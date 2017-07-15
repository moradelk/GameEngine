package com.base.engine;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;


public class Util {

	public static FloatBuffer createFloatBuffer(int size) {
		return BufferUtils.createFloatBuffer(size);
	}
	
	public static FloatBuffer createFlippedBuffer(Vertex[] vertices) {
		
		FloatBuffer buffer = createFloatBuffer(vertices.length * Vertex.SIZE );
		
		for (int i = 0; i< vertices.length ; i++) {
			buffer.put(vertices[i].getPos().x);
			buffer.put(vertices[i].getPos().y);
			buffer.put(vertices[i].getPos().z);
			
		}
		buffer.flip();
		
		return buffer;
		
	}
	
}
