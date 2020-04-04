package com.mr.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.mr.service.ScoreRecorder;

/**
 * 
 * �ɼ��Ի���
 * 
 * 
 * */ 

public class ScoreDialog extends JDialog {
	/*
	 * ���췽��
	 *  frame ������
	 * 
	 * */
	
	public ScoreDialog(JFrame frame) {
		super(frame,true); //���ø��๹�췽��������������
		int scores[] =ScoreRecorder.getScores(); //��ȡ��ǰǰ�����ɼ�
		JPanel scoreP = new JPanel(new GridLayout(4,1));//�ɼ���壬����һ��
		scoreP.setBackground(Color.WHITE) ; //��ɫ����
		JLabel title = new JLabel("�÷����а�",JLabel.CENTER);//�����ǩ������
		title.setFont(new Font("����",Font.BOLD,20));//��������
		title.setForeground(Color.RED);//��ɫ����
		JLabel first = new JLabel("��һ��"+scores[2],JLabel.CENTER); //��һ����ǩ
		JLabel second = new JLabel("�ڶ���"+scores[1],JLabel.CENTER); //�ڶ�����ǩ
		JLabel third = new JLabel("������"+scores[0],JLabel.CENTER); //��������ǩ
		JButton restart = new JButton("���¿�ʼ");//���¿�ʼ��ť
		restart.addActionListener(new ActionListener() {//��ť�¼�����
			@Override
			public void actionPerformed(ActionEvent e) {//�����ʱ
				dispose(); //���ٶԻ���
			}
		});
      scoreP.add(title); //�ɼ������ӱ�ǩ				
      scoreP.add(first); 
      scoreP.add(second); 
      scoreP.add(third); 
      
      Container c= getContentPane(); //��ȡ������
      c.setLayout(new BorderLayout());//ʹ�ñ߽粼��
      c.add(scoreP,BorderLayout.CENTER);//�ɼ������м�
      c.add(restart,BorderLayout.SOUTH);//��ť�ŵײ�
      
      setTitle("��Ϸ����"); //�Ի������
      
      int width ,height;// �Ի�����
      width = height = 200; // �Ի����߾�Ϊ200
      //������������λ�õĺ�����
      int x =frame.getX()+(frame.getWidth()-width)/2;
      //������������λ�õ�������
      int y =frame.getY()+(frame.getHeight()-height)/2;
      setBounds(x, y, width, height);//��������Ϳ��
      setVisible(true); //��ʾ�Ի���
		
	
		
	}

}
