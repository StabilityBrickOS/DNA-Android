package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class n extends RecyclerView.q {
    RecyclerView a;

    /* renamed from: b, reason: collision with root package name */
    private Scroller f595b;

    /* renamed from: c, reason: collision with root package name */
    private final RecyclerView.s f596c = new a();

    /* loaded from: classes.dex */
    class a extends RecyclerView.s {
        boolean a = false;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, int i) {
            super.a(recyclerView, i);
            if (i == 0 && this.a) {
                this.a = false;
                n.this.l();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.a = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g {
        b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.g, androidx.recyclerview.widget.RecyclerView.y
        protected void o(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
            n nVar = n.this;
            RecyclerView recyclerView = nVar.a;
            if (recyclerView == null) {
                return;
            }
            int[] c2 = nVar.c(recyclerView.getLayoutManager(), view);
            int i = c2[0];
            int i2 = c2[1];
            int w = w(Math.max(Math.abs(i), Math.abs(i2)));
            if (w > 0) {
                aVar.d(i, i2, w, this.j);
            }
        }

        @Override // androidx.recyclerview.widget.g
        protected float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    private void g() {
        this.a.X0(this.f596c);
        this.a.setOnFlingListener(null);
    }

    private void j() {
        if (this.a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.a.k(this.f596c);
        this.a.setOnFlingListener(this);
    }

    private boolean k(RecyclerView.n nVar, int i, int i2) {
        RecyclerView.y e2;
        int i3;
        if (!(nVar instanceof RecyclerView.y.b) || (e2 = e(nVar)) == null || (i3 = i(nVar, i, i2)) == -1) {
            return false;
        }
        e2.p(i3);
        nVar.J1(e2);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean a(int i, int i2) {
        RecyclerView.n layoutManager = this.a.getLayoutManager();
        if (layoutManager == null || this.a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.a.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && k(layoutManager, i, i2);
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            g();
        }
        this.a = recyclerView;
        if (recyclerView != null) {
            j();
            this.f595b = new Scroller(this.a.getContext(), new DecelerateInterpolator());
            l();
        }
    }

    public abstract int[] c(RecyclerView.n nVar, View view);

    public int[] d(int i, int i2) {
        this.f595b.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.f595b.getFinalX(), this.f595b.getFinalY()};
    }

    protected RecyclerView.y e(RecyclerView.n nVar) {
        return f(nVar);
    }

    @Deprecated
    protected g f(RecyclerView.n nVar) {
        if (nVar instanceof RecyclerView.y.b) {
            return new b(this.a.getContext());
        }
        return null;
    }

    public abstract View h(RecyclerView.n nVar);

    public abstract int i(RecyclerView.n nVar, int i, int i2);

    void l() {
        RecyclerView.n layoutManager;
        View h;
        RecyclerView recyclerView = this.a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (h = h(layoutManager)) == null) {
            return;
        }
        int[] c2 = c(layoutManager, h);
        if (c2[0] == 0 && c2[1] == 0) {
            return;
        }
        this.a.k1(c2[0], c2[1]);
    }
}
