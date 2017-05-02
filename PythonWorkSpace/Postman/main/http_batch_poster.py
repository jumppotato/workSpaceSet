from concurrent import futures

from http_poster import HttpPoster


class HttpBatchPoster:

    __default_thread_size = 5

    @staticmethod
    def post(url, data_list, headers=None, thread_size=None):
        HttpPoster.set_headers(headers)

        if thread_size is None:
            thread_size = HttpBatchPoster.__default_thread_size

        pool = futures.ThreadPoolExecutor(max_workers=thread_size)

        for data in data_list:
            pool.submit(HttpBatchPoster.__post(url, data))

    @staticmethod
    def __post(url, data):
        response = HttpPoster.post(url, data)
        print(response.read().decode('utf-8'))

