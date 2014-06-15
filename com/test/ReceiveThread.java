package com.test;


import java.io.*;
import java.net.*;

public class ReceiveThread{

	 Socket socket = null;
	 BufferedReader reader = null;
	 Request request = null;
	 String sentences = null;
	 SendThread sendThread = null;
	 
	 public ReceiveThread(Socket socket) throws IOException
	 {
		 this.socket = socket;
		 
		 this.reader = new BufferedReader
		 (new InputStreamReader(this.socket.getInputStream()));
		 
		 
	 }

	
	
	//receive method
	void receive() throws IOException
	{
		
			sentences = "";
			  		
			String temp = null;
			
			while(true)
			{
			
					temp = this.reader.readLine();
					
					//当输入流响应时（阻塞终止），但是还没有传输数据时，重新进入循环读数据！！！
					if(temp == null)
						continue;
					
					//根据http协议每个request后都有一个回车键,判断request结尾
					if(temp.length() < 1)
					{
						
						
						//解码：
						/**
						 * 中文解码
						 * */
						this.sentences = URLDecoder.decode(this.sentences, "UTF-8");
						
						System.out.println("********Request:*******\n" + this.sentences);
						//进行传送response
						this.request = new Request(this.sentences);
						//接受完数据，跳出receive
						
						break;
						
					
					}
					else
					{
						this.sentences += temp + "\n";
					}
					
			
				
				
			}
				
		
		}
		
		
		
	
	 
	 Request getRequest()
	 {
		 return this.request;
	 }
	 
	 
}
