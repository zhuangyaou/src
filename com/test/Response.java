package com.test;

import java.io.*;
import java.net.*;
import java.util.Date;


public class Response {
	
	
	String sentences = null;
	File file = null;
	
	
	public Response(Socket socket,String method ,String rout)
	{
		this.createSentences(method, rout);
		
	}
	
	void createSentences(String method,String rout)
	{
		file = new File(rout);
		
		//如果文件不存在
		if(!file.exists())
		{
			File file = new File("Web/NotFound.html");
			
			this.sentences = "HTTP/1.0 404 Not Found\r\n";
			this.sentences +="MIME_version: 1.0\r\n";
			this.sentences +="Connection: close\r\n";
			Date date = new Date();
			this.sentences += "Date: " + date.toString() +"\r\n";
			this.sentences += "Content_Length: " + file.length() +"\r\n";
			this.sentences += "Content_Type: text/html\r\n\r\n";
			
			
		}
		//文件存在
		else
		{
			this.sentences ="HTTP/1.0 200 OK\r\n";
			this.sentences +="MIME_version: 1.0\r\n";
			this.sentences +="Connection: close\r\n";
			Date date = new Date();
			this.sentences += "Date: " + date.toString() +"\r\n";
			this.sentences += "Content_Length: " + this.file.length() +"\r\n";
			
			//判断文件类型
			System.out.println("文件路径：" + rout);
			String extension = rout.substring(rout.lastIndexOf('.') + 1);
			System.out.println("文件类型："+extension);
			
			if(extension.compareToIgnoreCase("html") == 0
					|| extension.compareToIgnoreCase("htm") == 0)
			{
				this.sentences +="Content_Type: " + "text/html\r\n\r\n";
			}
			else if(extension.compareToIgnoreCase("gif")== 0)
			{
				this.sentences +="Content_Type: " + "image/gif\r\n\r\n";
			}
			else if(extension.compareToIgnoreCase("css")==0)
			{
				this.sentences +="Content_Type: " + " text/css\r\n\r\n";
			}
			else if(extension.compareToIgnoreCase("jpg") == 0 ||
					extension.compareToIgnoreCase("jpeg") == 0 ||
					extension.compareToIgnoreCase("jpe")==0)
			{
				this.sentences += "Accept-Encoding: gzip,deflate,sdch\r\n";
				this.sentences +="Content_Type: " + "image/jpeg\r\n";
				this.sentences += "Server: FileServer 1.0\r\n\r\n";
				
				
			}
			else
			{
				
			}
			
			
			
		}
		
		
		
	
		
	}
	
	String getSentences()
	{
		return this.sentences;
	}
	

}
