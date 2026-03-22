package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.d;

/* loaded from: classes.dex */
public final class a {
    private final b a;

    /* renamed from: b, reason: collision with root package name */
    private final SavedStateRegistry f610b = new SavedStateRegistry();

    private a(b bVar) {
        this.a = bVar;
    }

    public static a a(b bVar) {
        return new a(bVar);
    }

    public SavedStateRegistry b() {
        return this.f610b;
    }

    public void c(Bundle bundle) {
        d a = this.a.a();
        if (a.b() != d.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        a.a(new Recreator(this.a));
        this.f610b.b(a, bundle);
    }

    public void d(Bundle bundle) {
        this.f610b.c(bundle);
    }
}
