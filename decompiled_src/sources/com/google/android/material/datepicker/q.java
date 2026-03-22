package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.g;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends RecyclerView.f<b> {

    /* renamed from: c, reason: collision with root package name */
    private final g<?> f1108c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f1109e;

        a(int i) {
            this.f1109e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q.this.f1108c.I1(q.this.f1108c.B1().f(i.g(this.f1109e, q.this.f1108c.D1().g)));
            q.this.f1108c.J1(g.k.DAY);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.c0 {
        final TextView t;

        b(TextView textView) {
            super(textView);
            this.t = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(g<?> gVar) {
        this.f1108c = gVar;
    }

    private View.OnClickListener v(int i) {
        return new a(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public int c() {
        return this.f1108c.B1().l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int w(int i) {
        return i - this.f1108c.B1().k().h;
    }

    int x(int i) {
        return this.f1108c.B1().k().h + i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void j(b bVar, int i) {
        int x = x(i);
        String string = bVar.t.getContext().getString(d.a.a.a.i.mtrl_picker_navigate_to_year_description);
        bVar.t.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(x)));
        bVar.t.setContentDescription(String.format(string, Integer.valueOf(x)));
        c C1 = this.f1108c.C1();
        Calendar j = p.j();
        com.google.android.material.datepicker.b bVar2 = j.get(1) == x ? C1.f : C1.f1088d;
        Iterator<Long> it = this.f1108c.E1().e().iterator();
        while (it.hasNext()) {
            j.setTimeInMillis(it.next().longValue());
            if (j.get(1) == x) {
                bVar2 = C1.f1089e;
            }
        }
        bVar2.d(bVar.t);
        bVar.t.setOnClickListener(v(x));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public b l(ViewGroup viewGroup, int i) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(d.a.a.a.h.mtrl_calendar_year, viewGroup, false));
    }
}
