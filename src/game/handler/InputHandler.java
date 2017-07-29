package game.handler;

import game.modul.KeyboardModul;
import game.modul.MouseModul;

public class InputHandler {

	private static KeyboardModul keyboard;
	private static MouseModul mouse;

	public static void init() {

		keyboard = new KeyboardModul();
		mouse = new MouseModul();
		keyboard.init();
		mouse.init();
	}

	public static void update() {

		keyboard.update();
		mouse.update();
	}

	public static boolean getKey(int keycode) {
		return keyboard.getKey(keycode);
	}

	public static boolean getKeyDown(int keyCode) {
		return keyboard.getKeyDown(keyCode);
	}

	public static boolean getKeyUp(int keyCode) {
		return keyboard.getKeyUp(keyCode);
	}

	public static boolean getButton(int button) {
		return mouse.getButton(button);
	}

	public static boolean getButtonDown(int button) {
		return mouse.getButtonDown(button);

	}

	public static boolean getButtonUp(int button) {
		return mouse.getButtonUp(button);

	}

	public static double getCursorPosX() {
		return mouse.getCursorPosX();

	}

	public static double getCursorPosY() {
		return mouse.getCursorPosY();
	}

}
