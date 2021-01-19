package qiuqiu;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;


import cn.tedu.util.App;

public class World extends App{
	public static final int WIDTH = 800;//窗口宽
	public static final int HEIGHT = 620;//窗口高
	//创建小球对象
	Ball[] ball = new Ball[3000];
	public World() {
		for(int i=0;i<ball.length;i++) {
			ball[i] = new Ball();	
		}
	}


	//画小球
	public void painting(Graphics2D g) {
		for(int i=0;i<ball.length;i++) {
			ball[i].drawBall(g);
			ball[i].sped();  //小球移动

		}
		BallandballAction();

	}

	public void BallandballAction() {
		Ball[] ba = ball;
		Ball[] bl = ball;
		boolean[] eaten = new boolean[ba.length];
		for(int i =0;i<ba.length;i++) {
			for(int j =0;j<bl.length;j++) {
				if(i!=j) {
					ba[i].Ballandball(bl[j]);
				}
			}
		}
	}


	public static void main(String[] args) {

		World world = new World();
		world.start();

	}

}
