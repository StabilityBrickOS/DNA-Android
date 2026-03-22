package c.l;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class m implements Cloneable {
    private static final int[] K = {2, 1, 3, 4};
    private static final g L = new a();
    private static ThreadLocal<c.d.a<Animator, d>> M = new ThreadLocal<>();
    p G;
    private e H;
    private c.d.a<String, String> I;
    private ArrayList<s> x;
    private ArrayList<s> y;

    /* renamed from: e, reason: collision with root package name */
    private String f886e = getClass().getName();
    private long f = -1;
    long g = -1;
    private TimeInterpolator h = null;
    ArrayList<Integer> i = new ArrayList<>();
    ArrayList<View> j = new ArrayList<>();
    private ArrayList<String> k = null;
    private ArrayList<Class<?>> l = null;
    private ArrayList<Integer> m = null;
    private ArrayList<View> n = null;
    private ArrayList<Class<?>> o = null;
    private ArrayList<String> p = null;
    private ArrayList<Integer> q = null;
    private ArrayList<View> r = null;
    private ArrayList<Class<?>> s = null;
    private t t = new t();
    private t u = new t();
    q v = null;
    private int[] w = K;
    boolean z = false;
    ArrayList<Animator> A = new ArrayList<>();
    private int B = 0;
    private boolean C = false;
    private boolean D = false;
    private ArrayList<f> E = null;
    private ArrayList<Animator> F = new ArrayList<>();
    private g J = L;

    /* loaded from: classes.dex */
    static class a extends g {
        a() {
        }

        @Override // c.l.g
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        final /* synthetic */ c.d.a a;

        b(c.d.a aVar) {
            this.a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.remove(animator);
            m.this.A.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            m.this.A.add(animator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m.this.p();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {
        View a;

        /* renamed from: b, reason: collision with root package name */
        String f888b;

        /* renamed from: c, reason: collision with root package name */
        s f889c;

        /* renamed from: d, reason: collision with root package name */
        m0 f890d;

        /* renamed from: e, reason: collision with root package name */
        m f891e;

        d(View view, String str, m mVar, m0 m0Var, s sVar) {
            this.a = view;
            this.f888b = str;
            this.f889c = sVar;
            this.f890d = m0Var;
            this.f891e = mVar;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e {
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(m mVar);

        void b(m mVar);

        void c(m mVar);

        void d(m mVar);

        void e(m mVar);
    }

    private static boolean H(s sVar, s sVar2, String str) {
        Object obj = sVar.a.get(str);
        Object obj2 = sVar2.a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void I(c.d.a<View, s> aVar, c.d.a<View, s> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = sparseArray.valueAt(i);
            if (valueAt != null && G(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && G(view)) {
                s sVar = aVar.get(valueAt);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.x.add(sVar);
                    this.y.add(sVar2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void J(c.d.a<View, s> aVar, c.d.a<View, s> aVar2) {
        s remove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View i = aVar.i(size);
            if (i != null && G(i) && (remove = aVar2.remove(i)) != null && G(remove.f898b)) {
                this.x.add(aVar.k(size));
                this.y.add(remove);
            }
        }
    }

    private void K(c.d.a<View, s> aVar, c.d.a<View, s> aVar2, c.d.d<View> dVar, c.d.d<View> dVar2) {
        View e2;
        int l = dVar.l();
        for (int i = 0; i < l; i++) {
            View m = dVar.m(i);
            if (m != null && G(m) && (e2 = dVar2.e(dVar.h(i))) != null && G(e2)) {
                s sVar = aVar.get(m);
                s sVar2 = aVar2.get(e2);
                if (sVar != null && sVar2 != null) {
                    this.x.add(sVar);
                    this.y.add(sVar2);
                    aVar.remove(m);
                    aVar2.remove(e2);
                }
            }
        }
    }

    private void L(c.d.a<View, s> aVar, c.d.a<View, s> aVar2, c.d.a<String, View> aVar3, c.d.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i = 0; i < size; i++) {
            View m = aVar3.m(i);
            if (m != null && G(m) && (view = aVar4.get(aVar3.i(i))) != null && G(view)) {
                s sVar = aVar.get(m);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.x.add(sVar);
                    this.y.add(sVar2);
                    aVar.remove(m);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void M(t tVar, t tVar2) {
        c.d.a<View, s> aVar = new c.d.a<>(tVar.a);
        c.d.a<View, s> aVar2 = new c.d.a<>(tVar2.a);
        int i = 0;
        while (true) {
            int[] iArr = this.w;
            if (i >= iArr.length) {
                c(aVar, aVar2);
                return;
            }
            int i2 = iArr[i];
            if (i2 == 1) {
                J(aVar, aVar2);
            } else if (i2 == 2) {
                L(aVar, aVar2, tVar.f902d, tVar2.f902d);
            } else if (i2 == 3) {
                I(aVar, aVar2, tVar.f900b, tVar2.f900b);
            } else if (i2 == 4) {
                K(aVar, aVar2, tVar.f901c, tVar2.f901c);
            }
            i++;
        }
    }

    private void S(Animator animator, c.d.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            e(animator);
        }
    }

    private void c(c.d.a<View, s> aVar, c.d.a<View, s> aVar2) {
        for (int i = 0; i < aVar.size(); i++) {
            s m = aVar.m(i);
            if (G(m.f898b)) {
                this.x.add(m);
                this.y.add(null);
            }
        }
        for (int i2 = 0; i2 < aVar2.size(); i2++) {
            s m2 = aVar2.m(i2);
            if (G(m2.f898b)) {
                this.y.add(m2);
                this.x.add(null);
            }
        }
    }

    private static void d(t tVar, View view, s sVar) {
        tVar.a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.f900b.indexOfKey(id) >= 0) {
                tVar.f900b.put(id, null);
            } else {
                tVar.f900b.put(id, view);
            }
        }
        String G = c.f.l.s.G(view);
        if (G != null) {
            if (tVar.f902d.containsKey(G)) {
                tVar.f902d.put(G, null);
            } else {
                tVar.f902d.put(G, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.f901c.g(itemIdAtPosition) < 0) {
                    c.f.l.s.r0(view, true);
                    tVar.f901c.i(itemIdAtPosition, view);
                    return;
                }
                View e2 = tVar.f901c.e(itemIdAtPosition);
                if (e2 != null) {
                    c.f.l.s.r0(e2, false);
                    tVar.f901c.i(itemIdAtPosition, null);
                }
            }
        }
    }

    private void h(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.m;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.n;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.o;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (this.o.get(i).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s sVar = new s(view);
                    if (z) {
                        j(sVar);
                    } else {
                        g(sVar);
                    }
                    sVar.f899c.add(this);
                    i(sVar);
                    d(z ? this.t : this.u, view, sVar);
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.q;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.r;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.s;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.s.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                h(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    private static c.d.a<Animator, d> x() {
        c.d.a<Animator, d> aVar = M.get();
        if (aVar != null) {
            return aVar;
        }
        c.d.a<Animator, d> aVar2 = new c.d.a<>();
        M.set(aVar2);
        return aVar2;
    }

    public List<String> A() {
        return this.k;
    }

    public List<Class<?>> B() {
        return this.l;
    }

    public List<View> C() {
        return this.j;
    }

    public String[] D() {
        return null;
    }

    public s E(View view, boolean z) {
        q qVar = this.v;
        if (qVar != null) {
            return qVar.E(view, z);
        }
        return (z ? this.t : this.u).a.get(view);
    }

    public boolean F(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] D = D();
        if (D == null) {
            Iterator<String> it = sVar.a.keySet().iterator();
            while (it.hasNext()) {
                if (H(sVar, sVar2, it.next())) {
                }
            }
            return false;
        }
        for (String str : D) {
            if (!H(sVar, sVar2, str)) {
            }
        }
        return false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.m;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.n;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.o;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (this.o.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.p != null && c.f.l.s.G(view) != null && this.p.contains(c.f.l.s.G(view))) {
            return false;
        }
        if ((this.i.size() == 0 && this.j.size() == 0 && (((arrayList = this.l) == null || arrayList.isEmpty()) && ((arrayList2 = this.k) == null || arrayList2.isEmpty()))) || this.i.contains(Integer.valueOf(id)) || this.j.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.k;
        if (arrayList6 != null && arrayList6.contains(c.f.l.s.G(view))) {
            return true;
        }
        if (this.l != null) {
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                if (this.l.get(i2).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void N(View view) {
        if (this.D) {
            return;
        }
        c.d.a<Animator, d> x = x();
        int size = x.size();
        m0 d2 = c0.d(view);
        for (int i = size - 1; i >= 0; i--) {
            d m = x.m(i);
            if (m.a != null && d2.equals(m.f890d)) {
                c.l.a.b(x.i(i));
            }
        }
        ArrayList<f> arrayList = this.E;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.E.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((f) arrayList2.get(i2)).a(this);
            }
        }
        this.C = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(ViewGroup viewGroup) {
        d dVar;
        this.x = new ArrayList<>();
        this.y = new ArrayList<>();
        M(this.t, this.u);
        c.d.a<Animator, d> x = x();
        int size = x.size();
        m0 d2 = c0.d(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator i2 = x.i(i);
            if (i2 != null && (dVar = x.get(i2)) != null && dVar.a != null && d2.equals(dVar.f890d)) {
                s sVar = dVar.f889c;
                View view = dVar.a;
                s E = E(view, true);
                s t = t(view, true);
                if (E == null && t == null) {
                    t = this.u.a.get(view);
                }
                if (!(E == null && t == null) && dVar.f891e.F(sVar, t)) {
                    if (i2.isRunning() || i2.isStarted()) {
                        i2.cancel();
                    } else {
                        x.remove(i2);
                    }
                }
            }
        }
        o(viewGroup, this.t, this.u, this.x, this.y);
        T();
    }

    public m P(f fVar) {
        ArrayList<f> arrayList = this.E;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.E.size() == 0) {
            this.E = null;
        }
        return this;
    }

    public m Q(View view) {
        this.j.remove(view);
        return this;
    }

    public void R(View view) {
        if (this.C) {
            if (!this.D) {
                c.d.a<Animator, d> x = x();
                int size = x.size();
                m0 d2 = c0.d(view);
                for (int i = size - 1; i >= 0; i--) {
                    d m = x.m(i);
                    if (m.a != null && d2.equals(m.f890d)) {
                        c.l.a.c(x.i(i));
                    }
                }
                ArrayList<f> arrayList = this.E;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.E.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((f) arrayList2.get(i2)).b(this);
                    }
                }
            }
            this.C = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        a0();
        c.d.a<Animator, d> x = x();
        Iterator<Animator> it = this.F.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (x.containsKey(next)) {
                a0();
                S(next, x);
            }
        }
        this.F.clear();
        p();
    }

    public m U(long j) {
        this.g = j;
        return this;
    }

    public void V(e eVar) {
        this.H = eVar;
    }

    public m W(TimeInterpolator timeInterpolator) {
        this.h = timeInterpolator;
        return this;
    }

    public void X(g gVar) {
        if (gVar == null) {
            gVar = L;
        }
        this.J = gVar;
    }

    public void Y(p pVar) {
        this.G = pVar;
    }

    public m Z(long j) {
        this.f = j;
        return this;
    }

    public m a(f fVar) {
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.add(fVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a0() {
        if (this.B == 0) {
            ArrayList<f> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((f) arrayList2.get(i)).c(this);
                }
            }
            this.D = false;
        }
        this.B++;
    }

    public m b(View view) {
        this.j.add(view);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.g != -1) {
            str2 = str2 + "dur(" + this.g + ") ";
        }
        if (this.f != -1) {
            str2 = str2 + "dly(" + this.f + ") ";
        }
        if (this.h != null) {
            str2 = str2 + "interp(" + this.h + ") ";
        }
        if (this.i.size() <= 0 && this.j.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.i.size() > 0) {
            for (int i = 0; i < this.i.size(); i++) {
                if (i > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.i.get(i);
            }
        }
        if (this.j.size() > 0) {
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.j.get(i2);
            }
        }
        return str3 + ")";
    }

    protected void e(Animator animator) {
        if (animator == null) {
            p();
            return;
        }
        if (q() >= 0) {
            animator.setDuration(q());
        }
        if (y() >= 0) {
            animator.setStartDelay(y() + animator.getStartDelay());
        }
        if (s() != null) {
            animator.setInterpolator(s());
        }
        animator.addListener(new c());
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        for (int size = this.A.size() - 1; size >= 0; size--) {
            this.A.get(size).cancel();
        }
        ArrayList<f> arrayList = this.E;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.E.clone();
        int size2 = arrayList2.size();
        for (int i = 0; i < size2; i++) {
            ((f) arrayList2.get(i)).d(this);
        }
    }

    public abstract void g(s sVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(s sVar) {
        String[] b2;
        if (this.G == null || sVar.a.isEmpty() || (b2 = this.G.b()) == null) {
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= b2.length) {
                z = true;
                break;
            } else if (!sVar.a.containsKey(b2[i])) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        this.G.a(sVar);
    }

    public abstract void j(s sVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        c.d.a<String, String> aVar;
        l(z);
        if ((this.i.size() > 0 || this.j.size() > 0) && (((arrayList = this.k) == null || arrayList.isEmpty()) && ((arrayList2 = this.l) == null || arrayList2.isEmpty()))) {
            for (int i = 0; i < this.i.size(); i++) {
                View findViewById = viewGroup.findViewById(this.i.get(i).intValue());
                if (findViewById != null) {
                    s sVar = new s(findViewById);
                    if (z) {
                        j(sVar);
                    } else {
                        g(sVar);
                    }
                    sVar.f899c.add(this);
                    i(sVar);
                    d(z ? this.t : this.u, findViewById, sVar);
                }
            }
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                View view = this.j.get(i2);
                s sVar2 = new s(view);
                if (z) {
                    j(sVar2);
                } else {
                    g(sVar2);
                }
                sVar2.f899c.add(this);
                i(sVar2);
                d(z ? this.t : this.u, view, sVar2);
            }
        } else {
            h(viewGroup, z);
        }
        if (z || (aVar = this.I) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(this.t.f902d.remove(this.I.i(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.t.f902d.put(this.I.m(i4), view2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(boolean z) {
        t tVar;
        if (z) {
            this.t.a.clear();
            this.t.f900b.clear();
            tVar = this.t;
        } else {
            this.u.a.clear();
            this.u.f900b.clear();
            tVar = this.u;
        }
        tVar.f901c.b();
    }

    @Override // 
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public m clone() {
        try {
            m mVar = (m) super.clone();
            mVar.F = new ArrayList<>();
            mVar.t = new t();
            mVar.u = new t();
            mVar.x = null;
            mVar.y = null;
            return mVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        Animator n;
        int i;
        int i2;
        View view;
        Animator animator;
        s sVar;
        Animator animator2;
        s sVar2;
        c.d.a<Animator, d> x = x();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Long.MAX_VALUE;
        int i3 = 0;
        while (i3 < size) {
            s sVar3 = arrayList.get(i3);
            s sVar4 = arrayList2.get(i3);
            if (sVar3 != null && !sVar3.f899c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.f899c.contains(this)) {
                sVar4 = null;
            }
            if (sVar3 != null || sVar4 != null) {
                if ((sVar3 == null || sVar4 == null || F(sVar3, sVar4)) && (n = n(viewGroup, sVar3, sVar4)) != null) {
                    if (sVar4 != null) {
                        view = sVar4.f898b;
                        String[] D = D();
                        if (D != null && D.length > 0) {
                            sVar2 = new s(view);
                            i = size;
                            s sVar5 = tVar2.a.get(view);
                            if (sVar5 != null) {
                                int i4 = 0;
                                while (i4 < D.length) {
                                    sVar2.a.put(D[i4], sVar5.a.get(D[i4]));
                                    i4++;
                                    i3 = i3;
                                    sVar5 = sVar5;
                                }
                            }
                            i2 = i3;
                            int size2 = x.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size2) {
                                    animator2 = n;
                                    break;
                                }
                                d dVar = x.get(x.i(i5));
                                if (dVar.f889c != null && dVar.a == view && dVar.f888b.equals(u()) && dVar.f889c.equals(sVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i5++;
                            }
                        } else {
                            i = size;
                            i2 = i3;
                            animator2 = n;
                            sVar2 = null;
                        }
                        animator = animator2;
                        sVar = sVar2;
                    } else {
                        i = size;
                        i2 = i3;
                        view = sVar3.f898b;
                        animator = n;
                        sVar = null;
                    }
                    if (animator != null) {
                        p pVar = this.G;
                        if (pVar != null) {
                            long c2 = pVar.c(viewGroup, this, sVar3, sVar4);
                            sparseIntArray.put(this.F.size(), (int) c2);
                            j = Math.min(c2, j);
                        }
                        x.put(animator, new d(view, u(), this, c0.d(viewGroup), sVar));
                        this.F.add(animator);
                        j = j;
                    }
                    i3 = i2 + 1;
                    size = i;
                }
            }
            i = size;
            i2 = i3;
            i3 = i2 + 1;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                Animator animator3 = this.F.get(sparseIntArray.keyAt(i6));
                animator3.setStartDelay((sparseIntArray.valueAt(i6) - j) + animator3.getStartDelay());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        int i = this.B - 1;
        this.B = i;
        if (i == 0) {
            ArrayList<f> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((f) arrayList2.get(i2)).e(this);
                }
            }
            for (int i3 = 0; i3 < this.t.f901c.l(); i3++) {
                View m = this.t.f901c.m(i3);
                if (m != null) {
                    c.f.l.s.r0(m, false);
                }
            }
            for (int i4 = 0; i4 < this.u.f901c.l(); i4++) {
                View m2 = this.u.f901c.m(i4);
                if (m2 != null) {
                    c.f.l.s.r0(m2, false);
                }
            }
            this.D = true;
        }
    }

    public long q() {
        return this.g;
    }

    public e r() {
        return this.H;
    }

    public TimeInterpolator s() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s t(View view, boolean z) {
        q qVar = this.v;
        if (qVar != null) {
            return qVar.t(view, z);
        }
        ArrayList<s> arrayList = z ? this.x : this.y;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            s sVar = arrayList.get(i2);
            if (sVar == null) {
                return null;
            }
            if (sVar.f898b == view) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            return (z ? this.y : this.x).get(i);
        }
        return null;
    }

    public String toString() {
        return b0("");
    }

    public String u() {
        return this.f886e;
    }

    public g v() {
        return this.J;
    }

    public p w() {
        return this.G;
    }

    public long y() {
        return this.f;
    }

    public List<Integer> z() {
        return this.i;
    }
}
