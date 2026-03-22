package e.k;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends h {
    public static <T> List<T> b() {
        return s.INSTANCE;
    }

    public static final <T> int c(List<? extends T> list) {
        e.p.d.i.d(list, "$this$lastIndex");
        return list.size() - 1;
    }

    public static <T> List<T> d(T... tArr) {
        List<T> b2;
        List<T> a;
        e.p.d.i.d(tArr, "elements");
        if (tArr.length > 0) {
            a = d.a(tArr);
            return a;
        }
        b2 = b();
        return b2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> e(List<? extends T> list) {
        List<T> b2;
        List<T> a;
        e.p.d.i.d(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size == 0) {
            b2 = b();
            return b2;
        }
        if (size != 1) {
            return list;
        }
        a = h.a(list.get(0));
        return a;
    }

    public static void f() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
