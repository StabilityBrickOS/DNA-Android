package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class j0 implements androidx.appcompat.view.menu.p {
    private static Method J;
    private static Method K;
    private static Method L;
    final f A;
    private final e B;
    private final d C;
    private final b D;
    final Handler E;
    private final Rect F;
    private Rect G;
    private boolean H;
    PopupWindow I;

    /* renamed from: e, reason: collision with root package name */
    private Context f225e;
    private ListAdapter f;
    f0 g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private boolean q;
    private boolean r;
    int s;
    private View t;
    private int u;
    private DataSetObserver v;
    private View w;
    private Drawable x;
    private AdapterView.OnItemClickListener y;
    private AdapterView.OnItemSelectedListener z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            f0 f0Var;
            if (i == -1 || (f0Var = j0.this.g) == null) {
                return;
            }
            f0Var.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends DataSetObserver {
        c() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (j0.this.c()) {
                j0.this.a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            j0.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements AbsListView.OnScrollListener {
        d() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || j0.this.A() || j0.this.I.getContentView() == null) {
                return;
            }
            j0 j0Var = j0.this;
            j0Var.E.removeCallbacks(j0Var.A);
            j0.this.A.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements View.OnTouchListener {
        e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = j0.this.I) != null && popupWindow.isShowing() && x >= 0 && x < j0.this.I.getWidth() && y >= 0 && y < j0.this.I.getHeight()) {
                j0 j0Var = j0.this;
                j0Var.E.postDelayed(j0Var.A, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            j0 j0Var2 = j0.this;
            j0Var2.E.removeCallbacks(j0Var2.A);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f0 f0Var = j0.this.g;
            if (f0Var == null || !c.f.l.s.N(f0Var) || j0.this.g.getCount() <= j0.this.g.getChildCount()) {
                return;
            }
            int childCount = j0.this.g.getChildCount();
            j0 j0Var = j0.this;
            if (childCount <= j0Var.s) {
                j0Var.I.setInputMethodMode(2);
                j0.this.a();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                J = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                L = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                K = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public j0(Context context) {
        this(context, null, c.a.a.listPopupWindowStyle);
    }

    public j0(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public j0(Context context, AttributeSet attributeSet, int i, int i2) {
        this.h = -2;
        this.i = -2;
        this.l = 1002;
        this.p = 0;
        this.q = false;
        this.r = false;
        this.s = Integer.MAX_VALUE;
        this.u = 0;
        this.A = new f();
        this.B = new e();
        this.C = new d();
        this.D = new b();
        this.F = new Rect();
        this.f225e = context;
        this.E = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.j.ListPopupWindow, i, i2);
        this.j = obtainStyledAttributes.getDimensionPixelOffset(c.a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(c.a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.k = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.m = true;
        }
        obtainStyledAttributes.recycle();
        q qVar = new q(context, attributeSet, i, i2);
        this.I = qVar;
        qVar.setInputMethodMode(1);
    }

    private void C() {
        View view = this.t;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.t);
            }
        }
    }

    private void N(boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            this.I.setIsClippedToScreen(z);
            return;
        }
        Method method = J;
        if (method != null) {
            try {
                method.invoke(this.I, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int q() {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j0.q():int");
    }

    private int u(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.I.getMaxAvailableHeight(view, i, z);
        }
        Method method = K;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.I, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.I.getMaxAvailableHeight(view, i);
    }

    public boolean A() {
        return this.I.getInputMethodMode() == 2;
    }

    public boolean B() {
        return this.H;
    }

    public void D(View view) {
        this.w = view;
    }

    public void E(int i) {
        this.I.setAnimationStyle(i);
    }

    public void F(int i) {
        Drawable background = this.I.getBackground();
        if (background == null) {
            Q(i);
            return;
        }
        background.getPadding(this.F);
        Rect rect = this.F;
        this.i = rect.left + rect.right + i;
    }

    public void G(int i) {
        this.p = i;
    }

    public void H(Rect rect) {
        this.G = rect != null ? new Rect(rect) : null;
    }

    public void I(int i) {
        this.I.setInputMethodMode(i);
    }

    public void J(boolean z) {
        this.H = z;
        this.I.setFocusable(z);
    }

    public void K(PopupWindow.OnDismissListener onDismissListener) {
        this.I.setOnDismissListener(onDismissListener);
    }

    public void L(AdapterView.OnItemClickListener onItemClickListener) {
        this.y = onItemClickListener;
    }

    public void M(boolean z) {
        this.o = true;
        this.n = z;
    }

    public void O(int i) {
        this.u = i;
    }

    public void P(int i) {
        f0 f0Var = this.g;
        if (!c() || f0Var == null) {
            return;
        }
        f0Var.setListSelectionHidden(false);
        f0Var.setSelection(i);
        if (f0Var.getChoiceMode() != 0) {
            f0Var.setItemChecked(i, true);
        }
    }

    public void Q(int i) {
        this.i = i;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a() {
        int q = q();
        boolean A = A();
        androidx.core.widget.h.b(this.I, this.l);
        if (this.I.isShowing()) {
            if (c.f.l.s.N(t())) {
                int i = this.i;
                if (i == -1) {
                    i = -1;
                } else if (i == -2) {
                    i = t().getWidth();
                }
                int i2 = this.h;
                if (i2 == -1) {
                    if (!A) {
                        q = -1;
                    }
                    if (A) {
                        this.I.setWidth(this.i == -1 ? -1 : 0);
                        this.I.setHeight(0);
                    } else {
                        this.I.setWidth(this.i == -1 ? -1 : 0);
                        this.I.setHeight(-1);
                    }
                } else if (i2 != -2) {
                    q = i2;
                }
                this.I.setOutsideTouchable((this.r || this.q) ? false : true);
                this.I.update(t(), this.j, this.k, i < 0 ? -1 : i, q < 0 ? -1 : q);
                return;
            }
            return;
        }
        int i3 = this.i;
        if (i3 == -1) {
            i3 = -1;
        } else if (i3 == -2) {
            i3 = t().getWidth();
        }
        int i4 = this.h;
        if (i4 == -1) {
            q = -1;
        } else if (i4 != -2) {
            q = i4;
        }
        this.I.setWidth(i3);
        this.I.setHeight(q);
        N(true);
        this.I.setOutsideTouchable((this.r || this.q) ? false : true);
        this.I.setTouchInterceptor(this.B);
        if (this.o) {
            androidx.core.widget.h.a(this.I, this.n);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = L;
            if (method != null) {
                try {
                    method.invoke(this.I, this.G);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.I.setEpicenterBounds(this.G);
        }
        androidx.core.widget.h.c(this.I, t(), this.j, this.k, this.p);
        this.g.setSelection(-1);
        if (!this.H || this.g.isInTouchMode()) {
            r();
        }
        if (this.H) {
            return;
        }
        this.E.post(this.D);
    }

    public void b(Drawable drawable) {
        this.I.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean c() {
        return this.I.isShowing();
    }

    public void d(int i) {
        this.j = i;
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        this.I.dismiss();
        C();
        this.I.setContentView(null);
        this.g = null;
        this.E.removeCallbacks(this.A);
    }

    public int e() {
        return this.j;
    }

    public int h() {
        if (this.m) {
            return this.k;
        }
        return 0;
    }

    public Drawable j() {
        return this.I.getBackground();
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView l() {
        return this.g;
    }

    public void n(int i) {
        this.k = i;
        this.m = true;
    }

    public void o(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.v;
        if (dataSetObserver == null) {
            this.v = new c();
        } else {
            ListAdapter listAdapter2 = this.f;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.v);
        }
        f0 f0Var = this.g;
        if (f0Var != null) {
            f0Var.setAdapter(this.f);
        }
    }

    public void r() {
        f0 f0Var = this.g;
        if (f0Var != null) {
            f0Var.setListSelectionHidden(true);
            f0Var.requestLayout();
        }
    }

    f0 s(Context context, boolean z) {
        return new f0(context, z);
    }

    public View t() {
        return this.w;
    }

    public Object v() {
        if (c()) {
            return this.g.getSelectedItem();
        }
        return null;
    }

    public long w() {
        if (c()) {
            return this.g.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int x() {
        if (c()) {
            return this.g.getSelectedItemPosition();
        }
        return -1;
    }

    public View y() {
        if (c()) {
            return this.g.getSelectedView();
        }
        return null;
    }

    public int z() {
        return this.i;
    }
}
