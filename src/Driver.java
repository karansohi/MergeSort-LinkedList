/*Author: Karanbir Singh
Data Structures utilized: Usermade linkedlist and in built array.
Program Details: Sorting a linkedlist using merge sort.
*/
class Node {
    private int num;
    private Node next;
    //contructor1
    Node(int n, Node ntx){
        num = n;
        next = ntx;
    }
    //constructor 2
    Node(int n){
        num = n;
        next = null;
    }

    //get the data value of the node
    public int getValue(){
        return num;
    }
    //change or set the data value of the node
    public void setValue(int val){
        num = val;
    }
    public Node getNext(){
        return next;
    }
    public void setNext(Node ntx) {
        next = ntx;
    }
}

class LinkedList{
    private Node head;
    private int length;
    LinkedList(){
        head = null;
        length = 0;
    }
    //returns the list head
    public Node getListHead(){
        return head;
    }
    public void setListHead(Node a){
        head = a;
    }
    //adds node to the linkedlist
    public void addNode(int name){
        if(head == null){
            head = new Node(name,null);
            length++;
        }
        else{
            Node tmp = head;
            while(tmp.getNext()!= null){
                tmp = tmp.getNext();
            }
            Node n = new Node(name);
            tmp.setNext(n);
            length++;
        }
    }
    //trasverses the whole linkedlist displaying its content
    public void trasverse(){
        Node tmp = head;
        while(tmp!= null){
            System.out.print(tmp.getValue() + " ");
            tmp = tmp.getNext();
        }
    }
}

class MergeSort{
    static Node mergeSort(Node head){
        //base case
        if(head == null)
            return null;
        if ( head.getNext() == null)
            return head;
        Node a = head;
        int i = 0;
        //calculating lenght of the list for splitting it later
        while(a != null){
            a = a.getNext();
            i++;
        }
        i = i/2;
        a = head;
        //reaching the half of the list so that we can split it
        for(int half = 0; half < i-1; half++)
            a = a.getNext();
        //splitting the list
        Node b = a.getNext();
        a.setNext(null);
        a = head;
        a = mergeSort(a);
        b = mergeSort(b);
        Node c = merge(a,b);
        return c;
    }
    static Node merge(Node a, Node b){
        if(a == null)
            return b;
        if(b == null)
            return a;
        LinkedList list = new LinkedList();
        //trasvering the two lists
        while(a != null && b != null){
            //comparing values and adding them to the new list
            if (a.getValue() <= b.getValue()) {
                list.addNode(a.getValue());
                a = a.getNext();
            }
            else{
                list.addNode(b.getValue());
                b = b.getNext();
            }
        }
        //adding up the remaining left side values
        while(a != null){
            list.addNode(a.getValue());
            a = a.getNext();
        }
        //adding up the remaining right side values
        while(b != null){
            list.addNode(b.getValue());
            b = b.getNext();
        }
        //returning the head of the new list
        return list.getListHead();
    }
}

public class Driver {
    public static void main(String args[]){
        int arr[] = new int[]{5,3,9,1,2};
        LinkedList list = new LinkedList();
        for(int i = 0; i < arr.length; i++)
            list.addNode(arr[i]);
        System.out.println("Merge Sort is:");
        Node mergedHead;
        mergedHead = MergeSort.mergeSort(list.getListHead());
        LinkedList mergedList = new LinkedList();
        mergedList.setListHead(mergedHead);
        mergedList.trasverse();
    }

}
