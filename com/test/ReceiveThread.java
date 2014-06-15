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
					
					//����������Ӧʱ��������ֹ�������ǻ�û�д�������ʱ�����½���ѭ�������ݣ�����
					if(temp == null)
						continue;
					
					//����httpЭ��ÿ��request����һ���س���,�ж�request��β
					if(temp.length() < 1)
					{
						
						
						//���룺
						/**
						 * ���Ľ���
						 * */
						this.sentences = URLDecoder.decode(this.sentences, "UTF-8");
						
						System.out.println("********Request:*******\n" + this.sentences);
						//���д���response
						this.request = new Request(this.sentences);
						//���������ݣ�����receive
						
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
