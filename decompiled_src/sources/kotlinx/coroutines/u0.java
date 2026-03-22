package kotlinx.coroutines;

/* loaded from: classes.dex */
public abstract class u0 extends y {
    private long f;
    private boolean g;
    private kotlinx.coroutines.internal.a<o0<?>> h;

    private final long q(boolean z) {
        return z ? 4294967296L : 1L;
    }

    public static /* synthetic */ void u(u0 u0Var, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        u0Var.t(z);
    }

    public final void p(boolean z) {
        long q = this.f - q(z);
        this.f = q;
        if (q > 0) {
            return;
        }
        if (h0.a()) {
            if (!(this.f == 0)) {
                throw new AssertionError();
            }
        }
        if (this.g) {
            y();
        }
    }

    public final void r(o0<?> o0Var) {
        kotlinx.coroutines.internal.a<o0<?>> aVar = this.h;
        if (aVar == null) {
            aVar = new kotlinx.coroutines.internal.a<>();
            this.h = aVar;
        }
        aVar.a(o0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long s() {
        kotlinx.coroutines.internal.a<o0<?>> aVar = this.h;
        return (aVar == null || aVar.c()) ? Long.MAX_VALUE : 0L;
    }

    public final void t(boolean z) {
        this.f += q(z);
        if (z) {
            return;
        }
        this.g = true;
    }

    public final boolean v() {
        return this.f >= q(true);
    }

    public final boolean w() {
        kotlinx.coroutines.internal.a<o0<?>> aVar = this.h;
        if (aVar != null) {
            return aVar.c();
        }
        return true;
    }

    public final boolean x() {
        o0<?> d2;
        kotlinx.coroutines.internal.a<o0<?>> aVar = this.h;
        if (aVar == null || (d2 = aVar.d()) == null) {
            return false;
        }
        d2.run();
        return true;
    }

    protected void y() {
    }
}
