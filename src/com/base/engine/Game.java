package com.base.engine;
import static com.sun.glass.events.KeyEvent.*;

import org.lwjgl.glfw.GLFW;



public class Game {

	
	
	public Game() {
	
		
	}

	public void render() {
		// TODO Auto-generated method stub
		
	}

	public void update() {
		
		Input.update();
		
	}

	public void input() {

		
		if(Input.getKeyDown(VK_SPACE))
			System.out.println("Pressed space");
		if(Input.getKeyUp(VK_SPACE))
			System.out.println("Pressed released");
		if(Input.getButtonDown(0)) {
			double xpos[] =  {0} ,ypos[] = {0};
			GLFW.glfwGetCursorPos(GLFW.glfwGetCurrentContext(), xpos, ypos);
			System.out.println("Left button pressed at " + xpos[0] + ", " + ypos[0]);
		}
			
		if(Input.getButtonUp(0)) {
			double xpos[] =  {0} ,ypos[] = {0};
			GLFW.glfwGetCursorPos(GLFW.glfwGetCurrentContext(), xpos, ypos);
			System.out.println("Left button released at " + xpos[0] + ", " + ypos[0]);
		}

		
	}
	
	
	
	
}
