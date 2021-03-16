package android.wings.websarva.intentsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuThanksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_thanks);

        //先の画面で生成したインテントオブジェクトを取得
        Intent intent = getIntent();

        //先のデータから渡されたデータの取得し、変数に代入
        String menuName = intent.getStringExtra("menuName");
        String menuPrice = intent.getStringExtra("menuPrice");

        //上で取得した定食名と金額を表示させるtextViewを取得
        TextView tvMenuName = findViewById(R.id.tvMenuName);
        TextView tvMenuPrice = findViewById(R.id.tvMenuPrice);

        //取得したtextViewに定食名と金額を表示
        tvMenuName.setText(menuName);
        tvMenuPrice.setText(menuPrice);

    }

    /* 戻るボタンタップ時. レイアウトファイルでButtonに設定 */
    public void onBackButtonClick(View view) {
        finish();
    }


}
