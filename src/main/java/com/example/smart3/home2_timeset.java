package com.example.smart3;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class home2_timeset extends Fragment {

    private Object setContentView;

    public static home2_timeset newInstance(){
        home2_timeset fragment = new home2_timeset();
        return fragment;
    }
    @Override
    public void onCreate(Bundle sabedInstanceState){
        super.onCreate(sabedInstanceState);
    }

    private void setContentView(int activity_home2_timeset) {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_home2_timeset,container,false);

        return view;
    }

}

/*public class home2_timeset extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }
 }*/
