package com.base.engine;

import com.dep.lwjgl3.RenderUtil;

import game.handler.WindowHandler;

public class GameEngine {

	private final int WIDTH = 800;
	private final int HEIGHT = 800;
	private final String TITLE = "Game Test Screen";
	private final double FRAME_CAP = 5000.0;
	
	private WindowHandler windowHandler;
	private Game game;
	private boolean running=false;
	
	
	public GameEngine() {

		windowHandler = new WindowHandler(0, 0, WIDTH, HEIGHT, TITLE);
		windowHandler.createWindow();
		RenderUtil.initGraphics();
		Input.init();
		System.out.println(RenderUtil.getOpenGlVersion());
		game  = new Game();
		
	}
	

	public void start() {

		if (running)
			return;

		run();

	}
	
	private void run() {


		running = true;
		
		int frames = 0;
		long frameCounter = 0;

		final double frameTime = 1.0 / FRAME_CAP;

		long lastTime = Time.getTime();
		double unprocessedTime = 0;

		while (!windowHandler.isCloseRequested()) {

			boolean render = false;

			long startTime = Time.getTime();
			long passedTime = startTime - lastTime;
			lastTime = startTime;

			unprocessedTime += passedTime / (double) Time.SECOND;
			frameCounter += passedTime;
			while (unprocessedTime > frameTime) {

				render = true;

				unprocessedTime -= frameTime;
				
				Time.setDelta(frameTime);
				update();
				
				if(frameCounter >= Time.SECOND) {
					System.out.println(frames );
					frames = 0;
					frameCounter = 0;
				}

			}

			if (render) {
				render();
				frames++;
			}



		}

		cleanUp();

	}

	private void render() {
		RenderUtil.clearScreen();
		game.render();
		windowHandler.render();
	}
	
	private void cleanUp() {
		windowHandler.close();;
	}

	private void update() {
		windowHandler.update();
		Input.update();
		game.update();
	}
}
