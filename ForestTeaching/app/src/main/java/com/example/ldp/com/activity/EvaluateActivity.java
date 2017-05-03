package com.example.ldp.com.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

import com.example.ldp.com.adapter.MyEvaluateadater;
import com.example.ldp.com.adapter.Myadater;
import com.example.ldp.com.bean.Course;
import com.example.ldp.com.bean.Evaluate;
import com.example.ldp.com.controller.ActivityController;
import com.example.ldp.com.controller.BaseActivity;
import com.example.ldp.com.forestteaching.R;
import com.example.ldp.com.util.HttpGetUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateActivity extends BaseActivity {

    private List<Evaluate> evaluateList;
    private String c_id;
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
        c_id = bundle.getString("c_id");

        //设置标题
        TextView text = (TextView) findViewById(R.id.title_id);
        text.setText("课程评价列表");


        initFruits();//初始化数据
        MyEvaluateadater myadater = new MyEvaluateadater(EvaluateActivity.this,R.layout.list_view_adapter,evaluateList);
        //得到组件ListView
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(myadater);

        //相应listView子布局项的响应(监听event)
/*        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course =coursesList.get(position);
                Toast.makeText(TeacherActivity.this,course.getCname()+"您点击了！"+course.getC_id(),Toast.LENGTH_SHORT).show();
            }
        });*/

    }


    /*Override Activity Menu Method*/
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
    public static void actionstart(Context context, String c_id){
        Intent intent = new Intent(context,EvaluateActivity.class);
        intent.putExtra("c_id",c_id);
        context.startActivity(intent);
    }

    private void initFruits(){
        Map<String,String> map = new HashMap<>();
        map.put("c_id",c_id);
        String str = HttpGetUtil.SendPostHttp("teacher/toshowEvaluatejsp.action",map);
        Gson gson = new Gson();
        evaluateList = gson.fromJson(str,new TypeToken<List<Evaluate>>(){}.getType());
        if(evaluateList.size()==0){
            Toast.makeText(EvaluateActivity.this,"该课程没有评价",Toast.LENGTH_SHORT).show();
        }
    }
}
