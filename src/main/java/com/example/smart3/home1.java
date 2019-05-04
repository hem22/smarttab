package com.example.smart3;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import static android.widget.Toast.LENGTH_LONG;

public class home1 extends Fragment {

    Switch switch1, switch2;
    public Object home1;
    public static home1 newInstance(){
        home1 fragment = new home1();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_home1,container,false);
        switch1 = (Switch) view.findViewById(R.id.switch1);
        switch2 = (Switch) view.findViewById(R.id.switch2);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
                                               @Override
                                               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                                                   if(isChecked == true) {
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

/*
public class home1 extends AppCompatActivity {

    Switch switch1, switch2;
    public Object home1;

    @Override
    protected void onCreate(Bundle savedInstanceStaete){
        super.onCreate(savedInstanceStaete);
        setContentView(R.layout.activity_home1);

        switch1 = (Switch) findViewById(R.id.switch1);
        switch2 = (Switch) findViewById(R.id.switch2);


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
             if(isChecked == true) {
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
}*/