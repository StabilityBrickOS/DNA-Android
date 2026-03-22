package d.c.b.p;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.omarea.common.ui.e;
import com.omarea.common.ui.f;
import com.omarea.krscript.model.ActionNode;
import com.omarea.krscript.model.ActionParamInfo;
import com.omarea.krscript.model.AutoRunTask;
import com.omarea.krscript.model.ClickableNode;
import com.omarea.krscript.model.GroupNode;
import com.omarea.krscript.model.KrScriptActionHandler;
import com.omarea.krscript.model.NodeInfoBase;
import com.omarea.krscript.model.PageNode;
import com.omarea.krscript.model.PickerNode;
import com.omarea.krscript.model.RunnableNode;
import com.omarea.krscript.model.SwitchNode;
import d.c.b.p.l;
import d.c.b.p.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class a extends Fragment implements l.a {
    public static final C0106a j0 = new C0106a(null);
    private ArrayList<NodeInfoBase> b0;
    private com.omarea.common.ui.h c0;
    private KrScriptActionHandler d0;
    private AutoRunTask e0;
    private com.omarea.common.ui.i f0;
    private d.c.b.p.f g0;
    private boolean h0;
    private HashMap i0;

    /* renamed from: d.c.b.p.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0106a {
        private C0106a() {
        }

        public /* synthetic */ C0106a(e.p.d.e eVar) {
            this();
        }

        public final a a(ArrayList<NodeInfoBase> arrayList, KrScriptActionHandler krScriptActionHandler, AutoRunTask autoRunTask, com.omarea.common.ui.i iVar) {
            a aVar = new a();
            aVar.M1(arrayList, krScriptActionHandler, autoRunTask, iVar);
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b implements Runnable {
        final /* synthetic */ ArrayList f;
        final /* synthetic */ Handler g;
        final /* synthetic */ ActionNode h;
        final /* synthetic */ LinearLayout i;
        final /* synthetic */ String j;
        final /* synthetic */ Runnable k;

        /* renamed from: d.c.b.p.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class RunnableC0107a implements Runnable {
            final /* synthetic */ ActionParamInfo f;

            RunnableC0107a(ActionParamInfo actionParamInfo) {
                this.f = actionParamInfo;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.omarea.common.ui.h y1 = a.y1(a.this);
                StringBuilder sb = new StringBuilder();
                Context u = a.this.u();
                e.p.d.i.b(u);
                sb.append(u.getString(d.c.b.h.kr_param_load));
                String label = this.f.getLabel();
                sb.append(!(label == null || label.length() == 0) ? this.f.getLabel() : this.f.getName());
                y1.b(sb.toString());
            }
        }

        /* renamed from: d.c.b.p.a$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class RunnableC0108b implements Runnable {
            final /* synthetic */ ActionParamInfo f;

            RunnableC0108b(ActionParamInfo actionParamInfo) {
                this.f = actionParamInfo;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.omarea.common.ui.h y1 = a.y1(a.this);
                StringBuilder sb = new StringBuilder();
                Context u = a.this.u();
                e.p.d.i.b(u);
                sb.append(u.getString(d.c.b.h.kr_param_options_load));
                String label = this.f.getLabel();
                sb.append(!(label == null || label.length() == 0) ? this.f.getLabel() : this.f.getName());
                y1.b(sb.toString());
            }
        }

        /* loaded from: classes.dex */
        static final class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.omarea.common.ui.h y1 = a.y1(a.this);
                Context u = a.this.u();
                e.p.d.i.b(u);
                String string = u.getString(d.c.b.h.kr_params_render);
                e.p.d.i.c(string, "this.context!!.getString….string.kr_params_render)");
                y1.b(string);
            }
        }

        /* loaded from: classes.dex */
        static final class d implements Runnable {

            /* renamed from: d.c.b.p.a$b$d$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0109a implements r.a {
                C0109a() {
                }

                @Override // d.c.b.p.r.a
                public boolean openFileChooser(r.b bVar) {
                    e.p.d.i.d(bVar, "fileSelectedInterface");
                    if (a.this.d0 == null) {
                        return false;
                    }
                    KrScriptActionHandler krScriptActionHandler = a.this.d0;
                    e.p.d.i.b(krScriptActionHandler);
                    return krScriptActionHandler.openFileChooser(bVar);
                }
            }

            /* renamed from: d.c.b.p.a$b$d$b, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            static final class ViewOnClickListenerC0110b implements View.OnClickListener {

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ AlertDialog f1436e;

                ViewOnClickListenerC0110b(AlertDialog alertDialog) {
                    this.f1436e = alertDialog;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    try {
                        AlertDialog alertDialog = this.f1436e;
                        e.p.d.i.b(alertDialog);
                        alertDialog.dismiss();
                    } catch (Exception unused) {
                    }
                }
            }

            /* loaded from: classes.dex */
            static final class c implements View.OnClickListener {
                final /* synthetic */ d.c.b.p.b f;
                final /* synthetic */ AlertDialog g;

                c(d.c.b.p.b bVar, AlertDialog alertDialog) {
                    this.f = bVar;
                    this.g = alertDialog;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    try {
                        a.this.F1(b.this.h, b.this.j, b.this.k, this.f.c(b.this.f));
                        AlertDialog alertDialog = this.g;
                        e.p.d.i.b(alertDialog);
                        alertDialog.dismiss();
                    } catch (Exception e2) {
                        Context u = a.this.u();
                        e.p.d.i.b(u);
                        Toast.makeText(u, "" + e2.getMessage(), 1).show();
                    }
                }
            }

            /* renamed from: d.c.b.p.a$b$d$d, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            static final class RunnableC0111d implements Runnable {
                final /* synthetic */ d.c.b.p.b f;

                RunnableC0111d(d.c.b.p.b bVar) {
                    this.f = bVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        a.this.F1(b.this.h, b.this.j, b.this.k, this.f.c(b.this.f));
                    } catch (Exception e2) {
                        Context u = a.this.u();
                        e.p.d.i.b(u);
                        Toast.makeText(u, "" + e2.getMessage(), 1).show();
                    }
                }
            }

            d() {
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x0086  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x00ab  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x00c1  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0142  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x014b  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x017f  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x0184  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x0193  */
            /* JADX WARN: Removed duplicated region for block: B:43:0x015a  */
            /* JADX WARN: Removed duplicated region for block: B:44:0x0144  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x00fb  */
            /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void run() {
                /*
                    Method dump skipped, instructions count: 454
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: d.c.b.p.a.b.d.run():void");
            }
        }

        b(ArrayList arrayList, Handler handler, ActionNode actionNode, LinearLayout linearLayout, String str, Runnable runnable) {
            this.f = arrayList;
            this.g = handler;
            this.h = actionNode;
            this.i = linearLayout;
            this.j = str;
            this.k = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ActionParamInfo actionParamInfo = (ActionParamInfo) it.next();
                this.g.post(new RunnableC0107a(actionParamInfo));
                if (actionParamInfo.getValueShell() != null) {
                    a aVar = a.this;
                    String valueShell = actionParamInfo.getValueShell();
                    e.p.d.i.b(valueShell);
                    actionParamInfo.setValueFromShell(aVar.G1(valueShell, this.h));
                }
                this.g.post(new RunnableC0108b(actionParamInfo));
                a aVar2 = a.this;
                e.p.d.i.c(actionParamInfo, "actionParamInfo");
                actionParamInfo.setOptionsFromShell(aVar2.H1(actionParamInfo, this.h));
            }
            this.g.post(new c());
            this.g.post(new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c implements Runnable {
        final /* synthetic */ RunnableNode f;

        c(RunnableNode runnableNode) {
            this.f = runnableNode;
        }

        @Override // java.lang.Runnable
        public final void run() {
            KrScriptActionHandler krScriptActionHandler = a.this.d0;
            if (krScriptActionHandler != null) {
                krScriptActionHandler.onActionCompleted(this.f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d implements Runnable {
        final /* synthetic */ RunnableNode f;

        d(RunnableNode runnableNode) {
            this.f = runnableNode;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.L1(false);
            KrScriptActionHandler krScriptActionHandler = a.this.d0;
            if (krScriptActionHandler != null) {
                krScriptActionHandler.onActionCompleted(this.f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e implements Runnable {
        final /* synthetic */ RunnableNode f;

        e(RunnableNode runnableNode) {
            this.f = runnableNode;
        }

        @Override // java.lang.Runnable
        public final void run() {
            KrScriptActionHandler krScriptActionHandler = a.this.d0;
            if (krScriptActionHandler != null) {
                krScriptActionHandler.onActionCompleted(this.f);
            }
        }
    }

    /* loaded from: classes.dex */
    static final class f implements Runnable {
        final /* synthetic */ ActionNode f;
        final /* synthetic */ Runnable g;

        f(ActionNode actionNode, Runnable runnable) {
            this.f = actionNode;
            this.g = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.E1(this.f, this.g);
        }
    }

    /* loaded from: classes.dex */
    static final class g implements Runnable {
        final /* synthetic */ ActionNode f;
        final /* synthetic */ Runnable g;

        g(ActionNode actionNode, Runnable runnable) {
            this.f = actionNode;
            this.g = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.E1(this.f, this.g);
        }
    }

    /* loaded from: classes.dex */
    public static final class h implements KrScriptActionHandler.AddToFavoritesHandler {

        /* renamed from: d.c.b.p.a$h$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class RunnableC0112a implements Runnable {
            final /* synthetic */ Intent f;
            final /* synthetic */ ClickableNode g;

            RunnableC0112a(Intent intent, ClickableNode clickableNode) {
                this.f = intent;
                this.g = clickableNode;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Context u = a.this.u();
                e.p.d.i.b(u);
                e.p.d.i.c(u, "context!!");
                d.c.b.o.a aVar = new d.c.b.o.a(u);
                Intent intent = this.f;
                d.c.b.l.a aVar2 = new d.c.b.l.a();
                Context u2 = a.this.u();
                e.p.d.i.b(u2);
                e.p.d.i.c(u2, "context!!");
                (!aVar.a(intent, aVar2.c(u2, this.g), this.g) ? Toast.makeText(a.this.u(), d.c.b.h.kr_shortcut_create_fail, 0) : Toast.makeText(a.this.u(), a.this.N(d.c.b.h.kr_shortcut_create_success), 0)).show();
            }
        }

        h() {
        }

        @Override // com.omarea.krscript.model.KrScriptActionHandler.AddToFavoritesHandler
        public void onAddToFavorites(ClickableNode clickableNode, Intent intent) {
            e.p.d.i.d(clickableNode, "clickableNode");
            if (intent != null) {
                e.a aVar = com.omarea.common.ui.e.f1255b;
                androidx.fragment.app.d n = a.this.n();
                e.p.d.i.b(n);
                e.p.d.i.c(n, "activity!!");
                String N = a.this.N(d.c.b.h.kr_shortcut_create);
                e.p.d.i.c(N, "getString(R.string.kr_shortcut_create)");
                e.p.d.q qVar = e.p.d.q.a;
                String N2 = a.this.N(d.c.b.h.kr_shortcut_create_desc);
                e.p.d.i.c(N2, "getString(R.string.kr_shortcut_create_desc)");
                String format = String.format(N2, Arrays.copyOf(new Object[]{clickableNode.getTitle()}, 1));
                e.p.d.i.c(format, "java.lang.String.format(format, *args)");
                aVar.f(n, (r13 & 2) != 0 ? "" : N, (r13 & 4) != 0 ? "" : format, (r13 & 8) != 0 ? null : new RunnableC0112a(intent, clickableNode), (r13 & 16) != 0 ? null : null);
            }
        }
    }

    /* loaded from: classes.dex */
    static final class i implements Runnable {
        final /* synthetic */ PickerNode f;
        final /* synthetic */ Runnable g;

        i(PickerNode pickerNode, Runnable runnable) {
            this.f = pickerNode;
            this.g = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.J1(this.f, this.g);
        }
    }

    /* loaded from: classes.dex */
    static final class j implements Runnable {
        final /* synthetic */ PickerNode f;
        final /* synthetic */ Runnable g;

        j(PickerNode pickerNode, Runnable runnable) {
            this.f = pickerNode;
            this.g = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.J1(this.f, this.g);
        }
    }

    /* loaded from: classes.dex */
    static final class k implements Runnable {
        final /* synthetic */ SwitchNode f;
        final /* synthetic */ boolean g;
        final /* synthetic */ Runnable h;

        k(SwitchNode switchNode, boolean z, Runnable runnable) {
            this.f = switchNode;
            this.g = z;
            this.h = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.N1(this.f, this.g, this.h);
        }
    }

    /* loaded from: classes.dex */
    static final class l implements Runnable {
        final /* synthetic */ SwitchNode f;
        final /* synthetic */ boolean g;
        final /* synthetic */ Runnable h;

        l(SwitchNode switchNode, boolean z, Runnable runnable) {
            this.f = switchNode;
            this.g = z;
            this.h = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.N1(this.f, this.g, this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class m implements Runnable {
        final /* synthetic */ PickerNode f;
        final /* synthetic */ ActionParamInfo g;
        final /* synthetic */ Handler h;
        final /* synthetic */ Runnable i;

        /* renamed from: d.c.b.p.a$m$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class RunnableC0113a implements Runnable {
            final /* synthetic */ ArrayList f;

            /* renamed from: d.c.b.p.a$m$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0114a implements f.a {
                C0114a() {
                }

                @Override // com.omarea.common.ui.f.a
                public void a(List<d.c.a.e.a> list, boolean[] zArr) {
                    int g;
                    String s;
                    e.p.d.i.d(list, "selected");
                    e.p.d.i.d(zArr, "status");
                    String str = "";
                    if (m.this.f.getMultiple()) {
                        m mVar = m.this;
                        a aVar = a.this;
                        PickerNode pickerNode = mVar.f;
                        g = e.k.j.g(list, 10);
                        ArrayList arrayList = new ArrayList(g);
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add("" + ((d.c.a.e.a) it.next()).c());
                        }
                        s = e.k.q.s(arrayList, m.this.f.getSeparator(), null, null, 0, null, null, 62, null);
                        aVar.K1(pickerNode, s, m.this.i);
                        return;
                    }
                    if (list.size() <= 0) {
                        Toast.makeText(a.this.u(), a.this.N(d.c.b.h.picker_select_none), 0).show();
                        return;
                    }
                    m mVar2 = m.this;
                    a aVar2 = a.this;
                    PickerNode pickerNode2 = mVar2.f;
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    if (list.size() > 0) {
                        str = "" + list.get(0).c();
                    }
                    sb.append(str);
                    aVar2.K1(pickerNode2, sb.toString(), m.this.i);
                }
            }

            RunnableC0113a(ArrayList arrayList) {
                this.f = arrayList;
            }

            @Override // java.lang.Runnable
            public final void run() {
                View decorView;
                a.y1(a.this).a();
                boolean z = false;
                if (this.f == null) {
                    Toast.makeText(a.this.u(), a.this.N(d.c.b.h.picker_not_item), 0).show();
                    return;
                }
                androidx.fragment.app.d n = a.this.n();
                e.p.d.i.b(n);
                e.p.d.i.c(n, "activity!!");
                Window window = n.getWindow();
                Integer valueOf = (window == null || (decorView = window.getDecorView()) == null) ? null : Integer.valueOf(decorView.getSystemUiVisibility());
                if (valueOf != null && (valueOf.intValue() & 8192) == 0) {
                    z = true;
                }
                com.omarea.common.ui.f fVar = new com.omarea.common.ui.f(z, this.f, m.this.f.getMultiple(), new C0114a());
                androidx.fragment.app.d n2 = a.this.n();
                e.p.d.i.b(n2);
                e.p.d.i.c(n2, "activity!!");
                fVar.y1(n2.o(), "picker-item-chooser");
            }
        }

        m(PickerNode pickerNode, ActionParamInfo actionParamInfo, Handler handler, Runnable runnable) {
            this.f = pickerNode;
            this.g = actionParamInfo;
            this.h = handler;
            this.i = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f.getGetState() != null) {
                ActionParamInfo actionParamInfo = this.g;
                a aVar = a.this;
                String getState = this.f.getGetState();
                e.p.d.i.b(getState);
                actionParamInfo.setValueFromShell(aVar.G1(getState, this.f));
            }
            ArrayList<d.c.a.e.a> H1 = a.this.H1(this.g, this.f);
            if (H1 != null) {
                d.c.b.p.b.f1451d.d(this.g, H1);
            } else {
                H1 = null;
            }
            this.h.post(new RunnableC0113a(H1));
        }
    }

    /* loaded from: classes.dex */
    public static final class n extends HashMap<String, String> {
        final /* synthetic */ String $toValue;

        n(String str) {
            this.$toValue = str;
            put("state", str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return containsKey((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsKey(String str) {
            return super.containsKey((Object) str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof String) {
                return containsValue((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsValue(String str) {
            return super.containsValue((Object) str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
            return getEntries();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public /* bridge */ String get(String str) {
            return (String) super.get((Object) str);
        }

        public /* bridge */ Set getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set getKeys() {
            return super.keySet();
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
            return obj instanceof String ? getOrDefault((String) obj, (String) obj2) : obj2;
        }

        public /* bridge */ String getOrDefault(String str, String str2) {
            return (String) super.getOrDefault((Object) str, str2);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection getValues() {
            return super.values();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        public /* bridge */ String remove(String str) {
            return (String) super.remove((Object) str);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof String) && (obj2 instanceof String)) {
                return remove((String) obj, (String) obj2);
            }
            return false;
        }

        public /* bridge */ boolean remove(String str, String str2) {
            return super.remove((Object) str, (Object) str2);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<String> values() {
            return getValues();
        }
    }

    /* loaded from: classes.dex */
    public static final class o extends HashMap<String, String> {
        final /* synthetic */ boolean $toValue;

        o(boolean z) {
            this.$toValue = z;
            put("state", z ? "1" : "0");
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return containsKey((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsKey(String str) {
            return super.containsKey((Object) str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof String) {
                return containsValue((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsValue(String str) {
            return super.containsValue((Object) str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
            return getEntries();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public /* bridge */ String get(String str) {
            return (String) super.get((Object) str);
        }

        public /* bridge */ Set getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set getKeys() {
            return super.keySet();
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
            return obj instanceof String ? getOrDefault((String) obj, (String) obj2) : obj2;
        }

        public /* bridge */ String getOrDefault(String str, String str2) {
            return (String) super.getOrDefault((Object) str, str2);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection getValues() {
            return super.values();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        public /* bridge */ String remove(String str) {
            return (String) super.remove((Object) str);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof String) && (obj2 instanceof String)) {
                return remove((String) obj, (String) obj2);
            }
            return false;
        }

        public /* bridge */ boolean remove(String str, String str2) {
            return super.remove((Object) str, (Object) str2);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<String> values() {
            return getValues();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E1(ActionNode actionNode, Runnable runnable) {
        String setState = actionNode.getSetState();
        if (setState != null) {
            if (actionNode.getParams() != null) {
                ArrayList<ActionParamInfo> params = actionNode.getParams();
                e.p.d.i.b(params);
                if (params.size() > 0) {
                    Context u = u();
                    e.p.d.i.b(u);
                    View inflate = LayoutInflater.from(u).inflate(d.c.b.g.kr_params_list, (ViewGroup) null);
                    if (inflate == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
                    }
                    LinearLayout linearLayout = (LinearLayout) inflate;
                    Handler handler = new Handler();
                    com.omarea.common.ui.h hVar = this.c0;
                    if (hVar == null) {
                        e.p.d.i.l("progressBarDialog");
                        throw null;
                    }
                    Context u2 = u();
                    e.p.d.i.b(u2);
                    String string = u2.getString(d.c.b.h.onloading);
                    e.p.d.i.c(string, "this.context!!.getString(R.string.onloading)");
                    hVar.b(string);
                    new Thread(new b(params, handler, actionNode, linearLayout, setState, runnable)).start();
                    return;
                }
            }
            F1(actionNode, setState, runnable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F1(RunnableNode runnableNode, String str, Runnable runnable, HashMap<String, String> hashMap) {
        boolean z;
        Context u = u();
        e.p.d.i.b(u);
        e.p.d.i.c(u, "context!!");
        if (e.p.d.i.a(runnableNode.getShell(), RunnableNode.Companion.getShellModeBgTask())) {
            d.c.b.a.h.a(u, str, hashMap, runnableNode, runnable, new c(runnableNode));
            return;
        }
        if (e.p.d.i.a(runnableNode.getShell(), RunnableNode.Companion.getShellModeHidden())) {
            if (this.h0) {
                Toast.makeText(u, N(d.c.b.h.kr_hidden_task_running), 0).show();
                return;
            }
            this.h0 = true;
            d.c.b.c.f.a(u, str, hashMap, runnableNode, runnable, new d(runnableNode));
            return;
        }
        e eVar = new e(runnableNode);
        com.omarea.common.ui.i iVar = this.f0;
        if (iVar != null) {
            e.p.d.i.b(iVar);
            if (iVar.a()) {
                z = true;
                d.c.b.p.c a = d.c.b.p.c.v0.a(runnableNode, runnable, eVar, str, hashMap, z);
                a.w1(false);
                androidx.fragment.app.i z2 = z();
                e.p.d.i.b(z2);
                a.y1(z2, "");
            }
        }
        z = false;
        d.c.b.p.c a2 = d.c.b.p.c.v0.a(runnableNode, runnable, eVar, str, hashMap, z);
        a2.w1(false);
        androidx.fragment.app.i z22 = z();
        e.p.d.i.b(z22);
        a2.y1(z22, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String G1(String str, NodeInfoBase nodeInfoBase) {
        Context u = u();
        e.p.d.i.b(u);
        String b2 = d.c.b.n.b.b(u, str, nodeInfoBase);
        e.p.d.i.c(b2, "ScriptEnvironmen.execute…hellScript, nodeInfoBase)");
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<d.c.a.e.a> H1(ActionParamInfo actionParamInfo, NodeInfoBase nodeInfoBase) {
        List b2;
        boolean n2;
        d.c.a.e.a aVar;
        List b3;
        ArrayList<d.c.a.e.a> arrayList = new ArrayList<>();
        String G1 = !(actionParamInfo.getOptionsSh().length() == 0) ? G1(actionParamInfo.getOptionsSh(), nodeInfoBase) : "";
        if (!e.p.d.i.a(G1, "error") && !e.p.d.i.a(G1, "null")) {
            if (!(G1.length() == 0)) {
                List<String> split = new e.u.h("\n").split(G1, 0);
                if (!split.isEmpty()) {
                    ListIterator<String> listIterator = split.listIterator(split.size());
                    while (listIterator.hasPrevious()) {
                        if (!(listIterator.previous().length() == 0)) {
                            b2 = e.k.q.x(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                }
                b2 = e.k.i.b();
                Object[] array = b2.toArray(new String[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                for (String str : (String[]) array) {
                    n2 = e.u.v.n(str, "|", false, 2, null);
                    if (n2) {
                        List<String> split2 = new e.u.h("\\|").split(str, 0);
                        if (!split2.isEmpty()) {
                            ListIterator<String> listIterator2 = split2.listIterator(split2.size());
                            while (listIterator2.hasPrevious()) {
                                if (!(listIterator2.previous().length() == 0)) {
                                    b3 = e.k.q.x(split2, listIterator2.nextIndex() + 1);
                                    break;
                                }
                            }
                        }
                        b3 = e.k.i.b();
                        Object[] array2 = b3.toArray(new String[0]);
                        if (array2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                        String[] strArr = (String[]) array2;
                        aVar = new d.c.a.e.a();
                        String str2 = strArr[0];
                        if (strArr.length > 0) {
                            str2 = strArr[1];
                        }
                        aVar.e(str2);
                        str = strArr[0];
                    } else {
                        aVar = new d.c.a.e.a();
                        aVar.e(str);
                    }
                    aVar.f(str);
                    e.j jVar = e.j.a;
                    arrayList.add(aVar);
                }
                return arrayList;
            }
        }
        if (actionParamInfo.getOptions() == null) {
            return null;
        }
        ArrayList<d.c.a.e.a> options = actionParamInfo.getOptions();
        e.p.d.i.b(options);
        Iterator<d.c.a.e.a> it = options.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x013a, code lost:
    
        if (e.p.d.i.a(r2, "0") == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0147, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0143, code lost:
    
        if (r17.getLocked() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean I1(com.omarea.krscript.model.ClickableNode r17) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.b.p.a.I1(com.omarea.krscript.model.ClickableNode):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1(PickerNode pickerNode, Runnable runnable) {
        ActionParamInfo actionParamInfo = new ActionParamInfo();
        actionParamInfo.setOptions(pickerNode.getOptions());
        actionParamInfo.setOptionsSh(pickerNode.getOptionsSh());
        actionParamInfo.setSeparator(pickerNode.getSeparator());
        Handler handler = new Handler();
        com.omarea.common.ui.h hVar = this.c0;
        if (hVar == null) {
            e.p.d.i.l("progressBarDialog");
            throw null;
        }
        String N = N(d.c.b.h.kr_param_options_load);
        e.p.d.i.c(N, "getString(R.string.kr_param_options_load)");
        hVar.b(N);
        new Thread(new m(pickerNode, actionParamInfo, handler, runnable)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1(PickerNode pickerNode, String str, Runnable runnable) {
        String setState = pickerNode.getSetState();
        if (setState != null) {
            F1(pickerNode, setState, runnable, new n(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1(ArrayList<NodeInfoBase> arrayList, KrScriptActionHandler krScriptActionHandler, AutoRunTask autoRunTask, com.omarea.common.ui.i iVar) {
        if (arrayList != null) {
            this.b0 = arrayList;
            this.d0 = krScriptActionHandler;
            this.e0 = autoRunTask;
            this.f0 = iVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N1(SwitchNode switchNode, boolean z, Runnable runnable) {
        String setState = switchNode.getSetState();
        if (setState != null) {
            F1(switchNode, setState, runnable, new o(z));
        }
    }

    private final void O1(AutoRunTask autoRunTask) {
        if (autoRunTask != null) {
            String key = autoRunTask.getKey();
            if (key == null || key.length() == 0) {
                return;
            }
            d.c.b.p.f fVar = this.g0;
            if (fVar == null) {
                e.p.d.i.l("rootGroup");
                throw null;
            }
            String key2 = autoRunTask.getKey();
            e.p.d.i.b(key2);
            autoRunTask.onCompleted(Boolean.valueOf(fVar.k(key2)));
        }
    }

    public static final /* synthetic */ com.omarea.common.ui.h y1(a aVar) {
        com.omarea.common.ui.h hVar = aVar.c0;
        if (hVar != null) {
            return hVar;
        }
        e.p.d.i.l("progressBarDialog");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void E0(View view, Bundle bundle) {
        e.p.d.i.d(view, "view");
        super.E0(view, bundle);
        androidx.fragment.app.d n2 = n();
        e.p.d.i.b(n2);
        e.p.d.i.c(n2, "this.activity!!");
        this.c0 = new com.omarea.common.ui.h(n2, null, 2, null);
        Context u = u();
        e.p.d.i.b(u);
        e.p.d.i.c(u, "this.context!!");
        this.g0 = new d.c.b.p.f(u, true, new GroupNode(""));
        if (this.b0 != null) {
            Context u2 = u();
            e.p.d.i.b(u2);
            e.p.d.i.c(u2, "this.context!!");
            ArrayList<NodeInfoBase> arrayList = this.b0;
            e.p.d.i.b(arrayList);
            d.c.b.p.f fVar = this.g0;
            if (fVar == null) {
                e.p.d.i.l("rootGroup");
                throw null;
            }
            new d.c.b.p.l(u2, arrayList, this, fVar);
            d.c.b.p.f fVar2 = this.g0;
            if (fVar2 == null) {
                e.p.d.i.l("rootGroup");
                throw null;
            }
            View d2 = fVar2.d();
            View P = P();
            ScrollView scrollView = P != null ? (ScrollView) P.findViewById(d.c.b.f.kr_content) : null;
            if (scrollView != null) {
                scrollView.removeAllViews();
            }
            if (scrollView != null) {
                scrollView.addView(d2);
            }
            O1(this.e0);
        }
    }

    public final void L1(boolean z) {
        this.h0 = z;
    }

    @Override // d.c.b.p.l.a
    public void b(ActionNode actionNode, Runnable runnable) {
        e.a aVar;
        androidx.fragment.app.d n2;
        String title;
        String warning;
        Runnable gVar;
        ArrayList<ActionParamInfo> params;
        e.p.d.i.d(actionNode, "item");
        e.p.d.i.d(runnable, "onCompleted");
        if (I1(actionNode)) {
            if (actionNode.getConfirm()) {
                aVar = com.omarea.common.ui.e.f1255b;
                n2 = n();
                e.p.d.i.b(n2);
                e.p.d.i.c(n2, "activity!!");
                title = actionNode.getTitle();
                warning = actionNode.getDesc();
                gVar = new f(actionNode, runnable);
            } else {
                if (!(actionNode.getWarning().length() > 0) || (actionNode.getParams() != null && ((params = actionNode.getParams()) == null || params.size() != 0))) {
                    E1(actionNode, runnable);
                    return;
                }
                aVar = com.omarea.common.ui.e.f1255b;
                n2 = n();
                e.p.d.i.b(n2);
                e.p.d.i.c(n2, "activity!!");
                title = actionNode.getTitle();
                warning = actionNode.getWarning();
                gVar = new g(actionNode, runnable);
            }
            aVar.t(n2, (r13 & 2) != 0 ? "" : title, (r13 & 4) != 0 ? "" : warning, (r13 & 8) != 0 ? null : gVar, (r13 & 16) != 0 ? null : null);
        }
    }

    @Override // d.c.b.p.l.a
    public void c(ClickableNode clickableNode) {
        e.p.d.i.d(clickableNode, "clickableNode");
        if (!(clickableNode.getKey().length() == 0)) {
            KrScriptActionHandler krScriptActionHandler = this.d0;
            if (krScriptActionHandler != null) {
                krScriptActionHandler.addToFavorites(clickableNode, new h());
                return;
            }
            return;
        }
        e.a aVar = com.omarea.common.ui.e.f1255b;
        androidx.fragment.app.d n2 = n();
        e.p.d.i.b(n2);
        e.p.d.i.c(n2, "this.activity!!");
        String N = N(d.c.b.h.kr_shortcut_create_fail);
        e.p.d.i.c(N, "getString(R.string.kr_shortcut_create_fail)");
        String N2 = N(d.c.b.h.kr_ushortcut_nsupported);
        e.p.d.i.c(N2, "getString(R.string.kr_ushortcut_nsupported)");
        e.a.b(aVar, n2, N, N2, null, 8, null);
    }

    @Override // d.c.b.p.l.a
    public void f(PageNode pageNode, Runnable runnable) {
        e.p.d.i.d(pageNode, "item");
        e.p.d.i.d(runnable, "onCompleted");
        if (I1(pageNode)) {
            if (u() != null) {
                if (pageNode.getLink().length() > 0) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(pageNode.getLink()));
                        intent.addFlags(268435456);
                        Context u = u();
                        if (u != null) {
                            u.startActivity(intent);
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        Context u2 = u();
                        Context u3 = u();
                        Toast.makeText(u2, u3 != null ? u3.getString(d.c.b.h.kr_slice_activity_fail) : null, 0).show();
                        return;
                    }
                }
            }
            if (u() != null) {
                if (pageNode.getActivity().length() > 0) {
                    Context u4 = u();
                    e.p.d.i.b(u4);
                    e.p.d.i.c(u4, "context!!");
                    new d.c.b.j(u4, pageNode.getActivity()).b();
                    return;
                }
            }
            KrScriptActionHandler krScriptActionHandler = this.d0;
            if (krScriptActionHandler != null) {
                krScriptActionHandler.onSubPageClick(pageNode);
            }
        }
    }

    @Override // d.c.b.p.l.a
    public void g(SwitchNode switchNode, Runnable runnable) {
        e.a aVar;
        androidx.fragment.app.d n2;
        String title;
        String warning;
        Runnable lVar;
        e.p.d.i.d(switchNode, "item");
        e.p.d.i.d(runnable, "onCompleted");
        if (I1(switchNode)) {
            boolean z = !switchNode.getChecked();
            if (switchNode.getConfirm()) {
                aVar = com.omarea.common.ui.e.f1255b;
                n2 = n();
                e.p.d.i.b(n2);
                e.p.d.i.c(n2, "activity!!");
                title = switchNode.getTitle();
                warning = switchNode.getDesc();
                lVar = new k(switchNode, z, runnable);
            } else {
                if (!(switchNode.getWarning().length() > 0)) {
                    N1(switchNode, z, runnable);
                    return;
                }
                aVar = com.omarea.common.ui.e.f1255b;
                n2 = n();
                e.p.d.i.b(n2);
                e.p.d.i.c(n2, "activity!!");
                title = switchNode.getTitle();
                warning = switchNode.getWarning();
                lVar = new l(switchNode, z, runnable);
            }
            aVar.t(n2, (r13 & 2) != 0 ? "" : title, (r13 & 4) != 0 ? "" : warning, (r13 & 8) != 0 ? null : lVar, (r13 & 16) != 0 ? null : null);
        }
    }

    @Override // d.c.b.p.l.a
    public void i(PickerNode pickerNode, Runnable runnable) {
        e.a aVar;
        androidx.fragment.app.d n2;
        String title;
        String warning;
        Runnable jVar;
        e.p.d.i.d(pickerNode, "item");
        e.p.d.i.d(runnable, "onCompleted");
        if (I1(pickerNode)) {
            if (pickerNode.getConfirm()) {
                aVar = com.omarea.common.ui.e.f1255b;
                n2 = n();
                e.p.d.i.b(n2);
                e.p.d.i.c(n2, "activity!!");
                title = pickerNode.getTitle();
                warning = pickerNode.getDesc();
                jVar = new i(pickerNode, runnable);
            } else {
                if (!(pickerNode.getWarning().length() > 0)) {
                    J1(pickerNode, runnable);
                    return;
                }
                aVar = com.omarea.common.ui.e.f1255b;
                n2 = n();
                e.p.d.i.b(n2);
                e.p.d.i.c(n2, "activity!!");
                title = pickerNode.getTitle();
                warning = pickerNode.getWarning();
                jVar = new j(pickerNode, runnable);
            }
            aVar.t(n2, (r13 & 2) != 0 ? "" : title, (r13 & 4) != 0 ? "" : warning, (r13 & 8) != 0 ? null : jVar, (r13 & 16) != 0 ? null : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View j0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        e.p.d.i.d(layoutInflater, "inflater");
        return layoutInflater.inflate(d.c.b.g.kr_action_list_fragment, viewGroup, false);
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
}
