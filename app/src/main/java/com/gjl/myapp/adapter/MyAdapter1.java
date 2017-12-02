package com.gjl.myapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gjl.myapp.Beans.News;
import com.gjl.myapp.R;
import com.gjl.myapp.utils.LoadImageUtil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/12/2 0002.
 */

public class MyAdapter1 extends BaseAdapter {
	private static final String TAG = "MyAdapter1";
	private  ArrayList<News> list=null;
	private LayoutInflater inflater;
	private int layout;
	public MyAdapter1(){}
	public MyAdapter1(Context context,int layout, ArrayList<News> list){
		this.list = list;
		inflater=LayoutInflater.from(context);
		this.layout = layout;
	}
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder mViewHoder=null;
		if (convertView==null){
			convertView = inflater.inflate(layout,null);
			ImageView icon = convertView.findViewById(R.id.item_icon);//左侧图片
			TextView sum = convertView.findViewById(R.id.sum);//简介
			TextView sum_content = convertView.findViewById(R.id.sum_content);
			TextView center = convertView.findViewById(R.id.center);
			mViewHoder = new ViewHolder(icon,sum,sum_content,center);
			convertView.setTag(mViewHoder);
		}

		else {
			mViewHoder = (ViewHolder) convertView.getTag();
		}

		//取出
		ImageView imageView = mViewHoder.getvImageView();
		imageView.setTag(list.get(position).getUrl());
		TextView tv_sum = mViewHoder.getTv_sum();
		TextView tv_sum_content = mViewHoder.getTv_sum_content();
		TextView center = mViewHoder.getCenter();
		LoadImageUtil.loadImgeByImageLoader(list.get(position).getUrl(),imageView);
		tv_sum.setText(list.get(position).getSum());
		tv_sum_content.setText(list.get(position).getSum_content());
		center.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "onClick() returned: " + "进入"+list.get(position).getUrl_content());
			}
		});
		return convertView;
	}
	/**ViewHolder**/
	class ViewHolder{
		private ImageView vImageView;
		private TextView tv_sum;
		private TextView tv_sum_content;
		private TextView center;

		public ViewHolder(ImageView vImageView, TextView tv_sum, TextView tv_sum_content, TextView center) {
			this.vImageView = vImageView;
			this.tv_sum = tv_sum;
			this.tv_sum_content = tv_sum_content;
			this.center = center;
		}

		public ImageView getvImageView() {
			return vImageView;
		}

		public void setvImageView(ImageView vImageView) {
			this.vImageView = vImageView;
		}

		public TextView getTv_sum() {
			return tv_sum;
		}

		public void setTv_sum(TextView tv_sum) {
			this.tv_sum = tv_sum;
		}

		public TextView getTv_sum_content() {
			return tv_sum_content;
		}

		public void setTv_sum_content(TextView tv_sum_content) {
			this.tv_sum_content = tv_sum_content;
		}

		public TextView getCenter() {
			return center;
		}

		public void setCenter(TextView center) {
			this.center = center;
		}

		@Override
		public String toString() {
			return "ViewHolder{" +
					"vImageView=" + vImageView +
					", tv_sum=" + tv_sum +
					", tv_sum_content=" + tv_sum_content +
					", center=" + center +
					'}';
		}
	}
}
