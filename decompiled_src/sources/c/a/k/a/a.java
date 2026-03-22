package c.a.k.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.m0;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public final class a {
    private static final ThreadLocal<TypedValue> a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<Context, SparseArray<C0022a>> f625b = new WeakHashMap<>(0);

    /* renamed from: c, reason: collision with root package name */
    private static final Object f626c = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c.a.k.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0022a {
        final ColorStateList a;

        /* renamed from: b, reason: collision with root package name */
        final Configuration f627b;

        C0022a(ColorStateList colorStateList, Configuration configuration) {
            this.a = colorStateList;
            this.f627b = configuration;
        }
    }

    private static void a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f626c) {
            SparseArray<C0022a> sparseArray = f625b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                f625b.put(context, sparseArray);
            }
            sparseArray.append(i, new C0022a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static ColorStateList b(Context context, int i) {
        C0022a c0022a;
        synchronized (f626c) {
            SparseArray<C0022a> sparseArray = f625b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (c0022a = sparseArray.get(i)) != null) {
                if (c0022a.f627b.equals(context.getResources().getConfiguration())) {
                    return c0022a.a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    public static ColorStateList c(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList b2 = b(context, i);
        if (b2 != null) {
            return b2;
        }
        ColorStateList f = f(context, i);
        if (f == null) {
            return c.f.d.a.b(context, i);
        }
        a(context, i, f);
        return f;
    }

    public static Drawable d(Context context, int i) {
        return m0.h().j(context, i);
    }

    private static TypedValue e() {
        TypedValue typedValue = a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        a.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList f(Context context, int i) {
        if (g(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return c.f.d.c.a.a(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e2) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    private static boolean g(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue e2 = e();
        resources.getValue(i, e2, true);
        int i2 = e2.type;
        return i2 >= 28 && i2 <= 31;
    }
}
