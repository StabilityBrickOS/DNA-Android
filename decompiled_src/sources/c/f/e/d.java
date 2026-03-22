package c.f.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import c.f.d.c.c;
import c.f.d.c.f;
import c.f.i.b;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class d {
    private static final j a;

    /* renamed from: b, reason: collision with root package name */
    private static final c.d.e<String, Typeface> f720b;

    static {
        int i = Build.VERSION.SDK_INT;
        a = i >= 29 ? new i() : i >= 28 ? new h() : i >= 26 ? new g() : (i < 24 || !f.m()) ? Build.VERSION.SDK_INT >= 21 ? new e() : new j() : new f();
        f720b = new c.d.e<>(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i) {
        Typeface g;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (g = g(context, typeface, i)) == null) ? Typeface.create(typeface, i) : g;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i) {
        return a.c(context, cancellationSignal, fVarArr, i);
    }

    public static Typeface c(Context context, c.a aVar, Resources resources, int i, int i2, f.a aVar2, Handler handler, boolean z) {
        Typeface b2;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.a() == 0) {
                z2 = true;
            }
            b2 = c.f.i.b.g(context, dVar.b(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            b2 = a.b(context, (c.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (b2 != null) {
                    aVar2.b(b2, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (b2 != null) {
            f720b.d(e(resources, i, i2), b2);
        }
        return b2;
    }

    public static Typeface d(Context context, Resources resources, int i, String str, int i2) {
        Typeface e2 = a.e(context, resources, i, str, i2);
        if (e2 != null) {
            f720b.d(e(resources, i, i2), e2);
        }
        return e2;
    }

    private static String e(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface f(Resources resources, int i, int i2) {
        return f720b.c(e(resources, i, i2));
    }

    private static Typeface g(Context context, Typeface typeface, int i) {
        c.b i2 = a.i(typeface);
        if (i2 == null) {
            return null;
        }
        return a.b(context, i2, context.getResources(), i);
    }
}
