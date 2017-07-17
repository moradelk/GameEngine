package com.base.engine;

import com.base.math.Vec2f;
import com.dep.gl.RenderUtil;

public class MainComponent {

	private Thread thread;
	private final int WIDTH = 800;
	private final int HEIGHT = 800;
	private final String TITLE = "Game Engine";
	private final double FRAME_CAP = 5000.0;
	private Window window;

	private Game game;
	
	public MainComponent() {

		window = new Window(WIDTH, HEIGHT, TITLE);
		RenderUtil.initGraphics();
		System.out.println(RenderUtil.getOpenGlVersion());
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
					System.out.println(frames );
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
		RenderUtil.clearScreen();
		game.render();
		window.render();
	}

	private void cleanUp() {
		window.dispose();
	}

	public static void main(String args[]) {

		Vec2f v1= new Vec2f(1f,-1f);
		Vec2f v2= new Vec2f(0.f ,0.5f);
		System.out.println(v1.toString());
		System.out.println(v2.add(v1).toString());
		v1.normalize();
		v2.normalize();

		System.out.println(v1.dot(v2));
		System.out.println(v2.dot(v1));		/*
		MainComponent game = new MainComponent();
		game.start();
		*/

	}

}
