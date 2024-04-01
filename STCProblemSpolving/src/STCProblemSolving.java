import java.util.Stack;



public class STCProblemSolving {
    public static void main(String[] args){
        String s = "a(bcdefghijkl(mno)p)q";
        reverseParentheses(s);

    }

    private static void reverseParentheses(String s){
        Stack <Integer> index = new Stack<>();
        char[] result = s.toCharArray();
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='('){
                index.push(i);

            } else if (s.charAt(i) == ')') {
                reverse(result,index.pop()+1,i-1);
            }
        }

        String t = new String(result);
        t=t.replace("(","");
        t=t.replace(")","");
        System.out.println(result);
        System.out.println(t);
    }

    private static void reverse(char[] result, int begin, int end) {
            for(int x = begin, y = end; x<y; x++,y--){
                if(result[x]==')'|| result[x]=='('){
                    x++;
                }
                if( result[y]=='(' || result[y]==')') {
                    y--;
                }
                char temp = result[x];
                result[x]= result[y];
                result[y]=temp;
            }
        }

}
