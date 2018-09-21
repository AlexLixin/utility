file = open("res2sql.L18", "r")
filestr = file.read()
stringlist = filestr.split("RES2V1")
i = 0
for p in stringlist:
    i += 1
    f = open("file" + str(i) + ".txt", "w")
    f.write(p)
