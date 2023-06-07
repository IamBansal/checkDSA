package college_labs.DCN_lab_6th_sem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkStateRouting {

        private static final int INFINITY = 999999;
        private static final int NUM_NODES = 5; // Number of nodes in the network

        private static int[][] costMatrix; // Cost matrix containing the costs between nodes
        private static List<Integer>[] adjacencyList; // Adjacency list representing the network graph

        public static void main(String[] args) {
            costMatrix = new int[NUM_NODES][NUM_NODES];
            adjacencyList = new ArrayList[NUM_NODES];

            // Initialize the cost matrix and adjacency list
            for (int i = 0; i < NUM_NODES; i++) {
                Arrays.fill(costMatrix[i], INFINITY);
                adjacencyList[i] = new ArrayList<>();
            }

            // Set the direct costs between neighboring nodes
            setDirectCost(0, 1, 1);
            setDirectCost(0, 2, 3);
            setDirectCost(1, 2, 1);
            setDirectCost(1, 3, 2);
            setDirectCost(2, 3, 1);
            setDirectCost(2, 4, 5);
            setDirectCost(3, 4, 3);

            // Run the Link State Routing algorithm
            runLinkStateRouting();

            // Print the resulting cost matrix
            printMatrix(costMatrix);
        }

        private static void setDirectCost(int node1, int node2, int cost) {
            costMatrix[node1][node2] = cost;
            costMatrix[node2][node1] = cost;
            adjacencyList[node1].add(node2);
            adjacencyList[node2].add(node1);
        }

        private static void runLinkStateRouting() {
            for (int source = 0; source < NUM_NODES; source++) {
                boolean[] visited = new boolean[NUM_NODES];
                int[] distances = new int[NUM_NODES];
                Arrays.fill(distances, INFINITY);
                distances[source] = 0;

                while (true) {
                    int minDistance = INFINITY;
                    int minNode = -1;

                    // Find the node with the minimum distance
                    for (int i = 0; i < NUM_NODES; i++) {
                        if (!visited[i] && distances[i] < minDistance) {
                            minDistance = distances[i];
                            minNode = i;
                        }
                    }

                    if (minNode == -1) {
                        break; // No unvisited nodes left
                    }

                    visited[minNode] = true;

                    // Update distances to neighboring nodes
                    for (int neighbor : adjacencyList[minNode]) {
                        int newDistance = distances[minNode] + costMatrix[minNode][neighbor];
                        if (newDistance < distances[neighbor]) {
                            distances[neighbor] = newDistance;
                        }
                    }
                }

                // Update the cost matrix with the shortest path distances from the source node
                System.arraycopy(distances, 0, costMatrix[source], 0, NUM_NODES);
            }
        }

        private static void printMatrix(int[][] matrix) {
            System.out.println("Cost Matrix" + ":");
            for (int i = 0; i < NUM_NODES; i++) {
                for (int j = 0; j < NUM_NODES; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }


}
