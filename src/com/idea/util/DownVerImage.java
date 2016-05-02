package com.idea.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 下载验证码训练集图片
 * 
 * @author suchang
 * @version idea_s_01
 */
public class DownVerImage {

	/**
	 * 图片下载方法
	 * 
	 * @param url
	 *            文件地址
	 * @param fileName
	 *            保存文件名
	 * @param saveAddr
	 *            保持文件的路径
	 */
	public static void downTrainVerImage(String urlstring, String fileName, String saveAddr) {
		try {
			URL url = new URL(urlstring);
			URLConnection connect=url.openConnection();
			connect.setConnectTimeout(5000);
			
			//输入流
			InputStream ins=connect.getInputStream();
			//1KB缓存
			byte[] bt=new byte[1024];
			int len;//读取的数据长度
			
			File sf=new File(saveAddr);
			if(!sf.exists()){//如果保持地址不存在，则重新创建
				sf.mkdirs();
			}
			
			//输出流
			OutputStream os=new FileOutputStream(sf.getPath()+"/"+fileName);
			while((len=ins.read(bt))!=-1){
				os.write(bt, 0, len);
			}
			os.close();
			ins.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 多线程实现训练图片下载
	 * @param tNum
	 * @param urlstring
	 */
	public static void getVerImageByMultiThread(Thread tNum,String urlstring){
		
	}
}
