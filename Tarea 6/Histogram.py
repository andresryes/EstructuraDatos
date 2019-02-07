print('hello world')

#ruta del archivo a leer
file_name = "Lorem Ipsum.txt"
fileLines = []
#histograma
histogram = [[],[]]
finalHistogram = [[],[]]

# funcion para contar cuantas aparaciones tiene un char en un string
def count(string, char):
    ret = 0
    for x in range(len(string)):
        if(string[x]==char):
            ret+=1
    return ret

#lectura de cada linea del archivo
with open(file_name, "r") as file:
    line = file.readline()
    fileLines.append(line)

print(fileLines[0])

stringArray = list(fileLines[0])

#print(stringArray)

#print(len(stringArray))

for i in range(len(stringArray)):
    rep = False
    for j in range(len(histogram[0])):
        if(stringArray[i] == histogram[0][j]):
            rep = True

    if(rep == False):
        histogram[0].append(stringArray[i])
        histogram[1].append(count(stringArray, stringArray[i]))

#print(histogram)

for x in range(10):
    max = histogram[1][0]
    index = 0
    for y in range(len(histogram[1])):
        if(max < histogram[1][y]):
            max = histogram[1][y]
            index = y
        
    finalHistogram[0].append(index)
    finalHistogram[1].append(max)
    histogram[1][index] = 0

#print(finalHistogram)
#print(histogram)

for h in range(len(finalHistogram[0])):
    print('"'+histogram[0][finalHistogram[0][h]]+'"',end="")
    for k in range(finalHistogram[1][h]):
        print("*",end="")
    print(" ")