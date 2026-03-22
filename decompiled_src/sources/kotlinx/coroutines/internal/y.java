package kotlinx.coroutines.internal;

/* loaded from: classes.dex */
final class y {
    private Object[] a;

    /* renamed from: b, reason: collision with root package name */
    private int f1595b;

    /* renamed from: c, reason: collision with root package name */
    private final e.m.g f1596c;

    public y(e.m.g gVar, int i) {
        this.f1596c = gVar;
        this.a = new Object[i];
    }

    public final void a(Object obj) {
        Object[] objArr = this.a;
        int i = this.f1595b;
        this.f1595b = i + 1;
        objArr[i] = obj;
    }

    public final e.m.g b() {
        return this.f1596c;
    }

    public final void c() {
        this.f1595b = 0;
    }

    public final Object d() {
        Object[] objArr = this.a;
        int i = this.f1595b;
        this.f1595b = i + 1;
        return objArr[i];
    }
}
