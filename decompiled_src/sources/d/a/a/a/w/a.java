package d.a.a.a.w;

import android.graphics.Typeface;

/* loaded from: classes.dex */
public final class a extends f {
    private final Typeface a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0089a f1299b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1300c;

    /* renamed from: d.a.a.a.w.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0089a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0089a interfaceC0089a, Typeface typeface) {
        this.a = typeface;
        this.f1299b = interfaceC0089a;
    }

    private void d(Typeface typeface) {
        if (this.f1300c) {
            return;
        }
        this.f1299b.a(typeface);
    }

    @Override // d.a.a.a.w.f
    public void a(int i) {
        d(this.a);
    }

    @Override // d.a.a.a.w.f
    public void b(Typeface typeface, boolean z) {
        d(typeface);
    }

    public void c() {
        this.f1300c = true;
    }
}
