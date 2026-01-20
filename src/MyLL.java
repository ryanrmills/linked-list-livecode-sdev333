public class MyLL<T> {
    
    private class Node<E> {
        public E value;
        public Node<E> next;
        public Node<E> prev;

        public Node(E value, Node<E> next){
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public MyLL(){
        head = null;
        tail = null;
    }

    public void printList(){
        Node<T> current = head;
        while (current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }

    public void printBackwards(){
        if (tail == null){
            return;
        }
        Node<T> current = tail;

        while (current.prev != null){
            System.out.println(current.value);
            current = current.prev;
        }

        System.out.println(current.value);
    }

    public void addToBack(T toAdd){
        Node<T> newNode = new Node<T>(toAdd, null);
        
        if (head == null) {
            head = newNode;
            return;
        }

        Node<T> current = head;
        while (current.next != null){
            current = current.next;
        }
        
        newNode.prev = current;
        current.next = newNode;
        this.tail = newNode;

    }

    public T contains(T toFind){
        Node<T> current = head;
        while (current != null){
            if (current.value.equals(toFind)){
                return toFind;
            }
            current = current.next;
        }
        return null;
    }


    public T remove(T toRemove){
        if (head == null) return null;

        if (head.value.equals(toRemove)) head = head.next;

        
        Node<T> current = head;
        while (current.next != null){
            if (current.next.value.equals(toRemove)){
                current.next = current.next.next;
                return toRemove;
            }
            current = current.next;
        }

        return null;
    }
}
