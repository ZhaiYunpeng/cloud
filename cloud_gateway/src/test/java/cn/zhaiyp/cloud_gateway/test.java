package cn.zhaiyp.cloud_gateway;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String str ="35,天眼查,https://www.tianyancha.com/,1,34,,,35," +
                    "36,全国执行人信息网,http://zxgk.court.gov.cn/zhzxgk/,1,34,,,36," +
                    "37,裁判文书网,http://wenshu.court.gov.cn/,1,34,,,37," +
                    "38,全国认证认可信息网,http://cx.cnca.cn/,1,34,,,38," +
                    "39,百川信息网,http://www.baiinfo.com.cn/,1,34,,,39," +
                    "40,上海有色金属网,https://hq.smm.cn/,1,34,,,40," +
                    "41,宝钢在线,http://ecommerce.ibaosteel.com/,1,34,,,41," +
                    "42,事业单位在线,http://search.gjsy.gov.cn/,1,34,,,42," +
                    "43,排污许可证,http://permit.mee.gov.cn/,1,34,,,43," +
                    "44,新华网,http://so.news.cn/,1,33,,,44," +
                    "45,中国新闻网,http://www.chinaso.com/,1,33,,,45," +
                    "46,央视新闻,http://search.cctv.com/,1,33,,,46," +
                    "47,凤凰资讯,https://search.ifeng.com/,1,33,,,47," +
                    "48,搜狗新闻,https://news.sogou.com/,1,33,,,48," +
                    "49,新浪新闻,https://search.sina.com.cn/,1,33,,,49," +
                    "50,人民网,http://search.people.com.cn/,1,33,,,50," +
                    "51,今日头条,https://www.toutiao.com/a,1,33,,,51," +
                    "52,百度新闻,http://news.baidu.com/,1,33,,,52";
        String[] strs = str.split(",");
        List<String> sqlList = new ArrayList<>();
        StringBuffer sqlBuffer = new StringBuffer();
        int lineNum = 0;
        sqlBuffer.append("insert into RS_SEARCH_INDEX_URL_CONFIG values(");
        for (int i = 0; i < strs.length; i++) {
            String curStr = strs[i];
            if(lineNum != 7){
                sqlBuffer.append("'").append(curStr).append("',");
                lineNum++;
            }else if(lineNum == 7){
                sqlBuffer.append("'").append(curStr).append("'");
                sqlBuffer.append(");");
                sqlList.add(sqlBuffer.toString());
                sqlBuffer = new StringBuffer();
                sqlBuffer.append("insert into RS_SEARCH_INDEX_URL_CONFIG values(");
                lineNum = 0;
            }
        }
        for (String sql : sqlList) {
            System.out.println(sql);
        }
    }
}
