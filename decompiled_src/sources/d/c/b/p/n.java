package d.c.b.p;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.omarea.common.ui.a;
import com.omarea.common.ui.c;
import com.omarea.krscript.model.ActionParamInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class n implements c.a {
    private final Integer a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1482b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f1483c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f1484d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<a.b> f1485e;
    private ActionParamInfo f;
    private androidx.fragment.app.d g;

    /* loaded from: classes.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            n.this.d();
        }
    }

    /* loaded from: classes.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            n.this.d();
        }
    }

    public n(ActionParamInfo actionParamInfo, androidx.fragment.app.d dVar) {
        View decorView;
        e.p.d.i.d(actionParamInfo, "actionParamInfo");
        e.p.d.i.d(dVar, "context");
        this.f = actionParamInfo;
        this.g = dVar;
        Window window = dVar.getWindow();
        Integer valueOf = (window == null || (decorView = window.getDecorView()) == null) ? null : Integer.valueOf(decorView.getSystemUiVisibility());
        this.a = valueOf;
        this.f1482b = valueOf != null && (valueOf.intValue() & 8192) == 0;
    }

    private final List<a.b> c(boolean z) {
        ArrayList arrayList;
        int g;
        int g2;
        PackageManager packageManager = this.g.getPackageManager();
        ArrayList<d.c.a.e.a> optionsFromShell = this.f.getOptionsFromShell();
        if (optionsFromShell != null) {
            g2 = e.k.j.g(optionsFromShell, 10);
            arrayList = new ArrayList(g2);
            Iterator<T> it = optionsFromShell.iterator();
            while (it.hasNext()) {
                arrayList.add(((d.c.a.e.a) it.next()).c());
            }
        } else {
            arrayList = null;
        }
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(8192);
        e.p.d.i.c(installedPackages, "pm.getInstalledPackages(…GET_UNINSTALLED_PACKAGES)");
        ArrayList<PackageInfo> arrayList2 = new ArrayList();
        for (Object obj : installedPackages) {
            if (arrayList == null || arrayList.contains(((PackageInfo) obj).packageName)) {
                arrayList2.add(obj);
            }
        }
        g = e.k.j.g(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(g);
        for (PackageInfo packageInfo : arrayList2) {
            a.b bVar = new a.b();
            bVar.e("" + packageInfo.applicationInfo.loadLabel(packageManager));
            String str = packageInfo.packageName;
            e.p.d.i.c(str, "it.packageName");
            bVar.g(str);
            arrayList3.add(bVar);
        }
        ArrayList arrayList4 = new ArrayList(arrayList3);
        if (z && this.f.getOptionsFromShell() != null) {
            ArrayList<d.c.a.e.a> optionsFromShell2 = this.f.getOptionsFromShell();
            e.p.d.i.b(optionsFromShell2);
            Iterator<d.c.a.e.a> it2 = optionsFromShell2.iterator();
            while (it2.hasNext()) {
                d.c.a.e.a next = it2.next();
                ArrayList arrayList5 = new ArrayList();
                for (Object obj2 : arrayList4) {
                    if (e.p.d.i.a(((a.b) obj2).c(), next.c())) {
                        arrayList5.add(obj2);
                    }
                }
                if (arrayList5.isEmpty()) {
                    a.b bVar2 = new a.b();
                    bVar2.e("" + next.b());
                    bVar2.g("" + next.c());
                    e.j jVar = e.j.a;
                    arrayList4.add(bVar2);
                }
            }
        }
        return arrayList4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        f();
        boolean z = this.f1482b;
        ArrayList<a.b> arrayList = this.f1485e;
        if (arrayList != null) {
            new com.omarea.common.ui.c(z, arrayList, this.f.getMultiple(), this).y1(this.g.o(), "app-chooser");
        } else {
            e.p.d.i.l("packages");
            throw null;
        }
    }

    private final void f() {
        Object obj;
        int i;
        List<String> H;
        Object obj2;
        ArrayList<a.b> arrayList = this.f1485e;
        if (arrayList == null) {
            e.p.d.i.l("packages");
            throw null;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            ((a.b) it.next()).h(false);
        }
        TextView textView = this.f1483c;
        if (textView == null) {
            e.p.d.i.l("valueView");
            throw null;
        }
        CharSequence text = textView.getText();
        if (this.f.getMultiple()) {
            e.p.d.i.c(text, "currentValue");
            H = e.u.v.H(text, new String[]{this.f.getSeparator()}, false, 0, 6, null);
            for (String str : H) {
                ArrayList<a.b> arrayList2 = this.f1485e;
                if (arrayList2 == null) {
                    e.p.d.i.l("packages");
                    throw null;
                }
                Iterator<T> it2 = arrayList2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        obj2 = it2.next();
                        if (e.p.d.i.a(((a.b) obj2).c(), str)) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                a.b bVar = (a.b) obj2;
                if (bVar != null) {
                    bVar.h(true);
                }
            }
            return;
        }
        ArrayList<a.b> arrayList3 = this.f1485e;
        if (arrayList3 == null) {
            e.p.d.i.l("packages");
            throw null;
        }
        Iterator<T> it3 = arrayList3.iterator();
        while (true) {
            if (it3.hasNext()) {
                obj = it3.next();
                if (e.p.d.i.a(((a.b) obj).c(), text)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        a.b bVar2 = (a.b) obj;
        if (bVar2 != null) {
            ArrayList<a.b> arrayList4 = this.f1485e;
            if (arrayList4 == null) {
                e.p.d.i.l("packages");
                throw null;
            }
            i = arrayList4.indexOf(bVar2);
        } else {
            i = -1;
        }
        if (i > -1) {
            ArrayList<a.b> arrayList5 = this.f1485e;
            if (arrayList5 == null) {
                e.p.d.i.l("packages");
                throw null;
            }
            arrayList5.get(i).h(true);
        }
    }

    private final void g() {
        int g;
        int g2;
        int g3;
        List A;
        Object obj;
        ArrayList<a.b> arrayList = new ArrayList<>(c(e.p.d.i.a(this.f.getType(), "packages")));
        this.f1485e = arrayList;
        if (arrayList == null) {
            e.p.d.i.l("packages");
            throw null;
        }
        g = e.k.j.g(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(g);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((a.b) it.next()).a());
        }
        Object[] array = arrayList2.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr = (String[]) array;
        g2 = e.k.j.g(arrayList, 10);
        ArrayList arrayList3 = new ArrayList(g2);
        Iterator<T> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((a.b) it2.next()).c());
        }
        Object[] array2 = arrayList3.toArray(new String[0]);
        if (array2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr2 = (String[]) array2;
        if (this.f.getMultiple()) {
            List<String> c2 = d.c.b.p.b.f1451d.c(this.f);
            if (c2 != null) {
                for (String str : c2) {
                    ArrayList<a.b> arrayList4 = this.f1485e;
                    if (arrayList4 == null) {
                        e.p.d.i.l("packages");
                        throw null;
                    }
                    Iterator<T> it3 = arrayList4.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            obj = it3.next();
                            if (e.p.d.i.a(((a.b) obj).c(), str)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    a.b bVar = (a.b) obj;
                    if (bVar != null) {
                        bVar.h(true);
                    }
                }
            }
            ArrayList<a.b> arrayList5 = this.f1485e;
            if (arrayList5 == null) {
                e.p.d.i.l("packages");
                throw null;
            }
            ArrayList arrayList6 = new ArrayList();
            for (Object obj2 : arrayList5) {
                if (((a.b) obj2).d()) {
                    arrayList6.add(obj2);
                }
            }
            a(arrayList6);
            return;
        }
        ArrayList<a.b> arrayList7 = this.f1485e;
        if (arrayList7 == null) {
            e.p.d.i.l("packages");
            throw null;
        }
        g3 = e.k.j.g(arrayList7, 10);
        ArrayList arrayList8 = new ArrayList(g3);
        for (a.b bVar2 : arrayList7) {
            d.c.a.e.a aVar = new d.c.a.e.a();
            aVar.e(bVar2.a());
            aVar.f(bVar2.c());
            arrayList8.add(aVar);
        }
        A = e.k.q.A(arrayList8);
        int a2 = d.c.b.p.b.f1451d.a(this.f, new ArrayList<>(A));
        if (a2 > -1) {
            TextView textView = this.f1483c;
            if (textView == null) {
                e.p.d.i.l("valueView");
                throw null;
            }
            textView.setText(strArr2[a2]);
            TextView textView2 = this.f1484d;
            if (textView2 != null) {
                textView2.setText(strArr[a2]);
                return;
            } else {
                e.p.d.i.l("nameView");
                throw null;
            }
        }
        TextView textView3 = this.f1483c;
        if (textView3 == null) {
            e.p.d.i.l("valueView");
            throw null;
        }
        textView3.setText("");
        TextView textView4 = this.f1484d;
        if (textView4 == null) {
            e.p.d.i.l("nameView");
            throw null;
        }
        textView4.setText("");
    }

    @Override // com.omarea.common.ui.c.a
    public void a(List<? extends a.b> list) {
        TextView textView;
        String a2;
        int g;
        String s;
        int g2;
        e.p.d.i.d(list, "apps");
        if (this.f.getMultiple()) {
            g = e.k.j.g(list, 10);
            ArrayList arrayList = new ArrayList(g);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((a.b) it.next()).c());
            }
            s = e.k.q.s(arrayList, this.f.getSeparator(), null, null, 0, null, null, 62, null);
            g2 = e.k.j.g(list, 10);
            ArrayList arrayList2 = new ArrayList(g2);
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((a.b) it2.next()).a());
            }
            a2 = e.k.q.s(arrayList2, "，", null, null, 0, null, null, 62, null);
            TextView textView2 = this.f1483c;
            if (textView2 == null) {
                e.p.d.i.l("valueView");
                throw null;
            }
            textView2.setText(s);
            textView = this.f1484d;
            if (textView == null) {
                e.p.d.i.l("nameView");
                throw null;
            }
        } else {
            a.b bVar = (a.b) e.k.g.o(list);
            if (bVar == null) {
                TextView textView3 = this.f1483c;
                if (textView3 == null) {
                    e.p.d.i.l("valueView");
                    throw null;
                }
                textView3.setText("");
                TextView textView4 = this.f1484d;
                if (textView4 != null) {
                    textView4.setText("");
                    return;
                } else {
                    e.p.d.i.l("nameView");
                    throw null;
                }
            }
            TextView textView5 = this.f1483c;
            if (textView5 == null) {
                e.p.d.i.l("valueView");
                throw null;
            }
            textView5.setText(bVar.c());
            textView = this.f1484d;
            if (textView == null) {
                e.p.d.i.l("nameView");
                throw null;
            }
            a2 = bVar.a();
        }
        textView.setText(a2);
    }

    public final View e() {
        View inflate = LayoutInflater.from(this.g).inflate(d.c.b.g.kr_param_app, (ViewGroup) null);
        View findViewById = inflate.findViewById(d.c.b.f.kr_param_app_package);
        e.p.d.i.c(findViewById, "layout.findViewById(R.id.kr_param_app_package)");
        this.f1483c = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(d.c.b.f.kr_param_app_name);
        e.p.d.i.c(findViewById2, "layout.findViewById(R.id.kr_param_app_name)");
        this.f1484d = (TextView) findViewById2;
        g();
        inflate.findViewById(d.c.b.f.kr_param_app_btn).setOnClickListener(new a());
        TextView textView = this.f1484d;
        if (textView == null) {
            e.p.d.i.l("nameView");
            throw null;
        }
        textView.setOnClickListener(new b());
        TextView textView2 = this.f1483c;
        if (textView2 == null) {
            e.p.d.i.l("valueView");
            throw null;
        }
        textView2.setTag(this.f.getName());
        e.p.d.i.c(inflate, "layout");
        return inflate;
    }
}
