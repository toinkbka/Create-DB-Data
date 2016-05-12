package com.example.sql.db;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	private DictionaryEV ev;
	private DictionaryVE ve;
	SQLHelper db;
	String image;
	String sound;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// db.addContextAware(new ContextAware("ToiNK", "23", "Nam", "High",
		// "Medium", "Low", "High", "High", "Low"));

		// SQLHelper db=new SQLHelper(this);
		// db.addDictionaryEV(new DictionaryEV("abandon", "từ bỏ"));

		db = new SQLHelper(getApplicationContext());
		XXX();

	}

	public void XXX() {
		File file1 = new File("/sdcard/Download/en.txt");
		File file2 = new File("/sdcard/Download/vi.txt");
		File file3 = new File("/sdcard/Download/vi2.txt");
		File file4 = new File("/sdcard/Download/en2.txt");
		try {
			FileInputStream fis1 = new FileInputStream(file1);
			FileInputStream fis2 = new FileInputStream(file2);
			FileInputStream fis3 = new FileInputStream(file3);
			FileInputStream fis4 = new FileInputStream(file4);
			InputStreamReader reader1 = new InputStreamReader(fis1);
			InputStreamReader reader2 = new InputStreamReader(fis2);
			InputStreamReader reader3 = new InputStreamReader(fis3);
			InputStreamReader reader4 = new InputStreamReader(fis4);
			BufferedReader bf1 = new BufferedReader(reader1);
			BufferedReader bf2 = new BufferedReader(reader2);
			BufferedReader bf3 = new BufferedReader(reader3);
			BufferedReader bf4 = new BufferedReader(reader4);
			boolean pl = true;
			while (pl) {
				String en = bf1.readLine();
				String vi = bf2.readLine();
				String en2 = bf3.readLine();
				String vi2 = bf4.readLine();
				if (en != null || vi != null) {
//					if (bf1.readLine() == "orange") {
//						image = "images/orange.png";
//						sound = "C:\\Users\\alway\\Desktop\\TD\\orange.wav";
//					}
//					if (bf1.readLine() == "apple") {
//						image = "images/apple.png";
//						sound = "C:\\Users\\alway\\Desktop\\TD\\apple.wav";
//					} else {
						image = "images/upgrade.png";
						sound = "C:"+"\\"+"Users"+"\\"+"alway"+"\\"+"Desktop"+"\\"+"TD"+"\\"+"sr.wav";
//					}
					db.onCreateEV(new DictionaryEV(en, vi), image, sound);
					db.onCreateVE(new DictionaryVE(en2, vi2));
				} else {
					pl = false;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
