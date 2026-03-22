package kotlinx.coroutines;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g1 extends k1<h1> {
    private final e.p.c.l<Throwable, e.j> i;

    /* JADX WARN: Multi-variable type inference failed */
    public g1(h1 h1Var, e.p.c.l<? super Throwable, e.j> lVar) {
        super(h1Var);
        this.i = lVar;
    }

    @Override // e.p.c.l
    public /* bridge */ /* synthetic */ e.j invoke(Throwable th) {
        r(th);
        return e.j.a;
    }

    @Override // kotlinx.coroutines.u
    public void r(Throwable th) {
        this.i.invoke(th);
    }

    @Override // kotlinx.coroutines.internal.i
    public String toString() {
        return "InvokeOnCompletion[" + i0.a(this) + '@' + i0.b(this) + ']';
    }
}
