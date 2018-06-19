package com.xxmassdeveloper.mpchartexample.szytest;

/**
 * 作者: zengqinrui on 18/5/18 11:36
 * 邮箱：zengqinrui@szy.cn
 * 功能描述: 老师考勤
 * 备注:
 */

public class TeacherAttendance {

    private float value; // 考勤人数
    private String name; // 考勤类型（已签到、已请假、未签到、早退)
    private String chartColor;
    private float percent; // 签到率（服务器可以给,或者自己算)

    public void setValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getChartColor() {
        return chartColor;
    }

    public void setChartColor(String chartColor) {
        this.chartColor = chartColor;
    }
}
