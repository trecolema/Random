public class Primes {

    public static void main(String[] args){

        System.out.println(getPrimes(3));
        System.out.println(getPrimes(11));
        System.out.println(getPrimes(1000));
    }
    
    public static int getPrimes(int n){
        int count = 0, flag=1, i;
        
        while(count<n){
            flag++;
            for(i = 2; i <= flag; i++){
                if(flag%i==0){
                    break;
                }
            }
            if(i==flag){
                count++;
            }
        }

        return flag;
    }
}