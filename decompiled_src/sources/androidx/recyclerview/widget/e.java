package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements Runnable {
    static final ThreadLocal<e> i = new ThreadLocal<>();
    static Comparator<c> j = new a();
    long f;
    long g;

    /* renamed from: e, reason: collision with root package name */
    ArrayList<RecyclerView> f575e = new ArrayList<>();
    private ArrayList<c> h = new ArrayList<>();

    /* loaded from: classes.dex */
    static class a implements Comparator<c> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            if ((cVar.f581d == null) != (cVar2.f581d == null)) {
                return cVar.f581d == null ? 1 : -1;
            }
            boolean z = cVar.a;
            if (z != cVar2.a) {
                return z ? -1 : 1;
            }
            int i = cVar2.f579b - cVar.f579b;
            if (i != 0) {
                return i;
            }
            int i2 = cVar.f580c - cVar2.f580c;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"VisibleForTests"})
    /* loaded from: classes.dex */
    public static class b implements RecyclerView.n.c {
        int a;

        /* renamed from: b, reason: collision with root package name */
        int f576b;

        /* renamed from: c, reason: collision with root package name */
        int[] f577c;

        /* renamed from: d, reason: collision with root package name */
        int f578d;

        @Override // androidx.recyclerview.widget.RecyclerView.n.c
        public void a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.f578d * 2;
            int[] iArr = this.f577c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f577c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[i3 * 2];
                this.f577c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f577c;
            iArr4[i3] = i;
            iArr4[i3 + 1] = i2;
            this.f578d++;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f577c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f578d = 0;
        }

        void c(RecyclerView recyclerView, boolean z) {
            this.f578d = 0;
            int[] iArr = this.f577c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.n nVar = recyclerView.p;
            if (recyclerView.o == null || nVar == null || !nVar.u0()) {
                return;
            }
            if (z) {
                if (!recyclerView.h.p()) {
                    nVar.p(recyclerView.o.c(), this);
                }
            } else if (!recyclerView.l0()) {
                nVar.o(this.a, this.f576b, recyclerView.k0, this);
            }
            int i = this.f578d;
            if (i > nVar.m) {
                nVar.m = i;
                nVar.n = z;
                recyclerView.f.K();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean d(int i) {
            if (this.f577c != null) {
                int i2 = this.f578d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f577c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i, int i2) {
            this.a = i;
            this.f576b = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {
        public boolean a;

        /* renamed from: b, reason: collision with root package name */
        public int f579b;

        /* renamed from: c, reason: collision with root package name */
        public int f580c;

        /* renamed from: d, reason: collision with root package name */
        public RecyclerView f581d;

        /* renamed from: e, reason: collision with root package name */
        public int f582e;

        c() {
        }

        public void a() {
            this.a = false;
            this.f579b = 0;
            this.f580c = 0;
            this.f581d = null;
            this.f582e = 0;
        }
    }

    private void b() {
        c cVar;
        int size = this.f575e.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView = this.f575e.get(i3);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.j0.c(recyclerView, false);
                i2 += recyclerView.j0.f578d;
            }
        }
        this.h.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = this.f575e.get(i5);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.j0;
                int abs = Math.abs(bVar.a) + Math.abs(bVar.f576b);
                for (int i6 = 0; i6 < bVar.f578d * 2; i6 += 2) {
                    if (i4 >= this.h.size()) {
                        cVar = new c();
                        this.h.add(cVar);
                    } else {
                        cVar = this.h.get(i4);
                    }
                    int i7 = bVar.f577c[i6 + 1];
                    cVar.a = i7 <= abs;
                    cVar.f579b = abs;
                    cVar.f580c = i7;
                    cVar.f581d = recyclerView2;
                    cVar.f582e = bVar.f577c[i6];
                    i4++;
                }
            }
        }
        Collections.sort(this.h, j);
    }

    private void c(c cVar, long j2) {
        RecyclerView.c0 i2 = i(cVar.f581d, cVar.f582e, cVar.a ? Long.MAX_VALUE : j2);
        if (i2 == null || i2.f479b == null || !i2.s() || i2.t()) {
            return;
        }
        h(i2.f479b.get(), j2);
    }

    private void d(long j2) {
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            c cVar = this.h.get(i2);
            if (cVar.f581d == null) {
                return;
            }
            c(cVar, j2);
            cVar.a();
        }
    }

    static boolean e(RecyclerView recyclerView, int i2) {
        int j2 = recyclerView.i.j();
        for (int i3 = 0; i3 < j2; i3++) {
            RecyclerView.c0 f0 = RecyclerView.f0(recyclerView.i.i(i3));
            if (f0.f480c == i2 && !f0.t()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j2) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.G && recyclerView.i.j() != 0) {
            recyclerView.T0();
        }
        b bVar = recyclerView.j0;
        bVar.c(recyclerView, true);
        if (bVar.f578d != 0) {
            try {
                c.f.h.a.a("RV Nested Prefetch");
                recyclerView.k0.f(recyclerView.o);
                for (int i2 = 0; i2 < bVar.f578d * 2; i2 += 2) {
                    i(recyclerView, bVar.f577c[i2], j2);
                }
            } finally {
                c.f.h.a.b();
            }
        }
    }

    private RecyclerView.c0 i(RecyclerView recyclerView, int i2, long j2) {
        if (e(recyclerView, i2)) {
            return null;
        }
        RecyclerView.u uVar = recyclerView.f;
        try {
            recyclerView.F0();
            RecyclerView.c0 I = uVar.I(i2, false, j2);
            if (I != null) {
                if (!I.s() || I.t()) {
                    uVar.a(I, false);
                } else {
                    uVar.B(I.a);
                }
            }
            return I;
        } finally {
            recyclerView.H0(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f575e.add(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.f == 0) {
            this.f = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.j0.e(i2, i3);
    }

    void g(long j2) {
        b();
        d(j2);
    }

    public void j(RecyclerView recyclerView) {
        this.f575e.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            c.f.h.a.a("RV Prefetch");
            if (!this.f575e.isEmpty()) {
                int size = this.f575e.size();
                long j2 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView = this.f575e.get(i2);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView.getDrawingTime(), j2);
                    }
                }
                if (j2 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j2) + this.g);
                }
            }
        } finally {
            this.f = 0L;
            c.f.h.a.b();
        }
    }
}
