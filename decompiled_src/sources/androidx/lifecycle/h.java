package androidx.lifecycle;

import androidx.lifecycle.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class h extends d {

    /* renamed from: c, reason: collision with root package name */
    private final WeakReference<g> f447c;
    private c.b.a.b.a<f, b> a = new c.b.a.b.a<>();

    /* renamed from: d, reason: collision with root package name */
    private int f448d = 0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f449e = false;
    private boolean f = false;
    private ArrayList<d.b> g = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private d.b f446b = d.b.INITIALIZED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f450b;

        static {
            int[] iArr = new int[d.b.values().length];
            f450b = iArr;
            try {
                iArr[d.b.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f450b[d.b.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f450b[d.b.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f450b[d.b.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f450b[d.b.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[d.a.values().length];
            a = iArr2;
            try {
                iArr2[d.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[d.a.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[d.a.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[d.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[d.a.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[d.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[d.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        d.b a;

        /* renamed from: b, reason: collision with root package name */
        e f451b;

        b(f fVar, d.b bVar) {
            this.f451b = j.f(fVar);
            this.a = bVar;
        }

        void a(g gVar, d.a aVar) {
            d.b h = h.h(aVar);
            this.a = h.l(this.a, h);
            this.f451b.d(gVar, aVar);
            this.a = h;
        }
    }

    public h(g gVar) {
        this.f447c = new WeakReference<>(gVar);
    }

    private void d(g gVar) {
        Iterator<Map.Entry<f, b>> a2 = this.a.a();
        while (a2.hasNext() && !this.f) {
            Map.Entry<f, b> next = a2.next();
            b value = next.getValue();
            while (value.a.compareTo(this.f446b) > 0 && !this.f && this.a.contains(next.getKey())) {
                d.a f = f(value.a);
                o(h(f));
                value.a(gVar, f);
                n();
            }
        }
    }

    private d.b e(f fVar) {
        Map.Entry<f, b> i = this.a.i(fVar);
        d.b bVar = null;
        d.b bVar2 = i != null ? i.getValue().a : null;
        if (!this.g.isEmpty()) {
            bVar = this.g.get(r0.size() - 1);
        }
        return l(l(this.f446b, bVar2), bVar);
    }

    private static d.a f(d.b bVar) {
        int i = a.f450b[bVar.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException();
        }
        if (i == 2) {
            return d.a.ON_DESTROY;
        }
        if (i == 3) {
            return d.a.ON_STOP;
        }
        if (i == 4) {
            return d.a.ON_PAUSE;
        }
        if (i == 5) {
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException("Unexpected state value " + bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void g(g gVar) {
        c.b.a.b.b<f, b>.d d2 = this.a.d();
        while (d2.hasNext() && !this.f) {
            Map.Entry next = d2.next();
            b bVar = (b) next.getValue();
            while (bVar.a.compareTo(this.f446b) < 0 && !this.f && this.a.contains(next.getKey())) {
                o(bVar.a);
                bVar.a(gVar, r(bVar.a));
                n();
            }
        }
    }

    static d.b h(d.a aVar) {
        switch (a.a[aVar.ordinal()]) {
            case 1:
            case 2:
                return d.b.CREATED;
            case 3:
            case 4:
                return d.b.STARTED;
            case 5:
                return d.b.RESUMED;
            case 6:
                return d.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private boolean j() {
        if (this.a.size() == 0) {
            return true;
        }
        d.b bVar = this.a.b().getValue().a;
        d.b bVar2 = this.a.e().getValue().a;
        return bVar == bVar2 && this.f446b == bVar2;
    }

    static d.b l(d.b bVar, d.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    private void m(d.b bVar) {
        if (this.f446b == bVar) {
            return;
        }
        this.f446b = bVar;
        if (this.f449e || this.f448d != 0) {
            this.f = true;
            return;
        }
        this.f449e = true;
        q();
        this.f449e = false;
    }

    private void n() {
        this.g.remove(r0.size() - 1);
    }

    private void o(d.b bVar) {
        this.g.add(bVar);
    }

    private void q() {
        g gVar = this.f447c.get();
        if (gVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            boolean j = j();
            this.f = false;
            if (j) {
                return;
            }
            if (this.f446b.compareTo(this.a.b().getValue().a) < 0) {
                d(gVar);
            }
            Map.Entry<f, b> e2 = this.a.e();
            if (!this.f && e2 != null && this.f446b.compareTo(e2.getValue().a) > 0) {
                g(gVar);
            }
        }
    }

    private static d.a r(d.b bVar) {
        int i = a.f450b[bVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return d.a.ON_START;
            }
            if (i == 3) {
                return d.a.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return d.a.ON_CREATE;
    }

    @Override // androidx.lifecycle.d
    public void a(f fVar) {
        g gVar;
        d.b bVar = this.f446b;
        d.b bVar2 = d.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = d.b.INITIALIZED;
        }
        b bVar3 = new b(fVar, bVar2);
        if (this.a.g(fVar, bVar3) == null && (gVar = this.f447c.get()) != null) {
            boolean z = this.f448d != 0 || this.f449e;
            d.b e2 = e(fVar);
            this.f448d++;
            while (bVar3.a.compareTo(e2) < 0 && this.a.contains(fVar)) {
                o(bVar3.a);
                bVar3.a(gVar, r(bVar3.a));
                n();
                e2 = e(fVar);
            }
            if (!z) {
                q();
            }
            this.f448d--;
        }
    }

    @Override // androidx.lifecycle.d
    public d.b b() {
        return this.f446b;
    }

    @Override // androidx.lifecycle.d
    public void c(f fVar) {
        this.a.h(fVar);
    }

    public void i(d.a aVar) {
        m(h(aVar));
    }

    @Deprecated
    public void k(d.b bVar) {
        p(bVar);
    }

    public void p(d.b bVar) {
        m(bVar);
    }
}
