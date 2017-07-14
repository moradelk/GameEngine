package com.base.engine;

public class MainComponent {

	private Thread thread;
	public final int WIDTH = 800;
	public final int HEIGHT = 800;
	public final String TITLE = "Game Engine";
	public final double FRAME_CAP = 5000.0;
	public Window window;

	private Game game;
	
	public MainComponent() {

		window = new Window(WIDTH, HEIGHT, TITLE);
		game  = new Game();
	}

	private void start() {

		if (window.running)
			return;

		run();

	}

	private void run() {

		thread = new Thread(window, TITLE);
		thread.start();

		window.running = true;
		
		int frames = 0;
		long frameCounter = 0;

		final double frameTime = 1.0 / FRAME_CAP;

		long lastTime = Time.getTime();
		double unprocessedTime = 0;

		while (window.running) {

			boolean render = false;

			long startTime = Time.getTime();
			long passedTime = startTime - lastTime;
			lastTime = startTime;

			unprocessedTime += passedTime / (double) Time.SECOND;
			frameCounter += passedTime;
			while (unprocessedTime > frameTime) {

				render = true;

				unprocessedTime -= frameTime;

				if (window.isCloseRequested())
					stop();
				
				Time.setDelta(frameTime);
				
				game.input();
				game.update();
				
				if(frameCounter >= Time.SECOND) {
					System.out.println(frames + " : " + frameTime);
					frames = 0;
					frameCounter = 0;
				}

			}

			if (render) {
				render();
				frames++;
			}

			else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

		cleanUp();

	}

	private void stop() {
		window.running = false;

	}

	private void render() {
		game.render();
		window.render();
	}

	private void cleanUp() {
		window.dispose();
	}

	public static void main(String args[]) {

		MainComponent game = new MainComponent();
		game.start();

	}

}
