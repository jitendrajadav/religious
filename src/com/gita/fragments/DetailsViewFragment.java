package com.gita.fragments;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.gita.fragments.FormPageFragment.ActivityFragmentListener;
import com.gita.views.CustomAdapter;
import com.gita.views.R;
import com.gita.views.SQLiteHelper;
import com.gita.views.Todo;

public class DetailsViewFragment extends Fragment implements OnClickListener {

	private static final String TAG = DetailsViewFragment.class.getSimpleName();
	private ActivityFragmentListener listener;
	private ListView listView;
	
	public DetailsViewFragment() {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view= inflater.inflate(R.layout.record_view_layout, container, false);
		listView = (ListView) view.findViewById(R.id.listview);
		ImageView prevButton = (ImageView) view.findViewById(R.id.previousButton);
		
		prevButton.setOnClickListener(this);
		
		return view;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		listener= (ActivityFragmentListener) getActivity();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		SQLiteHelper dbHelper= SQLiteHelper.getInstance(getActivity().getApplicationContext());
		ArrayList<Todo> todoList =  dbHelper.getData();
		Log.i(TAG, "todoList => " + todoList.size());
		
		listView.setAdapter(new CustomAdapter(getActivity(), todoList));
	}
	
	@Override
	public void onClick(View v) {
		
		if(listener != null) {
			listener.navigationHandler(v);
		}
		
	}
}
