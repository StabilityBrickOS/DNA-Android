package androidx.lifecycle;

import androidx.lifecycle.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SingleGeneratedAdapterObserver implements e {
    private final c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleGeneratedAdapterObserver(c cVar) {
        this.a = cVar;
    }

    @Override // androidx.lifecycle.e
    public void d(g gVar, d.a aVar) {
        this.a.a(gVar, aVar, false, null);
        this.a.a(gVar, aVar, true, null);
    }
}
