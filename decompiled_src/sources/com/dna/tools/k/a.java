package com.dna.tools.k;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.dna.tools.R;
import com.omarea.common.ui.e;
import e.p.d.e;
import e.p.d.i;
import e.p.d.l;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    private static boolean f1000e;
    public static final C0057a f = new C0057a(null);
    private Handler a;

    /* renamed from: b, reason: collision with root package name */
    private Thread f1001b;

    /* renamed from: c, reason: collision with root package name */
    private Context f1002c;

    /* renamed from: d, reason: collision with root package name */
    private Runnable f1003d;

    /* renamed from: com.dna.tools.k.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0057a {
        private C0057a() {
        }

        public /* synthetic */ C0057a(e eVar) {
            this();
        }

        public final boolean a() {
            return a.f1000e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b implements Runnable {
        final /* synthetic */ l f;

        /* renamed from: com.dna.tools.k.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class RunnableC0058a implements Runnable {

            /* renamed from: com.dna.tools.k.a$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            static final class DialogInterfaceOnClickListenerC0059a implements DialogInterface.OnClickListener {
                DialogInterfaceOnClickListenerC0059a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (a.this.f1003d != null) {
                        a.this.f().post(a.this.f1003d);
                    }
                }
            }

            /* renamed from: com.dna.tools.k.a$b$a$b, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            static final class DialogInterfaceOnClickListenerC0060b implements DialogInterface.OnClickListener {
                DialogInterfaceOnClickListenerC0060b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    d.c.a.g.b.f1379c.d();
                    if (a.this.g() != null) {
                        Thread g = a.this.g();
                        i.b(g);
                        if (g.isAlive()) {
                            Thread g2 = a.this.g();
                            i.b(g2);
                            if (!g2.isInterrupted()) {
                                Thread g3 = a.this.g();
                                i.b(g3);
                                g3.interrupt();
                                a.this.h(null);
                            }
                        }
                    }
                    a.this.d();
                }
            }

            /* renamed from: com.dna.tools.k.a$b$a$c */
            /* loaded from: classes.dex */
            static final class c implements DialogInterface.OnClickListener {

                /* renamed from: e, reason: collision with root package name */
                public static final c f1008e = new c();

                c() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    System.exit(0);
                    throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
                }
            }

            RunnableC0058a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                d.c.a.g.b.f1379c.d();
                AlertDialog.Builder negativeButton = new AlertDialog.Builder(a.this.e()).setTitle(R.string.error_root).setPositiveButton(R.string.btn_retry, new DialogInterfaceOnClickListenerC0060b()).setNegativeButton(R.string.btn_exit, c.f1008e);
                if (!a.this.e().getResources().getBoolean(R.bool.force_root)) {
                    negativeButton.setNeutralButton(R.string.btn_skip, new DialogInterfaceOnClickListenerC0059a());
                }
                e.a aVar = com.omarea.common.ui.e.f1255b;
                i.c(negativeButton, "builder");
                aVar.c(negativeButton).e(false);
            }
        }

        b(l lVar) {
            this.f = lVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Handler f;
            Runnable runnableC0058a;
            a.f1000e = d.c.a.g.b.f1379c.a();
            l lVar = this.f;
            if (lVar.element) {
                return;
            }
            lVar.element = true;
            if (!a.f.a()) {
                f = a.this.f();
                runnableC0058a = new RunnableC0058a();
            } else {
                if (a.this.f1003d == null) {
                    return;
                }
                f = a.this.f();
                runnableC0058a = a.this.f1003d;
            }
            f.post(runnableC0058a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c implements Runnable {
        final /* synthetic */ l f;

        /* renamed from: com.dna.tools.k.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class RunnableC0061a implements Runnable {

            /* renamed from: com.dna.tools.k.a$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            static final class RunnableC0062a implements Runnable {
                RunnableC0062a() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.g() != null) {
                        Thread g = a.this.g();
                        i.b(g);
                        if (g.isAlive()) {
                            Thread g2 = a.this.g();
                            i.b(g2);
                            if (!g2.isInterrupted()) {
                                Thread g3 = a.this.g();
                                i.b(g3);
                                g3.interrupt();
                                a.this.h(null);
                            }
                        }
                    }
                    a.this.d();
                }
            }

            /* renamed from: com.dna.tools.k.a$c$a$b */
            /* loaded from: classes.dex */
            static final class b implements Runnable {

                /* renamed from: e, reason: collision with root package name */
                public static final b f1012e = new b();

                b() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    System.exit(0);
                    throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
                }
            }

            RunnableC0061a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                e.a aVar = com.omarea.common.ui.e.f1255b;
                Context e2 = a.this.e();
                String string = a.this.e().getString(R.string.error_root);
                i.c(string, "context.getString(R.string.error_root)");
                String string2 = a.this.e().getString(R.string.error_su_timeout);
                i.c(string2, "context.getString(R.string.error_su_timeout)");
                String string3 = a.this.e().getString(R.string.btn_retry);
                i.c(string3, "context.getString(R.string.btn_retry)");
                e.b bVar = new e.b(string3, new RunnableC0062a(), false, 4, null);
                String string4 = a.this.e().getString(R.string.btn_exit);
                i.c(string4, "context.getString(R.string.btn_exit)");
                aVar.e(e2, string, string2, null, bVar, new e.b(string4, b.f1012e, false, 4, null));
            }
        }

        c(l lVar) {
            this.f = lVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Thread.sleep(15000L);
            if (this.f.element) {
                return;
            }
            d.c.a.g.b.f1379c.d();
            a.this.f().post(new RunnableC0061a());
        }
    }

    public a(Context context, Runnable runnable) {
        i.d(context, "context");
        this.f1002c = context;
        this.f1003d = runnable;
        this.a = new Handler(Looper.getMainLooper());
    }

    public final void d() {
        if (f.a()) {
            Runnable runnable = this.f1003d;
            if (runnable != null) {
                this.a.post(runnable);
                return;
            }
            return;
        }
        l lVar = new l();
        lVar.element = false;
        Thread thread = new Thread(new b(lVar));
        this.f1001b = thread;
        i.b(thread);
        thread.start();
        new Thread(new c(lVar)).start();
    }

    public final Context e() {
        return this.f1002c;
    }

    public final Handler f() {
        return this.a;
    }

    public final Thread g() {
        return this.f1001b;
    }

    public final void h(Thread thread) {
        this.f1001b = thread;
    }
}
