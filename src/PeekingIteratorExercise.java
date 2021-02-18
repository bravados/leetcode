import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    Integer current;
    Boolean hasNext;

    private void advanceOnce(){
        if(it.hasNext()){
            current = it.next();
            hasNext = true;
        } else {
            current = null;
            hasNext = false;
        }
    }

    public PeekingIterator(Iterator<Integer> iterator) {
        it = iterator;
        advanceOnce();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return current;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer currentCopy = current;
        advanceOnce();
        return currentCopy;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }
}

public class PeekingIteratorExercise {

    public static void main(String args[]){
        List<Integer> list = Arrays.asList(1, 2, 3);
        Iterator<Integer> iterator = list.iterator();
        PeekingIterator peekingIterator = new PeekingIterator(iterator);
        System.out.println(peekingIterator.hasNext());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.hasNext());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.hasNext());
    }
}
