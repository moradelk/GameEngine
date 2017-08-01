package game.test;

import java.util.ArrayList;

public class BufferUtil {


	public static void main(String[] args) {
	
		ArrayList<Integer> indices = new ArrayList<Integer>();;
		System.out.println("Hallo");
		BufferUtil.setArray(indices);

		System.out.println(indices);

	}
	
	public static void setArray(ArrayList<Integer> indices) {
		indices.add(9);
		indices.add(9);
		indices.add(1);
	}

}
