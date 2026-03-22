package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.p0;
import c.a.n.b;
import c.f.l.s;
import c.f.l.w;
import c.f.l.x;
import c.f.l.y;
import c.f.l.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class m extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {
    private static final Interpolator B = new AccelerateInterpolator();
    private static final Interpolator C = new DecelerateInterpolator();
    final z A;
    Context a;

    /* renamed from: b, reason: collision with root package name */
    private Context f100b;

    /* renamed from: c, reason: collision with root package name */
    ActionBarOverlayLayout f101c;

    /* renamed from: d, reason: collision with root package name */
    ActionBarContainer f102d;

    /* renamed from: e, reason: collision with root package name */
    d0 f103e;
    ActionBarContextView f;
    View g;
    p0 h;
    private boolean i;
    d j;
    c.a.n.b k;
    b.a l;
    private boolean m;
    private ArrayList<a.b> n;
    private boolean o;
    private int p;
    boolean q;
    boolean r;
    boolean s;
    private boolean t;
    private boolean u;
    c.a.n.h v;
    private boolean w;
    boolean x;
    final x y;
    final x z;

    /* loaded from: classes.dex */
    class a extends y {
        a() {
        }

        @Override // c.f.l.x
        public void a(View view) {
            View view2;
            m mVar = m.this;
            if (mVar.q && (view2 = mVar.g) != null) {
                view2.setTranslationY(0.0f);
                m.this.f102d.setTranslationY(0.0f);
            }
            m.this.f102d.setVisibility(8);
            m.this.f102d.setTransitioning(false);
            m mVar2 = m.this;
            mVar2.v = null;
            mVar2.z();
            ActionBarOverlayLayout actionBarOverlayLayout = m.this.f101c;
            if (actionBarOverlayLayout != null) {
                s.f0(actionBarOverlayLayout);
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends y {
        b() {
        }

        @Override // c.f.l.x
        public void a(View view) {
            m mVar = m.this;
            mVar.v = null;
            mVar.f102d.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    class c implements z {
        c() {
        }

        @Override // c.f.l.z
        public void a(View view) {
            ((View) m.this.f102d.getParent()).invalidate();
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.n.b implements g.a {
        private final Context g;
        private final androidx.appcompat.view.menu.g h;
        private b.a i;
        private WeakReference<View> j;

        public d(Context context, b.a aVar) {
            this.g = context;
            this.i = aVar;
            androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
            gVar.S(1);
            this.h = gVar;
            gVar.R(this);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            b.a aVar = this.i;
            if (aVar != null) {
                return aVar.b(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            if (this.i == null) {
                return;
            }
            k();
            m.this.f.l();
        }

        @Override // c.a.n.b
        public void c() {
            m mVar = m.this;
            if (mVar.j != this) {
                return;
            }
            if (m.y(mVar.r, mVar.s, false)) {
                this.i.d(this);
            } else {
                m mVar2 = m.this;
                mVar2.k = this;
                mVar2.l = this.i;
            }
            this.i = null;
            m.this.x(false);
            m.this.f.g();
            m.this.f103e.o().sendAccessibilityEvent(32);
            m mVar3 = m.this;
            mVar3.f101c.setHideOnContentScrollEnabled(mVar3.x);
            m.this.j = null;
        }

        @Override // c.a.n.b
        public View d() {
            WeakReference<View> weakReference = this.j;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // c.a.n.b
        public Menu e() {
            return this.h;
        }

        @Override // c.a.n.b
        public MenuInflater f() {
            return new c.a.n.g(this.g);
        }

        @Override // c.a.n.b
        public CharSequence g() {
            return m.this.f.getSubtitle();
        }

        @Override // c.a.n.b
        public CharSequence i() {
            return m.this.f.getTitle();
        }

        @Override // c.a.n.b
        public void k() {
            if (m.this.j != this) {
                return;
            }
            this.h.d0();
            try {
                this.i.a(this, this.h);
            } finally {
                this.h.c0();
            }
        }

        @Override // c.a.n.b
        public boolean l() {
            return m.this.f.j();
        }

        @Override // c.a.n.b
        public void m(View view) {
            m.this.f.setCustomView(view);
            this.j = new WeakReference<>(view);
        }

        @Override // c.a.n.b
        public void n(int i) {
            o(m.this.a.getResources().getString(i));
        }

        @Override // c.a.n.b
        public void o(CharSequence charSequence) {
            m.this.f.setSubtitle(charSequence);
        }

        @Override // c.a.n.b
        public void q(int i) {
            r(m.this.a.getResources().getString(i));
        }

        @Override // c.a.n.b
        public void r(CharSequence charSequence) {
            m.this.f.setTitle(charSequence);
        }

        @Override // c.a.n.b
        public void s(boolean z) {
            super.s(z);
            m.this.f.setTitleOptional(z);
        }

        public boolean t() {
            this.h.d0();
            try {
                return this.i.c(this, this.h);
            } finally {
                this.h.c0();
            }
        }
    }

    public m(Activity activity, boolean z) {
        new ArrayList();
        this.n = new ArrayList<>();
        this.p = 0;
        this.q = true;
        this.u = true;
        this.y = new a();
        this.z = new b();
        this.A = new c();
        View decorView = activity.getWindow().getDecorView();
        F(decorView);
        if (z) {
            return;
        }
        this.g = decorView.findViewById(R.id.content);
    }

    public m(Dialog dialog) {
        new ArrayList();
        this.n = new ArrayList<>();
        this.p = 0;
        this.q = true;
        this.u = true;
        this.y = new a();
        this.z = new b();
        this.A = new c();
        F(dialog.getWindow().getDecorView());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private d0 C(View view) {
        if (view instanceof d0) {
            return (d0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void E() {
        if (this.t) {
            this.t = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f101c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            M(false);
        }
    }

    private void F(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(c.a.f.decor_content_parent);
        this.f101c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f103e = C(view.findViewById(c.a.f.action_bar));
        this.f = (ActionBarContextView) view.findViewById(c.a.f.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(c.a.f.action_bar_container);
        this.f102d = actionBarContainer;
        d0 d0Var = this.f103e;
        if (d0Var == null || this.f == null || actionBarContainer == null) {
            throw new IllegalStateException(m.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.a = d0Var.getContext();
        boolean z = (this.f103e.j() & 4) != 0;
        if (z) {
            this.i = true;
        }
        c.a.n.a b2 = c.a.n.a.b(this.a);
        t(b2.a() || z);
        I(b2.g());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(null, c.a.j.ActionBar, c.a.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(c.a.j.ActionBar_hideOnContentScroll, false)) {
            J(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(c.a.j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            H(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void I(boolean z) {
        this.o = z;
        if (z) {
            this.f102d.setTabContainer(null);
            this.f103e.n(this.h);
        } else {
            this.f103e.n(null);
            this.f102d.setTabContainer(this.h);
        }
        boolean z2 = D() == 2;
        p0 p0Var = this.h;
        if (p0Var != null) {
            if (z2) {
                p0Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f101c;
                if (actionBarOverlayLayout != null) {
                    s.f0(actionBarOverlayLayout);
                }
            } else {
                p0Var.setVisibility(8);
            }
        }
        this.f103e.v(!this.o && z2);
        this.f101c.setHasNonEmbeddedTabs(!this.o && z2);
    }

    private boolean K() {
        return s.O(this.f102d);
    }

    private void L() {
        if (this.t) {
            return;
        }
        this.t = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f101c;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        M(false);
    }

    private void M(boolean z) {
        if (y(this.r, this.s, this.t)) {
            if (this.u) {
                return;
            }
            this.u = true;
            B(z);
            return;
        }
        if (this.u) {
            this.u = false;
            A(z);
        }
    }

    static boolean y(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    public void A(boolean z) {
        View view;
        c.a.n.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        if (this.p != 0 || (!this.w && !z)) {
            this.y.a(null);
            return;
        }
        this.f102d.setAlpha(1.0f);
        this.f102d.setTransitioning(true);
        c.a.n.h hVar2 = new c.a.n.h();
        float f = -this.f102d.getHeight();
        if (z) {
            this.f102d.getLocationInWindow(new int[]{0, 0});
            f -= r5[1];
        }
        w c2 = s.c(this.f102d);
        c2.k(f);
        c2.i(this.A);
        hVar2.c(c2);
        if (this.q && (view = this.g) != null) {
            w c3 = s.c(view);
            c3.k(f);
            hVar2.c(c3);
        }
        hVar2.f(B);
        hVar2.e(250L);
        hVar2.g(this.y);
        this.v = hVar2;
        hVar2.h();
    }

    public void B(boolean z) {
        View view;
        View view2;
        c.a.n.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        this.f102d.setVisibility(0);
        if (this.p == 0 && (this.w || z)) {
            this.f102d.setTranslationY(0.0f);
            float f = -this.f102d.getHeight();
            if (z) {
                this.f102d.getLocationInWindow(new int[]{0, 0});
                f -= r5[1];
            }
            this.f102d.setTranslationY(f);
            c.a.n.h hVar2 = new c.a.n.h();
            w c2 = s.c(this.f102d);
            c2.k(0.0f);
            c2.i(this.A);
            hVar2.c(c2);
            if (this.q && (view2 = this.g) != null) {
                view2.setTranslationY(f);
                w c3 = s.c(this.g);
                c3.k(0.0f);
                hVar2.c(c3);
            }
            hVar2.f(C);
            hVar2.e(250L);
            hVar2.g(this.z);
            this.v = hVar2;
            hVar2.h();
        } else {
            this.f102d.setAlpha(1.0f);
            this.f102d.setTranslationY(0.0f);
            if (this.q && (view = this.g) != null) {
                view.setTranslationY(0.0f);
            }
            this.z.a(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f101c;
        if (actionBarOverlayLayout != null) {
            s.f0(actionBarOverlayLayout);
        }
    }

    public int D() {
        return this.f103e.q();
    }

    public void G(int i, int i2) {
        int j = this.f103e.j();
        if ((i2 & 4) != 0) {
            this.i = true;
        }
        this.f103e.w((i & i2) | ((~i2) & j));
    }

    public void H(float f) {
        s.p0(this.f102d, f);
    }

    public void J(boolean z) {
        if (z && !this.f101c.w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.x = z;
        this.f101c.setHideOnContentScrollEnabled(z);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a(boolean z) {
        this.q = z;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
        if (this.s) {
            this.s = false;
            M(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c() {
        c.a.n.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
            this.v = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d(int i) {
        this.p = i;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        if (this.s) {
            return;
        }
        this.s = true;
        M(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f() {
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        d0 d0Var = this.f103e;
        if (d0Var == null || !d0Var.t()) {
            return false;
        }
        this.f103e.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z) {
        if (z == this.m) {
            return;
        }
        this.m = z;
        int size = this.n.size();
        for (int i = 0; i < size; i++) {
            this.n.get(i).a(z);
        }
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f103e.j();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        if (this.f100b == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(c.a.a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f100b = new ContextThemeWrapper(this.a, i);
            } else {
                this.f100b = this.a;
            }
        }
        return this.f100b;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        I(c.a.n.a.b(this.a).g());
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i, KeyEvent keyEvent) {
        Menu e2;
        d dVar = this.j;
        if (dVar == null || (e2 = dVar.e()) == null) {
            return false;
        }
        e2.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return e2.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z) {
        if (this.i) {
            return;
        }
        s(z);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z) {
        G(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z) {
        this.f103e.p(z);
    }

    @Override // androidx.appcompat.app.a
    public void u(boolean z) {
        c.a.n.h hVar;
        this.w = z;
        if (z || (hVar = this.v) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.a
    public void v(CharSequence charSequence) {
        this.f103e.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public c.a.n.b w(b.a aVar) {
        d dVar = this.j;
        if (dVar != null) {
            dVar.c();
        }
        this.f101c.setHideOnContentScrollEnabled(false);
        this.f.k();
        d dVar2 = new d(this.f.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.j = dVar2;
        dVar2.k();
        this.f.h(dVar2);
        x(true);
        this.f.sendAccessibilityEvent(32);
        return dVar2;
    }

    public void x(boolean z) {
        w r;
        w f;
        if (z) {
            L();
        } else {
            E();
        }
        if (!K()) {
            if (z) {
                this.f103e.k(4);
                this.f.setVisibility(0);
                return;
            } else {
                this.f103e.k(0);
                this.f.setVisibility(8);
                return;
            }
        }
        if (z) {
            f = this.f103e.r(4, 100L);
            r = this.f.f(0, 200L);
        } else {
            r = this.f103e.r(0, 200L);
            f = this.f.f(8, 100L);
        }
        c.a.n.h hVar = new c.a.n.h();
        hVar.d(f, r);
        hVar.h();
    }

    void z() {
        b.a aVar = this.l;
        if (aVar != null) {
            aVar.d(this.k);
            this.k = null;
            this.l = null;
        }
    }
}
