package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import c.f.l.s;
import d.a.a.a.z.n;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    static final TimeInterpolator F = d.a.a.a.l.a.f1277c;
    static final int[] G = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] H = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    static final int[] I = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] J = {R.attr.state_hovered, R.attr.state_enabled};
    static final int[] K = {R.attr.state_enabled};
    static final int[] L = new int[0];
    private ViewTreeObserver.OnPreDrawListener E;
    d.a.a.a.z.k a;

    /* renamed from: b, reason: collision with root package name */
    d.a.a.a.z.g f1124b;

    /* renamed from: c, reason: collision with root package name */
    Drawable f1125c;

    /* renamed from: d, reason: collision with root package name */
    com.google.android.material.floatingactionbutton.a f1126d;

    /* renamed from: e, reason: collision with root package name */
    Drawable f1127e;
    boolean f;
    float h;
    float i;
    float j;
    int k;
    private final com.google.android.material.internal.f l;
    private d.a.a.a.l.h m;
    private d.a.a.a.l.h n;
    private Animator o;
    private d.a.a.a.l.h p;
    private d.a.a.a.l.h q;
    private float r;
    private int t;
    private ArrayList<Animator.AnimatorListener> v;
    private ArrayList<Animator.AnimatorListener> w;
    private ArrayList<i> x;
    final FloatingActionButton y;
    final d.a.a.a.y.b z;
    boolean g = true;
    private float s = 1.0f;
    private int u = 0;
    private final Rect A = new Rect();
    private final RectF B = new RectF();
    private final RectF C = new RectF();
    private final Matrix D = new Matrix();

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        private boolean a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f1128b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f1129c;

        a(boolean z, j jVar) {
            this.f1128b = z;
            this.f1129c = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.u = 0;
            b.this.o = null;
            if (this.a) {
                return;
            }
            b.this.y.b(this.f1128b ? 8 : 4, this.f1128b);
            j jVar = this.f1129c;
            if (jVar != null) {
                jVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.y.b(0, this.f1128b);
            b.this.u = 1;
            b.this.o = animator;
            this.a = false;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0073b extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f1131b;

        C0073b(boolean z, j jVar) {
            this.a = z;
            this.f1131b = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.u = 0;
            b.this.o = null;
            j jVar = this.f1131b;
            if (jVar != null) {
                jVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.y.b(0, this.a);
            b.this.u = 2;
            b.this.o = animator;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends d.a.a.a.l.g {
        c() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            b.this.s = f;
            return super.evaluate(f, matrix, matrix2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements TypeEvaluator<Float> {
        FloatEvaluator a = new FloatEvaluator();

        d(b bVar) {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f, Float f2, Float f3) {
            float floatValue = this.a.evaluate(f, (Number) f2, (Number) f3).floatValue();
            if (floatValue < 0.1f) {
                floatValue = 0.0f;
            }
            return Float.valueOf(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            b.this.H();
            return true;
        }
    }

    /* loaded from: classes.dex */
    private class f extends l {
        f(b bVar) {
            super(bVar, null);
        }

        @Override // com.google.android.material.floatingactionbutton.b.l
        protected float a() {
            return 0.0f;
        }
    }

    /* loaded from: classes.dex */
    private class g extends l {
        g() {
            super(b.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.b.l
        protected float a() {
            b bVar = b.this;
            return bVar.h + bVar.i;
        }
    }

    /* loaded from: classes.dex */
    private class h extends l {
        h() {
            super(b.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.b.l
        protected float a() {
            b bVar = b.this;
            return bVar.h + bVar.j;
        }
    }

    /* loaded from: classes.dex */
    interface i {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    interface j {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    private class k extends l {
        k() {
            super(b.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.b.l
        protected float a() {
            return b.this.h;
        }
    }

    /* loaded from: classes.dex */
    private abstract class l extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private boolean a;

        /* renamed from: b, reason: collision with root package name */
        private float f1138b;

        /* renamed from: c, reason: collision with root package name */
        private float f1139c;

        private l() {
        }

        /* synthetic */ l(b bVar, a aVar) {
            this();
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.g0((int) this.f1139c);
            this.a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.a) {
                d.a.a.a.z.g gVar = b.this.f1124b;
                this.f1138b = gVar == null ? 0.0f : gVar.w();
                this.f1139c = a();
                this.a = true;
            }
            b bVar = b.this;
            float f = this.f1138b;
            bVar.g0((int) (f + ((this.f1139c - f) * valueAnimator.getAnimatedFraction())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FloatingActionButton floatingActionButton, d.a.a.a.y.b bVar) {
        this.y = floatingActionButton;
        this.z = bVar;
        com.google.android.material.internal.f fVar = new com.google.android.material.internal.f();
        this.l = fVar;
        fVar.a(G, i(new h()));
        this.l.a(H, i(new g()));
        this.l.a(I, i(new g()));
        this.l.a(J, i(new g()));
        this.l.a(K, i(new k()));
        this.l.a(L, i(new f(this)));
        this.r = this.y.getRotation();
    }

    private boolean a0() {
        return s.O(this.y) && !this.y.isInEditMode();
    }

    private void g(float f2, Matrix matrix) {
        matrix.reset();
        if (this.y.getDrawable() == null || this.t == 0) {
            return;
        }
        RectF rectF = this.B;
        RectF rectF2 = this.C;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i2 = this.t;
        rectF2.set(0.0f, 0.0f, i2, i2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i3 = this.t;
        matrix.postScale(f2, f2, i3 / 2.0f, i3 / 2.0f);
    }

    private AnimatorSet h(d.a.a.a.l.h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.y, (Property<FloatingActionButton, Float>) View.ALPHA, f2);
        hVar.e("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.y, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        hVar.e("scale").a(ofFloat2);
        h0(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.y, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        hVar.e("scale").a(ofFloat3);
        h0(ofFloat3);
        arrayList.add(ofFloat3);
        g(f4, this.D);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.y, new d.a.a.a.l.f(), new c(), new Matrix(this.D));
        hVar.e("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        d.a.a.a.l.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private void h0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new d(this));
    }

    private ValueAnimator i(l lVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(F);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(lVar);
        valueAnimator.addUpdateListener(lVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private d.a.a.a.l.h l() {
        if (this.n == null) {
            this.n = d.a.a.a.l.h.c(this.y.getContext(), d.a.a.a.a.design_fab_hide_motion_spec);
        }
        d.a.a.a.l.h hVar = this.n;
        c.f.k.h.c(hVar);
        return hVar;
    }

    private d.a.a.a.l.h m() {
        if (this.m == null) {
            this.m = d.a.a.a.l.h.c(this.y.getContext(), d.a.a.a.a.design_fab_show_motion_spec);
        }
        d.a.a.a.l.h hVar = this.m;
        c.f.k.h.c(hVar);
        return hVar;
    }

    private ViewTreeObserver.OnPreDrawListener r() {
        if (this.E == null) {
            this.E = new e();
        }
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        this.l.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        d.a.a.a.z.g gVar = this.f1124b;
        if (gVar != null) {
            d.a.a.a.z.h.f(this.y, gVar);
        }
        if (K()) {
            this.y.getViewTreeObserver().addOnPreDrawListener(r());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D() {
        ViewTreeObserver viewTreeObserver = this.y.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.E;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.E = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(int[] iArr) {
        this.l.d(iArr);
    }

    void F(float f2, float f3, float f4) {
        f0();
        g0(f2);
    }

    void G(Rect rect) {
        d.a.a.a.y.b bVar;
        Drawable drawable;
        c.f.k.h.d(this.f1127e, "Didn't initialize content background");
        if (Z()) {
            drawable = new InsetDrawable(this.f1127e, rect.left, rect.top, rect.right, rect.bottom);
            bVar = this.z;
        } else {
            bVar = this.z;
            drawable = this.f1127e;
        }
        bVar.b(drawable);
    }

    void H() {
        float rotation = this.y.getRotation();
        if (this.r != rotation) {
            this.r = rotation;
            d0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I() {
        ArrayList<i> arrayList = this.x;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J() {
        ArrayList<i> arrayList = this.x;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    boolean K() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(ColorStateList colorStateList) {
        d.a.a.a.z.g gVar = this.f1124b;
        if (gVar != null) {
            gVar.setTintList(colorStateList);
        }
        com.google.android.material.floatingactionbutton.a aVar = this.f1126d;
        if (aVar != null) {
            aVar.c(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(PorterDuff.Mode mode) {
        d.a.a.a.z.g gVar = this.f1124b;
        if (gVar != null) {
            gVar.setTintMode(mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void N(float f2) {
        if (this.h != f2) {
            this.h = f2;
            F(f2, this.i, this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(boolean z) {
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void P(d.a.a.a.l.h hVar) {
        this.q = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Q(float f2) {
        if (this.i != f2) {
            this.i = f2;
            F(this.h, f2, this.j);
        }
    }

    final void R(float f2) {
        this.s = f2;
        Matrix matrix = this.D;
        g(f2, matrix);
        this.y.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S(int i2) {
        if (this.t != i2) {
            this.t = i2;
            e0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i2) {
        this.k = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void U(float f2) {
        if (this.j != f2) {
            this.j = f2;
            F(this.h, this.i, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(ColorStateList colorStateList) {
        Drawable drawable = this.f1125c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, d.a.a.a.x.b.a(colorStateList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(boolean z) {
        this.g = z;
        f0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void X(d.a.a.a.z.k kVar) {
        this.a = kVar;
        d.a.a.a.z.g gVar = this.f1124b;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(kVar);
        }
        Object obj = this.f1125c;
        if (obj instanceof n) {
            ((n) obj).setShapeAppearanceModel(kVar);
        }
        com.google.android.material.floatingactionbutton.a aVar = this.f1126d;
        if (aVar != null) {
            aVar.f(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Y(d.a.a.a.l.h hVar) {
        this.p = hVar;
    }

    boolean Z() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b0() {
        return !this.f || this.y.getSizeDimension() >= this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c0(j jVar, boolean z) {
        if (z()) {
            return;
        }
        Animator animator = this.o;
        if (animator != null) {
            animator.cancel();
        }
        if (!a0()) {
            this.y.b(0, z);
            this.y.setAlpha(1.0f);
            this.y.setScaleY(1.0f);
            this.y.setScaleX(1.0f);
            R(1.0f);
            if (jVar != null) {
                jVar.a();
                return;
            }
            return;
        }
        if (this.y.getVisibility() != 0) {
            this.y.setAlpha(0.0f);
            this.y.setScaleY(0.0f);
            this.y.setScaleX(0.0f);
            R(0.0f);
        }
        d.a.a.a.l.h hVar = this.p;
        if (hVar == null) {
            hVar = m();
        }
        AnimatorSet h2 = h(hVar, 1.0f, 1.0f, 1.0f);
        h2.addListener(new C0073b(z, jVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.v;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                h2.addListener(it.next());
            }
        }
        h2.start();
    }

    public void d(Animator.AnimatorListener animatorListener) {
        if (this.w == null) {
            this.w = new ArrayList<>();
        }
        this.w.add(animatorListener);
    }

    void d0() {
        FloatingActionButton floatingActionButton;
        int i2;
        if (Build.VERSION.SDK_INT == 19) {
            if (this.r % 90.0f != 0.0f) {
                i2 = 1;
                if (this.y.getLayerType() != 1) {
                    floatingActionButton = this.y;
                    floatingActionButton.setLayerType(i2, null);
                }
            } else if (this.y.getLayerType() != 0) {
                floatingActionButton = this.y;
                i2 = 0;
                floatingActionButton.setLayerType(i2, null);
            }
        }
        d.a.a.a.z.g gVar = this.f1124b;
        if (gVar != null) {
            gVar.a0((int) this.r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Animator.AnimatorListener animatorListener) {
        if (this.v == null) {
            this.v = new ArrayList<>();
        }
        this.v.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e0() {
        R(this.s);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(i iVar) {
        if (this.x == null) {
            this.x = new ArrayList<>();
        }
        this.x.add(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f0() {
        Rect rect = this.A;
        s(rect);
        G(rect);
        this.z.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g0(float f2) {
        d.a.a.a.z.g gVar = this.f1124b;
        if (gVar != null) {
            gVar.U(f2);
        }
    }

    d.a.a.a.z.g j() {
        d.a.a.a.z.k kVar = this.a;
        c.f.k.h.c(kVar);
        return new d.a.a.a.z.g(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable k() {
        return this.f1127e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float n() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d.a.a.a.l.h p() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float q() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Rect rect) {
        int sizeDimension = this.f ? (this.k - this.y.getSizeDimension()) / 2 : 0;
        int max = Math.max(sizeDimension, (int) Math.ceil(this.g ? n() + this.j : 0.0f));
        int max2 = Math.max(sizeDimension, (int) Math.ceil(r1 * 1.5f));
        rect.set(max, max2, max, max2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float t() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d.a.a.a.z.k u() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d.a.a.a.l.h v() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(j jVar, boolean z) {
        if (y()) {
            return;
        }
        Animator animator = this.o;
        if (animator != null) {
            animator.cancel();
        }
        if (!a0()) {
            this.y.b(z ? 8 : 4, z);
            if (jVar != null) {
                jVar.b();
                return;
            }
            return;
        }
        d.a.a.a.l.h hVar = this.q;
        if (hVar == null) {
            hVar = l();
        }
        AnimatorSet h2 = h(hVar, 0.0f, 0.0f, 0.0f);
        h2.addListener(new a(z, jVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.w;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                h2.addListener(it.next());
            }
        }
        h2.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        d.a.a.a.z.g j2 = j();
        this.f1124b = j2;
        j2.setTintList(colorStateList);
        if (mode != null) {
            this.f1124b.setTintMode(mode);
        }
        this.f1124b.Z(-12303292);
        this.f1124b.M(this.y.getContext());
        d.a.a.a.x.a aVar = new d.a.a.a.x.a(this.f1124b.C());
        aVar.setTintList(d.a.a.a.x.b.a(colorStateList2));
        this.f1125c = aVar;
        d.a.a.a.z.g gVar = this.f1124b;
        c.f.k.h.c(gVar);
        this.f1127e = new LayerDrawable(new Drawable[]{gVar, aVar});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y() {
        return this.y.getVisibility() == 0 ? this.u == 1 : this.u != 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z() {
        return this.y.getVisibility() != 0 ? this.u == 2 : this.u != 1;
    }
}
