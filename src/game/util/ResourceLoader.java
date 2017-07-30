package game.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import game.math.Vector3f;
import game.math.Vertex;

import game.object.Sphere;

public class ResourceLoader {

	public static String loadShader(String fileName) {

		StringBuilder shaderSource = new StringBuilder();
		BufferedReader shaderReader;
		try {
			shaderReader = new BufferedReader(new FileReader("./res/shaders/" + fileName));

			String line;
			while ((line = shaderReader.readLine()) != null) {
				shaderSource.append(line).append("\n");
			}

			shaderReader.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		return shaderSource.toString();
	}

	public static void loadSphere(String filename) {

		String[] splitArray = filename.split("\\.");
		String extension = splitArray[splitArray.length - 1];

		if (!extension.equals("obj")) {
			System.err.println("Error: File format" + extension + " not supported for mesh data: " + filename);
			new Exception().printStackTrace();
			System.exit(1);
		}

		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		ArrayList<Integer> indices = new ArrayList<Integer>();

		BufferedReader meshReader = null;
		try {

			meshReader = new BufferedReader(new FileReader("./res/mesh/" + filename));
			String line;

			while ((line = meshReader.readLine()) != null) {

				String[] tokens = line.split(" ");
				tokens = Util.removeEmptyStrings(tokens);

				if (tokens.length == 0 || tokens[0].equals("#"))
					continue;
				else if (tokens[0].equals("v")) {

					Vector3f vertex = new Vector3f(Float.valueOf(tokens[1]), Float.valueOf(tokens[2]), Float.valueOf(tokens[3]));
					vertices.add(new Vertex(vertex));
					
				}

				else if (tokens[0].equals("f")) {

					indices.add(Integer.parseInt(tokens[1])-1);
					indices.add(Integer.parseInt(tokens[2])-1);
					indices.add(Integer.parseInt(tokens[3])-1);
					
				}

			}

			meshReader.close();


			Vertex[] vertexData = new Vertex[vertices.size()];
			vertices.toArray(vertexData);
			
			Integer[] indexData = new Integer[indices.size()];
			indices.toArray(indexData);
			
						
			int[] intIndexData = Util.toIntArray(indexData);
			Sphere.addVertices(vertexData, intIndexData);
			System.err.println("Sphere loaded");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	}
