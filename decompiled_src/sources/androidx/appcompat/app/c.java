package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.b1;
import androidx.core.app.h;
import c.a.n.b;

/* loaded from: classes.dex */
public class c extends androidx.fragment.app.d implements d, h.a {
    private e u;
    private Resources v;

    private boolean C(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Deprecated
    public void A() {
    }

    public boolean B() {
        Intent f = f();
        if (f == null) {
            return false;
        }
        if (!F(f)) {
            E(f);
            return true;
        }
        androidx.core.app.h d2 = androidx.core.app.h.d(this);
        x(d2);
        z(d2);
        d2.e();
        try {
            androidx.core.app.a.e(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    public void D(Toolbar toolbar) {
        v().D(toolbar);
    }

    public void E(Intent intent) {
        androidx.core.app.f.e(this, intent);
    }

    public boolean F(Intent intent) {
        return androidx.core.app.f.f(this, intent);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        v().d(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(v().f(context));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        a w = w();
        if (getWindow().hasFeature(0)) {
            if (w == null || !w.g()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.core.app.e, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a w = w();
        if (keyCode == 82 && w != null && w.p(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.core.app.h.a
    public Intent f() {
        return androidx.core.app.f.a(this);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) v().i(i);
    }

    @Override // androidx.appcompat.app.d
    public void g(c.a.n.b bVar) {
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return v().l();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.v == null && b1.b()) {
            this.v = new b1(this, super.getResources());
        }
        Resources resources = this.v;
        return resources == null ? super.getResources() : resources;
    }

    @Override // androidx.appcompat.app.d
    public void i(c.a.n.b bVar) {
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        v().o();
    }

    @Override // androidx.appcompat.app.d
    public c.a.n.b j(b.a aVar) {
        return null;
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.v != null) {
            this.v.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        v().p(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        A();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        e v = v();
        v.n();
        v.q(bundle);
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        v().r();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (C(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a w = w();
        if (menuItem.getItemId() != 16908332 || w == null || (w.j() & 4) == 0) {
            return false;
        }
        return B();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        v().s(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        v().t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        v().u(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onStart() {
        super.onStart();
        v().v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onStop() {
        super.onStop();
        v().w();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        v().F(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        a w = w();
        if (getWindow().hasFeature(0)) {
            if (w == null || !w.q()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        v().A(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        v().B(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        v().C(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        v().E(i);
    }

    @Override // androidx.fragment.app.d
    public void u() {
        v().o();
    }

    public e v() {
        if (this.u == null) {
            this.u = e.g(this, this);
        }
        return this.u;
    }

    public a w() {
        return v().m();
    }

    public void x(androidx.core.app.h hVar) {
        hVar.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(int i) {
    }

    public void z(androidx.core.app.h hVar) {
    }
}
