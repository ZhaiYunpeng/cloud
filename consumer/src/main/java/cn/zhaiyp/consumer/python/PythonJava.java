package cn.zhaiyp.consumer.python;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 *  Java 爬取网页
 * @author fkptxmz
 */
public class PythonJava {
    /**
     * jsoup方式 获取虎扑新闻列表页
     * @param url 虎扑新闻列表页url
     */
    public static void jsoupList(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            // 使用 css选择器 提取列表新闻 a 标签
            Elements elements = document.select("div.news-list > ul > li > div.list-hd > h4 > a");
            for (Element element : elements) {
                // 获取详情页链接
                String dUrl = element.attr("href");
                // 获取标题
                String title = element.ownText();
                System.out.println("详情页链接：" + dUrl + " ,详情页标题：" + title);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String url = "https://voice.hupu.com/nba";
        jsoupList(url);
    }
}
