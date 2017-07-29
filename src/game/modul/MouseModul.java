package game.modul;

import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

public class MouseModul extends GLFWMouseButtonCallback {

	private final int NUM_MOUSEBUTTONS = 16;

	private boolean[] buttons = new boolean[NUM_MOUSEBUTTONS];
	private boolean[] currentButtons = new boolean[NUM_MOUSEBUTTONS];
	private boolean[] downButtons= new boolean[NUM_MOUSEBUTTONS];
	private boolean[] upButtons = new boolean[NUM_MOUSEBUTTONS];

	private long window;
	
	public void init() {
		window=GLFW.glfwGetCurrentContext();
		GLFW.glfwSetMouseButtonCallback(window, this);

		
	}

	public void update() {

		for (int i = 0; i < NUM_MOUSEBUTTONS; i++) {

			upButtons[i] = false;
			if (!getButton(i) && currentButtons[i])
				upButtons[i] = true;


			downButtons[i] = false;
			if (getButton(i) && !currentButtons[i])
				downButtons[i] = true;

			currentButtons[i] = false;
			if (getButton(i))
				currentButtons[i] = true;
		}

	}

	
	@Override
	public void invoke(long window, int button, int action, int mods) {
		
		buttons[button] = action != GLFW_RELEASE;
		
	}
	

	public boolean getButton(int button) {
		return buttons[button];
	}

	public boolean getButtonDown(int button) {
		return downButtons[button];

	}

	public boolean getButtonUp(int button) {
		return upButtons[button];

	}

	public double getCursorPosX() {
		double xpos[] =  {0} ,ypos[] = {0};
		GLFW.glfwGetCursorPos(GLFW.glfwGetCurrentContext(), xpos, ypos);
		return xpos[0];
	}

	public double getCursorPosY() {
		double xpos[] =  {0} ,ypos[] = {0};
		GLFW.glfwGetCursorPos(GLFW.glfwGetCurrentContext(), xpos, ypos);
		return ypos[0];
	}

}
