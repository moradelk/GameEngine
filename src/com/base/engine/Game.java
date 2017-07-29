package com.base.engine;
import static com.sun.glass.events.KeyEvent.*;

import com.dep.lwjgl3.Mesh;
import com.dep.lwjgl3.Shader;

import game.handler.InputHandler;
import game.math.Transform;
import game.modul.WindowModul;





public class Game {

	private Mesh mesh;
	private Shader shader;
	private Transform transform;
	
	public Game() {
		mesh = new Mesh();
		shader = new Shader();

		mesh = ResourceLoader.loadMesh("untitled.obj");
		transform = new Transform();
		transform.setProjection(70f,  WindowModul.getCurrentWidth(),WindowModul.getCurrentHeight(), 0.1f, 1000f);
		shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
		shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));
		shader.compileShader();
		shader.addUniform("transform");
		
		
	}
	

	public  void render() {

		shader.bind();
		shader.setUniform("transform", transform.getProjectedTransformation());
		
		mesh.draw();
		
	}

	float tmp=0;
	
	public  void update() {
		
		//Input.update();
		tmp += Time.getDelta()/5;
		transform.setTranslation(2,2,5) ;
		transform.setRotation(180 * (float) Math.sin(tmp) ,180 * (float) Math.cos(tmp), 180 * (float) Math.sin(tmp) * (float) Math.cos(tmp));
		transform.setScale(0.8f,0.8f,0.8f);
		input();
	
	}

	public  void input() {

		
		if(InputHandler.getKeyDown(VK_SPACE))
			System.out.println("Pressed space");
		if(InputHandler.getKeyUp(VK_SPACE))
			System.out.println("Pressed released");
		if(InputHandler.getButtonDown(0)) {
			double xpos = InputHandler.getCursorPosX();
			double ypos = InputHandler.getCursorPosY();
			System.out.println("Left button pressed at " + xpos  + ", " + ypos );
		}
			
		if(InputHandler.getButtonUp(0)) {
			double xpos = InputHandler.getCursorPosX();
			double ypos = InputHandler.getCursorPosY();
			System.out.println("Left button released at " + xpos + ", " + ypos);
		}

		
	}
	
	
	
	
}
