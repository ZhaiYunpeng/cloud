package cn.zhaiyp.consumer.python;

class JobInfo {
    public String jobName;               //岗位名称
    public String salary;                //薪资
    public String city;                  //城市
    public String area;                  //区
    public String locationAndYears;      //办公地点及工作年限
    public String company;               //公司
    public String industryAndPersonNum;  //行业及人数
    public String recruiter;             //招聘者

    public JobInfo(String jobName, String salary, String city, String area, String locationAndYears, String company, String industryAndPersonNum, String recruiter) {
        this.jobName = jobName;
        this.salary = salary;
        this.city = city;
        this.area = area;
        this.locationAndYears = locationAndYears;
        this.company = company;
        this.industryAndPersonNum = industryAndPersonNum;
        this.recruiter = recruiter;
    }
}
