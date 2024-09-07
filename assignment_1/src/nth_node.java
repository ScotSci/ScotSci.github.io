public class nth_node {
    static class Node {
        public int data;
        public Node next;
    
        public Node(int newData, Node newLink) {
            data = newData;
            next = newLink;
        }
    
        public Node(int newData) {
            data = newData;
            next = null;
        }
    }
    
    public static void print(Node head)
    {
        String statement = "Output: [";
        while (head != null)
        {
            statement += head.data;
            head = head.next;
            if(head != null)
            {
                statement += ", ";    
            }
        }
        statement += "]";
        System.out.println(statement);
    }
    
    public static Node DeleteNthNode(Node head, int N) {
        if (head == null) {
            return null;
        }
        int listLength = 0;
        Node temp = head;

        while (temp != null) {
            listLength++;
            temp = temp.next;
        }

        if (listLength == N) {
            Node newhead = head.next;
            head = null;
            return newhead;
        }

        int move = listLength - N;
        temp = head;

        while (temp != null) {
            move--;
            if (move == 0) {
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
    
    public static void main(String[] args) {
        int[] input = {1, 2};
        int N = 1;
        Node head = new Node(input[0]);
        Node placeholder = head;
        String statement = "" + head.data;
        for(int i = 1; i < input.length; i++)
        {
            placeholder.next = new Node(input[i]);
            placeholder = placeholder.next;
            statement += ", " + placeholder.data;
        }

        head = DeleteNthNode(head, N);
        System.out.println("Input: head = [" + statement + "], N = " + N);
        print(head);
    }
}