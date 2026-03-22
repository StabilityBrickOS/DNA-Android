package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public class f {
    private final h<?> a;

    private f(h<?> hVar) {
        this.a = hVar;
    }

    public static f b(h<?> hVar) {
        c.f.k.h.d(hVar, "callbacks == null");
        return new f(hVar);
    }

    public void a(Fragment fragment) {
        h<?> hVar = this.a;
        hVar.i.n(hVar, hVar, fragment);
    }

    public void c() {
        this.a.i.w();
    }

    public void d(Configuration configuration) {
        this.a.i.x(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.a.i.y(menuItem);
    }

    public void f() {
        this.a.i.z();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.a.i.A(menu, menuInflater);
    }

    public void h() {
        this.a.i.B();
    }

    public void i() {
        this.a.i.D();
    }

    public void j(boolean z) {
        this.a.i.E(z);
    }

    public boolean k(MenuItem menuItem) {
        return this.a.i.T(menuItem);
    }

    public void l(Menu menu) {
        this.a.i.U(menu);
    }

    public void m() {
        this.a.i.W();
    }

    public void n(boolean z) {
        this.a.i.X(z);
    }

    public boolean o(Menu menu) {
        return this.a.i.Y(menu);
    }

    public void p() {
        this.a.i.a0();
    }

    public void q() {
        this.a.i.b0();
    }

    public void r() {
        this.a.i.d0();
    }

    public boolean s() {
        return this.a.i.j0();
    }

    public Fragment t(String str) {
        return this.a.i.p0(str);
    }

    public i u() {
        return this.a.i;
    }

    public void v() {
        this.a.i.R0();
    }

    public View w(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.i.onCreateView(view, str, context, attributeSet);
    }

    public void x(Parcelable parcelable) {
        h<?> hVar = this.a;
        if (!(hVar instanceof androidx.lifecycle.s)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        hVar.i.b1(parcelable);
    }

    public Parcelable y() {
        return this.a.i.d1();
    }
}
