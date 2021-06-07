import java.util.Arrays;
import java.util.ArrayList;

public class AlgoTwo {
    public static void main(String[] args) throws Exception {
        int[] a3 = {6, 20, 14, 5, 10, 16, 18, 19, 15, 17, 2, 14, 11, 15, 13, 5, 16, 20, 11, 18, 3, 16, 10, 9, 14, 17, 19, 1, 11, 15, 3, 3, 3, 20, 3, 18, 2, 19, 5, 18, 5, 19, 17, 9, 5, 1, 2, 10, 4, 2, 10, 5, 15, 3, 4, 12, 16, 11, 5, 18, 11, 17, 4, 10, 11, 9, 19, 12, 14, 17, 14, 4, 7, 1, 10, 19, 8, 9, 8, 7, 2, 20, 17, 1, 8, 13, 2, 12, 0, 11, 3, 5, 13, 16, 14, 1, 17, 12, 18, 18};
        int[] b3 = {37, 44, 33, 27, 23, 49, 18, 17, 13, 19, 17, 37, 47, 8, 25, 17, 23, 16, 14, 41, 34, 2, 39, 3, 13, 47, 6, 45, 20, 9, 31, 18, 10, 27, 15, 38, 47, 16, 47, 17, 26, 34, 7, 47, 34, 8, 20, 13, 12, 17};
        reconcileHelper5(a3, b3); 
    }

/*
    Algorithm:
    1) sort both array in ascending order.
    2) initialize pointers for array a and b.
    3) create arraylist to store numbers that appear on both arrays.
    4) loop through array using while loop and pointers to find numbers appear on both array and store them.
        a) if the same, store them and increment both to go to next set.
        b) if a > b, then that means you have to increment pointer b to find a higher number that would match a. 
        c) if a < b, then that means you have to increment pointer a to find a higher number that would match b. 
    5) create two arraylists to store the unique numbers that one array has and the other doesn't
    6) print the numbers by looping through each array, and find numbers that does not appear in the numInBoth array, which 
       means it is a unique number only in that array. Store it in the unique number, and use it to check for repeats. 
*/    
    static void reconcileHelper5(int[] a, int[] b){
        //sort a and b to ascending orders
        Arrays.sort(a);
        Arrays.sort(b);
        int countA = 0;
        int countB = 0;
        //make arraylist to store similar numbers
        ArrayList<Integer> numInBoth = new ArrayList<Integer>();

        //find and store the similar numbers
        while(countB < b.length && countA < a.length){
            //if a and b are the same, store the number and increment both.
            if(a[countA] == b[countB]){ 
                numInBoth.add(a[countA]);
                countA++;
                countB++;
            }
            //if a is more than b, than increment B
            else if(a[countA] > b[countB]){ 
                countB++;
            } 
            //if a is less than b. than increment A
            else {
                countA++;
            }
        }
        //create arraylist to store unique numbers for a and b
        ArrayList<Integer> numANotB = new ArrayList<Integer>();
        ArrayList<Integer> numBNotA = new ArrayList<Integer>();

        //print numbers in array a that aren't in the numInBoth array
        System.out.println("Numbers in array a that aren't in array b: ");
        for(int num : a){
            if(!numInBoth.contains(num) && !numANotB.contains(num)){
                numANotB.add(num);
                System.out.print(num + " ");
            }
        }

        System.out.println(""); //Make new line

        //print numbers in array a that aren't in the numInBoth array
        System.out.println("Numbers in array b that aren't in array a: ");
        for(int num : b){
            if(!numInBoth.contains(num) && !numBNotA.contains(num)){
                numBNotA.add(num);
                System.out.print(num + " ");
            }
        }
    }
}
