package game.modul;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;
import org.lwjgl.opengl.GL;

import game.object.GridXY;
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
		GridXY.init();
		glFrustum(-5, 5, -5, 5, -5, 5);
		

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