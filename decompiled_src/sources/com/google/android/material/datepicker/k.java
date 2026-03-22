package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.f.l.s;
import com.google.android.material.datepicker.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends RecyclerView.f<b> {

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.material.datepicker.a f1102c;

    /* renamed from: d, reason: collision with root package name */
    private final d<?> f1103d;

    /* renamed from: e, reason: collision with root package name */
    private final g.l f1104e;
    private final int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f1105e;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f1105e = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f1105e.getAdapter().j(i)) {
                k.this.f1104e.a(this.f1105e.getAdapter().getItem(i).longValue());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.c0 {
        final TextView t;
        final MaterialCalendarGridView u;

        b(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(d.a.a.a.f.month_title);
            this.t = textView;
            s.j0(textView, true);
            this.u = (MaterialCalendarGridView) linearLayout.findViewById(d.a.a.a.f.month_grid);
            if (z) {
                return;
            }
            this.t.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, d<?> dVar, com.google.android.material.datepicker.a aVar, g.l lVar) {
        i k = aVar.k();
        i h = aVar.h();
        i j = aVar.j();
        if (k.compareTo(j) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (j.compareTo(h) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f = (j.i * g.F1(context)) + (h.z1(context) ? g.F1(context) : 0);
        this.f1102c = aVar;
        this.f1103d = dVar;
        this.f1104e = lVar;
        s(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public int c() {
        return this.f1102c.i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public long d(int i) {
        return this.f1102c.k().m(i).l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i v(int i) {
        return this.f1102c.k().m(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence w(int i) {
        return v(i).k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x(i iVar) {
        return this.f1102c.k().n(iVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void j(b bVar, int i) {
        i m = this.f1102c.k().m(i);
        bVar.t.setText(m.k());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.u.findViewById(d.a.a.a.f.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !m.equals(materialCalendarGridView.getAdapter().f1101e)) {
            j jVar = new j(m, this.f1103d, this.f1102c);
            materialCalendarGridView.setNumColumns(m.i);
            materialCalendarGridView.setAdapter((ListAdapter) jVar);
        } else {
            materialCalendarGridView.getAdapter().notifyDataSetChanged();
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public b l(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(d.a.a.a.h.mtrl_calendar_month_labeled, viewGroup, false);
        if (!h.z1(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.o(-1, this.f));
        return new b(linearLayout, true);
    }
}
