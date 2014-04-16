package throwing;

import java.util.Iterator;

class IteratorBridge<E, X extends Throwable> extends CheckedExceptionBridge<X> implements ThrowingIterator<E, X> {
    private final Iterator<E> delegate;
    
    IteratorBridge(Iterator<E> delegate, FunctionBridge<X> bridge) {
        super(bridge);
        this.delegate = delegate;
    }
    
    @Override
    public boolean hasNext() throws X {
        return filterBridgeException(delegate::hasNext);
    }
    
    @Override
    public E next() throws X {
        return filterBridgeException(delegate::next);
    }
}
