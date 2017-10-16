package zp.com.zplib;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by Administrator on 2017/10/16 0016.
 */

public class ZpLibActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib);
    }

    public void setLib(View view){
        ZpCallBack zpCallBack = new ZpCallBack();
        zpCallBack.getZpListener().showDialog(ZpLibActivity.this);
    }

}
