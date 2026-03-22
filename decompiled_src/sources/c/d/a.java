package c.d;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class a<K, V> extends g<K, V> implements Map<K, V> {
    f<K, V> l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0026a extends f<K, V> {
        C0026a() {
        }

        @Override // c.d.f
        protected void a() {
            a.this.clear();
        }

        @Override // c.d.f
        protected Object b(int i, int i2) {
            return a.this.f[(i << 1) + i2];
        }

        @Override // c.d.f
        protected Map<K, V> c() {
            return a.this;
        }

        @Override // c.d.f
        protected int d() {
            return a.this.g;
        }

        @Override // c.d.f
        protected int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // c.d.f
        protected int f(Object obj) {
            return a.this.h(obj);
        }

        @Override // c.d.f
        protected void g(K k, V v) {
            a.this.put(k, v);
        }

        @Override // c.d.f
        protected void h(int i) {
            a.this.k(i);
        }

        @Override // c.d.f
        protected V i(int i, V v) {
            return a.this.l(i, v);
        }
    }

    public a() {
    }

    public a(int i) {
        super(i);
    }

    public a(g gVar) {
        super(gVar);
    }

    private f<K, V> n() {
        if (this.l == null) {
            this.l = new C0026a();
        }
        return this.l;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return n().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return n().m();
    }

    public boolean o(Collection<?> collection) {
        return f.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.g + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return n().n();
    }
}
