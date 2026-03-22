package kotlinx.coroutines;

import kotlinx.coroutines.h1;

/* loaded from: classes.dex */
public abstract class k1<J extends h1> extends u implements r0, c1 {
    public final J h;

    public k1(J j) {
        this.h = j;
    }

    @Override // kotlinx.coroutines.c1
    public boolean a() {
        return true;
    }

    @Override // kotlinx.coroutines.r0
    public void b() {
        J j = this.h;
        if (j == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
        }
        ((l1) j).d0(this);
    }

    @Override // kotlinx.coroutines.c1
    public q1 c() {
        return null;
    }
}
