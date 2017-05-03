package com.example.ldp.com.util;/**
 * Created by Administrator on 2017/3/28.
 */

import android.graphics.Color;
import android.util.DisplayMetrics;

import com.example.ldp.com.bean.Analyzes;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :ChartUtil为 类
 * Author:ldp
 * Data:2017/3/28
 */
public class ChartUtil {

    /*
    *
    * author:ldp
    * 饼状图Methods
    * 2017年3月28日 星期二
    * */
    public static PieData getPieData(int count, float range,List<Analyzes> analyzesList) {

        ArrayList<String> xValues = new ArrayList<String>();  //xVals用来表示每个饼块上的内容

        ArrayList<Entry> yValues = new ArrayList<Entry>();  //yVals用来表示封装每个饼块的实际数据

        ArrayList<Entry> zValues = new ArrayList<Entry>();
        // 饼图数据
        /**
         * 将一个饼形图分成四部分， 四部分的数值比例为14:14:34:38
         * 所以 14代表的百分比就是14%
         */
        Integer num;
        if(analyzesList.size()>5){
            num=10;
        }else{
            num=5;
        }
        Analyzes analyzes;

        for(int i=0;i<num;i++){
            analyzes = analyzesList.get(i);
            xValues.add(analyzes.getIname()+"/"+analyzes.getA_id());
            yValues.add(new Entry((float)analyzes.getResult(),i));

        }

        //y轴的集合
        PieDataSet pieDataSet = new PieDataSet(yValues, "所属院级Color"/*显示在比例图上*/);
        pieDataSet.setSliceSpace(0.1f); //设置个饼状图之间的距离

        ArrayList<Integer> colors = new ArrayList<Integer>();

        // 饼图颜色
        colors.add(Color.rgb(205, 205, 205));
        colors.add(Color.rgb(114, 188, 223));
        colors.add(Color.rgb(255, 123, 124));
        colors.add(Color.rgb(57, 135, 200));
        colors.add(Color.rgb(255,235 ,205 ));
        colors.add(Color.rgb(240, 255,240 ));
        colors.add(Color.rgb(255, 255,0 ));
        colors.add(Color.rgb(56, 94, 155));
        colors.add(Color.rgb(127, 255, 0));
        colors.add(Color.rgb(255, 204,237 ));


        pieDataSet.setColors(colors);

        DisplayMetrics metrics = MyApplicationUtil.getContext().getResources().getDisplayMetrics();
        float px = 5 * (metrics.densityDpi / 160f);
        pieDataSet.setSelectionShift(px); // 选中态多出的长度

        PieData pieData = new PieData(xValues, pieDataSet);

        return pieData;
    }

    public static void showChart(PieChart pieChart, PieData pieData) {
        pieChart.setHoleColorTransparent(true);

        pieChart.setHoleRadius(60f);  //半径
        pieChart.setTransparentCircleRadius(64f); // 半透明圈
        //pieChart.setHoleRadius(0)  //实心圆

        pieChart.setDescription("全校排名饼状图");

        // mChart.setDrawYValues(true);
        pieChart.setDrawCenterText(true);  //饼状图中间可以添加文字

        pieChart.setDrawHoleEnabled(true);

        pieChart.setRotationAngle(90); // 初始旋转角度

        // draws the corresponding description value into the slice
        // mChart.setDrawXValues(true);

        // enable rotation of the chart by touch
        pieChart.setRotationEnabled(true); // 可以手动旋转

        // display percentage values
        pieChart.setUsePercentValues(true);  //显示成百分比
        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
//      mChart.setOnChartValueSelectedListener(this);
        // mChart.setTouchEnabled(false);

//      mChart.setOnAnimationListener(this);

        pieChart.setCenterText("排名占比");  //饼状图中间的文字

        pieChart.setCenterTextSize(12);
        //设置数据
        pieChart.setData(pieData);

        // undo all highlights
//      pieChart.highlightValues(null);
//      pieChart.invalidate();

        Legend mLegend = pieChart.getLegend();  //设置比例图
        mLegend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);  //最右边显示
//      mLegend.setForm(LegendForm.LINE);  //设置比例图的形状，默认是方形
        mLegend.setXEntrySpace(7f);
        mLegend.setYEntrySpace(5f);
        pieChart.animateXY(1000, 1000);  //设置动画
        // mChart.spin(2000, 0, 360);
    }




    /*
    *
    * author:ldp
    * 柱状图Methods
    * 2017年3月28日 星期二
    *
    * */

    public static void  BarChart3s(BarChart chart) {
        // 数据描述
        chart.setDescription("");
        //背景
        chart.setBackgroundColor(0xffffffff);
        //定义数据描述得位置
        //chart.setDescriptionPosition(2,100);
        // 设置描述文字的颜色
        // chart.setDescriptionColor(0xffededed);
        // 动画
        chart.animateY(1000);
        //设置无边框
        chart.setDrawBorders(false);
        // 设置是否可以触摸
        chart.setTouchEnabled(false);
        // 是否可以拖拽
        chart.setDragEnabled(false);
        // 是否可以缩放
        chart.setScaleEnabled(false);
        //设置网格背景
        chart.setGridBackgroundColor(0xffffffff);
        //设置边线宽度
        chart.setBorderWidth(0);
        //设置边线颜色
        chart.setBorderColor(0xffffffff);
        // 集双指缩放
        chart.setPinchZoom(false);
        // 隐藏右边的坐标轴
        chart.getAxisRight().setEnabled(false);
        // 隐藏左边的左边轴
        chart.getAxisLeft().setEnabled(true);

        Legend mLegend = chart.getLegend(); // 设置比例图标示
        // 设置窗体样式
        mLegend.setForm(Legend.LegendForm.SQUARE);
        //设置图标位置
        mLegend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);
        // 字体
        mLegend.setFormSize(4f);
        //是否显示注释
        mLegend.setEnabled(false);
        // 字体颜色
//        mLegend.setTextColor(Color.parseColor("#7e7e7e"));

        //设置X轴位置
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        // 前面xAxis.setEnabled(false);则下面绘制的Grid不会有"竖的线"（与X轴有关）
        // 上面第一行代码设置了false,所以下面第一行即使设置为true也不会绘制AxisLine
        //设置轴线得颜色
        xAxis.setAxisLineColor(0xffffffff);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);
        xAxis.setSpaceBetweenLabels(2);

        //设置Y轴
        YAxis leftAxis = chart.getAxisLeft();
        //Y轴颜色
        leftAxis.setAxisLineColor(0xffffffff);
        //Y轴参照线颜色
        leftAxis.setGridColor(0xfff3f3f3);
        //参照线长度
        leftAxis.setAxisLineWidth(5f);
        // 顶部居最大值站距离占比
        leftAxis.setSpaceTop(20f);

        chart.invalidate();
    }


    public static ArrayList<BarDataSet> getDataSet(List<Analyzes> analyzesList) {
        ArrayList<BarDataSet> dataSets = null;
        ArrayList<BarEntry> valueSet1 = new ArrayList<BarEntry>();
        Analyzes analyzes;
       /* for (int i = 0; i < 10; i++) {
            float value = (float) (Math.random() * 100*//*100以内的随机数*//*) + 3;
            valueSet1.add(new BarEntry(value,i));}*/


        Integer num;
        if(analyzesList.size()>5){
            num=8;
        }else{
            num=5;
        }

        ArrayList<BarEntry> valueSet2 = new ArrayList<BarEntry>();
        for (int j = 0; j < num; j++) {
            analyzes = analyzesList.get(j);
            valueSet2.add(new BarEntry((float)analyzes.getResult(),j));
        }


       /* BarDataSet barDataSet1 = new BarDataSet(valueSet1, "目标");
        barDataSet1.setColor(Color.parseColor("#45a2ff"));

        barDataSet1.setBarShadowColor(Color.parseColor("#01000000"));*/

        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "实际");
        barDataSet2.setColor(Color.parseColor("#6faae7"));
        barDataSet2.setBarShadowColor(Color.parseColor("#01000000"));

        dataSets = new ArrayList<BarDataSet>();
        /*dataSets.add(barDataSet1);*/
        dataSets.add(barDataSet2);
        return dataSets;
    }

    public static  ArrayList<String> getXAxisValues(List<Analyzes> analyzesList) {
        Integer num;
        if(analyzesList.size()>5){
            num=8;
        }else{
            num=5;
        }
        Analyzes analyzes;
        ArrayList<String> xAxis = new ArrayList<String>();
        for (int j = 0; j <num; j++){
            analyzes = analyzesList.get(j);
            xAxis.add(String.valueOf(analyzes.getA_id()));//设置横坐标值
        }
        return xAxis;
    }


}
