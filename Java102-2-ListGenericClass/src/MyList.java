public class MyList<T> {
private T[] array;
private int size;
private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyList() {
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
    @SuppressWarnings("unchecked")
    public MyList(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity cannot be negative.");
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }
    public int size(){
        return this.size;
    }

    public int getCapacity() {
        return this.array.length;
    }
    public void add(T data){
        if(size== array.length){
            resizeArray();
        }
        array[size++] = data;
    }
    @SuppressWarnings("unchecked")
    private void resizeArray() {
        T[] newArray = (T[]) new Object[array.length*2];
        System.arraycopy(array,0,newArray,0,array.length);
        array=newArray;
    }
    public T get(int index){
        if(index<0||index>=size){
            return null;
        }
        return array[index];
    }
    public T remove(int index){
        if(index<0 ||index>=size){
            return null;
        }
        T removedElement = array[index];
        for(int i=index ; i<size -1 ; i++){
            array[i] = array[i+1];
        }
        array[--size] = null;
        return removedElement;
    }
    public T set(int index,T data){
        if(index<0 || index >= size){
            return null;
        }
        T oldData = array[index];
        array[index] = data;
        return oldData;
    }

    @Override
    public String toString(){
        if(size==0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for(int i= 0; i<size ; i++){
            sb.append(array[i]);
            if(i<size-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int indexOf(T data){
        for(int i=0;i<size;i++){
            if(array[i].equals(data))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(T data){
        for(int i=size-1;i>=0;i--){
            if(array[i].equals(data)){
                return i;
            }
        }
        return -1;
    }
    public boolean isEmpty(){
        return size==0;
    }
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] newArray = (T[]) new Object[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }
    public MyList<T> subList(int start, int finish) {
        if (start < 0 || finish >= size || start > finish) {
            throw new IndexOutOfBoundsException("Invalid subList range");
        }
        MyList<T> sublist = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            sublist.add(array[i]);
        }
        return sublist;
    }
    
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }




    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("2. indisteki değer : " + list.get(2));
        list.remove(2);
        list.add(40);
        list.set(0, 100);
        System.out.println("2. indisteki değer : " + list.get(2));
        System.out.println(list.toString());

        // Ek testler
        System.out.println("Liste Durumu : " + (list.isEmpty() ? "Boş" : "Dolu"));
        list.add(20);
        list.add(50);
        list.add(60);
        list.add(70);
        System.out.println("Liste Durumu : " + (list.isEmpty() ? "Boş" : "Dolu"));
        System.out.println("Indeks : " + list.indexOf(20));
        System.out.println("Indeks :" + list.indexOf(100));
        System.out.println("Indeks : " + list.lastIndexOf(20));
        Object[] dizi = list.toArray();
        System.out.println("Object dizisinin ilk elemanı :" + dizi[0]);
        MyList<Integer> altListem = list.subList(0, 3);
        System.out.println(altListem.toString());
        System.out.println("Listemde 20 değeri : " + list.contains(20));
        System.out.println("Listemde 120 değeri : " + list.contains(120));
        list.clear();
        System.out.println(list.toString());



    }
}