package game.math;

public class Quaternion {

	private float x;
	private float y;
	private float z;
	private float w;

	public Quaternion() {
		x = 0;
		y = 0;
		z = 0;
		w = 0;

	}

	public Quaternion(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;

	}

	public Quaternion(Vector3f v, float w) {
		x = v.getX();
		y = v.getY();
		z = v.getZ();
		this.w = w;

	}

	public float length() {

		return (float) Math.sqrt(x * x + y * y + z * z + w * w);
	}

	public Quaternion normalize() {
		float length = length();
		if (length != 0) {
			x = x / length;
			y = y / length;
			z = z / length;
			w = w / length;
		}
		return this;
	}

	public Quaternion conjugate() {
		return new Quaternion(-x, -y, -z, w);
	}

	public Quaternion add(Quaternion v) {
		return new Quaternion(x + v.x, y + v.y, z + v.z, w + v.w);
	}

	public Quaternion sub(Quaternion v) {
		return new Quaternion(x - v.x, y - v.y, z - v.z, w - v.w);
	}

	public Quaternion mul(Quaternion v) {

		Vector3f a = new Vector3f(x, y, z);
		Vector3f b = new Vector3f(v.getX(), v.getY(), v.getZ());

		return new Quaternion(b.mul(w).add(a.mul(v.getW())).add(a.cross(b)), w * v.getW() - a.dot(b));

	}

	public Quaternion mul(Vector3f v) {

		return this.mul(new Quaternion(v.getX(), v.getY(), v.getZ(), 0));
	}

	public String toString() {
		return "(" + x + ", " + y + ", " + z + " " + w + ")";
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
