package zp.com.zpinterfacedemo.chouxiang;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

import zp.com.zpinterfacedemo.R;


/**
 * 抽象类实现传递数据
 */

public class ZpAbstractActivity extends Activity{

    private ListView listView;

    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zp_test);

        // 假数据
        setData();

        listView = (ListView) findViewById(R.id.lv_test);

        initListView();

    }

    private void initListView() {
        // 步骤4 -- 把监听传递到adapter中
        ZpAbstractAdapter zpTestAdapter = new ZpAbstractAdapter(ZpAbstractActivity.this,list,clickListener);
        listView.setAdapter(zpTestAdapter);
    }

    // 步骤3 -- 设置监听
    private ZpAbstractAdapter.ZpItemOnClickListener clickListener = new ZpAbstractAdapter.ZpItemOnClickListener(){

        @Override
        public void zpItemListener(int position) {
            Toast.makeText(ZpAbstractActivity.this,"点击第 " + position + " 条目的按钮",Toast.LENGTH_SHORT).show();
        }
    };


    /////////////////////// 假数据制造专区 //////////////////////////////////

    private void setData() {
        // 数据防护
        if (list != null && list.size() > 0){
            list.clear();
        }

        for (int i = 0 ; i < 10 ; i ++ ){
            list.add("第 " + i + " 个条目");
        }
    }

}
