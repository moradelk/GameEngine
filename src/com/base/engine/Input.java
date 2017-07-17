package com.base.engine;

import com.dep.input.Keyboard;
import com.dep.input.Mouse;

public class Input  {

	private static Keyboard keyboard;
	private static Mouse mouse;
	
	public static void init() {
		
		keyboard = new Keyboard();
		mouse = new Mouse();
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

}
