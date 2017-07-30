package game.modul;


import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_CW;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_VERSION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glFrontFace;
import static org.lwjgl.opengl.GL11.glGetString;
import static org.lwjgl.opengl.GL11.glViewport;
import static org.lwjgl.opengl.GL30.GL_FRAMEBUFFER_SRGB;

import org.lwjgl.opengl.GL;

import game.object.Sphere;

public class GraphicModul {
	
	
	
	
	public void clearScreen() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
	}
	
	public void initGraphics() {
		GL.createCapabilities();
		glClearColor(0,0,0,0);
		glFrontFace(GL_CW);
		//glEnable(GL_CULL_FACE);
		//glCullFace(GL_BACK);

		glEnable(GL_DEPTH_TEST);
		
		glEnable(GL_FRAMEBUFFER_SRGB);
		Sphere.init();

	}
	
	public String getOpenGlVersion() {
		return glGetString(GL_VERSION);
	}

	public void setClearColor(float r, float g, float b, float a) {
		glClearColor(r,g,b,a);
		
	}

	public void setViewport(int x, int y, int width, int height) {
		glViewport(x, y, width, height);
	}

}