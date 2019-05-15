package com.example.smart3;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class AppCompatActicity extends AppCompatActivity {
    Switch switch1, switch2;
    public Object home1;

    @Override
    protected void onCreate(Bundle savedInstanceStaete){
        super.onCreate(savedInstanceStaete);
        setContentView(R.layout.activity_home1);

        switch1 = (Switch) findViewById(R.id.switch1);
        switch2 = (Switch) findViewById(R.id.switch2);


        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                    if(isChecked) {
                        Toast.makeText((Context) home1, "전기가 켜집니다", LENGTH_LONG).show();
                    } else{
                        Toast.makeText((Context) home1, "전기가 꺼집니다.", LENGTH_LONG).show();
                    }
                }
            }
            );
            switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                    if(isChecked == true){
                        Toast.makeText((Context) home1,"전기가 켜집니다",Toast.LENGTH_SHORT).show();
                        // EditText 내용과 함께 ex) "휴대폰충전기가 켜집니다"
                        //imageView.setImageResource(R.drawble.off이미지);
                    } else{
                        Toast.makeText((Context) home1, "전기가 꺼집니다.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            );

    }
}