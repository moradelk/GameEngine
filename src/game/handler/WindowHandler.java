package game.handler;

import game.modul.WindowModul;

public class WindowHandler {

	private int xpos, ypos;
	private int width, height;
	private String title;
	private WindowModul window;
	private boolean fullscreen;
	// private int graphicsContext;
	// more Window vars

	public WindowHandler(int posX, int posY, int w, int h, String t) {
		xpos = posX;
		ypos = posY;
		width = w;
		height = h;
		title = t;
		fullscreen = false;
		window = new WindowModul(posX, posY, width, height, title);
	}

	public void createWindow() {

		window.createWindow();
	}

	public void update() {
		window.update();
	}
	
	public void render() {
		window.render();
	}

	public void resize() {
		window.resize();
	}

	public void close() {
		window.close();
	}
	public boolean isCloseRequested() {
		return window.isCloseRequested();
	}
	
	public void setPos(int posX, int posY) {
		xpos = posX;
		ypos = posY;
		window.setPos(xpos, ypos);
	}

	public void setSize(int w, int h) {
		width = w;
		height = h;
		window.setSize(width, height);
	}

	public int getXpos() {
		return window.getXpos();
	}

	public int getYpos() {
		return window.getYpos();
	}

	public int getWidth() {
		return window.getWidth();
	}

	public int getHeight() {
		return window.getHeight();
	}

	public String getTitle() {
		return window.getTitle();
	}

	public boolean isFullscreen() {
		return fullscreen;
	}

	public void setFullscreen(boolean fullscreen) {
		this.fullscreen = fullscreen;
		window.setFullscreen(fullscreen);
	}

}
