package game.handler;

import game.modul.GraphicModul;

public class GraphicHandler {
	
	private GraphicModul graphics;
	
	public GraphicHandler() {
		graphics = new GraphicModul();
	}
	
	public void clearScreen() {
		graphics.clearScreen();
		
	}
	
	public void initGraphics() {
		graphics.initGraphics();

	}
	
	public String getOpenGlVersion() {
		return graphics.getOpenGlVersion();
	}
	
	public void setClearColor(float r, float g, float b, float a) {
		graphics.setClearColor(r,g,b,a);
	}
	
	public void setViewport(int x, int y, int width, int height) {
		graphics.setViewport(x,y,width,height);
	}

}
