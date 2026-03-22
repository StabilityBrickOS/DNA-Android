package d.c.b;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.RemoteViews;
import com.omarea.common.ui.e;
import com.omarea.krscript.model.RunnableNode;
import com.omarea.krscript.model.ShellHandlerBase;
import e.k.q;
import e.u.v;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class a extends Thread {

    /* renamed from: e, reason: collision with root package name */
    private static boolean f1381e = false;
    private static final String f = "kr_script_task_notification";
    private static int g = 34050;
    public static final C0094a h = new C0094a(null);

    /* renamed from: d.c.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0094a {

        /* renamed from: d.c.b.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class RunnableC0095a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Runnable f1382e;
            final /* synthetic */ Runnable f;

            RunnableC0095a(Runnable runnable, Runnable runnable2) {
                this.f1382e = runnable;
                this.f = runnable2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    this.f1382e.run();
                    this.f.run();
                } catch (Exception unused) {
                }
            }
        }

        private C0094a() {
        }

        public /* synthetic */ C0094a(e.p.d.e eVar) {
            this();
        }

        public final void a(Context context, String str, HashMap<String, String> hashMap, RunnableNode runnableNode, Runnable runnable, Runnable runnable2) {
            e.p.d.i.d(context, "context");
            e.p.d.i.d(str, "script");
            e.p.d.i.d(runnableNode, "nodeInfo");
            e.p.d.i.d(runnable, "onExit");
            e.p.d.i.d(runnable2, "onDismiss");
            Context applicationContext = context.getApplicationContext();
            a.g++;
            e.p.d.i.c(applicationContext, "applicationContext");
            new d.c.b.n.c().b(context, runnableNode, str, new RunnableC0095a(runnable, runnable2), hashMap, new b(applicationContext, runnableNode, a.g));
            Bundle bundle = new Bundle();
            if (hashMap != null) {
                bundle.putSerializable("params", hashMap);
            }
            e.a aVar = com.omarea.common.ui.e.f1255b;
            String string = context.getString(h.kr_bg_task_start);
            e.p.d.i.c(string, "context.getString(R.string.kr_bg_task_start)");
            String string2 = context.getString(h.kr_bg_task_start_desc);
            e.p.d.i.c(string2, "context.getString(R.string.kr_bg_task_start_desc)");
            e.a.o(aVar, context, string, string2, null, 8, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends ShellHandlerBase {
        private NotificationManager a;

        /* renamed from: b, reason: collision with root package name */
        private final String f1383b;

        /* renamed from: c, reason: collision with root package name */
        private ArrayList<String> f1384c;

        /* renamed from: d, reason: collision with root package name */
        private String f1385d;

        /* renamed from: e, reason: collision with root package name */
        private int f1386e;
        private int f;
        private boolean g;
        private Runnable h;
        private boolean i;
        private String j;
        private final PendingIntent k;
        private final C0096a l;
        private final Context m;
        private final RunnableNode n;
        private final int o;

        /* renamed from: d.c.b.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0096a extends BroadcastReceiver {
            C0096a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Runnable runnable;
                if (intent == null || !intent.hasExtra("id") || intent.getIntExtra("id", 0) != b.this.o || (runnable = b.this.h) == null) {
                    return;
                }
                runnable.run();
            }
        }

        public b(Context context, RunnableNode runnableNode, int i) {
            e.p.d.i.d(context, "context");
            e.p.d.i.d(runnableNode, "runnableNode");
            this.m = context;
            this.n = runnableNode;
            this.o = i;
            Object systemService = context.getSystemService("notification");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
            }
            this.a = (NotificationManager) systemService;
            this.f1383b = this.n.getTitle();
            this.f1384c = new ArrayList<>();
            this.f1385d = "";
            this.j = this.m.getPackageName() + ".TaskStop.N" + this.o;
            Context context2 = this.m;
            Intent intent = new Intent(this.j);
            intent.putExtra("id", this.o);
            e.j jVar = e.j.a;
            this.k = PendingIntent.getBroadcast(context2, 0, intent, 134217728);
            this.l = new C0096a();
        }

        private final void c() {
            String s;
            CharSequence R;
            int i = 8;
            if (this.f1384c.size() > 8) {
                synchronized (this.f1384c) {
                    this.f1384c.remove(e.k.g.n(this.f1384c));
                    this.g = true;
                    e.j jVar = e.j.a;
                }
            }
            RemoteViews remoteViews = new RemoteViews(this.m.getPackageName(), g.kr_task_notification);
            remoteViews.setTextViewText(f.kr_task_title, this.f1383b + "(" + this.o + ")");
            int i2 = f.kr_task_log;
            s = q.s(this.f1384c, "", this.g ? "……\n" : "", null, 0, null, null, 60, null);
            if (s == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            R = v.R(s);
            remoteViews.setTextViewText(i2, R.toString());
            int i3 = f.kr_task_progress;
            int i4 = this.f;
            remoteViews.setProgressBar(i3, i4, this.f1386e, i4 < 0);
            remoteViews.setViewVisibility(f.kr_task_progress, this.f == this.f1386e ? 8 : 0);
            int i5 = f.kr_task_stop;
            if ((this.h != null || this.n.getInterruptable()) && !this.i) {
                i = 0;
            }
            remoteViews.setViewVisibility(i5, i);
            if (this.n.getInterruptable() && this.h != null && !this.i) {
                remoteViews.setOnClickPendingIntent(f.kr_task_stop, this.k);
            }
            Notification.Builder contentTitle = new Notification.Builder(this.m).setContentTitle("" + this.f1383b + "(" + this.o + ")");
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(this.f1385d);
            sb.append(" >> ");
            sb.append((String) e.k.g.u(this.f1384c));
            Notification.Builder when = contentTitle.setContentText(sb.toString()).setSmallIcon(e.kr_run).setAutoCancel(true).setWhen(System.currentTimeMillis());
            int i6 = this.f;
            int i7 = this.f1386e;
            if (i6 != i7) {
                when.setProgress(i6, i7, i6 < 0);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                when.setCustomBigContentView(remoteViews);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                if (!a.f1381e) {
                    NotificationChannel notificationChannel = new NotificationChannel(a.f, this.m.getString(h.kr_script_task_notification), 3);
                    notificationChannel.enableLights(false);
                    notificationChannel.enableVibration(false);
                    notificationChannel.setSound(null, null);
                    this.a.createNotificationChannel(notificationChannel);
                }
                a.f1381e = true;
                when.setChannelId(a.f);
            } else {
                when.setSound(null);
                when.setVibrate(null);
            }
            Notification build = when.build();
            if (Build.VERSION.SDK_INT < 24) {
                build.bigContentView = remoteViews;
            }
            if (!this.i) {
                e.p.d.i.b(build);
                build.flags = 34;
            }
            this.a.notify(this.o, build);
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onError(Object obj) {
            String string = this.m.getString(h.kr_script_task_has_error);
            e.p.d.i.c(string, "context.getString(R.stri…kr_script_task_has_error)");
            this.f1385d = string;
            synchronized (this.f1384c) {
                ArrayList<String> arrayList = this.f1384c;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(obj != null ? obj.toString() : null);
                arrayList.add(sb.toString());
                c();
                e.j jVar = e.j.a;
            }
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onExit(Object obj) {
            this.i = true;
            String string = this.m.getString(h.kr_script_task_finished);
            e.p.d.i.c(string, "context.getString(R.stri….kr_script_task_finished)");
            this.f1385d = string;
            synchronized (this.f1384c) {
                if (e.p.d.i.a(obj, 0)) {
                    this.f1384c.add("\n" + this.m.getString(h.kr_shell_completed));
                } else {
                    ArrayList<String> arrayList = this.f1384c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("\n");
                    sb.append(this.m.getString(h.kr_shell_finish_error));
                    sb.append(" ");
                    sb.append(obj != null ? obj.toString() : null);
                    arrayList.add(sb.toString());
                }
                c();
                e.j jVar = e.j.a;
            }
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onProgress(int i, int i2) {
            this.f1386e = i;
            this.f = i2;
            c();
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onReader(Object obj) {
            synchronized (this.f1384c) {
                ArrayList<String> arrayList = this.f1384c;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(obj != null ? obj.toString() : null);
                arrayList.add(sb.toString());
                c();
                e.j jVar = e.j.a;
            }
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onStart(Object obj) {
            String string = this.m.getString(h.kr_script_task_running);
            e.p.d.i.c(string, "context.getString(R.string.kr_script_task_running)");
            this.f1385d = string;
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        public void onStart(Runnable runnable) {
            this.h = runnable;
            this.m.registerReceiver(this.l, new IntentFilter(this.j));
            c();
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onWrite(Object obj) {
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void updateLog(SpannableString spannableString) {
        }
    }
}
