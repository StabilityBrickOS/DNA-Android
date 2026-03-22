package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.f.l.s;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class g<S> extends m<S> {
    static final Object m0 = "MONTHS_VIEW_GROUP_TAG";
    static final Object n0 = "NAVIGATION_PREV_TAG";
    static final Object o0 = "NAVIGATION_NEXT_TAG";
    static final Object p0 = "SELECTOR_TOGGLE_TAG";
    private int c0;
    private com.google.android.material.datepicker.d<S> d0;
    private com.google.android.material.datepicker.a e0;
    private com.google.android.material.datepicker.i f0;
    private k g0;
    private com.google.android.material.datepicker.c h0;
    private RecyclerView i0;
    private RecyclerView j0;
    private View k0;
    private View l0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f1091e;

        a(int i) {
            this.f1091e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.j0.o1(this.f1091e);
        }
    }

    /* loaded from: classes.dex */
    class b extends c.f.l.a {
        b(g gVar) {
        }

        @Override // c.f.l.a
        public void g(View view, c.f.l.b0.c cVar) {
            super.g(view, cVar);
            cVar.c0(null);
        }
    }

    /* loaded from: classes.dex */
    class c extends n {
        final /* synthetic */ int I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, int i, boolean z, int i2) {
            super(context, i, z);
            this.I = i2;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void M1(RecyclerView.z zVar, int[] iArr) {
            if (this.I == 0) {
                iArr[0] = g.this.j0.getWidth();
                iArr[1] = g.this.j0.getWidth();
            } else {
                iArr[0] = g.this.j0.getHeight();
                iArr[1] = g.this.j0.getHeight();
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements l {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.g.l
        public void a(long j) {
            if (g.this.e0.g().c(j)) {
                g.this.d0.d(j);
                Iterator<com.google.android.material.datepicker.l<S>> it = g.this.b0.iterator();
                while (it.hasNext()) {
                    it.next().a(g.this.d0.a());
                }
                g.this.j0.getAdapter().h();
                if (g.this.i0 != null) {
                    g.this.i0.getAdapter().h();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends RecyclerView.m {
        private final Calendar a = p.l();

        /* renamed from: b, reason: collision with root package name */
        private final Calendar f1092b = p.l();

        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public void g(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
            if ((recyclerView.getAdapter() instanceof q) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                q qVar = (q) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (c.f.k.d<Long, Long> dVar : g.this.d0.b()) {
                    Long l = dVar.a;
                    if (l != null && dVar.f779b != null) {
                        this.a.setTimeInMillis(l.longValue());
                        this.f1092b.setTimeInMillis(dVar.f779b.longValue());
                        int w = qVar.w(this.a.get(1));
                        int w2 = qVar.w(this.f1092b.get(1));
                        View C = gridLayoutManager.C(w);
                        View C2 = gridLayoutManager.C(w2);
                        int X2 = w / gridLayoutManager.X2();
                        int X22 = w2 / gridLayoutManager.X2();
                        int i = X2;
                        while (i <= X22) {
                            if (gridLayoutManager.C(gridLayoutManager.X2() * i) != null) {
                                canvas.drawRect(i == X2 ? C.getLeft() + (C.getWidth() / 2) : 0, r9.getTop() + g.this.h0.f1088d.c(), i == X22 ? C2.getLeft() + (C2.getWidth() / 2) : recyclerView.getWidth(), r9.getBottom() - g.this.h0.f1088d.b(), g.this.h0.h);
                            }
                            i++;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends c.f.l.a {
        f() {
        }

        @Override // c.f.l.a
        public void g(View view, c.f.l.b0.c cVar) {
            g gVar;
            int i;
            super.g(view, cVar);
            if (g.this.l0.getVisibility() == 0) {
                gVar = g.this;
                i = d.a.a.a.i.mtrl_picker_toggle_to_year_selection;
            } else {
                gVar = g.this;
                i = d.a.a.a.i.mtrl_picker_toggle_to_day_selection;
            }
            cVar.l0(gVar.N(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.datepicker.g$g, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0071g extends RecyclerView.s {
        final /* synthetic */ com.google.android.material.datepicker.k a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MaterialButton f1095b;

        C0071g(com.google.android.material.datepicker.k kVar, MaterialButton materialButton) {
            this.a = kVar;
            this.f1095b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, int i) {
            if (i == 0) {
                CharSequence text = this.f1095b.getText();
                if (Build.VERSION.SDK_INT >= 16) {
                    recyclerView.announceForAccessibility(text);
                } else {
                    recyclerView.sendAccessibilityEvent(2048);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(RecyclerView recyclerView, int i, int i2) {
            LinearLayoutManager G1 = g.this.G1();
            int Z1 = i < 0 ? G1.Z1() : G1.c2();
            g.this.f0 = this.a.v(Z1);
            this.f1095b.setText(this.a.w(Z1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.K1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.k f1098e;

        i(com.google.android.material.datepicker.k kVar) {
            this.f1098e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int Z1 = g.this.G1().Z1() + 1;
            if (Z1 < g.this.j0.getAdapter().c()) {
                g.this.I1(this.f1098e.v(Z1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.k f1099e;

        j(com.google.android.material.datepicker.k kVar) {
            this.f1099e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int c2 = g.this.G1().c2() - 1;
            if (c2 >= 0) {
                g.this.I1(this.f1099e.v(c2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum k {
        DAY,
        YEAR
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface l {
        void a(long j);
    }

    private RecyclerView.m A1() {
        return new e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int F1(Context context) {
        return context.getResources().getDimensionPixelSize(d.a.a.a.d.mtrl_calendar_day_height);
    }

    private void H1(int i2) {
        this.j0.post(new a(i2));
    }

    private void z1(View view, com.google.android.material.datepicker.k kVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(d.a.a.a.f.month_navigation_fragment_toggle);
        materialButton.setTag(p0);
        s.i0(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(d.a.a.a.f.month_navigation_previous);
        materialButton2.setTag(n0);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(d.a.a.a.f.month_navigation_next);
        materialButton3.setTag(o0);
        this.k0 = view.findViewById(d.a.a.a.f.mtrl_calendar_year_selector_frame);
        this.l0 = view.findViewById(d.a.a.a.f.mtrl_calendar_day_selector_frame);
        J1(k.DAY);
        materialButton.setText(this.f0.k());
        this.j0.k(new C0071g(kVar, materialButton));
        materialButton.setOnClickListener(new h());
        materialButton3.setOnClickListener(new i(kVar));
        materialButton2.setOnClickListener(new j(kVar));
    }

    @Override // androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        super.B0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.c0);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.d0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.e0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.a B1() {
        return this.e0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.c C1() {
        return this.h0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.i D1() {
        return this.f0;
    }

    public com.google.android.material.datepicker.d<S> E1() {
        return this.d0;
    }

    LinearLayoutManager G1() {
        return (LinearLayoutManager) this.j0.getLayoutManager();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I1(com.google.android.material.datepicker.i iVar) {
        RecyclerView recyclerView;
        int i2;
        com.google.android.material.datepicker.k kVar = (com.google.android.material.datepicker.k) this.j0.getAdapter();
        int x = kVar.x(iVar);
        int x2 = x - kVar.x(this.f0);
        boolean z = Math.abs(x2) > 3;
        boolean z2 = x2 > 0;
        this.f0 = iVar;
        if (!z || !z2) {
            if (z) {
                recyclerView = this.j0;
                i2 = x + 3;
            }
            H1(x);
        }
        recyclerView = this.j0;
        i2 = x - 3;
        recyclerView.g1(i2);
        H1(x);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J1(k kVar) {
        this.g0 = kVar;
        if (kVar == k.YEAR) {
            this.i0.getLayoutManager().x1(((q) this.i0.getAdapter()).w(this.f0.h));
            this.k0.setVisibility(0);
            this.l0.setVisibility(8);
        } else if (kVar == k.DAY) {
            this.k0.setVisibility(8);
            this.l0.setVisibility(0);
            I1(this.f0);
        }
    }

    void K1() {
        k kVar;
        k kVar2 = this.g0;
        if (kVar2 == k.YEAR) {
            kVar = k.DAY;
        } else if (kVar2 != k.DAY) {
            return;
        } else {
            kVar = k.YEAR;
        }
        J1(kVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void f0(Bundle bundle) {
        super.f0(bundle);
        if (bundle == null) {
            bundle = s();
        }
        this.c0 = bundle.getInt("THEME_RES_ID_KEY");
        this.d0 = (com.google.android.material.datepicker.d) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.e0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f0 = (com.google.android.material.datepicker.i) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View j0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(u(), this.c0);
        this.h0 = new com.google.android.material.datepicker.c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        com.google.android.material.datepicker.i k2 = this.e0.k();
        if (com.google.android.material.datepicker.h.z1(contextThemeWrapper)) {
            i2 = d.a.a.a.h.mtrl_calendar_vertical;
            i3 = 1;
        } else {
            i2 = d.a.a.a.h.mtrl_calendar_horizontal;
            i3 = 0;
        }
        View inflate = cloneInContext.inflate(i2, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(d.a.a.a.f.mtrl_calendar_days_of_week);
        s.i0(gridView, new b(this));
        gridView.setAdapter((ListAdapter) new com.google.android.material.datepicker.f());
        gridView.setNumColumns(k2.i);
        gridView.setEnabled(false);
        this.j0 = (RecyclerView) inflate.findViewById(d.a.a.a.f.mtrl_calendar_months);
        this.j0.setLayoutManager(new c(u(), i3, false, i3));
        this.j0.setTag(m0);
        com.google.android.material.datepicker.k kVar = new com.google.android.material.datepicker.k(contextThemeWrapper, this.d0, this.e0, new d());
        this.j0.setAdapter(kVar);
        int integer = contextThemeWrapper.getResources().getInteger(d.a.a.a.g.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(d.a.a.a.f.mtrl_calendar_year_selector_frame);
        this.i0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.i0.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.i0.setAdapter(new q(this));
            this.i0.h(A1());
        }
        if (inflate.findViewById(d.a.a.a.f.month_navigation_fragment_toggle) != null) {
            z1(inflate, kVar);
        }
        if (!com.google.android.material.datepicker.h.z1(contextThemeWrapper)) {
            new androidx.recyclerview.widget.h().b(this.j0);
        }
        this.j0.g1(kVar.x(this.f0));
        return inflate;
    }
}
