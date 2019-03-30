package Table;

public class HashTable {


    public static void main(String[] args) {

    }

    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;

    public HashTable(int size) {
        this.arraySize = size;
        this.hashArray = new DataItem[arraySize];
        this.nonItem = new DataItem(-1);
    }

    public DataItem find(int key) {
        int hashVal = hashFunc(key);
        int secondHashVal = hashFuncSecond(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
//            ++hashVal;
            hashVal += secondHashVal;
            hashVal %= arraySize; //hashVal = hashVal % arraySize
        }
        return null;
    }

    private int hashFunc(int key) {
        return key % arraySize;
    }

    private int hashFuncSecond(int key) {
        return 33 - key % 33;
    }

    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int secondHashVal = hashFuncSecond(key);
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
//            ++hashVal;
            hashVal += secondHashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItem delete(int key) {
        int hashVal = hashFunc(key);
        int secondHashVal = hashFuncSecond(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
//            ++hashVal;
            hashVal += secondHashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    private int getPrime(int min) {
        for (int i = min + 1; true; i++) {
            if (isPrime(i))
                return i;
        }
    }

    private boolean isPrime(int i) {
        for (int j = 2; (j * j <= i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public void display() {
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null) System.out.println(hashArray[i].getKey());
            else System.out.println("element is null");
        }
    }
}


