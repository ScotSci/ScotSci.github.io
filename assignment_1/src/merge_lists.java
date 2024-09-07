public class merge_lists {
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

    public static Node mergeLists(Node inputArray[], int numOfLists)
    {
        Node head = null;
        Node tracker = null;

        while (true) {
            int x = 0;
            int y = 0;
            int max = Integer.MAX_VALUE;

            for (int i = 0; i < numOfLists; i++) {
                if (inputArray[i] != null) {
                    x++;
                    if (inputArray[i].data < max) {
                        max = inputArray[i].data;
                        y = i;
                    }
                }
            }
            if (x != 0) {
                inputArray[y] = inputArray[y].next;
                Node temp = new Node(max);
                if (head == null) {
                    head = temp;
                    tracker = temp;
                } else {
                    tracker.next = temp;
                    tracker = temp;
                }
            } else {
                return head;
            }
        }
    }
    
    public static void main(String[] args) {

        Node nodeArray[] = new Node[3];

        nodeArray[0] = new Node(1);
        nodeArray[0].next = new Node(4);
        nodeArray[0].next.next = new Node(5);
        nodeArray[1] = new Node(1);
        nodeArray[1].next = new Node(3);
        nodeArray[1].next.next = new Node(4);
        nodeArray[2] = new Node(2);
        nodeArray[2].next = new Node(6);

        String inputSentence = "Input: lists = [";
        for(int i = 0; i < nodeArray.length; i++)
        {
            Node placeholder = nodeArray[i];
            inputSentence += "[";
            while(placeholder != null)
            {
                inputSentence += placeholder.data;
                if(placeholder.next != null)
                {
                    inputSentence += ", ";
                }
                placeholder = placeholder.next;
            }

            if(i == nodeArray.length -1)
            {
                inputSentence += "]]";
            }
            else
            {
                inputSentence += "], ";
            }
        }

        System.out.println(inputSentence);

        Node merged = mergeLists(nodeArray, 3);

        print(merged);
    }
}