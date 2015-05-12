package eggcatcher;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GamePanel extends JPanel
{ 
	Image gamebkg = new ImageIcon("images\\bggame.png").getImage();
	Image gameOverbkg= new ImageIcon("images\\bggameover.png").getImage();
	Image pausebtn = new ImageIcon("buttons\\pausebtn.png").getImage();
	Image mouse = new ImageIcon("images\\mouse.png").getImage();
	Image tempbkg; 
	boolean gameover;
	int x_info = 80,y_infor = 125, delay = 0;
	GameManager game;
	JLabel lb_score,lb_eggbreak,lb_level; // ---- thêm Label
	
	Font font = new Font("Arial", Font.BOLD, 28);
	GamePanel()
	{	
		game = new GameManager();
		gameover = false;
		setLayout(null);
		this.setBackground(Color.BLUE);
		setFocusable(true);
		tempbkg = gamebkg;	
		lb_score = new JLabel("0");
		lb_score.setFont(font);
		lb_score.setForeground(Color.RED);
		lb_score.setBounds(x_info,y_infor,200,20);
		
		lb_eggbreak = new JLabel("0");
		lb_eggbreak.setFont(font);
		lb_eggbreak.setForeground(Color.RED);
		lb_eggbreak.setBounds(x_info,y_infor + 45,200,20);
		
		lb_level = new JLabel("0");
		lb_level.setFont(font);
		lb_level.setForeground(Color.RED);
		lb_level.setBounds(x_info,y_infor + 90,200,20);
		//
		add(lb_score);		
		add(lb_eggbreak);
		add(lb_level);
		
		addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke)
			{					
				if(ke.getKeyCode() == ke.VK_LEFT && game.getBasket().x_basket > 0)
				{
					game.keyMove(10, false);
					repaint(); 
				}
				if(ke.getKeyCode() == ke.VK_RIGHT && game.getBasket().x_basket < 550)
				{
					game.keyMove(10, true);
					repaint();					
				}
				if(ke.getKeyCode() == ke.VK_R)
				{
					game.keyVK_R();
					tempbkg = gamebkg;	
				}
				if(ke.getKeyCode() == ke.VK_D)
				{
					game.keyVK_D();
				}
				if(ke.getKeyCode() == ke.VK_ESCAPE)
				{
					game.keyVK_ESCAPE();
					GameScreen.cl.show(GameScreen.cards, "MenuPanel");					
				}
				if(ke.getKeyCode() == ke.VK_P){
					game.keyVK_P();		
				}
				if(ke.getKeyCode() == ke.VK_M)
				{
					game.keyVK_M();	
				}
				if(game.animalsSize() <20)
				{
					if(ke.getKeyCode() == ke.VK_G )
					{
						game.addAnimal("GA");
						repaint();					
					}
					if(ke.getKeyCode() == ke.VK_V )
					{
						game.addAnimal("VIT");
						repaint();						
					}
					if(ke.getKeyCode() == ke.VK_N )
					{
						game.addAnimal("NGAN");
						repaint();					
					}
				}
			}
		});	
		game.startGame();
	}
	void printAllinfo()
	{
		lb_score.setText("" + game.getPlayer().score);
		lb_eggbreak.setText("" + game.getPlayer().eggbreak);
		lb_level.setText("" + (game.getPlayer().score/20 +1));
	}
	void gameOver()
	{
		if(game.getGameOver())
		{
			tempbkg = gameOverbkg;
			gameover = true;
		}
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(tempbkg,0,0,null); 	
		gameOver();	

		if(game.getBasketfoolow())
		{
			g2d.drawImage(mouse,540 ,y_infor - 12, null);
		}	
		if(!gameover)
		{
			if(!game.getGamePause())
			{
				setFocusable(true);
				grabFocus();
				printAllinfo();
				game.draw(g2d);
			}
			else
			{
				g2d.drawImage(pausebtn,180 ,150, null);
			}
		}	
		else
		{
			try
			{
				delay++;
				g2d.drawImage(tempbkg,0,0,null); 
				Thread.sleep(1000);
				printAllinfo();
				if(delay > 150)
				{
					game.newGame();
					tempbkg = gamebkg;	
					gameover = false;
					GameScreen.cl.show(GameScreen.cards, "MenuPanel"); 
				}
			}catch(Exception e)
			{
			   
			}			
		}
		repaint();
	}//end paintComponent
}//end class