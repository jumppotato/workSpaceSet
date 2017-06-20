
import urllib.request

from concurrent import futures


class HttpPoster:
    """Send Http Request"""

    headers = {}

    # 批量发送的默认线程数量
    __default_thread_size = 5

    @staticmethod
    def batch_post(url, data_list=None, headers=None, thread_size=None, post_processor=None):
        HttpPoster.set_headers(headers)

        if thread_size is None:
            thread_size = HttpPoster.__default_thread_size

        pool = futures.ThreadPoolExecutor(max_workers=thread_size)

        for i in range(len(data_list)):
            pool.submit(HttpPoster.__do_post, url, data_list[i], post_processor, i)

    @staticmethod
    def __do_post(url, req_data, processor, index):
        processor.before_post(index, req_data)

        response = HttpPoster.post(url, req_data)

        processor.after_post(index, req_data, response)

    @staticmethod
    def post(url, data=None, headers=None):

        encode_data = HttpPoster.__get_encode_data(data)

        headers_to_use = HttpPoster.__get_headers_if_necessary(headers)

        request = urllib.request.Request(url, encode_data, headers_to_use)

        response = urllib.request.urlopen(request)
        # print(response.read().decode('utf-8'))
        return response

    @staticmethod
    def __get_encode_data(data):
        encode_data = data
        if encode_data is not None:
            encode_data = urllib.parse.urlencode(data).encode(encoding='UTF8')
        return encode_data

    @staticmethod
    def __get_headers_if_necessary(headers):
        headers_to_use = headers
        if headers_to_use is None:
            headers_to_use = HttpPoster.headers
        return headers_to_use

    @staticmethod
    def set_headers(headers):
        HttpPoster.headers = headers
