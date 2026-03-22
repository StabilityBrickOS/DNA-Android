package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import c.f.k.h;
import d.a.a.a.z.g;
import d.a.a.a.z.k;
import java.util.ArrayList;

/* loaded from: classes.dex */
class c extends b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends g {
        a(k kVar) {
            super(kVar);
        }

        @Override // d.a.a.a.z.g, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FloatingActionButton floatingActionButton, d.a.a.a.y.b bVar) {
        super(floatingActionButton, bVar);
    }

    private Animator j0(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.y, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.y, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(b.F);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void A() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void C() {
        f0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void E(int[] iArr) {
        FloatingActionButton floatingActionButton;
        if (Build.VERSION.SDK_INT == 21) {
            float f = 0.0f;
            if (this.y.isEnabled()) {
                this.y.setElevation(this.h);
                if (this.y.isPressed()) {
                    floatingActionButton = this.y;
                    f = this.j;
                } else if (this.y.isFocused() || this.y.isHovered()) {
                    floatingActionButton = this.y;
                    f = this.i;
                }
                floatingActionButton.setTranslationZ(f);
            }
            this.y.setElevation(0.0f);
            floatingActionButton = this.y;
            floatingActionButton.setTranslationZ(f);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void F(float f, float f2, float f3) {
        if (Build.VERSION.SDK_INT == 21) {
            this.y.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(b.G, j0(f, f3));
            stateListAnimator.addState(b.H, j0(f, f2));
            stateListAnimator.addState(b.I, j0(f, f2));
            stateListAnimator.addState(b.J, j0(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.y, "elevation", f).setDuration(0L));
            int i = Build.VERSION.SDK_INT;
            if (i >= 22 && i <= 24) {
                FloatingActionButton floatingActionButton = this.y;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.y, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(b.F);
            stateListAnimator.addState(b.K, animatorSet);
            stateListAnimator.addState(b.L, j0(0.0f, 0.0f));
            this.y.setStateListAnimator(stateListAnimator);
        }
        if (Z()) {
            f0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.b
    boolean K() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void V(ColorStateList colorStateList) {
        Drawable drawable = this.f1125c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(d.a.a.a.x.b.a(colorStateList));
        } else {
            super.V(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.b
    boolean Z() {
        return this.z.c() || !b0();
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void d0() {
    }

    com.google.android.material.floatingactionbutton.a i0(int i, ColorStateList colorStateList) {
        Context context = this.y.getContext();
        k kVar = this.a;
        h.c(kVar);
        com.google.android.material.floatingactionbutton.a aVar = new com.google.android.material.floatingactionbutton.a(kVar);
        aVar.e(c.f.d.a.a(context, d.a.a.a.c.design_fab_stroke_top_outer_color), c.f.d.a.a(context, d.a.a.a.c.design_fab_stroke_top_inner_color), c.f.d.a.a(context, d.a.a.a.c.design_fab_stroke_end_inner_color), c.f.d.a.a(context, d.a.a.a.c.design_fab_stroke_end_outer_color));
        aVar.d(i);
        aVar.c(colorStateList);
        return aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    g j() {
        k kVar = this.a;
        h.c(kVar);
        return new a(kVar);
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public float n() {
        return this.y.getElevation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void s(Rect rect) {
        if (this.z.c()) {
            super.s(rect);
        } else {
            int sizeDimension = !b0() ? (this.k - this.y.getSizeDimension()) / 2 : 0;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void x(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable drawable;
        g j = j();
        this.f1124b = j;
        j.setTintList(colorStateList);
        if (mode != null) {
            this.f1124b.setTintMode(mode);
        }
        this.f1124b.M(this.y.getContext());
        if (i > 0) {
            this.f1126d = i0(i, colorStateList);
            com.google.android.material.floatingactionbutton.a aVar = this.f1126d;
            h.c(aVar);
            g gVar = this.f1124b;
            h.c(gVar);
            drawable = new LayerDrawable(new Drawable[]{aVar, gVar});
        } else {
            this.f1126d = null;
            drawable = this.f1124b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(d.a.a.a.x.b.a(colorStateList2), drawable, null);
        this.f1125c = rippleDrawable;
        this.f1127e = rippleDrawable;
    }
}
