package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements i.a {
    private c.f.k.e<b> a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<b> f532b;

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<b> f533c;

    /* renamed from: d, reason: collision with root package name */
    final InterfaceC0014a f534d;

    /* renamed from: e, reason: collision with root package name */
    Runnable f535e;
    final boolean f;
    final i g;
    private int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0014a {
        void a(int i, int i2);

        void b(b bVar);

        RecyclerView.c0 c(int i);

        void d(int i, int i2);

        void e(int i, int i2);

        void f(b bVar);

        void g(int i, int i2);

        void h(int i, int i2, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        int a;

        /* renamed from: b, reason: collision with root package name */
        int f536b;

        /* renamed from: c, reason: collision with root package name */
        Object f537c;

        /* renamed from: d, reason: collision with root package name */
        int f538d;

        b(int i, int i2, int i3, Object obj) {
            this.a = i;
            this.f536b = i2;
            this.f538d = i3;
            this.f537c = obj;
        }

        String a() {
            int i = this.a;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i = this.a;
            if (i != bVar.a) {
                return false;
            }
            if (i == 8 && Math.abs(this.f538d - this.f536b) == 1 && this.f538d == bVar.f536b && this.f536b == bVar.f538d) {
                return true;
            }
            if (this.f538d != bVar.f538d || this.f536b != bVar.f536b) {
                return false;
            }
            Object obj2 = this.f537c;
            Object obj3 = bVar.f537c;
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            } else if (obj3 != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.a * 31) + this.f536b) * 31) + this.f538d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f536b + "c:" + this.f538d + ",p:" + this.f537c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(InterfaceC0014a interfaceC0014a) {
        this(interfaceC0014a, false);
    }

    a(InterfaceC0014a interfaceC0014a, boolean z) {
        this.a = new c.f.k.f(30);
        this.f532b = new ArrayList<>();
        this.f533c = new ArrayList<>();
        this.h = 0;
        this.f534d = interfaceC0014a;
        this.f = z;
        this.g = new i(this);
    }

    private void c(b bVar) {
        r(bVar);
    }

    private void d(b bVar) {
        r(bVar);
    }

    private void f(b bVar) {
        boolean z;
        char c2;
        int i = bVar.f536b;
        int i2 = bVar.f538d + i;
        char c3 = 65535;
        int i3 = i;
        int i4 = 0;
        while (i3 < i2) {
            if (this.f534d.c(i3) != null || h(i3)) {
                if (c3 == 0) {
                    k(b(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 1;
            } else {
                if (c3 == 1) {
                    r(b(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            c3 = c2;
        }
        if (i4 != bVar.f538d) {
            a(bVar);
            bVar = b(2, i, i4, null);
        }
        if (c3 == 0) {
            k(bVar);
        } else {
            r(bVar);
        }
    }

    private void g(b bVar) {
        int i = bVar.f536b;
        int i2 = bVar.f538d + i;
        int i3 = i;
        char c2 = 65535;
        int i4 = 0;
        while (i < i2) {
            if (this.f534d.c(i) != null || h(i)) {
                if (c2 == 0) {
                    k(b(4, i3, i4, bVar.f537c));
                    i3 = i;
                    i4 = 0;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    r(b(4, i3, i4, bVar.f537c));
                    i3 = i;
                    i4 = 0;
                }
                c2 = 0;
            }
            i4++;
            i++;
        }
        if (i4 != bVar.f538d) {
            Object obj = bVar.f537c;
            a(bVar);
            bVar = b(4, i3, i4, obj);
        }
        if (c2 == 0) {
            k(bVar);
        } else {
            r(bVar);
        }
    }

    private boolean h(int i) {
        int size = this.f533c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f533c.get(i2);
            int i3 = bVar.a;
            if (i3 == 8) {
                if (n(bVar.f538d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = bVar.f536b;
                int i5 = bVar.f538d + i4;
                while (i4 < i5) {
                    if (n(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i;
        int i2 = bVar.a;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int v = v(bVar.f536b, i2);
        int i3 = bVar.f536b;
        int i4 = bVar.a;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < bVar.f538d; i6++) {
            int v2 = v(bVar.f536b + (i * i6), bVar.a);
            int i7 = bVar.a;
            if (i7 == 2 ? v2 == v : i7 == 4 && v2 == v + 1) {
                i5++;
            } else {
                b b2 = b(bVar.a, v, i5, bVar.f537c);
                l(b2, i3);
                a(b2);
                if (bVar.a == 4) {
                    i3 += i5;
                }
                v = v2;
                i5 = 1;
            }
        }
        Object obj = bVar.f537c;
        a(bVar);
        if (i5 > 0) {
            b b3 = b(bVar.a, v, i5, obj);
            l(b3, i3);
            a(b3);
        }
    }

    private void r(b bVar) {
        this.f533c.add(bVar);
        int i = bVar.a;
        if (i == 1) {
            this.f534d.g(bVar.f536b, bVar.f538d);
            return;
        }
        if (i == 2) {
            this.f534d.e(bVar.f536b, bVar.f538d);
            return;
        }
        if (i == 4) {
            this.f534d.h(bVar.f536b, bVar.f538d, bVar.f537c);
        } else {
            if (i == 8) {
                this.f534d.a(bVar.f536b, bVar.f538d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int v(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        for (int size = this.f533c.size() - 1; size >= 0; size--) {
            b bVar = this.f533c.get(size);
            int i7 = bVar.a;
            if (i7 == 8) {
                int i8 = bVar.f536b;
                int i9 = bVar.f538d;
                if (i8 >= i9) {
                    i9 = i8;
                    i8 = i9;
                }
                if (i < i8 || i > i9) {
                    int i10 = bVar.f536b;
                    if (i < i10) {
                        if (i2 == 1) {
                            bVar.f536b = i10 + 1;
                            i4 = bVar.f538d + 1;
                        } else if (i2 == 2) {
                            bVar.f536b = i10 - 1;
                            i4 = bVar.f538d - 1;
                        }
                        bVar.f538d = i4;
                    }
                } else {
                    int i11 = bVar.f536b;
                    if (i8 == i11) {
                        if (i2 == 1) {
                            i6 = bVar.f538d + 1;
                        } else {
                            if (i2 == 2) {
                                i6 = bVar.f538d - 1;
                            }
                            i++;
                        }
                        bVar.f538d = i6;
                        i++;
                    } else {
                        if (i2 == 1) {
                            i5 = i11 + 1;
                        } else {
                            if (i2 == 2) {
                                i5 = i11 - 1;
                            }
                            i--;
                        }
                        bVar.f536b = i5;
                        i--;
                    }
                }
            } else {
                int i12 = bVar.f536b;
                if (i12 > i) {
                    if (i2 == 1) {
                        i3 = i12 + 1;
                    } else if (i2 == 2) {
                        i3 = i12 - 1;
                    }
                    bVar.f536b = i3;
                } else if (i7 == 1) {
                    i -= bVar.f538d;
                } else if (i7 == 2) {
                    i += bVar.f538d;
                }
            }
        }
        for (int size2 = this.f533c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f533c.get(size2);
            if (bVar2.a == 8) {
                int i13 = bVar2.f538d;
                if (i13 != bVar2.f536b && i13 >= 0) {
                }
                this.f533c.remove(size2);
                a(bVar2);
            } else {
                if (bVar2.f538d > 0) {
                }
                this.f533c.remove(size2);
                a(bVar2);
            }
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.i.a
    public void a(b bVar) {
        if (this.f) {
            return;
        }
        bVar.f537c = null;
        this.a.a(bVar);
    }

    @Override // androidx.recyclerview.widget.i.a
    public b b(int i, int i2, int i3, Object obj) {
        b b2 = this.a.b();
        if (b2 == null) {
            return new b(i, i2, i3, obj);
        }
        b2.a = i;
        b2.f536b = i2;
        b2.f538d = i3;
        b2.f537c = obj;
        return b2;
    }

    public int e(int i) {
        int size = this.f532b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f532b.get(i2);
            int i3 = bVar.a;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = bVar.f536b;
                    if (i4 <= i) {
                        int i5 = bVar.f538d;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = bVar.f536b;
                    if (i6 == i) {
                        i = bVar.f538d;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (bVar.f538d <= i) {
                            i++;
                        }
                    }
                }
            } else if (bVar.f536b <= i) {
                i += bVar.f538d;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        int size = this.f533c.size();
        for (int i = 0; i < size; i++) {
            this.f534d.b(this.f533c.get(i));
        }
        t(this.f533c);
        this.h = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        i();
        int size = this.f532b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f532b.get(i);
            int i2 = bVar.a;
            if (i2 == 1) {
                this.f534d.b(bVar);
                this.f534d.g(bVar.f536b, bVar.f538d);
            } else if (i2 == 2) {
                this.f534d.b(bVar);
                this.f534d.d(bVar.f536b, bVar.f538d);
            } else if (i2 == 4) {
                this.f534d.b(bVar);
                this.f534d.h(bVar.f536b, bVar.f538d, bVar.f537c);
            } else if (i2 == 8) {
                this.f534d.b(bVar);
                this.f534d.a(bVar.f536b, bVar.f538d);
            }
            Runnable runnable = this.f535e;
            if (runnable != null) {
                runnable.run();
            }
        }
        t(this.f532b);
        this.h = 0;
    }

    void l(b bVar, int i) {
        this.f534d.f(bVar);
        int i2 = bVar.a;
        if (i2 == 2) {
            this.f534d.d(i, bVar.f538d);
        } else {
            if (i2 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f534d.h(i, bVar.f538d, bVar.f537c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(int i) {
        return n(i, 0);
    }

    int n(int i, int i2) {
        int size = this.f533c.size();
        while (i2 < size) {
            b bVar = this.f533c.get(i2);
            int i3 = bVar.a;
            if (i3 == 8) {
                int i4 = bVar.f536b;
                if (i4 == i) {
                    i = bVar.f538d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bVar.f538d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = bVar.f536b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = bVar.f538d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += bVar.f538d;
                }
            }
            i2++;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(int i) {
        return (i & this.h) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f532b.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return (this.f533c.isEmpty() || this.f532b.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.g.b(this.f532b);
        int size = this.f532b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f532b.get(i);
            int i2 = bVar.a;
            if (i2 == 1) {
                c(bVar);
            } else if (i2 == 2) {
                f(bVar);
            } else if (i2 == 4) {
                g(bVar);
            } else if (i2 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f535e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f532b.clear();
    }

    void t(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(list.get(i));
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        t(this.f532b);
        t(this.f533c);
        this.h = 0;
    }
}
