package com.android.mycalendar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Calendar_Fragment calendar_fragment;
    Login_Fragment login_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button UpAndDownBtn = findViewById(R.id.UpAndDown);
        Button.OnClickListener onClickListener = new Button.OnClickListener(){

            @Override
            public void onClick(View view){
                switch (view.getId()) {
                    case R.id.UpAndDown:
                        String buffer = UpAndDownBtn.getText().toString();
                        if(buffer.equals("up")){
                            //TODO: 버튼 클릭해서 달력 닫고 열기
                            upDownCalendar(1);
                            UpAndDownBtn.setText("down");
                        }else{
                            upDownCalendar(2);
                            UpAndDownBtn.setText("up");
                        }

                        break;
                }

            }
        };


        UpAndDownBtn.setOnClickListener(onClickListener);

    }

    public void upDownCalendar(int index){
        if(index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.calendar_place, calendar_fragment);
        }else {
            getSupportFragmentManager().beginTransaction().replace(R.id.calendar_place, login_fragment);
        }



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        getSupportFragmentManager().beginTransaction().replace(R.id.calendar_place, calendar_fragment).commit();

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
