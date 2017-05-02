# coding=utf-8
from tujia_env import TujiaEnv
from http_poster import HttpPoster

#TODO: 1.add json support
#TODO: 2.add thread support

if __name__ == "__main__":
    dev_env = TujiaEnv(TujiaEnv.DEV)
    url = 'http://provideruc.dev.tujia.com:8080/usercenter-web/test/testapi'

    data = {
        "str": "123",
        "top": "中文"
    }

    HttpPoster.set_headers(dev_env.get_headers())

    print HttpPoster.post(url, data).read()
