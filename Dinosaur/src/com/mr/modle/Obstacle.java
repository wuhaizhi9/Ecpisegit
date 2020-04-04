package com.mr.modle;

import java.awt.Rectangle;
import java.awt.image.*;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

import com.mr.view.BackgroundImage;



public class Obstacle {	
	 public int x, y; //�ݺ�����
	 public BufferedImage image; 
	 private BufferedImage stone; //ʯͷͼƬ
	 private BufferedImage cacti; //������ͼƬ
	 private int speed;// �ƶ��ٶ�
	
	  public Obstacle () {
		  try {
			stone = ImageIO.read(new File("image/ʯͷ.png"));
			cacti = ImageIO.read(new File("image/������.png"));
		} catch (Exception e) {
           e.printStackTrace();
		}
		  Random r = new Random(); // �����������
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
 * �ƶ�
 * 
 * */
	  
	  public void move() {
		  x -= speed; //���������
		  
		  
	  }
	  
	  
	  /**
	   * ��ȡ�߽�
	   * */
	  public Rectangle getBounds () {
		  if (image == cacti) {//���ʹ��������ͼƬ
			  //���������Ƶı߽�
			  return new Rectangle(x+7,y,15,image.getHeight());
		}
		  return new Rectangle(x+5,y+4,23,21);		  
	  }
    /**
          *�Ƿ��� 
     * 
     */	  
	  public boolean isLive() {
		  //����Ƴ���Ϸ����
		  if (x<= image.getWidth()) {
			  return false;
		}
             return true;		  
	  }
  }
