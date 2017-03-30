package ua.nure.shopynskyi.Task2;

import java.lang.*;

public class ListImpl implements List {

    private Object[] array;
    private int count;

    public ListImpl() {
        this.array = new Object[10];
    }

    public static void main(String[] args) {
        System.out.println("~~~ list A B C");
        System.out.println("~~~ Result: [A, B, C]");
        List list = new ListImpl();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list);

        System.out.println("~~~ list2: D E F");
        System.out.println("~~~ Result: [D, E, F]");
        List list2 = new ListImpl();
        list2.add("D");
        list2.add("E");
        list2.add("F");
        System.out.println(list2);

        System.out.println("~~~ list.addAll(list2)");
        System.out.println("~~~ Result: [A, B, C, D, E, F]");
        list.addAll(list2);
        System.out.println(list);

        System.out.println("~~~ list.add(C)");
        System.out.println("~~~ Result: [A, B, C, D, E, F, C]");
        list.add("C");
        System.out.println(list);

        System.out.println("~~~ list.clear()");
        System.out.println("~~~ Result: []");
        list.clear();
        System.out.println(list);

        System.out.println("~~~ list.addAll(list2)");
        System.out.println("~~~ Result: [D, E, F]");
        list.addAll(list2);
        System.out.println(list);

        System.out.println("~~~ list.contains(E)");
        System.out.println("~~~ Result: true");
        System.out.println(list.contains("E"));

        System.out.println("~~~ list.contains(�)");
        System.out.println("~~~ Result: false");
        System.out.println(list.contains("C"));

        System.out.println("~~~ list.indexOf(D)");
        System.out.println("~~~ Result: 0");
        System.out.println(list.indexOf("D"));

        System.out.println("~~~ list.get(2)");
        System.out.println("~~~ Result: F");
        System.out.println(list.get(2));

        System.out.println("~~~ list.indexOf(F)");
        System.out.println("~~~ Result: 2");
        System.out.println(list.indexOf("F"));

        System.out.println("~~~ list.size()");
        System.out.println("~~~ Result: 3");
        System.out.println(list.size());

        System.out.println("~~~ list");
        System.out.println("~~~ Result: [D, E, F]");
        System.out.println(list);

        System.out.println("~~~ list.remove(1)");
        System.out.println("~~~ Result: [D, F]");
        list.remove(1);
        System.out.println(list);

        System.out.println("~~~ list.remove(F)");
        System.out.println("~~~ Result: [D]");
        list.remove("F");
        System.out.println(list);

        System.out.println("~~~ list.size()");
        System.out.println("~~~ Result: 1");
        System.out.println(list.size());

        System.out.println("~~~ list.addAll(list2)");
        System.out.println("~~~ Result: [D, D, E, F]");
        list.addAll(list2);
        System.out.println(list);

        System.out.println("~~~ foreach list");
        System.out.println("~~~ Result: D D E F");
        for (Object el : list) {
            System.out.print(el + " ");
        }
        System.out.println();

        System.out.println("~~~ Iterator it = list.iterator()");
        Iterator it = list.iterator();

        System.out.println("~~~ it.next()");
        System.out.println("~~~ Result: D");
        System.out.println(it.next());

        System.out.println("~~~ it.next()");
        System.out.println("~~~ Result: D");
        System.out.println(it.next());

        System.out.println("~~~ it.remove()");
        System.out.println("~~~ Result: [D, E, F]");
        it.remove();
        System.out.println(list);

        System.out.println("~~~ it.next()");
        System.out.println("~~~ Result: E");
        System.out.println(it.next());

        System.out.println("~~~ it.remove()");
        System.out.println("~~~ Result: [D, F]");
        it.remove();
        System.out.println(list);

        System.out.println("~~~ it.next()");
        System.out.println("~~~ Result: F");
        System.out.println(it.next());

        System.out.println("~~~ it.remove()");
        System.out.println("~~~ Result: [D]");
        it.remove();
        System.out.println(list);

        System.out.println("~~~ list.remove(D)");
        System.out.println("~~~ Result: []");
        list.remove("D");
        System.out.println(list);

        System.out.println("~~~ list.addAll(list2)");
        System.out.println("~~~ Result: [D, E, F]");
        list.addAll(list2);
        System.out.println(list);

        System.out.println("~~~ foreach list");
        System.out.println("~~~ Result: D E F ");
        for (Object el : list) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    @Override
    public void add(Object el) {
        if (this.count == this.array.length) {
            resize();
        }

        this.array[count++] = el;
    }

    @Override
    public void addAll(List list) {
        Object[] array = list.toArray();

        for (Object obj : array) {
            this.add(obj);
        }
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[count];
        System.arraycopy(this.array, 0, array, 0, count);

        return array;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.count; i++) {
            this.array[i] = null;
        }

        this.count = 0;
    }

    @Override
    public boolean contains(Object el) {
        return indexOf(el) != -1;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        if (checkIndex(index)) {
            return this.array[index];
        } else {
            throw new IndexOutOfBoundsException("Index was outside " +
                    "of the list");
        }
    }

    @Override
    public int indexOf(Object el) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i].equals(el)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object remove(int j) throws IndexOutOfBoundsException {
        if (checkIndex(j)) {
            Object deleted = this.array[j];
            System.arraycopy(this.array, j + 1, this.array, j,
                    count - j - 1);
            this.array[--count] = null;

            return deleted;
        } else {
            throw new IndexOutOfBoundsException("Index was outside " +
                    "of the list");
        }
    }

    @Override
    public boolean remove(Object el) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i].equals(el)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public String toString() {
        String result = "[";

        if (this.count > 0) {
            result += this.array[0].toString();

            for (int i = 1; i < this.count; i++) {
                result += ", " + this.array[i].toString();
            }
        }

        return result + "]";
    }

    @Override
    public Iterator iterator() {
        return new Itr();
    }

    private class Itr implements Iterator {
        int cursor;

        public boolean hasNext() {
            return cursor != ListImpl.this.count;
        }

        public Object next() throws IndexOutOfBoundsException {
            if (cursor < ListImpl.this.count) {
                return ListImpl.this.array[cursor++];
            } else {
                throw new IndexOutOfBoundsException("Index was outside " +
                        "of the list");
            }
        }

        public void remove() throws IndexOutOfBoundsException {
            if (cursor > 0) {
                ListImpl.this.remove(--cursor);
            } else {
                throw new IndexOutOfBoundsException("Index was outside " +
                        "of the list");
            }
        }
    }

    // Multiple capacity of the internal array when list elements count is
    // more than array length
    private void resize() {
        Object[] temp = new Object[this.array.length * 2];
        System.arraycopy(this.array, 0, temp, 0, this.array.length);
        this.array = temp.clone();
    }

    // Checks whether an index is correct for list
    // Returns true if an index is greater than -1 and less than list size
    private boolean checkIndex(int index) {
        return index >= 0 && index < this.count;
    }
}
