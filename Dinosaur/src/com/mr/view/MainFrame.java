package com.mr.view;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.mr.service.ScoreRecorder;
import com.mr.service.Sound;


/**
 * ������
 * 
 * */

public class MainFrame  extends JFrame{
   public MainFrame() {
	    restart(); //��ʼ
	   setBounds(340, 150, 821, 260); //���ú�������Ϳ��
	   setTitle("���ܰɣ�С����������"); //����
	   Sound.backgroud();//���ű�������
	   ScoreRecorder.init();//��ȡ�÷ּ�¼
	   addListener(); //��Ӽ���
	   setDefaultCloseOperation(EXIT_ON_CLOSE); 
   }
 /**
  * ���¿�ʼ
  * 
  */
 public void restart() {
	 Container c =getContentPane(); //��ȡ����������
	 c.removeAll(); //ɾ�������и����������
	 GamePanel panel=new GamePanel(); //�����µ���Ϸ���
	 c.add(panel);
	 addKeyListener(panel); //��Ӽ����¼�
	 c.validate(); //����������֤�������
 }
 
 /**
  * ��Ӽ���
  * 
  * 
  * */
  private void addListener() {
	  addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			ScoreRecorder.saveScore(); //����ȷ�
			
		}
	});
	  
	  
  }
} 
