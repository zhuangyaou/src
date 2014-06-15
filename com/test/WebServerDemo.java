package com.test;

import java.io.*;
import java.net.*;

public class WebServerDemo {
	
	public static void main(String[] args)
	{
		
			
			//a welcome socket
			ServerSocket welcomeSocket = null;
			
			try {
				welcomeSocket = new ServerSocket(6767);
				System.out.println("Web Server is start!");
				System.out.println("Work port:6767");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//nopersistant receive request
			while(true)
			{
				//gain the socket once the client connectting the server
				Socket socket;
				try {
					socket = welcomeSocket.accept();
					System.out.println(socket.getInetAddress() + " connected!");
					//create a thread with the socket
					Thread thread = new Thread(new ServerThread(socket));
					thread.start();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();			
				}
				
				
				
			}
			
		
	
		
		
		
	}

}
