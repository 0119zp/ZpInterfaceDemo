package zp.com.zpinterfacedemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import zp.com.zpinterfacedemo.chouxiang.ZpAbstractActivity;
import zp.com.zpinterfacedemo.jiekou.ZpInterfaceActivity;
import zp.com.zplib.ZpCallBack;
import zp.com.zplib.ZpLibActivity;
import zp.com.zplib.ZpListener;

public class MainActivity extends AppCompatActivity implements ZpListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ZpCallBack zpCallBack = new ZpCallBack();
        zpCallBack.setZpListener(this);
    }

    public void button(View view){
        Intent intent = new Intent(MainActivity.this, ZpInterfaceActivity.class);
        startActivity(intent);
    }

    public void button1(View view){
        Intent intent = new Intent(MainActivity.this, ZpAbstractActivity.class);
        startActivity(intent);
    }

    public void button2(View view){
        Intent intent = new Intent(MainActivity.this, ZpLibActivity.class);
        startActivity(intent);
    }

    @Override
    public void showDialog(Context context) {
        ZpDialog dialog = new ZpDialog(this);
        dialog.show();
    }
}
