package kotlinx.coroutines.internal;

import kotlinx.coroutines.i0;

/* loaded from: classes.dex */
public abstract class o {
    public abstract c<?> a();

    public final boolean b(o oVar) {
        c<?> a;
        c<?> a2 = a();
        return (a2 == null || (a = oVar.a()) == null || a2.f() >= a.f()) ? false : true;
    }

    public abstract Object c(Object obj);

    public String toString() {
        return i0.a(this) + '@' + i0.b(this);
    }
}
