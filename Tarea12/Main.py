from HashTable import *

def main():
    hash_table = HashTable()

    for x in range(20):
        hash_table.insert(x, str(x))

    for x in hash_table.getHashTable():
        print(len(x))
        print (*x) 

if __name__ == "__main__":
    main()
