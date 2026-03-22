package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class e implements m, AdapterView.OnItemClickListener {

    /* renamed from: e, reason: collision with root package name */
    Context f119e;
    LayoutInflater f;
    g g;
    ExpandedMenuView h;
    int i;
    int j;
    int k;
    private m.a l;
    a m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {

        /* renamed from: e, reason: collision with root package name */
        private int f120e = -1;

        public a() {
            a();
        }

        void a() {
            i v = e.this.g.v();
            if (v != null) {
                ArrayList<i> z = e.this.g.z();
                int size = z.size();
                for (int i = 0; i < size; i++) {
                    if (z.get(i) == v) {
                        this.f120e = i;
                        return;
                    }
                }
            }
            this.f120e = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public i getItem(int i) {
            ArrayList<i> z = e.this.g.z();
            int i2 = i + e.this.i;
            int i3 = this.f120e;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return z.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = e.this.g.z().size() - e.this.i;
            return this.f120e < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.f.inflate(eVar.k, viewGroup, false);
            }
            ((n.a) view).e(getItem(i), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(int i, int i2) {
        this.k = i;
        this.j = i2;
    }

    public e(Context context, int i) {
        this(i, 0);
        this.f119e = context;
        this.f = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.m == null) {
            this.m = new a();
        }
        return this.m;
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
        m.a aVar = this.l;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    public n c(ViewGroup viewGroup) {
        if (this.h == null) {
            this.h = (ExpandedMenuView) this.f.inflate(c.a.g.abc_expanded_menu_layout, viewGroup, false);
            if (this.m == null) {
                this.m = new a();
            }
            this.h.setAdapter((ListAdapter) this.m);
            this.h.setOnItemClickListener(this);
        }
        return this.h;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
    @Override // androidx.appcompat.view.menu.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(android.content.Context r3, androidx.appcompat.view.menu.g r4) {
        /*
            r2 = this;
            int r0 = r2.j
            if (r0 == 0) goto L14
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            int r1 = r2.j
            r0.<init>(r3, r1)
            r2.f119e = r0
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r0)
        L11:
            r2.f = r3
            goto L23
        L14:
            android.content.Context r0 = r2.f119e
            if (r0 == 0) goto L23
            r2.f119e = r3
            android.view.LayoutInflater r0 = r2.f
            if (r0 != 0) goto L23
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            goto L11
        L23:
            r2.g = r4
            androidx.appcompat.view.menu.e$a r3 = r2.m
            if (r3 == 0) goto L2c
            r3.notifyDataSetChanged()
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.e.e(android.content.Context, androidx.appcompat.view.menu.g):void");
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean f(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean g(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void h(m.a aVar) {
        this.l = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean i(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        new h(rVar).d(null);
        m.a aVar = this.l;
        if (aVar == null) {
            return true;
        }
        aVar.c(rVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public void j(boolean z) {
        a aVar = this.m;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.g.M(this.m.getItem(i), this, 0);
    }
}
