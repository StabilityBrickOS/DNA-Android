package kotlinx.coroutines;

import e.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u1<T> extends k1<l1> {
    private final i<T> i;

    /* JADX WARN: Multi-variable type inference failed */
    public u1(l1 l1Var, i<? super T> iVar) {
        super(l1Var);
        this.i = iVar;
    }

    @Override // e.p.c.l
    public /* bridge */ /* synthetic */ e.j invoke(Throwable th) {
        r(th);
        return e.j.a;
    }

    @Override // kotlinx.coroutines.u
    public void r(Throwable th) {
        i<T> iVar;
        Object h;
        Object K = ((l1) this.h).K();
        if (h0.a() && !(!(K instanceof c1))) {
            throw new AssertionError();
        }
        if (K instanceof q) {
            iVar = this.i;
            Throwable th2 = ((q) K).a;
            f.a aVar = e.f.Companion;
            h = e.g.a(th2);
        } else {
            iVar = this.i;
            h = m1.h(K);
            f.a aVar2 = e.f.Companion;
        }
        iVar.resumeWith(e.f.m266constructorimpl(h));
    }

    @Override // kotlinx.coroutines.internal.i
    public String toString() {
        return "ResumeAwaitOnCompletion[" + this.i + ']';
    }
}
