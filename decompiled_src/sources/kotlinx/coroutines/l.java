package kotlinx.coroutines;

/* loaded from: classes.dex */
public final class l extends j1<h1> {
    public final i<?> i;

    public l(h1 h1Var, i<?> iVar) {
        super(h1Var);
        this.i = iVar;
    }

    @Override // e.p.c.l
    public /* bridge */ /* synthetic */ e.j invoke(Throwable th) {
        r(th);
        return e.j.a;
    }

    @Override // kotlinx.coroutines.u
    public void r(Throwable th) {
        i<?> iVar = this.i;
        iVar.x(iVar.o(this.h));
    }

    @Override // kotlinx.coroutines.internal.i
    public String toString() {
        return "ChildContinuation[" + this.i + ']';
    }
}
