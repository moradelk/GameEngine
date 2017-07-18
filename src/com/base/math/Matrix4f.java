package com.base.math;

public class Matrix4f {

	private float[][] m;

	public Matrix4f() {
		setM(new float[4][4]);
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
