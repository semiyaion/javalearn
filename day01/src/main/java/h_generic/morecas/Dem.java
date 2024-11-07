package h_generic.morecas;

class Dem <K,V>{
    private K key;
    /*外部确定K的类型并赋予key*/
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Dem(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Dem() {
    }

    @Override
    public String toString() {
        return "Dem{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
