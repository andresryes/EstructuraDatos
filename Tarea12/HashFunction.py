import math
import random

#math.floor(math.log((key % (len(hash_table)))))
# Hash Function == graph floor(log(x^2)) mod 20 from 0 to 30000

#hash_table = [[] for _ in range(20)]
#print (hash_table) 

def hashing_func(key, value):
    #ran = key + random.randint(1, 25000)
    new_key = 0
    for s in value:
        new_key+=ord(s)
    
    return math.floor(math.pow(math.sqrt(key+new_key),3)) % 20

def hashing_value(key, value):
    new_key = 0
    new_value = ""
    for s in value:
        new_key+=ord(s)
        new_value += chr((21*ord(s)) % 64)
        new_value += str(math.floor(math.log(new_key)))

    return new_value