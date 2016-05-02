package com.idea.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * ������֤��ѵ����ͼƬ
 * 
 * @author suchang
 * @version idea_s_01
 */
public class DownVerImage {

	/**
	 * ͼƬ���ط���
	 * 
	 * @param url
	 *            �ļ���ַ
	 * @param fileName
	 *            �����ļ���
	 * @param saveAddr
	 *            �����ļ���·��
	 */
	public static void downTrainVerImage(String urlstring, String fileName, String saveAddr) {
		try {
			URL url = new URL(urlstring);
			URLConnection connect=url.openConnection();
			connect.setConnectTimeout(5000);
			
			//������
			InputStream ins=connect.getInputStream();
			//1KB����
			byte[] bt=new byte[1024];
			int len;//��ȡ�����ݳ���
			
			File sf=new File(saveAddr);
			if(!sf.exists()){//������ֵ�ַ�����ڣ������´���
				sf.mkdirs();
			}
			
			//�����
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
	 * ���߳�ʵ��ѵ��ͼƬ����
	 * @param tNum
	 * @param urlstring
	 */
	public static void getVerImageByMultiThread(Thread tNum,String urlstring){
		
	}
}
