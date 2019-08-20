package cn.zhaiyp.producer.config;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String str = "RS_REP_PH_ABSTRACT" +
                ",RS_REP_PH_ENTRY_CRITERIA" +
                ",RS_REP_SU_CREDIT" +
                ",RS_REP_PH_ANALYSIS" +
                ",RS_REP_SU_CUST_INFO" +
                ",RS_REP_PERSONAL_FW_ANALYSIS" +
                ",RS_REP_PH_ANALYSIS" +
                ",RS_REP_PH_FUNDUSE_JUDGE" +
                ",RS_REP_PH_FUNDUSE_RECEVE" +
                ",RS_REP_PH_FUNDUSE_RENT" +
                ",RS_REP_PH_FUNDUSE_OTHERS" +
                ",RS_REP_PH_DEBT" +
                ",RS_REP_LEGAL_BASE_YHZXD" +
                ",RS_REP_PH_OVERDUE_RECORDS" +
                ",RS_REP_LEGAL_BASE_BDCLK" +
                ",RS_REP_LEGAL_BASE_SFZX" +
                ",RS_REP_LEGAL_BASE_FZDW" +
                ",RS_REP_GB_MAJOR_PARTY_DEBT" +
                ",RS_REP_LEGAL_BASE_GQCZ" +
                ",RS_REP_LEGAL_BASE_DCDY" +
                ",RS_REP_LEGAL_BASE_NDCDY" +
                ",RS_REP_LEGAL_BASE_TDDY" +
                ",RS_REP_PH_FINANCE_DEBT" +
                ",RS_REP_PH_DEBT_SUMMARY" +
                ",RS_REP_EIC_CWFX" +
                ",RS_REPORT_LEGAL_ASSETS" +
                ",RS_REP_LEGAL_ASSETS_CWBLTJ" +
                ",RS_REP_LEGAL_ASSETS_LRB" +
                ",RS_REP_LEGAL_ASSETS_GZBFX" +
                ",RS_REP_LEGAL_ASSETS_GXJLCS" +
                ",RS_REP_EIC_FEE" +
                ",RS_REP_EIC_STAFF" +
                ",RS_REP_PH_REPAYMENT_INTENTION" +
                ",RS_REP_PH_HISTORICAL_FINANCING" +
                ",RS_REP_PH_HIS_CASE_INVOLVE" +
                ",RS_REP_PH_COORDINAT_DEGREE" +
                ",RS_REP_LEGAL_CREDIT_RELATED" +
                ",RS_REP_LEGAL_LOAN" +
                ",RS_REP_LEGAL_LOAN" +
                ",RS_REP_LEGAL_QUERY_RECORD" +
                ",RS_REP_PH_PEER_EVALUATION" +
                ",RS_REP_PH_OTHER_REPAY" +
                ",RS_REP_PH_NCLS_INDICTED_CASE" +
                ",RS_REP_PH_ANALYSIS" +
                ",RS_REP_PH_ACTUAL_CONTROLLER" +
                ",RS_REP_PH_DEBT" +
                ",RS_REP_PH_PEER_EVALUATION" +
                ",RS_REP_PH_AFFILIATED_COMPANY" +
                ",RS_REP_PH_ASSETS" +
                ",RS_REP_PH_ASSETS_CWBLTJ" +
                ",RS_REP_PH_ASSETS_GXJLCS" +
                ",RS_REP_PH_ASSETS_GZBFX" +
                ",RS_REP_PH_ASSETS_LRB" +
                ",RS_REP_GUA_ZRR" +
                ",RS_REP_PH_DBCS_MEA_POINT" +
                ",RS_REP_PH_DBCS" +
                ",RS_REP_LEGAL_BASE_YHZXD" +
                ",RS_REP_PH_OVERDUE_RECORDS" +
                ",RS_REP_LEGAL_BASE_BDCLK" +
                ",RS_REP_PH_DBCS_GUA_HOUSE_INFO" +
                ",RS_REP_PH_DBCS_GUA_VEH_INFO" +
                ",RS_REP_GUA_FR" +
                ",RS_REP_LEGAL_BASE_SFZX";
        String[] strings = str.split(",");
        List<String> str_list = Arrays.asList(strings);
        HashSet<String> set = new HashSet<>(str_list);
        System.out.println(strings.length);
        System.out.println(set.size());
        System.out.println(set);
    }

}
