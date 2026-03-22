package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import e.f;
import e.g;

/* loaded from: classes.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    static {
        Object m266constructorimpl;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        try {
            f.a aVar = f.Companion;
            m266constructorimpl = f.m266constructorimpl(new a(a(Looper.getMainLooper(), true), objArr2 == true ? 1 : 0, 2, objArr == true ? 1 : 0));
        } catch (Throwable th) {
            f.a aVar2 = f.Companion;
            m266constructorimpl = f.m266constructorimpl(g.a(th));
        }
    }

    public static final Handler a(Looper looper, boolean z) {
        int i;
        if (!z || (i = Build.VERSION.SDK_INT) < 16) {
            return new Handler(looper);
        }
        if (i < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        if (invoke != null) {
            return (Handler) invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
    }
}
