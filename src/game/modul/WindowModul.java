package game.modul;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.glfw.GLFW;




public class WindowModul {

	private int xpos, ypos;
	private int width, height;
	private String title;
	private boolean fullscreen;

	public long windowContext;

	public WindowModul(int posX, int posY, int w, int h, String t) {
		xpos = posX;
		ypos = posY;
		width = w;
		height = h;
		title = t;
		fullscreen = false;

	}

	public void createWindow() {
		// Initializes our window creator library - GLFW
		if (glfwInit() != true) {
			System.err.println("GLFW initialization failed!");
			new Exception().printStackTrace();
			System.exit(1);
		}

		// Allows our window to be resizable
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
		glfwWindowHint(GLFW_DOUBLEBUFFER, GLFW_TRUE);

		windowContext = glfwCreateWindow(width, height, title, fullscreen ? glfwGetPrimaryMonitor() : NULL, NULL);

		// This code performs the appropriate checks to ensure that the
		// window was successfully created.
		// If not then it prints an error to the console
		if (windowContext == NULL) {
			// Throw an Error
			System.err.println("Could not create our Window!");
		}

		// Sets the initial position of our game window.
		glfwSetWindowPos(windowContext, xpos, ypos);
		// Sets the context of GLFW, this is vital for our program to work.
		glfwMakeContextCurrent(windowContext);

		// finally shows our created window in all it's glory.
		glfwShowWindow(windowContext);
	}

	public void update() {
		glfwPollEvents();
		
	}

	public void render() {
		glfwSwapBuffers(windowContext);
	}


	public void resize() {

	}

	public void close() {
		glfwDestroyWindow(windowContext);

	}

	public boolean isCloseRequested() {
		return glfwWindowShouldClose(windowContext);
	}

	public void setPos(int posX, int posY) {
		xpos = posX;
		ypos = posY;
		glfwSetWindowPos(windowContext, xpos, ypos);
	}

	public int getXpos() {
		int xpos[] = { 0 }, ypos[] = { 0 };
		glfwGetWindowPos(windowContext, xpos, ypos);
		return xpos[0];
	}

	public int getYpos() {
		int xpos[] = { 0 }, ypos[] = { 0 };
		glfwGetWindowPos(windowContext, xpos, ypos);
		return ypos[0];
	}

	public void setSize(int w, int h) {
		width = w;
		height = h;
		glfwSetWindowSize(windowContext, width, height);

	}

	public int getWidth() {
		int width[] = { 0 }, height[] = { 0 };
		glfwGetWindowSize(windowContext, width, height);
		return width[0];
	}

	public int getHeight() {
		int width[] = { 0 }, height[] = { 0 };
		glfwGetWindowSize(windowContext, width, height);
		return height[0];
	}
	public static int getCurrentWidth() {
		int  width[] =  {0} ,height[] = {0};
		glfwGetWindowSize(glfwGetCurrentContext(), width, height);
		return width[0];
		}

	public static int getCurrentHeight() {		
		int  width[] =  {0} ,height[] = {0};
		glfwGetWindowSize(glfwGetCurrentContext(), width, height);		
		return height[0];
	}
	public String getTitle() {
		return title;
	}

	public boolean isFullscreen() {
		return fullscreen;
	}

	public void setFullscreen(boolean fullscreen) {
		System.err.println("setFullscreen is not implemented");
		fullscreen = false;

	}
}
