package e.m.j.a;

/* loaded from: classes.dex */
public final class b implements e.m.d<Object> {

    /* renamed from: e, reason: collision with root package name */
    public static final b f1535e = new b();

    private b() {
    }

    @Override // e.m.d
    public e.m.g getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // e.m.d
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
