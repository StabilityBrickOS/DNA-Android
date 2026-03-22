package c.b.a.b;

import c.b.a.b.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {
    private HashMap<K, b.c<K, V>> i = new HashMap<>();

    @Override // c.b.a.b.b
    protected b.c<K, V> c(K k) {
        return this.i.get(k);
    }

    public boolean contains(K k) {
        return this.i.containsKey(k);
    }

    @Override // c.b.a.b.b
    public V g(K k, V v) {
        b.c<K, V> c2 = c(k);
        if (c2 != null) {
            return c2.f;
        }
        this.i.put(k, f(k, v));
        return null;
    }

    @Override // c.b.a.b.b
    public V h(K k) {
        V v = (V) super.h(k);
        this.i.remove(k);
        return v;
    }

    public Map.Entry<K, V> i(K k) {
        if (contains(k)) {
            return this.i.get(k).h;
        }
        return null;
    }
}
