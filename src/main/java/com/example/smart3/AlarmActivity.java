package com.example.smart3;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {

    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    Context context;
    Button add;
    PendingIntent pendingIntent;
    EditText textTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        this.context = this;

        // 알람매니저 설정
        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        // 타임피커 설정
        alarm_timepicker = findViewById(R.id.time_picker);

        // Calendar 객체 생성
        final Calendar calendar = Calendar.getInstance();

        // 알람리시버 intent 생성
        final Intent my_intent = new Intent(this.context, Alarm_Reciver.class);

        add = findViewById(R.id.add);

        textTitle = findViewById(R.id.textTitle);

        // 알람 시작 버튼
        Button alarm_on = findViewById(R.id.btn_start);
        alarm_on.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                // calendar에 시간 셋팅
                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
                calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                // 시간 가져옴
                int hour = alarm_timepicker.getHour();
                int minute = alarm_timepicker.getMinute();
                Toast.makeText(AlarmActivity.this, "Alarm 예정 " + hour + "시 " + minute + "분", Toast.LENGTH_SHORT).show();

                // reveiver에 string 값 넘겨주기
                my_intent.putExtra("state", "alarm on");

                pendingIntent = PendingIntent.getBroadcast(AlarmActivity.this, 0, my_intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

                // 알람셋팅
                alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                        pendingIntent);


            }
        });

        // 알람 정지 버튼
        Button alarm_off = findViewById(R.id.btn_finish);
        alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AlarmActivity.this, "Alarm 종료", Toast.LENGTH_SHORT).show();
                // 알람매니저 취소
                alarm_manager.cancel(pendingIntent);

                my_intent.putExtra("state", "alarm off");

                // 알람취소
                sendBroadcast(my_intent);
            }
        });

        // 선택버튼클릭리스너
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", textTitle.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
