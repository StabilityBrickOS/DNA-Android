package d.c.b;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.omarea.krscript.model.RunnableNode;
import com.omarea.krscript.model.ShellHandlerBase;
import e.k.q;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class c extends Thread {

    /* renamed from: e, reason: collision with root package name */
    private static int f1387e = 34050;
    public static final a f = new a(null);

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: d.c.b.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class RunnableC0097a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Runnable f1388e;
            final /* synthetic */ Runnable f;

            RunnableC0097a(Runnable runnable, Runnable runnable2) {
                this.f1388e = runnable;
                this.f = runnable2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    this.f1388e.run();
                    this.f.run();
                } catch (Exception unused) {
                }
            }
        }

        private a() {
        }

        public /* synthetic */ a(e.p.d.e eVar) {
            this();
        }

        public final void a(Context context, String str, HashMap<String, String> hashMap, RunnableNode runnableNode, Runnable runnable, Runnable runnable2) {
            e.p.d.i.d(context, "context");
            e.p.d.i.d(str, "script");
            e.p.d.i.d(runnableNode, "nodeInfo");
            e.p.d.i.d(runnable, "onExit");
            e.p.d.i.d(runnable2, "onDismiss");
            Context applicationContext = context.getApplicationContext();
            c.f1387e++;
            e.p.d.i.c(applicationContext, "applicationContext");
            new d.c.b.n.c().b(context, runnableNode, str, new RunnableC0097a(runnable, runnable2), hashMap, new b(applicationContext));
            Bundle bundle = new Bundle();
            if (hashMap != null) {
                bundle.putSerializable("params", hashMap);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends ShellHandlerBase {
        private ArrayList<String> a;

        /* renamed from: b, reason: collision with root package name */
        private final Context f1389b;

        public b(Context context) {
            e.p.d.i.d(context, "context");
            this.f1389b = context;
            this.a = new ArrayList<>();
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onError(Object obj) {
            e.p.d.i.c(this.f1389b.getString(h.kr_script_task_has_error), "context.getString(R.stri…kr_script_task_has_error)");
            synchronized (this.a) {
                ArrayList<String> arrayList = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(obj != null ? obj.toString() : null);
                arrayList.add(sb.toString());
            }
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onExit(Object obj) {
            String s;
            if (this.a.size() > 0) {
                Context context = this.f1389b;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f1389b.getString(h.kr_script_task_has_error));
                sb.append("\n\n");
                s = q.s(this.a, "\n", null, null, 0, null, null, 62, null);
                sb.append(s);
                Toast.makeText(context, sb.toString(), 1).show();
            }
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onProgress(int i, int i2) {
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onReader(Object obj) {
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onStart(Object obj) {
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        public void onStart(Runnable runnable) {
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onWrite(Object obj) {
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void updateLog(SpannableString spannableString) {
        }
    }
}
