package text.bwei.com.lianxi4chuanzhi;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    private String[] mStrings = {"中国", "美国", "英国", "法国", "俄罗斯",
            "泰国", "缅甸", "老挝", "越南", "日本", "印度", "里约",
            "雅典", "爪哇国", "女儿国", "车迟国"};

    private TextView mFragment2_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //实现方式一,全部操作在Activity中做,但这样的话,单独去建议Fragment已没有意义,所以我们要把操作都放在独立的Fragment中做
        //然后通过通信的方式来操作另一个Fragment
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(arrayAdapter);

        mFragment2_tv = (TextView) findViewById(R.id.fragment2_tv);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mFragment2_tv.setText(mStrings[position]);
            }
        });
    }
}
