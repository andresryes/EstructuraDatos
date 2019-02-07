from Function import count
from Function import histogramFunction

print('hello world')

#ruta del archivo a leer
file_name = "Lorem Ipsum.txt"
fileLines = []
#histograma
histogram = [[],[]]
finalHistogram = [[],[],[]]

#print(finalHistogram)
#print(histogram)

#lectura de cada linea del archivo
with open(file_name, "r") as file:
    line = file.readline()
    fileLines.append(line)

print(fileLines[0])

stringArray = list(fileLines[0])

#print(stringArray)
#print(len(stringArray))

finalHistogram = histogramFunction(stringArray, 10)
#print(finalHistogram)

for h in range(len(finalHistogram[0])):
    print('"'+finalHistogram[2][h]+'"',end="")
    for k in range(finalHistogram[1][h]):
        print("*",end="")
    print(" ")
input()