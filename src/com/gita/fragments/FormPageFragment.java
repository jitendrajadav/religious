package com.gita.fragments;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gita.views.R;
import com.gita.views.SQLiteHelper;

public class FormPageFragment extends Fragment implements OnClickListener {

	public interface ActivityFragmentListener {
		void navigationHandler(View v);
	}

	private static final String TAG = FormPageFragment.class.getSimpleName();

	private ActivityFragmentListener listener;
	private int maxHeight;

	private View view;

	public FormPageFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.form_page_layout, container, false);
		//
		ImageView nextButton = (ImageView) view.findViewById(R.id.nextBTN);
		ImageView saveButton = (ImageView) view.findViewById(R.id.saveBTN);
		//ImageView prevButton = (ImageView) view.findViewById(R.id.previousButton);

		nextButton.setOnClickListener(this);
		saveButton.setOnClickListener(this);
		//prevButton.setOnClickListener(this);
		//

		view.post(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				maxHeight= view.getHeight();
			}
		});

		return view;
	}


	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		listener = (ActivityFragmentListener) getActivity();

		getView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				if(view.getHeight() < maxHeight) {
					view.findViewById(R.id.buttonContainerID).setVisibility(View.GONE);
				} else {
					view.findViewById(R.id.buttonContainerID).setVisibility(View.VISIBLE);
				}
			}
		});

		((EditText) getView().findViewById(R.id.kjvBibleETVID)).setOnEditorActionListener(new TextView.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					//performSearch();
					insertDataIntoDB();
					// Close the keyboard
					InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

					return true;
				}
				return false;
			}
		});
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.saveBTN:
			insertDataIntoDB();
			break;
		case R.id.nextBTN:
			Log.i(TAG, "nextButton => ");
			if(listener != null) {
				listener.navigationHandler(v);
			}
			break;
		case R.id.previousButton:
			//showPreviousView();
			break;
		default:
			break;
		}
	}
	private void insertDataIntoDB() {
		// Get the sqlite database
		SQLiteHelper dbHelper= SQLiteHelper.getInstance(getActivity().getApplicationContext());

		Boolean checkIsNull = checkFieldValueNotEmpty();

		if(checkIsNull)
		{
			ContentValues cv = new ContentValues();  
			cv.put("LineNo", ((EditText) getView().findViewById(R.id.lineNOETVID)).getText().toString());  
			cv.put("Adhyay", ((EditText) getView().findViewById(R.id.adhyayETVID)).getText().toString());
			cv.put("ShlokNo", ((EditText) getView().findViewById(R.id.shlokNOTVID)).getText().toString());
			cv.put("Shlok", ((EditText) getView().findViewById(R.id.shlokTVID)).getText().toString());
			cv.put("MBVersion", ((EditText) getView().findViewById(R.id.mbVersionETID)).getText().toString());
			cv.put("Comment", ((EditText) getView().findViewById(R.id.commentETVID)).getText().toString());
			cv.put("QURAN", ((EditText) getView().findViewById(R.id.theQuranETVID)).getText().toString()); 
			cv.put("KJVBilbe", ((EditText) getView().findViewById(R.id.kjvBibleETVID)).getText().toString());
			long isSucess = dbHelper.insertData(cv);
			if(isSucess != -1)
			{
				clearFiledValue();
				Toast.makeText(getActivity(), "Record inserted successfully...!", Toast.LENGTH_LONG).show();
			}
			else
			{
				Toast.makeText(getActivity(), "Oops something went wrong please try again..!", Toast.LENGTH_LONG).show();
			}
		}
		else
		{

			AlertDialog alertDialog= new AlertDialog.Builder(getActivity()).create();
			alertDialog.setTitle("Alert");
			alertDialog.setMessage("Please fill all the field.!");
			alertDialog.show();
			alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
					new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
		}
	}

	private Boolean checkFieldValueNotEmpty() {
		// TODO Auto-generated method stub

		if(!TextUtils.isEmpty(((EditText) getView().findViewById(R.id.lineNOETVID)).getText().toString()) && 
				!TextUtils.isEmpty(((EditText) getView().findViewById(R.id.adhyayETVID)).getText().toString()) &&
				!TextUtils.isEmpty(((EditText) getView().findViewById(R.id.shlokNOTVID)).getText().toString()) &&
				!TextUtils.isEmpty(((EditText) getView().findViewById(R.id.shlokTVID)).getText().toString()) &&
				!TextUtils.isEmpty(((EditText) getView().findViewById(R.id.mbVersionETID)).getText().toString()) &&
				!TextUtils.isEmpty(((EditText) getView().findViewById(R.id.commentETVID)).getText().toString()) &&
				!TextUtils.isEmpty(((EditText) getView().findViewById(R.id.theQuranETVID)).getText().toString()) &&
				!TextUtils.isEmpty(((EditText) getView().findViewById(R.id.kjvBibleETVID)).getText().toString()))
		{
			return true;
		}
		else
			return false;
	}

	private void clearFiledValue()
	{
		// TODO Auto-generated method stub
		((EditText) getView().findViewById(R.id.lineNOETVID)).setText("");
		((EditText) getView().findViewById(R.id.adhyayETVID)).setText("");
		((EditText) getView().findViewById(R.id.shlokNOTVID)).setText("");
		((EditText) getView().findViewById(R.id.shlokTVID)).setText("");
		((EditText) getView().findViewById(R.id.mbVersionETID)).setText("");
		((EditText) getView().findViewById(R.id.commentETVID)).setText("");
		((EditText) getView().findViewById(R.id.theQuranETVID)).setText("");
		((EditText) getView().findViewById(R.id.kjvBibleETVID)).setText("");
	}
}
