package com.gjl.myapp.app;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;

import com.gjl.myapp.R;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by Administrator on 2017/12/2 0002.
 */

public class MyApp extends Application {
	private Context mContext;
	@Override
	public void onCreate() {
		super.onCreate();
		mContext=this;
		initImageLoader(mContext);
	}

	private void initImageLoader(Context context) {
		File cacheDir = StorageUtils.getOwnCacheDirectory(getApplicationContext(), "imageloader/Cache");
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
        		.threadPoolSize(3) // default
				.threadPriority(Thread.NORM_PRIORITY - 1) // default
				.tasksProcessingOrder(QueueProcessingType.FIFO) // default
				.denyCacheImageMultipleSizesInMemory()
				.memoryCache(new LruMemoryCache(2 * 1024 * 1024))
				.memoryCacheSize(2 * 1024 * 1024)
				.memoryCacheSizePercentage(13) // default
				.diskCache(new UnlimitedDiskCache(cacheDir)) // default
				.diskCacheSize(50 * 1024 * 1024)
				.diskCacheFileCount(100)
				.diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
				.imageDownloader(new BaseImageDownloader(context)) // default
				.defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
				.writeDebugLogs()
				.build();
		ImageLoader.getInstance().init(config);
	}
	//格式设置
	public static DisplayImageOptions options(){
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.ios7_cloud_download_outline) //设置图片在下载期间显示的图片
				.showImageForEmptyUri(R.drawable.flash_off)//设置图片Uri为空或是错误的时候显示的图片
				.showImageOnFail(R.drawable.flash_off)  //设置图片加载/解码过程中错误时候显示的图片
				.cacheInMemory(true)//设置下载的图片是否缓存在内存中
				.cacheOnDisc(true)//设置下载的图片是否缓存在SD卡中
				.considerExifParams(true)  //是否考虑JPEG图像EXIF参数（旋转，翻转）
				.imageScaleType(ImageScaleType.EXACTLY_STRETCHED)//设置图片以如何的编码方式显示
				.bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类型//
				//.delayBeforeLoading(int delayInMillis)//int delayInMillis为你设置的下载前的延迟时间
				//设置图片加入缓存前，对bitmap进行设置
				//.preProcessor(BitmapProcessor preProcessor)
				.resetViewBeforeLoading(true)//设置图片在下载前是否重置，复位
				.displayer(new RoundedBitmapDisplayer(20))//是否设置为圆角，弧度为多少
				.displayer(new FadeInBitmapDisplayer(100))//是否图片加载好后渐入的动画时间
				.build();//构建完成
		return options;
	}
}
