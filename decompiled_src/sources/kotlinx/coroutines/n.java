package kotlinx.coroutines;

/* loaded from: classes.dex */
public final class n extends j1<l1> implements m {
    public final o i;

    public n(l1 l1Var, o oVar) {
        super(l1Var);
        this.i = oVar;
    }

    @Override // kotlinx.coroutines.m
    public boolean d(Throwable th) {
        return ((l1) this.h).y(th);
    }

    @Override // e.p.c.l
    public /* bridge */ /* synthetic */ e.j invoke(Throwable th) {
        r(th);
        return e.j.a;
    }

    @Override // kotlinx.coroutines.u
    public void r(Throwable th) {
        this.i.i((t1) this.h);
    }

    @Override // kotlinx.coroutines.internal.i
    public String toString() {
        return "ChildHandle[" + this.i + ']';
    }
}
