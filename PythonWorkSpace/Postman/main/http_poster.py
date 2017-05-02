import urllib
import urllib2


class HttpPoster:
    """Send Http Request"""

    headers = {}

    @staticmethod
    def post(url, data=None, headers=None):

        encode_data = HttpPoster.__get_data_to_use(data)

        headers_to_use = HttpPoster.__get_headers_if_necessary(headers)

        request = urllib2.Request(url, encode_data, headers_to_use)

        response = urllib2.urlopen(request)
        return response

    @staticmethod
    def __get_data_to_use(data):
        encode_data = None
        if data is not None:
            encode_data = urllib.urlencode(data)
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

