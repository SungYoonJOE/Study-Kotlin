package com.example.hahaj.homework1byjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//버튼 리스너는 2가지 방법을 이용해서 구현
//가상 버튼 리스너
//클래스형 버튼 리스너

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    final TextView textView = (TextView)findViewById(R.id.textView);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1= (Button)findViewById(R.id.btn1);
        btn2= (Button)findViewById(R.id.btn2);
        btn3= (Button)findViewById(R.id.btn3);
        //textView = (TextView)findViewById(R.id.textView);

        //익명 클래스를 생성하여 처리
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strBtn1 = btn1.getText().toString();
                textView.setText(strBtn1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strBtn2 = btn2.getText().toString();
                textView.setText(strBtn2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strBtn3 = btn3.getText().toString();
                textView.setText(strBtn3);
            }
        });
    }
}
