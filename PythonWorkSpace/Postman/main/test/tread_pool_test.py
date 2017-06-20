from concurrent import futures

import time


def a(num):
    print('A', num)
    time.sleep(5)


def b(num):
    print('B', num)
    time.sleep(2)


if __name__ == "__main__":
    ex = futures.ThreadPoolExecutor(max_workers=2)
    ex.submit(a, 100)
    ex.submit(b, 123)

