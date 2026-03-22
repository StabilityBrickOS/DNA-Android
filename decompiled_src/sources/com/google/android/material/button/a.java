package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import c.f.l.s;
import com.google.android.material.internal.j;
import d.a.a.a.b;
import d.a.a.a.w.c;
import d.a.a.a.z.g;
import d.a.a.a.z.k;
import d.a.a.a.z.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {
    private static final boolean s;
    private final MaterialButton a;

    /* renamed from: b, reason: collision with root package name */
    private k f1075b;

    /* renamed from: c, reason: collision with root package name */
    private int f1076c;

    /* renamed from: d, reason: collision with root package name */
    private int f1077d;

    /* renamed from: e, reason: collision with root package name */
    private int f1078e;
    private int f;
    private int g;
    private int h;
    private PorterDuff.Mode i;
    private ColorStateList j;
    private ColorStateList k;
    private ColorStateList l;
    private Drawable m;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q;
    private LayerDrawable r;

    static {
        s = Build.VERSION.SDK_INT >= 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MaterialButton materialButton, k kVar) {
        this.a = materialButton;
        this.f1075b = kVar;
    }

    private void A(k kVar) {
        if (d() != null) {
            d().setShapeAppearanceModel(kVar);
        }
        if (l() != null) {
            l().setShapeAppearanceModel(kVar);
        }
        if (c() != null) {
            c().setShapeAppearanceModel(kVar);
        }
    }

    private void C() {
        g d2 = d();
        g l = l();
        if (d2 != null) {
            d2.c0(this.h, this.k);
            if (l != null) {
                l.b0(this.h, this.n ? d.a.a.a.q.a.c(this.a, b.colorSurface) : 0);
            }
        }
    }

    private InsetDrawable D(Drawable drawable) {
        return new InsetDrawable(drawable, this.f1076c, this.f1078e, this.f1077d, this.f);
    }

    private Drawable a() {
        g gVar = new g(this.f1075b);
        gVar.M(this.a.getContext());
        androidx.core.graphics.drawable.a.o(gVar, this.j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            androidx.core.graphics.drawable.a.p(gVar, mode);
        }
        gVar.c0(this.h, this.k);
        g gVar2 = new g(this.f1075b);
        gVar2.setTint(0);
        gVar2.b0(this.h, this.n ? d.a.a.a.q.a.c(this.a, b.colorSurface) : 0);
        if (s) {
            g gVar3 = new g(this.f1075b);
            this.m = gVar3;
            androidx.core.graphics.drawable.a.n(gVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(d.a.a.a.x.b.a(this.l), D(new LayerDrawable(new Drawable[]{gVar2, gVar})), this.m);
            this.r = rippleDrawable;
            return rippleDrawable;
        }
        d.a.a.a.x.a aVar = new d.a.a.a.x.a(this.f1075b);
        this.m = aVar;
        androidx.core.graphics.drawable.a.o(aVar, d.a.a.a.x.b.a(this.l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar, this.m});
        this.r = layerDrawable;
        return D(layerDrawable);
    }

    private g e(boolean z) {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (g) (s ? (LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable() : this.r).getDrawable(!z ? 1 : 0);
    }

    private g l() {
        return e(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(int i, int i2) {
        Drawable drawable = this.m;
        if (drawable != null) {
            drawable.setBounds(this.f1076c, this.f1078e, i2 - this.f1077d, i - this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.g;
    }

    public n c() {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return (n) (this.r.getNumberOfLayers() > 2 ? this.r.getDrawable(2) : this.r.getDrawable(1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g d() {
        return e(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k g() {
        return this.f1075b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList h() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(TypedArray typedArray) {
        this.f1076c = typedArray.getDimensionPixelOffset(d.a.a.a.k.MaterialButton_android_insetLeft, 0);
        this.f1077d = typedArray.getDimensionPixelOffset(d.a.a.a.k.MaterialButton_android_insetRight, 0);
        this.f1078e = typedArray.getDimensionPixelOffset(d.a.a.a.k.MaterialButton_android_insetTop, 0);
        this.f = typedArray.getDimensionPixelOffset(d.a.a.a.k.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(d.a.a.a.k.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(d.a.a.a.k.MaterialButton_cornerRadius, -1);
            this.g = dimensionPixelSize;
            u(this.f1075b.w(dimensionPixelSize));
            this.p = true;
        }
        this.h = typedArray.getDimensionPixelSize(d.a.a.a.k.MaterialButton_strokeWidth, 0);
        this.i = j.e(typedArray.getInt(d.a.a.a.k.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.j = c.a(this.a.getContext(), typedArray, d.a.a.a.k.MaterialButton_backgroundTint);
        this.k = c.a(this.a.getContext(), typedArray, d.a.a.a.k.MaterialButton_strokeColor);
        this.l = c.a(this.a.getContext(), typedArray, d.a.a.a.k.MaterialButton_rippleColor);
        this.q = typedArray.getBoolean(d.a.a.a.k.MaterialButton_android_checkable, false);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(d.a.a.a.k.MaterialButton_elevation, 0);
        int D = s.D(this.a);
        int paddingTop = this.a.getPaddingTop();
        int C = s.C(this.a);
        int paddingBottom = this.a.getPaddingBottom();
        if (typedArray.hasValue(d.a.a.a.k.MaterialButton_android_background)) {
            q();
        } else {
            this.a.setInternalBackground(a());
            g d2 = d();
            if (d2 != null) {
                d2.U(dimensionPixelSize2);
            }
        }
        s.v0(this.a, D + this.f1076c, paddingTop + this.f1078e, C + this.f1077d, paddingBottom + this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i) {
        if (d() != null) {
            d().setTint(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.o = true;
        this.a.setSupportBackgroundTintList(this.j);
        this.a.setSupportBackgroundTintMode(this.i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(boolean z) {
        this.q = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i) {
        if (this.p && this.g == i) {
            return;
        }
        this.g = i;
        this.p = true;
        u(this.f1075b.w(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            if (s && (this.a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.a.getBackground()).setColor(d.a.a.a.x.b.a(colorStateList));
            } else {
                if (s || !(this.a.getBackground() instanceof d.a.a.a.x.a)) {
                    return;
                }
                ((d.a.a.a.x.a) this.a.getBackground()).setTintList(d.a.a.a.x.b.a(colorStateList));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(k kVar) {
        this.f1075b = kVar;
        A(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(boolean z) {
        this.n = z;
        C();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            C();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(int i) {
        if (this.h != i) {
            this.h = i;
            C();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            if (d() != null) {
                androidx.core.graphics.drawable.a.o(d(), this.j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(PorterDuff.Mode mode) {
        if (this.i != mode) {
            this.i = mode;
            if (d() == null || this.i == null) {
                return;
            }
            androidx.core.graphics.drawable.a.p(d(), this.i);
        }
    }
}
