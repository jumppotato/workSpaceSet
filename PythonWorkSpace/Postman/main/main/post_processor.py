# 继承此接口 以实现在数据发送前的处理，和发送数据后的处理


class PostProcessor:

    def before_post(self, index, request):
        pass

    def after_post(self, index, request, response):
        pass
