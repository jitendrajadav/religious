package com.gita.views;

import java.util.ArrayList;

import com.gita.fragments.DetailsViewFragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

	private static final String TAG = CustomAdapter.class.getSimpleName();;
	private Context context;
	private ArrayList<Todo> dataList;

	public CustomAdapter(Context _context, ArrayList<Todo> _dataList) {
		// TODO Auto-generated constructor stub
		this.context= _context;
		this.dataList= _dataList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dataList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return dataList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView= inflater.inflate(R.layout.list_row, parent, false);
		}

		TextView lineNoTV= (TextView) convertView.findViewById(R.id.lineNoID);
		TextView adhyayTV= (TextView) convertView.findViewById(R.id.adhyayID);
		TextView shlokNoTV= (TextView) convertView.findViewById(R.id.shlokNoID);
		TextView shlokTV= (TextView) convertView.findViewById(R.id.shlokID);
		TextView mbVersionTV= (TextView) convertView.findViewById(R.id.mbVersionID);
		TextView commentTV= (TextView) convertView.findViewById(R.id.commentID);
		TextView quranTV= (TextView) convertView.findViewById(R.id.quranID);
		TextView kjvBilbeTV= (TextView) convertView.findViewById(R.id.kjvBilbeID);

		lineNoTV.setText(""+dataList.get(position).getLineNo());
		adhyayTV.setText(dataList.get(position).getAdhyay());
		shlokNoTV.setText(""+dataList.get(position).getShlokNo());
		shlokTV.setText(dataList.get(position).getShlok());
		mbVersionTV.setText(dataList.get(position).getMBVersion());
		commentTV.setText(dataList.get(position).getComment());
		quranTV.setText(dataList.get(position).getQuran());
		kjvBilbeTV.setText(dataList.get(position).getKJVBilbe());
		
		return convertView;
	}

}
