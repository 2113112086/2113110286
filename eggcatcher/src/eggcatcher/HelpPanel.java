package eggcatcher;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HelpPanel extends JPanel{

	Image helpbkg = new ImageIcon("images\\helpbkg.png").getImage(); //help image background
	JButton back = new JButton();
	ImageIcon backbtn = new ImageIcon("buttons\\back1.png");
	
	HelpPanel()
	{
		back.setIcon(backbtn);
		setFocusable(true);
		add(back);
		
		back.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent me){
						GameScreen.cl.show(GameScreen.cards, "MenuPanel");
			}	
		  });
	}//end constructor
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(helpbkg,0,0, null);
	}
}