import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Solution {

    public void printAllCombinations(String s){
        HashSet<String> set = new HashSet<>();

        set.add("i");
        set.add("like");
        set.add("mango");
        set.add("tango");
        set.add("man");
        set.add("tan");
        set.add("go");

        printAllInternal(set, s.toCharArray(), 0, new Stack<String>());
    }


    public void printAllInternal(HashSet<String> set, char[] s, int index, Stack<String> map){
        if(index >= s.length){
            Object[] list = map.toArray();
            print(list);
            return;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = index; i < s.length; i++){
            builder.append(s[i]);

            String value = builder.toString();

            if(set.contains(value)){
                map.push(value);
                printAllInternal(set, s, i + 1, map);
                map.pop();
            }

        }
    }


    public void print(Object[] array){
        System.out.println();
        for (Object item :
                array) {
            System.out.print(item + " ");
        }
    }
}

class Pair{

    Pair(Integer start, Integer end){
        this.start = start;
        this.end = end;
    }

    Integer start;
    Integer end;

    @Override
    public int hashCode() {
        return start.hashCode() + end.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pair other = (Pair) obj;
        if (start != other.start)
            return false;
        return start.equals(other.start) && end.equals(other.end);
    }
}
