package com.test;


import java.io.*;
import java.net.*;

public class SendThread {

	Socket socket = null;
	Response response = null;
	//BufferedWriter writer = null;
	OutputStream out = null;
	PrintStream writer = null;
	
	File file = null;
	
	public SendThread(Socket socket,Request request)
	{
		this.socket = socket;
		try {
			this.out = new BufferedOutputStream(this.socket.getOutputStream());
			this.writer = new PrintStream(this.out);
			//this.writer = new BufferedWriter(
					//new OutputStreamWriter(this.socket.getOutputStream()));
			this.response = new Response(this.socket,request.method,request.rout);		
			this.file = new File(request.rout);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	void send()
	{
		try {
			System.out.print("Response:\n" + this.response.getSentences());
			this.writer.print(this.response.getSentences());
			//this.writer.write(this.response.getSentences());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//传送文件
		if(this.file.exists())
		{
			this.sendFile(this.file);
		}
		else
		{
			this.sendFile(new File("Web/NotFound.html"));
		}
				
	
	}
	
	void sendFile(File file)
	{
		
		try {
			InputStream reader = new FileInputStream(file);		
			
			byte[] buff = new byte[1024];
		
			while(reader.available() > 0)
			{
				this.out.write(buff, 0, reader.read(buff));
			}	
			
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			this.writer.flush();
			System.out.println("加载完成！");
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}


}
