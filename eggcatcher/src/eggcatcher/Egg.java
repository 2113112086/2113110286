package eggcatcher;

import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Egg extends Product 
{
	JLabel cong;	
	private Basket basket;
	private Player player;
	private int x_ani;
	Font font = new Font("Arial", Font.BOLD, 28);
//	this.setBackground(Color.BLUE);
	Egg(int x_ani) {
		super(x_ani);
		switch(rand.nextInt(3))
		{
		case 0:
			imgproduct = new ImageIcon("images\\trung1.png").getImage();
			break;
		case 1:
			imgproduct = new ImageIcon("images\\trung2.png").getImage();
			break;
		case 2:
			imgproduct = new ImageIcon("images\\trung1.png").getImage();
			break;
		case 3:
			imgproduct = new ImageIcon("images\\trung2.png").getImage();
			break;
		}
	}
	@Override
	public boolean detectCollision(Basket basket, Player player, int x_ani) 
	{

		Rectangle basketRect = new Rectangle(basket.x_basket,basket.y_basket,70,45); 
		Rectangle eggRect    = new Rectangle(productX,productY,60,50); 
		
		if(eggRect.intersects(basketRect))
		{
			
			imgproduct1 = new ImageIcon("images\\cong.png").getImage();
			//productY--; 
			player.score++;
			return true;
			
		}
		else
		{	
			if(productY>basket.y_basket-15)
			{
				imgproduct = new ImageIcon("images\\opla1.png").getImage();
			}
		}
			if(productY>basket.y_basket-35)
				imgproduct1 = new ImageIcon("images\\tru.png").getImage();
			
			return false;			
		
	}
		

	

	@Override
	public boolean Check(Basket basket, Player player, int x_ani) {
		minfo = MouseInfo.getPointerInfo();
		point = minfo.getLocation();
		basket.followMouse((int)point.getX() -100);
		
		
		if(!(detectCollision(basket,player,x_ani))) // kiểm tra va chạm)
		{
			
			if(productY >=650)
			{
				player.eggbreak++;
				return true;
				
			}
			else
			{
				productY++;
				Y--;
				return false;
			}
		}
		Y--;
		return true;
	}

	
	
}
