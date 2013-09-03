package com.test.exp;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity {

	private RadioGroup radioGroup1;
	private RadioButton radioButton1, radioButton2;
	protected int sex = 0;
	protected int weight10 = 1;
	protected int weight1 = 1;
	protected int weight0 = 1;
	protected float weight = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);// activity_mainレイアウトを使います
		Button button1 = (Button) findViewById(R.id.button1);// startbuttonをbutton1にセット
		Button button2 = (Button) findViewById(R.id.button2);// endbuttonをbutton2にセット

		radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
		radioGroup1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int id) {
				radioButton1 = (RadioButton) findViewById(R.id.radio0);
				radioButton2 = (RadioButton) findViewById(R.id.radio1);
				if (radioButton1.isChecked() == true) {
					sex = 1;
				} else if (radioButton2.isChecked() == true) {
					sex = 2;
				} else {
					sex = 0;
				}
			}
		});
		final NumberPicker np10 = (NumberPicker) findViewById(R.id.numberPicker1);
		// 最大値設定
		np10.setMaxValue(9);
		// 最小値設定
		np10.setMinValue(0);
		final NumberPicker np1 = (NumberPicker) findViewById(R.id.numberPicker2);
		// 最大値設定
		np1.setMaxValue(9);
		// 最小値設定
		np1.setMinValue(0);
		final NumberPicker np0 = (NumberPicker) findViewById(R.id.numberPicker3);
		// 最大値設定
		np0.setMaxValue(9);
		// 最小値設定
		np0.setMinValue(0);

		button1.setOnClickListener(// button1が押されたら
		new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				setContentView(R.layout.kakunin);

				TextView textView = (TextView) findViewById(R.id.textView1);
				TextView textView2 = (TextView) findViewById(R.id.textView2);
				if (sex == 1) {
					textView.setText("あなたの性別は男性ですね");
				}else if (sex == 2) {
					textView.setText("あなたの性別は女性ですね");
				} else {
					textView.setText("性別が選択されていません");
				}

				weight10 = np10.getValue();
				weight1 = np1.getValue();
				weight0 = np0.getValue();
				weight = (float) ((weight10 * 10) + weight1 + (weight0 * 0.1));
				textView2.setText("あなたの体重は" + weight + "kgですね");
				// textView3.setText("今日の気温は" + temp + "℃ですね");

				Calendar cal1 = Calendar.getInstance(); // オブジェクトの生成

				int hour = cal1.get(Calendar.HOUR_OF_DAY); // 現在の時を取得
				int minute = cal1.get(Calendar.MINUTE); // 現在の分を取得
				int second = cal1.get(Calendar.SECOND); // 現在の秒を取得
				int firstallsec = (hour * 3600) + (minute * 60) + second;
				TextView textView3 = (TextView) findViewById(R.id.textView3);
				textView3.setText("開始時刻は" + hour + "時" + minute + "分" + second
						+ "秒" + "(" + firstallsec + ")です");

				Button button1 = (Button) findViewById(R.id.button1);
				Button button2 = (Button) findViewById(R.id.button2);

				button1.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {

						setContentView(R.layout.main);
						
						ImageButton toilet = (ImageButton) findViewById(R.id.imageButton1);
						ImageButton drink = (ImageButton) findViewById(R.id.imageButton2);

						toilet.setOnClickListener(new View.OnClickListener() {
							public void onClick(View v) {
								finish();
							}
						});
						drink.setOnClickListener(new View.OnClickListener() {
							public void onClick(View v) {
								finish();
							}
						});

					}
				});
				button2.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								com.test.exp.MainActivity.class);// Main2を起こす
						startActivity(intent);
						finish();
					}
				});
			}
		});
		button2.setOnClickListener(// button2が押されたら
		new View.OnClickListener() {
			public void onClick(View v) {
				finish();// Mainを閉じる
			}
		});
	}

}
