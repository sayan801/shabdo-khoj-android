package com.example.technicise.shabdo_khoj.swipehelpercalasses;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.technicise.shabdo_khoj.R;

public class ListAdapter extends BaseAdapter
{
	private Activity activity;
	private ArrayList<dumpclass> data;
	public ListAdapter(Activity a, ArrayList<dumpclass> basicList)
    {
		activity	=	a;
		data		=	basicList;
	}

	@Override
	public int getCount()
    {
		return data.size();
	}

	@Override
	public Object getItem(int position)
    {
		return data.get(position);
	}

	@Override
	public long getItemId(int position)
    {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
    {
		ViewHolder holder;
        if(convertView == null)
        {
         holder				=	new ViewHolder();
		 convertView		=	LayoutInflater.from(activity).inflate(R.layout.test_layout, null);
		 holder.fileNameTextView		=	(TextView) convertView.findViewById(R.id.fileNameTextView);
		 holder.filePathTextView		=	(TextView) convertView.findViewById(R.id.filePathTextView);
		 holder.swipeIndicatorImage		=	(ImageView) convertView.findViewById(R.id.swipeIndicatorImage);
		 convertView.setTag(holder);
        }
        else
        holder			=	(ViewHolder) convertView.getTag();
        holder.fileNameTextView.setText(data.get(position).filename);
        holder.filePathTextView.setText(data.get(position).filePath);
        //holder.text.setText(data.get(position).sampletext);

        return convertView;
	}

	
	public static class ViewHolder
    {
		TextView fileNameTextView;
		TextView filePathTextView;
		ImageView swipeIndicatorImage;
		
	}
}
