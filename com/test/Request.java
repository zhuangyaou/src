package com.test;

public class Request {
	String sentences = null;//������
	String method = null;//���󷽷�
	String rout = null;//����ҳ��·��
	String exter = "Web";//��������ҳ�ļ�
	
	public Request(String sentences)
	{
		
		this.sentences = sentences;
		
		//�ֽ�request
		String[] command = null;
		command = sentences.split("\n");
	
		//�ֽ��һ��,������ʱֻ���õ�һ��
		String[] firstSentence = null;
		firstSentence = command[0].split(" ");

		
		//�õ�request�е�method and rout
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
		 * ����·��@@
		 * 
		 * */
		//����ǡ���
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
