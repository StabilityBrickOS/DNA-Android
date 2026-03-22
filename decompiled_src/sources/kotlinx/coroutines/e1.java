package kotlinx.coroutines;

/* loaded from: classes.dex */
final class e1 extends f {

    /* renamed from: e, reason: collision with root package name */
    private final e.p.c.l<Throwable, e.j> f1562e;

    /* JADX WARN: Multi-variable type inference failed */
    public e1(e.p.c.l<? super Throwable, e.j> lVar) {
        this.f1562e = lVar;
    }

    @Override // kotlinx.coroutines.g
    public void a(Throwable th) {
        this.f1562e.invoke(th);
    }

    @Override // e.p.c.l
    public /* bridge */ /* synthetic */ e.j invoke(Throwable th) {
        a(th);
        return e.j.a;
    }

    public String toString() {
        return "InvokeOnCancel[" + i0.a(this.f1562e) + '@' + i0.b(this) + ']';
    }
}
