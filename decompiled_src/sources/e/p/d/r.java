package e.p.d;

import e.p.c.s;
import e.p.c.t;
import e.p.c.u;
import e.p.c.v;
import e.p.c.w;

/* loaded from: classes.dex */
public class r {
    public static Object a(Object obj, int i) {
        if (obj == null || c(obj, i)) {
            return obj;
        }
        f(obj, "kotlin.jvm.functions.Function" + i);
        throw null;
    }

    public static int b(Object obj) {
        if (obj instanceof f) {
            return ((f) obj).getArity();
        }
        if (obj instanceof e.p.c.a) {
            return 0;
        }
        if (obj instanceof e.p.c.l) {
            return 1;
        }
        if (obj instanceof e.p.c.p) {
            return 2;
        }
        if (obj instanceof e.p.c.q) {
            return 3;
        }
        if (obj instanceof e.p.c.r) {
            return 4;
        }
        if (obj instanceof s) {
            return 5;
        }
        if (obj instanceof t) {
            return 6;
        }
        if (obj instanceof u) {
            return 7;
        }
        if (obj instanceof v) {
            return 8;
        }
        if (obj instanceof w) {
            return 9;
        }
        if (obj instanceof e.p.c.b) {
            return 10;
        }
        if (obj instanceof e.p.c.c) {
            return 11;
        }
        if (obj instanceof e.p.c.d) {
            return 12;
        }
        if (obj instanceof e.p.c.e) {
            return 13;
        }
        if (obj instanceof e.p.c.f) {
            return 14;
        }
        if (obj instanceof e.p.c.g) {
            return 15;
        }
        if (obj instanceof e.p.c.h) {
            return 16;
        }
        if (obj instanceof e.p.c.i) {
            return 17;
        }
        if (obj instanceof e.p.c.j) {
            return 18;
        }
        if (obj instanceof e.p.c.k) {
            return 19;
        }
        if (obj instanceof e.p.c.m) {
            return 20;
        }
        if (obj instanceof e.p.c.n) {
            return 21;
        }
        return obj instanceof e.p.c.o ? 22 : -1;
    }

    public static boolean c(Object obj, int i) {
        return (obj instanceof e.c) && b(obj) == i;
    }

    private static <T extends Throwable> T d(T t) {
        i.h(t, r.class.getName());
        return t;
    }

    public static ClassCastException e(ClassCastException classCastException) {
        d(classCastException);
        throw classCastException;
    }

    public static void f(Object obj, String str) {
        g((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
        throw null;
    }

    public static void g(String str) {
        e(new ClassCastException(str));
        throw null;
    }
}
