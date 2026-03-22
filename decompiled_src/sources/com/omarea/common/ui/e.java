package com.omarea.common.ui;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class e {
    private static boolean a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f1255b = new a(null);

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: com.omarea.common.ui.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class ViewOnClickListenerC0082a implements View.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f1256e;
            final /* synthetic */ c f;

            ViewOnClickListenerC0082a(b bVar, c cVar) {
                this.f1256e = bVar;
                this.f = cVar;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b bVar = this.f1256e;
                if (bVar == null) {
                    this.f.a();
                    return;
                }
                if (bVar.a()) {
                    this.f.a();
                }
                Runnable b2 = this.f1256e.b();
                if (b2 != null) {
                    b2.run();
                }
            }
        }

        /* loaded from: classes.dex */
        static final class b implements View.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f1257e;
            final /* synthetic */ c f;

            b(b bVar, c cVar) {
                this.f1257e = bVar;
                this.f = cVar;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b bVar = this.f1257e;
                if (bVar == null) {
                    this.f.a();
                    return;
                }
                if (bVar.a()) {
                    this.f.a();
                }
                Runnable b2 = this.f1257e.b();
                if (b2 != null) {
                    b2.run();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class c implements DialogInterface.OnDismissListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Runnable f1258e;

            c(Runnable runnable, c cVar) {
                this.f1258e = runnable;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f1258e.run();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class d implements View.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ c f1259e;

            d(Runnable runnable, c cVar) {
                this.f1259e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1259e.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.omarea.common.ui.e$a$e, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class ViewOnClickListenerC0083e implements View.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ c f1260e;
            final /* synthetic */ Runnable f;

            ViewOnClickListenerC0083e(c cVar, Runnable runnable) {
                this.f1260e = cVar;
                this.f = runnable;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1260e.a();
                Runnable runnable = this.f;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class f implements View.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ c f1261e;
            final /* synthetic */ Runnable f;

            f(c cVar, Runnable runnable) {
                this.f1261e = cVar;
                this.f = runnable;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1261e.a();
                Runnable runnable = this.f;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class g implements View.OnTouchListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ View f1262e;
            final /* synthetic */ c f;

            g(View view, c cVar) {
                this.f1262e = view;
                this.f = cVar;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent == null || motionEvent.getAction() != 1) {
                    return false;
                }
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                Rect rect = new Rect();
                this.f1262e.getGlobalVisibleRect(rect);
                if (!rect.contains(x, y) && this.f.d()) {
                    this.f.a();
                }
                return true;
            }
        }

        private a() {
        }

        public /* synthetic */ a(e.p.d.e eVar) {
            this();
        }

        public static /* synthetic */ c b(a aVar, Context context, String str, String str2, Runnable runnable, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "";
            }
            if ((i & 4) != 0) {
                str2 = "";
            }
            if ((i & 8) != 0) {
                runnable = null;
            }
            return aVar.a(context, str, str2, runnable);
        }

        public static /* synthetic */ c i(a aVar, Context context, View view, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            return aVar.h(context, view, z);
        }

        private final View j(Context context, int i, String str, String str2, View view) {
            FrameLayout frameLayout;
            View inflate = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.c.a.a.confirm_title);
            if (textView != null) {
                if (str.length() == 0) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(str);
                }
            }
            TextView textView2 = (TextView) inflate.findViewById(d.c.a.a.confirm_message);
            if (textView2 != null) {
                if (str2.length() == 0) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(str2);
                }
            }
            if (view != null && (frameLayout = (FrameLayout) inflate.findViewById(d.c.a.a.confirm_custom_view)) != null) {
                frameLayout.addView(view);
            }
            e.p.d.i.c(inflate, "view");
            return inflate;
        }

        private final int l(Context context, int i) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.background});
            int color = obtainStyledAttributes.getColor(0, i);
            obtainStyledAttributes.recycle();
            return color;
        }

        static /* synthetic */ int m(a aVar, Context context, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return aVar.l(context, i);
        }

        public static /* synthetic */ c o(a aVar, Context context, String str, String str2, Runnable runnable, int i, Object obj) {
            if ((i & 8) != 0) {
                runnable = null;
            }
            return aVar.n(context, str, str2, runnable);
        }

        private final boolean p(Context context) {
            int j = androidx.appcompat.app.e.j();
            if (j == 2) {
                return true;
            }
            if (j != -1 && j != -100) {
                return false;
            }
            Object systemService = context.getSystemService("uimode");
            if (systemService != null) {
                return ((UiModeManager) systemService).getNightMode() == 2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.UiModeManager");
        }

        private final c q(Context context, int i, String str, String str2, Runnable runnable, Runnable runnable2) {
            View j = j(context, i, str, str2, null);
            c i2 = i(this, context, j, false, 4, null);
            View findViewById = j.findViewById(d.c.a.a.btn_cancel);
            if (findViewById != null) {
                findViewById.setOnClickListener(new ViewOnClickListenerC0083e(i2, runnable2));
            }
            View findViewById2 = j.findViewById(d.c.a.a.btn_confirm);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new f(i2, runnable));
            }
            return i2;
        }

        private final c r(View view, c cVar) {
            Window window = cVar.b().getWindow();
            View decorView = window != null ? window.getDecorView() : null;
            if (decorView != null) {
                decorView.setOnTouchListener(new g(view, cVar));
            }
            return cVar;
        }

        public final c a(Context context, String str, String str2, Runnable runnable) {
            e.p.d.i.d(context, "context");
            e.p.d.i.d(str, "title");
            e.p.d.i.d(str2, "message");
            return q(context, d.c.a.b.dialog_alert, str, str2, runnable, null);
        }

        public final c c(AlertDialog.Builder builder) {
            e.p.d.i.d(builder, "builder");
            AlertDialog create = builder.create();
            d(create);
            e.p.d.i.c(create, "dialog");
            return new c(create);
        }

        public final c d(AlertDialog alertDialog) {
            if (alertDialog != null && !alertDialog.isShowing()) {
                Window window = alertDialog.getWindow();
                if (window != null) {
                    window.setWindowAnimations(d.c.a.c.windowAnim);
                }
                alertDialog.show();
            }
            if (alertDialog != null) {
                return new c(alertDialog);
            }
            return null;
        }

        public final c e(Context context, String str, String str2, View view, b bVar, b bVar2) {
            e.p.d.i.d(context, "context");
            e.p.d.i.d(str, "title");
            e.p.d.i.d(str2, "message");
            View j = j(context, d.c.a.b.dialog_confirm, str, str2, view);
            c i = i(this, context, j, false, 4, null);
            TextView textView = (TextView) j.findViewById(d.c.a.a.btn_confirm);
            if (bVar != null && textView != null) {
                textView.setText(bVar.c());
            }
            if (textView != null) {
                textView.setOnClickListener(new ViewOnClickListenerC0082a(bVar, i));
            }
            TextView textView2 = (TextView) j.findViewById(d.c.a.a.btn_cancel);
            if (bVar2 != null && textView2 != null) {
                textView2.setText(bVar2.c());
            }
            textView2.setOnClickListener(new b(bVar2, i));
            return i;
        }

        public final c f(Context context, String str, String str2, Runnable runnable, Runnable runnable2) {
            e.p.d.i.d(context, "context");
            e.p.d.i.d(str, "title");
            e.p.d.i.d(str2, "message");
            return q(context, d.c.a.b.dialog_confirm, str, str2, runnable, runnable2);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.omarea.common.ui.e.c h(android.content.Context r5, android.view.View r6, boolean r7) {
            /*
                r4 = this;
                java.lang.String r0 = "context"
                e.p.d.i.d(r5, r0)
                java.lang.String r0 = "view"
                e.p.d.i.d(r6, r0)
                boolean r0 = r5 instanceof android.app.Activity
                java.lang.String r1 = "context.window"
                if (r0 == 0) goto L27
                r2 = r5
                android.app.Activity r2 = (android.app.Activity) r2
                android.view.Window r2 = r2.getWindow()
                e.p.d.i.c(r2, r1)
                android.view.WindowManager$LayoutParams r2 = r2.getAttributes()
                int r2 = r2.flags
                r3 = 1048576(0x100000, float:1.469368E-39)
                r2 = r2 & r3
                if (r2 != 0) goto L27
                r2 = 1
                goto L28
            L27:
                r2 = 0
            L28:
                if (r2 == 0) goto L32
                android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
                int r3 = d.c.a.c.custom_alert_dialog
                r2.<init>(r5, r3)
                goto L37
            L32:
                android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
                r2.<init>(r5)
            L37:
                android.app.AlertDialog$Builder r2 = r2.setView(r6)
                android.app.AlertDialog$Builder r2 = r2.setCancelable(r7)
                android.app.AlertDialog r2 = r2.create()
                java.lang.String r3 = "dialog"
                if (r0 == 0) goto L76
                r2.show()
                e.p.d.i.c(r2, r3)
                android.view.Window r0 = r2.getWindow()
                if (r0 == 0) goto L93
                com.omarea.common.ui.e$a r3 = com.omarea.common.ui.e.f1255b
                android.app.Activity r5 = (android.app.Activity) r5
                r3.s(r0, r5)
                android.view.View r0 = r0.getDecorView()
                android.view.Window r5 = r5.getWindow()
                e.p.d.i.c(r5, r1)
                android.view.View r5 = r5.getDecorView()
                java.lang.String r1 = "context.window.decorView"
                e.p.d.i.c(r5, r1)
                int r5 = r5.getSystemUiVisibility()
                r0.setSystemUiVisibility(r5)
                goto L93
            L76:
                e.p.d.i.c(r2, r3)
                android.view.Window r5 = r2.getWindow()
                if (r5 == 0) goto L84
                int r0 = d.c.a.c.windowAnim2
                r5.setWindowAnimations(r0)
            L84:
                r2.show()
                android.view.Window r5 = r2.getWindow()
                if (r5 == 0) goto L93
                r0 = 17170445(0x106000d, float:2.461195E-38)
                r5.setBackgroundDrawableResource(r0)
            L93:
                com.omarea.common.ui.e$c r5 = new com.omarea.common.ui.e$c
                r5.<init>(r2)
                r5.e(r7)
                r4.r(r6, r5)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.omarea.common.ui.e.a.h(android.content.Context, android.view.View, boolean):com.omarea.common.ui.e$c");
        }

        public final boolean k() {
            return e.a;
        }

        public final c n(Context context, String str, String str2, Runnable runnable) {
            e.p.d.i.d(context, "context");
            e.p.d.i.d(str, "title");
            e.p.d.i.d(str2, "message");
            View inflate = LayoutInflater.from(context).inflate(d.c.a.b.dialog_help_info, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.c.a.a.dialog_help_title);
            if (findViewById == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            TextView textView = (TextView) findViewById;
            if (str.length() > 0) {
                textView.setText(str);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            View findViewById2 = inflate.findViewById(d.c.a.a.dialog_help_info);
            if (findViewById2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            TextView textView2 = (TextView) findViewById2;
            if (str2.length() > 0) {
                textView2.setText(str2);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
            e.p.d.i.c(inflate, "dialog");
            c h = h(context, inflate, runnable == null);
            View findViewById3 = inflate.findViewById(d.c.a.a.btn_confirm);
            if (findViewById3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
            if (runnable != null) {
                h.f(new c(runnable, h));
            }
            findViewById3.setOnClickListener(new d(runnable, h));
            return h;
        }

        public final void s(Window window, Activity activity) {
            ColorDrawable colorDrawable;
            e.p.d.i.d(window, "window");
            e.p.d.i.d(activity, "activity");
            Window window2 = activity.getWindow();
            e.p.d.i.c(window2, "activity.window");
            boolean z = (window2.getAttributes().flags & 1048576) != 0;
            Bitmap c2 = (e.f1255b.k() || z) ? null : com.omarea.common.ui.g.c(activity);
            if (c2 != null) {
                window.setBackgroundDrawable(new BitmapDrawable(activity.getResources(), c2));
                return;
            }
            try {
                int m = m(e.f1255b, activity, 0, 2, null);
                if (m != 0) {
                    window.setBackgroundDrawable(new ColorDrawable(m));
                    return;
                }
                if (!z) {
                    a aVar = e.f1255b;
                    Context context = window.getContext();
                    e.p.d.i.c(context, "context");
                    if (!aVar.p(context)) {
                        colorDrawable = new ColorDrawable(Color.argb(255, 245, 245, 245));
                        window.setBackgroundDrawable(colorDrawable);
                    }
                }
                colorDrawable = new ColorDrawable(Color.argb(255, 18, 18, 18));
                window.setBackgroundDrawable(colorDrawable);
            } catch (Exception unused) {
                window.setBackgroundDrawable(new ColorDrawable(Color.argb(255, 245, 245, 245)));
            }
        }

        public final c t(Context context, String str, String str2, Runnable runnable, Runnable runnable2) {
            e.p.d.i.d(context, "context");
            e.p.d.i.d(str, "title");
            e.p.d.i.d(str2, "message");
            return q(context, d.c.a.b.dialog_warning, str, str2, runnable, runnable2);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private final String a;

        /* renamed from: b, reason: collision with root package name */
        private final Runnable f1263b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f1264c;

        public b(String str, Runnable runnable, boolean z) {
            e.p.d.i.d(str, "text");
            this.a = str;
            this.f1263b = runnable;
            this.f1264c = z;
        }

        public /* synthetic */ b(String str, Runnable runnable, boolean z, int i, e.p.d.e eVar) {
            this(str, (i & 2) != 0 ? null : runnable, (i & 4) != 0 ? true : z);
        }

        public final boolean a() {
            return this.f1264c;
        }

        public final Runnable b() {
            return this.f1263b;
        }

        public final String c() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        private boolean a;

        /* renamed from: b, reason: collision with root package name */
        private final AlertDialog f1265b;

        public c(AlertDialog alertDialog) {
            e.p.d.i.d(alertDialog, "d");
            this.f1265b = alertDialog;
            b().getContext();
            this.a = true;
        }

        public final void a() {
            try {
                this.f1265b.dismiss();
            } catch (Exception unused) {
            }
        }

        public final AlertDialog b() {
            return this.f1265b;
        }

        public final void c() {
            try {
                this.f1265b.hide();
            } catch (Exception unused) {
            }
        }

        public final boolean d() {
            return this.a;
        }

        public final c e(boolean z) {
            this.a = z;
            this.f1265b.setCancelable(z);
            return this;
        }

        public final c f(DialogInterface.OnDismissListener onDismissListener) {
            e.p.d.i.d(onDismissListener, "onDismissListener");
            this.f1265b.setOnDismissListener(onDismissListener);
            return this;
        }
    }
}
