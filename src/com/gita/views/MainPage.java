package com.gita.views;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.gita.fragments.DetailsViewFragment;
import com.gita.fragments.FormPageFragment;
import com.gita.fragments.FormPageFragment.ActivityFragmentListener;

public class MainPage extends FragmentActivity implements ActivityFragmentListener  {

	private static final String TAG = MainPage.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
		
		FormPageFragment formPageFragment = new FormPageFragment();
		FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.content, formPageFragment);
		ft.commit();

	}
	
	@Override
	public void navigationHandler(View v) {
		
		switch (v.getId()) {
		case R.id.nextBTN:
			Log.i(TAG, "Next Button ");
			DetailsViewFragment detailFragment= new DetailsViewFragment();
			getSupportFragmentManager().beginTransaction().replace(R.id.content, detailFragment).commit();
			break;
			
		case R.id.previousButton:
			FormPageFragment formPageFragment = new FormPageFragment();
			getSupportFragmentManager().beginTransaction().replace(R.id.content, formPageFragment).commit();
			break;
			
		default:
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
