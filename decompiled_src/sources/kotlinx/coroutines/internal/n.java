package kotlinx.coroutines.internal;

import kotlinx.coroutines.p1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n extends p1 {
    private final Throwable f;
    private final String g;

    public n(Throwable th, String str) {
        this.f = th;
        this.g = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        if (r1 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Void s() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f
            if (r0 == 0) goto L37
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.g
            if (r1 == 0) goto L26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 == 0) goto L26
            goto L28
        L26:
            java.lang.String r1 = ""
        L28:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f
            r1.<init>(r0, r2)
            throw r1
        L37:
            kotlinx.coroutines.internal.m.c()
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.n.s():java.lang.Void");
    }

    @Override // kotlinx.coroutines.y
    public /* bridge */ /* synthetic */ void n(e.m.g gVar, Runnable runnable) {
        r(gVar, runnable);
        throw null;
    }

    @Override // kotlinx.coroutines.y
    public boolean o(e.m.g gVar) {
        s();
        throw null;
    }

    @Override // kotlinx.coroutines.p1
    public p1 p() {
        return this;
    }

    public Void r(e.m.g gVar, Runnable runnable) {
        s();
        throw null;
    }

    @Override // kotlinx.coroutines.p1, kotlinx.coroutines.y
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f != null) {
            str = ", cause=" + this.f;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }
}
