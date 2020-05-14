from csv import reader

def calcDisp(prodTime, unplTime):
    return (prodTime / (unplTime + prodTime))

def calcPerform(pph, pphCalc):
    return (pphCalc / pph)

def calcQuali(qtyProd, metLoss):
    return ((qtyProd - metLoss) / qtyProd)
# OEE= qualidade x performance x disponibilidade
def calcOEE(prodTime, unplTime, pph, pphCalc, qtyProd, metLoss):
    res = calcDisp(prodTime, unplTime)
    res *= calcPerform(pph, pphCalc)
    res *= calcQuali(qtyProd, metLoss)
    return (res * 100)

def output(dic, mach):
    with open('relatorio_calculo.txt', 'w', encoding="utf8") as file:
        file.write("RELATORIO DA MAQUINA: {}\n".format(mach))
        for year in dic:
            file.write("\n--- ANO: {} ---\n".format(year))
            months = dic[year].items()
            for month in months:
                file.write("OOE do Mês {}: {}\n".format(month[0], month[1]))


# --- MAIN --- #
with open('DbSample.csv', 'r', encoding="utf8") as file:
    mach = input("Digite o nome da maquina: ")
    reader = reader(file, delimiter=',')
    line_count = 0

    prodTime = 0
    unplTime = 0
    pph = 0
    pphCalc = 0
    qtyProd = 0
    metLoss = 0

    dic = {}
    next(reader) # Ignore first line
    for row in reader:
        line_count += 1
        if (row[2] != mach): # Stop condition
            break

        # Get row values
        prodTime += float(row[9])
        unplTime += float(row[7])
        pph += float(row[15])
        pphCalc += float(row[16])
        qtyProd += float(row[13])
        metLoss += float(row[14])
        year = row[11].split('/')[2].split(' ')[0]
        month = row[11].split('/')[0]

        if (year not in dic): # Doesnt exist: Create year in dic
            dic[year] = {}

        # Place values
        dic[year][month] = calcOEE(prodTime, unplTime, 
                                pph, pphCalc, 
                                qtyProd, metLoss)

    print("CSV terminado. Linhas: {}".format(line_count))
    print("Colocando saída em arquivo...")
    output(dic, mach)
    print("...saída feita com sucesso.")