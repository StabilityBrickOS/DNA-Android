package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.n;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends n implements j.k {
    final j r;
    boolean s;
    int t = -1;

    public a(j jVar) {
        this.r = jVar;
    }

    private static boolean t(n.a aVar) {
        Fragment fragment = aVar.f409b;
        return (fragment == null || !fragment.o || fragment.K == null || fragment.D || fragment.C || !fragment.W()) ? false : true;
    }

    @Override // androidx.fragment.app.j.k
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (j.L) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.h) {
            return true;
        }
        this.r.i(this);
        return true;
    }

    @Override // androidx.fragment.app.n
    public int d() {
        return k(false);
    }

    @Override // androidx.fragment.app.n
    public int e() {
        return k(true);
    }

    @Override // androidx.fragment.app.n
    void f(int i, Fragment fragment, String str, int i2) {
        super.f(i, fragment, str, i2);
        fragment.v = this.r;
    }

    @Override // androidx.fragment.app.n
    public n g(Fragment fragment) {
        j jVar = fragment.v;
        if (jVar == null || jVar == this.r) {
            super.g(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(int i) {
        if (this.h) {
            if (j.L) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a aVar = this.a.get(i2);
                Fragment fragment = aVar.f409b;
                if (fragment != null) {
                    fragment.u += i;
                    if (j.L) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f409b + " to " + aVar.f409b.u);
                    }
                }
            }
        }
    }

    int k(boolean z) {
        if (this.s) {
            throw new IllegalStateException("commit already called");
        }
        if (j.L) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new c.f.k.b("FragmentManager"));
            l("  ", printWriter);
            printWriter.close();
        }
        this.s = true;
        this.t = this.h ? this.r.l(this) : -1;
        this.r.g0(this, z);
        return this.t;
    }

    public void l(String str, PrintWriter printWriter) {
        m(str, printWriter, true);
    }

    public void m(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.i);
            printWriter.print(" mIndex=");
            printWriter.print(this.t);
            printWriter.print(" mCommitted=");
            printWriter.println(this.s);
            if (this.f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (this.f405b != 0 || this.f406c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f405b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f406c));
            }
            if (this.f407d != 0 || this.f408e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f407d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f408e));
            }
            if (this.j != 0 || this.k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.k);
            }
            if (this.l != 0 || this.m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.m);
            }
        }
        if (this.a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            n.a aVar = this.a.get(i);
            switch (aVar.a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f409b);
            if (z) {
                if (aVar.f410c != 0 || aVar.f411d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f410c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f411d));
                }
                if (aVar.f412e != 0 || aVar.f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f412e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            n.a aVar = this.a.get(i);
            Fragment fragment = aVar.f409b;
            if (fragment != null) {
                fragment.o1(this.f, this.g);
            }
            switch (aVar.a) {
                case 1:
                    fragment.n1(aVar.f410c);
                    this.r.j(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                case 3:
                    fragment.n1(aVar.f411d);
                    this.r.X0(fragment);
                    break;
                case 4:
                    fragment.n1(aVar.f411d);
                    this.r.B0(fragment);
                    break;
                case 5:
                    fragment.n1(aVar.f410c);
                    this.r.k1(fragment);
                    break;
                case 6:
                    fragment.n1(aVar.f411d);
                    this.r.v(fragment);
                    break;
                case 7:
                    fragment.n1(aVar.f410c);
                    this.r.o(fragment);
                    break;
                case 8:
                    this.r.j1(fragment);
                    break;
                case 9:
                    this.r.j1(null);
                    break;
                case 10:
                    this.r.i1(fragment, aVar.h);
                    break;
            }
            if (!this.p && aVar.a != 1 && fragment != null) {
                this.r.N0(fragment);
            }
        }
        if (this.p) {
            return;
        }
        j jVar = this.r;
        jVar.O0(jVar.t, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(boolean z) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            n.a aVar = this.a.get(size);
            Fragment fragment = aVar.f409b;
            if (fragment != null) {
                fragment.o1(j.c1(this.f), this.g);
            }
            switch (aVar.a) {
                case 1:
                    fragment.n1(aVar.f);
                    this.r.X0(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                case 3:
                    fragment.n1(aVar.f412e);
                    this.r.j(fragment, false);
                    break;
                case 4:
                    fragment.n1(aVar.f412e);
                    this.r.k1(fragment);
                    break;
                case 5:
                    fragment.n1(aVar.f);
                    this.r.B0(fragment);
                    break;
                case 6:
                    fragment.n1(aVar.f412e);
                    this.r.o(fragment);
                    break;
                case 7:
                    fragment.n1(aVar.f);
                    this.r.v(fragment);
                    break;
                case 8:
                    this.r.j1(null);
                    break;
                case 9:
                    this.r.j1(fragment);
                    break;
                case 10:
                    this.r.i1(fragment, aVar.g);
                    break;
            }
            if (!this.p && aVar.a != 3 && fragment != null) {
                this.r.N0(fragment);
            }
        }
        if (this.p || !z) {
            return;
        }
        j jVar = this.r;
        jVar.O0(jVar.t, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment p(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.a.size()) {
            n.a aVar = this.a.get(i);
            int i2 = aVar.a;
            if (i2 != 1) {
                if (i2 == 2) {
                    Fragment fragment3 = aVar.f409b;
                    int i3 = fragment3.A;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList.get(size);
                        if (fragment4.A == i3) {
                            if (fragment4 == fragment3) {
                                z = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.a.add(i, new n.a(9, fragment4));
                                    i++;
                                    fragment2 = null;
                                }
                                n.a aVar2 = new n.a(3, fragment4);
                                aVar2.f410c = aVar.f410c;
                                aVar2.f412e = aVar.f412e;
                                aVar2.f411d = aVar.f411d;
                                aVar2.f = aVar.f;
                                this.a.add(i, aVar2);
                                arrayList.remove(fragment4);
                                i++;
                            }
                        }
                    }
                    if (z) {
                        this.a.remove(i);
                        i--;
                    } else {
                        aVar.a = 1;
                        arrayList.add(fragment3);
                    }
                } else if (i2 == 3 || i2 == 6) {
                    arrayList.remove(aVar.f409b);
                    Fragment fragment5 = aVar.f409b;
                    if (fragment5 == fragment2) {
                        this.a.add(i, new n.a(9, fragment5));
                        i++;
                        fragment2 = null;
                    }
                } else if (i2 != 7) {
                    if (i2 == 8) {
                        this.a.add(i, new n.a(9, fragment2));
                        i++;
                        fragment2 = aVar.f409b;
                    }
                }
                i++;
            }
            arrayList.add(aVar.f409b);
            i++;
        }
        return fragment2;
    }

    public String q() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(int i) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.a.get(i2).f409b;
            int i3 = fragment != null ? fragment.A : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s(ArrayList<a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.a.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.a.get(i4).f409b;
            int i5 = fragment != null ? fragment.A : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    a aVar = arrayList.get(i6);
                    int size2 = aVar.a.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = aVar.a.get(i7).f409b;
                        if ((fragment2 != null ? fragment2.A : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.t >= 0) {
            sb.append(" #");
            sb.append(this.t);
        }
        if (this.i != null) {
            sb.append(" ");
            sb.append(this.i);
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u() {
        for (int i = 0; i < this.a.size(); i++) {
            if (t(this.a.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void v() {
        if (this.q != null) {
            for (int i = 0; i < this.q.size(); i++) {
                this.q.get(i).run();
            }
            this.q = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(Fragment.e eVar) {
        for (int i = 0; i < this.a.size(); i++) {
            n.a aVar = this.a.get(i);
            if (t(aVar)) {
                aVar.f409b.p1(eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment x(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            n.a aVar = this.a.get(size);
            int i = aVar.a;
            if (i != 1) {
                if (i != 3) {
                    switch (i) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f409b;
                            break;
                        case 10:
                            aVar.h = aVar.g;
                            break;
                    }
                }
                arrayList.add(aVar.f409b);
            }
            arrayList.remove(aVar.f409b);
        }
        return fragment;
    }
}
