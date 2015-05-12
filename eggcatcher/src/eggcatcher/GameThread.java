package eggcatcher;

public abstract class GameThread
{
	protected boolean running = true;
	protected boolean paused = false;
	@SuppressWarnings("unused")
	private int fps = 60;
	private int frameCount = 0;
	Thread loop;
	protected double gamehertz = 200;
	double TIME_BETWEEN_UPDATES = 1000000000 / gamehertz;
	public GameThread()	{
		loop = new Thread() {
			public void run() {
				gameLoop();
			}
		};
	}
	
	protected void startRun()	{
		loop.start();
	}
	private void gameLoop() { 

		final int MAX_UPDATES_BEFORE_RENDER = 5;
		double lastUpdateTime = System.nanoTime();
		double lastRenderTime = System.nanoTime();

		final double TARGET_FPS = 60;
		final double TARGET_TIME_BETWEEN_RENDERS = 1000000000 / TARGET_FPS;

		int lastSecondTime = (int) (lastUpdateTime / 1000000000);

		while (running) {
			double now = System.nanoTime();
			int updateCount = 0;

			if (!paused) {
				while (now - lastUpdateTime > TIME_BETWEEN_UPDATES
						&& updateCount < MAX_UPDATES_BEFORE_RENDER) 
				{
					run();
					lastUpdateTime += TIME_BETWEEN_UPDATES;
					updateCount++;
				}

				if (now - lastUpdateTime > TIME_BETWEEN_UPDATES) 
				{
					lastUpdateTime = now - TIME_BETWEEN_UPDATES;
				}

				@SuppressWarnings("unused")
				float interpolation = Math
						.min(1.0f,
								(float) ((now - lastUpdateTime) / TIME_BETWEEN_UPDATES));
				//drawGame(interpolation);
				lastRenderTime = now;

				int thisSecond = (int) (lastUpdateTime / 1000000000);
				if (thisSecond > lastSecondTime)
				{
					fps = frameCount;
					frameCount = 0;
					lastSecondTime = thisSecond;
				}

				while (now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS
						&& now - lastUpdateTime < TIME_BETWEEN_UPDATES)
				{
					Thread.yield();
					try 
					{
						Thread.sleep(1);
					} 
					catch (Exception e)
					{
					}
					now = System.nanoTime();
				}
			}
		}
	}
	public abstract void run();
}
