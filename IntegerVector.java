public class IntegerVector {
    private int data[];
    private int numElements;

    public IntegerVector(int initSize) {
        if (initSize <= 0) {
            throw new IllegalArgumentException("initSize <= 0");
        }
        numElements = 0;
        data = new int[initSize];
    } // this constructor creates a vector of given size

    public IntegerVector() {
        this(100);
    } // this created a created a predetermined size

    public void add(int item) {
        if (numElements + 1 > data.length) {
            throw new IndexOutOfBoundsException("No space available");
        }
        data[numElements++] = item;
    } // add item to the end of the vector

    public void add(int item, int position) {
        if (position >= data.length) {
            throw new IndexOutOfBoundsException("No space available");
        }
        if (position < 0) {
            throw new IllegalArgumentException("Position size cannot be negative");
        }

        if (position >= numElements) {
            data[numElements++] = item;
        } else {
            int k;
            for (k = numElements -1; k >= position; k--) {
                data[k+1] = data[k];
            }
            data[k+1] = item;
            numElements++;
        }
    } // This adds to a given position

    public int get(int index) {
        if (index < 0 || index >= numElements) {
            throw new IndexOutOfBoundsException("Index is out of range"); // not correct comment
        }
        return data[index];
    } // Getting the item in the given index

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numElements; i++) {
            sb.append(data[i]);
            if (i < numElements - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test Vector");

        IntegerVector myVector = new IntegerVector(10);
        
        for (int i = 0; i < 10; i++) {
            myVector.add(i);
        }

        System.out.println(myVector);
        System.out.println(myVector.get(10));
    }

} // class IntegerVector