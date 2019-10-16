package cn.zhaiyp.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;


/**
 * @author fkptxmz
 */
//@Controller
@RestController
@RequestMapping("/compare")
public class CompareStrController {
    public static void main(String[] args) {
//        String targetStr = "汽车及汽车零部件、新能源汽车及其电池、电机、整车控制技术的开发、设计、制造与销售、技术服务；" +
//                "信息服务；高新技术产业投资与经营；进出口贸易；水利、电力机械、金属结构件的生产与销售；" +
//                "房屋租赁；工程机械、混凝土机械、专用汽车的生产、销售和租赁；机械维修；对外承包工程业务。" +
//                "以上凡涉及国家专项规定的凭许可证、资质证生产、经营。";
//        String sourceStr = "汽车零部件的生产与销售，技术服务，信息服务；" +
//                "高新技术产业投资与经营、进出口贸易，水利、电力机械，金属结构件的生产与销售，" +
//                "房屋租赁，工程机械、混凝土机械、专用汽车的生产、销售和租赁，机械维修；对外承包工程业务。" +
//                "以上凡涉及国家专项规定的凭许可证、资质证生产、经营。";
        String targetStr = "郑州市郑东新区商务外环路8号世博大厦十一楼04、05、06室";
        String sourceStr = "河南自贸试验区郑州片区（郑东）商务外环路8号世博大厦十一楼04、05、06室";
        String[] highLightDifferent = getHighLightDifferent(sourceStr, targetStr);
        for (String s : highLightDifferent) {
            System.out.print(s);
            System.out.println();
        }
    }

    @RequestMapping("/execute")
    public String[] compareExecute() {
        String targetStr = "郑州市郑东新区商务外环路8号世博大厦十一楼04、05、06室";
        String sourceStr = "河南自贸试验区郑州片区（郑东）商务外环路8号世博大厦十一楼04、05、06室";
        String[] highLightDifferent = getHighLightDifferent(sourceStr, targetStr);

//        ModelAndView mav = new ModelAndView("/html/compareTest");
//        mav.addObject("str1", highLightDifferent[0]);
//        mav.addObject("str2", highLightDifferent[1]);
//        return mav;
        for (String s : highLightDifferent) {
            System.out.print(s);
            System.out.println();
        }
        return highLightDifferent;
    }

    private static String[] getHighLightDifferent(String a, String b) {
        String[] temp = getDiff(a, b);
        return new String[]{getHighLight(a, temp[0]), getHighLight(b, temp[1])};
    }

    private static String getHighLight(String source, String temp) {
        StringBuilder sb = new StringBuilder();
        char[] sourceChars = source.toCharArray();
        char[] tempChars = temp.toCharArray();
        boolean flag = false;
        for (int i = 0; i < sourceChars.length; i++) {
            if (tempChars[i] != ' ') {
                if (i == 0) {
                    sb.append("<span style='color:red'>").append(sourceChars[i]);
                } else if (flag) {
                    sb.append(sourceChars[i]);
                } else {
                    sb.append("<span style='color:red'>").append(sourceChars[i]);
                }
                flag = true;
                if (i == sourceChars.length - 1) {
                    sb.append("</span>");
                }
            } else if (flag) {
                sb.append("</span>").append(sourceChars[i]);
                flag = false;
            } else {
                sb.append(sourceChars[i]);
            }
        }
        return sb.toString();
    }

    private static String[] getDiff(String a, String b) {
        String[] result;
        //选取长度较小的字符串用来穷举子串
        if (a.length() < b.length()) {
            result = getDiffByIndex(a, b, 0, a.length());
        } else {
            result = getDiffByIndex(b, a, 0, b.length());
            result = new String[]{result[1], result[0]};
        }
        return result;
    }

    /**
     * 将a的指定部分与b进行比较生成比对结果
     */
    private static String[] getDiffByIndex(String a, String b, int start, int end) {
        String[] result = new String[]{a, b};
        int len = result[0].length();
        while (len > 0) {
            for (int i = start; i < end - len + 1; i++) {
                String sub = result[0].substring(i, i + len);
//            for (int i = end - len; i > start; i--) {
//                String sub = result[0].substring(start, i);
                int idx = result[1].indexOf(sub);
                if (idx != -1) {
                    result[0] = setEmpty(result[0], i, i + len);
                    result[1] = setEmpty(result[1], idx, idx + len);
                    if (i > 0) {
                        //递归获取空白区域左边差异
                        result = getDiffByIndex(result[0], result[1], 0, i);
                    }
                    if (i + len < end) {
                        //递归获取空白区域右边差异
                        result = getDiffByIndex(result[0], result[1], i + len, end);
                    }
                    //退出while循环
                    len = 0;
                    break;
                }
            }
            len = len / 2;
        }
        return result;
    }

    /**
     * 将字符串s指定的区域设置成空格
     */
    private static String setEmpty(String s, int start, int end) {
        char[] array = s.toCharArray();
        for (int i = start; i < end; i++) {
            array[i] = ' ';
        }
        return new String(array);
    }

}
