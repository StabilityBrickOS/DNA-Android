package c.f.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import c.f.d.c.c;
import c.f.i.b;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
class f extends j {

    /* renamed from: b, reason: collision with root package name */
    private static final Class<?> f725b;

    /* renamed from: c, reason: collision with root package name */
    private static final Constructor<?> f726c;

    /* renamed from: d, reason: collision with root package name */
    private static final Method f727d;

    /* renamed from: e, reason: collision with root package name */
    private static final Method f728e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
        }
        f726c = constructor;
        f725b = cls;
        f727d = method2;
        f728e = method;
    }

    private static boolean k(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f727d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface l(Object obj) {
        try {
            Object newInstance = Array.newInstance(f725b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f728e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean m() {
        if (f727d == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f727d != null;
    }

    private static Object n() {
        try {
            return f726c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // c.f.e.j
    public Typeface b(Context context, c.b bVar, Resources resources, int i) {
        Object n = n();
        if (n == null) {
            return null;
        }
        for (c.C0027c c0027c : bVar.a()) {
            ByteBuffer b2 = k.b(context, resources, c0027c.b());
            if (b2 == null || !k(n, b2, c0027c.c(), c0027c.e(), c0027c.f())) {
                return null;
            }
        }
        return l(n);
    }

    @Override // c.f.e.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i) {
        Object n = n();
        if (n == null) {
            return null;
        }
        c.d.g gVar = new c.d.g();
        for (b.f fVar : fVarArr) {
            Uri c2 = fVar.c();
            ByteBuffer byteBuffer = (ByteBuffer) gVar.get(c2);
            if (byteBuffer == null) {
                byteBuffer = k.f(context, cancellationSignal, c2);
                gVar.put(c2, byteBuffer);
            }
            if (byteBuffer == null || !k(n, byteBuffer, fVar.b(), fVar.d(), fVar.e())) {
                return null;
            }
        }
        Typeface l = l(n);
        if (l == null) {
            return null;
        }
        return Typeface.create(l, i);
    }
}
