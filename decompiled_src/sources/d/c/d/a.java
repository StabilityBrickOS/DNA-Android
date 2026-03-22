package d.c.d;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.dna.tools.R;
import com.dna.tools.ui.FloatMonitorBatteryView;
import com.dna.tools.ui.FloatMonitorChartView;
import e.p.d.e;
import e.p.d.i;
import e.p.d.n;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public final class a {
    private static WindowManager p;

    @SuppressLint({"StaticFieldLeak"})
    private static View r;
    private Context a;

    /* renamed from: b, reason: collision with root package name */
    private Timer f1525b;

    /* renamed from: c, reason: collision with root package name */
    private com.dna.tools.l.b f1526c;

    /* renamed from: d, reason: collision with root package name */
    private View f1527d;

    /* renamed from: e, reason: collision with root package name */
    private FloatMonitorChartView f1528e;
    private TextView f;
    private FloatMonitorChartView g;
    private TextView h;
    private FloatMonitorBatteryView i;
    private TextView j;
    private TextView k;
    private ActivityManager l;
    private Handler m;
    private d.c.c.a.a n;
    private final ActivityManager.MemoryInfo o;
    public static final C0116a s = new C0116a(null);
    private static Boolean q = Boolean.FALSE;

    /* renamed from: d.c.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0116a {
        private C0116a() {
        }

        public /* synthetic */ C0116a(e eVar) {
            this();
        }

        public final Boolean a() {
            return a.q;
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements View.OnTouchListener {

        /* renamed from: e, reason: collision with root package name */
        private boolean f1529e;
        private float f;
        private float g;
        private float h;
        private float i;
        private long j;
        private long k;
        final /* synthetic */ WindowManager.LayoutParams m;

        b(WindowManager.LayoutParams layoutParams) {
            this.m = layoutParams;
        }

        private final void a() {
            if (System.currentTimeMillis() - this.k < 300) {
                a.this.n();
            } else {
                this.k = System.currentTimeMillis();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        
            if (r1 != 4) goto L26;
         */
        @Override // android.view.View.OnTouchListener
        @android.annotation.SuppressLint({"ClickableViewAccessibility"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
            /*
                r5 = this;
                r0 = 0
                if (r7 == 0) goto L97
                int r1 = r7.getAction()
                r2 = 1
                if (r1 == 0) goto L77
                if (r1 == r2) goto L44
                r2 = 2
                if (r1 == r2) goto L1b
                r6 = 3
                if (r1 == r6) goto L17
                r6 = 4
                if (r1 == r6) goto L17
                goto L97
            L17:
                r5.f1529e = r0
                goto L97
            L1b:
                boolean r1 = r5.f1529e
                if (r1 == 0) goto L97
                android.view.WindowManager$LayoutParams r1 = r5.m
                float r2 = r7.getRawX()
                float r3 = r5.f
                float r2 = r2 - r3
                int r2 = (int) r2
                r1.x = r2
                android.view.WindowManager$LayoutParams r1 = r5.m
                float r7 = r7.getRawY()
                float r2 = r5.g
                float r7 = r7 - r2
                int r7 = (int) r7
                r1.y = r7
                android.view.WindowManager r7 = d.c.d.a.g()
                e.p.d.i.b(r7)
                android.view.WindowManager$LayoutParams r1 = r5.m
                r7.updateViewLayout(r6, r1)
                goto L97
            L44:
                long r1 = java.lang.System.currentTimeMillis()
                long r3 = r5.j
                long r1 = r1 - r3
                r6 = 300(0x12c, float:4.2E-43)
                long r3 = (long) r6
                int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r6 >= 0) goto L17
                float r6 = r7.getRawX()
                float r1 = r5.h
                float r6 = r6 - r1
                float r6 = java.lang.Math.abs(r6)
                r1 = 15
                float r1 = (float) r1
                int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
                if (r6 >= 0) goto L17
                float r6 = r7.getRawY()
                float r7 = r5.i
                float r6 = r6 - r7
                float r6 = java.lang.Math.abs(r6)
                int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
                if (r6 >= 0) goto L17
                r5.a()
                goto L17
            L77:
                float r6 = r7.getX()
                r5.f = r6
                float r6 = r7.getY()
                r5.g = r6
                float r6 = r7.getRawX()
                r5.h = r6
                float r6 = r7.getRawY()
                r5.i = r6
                r5.f1529e = r2
                long r6 = java.lang.System.currentTimeMillis()
                r5.j = r6
            L97:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: d.c.d.a.b.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a.this.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d implements Runnable {
        final /* synthetic */ n f;
        final /* synthetic */ int g;
        final /* synthetic */ String h;
        final /* synthetic */ int i;
        final /* synthetic */ com.dna.tools.a j;

        d(n nVar, int i, String str, int i2, com.dna.tools.a aVar) {
            this.f = nVar;
            this.g = i;
            this.h = str;
            this.i = i2;
            this.j = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            TextView textView;
            Resources resources;
            int i;
            int color;
            FloatMonitorChartView floatMonitorChartView = a.this.f1528e;
            i.b(floatMonitorChartView);
            Double d2 = (Double) this.f.element;
            i.c(d2, "cpuLoad");
            floatMonitorChartView.f(100.0f, (float) (100 - d2.doubleValue()));
            TextView textView2 = a.this.f;
            i.b(textView2);
            textView2.setText(a.this.s(String.valueOf(this.g)) + "Mhz");
            TextView textView3 = a.this.h;
            i.b(textView3);
            textView3.setText(this.h);
            if (this.i > -1) {
                FloatMonitorChartView floatMonitorChartView2 = a.this.g;
                i.b(floatMonitorChartView2);
                floatMonitorChartView2.f(100.0f, 100.0f - this.i);
            }
            FloatMonitorBatteryView floatMonitorBatteryView = a.this.i;
            i.b(floatMonitorBatteryView);
            floatMonitorBatteryView.f(100.0f, 100.0f - this.j.a);
            TextView textView4 = a.this.j;
            i.b(textView4);
            textView4.setText(String.valueOf(this.j.f980b) + "°C");
            TextView textView5 = a.this.k;
            i.b(textView5);
            textView5.setText(String.valueOf(this.j.a) + "%");
            float f = this.j.f980b;
            if (f >= 54) {
                textView = a.this.j;
                i.b(textView);
                color = Color.rgb(255, 15, 0);
            } else {
                if (f >= 49) {
                    textView = a.this.j;
                    i.b(textView);
                    Context context = a.this.a;
                    i.b(context);
                    resources = context.getResources();
                    i = R.color.color_load_veryhight;
                } else if (f >= 44) {
                    textView = a.this.j;
                    i.b(textView);
                    Context context2 = a.this.a;
                    i.b(context2);
                    resources = context2.getResources();
                    i = R.color.color_load_hight;
                } else if (f > 34) {
                    textView = a.this.j;
                    i.b(textView);
                    Context context3 = a.this.a;
                    i.b(context3);
                    resources = context3.getResources();
                    i = R.color.color_load_mid;
                } else {
                    textView = a.this.j;
                    i.b(textView);
                    Context context4 = a.this.a;
                    i.b(context4);
                    resources = context4.getResources();
                    i = R.color.color_load_low;
                }
                color = resources.getColor(i);
            }
            textView.setTextColor(color);
            View view = a.this.f1527d;
            i.b(view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            View view2 = a.this.f1527d;
            i.b(view2);
            view2.setLayoutParams(layoutParams);
        }
    }

    public a(Context context) {
        i.d(context, "context");
        this.a = context;
        this.f1526c = new com.dna.tools.l.b();
        this.m = new Handler();
        this.n = new d.c.c.a.a();
        this.o = new ActivityManager.MemoryInfo();
    }

    @SuppressLint({"ApplySharedPref", "ClickableViewAccessibility"})
    private final View o(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fw_monitor, (ViewGroup) null);
        this.f1527d = inflate;
        i.b(inflate);
        inflate.findViewById(R.id.fw_gpu);
        View view = this.f1527d;
        i.b(view);
        view.findViewById(R.id.fw_battery);
        View view2 = this.f1527d;
        i.b(view2);
        this.f1528e = (FloatMonitorChartView) view2.findViewById(R.id.fw_cpu_load);
        View view3 = this.f1527d;
        i.b(view3);
        this.g = (FloatMonitorChartView) view3.findViewById(R.id.fw_gpu_load);
        View view4 = this.f1527d;
        i.b(view4);
        View view5 = this.f1527d;
        i.b(view5);
        this.i = (FloatMonitorBatteryView) view5.findViewById(R.id.fw_battery_chart);
        View view6 = this.f1527d;
        i.b(view6);
        this.f = (TextView) view6.findViewById(R.id.fw_cpu_freq);
        View view7 = this.f1527d;
        i.b(view7);
        this.h = (TextView) view7.findViewById(R.id.fw_gpu_freq);
        View view8 = this.f1527d;
        i.b(view8);
        View view9 = this.f1527d;
        i.b(view9);
        this.j = (TextView) view9.findViewById(R.id.fw_battery_temp);
        View view10 = this.f1527d;
        i.b(view10);
        this.k = (TextView) view10.findViewById(R.id.fw_battery_level);
        Object systemService = context.getSystemService("activity");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
        }
        this.l = (ActivityManager) systemService;
        View view11 = this.f1527d;
        i.b(view11);
        return view11;
    }

    private final void q() {
        r();
        Timer timer = new Timer();
        this.f1525b = timer;
        i.b(timer);
        timer.schedule(new c(), 0L, 1000L);
        t();
    }

    private final void r() {
        Timer timer = this.f1525b;
        if (timer != null) {
            i.b(timer);
            timer.cancel();
            this.f1525b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String s(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 3) {
            return str.length() == 0 ? "0" : str;
        }
        String substring = str.substring(0, str.length() - 3);
        i.c(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Double] */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.Double] */
    public final void t() {
        int f = com.dna.tools.l.a.f();
        String str = com.dna.tools.l.c.a() + "Mhz";
        int b2 = com.dna.tools.l.c.b();
        ActivityManager activityManager = this.l;
        i.b(activityManager);
        activityManager.getMemoryInfo(this.o);
        n nVar = new n();
        ?? c2 = this.f1526c.c();
        nVar.element = c2;
        double d2 = 0;
        if (((Double) c2).doubleValue() < d2) {
            nVar.element = Double.valueOf(d2);
        }
        this.m.post(new d(nVar, f, str, b2, this.n.a()));
    }

    public final void n() {
        r();
        Boolean bool = q;
        i.b(bool);
        if (!bool.booleanValue() || r == null) {
            return;
        }
        WindowManager windowManager = p;
        i.b(windowManager);
        windowManager.removeView(r);
        r = null;
        q = Boolean.FALSE;
    }

    public final void p() {
        Boolean bool = q;
        i.b(bool);
        if (bool.booleanValue()) {
            return;
        }
        System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this.a)) {
            Context context = this.a;
            i.b(context);
            Toast.makeText(context, context.getString(R.string.permission_float), 1).show();
            return;
        }
        q = Boolean.TRUE;
        Context context2 = this.a;
        i.b(context2);
        Object systemService = context2.getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        p = (WindowManager) systemService;
        Context context3 = this.a;
        i.b(context3);
        r = o(context3);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2003;
        layoutParams.type = Build.VERSION.SDK_INT >= 26 ? 2038 : 2003;
        layoutParams.format = -3;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.flags = 40;
        WindowManager windowManager = p;
        i.b(windowManager);
        windowManager.addView(r, layoutParams);
        View view = r;
        i.b(view);
        view.setOnTouchListener(new b(layoutParams));
        q();
    }
}
