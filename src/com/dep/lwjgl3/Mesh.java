package com.dep.lwjgl3;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

import com.base.engine.Util;
import com.base.engine.Vertex;


public class Mesh {

	private int vbo;
	private int ibo;

	//private int sizeVertex;
	private int sizeIndex;
	
	public Mesh() {
		
		vbo = glGenBuffers();
		ibo = glGenBuffers();
		sizeIndex = 0;
		//sizeVertex = 0;
	}
	
	public void addVertices(Vertex[] vertices, int[] indices) {
		
		//sizeVertex = vertices.length * Vertex.SIZE;
		sizeIndex = indices.length;
		
		glBindBuffer(GL_ARRAY_BUFFER,vbo);
		glBufferData(GL_ARRAY_BUFFER,Util.createFlippedBuffer(vertices),GL_STATIC_DRAW);
		
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER,Util.createFlippedBuffer(indices),GL_STATIC_DRAW);

	
	}
	
	public void draw() {
		
		glEnableVertexAttribArray(0);
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);
		
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		
		glDrawElements(GL_TRIANGLES, sizeIndex, GL_UNSIGNED_INT, 0);
		//glDrawArrays(GL_TRIANGLES, 0, sizeVertex);
		
		glDisableVertexAttribArray(0);
	}
}
