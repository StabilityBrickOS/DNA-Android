package kotlinx.coroutines.internal;

import e.f;

/* loaded from: classes.dex */
public final class f {
    private static final boolean a;

    static {
        Object m266constructorimpl;
        try {
            f.a aVar = e.f.Companion;
            m266constructorimpl = e.f.m266constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            f.a aVar2 = e.f.Companion;
            m266constructorimpl = e.f.m266constructorimpl(e.g.a(th));
        }
        a = e.f.m273isSuccessimpl(m266constructorimpl);
    }

    public static final boolean a() {
        return a;
    }
}
