import ConfigParser

parser = ConfigParser.SafeConfigParser()
parser.read('/Users/wangwenxuan/temp/myapp.conf')

print parser.sections()
print parser.options('db')
print parser.items('ssh')
