package college_labs.DCN_lab_6th_sem;

import java.util.Arrays;

public class DistanceVectorRouting {

    private static final int INFINITY = 999999;
    private static final int NUM_NODES = 5; // Number of nodes in the network

    private static int[][] distanceMatrix; // Distance matrix containing the costs between nodes
    private static int[][] nextHopMatrix; // Next hop matrix containing the next hops for each node

    public static void main(String[] args) {
        distanceMatrix = new int[NUM_NODES][NUM_NODES];
        nextHopMatrix = new int[NUM_NODES][NUM_NODES];

        // Initialize the distance matrix and next hop matrix
        for (int i = 0; i < NUM_NODES; i++) {
            Arrays.fill(distanceMatrix[i], INFINITY);
            Arrays.fill(nextHopMatrix[i], -1);
        }

        // Set the direct costs between neighboring nodes
        setDirectCost(0, 1, 1);
        setDirectCost(0, 2, 3);
        setDirectCost(1, 2, 1);
        setDirectCost(1, 3, 2);
        setDirectCost(2, 3, 1);
        setDirectCost(2, 4, 5);
        setDirectCost(3, 4, 3);

        // Run the Distance Vector Routing algorithm
        runDistanceVectorRouting();

        // Print the resulting distance matrix and next hop matrix
        printMatrix(distanceMatrix, "Distance Matrix");
        printMatrix(nextHopMatrix, "Next Hop Matrix");
    }

    private static void setDirectCost(int node1, int node2, int cost) {
        distanceMatrix[node1][node2] = cost;
        distanceMatrix[node2][node1] = cost;
        nextHopMatrix[node1][node2] = node2;
        nextHopMatrix[node2][node1] = node1;
    }

    private static void runDistanceVectorRouting() {
        boolean updated;
        do {
            updated = false;
            for (int source = 0; source < NUM_NODES; source++) {
                for (int destination = 0; destination < NUM_NODES; destination++) {
                    if (source != destination) {
                        int minDistance = distanceMatrix[source][destination];
                        int nextHop = nextHopMatrix[source][destination];

                        // Iterate over neighbors to find a better path
                        for (int neighbor = 0; neighbor < NUM_NODES; neighbor++) {
                            if (neighbor != source && neighbor != destination) {
                                int distance = distanceMatrix[source][neighbor] + distanceMatrix[neighbor][destination];
                                if (distance < minDistance) {
                                    minDistance = distance;
                                    nextHop = nextHopMatrix[source][neighbor];
                                }
                            }
                        }

                        // Update the distance matrix and next hop matrix if a better path is found
                        if (minDistance < distanceMatrix[source][destination]) {
                            distanceMatrix[source][destination] = minDistance;
                            nextHopMatrix[source][destination] = nextHop;
                            updated = true;
                        }
                    }
                }
            }
        } while (updated);
    }

    private static void printMatrix(int[][] matrix, String name) {
        System.out.println(name + ":");
        for (int i = 0; i < NUM_NODES; i++) {
            for (int j = 0; j < NUM_NODES; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}