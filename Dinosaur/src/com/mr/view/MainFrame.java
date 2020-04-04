package com.mr.view;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.mr.service.ScoreRecorder;
import com.mr.service.Sound;


/**
 * 主窗体
 * 
 * */

public class MainFrame  extends JFrame{
   public MainFrame() {
	    restart(); //开始
	   setBounds(340, 150, 821, 260); //设置横纵坐标和宽高
	   setTitle("奔跑吧！小恐龙！！！"); //标题
	   Sound.backgroud();//播放背景音乐
	   ScoreRecorder.init();//读取得分记录
	   addListener(); //添加监听
	   setDefaultCloseOperation(EXIT_ON_CLOSE); 
   }
 /**
  * 重新开始
  * 
  */
 public void restart() {
	 Container c =getContentPane(); //获取主容器对象
	 c.removeAll(); //删除容器中各个所有组价
	 GamePanel panel=new GamePanel(); //创建新的游戏面板
	 c.add(panel);
	 addKeyListener(panel); //添加键盘事件
	 c.validate(); //容器重新验证所有组件
 }
 
 /**
  * 添加监听
  * 
  * 
  * */
  private void addListener() {
	  addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			ScoreRecorder.saveScore(); //保存比分
			
		}
	});
	  
	  
  }
} 
