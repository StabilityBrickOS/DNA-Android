package com.google.android.material.bottomsheet;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.f.l.a0;
import c.f.l.b0.c;
import c.f.l.b0.f;
import c.f.l.s;
import c.h.b.c;
import com.google.android.material.internal.j;
import d.a.a.a.j;
import d.a.a.a.z.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    private static final int Q = j.Widget_Design_BottomSheet_Modal;
    c.h.b.c A;
    private boolean B;
    private int C;
    private boolean D;
    private int E;
    int F;
    int G;
    WeakReference<V> H;
    WeakReference<View> I;
    private final ArrayList<f> J;
    private VelocityTracker K;
    int L;
    private int M;
    boolean N;
    private Map<View, Integer> O;
    private final c.AbstractC0043c P;
    private int a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1068b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1069c;

    /* renamed from: d, reason: collision with root package name */
    private float f1070d;

    /* renamed from: e, reason: collision with root package name */
    private int f1071e;
    private boolean f;
    private int g;
    private int h;
    private boolean i;
    private d.a.a.a.z.g j;
    private int k;
    private boolean l;
    private k m;
    private boolean n;
    private BottomSheetBehavior<V>.h o;
    private ValueAnimator p;
    int q;
    int r;
    int s;
    float t;
    int u;
    float v;
    boolean w;
    private boolean x;
    private boolean y;
    int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f1072e;
        final /* synthetic */ int f;

        a(View view, int i) {
            this.f1072e = view;
            this.f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.m0(this.f1072e, this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.j != null) {
                BottomSheetBehavior.this.j.W(floatValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements j.c {
        c() {
        }

        @Override // com.google.android.material.internal.j.c
        public a0 a(View view, a0 a0Var, j.d dVar) {
            BottomSheetBehavior.this.k = a0Var.d().f717d;
            BottomSheetBehavior.this.t0(false);
            return a0Var;
        }
    }

    /* loaded from: classes.dex */
    class d extends c.AbstractC0043c {
        d() {
        }

        private boolean n(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.G + bottomSheetBehavior.U()) / 2;
        }

        @Override // c.h.b.c.AbstractC0043c
        public int a(View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // c.h.b.c.AbstractC0043c
        public int b(View view, int i, int i2) {
            int U = BottomSheetBehavior.this.U();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return c.f.g.a.b(i, U, bottomSheetBehavior.w ? bottomSheetBehavior.G : bottomSheetBehavior.u);
        }

        @Override // c.h.b.c.AbstractC0043c
        public int e(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.w ? bottomSheetBehavior.G : bottomSheetBehavior.u;
        }

        @Override // c.h.b.c.AbstractC0043c
        public void j(int i) {
            if (i == 1 && BottomSheetBehavior.this.y) {
                BottomSheetBehavior.this.k0(1);
            }
        }

        @Override // c.h.b.c.AbstractC0043c
        public void k(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.S(i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0075, code lost:
        
            if (java.lang.Math.abs(r7.getTop() - r6.a.q) < java.lang.Math.abs(r7.getTop() - r6.a.s)) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:
        
            r8 = r6.a.q;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00b1, code lost:
        
            if (java.lang.Math.abs(r8 - r6.a.s) < java.lang.Math.abs(r8 - r6.a.u)) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00d8, code lost:
        
            if (java.lang.Math.abs(r8 - r6.a.r) < java.lang.Math.abs(r8 - r6.a.u)) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00ea, code lost:
        
            if (r8 < java.lang.Math.abs(r8 - r9.u)) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00fc, code lost:
        
            if (java.lang.Math.abs(r8 - r0) < java.lang.Math.abs(r8 - r6.a.u)) goto L39;
         */
        @Override // c.h.b.c.AbstractC0043c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void l(android.view.View r7, float r8, float r9) {
            /*
                Method dump skipped, instructions count: 262
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.d.l(android.view.View, float, float):void");
        }

        @Override // c.h.b.c.AbstractC0043c
        public boolean m(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.z;
            if (i2 == 1 || bottomSheetBehavior.N) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.L == i) {
                WeakReference<View> weakReference = bottomSheetBehavior.I;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.H;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements c.f.l.b0.f {
        final /* synthetic */ int a;

        e(int i) {
            this.a = i;
        }

        @Override // c.f.l.b0.f
        public boolean a(View view, f.a aVar) {
            BottomSheetBehavior.this.j0(this.a);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {
        public abstract void a(View view, float f);

        public abstract void b(View view, int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class g extends c.h.a.a {
        public static final Parcelable.Creator<g> CREATOR = new a();
        final int g;
        int h;
        boolean i;
        boolean j;
        boolean k;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<g> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i) {
                return new g[i];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.g = parcel.readInt();
            this.h = parcel.readInt();
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.k = parcel.readInt() == 1;
        }

        public g(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.g = bottomSheetBehavior.z;
            this.h = ((BottomSheetBehavior) bottomSheetBehavior).f1071e;
            this.i = ((BottomSheetBehavior) bottomSheetBehavior).f1068b;
            this.j = bottomSheetBehavior.w;
            this.k = ((BottomSheetBehavior) bottomSheetBehavior).x;
        }

        @Override // c.h.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeInt(this.k ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class h implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private final View f1074e;
        private boolean f;
        int g;

        h(View view, int i) {
            this.f1074e = view;
            this.g = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.h.b.c cVar = BottomSheetBehavior.this.A;
            if (cVar == null || !cVar.m(true)) {
                BottomSheetBehavior.this.k0(this.g);
            } else {
                s.a0(this.f1074e, this);
            }
            this.f = false;
        }
    }

    public BottomSheetBehavior() {
        this.a = 0;
        this.f1068b = true;
        this.f1069c = false;
        this.o = null;
        this.t = 0.5f;
        this.v = -1.0f;
        this.y = true;
        this.z = 4;
        this.J = new ArrayList<>();
        this.P = new d();
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        this.a = 0;
        this.f1068b = true;
        this.f1069c = false;
        this.o = null;
        this.t = 0.5f;
        this.v = -1.0f;
        this.y = true;
        this.z = 4;
        this.J = new ArrayList<>();
        this.P = new d();
        this.h = context.getResources().getDimensionPixelSize(d.a.a.a.d.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.a.a.k.BottomSheetBehavior_Layout);
        this.i = obtainStyledAttributes.hasValue(d.a.a.a.k.BottomSheetBehavior_Layout_shapeAppearance);
        boolean hasValue = obtainStyledAttributes.hasValue(d.a.a.a.k.BottomSheetBehavior_Layout_backgroundTint);
        if (hasValue) {
            Q(context, attributeSet, hasValue, d.a.a.a.w.c.a(context, obtainStyledAttributes, d.a.a.a.k.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            P(context, attributeSet, hasValue);
        }
        R();
        if (Build.VERSION.SDK_INT >= 21) {
            this.v = obtainStyledAttributes.getDimension(d.a.a.a.k.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(d.a.a.a.k.BottomSheetBehavior_Layout_behavior_peekHeight);
        f0((peekValue == null || (i = peekValue.data) != -1) ? obtainStyledAttributes.getDimensionPixelSize(d.a.a.a.k.BottomSheetBehavior_Layout_behavior_peekHeight, -1) : i);
        e0(obtainStyledAttributes.getBoolean(d.a.a.a.k.BottomSheetBehavior_Layout_behavior_hideable, false));
        c0(obtainStyledAttributes.getBoolean(d.a.a.a.k.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        b0(obtainStyledAttributes.getBoolean(d.a.a.a.k.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        i0(obtainStyledAttributes.getBoolean(d.a.a.a.k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        Z(obtainStyledAttributes.getBoolean(d.a.a.a.k.BottomSheetBehavior_Layout_behavior_draggable, true));
        h0(obtainStyledAttributes.getInt(d.a.a.a.k.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        d0(obtainStyledAttributes.getFloat(d.a.a.a.k.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(d.a.a.a.k.BottomSheetBehavior_Layout_behavior_expandedOffset);
        a0((peekValue2 == null || peekValue2.type != 16) ? obtainStyledAttributes.getDimensionPixelOffset(d.a.a.a.k.BottomSheetBehavior_Layout_behavior_expandedOffset, 0) : peekValue2.data);
        obtainStyledAttributes.recycle();
        this.f1070d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void L(V v, c.a aVar, int i) {
        s.e0(v, aVar, null, new e(i));
    }

    private void M() {
        int O = O();
        if (this.f1068b) {
            this.u = Math.max(this.G - O, this.r);
        } else {
            this.u = this.G - O;
        }
    }

    private void N() {
        this.s = (int) (this.G * (1.0f - this.t));
    }

    private int O() {
        int i;
        return this.f ? Math.min(Math.max(this.g, this.G - ((this.F * 9) / 16)), this.E) : (this.l || (i = this.k) <= 0) ? this.f1071e : Math.max(this.f1071e, i + this.h);
    }

    private void P(Context context, AttributeSet attributeSet, boolean z) {
        Q(context, attributeSet, z, null);
    }

    private void Q(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.i) {
            this.m = k.e(context, attributeSet, d.a.a.a.b.bottomSheetStyle, Q).m();
            d.a.a.a.z.g gVar = new d.a.a.a.z.g(this.m);
            this.j = gVar;
            gVar.M(context);
            if (z && colorStateList != null) {
                this.j.V(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
            this.j.setTint(typedValue.data);
        }
    }

    private void R() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.p = ofFloat;
        ofFloat.setDuration(500L);
        this.p.addUpdateListener(new b());
    }

    private float V() {
        VelocityTracker velocityTracker = this.K;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f1070d);
        return this.K.getYVelocity(this.L);
    }

    private void X() {
        this.L = -1;
        VelocityTracker velocityTracker = this.K;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.K = null;
        }
    }

    private void Y(g gVar) {
        int i = this.a;
        if (i == 0) {
            return;
        }
        if (i == -1 || (i & 1) == 1) {
            this.f1071e = gVar.h;
        }
        int i2 = this.a;
        if (i2 == -1 || (i2 & 2) == 2) {
            this.f1068b = gVar.i;
        }
        int i3 = this.a;
        if (i3 == -1 || (i3 & 4) == 4) {
            this.w = gVar.j;
        }
        int i4 = this.a;
        if (i4 == -1 || (i4 & 8) == 8) {
            this.x = gVar.k;
        }
    }

    private void l0(View view) {
        if (Build.VERSION.SDK_INT < 29 || W() || this.f) {
            return;
        }
        com.google.android.material.internal.j.a(view, new c());
    }

    private void n0(int i) {
        V v = this.H.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && s.N(v)) {
            v.post(new a(v, i));
        } else {
            m0(v, i);
        }
    }

    private void q0() {
        V v;
        int i;
        c.a aVar;
        WeakReference<V> weakReference = this.H;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        s.c0(v, 524288);
        s.c0(v, 262144);
        s.c0(v, 1048576);
        if (this.w && this.z != 5) {
            L(v, c.a.l, 5);
        }
        int i2 = this.z;
        if (i2 == 3) {
            i = this.f1068b ? 4 : 6;
            aVar = c.a.k;
        } else {
            if (i2 != 4) {
                if (i2 != 6) {
                    return;
                }
                L(v, c.a.k, 4);
                L(v, c.a.j, 3);
                return;
            }
            i = this.f1068b ? 3 : 6;
            aVar = c.a.j;
        }
        L(v, aVar, i);
    }

    private void r0(int i) {
        ValueAnimator valueAnimator;
        if (i == 2) {
            return;
        }
        boolean z = i == 3;
        if (this.n != z) {
            this.n = z;
            if (this.j == null || (valueAnimator = this.p) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.p.reverse();
                return;
            }
            float f2 = z ? 0.0f : 1.0f;
            this.p.setFloatValues(1.0f - f2, f2);
            this.p.start();
        }
    }

    private void s0(boolean z) {
        Map<View, Integer> map;
        int intValue;
        WeakReference<V> weakReference = this.H;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.O != null) {
                    return;
                } else {
                    this.O = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.H.get()) {
                    if (z) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.O.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        if (this.f1069c) {
                            intValue = 4;
                            s.s0(childAt, intValue);
                        }
                    } else if (this.f1069c && (map = this.O) != null && map.containsKey(childAt)) {
                        intValue = this.O.get(childAt).intValue();
                        s.s0(childAt, intValue);
                    }
                }
            }
            if (z) {
                return;
            }
            this.O = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(boolean z) {
        V v;
        if (this.H != null) {
            M();
            if (this.z != 4 || (v = this.H.get()) == null) {
                return;
            }
            if (z) {
                n0(this.z);
            } else {
                v.requestLayout();
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.C = 0;
        this.D = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
    
        if (java.lang.Math.abs(r3 - r2.r) < java.lang.Math.abs(r3 - r2.u)) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
    
        if (r3 < java.lang.Math.abs(r3 - r2.u)) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
    
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.u)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a6, code lost:
    
        if (java.lang.Math.abs(r3 - r2.s) < java.lang.Math.abs(r3 - r2.u)) goto L47;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(androidx.coordinatorlayout.widget.CoordinatorLayout r3, V r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.U()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.k0(r0)
            return
        Lf:
            java.lang.ref.WeakReference<android.view.View> r3 = r2.I
            if (r3 == 0) goto Lb1
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto Lb1
            boolean r3 = r2.D
            if (r3 != 0) goto L1f
            goto Lb1
        L1f:
            int r3 = r2.C
            r5 = 4
            r6 = 6
            if (r3 <= 0) goto L3c
            boolean r3 = r2.f1068b
            if (r3 == 0) goto L2d
        L29:
            int r3 = r2.r
            goto Lab
        L2d:
            int r3 = r4.getTop()
            int r5 = r2.s
            if (r3 <= r5) goto L38
            r3 = r5
            goto Laa
        L38:
            int r3 = r2.q
            goto Lab
        L3c:
            boolean r3 = r2.w
            if (r3 == 0) goto L4e
            float r3 = r2.V()
            boolean r3 = r2.o0(r4, r3)
            if (r3 == 0) goto L4e
            int r3 = r2.G
            r0 = 5
            goto Lab
        L4e:
            int r3 = r2.C
            if (r3 != 0) goto L8b
            int r3 = r4.getTop()
            boolean r1 = r2.f1068b
            if (r1 == 0) goto L6c
            int r6 = r2.r
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            int r1 = r2.u
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r6 >= r3) goto L8f
            goto L29
        L6c:
            int r1 = r2.s
            if (r3 >= r1) goto L7b
            int r5 = r2.u
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            if (r3 >= r5) goto La8
            goto L38
        L7b:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.u
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L8f
            goto La8
        L8b:
            boolean r3 = r2.f1068b
            if (r3 == 0) goto L93
        L8f:
            int r3 = r2.u
            r0 = 4
            goto Lab
        L93:
            int r3 = r4.getTop()
            int r0 = r2.s
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.u
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L8f
        La8:
            int r3 = r2.s
        Laa:
            r0 = 6
        Lab:
            r5 = 0
            r2.p0(r4, r0, r3, r5)
            r2.D = r5
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.C(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.z == 1 && actionMasked == 0) {
            return true;
        }
        c.h.b.c cVar = this.A;
        if (cVar != null) {
            cVar.E(motionEvent);
        }
        if (actionMasked == 0) {
            X();
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        if (this.A != null && actionMasked == 2 && !this.B && Math.abs(this.M - motionEvent.getY()) > this.A.y()) {
            this.A.b(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.B;
    }

    void S(int i) {
        float f2;
        float f3;
        V v = this.H.get();
        if (v == null || this.J.isEmpty()) {
            return;
        }
        int i2 = this.u;
        if (i > i2 || i2 == U()) {
            int i3 = this.u;
            f2 = i3 - i;
            f3 = this.G - i3;
        } else {
            int i4 = this.u;
            f2 = i4 - i;
            f3 = i4 - U();
        }
        float f4 = f2 / f3;
        for (int i5 = 0; i5 < this.J.size(); i5++) {
            this.J.get(i5).a(v, f4);
        }
    }

    View T(View view) {
        if (s.P(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View T = T(viewGroup.getChildAt(i));
            if (T != null) {
                return T;
            }
        }
        return null;
    }

    public int U() {
        return this.f1068b ? this.r : this.q;
    }

    public boolean W() {
        return this.l;
    }

    public void Z(boolean z) {
        this.y = z;
    }

    public void a0(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.q = i;
    }

    public void b0(boolean z) {
        if (this.f1068b == z) {
            return;
        }
        this.f1068b = z;
        if (this.H != null) {
            M();
        }
        k0((this.f1068b && this.z == 6) ? 3 : this.z);
        q0();
    }

    public void c0(boolean z) {
        this.l = z;
    }

    public void d0(float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.t = f2;
        if (this.H != null) {
            N();
        }
    }

    public void e0(boolean z) {
        if (this.w != z) {
            this.w = z;
            if (!z && this.z == 5) {
                j0(4);
            }
            q0();
        }
    }

    public void f0(int i) {
        g0(i, false);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        super.g(fVar);
        this.H = null;
        this.A = null;
    }

    public final void g0(int i, boolean z) {
        boolean z2 = true;
        if (i == -1) {
            if (!this.f) {
                this.f = true;
            }
            z2 = false;
        } else {
            if (this.f || this.f1071e != i) {
                this.f = false;
                this.f1071e = Math.max(0, i);
            }
            z2 = false;
        }
        if (z2) {
            t0(z);
        }
    }

    public void h0(int i) {
        this.a = i;
    }

    public void i0(boolean z) {
        this.x = z;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void j() {
        super.j();
        this.H = null;
        this.A = null;
    }

    public void j0(int i) {
        if (i == this.z) {
            return;
        }
        if (this.H != null) {
            n0(i);
            return;
        }
        if (i == 4 || i == 3 || i == 6 || (this.w && i == 5)) {
            this.z = i;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        c.h.b.c cVar;
        if (!v.isShown() || !this.y) {
            this.B = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            X();
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.M = (int) motionEvent.getY();
            if (this.z != 2) {
                WeakReference<View> weakReference = this.I;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.B(view, x, this.M)) {
                    this.L = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.N = true;
                }
            }
            this.B = this.L == -1 && !coordinatorLayout.B(v, x, this.M);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.N = false;
            this.L = -1;
            if (this.B) {
                this.B = false;
                return false;
            }
        }
        if (!this.B && (cVar = this.A) != null && cVar.N(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.I;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.B || this.z == 1 || coordinatorLayout.B(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.A == null || Math.abs(((float) this.M) - motionEvent.getY()) <= ((float) this.A.y())) ? false : true;
    }

    void k0(int i) {
        V v;
        if (this.z == i) {
            return;
        }
        this.z = i;
        WeakReference<V> weakReference = this.H;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            s0(true);
        } else if (i == 6 || i == 5 || i == 4) {
            s0(false);
        }
        r0(i);
        for (int i2 = 0; i2 < this.J.size(); i2++) {
            this.J.get(i2).b(v, i);
        }
        q0();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i) {
        int i2;
        d.a.a.a.z.g gVar;
        if (s.v(coordinatorLayout) && !s.v(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.H == null) {
            this.g = coordinatorLayout.getResources().getDimensionPixelSize(d.a.a.a.d.design_bottom_sheet_peek_height_min);
            l0(v);
            this.H = new WeakReference<>(v);
            if (this.i && (gVar = this.j) != null) {
                s.l0(v, gVar);
            }
            d.a.a.a.z.g gVar2 = this.j;
            if (gVar2 != null) {
                float f2 = this.v;
                if (f2 == -1.0f) {
                    f2 = s.t(v);
                }
                gVar2.U(f2);
                boolean z = this.z == 3;
                this.n = z;
                this.j.W(z ? 0.0f : 1.0f);
            }
            q0();
            if (s.w(v) == 0) {
                s.s0(v, 1);
            }
        }
        if (this.A == null) {
            this.A = c.h.b.c.o(coordinatorLayout, this.P);
        }
        int top = v.getTop();
        coordinatorLayout.I(v, i);
        this.F = coordinatorLayout.getWidth();
        this.G = coordinatorLayout.getHeight();
        int height = v.getHeight();
        this.E = height;
        this.r = Math.max(0, this.G - height);
        N();
        M();
        int i3 = this.z;
        if (i3 == 3) {
            i2 = U();
        } else if (i3 == 6) {
            i2 = this.s;
        } else if (this.w && i3 == 5) {
            i2 = this.G;
        } else {
            int i4 = this.z;
            if (i4 != 4) {
                if (i4 == 1 || i4 == 2) {
                    s.U(v, top - v.getTop());
                }
                this.I = new WeakReference<>(T(v));
                return true;
            }
            i2 = this.u;
        }
        s.U(v, i2);
        this.I = new WeakReference<>(T(v));
        return true;
    }

    void m0(View view, int i) {
        int i2;
        int i3;
        if (i == 4) {
            i2 = this.u;
        } else if (i == 6) {
            int i4 = this.s;
            if (!this.f1068b || i4 > (i3 = this.r)) {
                i2 = i4;
            } else {
                i2 = i3;
                i = 3;
            }
        } else if (i == 3) {
            i2 = U();
        } else {
            if (!this.w || i != 5) {
                throw new IllegalArgumentException("Illegal state argument: " + i);
            }
            i2 = this.G;
        }
        p0(view, i, i2, false);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.I;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.z != 3 || super.o(coordinatorLayout, v, view, f2, f3);
    }

    boolean o0(View view, float f2) {
        if (this.x) {
            return true;
        }
        if (view.getTop() < this.u) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.u)) / ((float) O()) > 0.5f;
    }

    void p0(View view, int i, int i2, boolean z) {
        c.h.b.c cVar = this.A;
        if (!(cVar != null && (!z ? !cVar.O(view, view.getLeft(), i2) : !cVar.M(view.getLeft(), i2)))) {
            k0(i);
            return;
        }
        k0(2);
        r0(i);
        if (this.o == null) {
            this.o = new h(view, i);
        }
        if (((h) this.o).f) {
            this.o.g = i;
            return;
        }
        BottomSheetBehavior<V>.h hVar = this.o;
        hVar.g = i;
        s.a0(view, hVar);
        ((h) this.o).f = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void q(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        int i4;
        if (i3 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.I;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i5 = top - i2;
        if (i2 > 0) {
            if (i5 < U()) {
                iArr[1] = top - U();
                s.U(v, -iArr[1]);
                i4 = 3;
                k0(i4);
            } else {
                if (!this.y) {
                    return;
                }
                iArr[1] = i2;
                s.U(v, -i2);
                k0(1);
            }
        } else if (i2 < 0 && !view.canScrollVertically(-1)) {
            int i6 = this.u;
            if (i5 > i6 && !this.w) {
                iArr[1] = top - i6;
                s.U(v, -iArr[1]);
                i4 = 4;
                k0(i4);
            } else {
                if (!this.y) {
                    return;
                }
                iArr[1] = i2;
                s.U(v, -i2);
                k0(1);
            }
        }
        S(v.getTop());
        this.C = i2;
        this.D = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void x(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        g gVar = (g) parcelable;
        super.x(coordinatorLayout, v, gVar.f());
        Y(gVar);
        int i = gVar.g;
        if (i == 1 || i == 2) {
            i = 4;
        }
        this.z = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable y(CoordinatorLayout coordinatorLayout, V v) {
        return new g(super.y(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }
}
