package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import c.f.l.s;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class k extends c.f.l.a {

    /* renamed from: d, reason: collision with root package name */
    final RecyclerView f591d;

    /* renamed from: e, reason: collision with root package name */
    private final a f592e;

    /* loaded from: classes.dex */
    public static class a extends c.f.l.a {

        /* renamed from: d, reason: collision with root package name */
        final k f593d;

        /* renamed from: e, reason: collision with root package name */
        private Map<View, c.f.l.a> f594e = new WeakHashMap();

        public a(k kVar) {
            this.f593d = kVar;
        }

        @Override // c.f.l.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            c.f.l.a aVar = this.f594e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        @Override // c.f.l.a
        public c.f.l.b0.d b(View view) {
            c.f.l.a aVar = this.f594e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // c.f.l.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            c.f.l.a aVar = this.f594e.get(view);
            if (aVar != null) {
                aVar.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // c.f.l.a
        public void g(View view, c.f.l.b0.c cVar) {
            if (!this.f593d.o() && this.f593d.f591d.getLayoutManager() != null) {
                this.f593d.f591d.getLayoutManager().O0(view, cVar);
                c.f.l.a aVar = this.f594e.get(view);
                if (aVar != null) {
                    aVar.g(view, cVar);
                    return;
                }
            }
            super.g(view, cVar);
        }

        @Override // c.f.l.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            c.f.l.a aVar = this.f594e.get(view);
            if (aVar != null) {
                aVar.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // c.f.l.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            c.f.l.a aVar = this.f594e.get(viewGroup);
            return aVar != null ? aVar.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // c.f.l.a
        public boolean j(View view, int i, Bundle bundle) {
            if (this.f593d.o() || this.f593d.f591d.getLayoutManager() == null) {
                return super.j(view, i, bundle);
            }
            c.f.l.a aVar = this.f594e.get(view);
            if (aVar != null) {
                if (aVar.j(view, i, bundle)) {
                    return true;
                }
            } else if (super.j(view, i, bundle)) {
                return true;
            }
            return this.f593d.f591d.getLayoutManager().i1(view, i, bundle);
        }

        @Override // c.f.l.a
        public void l(View view, int i) {
            c.f.l.a aVar = this.f594e.get(view);
            if (aVar != null) {
                aVar.l(view, i);
            } else {
                super.l(view, i);
            }
        }

        @Override // c.f.l.a
        public void m(View view, AccessibilityEvent accessibilityEvent) {
            c.f.l.a aVar = this.f594e.get(view);
            if (aVar != null) {
                aVar.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c.f.l.a n(View view) {
            return this.f594e.remove(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void o(View view) {
            c.f.l.a j = s.j(view);
            if (j == null || j == this) {
                return;
            }
            this.f594e.put(view, j);
        }
    }

    public k(RecyclerView recyclerView) {
        this.f591d = recyclerView;
        c.f.l.a n = n();
        this.f592e = (n == null || !(n instanceof a)) ? new a(this) : (a) n;
    }

    @Override // c.f.l.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().K0(accessibilityEvent);
        }
    }

    @Override // c.f.l.a
    public void g(View view, c.f.l.b0.c cVar) {
        super.g(view, cVar);
        if (o() || this.f591d.getLayoutManager() == null) {
            return;
        }
        this.f591d.getLayoutManager().M0(cVar);
    }

    @Override // c.f.l.a
    public boolean j(View view, int i, Bundle bundle) {
        if (super.j(view, i, bundle)) {
            return true;
        }
        if (o() || this.f591d.getLayoutManager() == null) {
            return false;
        }
        return this.f591d.getLayoutManager().g1(i, bundle);
    }

    public c.f.l.a n() {
        return this.f592e;
    }

    boolean o() {
        return this.f591d.l0();
    }
}
