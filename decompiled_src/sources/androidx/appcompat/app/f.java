package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.b1;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.c1;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.w0;
import androidx.lifecycle.d;
import c.a.n.b;
import c.a.n.f;
import c.f.d.c.f;
import c.f.l.a0;
import c.f.l.e;
import c.f.l.w;
import c.f.l.y;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends androidx.appcompat.app.e implements g.a, LayoutInflater.Factory2 {
    private static final c.d.g<String, Integer> e0 = new c.d.g<>();
    private static final boolean f0;
    private static final int[] g0;
    private static final boolean h0;
    private static final boolean i0;
    private static boolean j0;
    private TextView A;
    private View B;
    private boolean C;
    private boolean D;
    boolean E;
    boolean F;
    boolean G;
    boolean H;
    boolean I;
    private boolean J;
    private s[] K;
    private s L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    boolean Q;
    private int R;
    private int S;
    private boolean T;
    private boolean U;
    private l V;
    private l W;
    boolean X;
    int Y;
    private final Runnable Z;
    private boolean a0;
    private Rect b0;
    private Rect c0;
    private androidx.appcompat.app.h d0;
    final Object h;
    final Context i;
    Window j;
    private j k;
    final androidx.appcompat.app.d l;
    androidx.appcompat.app.a m;
    MenuInflater n;
    private CharSequence o;
    private c0 p;
    private h q;
    private t r;
    c.a.n.b s;
    ActionBarContextView t;
    PopupWindow u;
    Runnable v;
    w w;
    private boolean x;
    private boolean y;
    ViewGroup z;

    /* loaded from: classes.dex */
    class a implements Thread.UncaughtExceptionHandler {
        final /* synthetic */ Thread.UncaughtExceptionHandler a;

        a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.a = uncaughtExceptionHandler;
        }

        private boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (!a(th)) {
                this.a.uncaughtException(thread, th);
                return;
            }
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            notFoundException.initCause(th.getCause());
            notFoundException.setStackTrace(th.getStackTrace());
            this.a.uncaughtException(thread, notFoundException);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            if ((fVar.Y & 1) != 0) {
                fVar.V(0);
            }
            f fVar2 = f.this;
            if ((fVar2.Y & 4096) != 0) {
                fVar2.V(108);
            }
            f fVar3 = f.this;
            fVar3.X = false;
            fVar3.Y = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements c.f.l.p {
        c() {
        }

        @Override // c.f.l.p
        public a0 a(View view, a0 a0Var) {
            int h = a0Var.h();
            int M0 = f.this.M0(a0Var, null);
            if (h != M0) {
                a0Var = a0Var.m(a0Var.f(), M0, a0Var.g(), a0Var.e());
            }
            return c.f.l.s.V(view, a0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements g0.a {
        d() {
        }

        @Override // androidx.appcompat.widget.g0.a
        public void a(Rect rect) {
            rect.top = f.this.M0(null, rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements ContentFrameLayout.a {
        e() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            f.this.T();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.appcompat.app.f$f, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0004f implements Runnable {

        /* renamed from: androidx.appcompat.app.f$f$a */
        /* loaded from: classes.dex */
        class a extends y {
            a() {
            }

            @Override // c.f.l.x
            public void a(View view) {
                f.this.t.setAlpha(1.0f);
                f.this.w.f(null);
                f.this.w = null;
            }

            @Override // c.f.l.y, c.f.l.x
            public void b(View view) {
                f.this.t.setVisibility(0);
            }
        }

        RunnableC0004f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.u.showAtLocation(fVar.t, 55, 0, 0);
            f.this.W();
            if (!f.this.E0()) {
                f.this.t.setAlpha(1.0f);
                f.this.t.setVisibility(0);
                return;
            }
            f.this.t.setAlpha(0.0f);
            f fVar2 = f.this;
            w c2 = c.f.l.s.c(fVar2.t);
            c2.a(1.0f);
            fVar2.w = c2;
            f.this.w.f(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends y {
        g() {
        }

        @Override // c.f.l.x
        public void a(View view) {
            f.this.t.setAlpha(1.0f);
            f.this.w.f(null);
            f.this.w = null;
        }

        @Override // c.f.l.y, c.f.l.x
        public void b(View view) {
            f.this.t.setVisibility(0);
            f.this.t.sendAccessibilityEvent(32);
            if (f.this.t.getParent() instanceof View) {
                c.f.l.s.f0((View) f.this.t.getParent());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class h implements m.a {
        h() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            f.this.M(gVar);
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            Window.Callback g0 = f.this.g0();
            if (g0 == null) {
                return true;
            }
            g0.onMenuOpened(108, gVar);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements b.a {
        private b.a a;

        /* loaded from: classes.dex */
        class a extends y {
            a() {
            }

            @Override // c.f.l.x
            public void a(View view) {
                f.this.t.setVisibility(8);
                f fVar = f.this;
                PopupWindow popupWindow = fVar.u;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (fVar.t.getParent() instanceof View) {
                    c.f.l.s.f0((View) f.this.t.getParent());
                }
                f.this.t.removeAllViews();
                f.this.w.f(null);
                f fVar2 = f.this;
                fVar2.w = null;
                c.f.l.s.f0(fVar2.z);
            }
        }

        public i(b.a aVar) {
            this.a = aVar;
        }

        @Override // c.a.n.b.a
        public boolean a(c.a.n.b bVar, Menu menu) {
            c.f.l.s.f0(f.this.z);
            return this.a.a(bVar, menu);
        }

        @Override // c.a.n.b.a
        public boolean b(c.a.n.b bVar, MenuItem menuItem) {
            return this.a.b(bVar, menuItem);
        }

        @Override // c.a.n.b.a
        public boolean c(c.a.n.b bVar, Menu menu) {
            return this.a.c(bVar, menu);
        }

        @Override // c.a.n.b.a
        public void d(c.a.n.b bVar) {
            this.a.d(bVar);
            f fVar = f.this;
            if (fVar.u != null) {
                fVar.j.getDecorView().removeCallbacks(f.this.v);
            }
            f fVar2 = f.this;
            if (fVar2.t != null) {
                fVar2.W();
                f fVar3 = f.this;
                w c2 = c.f.l.s.c(fVar3.t);
                c2.a(0.0f);
                fVar3.w = c2;
                f.this.w.f(new a());
            }
            f fVar4 = f.this;
            androidx.appcompat.app.d dVar = fVar4.l;
            if (dVar != null) {
                dVar.i(fVar4.s);
            }
            f fVar5 = f.this;
            fVar5.s = null;
            c.f.l.s.f0(fVar5.z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends c.a.n.i {
        j(Window.Callback callback) {
            super(callback);
        }

        final ActionMode b(ActionMode.Callback callback) {
            f.a aVar = new f.a(f.this.i, callback);
            c.a.n.b G0 = f.this.G0(aVar);
            if (G0 != null) {
                return aVar.e(G0);
            }
            return null;
        }

        @Override // c.a.n.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.U(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // c.a.n.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || f.this.s0(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // c.a.n.i, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // c.a.n.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // c.a.n.i, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            f.this.v0(i);
            return true;
        }

        @Override // c.a.n.i, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            f.this.w0(i);
        }

        @Override // c.a.n.i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar = menu instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menu : null;
            if (i == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.a0(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (gVar != null) {
                gVar.a0(false);
            }
            return onPreparePanel;
        }

        @Override // c.a.n.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            androidx.appcompat.view.menu.g gVar;
            s e0 = f.this.e0(0, true);
            if (e0 == null || (gVar = e0.j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, gVar, i);
            }
        }

        @Override // c.a.n.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return f.this.n0() ? b(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // c.a.n.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            return (f.this.n0() && i == 0) ? b(callback) : super.onWindowStartingActionMode(callback, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends l {

        /* renamed from: c, reason: collision with root package name */
        private final PowerManager f62c;

        k(Context context) {
            super();
            this.f62c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.f.l
        IntentFilter b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.f.l
        public int c() {
            return (Build.VERSION.SDK_INT < 21 || !this.f62c.isPowerSaveMode()) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.f.l
        public void d() {
            f.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class l {
        private BroadcastReceiver a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                l.this.d();
            }
        }

        l() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.a;
            if (broadcastReceiver != null) {
                try {
                    f.this.i.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter b2 = b();
            if (b2 == null || b2.countActions() == 0) {
                return;
            }
            if (this.a == null) {
                this.a = new a();
            }
            f.this.i.registerReceiver(this.a, b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class m extends l {

        /* renamed from: c, reason: collision with root package name */
        private final androidx.appcompat.app.l f65c;

        m(androidx.appcompat.app.l lVar) {
            super();
            this.f65c = lVar;
        }

        @Override // androidx.appcompat.app.f.l
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.f.l
        public int c() {
            return this.f65c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.f.l
        public void d() {
            f.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class n {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i = configuration.densityDpi;
            int i2 = configuration2.densityDpi;
            if (i != i2) {
                configuration3.densityDpi = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class o {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class p {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i = configuration.colorMode & 3;
            int i2 = configuration2.colorMode;
            if (i != (i2 & 3)) {
                configuration3.colorMode |= i2 & 3;
            }
            int i3 = configuration.colorMode & 12;
            int i4 = configuration2.colorMode;
            if (i3 != (i4 & 12)) {
                configuration3.colorMode |= i4 & 12;
            }
        }
    }

    /* loaded from: classes.dex */
    private static class q {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class r extends ContentFrameLayout {
        public r(Context context) {
            super(context);
        }

        private boolean c(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.U(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            f.this.O(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(c.a.k.a.a.d(getContext(), i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class s {
        int a;

        /* renamed from: b, reason: collision with root package name */
        int f67b;

        /* renamed from: c, reason: collision with root package name */
        int f68c;

        /* renamed from: d, reason: collision with root package name */
        int f69d;

        /* renamed from: e, reason: collision with root package name */
        int f70e;
        int f;
        ViewGroup g;
        View h;
        View i;
        androidx.appcompat.view.menu.g j;
        androidx.appcompat.view.menu.e k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        s(int i) {
            this.a = i;
        }

        androidx.appcompat.view.menu.n a(m.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(this.l, c.a.g.abc_list_menu_item_layout);
                this.k = eVar;
                eVar.h(aVar);
                this.j.b(this.k);
            }
            return this.k.c(this.g);
        }

        public boolean b() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.a().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.g gVar2 = this.j;
            if (gVar == gVar2) {
                return;
            }
            if (gVar2 != null) {
                gVar2.O(this.k);
            }
            this.j = gVar;
            if (gVar == null || (eVar = this.k) == null) {
                return;
            }
            gVar.b(eVar);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(c.a.a.actionBarPopupTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                newTheme.applyStyle(i, true);
            }
            newTheme.resolveAttribute(c.a.a.panelMenuListTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 == 0) {
                i2 = c.a.i.Theme_AppCompat_CompactMenu;
            }
            newTheme.applyStyle(i2, true);
            c.a.n.d dVar = new c.a.n.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(c.a.j.AppCompatTheme);
            this.f67b = obtainStyledAttributes.getResourceId(c.a.j.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(c.a.j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class t implements m.a {
        t() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            androidx.appcompat.view.menu.g D = gVar.D();
            boolean z2 = D != gVar;
            f fVar = f.this;
            if (z2) {
                gVar = D;
            }
            s Z = fVar.Z(gVar);
            if (Z != null) {
                if (!z2) {
                    f.this.P(Z, z);
                } else {
                    f.this.L(Z.a, Z, D);
                    f.this.P(Z, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            Window.Callback g0;
            if (gVar != gVar.D()) {
                return true;
            }
            f fVar = f.this;
            if (!fVar.E || (g0 = fVar.g0()) == null || f.this.Q) {
                return true;
            }
            g0.onMenuOpened(108, gVar);
            return true;
        }
    }

    static {
        f0 = Build.VERSION.SDK_INT < 21;
        g0 = new int[]{R.attr.windowBackground};
        h0 = !"robolectric".equals(Build.FINGERPRINT);
        i0 = Build.VERSION.SDK_INT >= 17;
        if (!f0 || j0) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        j0 = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Activity activity, androidx.appcompat.app.d dVar) {
        this(activity, null, dVar, activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Dialog dialog, androidx.appcompat.app.d dVar) {
        this(dialog.getContext(), dialog.getWindow(), dVar, dialog);
    }

    private f(Context context, Window window, androidx.appcompat.app.d dVar, Object obj) {
        Integer num;
        androidx.appcompat.app.c J0;
        this.w = null;
        this.x = true;
        this.R = -100;
        this.Z = new b();
        this.i = context;
        this.l = dVar;
        this.h = obj;
        if (this.R == -100 && (obj instanceof Dialog) && (J0 = J0()) != null) {
            this.R = J0.v().k();
        }
        if (this.R == -100 && (num = e0.get(this.h.getClass().getName())) != null) {
            this.R = num.intValue();
            e0.remove(this.h.getClass().getName());
        }
        if (window != null) {
            J(window);
        }
        androidx.appcompat.widget.j.h();
    }

    private boolean A0(s sVar, int i2, KeyEvent keyEvent, int i3) {
        androidx.appcompat.view.menu.g gVar;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((sVar.m || B0(sVar, keyEvent)) && (gVar = sVar.j) != null) {
            z = gVar.performShortcut(i2, keyEvent, i3);
        }
        if (z && (i3 & 1) == 0 && this.p == null) {
            P(sVar, true);
        }
        return z;
    }

    private boolean B0(s sVar, KeyEvent keyEvent) {
        c0 c0Var;
        c0 c0Var2;
        c0 c0Var3;
        if (this.Q) {
            return false;
        }
        if (sVar.m) {
            return true;
        }
        s sVar2 = this.L;
        if (sVar2 != null && sVar2 != sVar) {
            P(sVar2, false);
        }
        Window.Callback g02 = g0();
        if (g02 != null) {
            sVar.i = g02.onCreatePanelView(sVar.a);
        }
        int i2 = sVar.a;
        boolean z = i2 == 0 || i2 == 108;
        if (z && (c0Var3 = this.p) != null) {
            c0Var3.f();
        }
        if (sVar.i == null && (!z || !(z0() instanceof androidx.appcompat.app.j))) {
            if (sVar.j == null || sVar.r) {
                if (sVar.j == null && (!k0(sVar) || sVar.j == null)) {
                    return false;
                }
                if (z && this.p != null) {
                    if (this.q == null) {
                        this.q = new h();
                    }
                    this.p.a(sVar.j, this.q);
                }
                sVar.j.d0();
                if (!g02.onCreatePanelMenu(sVar.a, sVar.j)) {
                    sVar.c(null);
                    if (z && (c0Var = this.p) != null) {
                        c0Var.a(null, this.q);
                    }
                    return false;
                }
                sVar.r = false;
            }
            sVar.j.d0();
            Bundle bundle = sVar.s;
            if (bundle != null) {
                sVar.j.P(bundle);
                sVar.s = null;
            }
            if (!g02.onPreparePanel(0, sVar.i, sVar.j)) {
                if (z && (c0Var2 = this.p) != null) {
                    c0Var2.a(null, this.q);
                }
                sVar.j.c0();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            sVar.p = z2;
            sVar.j.setQwertyMode(z2);
            sVar.j.c0();
        }
        sVar.m = true;
        sVar.n = false;
        this.L = sVar;
        return true;
    }

    private void C0(boolean z) {
        c0 c0Var = this.p;
        if (c0Var == null || !c0Var.g() || (ViewConfiguration.get(this.i).hasPermanentMenuKey() && !this.p.b())) {
            s e02 = e0(0, true);
            e02.q = true;
            P(e02, false);
            y0(e02, null);
            return;
        }
        Window.Callback g02 = g0();
        if (this.p.c() && z) {
            this.p.d();
            if (this.Q) {
                return;
            }
            g02.onPanelClosed(108, e0(0, true).j);
            return;
        }
        if (g02 == null || this.Q) {
            return;
        }
        if (this.X && (this.Y & 1) != 0) {
            this.j.getDecorView().removeCallbacks(this.Z);
            this.Z.run();
        }
        s e03 = e0(0, true);
        androidx.appcompat.view.menu.g gVar = e03.j;
        if (gVar == null || e03.r || !g02.onPreparePanel(0, e03.i, gVar)) {
            return;
        }
        g02.onMenuOpened(108, e03.j);
        this.p.e();
    }

    private int D0(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i2 != 9) {
            return i2;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private boolean F0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.j.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || c.f.l.s.N((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean H(boolean z) {
        if (this.Q) {
            return false;
        }
        int K = K();
        boolean K0 = K0(o0(this.i, K), z);
        if (K == 0) {
            d0(this.i).e();
        } else {
            l lVar = this.V;
            if (lVar != null) {
                lVar.a();
            }
        }
        if (K == 3) {
            c0(this.i).e();
        } else {
            l lVar2 = this.W;
            if (lVar2 != null) {
                lVar2.a();
            }
        }
        return K0;
    }

    private void I() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.z.findViewById(R.id.content);
        View decorView = this.j.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.i.obtainStyledAttributes(c.a.j.AppCompatTheme);
        obtainStyledAttributes.getValue(c.a.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(c.a.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(c.a.j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(c.a.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(c.a.j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(c.a.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(c.a.j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(c.a.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(c.a.j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(c.a.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void I0() {
        if (this.y) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void J(Window window) {
        if (this.j != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof j) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        j jVar = new j(callback);
        this.k = jVar;
        window.setCallback(jVar);
        w0 u = w0.u(this.i, null, g0);
        Drawable h2 = u.h(0);
        if (h2 != null) {
            window.setBackgroundDrawable(h2);
        }
        u.w();
        this.j = window;
    }

    private androidx.appcompat.app.c J0() {
        for (Context context = this.i; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof androidx.appcompat.app.c) {
                return (androidx.appcompat.app.c) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private int K() {
        int i2 = this.R;
        return i2 != -100 ? i2 : androidx.appcompat.app.e.j();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean K0(int r7, boolean r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.i
            r1 = 0
            android.content.res.Configuration r0 = r6.Q(r0, r7, r1)
            boolean r2 = r6.m0()
            android.content.Context r3 = r6.i
            android.content.res.Resources r3 = r3.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.uiMode
            r3 = r3 & 48
            int r0 = r0.uiMode
            r0 = r0 & 48
            r4 = 1
            if (r3 == r0) goto L47
            if (r8 == 0) goto L47
            if (r2 != 0) goto L47
            boolean r8 = r6.N
            if (r8 == 0) goto L47
            boolean r8 = androidx.appcompat.app.f.h0
            if (r8 != 0) goto L30
            boolean r8 = r6.O
            if (r8 == 0) goto L47
        L30:
            java.lang.Object r8 = r6.h
            boolean r5 = r8 instanceof android.app.Activity
            if (r5 == 0) goto L47
            android.app.Activity r8 = (android.app.Activity) r8
            boolean r8 = r8.isChild()
            if (r8 != 0) goto L47
            java.lang.Object r8 = r6.h
            android.app.Activity r8 = (android.app.Activity) r8
            androidx.core.app.a.g(r8)
            r8 = 1
            goto L48
        L47:
            r8 = 0
        L48:
            if (r8 != 0) goto L50
            if (r3 == r0) goto L50
            r6.L0(r0, r2, r1)
            goto L51
        L50:
            r4 = r8
        L51:
            if (r4 == 0) goto L5e
            java.lang.Object r8 = r6.h
            boolean r0 = r8 instanceof androidx.appcompat.app.c
            if (r0 == 0) goto L5e
            androidx.appcompat.app.c r8 = (androidx.appcompat.app.c) r8
            r8.y(r7)
        L5e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.K0(int, boolean):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void L0(int i2, boolean z, Configuration configuration) {
        Resources resources = this.i.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        if (Build.VERSION.SDK_INT < 26) {
            androidx.appcompat.app.i.a(resources);
        }
        int i3 = this.S;
        if (i3 != 0) {
            this.i.setTheme(i3);
            if (Build.VERSION.SDK_INT >= 23) {
                this.i.getTheme().applyStyle(this.S, true);
            }
        }
        if (z) {
            Object obj = this.h;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.g) {
                    if (!((androidx.lifecycle.g) activity).a().b().isAtLeast(d.b.STARTED)) {
                        return;
                    }
                } else if (!this.P) {
                    return;
                }
                activity.onConfigurationChanged(configuration2);
            }
        }
    }

    private void N() {
        l lVar = this.V;
        if (lVar != null) {
            lVar.a();
        }
        l lVar2 = this.W;
        if (lVar2 != null) {
            lVar2.a();
        }
    }

    private void N0(View view) {
        Context context;
        int i2;
        if ((c.f.l.s.H(view) & 8192) != 0) {
            context = this.i;
            i2 = c.a.c.abc_decor_view_status_guard_light;
        } else {
            context = this.i;
            i2 = c.a.c.abc_decor_view_status_guard;
        }
        view.setBackgroundColor(c.f.d.a.a(context, i2));
    }

    private Configuration Q(Context context, int i2, Configuration configuration) {
        int i3 = i2 != 1 ? i2 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    private ViewGroup R() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.i.obtainStyledAttributes(c.a.j.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(c.a.j.AppCompatTheme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(c.a.j.AppCompatTheme_windowNoTitle, false)) {
            z(1);
        } else if (obtainStyledAttributes.getBoolean(c.a.j.AppCompatTheme_windowActionBar, false)) {
            z(108);
        }
        if (obtainStyledAttributes.getBoolean(c.a.j.AppCompatTheme_windowActionBarOverlay, false)) {
            z(109);
        }
        if (obtainStyledAttributes.getBoolean(c.a.j.AppCompatTheme_windowActionModeOverlay, false)) {
            z(10);
        }
        this.H = obtainStyledAttributes.getBoolean(c.a.j.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        Y();
        this.j.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.i);
        if (this.I) {
            viewGroup = (ViewGroup) from.inflate(this.G ? c.a.g.abc_screen_simple_overlay_action_mode : c.a.g.abc_screen_simple, (ViewGroup) null);
        } else if (this.H) {
            viewGroup = (ViewGroup) from.inflate(c.a.g.abc_dialog_title_material, (ViewGroup) null);
            this.F = false;
            this.E = false;
        } else if (this.E) {
            TypedValue typedValue = new TypedValue();
            this.i.getTheme().resolveAttribute(c.a.a.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new c.a.n.d(this.i, typedValue.resourceId) : this.i).inflate(c.a.g.abc_screen_toolbar, (ViewGroup) null);
            c0 c0Var = (c0) viewGroup.findViewById(c.a.f.decor_content_parent);
            this.p = c0Var;
            c0Var.setWindowCallback(g0());
            if (this.F) {
                this.p.k(109);
            }
            if (this.C) {
                this.p.k(2);
            }
            if (this.D) {
                this.p.k(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.E + ", windowActionBarOverlay: " + this.F + ", android:windowIsFloating: " + this.H + ", windowActionModeOverlay: " + this.G + ", windowNoTitle: " + this.I + " }");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            c.f.l.s.u0(viewGroup, new c());
        } else if (viewGroup instanceof g0) {
            ((g0) viewGroup).setOnFitSystemWindowsListener(new d());
        }
        if (this.p == null) {
            this.A = (TextView) viewGroup.findViewById(c.a.f.title);
        }
        c1.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(c.a.f.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.j.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.j.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new e());
        return viewGroup;
    }

    private void X() {
        if (this.y) {
            return;
        }
        this.z = R();
        CharSequence f02 = f0();
        if (!TextUtils.isEmpty(f02)) {
            c0 c0Var = this.p;
            if (c0Var != null) {
                c0Var.setWindowTitle(f02);
            } else if (z0() != null) {
                z0().v(f02);
            } else {
                TextView textView = this.A;
                if (textView != null) {
                    textView.setText(f02);
                }
            }
        }
        I();
        x0(this.z);
        this.y = true;
        s e02 = e0(0, false);
        if (this.Q) {
            return;
        }
        if (e02 == null || e02.j == null) {
            l0(108);
        }
    }

    private void Y() {
        if (this.j == null) {
            Object obj = this.h;
            if (obj instanceof Activity) {
                J(((Activity) obj).getWindow());
            }
        }
        if (this.j == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration a0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f = configuration.fontScale;
            float f2 = configuration2.fontScale;
            if (f != f2) {
                configuration3.fontScale = f2;
            }
            int i2 = configuration.mcc;
            int i3 = configuration2.mcc;
            if (i2 != i3) {
                configuration3.mcc = i3;
            }
            int i4 = configuration.mnc;
            int i5 = configuration2.mnc;
            if (i4 != i5) {
                configuration3.mnc = i5;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                o.a(configuration, configuration2, configuration3);
            } else if (!c.f.k.c.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i6 = configuration.touchscreen;
            int i7 = configuration2.touchscreen;
            if (i6 != i7) {
                configuration3.touchscreen = i7;
            }
            int i8 = configuration.keyboard;
            int i9 = configuration2.keyboard;
            if (i8 != i9) {
                configuration3.keyboard = i9;
            }
            int i10 = configuration.keyboardHidden;
            int i11 = configuration2.keyboardHidden;
            if (i10 != i11) {
                configuration3.keyboardHidden = i11;
            }
            int i12 = configuration.navigation;
            int i13 = configuration2.navigation;
            if (i12 != i13) {
                configuration3.navigation = i13;
            }
            int i14 = configuration.navigationHidden;
            int i15 = configuration2.navigationHidden;
            if (i14 != i15) {
                configuration3.navigationHidden = i15;
            }
            int i16 = configuration.orientation;
            int i17 = configuration2.orientation;
            if (i16 != i17) {
                configuration3.orientation = i17;
            }
            int i18 = configuration.screenLayout & 15;
            int i19 = configuration2.screenLayout;
            if (i18 != (i19 & 15)) {
                configuration3.screenLayout |= i19 & 15;
            }
            int i20 = configuration.screenLayout & 192;
            int i21 = configuration2.screenLayout;
            if (i20 != (i21 & 192)) {
                configuration3.screenLayout |= i21 & 192;
            }
            int i22 = configuration.screenLayout & 48;
            int i23 = configuration2.screenLayout;
            if (i22 != (i23 & 48)) {
                configuration3.screenLayout |= i23 & 48;
            }
            int i24 = configuration.screenLayout & 768;
            int i25 = configuration2.screenLayout;
            if (i24 != (i25 & 768)) {
                configuration3.screenLayout |= i25 & 768;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                p.a(configuration, configuration2, configuration3);
            }
            int i26 = configuration.uiMode & 15;
            int i27 = configuration2.uiMode;
            if (i26 != (i27 & 15)) {
                configuration3.uiMode |= i27 & 15;
            }
            int i28 = configuration.uiMode & 48;
            int i29 = configuration2.uiMode;
            if (i28 != (i29 & 48)) {
                configuration3.uiMode |= i29 & 48;
            }
            int i30 = configuration.screenWidthDp;
            int i31 = configuration2.screenWidthDp;
            if (i30 != i31) {
                configuration3.screenWidthDp = i31;
            }
            int i32 = configuration.screenHeightDp;
            int i33 = configuration2.screenHeightDp;
            if (i32 != i33) {
                configuration3.screenHeightDp = i33;
            }
            int i34 = configuration.smallestScreenWidthDp;
            int i35 = configuration2.smallestScreenWidthDp;
            if (i34 != i35) {
                configuration3.smallestScreenWidthDp = i35;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                n.a(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    private l c0(Context context) {
        if (this.W == null) {
            this.W = new k(context);
        }
        return this.W;
    }

    private l d0(Context context) {
        if (this.V == null) {
            this.V = new m(androidx.appcompat.app.l.a(context));
        }
        return this.V;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void h0() {
        /*
            r3 = this;
            r3.X()
            boolean r0 = r3.E
            if (r0 == 0) goto L37
            androidx.appcompat.app.a r0 = r3.m
            if (r0 == 0) goto Lc
            goto L37
        Lc:
            java.lang.Object r0 = r3.h
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L20
            androidx.appcompat.app.m r0 = new androidx.appcompat.app.m
            java.lang.Object r1 = r3.h
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r2 = r3.F
            r0.<init>(r1, r2)
        L1d:
            r3.m = r0
            goto L2e
        L20:
            boolean r0 = r0 instanceof android.app.Dialog
            if (r0 == 0) goto L2e
            androidx.appcompat.app.m r0 = new androidx.appcompat.app.m
            java.lang.Object r1 = r3.h
            android.app.Dialog r1 = (android.app.Dialog) r1
            r0.<init>(r1)
            goto L1d
        L2e:
            androidx.appcompat.app.a r0 = r3.m
            if (r0 == 0) goto L37
            boolean r1 = r3.a0
            r0.r(r1)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.h0():void");
    }

    private boolean i0(s sVar) {
        View view = sVar.i;
        if (view != null) {
            sVar.h = view;
            return true;
        }
        if (sVar.j == null) {
            return false;
        }
        if (this.r == null) {
            this.r = new t();
        }
        View view2 = (View) sVar.a(this.r);
        sVar.h = view2;
        return view2 != null;
    }

    private boolean j0(s sVar) {
        sVar.d(b0());
        sVar.g = new r(sVar.l);
        sVar.f68c = 81;
        return true;
    }

    private boolean k0(s sVar) {
        Context context = this.i;
        int i2 = sVar.a;
        if ((i2 == 0 || i2 == 108) && this.p != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(c.a.a.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(c.a.a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(c.a.a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                c.a.n.d dVar = new c.a.n.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.R(this);
        sVar.c(gVar);
        return true;
    }

    private void l0(int i2) {
        this.Y = (1 << i2) | this.Y;
        if (this.X) {
            return;
        }
        c.f.l.s.a0(this.j.getDecorView(), this.Z);
        this.X = true;
    }

    private boolean m0() {
        if (!this.U && (this.h instanceof Activity)) {
            PackageManager packageManager = this.i.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.i, this.h.getClass()), Build.VERSION.SDK_INT >= 29 ? 269221888 : Build.VERSION.SDK_INT >= 24 ? 786432 : 0);
                this.T = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.T = false;
            }
        }
        this.U = true;
        return this.T;
    }

    private boolean r0(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        s e02 = e0(i2, true);
        if (e02.o) {
            return false;
        }
        return B0(e02, keyEvent);
    }

    private boolean u0(int i2, KeyEvent keyEvent) {
        boolean z;
        c0 c0Var;
        if (this.s != null) {
            return false;
        }
        boolean z2 = true;
        s e02 = e0(i2, true);
        if (i2 != 0 || (c0Var = this.p) == null || !c0Var.g() || ViewConfiguration.get(this.i).hasPermanentMenuKey()) {
            if (e02.o || e02.n) {
                boolean z3 = e02.o;
                P(e02, true);
                z2 = z3;
            } else {
                if (e02.m) {
                    if (e02.r) {
                        e02.m = false;
                        z = B0(e02, keyEvent);
                    } else {
                        z = true;
                    }
                    if (z) {
                        y0(e02, keyEvent);
                    }
                }
                z2 = false;
            }
        } else if (this.p.c()) {
            z2 = this.p.d();
        } else {
            if (!this.Q && B0(e02, keyEvent)) {
                z2 = this.p.e();
            }
            z2 = false;
        }
        if (z2) {
            AudioManager audioManager = (AudioManager) this.i.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z2;
    }

    private void y0(s sVar, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (sVar.o || this.Q) {
            return;
        }
        if (sVar.a == 0) {
            if ((this.i.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback g02 = g0();
        if (g02 != null && !g02.onMenuOpened(sVar.a, sVar.j)) {
            P(sVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.i.getSystemService("window");
        if (windowManager != null && B0(sVar, keyEvent)) {
            if (sVar.g == null || sVar.q) {
                ViewGroup viewGroup = sVar.g;
                if (viewGroup == null) {
                    if (!j0(sVar) || sVar.g == null) {
                        return;
                    }
                } else if (sVar.q && viewGroup.getChildCount() > 0) {
                    sVar.g.removeAllViews();
                }
                if (!i0(sVar) || !sVar.b()) {
                    sVar.q = true;
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = sVar.h.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                }
                sVar.g.setBackgroundResource(sVar.f67b);
                ViewParent parent = sVar.h.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(sVar.h);
                }
                sVar.g.addView(sVar.h, layoutParams2);
                if (!sVar.h.hasFocus()) {
                    sVar.h.requestFocus();
                }
            } else {
                View view = sVar.i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i2 = -1;
                    sVar.n = false;
                    WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, sVar.f69d, sVar.f70e, 1002, 8519680, -3);
                    layoutParams3.gravity = sVar.f68c;
                    layoutParams3.windowAnimations = sVar.f;
                    windowManager.addView(sVar.g, layoutParams3);
                    sVar.o = true;
                }
            }
            i2 = -2;
            sVar.n = false;
            WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, sVar.f69d, sVar.f70e, 1002, 8519680, -3);
            layoutParams32.gravity = sVar.f68c;
            layoutParams32.windowAnimations = sVar.f;
            windowManager.addView(sVar.g, layoutParams32);
            sVar.o = true;
        }
    }

    @Override // androidx.appcompat.app.e
    public void A(int i2) {
        X();
        ViewGroup viewGroup = (ViewGroup) this.z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.i).inflate(i2, viewGroup);
        this.k.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void B(View view) {
        X();
        ViewGroup viewGroup = (ViewGroup) this.z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.k.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void C(View view, ViewGroup.LayoutParams layoutParams) {
        X();
        ViewGroup viewGroup = (ViewGroup) this.z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.k.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void D(Toolbar toolbar) {
        Window window;
        Window.Callback callback;
        if (this.h instanceof Activity) {
            androidx.appcompat.app.a m2 = m();
            if (m2 instanceof androidx.appcompat.app.m) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.n = null;
            if (m2 != null) {
                m2.n();
            }
            if (toolbar != null) {
                androidx.appcompat.app.j jVar = new androidx.appcompat.app.j(toolbar, f0(), this.k);
                this.m = jVar;
                window = this.j;
                callback = jVar.y();
            } else {
                this.m = null;
                window = this.j;
                callback = this.k;
            }
            window.setCallback(callback);
            o();
        }
    }

    @Override // androidx.appcompat.app.e
    public void E(int i2) {
        this.S = i2;
    }

    final boolean E0() {
        ViewGroup viewGroup;
        return this.y && (viewGroup = this.z) != null && c.f.l.s.O(viewGroup);
    }

    @Override // androidx.appcompat.app.e
    public final void F(CharSequence charSequence) {
        this.o = charSequence;
        c0 c0Var = this.p;
        if (c0Var != null) {
            c0Var.setWindowTitle(charSequence);
            return;
        }
        if (z0() != null) {
            z0().v(charSequence);
            return;
        }
        TextView textView = this.A;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public boolean G() {
        return H(true);
    }

    public c.a.n.b G0(b.a aVar) {
        androidx.appcompat.app.d dVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        c.a.n.b bVar = this.s;
        if (bVar != null) {
            bVar.c();
        }
        i iVar = new i(aVar);
        androidx.appcompat.app.a m2 = m();
        if (m2 != null) {
            c.a.n.b w = m2.w(iVar);
            this.s = w;
            if (w != null && (dVar = this.l) != null) {
                dVar.g(w);
            }
        }
        if (this.s == null) {
            this.s = H0(iVar);
        }
        return this.s;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    c.a.n.b H0(c.a.n.b.a r8) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.H0(c.a.n.b$a):c.a.n.b");
    }

    void L(int i2, s sVar, Menu menu) {
        if (menu == null) {
            if (sVar == null && i2 >= 0) {
                s[] sVarArr = this.K;
                if (i2 < sVarArr.length) {
                    sVar = sVarArr[i2];
                }
            }
            if (sVar != null) {
                menu = sVar.j;
            }
        }
        if ((sVar == null || sVar.o) && !this.Q) {
            this.k.a().onPanelClosed(i2, menu);
        }
    }

    void M(androidx.appcompat.view.menu.g gVar) {
        if (this.J) {
            return;
        }
        this.J = true;
        this.p.l();
        Window.Callback g02 = g0();
        if (g02 != null && !this.Q) {
            g02.onPanelClosed(108, gVar);
        }
        this.J = false;
    }

    final int M0(a0 a0Var, Rect rect) {
        boolean z;
        boolean z2;
        int h2 = a0Var != null ? a0Var.h() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.t;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.t.getLayoutParams();
            if (this.t.isShown()) {
                if (this.b0 == null) {
                    this.b0 = new Rect();
                    this.c0 = new Rect();
                }
                Rect rect2 = this.b0;
                Rect rect3 = this.c0;
                if (a0Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(a0Var.f(), a0Var.h(), a0Var.g(), a0Var.e());
                }
                c1.a(this.z, rect2, rect3);
                int i2 = rect2.top;
                int i3 = rect2.left;
                int i4 = rect2.right;
                a0 F = c.f.l.s.F(this.z);
                int f = F == null ? 0 : F.f();
                int g2 = F == null ? 0 : F.g();
                if (marginLayoutParams.topMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i2;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i4;
                    z2 = true;
                }
                if (i2 <= 0 || this.B != null) {
                    View view = this.B;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        if (marginLayoutParams2.height != marginLayoutParams.topMargin || marginLayoutParams2.leftMargin != f || marginLayoutParams2.rightMargin != g2) {
                            marginLayoutParams2.height = marginLayoutParams.topMargin;
                            marginLayoutParams2.leftMargin = f;
                            marginLayoutParams2.rightMargin = g2;
                            this.B.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.i);
                    this.B = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = f;
                    layoutParams.rightMargin = g2;
                    this.z.addView(this.B, -1, layoutParams);
                }
                r5 = this.B != null;
                if (r5 && this.B.getVisibility() != 0) {
                    N0(this.B);
                }
                if (!this.G && r5) {
                    h2 = 0;
                }
                z = r5;
                r5 = z2;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                r5 = false;
            }
            if (r5) {
                this.t.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.B;
        if (view3 != null) {
            view3.setVisibility(z ? 0 : 8);
        }
        return h2;
    }

    void O(int i2) {
        P(e0(i2, true), true);
    }

    void P(s sVar, boolean z) {
        ViewGroup viewGroup;
        c0 c0Var;
        if (z && sVar.a == 0 && (c0Var = this.p) != null && c0Var.c()) {
            M(sVar.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.i.getSystemService("window");
        if (windowManager != null && sVar.o && (viewGroup = sVar.g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                L(sVar.a, sVar, null);
            }
        }
        sVar.m = false;
        sVar.n = false;
        sVar.o = false;
        sVar.h = null;
        sVar.q = true;
        if (this.L == sVar) {
            this.L = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View S(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        androidx.appcompat.app.h hVar;
        boolean z2 = false;
        if (this.d0 == null) {
            String string = this.i.obtainStyledAttributes(c.a.j.AppCompatTheme).getString(c.a.j.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                hVar = new androidx.appcompat.app.h();
            } else {
                try {
                    this.d0 = (androidx.appcompat.app.h) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    hVar = new androidx.appcompat.app.h();
                }
            }
            this.d0 = hVar;
        }
        if (f0) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z2 = F0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z2 = true;
            }
            z = z2;
        } else {
            z = false;
        }
        return this.d0.q(view, str, context, attributeSet, z, f0, true, b1.b());
    }

    void T() {
        androidx.appcompat.view.menu.g gVar;
        c0 c0Var = this.p;
        if (c0Var != null) {
            c0Var.l();
        }
        if (this.u != null) {
            this.j.getDecorView().removeCallbacks(this.v);
            if (this.u.isShowing()) {
                try {
                    this.u.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.u = null;
        }
        W();
        s e02 = e0(0, false);
        if (e02 == null || (gVar = e02.j) == null) {
            return;
        }
        gVar.close();
    }

    boolean U(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.h;
        if (((obj instanceof e.a) || (obj instanceof androidx.appcompat.app.g)) && (decorView = this.j.getDecorView()) != null && c.f.l.e.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.k.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? q0(keyCode, keyEvent) : t0(keyCode, keyEvent);
    }

    void V(int i2) {
        s e02;
        s e03 = e0(i2, true);
        if (e03.j != null) {
            Bundle bundle = new Bundle();
            e03.j.Q(bundle);
            if (bundle.size() > 0) {
                e03.s = bundle;
            }
            e03.j.d0();
            e03.j.clear();
        }
        e03.r = true;
        e03.q = true;
        if ((i2 != 108 && i2 != 0) || this.p == null || (e02 = e0(0, false)) == null) {
            return;
        }
        e02.m = false;
        B0(e02, null);
    }

    void W() {
        w wVar = this.w;
        if (wVar != null) {
            wVar.b();
        }
    }

    s Z(Menu menu) {
        s[] sVarArr = this.K;
        int length = sVarArr != null ? sVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            s sVar = sVarArr[i2];
            if (sVar != null && sVar.j == menu) {
                return sVar;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        s Z;
        Window.Callback g02 = g0();
        if (g02 == null || this.Q || (Z = Z(gVar.D())) == null) {
            return false;
        }
        return g02.onMenuItemSelected(Z.a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void b(androidx.appcompat.view.menu.g gVar) {
        C0(true);
    }

    final Context b0() {
        androidx.appcompat.app.a m2 = m();
        Context k2 = m2 != null ? m2.k() : null;
        return k2 == null ? this.i : k2;
    }

    @Override // androidx.appcompat.app.e
    public void d(View view, ViewGroup.LayoutParams layoutParams) {
        X();
        ((ViewGroup) this.z.findViewById(R.id.content)).addView(view, layoutParams);
        this.k.a().onContentChanged();
    }

    protected s e0(int i2, boolean z) {
        s[] sVarArr = this.K;
        if (sVarArr == null || sVarArr.length <= i2) {
            s[] sVarArr2 = new s[i2 + 1];
            if (sVarArr != null) {
                System.arraycopy(sVarArr, 0, sVarArr2, 0, sVarArr.length);
            }
            this.K = sVarArr2;
            sVarArr = sVarArr2;
        }
        s sVar = sVarArr[i2];
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(i2);
        sVarArr[i2] = sVar2;
        return sVar2;
    }

    @Override // androidx.appcompat.app.e
    public Context f(Context context) {
        this.N = true;
        int o0 = o0(context, K());
        if (i0 && (context instanceof ContextThemeWrapper)) {
            try {
                q.a((ContextThemeWrapper) context, Q(context, o0, null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof c.a.n.d) {
            try {
                ((c.a.n.d) context).a(Q(context, o0, null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!h0) {
            super.f(context);
            return context;
        }
        try {
            Configuration configuration = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
            Configuration configuration2 = context.getResources().getConfiguration();
            Configuration Q = Q(context, o0, configuration.equals(configuration2) ? null : a0(configuration, configuration2));
            c.a.n.d dVar = new c.a.n.d(context, c.a.i.Theme_AppCompat_Empty);
            dVar.a(Q);
            boolean z = false;
            try {
                z = context.getTheme() != null;
            } catch (NullPointerException unused3) {
            }
            if (z) {
                f.b.a(dVar.getTheme());
            }
            super.f(dVar);
            return dVar;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Application failed to obtain resources from itself", e2);
        }
    }

    final CharSequence f0() {
        Object obj = this.h;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.o;
    }

    final Window.Callback g0() {
        return this.j.getCallback();
    }

    @Override // androidx.appcompat.app.e
    public <T extends View> T i(int i2) {
        X();
        return (T) this.j.findViewById(i2);
    }

    @Override // androidx.appcompat.app.e
    public int k() {
        return this.R;
    }

    @Override // androidx.appcompat.app.e
    public MenuInflater l() {
        if (this.n == null) {
            h0();
            androidx.appcompat.app.a aVar = this.m;
            this.n = new c.a.n.g(aVar != null ? aVar.k() : this.i);
        }
        return this.n;
    }

    @Override // androidx.appcompat.app.e
    public androidx.appcompat.app.a m() {
        h0();
        return this.m;
    }

    @Override // androidx.appcompat.app.e
    public void n() {
        LayoutInflater from = LayoutInflater.from(this.i);
        if (from.getFactory() == null) {
            c.f.l.f.b(from, this);
        } else {
            if (from.getFactory2() instanceof f) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public boolean n0() {
        return this.x;
    }

    @Override // androidx.appcompat.app.e
    public void o() {
        androidx.appcompat.app.a m2 = m();
        if (m2 == null || !m2.l()) {
            l0(0);
        }
    }

    int o0(Context context, int i2) {
        l d0;
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                    d0 = c0(context);
                }
            } else {
                if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() == 0) {
                    return -1;
                }
                d0 = d0(context);
            }
            return d0.c();
        }
        return i2;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return S(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.e
    public void p(Configuration configuration) {
        androidx.appcompat.app.a m2;
        if (this.E && this.y && (m2 = m()) != null) {
            m2.m(configuration);
        }
        androidx.appcompat.widget.j.b().g(this.i);
        H(false);
    }

    boolean p0() {
        c.a.n.b bVar = this.s;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        androidx.appcompat.app.a m2 = m();
        return m2 != null && m2.h();
    }

    @Override // androidx.appcompat.app.e
    public void q(Bundle bundle) {
        this.N = true;
        H(false);
        Y();
        Object obj = this.h;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.f.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                androidx.appcompat.app.a z0 = z0();
                if (z0 == null) {
                    this.a0 = true;
                } else {
                    z0.r(true);
                }
            }
            androidx.appcompat.app.e.c(this);
        }
        this.O = true;
    }

    boolean q0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.M = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            r0(0, keyEvent);
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    @Override // androidx.appcompat.app.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void r() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.h
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            androidx.appcompat.app.e.x(r3)
        L9:
            boolean r0 = r3.X
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.j
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.Z
            r0.removeCallbacks(r1)
        L18:
            r0 = 0
            r3.P = r0
            r0 = 1
            r3.Q = r0
            int r0 = r3.R
            r1 = -100
            if (r0 == r1) goto L48
            java.lang.Object r0 = r3.h
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L48
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L48
            c.d.g<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.f.e0
            java.lang.Object r1 = r3.h
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.R
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L57
        L48:
            c.d.g<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.f.e0
            java.lang.Object r1 = r3.h
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L57:
            androidx.appcompat.app.a r0 = r3.m
            if (r0 == 0) goto L5e
            r0.n()
        L5e:
            r3.N()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.r():void");
    }

    @Override // androidx.appcompat.app.e
    public void s(Bundle bundle) {
        X();
    }

    boolean s0(int i2, KeyEvent keyEvent) {
        androidx.appcompat.app.a m2 = m();
        if (m2 != null && m2.o(i2, keyEvent)) {
            return true;
        }
        s sVar = this.L;
        if (sVar != null && A0(sVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            s sVar2 = this.L;
            if (sVar2 != null) {
                sVar2.n = true;
            }
            return true;
        }
        if (this.L == null) {
            s e02 = e0(0, true);
            B0(e02, keyEvent);
            boolean A0 = A0(e02, keyEvent.getKeyCode(), keyEvent, 1);
            e02.m = false;
            if (A0) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void t() {
        androidx.appcompat.app.a m2 = m();
        if (m2 != null) {
            m2.u(true);
        }
    }

    boolean t0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z = this.M;
            this.M = false;
            s e02 = e0(0, false);
            if (e02 != null && e02.o) {
                if (!z) {
                    P(e02, true);
                }
                return true;
            }
            if (p0()) {
                return true;
            }
        } else if (i2 == 82) {
            u0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void u(Bundle bundle) {
    }

    @Override // androidx.appcompat.app.e
    public void v() {
        this.P = true;
        G();
    }

    void v0(int i2) {
        androidx.appcompat.app.a m2;
        if (i2 != 108 || (m2 = m()) == null) {
            return;
        }
        m2.i(true);
    }

    @Override // androidx.appcompat.app.e
    public void w() {
        this.P = false;
        androidx.appcompat.app.a m2 = m();
        if (m2 != null) {
            m2.u(false);
        }
    }

    void w0(int i2) {
        if (i2 == 108) {
            androidx.appcompat.app.a m2 = m();
            if (m2 != null) {
                m2.i(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            s e02 = e0(i2, true);
            if (e02.o) {
                P(e02, false);
            }
        }
    }

    void x0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.e
    public boolean z(int i2) {
        int D0 = D0(i2);
        if (this.I && D0 == 108) {
            return false;
        }
        if (this.E && D0 == 1) {
            this.E = false;
        }
        if (D0 == 1) {
            I0();
            this.I = true;
            return true;
        }
        if (D0 == 2) {
            I0();
            this.C = true;
            return true;
        }
        if (D0 == 5) {
            I0();
            this.D = true;
            return true;
        }
        if (D0 == 10) {
            I0();
            this.G = true;
            return true;
        }
        if (D0 == 108) {
            I0();
            this.E = true;
            return true;
        }
        if (D0 != 109) {
            return this.j.requestFeature(D0);
        }
        I0();
        this.F = true;
        return true;
    }

    final androidx.appcompat.app.a z0() {
        return this.m;
    }
}
