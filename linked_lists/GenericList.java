public class GenericList<T> {
    private class ListNode {
        public T data;
        public ListNode next;
    }

    private ListNode first;
    private int numElements;

    public GenericList() {
        first = null;
        numElements = 0;
    } // basic constructor with an empty list

    public void add(T item)
    // this adds a node at the beginning of the linkedList
    {
        ListNode node = new ListNode();
        node.data = item;
        node.next = first;

        first = node;
        numElements++;
    } // add

    public void add(T item, int position)
    // this adds a node at a given position, and adds at the end as default
    {
        ListNode node = new ListNode();
        node.data = item;
        ListNode frontLink = first;
        ListNode backLink = null;

        for (int i = 0; i < position && frontLink != null; i++) {
            backLink = frontLink;
            frontLink = frontLink.next;
        }

        node.next = frontLink;

        if (backLink != null) {
            backLink.next = node;
        } else {
            first = node;
        }

        numElements++;
    } // add with item and position

    public T get(int index) {
        if (index < 0 || index > numElements) {
            throw new IndexOutOfBoundsException("Your index is too big or negative");
        }

        ListNode temp = first;

        for (int i = 0; i < index && temp != null; i++) {
            temp = temp.next;
        }

        assert temp != null;

        return temp.data;
    } // getter

    public void set(int index, T item) {
        if (index < 0 || index > numElements) {
            throw new IndexOutOfBoundsException("Your index is either negative or too big");
        }

        ListNode temp = first;

        for (int i = 0; i < index && temp != null; i++) {
            temp = temp.next;
        }

        assert temp != null;

        temp.data = item;
    } // setter

    public int length() {
        return this.numElements;
    } // returns the length of the list

    public int position(T item)
    // find the position of a given item
    {
        ListNode temp = first;

        int index;

        for (index = 0; temp != null && !temp.data.equals(item); index++, temp = temp.next) {
            ;
        }

        if (temp == null) {
            return -1;
        } else {
            return index;
        }
    } // position

    // I did not test this one, Ich bin sehr mude
    // Ich denke it must be index instead of position
    public void remove(int position) {
        if (position < 0 || position >= numElements) {
            throw new IndexOutOfBoundsException("The position is out of range");
        }

        ListNode frontLink = first, backLink = null;

        for (int i = 0; i < position && frontLink != null; i++) {
            backLink = frontLink;
            frontLink = frontLink.next;
        }

        assert frontLink != null;

        if (backLink != null) {
            backLink.next = frontLink.next;
        } else {
            first = frontLink.next;
        }
        numElements--;
    } // remove

    public String toString() {
        StringBuffer s = new StringBuffer("[");
        for (ListNode curr = first; curr != null; curr = curr.next) {
            s.append("" + curr.data);
            if (curr.next != null)
                s.append(", ");
        }
        s.append("]");
        return s.toString();
    } // toString

    public static void main(String[] args) {
        IntegerList firstList = new IntegerList();
        for (int i = 0; i <= 10; i++) {
            firstList.add(i, i);
        }

        System.out.println(firstList);
        System.out.println(firstList.get(3));
        firstList.set(3, 30);
        System.out.println(firstList);
        System.out.println(firstList.length());
        firstList.remove(10);
        System.out.println(firstList);
        System.out.println(firstList.position(9));

    }

} // GenericList<T> Class
