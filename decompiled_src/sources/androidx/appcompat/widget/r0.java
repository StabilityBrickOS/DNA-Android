package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* loaded from: classes.dex */
public class r0 {
    private static final ThreadLocal<TypedValue> a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    static final int[] f257b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    static final int[] f258c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    static final int[] f259d = {R.attr.state_pressed};

    /* renamed from: e, reason: collision with root package name */
    static final int[] f260e = {R.attr.state_checked};
    static final int[] f = new int[0];
    private static final int[] g = new int[1];

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c.a.j.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(c.a.j.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i) {
        ColorStateList e2 = e(context, i);
        if (e2 != null && e2.isStateful()) {
            return e2.getColorForState(f257b, e2.getDefaultColor());
        }
        TypedValue f2 = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, f2, true);
        return d(context, i, f2.getFloat());
    }

    public static int c(Context context, int i) {
        int[] iArr = g;
        iArr[0] = i;
        w0 u = w0.u(context, null, iArr);
        try {
            return u.b(0, 0);
        } finally {
            u.w();
        }
    }

    static int d(Context context, int i, float f2) {
        return c.f.e.a.d(c(context, i), Math.round(Color.alpha(r0) * f2));
    }

    public static ColorStateList e(Context context, int i) {
        int[] iArr = g;
        iArr[0] = i;
        w0 u = w0.u(context, null, iArr);
        try {
            return u.c(0);
        } finally {
            u.w();
        }
    }

    private static TypedValue f() {
        TypedValue typedValue = a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        a.set(typedValue2);
        return typedValue2;
    }
}
