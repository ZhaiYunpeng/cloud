import requests, re
import datetime
import json
from lxml import etree
# from kafka import KafkaProducer
# from fake_useragent import UserAgent

"""
北京市政府采购网：
1、点击信息公告；
2、点击市级或区级招标信息。
"""

HEADERS = {
    # 'User-Agent':UserAgent().random
}


# 获取代理
def getProxies():
    url = 'http://10.56.1.24:8000/get/'
    proxie = requests.get(url).text
    proxies = {
        'http': 'http://{}'.format(proxie),
        'https': 'http://{}'.format(proxie)
    }
    return proxies


def getTendering(link, topic):
    """
    获取数据，然后把数据发送至kafka
    :param link: 网页链接
    :param topic: topic名称
    :return:
    """
    # 获取当天日期
    now = str(datetime.datetime.now().date())
    # 获取updateTime
    updateTime = str(datetime.datetime.now())
    # 创建kafka生产者对象
    # producer = KafkaProducer(bootstrap_servers=['10.56.1.120:9092'],
    #                          value_serializer=lambda v: json.dumps(v, ensure_ascii=False).encode('utf-8'))
    # 遍历每一页，设置最大页数为100页
    for page in range(0, 3):
        if page == 0:
            index_html = "/index.html"
            url_all = link.replace("_{}", "")
        else:
            index_html = "/index_" + str(page) + ".html"
            url_all = link.format(page)  # 合成链接
        print(url_all)
        # 发送请求
        try:
            res = requests.get(url_all, headers=HEADERS, proxies=getProxies())
        except:
            res = requests.get(url_all, headers=HEADERS)
        # 将返回的html结构化
        tree = etree.HTML(res.text)
        # 获取数据总数
        count = tree.xpath('//*[@class="xinxi_ul"]/li')
        # 设置错误数据次数
        badCount = 0
        # 遍历数据条数
        for i in range(len(count)):
            dataDict = {}
            # 定位数据，把数据添加到字典
            title = tree.xpath(f'//*[@class="xinxi_ul"]/li[{i + 1}]/a/text()')
            url = tree.xpath(f'//*[@class="xinxi_ul"]/li[{i + 1}]/a/@href')
            date = tree.xpath(f'//*[@class="xinxi_ul"]/li[{i + 1}]/span/text()')
            dataDict['title'] = ''.join(title)
            dataDict['url'] = ''.join(url_all).replace(index_html, "") + ''.join(url).replace("./", "/")
            dataDict['date'] = ''.join(date)
            dataDict['updateTime'] = updateTime
            dataDict['remark'] = "all"
            print(dataDict)
            # if now == ''.join(date):
            #     # 如果网页数据日期等于今日日期，则把数据发送kafka
            #     # producer.send(topic=topic, value=dataDict)
            #     print(dataDict)
            # else:
            #     badCount += 1
            #     # 如果错误数据大于3条，则关闭kafka，结束循环
            #     if badCount == 3:
            #         # producer.close()
            #         return '爬取完成...'

def run():
    """
    程序运行主函数
    :return: 无返回值
    """
    cityUrl = 'http://www.ccgp-beijing.gov.cn/xxgg/sjzfcggg/sjzbgg/index_{}.html'  # 市级信息公告
    areaUrl = 'http://www.ccgp-beijing.gov.cn/xxgg/qjzfcggg/qjzbgg/index_{}.html'  # 区级信息公告
    # getTendering(cityUrl, "beijing_zfcgw_city")
    getTendering(areaUrl, "beijing_zfcgw_city")


if __name__ == '__main__':
    run()
