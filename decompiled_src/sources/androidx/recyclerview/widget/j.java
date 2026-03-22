package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class j {
    protected final RecyclerView.n a;

    /* renamed from: b, reason: collision with root package name */
    private int f589b;

    /* renamed from: c, reason: collision with root package name */
    final Rect f590c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends j {
        a(RecyclerView.n nVar) {
            super(nVar, null);
        }

        @Override // androidx.recyclerview.widget.j
        public int d(View view) {
            return this.a.T(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.o) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int e(View view) {
            RecyclerView.o oVar = (RecyclerView.o) view.getLayoutParams();
            return this.a.S(view) + ((ViewGroup.MarginLayoutParams) oVar).leftMargin + ((ViewGroup.MarginLayoutParams) oVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int f(View view) {
            RecyclerView.o oVar = (RecyclerView.o) view.getLayoutParams();
            return this.a.R(view) + ((ViewGroup.MarginLayoutParams) oVar).topMargin + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int g(View view) {
            return this.a.Q(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.o) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int h() {
            return this.a.o0();
        }

        @Override // androidx.recyclerview.widget.j
        public int i() {
            return this.a.o0() - this.a.f0();
        }

        @Override // androidx.recyclerview.widget.j
        public int j() {
            return this.a.f0();
        }

        @Override // androidx.recyclerview.widget.j
        public int k() {
            return this.a.p0();
        }

        @Override // androidx.recyclerview.widget.j
        public int l() {
            return this.a.X();
        }

        @Override // androidx.recyclerview.widget.j
        public int m() {
            return this.a.e0();
        }

        @Override // androidx.recyclerview.widget.j
        public int n() {
            return (this.a.o0() - this.a.e0()) - this.a.f0();
        }

        @Override // androidx.recyclerview.widget.j
        public int p(View view) {
            this.a.n0(view, true, this.f590c);
            return this.f590c.right;
        }

        @Override // androidx.recyclerview.widget.j
        public int q(View view) {
            this.a.n0(view, true, this.f590c);
            return this.f590c.left;
        }

        @Override // androidx.recyclerview.widget.j
        public void r(int i) {
            this.a.C0(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends j {
        b(RecyclerView.n nVar) {
            super(nVar, null);
        }

        @Override // androidx.recyclerview.widget.j
        public int d(View view) {
            return this.a.O(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.o) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int e(View view) {
            RecyclerView.o oVar = (RecyclerView.o) view.getLayoutParams();
            return this.a.R(view) + ((ViewGroup.MarginLayoutParams) oVar).topMargin + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int f(View view) {
            RecyclerView.o oVar = (RecyclerView.o) view.getLayoutParams();
            return this.a.S(view) + ((ViewGroup.MarginLayoutParams) oVar).leftMargin + ((ViewGroup.MarginLayoutParams) oVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int g(View view) {
            return this.a.U(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.o) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int h() {
            return this.a.W();
        }

        @Override // androidx.recyclerview.widget.j
        public int i() {
            return this.a.W() - this.a.d0();
        }

        @Override // androidx.recyclerview.widget.j
        public int j() {
            return this.a.d0();
        }

        @Override // androidx.recyclerview.widget.j
        public int k() {
            return this.a.X();
        }

        @Override // androidx.recyclerview.widget.j
        public int l() {
            return this.a.p0();
        }

        @Override // androidx.recyclerview.widget.j
        public int m() {
            return this.a.g0();
        }

        @Override // androidx.recyclerview.widget.j
        public int n() {
            return (this.a.W() - this.a.g0()) - this.a.d0();
        }

        @Override // androidx.recyclerview.widget.j
        public int p(View view) {
            this.a.n0(view, true, this.f590c);
            return this.f590c.bottom;
        }

        @Override // androidx.recyclerview.widget.j
        public int q(View view) {
            this.a.n0(view, true, this.f590c);
            return this.f590c.top;
        }

        @Override // androidx.recyclerview.widget.j
        public void r(int i) {
            this.a.D0(i);
        }
    }

    private j(RecyclerView.n nVar) {
        this.f589b = Integer.MIN_VALUE;
        this.f590c = new Rect();
        this.a = nVar;
    }

    /* synthetic */ j(RecyclerView.n nVar, a aVar) {
        this(nVar);
    }

    public static j a(RecyclerView.n nVar) {
        return new a(nVar);
    }

    public static j b(RecyclerView.n nVar, int i) {
        if (i == 0) {
            return a(nVar);
        }
        if (i == 1) {
            return c(nVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static j c(RecyclerView.n nVar) {
        return new b(nVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f589b) {
            return 0;
        }
        return n() - this.f589b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i);

    public void s() {
        this.f589b = n();
    }
}
