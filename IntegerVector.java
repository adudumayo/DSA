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
    }

    public static void main(String[] args) {
        System.out.println("Test Vector");

        IntegerVector myVector = new IntegerVector();

        System.out.println(myVector);
    }

} // class IntegerVector