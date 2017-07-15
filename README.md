# GameEngine

package com.base.engine;
import org.lwjgl.glfw.GLFWKeyCallback;
import static org.lwjgl.glfw.GLFW.*;

public class Input extends GLFWKeyCallback {

	public static final int NUM_KEYCODES = 256;

	private static boolean[] keys = new boolean[NUM_KEYCODES];
	private static boolean[] currentKeys = new boolean[NUM_KEYCODES];
	private static boolean[] downKeys = new boolean[NUM_KEYCODES];
	private static boolean[] upKeys = new boolean[NUM_KEYCODES];

	public static void update() {

		for (int i = 0; i < NUM_KEYCODES; i++) {

			upKeys[i] = false;
			if (!getKey(i) && currentKeys[i])
				upKeys[i] = true;


			downKeys[i] = false;
			if (getKey(i) && !currentKeys[i])
				downKeys[i] = true;

			currentKeys[i] = false;
			if (getKey(i))
				currentKeys[i] = true;
		}

	}

	@Override
	public void invoke(long window, int key, int scancode, int action,
			int mods) {

		keys[key] = action != GLFW_RELEASE;

	}

	public static boolean getKey(int keycode) {
		return keys[keycode];
	}

	public static boolean getKeyDown(int keyCode) {
		return downKeys[keyCode];

	}

	public static boolean getKeyUp(int keyCode) {
		return upKeys[keyCode];

	}

}
