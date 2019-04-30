import math
import random

#math.floor(math.log((key % (len(hash_table)))))
# Hash Function == graph floor(log(x^2)) mod 20 from 0 to 30000

hash_table = [[] for _ in range(20)]
#print (hash_table) 

def hashing_func(key, value):
    #ran = key + random.randint(1, 25000)

    new_key = 0
    for s in value:
        new_key+=ord(s)

    return math.floor(math.pow(math.log(key+new_key),3)) % len(hash_table)

#print (hashing_func(4564, "hola mundo")) 
#print (hashing_func(546, "hola")) 
#print (hashing_func(78547, "hola mundo"))

def insert(hash_table, key, value):
    hash_key = hashing_func(key, value)
    hash_key = hashing_func(hash_key, value)
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
'''
def search(hash_table, key):
    hash_key = hash(key) % len(hash_table)    
    bucket = hash_table[hash_key]
    for i, kv in enumerate(bucket):
        k, v = kv
        if key == k:
            return v
'''
for x in range(20):
    insert(hash_table, x, 'Saturn'+str(x))
    #print (hash_table)
    '''
    insert(hash_table, random.randint(x, 25000), 'Pluto'+str(x))
    #print (hash_table)
    
    insert(hash_table, random.randint(x, 25000), 'Sun'+str(x))
    #print (hash_table)
    '''
for x in hash_table:
    print(len(x))