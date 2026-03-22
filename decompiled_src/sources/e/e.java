package e;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class e<A, B> implements Serializable {
    private final A first;
    private final B second;

    public e(A a, B b2) {
        this.first = a;
        this.second = b2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ e copy$default(e eVar, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = eVar.first;
        }
        if ((i & 2) != 0) {
            obj2 = eVar.second;
        }
        return eVar.copy(obj, obj2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final e<A, B> copy(A a, B b2) {
        return new e<>(a, b2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return e.p.d.i.a(this.first, eVar.first) && e.p.d.i.a(this.second, eVar.second);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public int hashCode() {
        A a = this.first;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b2 = this.second;
        return hashCode + (b2 != null ? b2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
