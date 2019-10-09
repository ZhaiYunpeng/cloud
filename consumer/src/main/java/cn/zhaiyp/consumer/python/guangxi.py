"""
广西壮族自治区政府采购网
url:http://zfcg.gxzf.gov.cn/
需求：1、查找中标公告；区内所有城市
"""

# from pub import *
import requests,re
import datetime
import json
# from fake_useragent import UserAgent
from kafka import KafkaProducer
from lxml import etree

HEADERS = {
    'User-Agent':UserAgent().random
}

#获取代理
def getProxies():
    url = 'http://10.56.1.24:8000/get/'
    proxie = requests.get(url).text
    proxies = {
    'http': 'http://{}'.format(proxie),
    'https': 'http://{}'.format(proxie)
    }
    return proxies


def getTendering(link,topic):
    """
    获取数据，然后把数据发送至kafka
    :param link: 网页链接
    :param topic: topic名称
    :return:
    """
    #获取当天日期
    now = str(datetime.datetime.now().date())
    #获取updateTime
    updateTime = str(datetime.datetime.now())
    #创建kafka生产者对象
    producer = KafkaProducer(bootstrap_servers=['10.56.1.120:9092'],
                             value_serializer=lambda v: json.dumps(v, ensure_ascii=False).encode('utf-8'))
    #遍历每一页，设置最大页数为100页
    for page in range(1,100):
        url = link.format(page)#合成链接
        #发送请求
        try:
            res = requests.get(url,headers=HEADERS,proxies=getProxies())
        except:
            res = requests.get(url, headers=HEADERS)
        #将返回的html结构化
        tree = etree.HTML(res.text)
        #获取数据总数
        count = tree.xpath('//*[@id="channelBody"]/div[2]/ul/li')
        #设置错误数据次数
        badCount = 0
        for i in range(len(count)):#遍历数据条数
            dataDict = {}
            #定位数据，把数据添加到字典
            title = tree.xpath(f'//*[@id="channelBody"]/div[2]/ul/li[{i+1}]/a/text()')
            url = tree.xpath(f'//*[@id="channelBody"]/div[2]/ul/li[{i+1}]/a/@href')
            date = tree.xpath(f'//*[@id="channelBody"]/div[2]/ul/li[{i+1}]/span[2]/text()')
            if topic == 'guangxi_city': #如果是市县区域需增加一个字段
                area = tree.xpath(f'//*[@id="channelBody"]/div[2]/ul/li[{i+1}]/a/span/text()')
                dataDict['area'] = ''.join(area)
            dataDict['title'] = ''.join(title)
            dataDict['url'] = 'http://zfcg.gxzf.gov.cn'+''.join(url)
            dataDict['date'] = ''.join(date)
            dataDict['updateTime'] = updateTime
            if now == ''.join(date):
                #如果网页数据日期等于今日日期，则把数据发送kafka
                producer.send(topic=topic, value=dataDict)
                print(dataDict)
            else:
                badCount += 1#如果错误数据大于3条，则关闭kafka，结束循环
                if badCount == 3:
                    producer.close()
                    return '爬取完成...'

def run():
    """
    程序运行主函数
    :return: 无返回值
    """
    areaUrl = 'http://zfcg.gxzf.gov.cn/CmsNewsController/getCmsNewsList/channelCode-shengji_zbgg/param_bulletin/20/page_{}.html'     #区本级采购
    cityUrl = 'http://zfcg.gxzf.gov.cn/CmsNewsController/getCmsNewsList/moreType_More/channelCode-sxjcg_gzgg/agentName_/20/page_{}.html'     #市县级采购
    getTendering(areaUrl,'guangxi_area')
    getTendering(cityUrl,'guangxi_city')


if __name__ == '__main__':
    run()
