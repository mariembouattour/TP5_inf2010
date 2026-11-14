import java.util.NoSuchElementException;

/**
 * InefficientArrayDistanceQueue: keys and values are both stored
 * in arrays with corresponding indices.  Both decreaseKey and extractMin
 * iterate over these arrays
 */
public class InefficientArrayDistanceQueue implements DistanceQueue {

    private long[] queueKeys;
    private int[] queueValues;
    private int size = 0;

    public InefficientArrayDistanceQueue(int V) {
        queueKeys = new long[V];
        queueValues = new int[V];
    }

    @Override
    public void decreaseKey(int v, long k) {
        int i = 0;
        while (i < size){
            if (v == queueValues[i]) {
                queueKeys[i] = k;
                return;
            }
            i++;
        }
        queueValues[size] = v;
        queueKeys[size++] = k;
    }

    @Override
    //À faire
    public int extractMin() {
        if (isEmpty()) throw new NoSuchElementException("queue is empty");
        int minIdx = 0;
        for (int i = 1; i < size; i++) {
            if (queueKeys[i] < queueKeys[minIdx]) minIdx = i;
        }
        int v = queueValues[minIdx];
        size--;
        queueValues[minIdx] = queueValues[size];
        queueKeys[minIdx] = queueKeys[size];
        return v;
    }

    @Override
    public boolean isEmpty() { return size == 0; }
}
