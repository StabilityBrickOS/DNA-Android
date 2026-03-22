package kotlinx.coroutines;

/* loaded from: classes.dex */
public enum f0 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public static /* synthetic */ void isLazy$annotations() {
    }

    public final <T> void invoke(e.p.c.l<? super e.m.d<? super T>, ? extends Object> lVar, e.m.d<? super T> dVar) {
        int i = e0.a[ordinal()];
        if (i == 1) {
            kotlinx.coroutines.d2.a.b(lVar, dVar);
            return;
        }
        if (i == 2) {
            e.m.f.a(lVar, dVar);
        } else if (i == 3) {
            kotlinx.coroutines.d2.b.a(lVar, dVar);
        } else if (i != 4) {
            throw new e.d();
        }
    }

    public final <R, T> void invoke(e.p.c.p<? super R, ? super e.m.d<? super T>, ? extends Object> pVar, R r, e.m.d<? super T> dVar) {
        int i = e0.f1561b[ordinal()];
        if (i == 1) {
            kotlinx.coroutines.d2.a.c(pVar, r, dVar);
            return;
        }
        if (i == 2) {
            e.m.f.b(pVar, r, dVar);
        } else if (i == 3) {
            kotlinx.coroutines.d2.b.b(pVar, r, dVar);
        } else if (i != 4) {
            throw new e.d();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }
}
