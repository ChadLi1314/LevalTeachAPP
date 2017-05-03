package com.example.ldp.com.activity;

import android.content.Context;
import android.content.Intent;

import com.example.ldp.com.bean.Analyzes;
import com.example.ldp.com.util.ChartUtil;
import com.example.ldp.com.util.HttpGetUtil;
import com.github.mikephil.charting.charts.BarChart;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ldp.com.controller.ActivityController;
import com.example.ldp.com.controller.BaseActivity;
import com.example.ldp.com.forestteaching.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.PieData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerActivity extends BaseActivity {

    private List<Analyzes> analyzesList;
    private PieChart mChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        //加载toobar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //标题设置
        TextView text = (TextView) findViewById(R.id.title_id);
        text.setText("评价分析主页");

        //请求数据
        initFruits();

        //设置饼状图表
        mChart = (PieChart) findViewById(R.id.spread_pie_chart);
        PieData mPieData = ChartUtil.getPieData(10,100,analyzesList);
        ChartUtil.showChart(mChart,mPieData);

        //柱状图
        BarChart chart1 = (BarChart) findViewById(R.id.chart1);
        ChartUtil.BarChart3s(chart1);
        BarData data = new BarData(ChartUtil.getXAxisValues(analyzesList),ChartUtil.getDataSet(analyzesList));
        chart1.setData(data);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.evaluate_manager,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.exit_item:
                ActivityController.finishAll();
                break;
            default:
                break;
        }
        return true;
    }

    /*put activity method*/
    public static void actionstart(Context context){
        Intent intent = new Intent(context,ManagerActivity.class);
        context.startActivity(intent);
    }

    /*请求数据Method*/
    private void initFruits(){
        Map<String,String> map = new HashMap<>();
        map.put("username","");
        String str = HttpGetUtil.SendPostHttp("teacher/toShowPieChartjsp.action",map);
        Gson gson = new Gson();
        analyzesList = gson.fromJson(str,new TypeToken<List<Analyzes>>(){}.getType());
        if(analyzesList.size()==0){
            Toast.makeText(ManagerActivity.this,"服务器没数据!",Toast.LENGTH_SHORT).show();
        }
    }

}
