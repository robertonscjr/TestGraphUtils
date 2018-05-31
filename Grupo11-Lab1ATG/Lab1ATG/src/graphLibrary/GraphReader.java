package graphLibrary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class GraphReader {

	public static Graph readGraph(String filePath, boolean weighted) throws IOException {
		Graph graph = null;
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(filePath));

			String line = br.readLine();

			graph = new Graph(Integer.parseInt(line.trim()));

			int[] vertices = null;
			
			while (true) {
				line = br.readLine();
				if (line == null)
					break;
				String[] aux = line.trim().split(" ");

				Edge edge1 = null;
				Edge edge2 = null;

				Vertex<Integer> v1;
				Vertex<Integer> v2;

				int[] data;

				if(weighted == false) {

					if (aux.length != 2) {
						throw new IOException("Expected two vertices per edge");
					}

					data = Arrays.stream(aux)
							.mapToInt(Integer::parseInt).toArray();

					v1 = new Vertex<Integer>(data[0]);
					v2 = new Vertex<Integer>(data[1]);

					graph.setWeight(v1, v2, 1f);

					edge1 = new Edge(v1, v2);



				}else {

					if (aux.length != 3) {
						throw new IOException("Expected two vertices per edge and weight");
					}

					Integer v1Value = Integer.parseInt(aux[0]);
					Integer v2Value = Integer.parseInt(aux[1]);
					Float  weight = Float.parseFloat((aux[2]));

					v1 = new Vertex<Integer>(v1Value);
					v2 = new Vertex<Integer>(v2Value);

					edge1 = new Edge(v1, v2, weight);



				}

				graph.addEdge(edge1);


			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}

		return graph;
	}

}
