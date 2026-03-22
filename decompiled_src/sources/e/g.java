package e;

import e.f;

/* loaded from: classes.dex */
public final class g {
    public static final Object a(Throwable th) {
        e.p.d.i.d(th, "exception");
        return new f.b(th);
    }

    public static final void b(Object obj) {
        if (obj instanceof f.b) {
            throw ((f.b) obj).exception;
        }
    }
}
