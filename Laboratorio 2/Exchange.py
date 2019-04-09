import unittest
from Dijkstra import Graph
from memory_profiler import profile

@profile
def exchange_rate():
    graph = Graph([
        ("USD", "CNY", 6.71),  ("EUR", "USD", 1.12),  ("QUE", "USD", 0.13), ("QUE", "VES", 428),
        ("EUR", "VES", 3694.16), ("ARS", "MXN", 0.44), ("ZWD", "MXN", 0.052),  ("CHF", "MXN", 19.61),
        ("CHF", "USD", 0.99), ("USD", "QUE", 7.7)])

    print(graph.dijkstra("EUR", "CNY"))
    print(graph.get_exchange("EUR", "CNY"))
    print("Exchange rate: " + str((graph.get_exchange("EUR", "CNY")[-1])))

if __name__ == '__main__':
    exchange_rate()