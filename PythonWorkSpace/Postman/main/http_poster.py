import urllib.request


class HttpPoster:
    """Send Http Request"""

    headers = {}
    opener = None

    @staticmethod
    def post(url, data=None, headers=None):

        encode_data = HttpPoster.__get_encode_data(data)

        headers_to_use = HttpPoster.__get_headers_if_necessary(headers)

        request = urllib.request.Request(url, encode_data, headers_to_use)

        response = urllib.request.urlopen(request)
        return response

    @staticmethod
    def __get_encode_data(data):
        encode_data = None
        if data is not None:
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
