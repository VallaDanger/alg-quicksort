package mx.chux.cs.alg.sorting;

public class Quicksort<T extends Comparable<T>> {

    public static final <T extends Comparable<T>> void sort(T[] items) {
        
        final int size = items.length;
        
        if( size == 0 ) {
            return;
        }
        
        new Quicksort<T>(items).sort(0, size - 1);
    }
    
    private final T[] array;
    
    private Quicksort(final T[] array) {
        this.array = array;
    }
    
    private void sort(final int start, final int end) {
        
        if( end <= start ) {
            return;
        }
        
        int partitionIndex = partition(start, end);
        
        sort(start, partitionIndex-1);
        sort(partitionIndex + 1, end);
    }
    
    private int partition(final int start, final int end) {
        
        int pivotIndex = selectPivotIndex(start, end);
        
        swap(pivotIndex, end);
        
        final T pivot = get(end);
        
        int j = start;
        
        for( int i = start; i < end ; i++ ) {
            if( isLessThanOrEqual(get(i), pivot) ) {
                swap(i, j);
                j++;
            }
        }
        
        swap(j, end);
        
        return j;
    }
    
    private boolean isLessThanOrEqual(T x, T y) {
        return x.compareTo(y) <= 0;
    }
    
    private boolean isGreaterThanOrEqual(T x, T y) {
        return x.compareTo(y) >= 0;
    }
    
    private int selectPivotIndex(final int start, final int end) {
        
        int mid = (start + end) / 2;
        int low = start;
        
        if( isGreaterThanOrEqual(get(low), get(mid)) ) {
            low = mid;
            mid = start;
        }
        
        if( isLessThanOrEqual(get(end), get(low)) ) {
            return low;
        }
        
        if( isLessThanOrEqual(get(end), get(mid)) ) {
            return mid;
        }
        
        return end;
    }
    
    private T get(int index) {
        return this.array[index];
    }
    
    private void set(int index, T value) {
        this.array[index] = value;
    }
    
    private void swap(int i, int j) {
        final T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }
    
}
