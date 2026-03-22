package androidx.lifecycle;

/* loaded from: classes.dex */
public class q {
    private final a a;

    /* renamed from: b, reason: collision with root package name */
    private final r f454b;

    /* loaded from: classes.dex */
    public interface a {
        <T extends p> T a(Class<T> cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class b implements a {
        b() {
        }

        @Override // androidx.lifecycle.q.a
        public <T extends p> T a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends p> T b(String str, Class<T> cls);
    }

    public q(r rVar, a aVar) {
        this.a = aVar;
        this.f454b = rVar;
    }

    public <T extends p> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public <T extends p> T b(String str, Class<T> cls) {
        T t = (T) this.f454b.b(str);
        if (cls.isInstance(t)) {
            return t;
        }
        a aVar = this.a;
        T t2 = aVar instanceof b ? (T) ((b) aVar).b(str, cls) : (T) aVar.a(cls);
        this.f454b.c(str, t2);
        return t2;
    }
}
