package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;

/* loaded from: classes.dex */
class FragmentStateAdapter$5 implements e {
    final /* synthetic */ Handler a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Runnable f617b;

    @Override // androidx.lifecycle.e
    public void d(g gVar, d.a aVar) {
        if (aVar == d.a.ON_DESTROY) {
            this.a.removeCallbacks(this.f617b);
            gVar.a().c(this);
        }
    }
}
