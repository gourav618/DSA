package Arrays.Concept;

public class HistogramProblem {

    //Heights of N pillars in  int Arr[N] ex- [0,1,0,2,1,3,0,2] --> plot this as histogram graph
    // find the total height of water trapped in rainfall
    // water will rest in gaps between the pillars created i.e in above arr 1,0,2 will have gap in between since 2nd pillar has height 0
    //o/p : 4 since gap between 1,0,2 and height diff 1
    //              gap between 2,1,3 and height diff 1
    //              gap between 3,0,2 and height diff 2
    // total height  = 1+1+2 = 4 , either side we dont have protection of pillar so no water trapped
    //Note: water will get trapped in a pillar i , only if we have atleast one pillar on left greater than ith pillar(i.e h1)
    // and one pillar on right with greater height (i.e h2)
    // deciding height of ith pillar (i.e with height h)  = min (h1, h2) and if (dec. height <= h) -> no water trapped
    // dec ht of water  = dec ht of pillar - h i,e ht of ith pillar
    //at any ith index pi = min(pMax[i-1], sMax[i+1]) i.e ht of water and ith pillar and then minus it with current ht.
    //Time complexity: O(N)
    //Space complexity: O(N)
    public static void main(String [] args){

        int [] a = {0,1,0,2,1,3,0,2};
        int[] prefixMaxSumArray = getPrefixMaxSumArray(a.clone());
        int[] suffixMaxSumArray = getSuffixMaxSumArray(a.clone());
        int ans = 0;

        // we will ignore 1st and last pillar since there is no left/right supporting pillar to hold water
        for (int i = 1; i<a.length-1; i++){
            int decidingHeight = Math.min(prefixMaxSumArray[i - 1], suffixMaxSumArray[i + 1]);
            if (decidingHeight > a[i]) {
                ans += Math.max(0, decidingHeight-a[i]);
            }
        }
        System.out.println("height of water trapped: "+ ans);
    }

    private static int[] getPrefixMaxSumArray(int [] arr){
        for (int i=1; i< arr.length; i++){
            arr[i] = Math.max(arr[i-1] , arr[i]);
        }
        return arr;
    }

    private static int[] getSuffixMaxSumArray(int [] arr){
        for (int i= arr.length-2; i>=0; i--){
            arr[i] = Math.max(arr[i+1], arr[i]);
        }
        return arr;
    }
}
