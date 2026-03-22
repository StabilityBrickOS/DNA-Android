package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;

/* loaded from: classes.dex */
public class x0 implements d0 {
    Toolbar a;

    /* renamed from: b, reason: collision with root package name */
    private int f284b;

    /* renamed from: c, reason: collision with root package name */
    private View f285c;

    /* renamed from: d, reason: collision with root package name */
    private View f286d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f287e;
    private Drawable f;
    private Drawable g;
    private boolean h;
    CharSequence i;
    private CharSequence j;
    private CharSequence k;
    Window.Callback l;
    boolean m;
    private c n;
    private int o;
    private int p;
    private Drawable q;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final androidx.appcompat.view.menu.a f288e;

        a() {
            this.f288e = new androidx.appcompat.view.menu.a(x0.this.a.getContext(), 0, R.id.home, 0, 0, x0.this.i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            x0 x0Var = x0.this;
            Window.Callback callback = x0Var.l;
            if (callback == null || !x0Var.m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f288e);
        }
    }

    /* loaded from: classes.dex */
    class b extends c.f.l.y {
        private boolean a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f289b;

        b(int i) {
            this.f289b = i;
        }

        @Override // c.f.l.x
        public void a(View view) {
            if (this.a) {
                return;
            }
            x0.this.a.setVisibility(this.f289b);
        }

        @Override // c.f.l.y, c.f.l.x
        public void b(View view) {
            x0.this.a.setVisibility(0);
        }

        @Override // c.f.l.y, c.f.l.x
        public void c(View view) {
            this.a = true;
        }
    }

    public x0(Toolbar toolbar, boolean z) {
        this(toolbar, z, c.a.h.abc_action_bar_up_description, c.a.e.abc_ic_ab_back_material);
    }

    public x0(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        w0 v = w0.v(toolbar.getContext(), null, c.a.j.ActionBar, c.a.a.actionBarStyle, 0);
        this.q = v.g(c.a.j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence p = v.p(c.a.j.ActionBar_title);
            if (!TextUtils.isEmpty(p)) {
                F(p);
            }
            CharSequence p2 = v.p(c.a.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(p2)) {
                E(p2);
            }
            Drawable g = v.g(c.a.j.ActionBar_logo);
            if (g != null) {
                A(g);
            }
            Drawable g2 = v.g(c.a.j.ActionBar_icon);
            if (g2 != null) {
                setIcon(g2);
            }
            if (this.g == null && (drawable = this.q) != null) {
                D(drawable);
            }
            w(v.k(c.a.j.ActionBar_displayOptions, 0));
            int n = v.n(c.a.j.ActionBar_customNavigationLayout, 0);
            if (n != 0) {
                y(LayoutInflater.from(this.a.getContext()).inflate(n, (ViewGroup) this.a, false));
                w(this.f284b | 16);
            }
            int m = v.m(c.a.j.ActionBar_height, 0);
            if (m > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = m;
                this.a.setLayoutParams(layoutParams);
            }
            int e2 = v.e(c.a.j.ActionBar_contentInsetStart, -1);
            int e3 = v.e(c.a.j.ActionBar_contentInsetEnd, -1);
            if (e2 >= 0 || e3 >= 0) {
                this.a.H(Math.max(e2, 0), Math.max(e3, 0));
            }
            int n2 = v.n(c.a.j.ActionBar_titleTextStyle, 0);
            if (n2 != 0) {
                Toolbar toolbar2 = this.a;
                toolbar2.L(toolbar2.getContext(), n2);
            }
            int n3 = v.n(c.a.j.ActionBar_subtitleTextStyle, 0);
            if (n3 != 0) {
                Toolbar toolbar3 = this.a;
                toolbar3.K(toolbar3.getContext(), n3);
            }
            int n4 = v.n(c.a.j.ActionBar_popupTheme, 0);
            if (n4 != 0) {
                this.a.setPopupTheme(n4);
            }
        } else {
            this.f284b = x();
        }
        v.w();
        z(i);
        this.k = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new a());
    }

    private void G(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.f284b & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    private void H() {
        if ((this.f284b & 4) != 0) {
            if (TextUtils.isEmpty(this.k)) {
                this.a.setNavigationContentDescription(this.p);
            } else {
                this.a.setNavigationContentDescription(this.k);
            }
        }
    }

    private void I() {
        Toolbar toolbar;
        Drawable drawable;
        if ((this.f284b & 4) != 0) {
            toolbar = this.a;
            drawable = this.g;
            if (drawable == null) {
                drawable = this.q;
            }
        } else {
            toolbar = this.a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void J() {
        Drawable drawable;
        int i = this.f284b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f) == null) {
            drawable = this.f287e;
        }
        this.a.setLogo(drawable);
    }

    private int x() {
        if (this.a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.a.getNavigationIcon();
        return 15;
    }

    public void A(Drawable drawable) {
        this.f = drawable;
        J();
    }

    public void B(int i) {
        C(i == 0 ? null : getContext().getString(i));
    }

    public void C(CharSequence charSequence) {
        this.k = charSequence;
        H();
    }

    public void D(Drawable drawable) {
        this.g = drawable;
        I();
    }

    public void E(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.f284b & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    public void F(CharSequence charSequence) {
        this.h = true;
        G(charSequence);
    }

    @Override // androidx.appcompat.widget.d0
    public void a(Menu menu, m.a aVar) {
        if (this.n == null) {
            c cVar = new c(this.a.getContext());
            this.n = cVar;
            cVar.p(c.a.f.action_menu_presenter);
        }
        this.n.h(aVar);
        this.a.I((androidx.appcompat.view.menu.g) menu, this.n);
    }

    @Override // androidx.appcompat.widget.d0
    public boolean b() {
        return this.a.z();
    }

    @Override // androidx.appcompat.widget.d0
    public boolean c() {
        return this.a.A();
    }

    @Override // androidx.appcompat.widget.d0
    public void collapseActionView() {
        this.a.e();
    }

    @Override // androidx.appcompat.widget.d0
    public boolean d() {
        return this.a.w();
    }

    @Override // androidx.appcompat.widget.d0
    public boolean e() {
        return this.a.O();
    }

    @Override // androidx.appcompat.widget.d0
    public void f() {
        this.m = true;
    }

    @Override // androidx.appcompat.widget.d0
    public boolean g() {
        return this.a.d();
    }

    @Override // androidx.appcompat.widget.d0
    public Context getContext() {
        return this.a.getContext();
    }

    @Override // androidx.appcompat.widget.d0
    public CharSequence getTitle() {
        return this.a.getTitle();
    }

    @Override // androidx.appcompat.widget.d0
    public void h() {
        this.a.f();
    }

    @Override // androidx.appcompat.widget.d0
    public void i(m.a aVar, g.a aVar2) {
        this.a.J(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.d0
    public int j() {
        return this.f284b;
    }

    @Override // androidx.appcompat.widget.d0
    public void k(int i) {
        this.a.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.d0
    public Menu l() {
        return this.a.getMenu();
    }

    @Override // androidx.appcompat.widget.d0
    public void m(int i) {
        A(i != 0 ? c.a.k.a.a.d(getContext(), i) : null);
    }

    @Override // androidx.appcompat.widget.d0
    public void n(p0 p0Var) {
        View view = this.f285c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.a;
            if (parent == toolbar) {
                toolbar.removeView(this.f285c);
            }
        }
        this.f285c = p0Var;
        if (p0Var == null || this.o != 2) {
            return;
        }
        this.a.addView(p0Var, 0);
        Toolbar.e eVar = (Toolbar.e) this.f285c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) eVar).width = -2;
        ((ViewGroup.MarginLayoutParams) eVar).height = -2;
        eVar.a = 8388691;
        p0Var.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.d0
    public ViewGroup o() {
        return this.a;
    }

    @Override // androidx.appcompat.widget.d0
    public void p(boolean z) {
    }

    @Override // androidx.appcompat.widget.d0
    public int q() {
        return this.o;
    }

    @Override // androidx.appcompat.widget.d0
    public c.f.l.w r(int i, long j) {
        c.f.l.w c2 = c.f.l.s.c(this.a);
        c2.a(i == 0 ? 1.0f : 0.0f);
        c2.d(j);
        c2.f(new b(i));
        return c2;
    }

    @Override // androidx.appcompat.widget.d0
    public void s() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.d0
    public void setIcon(int i) {
        setIcon(i != 0 ? c.a.k.a.a.d(getContext(), i) : null);
    }

    @Override // androidx.appcompat.widget.d0
    public void setIcon(Drawable drawable) {
        this.f287e = drawable;
        J();
    }

    @Override // androidx.appcompat.widget.d0
    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    @Override // androidx.appcompat.widget.d0
    public void setWindowTitle(CharSequence charSequence) {
        if (this.h) {
            return;
        }
        G(charSequence);
    }

    @Override // androidx.appcompat.widget.d0
    public boolean t() {
        return this.a.v();
    }

    @Override // androidx.appcompat.widget.d0
    public void u() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.d0
    public void v(boolean z) {
        this.a.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.d0
    public void w(int i) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i2 = this.f284b ^ i;
        this.f284b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    H();
                }
                I();
            }
            if ((i2 & 3) != 0) {
                J();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.a.setTitle(this.i);
                    toolbar = this.a;
                    charSequence = this.j;
                } else {
                    charSequence = null;
                    this.a.setTitle((CharSequence) null);
                    toolbar = this.a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i2 & 16) == 0 || (view = this.f286d) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.a.addView(view);
            } else {
                this.a.removeView(view);
            }
        }
    }

    public void y(View view) {
        View view2 = this.f286d;
        if (view2 != null && (this.f284b & 16) != 0) {
            this.a.removeView(view2);
        }
        this.f286d = view;
        if (view == null || (this.f284b & 16) == 0) {
            return;
        }
        this.a.addView(view);
    }

    public void z(int i) {
        if (i == this.p) {
            return;
        }
        this.p = i;
        if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
            B(this.p);
        }
    }
}
