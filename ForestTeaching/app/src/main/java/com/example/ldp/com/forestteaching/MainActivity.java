package com.example.ldp.com.forestteaching;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ldp.com.activity.ManagerActivity;
import com.example.ldp.com.activity.StudentActivity;
import com.example.ldp.com.activity.TeacherActivity;
import com.example.ldp.com.bean.BeanUtil;
import com.example.ldp.com.controller.BaseActivity;
import com.example.ldp.com.util.ConstantUtil;
import com.example.ldp.com.util.HttpGetUtil;
import com.example.ldp.com.util.JsonUtil;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button commit;
    private EditText userNumber;
    private EditText userPass;
    private TextView msg;
    private ImageButton img1;
    private ImageButton img2;
    private Spinner spinnerUser;

    private String useridText;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //继承Activity自动默认去掉标题栏
        setContentView(R.layout.activity_main);


        //属性列
        spinnerUser = (Spinner) findViewById(R.id.user_id);
        userNumber = (EditText) findViewById(R.id.user);
        userPass = (EditText) findViewById(R.id.password);
        commit = (Button) findViewById(R.id.input_all);
        msg = (TextView) findViewById(R.id.hint_msg);
        img1 = (ImageButton) findViewById(R.id.null_img1);
        img2 = (ImageButton) findViewById(R.id.null_img2);

        //监听列
        commit.setOnClickListener(this);
        img1.setOnClickListener(this);
        userNumber.setOnClickListener(this);
        img2.setOnClickListener(this);
        userPass.setOnClickListener(this);



        /*Lister Event*/
        final List<String> list = new ArrayList<>();
        list.add("学生");
        list.add("教师");
        list.add("Manager");
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUser.setAdapter(adapter);
        spinnerUser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)parent.getChildAt(0)).setTextColor(Color.WHITE);
                TextView tv = (TextView) view;
                tv.setTextSize(22);
                tv.setTextColor(Color.WHITE);
                tv.setGravity(Gravity.CENTER);
                useridText = adapter.getItem(position);
                Toast.makeText(MainActivity.this, "---选中" + adapter.getItem(position) + "用户---", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });


        userNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    img1.setVisibility(View.VISIBLE);
                }
            }
        });
        userPass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    img2.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.input_all:
                commitButton();
                break;
            case R.id.null_img1:
                userNumber.setText("");
                break;
            case R.id.null_img2:
                userPass.setText("");
                break;
            default:
                break;
        }
    }


    /**
     * author:ldp
     * Time:2017.3.18
     * Event Method
     */

    //commit event
    public void commitButton() {
        String flag="";
        if (userNumber.getText().toString().trim().equals("") ||
                userPass.getText().toString().trim().equals("")) {
            msg.setText("您输入的用户或密码为空!请填写后提交.");
            msg.setVisibility(View.VISIBLE);
            return;
        }else{
            Map<String,String> map = new HashMap<>();
            map.put("username",userNumber.getText().toString().trim());
            map.put("password",userPass.getText().toString().trim());

            switch (useridText.trim()) {
                case "学生":
                    flag = HttpGetUtil.SendPostHttp("login/studentlogin.action",map);
                    break;
                case "教师":
                    flag = HttpGetUtil.SendPostHttp("login/teacherlogin.action",map);
                    break;
                case "Manager":
                    flag = HttpGetUtil.SendPostHttp("login/managerlogin.action",map);
                    break;
                default:
                    break;
            }
        }

        BeanUtil beanUtil = JsonUtil.deserializeJson(flag,BeanUtil.class);

        if(beanUtil.getLoginState()==ConstantUtil.CONSTANT_ONE){
            switch (useridText.trim()){
                case "学生":
                    StudentActivity.actionstart(MainActivity.this,userNumber.getText().toString().trim());
                    break;
                case "教师":
                    TeacherActivity.actionstart(MainActivity.this,userNumber.getText().toString().trim());
                    break;
                case "Manager":
                    ManagerActivity.actionstart(MainActivity.this);
                    break;
                default:
                    break;
            }
            Toast.makeText(MainActivity.this, "---登录成功---", Toast.LENGTH_SHORT).show();
        }else{
            msg.setText("您输入的用户或密码有误!请再尝试.");
            msg.setVisibility(View.VISIBLE);
        }

    }

    /*put activity method*/
    public static void actionstart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }



}
