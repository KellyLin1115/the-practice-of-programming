package chapter3.item3;

import java.util.ArrayList;
import java.util.List;

public class Prefix<T> {
    public List<T> pref = new ArrayList<>();

    public Prefix(Prefix<T> p) {
        for (T t : p.pref)
            this.pref.add(t);
    }

    public Prefix(int n, T t) {
        for (int i = 0; i < n; i++) {
            this.pref.add(t);
        }
    }
    @Override
    public int hashCode(){
        int h = 0;
        for(T t: pref)
            h = h * 31 + t.hashCode();
        return h;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if(o == null)
            return false;
        if(!(o instanceof Prefix))
            return false;
        Prefix p = (Prefix) o;
        for (int i = 0; i < pref.size(); i++) {
            if(!this.pref.get(i).equals(p.pref.get(i)))
                return false;
        }
        return true;
    }
}
