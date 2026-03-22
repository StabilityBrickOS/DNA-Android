package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import c.f.d.c.f;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y {
    private final TextView a;

    /* renamed from: b, reason: collision with root package name */
    private u0 f291b;

    /* renamed from: c, reason: collision with root package name */
    private u0 f292c;

    /* renamed from: d, reason: collision with root package name */
    private u0 f293d;

    /* renamed from: e, reason: collision with root package name */
    private u0 f294e;
    private u0 f;
    private u0 g;
    private u0 h;
    private final a0 i;
    private int j = 0;
    private int k = -1;
    private Typeface l;
    private boolean m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends f.a {
        final /* synthetic */ int a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f295b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f296c;

        a(int i, int i2, WeakReference weakReference) {
            this.a = i;
            this.f295b = i2;
            this.f296c = weakReference;
        }

        @Override // c.f.d.c.f.a
        public void c(int i) {
        }

        @Override // c.f.d.c.f.a
        public void d(Typeface typeface) {
            int i;
            if (Build.VERSION.SDK_INT >= 28 && (i = this.a) != -1) {
                typeface = Typeface.create(typeface, i, (this.f295b & 2) != 0);
            }
            y.this.n(this.f296c, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(TextView textView) {
        this.a = textView;
        this.i = new a0(this.a);
    }

    private void A(int i, float f) {
        this.i.y(i, f);
    }

    private void B(Context context, w0 w0Var) {
        String o;
        Typeface create;
        Typeface typeface;
        this.j = w0Var.k(c.a.j.TextAppearance_android_textStyle, this.j);
        if (Build.VERSION.SDK_INT >= 28) {
            int k = w0Var.k(c.a.j.TextAppearance_android_textFontWeight, -1);
            this.k = k;
            if (k != -1) {
                this.j = (this.j & 2) | 0;
            }
        }
        if (!w0Var.s(c.a.j.TextAppearance_android_fontFamily) && !w0Var.s(c.a.j.TextAppearance_fontFamily)) {
            if (w0Var.s(c.a.j.TextAppearance_android_typeface)) {
                this.m = false;
                int k2 = w0Var.k(c.a.j.TextAppearance_android_typeface, 1);
                if (k2 == 1) {
                    typeface = Typeface.SANS_SERIF;
                } else if (k2 == 2) {
                    typeface = Typeface.SERIF;
                } else if (k2 != 3) {
                    return;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
                this.l = typeface;
                return;
            }
            return;
        }
        this.l = null;
        int i = w0Var.s(c.a.j.TextAppearance_fontFamily) ? c.a.j.TextAppearance_fontFamily : c.a.j.TextAppearance_android_fontFamily;
        int i2 = this.k;
        int i3 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface j = w0Var.j(i, this.j, new a(i2, i3, new WeakReference(this.a)));
                if (j != null) {
                    if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
                        j = Typeface.create(Typeface.create(j, 0), this.k, (this.j & 2) != 0);
                    }
                    this.l = j;
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (o = w0Var.o(i)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
            create = Typeface.create(o, this.j);
        } else {
            create = Typeface.create(Typeface.create(o, 0), this.k, (this.j & 2) != 0);
        }
        this.l = create;
    }

    private void a(Drawable drawable, u0 u0Var) {
        if (drawable == null || u0Var == null) {
            return;
        }
        j.i(drawable, u0Var, this.a.getDrawableState());
    }

    private static u0 d(Context context, j jVar, int i) {
        ColorStateList f = jVar.f(context, i);
        if (f == null) {
            return null;
        }
        u0 u0Var = new u0();
        u0Var.f269d = true;
        u0Var.a = f;
        return u0Var;
    }

    private void x(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            TextView textView = this.a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Drawable[] compoundDrawablesRelative2 = this.a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                TextView textView2 = this.a;
                Drawable drawable7 = compoundDrawablesRelative2[0];
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable8 = compoundDrawablesRelative2[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
        }
        Drawable[] compoundDrawables = this.a.getCompoundDrawables();
        TextView textView3 = this.a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void y() {
        u0 u0Var = this.h;
        this.f291b = u0Var;
        this.f292c = u0Var;
        this.f293d = u0Var;
        this.f294e = u0Var;
        this.f = u0Var;
        this.g = u0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f291b != null || this.f292c != null || this.f293d != null || this.f294e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.f291b);
            a(compoundDrawables[1], this.f292c);
            a(compoundDrawables[2], this.f293d);
            a(compoundDrawables[3], this.f294e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f == null && this.g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.i.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.i.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.i.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.i.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] h() {
        return this.i.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.i.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        u0 u0Var = this.h;
        if (u0Var != null) {
            return u0Var.a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        u0 u0Var = this.h;
        if (u0Var != null) {
            return u0Var.f267b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.i.s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public void m(AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        String str;
        boolean z;
        boolean z2;
        ColorStateList colorStateList2;
        String str2;
        ColorStateList colorStateList3;
        boolean z3;
        int i2;
        Context context = this.a.getContext();
        j b2 = j.b();
        w0 v = w0.v(context, attributeSet, c.a.j.AppCompatTextHelper, i, 0);
        TextView textView = this.a;
        c.f.l.s.g0(textView, textView.getContext(), c.a.j.AppCompatTextHelper, attributeSet, v.r(), i, 0);
        int n = v.n(c.a.j.AppCompatTextHelper_android_textAppearance, -1);
        if (v.s(c.a.j.AppCompatTextHelper_android_drawableLeft)) {
            this.f291b = d(context, b2, v.n(c.a.j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (v.s(c.a.j.AppCompatTextHelper_android_drawableTop)) {
            this.f292c = d(context, b2, v.n(c.a.j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (v.s(c.a.j.AppCompatTextHelper_android_drawableRight)) {
            this.f293d = d(context, b2, v.n(c.a.j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (v.s(c.a.j.AppCompatTextHelper_android_drawableBottom)) {
            this.f294e = d(context, b2, v.n(c.a.j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (v.s(c.a.j.AppCompatTextHelper_android_drawableStart)) {
                this.f = d(context, b2, v.n(c.a.j.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (v.s(c.a.j.AppCompatTextHelper_android_drawableEnd)) {
                this.g = d(context, b2, v.n(c.a.j.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        v.w();
        boolean z4 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (n != -1) {
            w0 t = w0.t(context, n, c.a.j.TextAppearance);
            if (z4 || !t.s(c.a.j.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z = t.a(c.a.j.TextAppearance_textAllCaps, false);
                z2 = true;
            }
            B(context, t);
            if (Build.VERSION.SDK_INT < 23) {
                colorStateList3 = t.s(c.a.j.TextAppearance_android_textColor) ? t.c(c.a.j.TextAppearance_android_textColor) : null;
                colorStateList = t.s(c.a.j.TextAppearance_android_textColorHint) ? t.c(c.a.j.TextAppearance_android_textColorHint) : null;
                colorStateList2 = t.s(c.a.j.TextAppearance_android_textColorLink) ? t.c(c.a.j.TextAppearance_android_textColorLink) : null;
            } else {
                colorStateList = null;
                colorStateList2 = null;
                colorStateList3 = null;
            }
            str2 = t.s(c.a.j.TextAppearance_textLocale) ? t.o(c.a.j.TextAppearance_textLocale) : null;
            str = (Build.VERSION.SDK_INT < 26 || !t.s(c.a.j.TextAppearance_fontVariationSettings)) ? null : t.o(c.a.j.TextAppearance_fontVariationSettings);
            t.w();
        } else {
            colorStateList = null;
            str = null;
            z = false;
            z2 = false;
            colorStateList2 = null;
            str2 = null;
            colorStateList3 = null;
        }
        w0 v2 = w0.v(context, attributeSet, c.a.j.TextAppearance, i, 0);
        if (z4 || !v2.s(c.a.j.TextAppearance_textAllCaps)) {
            z3 = z2;
        } else {
            z = v2.a(c.a.j.TextAppearance_textAllCaps, false);
            z3 = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (v2.s(c.a.j.TextAppearance_android_textColor)) {
                colorStateList3 = v2.c(c.a.j.TextAppearance_android_textColor);
            }
            if (v2.s(c.a.j.TextAppearance_android_textColorHint)) {
                colorStateList = v2.c(c.a.j.TextAppearance_android_textColorHint);
            }
            if (v2.s(c.a.j.TextAppearance_android_textColorLink)) {
                colorStateList2 = v2.c(c.a.j.TextAppearance_android_textColorLink);
            }
        }
        if (v2.s(c.a.j.TextAppearance_textLocale)) {
            str2 = v2.o(c.a.j.TextAppearance_textLocale);
        }
        if (Build.VERSION.SDK_INT >= 26 && v2.s(c.a.j.TextAppearance_fontVariationSettings)) {
            str = v2.o(c.a.j.TextAppearance_fontVariationSettings);
        }
        if (Build.VERSION.SDK_INT >= 28 && v2.s(c.a.j.TextAppearance_android_textSize) && v2.f(c.a.j.TextAppearance_android_textSize, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        B(context, v2);
        v2.w();
        if (colorStateList3 != null) {
            this.a.setTextColor(colorStateList3);
        }
        if (colorStateList != null) {
            this.a.setHintTextColor(colorStateList);
        }
        if (colorStateList2 != null) {
            this.a.setLinkTextColor(colorStateList2);
        }
        if (!z4 && z3) {
            r(z);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            if (this.k == -1) {
                this.a.setTypeface(typeface, this.j);
            } else {
                this.a.setTypeface(typeface);
            }
        }
        if (str != null) {
            this.a.setFontVariationSettings(str);
        }
        if (str2 != null) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 24) {
                this.a.setTextLocales(LocaleList.forLanguageTags(str2));
            } else if (i3 >= 21) {
                this.a.setTextLocale(Locale.forLanguageTag(str2.substring(0, str2.indexOf(44))));
            }
        }
        this.i.t(attributeSet, i);
        if (androidx.core.widget.b.a && this.i.n() != 0) {
            int[] m = this.i.m();
            if (m.length > 0) {
                if (this.a.getAutoSizeStepGranularity() != -1.0f) {
                    this.a.setAutoSizeTextTypeUniformWithConfiguration(this.i.k(), this.i.j(), this.i.l(), 0);
                } else {
                    this.a.setAutoSizeTextTypeUniformWithPresetSizes(m, 0);
                }
            }
        }
        w0 u = w0.u(context, attributeSet, c.a.j.AppCompatTextView);
        int n2 = u.n(c.a.j.AppCompatTextView_drawableLeftCompat, -1);
        Drawable c2 = n2 != -1 ? b2.c(context, n2) : null;
        int n3 = u.n(c.a.j.AppCompatTextView_drawableTopCompat, -1);
        Drawable c3 = n3 != -1 ? b2.c(context, n3) : null;
        int n4 = u.n(c.a.j.AppCompatTextView_drawableRightCompat, -1);
        Drawable c4 = n4 != -1 ? b2.c(context, n4) : null;
        int n5 = u.n(c.a.j.AppCompatTextView_drawableBottomCompat, -1);
        Drawable c5 = n5 != -1 ? b2.c(context, n5) : null;
        int n6 = u.n(c.a.j.AppCompatTextView_drawableStartCompat, -1);
        Drawable c6 = n6 != -1 ? b2.c(context, n6) : null;
        int n7 = u.n(c.a.j.AppCompatTextView_drawableEndCompat, -1);
        x(c2, c3, c4, c5, c6, n7 != -1 ? b2.c(context, n7) : null);
        if (u.s(c.a.j.AppCompatTextView_drawableTint)) {
            androidx.core.widget.i.g(this.a, u.c(c.a.j.AppCompatTextView_drawableTint));
        }
        if (u.s(c.a.j.AppCompatTextView_drawableTintMode)) {
            i2 = -1;
            androidx.core.widget.i.h(this.a, e0.d(u.k(c.a.j.AppCompatTextView_drawableTintMode, -1), null));
        } else {
            i2 = -1;
        }
        int f = u.f(c.a.j.AppCompatTextView_firstBaselineToTopHeight, i2);
        int f2 = u.f(c.a.j.AppCompatTextView_lastBaselineToBottomHeight, i2);
        int f3 = u.f(c.a.j.AppCompatTextView_lineHeight, i2);
        u.w();
        if (f != i2) {
            androidx.core.widget.i.j(this.a, f);
        }
        if (f2 != i2) {
            androidx.core.widget.i.k(this.a, f2);
        }
        if (f3 != i2) {
            androidx.core.widget.i.l(this.a, f3);
        }
    }

    void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.m) {
            this.l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(boolean z, int i, int i2, int i3, int i4) {
        if (androidx.core.widget.b.a) {
            return;
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Context context, int i) {
        String o;
        ColorStateList c2;
        w0 t = w0.t(context, i, c.a.j.TextAppearance);
        if (t.s(c.a.j.TextAppearance_textAllCaps)) {
            r(t.a(c.a.j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && t.s(c.a.j.TextAppearance_android_textColor) && (c2 = t.c(c.a.j.TextAppearance_android_textColor)) != null) {
            this.a.setTextColor(c2);
        }
        if (t.s(c.a.j.TextAppearance_android_textSize) && t.f(c.a.j.TextAppearance_android_textSize, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        B(context, t);
        if (Build.VERSION.SDK_INT >= 26 && t.s(c.a.j.TextAppearance_fontVariationSettings) && (o = t.o(c.a.j.TextAppearance_fontVariationSettings)) != null) {
            this.a.setFontVariationSettings(o);
        }
        t.w();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(boolean z) {
        this.a.setAllCaps(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i, int i2, int i3, int i4) {
        this.i.u(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int[] iArr, int i) {
        this.i.v(iArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i) {
        this.i.w(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new u0();
        }
        u0 u0Var = this.h;
        u0Var.a = colorStateList;
        u0Var.f269d = colorStateList != null;
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new u0();
        }
        u0 u0Var = this.h;
        u0Var.f267b = mode;
        u0Var.f268c = mode != null;
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(int i, float f) {
        if (androidx.core.widget.b.a || l()) {
            return;
        }
        A(i, f);
    }
}
