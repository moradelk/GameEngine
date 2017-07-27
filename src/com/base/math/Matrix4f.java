package com.base.math;

public class Matrix4f {

	private float[][] m;

	public Matrix4f() {
		m = new float[4][4];
	}

	public void initIdentity() {
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				if (i == j)
					m[i][j] = 1;
				else
					m[i][j] = 0;

			}

	}
	public Matrix4f initTranslation(Vector3f t) {
		return initTranslation(t.getX(),t.getY(),t.getZ());
		
	}	
	public Matrix4f initTranslation(float x, float y, float z) {
		initIdentity();
		m[0][3] = x;
		m[1][3] = y;
		m[2][3] = z;
		m[3][3] = 1;
		
		return this;

	}

	public Matrix4f initRotation(Vector3f r) {
		return initRotation(r.getX(),r.getY(),r.getZ());
	}
	public Matrix4f initRotation(float x, float y, float z) {
		
		Matrix4f rz = new Matrix4f();
		Matrix4f rx = new Matrix4f();
		Matrix4f ry = new Matrix4f();

		rz.initIdentity();
		rx.initIdentity();
		ry.initIdentity();
		
		z = (float) Math.toRadians(z);
		x = (float) Math.toRadians(x);
		y = (float) Math.toRadians(y);
		
		rz.set(0, 0, (float) Math.cos(z));
		rz.set(0, 1, -(float) Math.sin(z));
		rz.set(1, 0, (float) Math.sin(z));
		rz.set(1, 1, (float) Math.cos(z));
		
		rx.set(1, 1, (float) Math.cos(x));
		rx.set(1, 2, -(float) Math.sin(x));
		rx.set(2, 1, (float) Math.sin(x));
		rx.set(2, 2, (float) Math.cos(x));

		ry.set(0, 0, (float) Math.cos(y));
		ry.set(0, 2, -(float) Math.sin(y));
		ry.set(2, 0, (float) Math.sin(y));
		ry.set(2, 2, (float) Math.cos(y));

		
		m = (rx.mul(ry.mul(rz))).getM();
		
		return this;

	}


	public Matrix4f initScale(Vector3f scale) {
		return initScale(scale.getX(), scale.getY(), scale.getZ());
	}

	
	public Matrix4f initScale(float x, float y, float z) {
		initIdentity();
		m[0][0] = x;
		m[1][1] = y;
		m[2][2] = z;
		
		return this;
	}

	public Matrix4f mul(Matrix4f r) {
		Matrix4f res = new Matrix4f();

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				float val = 0;
				for (int k = 0; k < 4; k++)
					val += m[i][k] * r.get(k, j);
				res.set(i, j, val);
			}

		return res;
	}

	public float get(int x, int y) {
		return m[x][y];
	}

	public void set(int x, int y, float value) {
		m[x][y] = value;
	}

	public float[][] getM() {
		return m;
	}

	public void setM(float[][] m) {
		this.m = m;
	}

}
