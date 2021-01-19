package qiuqiu;
import java.util.Random;

import sun.applet.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ball {//小球的属性
	int x;
	int y;
	int d;
	double r;
	double R;
	int xspeed;
	int yspeed;
	int position;
	Color ballColor;
	public static final int UP=0;
	public static final int DOWN=1;
	public static final int LEFT=2;
	public static final int RIGHT=3;




	Ball() {
		x = (int)(Math.random()*780);
		y = (int)(Math.random()*580);
		d = (int)(Math.random()*60+10); 
		position =(int)(Math.random()*4); 
		xspeed=(int)(Math.random()*3+1);
		yspeed=(int)(Math.random()*4+1);
		int red=(int)(Math.random()*255+1);
		int green=(int)(Math.random()*255+1);
		int blue=(int)(Math.random()*255+1);
		ballColor = new Color(red,green,blue);


	}
	//重画小球
	public void drawBall(Graphics2D g) {
		g.setColor(ballColor);
		g.fillOval(x,y,d,d);
	}
	//** 小球移动 */
	public void sped(){
		switch(this.position){
		case UP:
			x-=xspeed;
			y-=yspeed;
			if(x<=0){
				this.position=DOWN;
			}else if(y<=0){
				this.position=LEFT;
			}
			break;
		case DOWN:
			x+=xspeed;
			y-=yspeed;
			if(x>=780-d){
				this.position=UP;
			}else if (y<=0) {
				this.position=RIGHT;
			}
			break;
		case LEFT:
			x-=xspeed;
			y+=yspeed;
			if (x<=0) {
				this.position=RIGHT;
			}else if (y>=580-d) {
				this.position=UP;	
			}
			break;
		case RIGHT:
			x+=xspeed;
			y+=yspeed;
			if (x>=790-d) {
				this.position=LEFT;
			}else if (y>=580-d) {
				this.position=DOWN;
			}
			break;
		}
	}


	public boolean Ballandball(Ball ball) { 
		double X=x,Y=y,D=d;
		double x=ball.x,y=ball.y,d=ball.d;
		if(d>D) {
			return false;
		}
		double x1 = X+D/2;	
		double x2 = x+d/2;
		double y1 = Y+D/2;
		double y2 = y+d/2;
		double m = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));//m为两个圆之间的距离
		boolean eaten =m<=(D/2)-(d/2);//两个元之间的距离<两个半径的差
		if(m<=(D/2)-(d/2)) {//计算吃后球的面积
			R = D/2;
			r = d/2;
			double area =Math.PI*R*R+Math.PI*r*r;
			
			R= Math.sqrt(area/Math.PI);//计算新圆的半径
			this.d = (int) R*2;
			ball.d=0;
		}
		return eaten;
	}


}






































