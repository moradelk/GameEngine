package com.base.math;

public class Quat4f {

	private float x;
	private float y;
	private float z;
	private float w;

	public Quat4f() {
		x=0;
		y=0;
		z=0;
		w=0;
		
	}

	public Quat4f(float x, float y ,float z, float w) {
		this.x=x;
		this.y=y;
		this.z=z;
		this.w=w;
		
	}

	public Quat4f(Vec3f v, float w) {
		x=v.getX();
		y=v.getY();
		z=v.getZ();
		this.w=w;
		
	}
	
	
	
	public Quat4f mul(Quat4f v) {
		
		Vec3f a = new Vec3f(x,y,z);
		Vec3f b = new Vec3f(v.getX(),v.getY(),v.getZ());

		return new Quat4f(b.mul(w).add( a.mul(v.getW())).add( a.cross(b) ), w*v.getW()-a.dot(b));
		
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

	public float getW() {
		return w;
	}
	
	public void setW(float w) {
		this.w = w;
	}

}
