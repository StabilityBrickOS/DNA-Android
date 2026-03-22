package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.n implements RecyclerView.y.b {
    int A;
    int B;
    private boolean C;
    d D;
    final a E;
    private final b F;
    private int G;
    private int[] H;
    int s;
    private c t;
    j u;
    private boolean v;
    private boolean w;
    boolean x;
    private boolean y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        j a;

        /* renamed from: b, reason: collision with root package name */
        int f464b;

        /* renamed from: c, reason: collision with root package name */
        int f465c;

        /* renamed from: d, reason: collision with root package name */
        boolean f466d;

        /* renamed from: e, reason: collision with root package name */
        boolean f467e;

        a() {
            e();
        }

        void a() {
            this.f465c = this.f466d ? this.a.i() : this.a.m();
        }

        public void b(View view, int i) {
            this.f465c = this.f466d ? this.a.d(view) + this.a.o() : this.a.g(view);
            this.f464b = i;
        }

        public void c(View view, int i) {
            int o = this.a.o();
            if (o >= 0) {
                b(view, i);
                return;
            }
            this.f464b = i;
            if (this.f466d) {
                int i2 = (this.a.i() - o) - this.a.d(view);
                this.f465c = this.a.i() - i2;
                if (i2 > 0) {
                    int e2 = this.f465c - this.a.e(view);
                    int m = this.a.m();
                    int min = e2 - (m + Math.min(this.a.g(view) - m, 0));
                    if (min < 0) {
                        this.f465c += Math.min(i2, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g = this.a.g(view);
            int m2 = g - this.a.m();
            this.f465c = g;
            if (m2 > 0) {
                int i3 = (this.a.i() - Math.min(0, (this.a.i() - o) - this.a.d(view))) - (g + this.a.e(view));
                if (i3 < 0) {
                    this.f465c -= Math.min(m2, -i3);
                }
            }
        }

        boolean d(View view, RecyclerView.z zVar) {
            RecyclerView.o oVar = (RecyclerView.o) view.getLayoutParams();
            return !oVar.c() && oVar.a() >= 0 && oVar.a() < zVar.b();
        }

        void e() {
            this.f464b = -1;
            this.f465c = Integer.MIN_VALUE;
            this.f466d = false;
            this.f467e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f464b + ", mCoordinate=" + this.f465c + ", mLayoutFromEnd=" + this.f466d + ", mValid=" + this.f467e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class b {
        public int a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f468b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f469c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f470d;

        protected b() {
        }

        void a() {
            this.a = 0;
            this.f468b = false;
            this.f469c = false;
            this.f470d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b, reason: collision with root package name */
        int f471b;

        /* renamed from: c, reason: collision with root package name */
        int f472c;

        /* renamed from: d, reason: collision with root package name */
        int f473d;

        /* renamed from: e, reason: collision with root package name */
        int f474e;
        int f;
        int g;
        boolean j;
        int k;
        boolean m;
        boolean a = true;
        int h = 0;
        int i = 0;
        List<RecyclerView.c0> l = null;

        c() {
        }

        private View e() {
            int size = this.l.size();
            for (int i = 0; i < size; i++) {
                View view = this.l.get(i).a;
                RecyclerView.o oVar = (RecyclerView.o) view.getLayoutParams();
                if (!oVar.c() && this.f473d == oVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View f = f(view);
            this.f473d = f == null ? -1 : ((RecyclerView.o) f.getLayoutParams()).a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c(RecyclerView.z zVar) {
            int i = this.f473d;
            return i >= 0 && i < zVar.b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View d(RecyclerView.u uVar) {
            if (this.l != null) {
                return e();
            }
            View o = uVar.o(this.f473d);
            this.f473d += this.f474e;
            return o;
        }

        public View f(View view) {
            int a;
            int size = this.l.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.l.get(i2).a;
                RecyclerView.o oVar = (RecyclerView.o) view3.getLayoutParams();
                if (view3 != view && !oVar.c() && (a = (oVar.a() - this.f473d) * this.f474e) >= 0 && a < i) {
                    view2 = view3;
                    if (a == 0) {
                        break;
                    }
                    i = a;
                }
            }
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        int f475e;
        int f;
        boolean g;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i) {
                return new d[i];
            }
        }

        public d() {
        }

        d(Parcel parcel) {
            this.f475e = parcel.readInt();
            this.f = parcel.readInt();
            this.g = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f475e = dVar.f475e;
            this.f = dVar.f;
            this.g = dVar.g;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        boolean f() {
            return this.f475e >= 0;
        }

        void g() {
            this.f475e = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f475e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        C2(i);
        D2(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.n.d i0 = RecyclerView.n.i0(context, attributeSet, i, i2);
        C2(i0.a);
        D2(i0.f494c);
        E2(i0.f495d);
    }

    private void A2() {
        this.x = (this.s == 1 || !q2()) ? this.w : !this.w;
    }

    private boolean F2(RecyclerView.u uVar, RecyclerView.z zVar, a aVar) {
        if (J() == 0) {
            return false;
        }
        View V = V();
        if (V != null && aVar.d(V, zVar)) {
            aVar.c(V, h0(V));
            return true;
        }
        if (this.v != this.y) {
            return false;
        }
        View i2 = aVar.f466d ? i2(uVar, zVar) : j2(uVar, zVar);
        if (i2 == null) {
            return false;
        }
        aVar.b(i2, h0(i2));
        if (!zVar.e() && L1()) {
            if (this.u.g(i2) >= this.u.i() || this.u.d(i2) < this.u.m()) {
                aVar.f465c = aVar.f466d ? this.u.i() : this.u.m();
            }
        }
        return true;
    }

    private boolean G2(RecyclerView.z zVar, a aVar) {
        int i;
        if (!zVar.e() && (i = this.A) != -1) {
            if (i >= 0 && i < zVar.b()) {
                aVar.f464b = this.A;
                d dVar = this.D;
                if (dVar != null && dVar.f()) {
                    boolean z = this.D.g;
                    aVar.f466d = z;
                    aVar.f465c = z ? this.u.i() - this.D.f : this.u.m() + this.D.f;
                    return true;
                }
                if (this.B != Integer.MIN_VALUE) {
                    boolean z2 = this.x;
                    aVar.f466d = z2;
                    aVar.f465c = z2 ? this.u.i() - this.B : this.u.m() + this.B;
                    return true;
                }
                View C = C(this.A);
                if (C == null) {
                    if (J() > 0) {
                        aVar.f466d = (this.A < h0(I(0))) == this.x;
                    }
                    aVar.a();
                } else {
                    if (this.u.e(C) > this.u.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.u.g(C) - this.u.m() < 0) {
                        aVar.f465c = this.u.m();
                        aVar.f466d = false;
                        return true;
                    }
                    if (this.u.i() - this.u.d(C) < 0) {
                        aVar.f465c = this.u.i();
                        aVar.f466d = true;
                        return true;
                    }
                    aVar.f465c = aVar.f466d ? this.u.d(C) + this.u.o() : this.u.g(C);
                }
                return true;
            }
            this.A = -1;
            this.B = Integer.MIN_VALUE;
        }
        return false;
    }

    private void H2(RecyclerView.u uVar, RecyclerView.z zVar, a aVar) {
        if (G2(zVar, aVar) || F2(uVar, zVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f464b = this.y ? zVar.b() - 1 : 0;
    }

    private void I2(int i, int i2, boolean z, RecyclerView.z zVar) {
        int m;
        this.t.m = z2();
        this.t.f = i;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(zVar, iArr);
        int max = Math.max(0, this.H[0]);
        int max2 = Math.max(0, this.H[1]);
        boolean z2 = i == 1;
        this.t.h = z2 ? max2 : max;
        c cVar = this.t;
        if (!z2) {
            max = max2;
        }
        cVar.i = max;
        if (z2) {
            this.t.h += this.u.j();
            View m2 = m2();
            this.t.f474e = this.x ? -1 : 1;
            c cVar2 = this.t;
            int h0 = h0(m2);
            c cVar3 = this.t;
            cVar2.f473d = h0 + cVar3.f474e;
            cVar3.f471b = this.u.d(m2);
            m = this.u.d(m2) - this.u.i();
        } else {
            View n2 = n2();
            this.t.h += this.u.m();
            this.t.f474e = this.x ? 1 : -1;
            c cVar4 = this.t;
            int h02 = h0(n2);
            c cVar5 = this.t;
            cVar4.f473d = h02 + cVar5.f474e;
            cVar5.f471b = this.u.g(n2);
            m = (-this.u.g(n2)) + this.u.m();
        }
        c cVar6 = this.t;
        cVar6.f472c = i2;
        if (z) {
            cVar6.f472c = i2 - m;
        }
        this.t.g = m;
    }

    private void J2(int i, int i2) {
        this.t.f472c = this.u.i() - i2;
        this.t.f474e = this.x ? -1 : 1;
        c cVar = this.t;
        cVar.f473d = i;
        cVar.f = 1;
        cVar.f471b = i2;
        cVar.g = Integer.MIN_VALUE;
    }

    private void K2(a aVar) {
        J2(aVar.f464b, aVar.f465c);
    }

    private void L2(int i, int i2) {
        this.t.f472c = i2 - this.u.m();
        c cVar = this.t;
        cVar.f473d = i;
        cVar.f474e = this.x ? 1 : -1;
        c cVar2 = this.t;
        cVar2.f = -1;
        cVar2.f471b = i2;
        cVar2.g = Integer.MIN_VALUE;
    }

    private void M2(a aVar) {
        L2(aVar.f464b, aVar.f465c);
    }

    private int O1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.a(zVar, this.u, Y1(!this.z, true), X1(!this.z, true), this, this.z);
    }

    private int P1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.b(zVar, this.u, Y1(!this.z, true), X1(!this.z, true), this, this.z, this.x);
    }

    private int Q1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.c(zVar, this.u, Y1(!this.z, true), X1(!this.z, true), this, this.z);
    }

    private View V1() {
        return d2(0, J());
    }

    private View W1(RecyclerView.u uVar, RecyclerView.z zVar) {
        return h2(uVar, zVar, 0, J(), zVar.b());
    }

    private View a2() {
        return d2(J() - 1, -1);
    }

    private View b2(RecyclerView.u uVar, RecyclerView.z zVar) {
        return h2(uVar, zVar, J() - 1, -1, zVar.b());
    }

    private View f2() {
        return this.x ? V1() : a2();
    }

    private View g2() {
        return this.x ? a2() : V1();
    }

    private View i2(RecyclerView.u uVar, RecyclerView.z zVar) {
        return this.x ? W1(uVar, zVar) : b2(uVar, zVar);
    }

    private View j2(RecyclerView.u uVar, RecyclerView.z zVar) {
        return this.x ? b2(uVar, zVar) : W1(uVar, zVar);
    }

    private int k2(int i, RecyclerView.u uVar, RecyclerView.z zVar, boolean z) {
        int i2;
        int i3 = this.u.i() - i;
        if (i3 <= 0) {
            return 0;
        }
        int i4 = -B2(-i3, uVar, zVar);
        int i5 = i + i4;
        if (!z || (i2 = this.u.i() - i5) <= 0) {
            return i4;
        }
        this.u.r(i2);
        return i2 + i4;
    }

    private int l2(int i, RecyclerView.u uVar, RecyclerView.z zVar, boolean z) {
        int m;
        int m2 = i - this.u.m();
        if (m2 <= 0) {
            return 0;
        }
        int i2 = -B2(m2, uVar, zVar);
        int i3 = i + i2;
        if (!z || (m = i3 - this.u.m()) <= 0) {
            return i2;
        }
        this.u.r(-m);
        return i2 - m;
    }

    private View m2() {
        return I(this.x ? 0 : J() - 1);
    }

    private View n2() {
        return I(this.x ? J() - 1 : 0);
    }

    private void t2(RecyclerView.u uVar, RecyclerView.z zVar, int i, int i2) {
        if (!zVar.g() || J() == 0 || zVar.e() || !L1()) {
            return;
        }
        List<RecyclerView.c0> k = uVar.k();
        int size = k.size();
        int h0 = h0(I(0));
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.c0 c0Var = k.get(i5);
            if (!c0Var.v()) {
                char c2 = (c0Var.m() < h0) != this.x ? (char) 65535 : (char) 1;
                int e2 = this.u.e(c0Var.a);
                if (c2 == 65535) {
                    i3 += e2;
                } else {
                    i4 += e2;
                }
            }
        }
        this.t.l = k;
        if (i3 > 0) {
            L2(h0(n2()), i);
            c cVar = this.t;
            cVar.h = i3;
            cVar.f472c = 0;
            cVar.a();
            U1(uVar, this.t, zVar, false);
        }
        if (i4 > 0) {
            J2(h0(m2()), i2);
            c cVar2 = this.t;
            cVar2.h = i4;
            cVar2.f472c = 0;
            cVar2.a();
            U1(uVar, this.t, zVar, false);
        }
        this.t.l = null;
    }

    private void v2(RecyclerView.u uVar, c cVar) {
        if (!cVar.a || cVar.m) {
            return;
        }
        int i = cVar.g;
        int i2 = cVar.i;
        if (cVar.f == -1) {
            x2(uVar, i, i2);
        } else {
            y2(uVar, i, i2);
        }
    }

    private void w2(RecyclerView.u uVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                n1(i, uVar);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                n1(i3, uVar);
            }
        }
    }

    private void x2(RecyclerView.u uVar, int i, int i2) {
        int J = J();
        if (i < 0) {
            return;
        }
        int h = (this.u.h() - i) + i2;
        if (this.x) {
            for (int i3 = 0; i3 < J; i3++) {
                View I = I(i3);
                if (this.u.g(I) < h || this.u.q(I) < h) {
                    w2(uVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = J - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View I2 = I(i5);
            if (this.u.g(I2) < h || this.u.q(I2) < h) {
                w2(uVar, i4, i5);
                return;
            }
        }
    }

    private void y2(RecyclerView.u uVar, int i, int i2) {
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int J = J();
        if (!this.x) {
            for (int i4 = 0; i4 < J; i4++) {
                View I = I(i4);
                if (this.u.d(I) > i3 || this.u.p(I) > i3) {
                    w2(uVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = J - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View I2 = I(i6);
            if (this.u.d(I2) > i3 || this.u.p(I2) > i3) {
                w2(uVar, i5, i6);
                return;
            }
        }
    }

    int B2(int i, RecyclerView.u uVar, RecyclerView.z zVar) {
        if (J() == 0 || i == 0) {
            return 0;
        }
        T1();
        this.t.a = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        I2(i2, abs, true, zVar);
        c cVar = this.t;
        int U1 = cVar.g + U1(uVar, cVar, zVar, false);
        if (U1 < 0) {
            return 0;
        }
        if (abs > U1) {
            i = i2 * U1;
        }
        this.u.r(-i);
        this.t.k = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public View C(int i) {
        int J = J();
        if (J == 0) {
            return null;
        }
        int h0 = i - h0(I(0));
        if (h0 >= 0 && h0 < J) {
            View I = I(h0);
            if (h0(I) == i) {
                return I;
            }
        }
        return super.C(i);
    }

    public void C2(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        g(null);
        if (i != this.s || this.u == null) {
            j b2 = j.b(this, i);
            this.u = b2;
            this.E.a = b2;
            this.s = i;
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o D() {
        return new RecyclerView.o(-2, -2);
    }

    public void D2(boolean z) {
        g(null);
        if (z == this.w) {
            return;
        }
        this.w = z;
        t1();
    }

    public void E2(boolean z) {
        g(null);
        if (this.y == z) {
            return;
        }
        this.y = z;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    boolean G1() {
        return (X() == 1073741824 || p0() == 1073741824 || !q0()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void I0(RecyclerView recyclerView, RecyclerView.u uVar) {
        super.I0(recyclerView, uVar);
        if (this.C) {
            k1(uVar);
            uVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void I1(RecyclerView recyclerView, RecyclerView.z zVar, int i) {
        g gVar = new g(recyclerView.getContext());
        gVar.p(i);
        J1(gVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public View J0(View view, int i, RecyclerView.u uVar, RecyclerView.z zVar) {
        int R1;
        A2();
        if (J() == 0 || (R1 = R1(i)) == Integer.MIN_VALUE) {
            return null;
        }
        T1();
        I2(R1, (int) (this.u.n() * 0.33333334f), false, zVar);
        c cVar = this.t;
        cVar.g = Integer.MIN_VALUE;
        cVar.a = false;
        U1(uVar, cVar, zVar, true);
        View g2 = R1 == -1 ? g2() : f2();
        View n2 = R1 == -1 ? n2() : m2();
        if (!n2.hasFocusable()) {
            return g2;
        }
        if (g2 == null) {
            return null;
        }
        return n2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void K0(AccessibilityEvent accessibilityEvent) {
        super.K0(accessibilityEvent);
        if (J() > 0) {
            accessibilityEvent.setFromIndex(Z1());
            accessibilityEvent.setToIndex(c2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean L1() {
        return this.D == null && this.v == this.y;
    }

    protected void M1(RecyclerView.z zVar, int[] iArr) {
        int i;
        int o2 = o2(zVar);
        if (this.t.f == -1) {
            i = 0;
        } else {
            i = o2;
            o2 = 0;
        }
        iArr[0] = o2;
        iArr[1] = i;
    }

    void N1(RecyclerView.z zVar, c cVar, RecyclerView.n.c cVar2) {
        int i = cVar.f473d;
        if (i < 0 || i >= zVar.b()) {
            return;
        }
        cVar2.a(i, Math.max(0, cVar.g));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int R1(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.s == 1) ? 1 : Integer.MIN_VALUE : this.s == 0 ? 1 : Integer.MIN_VALUE : this.s == 1 ? -1 : Integer.MIN_VALUE : this.s == 0 ? -1 : Integer.MIN_VALUE : (this.s != 1 && q2()) ? -1 : 1 : (this.s != 1 && q2()) ? 1 : -1;
    }

    c S1() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T1() {
        if (this.t == null) {
            this.t = S1();
        }
    }

    int U1(RecyclerView.u uVar, c cVar, RecyclerView.z zVar, boolean z) {
        int i = cVar.f472c;
        int i2 = cVar.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.g = i2 + i;
            }
            v2(uVar, cVar);
        }
        int i3 = cVar.f472c + cVar.h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.m && i3 <= 0) || !cVar.c(zVar)) {
                break;
            }
            bVar.a();
            s2(uVar, zVar, cVar, bVar);
            if (!bVar.f468b) {
                cVar.f471b += bVar.a * cVar.f;
                if (!bVar.f469c || cVar.l != null || !zVar.e()) {
                    int i4 = cVar.f472c;
                    int i5 = bVar.a;
                    cVar.f472c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.g;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + bVar.a;
                    cVar.g = i7;
                    int i8 = cVar.f472c;
                    if (i8 < 0) {
                        cVar.g = i7 + i8;
                    }
                    v2(uVar, cVar);
                }
                if (z && bVar.f470d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.f472c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void X0(RecyclerView.u uVar, RecyclerView.z zVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int k2;
        int i5;
        View C;
        int g;
        int i6;
        int i7 = -1;
        if (!(this.D == null && this.A == -1) && zVar.b() == 0) {
            k1(uVar);
            return;
        }
        d dVar = this.D;
        if (dVar != null && dVar.f()) {
            this.A = this.D.f475e;
        }
        T1();
        this.t.a = false;
        A2();
        View V = V();
        if (!this.E.f467e || this.A != -1 || this.D != null) {
            this.E.e();
            a aVar = this.E;
            aVar.f466d = this.x ^ this.y;
            H2(uVar, zVar, aVar);
            this.E.f467e = true;
        } else if (V != null && (this.u.g(V) >= this.u.i() || this.u.d(V) <= this.u.m())) {
            this.E.c(V, h0(V));
        }
        c cVar = this.t;
        cVar.f = cVar.k >= 0 ? 1 : -1;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(zVar, iArr);
        int max = Math.max(0, this.H[0]) + this.u.m();
        int max2 = Math.max(0, this.H[1]) + this.u.j();
        if (zVar.e() && (i5 = this.A) != -1 && this.B != Integer.MIN_VALUE && (C = C(i5)) != null) {
            if (this.x) {
                i6 = this.u.i() - this.u.d(C);
                g = this.B;
            } else {
                g = this.u.g(C) - this.u.m();
                i6 = this.B;
            }
            int i8 = i6 - g;
            if (i8 > 0) {
                max += i8;
            } else {
                max2 -= i8;
            }
        }
        if (!this.E.f466d ? !this.x : this.x) {
            i7 = 1;
        }
        u2(uVar, zVar, this.E, i7);
        w(uVar);
        this.t.m = z2();
        this.t.j = zVar.e();
        this.t.i = 0;
        a aVar2 = this.E;
        if (aVar2.f466d) {
            M2(aVar2);
            c cVar2 = this.t;
            cVar2.h = max;
            U1(uVar, cVar2, zVar, false);
            c cVar3 = this.t;
            i2 = cVar3.f471b;
            int i9 = cVar3.f473d;
            int i10 = cVar3.f472c;
            if (i10 > 0) {
                max2 += i10;
            }
            K2(this.E);
            c cVar4 = this.t;
            cVar4.h = max2;
            cVar4.f473d += cVar4.f474e;
            U1(uVar, cVar4, zVar, false);
            c cVar5 = this.t;
            i = cVar5.f471b;
            int i11 = cVar5.f472c;
            if (i11 > 0) {
                L2(i9, i2);
                c cVar6 = this.t;
                cVar6.h = i11;
                U1(uVar, cVar6, zVar, false);
                i2 = this.t.f471b;
            }
        } else {
            K2(aVar2);
            c cVar7 = this.t;
            cVar7.h = max2;
            U1(uVar, cVar7, zVar, false);
            c cVar8 = this.t;
            i = cVar8.f471b;
            int i12 = cVar8.f473d;
            int i13 = cVar8.f472c;
            if (i13 > 0) {
                max += i13;
            }
            M2(this.E);
            c cVar9 = this.t;
            cVar9.h = max;
            cVar9.f473d += cVar9.f474e;
            U1(uVar, cVar9, zVar, false);
            c cVar10 = this.t;
            i2 = cVar10.f471b;
            int i14 = cVar10.f472c;
            if (i14 > 0) {
                J2(i12, i);
                c cVar11 = this.t;
                cVar11.h = i14;
                U1(uVar, cVar11, zVar, false);
                i = this.t.f471b;
            }
        }
        if (J() > 0) {
            if (this.x ^ this.y) {
                int k22 = k2(i, uVar, zVar, true);
                i3 = i2 + k22;
                i4 = i + k22;
                k2 = l2(i3, uVar, zVar, false);
            } else {
                int l2 = l2(i2, uVar, zVar, true);
                i3 = i2 + l2;
                i4 = i + l2;
                k2 = k2(i4, uVar, zVar, false);
            }
            i2 = i3 + k2;
            i = i4 + k2;
        }
        t2(uVar, zVar, i2, i);
        if (zVar.e()) {
            this.E.e();
        } else {
            this.u.s();
        }
        this.v = this.y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View X1(boolean z, boolean z2) {
        int J;
        int i;
        if (this.x) {
            J = 0;
            i = J();
        } else {
            J = J() - 1;
            i = -1;
        }
        return e2(J, i, z, z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void Y0(RecyclerView.z zVar) {
        super.Y0(zVar);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Y1(boolean z, boolean z2) {
        int i;
        int J;
        if (this.x) {
            i = J() - 1;
            J = -1;
        } else {
            i = 0;
            J = J();
        }
        return e2(i, J, z, z2);
    }

    public int Z1() {
        View e2 = e2(0, J(), false, true);
        if (e2 == null) {
            return -1;
        }
        return h0(e2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public PointF a(int i) {
        if (J() == 0) {
            return null;
        }
        int i2 = (i < h0(I(0))) != this.x ? -1 : 1;
        return this.s == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void c1(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.D = (d) parcelable;
            t1();
        }
    }

    public int c2() {
        View e2 = e2(J() - 1, -1, false, true);
        if (e2 == null) {
            return -1;
        }
        return h0(e2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public Parcelable d1() {
        if (this.D != null) {
            return new d(this.D);
        }
        d dVar = new d();
        if (J() > 0) {
            T1();
            boolean z = this.v ^ this.x;
            dVar.g = z;
            if (z) {
                View m2 = m2();
                dVar.f = this.u.i() - this.u.d(m2);
                dVar.f475e = h0(m2);
            } else {
                View n2 = n2();
                dVar.f475e = h0(n2);
                dVar.f = this.u.g(n2) - this.u.m();
            }
        } else {
            dVar.g();
        }
        return dVar;
    }

    View d2(int i, int i2) {
        int i3;
        int i4;
        T1();
        if ((i2 > i ? (char) 1 : i2 < i ? (char) 65535 : (char) 0) == 0) {
            return I(i);
        }
        if (this.u.g(I(i)) < this.u.m()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return (this.s == 0 ? this.f492e : this.f).a(i, i2, i3, i4);
    }

    View e2(int i, int i2, boolean z, boolean z2) {
        T1();
        return (this.s == 0 ? this.f492e : this.f).a(i, i2, z ? 24579 : 320, z2 ? 320 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g(String str) {
        if (this.D == null) {
            super.g(str);
        }
    }

    View h2(RecyclerView.u uVar, RecyclerView.z zVar, int i, int i2, int i3) {
        T1();
        int m = this.u.m();
        int i4 = this.u.i();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View I = I(i);
            int h0 = h0(I);
            if (h0 >= 0 && h0 < i3) {
                if (((RecyclerView.o) I.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = I;
                    }
                } else {
                    if (this.u.g(I) < i4 && this.u.d(I) >= m) {
                        return I;
                    }
                    if (view == null) {
                        view = I;
                    }
                }
            }
            i += i5;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean k() {
        return this.s == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean l() {
        return this.s == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void o(int i, int i2, RecyclerView.z zVar, RecyclerView.n.c cVar) {
        if (this.s != 0) {
            i = i2;
        }
        if (J() == 0 || i == 0) {
            return;
        }
        T1();
        I2(i > 0 ? 1 : -1, Math.abs(i), true, zVar);
        N1(zVar, this.t, cVar);
    }

    @Deprecated
    protected int o2(RecyclerView.z zVar) {
        if (zVar.d()) {
            return this.u.n();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void p(int i, RecyclerView.n.c cVar) {
        boolean z;
        int i2;
        d dVar = this.D;
        if (dVar == null || !dVar.f()) {
            A2();
            z = this.x;
            i2 = this.A;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            d dVar2 = this.D;
            z = dVar2.g;
            i2 = dVar2.f475e;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.G && i2 >= 0 && i2 < i; i4++) {
            cVar.a(i2, 0);
            i2 += i3;
        }
    }

    public int p2() {
        return this.s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int q(RecyclerView.z zVar) {
        return O1(zVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int r(RecyclerView.z zVar) {
        return P1(zVar);
    }

    public boolean r2() {
        return this.z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int s(RecyclerView.z zVar) {
        return Q1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean s0() {
        return true;
    }

    void s2(RecyclerView.u uVar, RecyclerView.z zVar, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int f;
        View d2 = cVar.d(uVar);
        if (d2 == null) {
            bVar.f468b = true;
            return;
        }
        RecyclerView.o oVar = (RecyclerView.o) d2.getLayoutParams();
        if (cVar.l == null) {
            if (this.x == (cVar.f == -1)) {
                d(d2);
            } else {
                e(d2, 0);
            }
        } else {
            if (this.x == (cVar.f == -1)) {
                b(d2);
            } else {
                c(d2, 0);
            }
        }
        A0(d2, 0, 0);
        bVar.a = this.u.e(d2);
        if (this.s == 1) {
            if (q2()) {
                f = o0() - f0();
                i4 = f - this.u.f(d2);
            } else {
                i4 = e0();
                f = this.u.f(d2) + i4;
            }
            int i5 = cVar.f;
            int i6 = cVar.f471b;
            if (i5 == -1) {
                i3 = i6;
                i2 = f;
                i = i6 - bVar.a;
            } else {
                i = i6;
                i2 = f;
                i3 = bVar.a + i6;
            }
        } else {
            int g0 = g0();
            int f2 = this.u.f(d2) + g0;
            int i7 = cVar.f;
            int i8 = cVar.f471b;
            if (i7 == -1) {
                i2 = i8;
                i = g0;
                i3 = f2;
                i4 = i8 - bVar.a;
            } else {
                i = g0;
                i2 = bVar.a + i8;
                i3 = f2;
                i4 = i8;
            }
        }
        z0(d2, i4, i, i2, i3);
        if (oVar.c() || oVar.b()) {
            bVar.f469c = true;
        }
        bVar.f470d = d2.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int t(RecyclerView.z zVar) {
        return O1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int u(RecyclerView.z zVar) {
        return P1(zVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u2(RecyclerView.u uVar, RecyclerView.z zVar, a aVar, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int v(RecyclerView.z zVar) {
        return Q1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int w1(int i, RecyclerView.u uVar, RecyclerView.z zVar) {
        if (this.s == 1) {
            return 0;
        }
        return B2(i, uVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void x1(int i) {
        this.A = i;
        this.B = Integer.MIN_VALUE;
        d dVar = this.D;
        if (dVar != null) {
            dVar.g();
        }
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int y1(int i, RecyclerView.u uVar, RecyclerView.z zVar) {
        if (this.s == 0) {
            return 0;
        }
        return B2(i, uVar, zVar);
    }

    boolean z2() {
        return this.u.k() == 0 && this.u.h() == 0;
    }
}
