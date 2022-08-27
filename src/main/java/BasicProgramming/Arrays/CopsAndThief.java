package BasicProgramming.Arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CopsAndThief {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=610&sectionId=1&moduleId=0&topicId=42&subtopicId=585&assignmentId=93

        Scanner s = new Scanner(System.in);
        String[] mXy = s.nextLine().split(" ");
        List<Integer> copHouse = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int totalDistance = Integer.parseInt(mXy[1]) * Integer.parseInt(mXy[2]);
        Set<Integer> unsafeHouse = new HashSet<>();

        for (int i=0; i<Integer.parseInt(mXy[0]); i++){
            int ll = copHouse.get(i) - totalDistance, ul = copHouse.get(i) + totalDistance;

            if (ll >= 1 && ul <= 100) {
                unsafeHouse.addAll(IntStream.iterate(ll, j -> j+1)
                        .limit((ul-ll)+1).boxed().collect(Collectors.toList()));
            } else {
                if (ll < 1 && ul > 100){
                    unsafeHouse.addAll(IntStream.iterate(1, j -> j+1)
                            .limit(100).boxed().collect(Collectors.toList()));
                }
                else if (ll < 1) {
                    unsafeHouse.addAll(IntStream.iterate(1, j -> j+1)
                            .limit((ul-1)+1).boxed().collect(Collectors.toList()));
                }else if (ul > 100) {
                    unsafeHouse.addAll(IntStream.iterate(ll, j -> j+1)
                            .limit((100-ll)+1).boxed().collect(Collectors.toList()));
                }
            }
        }

        System.out.println(100- unsafeHouse.size());
    }
}
