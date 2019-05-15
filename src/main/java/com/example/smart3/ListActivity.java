package com.example.smart3;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    private static final int REQUEST_ADD_ALARM = 100;
    List<String> dataList;
    ArrayAdapter<String> adapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_list);

        dataList = new ArrayList<String>();
        dataList.add("Encapsulation");
        dataList.add("inheritance");
        dataList.add("Polymerphsim");

        //controller 역할을 하는Adapter 객체 생성
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice, dataList);
        list =(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //list에서 항목을 선택했을 때 호출되는 메소드 설정
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            //첫번째 : 엄마 View(ListView(R.id.list)가 엄마 뷰입니다)
            //두번째 : 이벤트가 발생한 항목 뷰 (엄마 뷰안에 들어갈 자식뷰입니다, 리스트뷰에 들어가있는 하나하나의 Row라고 생각하시면 됩니다.)
            //세번째 : 이벤트가 발생한 인덱스 (선택한 자식의 인덱스를 리턴합니다)
            //네번째 : 이벤트가 발생한 항목 뷰의 아이디 (id는 안드로이드가 알아서 매기기때문에 잘 활용하지 않는 매개변수입니다~)
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast로 성택한 데이터를 출력
                String item = dataList.get(position);
                //this는 아이템 클릭리스너의 this가 되어버리끼 때문에 ManActivity.this를 써주어야 합니다
                Toast.makeText(ListActivity.this,item,Toast.LENGTH_LONG).show();
            }
        });

        //add 버튼을 눌럿을때 newItem에 입력한 문자열을 리스트 뷰에 추가
        Button add = (Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText newItem = (EditText)findViewById(R.id.textTitle);
                String item = newItem.getText().toString(); // EidtText에는 데이터가 Edittable로 들어가기때문에 toString()으로~~
                if(item!=null || item.trim().length()>0){
                    dataList.add(item.trim());
                    adapter.notifyDataSetChanged();
                    newItem.setText("");
                }
            }
        });

        Button delete = (Button)findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int pos = list.getCheckedItemPosition();
                if(pos>=0 && pos< dataList.size()){
                    dataList.remove(pos);
                    list.clearChoices();
                    adapter.notifyDataSetChanged();

                }
            }
        });

        Button b = (Button)findViewById(R.id.add);
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                Intent intent = new Intent(getApplicationContext(), AlarmActivity.class);
                startActivityForResult(intent, REQUEST_ADD_ALARM);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_ADD_ALARM){
            String name = data.getStringExtra("name");
            dataList.add(name);
            adapter.notifyDataSetChanged();
        }

    }
}