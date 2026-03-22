package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class i {

    /* renamed from: e, reason: collision with root package name */
    static final AtomicReferenceFieldUpdater f1583e = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_next");
    static final AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_prev");
    private static final AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_removedRef");
    volatile Object _next = this;
    volatile Object _prev = this;
    private volatile Object _removedRef = null;

    /* loaded from: classes.dex */
    public static abstract class a extends c<i> {

        /* renamed from: b, reason: collision with root package name */
        public i f1584b;

        /* renamed from: c, reason: collision with root package name */
        public final i f1585c;

        public a(i iVar) {
            this.f1585c = iVar;
        }

        @Override // kotlinx.coroutines.internal.c
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(i iVar, Object obj) {
            boolean z = obj == null;
            i iVar2 = z ? this.f1585c : this.f1584b;
            if (iVar2 != null && i.f1583e.compareAndSet(iVar, this, iVar2) && z) {
                i iVar3 = this.f1585c;
                i iVar4 = this.f1584b;
                e.p.d.i.b(iVar4);
                iVar3.i(iVar4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        if (kotlinx.coroutines.internal.i.f1583e.compareAndSet(r3, r2, ((kotlinx.coroutines.internal.p) r4).a) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlinx.coroutines.internal.i g(kotlinx.coroutines.internal.o r7) {
        /*
            r6 = this;
        L0:
            java.lang.Object r0 = r6._prev
            kotlinx.coroutines.internal.i r0 = (kotlinx.coroutines.internal.i) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r6) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.i.f
            boolean r0 = r1.compareAndSet(r6, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r6.m()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r7) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.o
            if (r5 == 0) goto L38
            if (r7 == 0) goto L32
            r0 = r4
            kotlinx.coroutines.internal.o r0 = (kotlinx.coroutines.internal.o) r0
            boolean r0 = r7.b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            kotlinx.coroutines.internal.o r4 = (kotlinx.coroutines.internal.o) r4
            r4.c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.p
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.i.f1583e
            kotlinx.coroutines.internal.p r4 = (kotlinx.coroutines.internal.p) r4
            kotlinx.coroutines.internal.i r4 = r4.a
            boolean r2 = r5.compareAndSet(r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.i r2 = (kotlinx.coroutines.internal.i) r2
            goto L7
        L52:
            if (r4 == 0) goto L59
            kotlinx.coroutines.internal.i r4 = (kotlinx.coroutines.internal.i) r4
            r3 = r2
            r2 = r4
            goto L7
        L59:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
        */
        //  java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.i.g(kotlinx.coroutines.internal.o):kotlinx.coroutines.internal.i");
    }

    private final i h(i iVar) {
        while (iVar.m()) {
            iVar = (i) iVar._prev;
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(i iVar) {
        i iVar2;
        do {
            iVar2 = (i) iVar._prev;
            if (j() != iVar) {
                return;
            }
        } while (!f.compareAndSet(iVar, iVar2, this));
        if (m()) {
            iVar.g(null);
        }
    }

    private final p p() {
        p pVar = (p) this._removedRef;
        if (pVar != null) {
            return pVar;
        }
        p pVar2 = new p(this);
        g.lazySet(this, pVar2);
        return pVar2;
    }

    public final boolean f(i iVar) {
        f.lazySet(iVar, this);
        f1583e.lazySet(iVar, this);
        while (j() == this) {
            if (f1583e.compareAndSet(this, this, iVar)) {
                iVar.i(this);
                return true;
            }
        }
        return false;
    }

    public final Object j() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof o)) {
                return obj;
            }
            ((o) obj).c(this);
        }
    }

    public final i k() {
        return h.b(j());
    }

    public final i l() {
        i g2 = g(null);
        return g2 != null ? g2 : h((i) this._prev);
    }

    public boolean m() {
        return j() instanceof p;
    }

    public boolean n() {
        return o() == null;
    }

    public final i o() {
        Object j;
        i iVar;
        do {
            j = j();
            if (j instanceof p) {
                return ((p) j).a;
            }
            if (j == this) {
                return (i) j;
            }
            if (j == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            iVar = (i) j;
        } while (!f1583e.compareAndSet(this, j, iVar.p()));
        iVar.g(null);
        return null;
    }

    public final int q(i iVar, i iVar2, a aVar) {
        f.lazySet(iVar, this);
        f1583e.lazySet(iVar, iVar2);
        aVar.f1584b = iVar2;
        if (f1583e.compareAndSet(this, iVar2, aVar)) {
            return aVar.c(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }
}
