package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;

/* loaded from: classes.dex */
class j extends BaseAdapter {
    static final int i = p.l().getMaximum(4);

    /* renamed from: e, reason: collision with root package name */
    final i f1101e;
    final d<?> f;
    c g;
    final a h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, d<?> dVar, a aVar) {
        this.f1101e = iVar;
        this.f = dVar;
        this.h = aVar;
    }

    private void e(Context context) {
        if (this.g == null) {
            this.g = new c(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i2) {
        return b() + (i2 - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1101e.i();
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i2) {
        if (i2 < this.f1101e.i() || i2 > h()) {
            return null;
        }
        return Long.valueOf(this.f1101e.j(i(i2)));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.e(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = d.a.a.a.h.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.b()
            int r7 = r6 - r7
            r8 = 1
            if (r7 < 0) goto L5e
            com.google.android.material.datepicker.i r2 = r5.f1101e
            int r3 = r2.j
            if (r7 < r3) goto L2e
            goto L5e
        L2e:
            int r7 = r7 + r8
            r0.setTag(r2)
            java.lang.String r2 = java.lang.String.valueOf(r7)
            r0.setText(r2)
            com.google.android.material.datepicker.i r2 = r5.f1101e
            long r2 = r2.j(r7)
            com.google.android.material.datepicker.i r7 = r5.f1101e
            int r7 = r7.h
            com.google.android.material.datepicker.i r4 = com.google.android.material.datepicker.i.h()
            int r4 = r4.h
            if (r7 != r4) goto L50
            java.lang.String r7 = com.google.android.material.datepicker.e.a(r2)
            goto L54
        L50:
            java.lang.String r7 = com.google.android.material.datepicker.e.c(r2)
        L54:
            r0.setContentDescription(r7)
            r0.setVisibility(r1)
            r0.setEnabled(r8)
            goto L66
        L5e:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L66:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L6d
            return r0
        L6d:
            com.google.android.material.datepicker.a r7 = r5.h
            com.google.android.material.datepicker.a$b r7 = r7.g()
            long r2 = r6.longValue()
            boolean r7 = r7.c(r2)
            if (r7 == 0) goto Lcc
            r0.setEnabled(r8)
            com.google.android.material.datepicker.d<?> r7 = r5.f
            java.util.Collection r7 = r7.e()
            java.util.Iterator r7 = r7.iterator()
        L8a:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Lb2
            java.lang.Object r8 = r7.next()
            java.lang.Long r8 = (java.lang.Long) r8
            long r1 = r8.longValue()
            long r3 = r6.longValue()
            long r3 = com.google.android.material.datepicker.p.a(r3)
            long r1 = com.google.android.material.datepicker.p.a(r1)
            int r8 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r8 != 0) goto L8a
            com.google.android.material.datepicker.c r6 = r5.g
            com.google.android.material.datepicker.b r6 = r6.f1086b
        Lae:
            r6.d(r0)
            return r0
        Lb2:
            java.util.Calendar r7 = com.google.android.material.datepicker.p.j()
            long r7 = r7.getTimeInMillis()
            long r1 = r6.longValue()
            int r6 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r6 != 0) goto Lc7
            com.google.android.material.datepicker.c r6 = r5.g
            com.google.android.material.datepicker.b r6 = r6.f1087c
            goto Lae
        Lc7:
            com.google.android.material.datepicker.c r6 = r5.g
            com.google.android.material.datepicker.b r6 = r6.a
            goto Lae
        Lcc:
            r0.setEnabled(r1)
            com.google.android.material.datepicker.c r6 = r5.g
            com.google.android.material.datepicker.b r6 = r6.g
            goto Lae
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.j.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(int i2) {
        return i2 % this.f1101e.i == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(int i2) {
        return (i2 + 1) % this.f1101e.i == 0;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1101e.j + b();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2 / this.f1101e.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return (this.f1101e.i() + this.f1101e.j) - 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    int i(int i2) {
        return (i2 - this.f1101e.i()) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j(int i2) {
        return i2 >= b() && i2 <= h();
    }
}
