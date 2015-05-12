package eggcatcher;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class MenuPanel extends JPanel
{

	JButton play = new JButton("");
	JButton help = new JButton("");
	JButton exit = new JButton("");
	
	Image menubkg = new ImageIcon("images\\menubg.png").getImage(); 
	Image menubkg2 = new ImageIcon("images\\menubg2.png").getImage(); 
	boolean bkg = true;
	int delay = 0;
	ImageIcon playbtn = new ImageIcon("buttons\\play.png"); 
	ImageIcon helpbtn = new ImageIcon("buttons\\help.png");
	ImageIcon exitbtn = new ImageIcon("buttons\\exit.png");
	

	JPanel center = new JPanel();
	
	MenuPanel()
	{		
		center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS)); 
		add(center); 
		center.setBounds(100, 100, 0, 150);
		/* setting icons on buttons */
		play.setIcon(playbtn); 
		help.setIcon(helpbtn);
		exit.setIcon(exitbtn);
		center.add(play);
		center.add(help);
		center.add(exit);
		play.addMouseListener(new Click());
		help.addMouseListener(new Click());
		exit.addMouseListener(new Click());
		
		
	}//end constructor
	
	class Click extends MouseAdapter
	{	
		public void mouseClicked(MouseEvent me)
		{
			if(me.getSource()== play){
			
				GameScreen.resetGamePanel();
				GameScreen.cl.show(GameScreen.cards, "GamePanel"); 
			}
			if(me.getSource()== help){
				GameScreen.cl.show(GameScreen.cards, "HelpPanel"); 
			}	
			if(me.getSource()== exit)
			{
				System.exit(0);
			}
		}//end mouseClick
	}//end mouseAdapter
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g); 
		Graphics2D g2d = (Graphics2D)g;
		setFocusable(true);
		if(bkg)
		{
			g2d.drawImage(menubkg, 0,0, null);
		} 
		else
		{
			g2d.drawImage(menubkg2, 0,0, null);
		}
		if(delay > 240)
		{
			bkg =!bkg;
			delay = 0;
		}
		else
		{
			delay++;
		}
		
		repaint();
	}//end paintComponent
}//end GamePanel