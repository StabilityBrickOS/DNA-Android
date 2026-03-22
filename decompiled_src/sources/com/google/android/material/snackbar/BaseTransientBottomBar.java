package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.f.l.a0;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.b;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    static final Handler s;
    private static final boolean t;
    private static final int[] u;
    private static final String v;
    private final ViewGroup a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f1168b;

    /* renamed from: c, reason: collision with root package name */
    protected final v f1169c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.material.snackbar.a f1170d;

    /* renamed from: e, reason: collision with root package name */
    private int f1171e;
    private boolean f;
    private View g;
    private Rect i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private List<r<B>> o;
    private Behavior p;
    private final AccessibilityManager q;
    private final Runnable h = new j();
    b.InterfaceC0075b r = new m();

    /* loaded from: classes.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {
        private final s k = new s(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void P(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.k.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean E(View view) {
            return this.k.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.k.b(coordinatorLayout, view, motionEvent);
            return super.k(coordinatorLayout, view, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.H();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.G(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f1169c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f1169c.setScaleX(floatValue);
            BaseTransientBottomBar.this.f1169c.setScaleY(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.H();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f1170d.b(70, 180);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        private int a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1173b;

        f(int i) {
            this.f1173b = i;
            this.a = this.f1173b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.t) {
                c.f.l.s.U(BaseTransientBottomBar.this.f1169c, intValue - this.a);
            } else {
                BaseTransientBottomBar.this.f1169c.setTranslationY(intValue);
            }
            this.a = intValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        g(int i) {
            this.a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.G(this.a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f1170d.a(0, 180);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        private int a = 0;

        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.t) {
                c.f.l.s.U(BaseTransientBottomBar.this.f1169c, intValue - this.a);
            } else {
                BaseTransientBottomBar.this.f1169c.setTranslationY(intValue);
            }
            this.a = intValue;
        }
    }

    /* loaded from: classes.dex */
    static class i implements Handler.Callback {
        i() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                ((BaseTransientBottomBar) message.obj).N();
                return true;
            }
            if (i != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).D(message.arg1);
            return true;
        }
    }

    /* loaded from: classes.dex */
    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int y;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f1169c == null || baseTransientBottomBar.f1168b == null || (y = (BaseTransientBottomBar.this.y() - BaseTransientBottomBar.this.B()) + ((int) BaseTransientBottomBar.this.f1169c.getTranslationY())) >= BaseTransientBottomBar.this.m) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f1169c.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.v, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.m - y;
            BaseTransientBottomBar.this.f1169c.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    class k implements c.f.l.p {
        k() {
        }

        @Override // c.f.l.p
        public a0 a(View view, a0 a0Var) {
            BaseTransientBottomBar.this.j = a0Var.e();
            BaseTransientBottomBar.this.k = a0Var.f();
            BaseTransientBottomBar.this.l = a0Var.g();
            BaseTransientBottomBar.this.T();
            return a0Var;
        }
    }

    /* loaded from: classes.dex */
    class l extends c.f.l.a {
        l() {
        }

        @Override // c.f.l.a
        public void g(View view, c.f.l.b0.c cVar) {
            super.g(view, cVar);
            cVar.a(1048576);
            cVar.f0(true);
        }

        @Override // c.f.l.a
        public boolean j(View view, int i, Bundle bundle) {
            if (i != 1048576) {
                return super.j(view, i, bundle);
            }
            BaseTransientBottomBar.this.s();
            return true;
        }
    }

    /* loaded from: classes.dex */
    class m implements b.InterfaceC0075b {
        m() {
        }

        @Override // com.google.android.material.snackbar.b.InterfaceC0075b
        public void a() {
            Handler handler = BaseTransientBottomBar.s;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.b.InterfaceC0075b
        public void b(int i) {
            Handler handler = BaseTransientBottomBar.s;
            handler.sendMessage(handler.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n implements t {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseTransientBottomBar.this.G(3);
            }
        }

        n() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        public void onViewAttachedToWindow(View view) {
            WindowInsets rootWindowInsets;
            if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = BaseTransientBottomBar.this.f1169c.getRootWindowInsets()) == null) {
                return;
            }
            BaseTransientBottomBar.this.m = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            BaseTransientBottomBar.this.T();
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        public void onViewDetachedFromWindow(View view) {
            if (BaseTransientBottomBar.this.E()) {
                BaseTransientBottomBar.s.post(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o implements u {
        o() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.u
        public void a(View view, int i, int i2, int i3, int i4) {
            BaseTransientBottomBar.this.f1169c.setOnLayoutChangeListener(null);
            BaseTransientBottomBar.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p implements SwipeDismissBehavior.c {
        p() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(View view) {
            view.setVisibility(8);
            BaseTransientBottomBar.this.t(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(int i) {
            if (i == 0) {
                com.google.android.material.snackbar.b.c().k(BaseTransientBottomBar.this.r);
            } else if (i == 1 || i == 2) {
                com.google.android.material.snackbar.b.c().j(BaseTransientBottomBar.this.r);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class q implements Runnable {
        q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v vVar = BaseTransientBottomBar.this.f1169c;
            if (vVar == null) {
                return;
            }
            vVar.setVisibility(0);
            if (BaseTransientBottomBar.this.f1169c.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.P();
            } else {
                BaseTransientBottomBar.this.R();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class r<B> {
        public void a(B b2, int i) {
        }

        public void b(B b2) {
        }
    }

    /* loaded from: classes.dex */
    public static class s {
        private b.InterfaceC0075b a;

        public s(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.L(0.1f);
            swipeDismissBehavior.J(0.6f);
            swipeDismissBehavior.M(0);
        }

        public boolean a(View view) {
            return view instanceof v;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.B(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.b.c().j(this.a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.b.c().k(this.a);
            }
        }

        public void c(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.a = baseTransientBottomBar.r;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface t {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface u {
        void a(View view, int i, int i2, int i3, int i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class v extends FrameLayout {
        private static final View.OnTouchListener l = new a();

        /* renamed from: e, reason: collision with root package name */
        private u f1181e;
        private t f;
        private int g;
        private final float h;
        private final float i;
        private ColorStateList j;
        private PorterDuff.Mode k;

        /* loaded from: classes.dex */
        static class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public v(Context context, AttributeSet attributeSet) {
            super(com.google.android.material.theme.a.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, d.a.a.a.k.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(d.a.a.a.k.SnackbarLayout_elevation)) {
                c.f.l.s.p0(this, obtainStyledAttributes.getDimensionPixelSize(d.a.a.a.k.SnackbarLayout_elevation, 0));
            }
            this.g = obtainStyledAttributes.getInt(d.a.a.a.k.SnackbarLayout_animationMode, 0);
            this.h = obtainStyledAttributes.getFloat(d.a.a.a.k.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(d.a.a.a.w.c.a(context2, obtainStyledAttributes, d.a.a.a.k.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(com.google.android.material.internal.j.e(obtainStyledAttributes.getInt(d.a.a.a.k.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.i = obtainStyledAttributes.getFloat(d.a.a.a.k.SnackbarLayout_actionTextColorAlpha, 1.0f);
            obtainStyledAttributes.recycle();
            setOnTouchListener(l);
            setFocusable(true);
            if (getBackground() == null) {
                c.f.l.s.l0(this, a());
            }
        }

        private Drawable a() {
            float dimension = getResources().getDimension(d.a.a.a.d.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(d.a.a.a.q.a.g(this, d.a.a.a.b.colorSurface, d.a.a.a.b.colorOnSurface, getBackgroundOverlayColorAlpha()));
            if (this.j == null) {
                return androidx.core.graphics.drawable.a.r(gradientDrawable);
            }
            Drawable r = androidx.core.graphics.drawable.a.r(gradientDrawable);
            androidx.core.graphics.drawable.a.o(r, this.j);
            return r;
        }

        float getActionTextColorAlpha() {
            return this.i;
        }

        int getAnimationMode() {
            return this.g;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.h;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            t tVar = this.f;
            if (tVar != null) {
                tVar.onViewAttachedToWindow(this);
            }
            c.f.l.s.f0(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            t tVar = this.f;
            if (tVar != null) {
                tVar.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            u uVar = this.f1181e;
            if (uVar != null) {
                uVar.a(this, i, i2, i3, i4);
            }
        }

        void setAnimationMode(int i) {
            this.g = i;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.j != null) {
                drawable = androidx.core.graphics.drawable.a.r(drawable.mutate());
                androidx.core.graphics.drawable.a.o(drawable, this.j);
                androidx.core.graphics.drawable.a.p(drawable, this.k);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.j = colorStateList;
            if (getBackground() != null) {
                Drawable r = androidx.core.graphics.drawable.a.r(getBackground().mutate());
                androidx.core.graphics.drawable.a.o(r, colorStateList);
                androidx.core.graphics.drawable.a.p(r, this.k);
                if (r != getBackground()) {
                    super.setBackgroundDrawable(r);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.k = mode;
            if (getBackground() != null) {
                Drawable r = androidx.core.graphics.drawable.a.r(getBackground().mutate());
                androidx.core.graphics.drawable.a.p(r, mode);
                if (r != getBackground()) {
                    super.setBackgroundDrawable(r);
                }
            }
        }

        void setOnAttachStateChangeListener(t tVar) {
            this.f = tVar;
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : l);
            super.setOnClickListener(onClickListener);
        }

        void setOnLayoutChangeListener(u uVar) {
            this.f1181e = uVar;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        t = i2 >= 16 && i2 <= 19;
        u = new int[]{d.a.a.a.b.snackbarStyle};
        v = BaseTransientBottomBar.class.getSimpleName();
        s = new Handler(Looper.getMainLooper(), new i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseTransientBottomBar(ViewGroup viewGroup, View view, com.google.android.material.snackbar.a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.a = viewGroup;
        this.f1170d = aVar;
        Context context = viewGroup.getContext();
        this.f1168b = context;
        com.google.android.material.internal.i.a(context);
        v vVar = (v) LayoutInflater.from(this.f1168b).inflate(z(), this.a, false);
        this.f1169c = vVar;
        if (view instanceof SnackbarContentLayout) {
            ((SnackbarContentLayout) view).c(vVar.getActionTextColorAlpha());
        }
        this.f1169c.addView(view);
        ViewGroup.LayoutParams layoutParams = this.f1169c.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.i = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        c.f.l.s.k0(this.f1169c, 1);
        c.f.l.s.s0(this.f1169c, 1);
        c.f.l.s.q0(this.f1169c, true);
        c.f.l.s.u0(this.f1169c, new k());
        c.f.l.s.i0(this.f1169c, new l());
        this.q = (AccessibilityManager) this.f1168b.getSystemService("accessibility");
    }

    private int A() {
        int height = this.f1169c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f1169c.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int B() {
        int[] iArr = new int[2];
        this.f1169c.getLocationOnScreen(iArr);
        return iArr[1] + this.f1169c.getHeight();
    }

    private boolean F() {
        ViewGroup.LayoutParams layoutParams = this.f1169c.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) layoutParams).f() instanceof SwipeDismissBehavior);
    }

    private void J(CoordinatorLayout.f fVar) {
        SwipeDismissBehavior<? extends View> swipeDismissBehavior = this.p;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = w();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).P(this);
        }
        swipeDismissBehavior.K(new p());
        fVar.o(swipeDismissBehavior);
        if (this.g == null) {
            fVar.g = 80;
        }
    }

    private boolean L() {
        return this.m > 0 && !this.f && F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (K()) {
            p();
        } else {
            this.f1169c.setVisibility(0);
            H();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        ValueAnimator u2 = u(0.0f, 1.0f);
        ValueAnimator x = x(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(u2, x);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new a());
        animatorSet.start();
    }

    private void Q(int i2) {
        ValueAnimator u2 = u(1.0f, 0.0f);
        u2.setDuration(75L);
        u2.addListener(new b(i2));
        u2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        int A = A();
        if (t) {
            c.f.l.s.U(this.f1169c, A);
        } else {
            this.f1169c.setTranslationY(A);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(A, 0);
        valueAnimator.setInterpolator(d.a.a.a.l.a.f1276b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new e());
        valueAnimator.addUpdateListener(new f(A));
        valueAnimator.start();
    }

    private void S(int i2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, A());
        valueAnimator.setInterpolator(d.a.a.a.l.a.f1276b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new g(i2));
        valueAnimator.addUpdateListener(new h());
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        ViewGroup.LayoutParams layoutParams = this.f1169c.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || this.i == null) {
            Log.w(v, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        int i2 = this.g != null ? this.n : this.j;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        Rect rect = this.i;
        marginLayoutParams.bottomMargin = rect.bottom + i2;
        marginLayoutParams.leftMargin = rect.left + this.k;
        marginLayoutParams.rightMargin = rect.right + this.l;
        this.f1169c.requestLayout();
        if (Build.VERSION.SDK_INT < 29 || !L()) {
            return;
        }
        this.f1169c.removeCallbacks(this.h);
        this.f1169c.post(this.h);
    }

    private void q(int i2) {
        if (this.f1169c.getAnimationMode() == 1) {
            Q(i2);
        } else {
            S(i2);
        }
    }

    private int r() {
        View view = this.g;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        this.a.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.a.getHeight()) - i2;
    }

    private ValueAnimator u(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(d.a.a.a.l.a.a);
        ofFloat.addUpdateListener(new c());
        return ofFloat;
    }

    private ValueAnimator x(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(d.a.a.a.l.a.f1278d);
        ofFloat.addUpdateListener(new d());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int y() {
        WindowManager windowManager = (WindowManager) this.f1168b.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    protected boolean C() {
        TypedArray obtainStyledAttributes = this.f1168b.obtainStyledAttributes(u);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    final void D(int i2) {
        if (K() && this.f1169c.getVisibility() == 0) {
            q(i2);
        } else {
            G(i2);
        }
    }

    public boolean E() {
        return com.google.android.material.snackbar.b.c().e(this.r);
    }

    void G(int i2) {
        com.google.android.material.snackbar.b.c().h(this.r);
        List<r<B>> list = this.o;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.o.get(size).a(this, i2);
            }
        }
        ViewParent parent = this.f1169c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f1169c);
        }
    }

    void H() {
        com.google.android.material.snackbar.b.c().i(this.r);
        List<r<B>> list = this.o;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.o.get(size).b(this);
            }
        }
    }

    public B I(int i2) {
        this.f1171e = i2;
        return this;
    }

    boolean K() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.q.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void M() {
        com.google.android.material.snackbar.b.c().m(v(), this.r);
    }

    final void N() {
        this.f1169c.setOnAttachStateChangeListener(new n());
        if (this.f1169c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f1169c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                J((CoordinatorLayout.f) layoutParams);
            }
            this.n = r();
            T();
            this.f1169c.setVisibility(4);
            this.a.addView(this.f1169c);
        }
        if (c.f.l.s.O(this.f1169c)) {
            O();
        } else {
            this.f1169c.setOnLayoutChangeListener(new o());
        }
    }

    void p() {
        this.f1169c.post(new q());
    }

    public void s() {
        t(3);
    }

    protected void t(int i2) {
        com.google.android.material.snackbar.b.c().b(this.r, i2);
    }

    public int v() {
        return this.f1171e;
    }

    protected SwipeDismissBehavior<? extends View> w() {
        return new Behavior();
    }

    protected int z() {
        return C() ? d.a.a.a.h.mtrl_layout_snackbar : d.a.a.a.h.design_layout_snackbar;
    }
}
