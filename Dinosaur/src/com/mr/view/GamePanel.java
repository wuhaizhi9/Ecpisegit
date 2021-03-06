package com.mr.view;
//

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.mr.modle.Dinosaur;
import com.mr.modle.Obstacle;
import com.mr.service.FreshThread;
import com.mr.service.ScoreRecorder;
import com.mr.service.Sound;

public class GamePanel extends JPanel implements KeyListener{
	private BufferedImage image; //主图片
	private BackgroundImage background; //背景图片
	private Dinosaur golden; //恐龙
	private Graphics2D g2 ;//主图片绘画对象
	private int addObstacleTimer= 0;//添加障碍物计时器
	private boolean finish =false; //游戏结束标志
	private List<Obstacle> list = new ArrayList<Obstacle>(); //障碍物集合
	private final int FREASH = FreshThread.FREASH; //刷新时间
	
	
	int score = 0; //得分
	int scoreTimer = 0; //得分计时器
	
	public GamePanel() {
		//主图片采用宽800高300的彩色图片
		image= new BufferedImage(800, 300, BufferedImage.TYPE_INT_BGR);
		g2= image.createGraphics();//绘制主图片对象
		background = new BackgroundImage(); //初始化滚动背景
		golden = new Dinosaur(); //初始化小恐龙
		list.add(new Obstacle());//添加第一个障碍物
		FreshThread t = new FreshThread(this); //刷新帧线程
		t.start();//启动线程
		
		
		
	}
	/**
	 * 绘制主图片
	 * 
	 * */
	
	private  void paintImage() {
		background.roll(); //背景图片开始滚动
		golden.move(); //恐龙开始移动
		g2.drawImage(background.image, 0,0, this);
		if (addObstacleTimer==1300) { //没过1300毫秒
			if (Math.random()*100>40) {//60%概率出现障碍物
				list.add(new Obstacle());
			}
			addObstacleTimer = 0 ; //重新计时
		}
		for (int i = 0; i < list.size(); i++) {//遍历障碍集合
		  Obstacle o = list.get(i); //获取障碍对象
		  if (o.isLive()) {//如果是有效障碍物
			  o.move(); //障碍物移动
			  g2.drawImage(o.image,o.x,o.y, this);//绘制障碍物
			   //如果恐龙小指头碰到障碍
			  if (o.getBounds().intersects(golden.getFootBounds())||o.getBounds().intersects(golden.getHeadBounds())) {
				  Sound.hit();//播放撞击声音
				  gameOver();//游戏结束
			}
			
		}else {//如果不是有效障碍物
			list.remove(i);//删除障碍物
			i--;//循环变量前移
		}
			
		}
		
		g2.drawImage(golden.image, golden.x, golden.y, this);//绘制恐龙
		if (scoreTimer>= 500) { //没过500毫秒
			score += 10; //加十分
			scoreTimer = 0; //重新计时
		}
		
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("黑体",Font.BOLD,24));
	    g2.drawString(String.format("%06d", score),700,30);//绘制分数
	    
	    
	    addObstacleTimer += FREASH; //障碍物计时器递增
	    scoreTimer += FREASH;// 分数计时器递增
		
	}
	
	/**
	 * 重写绘制组件方法
	 * 
	 * 
	 * 
	 * */
	public void paint(Graphics g) {
		paintImage();//绘制猪图片内容
		g.drawImage(image, 0,0, this);
		
	}
	
	 /**
	  * 游戏是否结束
	  * 
	  * 
	  */
  public boolean isFinish() {
	  return finish;
	  
  }
  
  /**
   * 使游戏结束
   * 
   * 
   * */
  
  public void gameOver() {
	  ScoreRecorder.addNewScore(score); //记录当前分数
	  finish =true;
  }
  /**
   * 实现按下键盘按键方法
   * 
   * 
   * 
   * */
  public void keyPressed(KeyEvent e) {
	  int code = e.getKeyCode();//获取按下的按键值
	  if (code== KeyEvent.VK_SPACE) { //如果是空格
		golden.jump(); //恐龙跳跃
	}
  }
 @Override
  public void keyReleased(KeyEvent e) {
	  
	  
	  
  }
  
 @Override
  public void keyTyped(KeyEvent e) {
	  
	  
	  
  }

}
