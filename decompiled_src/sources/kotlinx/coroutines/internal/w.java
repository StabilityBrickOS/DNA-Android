package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.internal.x;

/* loaded from: classes.dex */
public class w<T extends x & Comparable<? super T>> {
    private volatile int _size = 0;
    private T[] a;

    private final T[] f() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new x[4];
            this.a = tArr2;
            return tArr2;
        }
        if (c() < tArr.length) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, c() * 2);
        e.p.d.i.c(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((x[]) copyOf);
        this.a = tArr3;
        return tArr3;
    }

    private final void j(int i) {
        this._size = i;
    }

    private final void k(int i) {
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 >= c()) {
                return;
            }
            T[] tArr = this.a;
            e.p.d.i.b(tArr);
            int i3 = i2 + 1;
            if (i3 < c()) {
                T t = tArr[i3];
                e.p.d.i.b(t);
                T t2 = tArr[i2];
                e.p.d.i.b(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    i2 = i3;
                }
            }
            T t3 = tArr[i];
            e.p.d.i.b(t3);
            T t4 = tArr[i2];
            e.p.d.i.b(t4);
            if (((Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            m(i, i2);
            i = i2;
        }
    }

    private final void l(int i) {
        while (i > 0) {
            T[] tArr = this.a;
            e.p.d.i.b(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            e.p.d.i.b(t);
            T t2 = tArr[i];
            e.p.d.i.b(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            m(i, i2);
            i = i2;
        }
    }

    private final void m(int i, int i2) {
        T[] tArr = this.a;
        e.p.d.i.b(tArr);
        T t = tArr[i2];
        e.p.d.i.b(t);
        T t2 = tArr[i];
        e.p.d.i.b(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.a(i);
        t2.a(i2);
    }

    public final void a(T t) {
        if (h0.a()) {
            if (!(t.e() == null)) {
                throw new AssertionError();
            }
        }
        t.c(this);
        T[] f = f();
        int c2 = c();
        j(c2 + 1);
        f[c2] = t;
        t.a(c2);
        l(c2);
    }

    public final T b() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return this._size;
    }

    public final boolean d() {
        return c() == 0;
    }

    public final T e() {
        T b2;
        synchronized (this) {
            b2 = b();
        }
        return b2;
    }

    public final boolean g(T t) {
        boolean z;
        synchronized (this) {
            z = true;
            if (t.e() == null) {
                z = false;
            } else {
                int f = t.f();
                if (h0.a()) {
                    if (!(f >= 0)) {
                        throw new AssertionError();
                    }
                }
                h(f);
            }
        }
        return z;
    }

    public final T h(int i) {
        if (h0.a()) {
            if (!(c() > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.a;
        e.p.d.i.b(tArr);
        j(c() - 1);
        if (i < c()) {
            m(i, c());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                T t = tArr[i];
                e.p.d.i.b(t);
                T t2 = tArr[i2];
                e.p.d.i.b(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    m(i, i2);
                    l(i2);
                }
            }
            k(i);
        }
        T t3 = tArr[c()];
        e.p.d.i.b(t3);
        if (h0.a()) {
            if (!(t3.e() == this)) {
                throw new AssertionError();
            }
        }
        t3.c(null);
        t3.a(-1);
        tArr[c()] = null;
        return t3;
    }

    public final T i() {
        T h;
        synchronized (this) {
            h = c() > 0 ? h(0) : null;
        }
        return h;
    }
}
