package c.l;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import c.l.m;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class e extends androidx.fragment.app.q {

    /* loaded from: classes.dex */
    class a extends m.e {
        a(e eVar, Rect rect) {
        }
    }

    /* loaded from: classes.dex */
    class b implements m.f {
        final /* synthetic */ View a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f862b;

        b(e eVar, View view, ArrayList arrayList) {
            this.a = view;
            this.f862b = arrayList;
        }

        @Override // c.l.m.f
        public void a(m mVar) {
        }

        @Override // c.l.m.f
        public void b(m mVar) {
        }

        @Override // c.l.m.f
        public void c(m mVar) {
        }

        @Override // c.l.m.f
        public void d(m mVar) {
        }

        @Override // c.l.m.f
        public void e(m mVar) {
            mVar.P(this);
            this.a.setVisibility(8);
            int size = this.f862b.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f862b.get(i)).setVisibility(0);
            }
        }
    }

    /* loaded from: classes.dex */
    class c extends n {
        final /* synthetic */ Object a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f863b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f864c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f865d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f866e;
        final /* synthetic */ ArrayList f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.a = obj;
            this.f863b = arrayList;
            this.f864c = obj2;
            this.f865d = arrayList2;
            this.f866e = obj3;
            this.f = arrayList3;
        }

        @Override // c.l.n, c.l.m.f
        public void c(m mVar) {
            Object obj = this.a;
            if (obj != null) {
                e.this.q(obj, this.f863b, null);
            }
            Object obj2 = this.f864c;
            if (obj2 != null) {
                e.this.q(obj2, this.f865d, null);
            }
            Object obj3 = this.f866e;
            if (obj3 != null) {
                e.this.q(obj3, this.f, null);
            }
        }

        @Override // c.l.m.f
        public void e(m mVar) {
            mVar.P(this);
        }
    }

    /* loaded from: classes.dex */
    class d extends m.e {
        d(e eVar, Rect rect) {
        }
    }

    private static boolean B(m mVar) {
        return (androidx.fragment.app.q.l(mVar.z()) && androidx.fragment.app.q.l(mVar.A()) && androidx.fragment.app.q.l(mVar.B())) ? false : true;
    }

    @Override // androidx.fragment.app.q
    public Object A(Object obj) {
        if (obj == null) {
            return null;
        }
        q qVar = new q();
        qVar.e0((m) obj);
        return qVar;
    }

    @Override // androidx.fragment.app.q
    public void a(Object obj, View view) {
        if (obj != null) {
            ((m) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.q
    public void b(Object obj, ArrayList<View> arrayList) {
        m mVar = (m) obj;
        if (mVar == null) {
            return;
        }
        int i = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int h0 = qVar.h0();
            while (i < h0) {
                b(qVar.g0(i), arrayList);
                i++;
            }
            return;
        }
        if (B(mVar) || !androidx.fragment.app.q.l(mVar.C())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            mVar.b(arrayList.get(i));
            i++;
        }
    }

    @Override // androidx.fragment.app.q
    public void c(ViewGroup viewGroup, Object obj) {
        o.a(viewGroup, (m) obj);
    }

    @Override // androidx.fragment.app.q
    public boolean e(Object obj) {
        return obj instanceof m;
    }

    @Override // androidx.fragment.app.q
    public Object g(Object obj) {
        if (obj != null) {
            return ((m) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.q
    public Object m(Object obj, Object obj2, Object obj3) {
        m mVar = (m) obj;
        m mVar2 = (m) obj2;
        m mVar3 = (m) obj3;
        if (mVar != null && mVar2 != null) {
            q qVar = new q();
            qVar.e0(mVar);
            qVar.e0(mVar2);
            qVar.m0(1);
            mVar = qVar;
        } else if (mVar == null) {
            mVar = mVar2 != null ? mVar2 : null;
        }
        if (mVar3 == null) {
            return mVar;
        }
        q qVar2 = new q();
        if (mVar != null) {
            qVar2.e0(mVar);
        }
        qVar2.e0(mVar3);
        return qVar2;
    }

    @Override // androidx.fragment.app.q
    public Object n(Object obj, Object obj2, Object obj3) {
        q qVar = new q();
        if (obj != null) {
            qVar.e0((m) obj);
        }
        if (obj2 != null) {
            qVar.e0((m) obj2);
        }
        if (obj3 != null) {
            qVar.e0((m) obj3);
        }
        return qVar;
    }

    @Override // androidx.fragment.app.q
    public void p(Object obj, View view) {
        if (obj != null) {
            ((m) obj).Q(view);
        }
    }

    @Override // androidx.fragment.app.q
    public void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        m mVar = (m) obj;
        int i = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int h0 = qVar.h0();
            while (i < h0) {
                q(qVar.g0(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (B(mVar)) {
            return;
        }
        List<View> C = mVar.C();
        if (C.size() == arrayList.size() && C.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                mVar.b(arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                mVar.Q(arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.q
    public void r(Object obj, View view, ArrayList<View> arrayList) {
        ((m) obj).a(new b(this, view, arrayList));
    }

    @Override // androidx.fragment.app.q
    public void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((m) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.q
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((m) obj).V(new d(this, rect));
        }
    }

    @Override // androidx.fragment.app.q
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((m) obj).V(new a(this, rect));
        }
    }

    @Override // androidx.fragment.app.q
    public void y(Object obj, View view, ArrayList<View> arrayList) {
        q qVar = (q) obj;
        List<View> C = qVar.C();
        C.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            androidx.fragment.app.q.d(C, arrayList.get(i));
        }
        C.add(view);
        arrayList.add(view);
        b(qVar, arrayList);
    }

    @Override // androidx.fragment.app.q
    public void z(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        q qVar = (q) obj;
        if (qVar != null) {
            qVar.C().clear();
            qVar.C().addAll(arrayList2);
            q(qVar, arrayList, arrayList2);
        }
    }
}
