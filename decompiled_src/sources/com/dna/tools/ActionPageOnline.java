package com.dna.tools;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.omarea.common.ui.e;
import d.c.b.k;
import d.c.b.p.r;
import e.p.d.n;
import e.u.u;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public final class ActionPageOnline extends androidx.appcompat.app.c {
    private Timer A;
    private HashMap B;
    private com.omarea.common.ui.i x;
    private r.b y;
    private final com.omarea.common.ui.h w = new com.omarea.common.ui.h(this, null, 2, null);
    private final int z = 65400;

    /* loaded from: classes.dex */
    public static final class a extends WebChromeClient {

        /* renamed from: com.dna.tools.ActionPageOnline$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class DialogInterfaceOnClickListenerC0052a implements DialogInterface.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            public static final DialogInterfaceOnClickListenerC0052a f948e = new DialogInterfaceOnClickListenerC0052a();

            DialogInterfaceOnClickListenerC0052a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* loaded from: classes.dex */
        static final class b implements DialogInterface.OnDismissListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ JsResult f949e;

            b(JsResult jsResult) {
                this.f949e = jsResult;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                JsResult jsResult = this.f949e;
                if (jsResult != null) {
                    jsResult.confirm();
                }
            }
        }

        /* loaded from: classes.dex */
        static final class c implements DialogInterface.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ JsResult f950e;

            c(JsResult jsResult) {
                this.f950e = jsResult;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                JsResult jsResult = this.f950e;
                if (jsResult != null) {
                    jsResult.confirm();
                }
            }
        }

        /* loaded from: classes.dex */
        static final class d implements DialogInterface.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ JsResult f951e;

            d(JsResult jsResult) {
                this.f951e = jsResult;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                JsResult jsResult = this.f951e;
                if (jsResult != null) {
                    jsResult.cancel();
                }
            }
        }

        a() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            e.c d2 = com.omarea.common.ui.e.f1255b.d(new AlertDialog.Builder(ActionPageOnline.this).setMessage(str2).setPositiveButton(R.string.btn_confirm, DialogInterfaceOnClickListenerC0052a.f948e).setOnDismissListener(new b(jsResult)).create());
            if (d2 == null) {
                return true;
            }
            d2.e(false);
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            e.c d2 = com.omarea.common.ui.e.f1255b.d(new AlertDialog.Builder(ActionPageOnline.this).setMessage(str2).setPositiveButton(R.string.btn_confirm, new c(jsResult)).setNeutralButton(R.string.btn_cancel, new d(jsResult)).create());
            if (d2 == null) {
                return true;
            }
            d2.e(false);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            ActionPageOnline.this.w.a();
            if (webView != null) {
                ActionPageOnline.this.setTitle(webView.getTitle());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            com.omarea.common.ui.h hVar = ActionPageOnline.this.w;
            String string = ActionPageOnline.this.getString(R.string.please_wait);
            e.p.d.i.c(string, "getString(R.string.please_wait)");
            hVar.b(string);
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
        
            if (r0 != true) goto L11;
         */
        @Override // android.webkit.WebViewClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean shouldOverrideUrlLoading(android.webkit.WebView r8, android.webkit.WebResourceRequest r9) {
            /*
                r7 = this;
                r0 = 0
                if (r9 == 0) goto L8
                android.net.Uri r1 = r9.getUrl()     // Catch: java.lang.Exception -> L36
                goto L9
            L8:
                r1 = r0
            L9:
                if (r1 == 0) goto L31
                java.lang.String r2 = r1.getScheme()     // Catch: java.lang.Exception -> L36
                r3 = 1
                if (r2 == 0) goto L1c
                java.lang.String r4 = "http"
                r5 = 0
                r6 = 2
                boolean r0 = e.u.l.k(r2, r4, r5, r6, r0)     // Catch: java.lang.Exception -> L36
                if (r0 == r3) goto L31
            L1c:
                android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Exception -> L36
                java.lang.String r2 = "android.intent.action.VIEW"
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L36
                android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Exception -> L36
                r0.<init>(r2, r1)     // Catch: java.lang.Exception -> L36
                com.dna.tools.ActionPageOnline r1 = com.dna.tools.ActionPageOnline.this     // Catch: java.lang.Exception -> L36
                r1.startActivity(r0)     // Catch: java.lang.Exception -> L36
                return r3
            L31:
                boolean r8 = super.shouldOverrideUrlLoading(r8, r9)     // Catch: java.lang.Exception -> L36
                return r8
            L36:
                boolean r8 = super.shouldOverrideUrlLoading(r8, r9)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dna.tools.ActionPageOnline.b.shouldOverrideUrlLoading(android.webkit.WebView, android.webkit.WebResourceRequest):boolean");
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements r.a {
        c() {
        }

        @Override // d.c.b.p.r.a
        public boolean openFileChooser(r.b bVar) {
            e.p.d.i.d(bVar, "fileSelectedInterface");
            return ActionPageOnline.this.K(bVar);
        }
    }

    /* loaded from: classes.dex */
    static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActionPageOnline.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Object systemService = ActionPageOnline.this.getSystemService("clipboard");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
            }
            TextView textView = (TextView) ActionPageOnline.this.G(com.dna.tools.g.kr_download_name);
            e.p.d.i.c(textView, "kr_download_name");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("text", textView.getText().toString()));
            ActionPageOnline actionPageOnline = ActionPageOnline.this;
            Toast.makeText(actionPageOnline, actionPageOnline.getString(R.string.copy_success), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Object systemService = ActionPageOnline.this.getSystemService("clipboard");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
            }
            TextView textView = (TextView) ActionPageOnline.this.G(com.dna.tools.g.kr_download_url);
            e.p.d.i.c(textView, "kr_download_url");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("text", textView.getText().toString()));
            ActionPageOnline actionPageOnline = ActionPageOnline.this;
            Toast.makeText(actionPageOnline, actionPageOnline.getString(R.string.copy_success), 0).show();
        }
    }

    /* loaded from: classes.dex */
    public static final class g extends TimerTask {
        final /* synthetic */ DownloadManager f;
        final /* synthetic */ DownloadManager.Query g;
        final /* synthetic */ Handler h;
        final /* synthetic */ d.c.b.m.a i;
        final /* synthetic */ String j;
        final /* synthetic */ long k;
        final /* synthetic */ boolean l;

        /* loaded from: classes.dex */
        static final class a implements Runnable {
            final /* synthetic */ n f;
            final /* synthetic */ int g;

            a(n nVar, int i) {
                this.f = nVar;
                this.g = i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                TextView textView = (TextView) ActionPageOnline.this.G(com.dna.tools.g.kr_download_name);
                e.p.d.i.c(textView, "kr_download_name");
                textView.setText((String) this.f.element);
                ProgressBar progressBar = (ProgressBar) ActionPageOnline.this.G(com.dna.tools.g.kr_download_progress);
                e.p.d.i.c(progressBar, "kr_download_progress");
                progressBar.setProgress(this.g);
                ProgressBar progressBar2 = (ProgressBar) ActionPageOnline.this.G(com.dna.tools.g.kr_download_progress);
                e.p.d.i.c(progressBar2, "kr_download_progress");
                progressBar2.setIndeterminate(false);
                ActionPageOnline.this.setTitle(R.string.kr_download_downloading);
                g gVar = g.this;
                gVar.i.d(gVar.j, this.g);
            }
        }

        /* loaded from: classes.dex */
        static final class b implements Runnable {
            final /* synthetic */ n f;

            b(n nVar) {
                this.f = nVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                ActionPageOnline.this.setTitle(R.string.kr_download_completed);
                ProgressBar progressBar = (ProgressBar) ActionPageOnline.this.G(com.dna.tools.g.kr_download_progress);
                e.p.d.i.c(progressBar, "kr_download_progress");
                progressBar.setVisibility(8);
                ActionPageOnline.this.P();
                Intent intent = new Intent();
                intent.putExtra("absPath", (String) this.f.element);
                ActionPageOnline.this.setResult(0, intent);
                g gVar = g.this;
                if (gVar.l) {
                    ActionPageOnline.this.finish();
                }
            }
        }

        g(DownloadManager downloadManager, DownloadManager.Query query, Handler handler, d.c.b.m.a aVar, String str, long j, boolean z) {
            this.f = downloadManager;
            this.g = query;
            this.h = handler;
            this.i = aVar;
            this.j = str;
            this.k = j;
            this.l = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.String] */
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Cursor query = this.f.query(this.g);
            n nVar = new n();
            nVar.element = "";
            n nVar2 = new n();
            nVar2.element = "";
            if (query.moveToFirst()) {
                int i = (int) ((query.getLong(query.getColumnIndexOrThrow("bytes_so_far")) * 100) / query.getLong(query.getColumnIndexOrThrow("total_size")));
                boolean z = true;
                if (((String) nVar.element).length() == 0) {
                    try {
                        ?? string = query.getString(query.getColumnIndexOrThrow("local_uri"));
                        e.p.d.i.c(string, "cursor.getString(nameColumn)");
                        nVar.element = string;
                        ?? b2 = new d.c.a.f.a().b(ActionPageOnline.this, Uri.parse((String) nVar.element));
                        e.p.d.i.c(b2, "FilePathResolver().getPa…ine, Uri.parse(fileName))");
                        nVar2.element = b2;
                        if (((String) b2).length() != 0) {
                            z = false;
                        }
                        if (!z) {
                            nVar.element = (String) nVar2.element;
                        }
                    } catch (Exception unused) {
                    }
                }
                this.h.post(new a(nVar, i));
                if (i >= 100) {
                    this.i.c(this.k, (String) nVar2.element);
                    this.h.post(new b(nVar2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean K(r.b bVar) {
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 2);
            Toast.makeText(this, getString(R.string.kr_write_external_storage), 1).show();
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("*/*");
            intent.addCategory("android.intent.category.OPENABLE");
            startActivityForResult(intent, this.z);
            this.y = bVar;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private final String L(Uri uri) {
        try {
            return new d.c.a.f.a().b(this, uri);
        } catch (Exception unused) {
            return null;
        }
    }

    private final void M(String str) {
        boolean k;
        WebView webView = (WebView) G(com.dna.tools.g.kr_online_webview);
        e.p.d.i.c(webView, "kr_online_webview");
        boolean z = false;
        webView.setVisibility(0);
        WebView webView2 = (WebView) G(com.dna.tools.g.kr_online_webview);
        e.p.d.i.c(webView2, "kr_online_webview");
        webView2.setWebChromeClient(new a());
        WebView webView3 = (WebView) G(com.dna.tools.g.kr_online_webview);
        e.p.d.i.c(webView3, "kr_online_webview");
        webView3.setWebViewClient(new b());
        ((WebView) G(com.dna.tools.g.kr_online_webview)).loadUrl(str);
        k kVar = new k((WebView) G(com.dna.tools.g.kr_online_webview), new c());
        if (str != null) {
            k = u.k(str, "file:///android_asset", false, 2, null);
            if (k) {
                z = true;
            }
        }
        kVar.d(this, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0040, code lost:
    
        if (r0.containsKey("url") != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void N() {
        /*
            r12 = this;
            android.content.Intent r0 = r12.getIntent()
            java.lang.String r1 = "intent"
            e.p.d.i.c(r0, r1)
            android.os.Bundle r1 = r0.getExtras()
            if (r1 == 0) goto Le0
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto Le0
            java.lang.String r1 = "title"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L27
            java.lang.String r1 = r0.getString(r1)
            e.p.d.i.b(r1)
            r12.setTitle(r1)
        L27:
            r12.O()
            java.lang.String r1 = "config"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L3a
        L32:
            java.lang.String r1 = r0.getString(r1)
            r12.M(r1)
            goto L43
        L3a:
            java.lang.String r1 = "url"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L43
            goto L32
        L43:
            java.lang.String r1 = "downloadUrl"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto Le0
            d.c.b.m.a r2 = new d.c.b.m.a
            r3 = 0
            r4 = 2
            r2.<init>(r12, r3, r4, r3)
            java.lang.String r1 = r0.getString(r1)
            e.p.d.i.b(r1)
            java.lang.String r5 = "taskId"
            boolean r6 = r0.containsKey(r5)
            if (r6 == 0) goto L66
            java.lang.String r5 = r0.getString(r5)
            goto L6e
        L66:
            java.util.UUID r5 = java.util.UUID.randomUUID()
            java.lang.String r5 = r5.toString()
        L6e:
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 23
            java.lang.String r8 = "taskAliasId"
            r9 = 0
            if (r6 < r7) goto La7
            java.lang.String r6 = "android.permission.READ_EXTERNAL_STORAGE"
            int r7 = r12.checkSelfPermission(r6)
            if (r7 == 0) goto La7
            e.p.d.i.c(r5, r8)
            r2.d(r5, r9)
            java.lang.String r0 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String[] r0 = new java.lang.String[]{r6, r0}
            r12.requestPermissions(r0, r4)
            com.omarea.common.ui.e$a r5 = com.omarea.common.ui.e.f1255b
            r0 = 2131689585(0x7f0f0071, float:1.900819E38)
            java.lang.String r8 = r12.getString(r0)
            java.lang.String r0 = "getString(R.string.kr_write_external_storage)"
            e.p.d.i.c(r8, r0)
            r9 = 0
            r10 = 8
            r11 = 0
            java.lang.String r7 = ""
            r6 = r12
            com.omarea.common.ui.e.a.o(r5, r6, r7, r8, r9, r10, r11)
            goto Le0
        La7:
            e.p.d.i.c(r5, r8)
            java.lang.Long r3 = r2.b(r1, r3, r3, r5)
            if (r3 == 0) goto Ldc
            int r4 = com.dna.tools.g.kr_download_url
            android.view.View r4 = r12.G(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r6 = "kr_download_url"
            e.p.d.i.c(r4, r6)
            r4.setText(r1)
            java.lang.String r1 = "autoClose"
            boolean r4 = r0.containsKey(r1)
            if (r4 == 0) goto Ld0
            boolean r0 = r0.getBoolean(r1)
            if (r0 == 0) goto Ld0
            r0 = 1
            goto Ld1
        Ld0:
            r0 = 0
        Ld1:
            r2.d(r5, r9)
            long r1 = r3.longValue()
            r12.Q(r1, r0, r5)
            goto Le0
        Ldc:
            r0 = -1
            r2.d(r5, r0)
        Le0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dna.tools.ActionPageOnline.N():void");
    }

    private final void O() {
        int i;
        Window window = getWindow();
        window.clearFlags(67108864);
        e.p.d.i.c(window, "window");
        View decorView = window.getDecorView();
        e.p.d.i.c(decorView, "window.decorView");
        decorView.setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        com.omarea.common.ui.i iVar = this.x;
        if (iVar == null) {
            e.p.d.i.l("themeMode");
            throw null;
        }
        if (!iVar.a()) {
            window.setStatusBarColor(-1);
            window.setNavigationBarColor(-1);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 26) {
                i = 9232;
            } else if (i2 >= 23) {
                i = 9216;
            }
            Window window2 = getWindow();
            e.p.d.i.c(window2, "getWindow()");
            View decorView2 = window2.getDecorView();
            e.p.d.i.c(decorView2, "getWindow().decorView");
            decorView2.setSystemUiVisibility(i);
            RelativeLayout relativeLayout = (RelativeLayout) G(com.dna.tools.g.kr_online_root);
            e.p.d.i.c(relativeLayout, "kr_online_root");
            relativeLayout.setFitsSystemWindows(true);
        }
        i = 1024;
        Window window22 = getWindow();
        e.p.d.i.c(window22, "getWindow()");
        View decorView22 = window22.getDecorView();
        e.p.d.i.c(decorView22, "getWindow().decorView");
        decorView22.setSystemUiVisibility(i);
        RelativeLayout relativeLayout2 = (RelativeLayout) G(com.dna.tools.g.kr_online_root);
        e.p.d.i.c(relativeLayout2, "kr_online_root");
        relativeLayout2.setFitsSystemWindows(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        Timer timer = this.A;
        if (timer != null) {
            if (timer != null) {
                timer.cancel();
            }
            this.A = null;
        }
    }

    private final void Q(long j, boolean z, String str) {
        LinearLayout linearLayout = (LinearLayout) G(com.dna.tools.g.kr_download_state);
        e.p.d.i.c(linearLayout, "kr_download_state");
        linearLayout.setVisibility(0);
        Object systemService = getSystemService("download");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.DownloadManager");
        }
        DownloadManager.Query filterById = new DownloadManager.Query().setFilterById(j);
        ((ImageButton) G(com.dna.tools.g.kr_download_name_copy)).setOnClickListener(new e());
        ((ImageButton) G(com.dna.tools.g.kr_download_url_copy)).setOnClickListener(new f());
        Handler handler = new Handler();
        d.c.b.m.a aVar = new d.c.b.m.a(this, null, 2, null);
        Timer timer = new Timer();
        this.A = timer;
        timer.schedule(new g((DownloadManager) systemService, filterById, handler, aVar, str, j, z), 200L, 500L);
    }

    public View G(int i) {
        if (this.B == null) {
            this.B = new HashMap();
        }
        View view = (View) this.B.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.B.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == this.z) {
            Uri data = (intent == null || i2 != -1) ? null : intent.getData();
            r.b bVar = this.y;
            if (bVar != null) {
                if (data != null) {
                    String L = L(data);
                    r.b bVar2 = this.y;
                    if (bVar2 != null) {
                        bVar2.a(L);
                    }
                } else if (bVar != null) {
                    bVar.a(null);
                }
            }
            this.y = null;
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.x = j.f999b.c(this);
        setContentView(R.layout.activity_action_page_online);
        View findViewById = findViewById(R.id.toolbar);
        if (findViewById == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        }
        Toolbar toolbar = (Toolbar) findViewById;
        D(toolbar);
        setTitle(R.string.app_name);
        androidx.appcompat.app.a w = w();
        e.p.d.i.b(w);
        w.t(true);
        androidx.appcompat.app.a w2 = w();
        e.p.d.i.b(w2);
        w2.s(true);
        toolbar.setNavigationOnClickListener(new d());
        N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, android.app.Activity
    public void onDestroy() {
        P();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !((WebView) G(com.dna.tools.g.kr_online_webview)).canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        ((WebView) G(com.dna.tools.g.kr_online_webview)).goBack();
        return true;
    }
}
