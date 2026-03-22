package c.a.n;

import android.view.View;
import android.view.animation.Interpolator;
import c.f.l.w;
import c.f.l.x;
import c.f.l.y;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f659c;

    /* renamed from: d, reason: collision with root package name */
    x f660d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f661e;

    /* renamed from: b, reason: collision with root package name */
    private long f658b = -1;
    private final y f = new a();
    final ArrayList<w> a = new ArrayList<>();

    /* loaded from: classes.dex */
    class a extends y {
        private boolean a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f662b = 0;

        a() {
        }

        @Override // c.f.l.x
        public void a(View view) {
            int i = this.f662b + 1;
            this.f662b = i;
            if (i == h.this.a.size()) {
                x xVar = h.this.f660d;
                if (xVar != null) {
                    xVar.a(null);
                }
                d();
            }
        }

        @Override // c.f.l.y, c.f.l.x
        public void b(View view) {
            if (this.a) {
                return;
            }
            this.a = true;
            x xVar = h.this.f660d;
            if (xVar != null) {
                xVar.b(null);
            }
        }

        void d() {
            this.f662b = 0;
            this.a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f661e) {
            Iterator<w> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f661e = false;
        }
    }

    void b() {
        this.f661e = false;
    }

    public h c(w wVar) {
        if (!this.f661e) {
            this.a.add(wVar);
        }
        return this;
    }

    public h d(w wVar, w wVar2) {
        this.a.add(wVar);
        wVar2.h(wVar.c());
        this.a.add(wVar2);
        return this;
    }

    public h e(long j) {
        if (!this.f661e) {
            this.f658b = j;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f661e) {
            this.f659c = interpolator;
        }
        return this;
    }

    public h g(x xVar) {
        if (!this.f661e) {
            this.f660d = xVar;
        }
        return this;
    }

    public void h() {
        if (this.f661e) {
            return;
        }
        Iterator<w> it = this.a.iterator();
        while (it.hasNext()) {
            w next = it.next();
            long j = this.f658b;
            if (j >= 0) {
                next.d(j);
            }
            Interpolator interpolator = this.f659c;
            if (interpolator != null) {
                next.e(interpolator);
            }
            if (this.f660d != null) {
                next.f(this.f);
            }
            next.j();
        }
        this.f661e = true;
    }
}
