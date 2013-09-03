package com.test.exp;

import java.util.Calendar;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

public class MainActivity2 extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kakunin);
		Intent intent = getIntent();

		if (intent != null) {
			String sexS = intent.getStringExtra("sex");// mainからstringでsexもってくる
			String weightS = intent.getStringExtra("weight");// mainからstringでweightもってくる
			int sex = Integer.parseInt(sexS);// stringからintへ
			float weight = Integer.parseInt(weightS);// stringからintへ
			TextView textView = (TextView) findViewById(R.id.textView1);
			TextView textView2 = (TextView) findViewById(R.id.textView2);
			//TextView textView3 = (TextView) findViewById(R.id.textView3);
			if(sex == 1){
				textView.setText("あなたの性別は男性ですね");
			}if(sex == 2){
				textView.setText("あなたの性別は女性ですね");
			}else{
				textView.setText("性別が選択されていません");
			}
			textView2.setText("あなたの体重は" + weight + "kgですね");
			//textView3.setText("今日の気温は" + temp + "℃ですね");
			
			Calendar cal1 = Calendar.getInstance(); // オブジェクトの生成

			int hour = cal1.get(Calendar.HOUR_OF_DAY); // 現在の時を取得
			int minute = cal1.get(Calendar.MINUTE); // 現在の分を取得
			int second = cal1.get(Calendar.SECOND); // 現在の秒を取得
			int firstallsec = (hour * 3600) + (minute * 60) + second;
			TextView textView3 = (TextView) findViewById(R.id.textView3);
			textView3.setText("開始時刻は"+hour+"時"+minute+"分"+second+"秒"+"(" + firstallsec + ")です");
			
			
			


			Button button1 = (Button) findViewById(R.id.button1);
			Button button2 = (Button) findViewById(R.id.button2);

			button1.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					Intent intent = new Intent(MainActivity2.this, com.test.exp.MainActivity.class);//Main2を起こす
					startActivity(intent);
					finish();
				}
			});
			button2.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					finish();
				}
			});
		}

	}


}