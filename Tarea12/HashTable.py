from HashFunction import hashing_func
from HashFunction import hashing_value

class HashTable:
    hash_table = [[] for _ in range(20)]

    def __init__(self):
        print("Initializing Hash table") 

    def insert(self, key, value):
        hash_key = hashing_func(key, value)
        hash_key = hashing_func(hash_key, value)
        value = hashing_value(key, value)
        key_exists = False
        bucket = self.hash_table[hash_key]    
        for i, kv in enumerate(bucket):
            k, v = kv
            if key == k:
                key_exists = True 
                break
        if key_exists:
            bucket[i] = ((key, value))
        else:
            bucket.append((key, value))

    def getHashTable(self):
        return self.hash_table