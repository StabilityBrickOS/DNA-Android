package c.a.n;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContextView;
import c.a.n.b;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class e extends b implements g.a {
    private Context g;
    private ActionBarContextView h;
    private b.a i;
    private WeakReference<View> j;
    private boolean k;
    private androidx.appcompat.view.menu.g l;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.g = context;
        this.h = actionBarContextView;
        this.i = aVar;
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(actionBarContextView.getContext());
        gVar.S(1);
        this.l = gVar;
        gVar.R(this);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        return this.i.b(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void b(androidx.appcompat.view.menu.g gVar) {
        k();
        this.h.l();
    }

    @Override // c.a.n.b
    public void c() {
        if (this.k) {
            return;
        }
        this.k = true;
        this.h.sendAccessibilityEvent(32);
        this.i.d(this);
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
        return this.l;
    }

    @Override // c.a.n.b
    public MenuInflater f() {
        return new g(this.h.getContext());
    }

    @Override // c.a.n.b
    public CharSequence g() {
        return this.h.getSubtitle();
    }

    @Override // c.a.n.b
    public CharSequence i() {
        return this.h.getTitle();
    }

    @Override // c.a.n.b
    public void k() {
        this.i.a(this, this.l);
    }

    @Override // c.a.n.b
    public boolean l() {
        return this.h.j();
    }

    @Override // c.a.n.b
    public void m(View view) {
        this.h.setCustomView(view);
        this.j = view != null ? new WeakReference<>(view) : null;
    }

    @Override // c.a.n.b
    public void n(int i) {
        o(this.g.getString(i));
    }

    @Override // c.a.n.b
    public void o(CharSequence charSequence) {
        this.h.setSubtitle(charSequence);
    }

    @Override // c.a.n.b
    public void q(int i) {
        r(this.g.getString(i));
    }

    @Override // c.a.n.b
    public void r(CharSequence charSequence) {
        this.h.setTitle(charSequence);
    }

    @Override // c.a.n.b
    public void s(boolean z) {
        super.s(z);
        this.h.setTitleOptional(z);
    }
}
