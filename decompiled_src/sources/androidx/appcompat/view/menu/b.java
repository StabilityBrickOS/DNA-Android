package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b implements m {

    /* renamed from: e, reason: collision with root package name */
    protected Context f110e;
    protected Context f;
    protected g g;
    protected LayoutInflater h;
    private m.a i;
    private int j;
    private int k;
    protected n l;

    public b(Context context, int i, int i2) {
        this.f110e = context;
        this.h = LayoutInflater.from(context);
        this.j = i;
        this.k = i2;
    }

    protected void a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.l).addView(view, i);
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
        m.a aVar = this.i;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    public abstract void c(i iVar, n.a aVar);

    @Override // androidx.appcompat.view.menu.m
    public void e(Context context, g gVar) {
        this.f = context;
        LayoutInflater.from(context);
        this.g = gVar;
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
        this.i = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.g] */
    @Override // androidx.appcompat.view.menu.m
    public boolean i(r rVar) {
        m.a aVar = this.i;
        r rVar2 = rVar;
        if (aVar == null) {
            return false;
        }
        if (rVar == null) {
            rVar2 = this.g;
        }
        return aVar.c(rVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.m
    public void j(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.l;
        if (viewGroup == null) {
            return;
        }
        g gVar = this.g;
        int i = 0;
        if (gVar != null) {
            gVar.r();
            ArrayList<i> E = this.g.E();
            int size = E.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                i iVar = E.get(i3);
                if (q(i2, iVar)) {
                    View childAt = viewGroup.getChildAt(i2);
                    i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                    View n = n(iVar, childAt, viewGroup);
                    if (iVar != itemData) {
                        n.setPressed(false);
                        n.jumpDrawablesToCurrentState();
                    }
                    if (n != childAt) {
                        a(n, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!l(viewGroup, i)) {
                i++;
            }
        }
    }

    public n.a k(ViewGroup viewGroup) {
        return (n.a) this.h.inflate(this.k, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean l(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public m.a m() {
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View n(i iVar, View view, ViewGroup viewGroup) {
        n.a k = view instanceof n.a ? (n.a) view : k(viewGroup);
        c(iVar, k);
        return (View) k;
    }

    public n o(ViewGroup viewGroup) {
        if (this.l == null) {
            n nVar = (n) this.h.inflate(this.j, viewGroup, false);
            this.l = nVar;
            nVar.b(this.g);
            j(true);
        }
        return this.l;
    }

    public void p(int i) {
    }

    public abstract boolean q(int i, i iVar);
}
