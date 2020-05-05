from json import load
import mysql.connector
from mysql.connector import errorcode
from csv import reader

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
    return 0
    """cursor = db.cursor()
    sqlFormula = "INSERT INTO dados_cadastrais_pj (cnpj,identificador_matriz_filial,razao_social,nome_fantasia,codigo_natureza_juridica,data_inicio_atividade,cnae_fiscal,descricao_tipo_logradouro,logradouro,numero,complemento,bairro,cep,uf,municipio,ddd_telefone_1,ddd_telefone_2,ddd_fax,correio_eletronico,porte_empresa,opcao_pelo_simples,opcao_pelo_mei) VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
    with open('raw_data/cnpj_dados_cadastrais_pj.csv', 'r', encoding="utf8") as file:
        reader = reader(file, delimiter='#')
        line_count = 0
        entries = []
        for row in reader:
            line_count += 1
            if (line_count > 7992000):
                entry = (
                    row[3], # cnpj (X) NN
                    )
                entries.append(entry)
                if (line_count % 10000 == 0 or line_count == 42484600) and line_count != 1:
                    print(line_count)
                    try:
                        cursor.executemany(sqlFormula,entries)
                        print("Insertion finished.")
                        entries.clear()
                    except Exception as e:
                        print("Error during insertion:",e)
                        cursor.close()
                        DB.close()
                        print("Connection aborted.")
                        exit(0)
                if (line_count % 1000000 == 0):
                    print("<< Commiting changes >>")
                    db.commit()
                    print("<< Changes commited. >>")

        print("CSV terminado",line_count)

    db.commit()
    print("Successfully finished all insertions.")
    cursor.close()"""


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
