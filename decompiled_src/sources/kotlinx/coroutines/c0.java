package kotlinx.coroutines;

import e.m.g;

/* loaded from: classes.dex */
public final class c0 extends e.m.a {
    public static final a f = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private final String f1559e;

    /* loaded from: classes.dex */
    public static final class a implements g.c<c0> {
        private a() {
        }

        public /* synthetic */ a(e.p.d.e eVar) {
            this();
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof c0) && e.p.d.i.a(this.f1559e, ((c0) obj).f1559e);
        }
        return true;
    }

    public int hashCode() {
        String str = this.f1559e;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String n() {
        return this.f1559e;
    }

    public String toString() {
        return "CoroutineName(" + this.f1559e + ')';
    }
}
