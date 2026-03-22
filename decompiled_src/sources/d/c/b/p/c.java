package d.c.b.p;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.krscript.model.RunnableNode;
import com.omarea.krscript.model.ShellHandlerBase;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class c extends androidx.fragment.app.c {
    public static final a v0 = new a(null);
    private boolean m0;
    private RunnableNode n0;
    private Runnable o0;
    private String p0;
    private HashMap<String, String> q0;
    private int r0;
    private View s0;
    private Runnable t0;
    private HashMap u0;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e.p.d.e eVar) {
            this();
        }

        public final c a(RunnableNode runnableNode, Runnable runnable, Runnable runnable2, String str, HashMap<String, String> hashMap, boolean z) {
            e.p.d.i.d(runnableNode, "nodeInfo");
            e.p.d.i.d(runnable, "onExit");
            e.p.d.i.d(runnable2, "onDismiss");
            e.p.d.i.d(str, "script");
            c cVar = new c();
            cVar.n0 = runnableNode;
            cVar.o0 = runnable;
            cVar.p0 = str;
            cVar.q0 = hashMap;
            cVar.r0 = z ? d.c.b.i.kr_full_screen_dialog_dark : d.c.b.i.kr_full_screen_dialog_light;
            cVar.t0 = runnable2;
            return cVar;
        }
    }

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface b {
        void a(Runnable runnable);

        void b();

        void c();
    }

    /* renamed from: d.c.b.p.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class HandlerC0115c extends ShellHandlerBase {
        private final Context a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1454b;

        /* renamed from: c, reason: collision with root package name */
        private final int f1455c;

        /* renamed from: d, reason: collision with root package name */
        private final int f1456d;

        /* renamed from: e, reason: collision with root package name */
        private final int f1457e;
        private boolean f;
        private b g;
        private TextView h;
        private ProgressBar i;

        /* renamed from: d.c.b.p.c$c$a */
        /* loaded from: classes.dex */
        static final class a implements Runnable {
            final /* synthetic */ SpannableString f;

            a(SpannableString spannableString) {
                this.f = spannableString;
            }

            @Override // java.lang.Runnable
            public final void run() {
                HandlerC0115c.this.h.append(this.f);
                ViewParent parent = HandlerC0115c.this.h.getParent();
                if (parent == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.ScrollView");
                }
                ((ScrollView) parent).fullScroll(130);
            }
        }

        public HandlerC0115c(b bVar, TextView textView, ProgressBar progressBar) {
            e.p.d.i.d(bVar, "actionEventHandler");
            e.p.d.i.d(textView, "logView");
            e.p.d.i.d(progressBar, "shellProgress");
            this.g = bVar;
            this.h = textView;
            this.i = progressBar;
            this.a = textView.getContext();
            this.f1454b = b(d.c.b.d.kr_shell_log_error);
            this.f1455c = b(d.c.b.d.kr_shell_log_basic);
            this.f1456d = b(d.c.b.d.kr_shell_log_script);
            this.f1457e = b(d.c.b.d.kr_shell_log_end);
        }

        private final int b(int i) {
            if (Build.VERSION.SDK_INT >= 23) {
                Context context = this.a;
                e.p.d.i.b(context);
                return context.getColor(i);
            }
            Context context2 = this.a;
            e.p.d.i.b(context2);
            return context2.getResources().getColor(i);
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase, android.os.Handler
        public void handleMessage(Message message) {
            e.p.d.i.d(message, "msg");
            int i = message.what;
            if (i == -2) {
                onExit(message.obj);
                return;
            }
            if (i == 0) {
                onStart(message.obj);
                return;
            }
            if (i == 2) {
                onReaderMsg(message.obj);
                return;
            }
            if (i == 4) {
                Object obj = message.obj;
                e.p.d.i.c(obj, "msg.obj");
                onError(obj);
            } else {
                if (i != 6) {
                    return;
                }
                Object obj2 = message.obj;
                e.p.d.i.c(obj2, "msg.obj");
                onWrite(obj2);
            }
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onError(Object obj) {
            e.p.d.i.d(obj, "msg");
            this.f = true;
            updateLog(obj, this.f1454b);
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onExit(Object obj) {
            updateLog(this.a.getString(d.c.b.h.kr_shell_completed), this.f1457e);
            this.g.c();
            if (this.f) {
                return;
            }
            this.g.b();
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onProgress(int i, int i2) {
            if (i == -1) {
                this.i.setVisibility(0);
                this.i.setIndeterminate(true);
            } else {
                if (i == i2) {
                    this.i.setVisibility(8);
                    return;
                }
                this.i.setVisibility(0);
                this.i.setIndeterminate(false);
                this.i.setMax(i2);
                this.i.setProgress(i);
            }
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onReader(Object obj) {
            e.p.d.i.d(obj, "msg");
            updateLog(obj, this.f1455c);
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onStart(Object obj) {
            this.h.setText("");
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        public void onStart(Runnable runnable) {
            this.g.a(runnable);
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void onWrite(Object obj) {
            e.p.d.i.d(obj, "msg");
            updateLog(obj, this.f1456d);
        }

        @Override // com.omarea.krscript.model.ShellHandlerBase
        protected void updateLog(SpannableString spannableString) {
            if (spannableString != null) {
                this.h.post(new a(spannableString));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            c.this.L1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e implements View.OnClickListener {
        final /* synthetic */ e.p.d.n f;

        e(e.p.d.n nVar) {
            this.f = nVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Runnable runnable;
            if (c.this.m0 && (runnable = (Runnable) this.f.element) != null) {
                runnable.run();
            }
            c.this.L1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                Context u = c.this.u();
                e.p.d.i.b(u);
                Object systemService = u.getSystemService("clipboard");
                if (systemService == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
                }
                TextView textView = (TextView) c.this.A1(d.c.b.f.shell_output);
                e.p.d.i.c(textView, "shell_output");
                ClipData newPlainText = ClipData.newPlainText("text", textView.getText().toString());
                e.p.d.i.c(newPlainText, "ClipData.newPlainText(\"t…l_output.text.toString())");
                ((ClipboardManager) systemService).setPrimaryClip(newPlainText);
                Toast.makeText(c.this.u(), c.this.N(d.c.b.h.copy_success), 0).show();
            } catch (Exception unused) {
                Toast.makeText(c.this.u(), c.this.N(d.c.b.h.copy_fail), 0).show();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class g implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RunnableNode f1462b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ e.p.d.n f1463c;

        g(RunnableNode runnableNode, e.p.d.n nVar) {
            this.f1462b = runnableNode;
            this.f1463c = nVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.c.b.p.c.b
        public void a(Runnable runnable) {
            Button button;
            int i;
            c.this.m0 = true;
            if (!this.f1462b.getInterruptable() || runnable == 0) {
                button = (Button) c.this.A1(d.c.b.f.btn_exit);
                e.p.d.i.c(button, "btn_exit");
                i = 8;
            } else {
                button = (Button) c.this.A1(d.c.b.f.btn_exit);
                e.p.d.i.c(button, "btn_exit");
                i = 0;
            }
            button.setVisibility(i);
            this.f1463c.element = runnable;
        }

        @Override // d.c.b.p.c.b
        public void b() {
            if (this.f1462b.getAutoOff()) {
                c.this.L1();
            }
        }

        @Override // d.c.b.p.c.b
        public void c() {
            c.this.m0 = false;
            c.C1(c.this).run();
            if (((ImageButton) c.this.A1(d.c.b.f.btn_hide)) != null) {
                ImageButton imageButton = (ImageButton) c.this.A1(d.c.b.f.btn_hide);
                e.p.d.i.c(imageButton, "btn_hide");
                imageButton.setVisibility(8);
                Button button = (Button) c.this.A1(d.c.b.f.btn_exit);
                e.p.d.i.c(button, "btn_exit");
                button.setVisibility(0);
                ProgressBar progressBar = (ProgressBar) c.this.A1(d.c.b.f.action_progress);
                e.p.d.i.c(progressBar, "action_progress");
                progressBar.setVisibility(8);
            }
            c.this.w1(true);
        }
    }

    public static final /* synthetic */ Runnable C1(c cVar) {
        Runnable runnable = cVar.o0;
        if (runnable != null) {
            return runnable;
        }
        e.p.d.i.l("onExit");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L1() {
        try {
            s1();
        } catch (Exception unused) {
        }
    }

    private final ShellHandlerBase M1(RunnableNode runnableNode) {
        e.p.d.n nVar = new e.p.d.n();
        nVar.element = null;
        ((ImageButton) A1(d.c.b.f.btn_hide)).setOnClickListener(new d());
        ((Button) A1(d.c.b.f.btn_exit)).setOnClickListener(new e(nVar));
        ((Button) A1(d.c.b.f.btn_copy)).setOnClickListener(new f());
        if (runnableNode.getInterruptable()) {
            ImageButton imageButton = (ImageButton) A1(d.c.b.f.btn_hide);
            if (imageButton != null) {
                imageButton.setVisibility(0);
            }
            Button button = (Button) A1(d.c.b.f.btn_exit);
            if (button != null) {
                button.setVisibility(0);
            }
        } else {
            ImageButton imageButton2 = (ImageButton) A1(d.c.b.f.btn_hide);
            if (imageButton2 != null) {
                imageButton2.setVisibility(8);
            }
            Button button2 = (Button) A1(d.c.b.f.btn_exit);
            if (button2 != null) {
                button2.setVisibility(8);
            }
        }
        if (runnableNode.getTitle().length() == 0) {
            TextView textView = (TextView) A1(d.c.b.f.title);
            e.p.d.i.c(textView, "title");
            textView.setVisibility(8);
        } else {
            TextView textView2 = (TextView) A1(d.c.b.f.title);
            e.p.d.i.c(textView2, "title");
            textView2.setText(runnableNode.getTitle());
        }
        if (runnableNode.getDesc().length() == 0) {
            TextView textView3 = (TextView) A1(d.c.b.f.desc);
            e.p.d.i.c(textView3, "desc");
            textView3.setVisibility(8);
        } else {
            TextView textView4 = (TextView) A1(d.c.b.f.desc);
            e.p.d.i.c(textView4, "desc");
            textView4.setText(runnableNode.getDesc());
        }
        ProgressBar progressBar = (ProgressBar) A1(d.c.b.f.action_progress);
        e.p.d.i.c(progressBar, "action_progress");
        progressBar.setIndeterminate(true);
        g gVar = new g(runnableNode, nVar);
        TextView textView5 = (TextView) A1(d.c.b.f.shell_output);
        e.p.d.i.c(textView5, "shell_output");
        ProgressBar progressBar2 = (ProgressBar) A1(d.c.b.f.action_progress);
        e.p.d.i.c(progressBar2, "action_progress");
        return new HandlerC0115c(gVar, textView5, progressBar2);
    }

    public View A1(int i) {
        if (this.u0 == null) {
            this.u0 = new HashMap();
        }
        View view = (View) this.u0.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View P = P();
        if (P == null) {
            return null;
        }
        View findViewById = P.findViewById(i);
        this.u0.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // androidx.fragment.app.Fragment
    public void E0(View view, Bundle bundle) {
        Dialog u1;
        Window window;
        e.p.d.i.d(view, "view");
        super.E0(view, bundle);
        androidx.fragment.app.d n = n();
        if (n == null || (u1 = u1()) == null || (window = u1.getWindow()) == null) {
            return;
        }
        com.omarea.common.ui.e.f1255b.s(window, n);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void Z(Bundle bundle) {
        super.Z(bundle);
        RunnableNode runnableNode = this.n0;
        if (runnableNode == null) {
            s1();
            return;
        }
        if (runnableNode != null) {
            if (runnableNode.getReloadPage()) {
                ImageButton imageButton = (ImageButton) A1(d.c.b.f.btn_hide);
                e.p.d.i.c(imageButton, "btn_hide");
                imageButton.setVisibility(8);
            }
            ShellHandlerBase M1 = M1(runnableNode);
            if (M1 != null) {
                d.c.b.n.c cVar = new d.c.b.n.c();
                androidx.fragment.app.d n = n();
                String str = this.p0;
                if (str == null) {
                    e.p.d.i.l("script");
                    throw null;
                }
                Runnable runnable = this.o0;
                if (runnable != null) {
                    cVar.b(n, runnableNode, str, runnable, this.q0, M1);
                } else {
                    e.p.d.i.l("onExit");
                    throw null;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View j0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        e.p.d.i.d(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(d.c.b.g.kr_dialog_log, viewGroup);
        e.p.d.i.c(inflate, "inflater.inflate(R.layou…kr_dialog_log, container)");
        this.s0 = inflate;
        if (inflate != null) {
            return inflate;
        }
        e.p.d.i.l("currentView");
        throw null;
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public /* synthetic */ void m0() {
        super.m0();
        z1();
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        e.p.d.i.d(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        Runnable runnable = this.t0;
        if (runnable != null) {
            runnable.run();
        }
        this.t0 = null;
    }

    @Override // androidx.fragment.app.c
    public Dialog v1(Bundle bundle) {
        androidx.fragment.app.d n = n();
        e.p.d.i.b(n);
        int i = this.r0;
        if (i == 0) {
            i = d.c.b.i.kr_full_screen_dialog_light;
        }
        return new Dialog(n, i);
    }

    public void z1() {
        HashMap hashMap = this.u0;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
