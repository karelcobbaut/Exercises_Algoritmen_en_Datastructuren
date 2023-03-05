package week7infix;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
public class StackInfixToPostfix implements InfixToPostfix {

    private String operators = "+*-/";
    private List<String>  returnList = new ArrayList<>();
    private List<String> startList;

    @Override
    public List<String> infixToPostfix(List<String> infix) {
        startList = infix;

        recursiveInfix(0,infix.size());
        return returnList;
    }
    private void recursiveInfix(int start, int j){
        Stack<String> myStack = new Stack<>();
        int i=start;
        int count=0;
        while(i<j) {
            if (startList.get(i).equals("(")) {
                int j_ = findEndBracket(i+1, j);
                recursiveInfix(i +1, j_-1);

                i=j_;
            } else {
                if (operators.indexOf(startList.get(i)) == -1) {
                    returnList.add(startList.get(i));
                } else {

                    while (count!=0&&(operators.indexOf(myStack.peek())%2>=operators.indexOf(startList.get(i))%2)){
                        returnList.add(myStack.pop());
                        count--;
                    }

                    //else if(!myStack.isEmpty()&&operators.indexOf(startList.get(i))>1))
                    myStack.add(startList.get(i));
                    count++;

                }
                i++;
            }

        }
        while (!myStack.isEmpty()) returnList.add(myStack.pop());
    }
    private int findEndBracket(int start, int end){
        int count = 1;
        int i=start;
        while(count != 0){
            if(startList.get(i).equals("(")) count++;
            if(startList.get(i).equals(")")) count--;
            i++;
        }
        assert(i<=end);
        return i;
    }
}
