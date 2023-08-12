package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnionOf2SortedArray {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=182&sectionId=1&moduleId=2&topicId=8&subtopicId=108&homeworkId=26

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]), n = Integer.parseInt(s[1]);
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];
        for (int i=0; i<m; i++){
            arr1[i] = Integer.parseInt(s1[i]);
        }
        for (int i=0; i<n; i++){
            arr2[i] = Integer.parseInt(s2[i]);
        }

        int i=0, j=0;
        while (i < m && j < n){
            if (arr1[i] < arr2[j]){
                System.out.print(arr1[i]+" ");
                int p = arr1[i];
                while (i < m && arr1[i] == p){
                    i++;
                }
            } else if (arr1[i] > arr2[j]) {
                System.out.print(arr2[j]+" ");
                int p = arr2[j];
                while (j < n && arr2[j] == p){
                    j++;
                }
            }else {
                System.out.print(arr1[i]+" ");
                int p = arr1[i];
                while (i < m && arr1[i] == p) {
                    i++;
                }
                while (j < n && arr2[j] == p) {
                    j++;
                }
            }
        }
        if (i < m){
            while (i < m){
                System.out.print(arr1[i]+" ");
                i++;
            }
        }
        if (j < n){
            while (j < n){
                System.out.print(arr2[j]+" ");
                j++;
            }
        }
        System.out.println();
    }
}
