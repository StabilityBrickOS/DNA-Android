package androidx.coordinatorlayout.widget;

import c.d.g;
import c.f.k.e;
import c.f.k.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class a<T> {
    private final e<ArrayList<T>> a = new f(10);

    /* renamed from: b, reason: collision with root package name */
    private final g<T, ArrayList<T>> f309b = new g<>();

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<T> f310c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private final HashSet<T> f311d = new HashSet<>();

    private void e(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (hashSet.contains(t)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t);
        ArrayList<T> arrayList2 = this.f309b.get(t);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                e(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(t);
        arrayList.add(t);
    }

    private ArrayList<T> f() {
        ArrayList<T> b2 = this.a.b();
        return b2 == null ? new ArrayList<>() : b2;
    }

    private void k(ArrayList<T> arrayList) {
        arrayList.clear();
        this.a.a(arrayList);
    }

    public void a(T t, T t2) {
        if (!this.f309b.containsKey(t) || !this.f309b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayList = this.f309b.get(t);
        if (arrayList == null) {
            arrayList = f();
            this.f309b.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    public void b(T t) {
        if (this.f309b.containsKey(t)) {
            return;
        }
        this.f309b.put(t, null);
    }

    public void c() {
        int size = this.f309b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> m = this.f309b.m(i);
            if (m != null) {
                k(m);
            }
        }
        this.f309b.clear();
    }

    public boolean d(T t) {
        return this.f309b.containsKey(t);
    }

    public List g(T t) {
        return this.f309b.get(t);
    }

    public List<T> h(T t) {
        int size = this.f309b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList<T> m = this.f309b.m(i);
            if (m != null && m.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f309b.i(i));
            }
        }
        return arrayList;
    }

    public ArrayList<T> i() {
        this.f310c.clear();
        this.f311d.clear();
        int size = this.f309b.size();
        for (int i = 0; i < size; i++) {
            e(this.f309b.i(i), this.f310c, this.f311d);
        }
        return this.f310c;
    }

    public boolean j(T t) {
        int size = this.f309b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> m = this.f309b.m(i);
            if (m != null && m.contains(t)) {
                return true;
            }
        }
        return false;
    }
}
