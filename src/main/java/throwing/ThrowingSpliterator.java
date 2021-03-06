package throwing;

import throwing.function.ThrowingConsumer;
import throwing.function.ThrowingDoubleConsumer;
import throwing.function.ThrowingIntConsumer;
import throwing.function.ThrowingLongConsumer;

public interface ThrowingSpliterator<T, X extends Throwable> {
    public interface OfPrimitive<T, T_CONS, T_SPLITR extends OfPrimitive<T, T_CONS, T_SPLITR, X>, X extends Throwable>
            extends ThrowingSpliterator<T, X> {
        @Override
        public T_SPLITR trySplit();
        
        public boolean tryAdvance(T_CONS action) throws X;
    }
    
    public interface OfInt<X extends Throwable> extends OfPrimitive<Integer, ThrowingIntConsumer<X>, OfInt<X>, X> {}
    
    public interface OfLong<X extends Throwable> extends OfPrimitive<Long, ThrowingLongConsumer<X>, OfLong<X>, X> {}
    
    public interface OfDouble<X extends Throwable> extends
            OfPrimitive<Double, ThrowingDoubleConsumer<X>, OfDouble<X>, X> {}
    
    public boolean tryAdvance(ThrowingConsumer<? super T, ? extends X> action) throws X;
    
    public ThrowingSpliterator<T, X> trySplit();
    
    public long estimateSize();
    
    public int characteristics();
}
