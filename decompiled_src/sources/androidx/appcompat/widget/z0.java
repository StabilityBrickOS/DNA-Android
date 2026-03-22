package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
class z0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    private static z0 n;
    private static z0 o;

    /* renamed from: e, reason: collision with root package name */
    private final View f299e;
    private final CharSequence f;
    private final int g;
    private final Runnable h = new a();
    private final Runnable i = new b();
    private int j;
    private int k;
    private a1 l;
    private boolean m;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z0.this.g(false);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z0.this.c();
        }
    }

    private z0(View view, CharSequence charSequence) {
        this.f299e = view;
        this.f = charSequence;
        this.g = c.f.l.t.c(ViewConfiguration.get(view.getContext()));
        b();
        this.f299e.setOnLongClickListener(this);
        this.f299e.setOnHoverListener(this);
    }

    private void a() {
        this.f299e.removeCallbacks(this.h);
    }

    private void b() {
        this.j = Integer.MAX_VALUE;
        this.k = Integer.MAX_VALUE;
    }

    private void d() {
        this.f299e.postDelayed(this.h, ViewConfiguration.getLongPressTimeout());
    }

    private static void e(z0 z0Var) {
        z0 z0Var2 = n;
        if (z0Var2 != null) {
            z0Var2.a();
        }
        n = z0Var;
        if (z0Var != null) {
            z0Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        z0 z0Var = n;
        if (z0Var != null && z0Var.f299e == view) {
            e(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new z0(view, charSequence);
            return;
        }
        z0 z0Var2 = o;
        if (z0Var2 != null && z0Var2.f299e == view) {
            z0Var2.c();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private boolean h(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.j) <= this.g && Math.abs(y - this.k) <= this.g) {
            return false;
        }
        this.j = x;
        this.k = y;
        return true;
    }

    void c() {
        if (o == this) {
            o = null;
            a1 a1Var = this.l;
            if (a1Var != null) {
                a1Var.c();
                this.l = null;
                b();
                this.f299e.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (n == this) {
            e(null);
        }
        this.f299e.removeCallbacks(this.i);
    }

    void g(boolean z) {
        long longPressTimeout;
        if (c.f.l.s.N(this.f299e)) {
            e(null);
            z0 z0Var = o;
            if (z0Var != null) {
                z0Var.c();
            }
            o = this;
            this.m = z;
            a1 a1Var = new a1(this.f299e.getContext());
            this.l = a1Var;
            a1Var.e(this.f299e, this.j, this.k, this.m, this.f);
            this.f299e.addOnAttachStateChangeListener(this);
            if (this.m) {
                longPressTimeout = 2500;
            } else {
                longPressTimeout = ((c.f.l.s.H(this.f299e) & 1) == 1 ? 3000L : 15000L) - ViewConfiguration.getLongPressTimeout();
            }
            this.f299e.removeCallbacks(this.i);
            this.f299e.postDelayed(this.i, longPressTimeout);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.l != null && this.m) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f299e.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.f299e.isEnabled() && this.l == null && h(motionEvent)) {
            e(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.j = view.getWidth() / 2;
        this.k = view.getHeight() / 2;
        g(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
