package com.gjl.myapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.ListView;

import com.gjl.myapp.Beans.News;
import com.gjl.myapp.adapter.MyAdapter1;
import com.gjl.myapp.utils.HttpUtil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/28 0028.
 */

public class MainActivity extends AppCompatActivity{
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		ListView listView = (ListView) findViewById(R.id.lv_main);
		ArrayList<News>list = initData();//模拟数据
		MyAdapter1 myAdapter1 = new MyAdapter1(MainActivity.this, R.layout.item_llistview, list);
		listView.setAdapter(myAdapter1);
	}

	private ArrayList<News> initData() {
		ArrayList<News> list = new ArrayList<>();
		for (int i = 0;i<5;i++){
			for (int j = 0; j< HttpUtil.urls.length; j++){
				News news = new News();
				news.setnId(i+j+"");
				news.setUrl(HttpUtil.urls[j]);
				news.setSum("新闻"+i+j);
				news.setSum_content("新闻内容----------"+i+j);
				news.setUrl_content(HttpUtil.urls[j]);
				list.add(news);
			}
		}
		return list;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.mymenu,menu);
		return true;
	}
}
