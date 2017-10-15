package zp.com.zpinterfacedemo.chouxiang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import zp.com.zpinterfacedemo.R;

/**
 * Created by Administrator on 2017/3/22 0022.
 */

public class ZpAbstractAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<String> list = new ArrayList<>();
    private View view;
    // 步骤5 -- 声明监听
    private ZpItemOnClickListener zpItemOnClickListener;

    public ZpAbstractAdapter(Context context, ArrayList<String> list, ZpItemOnClickListener clickListener) {
        this.context = context;
        this.list = list;
        // 步骤6 -- 关联监听
        this.zpItemOnClickListener = clickListener;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ViewHlder viewHlder = null;
        if (view == null){
            viewHlder = new ViewHlder();
            view = LayoutInflater.from(context).inflate(R.layout.zp_test_item,null);

            viewHlder.itemText = (TextView) view.findViewById(R.id.tv_text);
            viewHlder.btnItem = (Button) view.findViewById(R.id.btn_item);

            view.setTag(viewHlder);
        }else {
            viewHlder = (ViewHlder) view.getTag();
        }
        // 设置条目文案
        viewHlder.itemText.setText(list.get(position));

        // 设置条目按钮点击事件
        viewHlder.btnItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 步骤2 -- 点击事件监听与自定义监听关联
                zpItemOnClickListener.zpItemListener(position);
            }
        });

        return view;
    }

    public class ViewHlder{

        TextView itemText;
        Button btnItem;
    }

    // 步骤1 -- 自定义抽象类 -- 实现点击事件监听
    public static abstract class ZpItemOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            zpItemListener((Integer)view.getTag());
        }
        public abstract void zpItemListener(int position);
    }

}
