package cn.zhaiyp.consumer.python;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Java 爬取网页
 * @author fkptxmz
 */
public class PythonJava {
    /**
     * jsoup方式 获取虎扑新闻列表页
     * @param url 虎扑新闻列表页url
     */
    private static void jsoupList(String url) {
        try {
            Document document = Jsoup.connect(url).userAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)").get();
            // 使用 css选择器 提取列表新闻 a 标签
//            Elements elements = document.select("div.water-container > div.s-news-list-wrapper");
            Elements elements = document.select("div.content-right-content-center>li");
            for (Element element : elements) {
                Element aHtml = element.selectFirst("a");
                // 获取详情页链接
                String dUrl = aHtml.attr("href");
                // 获取标题
                String title = aHtml.ownText();
                // 获取时间
                String date = element.selectFirst("span").text();
                System.out.println("发布时间：" + date + " ，详情页链接：" + dUrl + " ,详情页标题：" + title);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * httpclient + 正则表达式 获取虎扑新闻列表页
     * @param url 虎扑新闻列表页url
     */
    public static void httpClientList(String url) {
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                String body = EntityUtils.toString(entity, "utf-8");

                if (body != null) {
                    /*
                     * 替换掉换行符、制表符、回车符，去掉这些符号，正则表示写起来更简单一些
                     * 只有空格符号和其他正常字体
                     */
                    Pattern p = Pattern.compile("\t|\r|\n");
                    Matcher m = p.matcher(body);
                    body = m.replaceAll("");
                    /*
                     * 提取列表页的正则表达式
                     * 去除换行符之后的 li
                     * <div class="list-hd">                                    <h4>                                        <a href="https://voice.hupu.com/nba/2485167.html"  target="_blank">与球迷亲切互动！凯尔特人官方晒球队开放训练日照片</a>                                    </h4>                                </div>
                     */
                    Pattern pattern = Pattern.compile("<div class=\"list-hd\">\\s* <h4>\\s* <a href=\"(.*?)\"\\s* target=\"_blank\">(.*?)</a>\\s* </h4>\\s* </div>");

                    Matcher matcher = pattern.matcher(body);
                    // 匹配出所有符合正则表达式的数据
                    while (matcher.find()) {
//                        String info = matcher.group(0);
//                        System.out.println(info);
                        // 提取出链接和标题
                        System.out.println("详情页链接：" + matcher.group(1) + " ,详情页标题：" + matcher.group(2));
                    }
                } else {
                    System.out.println("处理失败！！！获取正文内容为空");
                }
            } else {
                System.out.println("处理失败！！！返回状态码：" + response.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static void main(String[] args) {
//        String url = "https://voice.hupu.com/nba";
//        String url = "http://bgpc.beijing.gov.cn/news/tid/2";
        String url = "https://www.zhipin.com/job_detail/?query=java%E5%B7%A5%E7%A8%8B%E5%B8%88&city=101180100&industry=&position=";
        jsoupList(url);
//        httpClientList(url);
    }
}
