from csv import reader

# --- MAIN --- #
with open('perdas_laminacao.csv', 'r', encoding="utf8") as file:
    largest = -1
    read = reader(file, delimiter=',')
    next(read) # Ignore first line
    for row in read:
        size = len(row[7])
        if (size > largest):
            largest = size

    print(largest)