package e.k;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
class b0 {
    public static final <T> Set<T> a(T t) {
        Set<T> singleton = Collections.singleton(t);
        e.p.d.i.c(singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }
}
