package com.xxmassdeveloper.mpchartexample.szytest;

/**
 * 作者: zengqinrui on 18/5/17 15:50
 * 邮箱：zengqinrui@szy.cn
 * 功能描述: 班级考勤
 * 备注:
 */

public class ClassAttendance {

    private String className;
    private float percent;
    private String startColor;
    private String endColor;

    public ClassAttendance(String className, float percent) {
        this.className = className;
        this.percent = percent;
    }

    public float getPercent() {
        return percent;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public String getEndColor() {
        return endColor;
    }

    public void setEndColor(String endColor) {
        this.endColor = endColor;
    }

    public String getStartColor() {
        return startColor;
    }

    public void setStartColor(String startColor) {
        this.startColor = startColor;
    }
}
