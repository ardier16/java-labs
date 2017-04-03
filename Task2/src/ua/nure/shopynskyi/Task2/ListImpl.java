package ua.nure.shopynskyi.Task2;

public class ListImpl implements List {

    private Object[] array;
    private int count;
    private String exMessage = "Index was outside of the list";

    public ListImpl() {
        this.array = new Object[10];
    }

    // Main method for the list tests
    public static void main(String[] args) {

        // Declarations
        String defResult = "~~~ Result: [D, E, F]";
        String addAll = "~~~ list.addAll(list2)";

        // Lists creating
        System.out.println("~~~ list A B C");
        System.out.println("~~~ Result: [A, B, C]");
        List list = new ListImpl();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list);

        // 1
        System.out.println("~~~ list2: D E F");
        System.out.println(defResult);
        List list2 = new ListImpl();
        list2.add("D");
        list2.add("E");
        list2.add("F");
        System.out.println(list2);

        // Adding elements
        System.out.println(addAll);
        System.out.println("~~~ Result: [A, B, C, D, E, F]");
        list.addAll(list2);
        System.out.println(list);

        System.out.println("~~~ list.add(C)");
        System.out.println("~~~ Result: [A, B, C, D, E, F, C]");
        list.add("C");
        System.out.println(list);

        // List methods tests
        System.out.println("~~~ list.clear()");
        System.out.println("~~~ Result: []");
        list.clear();
        System.out.println(list);

        System.out.println(addAll);
        System.out.println(defResult);
        list.addAll(list2);
        System.out.println(list);

        // List contains methods
        System.out.println("~~~ list.contains(E)");
        System.out.println("~~~ Result: true");
        System.out.println(list.contains("E"));

        // 1
        System.out.println("~~~ list.contains(С)");
        System.out.println("~~~ Result: false");
        System.out.println(list.contains("С"));

        // 2
        System.out.println("~~~ list.indexOf(D)");
        System.out.println("~~~ Result: 0");
        System.out.println(list.indexOf("D"));

        // 3
        System.out.println("~~~ list.get(2)");
        System.out.println("~~~ Result: F");
        System.out.println(list.get(2));

        // 4
        System.out.println("~~~ list.indexOf(F)");
        System.out.println("~~~ Result: 2");
        System.out.println(list.indexOf("F"));

        // 5
        System.out.println("~~~ list.size()");
        System.out.println("~~~ Result: 3");
        System.out.println(list.size());

        // 6
        System.out.println("~~~ list");
        System.out.println(defResult);
        System.out.println(list);

        // List remove methods
        System.out.println("~~~ list.remove(1)");
        System.out.println("~~~ Result: [D, F]");
        list.remove(1);
        System.out.println(list);

        // 7
        System.out.println("~~~ list.remove(F)");
        System.out.println("~~~ Result: [D]");
        list.remove("F");
        System.out.println(list);

        // 8
        System.out.println("~~~ list.size()");
        System.out.println("~~~ Result: 1");
        System.out.println(list.size());

        // 9
        System.out.println(addAll);
        System.out.println("~~~ Result: [D, D, E, F]");
        list.addAll(list2);
        System.out.println(list);

        testIter(list, list2);
    }

    private static void testIter(List list, List list2) {
        String itNext = "~~~ it.next()";

        // 11
        System.out.println("~~~ foreach list");
        System.out.println("~~~ Result: D D E F");
        for (Object el : list) {
            System.out.print(el + " ");
        }
        System.out.println();

        // 12
        System.out.println("~~~ Iterator it = list.iterator()");
        ListIterator it = list.iterator();

        // 13
        System.out.println("~~~ it.next()");
        System.out.println("~~~ Result: D");
        System.out.println(it.next());

        // 14
        System.out.println(itNext);
        System.out.println("~~~ Result: D");
        System.out.println(it.next());

        // 15
        System.out.println("~~~ it.remove()");
        System.out.println("~~~ Result: [D, E, F]");
        it.remove();
        System.out.println(list);

        // 16
        System.out.println(itNext);
        System.out.println("~~~ Result: E");
        System.out.println(it.next());

        // 17
        System.out.println("~~~ it.remove()");
        System.out.println("~~~ Result: [D, F]");
        it.remove();
        System.out.println(list);

        // 18
        System.out.println(itNext);
        System.out.println("~~~ Result: F");
        System.out.println(it.next());

        // 19
        System.out.println("~~~ it.remove()");
        System.out.println("~~~ Result: [D]");
        it.remove();
        System.out.println(list);

        // 20
        System.out.println("~~~ list.remove(D)");
        System.out.println("~~~ Result: []");
        list.remove("D");
        System.out.println(list);

        // 21
        System.out.println("~~~ list.addAll(list2)");
        System.out.println("~~~ Result: [D, E, F]");
        list.addAll(list2);
        System.out.println(list);

        // 22
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
        Object[] arr = list.toArray();

        for (Object obj : arr) {
            this.add(obj);
        }
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[count];
        System.arraycopy(this.array, 0, arr, 0, count);

        return arr;
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
    public Object get(int index) {
        if (checkIndex(index)) {
            return this.array[index];
        } else {
            throw new IndexOutOfBoundsException(exMessage);
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
    public Object remove(int j) {
        if (checkIndex(j)) {
            Object deleted = this.array[j];
            System.arraycopy(this.array, j + 1, this.array, j,
                    count - j - 1);
            this.array[--count] = null;

            return deleted;
        } else {
            throw new IndexOutOfBoundsException(exMessage);
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
        StringBuilder result = new StringBuilder();
        result.append("[");

        if (this.count > 0) {
            result.append(this.array[0].toString());

            for (int i = 1; i < this.count; i++) {
                result.append(", ");
                result.append(this.array[i].toString());
            }
        }

        result.append("]");


        return result.toString();
    }

    @Override
    public ListIterator iterator() {
        return new Itr();
    }

    private class Itr implements ListIterator {
        private int cursor;

        public boolean hasNext() {
            return cursor != ListImpl.this.count;
        }

        public Object next() {
            if (cursor < ListImpl.this.count) {
                return ListImpl.this.array[cursor++];
            } else {
                throw new IllegalStateException(exMessage);
            }
        }

        public void remove() {
            if (cursor > 0) {
                ListImpl.this.remove(--cursor);
            } else {
                throw new IllegalStateException(exMessage);
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
