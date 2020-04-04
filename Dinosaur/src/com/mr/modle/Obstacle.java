package com.mr.modle;

import java.awt.Rectangle;
import java.awt.image.*;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

import com.mr.view.BackgroundImage;



public class Obstacle {	
	 public int x, y; //纵横坐标
	 public BufferedImage image; 
	 private BufferedImage stone; //石头图片
	 private BufferedImage cacti; //仙人掌图片
	 private int speed;// 移动速度
	
	  public Obstacle () {
		  try {
			stone = ImageIO.read(new File("image/石头.png"));
			cacti = ImageIO.read(new File("image/仙人掌.png"));
		} catch (Exception e) {
           e.printStackTrace();
		}
		  Random r = new Random(); // 创建随机对象
		  if (r.nextInt(2)== 0) {

			  image = cacti;
		}else {
			image = stone;
		}
		  x = 800;
		  y = 200 - image.getHeight();
		  speed = BackgroundImage.SPEED; 
	  }
/**
 * 移动
 * 
 * */
	  
	  public void move() {
		  x -= speed; //横坐标递增
		  
		  
	  }
	  
	  
	  /**
	   * 获取边界
	   * */
	  public Rectangle getBounds () {
		  if (image == cacti) {//如果使用仙人掌图片
			  //返回仙人掌的边界
			  return new Rectangle(x+7,y,15,image.getHeight());
		}
		  return new Rectangle(x+5,y+4,23,21);		  
	  }
    /**
          *是否存活 
     * 
     */	  
	  public boolean isLive() {
		  //如果移出游戏界面
		  if (x<= image.getWidth()) {
			  return false;
		}
             return true;		  
	  }
  }
