import java.util.Scanner;

// create TSPExample class to implement TSP code in Java
class TSPExample {
    // create findTSP() method to get minimum weighted cycle
    static int findTSP(int[][] distance, boolean[] visitCity, int currPos, int cities, int count, int cost,
            int tspCycle) {

        if (count == cities && distance[currPos][0] > 0) {
            tspCycle = Math.min(tspCycle, cost + distance[currPos][0]);
            return tspCycle;
        }

        // BACKTRACKING STEP
        for (int i = 0; i < cities; i++) {
            if (visitCity[i] == false && distance[currPos][i] > 0) {

                // Mark as visited
                visitCity[i] = true;
                tspCycle = findTSP(distance, visitCity, i, cities, count + 1, cost + distance[currPos][i], tspCycle);

                // Mark ith node as unvisited
                visitCity[i] = false;
            }
        }
        return tspCycle;
    }

    // main() method start
    public static void main(String[] args) {
        int cities;

        // create scanner class object to get input from user
        Scanner sc = new Scanner(System.in);

        // get total number of cities from the user
        System.out.println("Enter total number of cities ");
        cities = sc.nextInt();

        // get distance of cities from the user
        int distance[][] = new int[cities][cities];
        for (int i = 0; i < cities; i++) {
            for (int j = 0; j < cities; j++) {
                System.out.println("Distance from city" + (i + 1) + " to city" + (j + 1) + ": ");
                distance[i][j] = sc.nextInt();
            }
        }

        // create an array of type boolean to check if a node has been visited or not
        boolean[] visitCity = new boolean[cities];

        // by default, we make the first city visited
        visitCity[0] = true;

        int tspCycle = Integer.MAX_VALUE;

        // call findTSP() method that returns the minimum weight Hamiltonian Cycle
        tspCycle = findTSP(distance, visitCity, 0, cities, 1, 0, tspCycle);

        // print the minimum weighted Hamiltonian Cycle
        System.out.println(tspCycle);
    }
}
