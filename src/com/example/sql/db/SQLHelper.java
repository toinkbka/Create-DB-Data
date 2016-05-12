package com.example.sql.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaPlayer;
import android.widget.ImageView;

public class SQLHelper extends SQLiteOpenHelper {
	// data version, name
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "dictionary";

	// table name
	private static final String TABLE_EV = "WORD";
	private static final String TABLE_VE = "NHAPTU";

	// common column
	private static final String KEY_ID = "id";

	// word table- column names
	private static final String KEY_ENGLISH_WORD = "Word";
	private static final String KEY_VIETNAM_MEAN = "Translate";
	private static final String KEY_IMAGE = "Image";
	private static final String KEY_SOUND = "Sound";

	// nhap tu table- column names
	private static final String KEY_VIETNAM_WORD = "Tu";
	private static final String KEY_ENGLISH_MEAN = "Nghia";

	private static final String CREATE_TABLE_EV = "CREATE TABLE " + TABLE_EV
			+ "(" + KEY_ENGLISH_WORD + " TEXT," + KEY_VIETNAM_MEAN + " TEXT,"
			+ KEY_IMAGE + " TEXT," + KEY_SOUND + " TEXT" + ")";

	private static final String CREATE_TABLE_VE = "CREATE TABLE " + TABLE_VE
			+ "(" + KEY_VIETNAM_WORD + " TEXT," + KEY_ENGLISH_MEAN + " TEXT,"
			+ KEY_IMAGE + " TEXT," + KEY_SOUND + " TEXT" + ")";

	public SQLHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_EV);
		db.execSQL(CREATE_TABLE_VE);

	}

	public void onCreateEV(DictionaryEV ev, String image, String sound) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_ENGLISH_WORD, ev.getEnglish_word());
		values.put(KEY_VIETNAM_MEAN, ev.getVietnam_word());
		values.put(KEY_IMAGE, image);
		values.put(KEY_SOUND, sound);
		db.insert(TABLE_EV, null, values);
		db.close();
	}

	public void onCreateVE(DictionaryVE ve) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_VIETNAM_WORD, ve.getVietnam_word());
		values.put(KEY_ENGLISH_MEAN, ve.getEnglish_word());
		// values.put(KEY_IMAGE, image);
		// values.put(KEY_SOUND, sound);
		db.insert(TABLE_VE, null, values);
		db.close();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_EV);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_VE);
		onCreate(db);
	}

}
