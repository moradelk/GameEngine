package com.base.math;

public class Vector2f {

	private float x;
	private float y;

	public Vector2f() {
		x = 0;
		y = 0;
	};

	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vector2f add(Vector2f v) {
		return new Vector2f(x + v.x, y + v.y);
	}

	public Vector2f sub(Vector2f v) {
		return new Vector2f(x - v.x, y - v.y);
	}

	public Vector2f mul(float l) {
		return new Vector2f(l * x, l * y);
	}

	public Vector2f mul(Vector2f v) {
		return new Vector2f(x * v.x, y * v.y);
	}

	public Vector2f rotate(float phi) {
		double rad=Math.toRadians(phi);
		double sin=Math.sin(rad);
		double cos=Math.cos(rad);
		return new Vector2f((float) (x*cos - y*sin), (float) (x*sin - y*cos));
	}

	public float dot(Vector2f v) {
		return (x * v.x + y * v.y);
	}

	public float length() {
		return (float) Math.sqrt(dot(this));
	}

	public void normalize() {
		float l = length();
		if (l != 0) {
			x = x / l;
			y = y / l;
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
