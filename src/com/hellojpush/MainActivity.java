package com.hellojpush;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView imageView;
	private Animation loadAnimation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		JPushInterface.setDebugMode(true);
		JPushInterface.init(this);
		
		//…Ë÷√RegistrationID
		JPushInterface.getRegistrationID(this);
		
		//…Ë÷√alias
		JPushInterface.setAlias(this, "ang", new TagAliasCallback() {

			@Override
			public void gotResult(int arg0, String arg1, Set<String> arg2) {

				Log.v("ang", "alias yes or no:" + arg0);
			}
		});
		
		//…Ë÷√tags
		Set<String> set=new HashSet<String>();
		set.add("sports");
		set.add("game");
		JPushInterface.setTags(this, set, new TagAliasCallback() {
			
			@Override
			public void gotResult(int arg0, String arg1, Set<String> arg2) {
				Log.v("ang", "tags yes or no:" + arg0);
				
			}
		});
		
		initView();
	}

	private void initView() {
		imageView = (ImageView) findViewById(R.id.imageView);
		TranslateAnimation translate = new TranslateAnimation(0, 0, -25, 25);
		translate.setDuration(500);
		translate.setRepeatCount(Animation.INFINITE);
		translate.setRepeatMode(Animation.REVERSE);
		imageView.startAnimation(translate);

	}

}
