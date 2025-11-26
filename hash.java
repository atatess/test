public class Hash<T> {

    T[] table;
    int M;
    boolean[] valid;

    public Hash(int M) {
        table = (T[]) new Object[M];
        valid = new boolean[M];
        this.M = M;
    }

    public boolean insert(T key) {
        int ix = hash(key);
        table[ix] = key;
        valid[ix] = true;
        return true;
    }

    public int hash(T key) {
        return key.hashCode() % M;
    }

}

//----------------------

public class LinearProbingHash<Key> {

    Key[] table;
    int M; // size of the table
    int N; // number of currently stored keys

    public LinearProbingHash(int M) {
        table = (Key[]) new Object[M];
        this.M = M;
    }

    public int hash(Key k) {
        return k.hashCode() % table.length;
    }

    public boolean contains(Key key) {
        int ix = hash(key);
        int startIx = ix;
        while (table[ix] != null) {
            if (table[ix].equals(key)) {
                return true;
            }
            if (ix + 1 == startIx) {
                return false; // start
            }
            ix = (ix + 1) % M; // cycle through
        }
        return false;
    }

    public boolean insert(Key key) {
        int ix = hash(key);
        // must check for a whole cycle there can be infinite  
        int startIx = ix;
        while (table[ix] != null) {
            if (ix + 1 == startIx) {
                return false; // Table is full	
                
            }
            if (table[ix].equals(key)) {
                return false; //Table has got the key	
            }
            ix = (ix + 1) % M;
        }
        // reaching here mans table[ix] is empty
        table[ix] = key;
        N++;
        if(N == M/2)
            resize(2*M);
        return true;
    }
    
    public void delete(Key key){
        if(!contains(key)) return;
        int i = hash(key);
        while(!key.equals(table[i]))
            i = (i+1) % M;
        table[i] = null;
        N--;
        
        //rehashing
        i = (i+1)%M;
        while(table[i] != null){
            Key keyToRedo = table[i];
            table[i] = null;
            N--;
            insert(keyToRedo);
            i = (i+1)%M;
        }
        
        //resize
        if(N>0 && N==M/8)
            resize(M/2);
    }
    
    public void resize(int newSize){
        Key[] backup = table;
        table = (Key[])new Object[newSize];
        N = 0;
        for (int i = 0; i < backup.length; i++) {
            if(backup[i] != null){
                insert(backup[i]);
            }
        }
        M = newSize;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < M; i++) {
            s += table[i] + ", ";
        }
        return s;
    }
    
    

}

//----------------------------

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gameb
 */
public class SeparateChainHash<T> {

    int M;
    LinkedList<T>[] table;

    public SeparateChainHash(int M) {
        table = new LinkedList[M];
        for (int ix = 0; ix < M; ix++) {
            table[ix] = new LinkedList<T>();
        }
        this.M = M;

    }

    public void insert(T t) {
        int ix = hash(t);
        table[ix].insertFirst(t);
    }

    public boolean contains(T t) {
        int ix = hash(t);
        Node<T> n = table[ix].search(t);
        return n == null;
    }
    
    public int hash(T t){
        return t.hashCode()%M;
    }
    


    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < M; i++) {
            System.out.println(i + ": " + table[i]);
        }
        return s;
    }
    
    

}
