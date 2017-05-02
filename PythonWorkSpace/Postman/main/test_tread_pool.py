from concurrent import futures


def a(num):
    print('A', num)


def b(num):
    print('B', num)


if __name__ == "__main__":
    ex = futures.ThreadPoolExecutor(max_workers=2)
    ex.submit(a, 100)
    ex.submit(b, 123)

