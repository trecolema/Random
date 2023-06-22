import java.util.Arrays;
import java.util.InputMismatchException;
// time complexity is O(n)
public class Challenge2{

    public static void main(String[] args){
    
    try{
        String arr1[] = {"1","2","3","4","5","6"};
        String arr2[];
        arr2 = new String[1001];
        for(int i = 0; i <= arr2.length-1; i++){
            arr2[i] = String.valueOf(i);
        }
        String arr3[] = {"1","3","5","7","2","4","5"};
        String arr4[] = {"1","2","3","4","x"};
        String arr5[] = {"0","0","0","0","3","12","16"};
        String result1 = Max3EvenSum(arr1);
        String result2 = Max3EvenSum(arr2);
        String result3 = Max3EvenSum(arr3);
        String result4 = Max3EvenSum(arr4);
        /*
         * I would have used int's (for the array and method) completely and just threw an error if the array
         * contained anything else but to match the ouput on the worksheet I did it this way
         */

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(Max3EvenSum(arr5));

    }catch(InputMismatchException e){
        System.out.println(e);
        System.out.println("0");
    }

    }



    public static String Max3EvenSum(String[] arr){
        String firstEven = "0", secondEven = "0", thirdEven = "0";
        if(arr.length < 3){ //make sure that there are at least 3 numbers in the array
            return "0";
        }
    try{
        for(int i = 0; i <= arr.length-1; i++){
            if((Integer.parseInt(arr[i]) % 2) == 0){ //check if even
                if((Integer.parseInt(arr[i])) > Integer.parseInt(firstEven)){
                    //swap values to so that the largest value is always in firsteven second largerst in secondeven and
                    //so on
                    thirdEven = secondEven;
                    secondEven = firstEven;
                    firstEven = arr[i];
                }
                
                else if((Integer.parseInt(arr[i])) > Integer.parseInt(secondEven)){
                    thirdEven = secondEven;
                    secondEven = arr[i];
                }
                else if((Integer.parseInt(arr[i])) > Integer.parseInt(thirdEven)){
                    thirdEven = arr[i];
                }
                
            }
        }
        if(firstEven == "0" || secondEven == "0" || thirdEven == "0"){
            //if there are not 3 even values > 0 return 0
            return "0";
        }
        else{
            //return as string
            int result = Integer.parseInt(firstEven)+Integer.parseInt(secondEven)+Integer.parseInt(thirdEven);
            String sum = String.valueOf(result);
            return sum;
        }
        
        }catch(NumberFormatException e){
            //throw exception if the array is not a list of String integers
            String printValue = Arrays.toString(arr);
            return "invalid array: " + printValue;
        }
    }
}