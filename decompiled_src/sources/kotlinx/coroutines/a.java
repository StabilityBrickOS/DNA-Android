package kotlinx.coroutines;

/* loaded from: classes.dex */
public abstract class a<T> extends l1 implements h1, e.m.d<T>, d0 {
    private final e.m.g f;
    protected final e.m.g g;

    public a(e.m.g gVar, boolean z) {
        super(z);
        this.g = gVar;
        this.f = gVar.plus(this);
    }

    @Override // kotlinx.coroutines.l1
    public final void M(Throwable th) {
        a0.a(this.f, th);
    }

    @Override // kotlinx.coroutines.l1
    public String U() {
        String b2 = x.b(this.f);
        if (b2 == null) {
            return super.U();
        }
        return '\"' + b2 + "\":" + super.U();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.l1
    protected final void Z(Object obj) {
        if (!(obj instanceof q)) {
            s0(obj);
        } else {
            q qVar = (q) obj;
            r0(qVar.a, qVar.a());
        }
    }

    @Override // kotlinx.coroutines.l1, kotlinx.coroutines.h1
    public boolean a() {
        return super.a();
    }

    @Override // kotlinx.coroutines.l1
    public final void a0() {
        t0();
    }

    @Override // kotlinx.coroutines.d0
    public e.m.g g() {
        return this.f;
    }

    @Override // e.m.d
    public final e.m.g getContext() {
        return this.f;
    }

    protected void p0(Object obj) {
        r(obj);
    }

    public final void q0() {
        N((h1) this.g.get(h1.f1578d));
    }

    protected void r0(Throwable th, boolean z) {
    }

    @Override // e.m.d
    public final void resumeWith(Object obj) {
        Object S = S(r.a(obj));
        if (S == m1.f1602b) {
            return;
        }
        p0(S);
    }

    protected void s0(T t) {
    }

    protected void t0() {
    }

    public final <R> void u0(f0 f0Var, R r, e.p.c.p<? super R, ? super e.m.d<? super T>, ? extends Object> pVar) {
        q0();
        f0Var.invoke(pVar, r, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.l1
    public String x() {
        return i0.a(this) + " was cancelled";
    }
}
