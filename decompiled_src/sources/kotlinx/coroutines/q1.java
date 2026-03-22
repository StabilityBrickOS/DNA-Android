package kotlinx.coroutines;

/* loaded from: classes.dex */
public final class q1 extends kotlinx.coroutines.internal.g implements c1 {
    @Override // kotlinx.coroutines.c1
    public boolean a() {
        return true;
    }

    @Override // kotlinx.coroutines.c1
    public q1 c() {
        return this;
    }

    public final String r(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        Object j = j();
        if (j == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        boolean z = true;
        for (kotlinx.coroutines.internal.i iVar = (kotlinx.coroutines.internal.i) j; !e.p.d.i.a(iVar, this); iVar = iVar.k()) {
            if (iVar instanceof k1) {
                k1 k1Var = (k1) iVar;
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                sb.append(k1Var);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        e.p.d.i.c(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Override // kotlinx.coroutines.internal.i
    public String toString() {
        return h0.c() ? r("Active") : super.toString();
    }
}
