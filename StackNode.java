class StackNode{
    int data;
    StackNode next;

    public StackNode(int data){
        this.data = data;
        this.next = null;

    }
}

class Stack{
    private StackNode top;

    public Stack(){
        this.top = null;
    }

    public void push(int data){
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
        System.out.println(data + " pushed to stack.");
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }

        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }

        return top.data;
    }

    public boolean isEmpty(){
        return (top == null);
    }
    
private void insertAtBottom(int data){
        if (isEmpty()){
            push(data);
        } else {
            int topElement = pop();
            insertAtBottom(data);
            push(topElement);
        }
    }

    public void reverseStack(){
        if (!isEmpty()){
            int topElement = pop();
            reverseStack();
            insertAtBottom(topElement);
        }
}

}



public class Main{
    public static void main(String[] args){
        Stack stack = new Stack();

        stack.push(50);
        stack.push(7);
        stack.push(10);
        System.out.println(stack.peek());
        
        stack.reverseStack();
        
        System.out.println(stack.peek());

    }
}
