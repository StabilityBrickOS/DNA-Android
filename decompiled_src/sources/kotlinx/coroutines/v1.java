package kotlinx.coroutines;

/* loaded from: classes.dex */
class v1 extends a<e.j> {
    public v1(e.m.g gVar, boolean z) {
        super(gVar, z);
    }

    @Override // kotlinx.coroutines.l1
    protected boolean L(Throwable th) {
        a0.a(getContext(), th);
        return true;
    }
}
