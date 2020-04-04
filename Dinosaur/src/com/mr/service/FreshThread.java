package com.mr.service;
/**
 * 刷新帧线程
 * 
 * 
 * */

import java.awt.Container;

import com.mr.view.GamePanel;
import com.mr.view.MainFrame;
import com.mr.view.ScoreDialog;

public class FreshThread  extends Thread{
	public static final int FREASH = 20;//刷新时间
	GamePanel p ;//游戏面板
	
	public FreshThread(GamePanel p) {
		this.p = p;
	}
	
	public void run() {
		while (!p.isFinish()) {
			p.repaint(); //重绘游戏面板
			try {
				Thread.sleep(FREASH); //按照刷新时间休眠
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Container c = p.getParent();//获取面板父容器
		while (!(c instanceof MainFrame) ) {
			c= c.getParent(); //继续继承父容器的父容器
			
		}
		MainFrame frame = (MainFrame)c;//将容器强制转换为主窗体类
		new ScoreDialog(frame); //弹出得分记录对话框
		frame.restart();//主窗体重载开始游戏
	}

}
