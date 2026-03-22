package e.p.d;

/* loaded from: classes.dex */
public final class k implements b {

    /* renamed from: e, reason: collision with root package name */
    private final Class<?> f1541e;

    public k(Class<?> cls, String str) {
        i.d(cls, "jClass");
        i.d(str, "moduleName");
        this.f1541e = cls;
    }

    @Override // e.p.d.b
    public Class<?> a() {
        return this.f1541e;
    }

    public boolean equals(Object obj) {
        return (obj instanceof k) && i.a(a(), ((k) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
