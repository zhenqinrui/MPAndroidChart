package com.xxmassdeveloper.mpchartexample.szytest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.xxmassdeveloper.mpchartexample.R;
import com.xxmassdeveloper.mpchartexample.custom.MyAxisValueFormatter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * 作者: zengqinrui on 18/5/17 16:03
 * 邮箱：zengqinrui@szy.cn
 * 功能描述:
 * 备注:
 */

public class SzyTestBarActivity extends Activity {

    private ArrayList<ClassAttendance> attendances = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szytest);
        initData();
        initBarchart();
    }

    private void initData() {
        for (int i = 0; i < 7; i++) {
            ClassAttendance classAttendance = new ClassAttendance("年级\n" + (i+1) + "班", i * 10 + 4);
            if (i == 0) {
                classAttendance.setStartColor("#74d2fd");
                classAttendance.setEndColor("#4fc4ff");
            } else if (i == 1) {
                classAttendance.setStartColor("#d3e461");
                classAttendance.setEndColor("#c7dd28");
            } else if (i == 2) {
                classAttendance.setStartColor("#ffe061");
                classAttendance.setEndColor("#ffc929");
            } else if (i == 3) {
                classAttendance.setStartColor("#c39cff");
                classAttendance.setEndColor("#b280ff");
            } else if (i == 4) {
                classAttendance.setStartColor("#ff92a2");
                classAttendance.setEndColor("#ff758b");
            } else if (i == 5) {
                classAttendance.setStartColor("#98ebe9");
                classAttendance.setEndColor("#4bd7da");
            }  else if (i == 6) {
                classAttendance.setStartColor("#98ebe9");
                classAttendance.setEndColor("#4bd7da");
            } else if (i == 7) {
                classAttendance.setStartColor("#98ebe9");
                classAttendance.setEndColor("#4bd7da");
            } else if (i == 8) {
                classAttendance.setStartColor("#98ebe9");
                classAttendance.setEndColor("#4bd7da");
            } else if (i == 9) {
                classAttendance.setStartColor("#98ebe9");
                classAttendance.setEndColor("#4bd7da");
            }

            attendances.add(classAttendance);
        }

    }

    private void initBarchart() {

        BarChart barChart = (BarChart)findViewById(R.id.barchart);
        //不可以缩放
        barChart.setScaleEnabled(false);
        barChart.setPinchZoom(false);

        barChart.setDragOffsetX(30);
        // 不显示定义描述
        barChart.getDescription().setEnabled(false);
        // 不显示比例图(底部描述)
//        barChart.getLegend().setEnabled(false);
//        barChart.setViewPortOffsets(0, 0, 0, 130);
//        // 处理x坐标文字显示不全问题
        Legend legend = barChart.getLegend();
        legend.setForm(Legend.LegendForm.NONE);
        legend.setTextColor(Color.TRANSPARENT);
//        barChart.setBackgroundColor(getResources().getColor(R.color.chart_toolbar_bg));
//        barChart.setDrawGridBackground(true);

        XAxis xAxis = barChart.getXAxis();
        //设置表格颜色
//        barChart.setGridBackgroundColor(getResources().getColor(R.color.chart_bg));
//        barChart.getAxisRight().setEnabled(false);
        xAxis.setXOffset(15);
        // 设置x坐标轴位置（默认在顶部)
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        // 设置x坐标轴线颜色
        xAxis.setAxisLineColor(Color.parseColor("#EEEEEE"));
        // 设置x轴刻度颜色
        xAxis.setTextColor(Color.parseColor("#818d9d"));
        // 设置x轴刻度文字大小
        xAxis.setTextSize(11);

        // 不画x轴网格线(x轴上的竖线)
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setDrawGridLines(false);
        //不显示X坐标轴上的线
        xAxis.setDrawAxisLine(false);
        xAxis.setYOffset(10f);
        xAxis.setDrawGridLines(false); // /是否显示X坐标轴上的刻度竖线
        xAxis.setGranularity(0); // 没有x坐标间隔（即跳过几个坐标在显示)
        xAxis.setValueFormatter(new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return attendances.get((int) value).getClassName();
            }
        });
        // y坐标轴
        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setGranularity(20); // 设置刻度
        leftAxis.setAxisMinimum(0);
        leftAxis.setAxisMaximum(100);
        leftAxis.setValueFormatter(new IAxisValueFormatter() {
            private DecimalFormat mFormat = new DecimalFormat("###,###,###,##0");
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if (value < 0) {
                    return "";
                }
                return mFormat.format(value);
            }
        });

        // 设置y轴网格线为虚线(注意使用setAxisLineDashedLine这个方法无效）
        leftAxis.setGridColor(Color.parseColor("#eeeeee"));
        leftAxis.enableGridDashedLine(10, 5, 0);
        leftAxis.setTextSize(11);

        // 不显示y坐标轴线
        leftAxis.setDrawAxisLine(false);
        leftAxis.enableAxisLineDashedLine(40, 3, 0);


        YAxis rightAxis = barChart.getAxisRight();
        // 不绘制右边y轴
        rightAxis.setEnabled(false);

        List<BarEntry> entryList = new ArrayList<>();
        for (int i=0; i<attendances.size(); i++) {
            BarEntry barEntry = new BarEntry(i, attendances.get(i).getPercent());
            entryList.add(barEntry);
        }
        BarDataSet dataSet = new BarDataSet(entryList, "");
        dataSet.setDrawValues(true); // 不显示柱状图数值
        BarData barData = new BarData(dataSet);
//        barChart.setFitBars(true);
//        barChart.setAutoScaleMinMaxEnabled(true);
        barChart.setData(barData);
//        mChart.invalidate();

    }

    private void test2() {
        BarChart mChart = (BarChart)findViewById(R.id.barchart);
        //启用/禁用缩放图表上的两个轴
        mChart.setScaleEnabled(true);
        //是否可以缩放
        mChart.setScaleEnabled(false);
        //集双指缩放
        mChart.setPinchZoom(false);
        mChart.setViewPortOffsets(0, 0, 0, 130);
        //增加X轴最左边与Y轴的距离
        mChart.setDragOffsetX(30);
        //设置表格颜色
        mChart.getAxisRight().setEnabled(false);
        //设置一个描述的文本出现在右下角的图
        mChart.setDescription(null);
        //隐藏图例
        mChart.getLegend().setEnabled(false);

        //设置X轴
        XAxis xAxis = mChart.getXAxis();
        //设置X轴的位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setGranularity(0);
        xAxis.setDrawGridLines(false);
        //不显示X坐标轴上的线
        xAxis.setDrawAxisLine(false);
        xAxis.setYOffset(10f);
        xAxis.setValueFormatter(new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                Log.i("zqr", "value=" + value);
                return attendances.get((int) value).getClassName() ;
            }
        });
        //设置Y轴
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setTextColor(Color.WHITE);
        leftAxis.setGridColor(Color.parseColor("#313131"));
        leftAxis.setGridLineWidth(1f);
        leftAxis.setTextSize(10);
        //不显示Y坐标轴上的线
        leftAxis.setDrawAxisLine(false);
        //设置Y坐标显示在右边
        leftAxis.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        //Y坐标显示向上偏移
        leftAxis.setYOffset(-7f);

        List<BarEntry> entryList = new ArrayList<>();
        for (int i=0; i<attendances.size(); i++) {
            BarEntry barEntry = new BarEntry(i, attendances.get(i).getPercent());
            entryList.add(barEntry);
        }
        BarDataSet dataSet = new BarDataSet(entryList, "");
        dataSet.setDrawValues(true); // 不显示柱状图数值
        BarData barData = new BarData(dataSet);
//        barChart.setFitBars(true);
//        barChart.setAutoScaleMinMaxEnabled(true);
        mChart.setData(barData);
//        mChart.invalidate();
    }


}
