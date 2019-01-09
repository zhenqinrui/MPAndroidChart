package com.xxmassdeveloper.mpchartexample.szytest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.xxmassdeveloper.mpchartexample.AnotherBarActivity;
import com.xxmassdeveloper.mpchartexample.R;
import com.xxmassdeveloper.mpchartexample.custom.MyAxisValueFormatter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
        int count = new Random().nextInt(30);
        for (int i = 0; i < count; i++) {
            ClassAttendance classAttendance = new ClassAttendance("杰杰幼的-" + "大大" + (i+1) + "班", 60);
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

    float lastX = 0;
    float lastY = 0;

    private void initBarchart() {

        BarChart barChart = (BarChart)findViewById(R.id.barchart);
        //不可以缩放
        barChart.setScaleEnabled(false);
        barChart.setPinchZoom(false);
        barChart.setDoubleTapToZoomEnabled(false); // 禁止通过在其上双击缩放图表。
        barChart.setHighlightPerTapEnabled(false); // 防止值由敲击姿态被突出显示
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

        XAxis xAxis = barChart.getXAxis();
        float[] floats = new float[attendances.size()];
        for (int i = 0; i<floats.length; i++) {
            floats[i] = i;
        }
        xAxis.setUseCustomerEntry(true, floats);
//        xAxis.setAxisMinimum(0);
//        xAxis.setAxisMaximum(attendances.size() - 1);
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
                int i = (int)value;
                if (i < attendances.size()) {
                    return attendances.get(i).getClassName();
                }
                return "";
            }
        });
        // y坐标轴
        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setGranularity(20); // 设置刻度
        leftAxis.setAxisMinimum(0);
        leftAxis.setAxisMaximum(100);
        leftAxis.setSpaceBottom(0);
        leftAxis.setSpaceTop(0);

        // 设置y轴网格线为虚线(注意使用setAxisLineDashedLine这个方法无效）
        leftAxis.setGridColor(Color.parseColor("#ffaabb"));
        leftAxis.enableGridDashedLine(10, 5, 0);
        leftAxis.setTextSize(11);

        // 不显示y坐标轴线
        leftAxis.setDrawAxisLine(false);


        YAxis rightAxis = barChart.getAxisRight();
        // 不绘制右边y轴
        rightAxis.setEnabled(false);

        List<BarEntry> entryList = new ArrayList<>();
        for (int i=0; i<attendances.size(); i++) {
            BarEntry barEntry = new BarEntry(i, attendances.get(i).getPercent());
            entryList.add(barEntry);
        }
        BarDataSet dataSet = new BarDataSet(entryList, "");
        dataSet.setRoundRadius(15);
        dataSet.setDrawValues(true); // 不显示柱状图数值
        BarData barData = new BarData(dataSet);
        barData.setBarWidth(0.5f); // 设置柱状图的宽度，小一点，默认0.85相对比较大
        barChart.setData(barData);
        // 设置默认几个可见，需要放在setData后
        if (attendances.size() > 5) {
            barChart.setVisibleXRange(0, 5);
        } else {
            barChart.setVisibleXRange(0, attendances.size());
        }
//        // barChart可以滚动，设置点击事件导致滚动后，手指抬起也会调用点击事件，因此自定义下
        barChart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        lastX = event.getX();
                        lastY = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        // 自定义点击
                        Log.i("zqr", "Math.abs(event.getX() - lastX=" + Math.abs(event.getX() - lastX));
                        if (Math.abs(event.getX() - lastX) < 6) {
                            // 是点击，而非滑动
                            startActivity(new Intent(SzyTestBarActivity.this,  AnotherBarActivity.class));
                        }
                        break;
                }
                return false;
            }
        });
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
