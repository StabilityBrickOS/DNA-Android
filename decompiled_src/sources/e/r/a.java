package e.r;

import e.k.v;

/* loaded from: classes.dex */
public class a implements Iterable<Integer> {
    public static final C0123a h = new C0123a(null);

    /* renamed from: e, reason: collision with root package name */
    private final int f1544e;
    private final int f;
    private final int g;

    /* renamed from: e.r.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0123a {
        private C0123a() {
        }

        public /* synthetic */ C0123a(e.p.d.e eVar) {
            this();
        }

        public final a a(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f1544e = i;
        this.f = e.n.c.b(i, i2, i3);
        this.g = i3;
    }

    public final int a() {
        return this.f1544e;
    }

    public final int b() {
        return this.f;
    }

    public final int c() {
        return this.g;
    }

    @Override // java.lang.Iterable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public v iterator() {
        return new b(this.f1544e, this.f, this.g);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f1544e != aVar.f1544e || this.f != aVar.f || this.g != aVar.g) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f1544e * 31) + this.f) * 31) + this.g;
    }

    public boolean isEmpty() {
        if (this.g > 0) {
            if (this.f1544e > this.f) {
                return true;
            }
        } else if (this.f1544e < this.f) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.g > 0) {
            sb = new StringBuilder();
            sb.append(this.f1544e);
            sb.append("..");
            sb.append(this.f);
            sb.append(" step ");
            i = this.g;
        } else {
            sb = new StringBuilder();
            sb.append(this.f1544e);
            sb.append(" downTo ");
            sb.append(this.f);
            sb.append(" step ");
            i = -this.g;
        }
        sb.append(i);
        return sb.toString();
    }
}
