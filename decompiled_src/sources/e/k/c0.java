package e.k;

import java.util.Set;

/* loaded from: classes.dex */
class c0 extends b0 {
    public static final <T> Set<T> b() {
        return u.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> c(Set<? extends T> set) {
        e.p.d.i.d(set, "$this$optimizeReadOnlySet");
        int size = set.size();
        return size != 0 ? size != 1 ? set : b0.a(set.iterator().next()) : b();
    }
}
