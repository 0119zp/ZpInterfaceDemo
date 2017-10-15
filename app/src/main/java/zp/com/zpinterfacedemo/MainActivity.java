package zp.com.zpinterfacedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import zp.com.zpinterfacedemo.chouxiang.ZpAbstractActivity;
import zp.com.zpinterfacedemo.jiekou.ZpInterfaceActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button(View view){
        Intent intent = new Intent(MainActivity.this, ZpInterfaceActivity.class);
        startActivity(intent);
    }

    public void button1(View view){
        Intent intent = new Intent(MainActivity.this, ZpAbstractActivity.class);
        startActivity(intent);
    }
}
