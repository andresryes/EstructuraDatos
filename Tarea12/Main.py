from HashTable import *
from memory_profiler import profile
from pycallgraph import PyCallGraph
from pycallgraph.output import GraphvizOutput


@profile
def main():
    hash_table = HashTable()

    for x in range(20):
        hash_table.insert(x, str(x))

    for x in hash_table.getHashTable():
        print(len(x))
        print (*x) 
'''
graphviz = GraphvizOutput(output_file='call_tree.png')
with PyCallGraph(output=graphviz):
    hash_table = HashTable()

    for x in range(20):
        hash_table.insert(x, str(x))

    for x in hash_table.getHashTable():
        print(len(x))
        print (*x) 
'''

if __name__ == "__main__":
    main()