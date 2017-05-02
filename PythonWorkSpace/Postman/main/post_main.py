import json
from time import ctime

import concurrent
from concurrent import futures

from http_batch_poster import HttpBatchPoster
from tujia_env import TujiaEnv
from http_poster import HttpPoster


# TODO: 3.add exception support

def invoke_http():
    HttpPoster.set_headers(dev_env.get_headers())
    response = HttpPoster.post(url, data)
    print(response.read().decode('utf-8'))
    print(response.getcode())

if __name__ == "__main__":
    dev_env = TujiaEnv(TujiaEnv.DEV)
    url = 'http://provideruc.dev.tujia.com:8080/usercenter-web/test/testapi'

    tavern_vo = {
        "tavernId": 9999
    }

    data = {
        "input": json.dumps(tavern_vo),
        "status": 1,
        "cid": 2,
        "searchVo": json.dumps(tavern_vo)
    }
    data_list = [data, data]

    HttpBatchPoster.post(url, data_list, dev_env.get_headers())
