package com.base.engine;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;

public class Game {

	Input input = new Input();
	public Game() {		
	}

	public void render() {
		// TODO Auto-generated method stub
		
	}

	public void update() {

		
	}

	public void input() {

		if(input.isKeyDown(GLFW.GLFW_KEY_SPACE))
			System.out.println("Pressed up");
		
	}
	
	
	
	
}
