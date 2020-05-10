from json import load
import mysql.connector
from mysql.connector import errorcode
from csv import reader
from datetime import datetime

# Connect to database
def connect(config):
    try:
        db = mysql.connector.connect(**config)
        return db
    except mysql.connector.Error as err:
        if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
            print("Something is wrong with your user name or password")
        elif err.errno == errorcode.ER_BAD_DB_ERROR:
            print("Database does not exist")
        else:
            print(err)
        return 0

# TODO: Populate database with data from a csv
def populate(db):
    cursor = db.cursor()
    entries = []
    # String grande demais
    sqlFormula = """INSERT INTO record (cod_equipment, id_equipment_status, cod_shift,
                    cod_crew, equipment_status_mode, unplanned_time, stopped_time,
                    production_time, id_material_definition, dt_start,dt_end,
                    qty_produced, metallic_loss, theoretical_duration_by_pph,
                    theoretical_duration_by_pph_for_calculation
                    ) VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)
                    """
    with open('amostras/DbSample.csv', 'r', encoding="utf8") as file:
        read = reader(file, delimiter=',')
        line_count = 0
        next(read)
        for row in read:
            line_count += 1
            entry = []
            for i in range(2, 17): # Vai da coluna 2 até a 16
                p = row[i]
                # Se for coluna 11 e 12 (datas), processa antes de inserir.
                if (i==11 or i ==12):
                    p = datetime.strptime(row[i], '%m/%d/%Y %H:%M')
                entry.append(p)
            entries.append(entry)
            # Executar query a cada 10 mil linhas, e quando chegar na última.
            # Limpa as queries para não lotar a memória RAM
            if (line_count % 10000 == 0 or line_count == 1048575):
                try:
                    cursor.executemany(sqlFormula,entries)
                    print("Insertion finished.")
                    entries.clear()
                except Exception as e:
                    print("Error during insertion:",e)
                    cursor.close()
                    print("Connection aborted.")
                    return 0
            # Dar commit a cada 100 mil linhas
            # Em geral, a conexão é demorada
            if (line_count % 100000 == 0 or line_count == 1048575):
                print("<< Commiting changes {}>>".format(line_count))
                db.commit()
                print("<< Changes commited. >>")

        print("FINISHED. Insertions made with success:", line_count)
        cursor.close()
        return 1


# ----- MAIN ----- #
print("Press 1 to only test connection with database.")
print("Press 2 to populate database from csv.")
n = int(input("Choice: "))

# Load Credentials
with open('config.json', 'r') as file:
	config = load(file)

# Connect to db
db = connect(config)
if db:
    print("Connection successfull:", db)
    if n == 2:
        populate(db)
    db.close()
else:
    print("Connection failed")
