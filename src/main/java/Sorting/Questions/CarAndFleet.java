package Sorting.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CarAndFleet {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/practice/question?questionId=152&sectionId=1&moduleId=2&topicId=7&subtopicId=85&homeworkId=18
        //https://leetcode.com/problems/car-fleet/
        /**
         * We first create a vector of pairs where the first element of each pair is a position and the second element
         * is the time it takes for the car at that position to reach the target, given its speed.
         * We then sort this vector in ascending order of positions.
         *
         * Next, we keep track of the number of car fleets and the time it takes for the slowest car in the current fleet
         * to reach the target. We start from the last car and traverse the vector in reverse, checking if the current
         * car takes more time than the slowest car in the current fleet. If it does, we increase the number of fleets
         * and update the time for the slowest car in the current fleet.
         */

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            String[] line = reader.readLine().trim().split(" ");
            int n = Integer.parseInt(line[0]);
            float target = Float.parseFloat(line[1]);

            float[][] cars = new float[n][2];

            String[] carPositions = reader.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                cars[i][0] = Float.parseFloat(carPositions[i]);
            }

            String[] carSpeeds = reader.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                cars[i][1] = Float.parseFloat(carSpeeds[i]);
            }

            System.out.println(getNumberOfFleet(n, target, cars));
        }

    }

    private static int getNumberOfFleet(int n, float target, float[][] cars) {
        //sort cars in terms of position in descending orders
        Arrays.sort(cars, (c1, c2) -> {
            if (c1[0] > c2[0]){
                return -1;
            } else if (c1[0] < c2[0]) {
                return 1;
            }else {
                return 0;
            }
        });

        float prev = (target - cars[0][0]) / cars[0][1];
        int fleet = 1;
        for (int i = 1; i < n; i++) {
            float curr = (target - cars[i][0]) / cars[i][1];
            if (curr <= prev) {
                continue;
            } else {
                prev = curr;
                fleet++;
            }
        }
        return fleet;
    }
}
