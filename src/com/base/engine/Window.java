package com.base.engine;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.glfw.GLFWVidMode;

public class Window implements Runnable {

	public long window;
	public boolean running = false;
	 

	public Window(int width, int height, String title) {
		init(width, height, title);
 		Input.init();

	}

	public void init(int width, int height, String title) {
		// Initializes our window creator library - GLFW
		// This basically means, if this glfwInit() doesn't run properly
		// print an error to the console
		if (glfwInit() != true) {
			// Throw an error.
			System.err.println("GLFW initialization failed!");
		}

		
		// Allows our window to be resizable
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);

		// Creates our window. You'll need to declare private long window at the
		// top of the class though.
		// We pass the width and height of the game we want as well as the title
		// for
		// the window. The last 2 NULL parameters are for more advanced uses and
		// you
		// shouldn't worry about them right now.
		window = glfwCreateWindow(width, height, title, NULL, NULL);

		// This code performs the appropriate checks to ensure that the
		// window was successfully created.
		// If not then it prints an error to the console
		if (window == NULL) {
			// Throw an Error
			System.err.println("Could not create our Window!");
		}

		// creates a bytebuffer object 'vidmode' which then queries
		// to see what the primary monitor is.
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		System.err.println(vidmode.toString());
		// Sets the initial position of our game window.
		glfwSetWindowPos(window, 100, 100);
		// Sets the context of GLFW, this is vital for our program to work.
		glfwMakeContextCurrent(window);
		// finally shows our created window in all it's glory.
		glfwShowWindow(window);
	}

	public void update() {
		// Polls for any window events such as the window closing etc.
		glfwPollEvents();
	}

	public void render() {
		// Swaps out our buffers
		glfwSwapBuffers(window);
	}

	public void dispose() {
		glfwDestroyWindow(window);
		System.err.println("Window.dispose()");
	}
	@Override
	public void run() {

		// All our initialization code

		// Our main game loop
		while (running) {
			update();
			//render();
			// Checks to see if either the escape button or the
			// red cross at the top were pressed.
			// if so sets our boolean to false and closes the
			// thread.
//			if (glfwWindowShouldClose(window) == true) {
//				running = false;
	//		}
		}

	}

	int getWidth() {
		return 220;
	}

	int getHeight() {
		return 110;
	}
	
	public boolean isCloseRequested() {
		
		return glfwWindowShouldClose(window);
	}
}
