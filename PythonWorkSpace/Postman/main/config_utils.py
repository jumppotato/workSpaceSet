from backports import configparser


class ConfigUtils:

    __parser = None

    @staticmethod
    def get_parser(path):
        if ConfigUtils.__parser is None:
            parser = configparser.ConfigParser()
            parser.read(path)
            ConfigUtils.__parser = parser

        return ConfigUtils.__parser


