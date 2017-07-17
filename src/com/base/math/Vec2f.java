package com.base.math;

public class Vec2f {
	
	private float x;
	private float y;
	
	public Vec2f() {
		x=0;
		y=0;
	};
	
	public Vec2f(float x, float y) {
		this.x=x;
		this.y=y;
	}
	
	public Vec2f add(Vec2f v) {
		return new Vec2f(x+v.x, y+v.y);
	}

	public Vec2f sub(Vec2f v) {
		return new Vec2f(x-v.x, y-v.y);
	}
	
	public Vec2f mul(float l) {
		return new Vec2f(l*x, l*y);
	}

	public Vec2f mul(Vec2f v) {
		return new Vec2f(x*v.x, y*v.y);
	}

	
	public float dot(Vec2f v) {
		return (x*v.x + y*v.y);
	}
	
	public float length() {
		return (float) Math.sqrt(dot(this));	
	}
	
	public void normalize() {
		float l = length();
		if(l!=0) {
			x=x/l;
			y=y/l;					
		}
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	

}
