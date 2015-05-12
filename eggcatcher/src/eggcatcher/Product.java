package eggcatcher;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.PointerInfo;
import java.util.Random;

public abstract class Product 
{
	Random rand = new Random();
	public int productX, productY = 80,Y=650,X;
	protected Image imgproduct;
	protected Image imgproduct1;
	PointerInfo minfo ;
	Point point ;
	Product(int x_ani)
	{
		productX = x_ani;
		X=x_ani;
	}
	public void draw(Graphics g)
	{
		g.drawImage(imgproduct, productX,productY, null);
		g.drawImage(imgproduct1, X,Y, null);
		
	}
	public abstract boolean detectCollision(Basket basket,Player player,int x_ani);
	public abstract boolean Check(Basket basket,Player player,int x_ani);
	//public abstract void paintComponent(Graphics g) ;
	
	
	
}
