import java.util.Arrays;

public class AlgoOne {
    public static void main(String[] args) throws Exception {
        int[] arr = {14 , 8, -5, 0, 8, 5, 1, 4, 5, 4, -100, 4, 5};
        int targetSum = 9;
        findPairs(arr, targetSum);  
    }

    /*
    Algorithm:
    1) sort the array in ascending order
    2) Intialize two pointers: lo = 0 and hi = lastIndexOfArray
    3) Under condition that lo < hi, use while loop to loop through array
        a) if sum of lo and hi is equals to the target sum, then print it and increment lo and decrement hi to eliminate from loop
        b) if sum of lo and hi is more than the target sum, then decrement hi 
        c) else, which means sum of lo and hi is less than the sum, then increment lo
    */

    static void findPairs(int[] testArray, int targetSum)
    {
        //Sorts array to ascending order for the algorithm to support the lo and hi pointers
        Arrays.sort(testArray);
        int lo = 0;
        int hi = testArray.length-1;

        while (lo < hi) { 
            int num1 = testArray[lo];
            int num2 = testArray[hi];
            int numSum = num1 + num2;

            //if sum of pairs is equals to targetSum and it isn't a repeating pair, 
            //then print and move the pointers to another pair 
            if(numSum == targetSum && num1 != testArray[lo-1]){
                System.out.println("(" + num1 + ", " + num2 + ")");
                hi--;
                lo++;
            }
            //if sum of pairs is more than targetSum, then decrement end pointer to another number to find new sum
            else if(numSum > targetSum){
                hi--;
            }
            //else, increment the starting pointer to another number to find new sum
            else{
                lo++;
            }
        }
    }

    
}

