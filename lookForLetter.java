public class lookForLetter{
    public static void main(String[] args){

        String word  = "chicagoc";
        int count = 0;
        for(int i = 0; i< word.length();i++){
            if(word.charAt(i) == 'c'){
                count++;
            }
        }
        System.out.println(count);

    }
}