package kotlinx.coroutines;

import e.m.g;
import kotlinx.coroutines.w1;

/* loaded from: classes.dex */
public final class b0 extends e.m.a implements w1<String> {
    public static final a f = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private final long f1557e;

    /* loaded from: classes.dex */
    public static final class a implements g.c<b0> {
        private a() {
        }

        public /* synthetic */ a(e.p.d.e eVar) {
            this();
        }
    }

    public b0(long j) {
        super(f);
        this.f1557e = j;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof b0) && this.f1557e == ((b0) obj).f1557e;
        }
        return true;
    }

    @Override // e.m.a, e.m.g
    public <R> R fold(R r, e.p.c.p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) w1.a.a(this, r, pVar);
    }

    @Override // e.m.a, e.m.g.b, e.m.g
    public <E extends g.b> E get(g.c<E> cVar) {
        return (E) w1.a.b(this, cVar);
    }

    public int hashCode() {
        long j = this.f1557e;
        return (int) (j ^ (j >>> 32));
    }

    @Override // e.m.a, e.m.g
    public e.m.g minusKey(g.c<?> cVar) {
        return w1.a.c(this, cVar);
    }

    public final long n() {
        return this.f1557e;
    }

    @Override // kotlinx.coroutines.w1
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(e.m.g gVar, String str) {
        Thread.currentThread().setName(str);
    }

    @Override // kotlinx.coroutines.w1
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public String l(e.m.g gVar) {
        String str;
        int A;
        c0 c0Var = (c0) gVar.get(c0.f);
        if (c0Var == null || (str = c0Var.n()) == null) {
            str = "coroutine";
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        A = e.u.v.A(name, " @", 0, false, 6, null);
        if (A < 0) {
            A = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + A + 10);
        if (name == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = name.substring(0, A);
        e.p.d.i.c(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(" @");
        sb.append(str);
        sb.append('#');
        sb.append(this.f1557e);
        e.j jVar = e.j.a;
        String sb2 = sb.toString();
        e.p.d.i.c(sb2, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(sb2);
        return name;
    }

    @Override // e.m.a, e.m.g
    public e.m.g plus(e.m.g gVar) {
        return w1.a.d(this, gVar);
    }

    public String toString() {
        return "CoroutineId(" + this.f1557e + ')';
    }
}
