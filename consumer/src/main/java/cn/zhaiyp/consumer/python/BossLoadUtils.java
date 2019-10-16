package cn.zhaiyp.consumer.python;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BossLoadUtils {
    private static String[] mJobTypes = {"android", "ios", "java", "python", "php", "h5", "大数据", "flutter", ""};
    /**
     * 切换不同岗位
     */
    private static int mIndex = 2;

    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://www.zhipin.com/job_detail/?query=" + mJobTypes[mIndex] + "&city=101180100";
        Map<String,String> paramsMap = new HashMap<>();
        paramsMap.put("__a", "69860304.1568691437.1570612566.1570670589.32.3.3.32");
        paramsMap.put("__c", "1570670589");
        paramsMap.put("__g", "-");
        paramsMap.put("__l", "l=/www.zhipin.com/c101180100/y_5/?query=java%E5%B7%A5%E7%A8%8B%E5%B8%88&ka=sel-salary-5&r=&friend_source=0&friend_source=0");
        paramsMap.put("__zp_stoken__", "8972ToS/nV+IRePki7x0kuiUTR3wMnB2keRDMeyclLLc4gu5QrlWPz/R3MRcdPxD/rXDpHIdMFyZB1LXyI/ac89hRA==");
        paramsMap.put("_uab_collina", "156869143706729147625995");
        paramsMap.put("lastCity", "101180100");

        //获取编辑推荐页
        Document document = Jsoup.connect(url)
                //模拟火狐浏览器
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:69.0) Gecko/20100101 Firefox/69.0").cookies(paramsMap)
                .get();
        //获取工作列表数据
        Elements jobPrimary = document.select("div[class='job-primary']");
        //遍历取出每一条工作数据记录集合
        List<String> mJobInfoList = jobPrimary.eachText();
        printTabTitleBar();
        for (String jobInfo : mJobInfoList) {
            //可以根据空格做切割处理获取相关数据（注意：这里可以更精确的筛选对应标签取出对应值，我偷懒了）
            String[] mSplit = jobInfo.split(" ");
            JobInfo mJobInfo = new JobInfo(mSplit[0], mSplit[1], mSplit[2], mSplit[3], mSplit[4], mSplit[5], mSplit[6], mSplit[7]);
            printlnJobInfo(mJobInfo);
            Thread.sleep(10);
            printDashLine();
        }
    }

    private static void printTabTitleBar() {
        printlnTitle();
        printDashLine();
        StringBuffer sb = new StringBuffer();
        append(sb, "岗位名称", "薪资", "城市", "区", "办公地点及工作年限", "公司", "行业及人数", "招聘者");
        println(sb.toString());
        printDashLine();
    }

    private static void append(StringBuffer sb, String jobName, String salary, String city, String area, String locationAndYears, String company, String industryAndPersonNum, String recruiter) {
        sb.append(jobName).append("  |  ")
                .append(salary).append("  |  ")
                .append(city).append("  |  ")
                .append(area).append("  |  ")
                .append(locationAndYears).append("     |      ")
                .append(company).append("     |      ")
                .append(industryAndPersonNum).append("     |      ")
                .append(recruiter).append("|");
    }

    private static void printlnTitle() {
        println("-----------------------------------------------------------Java爬取boss直聘" + mJobTypes[mIndex] + "招聘信息-------------------------------------------------------");
    }

    private static void printlnJobInfo(JobInfo jobInfo) {
        StringBuffer sb = new StringBuffer();
        append(sb, jobInfo.jobName, jobInfo.salary, jobInfo.city, jobInfo.area, jobInfo.locationAndYears, jobInfo.company, jobInfo.industryAndPersonNum, jobInfo.recruiter);
        println(sb.toString());
    }

    private static void println(String log) {
        System.out.println(log);
    }

    private static void printDashLine() {
        println("---------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
