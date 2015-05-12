package eggcatcher;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Basket 
{
	Image basket  = new ImageIcon("images\\basket.png").getImage();
	public int x_basket,y_basket;
	public boolean followmouse = false;
	Random rand = new Random();
	Basket()
	{
		x_basket = rand.nextInt(510); 
		y_basket = 550;
	}
	public void Move(int x,boolean irection)
	{
		if(irection)
		{
			x_basket+=x;
		}
		else
		{
			x_basket-=x;
		}
	}

	public void followMouse(int x_mouse)
	{
		if(followmouse)
		{
			x_basket =x_mouse;
			if(x_basket > 520)
				x_basket =520;
			else
				if(x_basket <= 2)
					x_basket =2;
		}
	}
	public void Draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(basket, x_basket ,y_basket, null); // draw help background
	}
}

