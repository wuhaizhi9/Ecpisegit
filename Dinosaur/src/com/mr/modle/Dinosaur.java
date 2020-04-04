package com.mr.modle;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.sound.midi.*;

import com.mr.service.FreshThread;
import com.mr.service.Sound;

public class Dinosaur {
	public BufferedImage image;  //��ͼƬ
	private BufferedImage image1, image2, image3;  // �ܲ�ͼƬ
	public int x,y ; //����
	private int jumpValue = 0; //��Ծ��������
	private  boolean jumpState = false; //��Ծ״̬
	private  int stepTimer = 0; //̤����ʱ��
	private final int JUMP_HIGHT =120; //�������߶�
	private final int LOWEST_Y = 120; //����������
	private final int FREASH = FreshThread.FREASH; //ˢ��ʱ��
	
	 public  Dinosaur() {
		 x = 50;
		 y =LOWEST_Y;
		 try {	
			 image1 = ImageIO.read(new File("image/����1.png"));
			 image2 = ImageIO.read(new File("image/����2.png"));
			 image3 = ImageIO.read(new File("image/����3.png"));
			 
		} catch (Exception e) {
            e.printStackTrace();
		}
		  
		 
		 
	 }
	public void move() {
		step(); //����̤��
		if (jumpState) {//���������Ծ
           if (y>=LOWEST_Y) { //�����������ڵ�����͵�
           jumpValue =-4; //������Ϊ��ֵ
         }
           if (y<=LOWEST_Y - JUMP_HIGHT) { //���������ߵ�
        	 jumpValue = 4 ; //������Ϊ��ֵ
		}
		y+= jumpValue;  //�����귢���仯
		if (y>=LOWEST_Y) { //����ٴ����
			jumpState = false; //ֹͣ��Ծ
     		}
		}
	}
	/**
	 * ��Ծ
	*/
   public void jump() {
	   if (!jumpState) { //���û������Ծ״̬
		   Sound.jump(); //������Ծ��Ч
	}
    jumpState  =true ; // ������Ծ״̬
}
   /**
    * ̤��
    * 
    * */
   
   private void step() {
	//û��250���룬����һ��ͼƬ����Ϊ����3��ͼƬ�����Գ���3���࣬����չʾ������
	   int tmp = stepTimer /250 % 3;
       switch (tmp) {
     	case 1:
     		image = image1;
     		break;
     	case 2:
     		image = image2;
     		break;
		default :
			image = image3;
	} 
      stepTimer += FREASH;//��ʱ������   
      }
   /**
    * �㲿�߽�����
    * 
    * */
  public Rectangle getFootBounds() {
	  return new  Rectangle(x + 30 , y + 59 , 29 , 18);
  }   
  /**
   * ͷ���߽�����
   * 
   * 
   * */
   public Rectangle getHeadBounds() {
	   return new Rectangle(x +66, y + 25, 32,22);
	   
	   
	   
   }

}
    