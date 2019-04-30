import math
import random

#math.floor(math.log((key % (len(hash_table)))))
# Hash Function == graph floor(log(x^2)) mod 20 from 0 to 30000

hash_table = [[] for _ in range(20)]
print (hash_table) 

def hashing_func(key, value):
    new_key = 0
    for s in value:
        new_key+=ord(s)

    return math.floor(math.pow(math.log(key+new_key), 2)) % len(hash_table)

#print (hashing_func(4564)) 
#print (hashing_func(546)) 
#print (hashing_func(78547))

def insert(hash_table, key, value):
    hash_key = hashing_func(key, value)
    key_exists = False
    bucket = hash_table[hash_key]    
    for i, kv in enumerate(bucket):
        k, v = kv
        if key == k:
            key_exists = True 
            break
    if key_exists:
        bucket[i] = ((key, value))
    else:
        bucket.append((key, value))

def search(hash_table, key):
    hash_key = hash(key) % len(hash_table)    
    bucket = hash_table[hash_key]
    for i, kv in enumerate(bucket):
        k, v = kv
        if key == k:
            return v

for x in range(6):
    insert(hash_table, random.randint(1, 20000), 'Saturno'+str(x))
    #print (hash_table)
    
    insert(hash_table, random.randint(1, 20000), 'Pluton'+str(x))
    #print (hash_table)
    
    insert(hash_table, random.randint(1, 20000), 'Sol'+str(x))
    #print (hash_table)

print (hash_table)