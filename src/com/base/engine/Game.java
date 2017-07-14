package com.base.engine;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;

public class Game {

	
	public Game(long window) {
	
	}

	public void render() {
		// TODO Auto-generated method stub
		
	}

	public void update() {
		
		Input.update();
		
	}

	public void input() {

		if(Input.getKeyDown(GLFW.GLFW_KEY_SPACE))
			System.out.println("Pressed space");
		if(Input.getKeyUp(GLFW.GLFW_KEY_SPACE))
			System.out.println("Pressed released");
		
	}
	
	
	
	
}
