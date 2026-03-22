package kotlinx.coroutines;

/* loaded from: classes.dex */
public final class x {
    private static final boolean a;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0028, code lost:
    
        if (r0.equals("on") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        if (r0.equals("") != false) goto L19;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = kotlinx.coroutines.internal.s.d(r0)
            if (r0 != 0) goto L9
            goto L33
        L9:
            int r1 = r0.hashCode()
            if (r1 == 0) goto L2b
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L22
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L37
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
            r0 = 0
            goto L34
        L22:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
            goto L33
        L2b:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
        L33:
            r0 = 1
        L34:
            kotlinx.coroutines.x.a = r0
            return
        L37:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.x.<clinit>():void");
    }

    public static final y a() {
        return a ? kotlinx.coroutines.e2.c.l : p.h;
    }

    public static final String b(e.m.g gVar) {
        b0 b0Var;
        String str;
        if (!h0.c() || (b0Var = (b0) gVar.get(b0.f)) == null) {
            return null;
        }
        c0 c0Var = (c0) gVar.get(c0.f);
        if (c0Var == null || (str = c0Var.n()) == null) {
            str = "coroutine";
        }
        return str + '#' + b0Var.n();
    }

    public static final e.m.g c(d0 d0Var, e.m.g gVar) {
        e.m.g plus = d0Var.g().plus(gVar);
        e.m.g plus2 = h0.c() ? plus.plus(new b0(h0.b().incrementAndGet())) : plus;
        return (plus == q0.a() || plus.get(e.m.e.f1534b) != null) ? plus2 : plus2.plus(q0.a());
    }
}
