package kotlinx.coroutines;

/* loaded from: classes.dex */
class l0<T> extends kotlinx.coroutines.a<T> implements k0<T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    @e.m.j.a.e(c = "kotlinx.coroutines.DeferredCoroutine", f = "Builders.common.kt", l = {101}, m = "await$suspendImpl")
    /* loaded from: classes.dex */
    public static final class a extends e.m.j.a.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        a(e.m.d dVar) {
            super(dVar);
        }

        @Override // e.m.j.a.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return l0.v0(l0.this, this);
        }
    }

    public l0(e.m.g gVar, boolean z) {
        super(gVar, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object v0(kotlinx.coroutines.l0 r4, e.m.d r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.l0.a
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.l0$a r0 = (kotlinx.coroutines.l0.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.l0$a r0 = new kotlinx.coroutines.l0$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = e.m.i.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.l0 r4 = (kotlinx.coroutines.l0) r4
            e.g.b(r5)
            goto L43
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            e.g.b(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.s(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.l0.v0(kotlinx.coroutines.l0, e.m.d):java.lang.Object");
    }

    @Override // kotlinx.coroutines.k0
    public Object h(e.m.d<? super T> dVar) {
        return v0(this, dVar);
    }
}
