package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.h0;

/* loaded from: classes.dex */
public final class k<E> {
    private volatile Object _next = null;
    private volatile long _state = 0;
    private final int a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicReferenceArray f1587b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1588c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f1589d;
    public static final a h = new a(null);
    public static final r g = new r("REMOVE_FROZEN");

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1586e = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_next");
    private static final AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(k.class, "_state");

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e.p.d.e eVar) {
            this();
        }

        public final int a(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j, int i) {
            return d(j, 1073741823L) | (i << 0);
        }

        public final long c(long j, int i) {
            return d(j, 1152921503533105152L) | (i << 30);
        }

        public final long d(long j, long j2) {
            return j & (~j2);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public final int a;

        public b(int i) {
            this.a = i;
        }
    }

    public k(int i, boolean z) {
        this.f1588c = i;
        this.f1589d = z;
        this.a = i - 1;
        this.f1587b = new AtomicReferenceArray(this.f1588c);
        if (!(this.a <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((this.f1588c & this.a) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final k<E> b(long j) {
        k<E> kVar = new k<>(this.f1588c * 2, this.f1589d);
        int i = (int) ((1073741823 & j) >> 0);
        int i2 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i3 = this.a;
            if ((i & i3) == (i2 & i3)) {
                kVar._state = h.d(j, 1152921504606846976L);
                return kVar;
            }
            Object obj = this.f1587b.get(i3 & i);
            if (obj == null) {
                obj = new b(i);
            }
            kVar.f1587b.set(kVar.a & i, obj);
            i++;
        }
    }

    private final k<E> c(long j) {
        while (true) {
            k<E> kVar = (k) this._next;
            if (kVar != null) {
                return kVar;
            }
            f1586e.compareAndSet(this, null, b(j));
        }
    }

    private final k<E> e(int i, E e2) {
        Object obj = this.f1587b.get(this.a & i);
        if (!(obj instanceof b) || ((b) obj).a != i) {
            return null;
        }
        this.f1587b.set(i & this.a, e2);
        return this;
    }

    private final long h() {
        long j;
        long j2;
        do {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!f.compareAndSet(this, j, j2));
        return j2;
    }

    private final k<E> k(int i, int i2) {
        long j;
        int i3;
        do {
            j = this._state;
            i3 = (int) ((1073741823 & j) >> 0);
            if (h0.a()) {
                if (!(i3 == i)) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & j) != 0) {
                return i();
            }
        } while (!f.compareAndSet(this, j, h.b(j, i2)));
        this.f1587b.set(this.a & i3, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(E r13) {
        /*
            r12 = this;
        L0:
            long r2 = r12._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L12
            kotlinx.coroutines.internal.k$a r13 = kotlinx.coroutines.internal.k.h
            int r13 = r13.a(r2)
            return r13
        L12:
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r2
            r8 = 0
            long r0 = r0 >> r8
            int r1 = (int) r0
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r0 = 30
            long r4 = r4 >> r0
            int r9 = (int) r4
            int r10 = r12.a
            int r0 = r9 + 2
            r0 = r0 & r10
            r4 = r1 & r10
            r5 = 1
            if (r0 != r4) goto L2e
            return r5
        L2e:
            boolean r0 = r12.f1589d
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 != 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f1587b
            r11 = r9 & r10
            java.lang.Object r0 = r0.get(r11)
            if (r0 == 0) goto L4d
            int r0 = r12.f1588c
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L4c
            int r9 = r9 - r1
            r1 = r9 & r4
            int r0 = r0 >> 1
            if (r1 <= r0) goto L0
        L4c:
            return r5
        L4d:
            int r0 = r9 + 1
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.k.f
            kotlinx.coroutines.internal.k$a r4 = kotlinx.coroutines.internal.k.h
            long r4 = r4.c(r2, r0)
            r0 = r1
            r1 = r12
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f1587b
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L68:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L72
            goto L7d
        L72:
            kotlinx.coroutines.internal.k r0 = r0.i()
            kotlinx.coroutines.internal.k r0 = r0.e(r9, r13)
            if (r0 == 0) goto L7d
            goto L68
        L7d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.k.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final int f() {
        long j = this._state;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0)));
    }

    public final boolean g() {
        long j = this._state;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    public final k<E> i() {
        return c(h());
    }

    public final Object j() {
        while (true) {
            long j = this._state;
            if ((1152921504606846976L & j) != 0) {
                return g;
            }
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.a;
            if ((i2 & i3) == (i & i3)) {
                return null;
            }
            Object obj = this.f1587b.get(i3 & i);
            if (obj == null) {
                if (this.f1589d) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i4 = (i + 1) & 1073741823;
                if (f.compareAndSet(this, j, h.b(j, i4))) {
                    this.f1587b.set(this.a & i, null);
                    return obj;
                }
                if (this.f1589d) {
                    k<E> kVar = this;
                    do {
                        kVar = kVar.k(i, i4);
                    } while (kVar != null);
                    return obj;
                }
            }
        }
    }
}
