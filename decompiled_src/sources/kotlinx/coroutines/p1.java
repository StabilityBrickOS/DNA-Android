package kotlinx.coroutines;

/* loaded from: classes.dex */
public abstract class p1 extends y {
    public abstract p1 p();

    /* JADX INFO: Access modifiers changed from: protected */
    public final String q() {
        p1 p1Var;
        p1 c2 = q0.c();
        if (this == c2) {
            return "Dispatchers.Main";
        }
        try {
            p1Var = c2.p();
        } catch (UnsupportedOperationException unused) {
            p1Var = null;
        }
        if (this == p1Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.y
    public String toString() {
        String q = q();
        if (q != null) {
            return q;
        }
        return i0.a(this) + '@' + i0.b(this);
    }
}
