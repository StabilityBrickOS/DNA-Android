package d.c.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import com.omarea.krscript.model.NodeInfoBase;
import d.c.b.p.r;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class k {
    private WebView a;

    /* renamed from: b, reason: collision with root package name */
    private Context f1391b;

    /* renamed from: c, reason: collision with root package name */
    private r.a f1392c;

    /* loaded from: classes.dex */
    class a implements DownloadListener {
        final /* synthetic */ Activity a;

        /* renamed from: d.c.b.k$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class DialogInterfaceOnClickListenerC0098a implements DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC0098a(a aVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* loaded from: classes.dex */
        class b implements DialogInterface.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f1394e;
            final /* synthetic */ String f;
            final /* synthetic */ String g;

            b(String str, String str2, String str3) {
                this.f1394e = str;
                this.f = str2;
                this.g = str3;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                new d.c.b.m.a(k.this.f1391b, null).b(this.f1394e, this.f, this.g, UUID.randomUUID().toString());
            }
        }

        a(Activity activity) {
            this.a = activity;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (Build.VERSION.SDK_INT >= 23 && k.this.f1391b.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
                this.a.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 2);
                Toast.makeText(k.this.f1391b, h.kr_write_external_storage, 1).show();
                return;
            }
            com.omarea.common.ui.e.f1255b.c(new AlertDialog.Builder(k.this.f1391b).setTitle(h.kr_download_confirm).setMessage("" + str + "\n\n" + str4 + "\n" + j + "Bytes").setPositiveButton(h.btn_confirm, new b(str, str3, str4)).setNegativeButton(h.btn_cancel, new DialogInterfaceOnClickListenerC0098a(this))).e(false);
        }
    }

    /* loaded from: classes.dex */
    private class b {
        private Context a;

        /* renamed from: b, reason: collision with root package name */
        private NodeInfoBase f1395b;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        /* renamed from: d.c.b.k$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0099b implements r.b {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f1397b;

            /* renamed from: d.c.b.k$b$b$a */
            /* loaded from: classes.dex */
            class a implements Runnable {

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ JSONObject f1399e;

                /* renamed from: d.c.b.k$b$b$a$a, reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class C0100a implements ValueCallback<String> {
                    C0100a(a aVar) {
                    }

                    @Override // android.webkit.ValueCallback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onReceiveValue(String str) {
                    }
                }

                a(JSONObject jSONObject) {
                    this.f1399e = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    k.this.a.evaluateJavascript(C0099b.this.f1397b + "(" + this.f1399e.toString() + ")", new C0100a(this));
                }
            }

            C0099b(String str) {
                this.f1397b = str;
            }

            @Override // d.c.b.p.r.b
            public void a(String str) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (str != null && !str.isEmpty()) {
                        jSONObject.put("absPath", str);
                        k.this.a.post(new a(jSONObject));
                    }
                    jSONObject.put("absPath", (Object) null);
                    k.this.a.post(new a(jSONObject));
                } catch (Exception unused) {
                }
            }

            @Override // d.c.b.p.r.b
            public String b() {
                return "*/*";
            }

            @Override // d.c.b.p.r.b
            public String c() {
                return null;
            }

            @Override // d.c.b.p.r.b
            public int d() {
                return r.b.a.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ InputStream f1400e;
            final /* synthetic */ String f;

            /* loaded from: classes.dex */
            class a implements Runnable {

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ JSONObject f1401e;

                /* renamed from: d.c.b.k$b$c$a$a, reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class C0101a implements ValueCallback<String> {
                    C0101a(a aVar) {
                    }

                    @Override // android.webkit.ValueCallback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onReceiveValue(String str) {
                    }
                }

                a(JSONObject jSONObject) {
                    this.f1401e = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    k.this.a.evaluateJavascript(c.this.f + "(" + this.f1401e.toString() + ")", new C0101a(this));
                }
            }

            c(InputStream inputStream, String str) {
                this.f1400e = inputStream;
                this.f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f1400e, "UTF-8"));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("type", 2);
                            jSONObject.put("message", readLine + "\n");
                            k.this.a.post(new a(jSONObject));
                        } catch (Exception unused) {
                        }
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class d implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ InputStream f1402e;
            final /* synthetic */ String f;

            /* loaded from: classes.dex */
            class a implements Runnable {

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ JSONObject f1403e;

                /* renamed from: d.c.b.k$b$d$a$a, reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class C0102a implements ValueCallback<String> {
                    C0102a(a aVar) {
                    }

                    @Override // android.webkit.ValueCallback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onReceiveValue(String str) {
                    }
                }

                a(JSONObject jSONObject) {
                    this.f1403e = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    k.this.a.evaluateJavascript(d.this.f + "(" + this.f1403e.toString() + ")", new C0102a(this));
                }
            }

            d(InputStream inputStream, String str) {
                this.f1402e = inputStream;
                this.f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f1402e, "UTF-8"));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("type", 4);
                            jSONObject.put("message", readLine + "\n");
                            k.this.a.post(new a(jSONObject));
                        } catch (Exception unused) {
                        }
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class e implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Process f1404e;
            final /* synthetic */ String f;
            final /* synthetic */ Thread g;
            final /* synthetic */ Thread h;
            final /* synthetic */ Runnable i;

            /* loaded from: classes.dex */
            class a implements Runnable {

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ JSONObject f1405e;

                /* renamed from: d.c.b.k$b$e$a$a, reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class C0103a implements ValueCallback<String> {
                    C0103a(a aVar) {
                    }

                    @Override // android.webkit.ValueCallback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onReceiveValue(String str) {
                    }
                }

                a(JSONObject jSONObject) {
                    this.f1405e = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    k.this.a.evaluateJavascript(e.this.f + "(" + this.f1405e.toString() + ")", new C0103a(this));
                }
            }

            e(Process process, String str, Thread thread, Thread thread2, Runnable runnable) {
                this.f1404e = process;
                this.f = str;
                this.g = thread;
                this.h = thread2;
                this.i = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable;
                try {
                    try {
                        int waitFor = this.f1404e.waitFor();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("type", -2);
                            jSONObject.put("message", "" + waitFor);
                            k.this.a.post(new a(jSONObject));
                        } catch (Exception unused) {
                        }
                        if (this.g.isAlive()) {
                            this.g.interrupt();
                        }
                        if (this.h.isAlive()) {
                            this.h.interrupt();
                        }
                        runnable = this.i;
                        if (runnable == null) {
                            return;
                        }
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("type", -2);
                            jSONObject2.put("message", "-1");
                            k.this.a.post(new a(jSONObject2));
                        } catch (Exception unused2) {
                        }
                        if (this.g.isAlive()) {
                            this.g.interrupt();
                        }
                        if (this.h.isAlive()) {
                            this.h.interrupt();
                        }
                        runnable = this.i;
                        if (runnable == null) {
                            return;
                        }
                    }
                    runnable.run();
                } catch (Throwable th) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("type", -2);
                        jSONObject3.put("message", "-1");
                        k.this.a.post(new a(jSONObject3));
                    } catch (Exception unused3) {
                    }
                    if (this.g.isAlive()) {
                        this.g.interrupt();
                    }
                    if (this.h.isAlive()) {
                        this.h.interrupt();
                    }
                    Runnable runnable2 = this.i;
                    if (runnable2 == null) {
                        throw th;
                    }
                    runnable2.run();
                    throw th;
                }
            }
        }

        private b(Context context) {
            this.f1395b = new NodeInfoBase("");
            this.a = context;
        }

        /* synthetic */ b(k kVar, Context context, a aVar) {
            this(context);
        }

        private void a(Process process, String str, Runnable runnable) {
            InputStream inputStream = process.getInputStream();
            InputStream errorStream = process.getErrorStream();
            Thread thread = new Thread(new c(inputStream, str));
            Thread thread2 = new Thread(new d(errorStream, str));
            Thread thread3 = new Thread(new e(process, str, thread, thread2, runnable));
            thread.start();
            thread2.start();
            thread3.start();
        }

        @JavascriptInterface
        public String executeShell(String str) {
            return (str == null || str.isEmpty()) ? "" : d.c.b.n.b.b(this.a, str, this.f1395b);
        }

        @JavascriptInterface
        public boolean executeShellAsync(String str, String str2, String str3) {
            Process process;
            HashMap hashMap = new HashMap();
            if (str3 != null) {
                try {
                    if (!str3.isEmpty()) {
                        JSONObject jSONObject = new JSONObject(str3);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, jSONObject.getString(next));
                        }
                    }
                } catch (Exception e2) {
                    Toast.makeText(this.a, e2.getMessage(), 0).show();
                    process = null;
                }
            }
            process = d.c.a.g.e.d();
            if (process == null) {
                return false;
            }
            DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
            a(process, str2, new a(this));
            d.c.b.n.b.c(this.a, dataOutputStream, str, hashMap, null, null);
            return true;
        }

        @JavascriptInterface
        public String extractAssets(String str) {
            return new d.c.b.n.a(this.a).a(str);
        }

        @JavascriptInterface
        public boolean fileChooser(String str) {
            if (k.this.f1392c != null) {
                return k.this.f1392c.openFileChooser(new C0099b(str));
            }
            return false;
        }

        @JavascriptInterface
        public boolean rootCheck() {
            return d.c.a.g.b.f1379c.a();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public k(WebView webView, r.a aVar) {
        this.a = webView;
        this.f1391b = webView.getContext();
        this.f1392c = aVar;
    }

    @SuppressLint({"JavascriptInterface", "SetJavaScriptEnabled"})
    public void d(Activity activity, boolean z) {
        WebView webView = this.a;
        if (webView != null) {
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAllowFileAccess(z);
            settings.setAllowUniversalAccessFromFileURLs(z);
            settings.setAllowFileAccessFromFileURLs(z);
            settings.setAllowContentAccess(true);
            settings.setUseWideViewPort(true);
            this.a.addJavascriptInterface(new b(this, this.f1391b, null), "KrScriptCore");
            this.a.setDownloadListener(new a(activity));
        }
    }
}
