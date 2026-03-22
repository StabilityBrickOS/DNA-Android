package e.k;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends l {
    public static <T> void h(List<T> list, Comparator<? super T> comparator) {
        e.p.d.i.d(list, "$this$sortWith");
        e.p.d.i.d(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
