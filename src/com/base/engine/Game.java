package com.base.engine;
import static com.sun.glass.events.KeyEvent.*;

import org.lwjgl.glfw.GLFW;

import com.base.math.Transform;
import com.base.math.Vector3f;
import com.dep.gl.Mesh;
import com.dep.gl.RenderUtil;
import com.dep.gl.Shader;




public class Game {

	private Mesh mesh;
	private Shader shader;
	private Transform transform;
	
	public Game() {
		mesh = new Mesh();
		shader = new Shader();
		Vertex[] vertices = new Vertex[] {
				new Vertex(new Vector3f(-1,-1,0)) ,				
				new Vertex(new Vector3f(0,1,0)) ,
				new Vertex(new Vector3f(1,-1,0)),
				new Vertex(new Vector3f(0,-1,1))
		};
		
		int[] indices = new int[] {0,1,2,   3,1,2,  0,1,3,   0,2,3};
/*
		int[] indices = new int[]
				{	0,1,3,
					3,1,2,
					2,1,0,
					0,2,3};
*/
		//mesh.addVertices(vertices, indices );
		
		mesh = ResourceLoader.loadMesh("untitled.obj");
		transform = new Transform();
		
		shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
		shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));
		shader.compileShader();
		shader.addUniform("transform");
		
		
	}
	

	public  void render() {

		shader.bind();
		shader.setUniform("transform", transform.getTransformation());
		
		mesh.draw();
		
	}

	float tmp=0;
	
	public  void update() {
		
		Input.update();
		tmp += Time.getDelta()/50;
		transform.setTranslation(0,0,0) ;
		transform.setRotation(180 * (float) Math.sin(tmp) ,180 * (float) Math.cos(tmp), 180 * (float) Math.sin(tmp) * (float) Math.cos(tmp));
		transform.setScale(0.5f,0.5f,0.5f);
	
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
