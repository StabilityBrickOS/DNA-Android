package kotlinx.coroutines.e2;

import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.y;

/* loaded from: classes.dex */
public final class c extends d {
    private static final y k;
    public static final c l;

    static {
        int a;
        int d2;
        c cVar = new c();
        l = cVar;
        a = e.r.f.a(64, s.a());
        d2 = u.d("kotlinx.coroutines.io.parallelism", a, 0, 0, 12, null);
        k = new f(cVar, d2, "Dispatchers.IO", 1);
    }

    private c() {
        super(0, 0, null, 7, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public final y r() {
        return k;
    }

    @Override // kotlinx.coroutines.y
    public String toString() {
        return "Dispatchers.Default";
    }
}
