package c.a.n;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import c.a.n.b;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f extends ActionMode {
    final Context a;

    /* renamed from: b, reason: collision with root package name */
    final b f644b;

    /* loaded from: classes.dex */
    public static class a implements b.a {
        final ActionMode.Callback a;

        /* renamed from: b, reason: collision with root package name */
        final Context f645b;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList<f> f646c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        final c.d.g<Menu, Menu> f647d = new c.d.g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f645b = context;
            this.a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = this.f647d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            o oVar = new o(this.f645b, (c.f.f.a.a) menu);
            this.f647d.put(menu, oVar);
            return oVar;
        }

        @Override // c.a.n.b.a
        public boolean a(b bVar, Menu menu) {
            return this.a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // c.a.n.b.a
        public boolean b(b bVar, MenuItem menuItem) {
            return this.a.onActionItemClicked(e(bVar), new j(this.f645b, (c.f.f.a.b) menuItem));
        }

        @Override // c.a.n.b.a
        public boolean c(b bVar, Menu menu) {
            return this.a.onCreateActionMode(e(bVar), f(menu));
        }

        @Override // c.a.n.b.a
        public void d(b bVar) {
            this.a.onDestroyActionMode(e(bVar));
        }

        public ActionMode e(b bVar) {
            int size = this.f646c.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.f646c.get(i);
                if (fVar != null && fVar.f644b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f645b, bVar);
            this.f646c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.a = context;
        this.f644b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f644b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f644b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new o(this.a, (c.f.f.a.a) this.f644b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f644b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f644b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f644b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f644b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f644b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f644b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f644b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f644b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f644b.n(i);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f644b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f644b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f644b.q(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f644b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f644b.s(z);
    }
}
