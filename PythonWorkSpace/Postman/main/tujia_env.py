# coding=utf-8
from config_utils import ConfigUtils
from cookie_utils import CookieUtils


class TujiaEnv:
    """store Http Request Environment"""
    DEV = 1
    FVT = 2
    PRO = 3

    # 配置的类型
    DEV_SECTION_TYPE = 'dev'
    FVT_SECTION_TYPE = 'fvt'
    PRO_SECTION_TYPE = 'pro'

    # 配置的Key
    USER_TOKEN_KEY = 'userToken'
    USER_TOKEN_NAME_KEY = 'userTokenName'

    CONFIG_PATH = '/Users/wangwenxuan/Documents/tujia/data/tuja.conf'

    def __init__(self, env_type):
        self.user_agent = "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)"
        self.env_type = env_type

        self.userTokenName = self.__get_user_token_name()
        self.userToken = self.__get_user_token()

    def __get_user_token_name(self):
        parser = ConfigUtils.get_parser(TujiaEnv.CONFIG_PATH)

        section_type = self.__get_section_type()
        return parser.get(section_type, TujiaEnv.USER_TOKEN_NAME_KEY)

    def __get_user_token(self):
        parser = ConfigUtils.get_parser(TujiaEnv.CONFIG_PATH)

        section_type = self.__get_section_type()
        return parser.get(section_type, TujiaEnv.USER_TOKEN_KEY)

    def __get_section_type(self):
        section_type = None
        if self.env_type == TujiaEnv.DEV:
            section_type = TujiaEnv.DEV_SECTION_TYPE
        elif self.env_type == TujiaEnv.FVT:
            section_type = TujiaEnv.FVT_SECTION_TYPE
        elif self.env_type == TujiaEnv.PRO:
            section_type = TujiaEnv.PRO_SECTION_TYPE
        return section_type

    def get_headers(self):
        headers = {
            'Cookie': self.__get_cookies_str(),
            'User-Agent': self.user_agent
        }

        return headers

    def __get_cookies_str(self):
        return CookieUtils.conver_to_str(self.__get_tujia_cookie())

    def __get_tujia_cookie(self):
        cookies = {
            self.userTokenName: self.userToken,
            'domain': '.tujia.com',
            'path': '/'
        }

        return cookies
