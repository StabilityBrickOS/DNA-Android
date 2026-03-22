package kotlinx.coroutines;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t0 implements c1 {

    /* renamed from: e, reason: collision with root package name */
    private final boolean f1613e;

    public t0(boolean z) {
        this.f1613e = z;
    }

    @Override // kotlinx.coroutines.c1
    public boolean a() {
        return this.f1613e;
    }

    @Override // kotlinx.coroutines.c1
    public q1 c() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(a() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
