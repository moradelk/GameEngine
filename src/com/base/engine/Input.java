package com.base.engine;
import org.lwjgl.glfw.GLFWKeyCallback;
import static org.lwjgl.glfw.GLFW.*;

public class Input extends GLFWKeyCallback{

  public boolean[] keys = new boolean[65536];
  // The GLFWKeyCallback class is an abstract method that
  // can't be instantiated by itself and must instead be extended
  // 
  @Override
  public void invoke(long window, int key, int scancode, int action, int mods) {
    // TODO Auto-generated method stub
    keys[key] = action != GLFW_RELEASE ;
    System.out.println("Some hit");
  }

  // boolean method that returns true if a given key
  // is pressed.
  public boolean isKeyDown(int keycode) {
    return keys[keycode];
  }
	
}
