import java.util.HashSet;
public class duplicates2 {
    public static void main(String[] args){
    String word = "CCCollabAppleTree";
    String word2 = word.toLowerCase();
    HashSet<Character> hash = new HashSet<Character>();
    HashSet<Character> hash2 = new HashSet<Character>();


    for(int i = 0; i < word2.length(); i++){
       if(i+1 < word2.length() && word2.charAt(i) == word2.charAt(i+1)){
        hash.add(word2.charAt(i));
        }
        for(int j = i+1; j < word2.length(); j++){
            if(word2.charAt(i) == word2.charAt(j)){
                hash2.add(word2.charAt(i));
            }
        }
    }

    System.out.println("all duplicates : " + hash2);
    System.out.println("all adjacent duplicates : " + hash);
    }
}