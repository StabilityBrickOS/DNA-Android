package c.f.k;

/* loaded from: classes.dex */
public class g<T> extends f<T> {

    /* renamed from: c, reason: collision with root package name */
    private final Object f781c;

    public g(int i) {
        super(i);
        this.f781c = new Object();
    }

    @Override // c.f.k.f, c.f.k.e
    public boolean a(T t) {
        boolean a;
        synchronized (this.f781c) {
            a = super.a(t);
        }
        return a;
    }

    @Override // c.f.k.f, c.f.k.e
    public T b() {
        T t;
        synchronized (this.f781c) {
            t = (T) super.b();
        }
        return t;
    }
}
