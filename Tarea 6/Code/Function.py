def histogramFunction(stringArray, largest):
    returnHistogram = [[],[],[]]
    tempHistogram = [[],[]]
    for i in range(len(stringArray)):
        rep = False
        for j in range(len(tempHistogram[0])):
            if(stringArray[i] == tempHistogram[0][j]):
                rep = True

        if(rep == False):
            tempHistogram[0].append(stringArray[i])
            tempHistogram[1].append(count(stringArray, stringArray[i]))

        #print(histogram)

    for x in range(largest):
        max = tempHistogram[1][0]
        index = 0
        for y in range(len(tempHistogram[1])):
            if(max < tempHistogram[1][y]):
                max = tempHistogram[1][y]
                index = y
            
        returnHistogram[0].append(index)
        returnHistogram[1].append(max)
        tempHistogram[1][index] = 0

    for a in range(len(returnHistogram[0])):
        returnHistogram[2].append(tempHistogram[0][returnHistogram[0][a]])
    
    return  returnHistogram

# funcion para contar cuantas aparaciones tiene un char en un string
def count(string, char):
    ret = 0
    for x in range(len(string)):
        if(string[x]==char):
            ret+=1
    return ret