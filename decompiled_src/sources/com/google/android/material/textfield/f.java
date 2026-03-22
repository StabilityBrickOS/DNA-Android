package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.z;
import c.f.l.s;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final TextInputLayout f1209b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f1210c;

    /* renamed from: d, reason: collision with root package name */
    private int f1211d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f1212e;
    private int f;
    private Animator g;
    private final float h;
    private int i;
    private int j;
    private CharSequence k;
    private boolean l;
    private TextView m;
    private CharSequence n;
    private int o;
    private ColorStateList p;
    private CharSequence q;
    private boolean r;
    private TextView s;
    private int t;
    private ColorStateList u;
    private Typeface v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f1213b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f1214c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f1215d;

        a(int i, TextView textView, int i2, TextView textView2) {
            this.a = i;
            this.f1213b = textView;
            this.f1214c = i2;
            this.f1215d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.i = this.a;
            f.this.g = null;
            TextView textView = this.f1213b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f1214c == 1 && f.this.m != null) {
                    f.this.m.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f1215d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f1215d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f1215d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public f(TextInputLayout textInputLayout) {
        this.a = textInputLayout.getContext();
        this.f1209b = textInputLayout;
        this.h = r0.getResources().getDimensionPixelSize(d.a.a.a.d.design_textinput_caption_translate_y);
    }

    private void H(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void J(ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean K(TextView textView, CharSequence charSequence) {
        return s.O(this.f1209b) && this.f1209b.isEnabled() && !(this.j == this.i && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void N(int i, int i2, boolean z) {
        if (i == i2) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.g = animatorSet;
            ArrayList arrayList = new ArrayList();
            h(arrayList, this.r, this.s, 2, i, i2);
            h(arrayList, this.l, this.m, 1, i, i2);
            d.a.a.a.l.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i2, l(i), i, l(i2)));
            animatorSet.start();
        } else {
            z(i, i2);
        }
        this.f1209b.k0();
        this.f1209b.o0(z);
        this.f1209b.y0();
    }

    private boolean f() {
        return (this.f1210c == null || this.f1209b.getEditText() == null) ? false : true;
    }

    private void h(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            list.add(i(textView, i3 == i));
            if (i3 == i) {
                list.add(j(textView));
            }
        }
    }

    private ObjectAnimator i(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(d.a.a.a.l.a.a);
        return ofFloat;
    }

    private ObjectAnimator j(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.h, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(d.a.a.a.l.a.f1278d);
        return ofFloat;
    }

    private TextView l(int i) {
        if (i == 1) {
            return this.m;
        }
        if (i != 2) {
            return null;
        }
        return this.s;
    }

    private boolean u(int i) {
        return (i != 1 || this.m == null || TextUtils.isEmpty(this.k)) ? false : true;
    }

    private void z(int i, int i2) {
        TextView l;
        TextView l2;
        if (i == i2) {
            return;
        }
        if (i2 != 0 && (l2 = l(i2)) != null) {
            l2.setVisibility(0);
            l2.setAlpha(1.0f);
        }
        if (i != 0 && (l = l(i)) != null) {
            l.setVisibility(4);
            if (i == 1) {
                l.setText((CharSequence) null);
            }
        }
        this.i = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(CharSequence charSequence) {
        this.n = charSequence;
        TextView textView = this.m;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(boolean z) {
        if (this.l == z) {
            return;
        }
        g();
        if (z) {
            z zVar = new z(this.a);
            this.m = zVar;
            zVar.setId(d.a.a.a.f.textinput_error);
            if (Build.VERSION.SDK_INT >= 17) {
                this.m.setTextAlignment(5);
            }
            Typeface typeface = this.v;
            if (typeface != null) {
                this.m.setTypeface(typeface);
            }
            C(this.o);
            D(this.p);
            A(this.n);
            this.m.setVisibility(4);
            s.k0(this.m, 1);
            d(this.m, 0);
        } else {
            s();
            y(this.m, 0);
            this.m = null;
            this.f1209b.k0();
            this.f1209b.y0();
        }
        this.l = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(int i) {
        this.o = i;
        TextView textView = this.m;
        if (textView != null) {
            this.f1209b.Y(textView, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(ColorStateList colorStateList) {
        this.p = colorStateList;
        TextView textView = this.m;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(int i) {
        this.t = i;
        TextView textView = this.s;
        if (textView != null) {
            androidx.core.widget.i.n(textView, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(boolean z) {
        if (this.r == z) {
            return;
        }
        g();
        if (z) {
            z zVar = new z(this.a);
            this.s = zVar;
            zVar.setId(d.a.a.a.f.textinput_helper_text);
            if (Build.VERSION.SDK_INT >= 17) {
                this.s.setTextAlignment(5);
            }
            Typeface typeface = this.v;
            if (typeface != null) {
                this.s.setTypeface(typeface);
            }
            this.s.setVisibility(4);
            s.k0(this.s, 1);
            E(this.t);
            G(this.u);
            d(this.s, 1);
        } else {
            t();
            y(this.s, 1);
            this.s = null;
            this.f1209b.k0();
            this.f1209b.y0();
        }
        this.r = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(ColorStateList colorStateList) {
        this.u = colorStateList;
        TextView textView = this.s;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(Typeface typeface) {
        if (typeface != this.v) {
            this.v = typeface;
            H(this.m, typeface);
            H(this.s, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(CharSequence charSequence) {
        g();
        this.k = charSequence;
        this.m.setText(charSequence);
        if (this.i != 1) {
            this.j = 1;
        }
        N(this.i, this.j, K(this.m, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(CharSequence charSequence) {
        g();
        this.q = charSequence;
        this.s.setText(charSequence);
        if (this.i != 2) {
            this.j = 2;
        }
        N(this.i, this.j, K(this.s, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TextView textView, int i) {
        if (this.f1210c == null && this.f1212e == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            this.f1210c = linearLayout;
            linearLayout.setOrientation(0);
            this.f1209b.addView(this.f1210c, -1, -2);
            this.f1212e = new FrameLayout(this.a);
            this.f1210c.addView(this.f1212e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f1209b.getEditText() != null) {
                e();
            }
        }
        if (v(i)) {
            this.f1212e.setVisibility(0);
            this.f1212e.addView(textView);
            this.f++;
        } else {
            this.f1210c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f1210c.setVisibility(0);
        this.f1211d++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (f()) {
            s.v0(this.f1210c, s.D(this.f1209b.getEditText()), 0, s.C(this.f1209b.getEditText()), 0);
        }
    }

    void g() {
        Animator animator = this.g;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return u(this.j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence m() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence n() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList p() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence q() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        TextView textView = this.s;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.k = null;
        g();
        if (this.i == 1) {
            this.j = (!this.r || TextUtils.isEmpty(this.q)) ? 0 : 2;
        }
        N(this.i, this.j, K(this.m, null));
    }

    void t() {
        g();
        if (this.i == 2) {
            this.j = 0;
        }
        N(this.i, this.j, K(this.s, null));
    }

    boolean v(int i) {
        return i == 0 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(TextView textView, int i) {
        FrameLayout frameLayout;
        if (this.f1210c == null) {
            return;
        }
        if (!v(i) || (frameLayout = this.f1212e) == null) {
            this.f1210c.removeView(textView);
        } else {
            int i2 = this.f - 1;
            this.f = i2;
            J(frameLayout, i2);
            this.f1212e.removeView(textView);
        }
        int i3 = this.f1211d - 1;
        this.f1211d = i3;
        J(this.f1210c, i3);
    }
}
