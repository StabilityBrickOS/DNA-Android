package kotlinx.coroutines.internal;

/* loaded from: classes.dex */
public final class h {
    private static final Object a = new r("CONDITION_FALSE");

    public static final Object a() {
        return a;
    }

    public static final i b(Object obj) {
        i iVar;
        p pVar = (p) (!(obj instanceof p) ? null : obj);
        if (pVar != null && (iVar = pVar.a) != null) {
            return iVar;
        }
        if (obj != null) {
            return (i) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }
}
