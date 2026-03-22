package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o {
    private static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b, reason: collision with root package name */
    private static final q f413b;

    /* renamed from: c, reason: collision with root package name */
    private static final q f414c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f415e;

        a(ArrayList arrayList) {
            this.f415e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.B(this.f415e, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f416e;
        final /* synthetic */ q f;
        final /* synthetic */ View g;
        final /* synthetic */ Fragment h;
        final /* synthetic */ ArrayList i;
        final /* synthetic */ ArrayList j;
        final /* synthetic */ ArrayList k;
        final /* synthetic */ Object l;

        b(Object obj, q qVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f416e = obj;
            this.f = qVar;
            this.g = view;
            this.h = fragment;
            this.i = arrayList;
            this.j = arrayList2;
            this.k = arrayList3;
            this.l = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f416e;
            if (obj != null) {
                this.f.p(obj, this.g);
                this.j.addAll(o.k(this.f, this.f416e, this.h, this.i, this.g));
            }
            if (this.k != null) {
                if (this.l != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(this.g);
                    this.f.q(this.l, this.k, arrayList);
                }
                this.k.clear();
                this.k.add(this.g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Fragment f417e;
        final /* synthetic */ Fragment f;
        final /* synthetic */ boolean g;
        final /* synthetic */ c.d.a h;
        final /* synthetic */ View i;
        final /* synthetic */ q j;
        final /* synthetic */ Rect k;

        c(Fragment fragment, Fragment fragment2, boolean z, c.d.a aVar, View view, q qVar, Rect rect) {
            this.f417e = fragment;
            this.f = fragment2;
            this.g = z;
            this.h = aVar;
            this.i = view;
            this.j = qVar;
            this.k = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.f(this.f417e, this.f, this.g, this.h, false);
            View view = this.i;
            if (view != null) {
                this.j.k(view, this.k);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ q f418e;
        final /* synthetic */ c.d.a f;
        final /* synthetic */ Object g;
        final /* synthetic */ e h;
        final /* synthetic */ ArrayList i;
        final /* synthetic */ View j;
        final /* synthetic */ Fragment k;
        final /* synthetic */ Fragment l;
        final /* synthetic */ boolean m;
        final /* synthetic */ ArrayList n;
        final /* synthetic */ Object o;
        final /* synthetic */ Rect p;

        d(q qVar, c.d.a aVar, Object obj, e eVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f418e = qVar;
            this.f = aVar;
            this.g = obj;
            this.h = eVar;
            this.i = arrayList;
            this.j = view;
            this.k = fragment;
            this.l = fragment2;
            this.m = z;
            this.n = arrayList2;
            this.o = obj2;
            this.p = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.d.a<String, View> h = o.h(this.f418e, this.f, this.g, this.h);
            if (h != null) {
                this.i.addAll(h.values());
                this.i.add(this.j);
            }
            o.f(this.k, this.l, this.m, h, false);
            Object obj = this.g;
            if (obj != null) {
                this.f418e.z(obj, this.n, this.i);
                View t = o.t(h, this.h, this.o, this.m);
                if (t != null) {
                    this.f418e.k(t, this.p);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e {
        public Fragment a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f419b;

        /* renamed from: c, reason: collision with root package name */
        public androidx.fragment.app.a f420c;

        /* renamed from: d, reason: collision with root package name */
        public Fragment f421d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f422e;
        public androidx.fragment.app.a f;

        e() {
        }
    }

    static {
        f413b = Build.VERSION.SDK_INT >= 21 ? new p() : null;
        f414c = x();
    }

    private static void A(q qVar, Object obj, Object obj2, c.d.a<String, View> aVar, boolean z, androidx.fragment.app.a aVar2) {
        ArrayList<String> arrayList = aVar2.n;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = aVar.get((z ? aVar2.o : aVar2.n).get(0));
        qVar.v(obj, view);
        if (obj2 != null) {
            qVar.v(obj2, view);
        }
    }

    static void B(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void C(j jVar, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (jVar.t < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            androidx.fragment.app.a aVar = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                e(aVar, sparseArray, z);
            } else {
                c(aVar, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(jVar.u.i());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = sparseArray.keyAt(i4);
                c.d.a<String, String> d2 = d(keyAt, arrayList, arrayList2, i, i2);
                e eVar = (e) sparseArray.valueAt(i4);
                if (z) {
                    o(jVar, keyAt, eVar, view, d2);
                } else {
                    n(jVar, keyAt, eVar, view, d2);
                }
            }
        }
    }

    private static void a(ArrayList<View> arrayList, c.d.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View m = aVar.m(size);
            if (collection.contains(c.f.l.s.G(m))) {
                arrayList.add(m);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0041, code lost:
    
        if (r10.o != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0092, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0076, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0090, code lost:
    
        if (r10.C == false) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void b(androidx.fragment.app.a r16, androidx.fragment.app.n.a r17, android.util.SparseArray<androidx.fragment.app.o.e> r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.o.b(androidx.fragment.app.a, androidx.fragment.app.n$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(androidx.fragment.app.a aVar, SparseArray<e> sparseArray, boolean z) {
        int size = aVar.a.size();
        for (int i = 0; i < size; i++) {
            b(aVar, aVar.a.get(i), sparseArray, false, z);
        }
    }

    private static c.d.a<String, String> d(int i, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        c.d.a<String, String> aVar = new c.d.a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            androidx.fragment.app.a aVar2 = arrayList.get(i4);
            if (aVar2.r(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                ArrayList<String> arrayList5 = aVar2.n;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.n;
                        arrayList4 = aVar2.o;
                    } else {
                        ArrayList<String> arrayList6 = aVar2.n;
                        arrayList3 = aVar2.o;
                        arrayList4 = arrayList6;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(androidx.fragment.app.a aVar, SparseArray<e> sparseArray, boolean z) {
        if (aVar.r.v.f()) {
            for (int size = aVar.a.size() - 1; size >= 0; size--) {
                b(aVar, aVar.a.get(size), sparseArray, true, z);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z, c.d.a<String, View> aVar, boolean z2) {
        androidx.core.app.g w = z ? fragment2.w() : fragment.w();
        if (w != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(aVar.i(i));
                arrayList.add(aVar.m(i));
            }
            if (z2) {
                w.c(arrayList2, arrayList, null);
            } else {
                w.b(arrayList2, arrayList, null);
            }
        }
    }

    private static boolean g(q qVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!qVar.e(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    static c.d.a<String, View> h(q qVar, c.d.a<String, String> aVar, Object obj, e eVar) {
        androidx.core.app.g w;
        ArrayList<String> arrayList;
        String q;
        Fragment fragment = eVar.a;
        View P = fragment.P();
        if (aVar.isEmpty() || obj == null || P == null) {
            aVar.clear();
            return null;
        }
        c.d.a<String, View> aVar2 = new c.d.a<>();
        qVar.j(aVar2, P);
        androidx.fragment.app.a aVar3 = eVar.f420c;
        if (eVar.f419b) {
            w = fragment.y();
            arrayList = aVar3.n;
        } else {
            w = fragment.w();
            arrayList = aVar3.o;
        }
        if (arrayList != null) {
            aVar2.o(arrayList);
            aVar2.o(aVar.values());
        }
        if (w != null) {
            w.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    String q2 = q(aVar, str);
                    if (q2 != null) {
                        aVar.remove(q2);
                    }
                } else if (!str.equals(c.f.l.s.G(view)) && (q = q(aVar, str)) != null) {
                    aVar.put(q, c.f.l.s.G(view));
                }
            }
        } else {
            y(aVar, aVar2);
        }
        return aVar2;
    }

    private static c.d.a<String, View> i(q qVar, c.d.a<String, String> aVar, Object obj, e eVar) {
        androidx.core.app.g y;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = eVar.f421d;
        c.d.a<String, View> aVar2 = new c.d.a<>();
        qVar.j(aVar2, fragment.g1());
        androidx.fragment.app.a aVar3 = eVar.f;
        if (eVar.f422e) {
            y = fragment.w();
            arrayList = aVar3.o;
        } else {
            y = fragment.y();
            arrayList = aVar3.n;
        }
        aVar2.o(arrayList);
        if (y != null) {
            y.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(c.f.l.s.G(view))) {
                    aVar.put(c.f.l.s.G(view), aVar.remove(str));
                }
            }
        } else {
            aVar.o(aVar2.keySet());
        }
        return aVar2;
    }

    private static q j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object x = fragment.x();
            if (x != null) {
                arrayList.add(x);
            }
            Object J = fragment.J();
            if (J != null) {
                arrayList.add(J);
            }
            Object L = fragment.L();
            if (L != null) {
                arrayList.add(L);
            }
        }
        if (fragment2 != null) {
            Object v = fragment2.v();
            if (v != null) {
                arrayList.add(v);
            }
            Object G = fragment2.G();
            if (G != null) {
                arrayList.add(G);
            }
            Object K = fragment2.K();
            if (K != null) {
                arrayList.add(K);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        q qVar = f413b;
        if (qVar != null && g(qVar, arrayList)) {
            return f413b;
        }
        q qVar2 = f414c;
        if (qVar2 != null && g(qVar2, arrayList)) {
            return f414c;
        }
        if (f413b == null && f414c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList<View> k(q qVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View P = fragment.P();
        if (P != null) {
            qVar.f(arrayList2, P);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        qVar.b(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(q qVar, ViewGroup viewGroup, View view, c.d.a<String, String> aVar, e eVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object u;
        c.d.a<String, String> aVar2;
        Object obj3;
        Rect rect;
        Fragment fragment = eVar.a;
        Fragment fragment2 = eVar.f421d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = eVar.f419b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            u = null;
        } else {
            u = u(qVar, fragment, fragment2, z);
            aVar2 = aVar;
        }
        c.d.a<String, View> i = i(qVar, aVar2, u, eVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(i.values());
            obj3 = u;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, i, true);
        if (obj3 != null) {
            rect = new Rect();
            qVar.y(obj3, view, arrayList);
            A(qVar, obj3, obj2, i, eVar.f422e, eVar.f);
            if (obj != null) {
                qVar.u(obj, rect);
            }
        } else {
            rect = null;
        }
        c.f.l.q.a(viewGroup, new d(qVar, aVar, obj3, eVar, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj3;
    }

    private static Object m(q qVar, ViewGroup viewGroup, View view, c.d.a<String, String> aVar, e eVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = eVar.a;
        Fragment fragment2 = eVar.f421d;
        if (fragment != null) {
            fragment.g1().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = eVar.f419b;
        Object u = aVar.isEmpty() ? null : u(qVar, fragment, fragment2, z);
        c.d.a<String, View> i = i(qVar, aVar, u, eVar);
        c.d.a<String, View> h = h(qVar, aVar, u, eVar);
        if (aVar.isEmpty()) {
            if (i != null) {
                i.clear();
            }
            if (h != null) {
                h.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, i, aVar.keySet());
            a(arrayList2, h, aVar.values());
            obj3 = u;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, i, true);
        if (obj3 != null) {
            arrayList2.add(view);
            qVar.y(obj3, view, arrayList);
            A(qVar, obj3, obj2, i, eVar.f422e, eVar.f);
            Rect rect2 = new Rect();
            View t = t(h, eVar, obj, z);
            if (t != null) {
                qVar.u(obj, rect2);
            }
            rect = rect2;
            view2 = t;
        } else {
            view2 = null;
            rect = null;
        }
        c.f.l.q.a(viewGroup, new c(fragment, fragment2, z, h, view2, qVar, rect));
        return obj3;
    }

    private static void n(j jVar, int i, e eVar, View view, c.d.a<String, String> aVar) {
        Fragment fragment;
        Fragment fragment2;
        q j;
        Object obj;
        ViewGroup viewGroup = jVar.v.f() ? (ViewGroup) jVar.v.c(i) : null;
        if (viewGroup == null || (j = j((fragment2 = eVar.f421d), (fragment = eVar.a))) == null) {
            return;
        }
        boolean z = eVar.f419b;
        boolean z2 = eVar.f422e;
        Object r = r(j, fragment, z);
        Object s = s(j, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object l = l(j, viewGroup, view, aVar, eVar, arrayList, arrayList2, r, s);
        if (r == null && l == null) {
            obj = s;
            if (obj == null) {
                return;
            }
        } else {
            obj = s;
        }
        ArrayList<View> k = k(j, obj, fragment2, arrayList, view);
        Object obj2 = (k == null || k.isEmpty()) ? null : obj;
        j.a(r, view);
        Object v = v(j, r, obj2, l, fragment, eVar.f419b);
        if (v != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            j.t(v, r, arrayList3, obj2, k, l, arrayList2);
            z(j, viewGroup, fragment, view, arrayList2, r, arrayList3, obj2, k);
            j.w(viewGroup, arrayList2, aVar);
            j.c(viewGroup, v);
            j.s(viewGroup, arrayList2, aVar);
        }
    }

    private static void o(j jVar, int i, e eVar, View view, c.d.a<String, String> aVar) {
        Fragment fragment;
        Fragment fragment2;
        q j;
        Object obj;
        ViewGroup viewGroup = jVar.v.f() ? (ViewGroup) jVar.v.c(i) : null;
        if (viewGroup == null || (j = j((fragment2 = eVar.f421d), (fragment = eVar.a))) == null) {
            return;
        }
        boolean z = eVar.f419b;
        boolean z2 = eVar.f422e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object r = r(j, fragment, z);
        Object s = s(j, fragment2, z2);
        Object m = m(j, viewGroup, view, aVar, eVar, arrayList2, arrayList, r, s);
        if (r == null && m == null) {
            obj = s;
            if (obj == null) {
                return;
            }
        } else {
            obj = s;
        }
        ArrayList<View> k = k(j, obj, fragment2, arrayList2, view);
        ArrayList<View> k2 = k(j, r, fragment, arrayList, view);
        B(k2, 4);
        Object v = v(j, r, obj, m, fragment, z);
        if (v != null) {
            w(j, obj, fragment2, k);
            ArrayList<String> o = j.o(arrayList);
            j.t(v, r, k2, obj, k, m, arrayList);
            j.c(viewGroup, v);
            j.x(viewGroup, arrayList2, arrayList, o, aVar);
            B(k2, 0);
            j.z(m, arrayList2, arrayList);
        }
    }

    private static e p(e eVar, SparseArray<e> sparseArray, int i) {
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e();
        sparseArray.put(i, eVar2);
        return eVar2;
    }

    private static String q(c.d.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.m(i))) {
                return aVar.i(i);
            }
        }
        return null;
    }

    private static Object r(q qVar, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return qVar.g(z ? fragment.G() : fragment.v());
    }

    private static Object s(q qVar, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return qVar.g(z ? fragment.J() : fragment.x());
    }

    static View t(c.d.a<String, View> aVar, e eVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        androidx.fragment.app.a aVar2 = eVar.f420c;
        if (obj == null || aVar == null || (arrayList = aVar2.n) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get((z ? aVar2.n : aVar2.o).get(0));
    }

    private static Object u(q qVar, Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return qVar.A(qVar.g(z ? fragment2.L() : fragment.K()));
    }

    private static Object v(q qVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        return (obj == null || obj2 == null || fragment == null) ? true : z ? fragment.p() : fragment.o() ? qVar.n(obj2, obj, obj3) : qVar.m(obj2, obj, obj3);
    }

    private static void w(q qVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.o && fragment.C && fragment.Q) {
            fragment.m1(true);
            qVar.r(obj, fragment.P(), arrayList);
            c.f.l.q.a(fragment.J, new a(arrayList));
        }
    }

    private static q x() {
        try {
            return (q) Class.forName("c.l.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void y(c.d.a<String, String> aVar, c.d.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.m(size))) {
                aVar.k(size);
            }
        }
    }

    private static void z(q qVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        c.f.l.q.a(viewGroup, new b(obj, qVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }
}
