package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements e {
    private final Object a;

    /* renamed from: b, reason: collision with root package name */
    private final a.C0012a f441b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
        this.f441b = a.f442c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.e
    public void d(g gVar, d.a aVar) {
        this.f441b.a(gVar, aVar, this.a);
    }
}
