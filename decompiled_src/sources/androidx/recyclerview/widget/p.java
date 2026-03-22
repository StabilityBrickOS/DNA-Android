package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p {
    final c.d.g<RecyclerView.c0, a> a = new c.d.g<>();

    /* renamed from: b, reason: collision with root package name */
    final c.d.d<RecyclerView.c0> f603b = new c.d.d<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d, reason: collision with root package name */
        static c.f.k.e<a> f604d = new c.f.k.f(20);
        int a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView.k.c f605b;

        /* renamed from: c, reason: collision with root package name */
        RecyclerView.k.c f606c;

        private a() {
        }

        static void a() {
            do {
            } while (f604d.b() != null);
        }

        static a b() {
            a b2 = f604d.b();
            return b2 == null ? new a() : b2;
        }

        static void c(a aVar) {
            aVar.a = 0;
            aVar.f605b = null;
            aVar.f606c = null;
            f604d.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(RecyclerView.c0 c0Var);

        void b(RecyclerView.c0 c0Var, RecyclerView.k.c cVar, RecyclerView.k.c cVar2);

        void c(RecyclerView.c0 c0Var, RecyclerView.k.c cVar, RecyclerView.k.c cVar2);

        void d(RecyclerView.c0 c0Var, RecyclerView.k.c cVar, RecyclerView.k.c cVar2);
    }

    private RecyclerView.k.c l(RecyclerView.c0 c0Var, int i) {
        a m;
        RecyclerView.k.c cVar;
        int f = this.a.f(c0Var);
        if (f >= 0 && (m = this.a.m(f)) != null) {
            int i2 = m.a;
            if ((i2 & i) != 0) {
                m.a = (~i) & i2;
                if (i == 4) {
                    cVar = m.f605b;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cVar = m.f606c;
                }
                if ((m.a & 12) == 0) {
                    this.a.k(f);
                    a.c(m);
                }
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.c0 c0Var, RecyclerView.k.c cVar) {
        a aVar = this.a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.a.put(c0Var, aVar);
        }
        aVar.a |= 2;
        aVar.f605b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.c0 c0Var) {
        a aVar = this.a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.a.put(c0Var, aVar);
        }
        aVar.a |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j, RecyclerView.c0 c0Var) {
        this.f603b.i(j, c0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(RecyclerView.c0 c0Var, RecyclerView.k.c cVar) {
        a aVar = this.a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.a.put(c0Var, aVar);
        }
        aVar.f606c = cVar;
        aVar.a |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(RecyclerView.c0 c0Var, RecyclerView.k.c cVar) {
        a aVar = this.a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.a.put(c0Var, aVar);
        }
        aVar.f605b = cVar;
        aVar.a |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.a.clear();
        this.f603b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.c0 g(long j) {
        return this.f603b.e(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(RecyclerView.c0 c0Var) {
        a aVar = this.a.get(c0Var);
        return (aVar == null || (aVar.a & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(RecyclerView.c0 c0Var) {
        a aVar = this.a.get(c0Var);
        return (aVar == null || (aVar.a & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        a.a();
    }

    public void k(RecyclerView.c0 c0Var) {
        p(c0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.k.c m(RecyclerView.c0 c0Var) {
        return l(c0Var, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.k.c n(RecyclerView.c0 c0Var) {
        return l(c0Var, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(b bVar) {
        RecyclerView.k.c cVar;
        RecyclerView.k.c cVar2;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            RecyclerView.c0 i = this.a.i(size);
            a k = this.a.k(size);
            int i2 = k.a;
            if ((i2 & 3) != 3) {
                if ((i2 & 1) != 0) {
                    cVar = k.f605b;
                    cVar2 = cVar != null ? k.f606c : null;
                } else {
                    if ((i2 & 14) != 14) {
                        if ((i2 & 12) == 12) {
                            bVar.d(i, k.f605b, k.f606c);
                        } else if ((i2 & 4) != 0) {
                            cVar = k.f605b;
                        } else if ((i2 & 8) == 0) {
                        }
                        a.c(k);
                    }
                    bVar.b(i, k.f605b, k.f606c);
                    a.c(k);
                }
                bVar.c(i, cVar, cVar2);
                a.c(k);
            }
            bVar.a(i);
            a.c(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(RecyclerView.c0 c0Var) {
        a aVar = this.a.get(c0Var);
        if (aVar == null) {
            return;
        }
        aVar.a &= -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(RecyclerView.c0 c0Var) {
        int l = this.f603b.l() - 1;
        while (true) {
            if (l < 0) {
                break;
            }
            if (c0Var == this.f603b.m(l)) {
                this.f603b.k(l);
                break;
            }
            l--;
        }
        a remove = this.a.remove(c0Var);
        if (remove != null) {
            a.c(remove);
        }
    }
}
