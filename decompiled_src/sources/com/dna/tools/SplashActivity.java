package com.dna.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import e.k.q;
import e.u.v;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class SplashActivity extends Activity {

    /* renamed from: e, reason: collision with root package name */
    private boolean f969e;
    private HashMap f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends Thread {

        /* renamed from: e, reason: collision with root package name */
        private final HashMap<String, String> f970e;
        private Context f;
        private final com.dna.tools.e g;
        private c h;

        public a(Context context, com.dna.tools.e eVar, c cVar) {
            e.p.d.i.d(context, "context");
            e.p.d.i.d(eVar, "config");
            e.p.d.i.d(cVar, "updateLogViewHandler");
            this.f = context;
            this.g = eVar;
            this.h = cVar;
            this.f970e = eVar.g();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Process d2 = com.dna.tools.k.a.f.a() ? d.c.a.g.e.d() : d.c.a.g.e.c();
                if (d2 != null) {
                    d.c.b.n.b.c(this.f, new DataOutputStream(d2.getOutputStream()), this.g.b(), this.f970e, null, "pio-splash");
                    InputStream inputStream = d2.getInputStream();
                    e.p.d.i.c(inputStream, "process.inputStream");
                    Reader inputStreamReader = new InputStreamReader(inputStream, e.u.c.a);
                    new b(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192), this.h).start();
                    InputStream errorStream = d2.getErrorStream();
                    e.p.d.i.c(errorStream, "process.errorStream");
                    Reader inputStreamReader2 = new InputStreamReader(errorStream, e.u.c.a);
                    new b(inputStreamReader2 instanceof BufferedReader ? (BufferedReader) inputStreamReader2 : new BufferedReader(inputStreamReader2, 8192), this.h).start();
                    d2.waitFor();
                }
                this.h.f();
            } catch (Exception unused) {
                this.h.f();
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class b extends Thread {

        /* renamed from: e, reason: collision with root package name */
        private BufferedReader f971e;
        private c f;

        public b(BufferedReader bufferedReader, c cVar) {
            e.p.d.i.d(bufferedReader, "reader");
            e.p.d.i.d(cVar, "updateLogViewHandler");
            this.f971e = bufferedReader;
            this.f = cVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                String readLine = this.f971e.readLine();
                if (readLine == null) {
                    return;
                } else {
                    this.f.g(readLine);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {
        private final Handler a;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<String> f972b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f973c;

        /* renamed from: d, reason: collision with root package name */
        private TextView f974d;

        /* renamed from: e, reason: collision with root package name */
        private final Runnable f975e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                c.this.f975e.run();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class b implements Runnable {
            final /* synthetic */ String f;

            b(String str) {
                this.f = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                String s;
                CharSequence R;
                synchronized (c.this.f972b) {
                    if (c.this.f972b.size() > 6) {
                        c.this.f972b.remove(e.k.g.n(c.this.f972b));
                        c.this.f973c = true;
                    }
                    c.this.f972b.add(this.f);
                    TextView textView = c.this.f974d;
                    s = q.s(c.this.f972b, "\n", c.this.f973c ? "……\n" : "", null, 0, null, null, 60, null);
                    if (s == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    R = v.R(s);
                    textView.setText(R.toString());
                    e.j jVar = e.j.a;
                }
            }
        }

        public c(TextView textView, Runnable runnable) {
            e.p.d.i.d(textView, "logView");
            e.p.d.i.d(runnable, "onExit");
            this.f974d = textView;
            this.f975e = runnable;
            this.a = new Handler(Looper.getMainLooper());
            this.f972b = new ArrayList<>();
        }

        public final void f() {
            this.a.post(new a());
        }

        public final void g(String str) {
            e.p.d.i.d(str, "log");
            this.a.post(new b(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            TextView textView = (TextView) SplashActivity.this.a(g.start_state_text);
            e.p.d.i.c(textView, "start_state_text");
            textView.setText(SplashActivity.this.getString(R.string.pio_permission_checking));
            SplashActivity.this.f969e = true;
            SplashActivity.this.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SplashActivity.this.h();
        }
    }

    public SplashActivity() {
        new Handler();
    }

    private final void e() {
        LinearLayout linearLayout = (LinearLayout) a(g.start_logo);
        e.p.d.i.c(linearLayout, "start_logo");
        linearLayout.setVisibility(0);
        f(new d());
    }

    private final void f(Runnable runnable) {
        new com.dna.tools.k.a(this, runnable).d();
    }

    private final int g() {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true);
        return typedValue.data;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        Intent intent;
        if (getIntent() != null && getIntent().hasExtra("JumpActionPage") && getIntent().getBooleanExtra("JumpActionPage", false)) {
            intent = new Intent(getApplicationContext(), (Class<?>) ActionPage.class);
            intent.putExtras(getIntent());
        } else {
            intent = new Intent(getApplicationContext(), (Class<?>) MainActivity.class);
        }
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        TextView textView = (TextView) a(g.start_state_text);
        e.p.d.i.c(textView, "start_state_text");
        textView.setText(getString(R.string.pop_started));
        com.dna.tools.e eVar = new com.dna.tools.e();
        eVar.h(this);
        e.p.d.i.c(eVar, "config");
        String b2 = eVar.b();
        e.p.d.i.c(b2, "config.beforeStartSh");
        if (!(b2.length() > 0)) {
            h();
            return;
        }
        TextView textView2 = (TextView) a(g.start_state_text);
        e.p.d.i.c(textView2, "start_state_text");
        new a(this, eVar, new c(textView2, new e())).start();
    }

    private final void j() {
        Window window;
        int color;
        getWindow().setNavigationBarColor(g());
        if (Build.VERSION.SDK_INT >= 23) {
            window = getWindow();
            color = getColor(R.color.splash_bg_color);
        } else {
            window = getWindow();
            color = getResources().getColor(R.color.splash_bg_color);
        }
        window.setNavigationBarColor(color);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(1280);
            getWindow().setStatusBarColor(0);
        }
    }

    public View a(int i) {
        if (this.f == null) {
            this.f = new HashMap();
        }
        View view = (View) this.f.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (d.c.b.n.b.l()) {
            if (isTaskRoot()) {
                h();
            }
        } else {
            setContentView(R.layout.activity_splash);
            j();
            e();
        }
    }
}
