package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.l0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q extends k implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, m, View.OnKeyListener {
    private static final int z = c.a.g.abc_popup_menu_item_layout;
    private final Context f;
    private final g g;
    private final f h;
    private final boolean i;
    private final int j;
    private final int k;
    private final int l;
    final l0 m;
    private PopupWindow.OnDismissListener p;
    private View q;
    View r;
    private m.a s;
    ViewTreeObserver t;
    private boolean u;
    private boolean v;
    private int w;
    private boolean y;
    final ViewTreeObserver.OnGlobalLayoutListener n = new a();
    private final View.OnAttachStateChangeListener o = new b();
    private int x = 0;

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!q.this.c() || q.this.m.B()) {
                return;
            }
            View view = q.this.r;
            if (view == null || !view.isShown()) {
                q.this.dismiss();
            } else {
                q.this.m.a();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = q.this.t;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    q.this.t = view.getViewTreeObserver();
                }
                q qVar = q.this;
                qVar.t.removeGlobalOnLayoutListener(qVar.n);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i, int i2, boolean z2) {
        this.f = context;
        this.g = gVar;
        this.i = z2;
        this.h = new f(gVar, LayoutInflater.from(context), this.i, z);
        this.k = i;
        this.l = i2;
        Resources resources = context.getResources();
        this.j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(c.a.d.abc_config_prefDialogWidth));
        this.q = view;
        this.m = new l0(this.f, null, this.k, this.l);
        gVar.c(this, context);
    }

    private boolean z() {
        View view;
        if (c()) {
            return true;
        }
        if (this.u || (view = this.q) == null) {
            return false;
        }
        this.r = view;
        this.m.K(this);
        this.m.L(this);
        this.m.J(true);
        View view2 = this.r;
        boolean z2 = this.t == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.t = viewTreeObserver;
        if (z2) {
            viewTreeObserver.addOnGlobalLayoutListener(this.n);
        }
        view2.addOnAttachStateChangeListener(this.o);
        this.m.D(view2);
        this.m.G(this.x);
        if (!this.v) {
            this.w = k.o(this.h, null, this.f, this.j);
            this.v = true;
        }
        this.m.F(this.w);
        this.m.I(2);
        this.m.H(n());
        this.m.a();
        ListView l = this.m.l();
        l.setOnKeyListener(this);
        if (this.y && this.g.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f).inflate(c.a.g.abc_popup_menu_header_item_layout, (ViewGroup) l, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.g.x());
            }
            frameLayout.setEnabled(false);
            l.addHeaderView(frameLayout, null, false);
        }
        this.m.o(this.h);
        this.m.a();
        return true;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z2) {
        if (gVar != this.g) {
            return;
        }
        dismiss();
        m.a aVar = this.s;
        if (aVar != null) {
            aVar.b(gVar, z2);
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean c() {
        return !this.u && this.m.c();
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        if (c()) {
            this.m.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void h(m.a aVar) {
        this.s = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean i(r rVar) {
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.f, rVar, this.r, this.i, this.k, this.l);
            lVar.j(this.s);
            lVar.g(k.x(rVar));
            lVar.i(this.p);
            this.p = null;
            this.g.e(false);
            int e2 = this.m.e();
            int h = this.m.h();
            if ((Gravity.getAbsoluteGravity(this.x, c.f.l.s.y(this.q)) & 7) == 5) {
                e2 += this.q.getWidth();
            }
            if (lVar.n(e2, h)) {
                m.a aVar = this.s;
                if (aVar == null) {
                    return true;
                }
                aVar.c(rVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void j(boolean z2) {
        this.v = false;
        f fVar = this.h;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void k(g gVar) {
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView l() {
        return this.m.l();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.u = true;
        this.g.close();
        ViewTreeObserver viewTreeObserver = this.t;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.t = this.r.getViewTreeObserver();
            }
            this.t.removeGlobalOnLayoutListener(this.n);
            this.t = null;
        }
        this.r.removeOnAttachStateChangeListener(this.o);
        PopupWindow.OnDismissListener onDismissListener = this.p;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.k
    public void p(View view) {
        this.q = view;
    }

    @Override // androidx.appcompat.view.menu.k
    public void r(boolean z2) {
        this.h.d(z2);
    }

    @Override // androidx.appcompat.view.menu.k
    public void s(int i) {
        this.x = i;
    }

    @Override // androidx.appcompat.view.menu.k
    public void t(int i) {
        this.m.d(i);
    }

    @Override // androidx.appcompat.view.menu.k
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.p = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void v(boolean z2) {
        this.y = z2;
    }

    @Override // androidx.appcompat.view.menu.k
    public void w(int i) {
        this.m.n(i);
    }
}
