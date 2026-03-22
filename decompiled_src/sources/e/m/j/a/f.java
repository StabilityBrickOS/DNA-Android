package e.m.j.a;

import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class f {
    private static final void a(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }

    private static final e b(a aVar) {
        return (e) aVar.getClass().getAnnotation(e.class);
    }

    private static final int c(a aVar) {
        try {
            Field declaredField = aVar.getClass().getDeclaredField("label");
            e.p.d.i.c(declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(aVar);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(a aVar) {
        String str;
        e.p.d.i.d(aVar, "$this$getStackTraceElementImpl");
        e b2 = b(aVar);
        if (b2 == null) {
            return null;
        }
        a(1, b2.v());
        int c2 = c(aVar);
        int i = c2 < 0 ? -1 : b2.l()[c2];
        String b3 = h.f1537c.b(aVar);
        if (b3 == null) {
            str = b2.c();
        } else {
            str = b3 + '/' + b2.c();
        }
        return new StackTraceElement(str, b2.m(), b2.f(), i);
    }
}
