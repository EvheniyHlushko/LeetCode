import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();

        Generate(result, 0, 0, n * 2, new StringBuilder());

        return result;
    }

    public void Generate(List<String> result, int open, int closed, int count, StringBuilder builder){
        if(builder.length() == count){
            result.add(builder.toString());
            return;
        }

        if(isValid(open, closed, count, ')')){
            StringBuilder newBuilder = new StringBuilder(builder);
            newBuilder.append(')');
            Generate(result, open, closed+1, count, newBuilder);
        }

        if(isValid(open, closed, count, '(')){
            StringBuilder newBuilder = new StringBuilder(builder);
            newBuilder.append('(');
            Generate(result, open+1, closed, count, newBuilder);
        }

    }


    private boolean isValid(int open, int closed, int count, Character sign){
        if(sign == '('){
            if(count/2 > open){
                return true;
            }
            return false;
        }
        if(sign == ')'){
            if(open > closed){
                return true;
            }
            return false;
        }

        return false;
    }



}
