import random
class BinHeap:
  def __init__(self):
      self.heapList = [0]
      self.currentSize = 0


  def percUp(self,i):
      while i // 2 > 0:
        if self.heapList[i] < self.heapList[i // 2]:
            tmp = self.heapList[i // 2]
            self.heapList[i // 2] = self.heapList[i]
            self.heapList[i] = tmp
        i = i // 2

  def insert(self,k):
    self.heapList.append(k)
    self.currentSize = self.currentSize + 1
    self.percUp(self.currentSize)

  def percDown(self,i):
    while (i * 2) <= self.currentSize:
        mc = self.minChild(i)
        if self.heapList[i] > self.heapList[mc]:
            tmp = self.heapList[i]
            self.heapList[i] = self.heapList[mc]
            self.heapList[mc] = tmp
        i = mc

  def minChild(self,i):
    if i * 2 + 1 > self.currentSize:
        return i * 2
    else:
        if self.heapList[i*2] < self.heapList[i*2+1]:
            return i * 2
        else:
            return i * 2 + 1

  def delMin(self):
    retval = self.heapList[1]
    self.heapList[1] = self.heapList[self.currentSize]
    self.currentSize = self.currentSize - 1
    self.heapList.pop()
    self.percDown(1)
    return retval

  def buildHeap(self,alist):
    i = len(alist) // 2
    self.currentSize = len(alist)
    self.heapList = [0] + alist[:]
    while (i > 0):
        self.percDown(i)
        i = i - 1
@profile
def orderSmall(ordenadoMenor):
    bh = BinHeap()
    bh.buildHeap(ordenadoMenor)    
    print(bh.delMin())
@profile
def orderBig(ordenadoMayor):
  bh = BinHeap()
  bh.buildHeap(ordenadoMayor)
  print(bh.delMin())
@profile
def orderUnorder(desordenado):
  #random.shuffle(desordenado)

  bh = BinHeap()  
  bh.buildHeap(desordenado)    
  print(bh.delMin())  


if __name__ == '__main__':
    number = 1000000
    ordenadoMenor = [a for a in range(number)] 
    number = 1000000
    ordenadoMayor = [a for a in range(number, -1, -1)]
    number = 1000000
    desordenado = [a for a in range(number)] 
    orderSmall(ordenadoMenor)
    orderBig(ordenadoMayor)
    orderUnorder(desordenado)