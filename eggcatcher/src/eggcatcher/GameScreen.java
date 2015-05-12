package eggcatcher;


import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameScreen extends JFrame
{
	
	static MenuPanel mp = new MenuPanel();
	static HelpPanel hp = new HelpPanel();
	static GamePanel gp = new GamePanel();	
	static CardLayout cl = new CardLayout();
	static JPanel cards = new JPanel();
	public static void resetGamePanel(){
		gp = new GamePanel();	
		cards.remove(2);
		cards.add(gp, "GamePanel");
	}
	GameScreen()
	{		
		cards.setLayout(cl);
		cards.add(mp, "MenuPanel");
		cards.add(hp, "HelpPanel");
		cards.add(gp, "GamePanel");
		cl.show(cards, "MenuPanel");
		add(cards);
		
		setTitle("Game Hứng Trứng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 700); 
		setResizable(true);
		setVisible(true); 
		
	}//end constructor
	public static void main(String args[])
	{
		new GameScreen();
		
	}//end main
}//end class

