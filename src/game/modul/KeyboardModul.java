package game.modul;

import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;

public class KeyboardModul {

	private final int NUM_KEYCODES = 1024;

	private boolean[] keys = new boolean[NUM_KEYCODES];

	private boolean[] currentKeys = new boolean[NUM_KEYCODES];
	private boolean[] downKeys = new boolean[NUM_KEYCODES];
	private boolean[] upKeys = new boolean[NUM_KEYCODES];

	private long window;

	public void init() {
		window = GLFW.glfwGetCurrentContext();
		glfwSetKeyCallback(window, new GLFWKeyCallback() {

			@Override
			public void invoke(long window, int key, int scancode, int action, int mods) {

				keys[key] = action != GLFW_RELEASE;

				// pressedKeys.put(new Integer(key), new Boolean(action !=
				// GLFW_RELEASE));
			}
		});

	}

	public void update() {

		for (int i = 0; i < NUM_KEYCODES; i++) {

			upKeys[i] = false;
			downKeys[i] = false;

			if (!getKey(i) && currentKeys[i])
				upKeys[i] = true;
			if (getKey(i) && !currentKeys[i])
				downKeys[i] = true;

			currentKeys[i] = false;
			if (getKey(i))
				currentKeys[i] = true;

		}

	}


	public boolean getKey(int keycode) {
		/*
		 * if(pressedKeys.containsKey(keycode)) return
		 * pressedKeys.get(keycode).booleanValue(); return false;
		 */
		return keys[keycode];
	}

	public boolean getKeyDown(int keyCode) {
		return downKeys[keyCode];

	}

	public boolean getKeyUp(int keyCode) {
		return upKeys[keyCode];

	}

}
