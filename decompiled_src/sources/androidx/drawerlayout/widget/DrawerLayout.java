package androidx.drawerlayout.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import c.f.l.b0.c;
import c.f.l.s;
import c.h.b.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    private static final int[] O = {R.attr.colorPrimaryDark};
    static final int[] P = {R.attr.layout_gravity};
    static final boolean Q;
    private static final boolean R;
    private Drawable A;
    private Drawable B;
    private Drawable C;
    private CharSequence D;
    private CharSequence E;
    private Object F;
    private boolean G;
    private Drawable H;
    private Drawable I;
    private Drawable J;
    private Drawable K;
    private final ArrayList<View> L;
    private Rect M;
    private Matrix N;

    /* renamed from: e, reason: collision with root package name */
    private final c f360e;
    private float f;
    private int g;
    private int h;
    private float i;
    private Paint j;
    private final c.h.b.c k;
    private final c.h.b.c l;
    private final g m;
    private final g n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private d w;
    private List<d> x;
    private float y;
    private float z;

    /* loaded from: classes.dex */
    class a implements View.OnApplyWindowInsetsListener {
        a(DrawerLayout drawerLayout) {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).M(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    /* loaded from: classes.dex */
    class b extends c.f.l.a {

        /* renamed from: d, reason: collision with root package name */
        private final Rect f361d = new Rect();

        b() {
        }

        private void n(c.f.l.b0.c cVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.y(childAt)) {
                    cVar.c(childAt);
                }
            }
        }

        private void o(c.f.l.b0.c cVar, c.f.l.b0.c cVar2) {
            Rect rect = this.f361d;
            cVar2.m(rect);
            cVar.W(rect);
            cVar2.n(rect);
            cVar.X(rect);
            cVar.z0(cVar2.M());
            cVar.o0(cVar2.u());
            cVar.a0(cVar2.p());
            cVar.e0(cVar2.r());
            cVar.g0(cVar2.E());
            cVar.b0(cVar2.D());
            cVar.i0(cVar2.F());
            cVar.j0(cVar2.G());
            cVar.U(cVar2.A());
            cVar.u0(cVar2.K());
            cVar.m0(cVar2.H());
            cVar.a(cVar2.k());
        }

        @Override // c.f.l.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.a(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View n = DrawerLayout.this.n();
            if (n == null) {
                return true;
            }
            CharSequence q = DrawerLayout.this.q(DrawerLayout.this.r(n));
            if (q == null) {
                return true;
            }
            text.add(q);
            return true;
        }

        @Override // c.f.l.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        @Override // c.f.l.a
        public void g(View view, c.f.l.b0.c cVar) {
            if (DrawerLayout.Q) {
                super.g(view, cVar);
            } else {
                c.f.l.b0.c P = c.f.l.b0.c.P(cVar);
                super.g(view, P);
                cVar.w0(view);
                Object E = s.E(view);
                if (E instanceof View) {
                    cVar.q0((View) E);
                }
                o(cVar, P);
                P.R();
                n(cVar, (ViewGroup) view);
            }
            cVar.a0(DrawerLayout.class.getName());
            cVar.i0(false);
            cVar.j0(false);
            cVar.S(c.a.f798e);
            cVar.S(c.a.f);
        }

        @Override // c.f.l.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.Q || DrawerLayout.y(view)) {
                return super.i(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    static final class c extends c.f.l.a {
        c() {
        }

        @Override // c.f.l.a
        public void g(View view, c.f.l.b0.c cVar) {
            super.g(view, cVar);
            if (DrawerLayout.y(view)) {
                return;
            }
            cVar.q0(null);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i);

        void b(View view);

        void c(View view, float f);

        void d(View view);
    }

    /* loaded from: classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {
        public int a;

        /* renamed from: b, reason: collision with root package name */
        float f363b;

        /* renamed from: c, reason: collision with root package name */
        boolean f364c;

        /* renamed from: d, reason: collision with root package name */
        int f365d;

        public e(int i, int i2) {
            super(i, i2);
            this.a = 0;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.P);
            this.a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 0;
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.a = 0;
            this.a = eVar.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class f extends c.h.a.a {
        public static final Parcelable.Creator<f> CREATOR = new a();
        int g;
        int h;
        int i;
        int j;
        int k;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<f> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i) {
                return new f[i];
            }
        }

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.g = 0;
            this.g = parcel.readInt();
            this.h = parcel.readInt();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }

        public f(Parcelable parcelable) {
            super(parcelable);
            this.g = 0;
        }

        @Override // c.h.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h);
            parcel.writeInt(this.i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g extends c.AbstractC0043c {
        private final int a;

        /* renamed from: b, reason: collision with root package name */
        private c.h.b.c f366b;

        /* renamed from: c, reason: collision with root package name */
        private final Runnable f367c = new a();

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.o();
            }
        }

        g(int i) {
            this.a = i;
        }

        private void n() {
            View l = DrawerLayout.this.l(this.a == 3 ? 5 : 3);
            if (l != null) {
                DrawerLayout.this.d(l);
            }
        }

        @Override // c.h.b.c.AbstractC0043c
        public int a(View view, int i, int i2) {
            int width;
            int width2;
            if (DrawerLayout.this.c(view, 3)) {
                width2 = -view.getWidth();
                width = 0;
            } else {
                width = DrawerLayout.this.getWidth();
                width2 = width - view.getWidth();
            }
            return Math.max(width2, Math.min(i, width));
        }

        @Override // c.h.b.c.AbstractC0043c
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // c.h.b.c.AbstractC0043c
        public int d(View view) {
            if (DrawerLayout.this.B(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // c.h.b.c.AbstractC0043c
        public void f(int i, int i2) {
            DrawerLayout drawerLayout;
            int i3;
            if ((i & 1) == 1) {
                drawerLayout = DrawerLayout.this;
                i3 = 3;
            } else {
                drawerLayout = DrawerLayout.this;
                i3 = 5;
            }
            View l = drawerLayout.l(i3);
            if (l == null || DrawerLayout.this.p(l) != 0) {
                return;
            }
            this.f366b.b(l, i2);
        }

        @Override // c.h.b.c.AbstractC0043c
        public boolean g(int i) {
            return false;
        }

        @Override // c.h.b.c.AbstractC0043c
        public void h(int i, int i2) {
            DrawerLayout.this.postDelayed(this.f367c, 160L);
        }

        @Override // c.h.b.c.AbstractC0043c
        public void i(View view, int i) {
            ((e) view.getLayoutParams()).f364c = false;
            n();
        }

        @Override // c.h.b.c.AbstractC0043c
        public void j(int i) {
            DrawerLayout.this.Q(this.a, i, this.f366b.v());
        }

        @Override // c.h.b.c.AbstractC0043c
        public void k(View view, int i, int i2, int i3, int i4) {
            float width = (DrawerLayout.this.c(view, 3) ? i + r3 : DrawerLayout.this.getWidth() - i) / view.getWidth();
            DrawerLayout.this.O(view, width);
            view.setVisibility(width == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // c.h.b.c.AbstractC0043c
        public void l(View view, float f, float f2) {
            int i;
            float s = DrawerLayout.this.s(view);
            int width = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && s > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && s > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.f366b.M(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // c.h.b.c.AbstractC0043c
        public boolean m(View view, int i) {
            return DrawerLayout.this.B(view) && DrawerLayout.this.c(view, this.a) && DrawerLayout.this.p(view) == 0;
        }

        void o() {
            View l;
            int width;
            int w = this.f366b.w();
            boolean z = this.a == 3;
            if (z) {
                l = DrawerLayout.this.l(3);
                width = (l != null ? -l.getWidth() : 0) + w;
            } else {
                l = DrawerLayout.this.l(5);
                width = DrawerLayout.this.getWidth() - w;
            }
            if (l != null) {
                if (((!z || l.getLeft() >= width) && (z || l.getLeft() <= width)) || DrawerLayout.this.p(l) != 0) {
                    return;
                }
                e eVar = (e) l.getLayoutParams();
                this.f366b.O(l, width, l.getTop());
                eVar.f364c = true;
                DrawerLayout.this.invalidate();
                n();
                DrawerLayout.this.b();
            }
        }

        public void p() {
            DrawerLayout.this.removeCallbacks(this.f367c);
        }

        public void q(c.h.b.c cVar) {
            this.f366b = cVar;
        }
    }

    static {
        Q = Build.VERSION.SDK_INT >= 19;
        R = Build.VERSION.SDK_INT >= 21;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f360e = new c();
        this.h = -1728053248;
        this.j = new Paint();
        this.q = true;
        this.r = 3;
        this.s = 3;
        this.t = 3;
        this.u = 3;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.g = (int) ((64.0f * f2) + 0.5f);
        float f3 = 400.0f * f2;
        this.m = new g(3);
        this.n = new g(5);
        c.h.b.c n = c.h.b.c.n(this, 1.0f, this.m);
        this.k = n;
        n.K(1);
        this.k.L(f3);
        this.m.q(this.k);
        c.h.b.c n2 = c.h.b.c.n(this, 1.0f, this.n);
        this.l = n2;
        n2.K(2);
        this.l.L(f3);
        this.n.q(this.l);
        setFocusableInTouchMode(true);
        s.s0(this, 1);
        s.i0(this, new b());
        setMotionEventSplittingEnabled(false);
        if (s.v(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new a(this));
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(O);
                try {
                    this.A = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.A = null;
            }
        }
        this.f = f2 * 10.0f;
        this.L = new ArrayList<>();
    }

    private boolean D(float f2, float f3, View view) {
        if (this.M == null) {
            this.M = new Rect();
        }
        view.getHitRect(this.M);
        return this.M.contains((int) f2, (int) f3);
    }

    private boolean E(Drawable drawable, int i) {
        if (drawable == null || !androidx.core.graphics.drawable.a.h(drawable)) {
            return false;
        }
        androidx.core.graphics.drawable.a.m(drawable, i);
        return true;
    }

    private Drawable J() {
        int y = s.y(this);
        if (y == 0) {
            Drawable drawable = this.H;
            if (drawable != null) {
                E(drawable, y);
                return this.H;
            }
        } else {
            Drawable drawable2 = this.I;
            if (drawable2 != null) {
                E(drawable2, y);
                return this.I;
            }
        }
        return this.J;
    }

    private Drawable K() {
        int y = s.y(this);
        if (y == 0) {
            Drawable drawable = this.I;
            if (drawable != null) {
                E(drawable, y);
                return this.I;
            }
        } else {
            Drawable drawable2 = this.H;
            if (drawable2 != null) {
                E(drawable2, y);
                return this.H;
            }
        }
        return this.K;
    }

    private void L() {
        if (R) {
            return;
        }
        this.B = J();
        this.C = K();
    }

    private void P(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            s.s0(childAt, ((z || B(childAt)) && !(z && childAt == view)) ? 4 : 1);
        }
    }

    private boolean k(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent t = t(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(t);
            t.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent t(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.N == null) {
                this.N = new Matrix();
            }
            matrix.invert(this.N);
            obtain.transform(this.N);
        }
        return obtain;
    }

    static String u(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    private static boolean v(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    private boolean w() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((e) getChildAt(i).getLayoutParams()).f364c) {
                return true;
            }
        }
        return false;
    }

    private boolean x() {
        return n() != null;
    }

    static boolean y(View view) {
        return (s.w(view) == 4 || s.w(view) == 2) ? false : true;
    }

    public boolean A(View view) {
        if (B(view)) {
            return (((e) view.getLayoutParams()).f365d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    boolean B(View view) {
        int b2 = c.f.l.d.b(((e) view.getLayoutParams()).a, s.y(view));
        return ((b2 & 3) == 0 && (b2 & 5) == 0) ? false : true;
    }

    public boolean C(View view) {
        if (B(view)) {
            return ((e) view.getLayoutParams()).f363b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    void F(View view, float f2) {
        float s = s(view);
        float width = view.getWidth();
        int i = ((int) (width * f2)) - ((int) (s * width));
        if (!c(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        O(view, f2);
    }

    public void G(View view) {
        H(view, true);
    }

    public void H(View view, boolean z) {
        if (!B(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        e eVar = (e) view.getLayoutParams();
        if (this.q) {
            eVar.f363b = 1.0f;
            eVar.f365d = 1;
            P(view, true);
        } else if (z) {
            eVar.f365d |= 2;
            if (c(view, 3)) {
                this.k.O(view, 0, view.getTop());
            } else {
                this.l.O(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            F(view, 1.0f);
            Q(eVar.a, 0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void I(d dVar) {
        List<d> list;
        if (dVar == null || (list = this.x) == null) {
            return;
        }
        list.remove(dVar);
    }

    public void M(Object obj, boolean z) {
        this.F = obj;
        this.G = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void N(int i, int i2) {
        View l;
        int b2 = c.f.l.d.b(i2, s.y(this));
        if (i2 == 3) {
            this.r = i;
        } else if (i2 == 5) {
            this.s = i;
        } else if (i2 == 8388611) {
            this.t = i;
        } else if (i2 == 8388613) {
            this.u = i;
        }
        if (i != 0) {
            (b2 == 3 ? this.k : this.l).a();
        }
        if (i != 1) {
            if (i == 2 && (l = l(b2)) != null) {
                G(l);
                return;
            }
            return;
        }
        View l2 = l(b2);
        if (l2 != null) {
            d(l2);
        }
    }

    void O(View view, float f2) {
        e eVar = (e) view.getLayoutParams();
        if (f2 == eVar.f363b) {
            return;
        }
        eVar.f363b = f2;
        j(view, f2);
    }

    void Q(int i, int i2, View view) {
        int z = this.k.z();
        int z2 = this.l.z();
        int i3 = 2;
        if (z == 1 || z2 == 1) {
            i3 = 1;
        } else if (z != 2 && z2 != 2) {
            i3 = 0;
        }
        if (view != null && i2 == 0) {
            float f2 = ((e) view.getLayoutParams()).f363b;
            if (f2 == 0.0f) {
                h(view);
            } else if (f2 == 1.0f) {
                i(view);
            }
        }
        if (i3 != this.o) {
            this.o = i3;
            List<d> list = this.x;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.x.get(size).a(i3);
                }
            }
        }
    }

    public void a(d dVar) {
        if (dVar == null) {
            return;
        }
        if (this.x == null) {
            this.x = new ArrayList();
        }
        this.x.add(dVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (!B(childAt)) {
                this.L.add(childAt);
            } else if (A(childAt)) {
                childAt.addFocusables(arrayList, i, i2);
                z = true;
            }
        }
        if (!z) {
            int size = this.L.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = this.L.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        this.L.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        s.s0(view, (m() != null || B(view)) ? 4 : 1);
        if (Q) {
            return;
        }
        s.i0(view, this.f360e);
    }

    void b() {
        if (this.v) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).dispatchTouchEvent(obtain);
        }
        obtain.recycle();
        this.v = true;
    }

    boolean c(View view, int i) {
        return (r(view) & i) == i;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f2 = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f2 = Math.max(f2, ((e) getChildAt(i).getLayoutParams()).f363b);
        }
        this.i = f2;
        boolean m = this.k.m(true);
        boolean m2 = this.l.m(true);
        if (m || m2) {
            s.Z(this);
        }
    }

    public void d(View view) {
        e(view, true);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.i <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (D(x, y, childAt) && !z(childAt) && k(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        Drawable drawable;
        int height = getHeight();
        boolean z = z(view);
        int width = getWidth();
        int save = canvas.save();
        int i = 0;
        if (z) {
            int childCount = getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && v(childAt) && B(childAt) && childAt.getHeight() >= height) {
                    if (c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i2) {
                            i2 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, width, getHeight());
            i = i2;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        float f2 = this.i;
        if (f2 <= 0.0f || !z) {
            if (this.B != null && c(view, 3)) {
                int intrinsicWidth = this.B.getIntrinsicWidth();
                int right2 = view.getRight();
                float max = Math.max(0.0f, Math.min(right2 / this.k.w(), 1.0f));
                this.B.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
                this.B.setAlpha((int) (max * 255.0f));
                drawable = this.B;
            } else if (this.C != null && c(view, 5)) {
                int intrinsicWidth2 = this.C.getIntrinsicWidth();
                int left2 = view.getLeft();
                float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.l.w(), 1.0f));
                this.C.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
                this.C.setAlpha((int) (max2 * 255.0f));
                drawable = this.C;
            }
            drawable.draw(canvas);
        } else {
            this.j.setColor((this.h & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * f2)) << 24));
            canvas.drawRect(i, 0.0f, width, getHeight(), this.j);
        }
        return drawChild;
    }

    public void e(View view, boolean z) {
        c.h.b.c cVar;
        int width;
        if (!B(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        e eVar = (e) view.getLayoutParams();
        if (this.q) {
            eVar.f363b = 0.0f;
            eVar.f365d = 0;
        } else if (z) {
            eVar.f365d |= 4;
            if (c(view, 3)) {
                cVar = this.k;
                width = -view.getWidth();
            } else {
                cVar = this.l;
                width = getWidth();
            }
            cVar.O(view, width, view.getTop());
        } else {
            F(view, 0.0f);
            Q(eVar.a, 0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    public void f() {
        g(false);
    }

    void g(boolean z) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            e eVar = (e) childAt.getLayoutParams();
            if (B(childAt) && (!z || eVar.f364c)) {
                z2 |= c(childAt, 3) ? this.k.O(childAt, -childAt.getWidth(), childAt.getTop()) : this.l.O(childAt, getWidth(), childAt.getTop());
                eVar.f364c = false;
            }
        }
        this.m.p();
        this.n.p();
        if (z2) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public float getDrawerElevation() {
        if (R) {
            return this.f;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.A;
    }

    void h(View view) {
        View rootView;
        e eVar = (e) view.getLayoutParams();
        if ((eVar.f365d & 1) == 1) {
            eVar.f365d = 0;
            List<d> list = this.x;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.x.get(size).d(view);
                }
            }
            P(view, false);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    void i(View view) {
        e eVar = (e) view.getLayoutParams();
        if ((eVar.f365d & 1) == 0) {
            eVar.f365d = 1;
            List<d> list = this.x;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.x.get(size).b(view);
                }
            }
            P(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void j(View view, float f2) {
        List<d> list = this.x;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.x.get(size).c(view, f2);
            }
        }
    }

    View l(int i) {
        int b2 = c.f.l.d.b(i, s.y(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((r(childAt) & 7) == b2) {
                return childAt;
            }
        }
        return null;
    }

    View m() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((e) childAt.getLayoutParams()).f365d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    View n() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (B(childAt) && C(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int o(int i) {
        int y = s.y(this);
        if (i == 3) {
            int i2 = this.r;
            if (i2 != 3) {
                return i2;
            }
            int i3 = y == 0 ? this.t : this.u;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (i == 5) {
            int i4 = this.s;
            if (i4 != 3) {
                return i4;
            }
            int i5 = y == 0 ? this.u : this.t;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (i == 8388611) {
            int i6 = this.t;
            if (i6 != 3) {
                return i6;
            }
            int i7 = y == 0 ? this.r : this.s;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        }
        if (i != 8388613) {
            return 0;
        }
        int i8 = this.u;
        if (i8 != 3) {
            return i8;
        }
        int i9 = y == 0 ? this.s : this.r;
        if (i9 != 3) {
            return i9;
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.q = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Object obj;
        super.onDraw(canvas);
        if (!this.G || this.A == null) {
            return;
        }
        int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || (obj = this.F) == null) ? 0 : ((WindowInsets) obj).getSystemWindowInsetTop();
        if (systemWindowInsetTop > 0) {
            this.A.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.A.draw(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r0 != 3) goto L13;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            c.h.b.c r1 = r6.k
            boolean r1 = r1.N(r7)
            c.h.b.c r2 = r6.l
            boolean r2 = r2.N(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L38
            if (r0 == r2) goto L31
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L1e
            if (r0 == r4) goto L31
            goto L36
        L1e:
            c.h.b.c r7 = r6.k
            boolean r7 = r7.d(r4)
            if (r7 == 0) goto L36
            androidx.drawerlayout.widget.DrawerLayout$g r7 = r6.m
            r7.p()
            androidx.drawerlayout.widget.DrawerLayout$g r7 = r6.n
            r7.p()
            goto L36
        L31:
            r6.g(r2)
            r6.v = r3
        L36:
            r7 = 0
            goto L60
        L38:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.y = r0
            r6.z = r7
            float r4 = r6.i
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5d
            c.h.b.c r4 = r6.k
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.t(r0, r7)
            if (r7 == 0) goto L5d
            boolean r7 = r6.z(r7)
            if (r7 == 0) goto L5d
            r7 = 1
            goto L5e
        L5d:
            r7 = 0
        L5e:
            r6.v = r3
        L60:
            if (r1 != 0) goto L70
            if (r7 != 0) goto L70
            boolean r7 = r6.w()
            if (r7 != 0) goto L70
            boolean r7 = r6.v
            if (r7 == 0) goto L6f
            goto L70
        L6f:
            r2 = 0
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !x()) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View n = n();
        if (n != null && p(n) == 0) {
            f();
        }
        return n != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f2;
        int i5;
        int measuredHeight;
        int i6;
        int i7;
        this.p = true;
        int i8 = i3 - i;
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (z(childAt)) {
                    int i10 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
                    childAt.layout(i10, ((ViewGroup.MarginLayoutParams) eVar).topMargin, childAt.getMeasuredWidth() + i10, ((ViewGroup.MarginLayoutParams) eVar).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    if (c(childAt, 3)) {
                        float f3 = measuredWidth;
                        i5 = (-measuredWidth) + ((int) (eVar.f363b * f3));
                        f2 = (measuredWidth + i5) / f3;
                    } else {
                        float f4 = measuredWidth;
                        f2 = (i8 - r11) / f4;
                        i5 = i8 - ((int) (eVar.f363b * f4));
                    }
                    boolean z2 = f2 != eVar.f363b;
                    int i11 = eVar.a & 112;
                    if (i11 != 16) {
                        if (i11 != 80) {
                            measuredHeight = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                            i6 = measuredWidth + i5;
                            i7 = measuredHeight2 + measuredHeight;
                        } else {
                            int i12 = i4 - i2;
                            measuredHeight = (i12 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - childAt.getMeasuredHeight();
                            i6 = measuredWidth + i5;
                            i7 = i12 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                        }
                        childAt.layout(i5, measuredHeight, i6, i7);
                    } else {
                        int i13 = i4 - i2;
                        int i14 = (i13 - measuredHeight2) / 2;
                        int i15 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                        if (i14 < i15) {
                            i14 = i15;
                        } else {
                            int i16 = i14 + measuredHeight2;
                            int i17 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                            if (i16 > i13 - i17) {
                                i14 = (i13 - i17) - measuredHeight2;
                            }
                        }
                        childAt.layout(i5, i14, measuredWidth + i5, measuredHeight2 + i14);
                    }
                    if (z2) {
                        O(childAt, f2);
                    }
                    int i18 = eVar.f363b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i18) {
                        childAt.setVisibility(i18);
                    }
                }
            }
        }
        this.p = false;
        this.q = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
            if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        int i3 = 0;
        boolean z = this.F != null && s.v(this);
        int y = s.y(this);
        int childCount = getChildCount();
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (z) {
                    int b2 = c.f.l.d.b(eVar.a, y);
                    boolean v = s.v(childAt);
                    int i5 = Build.VERSION.SDK_INT;
                    if (v) {
                        if (i5 >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.F;
                            if (b2 == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i3, windowInsets.getSystemWindowInsetBottom());
                            } else if (b2 == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i3, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (i5 >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.F;
                        if (b2 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i3, windowInsets2.getSystemWindowInsetBottom());
                        } else if (b2 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i3, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) eVar).topMargin = windowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = windowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (z(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, 1073741824));
                } else {
                    if (!B(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i4 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (R) {
                        float t = s.t(childAt);
                        float f2 = this.f;
                        if (t != f2) {
                            s.p0(childAt, f2);
                        }
                    }
                    int r = r(childAt) & 7;
                    boolean z4 = r == 3;
                    if ((z4 && z2) || (!z4 && z3)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + u(r) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z4) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i, this.g + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin, ((ViewGroup.MarginLayoutParams) eVar).width), ViewGroup.getChildMeasureSpec(i2, ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, ((ViewGroup.MarginLayoutParams) eVar).height));
                    i4++;
                    i3 = 0;
                }
            }
            i4++;
            i3 = 0;
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View l;
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.f());
        int i = fVar.g;
        if (i != 0 && (l = l(i)) != null) {
            G(l);
        }
        int i2 = fVar.h;
        if (i2 != 3) {
            N(i2, 3);
        }
        int i3 = fVar.i;
        if (i3 != 3) {
            N(i3, 5);
        }
        int i4 = fVar.j;
        if (i4 != 3) {
            N(i4, 8388611);
        }
        int i5 = fVar.k;
        if (i5 != 3) {
            N(i5, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        L();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            e eVar = (e) getChildAt(i).getLayoutParams();
            boolean z = eVar.f365d == 1;
            boolean z2 = eVar.f365d == 2;
            if (z || z2) {
                fVar.g = eVar.a;
                break;
            }
        }
        fVar.h = this.r;
        fVar.i = this.s;
        fVar.j = this.t;
        fVar.k = this.u;
        return fVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
    
        if (p(r7) != 2) goto L20;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            c.h.b.c r0 = r6.k
            r0.E(r7)
            c.h.b.c r0 = r6.l
            r0.E(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L60
            if (r0 == r2) goto L1e
            r7 = 3
            if (r0 == r7) goto L1a
            goto L6e
        L1a:
            r6.g(r2)
            goto L6c
        L1e:
            float r0 = r7.getX()
            float r7 = r7.getY()
            c.h.b.c r3 = r6.k
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.t(r4, r5)
            if (r3 == 0) goto L5b
            boolean r3 = r6.z(r3)
            if (r3 == 0) goto L5b
            float r3 = r6.y
            float r0 = r0 - r3
            float r3 = r6.z
            float r7 = r7 - r3
            c.h.b.c r3 = r6.k
            int r3 = r3.y()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L5b
            android.view.View r7 = r6.m()
            if (r7 == 0) goto L5b
            int r7 = r6.p(r7)
            r0 = 2
            if (r7 != r0) goto L5c
        L5b:
            r1 = 1
        L5c:
            r6.g(r1)
            goto L6e
        L60:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.y = r0
            r6.z = r7
        L6c:
            r6.v = r1
        L6e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public int p(View view) {
        if (B(view)) {
            return o(((e) view.getLayoutParams()).a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public CharSequence q(int i) {
        int b2 = c.f.l.d.b(i, s.y(this));
        if (b2 == 3) {
            return this.D;
        }
        if (b2 == 5) {
            return this.E;
        }
        return null;
    }

    int r(View view) {
        return c.f.l.d.b(((e) view.getLayoutParams()).a, s.y(this));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            g(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.p) {
            return;
        }
        super.requestLayout();
    }

    float s(View view) {
        return ((e) view.getLayoutParams()).f363b;
    }

    public void setDrawerElevation(float f2) {
        this.f = f2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (B(childAt)) {
                s.p0(childAt, this.f);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(d dVar) {
        d dVar2 = this.w;
        if (dVar2 != null) {
            I(dVar2);
        }
        if (dVar != null) {
            a(dVar);
        }
        this.w = dVar;
    }

    public void setDrawerLockMode(int i) {
        N(i, 3);
        N(i, 5);
    }

    public void setScrimColor(int i) {
        this.h = i;
        invalidate();
    }

    public void setStatusBarBackground(int i) {
        this.A = i != 0 ? c.f.d.a.c(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.A = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.A = new ColorDrawable(i);
        invalidate();
    }

    boolean z(View view) {
        return ((e) view.getLayoutParams()).a == 0;
    }
}
