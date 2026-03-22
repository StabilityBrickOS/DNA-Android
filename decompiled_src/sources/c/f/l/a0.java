package c.f.l;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;

/* loaded from: classes.dex */
public class a0 {

    /* renamed from: b, reason: collision with root package name */
    public static final a0 f784b = new a().a().a().b().c();
    private final i a;

    /* loaded from: classes.dex */
    public static final class a {
        private final d a;

        public a() {
            int i = Build.VERSION.SDK_INT;
            this.a = i >= 29 ? new c() : i >= 20 ? new b() : new d();
        }

        public a(a0 a0Var) {
            int i = Build.VERSION.SDK_INT;
            this.a = i >= 29 ? new c(a0Var) : i >= 20 ? new b(a0Var) : new d(a0Var);
        }

        public a0 a() {
            return this.a.a();
        }

        public a b(c.f.e.b bVar) {
            this.a.b(bVar);
            return this;
        }

        public a c(c.f.e.b bVar) {
            this.a.c(bVar);
            return this;
        }
    }

    /* loaded from: classes.dex */
    private static class b extends d {

        /* renamed from: c, reason: collision with root package name */
        private static Field f785c;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f786d;

        /* renamed from: e, reason: collision with root package name */
        private static Constructor<WindowInsets> f787e;
        private static boolean f;

        /* renamed from: b, reason: collision with root package name */
        private WindowInsets f788b;

        b() {
            this.f788b = d();
        }

        b(a0 a0Var) {
            this.f788b = a0Var.n();
        }

        private static WindowInsets d() {
            if (!f786d) {
                try {
                    f785c = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f786d = true;
            }
            Field field = f785c;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!f) {
                try {
                    f787e = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                f = true;
            }
            Constructor<WindowInsets> constructor = f787e;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        @Override // c.f.l.a0.d
        a0 a() {
            return a0.o(this.f788b);
        }

        @Override // c.f.l.a0.d
        void c(c.f.e.b bVar) {
            WindowInsets windowInsets = this.f788b;
            if (windowInsets != null) {
                this.f788b = windowInsets.replaceSystemWindowInsets(bVar.a, bVar.f715b, bVar.f716c, bVar.f717d);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class c extends d {

        /* renamed from: b, reason: collision with root package name */
        final WindowInsets.Builder f789b;

        c() {
            this.f789b = new WindowInsets.Builder();
        }

        c(a0 a0Var) {
            WindowInsets n = a0Var.n();
            this.f789b = n != null ? new WindowInsets.Builder(n) : new WindowInsets.Builder();
        }

        @Override // c.f.l.a0.d
        a0 a() {
            return a0.o(this.f789b.build());
        }

        @Override // c.f.l.a0.d
        void b(c.f.e.b bVar) {
            this.f789b.setStableInsets(bVar.c());
        }

        @Override // c.f.l.a0.d
        void c(c.f.e.b bVar) {
            this.f789b.setSystemWindowInsets(bVar.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {
        private final a0 a;

        d() {
            this(new a0((a0) null));
        }

        d(a0 a0Var) {
            this.a = a0Var;
        }

        a0 a() {
            return this.a;
        }

        void b(c.f.e.b bVar) {
        }

        void c(c.f.e.b bVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e extends i {

        /* renamed from: b, reason: collision with root package name */
        final WindowInsets f790b;

        /* renamed from: c, reason: collision with root package name */
        private c.f.e.b f791c;

        e(a0 a0Var, WindowInsets windowInsets) {
            super(a0Var);
            this.f791c = null;
            this.f790b = windowInsets;
        }

        e(a0 a0Var, e eVar) {
            this(a0Var, new WindowInsets(eVar.f790b));
        }

        @Override // c.f.l.a0.i
        final c.f.e.b g() {
            if (this.f791c == null) {
                this.f791c = c.f.e.b.a(this.f790b.getSystemWindowInsetLeft(), this.f790b.getSystemWindowInsetTop(), this.f790b.getSystemWindowInsetRight(), this.f790b.getSystemWindowInsetBottom());
            }
            return this.f791c;
        }

        @Override // c.f.l.a0.i
        a0 h(int i, int i2, int i3, int i4) {
            a aVar = new a(a0.o(this.f790b));
            aVar.c(a0.k(g(), i, i2, i3, i4));
            aVar.b(a0.k(f(), i, i2, i3, i4));
            return aVar.a();
        }

        @Override // c.f.l.a0.i
        boolean j() {
            return this.f790b.isRound();
        }
    }

    /* loaded from: classes.dex */
    private static class f extends e {

        /* renamed from: d, reason: collision with root package name */
        private c.f.e.b f792d;

        f(a0 a0Var, WindowInsets windowInsets) {
            super(a0Var, windowInsets);
            this.f792d = null;
        }

        f(a0 a0Var, f fVar) {
            super(a0Var, fVar);
            this.f792d = null;
        }

        @Override // c.f.l.a0.i
        a0 b() {
            return a0.o(this.f790b.consumeStableInsets());
        }

        @Override // c.f.l.a0.i
        a0 c() {
            return a0.o(this.f790b.consumeSystemWindowInsets());
        }

        @Override // c.f.l.a0.i
        final c.f.e.b f() {
            if (this.f792d == null) {
                this.f792d = c.f.e.b.a(this.f790b.getStableInsetLeft(), this.f790b.getStableInsetTop(), this.f790b.getStableInsetRight(), this.f790b.getStableInsetBottom());
            }
            return this.f792d;
        }

        @Override // c.f.l.a0.i
        boolean i() {
            return this.f790b.isConsumed();
        }
    }

    /* loaded from: classes.dex */
    private static class g extends f {
        g(a0 a0Var, WindowInsets windowInsets) {
            super(a0Var, windowInsets);
        }

        g(a0 a0Var, g gVar) {
            super(a0Var, gVar);
        }

        @Override // c.f.l.a0.i
        a0 a() {
            return a0.o(this.f790b.consumeDisplayCutout());
        }

        @Override // c.f.l.a0.i
        c.f.l.c d() {
            return c.f.l.c.a(this.f790b.getDisplayCutout());
        }

        @Override // c.f.l.a0.i
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof g) {
                return Objects.equals(this.f790b, ((g) obj).f790b);
            }
            return false;
        }

        @Override // c.f.l.a0.i
        public int hashCode() {
            return this.f790b.hashCode();
        }
    }

    /* loaded from: classes.dex */
    private static class h extends g {

        /* renamed from: e, reason: collision with root package name */
        private c.f.e.b f793e;

        h(a0 a0Var, WindowInsets windowInsets) {
            super(a0Var, windowInsets);
            this.f793e = null;
        }

        h(a0 a0Var, h hVar) {
            super(a0Var, hVar);
            this.f793e = null;
        }

        @Override // c.f.l.a0.i
        c.f.e.b e() {
            if (this.f793e == null) {
                this.f793e = c.f.e.b.b(this.f790b.getMandatorySystemGestureInsets());
            }
            return this.f793e;
        }

        @Override // c.f.l.a0.e, c.f.l.a0.i
        a0 h(int i, int i2, int i3, int i4) {
            return a0.o(this.f790b.inset(i, i2, i3, i4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        final a0 a;

        i(a0 a0Var) {
            this.a = a0Var;
        }

        a0 a() {
            return this.a;
        }

        a0 b() {
            return this.a;
        }

        a0 c() {
            return this.a;
        }

        c.f.l.c d() {
            return null;
        }

        c.f.e.b e() {
            return g();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return j() == iVar.j() && i() == iVar.i() && c.f.k.c.a(g(), iVar.g()) && c.f.k.c.a(f(), iVar.f()) && c.f.k.c.a(d(), iVar.d());
        }

        c.f.e.b f() {
            return c.f.e.b.f714e;
        }

        c.f.e.b g() {
            return c.f.e.b.f714e;
        }

        a0 h(int i, int i2, int i3, int i4) {
            return a0.f784b;
        }

        public int hashCode() {
            return c.f.k.c.b(Boolean.valueOf(j()), Boolean.valueOf(i()), g(), f(), d());
        }

        boolean i() {
            return false;
        }

        boolean j() {
            return false;
        }
    }

    private a0(WindowInsets windowInsets) {
        i eVar;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            eVar = new h(this, windowInsets);
        } else if (i2 >= 28) {
            eVar = new g(this, windowInsets);
        } else if (i2 >= 21) {
            eVar = new f(this, windowInsets);
        } else {
            if (i2 < 20) {
                this.a = new i(this);
                return;
            }
            eVar = new e(this, windowInsets);
        }
        this.a = eVar;
    }

    public a0(a0 a0Var) {
        i iVar;
        i eVar;
        if (a0Var != null) {
            i iVar2 = a0Var.a;
            if (Build.VERSION.SDK_INT >= 29 && (iVar2 instanceof h)) {
                eVar = new h(this, (h) iVar2);
            } else if (Build.VERSION.SDK_INT >= 28 && (iVar2 instanceof g)) {
                eVar = new g(this, (g) iVar2);
            } else if (Build.VERSION.SDK_INT >= 21 && (iVar2 instanceof f)) {
                eVar = new f(this, (f) iVar2);
            } else if (Build.VERSION.SDK_INT < 20 || !(iVar2 instanceof e)) {
                iVar = new i(this);
            } else {
                eVar = new e(this, (e) iVar2);
            }
            this.a = eVar;
            return;
        }
        iVar = new i(this);
        this.a = iVar;
    }

    static c.f.e.b k(c.f.e.b bVar, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, bVar.a - i2);
        int max2 = Math.max(0, bVar.f715b - i3);
        int max3 = Math.max(0, bVar.f716c - i4);
        int max4 = Math.max(0, bVar.f717d - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? bVar : c.f.e.b.a(max, max2, max3, max4);
    }

    public static a0 o(WindowInsets windowInsets) {
        c.f.k.h.c(windowInsets);
        return new a0(windowInsets);
    }

    public a0 a() {
        return this.a.a();
    }

    public a0 b() {
        return this.a.b();
    }

    public a0 c() {
        return this.a.c();
    }

    public c.f.e.b d() {
        return this.a.e();
    }

    public int e() {
        return i().f717d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a0) {
            return c.f.k.c.a(this.a, ((a0) obj).a);
        }
        return false;
    }

    public int f() {
        return i().a;
    }

    public int g() {
        return i().f716c;
    }

    public int h() {
        return i().f715b;
    }

    public int hashCode() {
        i iVar = this.a;
        if (iVar == null) {
            return 0;
        }
        return iVar.hashCode();
    }

    public c.f.e.b i() {
        return this.a.g();
    }

    public a0 j(int i2, int i3, int i4, int i5) {
        return this.a.h(i2, i3, i4, i5);
    }

    public boolean l() {
        return this.a.i();
    }

    @Deprecated
    public a0 m(int i2, int i3, int i4, int i5) {
        a aVar = new a(this);
        aVar.c(c.f.e.b.a(i2, i3, i4, i5));
        return aVar.a();
    }

    public WindowInsets n() {
        i iVar = this.a;
        if (iVar instanceof e) {
            return ((e) iVar).f790b;
        }
        return null;
    }
}
