package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
final class g {
    private static boolean k;
    private static Constructor<StaticLayout> l;
    private static Object m;
    private CharSequence a;

    /* renamed from: b, reason: collision with root package name */
    private final TextPaint f1154b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1155c;

    /* renamed from: e, reason: collision with root package name */
    private int f1157e;
    private boolean i;

    /* renamed from: d, reason: collision with root package name */
    private int f1156d = 0;
    private Layout.Alignment f = Layout.Alignment.ALIGN_NORMAL;
    private int g = Integer.MAX_VALUE;
    private boolean h = true;
    private TextUtils.TruncateAt j = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends Exception {
        a(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    private g(CharSequence charSequence, TextPaint textPaint, int i) {
        this.a = charSequence;
        this.f1154b = textPaint;
        this.f1155c = i;
        this.f1157e = charSequence.length();
    }

    private void b() {
        Class<?> cls;
        if (k) {
            return;
        }
        try {
            boolean z = this.i && Build.VERSION.SDK_INT >= 23;
            if (Build.VERSION.SDK_INT >= 18) {
                cls = TextDirectionHeuristic.class;
                m = z ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            } else {
                ClassLoader classLoader = g.class.getClassLoader();
                String str = this.i ? "RTL" : "LTR";
                Class<?> loadClass = classLoader.loadClass("android.text.TextDirectionHeuristic");
                Class<?> loadClass2 = classLoader.loadClass("android.text.TextDirectionHeuristics");
                m = loadClass2.getField(str).get(loadClass2);
                cls = loadClass;
            }
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, cls, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE);
            l = declaredConstructor;
            declaredConstructor.setAccessible(true);
            k = true;
        } catch (Exception e2) {
            throw new a(e2);
        }
    }

    public static g c(CharSequence charSequence, TextPaint textPaint, int i) {
        return new g(charSequence, textPaint, i);
    }

    public StaticLayout a() {
        if (this.a == null) {
            this.a = "";
        }
        int max = Math.max(0, this.f1155c);
        CharSequence charSequence = this.a;
        if (this.g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f1154b, max, this.j);
        }
        this.f1157e = Math.min(charSequence.length(), this.f1157e);
        if (Build.VERSION.SDK_INT < 23) {
            b();
            try {
                Constructor<StaticLayout> constructor = l;
                c.f.k.h.c(constructor);
                Object obj = m;
                c.f.k.h.c(obj);
                return constructor.newInstance(charSequence, Integer.valueOf(this.f1156d), Integer.valueOf(this.f1157e), this.f1154b, Integer.valueOf(max), this.f, obj, Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.h), null, Integer.valueOf(max), Integer.valueOf(this.g));
            } catch (Exception e2) {
                throw new a(e2);
            }
        }
        if (this.i) {
            this.f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.f1156d, this.f1157e, this.f1154b, max);
        obtain.setAlignment(this.f);
        obtain.setIncludePad(this.h);
        obtain.setTextDirection(this.i ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.j;
        if (truncateAt != null) {
            obtain.setEllipsize(truncateAt);
        }
        obtain.setMaxLines(this.g);
        return obtain.build();
    }

    public g d(Layout.Alignment alignment) {
        this.f = alignment;
        return this;
    }

    public g e(TextUtils.TruncateAt truncateAt) {
        this.j = truncateAt;
        return this;
    }

    public g f(boolean z) {
        this.h = z;
        return this;
    }

    public g g(boolean z) {
        this.i = z;
        return this;
    }

    public g h(int i) {
        this.g = i;
        return this;
    }
}
