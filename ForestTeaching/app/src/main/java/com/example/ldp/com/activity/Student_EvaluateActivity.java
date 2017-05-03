package com.example.ldp.com.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ldp.com.adapter.Student_Evaluate_Adater;
import com.example.ldp.com.controller.ActivityController;
import com.example.ldp.com.controller.BaseActivity;
import com.example.ldp.com.forestteaching.R;
import com.example.ldp.com.util.HttpGetUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student_EvaluateActivity extends BaseActivity {

    private List<String> questionList;
    private String c_id;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        //加载toobar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //设置标题
        TextView text = (TextView) findViewById(R.id.title_id);
        text.setText("课程评价主页");



        //获得用户ID值
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        c_id = bundle.getString("c_id");
        username = bundle.getString("username");

        initFruits();//初始化数据
        Student_Evaluate_Adater myadater = new Student_Evaluate_Adater(Student_EvaluateActivity.this,R.layout.listview_student__evaluate,questionList);
        //得到组件ListView
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(myadater);

        //等list全部迭代完后，添加Button、Editext所在的布局加到listView最下端


        EditText editText = new EditText(this);
        editText.setHint("请输入评语");
        editText.setTextColor(Color.parseColor("#323542"));
        editText.setHintTextColor(Color.parseColor("#808A87"));
        editText.setBackgroundResource(R.drawable.forget_password_div);
        editText.setMaxEms(10);
        InputFilter[] filters = {new InputFilter.LengthFilter(30)};
        editText.setFilters(filters);


        //动态添加Button并监听
        Button buttonFooter = new Button(this);
        buttonFooter.setText("Pull All");
        buttonFooter.setTextSize(18);
        buttonFooter.setTextColor(Color.parseColor("#323542"));
        buttonFooter.setBackgroundResource(R.drawable.button);
        buttonFooter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("LDP","成功点击");
                postEvaluate();
                Toast.makeText(Student_EvaluateActivity.this,"提交成功",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        listView.addFooterView(editText);
        listView.addFooterView(buttonFooter);


        //相应listView子布局项的响应(监听event)
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parent.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
                String question =questionList.get(position);
                Toast.makeText(Student_EvaluateActivity.this,"您点击了！"+question,Toast.LENGTH_SHORT).show();

            }
        });*/


    }


    /*加载ToolBar标题栏*/
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
    public static void actionstart(Context context,String c_id,String username){
        Intent intent = new Intent(context,Student_EvaluateActivity.class);
        intent.putExtra("c_id",c_id);
        intent.putExtra("username",username);
        context.startActivity(intent);
    }



    /*后台查询出评价数据*/
    private void initFruits(){
        Map<String,String> map = new HashMap<>();
        map.put("c_id",c_id);
        String str = HttpGetUtil.SendPostHttp("evaluate/toEvaluateJsp.action",map);
        Gson gson = new Gson();
        questionList = gson.fromJson(str,new TypeToken<List<String>>(){}.getType());
        if(questionList.size()==0){
            Toast.makeText(Student_EvaluateActivity.this,"该课程没有任何评价",Toast.LENGTH_SHORT).show();
        }

    }

    private void postEvaluate(){
        Map<String,String> map = new HashMap<>();
        map.put("c_id",c_id);
        map.put("result","72");
        map.put("username",username);
        map.put("content","很不错");
        String str = HttpGetUtil.SendPostHttp("evaluate/saveEvaluate.action",map);
    }



}
