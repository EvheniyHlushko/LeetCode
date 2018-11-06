import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/basic-calculator-ii/

227. Basic calculator 2

        Implement a basic calculator to evaluate a simple expression string.

        The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

        Example 1:

        Input: "3+2*2"
        Output: 7
        Example 2:

        Input: " 3/2 "
        Output: 1
        Example 3:

        Input: " 3+5 / 2 "
        Output: 5
        Note:

        You may assume that the given expression is always valid.
        Do not use the eval built-in library function.
*/


public class Solution {
    public int calculate(String s) {

        String newStr = s.replace(" ", "");

        Queue<CustomOperation> operations = getOperations(newStr);

        List<CustomOperation> list = new ArrayList<CustomOperation>();

        while(!operations.isEmpty()){
            CustomOperation item = operations.poll();

            if(item.operation == '*' || item.operation == '/'){
                CustomOperation item2 = operations.peek();
                item2.number = calculateOp(item.number, item2.number, item.operation);
                continue;
            }
            list.add(item);
        }

        CustomOperation element = list.get(0);
        for(int i = 1; i < list.size(); i++){
            CustomOperation element1 = list.get(i);

            element1.number = calculateSimple(element.number, element1.number, element.operation);

            element = element1;
        }

        return element.number;
    }


    public int calculateOp(int first, int second, char operation){
        if(operation == '*'){
            return first * second;
        }
        return first/second;
    }

    public int calculateSimple(int first, int second, char operation){
        if(operation == '-'){
            return first - second;
        }
        return first+second;
    }

    private Queue<CustomOperation> getOperations(String s){
        char[] list = s.toCharArray();

        Queue<CustomOperation> queue = new LinkedList<CustomOperation>();

        for (int i = 0; i < list.length; i++){

            int intValue = Character.getNumericValue(list[i]);

            StringBuilder builder = new StringBuilder();

            while(i < list.length && Character.getNumericValue(list[i]) != -1){
                builder.append(list[i]);
                i++;
            }

            char sign = i < list.length ? list[i] : '#';

            CustomOperation op = new CustomOperation();
            op.number = Integer.parseInt(builder.toString());
            op.operation = sign;

            queue.add(op);
        }

        return queue;
    }

}
