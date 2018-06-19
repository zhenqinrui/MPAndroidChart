package com.xxmassdeveloper.mpchartexample.szytest;

import android.util.Log;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 作者: zengqinrui on 18/5/17 17:39
 * 邮箱：zengqinrui@szy.cn
 * 功能描述:
 * 备注:
 */

public class ClassAttendanceValueFormatter implements IAxisValueFormatter {

    private ArrayList<ClassAttendance> attendances;
    private HashMap<Integer, Boolean> map = new HashMap<>();

    public ClassAttendanceValueFormatter(ArrayList<ClassAttendance> attendances) {
        this.attendances = attendances;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        Log.i("zqr", "aa value=" + value);
        Integer i = (int)value;
//        if (map.containsKey(i)) {
//            return "";
//        }
//        map.put(i, true);
        // 将x坐标值显示为对应的值
        return attendances.get(i).getClassName();
    }
}
