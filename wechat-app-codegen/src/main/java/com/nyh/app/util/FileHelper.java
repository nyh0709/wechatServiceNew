package com.nyh.app.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class FileHelper {
	
	public static String readFile(String fileName,String charset) {
		try {
			File file = new File(fileName);
			
			StringBuffer sb = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName), charset));
			String str;
			while ((str = in.readLine()) != null) {
				sb.append(str + "\r\n");
			}
			in.close();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static String getCharset(File file) {
		String charset = "GBK";
		byte[] first3Bytes = new byte[3];
		try {
			boolean checked = false;
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(file));
			bis.mark(0);
			int read = bis.read(first3Bytes, 0, 3);
			if (read == -1)
				return charset;
			if (first3Bytes[0] == (byte) 0xFF && first3Bytes[1] == (byte) 0xFE) {
				charset = "UTF-16LE";
				checked = true;
			} else if (first3Bytes[0] == (byte) 0xFE
					&& first3Bytes[1] == (byte) 0xFF) {
				charset = "UTF-16BE";
				checked = true;
			} else if (first3Bytes[0] == (byte) 0xEF
					&& first3Bytes[1] == (byte) 0xBB
					&& first3Bytes[2] == (byte) 0xBF) {
				charset = "UTF-8";
				checked = true;
			}
			bis.reset();

			if (!checked) {
				int loc = 0;
				while ((read = bis.read()) != -1) {
					loc++;
					if (read >= 0xF0)
						break;
					if (0x80 <= read && read <= 0xBF)
						break;
					if (0xC0 <= read && read <= 0xDF) {
						read = bis.read();
						if (0x80 <= read && read <= 0xBF)
							continue;
						else
							break;
					} else if (0xE0 <= read && read <= 0xEF) {
						read = bis.read();
						if (0x80 <= read && read <= 0xBF) {
							read = bis.read();
							if (0x80 <= read && read <= 0xBF) {
								charset = "UTF-8";
								break;
							} else
								break;
						} else
							break;
					}
				}

			}
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return charset;
	}
	
	
	public static void backupFile(String filePath) {
		
		File file=new File(filePath);
		if(file.exists())
		{
			String path=filePath +".001";
			File tmp=new File(path);
			int i=1;
			
			while(tmp.exists())
			{
				i++;
				int len=3- String.valueOf(i).length();
				String ext=String.valueOf(i);
				for(int k=0;k<len;k++){
					ext="0" +ext;
				}
				path=filePath+"." + ext;
				tmp=new File(path);
			}
			copyFile(filePath, path);
		}
		
		
	}
	
	public static void writeFile(File file,String charset,String content) throws IOException
	{
		Writer writer = new OutputStreamWriter(new FileOutputStream(file), charset);
		writer.write(content);
		writer.close();
	}
	
	public static void main(String[] args)
	{
		 String insert="<!--insert-->";
		 String str="aa<!--insert-->bb<!--insert-->cc";
		 int pos=str.lastIndexOf(insert);
		 System.out.println(str.substring(0,pos));
		 System.out.println(str.substring(pos+insert.length()));
	}
	
	public  static String[] getBySplit(String content,String splitTag)
	{
		String[] aryRtn=new String[2];
		int pos=content.lastIndexOf(splitTag);
		aryRtn[0]=content.substring(0,pos);
		aryRtn[1]=content.substring(pos+splitTag.length());
		return aryRtn;
	}
	
	public static boolean copyFile(String from, String to) {
		File fromFile = new File(from);
		File toFile = new File(to);
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(fromFile);
			fos = new FileOutputStream(toFile);
			int bytesRead;
			byte[] buf = new byte[4 * 1024]; // 4K buffer
			while ((bytesRead = fis.read(buf)) != -1) {
				fos.write(buf, 0, bytesRead);
			}
			fos.flush();
			fos.close();
			fis.close();
		} catch (IOException e) {
			System.out.println(e);
			return false;
		}
		return true;

	}
	
	public static boolean isExistFile(String dir){
		boolean isExist=false;
		File fileDir=new File(dir);
		if(fileDir.isDirectory()){
			File[] files=fileDir.listFiles();
			if(files!=null&&files.length!=0){
				isExist=true;
			}
		}
		return isExist;
	}
	
	public static File[] getFiles(String path) {
		File file = new File(path);
		return file.listFiles();
	}
	
	
	public static InputStream getInputStream(String filepath){
		File file=new File(filepath);
		String charset=getCharset(file);
		String str=readFile(filepath, charset);
		ByteArrayInputStream stream =null;
		try {
			stream = new ByteArrayInputStream(str.getBytes(charset));
		} catch (UnsupportedEncodingException e) {
		    e.printStackTrace();
		}
		 return stream;
	}

}
