package androidx.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.app.e;
import androidx.lifecycle.d;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.o;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.savedstate.SavedStateRegistry;

/* loaded from: classes.dex */
public class ComponentActivity extends e implements g, s, androidx.savedstate.b, c {
    private r h;
    private int j;
    private final h f = new h(this);
    private final androidx.savedstate.a g = androidx.savedstate.a.a(this);
    private final OnBackPressedDispatcher i = new OnBackPressedDispatcher(new a());

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {
        r a;

        b() {
        }
    }

    public ComponentActivity() {
        if (a() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            a().a(new androidx.lifecycle.e() { // from class: androidx.activity.ComponentActivity.2
                @Override // androidx.lifecycle.e
                public void d(g gVar, d.a aVar) {
                    if (aVar == d.a.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View peekDecorView = window != null ? window.peekDecorView() : null;
                        if (peekDecorView != null) {
                            peekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        a().a(new androidx.lifecycle.e() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.e
            public void d(g gVar, d.a aVar) {
                if (aVar != d.a.ON_DESTROY || ComponentActivity.this.isChangingConfigurations()) {
                    return;
                }
                ComponentActivity.this.h().a();
            }
        });
        int i = Build.VERSION.SDK_INT;
        if (19 > i || i > 23) {
            return;
        }
        a().a(new ImmLeaksCleaner(this));
    }

    @Override // androidx.lifecycle.g
    public d a() {
        return this.f;
    }

    @Override // androidx.activity.c
    public final OnBackPressedDispatcher d() {
        return this.i;
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry e() {
        return this.g.b();
    }

    @Override // androidx.lifecycle.s
    public r h() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.h == null) {
            b bVar = (b) getLastNonConfigurationInstance();
            if (bVar != null) {
                this.h = bVar.a;
            }
            if (this.h == null) {
                this.h = new r();
            }
        }
        return this.h;
    }

    @Deprecated
    public Object l() {
        return null;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.i.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.g.c(bundle);
        o.e(this);
        int i = this.j;
        if (i != 0) {
            setContentView(i);
        }
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        b bVar;
        Object l = l();
        r rVar = this.h;
        if (rVar == null && (bVar = (b) getLastNonConfigurationInstance()) != null) {
            rVar = bVar.a;
        }
        if (rVar == null && l == null) {
            return null;
        }
        b bVar2 = new b();
        bVar2.a = rVar;
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.e, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        d a2 = a();
        if (a2 instanceof h) {
            ((h) a2).p(d.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.g.d(bundle);
    }
}
