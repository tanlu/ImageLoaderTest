package com.gjl.myapp.Beans;

/**
 * Created by Administrator on 2017/12/2 0002.
 */

public class News {
	private String nId;
	private String url;
	private String sum;
	private String sum_content;
	private String url_content;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getSum_content() {
		return sum_content;
	}

	public void setSum_content(String sum_content) {
		this.sum_content = sum_content;
	}

	public String getUrl_content() {
		return url_content;
	}

	public void setUrl_content(String url_content) {
		this.url_content = url_content;
	}

	public News(String nId, String url, String sum, String sum_content, String url_content) {
		this.nId = nId;
		this.url = url;
		this.sum = sum;
		this.sum_content = sum_content;
		this.url_content = url_content;
	}

	public News() {
	}

	public String getnId() {
		return nId;
	}

	public void setnId(String nId) {
		this.nId = nId;
	}

	@Override
	public String toString() {
		return "News{" +
				"nId='" + nId + '\'' +
				", url='" + url + '\'' +
				", sum='" + sum + '\'' +
				", sum_content='" + sum_content + '\'' +
				", url_content='" + url_content + '\'' +
				'}';
	}
}
