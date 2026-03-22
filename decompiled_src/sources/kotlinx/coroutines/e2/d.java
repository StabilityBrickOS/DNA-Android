package kotlinx.coroutines.e2;

import java.util.concurrent.RejectedExecutionException;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.z0;

/* loaded from: classes.dex */
public class d extends z0 {
    private b f;
    private final int g;
    private final int h;
    private final long i;
    private final String j;

    public d(int i, int i2, long j, String str) {
        this.g = i;
        this.h = i2;
        this.i = j;
        this.j = str;
        this.f = p();
    }

    public d(int i, int i2, String str) {
        this(i, i2, l.f1569d, str);
    }

    public /* synthetic */ d(int i, int i2, String str, int i3, e.p.d.e eVar) {
        this((i3 & 1) != 0 ? l.f1567b : i, (i3 & 2) != 0 ? l.f1568c : i2, (i3 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    private final b p() {
        return new b(this.g, this.h, this.i, this.j);
    }

    @Override // kotlinx.coroutines.y
    public void n(e.m.g gVar, Runnable runnable) {
        try {
            b.g(this.f, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            j0.l.n(gVar, runnable);
        }
    }

    public final void q(Runnable runnable, j jVar, boolean z) {
        try {
            this.f.f(runnable, jVar, z);
        } catch (RejectedExecutionException unused) {
            j0.l.F(this.f.d(runnable, jVar));
        }
    }
}
