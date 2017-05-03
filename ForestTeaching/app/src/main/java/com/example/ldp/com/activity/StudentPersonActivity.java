package com.example.ldp.com.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ldp.com.bean.BeanUtil;
import com.example.ldp.com.bean.Student;
import com.example.ldp.com.controller.ActivityController;
import com.example.ldp.com.controller.BaseActivity;
import com.example.ldp.com.forestteaching.R;
import com.example.ldp.com.util.HttpGetUtil;
import com.example.ldp.com.util.JsonUtil;

import java.util.HashMap;
import java.util.Map;

public class StudentPersonActivity extends BaseActivity {

    private EditText student_id;
    private EditText student_name;
    private EditText student_password;
    private EditText student_class;
    private Button input_message;

    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_person);
        //加载toobar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //获得用户ID值
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        id = bundle.getString("id");
        Log.i("LDP",id);

        //改变标题文字
        TextView text = (TextView) findViewById(R.id.title_id);
        text.setText("个人信息主页");

        //加载控件
        this.student_id = (EditText) findViewById(R.id.student_id);
        this.student_name = (EditText) findViewById(R.id.student_name);
        this.student_password = (EditText) findViewById(R.id.student_password);
        this.student_class = (EditText) findViewById(R.id.student_class);
        this.input_message = (Button) findViewById(R.id.input_message);


        //得到数据设置进去
        selectPersonMessage(this.id);

        //按钮监听
        this.input_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePersonMessage();
            }
        });

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
    public static void actionstart(Context context, String username){
        Intent intent = new Intent(context,StudentPersonActivity.class);
        intent.putExtra("id",username);
        context.startActivity(intent);
    }

    /*select method*/
    private void selectPersonMessage(String id){
        Map<String,String> map = new HashMap<>();
        map.put("id",id);
        String str = HttpGetUtil.SendPostHttp("showcourse/toupdateStudent.action",map);
        Student student = JsonUtil.deserializeJson(str, Student.class);
        this.student_id.setText(String.valueOf(student.getS_id()));
        this.student_class.setText(student.getGrade());
        this.student_password.setText(student.getPassword());
        this.student_name.setText(student.getSname());
    }

    /*select method*/
    private void updatePersonMessage(){
        Map<String,String> map = new HashMap<>();
        map.put("s_id",this.student_id.getText().toString());
        map.put("password",this.student_password.getText().toString());
        String str = HttpGetUtil.SendPostHttp("showcourse/updateStudentLogin.action",map);
        BeanUtil beanUtil = JsonUtil.deserializeJson(str, BeanUtil.class);
        if (beanUtil.getLoginState()==1){
            /*要想重新回到上一个活动，不能请求调用finish方法相当于回到了上一个活动activity*/
            /*StudentActivity.actionstart(StudentPersonActivity.this,this.student_id.getText().toString());*/
            StudentPersonActivity.this.finish();
        }else{
            Toast.makeText(StudentPersonActivity.this,"网络出错，请稍后重试",Toast.LENGTH_SHORT).show();
        }
    }


}
