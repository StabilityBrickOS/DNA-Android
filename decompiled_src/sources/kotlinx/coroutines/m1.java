package kotlinx.coroutines;

/* loaded from: classes.dex */
public final class m1 {
    private static final kotlinx.coroutines.internal.r a = new kotlinx.coroutines.internal.r("COMPLETING_ALREADY");

    /* renamed from: b, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.r f1602b = new kotlinx.coroutines.internal.r("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.r f1603c = new kotlinx.coroutines.internal.r("COMPLETING_RETRY");

    /* renamed from: d, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.r f1604d = new kotlinx.coroutines.internal.r("TOO_LATE_TO_CANCEL");

    /* renamed from: e, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.r f1605e = new kotlinx.coroutines.internal.r("SEALED");
    private static final t0 f = new t0(false);
    private static final t0 g = new t0(true);

    public static final Object g(Object obj) {
        return obj instanceof c1 ? new d1((c1) obj) : obj;
    }

    public static final Object h(Object obj) {
        c1 c1Var;
        d1 d1Var = (d1) (!(obj instanceof d1) ? null : obj);
        return (d1Var == null || (c1Var = d1Var.a) == null) ? obj : c1Var;
    }
}
