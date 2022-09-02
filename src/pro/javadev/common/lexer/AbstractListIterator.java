package pro.javadev.common.lexer;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class AbstractListIterator<T> implements ListIterator<T>, Iterable<T> {

    private final static UnsupportedOperationException UNSUPPORTED_OPERATION_EXCEPTION
            = new UnsupportedOperationException("LIST ITERATOR IS IMMUTABLE");

    protected final List<T> entries;
    protected final int     length;
    protected       int     cursor;

    public AbstractListIterator(List<T> entries) {
        this.length = entries.size();
        this.entries = Collections.unmodifiableList(entries);
    }

    @Override
    public T previous() {
        return entries.get(--cursor);
    }

    @Override
    public T next() {
        return entries.get(cursor++);
    }

    @Override
    public boolean hasNext() {
        return cursor != entries.size();
    }

    @Override
    public boolean hasPrevious() {
        return cursor != 0;
    }

    @Override
    public int nextIndex() {
        return cursor + 1;
    }

    @Override
    public int previousIndex() {
        return cursor - 1;
    }

    @Override
    public Iterator<T> iterator() {
        return entries.iterator();
    }

    @Override
    public void remove() {
        throw UNSUPPORTED_OPERATION_EXCEPTION;
    }

    @Override
    public void set(T entry) {
        throw UNSUPPORTED_OPERATION_EXCEPTION;
    }

    @Override
    public void add(T entry) {
        throw UNSUPPORTED_OPERATION_EXCEPTION;
    }

}