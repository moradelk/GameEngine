package com.dep.gl;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

import org.lwjgl.opengl.GL;


public class RenderUtil {

	public static void clearScreen() {
		
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
	}
	
	public static void initGraphics() {
		GL.createCapabilities();
		glClearColor(0.0f, 0.0f, 1.0f, 0.0f);
		
		glFrontFace(GL_CW);
		//glEnable(GL_CULL_FACE);
		//glCullFace(GL_BACK);

		glEnable(GL_DEPTH_TEST);
		
		glEnable(GL_FRAMEBUFFER_SRGB);
		

	}
	
	public static String getOpenGlVersion() {
		return glGetString(GL_VERSION);
	}
	
}
