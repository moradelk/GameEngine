package game.object;

import game.math.Transform;
import game.math.Vector3f;
import game.modul.ShaderModul;
import game.modul.WindowModul;
import game.util.ResourceLoader;

public class SphereObject {
	private ShaderModul shader;

	public Transform transform;

	private Vector3f scale;
	private Vector3f pos;
	private float theta;
	private float phi;

	public SphereObject() {

		shader = new ShaderModul();

		transform = new Transform();
		transform.setProjection(70f, WindowModul.getCurrentWidth(), WindowModul.getCurrentHeight(), 0.1f, 1000f);
		shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
		shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));
		shader.compileShader();
		shader.addUniform("transform");
		scale = new Vector3f(1, 1, 1);
		pos = new Vector3f(0, 0, 5);
		theta = 0;
		phi = 0;

	}

	public void draw() {
		
		transform.setTranslation(pos);
		transform.setRotation(180 * (float) Math.sin(1), 180 * (float) Math.cos(-0.3),
				180 * (float) Math.sin(0) * (float) Math.cos(1));
		transform.setScale(scale);
		shader.bind();
		shader.setUniform("transform", transform.getProjectedTransformation());
		Sphere.draw();
		shader.unbind();
	}

	public Vector3f getScale() {
		return scale;
	}

	public void setScale(Vector3f scale) {
		this.scale = scale;
	}

	public Vector3f getPos() {
		return pos;
	}

	public void setPos(Vector3f pos) {
		this.pos = pos;
	}

	public float getTheta() {
		return theta;
	}

	public void setTheta(float theta) {
		this.theta = theta;
	}

	public float getPhi() {
		return phi;
	}

	public void setPhi(float phi) {
		this.phi = phi;
	}

}
