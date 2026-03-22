package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.k0;
import androidx.appcompat.widget.l0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends k implements m, View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int F = c.a.g.abc_cascading_menu_item_layout;
    private boolean A;
    private m.a B;
    ViewTreeObserver C;
    private PopupWindow.OnDismissListener D;
    boolean E;
    private final Context f;
    private final int g;
    private final int h;
    private final int i;
    private final boolean j;
    final Handler k;
    private View s;
    View t;
    private boolean v;
    private boolean w;
    private int x;
    private int y;
    private final List<g> l = new ArrayList();
    final List<C0005d> m = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener n = new a();
    private final View.OnAttachStateChangeListener o = new b();
    private final k0 p = new c();
    private int q = 0;
    private int r = 0;
    private boolean z = false;
    private int u = D();

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!d.this.c() || d.this.m.size() <= 0 || d.this.m.get(0).a.B()) {
                return;
            }
            View view = d.this.t;
            if (view == null || !view.isShown()) {
                d.this.dismiss();
                return;
            }
            Iterator<C0005d> it = d.this.m.iterator();
            while (it.hasNext()) {
                it.next().a.a();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = d.this.C;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.C = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.C.removeGlobalOnLayoutListener(dVar.n);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* loaded from: classes.dex */
    class c implements k0 {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ C0005d f116e;
            final /* synthetic */ MenuItem f;
            final /* synthetic */ g g;

            a(C0005d c0005d, MenuItem menuItem, g gVar) {
                this.f116e = c0005d;
                this.f = menuItem;
                this.g = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0005d c0005d = this.f116e;
                if (c0005d != null) {
                    d.this.E = true;
                    c0005d.f117b.e(false);
                    d.this.E = false;
                }
                if (this.f.isEnabled() && this.f.hasSubMenu()) {
                    this.g.L(this.f, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.k0
        public void g(g gVar, MenuItem menuItem) {
            d.this.k.removeCallbacksAndMessages(null);
            int size = d.this.m.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (gVar == d.this.m.get(i).f117b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            d.this.k.postAtTime(new a(i2 < d.this.m.size() ? d.this.m.get(i2) : null, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.k0
        public void i(g gVar, MenuItem menuItem) {
            d.this.k.removeCallbacksAndMessages(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.appcompat.view.menu.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0005d {
        public final l0 a;

        /* renamed from: b, reason: collision with root package name */
        public final g f117b;

        /* renamed from: c, reason: collision with root package name */
        public final int f118c;

        public C0005d(l0 l0Var, g gVar, int i) {
            this.a = l0Var;
            this.f117b = gVar;
            this.f118c = i;
        }

        public ListView a() {
            return this.a.l();
        }
    }

    public d(Context context, View view, int i, int i2, boolean z) {
        this.f = context;
        this.s = view;
        this.h = i;
        this.i = i2;
        this.j = z;
        Resources resources = context.getResources();
        this.g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(c.a.d.abc_config_prefDialogWidth));
        this.k = new Handler();
    }

    private int A(g gVar) {
        int size = this.m.size();
        for (int i = 0; i < size; i++) {
            if (gVar == this.m.get(i).f117b) {
                return i;
            }
        }
        return -1;
    }

    private MenuItem B(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = gVar.getItem(i);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View C(C0005d c0005d, g gVar) {
        f fVar;
        int i;
        int firstVisiblePosition;
        MenuItem B = B(c0005d.f117b, gVar);
        if (B == null) {
            return null;
        }
        ListView a2 = c0005d.a();
        ListAdapter adapter = a2.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            i = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            }
            if (B == fVar.getItem(i2)) {
                break;
            }
            i2++;
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + i) - a2.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a2.getChildCount()) {
            return a2.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int D() {
        return c.f.l.s.y(this.s) == 1 ? 0 : 1;
    }

    private int E(int i) {
        List<C0005d> list = this.m;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.t.getWindowVisibleDisplayFrame(rect);
        return this.u == 1 ? (iArr[0] + a2.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    private void F(g gVar) {
        C0005d c0005d;
        View view;
        int i;
        int i2;
        int i3;
        LayoutInflater from = LayoutInflater.from(this.f);
        f fVar = new f(gVar, from, this.j, F);
        if (!c() && this.z) {
            fVar.d(true);
        } else if (c()) {
            fVar.d(k.x(gVar));
        }
        int o = k.o(fVar, null, this.f, this.g);
        l0 z = z();
        z.o(fVar);
        z.F(o);
        z.G(this.r);
        if (this.m.size() > 0) {
            List<C0005d> list = this.m;
            c0005d = list.get(list.size() - 1);
            view = C(c0005d, gVar);
        } else {
            c0005d = null;
            view = null;
        }
        if (view != null) {
            z.U(false);
            z.R(null);
            int E = E(o);
            boolean z2 = E == 1;
            this.u = E;
            if (Build.VERSION.SDK_INT >= 26) {
                z.D(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.s.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.r & 7) == 5) {
                    iArr[0] = iArr[0] + this.s.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.r & 5) == 5) {
                if (!z2) {
                    o = view.getWidth();
                    i3 = i - o;
                }
                i3 = i + o;
            } else {
                if (z2) {
                    o = view.getWidth();
                    i3 = i + o;
                }
                i3 = i - o;
            }
            z.d(i3);
            z.M(true);
            z.n(i2);
        } else {
            if (this.v) {
                z.d(this.x);
            }
            if (this.w) {
                z.n(this.y);
            }
            z.H(n());
        }
        this.m.add(new C0005d(z, gVar, this.u));
        z.a();
        ListView l = z.l();
        l.setOnKeyListener(this);
        if (c0005d == null && this.A && gVar.x() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(c.a.g.abc_popup_menu_header_item_layout, (ViewGroup) l, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(gVar.x());
            l.addHeaderView(frameLayout, null, false);
            z.a();
        }
    }

    private l0 z() {
        l0 l0Var = new l0(this.f, null, this.h, this.i);
        l0Var.T(this.p);
        l0Var.L(this);
        l0Var.K(this);
        l0Var.D(this.s);
        l0Var.G(this.r);
        l0Var.J(true);
        l0Var.I(2);
        return l0Var;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a() {
        if (c()) {
            return;
        }
        Iterator<g> it = this.l.iterator();
        while (it.hasNext()) {
            F(it.next());
        }
        this.l.clear();
        View view = this.s;
        this.t = view;
        if (view != null) {
            boolean z = this.C == null;
            ViewTreeObserver viewTreeObserver = this.t.getViewTreeObserver();
            this.C = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.n);
            }
            this.t.addOnAttachStateChangeListener(this.o);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
        int A = A(gVar);
        if (A < 0) {
            return;
        }
        int i = A + 1;
        if (i < this.m.size()) {
            this.m.get(i).f117b.e(false);
        }
        C0005d remove = this.m.remove(A);
        remove.f117b.O(this);
        if (this.E) {
            remove.a.S(null);
            remove.a.E(0);
        }
        remove.a.dismiss();
        int size = this.m.size();
        this.u = size > 0 ? this.m.get(size - 1).f118c : D();
        if (size != 0) {
            if (z) {
                this.m.get(0).f117b.e(false);
                return;
            }
            return;
        }
        dismiss();
        m.a aVar = this.B;
        if (aVar != null) {
            aVar.b(gVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.C;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.C.removeGlobalOnLayoutListener(this.n);
            }
            this.C = null;
        }
        this.t.removeOnAttachStateChangeListener(this.o);
        this.D.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean c() {
        return this.m.size() > 0 && this.m.get(0).a.c();
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        int size = this.m.size();
        if (size > 0) {
            C0005d[] c0005dArr = (C0005d[]) this.m.toArray(new C0005d[size]);
            for (int i = size - 1; i >= 0; i--) {
                C0005d c0005d = c0005dArr[i];
                if (c0005d.a.c()) {
                    c0005d.a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void h(m.a aVar) {
        this.B = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean i(r rVar) {
        for (C0005d c0005d : this.m) {
            if (rVar == c0005d.f117b) {
                c0005d.a().requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        k(rVar);
        m.a aVar = this.B;
        if (aVar != null) {
            aVar.c(rVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public void j(boolean z) {
        Iterator<C0005d> it = this.m.iterator();
        while (it.hasNext()) {
            k.y(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void k(g gVar) {
        gVar.c(this, this.f);
        if (c()) {
            F(gVar);
        } else {
            this.l.add(gVar);
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView l() {
        if (this.m.isEmpty()) {
            return null;
        }
        return this.m.get(r0.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.k
    protected boolean m() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C0005d c0005d;
        int size = this.m.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                c0005d = null;
                break;
            }
            c0005d = this.m.get(i);
            if (!c0005d.a.c()) {
                break;
            } else {
                i++;
            }
        }
        if (c0005d != null) {
            c0005d.f117b.e(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.k
    public void p(View view) {
        if (this.s != view) {
            this.s = view;
            this.r = c.f.l.d.b(this.q, c.f.l.s.y(view));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void r(boolean z) {
        this.z = z;
    }

    @Override // androidx.appcompat.view.menu.k
    public void s(int i) {
        if (this.q != i) {
            this.q = i;
            this.r = c.f.l.d.b(i, c.f.l.s.y(this.s));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void t(int i) {
        this.v = true;
        this.x = i;
    }

    @Override // androidx.appcompat.view.menu.k
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.D = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void v(boolean z) {
        this.A = z;
    }

    @Override // androidx.appcompat.view.menu.k
    public void w(int i) {
        this.w = true;
        this.y = i;
    }
}
