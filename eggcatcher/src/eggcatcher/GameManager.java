package eggcatcher;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class GameManager extends GameThread {
	Random rand = new Random();
	boolean gameOver, pause;
	Basket basket = new Basket();
	Player player = new Player();
	ArrayList<Animal> animals = new ArrayList<>();
	ArrayList<Product> products = new ArrayList<>();

	public GameManager() {
		super();
		newGame();
		//gamehertz = 400;
	}

	public void newGame() {
		gameOver = false;
		running = true;
		pause = false;
		animals.clear();
		products.clear();
		gameOver = false;
		player.reSet();
		animals.add(new Chicken());
		products.add(createProduct(animals.get(animals.size() - 1).x_ani));
	}
	public void startGame(){
		startRun();
	}

	private Product createProduct(int local){
		if(rand.nextBoolean())
		{
			return new Egg(local);
		}
		else
		{
			return new Egg(local);
		}
	}
	public void keyMove(int x, Boolean irection) {
		basket.Move(x, irection);
	}

	public void keyVK_R() {
		newGame();
	}

	public void keyVK_D() {
		if(animals.size() >1)
			animals.remove(animals.size() - 1);
	}

	public void keyVK_ESCAPE() {
		newGame();
	}

	public void keyVK_P() {
		pause = !pause;
	}

	public void keyVK_M() {
		basket.followmouse = !basket.followmouse;
	}

	public Player getPlayer() {
		return player;
	}
	public void addAnimal(String type) {
		try{
			if (animals.size() < 20) {
				switch (type) {
				case "GA":
					animals.add(new Chicken());
					products.add(createProduct(animals.get(animals.size() - 1).x_ani));
					break;
				case "VIT":
					animals.add(new Duck());
					products.add(createProduct(animals.get(animals.size() - 1).x_ani));
					break;
				case "NGAN":
					animals.add(new Goose());
					products.add(createProduct(animals.get(animals.size() - 1).x_ani));
					break;
				default:
					animals.add(new Chicken());
					products.add(createProduct(animals.get(animals.size() - 1).x_ani));
					break;
				}
			}
		}catch(Exception e)
		{
			
		}
	}

	public int animalsSize() {
		return animals.size();
	}

	public boolean getGameOver() {
		return gameOver;
		
	} 
	public boolean getGamePause() {
		return pause;
		
	}

	public boolean getBasketfoolow(){
		return basket.followmouse;	
	}
	public Basket getBasket(){
		return basket;
		
	}
	void gameOver()
	{
		//if(player.receiveshit == 3 || player.eggbreak == 3)
		if(player.eggbreak == 3)
		{
			gameOver = true;
			running = false;
		}
		else
		{
			TIME_BETWEEN_UPDATES = 1000000000 / (200 + 50*(player.score/20));
		}
	}
	public void draw(Graphics g)
	{
		for(int i = 0; i< animals.size();i++)
		{
			products.get(i).draw(g);
			basket.Draw(g);
			animals.get(i).draw(g);
		}
	}

	@Override
	public void run() {
		for(int i = 0; i< animals.size();i++)
		{
			gameOver();
			if(products.get(i).Check(basket,player,animals.get(i).x_ani))
			{
				products.set(i, createProduct(animals.get(i).x_ani));
			}
			animals.get(i).move();
		}
	}
}
