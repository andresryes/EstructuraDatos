import unittest
from HashTable import *
from HashFunction import *

class TestStringMethods(unittest.TestCase):

    def test_insert(self):
        hash_table = HashTable()
        hash_table.insert(1,str(1))
        self.assertEqual(len(hash_table.getHashTable()), 20)

    '''
    def test_getHashTable(self):
        hash_table = HashTable()
        self.assertEqual(len(hash_table.getHashTable()), 20)
    '''

    def test_hash_function(self):
        s = 'hello world'
        hash_key = hashing_func(1,str(1))
        self.assertEqual(hash_key, 13)
        self.assertEqual(s.split(), ['hello', 'world'])
        # check that s.split fails when the separator is not a string
        with self.assertRaises(TypeError):
            s.split(2)

    def test_hash_value(self):
        value = hashing_value(1,str(1))
        self.assertEqual(value, '\x053')


if __name__ == '__main__':
    unittest.main()