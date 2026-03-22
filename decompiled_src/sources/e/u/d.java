package e.u;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements e.t.c<e.r.c> {
    private final CharSequence a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1549b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1550c;

    /* renamed from: d, reason: collision with root package name */
    private final e.p.c.p<CharSequence, Integer, e.e<Integer, Integer>> f1551d;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<e.r.c> {

        /* renamed from: e, reason: collision with root package name */
        private int f1552e = -1;
        private int f;
        private int g;
        private e.r.c h;
        private int i;

        a() {
            int e2;
            e2 = e.r.f.e(d.this.f1549b, 0, d.this.a.length());
            this.f = e2;
            this.g = e2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        
            if (r0 < r6.j.f1550c) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.g
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f1552e = r1
                r0 = 0
                r6.h = r0
                goto L99
            Lc:
                e.u.d r0 = e.u.d.this
                int r0 = e.u.d.c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.i
                int r0 = r0 + r3
                r6.i = r0
                e.u.d r4 = e.u.d.this
                int r4 = e.u.d.c(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.g
                e.u.d r4 = e.u.d.this
                java.lang.CharSequence r4 = e.u.d.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                int r0 = r6.f
                e.r.c r1 = new e.r.c
                e.u.d r4 = e.u.d.this
                java.lang.CharSequence r4 = e.u.d.b(r4)
                int r4 = e.u.v.p(r4)
                r1.<init>(r0, r4)
            L42:
                r6.h = r1
            L44:
                r6.g = r2
                goto L97
            L47:
                e.u.d r0 = e.u.d.this
                e.p.c.p r0 = e.u.d.a(r0)
                e.u.d r4 = e.u.d.this
                java.lang.CharSequence r4 = e.u.d.b(r4)
                int r5 = r6.g
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                e.e r0 = (e.e) r0
                if (r0 != 0) goto L73
                int r0 = r6.f
                e.r.c r1 = new e.r.c
                e.u.d r4 = e.u.d.this
                java.lang.CharSequence r4 = e.u.d.b(r4)
                int r4 = e.u.v.p(r4)
                r1.<init>(r0, r4)
                goto L42
            L73:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f
                e.r.c r4 = e.r.d.g(r4, r2)
                r6.h = r4
                int r2 = r2 + r0
                r6.f = r2
                if (r0 != 0) goto L95
                r1 = 1
            L95:
                int r2 = r2 + r1
                goto L44
            L97:
                r6.f1552e = r3
            L99:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e.u.d.a.a():void");
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e.r.c next() {
            if (this.f1552e == -1) {
                a();
            }
            if (this.f1552e == 0) {
                throw new NoSuchElementException();
            }
            e.r.c cVar = this.h;
            if (cVar == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.h = null;
            this.f1552e = -1;
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f1552e == -1) {
                a();
            }
            return this.f1552e == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, e.p.c.p<? super CharSequence, ? super Integer, e.e<Integer, Integer>> pVar) {
        e.p.d.i.d(charSequence, "input");
        e.p.d.i.d(pVar, "getNextMatch");
        this.a = charSequence;
        this.f1549b = i;
        this.f1550c = i2;
        this.f1551d = pVar;
    }

    @Override // e.t.c
    public Iterator<e.r.c> iterator() {
        return new a();
    }
}
