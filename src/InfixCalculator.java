import java.util.*;
public class InfixCalculator {
    /**
     * input is a string that contain the operation
     */
    String input;

    /**
     * This is the constructor of class InfixCalculator
     * @param input is the string that come from the user's input
     */
    public InfixCalculator(String input){
        this.input = input;
    }

    /**
     * This method print the infix, postfix form of the operation as well as the result of the operation.
     */
    public void evaluateInfix(){
        System.out.println("infix: "+input);
        System.out.println("postfix: "+convertPostfix(input));
        System.out.println("result: "+getPostFix(convertPostfix(input)));
    }

    /**
     * This method will convert the operation from infix form to postfix form
     * @param input is the string of the operation that come from the user's input
     * @return the string that contain the postfix form of the operation
     */
    public String convertPostfix(String input){
        StackListBased<Character> stak = new StackListBased<Character>();
        stak.createStack();
        String converted ="";
        for(char ch : input.toCharArray()){
            // check if the character is an operand
            if(ch == '1'||ch == '2'||ch == '3'||ch == '4'||ch == '5'||ch == '6'||ch == '7'||ch == '8'||ch == '9'||ch == '0'){
                converted += ch; // put the operand into the empty string
            }else if (ch == '+'||ch == '-'||ch == '*'||ch == '/'){ // check if the character is an operator
                while((!stak.isEmpty()) && (stak.peek()!='(')){
                    // the if-else statements check if the operator from the character have the precedence smaller or equals
                    // to the precedence from the element from the top of the stack
                    if((ch=='+'||ch=='-') && (stak.peek()=='*'||stak.peek()=='/')){
                        converted += " "+stak.pop();
                    }else if((ch=='+'||ch=='-') && (stak.peek()=='+'||stak.peek()=='-')){
                        converted += " "+stak.pop();
                    }else if((ch=='*'||ch=='/') && (stak.peek()=='*'||stak.peek()=='/')) {
                        converted += " " + stak.pop();
                    }
                    break;
                }
                // check if the operator from the character have the same precedence as the precedence of the element come
                // after the element that was pop previously
                if((!stak.isEmpty())&&(stak.peek()!='(')&&(ch=='+'||ch=='-')&&(stak.peek()=='+'||stak.peek()=='-')) {
                    converted += " " + stak.pop();
                }
                stak.push(ch); // push the character to the top of the stack
                converted += " ";
            }else if (ch == '('){
                stak.push(ch);// push the '(' parenthesis to the stack
            }else if (ch == ')'){
                while (stak.peek()!='('){
                    converted += " ";
                    converted += stak.pop();
                }
                char peren = stak.pop(); //pop parenthesis
            }
        }
        while(!stak.isEmpty()){
            converted += " "+stak.pop(); // pop all the remain operator in the stack
        }
        return converted;
    }

    /**
     * This method calculate the result of the operation using the postfix expression that came from the convertPostfix method
     * @param post is the string of the converted infix operation came from convertPostfix method
     * @return result of the operation in the form of double
     */
    public double getPostFix(String post){
        StackListBased<Double> stak = new StackListBased<Double>();
        stak.createStack();
        String contain ="";
        for(char ch : post.toCharArray()){
            if(ch == '1'||ch == '2'||ch == '3'||ch == '4'||ch == '5'||ch == '6'||ch == '7'||ch == '8'||ch == '9'||ch == '0'){
                contain += ch;
            }else if(ch==' '&&!contain.equals("")){
                stak.push(Double.parseDouble(contain));
                contain ="";
            }else if(ch == '+'||ch == '-'||ch == '*'||ch == '/'){
                double a = stak.pop();
                double b = stak.pop();
                if(ch=='+'){
                    stak.push(a+b);
                }else if(ch=='-'){
                    stak.push(b-a);
                }else if(ch=='*'){
                    stak.push(a*b);
                }else if(ch=='/'){
                    stak.push(b/a);
                }
            }
        }
        return stak.pop();
    }
}

