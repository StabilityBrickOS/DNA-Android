package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import c.f.l.b;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends androidx.appcompat.view.menu.b implements b.a {
    e A;
    a B;
    RunnableC0007c C;
    private b D;
    final f E;
    int F;
    d m;
    private Drawable n;
    private boolean o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private final SparseBooleanArray z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends androidx.appcompat.view.menu.l {
        public a(Context context, androidx.appcompat.view.menu.r rVar, View view) {
            super(context, rVar, view, false, c.a.a.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.i) rVar.getItem()).l()) {
                View view2 = c.this.m;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.b) c.this).l : view2);
            }
            j(c.this.E);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            c cVar = c.this;
            cVar.B = null;
            cVar.F = 0;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.p a() {
            a aVar = c.this.B;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.appcompat.widget.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0007c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private e f197e;

        public RunnableC0007c(e eVar) {
            this.f197e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.b) c.this).g != null) {
                ((androidx.appcompat.view.menu.b) c.this).g.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.b) c.this).l;
            if (view != null && view.getWindowToken() != null && this.f197e.m()) {
                c.this.A = this.f197e;
            }
            c.this.C = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends o implements ActionMenuView.a {

        /* loaded from: classes.dex */
        class a extends h0 {
            a(View view, c cVar) {
                super(view);
            }

            @Override // androidx.appcompat.widget.h0
            public androidx.appcompat.view.menu.p b() {
                e eVar = c.this.A;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.h0
            public boolean c() {
                c.this.K();
                return true;
            }

            @Override // androidx.appcompat.widget.h0
            public boolean d() {
                c cVar = c.this;
                if (cVar.C != null) {
                    return false;
                }
                cVar.B();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, c.a.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            y0.a(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.K();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends androidx.appcompat.view.menu.l {
        public e(Context context, androidx.appcompat.view.menu.g gVar, View view, boolean z) {
            super(context, gVar, view, z, c.a.a.actionOverflowMenuStyle);
            h(8388613);
            j(c.this.E);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            if (((androidx.appcompat.view.menu.b) c.this).g != null) {
                ((androidx.appcompat.view.menu.b) c.this).g.close();
            }
            c.this.A = null;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class f implements m.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            if (gVar instanceof androidx.appcompat.view.menu.r) {
                gVar.D().e(false);
            }
            m.a m = c.this.m();
            if (m != null) {
                m.b(gVar, z);
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            if (gVar == ((androidx.appcompat.view.menu.b) c.this).g) {
                return false;
            }
            c.this.F = ((androidx.appcompat.view.menu.r) gVar).getItem().getItemId();
            m.a m = c.this.m();
            if (m != null) {
                return m.c(gVar);
            }
            return false;
        }
    }

    public c(Context context) {
        super(context, c.a.g.abc_action_menu_layout, c.a.g.abc_action_menu_item_layout);
        this.z = new SparseBooleanArray();
        this.E = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View z(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.l;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable A() {
        d dVar = this.m;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.o) {
            return this.n;
        }
        return null;
    }

    public boolean B() {
        Object obj;
        RunnableC0007c runnableC0007c = this.C;
        if (runnableC0007c != null && (obj = this.l) != null) {
            ((View) obj).removeCallbacks(runnableC0007c);
            this.C = null;
            return true;
        }
        e eVar = this.A;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean C() {
        a aVar = this.B;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean D() {
        return this.C != null || E();
    }

    public boolean E() {
        e eVar = this.A;
        return eVar != null && eVar.d();
    }

    public void F(Configuration configuration) {
        if (!this.u) {
            this.t = c.a.n.a.b(this.f).d();
        }
        androidx.appcompat.view.menu.g gVar = this.g;
        if (gVar != null) {
            gVar.K(true);
        }
    }

    public void G(boolean z) {
        this.x = z;
    }

    public void H(ActionMenuView actionMenuView) {
        this.l = actionMenuView;
        actionMenuView.b(this.g);
    }

    public void I(Drawable drawable) {
        d dVar = this.m;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.o = true;
            this.n = drawable;
        }
    }

    public void J(boolean z) {
        this.p = z;
        this.q = true;
    }

    public boolean K() {
        androidx.appcompat.view.menu.g gVar;
        if (!this.p || E() || (gVar = this.g) == null || this.l == null || this.C != null || gVar.z().isEmpty()) {
            return false;
        }
        RunnableC0007c runnableC0007c = new RunnableC0007c(new e(this.f, this.g, this.m, true));
        this.C = runnableC0007c;
        ((View) this.l).post(runnableC0007c);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
        y();
        super.b(gVar, z);
    }

    @Override // androidx.appcompat.view.menu.b
    public void c(androidx.appcompat.view.menu.i iVar, n.a aVar) {
        aVar.e(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.l);
        if (this.D == null) {
            this.D = new b();
        }
        actionMenuItemView.setPopupCallback(this.D);
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        ArrayList<androidx.appcompat.view.menu.i> arrayList;
        int i;
        int i2;
        int i3;
        int i4;
        c cVar = this;
        androidx.appcompat.view.menu.g gVar = cVar.g;
        View view = null;
        int i5 = 0;
        if (gVar != null) {
            arrayList = gVar.E();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i6 = cVar.t;
        int i7 = cVar.s;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.l;
        boolean z = false;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            androidx.appcompat.view.menu.i iVar = arrayList.get(i10);
            if (iVar.o()) {
                i8++;
            } else if (iVar.n()) {
                i9++;
            } else {
                z = true;
            }
            if (cVar.x && iVar.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (cVar.p && (z || i9 + i8 > i6)) {
            i6--;
        }
        int i11 = i6 - i8;
        SparseBooleanArray sparseBooleanArray = cVar.z;
        sparseBooleanArray.clear();
        if (cVar.v) {
            int i12 = cVar.y;
            i3 = i7 / i12;
            i2 = i12 + ((i7 % i12) / i3);
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < i) {
            androidx.appcompat.view.menu.i iVar2 = arrayList.get(i13);
            if (iVar2.o()) {
                View n = cVar.n(iVar2, view, viewGroup);
                if (cVar.v) {
                    i3 -= ActionMenuView.L(n, i2, i3, makeMeasureSpec, i5);
                } else {
                    n.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = n.getMeasuredWidth();
                i7 -= measuredWidth;
                if (i14 == 0) {
                    i14 = measuredWidth;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.u(true);
                i4 = i;
            } else if (iVar2.n()) {
                int groupId2 = iVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i11 > 0 || z2) && i7 > 0 && (!cVar.v || i3 > 0);
                boolean z4 = z3;
                i4 = i;
                if (z3) {
                    View n2 = cVar.n(iVar2, null, viewGroup);
                    if (cVar.v) {
                        int L = ActionMenuView.L(n2, i2, i3, makeMeasureSpec, 0);
                        i3 -= L;
                        if (L == 0) {
                            z4 = false;
                        }
                    } else {
                        n2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z5 = z4;
                    int measuredWidth2 = n2.getMeasuredWidth();
                    i7 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    z3 = z5 & (!cVar.v ? i7 + i14 <= 0 : i7 < 0);
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i15 = 0; i15 < i13; i15++) {
                        androidx.appcompat.view.menu.i iVar3 = arrayList.get(i15);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.l()) {
                                i11++;
                            }
                            iVar3.u(false);
                        }
                    }
                }
                if (z3) {
                    i11--;
                }
                iVar2.u(z3);
            } else {
                i4 = i;
                iVar2.u(false);
                i13++;
                view = null;
                cVar = this;
                i = i4;
                i5 = 0;
            }
            i13++;
            view = null;
            cVar = this;
            i = i4;
            i5 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void e(Context context, androidx.appcompat.view.menu.g gVar) {
        super.e(context, gVar);
        Resources resources = context.getResources();
        c.a.n.a b2 = c.a.n.a.b(context);
        if (!this.q) {
            this.p = b2.h();
        }
        if (!this.w) {
            this.r = b2.c();
        }
        if (!this.u) {
            this.t = b2.d();
        }
        int i = this.r;
        if (this.p) {
            if (this.m == null) {
                d dVar = new d(this.f110e);
                this.m = dVar;
                if (this.o) {
                    dVar.setImageDrawable(this.n);
                    this.n = null;
                    this.o = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.m.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.m.getMeasuredWidth();
        } else {
            this.m = null;
        }
        this.s = i;
        this.y = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public boolean i(androidx.appcompat.view.menu.r rVar) {
        boolean z = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.r rVar2 = rVar;
        while (rVar2.e0() != this.g) {
            rVar2 = (androidx.appcompat.view.menu.r) rVar2.e0();
        }
        View z2 = z(rVar2.getItem());
        if (z2 == null) {
            return false;
        }
        rVar.getItem().getItemId();
        int size = rVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        a aVar = new a(this.f, rVar, z2);
        this.B = aVar;
        aVar.g(z);
        this.B.k();
        super.i(rVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void j(boolean z) {
        super.j(z);
        ((View) this.l).requestLayout();
        androidx.appcompat.view.menu.g gVar = this.g;
        boolean z2 = false;
        if (gVar != null) {
            ArrayList<androidx.appcompat.view.menu.i> s = gVar.s();
            int size = s.size();
            for (int i = 0; i < size; i++) {
                c.f.l.b b2 = s.get(i).b();
                if (b2 != null) {
                    b2.i(this);
                }
            }
        }
        androidx.appcompat.view.menu.g gVar2 = this.g;
        ArrayList<androidx.appcompat.view.menu.i> z3 = gVar2 != null ? gVar2.z() : null;
        if (this.p && z3 != null) {
            int size2 = z3.size();
            if (size2 == 1) {
                z2 = !z3.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        d dVar = this.m;
        if (z2) {
            if (dVar == null) {
                this.m = new d(this.f110e);
            }
            ViewGroup viewGroup = (ViewGroup) this.m.getParent();
            if (viewGroup != this.l) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.m);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.l;
                actionMenuView.addView(this.m, actionMenuView.F());
            }
        } else if (dVar != null) {
            Object parent = dVar.getParent();
            Object obj = this.l;
            if (parent == obj) {
                ((ViewGroup) obj).removeView(this.m);
            }
        }
        ((ActionMenuView) this.l).setOverflowReserved(this.p);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean l(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.m) {
            return false;
        }
        return super.l(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.b
    public View n(androidx.appcompat.view.menu.i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.j()) {
            actionView = super.n(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.n o(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.n nVar = this.l;
        androidx.appcompat.view.menu.n o = super.o(viewGroup);
        if (nVar != o) {
            ((ActionMenuView) o).setPresenter(this);
        }
        return o;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean q(int i, androidx.appcompat.view.menu.i iVar) {
        return iVar.l();
    }

    public boolean y() {
        return B() | C();
    }
}
