package android.wings.websarva.intentsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        ListView lvMenu = findViewById(R.id.lvMenu);

        List<Map<String, String>> menuList = new ArrayList<>();

        //Map（キーとバリュー）を生成し、上のmenuListに格納
        Map<String, String> menu = new HashMap<>();
        menu.put("name", "唐揚げ定食");
        menu.put("price", "800円");
        menuList.add(menu);

        //listに追加するhashmapを任意の数だけ追加していく
        menu = new HashMap<>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", "850円");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", "850円");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ステーキ定食");
        menu.put("price", "1000円");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "野菜炒め定食");
        menu.put("price", "750円");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "とんかつ定食");
        menu.put("price", "900円");
        menuList.add(menu);

        //各画面部品に割り当てるデータを表すMapのキー名配列
        String[] from = {"name", "price"};
        // 上のfromのキー名に対応して、データを割り当てる画面部品のR値配列
        int[] to = {android.R.id.text1, android.R.id.text2};

        // ex) nameのバリューを、android.R.id.text1 に、priceのバリューをandroid.R.id.text2 に表示する
        // ※android.R.id.text1, android.R.id.text2は、android.R.layout.simple_list_item_2に埋め込まれている2個のTextView
        SimpleAdapter adapter = new SimpleAdapter
                (MenuListActivity.this, menuList, android.R.layout.simple_list_item_2, from, to);

        lvMenu.setAdapter(adapter);

        lvMenu.setOnItemClickListener(new ListItemClickListener());

    }


    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            //タップされた行のデータ取得。SimpleAdapterでは1行分はMap型。
            Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);

            //nameキーとpriceキーに入っている値を取得
            String menuName = item.get("name");
            String menuPrice = item.get("price");

            //インテントオブジェクトを作成
            Intent intent = new Intent(MenuListActivity.this, MenuThanksActivity.class);

            //次の画面に送るデータの格納。intentオブジェクトのメソッド。
            intent.putExtra("menuName", menuName);
            intent.putExtra("menuPrice", menuPrice);

            //第二画面の起動
            startActivity(intent);


        }

    }



}
