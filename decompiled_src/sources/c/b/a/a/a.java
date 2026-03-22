package c.b.a.a;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f665c;
    private c a;

    /* renamed from: b, reason: collision with root package name */
    private c f666b;

    private a() {
        b bVar = new b();
        this.f666b = bVar;
        this.a = bVar;
    }

    public static a b() {
        if (f665c != null) {
            return f665c;
        }
        synchronized (a.class) {
            if (f665c == null) {
                f665c = new a();
            }
        }
        return f665c;
    }

    @Override // c.b.a.a.c
    public boolean a() {
        return this.a.a();
    }
}
