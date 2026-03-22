package e.n;

import e.p.d.i;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e.n.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0121a {
        public static final Method a;

        /* JADX WARN: Removed duplicated region for block: B:10:0x003e A[LOOP:0: B:2:0x000e->B:10:0x003e, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0042 A[EDGE_INSN: B:11:0x0042->B:12:0x0042 BREAK  A[LOOP:0: B:2:0x000e->B:10:0x003e], SYNTHETIC] */
        static {
            /*
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                e.p.d.i.c(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            Le:
                java.lang.String r5 = "it"
                if (r4 >= r2) goto L41
                r6 = r1[r4]
                e.p.d.i.c(r6, r5)
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = e.p.d.i.a(r7, r8)
                if (r7 == 0) goto L3a
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "it.parameterTypes"
                e.p.d.i.c(r7, r8)
                java.lang.Object r7 = e.k.a.i(r7)
                java.lang.Class r7 = (java.lang.Class) r7
                boolean r7 = e.p.d.i.a(r7, r0)
                if (r7 == 0) goto L3a
                r7 = 1
                goto L3b
            L3a:
                r7 = 0
            L3b:
                if (r7 == 0) goto L3e
                goto L42
            L3e:
                int r4 = r4 + 1
                goto Le
            L41:
                r6 = 0
            L42:
                e.n.a.C0121a.a = r6
                int r0 = r1.length
            L45:
                if (r3 >= r0) goto L5c
                r2 = r1[r3]
                e.p.d.i.c(r2, r5)
                java.lang.String r2 = r2.getName()
                java.lang.String r4 = "getSuppressed"
                boolean r2 = e.p.d.i.a(r2, r4)
                if (r2 == 0) goto L59
                goto L5c
            L59:
                int r3 = r3 + 1
                goto L45
            L5c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e.n.a.C0121a.<clinit>():void");
        }
    }

    public void a(Throwable th, Throwable th2) {
        i.d(th, "cause");
        i.d(th2, "exception");
        Method method = C0121a.a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public e.q.c b() {
        return new e.q.b();
    }
}
