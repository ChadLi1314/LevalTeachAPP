package com.example.ldp.com.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ldp.com.adapter.Myadater;
import com.example.ldp.com.bean.Course;
import com.example.ldp.com.controller.ActivityController;
import com.example.ldp.com.controller.BaseActivity;
import com.example.ldp.com.forestteaching.R;
import com.example.ldp.com.util.HttpGetUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherActivity extends BaseActivity {

    private List<Course> coursesList = new ArrayList<>();
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        //加载toobar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //得到用户id
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        username = bundle.getString("username");
        //设置标题
        TextView text = (TextView) findViewById(R.id.title_id);
        text.setText("教师主页");


        initFruits();//初始化数据
        Myadater myadater = new Myadater(TeacherActivity.this,R.layout.list_view_adapter,coursesList);
        //得到组件ListView
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(myadater);

        //相应listView子布局项的响应(监听event)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course =coursesList.get(position);
                Toast.makeText(TeacherActivity.this,course.getCname()+"您点击了！"+course.getC_id(),Toast.LENGTH_SHORT).show();
                EvaluateActivity.actionstart(TeacherActivity.this,String.valueOf(course.getC_id()));
            }
        });

    }

    /*Override Activity Menu Method*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.teacher,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.evaluation_id:
                /*Toast.makeText(this,"evaluation",Toast.LENGTH_SHORT).show();*/
                Teacher_ChartActivity.actionstart(TeacherActivity.this,username);
                break;
            case R.id.exit_item:
                ActivityController.finishAll();
                break;
            default:
                break;
        }
        return true;
    }

    /*put activity method*/
    public static void actionstart(Context context,String username){
        Intent intent = new Intent(context,TeacherActivity.class);
        intent.putExtra("username",username);
        context.startActivity(intent);
    }


    private void initFruits(){
        Map<String,String> map = new HashMap<>();
        map.put("username",username);
        String str = HttpGetUtil.SendPostHttp("teacher/toTeacherShowCourse.action",map);
        Gson gson = new Gson();
        coursesList = gson.fromJson(str,new TypeToken<List<Course>>(){}.getType());
        if(coursesList.size()==0){
            Toast.makeText(TeacherActivity.this,"您没有课程！",Toast.LENGTH_SHORT).show();
        }
    }
}
