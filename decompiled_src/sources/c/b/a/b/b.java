package c.b.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: e, reason: collision with root package name */
    c<K, V> f668e;
    private c<K, V> f;
    private WeakHashMap<f<K, V>, Boolean> g = new WeakHashMap<>();
    private int h = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // c.b.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.h;
        }

        @Override // c.b.a.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.g;
        }
    }

    /* renamed from: c.b.a.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0025b<K, V> extends e<K, V> {
        C0025b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // c.b.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.g;
        }

        @Override // c.b.a.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: e, reason: collision with root package name */
        final K f669e;
        final V f;
        c<K, V> g;
        c<K, V> h;

        c(K k, V v) {
            this.f669e = k;
            this.f = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f669e.equals(cVar.f669e) && this.f.equals(cVar.f);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f669e;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f669e.hashCode() ^ this.f.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f669e + "=" + this.f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: e, reason: collision with root package name */
        private c<K, V> f670e;
        private boolean f = true;

        d() {
        }

        @Override // c.b.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f670e;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.h;
                this.f670e = cVar3;
                this.f = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.f) {
                this.f = false;
                cVar = b.this.f668e;
            } else {
                c<K, V> cVar2 = this.f670e;
                cVar = cVar2 != null ? cVar2.g : null;
            }
            this.f670e = cVar;
            return this.f670e;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f) {
                return b.this.f668e != null;
            }
            c<K, V> cVar = this.f670e;
            return (cVar == null || cVar.g == null) ? false : true;
        }
    }

    /* loaded from: classes.dex */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: e, reason: collision with root package name */
        c<K, V> f671e;
        c<K, V> f;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f671e = cVar2;
            this.f = cVar;
        }

        private c<K, V> e() {
            c<K, V> cVar = this.f;
            c<K, V> cVar2 = this.f671e;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // c.b.a.b.b.f
        public void a(c<K, V> cVar) {
            if (this.f671e == cVar && cVar == this.f) {
                this.f = null;
                this.f671e = null;
            }
            c<K, V> cVar2 = this.f671e;
            if (cVar2 == cVar) {
                this.f671e = b(cVar2);
            }
            if (this.f == cVar) {
                this.f = e();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f;
            this.f = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> a() {
        C0025b c0025b = new C0025b(this.f, this.f668e);
        this.g.put(c0025b, Boolean.FALSE);
        return c0025b;
    }

    public Map.Entry<K, V> b() {
        return this.f668e;
    }

    protected c<K, V> c(K k) {
        c<K, V> cVar = this.f668e;
        while (cVar != null && !cVar.f669e.equals(k)) {
            cVar = cVar.g;
        }
        return cVar;
    }

    public b<K, V>.d d() {
        b<K, V>.d dVar = new d();
        this.g.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c<K, V> f(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.h++;
        c<K, V> cVar2 = this.f;
        if (cVar2 == null) {
            this.f668e = cVar;
        } else {
            cVar2.g = cVar;
            cVar.h = cVar2;
        }
        this.f = cVar;
        return cVar;
    }

    public V g(K k, V v) {
        c<K, V> c2 = c(k);
        if (c2 != null) {
            return c2.f;
        }
        f(k, v);
        return null;
    }

    public V h(K k) {
        c<K, V> c2 = c(k);
        if (c2 == null) {
            return null;
        }
        this.h--;
        if (!this.g.isEmpty()) {
            Iterator<f<K, V>> it = this.g.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(c2);
            }
        }
        c<K, V> cVar = c2.h;
        if (cVar != null) {
            cVar.g = c2.g;
        } else {
            this.f668e = c2.g;
        }
        c<K, V> cVar2 = c2.g;
        if (cVar2 != null) {
            cVar2.h = c2.h;
        } else {
            this.f = c2.h;
        }
        c2.g = null;
        c2.h = null;
        return c2.f;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f668e, this.f);
        this.g.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.h;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
