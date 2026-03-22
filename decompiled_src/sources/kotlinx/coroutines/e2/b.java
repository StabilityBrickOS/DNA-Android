package kotlinx.coroutines.e2;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.internal.r;
import kotlinx.coroutines.y1;
import kotlinx.coroutines.z1;

/* loaded from: classes.dex */
public final class b implements Executor, Closeable {
    private volatile int _isTerminated;
    volatile long controlState;

    /* renamed from: e, reason: collision with root package name */
    public final e f1563e;
    public final e f;
    public final AtomicReferenceArray<a> g;
    public final int h;
    public final int i;
    public final long j;
    public final String k;
    private volatile long parkedWorkersStack;
    public static final r o = new r("NOT_IN_STACK");
    private static final AtomicLongFieldUpdater l = AtomicLongFieldUpdater.newUpdater(b.class, "parkedWorkersStack");
    static final AtomicLongFieldUpdater m = AtomicLongFieldUpdater.newUpdater(b.class, "controlState");
    private static final AtomicIntegerFieldUpdater n = AtomicIntegerFieldUpdater.newUpdater(b.class, "_isTerminated");

    /* loaded from: classes.dex */
    public final class a extends Thread {
        static final AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl");

        /* renamed from: e, reason: collision with root package name */
        public final n f1564e;
        public EnumC0124b f;
        private long g;
        private long h;
        private int i;
        private volatile int indexInArray;
        public boolean j;
        private volatile Object nextParkedWorker;
        volatile int workerCtl;

        private a() {
            setDaemon(true);
            this.f1564e = new n();
            this.f = EnumC0124b.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = b.o;
            this.i = e.q.c.f1543b.b();
        }

        public a(b bVar, int i) {
            this();
            n(i);
        }

        private final void a(int i) {
            if (i == 0) {
                return;
            }
            b.m.addAndGet(b.this, -2097152L);
            EnumC0124b enumC0124b = this.f;
            if (enumC0124b != EnumC0124b.TERMINATED) {
                if (h0.a()) {
                    if (!(enumC0124b == EnumC0124b.BLOCKING)) {
                        throw new AssertionError();
                    }
                }
                this.f = EnumC0124b.DORMANT;
            }
        }

        private final void b(int i) {
            if (i != 0 && r(EnumC0124b.BLOCKING)) {
                b.this.q();
            }
        }

        private final void c(i iVar) {
            int g = iVar.f.g();
            h(g);
            b(g);
            b.this.n(iVar);
            a(g);
        }

        private final i d(boolean z) {
            i l2;
            i l3;
            if (z) {
                boolean z2 = j(b.this.h * 2) == 0;
                if (z2 && (l3 = l()) != null) {
                    return l3;
                }
                i h = this.f1564e.h();
                if (h != null) {
                    return h;
                }
                if (!z2 && (l2 = l()) != null) {
                    return l2;
                }
            } else {
                i l4 = l();
                if (l4 != null) {
                    return l4;
                }
            }
            return s(false);
        }

        private final void h(int i) {
            this.g = 0L;
            if (this.f == EnumC0124b.PARKING) {
                if (h0.a()) {
                    if (!(i == 1)) {
                        throw new AssertionError();
                    }
                }
                this.f = EnumC0124b.BLOCKING;
            }
        }

        private final boolean i() {
            return this.nextParkedWorker != b.o;
        }

        private final void k() {
            if (this.g == 0) {
                this.g = System.nanoTime() + b.this.j;
            }
            LockSupport.parkNanos(b.this.j);
            if (System.nanoTime() - this.g >= 0) {
                this.g = 0L;
                t();
            }
        }

        private final i l() {
            e eVar;
            if (j(2) == 0) {
                i d2 = b.this.f1563e.d();
                if (d2 != null) {
                    return d2;
                }
                eVar = b.this.f;
            } else {
                i d3 = b.this.f.d();
                if (d3 != null) {
                    return d3;
                }
                eVar = b.this.f1563e;
            }
            return eVar.d();
        }

        private final void m() {
            loop0: while (true) {
                boolean z = false;
                while (!b.this.i() && this.f != EnumC0124b.TERMINATED) {
                    i e2 = e(this.j);
                    if (e2 != null) {
                        this.h = 0L;
                        c(e2);
                    } else {
                        this.j = false;
                        if (this.h == 0) {
                            q();
                        } else if (z) {
                            r(EnumC0124b.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.h);
                            this.h = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
            }
            r(EnumC0124b.TERMINATED);
        }

        private final boolean p() {
            boolean z;
            if (this.f != EnumC0124b.CPU_ACQUIRED) {
                b bVar = b.this;
                while (true) {
                    long j = bVar.controlState;
                    if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                        z = false;
                        break;
                    }
                    if (b.m.compareAndSet(bVar, j, j - 4398046511104L)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    return false;
                }
                this.f = EnumC0124b.CPU_ACQUIRED;
            }
            return true;
        }

        private final void q() {
            if (!i()) {
                b.this.l(this);
                return;
            }
            if (h0.a()) {
                if (!(this.f1564e.f() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (i() && !b.this.i() && this.f != EnumC0124b.TERMINATED) {
                r(EnumC0124b.PARKING);
                Thread.interrupted();
                k();
            }
        }

        private final i s(boolean z) {
            if (h0.a()) {
                if (!(this.f1564e.f() == 0)) {
                    throw new AssertionError();
                }
            }
            int h = b.this.h();
            if (h < 2) {
                return null;
            }
            int j = j(h);
            long j2 = Long.MAX_VALUE;
            for (int i = 0; i < h; i++) {
                j++;
                if (j > h) {
                    j = 1;
                }
                a aVar = b.this.g.get(j);
                if (aVar != null && aVar != this) {
                    if (h0.a()) {
                        if (!(this.f1564e.f() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    n nVar = this.f1564e;
                    n nVar2 = aVar.f1564e;
                    long k = z ? nVar.k(nVar2) : nVar.l(nVar2);
                    if (k == -1) {
                        return this.f1564e.h();
                    }
                    if (k > 0) {
                        j2 = Math.min(j2, k);
                    }
                }
            }
            if (j2 == Long.MAX_VALUE) {
                j2 = 0;
            }
            this.h = j2;
            return null;
        }

        private final void t() {
            synchronized (b.this.g) {
                if (b.this.i()) {
                    return;
                }
                if (b.this.h() <= b.this.h) {
                    return;
                }
                if (l.compareAndSet(this, -1, 1)) {
                    int i = this.indexInArray;
                    n(0);
                    b.this.m(this, i, 0);
                    int andDecrement = (int) (b.m.getAndDecrement(b.this) & 2097151);
                    if (andDecrement != i) {
                        a aVar = b.this.g.get(andDecrement);
                        e.p.d.i.b(aVar);
                        a aVar2 = aVar;
                        b.this.g.set(i, aVar2);
                        aVar2.n(i);
                        b.this.m(aVar2, andDecrement, i);
                    }
                    b.this.g.set(andDecrement, null);
                    e.j jVar = e.j.a;
                    this.f = EnumC0124b.TERMINATED;
                }
            }
        }

        public final i e(boolean z) {
            i d2;
            if (p()) {
                return d(z);
            }
            if (!z || (d2 = this.f1564e.h()) == null) {
                d2 = b.this.f.d();
            }
            return d2 != null ? d2 : s(true);
        }

        public final int f() {
            return this.indexInArray;
        }

        public final Object g() {
            return this.nextParkedWorker;
        }

        public final int j(int i) {
            int i2 = this.i;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.i = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        public final void n(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(b.this.k);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void o(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean r(EnumC0124b enumC0124b) {
            EnumC0124b enumC0124b2 = this.f;
            boolean z = enumC0124b2 == EnumC0124b.CPU_ACQUIRED;
            if (z) {
                b.m.addAndGet(b.this, 4398046511104L);
            }
            if (enumC0124b2 != enumC0124b) {
                this.f = enumC0124b;
            }
            return z;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            m();
        }
    }

    /* renamed from: kotlinx.coroutines.e2.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0124b {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public b(int i, int i2, long j, String str) {
        this.h = i;
        this.i = i2;
        this.j = j;
        this.k = str;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + this.h + " should be at least 1").toString());
        }
        if (!(this.i >= this.h)) {
            throw new IllegalArgumentException(("Max pool size " + this.i + " should be greater than or equals to core pool size " + this.h).toString());
        }
        if (!(this.i <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + this.i + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(this.j > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + this.j + " must be positive").toString());
        }
        this.f1563e = new e();
        this.f = new e();
        this.parkedWorkersStack = 0L;
        this.g = new AtomicReferenceArray<>(this.i + 1);
        this.controlState = this.h << 42;
        this._isTerminated = 0;
    }

    private final boolean b(i iVar) {
        return (iVar.f.g() == 1 ? this.f : this.f1563e).a(iVar);
    }

    private final int c() {
        int a2;
        int i;
        synchronized (this.g) {
            if (i()) {
                i = -1;
            } else {
                long j = this.controlState;
                int i2 = (int) (j & 2097151);
                a2 = e.r.f.a(i2 - ((int) ((j & 4398044413952L) >> 21)), 0);
                if (a2 >= this.h) {
                    return 0;
                }
                if (i2 >= this.i) {
                    return 0;
                }
                int i3 = ((int) (this.controlState & 2097151)) + 1;
                if (!(i3 > 0 && this.g.get(i3) == null)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                a aVar = new a(this, i3);
                this.g.set(i3, aVar);
                if (!(i3 == ((int) (2097151 & m.incrementAndGet(this))))) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                aVar.start();
                i = a2 + 1;
            }
            return i;
        }
    }

    private final a e() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof a)) {
            currentThread = null;
        }
        a aVar = (a) currentThread;
        if (aVar == null || !e.p.d.i.a(b.this, this)) {
            return null;
        }
        return aVar;
    }

    public static /* synthetic */ void g(b bVar, Runnable runnable, j jVar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            jVar = h.f;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        bVar.f(runnable, jVar, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int h() {
        return (int) (this.controlState & 2097151);
    }

    private final int j(a aVar) {
        int f;
        do {
            Object g = aVar.g();
            if (g == o) {
                return -1;
            }
            if (g == null) {
                return 0;
            }
            aVar = (a) g;
            f = aVar.f();
        } while (f == 0);
        return f;
    }

    private final a k() {
        while (true) {
            long j = this.parkedWorkersStack;
            a aVar = this.g.get((int) (2097151 & j));
            if (aVar == null) {
                return null;
            }
            long j2 = (2097152 + j) & (-2097152);
            int j3 = j(aVar);
            if (j3 >= 0 && l.compareAndSet(this, j, j3 | j2)) {
                aVar.o(o);
                return aVar;
            }
        }
    }

    private final void p(boolean z) {
        long addAndGet = m.addAndGet(this, 2097152L);
        if (z || u() || s(addAndGet)) {
            return;
        }
        u();
    }

    private final i r(a aVar, i iVar, boolean z) {
        if (aVar == null || aVar.f == EnumC0124b.TERMINATED) {
            return iVar;
        }
        if (iVar.f.g() == 0 && aVar.f == EnumC0124b.BLOCKING) {
            return iVar;
        }
        aVar.j = true;
        return aVar.f1564e.a(iVar, z);
    }

    private final boolean s(long j) {
        int a2;
        a2 = e.r.f.a(((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)), 0);
        if (a2 < this.h) {
            int c2 = c();
            if (c2 == 1 && this.h > 1) {
                c();
            }
            if (c2 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean t(b bVar, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = bVar.controlState;
        }
        return bVar.s(j);
    }

    private final boolean u() {
        a k;
        do {
            k = k();
            if (k == null) {
                return false;
            }
        } while (!a.l.compareAndSet(k, -1, 0));
        LockSupport.unpark(k);
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        o(10000L);
    }

    public final i d(Runnable runnable, j jVar) {
        long a2 = l.f1570e.a();
        if (!(runnable instanceof i)) {
            return new k(runnable, a2, jVar);
        }
        i iVar = (i) runnable;
        iVar.f1566e = a2;
        iVar.f = jVar;
        return iVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        g(this, runnable, null, false, 6, null);
    }

    public final void f(Runnable runnable, j jVar, boolean z) {
        y1 a2 = z1.a();
        if (a2 != null) {
            a2.g();
        }
        i d2 = d(runnable, jVar);
        a e2 = e();
        i r = r(e2, d2, z);
        if (r != null && !b(r)) {
            throw new RejectedExecutionException(this.k + " was terminated");
        }
        boolean z2 = z && e2 != null;
        if (d2.f.g() != 0) {
            p(z2);
        } else {
            if (z2) {
                return;
            }
            q();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    public final boolean i() {
        return this._isTerminated;
    }

    public final boolean l(a aVar) {
        long j;
        long j2;
        int f;
        if (aVar.g() != o) {
            return false;
        }
        do {
            j = this.parkedWorkersStack;
            int i = (int) (2097151 & j);
            j2 = (2097152 + j) & (-2097152);
            f = aVar.f();
            if (h0.a()) {
                if (!(f != 0)) {
                    throw new AssertionError();
                }
            }
            aVar.o(this.g.get(i));
        } while (!l.compareAndSet(this, j, f | j2));
        return true;
    }

    public final void m(a aVar, int i, int i2) {
        while (true) {
            long j = this.parkedWorkersStack;
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (i3 == i) {
                i3 = i2 == 0 ? j(aVar) : i2;
            }
            if (i3 >= 0 && l.compareAndSet(this, j, j2 | i3)) {
                return;
            }
        }
    }

    public final void n(i iVar) {
        try {
            iVar.run();
        } catch (Throwable th) {
            try {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
                y1 a2 = z1.a();
                if (a2 == null) {
                }
            } finally {
                y1 a3 = z1.a();
                if (a3 != null) {
                    a3.f();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
    
        if (r9 != null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(long r9) {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.e2.b.n
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            kotlinx.coroutines.e2.b$a r0 = r8.e()
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.e2.b$a> r3 = r8.g
            monitor-enter(r3)
            long r4 = r8.controlState     // Catch: java.lang.Throwable -> Lb5
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r5 = (int) r4
            monitor-exit(r3)
            if (r2 > r5) goto L5b
            r3 = 1
        L1d:
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.e2.b$a> r4 = r8.g
            java.lang.Object r4 = r4.get(r3)
            e.p.d.i.b(r4)
            kotlinx.coroutines.e2.b$a r4 = (kotlinx.coroutines.e2.b.a) r4
            if (r4 == r0) goto L56
        L2a:
            boolean r6 = r4.isAlive()
            if (r6 == 0) goto L37
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r4.join(r9)
            goto L2a
        L37:
            kotlinx.coroutines.e2.b$b r6 = r4.f
            boolean r7 = kotlinx.coroutines.h0.a()
            if (r7 == 0) goto L4f
            kotlinx.coroutines.e2.b$b r7 = kotlinx.coroutines.e2.b.EnumC0124b.TERMINATED
            if (r6 != r7) goto L45
            r6 = 1
            goto L46
        L45:
            r6 = 0
        L46:
            if (r6 == 0) goto L49
            goto L4f
        L49:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L4f:
            kotlinx.coroutines.e2.n r4 = r4.f1564e
            kotlinx.coroutines.e2.e r6 = r8.f
            r4.g(r6)
        L56:
            if (r3 == r5) goto L5b
            int r3 = r3 + 1
            goto L1d
        L5b:
            kotlinx.coroutines.e2.e r9 = r8.f
            r9.b()
            kotlinx.coroutines.e2.e r9 = r8.f1563e
            r9.b()
        L65:
            if (r0 == 0) goto L6e
            kotlinx.coroutines.e2.i r9 = r0.e(r2)
            if (r9 == 0) goto L6e
            goto L76
        L6e:
            kotlinx.coroutines.e2.e r9 = r8.f1563e
            java.lang.Object r9 = r9.d()
            kotlinx.coroutines.e2.i r9 = (kotlinx.coroutines.e2.i) r9
        L76:
            if (r9 == 0) goto L79
            goto L81
        L79:
            kotlinx.coroutines.e2.e r9 = r8.f
            java.lang.Object r9 = r9.d()
            kotlinx.coroutines.e2.i r9 = (kotlinx.coroutines.e2.i) r9
        L81:
            if (r9 == 0) goto L87
            r8.n(r9)
            goto L65
        L87:
            if (r0 == 0) goto L8e
            kotlinx.coroutines.e2.b$b r9 = kotlinx.coroutines.e2.b.EnumC0124b.TERMINATED
            r0.r(r9)
        L8e:
            boolean r9 = kotlinx.coroutines.h0.a()
            if (r9 == 0) goto Lae
            long r9 = r8.controlState
            r3 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r9 = r9 & r3
            r0 = 42
            long r9 = r9 >> r0
            int r10 = (int) r9
            int r9 = r8.h
            if (r10 != r9) goto La5
            r1 = 1
        La5:
            if (r1 == 0) goto La8
            goto Lae
        La8:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        Lae:
            r9 = 0
            r8.parkedWorkersStack = r9
            r8.controlState = r9
            return
        Lb5:
            r9 = move-exception
            monitor-exit(r3)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.e2.b.o(long):void");
    }

    public final void q() {
        if (u() || t(this, 0L, 1, null)) {
            return;
        }
        u();
    }

    public String toString() {
        StringBuilder sb;
        String str;
        ArrayList arrayList = new ArrayList();
        int length = this.g.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < length; i6++) {
            a aVar = this.g.get(i6);
            if (aVar != null) {
                int f = aVar.f1564e.f();
                int i7 = kotlinx.coroutines.e2.a.a[aVar.f.ordinal()];
                if (i7 != 1) {
                    if (i7 == 2) {
                        i2++;
                        sb = new StringBuilder();
                        sb.append(String.valueOf(f));
                        str = "b";
                    } else if (i7 == 3) {
                        i++;
                        sb = new StringBuilder();
                        sb.append(String.valueOf(f));
                        str = "c";
                    } else if (i7 == 4) {
                        i4++;
                        if (f > 0) {
                            sb = new StringBuilder();
                            sb.append(String.valueOf(f));
                            str = "d";
                        }
                    } else if (i7 == 5) {
                        i5++;
                    }
                    sb.append(str);
                    arrayList.add(sb.toString());
                } else {
                    i3++;
                }
            }
        }
        long j = this.controlState;
        return this.k + '@' + i0.b(this) + "[Pool Size {core = " + this.h + ", max = " + this.i + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f1563e.c() + ", global blocking queue size = " + this.f.c() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", CPUs acquired = " + (this.h - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }
}
