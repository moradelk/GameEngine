package com.base.engine;

import com.sun.javafx.geom.Vec3f;


public class Vertex {
	
	public static final int SIZE = 3;
	
	private Vec3f pos;
	
	public Vertex(Vec3f pos) {
		this.setPos(pos);
	}

	public Vec3f getPos() {
		return pos;
	}

	public void setPos(Vec3f pos) {
		this.pos = pos;
	}
	
	
	
	
}
