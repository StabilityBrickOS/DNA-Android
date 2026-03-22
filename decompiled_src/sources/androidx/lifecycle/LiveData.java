package androidx.lifecycle;

import androidx.lifecycle.d;

/* loaded from: classes.dex */
public abstract class LiveData<T> {
    static final Object i = new Object();
    final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private c.b.a.b.b<m<? super T>, LiveData<T>.a> f433b = new c.b.a.b.b<>();

    /* renamed from: c, reason: collision with root package name */
    int f434c = 0;

    /* renamed from: d, reason: collision with root package name */
    private volatile Object f435d = i;

    /* renamed from: e, reason: collision with root package name */
    volatile Object f436e = i;
    private int f = -1;
    private boolean g;
    private boolean h;

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends LiveData<T>.a implements Object {

        /* renamed from: e, reason: collision with root package name */
        final g f437e;

        LifecycleBoundObserver(g gVar, m<? super T> mVar) {
            super(mVar);
            this.f437e = gVar;
        }

        public void d(g gVar, d.a aVar) {
            if (this.f437e.a().b() == d.b.DESTROYED) {
                LiveData.this.i(this.a);
            } else {
                h(k());
            }
        }

        @Override // androidx.lifecycle.LiveData.a
        void i() {
            this.f437e.a().c(this);
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean j(g gVar) {
            return this.f437e == gVar;
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean k() {
            return this.f437e.a().b().isAtLeast(d.b.STARTED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class a {
        final m<? super T> a;

        /* renamed from: b, reason: collision with root package name */
        boolean f438b;

        /* renamed from: c, reason: collision with root package name */
        int f439c = -1;

        a(m<? super T> mVar) {
            this.a = mVar;
        }

        void h(boolean z) {
            if (z == this.f438b) {
                return;
            }
            this.f438b = z;
            boolean z2 = LiveData.this.f434c == 0;
            LiveData.this.f434c += this.f438b ? 1 : -1;
            if (z2 && this.f438b) {
                LiveData.this.g();
            }
            LiveData liveData = LiveData.this;
            if (liveData.f434c == 0 && !this.f438b) {
                liveData.h();
            }
            if (this.f438b) {
                LiveData.this.c(this);
            }
        }

        void i() {
        }

        boolean j(g gVar) {
            return false;
        }

        abstract boolean k();
    }

    private static void a(String str) {
        if (c.b.a.a.a.b().a()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void b(LiveData<T>.a aVar) {
        if (aVar.f438b) {
            if (!aVar.k()) {
                aVar.h(false);
                return;
            }
            int i2 = aVar.f439c;
            int i3 = this.f;
            if (i2 >= i3) {
                return;
            }
            aVar.f439c = i3;
            aVar.a.a((Object) this.f435d);
        }
    }

    void c(LiveData<T>.a aVar) {
        if (this.g) {
            this.h = true;
            return;
        }
        this.g = true;
        do {
            this.h = false;
            if (aVar != null) {
                b(aVar);
                aVar = null;
            } else {
                c.b.a.b.b<m<? super T>, LiveData<T>.a>.d d2 = this.f433b.d();
                while (d2.hasNext()) {
                    b((a) d2.next().getValue());
                    if (this.h) {
                        break;
                    }
                }
            }
        } while (this.h);
        this.g = false;
    }

    public T d() {
        T t = (T) this.f435d;
        if (t != i) {
            return t;
        }
        return null;
    }

    public boolean e() {
        return this.f434c > 0;
    }

    public void f(g gVar, m<? super T> mVar) {
        a("observe");
        if (gVar.a().b() == d.b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(gVar, mVar);
        LiveData<T>.a g = this.f433b.g(mVar, lifecycleBoundObserver);
        if (g != null && !g.j(gVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (g != null) {
            return;
        }
        gVar.a().a(lifecycleBoundObserver);
    }

    protected void g() {
    }

    protected void h() {
    }

    public void i(m<? super T> mVar) {
        a("removeObserver");
        LiveData<T>.a h = this.f433b.h(mVar);
        if (h == null) {
            return;
        }
        h.i();
        h.h(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(T t) {
        a("setValue");
        this.f++;
        this.f435d = t;
        c(null);
    }
}
