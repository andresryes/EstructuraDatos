from Function import histogramFunction
import unittest

stringArray = list("aaaabbccc")

histogramTest = histogramFunction(stringArray, 3)

print(histogramTest)

if(histogramTest[1][0] == 4 and histogramTest[1][1] == 3 and histogramTest[1][2] == 2):
    print("test worked perfectly")


def test_upper(self):
    self.assertEqual(histogramTest[2][0], 'a')
