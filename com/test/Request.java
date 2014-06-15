package com.test;

public class Request {
	String sentences = null;//请求报文
	String method = null;//请求方法
	String rout = null;//请求页面路径
	String exter = "Web";//服务器网页文件
	
	public Request(String sentences)
	{
		
		this.sentences = sentences;
		
		//分解request
		String[] command = null;
		command = sentences.split("\n");
	
		//分解第一行,我们暂时只适用第一行
		String[] firstSentence = null;
		firstSentence = command[0].split(" ");

		
		//得到request中的method and rout
		this.setMethod(firstSentence);
		this.setRout(firstSentence);

	}
	
	//set the method of the request
	void setMethod(String[] command)
	{
		this.method = command[0];
	}
	
	//set the rout of the file
	void setRout(String[] command)
	{
		/**
		 * 设置路径@@
		 * 
		 * */
		//如果是“”
		String str = command[1].substring(1);
		if(str.equals(""))
		{
			this.rout = this.exter + "/hello.html";
			
		}
		else
		{
			this.rout = this.exter + "/" + str;
			
		}
		
		
	}
	

}
