package androidx.fragment.app;

import androidx.lifecycle.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements androidx.lifecycle.g {

    /* renamed from: e, reason: collision with root package name */
    private androidx.lifecycle.h f431e = null;

    @Override // androidx.lifecycle.g
    public androidx.lifecycle.d a() {
        c();
        return this.f431e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d.a aVar) {
        this.f431e.i(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.f431e == null) {
            this.f431e = new androidx.lifecycle.h(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.f431e != null;
    }
}
