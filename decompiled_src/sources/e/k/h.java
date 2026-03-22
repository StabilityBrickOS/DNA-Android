package e.k;

import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h {
    public static <T> List<T> a(T t) {
        List<T> singletonList = Collections.singletonList(t);
        e.p.d.i.c(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }
}
