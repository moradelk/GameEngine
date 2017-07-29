package game.math;

public class Transform {

	
	private static float zNear, zFar;
	private static float width, height;
	private static float fov;
	
	
	private Vector3f translation;
	private Vector3f rotation;
	private Vector3f scale;
	public Transform() {
		
		translation = new Vector3f(0,0,0);
		rotation = new Vector3f(0,0,0);
		scale = new Vector3f(1,1,1);
	}

	public Matrix4f getTransformation(){
		
		Matrix4f transformationMatrix= new Matrix4f().initTranslation(translation);
		Matrix4f rotationMatrix = new Matrix4f().initRotation(rotation);
		Matrix4f scaleMatrix = new Matrix4f().initScale(scale);
		return transformationMatrix.mul(rotationMatrix.mul(scaleMatrix));
		
		
	}
	
	public Matrix4f getProjectedTransformation() {
		
		Matrix4f transformationMatrix = this.getTransformation();
		Matrix4f projectionMatrix = new Matrix4f();
		projectionMatrix.initProjection(fov, width, height, zNear,  zFar);
		return projectionMatrix.mul(transformationMatrix);
	}
	
	public Vector3f getTranslation() {
		return translation;
	}

	public void setProjection(float fov, float width, float height, float zNear, float zFar) {

		Transform.fov=fov;
		Transform.width=width;
		Transform.height=height;
		Transform.zNear=zNear;
		Transform.zFar=zFar;
	}

	public void setTranslation(Vector3f translation) {
		this.translation = translation;
	}

	public void setTranslation(float x, float y, float z) {
		this.translation = new Vector3f(x,y,z);
	}

	public Vector3f getRotation() {
		return rotation;
	}

	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}
	public void setRotation(float x, float y, float z) {
		this.rotation = new Vector3f(x,y,z);
	}

	public Vector3f getScale() {
		return scale;
	}

	public void setScale(Vector3f scale) {
		this.scale = scale;
	}

	public void setScale(float x, float y, float z) {
		this.scale = new Vector3f(x,y,z);
	}

}
