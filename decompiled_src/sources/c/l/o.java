package c.l;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class o {
    private static m a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static ThreadLocal<WeakReference<c.d.a<ViewGroup, ArrayList<m>>>> f892b = new ThreadLocal<>();

    /* renamed from: c, reason: collision with root package name */
    static ArrayList<ViewGroup> f893c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: e, reason: collision with root package name */
        m f894e;
        ViewGroup f;

        /* renamed from: c.l.o$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0048a extends n {
            final /* synthetic */ c.d.a a;

            C0048a(c.d.a aVar) {
                this.a = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.l.m.f
            public void e(m mVar) {
                ((ArrayList) this.a.get(a.this.f)).remove(mVar);
                mVar.P(this);
            }
        }

        a(m mVar, ViewGroup viewGroup) {
            this.f894e = mVar;
            this.f = viewGroup;
        }

        private void a() {
            this.f.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!o.f893c.remove(this.f)) {
                return true;
            }
            c.d.a<ViewGroup, ArrayList<m>> b2 = o.b();
            ArrayList<m> arrayList = b2.get(this.f);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                b2.put(this.f, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f894e);
            this.f894e.a(new C0048a(b2));
            this.f894e.k(this.f, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((m) it.next()).R(this.f);
                }
            }
            this.f894e.O(this.f);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            o.f893c.remove(this.f);
            ArrayList<m> arrayList = o.b().get(this.f);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().R(this.f);
                }
            }
            this.f894e.l(true);
        }
    }

    public static void a(ViewGroup viewGroup, m mVar) {
        if (f893c.contains(viewGroup) || !c.f.l.s.O(viewGroup)) {
            return;
        }
        f893c.add(viewGroup);
        if (mVar == null) {
            mVar = a;
        }
        m clone = mVar.clone();
        d(viewGroup, clone);
        l.c(viewGroup, null);
        c(viewGroup, clone);
    }

    static c.d.a<ViewGroup, ArrayList<m>> b() {
        c.d.a<ViewGroup, ArrayList<m>> aVar;
        WeakReference<c.d.a<ViewGroup, ArrayList<m>>> weakReference = f892b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        c.d.a<ViewGroup, ArrayList<m>> aVar2 = new c.d.a<>();
        f892b.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    private static void c(ViewGroup viewGroup, m mVar) {
        if (mVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(mVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void d(ViewGroup viewGroup, m mVar) {
        ArrayList<m> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().N(viewGroup);
            }
        }
        if (mVar != null) {
            mVar.k(viewGroup, true);
        }
        l b2 = l.b(viewGroup);
        if (b2 != null) {
            b2.a();
        }
    }
}
