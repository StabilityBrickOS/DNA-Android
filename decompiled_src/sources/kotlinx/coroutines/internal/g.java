package kotlinx.coroutines.internal;

/* loaded from: classes.dex */
public class g extends i {
    @Override // kotlinx.coroutines.internal.i
    public boolean m() {
        return false;
    }

    @Override // kotlinx.coroutines.internal.i
    public final boolean n() {
        throw new IllegalStateException("head cannot be removed".toString());
    }
}
