class DynamicArray {
    int[] arr;
    int len;

    public DynamicArray(int capacity) {
        arr = new int[capacity];
        len = 0;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (len == getCapacity()) {
            resize();
        }
        arr[len] = n;
        len += 1;
    }

    public int popback() {
        return arr[--len];
    }

    private void resize() {
        int[] tempArr = new int[len*2];
        for (int i = 0; i < len; i++) {
            tempArr[i] = arr[i];
        }
        arr = tempArr;
    }

    public int getSize() {
        return len;
    }

    public int getCapacity() {
        return arr.length;
    }
}
