package game.object;



import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.*;


import game.math.Vector3f;
import game.math.Vertex;
import game.util.Util;

//4 Points at (0,0),..,(1,1)
public class GridXY {

	private static int vbo;
	private static int ibo;
	private static int vao;
	private static int sizeIndex;


	public static void init() {

		vbo = glGenBuffers();
		ibo = glGenBuffers();

		vao = glGenVertexArrays();
		
		sizeIndex=0;

		Vertex[] vertices = {
				new Vertex(new Vector3f(0,0,0)),
				new Vertex(new Vector3f(1,0,0)),
				new Vertex(new Vector3f(0,1,0)),
				new Vertex(new Vector3f(1,1,0))};
		int[] indices = {0,1,2,2,1,3};
		addVertices(vertices, indices);
		
		glBindVertexArray(vao);


		addVertices(vertices, indices);
		glEnableVertexAttribArray(0);

		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);

		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		
		glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
		
		glBindVertexArray(0);
	}

	private static void addVertices(Vertex[] vertices, int[] indices) {

		sizeIndex = indices.length;

		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);

		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, Util.createFlippedBuffer(indices), GL_STATIC_DRAW);

	}

	public static void draw() {


		glBindVertexArray(vao);
		glDrawElements(GL_TRIANGLES, sizeIndex, GL_UNSIGNED_INT, 0);

	}
}
