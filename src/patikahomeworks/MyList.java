package patikahomeworks;

public class MyList<T> {
    private T[] elements;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyList() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyList(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return elements.length;
    }

    public void add(T data) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = data;
    }

    private void resize() {
        T[] temp = (T[]) new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            temp[i] = elements[i];
        }
        elements = temp;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return elements[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        T removedElement = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return removedElement;
    }

    public void set(int index, T data) {
        if (index < 0 || index >= size) {
            return;
        }
        elements[index] = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]).append(", ");
        }
        if (size > 0) {
            sb.deleteCharAt(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T[] toArray() {
        T[] arr = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = elements[i];
        }
        return arr;
    }

    public void clear() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyList<T> subList(int start, int finish) {
        if (start < 0 || start >= size || finish < 0 || finish > size || start > finish) {
            return null;
        }
        MyList<T> subList = new MyList<>(finish - start);
        for (int i = start; i < finish; i++) {
            subList.add(elements[i]);
        }
        return subList;
    }

    public boolean contains(T data) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(data)) {
                return true;
            }
        }
        return false;
    }
}
