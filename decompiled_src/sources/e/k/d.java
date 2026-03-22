package e.k;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends c {
    public static <T> List<T> a(T[] tArr) {
        e.p.d.i.d(tArr, "$this$asList");
        List<T> a = f.a(tArr);
        e.p.d.i.c(a, "ArraysUtilJVM.asList(this)");
        return a;
    }

    public static final <T> T[] b(T[] tArr, T[] tArr2, int i, int i2, int i3) {
        e.p.d.i.d(tArr, "$this$copyInto");
        e.p.d.i.d(tArr2, "destination");
        System.arraycopy(tArr, i2, tArr2, i, i3 - i2);
        return tArr2;
    }

    public static /* synthetic */ Object[] c(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        b(objArr, objArr2, i, i2, i3);
        return objArr2;
    }

    public static final <T> void d(T[] tArr, Comparator<? super T> comparator) {
        e.p.d.i.d(tArr, "$this$sortWith");
        e.p.d.i.d(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
