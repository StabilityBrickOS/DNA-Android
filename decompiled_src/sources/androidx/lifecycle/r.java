package androidx.lifecycle;

import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class r {
    private final HashMap<String, p> a = new HashMap<>();

    public final void a() {
        Iterator<p> it = this.a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final p b(String str) {
        return this.a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(String str, p pVar) {
        p put = this.a.put(str, pVar);
        if (put != null) {
            put.c();
        }
    }
}
