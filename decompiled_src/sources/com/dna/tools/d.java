package com.dna.tools;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.dna.tools.ui.RamChatView;
import com.omarea.common.ui.OverScrollGridView;
import e.p.d.q;
import e.u.v;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public final class d extends Fragment {
    private Timer b0;
    private ActivityManager e0;
    private int h0;
    private HashMap i0;
    private Handler c0 = new Handler();
    private int d0 = -1;
    private HashMap<Integer, String> f0 = new HashMap<>();
    private HashMap<Integer, String> g0 = new HashMap<>();

    /* loaded from: classes.dex */
    public static final class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.this.A1();
        }
    }

    /* loaded from: classes.dex */
    static final class b implements View.OnClickListener {

        /* loaded from: classes.dex */
        static final class a implements Runnable {

            /* renamed from: com.dna.tools.d$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            static final class RunnableC0054a implements Runnable {
                RunnableC0054a() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        d.this.B1();
                        Toast.makeText(d.this.u(), d.this.N(R.string.monitor_cache_cleared), 0).show();
                    } catch (Exception unused) {
                    }
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                d.c.a.g.b.f1379c.b("sync\necho 3 > /proc/sys/vm/drop_caches\necho 1 > /proc/sys/vm/compact_memory");
                d.this.c0.postDelayed(new RunnableC0054a(), 600L);
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TextView textView = (TextView) d.this.t1(g.home_raminfo_text);
            e.p.d.i.c(textView, "home_raminfo_text");
            textView.setText(d.this.N(R.string.please_wait));
            new Thread(new a()).start();
        }
    }

    /* loaded from: classes.dex */
    static final class c implements View.OnClickListener {

        /* loaded from: classes.dex */
        static final class a implements Runnable {

            /* renamed from: com.dna.tools.d$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            static final class RunnableC0055a implements Runnable {
                RunnableC0055a() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        d.this.B1();
                        Toast.makeText(d.this.u(), d.this.N(R.string.monitor_ram_cleared), 0).show();
                    } catch (Exception unused) {
                    }
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                d.c.a.g.b.f1379c.b("sync\necho 1 > /proc/sys/vm/compact_memory");
                d.this.c0.postDelayed(new RunnableC0055a(), 600L);
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TextView textView = (TextView) d.this.t1(g.home_zramsize_text);
            e.p.d.i.c(textView, "home_zramsize_text");
            textView.setText(d.this.N(R.string.please_wait));
            new Thread(new a()).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.dna.tools.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class RunnableC0056d implements Runnable {
        final /* synthetic */ String f;
        final /* synthetic */ int g;
        final /* synthetic */ HashMap h;
        final /* synthetic */ ArrayList i;

        RunnableC0056d(String str, int i, HashMap hashMap, ArrayList arrayList) {
            this.f = str;
            this.g = i;
            this.h = hashMap;
            this.i = arrayList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                TextView textView = (TextView) d.this.t1(g.cpu_core_count);
                e.p.d.i.c(textView, "cpu_core_count");
                q qVar = q.a;
                String N = d.this.N(R.string.monitor_core_count);
                e.p.d.i.c(N, "getString(R.string.monitor_core_count)");
                String format = String.format(N, Arrays.copyOf(new Object[]{Integer.valueOf(d.this.d0)}, 1));
                e.p.d.i.c(format, "java.lang.String.format(format, *args)");
                textView.setText(format);
                TextView textView2 = (TextView) d.this.t1(g.home_gpu_freq);
                e.p.d.i.c(textView2, "home_gpu_freq");
                textView2.setText(this.f);
                TextView textView3 = (TextView) d.this.t1(g.home_gpu_load);
                e.p.d.i.c(textView3, "home_gpu_load");
                q qVar2 = q.a;
                String N2 = d.this.N(R.string.monitor_laod);
                e.p.d.i.c(N2, "getString(R.string.monitor_laod)");
                String format2 = String.format(N2, Arrays.copyOf(new Object[]{Integer.valueOf(this.g)}, 1));
                e.p.d.i.c(format2, "java.lang.String.format(format, *args)");
                textView3.setText(format2);
                if (this.g > -1) {
                    ((RamChatView) d.this.t1(g.home_gpu_chat)).d(100, 100 - this.g);
                }
                if (this.h.containsKey(-1)) {
                    TextView textView4 = (TextView) d.this.t1(g.cpu_core_total_load);
                    e.p.d.i.c(textView4, "cpu_core_total_load");
                    q qVar3 = q.a;
                    String N3 = d.this.N(R.string.monitor_laod);
                    e.p.d.i.c(N3, "getString(R.string.monitor_laod)");
                    Object obj = this.h.get(-1);
                    e.p.d.i.b(obj);
                    String format3 = String.format(N3, Arrays.copyOf(new Object[]{Integer.valueOf((int) ((Number) obj).doubleValue())}, 1));
                    e.p.d.i.c(format3, "java.lang.String.format(format, *args)");
                    textView4.setText(format3);
                    e.p.d.i.b(this.h.get(-1));
                    ((RamChatView) d.this.t1(g.home_cpu_chat)).d(100, 100 - ((int) ((Number) r3).doubleValue()));
                }
                OverScrollGridView overScrollGridView = (OverScrollGridView) d.this.t1(g.cpu_core_list);
                e.p.d.i.c(overScrollGridView, "cpu_core_list");
                if (overScrollGridView.getAdapter() != null) {
                    OverScrollGridView overScrollGridView2 = (OverScrollGridView) d.this.t1(g.cpu_core_list);
                    e.p.d.i.c(overScrollGridView2, "cpu_core_list");
                    ListAdapter adapter = overScrollGridView2.getAdapter();
                    if (adapter == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.projectkr.shell.ui.AdapterCpuCores");
                    }
                    ((com.dna.tools.ui.a) adapter).b(this.i);
                    return;
                }
                if (this.i.size() < 6) {
                    OverScrollGridView overScrollGridView3 = (OverScrollGridView) d.this.t1(g.cpu_core_list);
                    e.p.d.i.c(overScrollGridView3, "cpu_core_list");
                    overScrollGridView3.setNumColumns(2);
                }
                OverScrollGridView overScrollGridView4 = (OverScrollGridView) d.this.t1(g.cpu_core_list);
                e.p.d.i.c(overScrollGridView4, "cpu_core_list");
                Context u = d.this.u();
                e.p.d.i.b(u);
                e.p.d.i.c(u, "context!!");
                overScrollGridView4.setAdapter((ListAdapter) new com.dna.tools.ui.a(u, this.i));
            } catch (Exception e2) {
                Log.e("Exception", e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0065, code lost:
    
        if ((r4 == null || r4.length() == 0) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00be, code lost:
    
        if ((r4 == null || r4.length() == 0) != false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0107 A[SYNTHETIC] */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A1() {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dna.tools.d.A1():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void B1() {
        boolean n;
        int v;
        int A;
        CharSequence R;
        int v2;
        CharSequence R2;
        int v3;
        CharSequence R3;
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (this.e0 == null) {
                Context u = u();
                e.p.d.i.b(u);
                Object systemService = u.getSystemService("activity");
                if (systemService == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
                }
                this.e0 = (ActivityManager) systemService;
            }
            ActivityManager activityManager = this.e0;
            e.p.d.i.b(activityManager);
            activityManager.getMemoryInfo(memoryInfo);
            long j = 1024;
            int i = (int) (((float) (memoryInfo.totalMem / j)) / 1024.0f);
            int i2 = (int) (((float) (memoryInfo.availMem / j)) / 1024.0f);
            TextView textView = (TextView) t1(g.home_raminfo_text);
            e.p.d.i.c(textView, "home_raminfo_text");
            textView.setText((((i - i2) * 100) / i) + "% (" + ((i / 1024) + 1) + "GB)");
            ((RamChatView) t1(g.home_raminfo)).d((float) i, (float) i2);
            String b2 = d.c.a.g.b.f1379c.b("free -m | grep Swap");
            n = v.n(b2, "Swap", false, 2, null);
            if (n) {
                v = v.v(b2, " ", 0, false, 6, null);
                A = v.A(b2, " ", 0, false, 6, null);
                if (b2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String substring = b2.substring(v, A);
                e.p.d.i.c(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (substring == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                R = v.R(substring);
                String obj = R.toString();
                if (new e.u.h("[\\d]{1,}[\\s]{1,}[\\d]{1,}").matches(obj)) {
                    v2 = v.v(obj, " ", 0, false, 6, null);
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String substring2 = obj.substring(0, v2);
                    e.p.d.i.c(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    R2 = v.R(substring2);
                    int parseInt = Integer.parseInt(R2.toString());
                    v3 = v.v(obj, " ", 0, false, 6, null);
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String substring3 = obj.substring(v3);
                    e.p.d.i.c(substring3, "(this as java.lang.String).substring(startIndex)");
                    if (substring3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    R3 = v.R(substring3);
                    int parseInt2 = Integer.parseInt(R3.toString());
                    ((RamChatView) t1(g.home_swapstate_chat)).d(parseInt, parseInt - parseInt2);
                    if (parseInt <= 99) {
                        TextView textView2 = (TextView) t1(g.home_zramsize_text);
                        e.p.d.i.c(textView2, "home_zramsize_text");
                        textView2.setText(((int) ((parseInt2 * 100.0d) / parseInt)) + "% (" + parseInt + "MB)");
                        return;
                    }
                    TextView textView3 = (TextView) t1(g.home_zramsize_text);
                    e.p.d.i.c(textView3, "home_zramsize_text");
                    StringBuilder sb = new StringBuilder();
                    double d2 = parseInt;
                    sb.append((int) ((parseInt2 * 100.0d) / d2));
                    sb.append("% (");
                    sb.append(y1(d2 / 1024.0d));
                    sb.append("GB)");
                    textView3.setText(sb.toString());
                }
            }
        } catch (Exception unused) {
        }
    }

    private final void z1() {
        Timer timer = this.b0;
        if (timer != null) {
            e.p.d.i.b(timer);
            timer.cancel();
            this.b0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"SetTextI18n"})
    public void A0() {
        super.A0();
        if (T()) {
            return;
        }
        this.g0.clear();
        this.f0.clear();
        z1();
        Timer timer = new Timer();
        this.b0 = timer;
        e.p.d.i.b(timer);
        timer.schedule(new a(), 0L, 1000L);
        B1();
    }

    @Override // androidx.fragment.app.Fragment
    public void E0(View view, Bundle bundle) {
        e.p.d.i.d(view, "view");
        super.E0(view, bundle);
        ((LinearLayout) t1(g.home_clear_ram)).setOnClickListener(new b());
        ((LinearLayout) t1(g.home_clear_swap)).setOnClickListener(new c());
    }

    @Override // androidx.fragment.app.Fragment
    public View j0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        e.p.d.i.d(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void m0() {
        super.m0();
        s1();
    }

    public void s1() {
        HashMap hashMap = this.i0;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View t1(int i) {
        if (this.i0 == null) {
            this.i0 = new HashMap();
        }
        View view = (View) this.i0.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View P = P();
        if (P == null) {
            return null;
        }
        View findViewById = P.findViewById(i);
        this.i0.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // androidx.fragment.app.Fragment
    public void v0() {
        z1();
        super.v0();
    }

    public final String y1(double d2) {
        BigDecimal scale = new BigDecimal(d2).setScale(1, RoundingMode.HALF_UP);
        e.p.d.i.c(scale, "bd.setScale(1, RoundingMode.HALF_UP)");
        String bigDecimal = scale.toString();
        e.p.d.i.c(bigDecimal, "bd.toString()");
        return bigDecimal;
    }
}
