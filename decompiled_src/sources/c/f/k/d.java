package c.f.k;

/* loaded from: classes.dex */
public class d<F, S> {
    public final F a;

    /* renamed from: b, reason: collision with root package name */
    public final S f779b;

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a(dVar.a, this.a) && c.a(dVar.f779b, this.f779b);
    }

    public int hashCode() {
        F f = this.a;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.f779b;
        return hashCode ^ (s != null ? s.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.a) + " " + String.valueOf(this.f779b) + "}";
    }
}
