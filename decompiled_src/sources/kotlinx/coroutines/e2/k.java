package kotlinx.coroutines.e2;

import kotlinx.coroutines.i0;

/* loaded from: classes.dex */
public final class k extends i {
    public final Runnable g;

    public k(Runnable runnable, long j, j jVar) {
        super(j, jVar);
        this.g = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.g.run();
        } finally {
            this.f.k();
        }
    }

    public String toString() {
        return "Task[" + i0.a(this.g) + '@' + i0.b(this.g) + ", " + this.f1566e + ", " + this.f + ']';
    }
}
