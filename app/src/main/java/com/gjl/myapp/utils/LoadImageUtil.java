package com.gjl.myapp.utils;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.gjl.myapp.R;
import com.gjl.myapp.app.MyApp;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by Administrator on 2017/12/2 0002.
 */

public class LoadImageUtil {
	private static final String TAG = "LoadImageUtil";
	//使用ImageLoader加载图片的方法
	public static void loadImgeByImageLoader(final String url, final ImageView imageView){
		ImageLoader.getInstance().displayImage(url, imageView, MyApp.options(),new ImageLoadingListener() {
			@Override
			public void onLoadingStarted(String imageUri, View view) {
				Log.d(TAG, "onLoadingStarted() returned: " + "开始.....");
//				imageView.setImageResource(R.drawable.ios7_cloud_download_outline);
			}

			@Override
			public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
				Log.d(TAG, "onLoadingStarted() returned: " + "失败.....");
//				imageView.setImageResource(R.drawable.ios7_cloud_download_outline);
			}

			@Override
			public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

				Log.d(TAG, "onLoadingStarted() returned: " + "完成.....");

				if (url.equals(imageView.getTag())){
					imageView.setImageBitmap(loadedImage);
				}

			}

			@Override
			public void onLoadingCancelled(String imageUri, View view) {
				Log.d(TAG, "onLoadingStarted() returned: " + "取消.....");
			}
		});
	}
}
