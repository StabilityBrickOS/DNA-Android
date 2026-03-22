package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class c {
    final Context a;

    /* renamed from: b, reason: collision with root package name */
    private c.d.g<c.f.f.a.b, MenuItem> f111b;

    /* renamed from: c, reason: collision with root package name */
    private c.d.g<c.f.f.a.c, SubMenu> f112c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof c.f.f.a.b)) {
            return menuItem;
        }
        c.f.f.a.b bVar = (c.f.f.a.b) menuItem;
        if (this.f111b == null) {
            this.f111b = new c.d.g<>();
        }
        MenuItem menuItem2 = this.f111b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        j jVar = new j(this.a, bVar);
        this.f111b.put(bVar, jVar);
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof c.f.f.a.c)) {
            return subMenu;
        }
        c.f.f.a.c cVar = (c.f.f.a.c) subMenu;
        if (this.f112c == null) {
            this.f112c = new c.d.g<>();
        }
        SubMenu subMenu2 = this.f112c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        s sVar = new s(this.a, cVar);
        this.f112c.put(cVar, sVar);
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        c.d.g<c.f.f.a.b, MenuItem> gVar = this.f111b;
        if (gVar != null) {
            gVar.clear();
        }
        c.d.g<c.f.f.a.c, SubMenu> gVar2 = this.f112c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(int i) {
        if (this.f111b == null) {
            return;
        }
        int i2 = 0;
        while (i2 < this.f111b.size()) {
            if (this.f111b.i(i2).getGroupId() == i) {
                this.f111b.k(i2);
                i2--;
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(int i) {
        if (this.f111b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f111b.size(); i2++) {
            if (this.f111b.i(i2).getItemId() == i) {
                this.f111b.k(i2);
                return;
            }
        }
    }
}
