import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class Challenge3 {
    public static void main(String[] args){
        //test cases
        //sorry it is a bit sloppy, just wanted to cover my bases


        List<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 1,4,3,6,3,4,1,3);
        System.out.println("Oringal List:" + list1);
        List<Integer> result = deleteDuplicates(list1);
        System.out.println("Duplicates removed: " + result);
        List<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "hello","hello","yes","no","yes","hello","yes"); //Making sure it works with other data types
        Map<Integer, Integer> result3 = tally(list1);
        System.out.println("Tally: " + result3);
        List<List<Integer>> LOL = gather(list1);
        System.out.println("Gather : " + LOL);
        //List<String> result = deleteDuplicates(list2);
        //System.out.println("Duplicates removed: " + result);
    }
        //use generic types of return values and input values to the methods
        //there are test methods above that contain strings if you want to test it that way as well

    public static <T> List<T> deleteDuplicates(List<T> list){
        //a linked hashset will maintain the input order and will not store duplicate values
        Collection<T> col = new LinkedHashSet<T>(list);
        List<T> uniqueList = new ArrayList<>();
        for(T data : col){
            uniqueList.add(data);
        }

        return uniqueList;
    }
    public static <T> List<List<T>> gather(List<T> list){
        //Map<T,Integer> hash = new LinkedHashMap<>();
        //Map<T,List<T>> hash = new LinkedHashMap<>();
        //List<T> ol = new ArrayList<>();
        List<List<T>> LOL = new ArrayList<>();
        //loop through the data in the list maintaining the order from delete duplicates
        //create a list of in input ordered numbers and add that list into a list of list
        for(T data : deleteDuplicates(list)){
            List<T> ol = new ArrayList<>();
            for(T toAdd : list){
                if(toAdd.equals(data)){
                    ol.add(toAdd);
                }
            }
            LOL.add(ol);
        }

        /* was trying something that didn't end up working
        for(int i = 0; i<list.size(); i++){
            Integer count = hash.get(list.get(i));
            if(count == null){
                count = 0;
            }
            hash.put(list.get(i), count+1);
        }
        for(int i = 0; i < list.size(); i++){
            Integer count = hash.get(list.get(i));
            if(count != null){
                for(int j = 0; j<count; j++){
                    ol.add(list.get(i));
                    hash.remove(list.get(i));
                }
            }
        }
        */
        //System.out.println(ol);
        
        return LOL;
    }
    public static <T> Map<T,Integer> tally(List<T> list){
        Map<T,Integer> hash = new LinkedHashMap<>();
        //map the data and amount it appears in the list to a linked hash map that will retain the orginal
        //input order
        for(int i = 0; i<list.size(); i++){
            Integer count = hash.get(list.get(i));
            if(count == null){
                count = 0;
            }
            hash.put(list.get(i), count+1);
        }

        return hash;
    }
}
