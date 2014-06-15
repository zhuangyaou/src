package com.test;

import java.io.*;
import java.net.*;

public class ServerThread implements Runnable{
	
	//socket,reader,writer
	Socket socket = null;
	
	
	//sendThread and receiveThread
	ReceiveThread receiveThread = null;
	
	SendThread sendThread = null;
	
	
	//init method
	public ServerThread(Socket socket) throws IOException
	{
		this.socket = socket;
		/**
		 * print the imformation of the client
		 * */
		System.out.println();
		System.out.println("ServerThread start");
		
		//启动接收线程
		this.receiveThread = new ReceiveThread(this.socket);
			
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		/**
		 * start the receiveThread
		 * */
		try {
			
		
			this.receiveThread.receive();
			
			//启动发送线程
			System.out.println("\n******发送线程******");
			//发送response
			this.sendThread = new SendThread(this.socket
					,this.receiveThread.getRequest());
			this.sendThread.send();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally
		{
			try {
				this.socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
