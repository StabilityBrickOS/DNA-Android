package d.c.a.g;

import e.p.d.i;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class b {
    private static final a a;

    /* renamed from: b, reason: collision with root package name */
    private static final a f1378b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f1379c = new b();

    static {
        new HashMap();
        boolean z = false;
        int i = 1;
        e.p.d.e eVar = null;
        a = new a(z, i, eVar);
        f1378b = new a(z, i, eVar);
    }

    private b() {
    }

    public final boolean a() {
        return a.l();
    }

    public final String b(String str) {
        i.d(str, "cmd");
        return c().m(str);
    }

    public final a c() {
        return (a.o() || !f1378b.o()) ? a : f1378b;
    }

    public final void d() {
        a.p();
        f1378b.p();
    }
}
