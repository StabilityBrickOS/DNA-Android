package com.dna.tools;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.omarea.krscript.model.ActionNode;
import com.omarea.krscript.model.AutoRunTask;
import com.omarea.krscript.model.ClickableNode;
import com.omarea.krscript.model.KrScriptActionHandler;
import com.omarea.krscript.model.PageMenuOption;
import com.omarea.krscript.model.PageNode;
import com.omarea.krscript.model.RunnableNode;
import d.c.b.p.c;
import d.c.b.p.m;
import d.c.b.p.r;
import e.p.d.n;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class ActionPage extends androidx.appcompat.app.c {
    private r.b C;
    private ArrayList<PageMenuOption> F;
    private HashMap G;
    private boolean x;
    private PageNode z;
    private final com.omarea.common.ui.h w = new com.omarea.common.ui.h(this, null, 2, null);
    private Handler y = new Handler();
    private String A = "";
    private a B = new a();
    private final int D = 65400;
    private final int E = 65300;

    /* loaded from: classes.dex */
    public static final class a implements KrScriptActionHandler {
        a() {
        }

        @Override // com.omarea.krscript.model.KrScriptActionHandler
        public void addToFavorites(ClickableNode clickableNode, KrScriptActionHandler.AddToFavoritesHandler addToFavoritesHandler) {
            PageNode M;
            e.p.d.i.d(clickableNode, "clickableNode");
            e.p.d.i.d(addToFavoritesHandler, "addToFavoritesHandler");
            if (clickableNode instanceof PageNode) {
                M = (PageNode) clickableNode;
            } else if (!(clickableNode instanceof RunnableNode)) {
                return;
            } else {
                M = ActionPage.M(ActionPage.this);
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(ActionPage.this.getApplicationContext(), (Class<?>) ActionPage.class));
            intent.addFlags(8388608);
            intent.addFlags(1073741824);
            if (clickableNode instanceof RunnableNode) {
                intent.putExtra("autoRunItemId", clickableNode.getKey());
            }
            intent.putExtra("page", M);
            addToFavoritesHandler.onAddToFavorites(clickableNode, intent);
        }

        @Override // com.omarea.krscript.model.KrScriptActionHandler
        public void onActionCompleted(RunnableNode runnableNode) {
            e.p.d.i.d(runnableNode, "runnableNode");
            if (runnableNode.getAutoFinish()) {
                ActionPage.this.finishAndRemoveTask();
            } else if (runnableNode.getReloadPage()) {
                ActionPage.this.b0();
            }
        }

        @Override // com.omarea.krscript.model.KrScriptActionHandler
        public void onSubPageClick(PageNode pageNode) {
            e.p.d.i.d(pageNode, "pageNode");
            ActionPage.this.H(pageNode);
        }

        @Override // com.omarea.krscript.model.KrScriptActionHandler
        public boolean openFileChooser(r.b bVar) {
            e.p.d.i.d(bVar, "fileSelectedInterface");
            return ActionPage.this.X(bVar);
        }

        @Override // com.omarea.krscript.model.KrScriptActionHandler
        public boolean openParamsPage(ActionNode actionNode, View view, Runnable runnable) {
            e.p.d.i.d(actionNode, "actionNode");
            e.p.d.i.d(view, "view");
            e.p.d.i.d(runnable, "onCompleted");
            return KrScriptActionHandler.DefaultImpls.openParamsPage(this, actionNode, view, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b implements View.OnClickListener {
        final /* synthetic */ PageMenuOption f;

        b(PageMenuOption pageMenuOption) {
            this.f = pageMenuOption;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActionPage.this.e0(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionPage.this.w.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d implements Runnable {
        final /* synthetic */ ActionPage f;

        /* loaded from: classes.dex */
        static final class a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ n f938e;
            final /* synthetic */ d f;

            /* renamed from: com.dna.tools.ActionPage$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0051a implements AutoRunTask {
                private final String a;

                C0051a() {
                    this.a = ActionPage.this.A;
                }

                @Override // com.omarea.krscript.model.AutoRunTask
                public String getKey() {
                    return this.a;
                }

                @Override // com.omarea.krscript.model.AutoRunTask
                public void onCompleted(Boolean bool) {
                    if (!e.p.d.i.a(bool, Boolean.TRUE)) {
                        ActionPage actionPage = ActionPage.this;
                        Toast.makeText(actionPage, actionPage.getString(R.string.kr_auto_run_item_losted), 0).show();
                    }
                }
            }

            a(n nVar, d dVar) {
                this.f938e = nVar;
                this.f = dVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                d.c.b.p.a a = d.c.b.p.a.j0.a((ArrayList) this.f938e.element, ActionPage.this.B, ActionPage.this.x ? null : new C0051a(), j.f999b.b());
                androidx.fragment.app.n a2 = ActionPage.this.o().a();
                a2.h(R.id.main_list, a);
                a2.e();
                ActionPage.this.a0();
                ActionPage.this.x = true;
            }
        }

        /* loaded from: classes.dex */
        static final class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ActionPage actionPage = ActionPage.this;
                Toast.makeText(actionPage, actionPage.getString(R.string.kr_page_load_fail), 0).show();
            }
        }

        d(ActionPage actionPage) {
            this.f = actionPage;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v27, types: [T, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r4v30, types: [T, java.util.ArrayList] */
        @Override // java.lang.Runnable
        public final void run() {
            PageNode M = ActionPage.M(ActionPage.this);
            if (M.getBeforeRead().length() > 0) {
                ActionPage actionPage = ActionPage.this;
                String string = actionPage.getString(R.string.kr_page_before_load);
                e.p.d.i.c(string, "getString(R.string.kr_page_before_load)");
                actionPage.g0(string);
                d.c.b.n.b.b(this.f, M.getBeforeRead(), M);
            }
            ActionPage actionPage2 = ActionPage.this;
            String string2 = actionPage2.getString(R.string.kr_page_loading);
            e.p.d.i.c(string2, "getString(R.string.kr_page_loading)");
            actionPage2.g0(string2);
            n nVar = new n();
            nVar.element = null;
            if (M.getPageConfigSh().length() > 0) {
                nVar.element = new d.c.b.l.c(ActionPage.this, M.getPageConfigSh(), M).b();
            }
            if (((ArrayList) nVar.element) == null) {
                if (M.getPageConfigPath().length() > 0) {
                    Context applicationContext = ActionPage.this.getApplicationContext();
                    e.p.d.i.c(applicationContext, "applicationContext");
                    nVar.element = new d.c.b.l.b(applicationContext, M.getPageConfigPath(), M.getPageConfigDir()).i();
                }
            }
            if (M.getAfterRead().length() > 0) {
                ActionPage actionPage3 = ActionPage.this;
                String string3 = actionPage3.getString(R.string.kr_page_after_load);
                e.p.d.i.c(string3, "getString(R.string.kr_page_after_load)");
                actionPage3.g0(string3);
                d.c.b.n.b.b(this.f, M.getAfterRead(), M);
            }
            T t = nVar.element;
            if (((ArrayList) t) != null && ((ArrayList) t).size() != 0) {
                if (M.getLoadSuccess().length() > 0) {
                    ActionPage actionPage4 = ActionPage.this;
                    String string4 = actionPage4.getString(R.string.kr_page_load_success);
                    e.p.d.i.c(string4, "getString(R.string.kr_page_load_success)");
                    actionPage4.g0(string4);
                    d.c.b.n.b.b(this.f, M.getLoadSuccess(), M);
                }
                ActionPage.this.y.post(new a(nVar, this));
                return;
            }
            if (M.getLoadFail().length() > 0) {
                ActionPage actionPage5 = ActionPage.this;
                String string5 = actionPage5.getString(R.string.kr_page_load_fail);
                e.p.d.i.c(string5, "getString(R.string.kr_page_load_fail)");
                actionPage5.g0(string5);
                d.c.b.n.b.b(this.f, M.getLoadFail(), M);
                ActionPage.this.a0();
            }
            ActionPage.this.y.post(new b());
            ActionPage.this.a0();
            ActionPage.this.finish();
        }
    }

    /* loaded from: classes.dex */
    public static final class e implements r.b {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ PageMenuOption f942c;

        /* loaded from: classes.dex */
        static final class a implements Runnable {
            final /* synthetic */ String f;

            a(String str) {
                this.f = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                e eVar = e.this;
                ActionPage actionPage = ActionPage.this;
                PageMenuOption pageMenuOption = eVar.f942c;
                HashMap hashMap = new HashMap();
                hashMap.put("state", e.this.f942c.getKey());
                hashMap.put("menu_id", e.this.f942c.getKey());
                hashMap.put("file", this.f);
                hashMap.put("folder", this.f);
                e.j jVar = e.j.a;
                actionPage.d0(pageMenuOption, hashMap);
            }
        }

        e(PageMenuOption pageMenuOption) {
            this.f942c = pageMenuOption;
        }

        @Override // d.c.b.p.r.b
        public void a(String str) {
            if (str != null) {
                ActionPage.this.y.post(new a(str));
            }
        }

        @Override // d.c.b.p.r.b
        public String b() {
            if (this.f942c.getMime().length() == 0) {
                return null;
            }
            return this.f942c.getMime();
        }

        @Override // d.c.b.p.r.b
        public String c() {
            if (this.f942c.getSuffix().length() == 0) {
                return null;
            }
            return this.f942c.getSuffix();
        }

        @Override // d.c.b.p.r.b
        public int d() {
            String type = this.f942c.getType();
            int hashCode = type.hashCode();
            if (hashCode != -1268966290) {
                if (hashCode == 3143036) {
                    type.equals("file");
                }
            } else if (type.equals("folder")) {
                return r.b.a.b();
            }
            return r.b.a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class f implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public static final f f944e = new f();

        f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class g implements Runnable {
        final /* synthetic */ PageMenuOption f;

        g(PageMenuOption pageMenuOption) {
            this.f = pageMenuOption;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f.getAutoFinish()) {
                ActionPage.this.finish();
            } else if (this.f.getReloadPage()) {
                ActionPage.this.recreate();
            } else {
                this.f.getUpdateBlocks();
            }
        }
    }

    /* loaded from: classes.dex */
    static final class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActionPage.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class i implements Runnable {
        final /* synthetic */ String f;

        i(String str) {
            this.f = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionPage.this.w.b(this.f);
        }
    }

    public static final /* synthetic */ PageNode M(ActionPage actionPage) {
        PageNode pageNode = actionPage.z;
        if (pageNode != null) {
            return pageNode;
        }
        e.p.d.i.l("currentPageConfig");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
    
        if (r7 != null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void V(com.omarea.krscript.model.PageMenuOption r7) {
        /*
            r6 = this;
            int r0 = com.dna.tools.g.action_page_fab
            android.view.View r0 = r6.G(r0)
            com.google.android.material.floatingactionbutton.FloatingActionButton r0 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r0
            r1 = 0
            r0.setVisibility(r1)
            com.dna.tools.ActionPage$b r2 = new com.dna.tools.ActionPage$b
            r2.<init>(r7)
            r0.setOnClickListener(r2)
            java.lang.String r2 = r7.getType()
            java.lang.String r3 = "file"
            boolean r2 = e.p.d.i.a(r2, r3)
            r3 = 1
            if (r2 == 0) goto L3c
            java.lang.String r2 = r7.getIconPath()
            int r2 = r2.length()
            if (r2 != 0) goto L2d
            r2 = 1
            goto L2e
        L2d:
            r2 = 0
        L2e:
            if (r2 == 0) goto L3c
            android.content.Context r7 = r0.getContext()
            r1 = 2131165335(0x7f070097, float:1.7944884E38)
            android.graphics.drawable.Drawable r7 = c.f.d.a.c(r7, r1)
            goto L6a
        L3c:
            java.lang.String r2 = r7.getIconPath()
            int r2 = r2.length()
            if (r2 <= 0) goto L47
            goto L48
        L47:
            r3 = 0
        L48:
            r2 = 2131165334(0x7f070096, float:1.7944882E38)
            if (r3 == 0) goto L62
            d.c.b.l.a r3 = new d.c.b.l.a
            r3.<init>()
            android.content.Context r4 = r0.getContext()
            java.lang.String r5 = "context"
            e.p.d.i.c(r4, r5)
            android.graphics.drawable.Drawable r7 = r3.d(r4, r7, r1)
            if (r7 == 0) goto L62
            goto L6a
        L62:
            android.content.Context r7 = r0.getContext()
            android.graphics.drawable.Drawable r7 = c.f.d.a.c(r7, r2)
        L6a:
            r0.setImageDrawable(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dna.tools.ActionPage.V(com.omarea.krscript.model.PageMenuOption):void");
    }

    private final void W(String str) {
        try {
            Intent intent = new Intent(this, (Class<?>) ActivityFileSelector.class);
            intent.putExtra("extension", str);
            intent.putExtra("mode", ActivityFileSelector.C.a());
            startActivityForResult(intent, this.E);
        } catch (Exception unused) {
            Toast.makeText(this, "Failed to start built-in file selector!", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049 A[Catch: Exception -> 0x006e, TryCatch #0 {Exception -> 0x006e, blocks: (B:9:0x0027, B:11:0x0033, B:12:0x006b, B:15:0x0037, B:17:0x003d, B:22:0x0049, B:23:0x004d, B:25:0x005a, B:26:0x0061), top: B:8:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004d A[Catch: Exception -> 0x006e, TryCatch #0 {Exception -> 0x006e, blocks: (B:9:0x0027, B:11:0x0033, B:12:0x006b, B:15:0x0037, B:17:0x003d, B:22:0x0049, B:23:0x004d, B:25:0x005a, B:26:0x0061), top: B:8:0x0027 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean X(d.c.b.p.r.b r5) {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 1
            r3 = 23
            if (r0 < r3) goto L27
            java.lang.String r0 = "android.permission.READ_EXTERNAL_STORAGE"
            int r3 = r4.checkSelfPermission(r0)
            if (r3 == 0) goto L27
            java.lang.String[] r5 = new java.lang.String[]{r0}
            r0 = 2
            r4.requestPermissions(r5, r0)
            r5 = 2131689585(0x7f0f0071, float:1.900819E38)
            java.lang.String r5 = r4.getString(r5)
            android.widget.Toast r5 = android.widget.Toast.makeText(r4, r5, r2)
            r5.show()
            return r1
        L27:
            int r0 = r5.d()     // Catch: java.lang.Exception -> L6e
            d.c.b.p.r$b$a r3 = d.c.b.p.r.b.a     // Catch: java.lang.Exception -> L6e
            int r3 = r3.b()     // Catch: java.lang.Exception -> L6e
            if (r0 != r3) goto L37
            r4.Y()     // Catch: java.lang.Exception -> L6e
            goto L6b
        L37:
            java.lang.String r0 = r5.c()     // Catch: java.lang.Exception -> L6e
            if (r0 == 0) goto L46
            int r3 = r0.length()     // Catch: java.lang.Exception -> L6e
            if (r3 != 0) goto L44
            goto L46
        L44:
            r3 = 0
            goto L47
        L46:
            r3 = 1
        L47:
            if (r3 != 0) goto L4d
            r4.W(r0)     // Catch: java.lang.Exception -> L6e
            goto L6b
        L4d:
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Exception -> L6e
            java.lang.String r3 = "android.intent.action.GET_CONTENT"
            r0.<init>(r3)     // Catch: java.lang.Exception -> L6e
            java.lang.String r3 = r5.b()     // Catch: java.lang.Exception -> L6e
            if (r3 == 0) goto L5e
        L5a:
            r0.setType(r3)     // Catch: java.lang.Exception -> L6e
            goto L61
        L5e:
        */
        //  java.lang.String r3 = "*/*"
        /*
            goto L5a
        L61:
            java.lang.String r3 = "android.intent.category.OPENABLE"
            r0.addCategory(r3)     // Catch: java.lang.Exception -> L6e
            int r3 = r4.D     // Catch: java.lang.Exception -> L6e
            r4.startActivityForResult(r0, r3)     // Catch: java.lang.Exception -> L6e
        L6b:
            r4.C = r5     // Catch: java.lang.Exception -> L6e
            r1 = 1
        L6e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dna.tools.ActionPage.X(d.c.b.p.r$b):boolean");
    }

    private final void Y() {
        try {
            Intent intent = new Intent(this, (Class<?>) ActivityFileSelector.class);
            intent.putExtra("mode", ActivityFileSelector.C.b());
            startActivityForResult(intent, this.E);
        } catch (Exception unused) {
            Toast.makeText(this, "Failed to start built-in file selector!", 0).show();
        }
    }

    private final String Z(Uri uri) {
        try {
            return new d.c.a.f.a().b(this, uri);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0() {
        this.y.post(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0() {
        new Thread(new d(this)).start();
    }

    private final void c0(PageMenuOption pageMenuOption) {
        X(new e(pageMenuOption));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(PageMenuOption pageMenuOption, HashMap<String, String> hashMap) {
        g gVar = new g(pageMenuOption);
        boolean a2 = j.f999b.b().a();
        c.a aVar = d.c.b.p.c.v0;
        f fVar = f.f944e;
        PageNode pageNode = this.z;
        if (pageNode == null) {
            e.p.d.i.l("currentPageConfig");
            throw null;
        }
        d.c.b.p.c a3 = aVar.a(pageMenuOption, fVar, gVar, pageNode.getPageHandlerSh(), hashMap, a2);
        a3.y1(o(), "");
        a3.w1(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0047, code lost:
    
        finish();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if (r0.equals("exit") != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if (r0.equals("reload") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
    
        if (r0.equals("finish") != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r0.equals("refresh") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x003b, code lost:
    
        recreate();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (r0.equals("close") != false) goto L22;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e0(com.omarea.krscript.model.PageMenuOption r4) {
        /*
            r3 = this;
            java.lang.String r0 = r4.getType()
            int r1 = r0.hashCode()
            switch(r1) {
                case -1274442605: goto L3f;
                case -934641255: goto L33;
                case 3127582: goto L2a;
                case 3143036: goto L1e;
                case 94756344: goto L15;
                case 1085444827: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L4b
        Lc:
            java.lang.String r1 = "refresh"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4b
            goto L3b
        L15:
            java.lang.String r1 = "close"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4b
            goto L47
        L1e:
            java.lang.String r1 = "file"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4b
            r3.c0(r4)
            goto L67
        L2a:
            java.lang.String r1 = "exit"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4b
            goto L47
        L33:
            java.lang.String r1 = "reload"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4b
        L3b:
            r3.recreate()
            goto L67
        L3f:
            java.lang.String r1 = "finish"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4b
        L47:
            r3.finish()
            goto L67
        L4b:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = r4.getKey()
            java.lang.String r2 = "state"
            r0.put(r2, r1)
            java.lang.String r1 = r4.getKey()
            java.lang.String r2 = "menu_id"
            r0.put(r2, r1)
            e.j r1 = e.j.a
            r3.d0(r4, r0)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dna.tools.ActionPage.e0(com.omarea.krscript.model.PageMenuOption):void");
    }

    private final void f0() {
        if (isTaskRoot()) {
            try {
                Object systemService = getSystemService("activity");
                if (systemService == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
                }
                for (ActivityManager.AppTask appTask : ((ActivityManager) systemService).getAppTasks()) {
                    e.p.d.i.c(appTask, "task");
                    if (appTask.getTaskInfo().id == getTaskId()) {
                        appTask.setExcludeFromRecents(true);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(String str) {
        this.y.post(new i(str));
    }

    public View G(int i2) {
        if (this.G == null) {
            this.G = new HashMap();
        }
        View view = (View) this.G.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.G.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void H(PageNode pageNode) {
        e.p.d.i.d(pageNode, "pageNode");
        new com.dna.tools.f(this).a(pageNode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r1 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r1.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        if (r1 != null) goto L14;
     */
    @Override // androidx.fragment.app.d, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            int r0 = r3.D
            r1 = -1
            r2 = 0
            if (r4 != r0) goto L2b
            if (r6 == 0) goto L10
            if (r5 == r1) goto Lb
            goto L10
        Lb:
            android.net.Uri r0 = r6.getData()
            goto L11
        L10:
            r0 = r2
        L11:
            d.c.b.p.r$b r1 = r3.C
            if (r1 == 0) goto L28
            if (r0 == 0) goto L23
            java.lang.String r0 = r3.Z(r0)
            d.c.b.p.r$b r1 = r3.C
            if (r1 == 0) goto L28
        L1f:
            r1.a(r0)
            goto L28
        L23:
            if (r1 == 0) goto L28
            r1.a(r2)
        L28:
            r3.C = r2
            goto L41
        L2b:
            int r0 = r3.E
            if (r4 != r0) goto L41
            if (r6 == 0) goto L3b
            if (r5 == r1) goto L34
            goto L3b
        L34:
            java.lang.String r0 = "file"
            java.lang.String r0 = r6.getStringExtra(r0)
            goto L3c
        L3b:
            r0 = r2
        L3c:
            d.c.b.p.r$b r1 = r3.C
            if (r1 == 0) goto L28
            goto L1f
        L41:
            super.onActivityResult(r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dna.tools.ActionPage.onActivityResult(int, int, android.content.Intent):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        Bundle extras;
        PageNode d2;
        super.onCreate(bundle);
        if (!d.c.b.n.b.l()) {
            Intent intent = new Intent(getApplicationContext(), (Class<?>) SplashActivity.class);
            intent.addFlags(65536);
            intent.putExtras(getIntent());
            intent.putExtra("JumpActionPage", true);
            startActivity(intent);
            finish();
            return;
        }
        j.f999b.c(this);
        setContentView(R.layout.activity_action_page);
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
        toolbar.setNavigationOnClickListener(new h());
        Intent intent2 = getIntent();
        e.p.d.i.c(intent2, "intent");
        if (intent2.getExtras() != null && (extras = intent2.getExtras()) != null && (extras.containsKey("page") || extras.containsKey("shortcutId"))) {
            String str = "";
            if (extras.containsKey("page")) {
                d2 = (PageNode) extras.getSerializable("page");
            } else {
                d2 = new d.c.b.o.a(this).d("" + extras.getString("shortcutId"));
            }
            if (d2 != null) {
                if (extras.containsKey("autoRunItemId")) {
                    str = "" + extras.getString("autoRunItemId");
                }
                this.A = str;
                if ((d2.getActivity().length() > 0) && new d.c.b.j(this, d2.getActivity()).b()) {
                    finish();
                    return;
                }
                if (d2.getOnlineHtmlPage().length() > 0) {
                    try {
                        Intent intent3 = new Intent(this, (Class<?>) ActionPageOnline.class);
                        intent3.addFlags(268435456);
                        intent3.putExtra("config", d2.getOnlineHtmlPage());
                        e.j jVar = e.j.a;
                        startActivity(intent3);
                    } catch (Exception unused) {
                    }
                }
                if (d2.getTitle().length() > 0) {
                    setTitle(d2.getTitle());
                }
                this.z = d2;
            } else {
                Toast.makeText(this, "Invalid page information", 0).show();
                finish();
            }
        }
        PageNode pageNode = this.z;
        if (pageNode == null) {
            e.p.d.i.l("currentPageConfig");
            throw null;
        }
        if (pageNode.getPageConfigPath().length() == 0) {
            PageNode pageNode2 = this.z;
            if (pageNode2 == null) {
                e.p.d.i.l("currentPageConfig");
                throw null;
            }
            if (pageNode2.getPageConfigSh().length() == 0) {
                setResult(2);
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.F == null) {
            Context applicationContext = getApplicationContext();
            e.p.d.i.c(applicationContext, "applicationContext");
            PageNode pageNode = this.z;
            if (pageNode == null) {
                e.p.d.i.l("currentPageConfig");
                throw null;
            }
            this.F = new m(applicationContext, pageNode).a();
        }
        ArrayList<PageMenuOption> arrayList = this.F;
        if (arrayList == null || menu == null) {
            return true;
        }
        e.p.d.i.b(arrayList);
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<PageMenuOption> arrayList2 = this.F;
            e.p.d.i.b(arrayList2);
            PageMenuOption pageMenuOption = arrayList2.get(i2);
            e.p.d.i.c(pageMenuOption, "menuOptions!![i]");
            PageMenuOption pageMenuOption2 = pageMenuOption;
            if (pageMenuOption2.isFab()) {
                V(pageMenuOption2);
            } else {
                menu.add(-1, i2, i2, pageMenuOption2.getTitle());
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, android.app.Activity
    public void onDestroy() {
        f0();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        e.p.d.i.d(menuItem, "item");
        ArrayList<PageMenuOption> arrayList = this.F;
        if (arrayList == null) {
            return false;
        }
        e.p.d.i.b(arrayList);
        PageMenuOption pageMenuOption = arrayList.get(menuItem.getItemId());
        e.p.d.i.c(pageMenuOption, "menuOptions!![item.itemId]");
        e0(pageMenuOption);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.x) {
            return;
        }
        b0();
    }
}
