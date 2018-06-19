修改点（基于MPAndroidChart2018年6月18日master最新代码）：
1、 // 柱状图示例： 处理x坐标文字显示不全问题(重写了换行，还是没显示的问题),以下两种方式都可以试下，第一种方式好像和版本有关,第二种试了没问题
    // 方案一
      Legend legend = mChart.getLegend();
    //legend.setForm(Legend.LegendForm.NONE);
    // legend.setTextColor(Color.TRANSPARENT);
  
      // 方案二
      legend.setEnabled(false);
      mChart.setViewPortOffsets(0, 0, 0, 100);
 
2、XAxisRenderer绘制x坐标值，修改drawLabel方法以支持x坐标根据\n换行
    protected void drawLabel(Canvas c, String formattedLabel, float x, float y, MPPointF anchor, float angleDegrees) {
            float labelHeight = mXAxis.getTextSize();
            float labelInterval = 25f;
            String[] labels = formattedLabel.split("\n");
    
            Paint mFirstLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mFirstLinePaint.setColor(Color.BLUE);
            mFirstLinePaint.setTextAlign(Align.CENTER);
            mFirstLinePaint.setTextSize(Utils.convertDpToPixel(15f));
            mFirstLinePaint.setTypeface(mXAxis.getTypeface());
    
            Paint mSecondLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mSecondLinePaint.setColor(0xFF9b9b9b);
            mSecondLinePaint.setTextAlign(Align.CENTER);
            mSecondLinePaint.setTextSize(Utils.convertDpToPixel(10f));
            mSecondLinePaint.setTypeface(mXAxis.getTypeface());
    
            if (labels.length > 1) {
                Utils.drawXAxisValue(c, labels[0], x, y, mFirstLinePaint, anchor, angleDegrees);
                Utils.drawXAxisValue(c, labels[1], x, y + labelHeight + labelInterval, mSecondLinePaint, anchor, angleDegrees);
            } else {
                Utils.drawXAxisValue(c, formattedLabel, x, y, mFirstLinePaint, anchor, angleDegrees);
            }
            // 原来的方法（不支持文字换行)
    //        Utils.drawXAxisValue(c, formattedLabel, x, y, mAxisLabelPaint, anchor, angleDegrees);
        }

     
      