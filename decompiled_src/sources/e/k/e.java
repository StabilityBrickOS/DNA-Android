package e.k;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends d {
    public static <T> boolean e(T[] tArr, T t) {
        e.p.d.i.d(tArr, "$this$contains");
        return f(tArr, t) >= 0;
    }

    public static final <T> int f(T[] tArr, T t) {
        e.p.d.i.d(tArr, "$this$indexOf");
        int i = 0;
        if (t == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i < length2) {
            if (e.p.d.i.a(t, tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int g(boolean[] zArr, boolean z) {
        e.p.d.i.d(zArr, "$this$indexOf");
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (z == zArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static char h(char[] cArr) {
        e.p.d.i.d(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> T i(T[] tArr) {
        e.p.d.i.d(tArr, "$this$singleOrNull");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> T[] j(T[] tArr, Comparator<? super T> comparator) {
        e.p.d.i.d(tArr, "$this$sortedArrayWith");
        e.p.d.i.d(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        e.p.d.i.c(tArr2, "java.util.Arrays.copyOf(this, size)");
        d.d(tArr2, comparator);
        return tArr2;
    }

    public static <T> List<T> k(T[] tArr, Comparator<? super T> comparator) {
        List<T> a;
        e.p.d.i.d(tArr, "$this$sortedWith");
        e.p.d.i.d(comparator, "comparator");
        a = d.a(j(tArr, comparator));
        return a;
    }
}
