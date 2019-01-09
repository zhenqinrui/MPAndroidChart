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
        if (className != null) {
            String[] names = className.split("-");
            if (names != null && names.length > 1) {
                String s1 = names[0];
                if (s1.length() > 4) {
                    s1 = s1.substring(0, 4);
                }
                String s2 = names[1];
                if (s2.length() > 4) {
                    s2 = s2.substring(0, 4);
                }
                return s1 + "\n" + s2;
            } else {
                if (className.length() > 4) {
                    return className.substring(0, 4);
                }
            }
        }
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
