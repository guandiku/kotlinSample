package com.xiamen.www.myapplication3.kotlin.optimize.splash;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ProgressBar;

import com.xiamen.www.myapplication3.R;

import java.lang.ref.WeakReference;

public class MainActivity extends FragmentActivity {
	private Handler mHandler = new Handler();
	private ProgressBar mProgressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_splash);
		mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);

		final SplashFragment splashFragment = new SplashFragment();
		final FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.frame, splashFragment);
		transaction.commit();
		
//		mHandler.postDelayed(new DelayRunnable(this, splashFragment,
//				mProgressBar), 2500);
//		 getWindow().getDecorView().post(new Runnable() {
//	            @Override
//	            public void run() {
//	                mHandler.postDelayed(new DelayRunnable(MainActivity.this, splashFragment,
//	        				mProgressBar), 2500);
//	            }
//	        });

	}

	 class DelayRunnable implements Runnable {
		private WeakReference<Context> contextRef;
		private WeakReference<SplashFragment> fragmentRef;
		private WeakReference<ProgressBar> progressBarRef;

		public DelayRunnable(Context context, SplashFragment splashFragment,
                             ProgressBar progressBar) {
			contextRef = new WeakReference<Context>(context);
			fragmentRef = new WeakReference<SplashFragment>(splashFragment);
			progressBarRef = new WeakReference<ProgressBar>(progressBar);
		}

		@Override
		public void run() {
			ProgressBar progressBar = progressBarRef.get();
			if (progressBar != null)
				progressBar.setVisibility(View.GONE);
			FragmentActivity context = (FragmentActivity) contextRef.get();
			if (context != null) {
				SplashFragment splashFragment = fragmentRef.get();
				if (splashFragment == null)
					return;
				final FragmentTransaction transaction = context.getSupportFragmentManager().beginTransaction();
				transaction.remove(splashFragment);
				transaction.commit();
			}
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mHandler.removeCallbacksAndMessages(null);
	}

}
