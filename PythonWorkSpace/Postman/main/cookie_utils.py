class CookieUtils:

    @staticmethod
    def conver_to_str(cookie_dic):
        cookie_str = ""
        for key in cookie_dic:
            cookie_str += key + '=' + cookie_dic[key] + ';'
        cookie_str = cookie_str[0:len(cookie_str) - 1]
        return cookie_str
