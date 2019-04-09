import unittest
from Dijkstra import Graph
from memory_profiler import profile


class TestDijkstra(unittest.TestCase):
    
    @profile
    def test_exchangerate(self):
        graph = Graph([
            ("USD", "CNY", 6.71),  ("EUR", "USD", 1.12),  ("QUE", "USD", 0.13), ("QUE", "VES", 428),
            ("EUR", "VES", 3694.16), ("ARS", "MXN", 0.44), ("ZWD", "MXN", 0.052),  ("CHF", "MXN", 19.61),
            ("CHF", "USD", 0.99), ("USD", "QUE", 7.7)])

        self.assertEqual("3691.072", str((graph.get_exchange("EUR", "VES")[-1])))

if __name__ == '__main__':
    unittest.main()