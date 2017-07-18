package com.base.engine;
import static com.sun.glass.events.KeyEvent.*;

import org.lwjgl.glfw.GLFW;

import com.base.math.Vector3f;
import com.dep.gl.Mesh;
import com.dep.gl.Shader;




public class Game {

	private Mesh mesh;
	private Shader shader;
	public Game() {
		mesh = new Mesh();
		shader = new Shader();
		Vertex[] vertices = new Vertex[] {
				new Vertex(new Vector3f(-1,-1,0)) ,				
				new Vertex(new Vector3f(0,1,0)) ,
				new Vertex(new Vector3f(1,-1,0))
		};
		
		mesh.addVertices(vertices);
		shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
		shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));
		shader.compileShader();
		shader.addUniform("scale");
		
		
	}
	

	public  void render() {

		shader.bind();
		mesh.draw();
		
	}

	float tmp=0;
	public  void update() {
		
		Input.update();
		tmp += Time.getDelta();
		
		shader.setUniformf("scale", (float) (Math.abs(Math.sin(tmp))));
		
	}

	public  void input() {

		
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
