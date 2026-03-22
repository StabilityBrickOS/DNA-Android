package d.a.a.a.t;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public final class b {
    private final View a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1297b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f1298c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public b(a aVar) {
        this.a = (View) aVar;
    }

    private void a() {
        ViewParent parent = this.a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).f(this.a);
        }
    }

    public int b() {
        return this.f1298c;
    }

    public boolean c() {
        return this.f1297b;
    }

    public void d(Bundle bundle) {
        this.f1297b = bundle.getBoolean("expanded", false);
        this.f1298c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f1297b) {
            a();
        }
    }

    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f1297b);
        bundle.putInt("expandedComponentIdHint", this.f1298c);
        return bundle;
    }

    public void f(int i) {
        this.f1298c = i;
    }
}
