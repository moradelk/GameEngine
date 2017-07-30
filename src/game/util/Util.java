package game.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

import game.math.Matrix4f;
import game.math.Vertex;


public class Util {

	public static FloatBuffer createFlippedBuffer(Vertex[] vertices) {
		
		ByteBuffer bb = ByteBuffer.allocateDirect(vertices.length * Vertex.SIZE * 4 ); //4 Byte per float
		bb.order(ByteOrder.nativeOrder());
		FloatBuffer buffer = bb.asFloatBuffer();
		
		for (int i = 0; i< vertices.length ; i++) {

			buffer.put(vertices[i].getPos().getX());
			buffer.put(vertices[i].getPos().getY());
			buffer.put(vertices[i].getPos().getZ());

			
		}
		buffer.position(0);		
		
	
		return buffer;
			
	}

	
	public static IntBuffer createFlippedBuffer(int[] indices ) {
		
		ByteBuffer bb = ByteBuffer.allocateDirect(indices.length * Vertex.SIZE * 4 ); //4 Byte per float
		bb.order(ByteOrder.nativeOrder());

		IntBuffer buffer = bb.asIntBuffer();
		
		buffer.put(indices);
		buffer.position(0);		

		return buffer;
		
	}
	
	public static FloatBuffer createFlippedBuffer(Matrix4f value) {

		ByteBuffer bb = ByteBuffer.allocateDirect(4 * 4 * 4 ); //4 Byte per float
		bb.order(ByteOrder.nativeOrder());
		FloatBuffer buffer = bb.asFloatBuffer();

		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				buffer.put(value.get(i, j));
			}
		}
		
		buffer.position(0);		

		return buffer;
	}


	public static String[] removeEmptyStrings(String[] tokens) {
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0; i< tokens.length; i++) {
			if(!tokens[i].equals(""))
				result.add(tokens[i]);
		}
		
		String[] res = new String[result.size()]; 

		result.toArray(res);
		return res;
		
	}


	public static int[] toIntArray(Integer[] data) {
		int[] result = new int[data.length];
		for(int i = 0; i<data.length; i++)
			result[i]=data[i].intValue();
		
		return result;
	}
	
}
