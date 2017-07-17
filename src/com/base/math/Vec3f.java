package com.base.math;

public class Vec3f {

	private float x;
	private float y;
	private float z;
	
	
	public Vec3f() {
		x=0;
		y=0;
		z=0;
	};
	
	public Vec3f(float x, float y, float z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public Vec3f add(Vec3f v) {
		return new Vec3f(x+v.x, y+v.y, z+v.z);
	}

	public Vec3f sub(Vec3f v) {
		return new Vec3f(x-v.x, y-v.y, z-v.z);
	}
	
	public Vec3f mul(float l) {
		return new Vec3f(l*x, l*y, l*z);
	}

	public Vec3f mul(Vec3f v) {
		return new Vec3f(x*v.x, y*v.y, z*v.z);
	}
	
	public float dot(Vec3f v) {
		return (x*v.x + y*v.y + z*v.z);
	}
	
	public Vec3f cross(Vec3f v) {
		
		return new Vec3f(y*v.z - z*v.y, z*v.x - x*v.z, x*v.y - y*v.x);
		
	}
	
	public float length() {
		return (float) Math.sqrt(dot(this));	
	}
	
	public void normalize() {
		float l = length();
		if(l!=0) {
			x=x/l;
			y=y/l;
			z=z/l;
		}
	}
	
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
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
	
	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	
	
	
}
