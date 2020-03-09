import java.util.*;
public class StackListBased<E> {
    /**
     * items is the linked list of the ADT StackListBased
     */
    private LinkedList<E> items;
    //private E top;

    /**
     * This is the constructor of class StackListBased
     */
    public StackListBased(){
    }

    /**
     * This method create an empty linked list, which will act as a stack
     */
    public void createStack(){
        items = new LinkedList<E>();
    }

    /**
     * This method clear remove all the elements in the stack
     */
    public void popAll(){
        items.clear();
    }

    /**
     * This method check if the stack is empty or not
     * @return true if the stack is empty and else otherwise
     */
    public boolean isEmpty(){
        return items.isEmpty();
    }

    /**
     * This method put an element to the top of the stack
     * @param item is the element which will be put to top of the stack
     */
    public void push(E item){
        items.push(item);
        //top = items.getFirst();
    }

    /**
     * This method remove the element on top of the stack from the stack and return that element
     * @return the element that was removed from the stack
     */
    public E pop(){
        E item = items.pop();
        return item;
    }

    /**
     * This method return the element that is currently on the top of the stack
     * @return the element that is currently on the top of the stack
     */
    public E peek(){
        return items.getFirst();
    }
}


