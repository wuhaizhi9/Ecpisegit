package com.mr.service;
/**
 * ˢ��֡�߳�
 * 
 * 
 * */

import java.awt.Container;

import com.mr.view.GamePanel;
import com.mr.view.MainFrame;
import com.mr.view.ScoreDialog;

public class FreshThread  extends Thread{
	public static final int FREASH = 20;//ˢ��ʱ��
	GamePanel p ;//��Ϸ���
	
	public FreshThread(GamePanel p) {
		this.p = p;
	}
	
	public void run() {
		while (!p.isFinish()) {
			p.repaint(); //�ػ���Ϸ���
			try {
				Thread.sleep(FREASH); //����ˢ��ʱ������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Container c = p.getParent();//��ȡ��常����
		while (!(c instanceof MainFrame) ) {
			c= c.getParent(); //�����̳и������ĸ�����
			
		}
		MainFrame frame = (MainFrame)c;//������ǿ��ת��Ϊ��������
		new ScoreDialog(frame); //�����÷ּ�¼�Ի���
		frame.restart();//���������ؿ�ʼ��Ϸ
	}

}
