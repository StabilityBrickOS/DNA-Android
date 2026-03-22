package e.n.d;

import e.p.d.i;

/* loaded from: classes.dex */
public class a extends e.n.a {
    @Override // e.n.a
    public void a(Throwable th, Throwable th2) {
        i.d(th, "cause");
        i.d(th2, "exception");
        th.addSuppressed(th2);
    }
}
