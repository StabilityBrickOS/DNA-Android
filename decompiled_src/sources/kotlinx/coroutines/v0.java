package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class v0 extends w0 {
    private static final AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(v0.class, Object.class, "_queue");
    private static final AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(v0.class, Object.class, "_delayed");
    private volatile Object _queue = null;
    private volatile Object _delayed = null;
    private volatile int _isCompleted = 0;

    /* loaded from: classes.dex */
    public static abstract class a implements Runnable, Comparable<a>, r0, kotlinx.coroutines.internal.x {

        /* renamed from: e, reason: collision with root package name */
        private Object f1614e;
        private int f;
        public long g;

        @Override // kotlinx.coroutines.internal.x
        public void a(int i) {
            this.f = i;
        }

        @Override // kotlinx.coroutines.r0
        public final synchronized void b() {
            kotlinx.coroutines.internal.r rVar;
            kotlinx.coroutines.internal.r rVar2;
            Object obj = this.f1614e;
            rVar = y0.a;
            if (obj == rVar) {
                return;
            }
            if (!(obj instanceof b)) {
                obj = null;
            }
            b bVar = (b) obj;
            if (bVar != null) {
                bVar.g(this);
            }
            rVar2 = y0.a;
            this.f1614e = rVar2;
        }

        @Override // kotlinx.coroutines.internal.x
        public void c(kotlinx.coroutines.internal.w<?> wVar) {
            kotlinx.coroutines.internal.r rVar;
            Object obj = this.f1614e;
            rVar = y0.a;
            if (!(obj != rVar)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.f1614e = wVar;
        }

        @Override // kotlinx.coroutines.internal.x
        public kotlinx.coroutines.internal.w<?> e() {
            Object obj = this.f1614e;
            if (!(obj instanceof kotlinx.coroutines.internal.w)) {
                obj = null;
            }
            return (kotlinx.coroutines.internal.w) obj;
        }

        @Override // kotlinx.coroutines.internal.x
        public int f() {
            return this.f;
        }

        @Override // java.lang.Comparable
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            long j = this.g - aVar.g;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0040 A[Catch: all -> 0x004a, TryCatch #0 {, blocks: (B:11:0x000d, B:19:0x0021, B:20:0x0037, B:22:0x0040, B:23:0x0044, B:27:0x0024, B:30:0x002e), top: B:10:0x000d, outer: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final synchronized int h(long r8, kotlinx.coroutines.v0.b r10, kotlinx.coroutines.v0 r11) {
            /*
                r7 = this;
                monitor-enter(r7)
                java.lang.Object r0 = r7.f1614e     // Catch: java.lang.Throwable -> L4d
                kotlinx.coroutines.internal.r r1 = kotlinx.coroutines.y0.b()     // Catch: java.lang.Throwable -> L4d
                if (r0 != r1) goto Lc
                r8 = 2
            La:
                monitor-exit(r7)
                return r8
            Lc:
                monitor-enter(r10)     // Catch: java.lang.Throwable -> L4d
                kotlinx.coroutines.internal.x r0 = r10.b()     // Catch: java.lang.Throwable -> L4a
                kotlinx.coroutines.v0$a r0 = (kotlinx.coroutines.v0.a) r0     // Catch: java.lang.Throwable -> L4a
                boolean r11 = kotlinx.coroutines.v0.C(r11)     // Catch: java.lang.Throwable -> L4a
                if (r11 == 0) goto L1d
                r8 = 1
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4d
                monitor-exit(r7)
                return r8
            L1d:
                r1 = 0
                if (r0 != 0) goto L24
            L21:
                r10.f1615b = r8     // Catch: java.lang.Throwable -> L4a
                goto L37
            L24:
                long r3 = r0.g     // Catch: java.lang.Throwable -> L4a
                long r5 = r3 - r8
                int r11 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r11 < 0) goto L2d
                goto L2e
            L2d:
                r8 = r3
            L2e:
                long r3 = r10.f1615b     // Catch: java.lang.Throwable -> L4a
                long r3 = r8 - r3
                int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r11 <= 0) goto L37
                goto L21
            L37:
                long r8 = r7.g     // Catch: java.lang.Throwable -> L4a
                long r3 = r10.f1615b     // Catch: java.lang.Throwable -> L4a
                long r8 = r8 - r3
                int r11 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r11 >= 0) goto L44
                long r8 = r10.f1615b     // Catch: java.lang.Throwable -> L4a
                r7.g = r8     // Catch: java.lang.Throwable -> L4a
            L44:
                r10.a(r7)     // Catch: java.lang.Throwable -> L4a
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4d
                r8 = 0
                goto La
            L4a:
                r8 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4d
                throw r8     // Catch: java.lang.Throwable -> L4d
            L4d:
                r8 = move-exception
                monitor-exit(r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.v0.a.h(long, kotlinx.coroutines.v0$b, kotlinx.coroutines.v0):int");
        }

        public final boolean i(long j) {
            return j - this.g >= 0;
        }

        public String toString() {
            return "Delayed[nanos=" + this.g + ']';
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends kotlinx.coroutines.internal.w<a> {

        /* renamed from: b, reason: collision with root package name */
        public long f1615b;

        public b(long j) {
            this.f1615b = j;
        }
    }

    private final void D() {
        kotlinx.coroutines.internal.r rVar;
        kotlinx.coroutines.internal.r rVar2;
        if (h0.a() && !H()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
                rVar = y0.f1618b;
                if (atomicReferenceFieldUpdater.compareAndSet(this, null, rVar)) {
                    return;
                }
            } else {
                if (obj instanceof kotlinx.coroutines.internal.k) {
                    ((kotlinx.coroutines.internal.k) obj).d();
                    return;
                }
                rVar2 = y0.f1618b;
                if (obj == rVar2) {
                    return;
                }
                kotlinx.coroutines.internal.k kVar = new kotlinx.coroutines.internal.k(8, true);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
                kVar.a((Runnable) obj);
                if (i.compareAndSet(this, obj, kVar)) {
                    return;
                }
            }
        }
    }

    private final Runnable E() {
        kotlinx.coroutines.internal.r rVar;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof kotlinx.coroutines.internal.k)) {
                rVar = y0.f1618b;
                if (obj == rVar) {
                    return null;
                }
                if (i.compareAndSet(this, obj, null)) {
                    if (obj != null) {
                        return (Runnable) obj;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            } else {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
                kotlinx.coroutines.internal.k kVar = (kotlinx.coroutines.internal.k) obj;
                Object j2 = kVar.j();
                if (j2 != kotlinx.coroutines.internal.k.g) {
                    return (Runnable) j2;
                }
                i.compareAndSet(this, obj, kVar.i());
            }
        }
    }

    private final boolean G(Runnable runnable) {
        kotlinx.coroutines.internal.r rVar;
        while (true) {
            Object obj = this._queue;
            if (H()) {
                return false;
            }
            if (obj == null) {
                if (i.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (!(obj instanceof kotlinx.coroutines.internal.k)) {
                rVar = y0.f1618b;
                if (obj == rVar) {
                    return false;
                }
                kotlinx.coroutines.internal.k kVar = new kotlinx.coroutines.internal.k(8, true);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
                kVar.a((Runnable) obj);
                kVar.a(runnable);
                if (i.compareAndSet(this, obj, kVar)) {
                    return true;
                }
            } else {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
                kotlinx.coroutines.internal.k kVar2 = (kotlinx.coroutines.internal.k) obj;
                int a2 = kVar2.a(runnable);
                if (a2 == 0) {
                    return true;
                }
                if (a2 == 1) {
                    i.compareAndSet(this, obj, kVar2.i());
                } else if (a2 == 2) {
                    return false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    public final boolean H() {
        return this._isCompleted;
    }

    private final void K() {
        a i2;
        y1 a2 = z1.a();
        long h = a2 != null ? a2.h() : System.nanoTime();
        while (true) {
            b bVar = (b) this._delayed;
            if (bVar == null || (i2 = bVar.i()) == null) {
                return;
            } else {
                A(h, i2);
            }
        }
    }

    private final int N(long j2, a aVar) {
        if (H()) {
            return 1;
        }
        b bVar = (b) this._delayed;
        if (bVar == null) {
            j.compareAndSet(this, null, new b(j2));
            Object obj = this._delayed;
            e.p.d.i.b(obj);
            bVar = (b) obj;
        }
        return aVar.h(j2, bVar, this);
    }

    private final void O(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    private final boolean P(a aVar) {
        b bVar = (b) this._delayed;
        return (bVar != null ? bVar.e() : null) == aVar;
    }

    public final void F(Runnable runnable) {
        if (G(runnable)) {
            B();
        } else {
            j0.l.F(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean I() {
        kotlinx.coroutines.internal.r rVar;
        if (!w()) {
            return false;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof kotlinx.coroutines.internal.k) {
                return ((kotlinx.coroutines.internal.k) obj).g();
            }
            rVar = y0.f1618b;
            if (obj != rVar) {
                return false;
            }
        }
        return true;
    }

    public long J() {
        a aVar;
        if (x()) {
            return 0L;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.d()) {
            y1 a2 = z1.a();
            long h = a2 != null ? a2.h() : System.nanoTime();
            do {
                synchronized (bVar) {
                    a b2 = bVar.b();
                    aVar = null;
                    if (b2 != null) {
                        a aVar2 = b2;
                        if (aVar2.i(h) ? G(aVar2) : false) {
                            aVar = bVar.h(0);
                        }
                    }
                }
            } while (aVar != null);
        }
        Runnable E = E();
        if (E == null) {
            return s();
        }
        E.run();
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L() {
        this._queue = null;
        this._delayed = null;
    }

    public final void M(long j2, a aVar) {
        int N = N(j2, aVar);
        if (N == 0) {
            if (P(aVar)) {
                B();
            }
        } else if (N == 1) {
            A(j2, aVar);
        } else if (N != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    @Override // kotlinx.coroutines.y
    public final void n(e.m.g gVar, Runnable runnable) {
        F(runnable);
    }

    @Override // kotlinx.coroutines.u0
    protected long s() {
        a e2;
        kotlinx.coroutines.internal.r rVar;
        if (super.s() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.k)) {
                rVar = y0.f1618b;
                return obj == rVar ? Long.MAX_VALUE : 0L;
            }
            if (!((kotlinx.coroutines.internal.k) obj).g()) {
                return 0L;
            }
        }
        b bVar = (b) this._delayed;
        if (bVar == null || (e2 = bVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j2 = e2.g;
        y1 a2 = z1.a();
        return e.r.d.b(j2 - (a2 != null ? a2.h() : System.nanoTime()), 0L);
    }

    @Override // kotlinx.coroutines.u0
    protected void y() {
        x1.f1616b.b();
        O(true);
        D();
        do {
        } while (J() <= 0);
        K();
    }
}
