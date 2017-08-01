package game;
import static com.sun.glass.events.KeyEvent.*;

import game.handler.InputHandler;
import game.math.Vector3f;
import game.object.GridXY;
import game.object.SphereObject;
import game.util.Time;





public class Game {

	
	private SphereObject sphere;
	private SphereObject sphere2;
	public Game() {
	

	
		
		sphere = new SphereObject();
		sphere2 = new SphereObject();
		
	}
	

	public  void render() {

		sphere.draw();
		sphere2.draw();
		GridXY.draw();
		
	}

	float tmp=0;
	
	public  void update() {
		
		//Input.update();
		tmp += Time.getDelta()/5;
		float a =(float) Math.cos(tmp);
		float b = (float) Math.sin(tmp);
		sphere.setPos(new Vector3f(a,b,10+a+b));
		sphere2.setPos(new Vector3f(a,-b,10-+a-b));

		input();
	
	}

	public  void input() {

		
		if(InputHandler.getKeyDown(VK_SPACE))
			System.out.println("Pressed space");
		if(InputHandler.getKeyUp(VK_SPACE))
			System.out.println("Pressed released");
		if(InputHandler.getButtonDown(0)) {
			double xpos = InputHandler.getCursorPosX();
			double ypos = InputHandler.getCursorPosY();
			System.out.println("Left button pressed at " + xpos  + ", " + ypos );
		}
			
		if(InputHandler.getButtonUp(0)) {
			double xpos = InputHandler.getCursorPosX();
			double ypos = InputHandler.getCursorPosY();
			System.out.println("Left button released at " + xpos + ", " + ypos);
		}

		
	}
	
	
	
	
}
