package e.r;

/* loaded from: classes.dex */
public final class c extends e.r.a {
    public static final a j = new a(null);
    private static final c i = new c(1, 0);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e.p.d.e eVar) {
            this();
        }

        public final c a() {
            return c.i;
        }
    }

    public c(int i2, int i3) {
        super(i2, i3, 1);
    }

    @Override // e.r.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (a() != cVar.a() || b() != cVar.b()) {
                }
            }
            return true;
        }
        return false;
    }

    public Integer f() {
        return Integer.valueOf(b());
    }

    public Integer g() {
        return Integer.valueOf(a());
    }

    @Override // e.r.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // e.r.a
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // e.r.a
    public String toString() {
        return a() + ".." + b();
    }
}
