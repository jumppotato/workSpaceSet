import time

from main.http_poster import HttpPoster
from main.post_processor import PostProcessor
from tujia.tujia_env import TujiaEnv


start = 1
n = 100

class MyProcessor(PostProcessor):
    def __init__(self):
        self.count = 0

    def after_post(self, index, request, response):
        self.count = self.count + 1
        print("index = ", index, "count = ", self.count)
        if self.count == n:
            end = time.time()
            print(end - start)


if __name__ == "__main__":
    env = TujiaEnv(TujiaEnv.DEV)
    url = "http://providercrm.dev.tujia.com:8080/crm-web/testapi/cnt"
    baidu_url = "http://www.baidu.com"

    data_list = []

    start = time.time()
    for i in range(n):
        entry = {
            'count': i
        }
        data_list.append(entry)
        # HttpPoster.post(url, entry, env.get_headers())

    awarer = MyProcessor()

    HttpPoster.batch_post(baidu_url, data_list, env.get_headers(), 30, awarer)
