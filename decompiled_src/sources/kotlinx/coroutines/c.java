package kotlinx.coroutines;

/* loaded from: classes.dex */
public final class c extends v0 {
    private final Thread k;

    public c(Thread thread) {
        this.k = thread;
    }

    @Override // kotlinx.coroutines.w0
    protected Thread z() {
        return this.k;
    }
}
