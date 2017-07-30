package game.object;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import game.math.Vertex;
import game.util.ResourceLoader;
import game.util.Util;

public class Sphere {

	private static int vbo;
	private static int ibo;
	private static final String FILENAME = "sphere.obj";
	private static int sizeIndex;


	public static void init() {

		vbo = glGenBuffers();
		ibo = glGenBuffers();
		sizeIndex=0;
		ResourceLoader.loadSphere(FILENAME);

	}

	public static void addVertices(Vertex[] vertices, int[] indices) {

		sizeIndex = indices.length;

		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);

		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, Util.createFlippedBuffer(indices), GL_STATIC_DRAW);

	}

	public static void draw() {


		glEnableVertexAttribArray(0);

		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);

		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);

		// glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
		glDrawElements(GL_TRIANGLES, sizeIndex, GL_UNSIGNED_INT, 0);

		glDisableVertexAttribArray(0);
	}
}
