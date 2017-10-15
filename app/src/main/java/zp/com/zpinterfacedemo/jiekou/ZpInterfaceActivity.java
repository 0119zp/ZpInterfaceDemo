package zp.com.zpinterfacedemo.jiekou;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import zp.com.zpinterfacedemo.R;

/**
 * 接口方式传递数据
 */

public class ZpInterfaceActivity extends Activity{

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

        ZpInterfaceAdapter zpTestAdapter = new ZpInterfaceAdapter(ZpInterfaceActivity.this,list);
        listView.setAdapter(zpTestAdapter);

        // 接口方式传递数据
        // 步骤5 -- 调用方法设置监听
        zpTestAdapter.setZpItemOnListener(new ZpInterfaceAdapter.ZpItemOnListener() {
            @Override
            public void onItemListener(int position) {
                Toast.makeText(ZpInterfaceActivity.this, "点击第 " + position + " 条目的按钮" , Toast.LENGTH_SHORT).show();
            }
        });

    }


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
