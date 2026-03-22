package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.x0;
import c.f.l.s;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends androidx.appcompat.app.a {
    d0 a;

    /* renamed from: b, reason: collision with root package name */
    boolean f83b;

    /* renamed from: c, reason: collision with root package name */
    Window.Callback f84c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f85d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f86e;
    private ArrayList<a.b> f = new ArrayList<>();
    private final Runnable g = new a();
    private final Toolbar.f h = new b();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.z();
        }
    }

    /* loaded from: classes.dex */
    class b implements Toolbar.f {
        b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.f
        public boolean onMenuItemClick(MenuItem menuItem) {
            return j.this.f84c.onMenuItemSelected(0, menuItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c implements m.a {

        /* renamed from: e, reason: collision with root package name */
        private boolean f88e;

        c() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            if (this.f88e) {
                return;
            }
            this.f88e = true;
            j.this.a.h();
            Window.Callback callback = j.this.f84c;
            if (callback != null) {
                callback.onPanelClosed(108, gVar);
            }
            this.f88e = false;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            Window.Callback callback = j.this.f84c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, gVar);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class d implements g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            j jVar = j.this;
            if (jVar.f84c != null) {
                if (jVar.a.c()) {
                    j.this.f84c.onPanelClosed(108, gVar);
                } else if (j.this.f84c.onPreparePanel(0, null, gVar)) {
                    j.this.f84c.onMenuOpened(108, gVar);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private class e extends c.a.n.i {
        public e(Window.Callback callback) {
            super(callback);
        }

        @Override // c.a.n.i, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            return i == 0 ? new View(j.this.a.getContext()) : super.onCreatePanelView(i);
        }

        @Override // c.a.n.i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel) {
                j jVar = j.this;
                if (!jVar.f83b) {
                    jVar.a.f();
                    j.this.f83b = true;
                }
            }
            return onPreparePanel;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.a = new x0(toolbar, false);
        e eVar = new e(callback);
        this.f84c = eVar;
        this.a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(this.h);
        this.a.setWindowTitle(charSequence);
    }

    private Menu x() {
        if (!this.f85d) {
            this.a.i(new c(), new d());
            this.f85d = true;
        }
        return this.a.l();
    }

    public void A(int i, int i2) {
        this.a.w((i & i2) | ((~i2) & this.a.j()));
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        return this.a.d();
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        if (!this.a.t()) {
            return false;
        }
        this.a.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z) {
        if (z == this.f86e) {
            return;
        }
        this.f86e = z;
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            this.f.get(i).a(z);
        }
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.a.j();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        return this.a.getContext();
    }

    @Override // androidx.appcompat.app.a
    public boolean l() {
        this.a.o().removeCallbacks(this.g);
        s.a0(this.a.o(), this.g);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        super.m(configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.app.a
    public void n() {
        this.a.o().removeCallbacks(this.g);
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i, KeyEvent keyEvent) {
        Menu x = x();
        if (x == null) {
            return false;
        }
        x.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return x.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean q() {
        return this.a.e();
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z) {
        A(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void u(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void v(CharSequence charSequence) {
        this.a.setWindowTitle(charSequence);
    }

    public Window.Callback y() {
        return this.f84c;
    }

    void z() {
        Menu x = x();
        androidx.appcompat.view.menu.g gVar = x instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) x : null;
        if (gVar != null) {
            gVar.d0();
        }
        try {
            x.clear();
            if (!this.f84c.onCreatePanelMenu(0, x) || !this.f84c.onPreparePanel(0, null, x)) {
                x.clear();
            }
        } finally {
            if (gVar != null) {
                gVar.c0();
            }
        }
    }
}
