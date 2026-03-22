package d.c.b.p;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.omarea.common.ui.f;
import com.omarea.krscript.model.ActionParamInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class s {
    private ArrayList<d.c.a.e.a> a;

    /* renamed from: b, reason: collision with root package name */
    private boolean[] f1504b;

    /* renamed from: c, reason: collision with root package name */
    private String[] f1505c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f1506d;

    /* renamed from: e, reason: collision with root package name */
    private final ActionParamInfo f1507e;
    private final androidx.fragment.app.d f;

    /* loaded from: classes.dex */
    public static final class a implements f.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f1508b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ TextView f1509c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f1510d;

        a(TextView textView, TextView textView2, TextView textView3) {
            this.f1508b = textView;
            this.f1509c = textView2;
            this.f1510d = textView3;
        }

        @Override // com.omarea.common.ui.f.a
        public void a(List<d.c.a.e.a> list, boolean[] zArr) {
            e.p.d.i.d(list, "selected");
            e.p.d.i.d(zArr, "result");
            int length = zArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                s.this.f1504b[i2] = zArr[i];
                i++;
                i2++;
            }
            s.this.f(this.f1508b, this.f1509c, this.f1510d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b implements View.OnClickListener {
        final /* synthetic */ TextView f;
        final /* synthetic */ TextView g;
        final /* synthetic */ TextView h;

        b(TextView textView, TextView textView2, TextView textView3) {
            this.f = textView;
            this.g = textView2;
            this.h = textView3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            s sVar = s.this;
            TextView textView = this.f;
            e.p.d.i.c(textView, "textView");
            TextView textView2 = this.g;
            e.p.d.i.c(textView2, "valueView");
            TextView textView3 = this.h;
            e.p.d.i.c(textView3, "countView");
            sVar.d(textView, textView2, textView3);
        }
    }

    public s(ActionParamInfo actionParamInfo, androidx.fragment.app.d dVar) {
        e.p.d.i.d(actionParamInfo, "actionParamInfo");
        e.p.d.i.d(dVar, "context");
        this.f1507e = actionParamInfo;
        this.f = dVar;
        this.f1504b = new boolean[0];
        this.f1505c = new String[0];
        this.f1506d = new String[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(TextView textView, TextView textView2, TextView textView3) {
        if (this.a != null) {
            ArrayList arrayList = new ArrayList();
            int length = this.f1505c.length;
            for (int i = 0; i < length; i++) {
                d.c.a.e.a aVar = new d.c.a.e.a();
                aVar.e("" + this.f1505c[i]);
                aVar.d(this.f1504b[i]);
                e.j jVar = e.j.a;
                arrayList.add(aVar);
            }
            new com.omarea.common.ui.f(true, new ArrayList(arrayList), true, new a(textView, textView2, textView3)).y1(this.f.o(), "params-multi-select");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(TextView textView, TextView textView2, TextView textView3) {
        String s;
        String s2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = this.f1504b.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.f1504b[i2]) {
                String str = this.f1506d[i2];
                if (str != null) {
                    arrayList.add(str);
                }
                String str2 = this.f1505c[i2];
                if (str2 != null) {
                    arrayList2.add(str2);
                }
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        String str3 = "";
        sb.append("");
        s = e.k.q.s(arrayList, this.f1507e.getSeparator(), null, null, 0, null, null, 62, null);
        sb.append(s);
        String sb2 = sb.toString();
        if (arrayList2.size() > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            s2 = e.k.q.s(arrayList2, "，", null, null, 0, null, null, 62, null);
            sb3.append(s2);
            str3 = sb3.toString();
        }
        textView.setText(str3);
        textView2.setText(sb2);
        textView3.setText(String.valueOf(i));
    }

    public final View e() {
        int g;
        int g2;
        ArrayList<d.c.a.e.a> optionsFromShell = this.f1507e.getOptionsFromShell();
        this.a = optionsFromShell;
        if (optionsFromShell != null) {
            g = e.k.j.g(optionsFromShell, 10);
            ArrayList arrayList = new ArrayList(g);
            Iterator<T> it = optionsFromShell.iterator();
            while (it.hasNext()) {
                arrayList.add(((d.c.a.e.a) it.next()).b());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            this.f1505c = (String[]) array;
            g2 = e.k.j.g(optionsFromShell, 10);
            ArrayList arrayList2 = new ArrayList(g2);
            Iterator<T> it2 = optionsFromShell.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((d.c.a.e.a) it2.next()).c());
            }
            Object[] array2 = arrayList2.toArray(new String[0]);
            if (array2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            this.f1506d = (String[]) array2;
            this.f1504b = d.c.b.p.b.f1451d.b(this.f1507e, optionsFromShell);
        }
        View inflate = LayoutInflater.from(this.f).inflate(d.c.b.g.kr_param_multiple_select, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.c.b.f.kr_param_label_text);
        TextView textView2 = (TextView) inflate.findViewById(d.c.b.f.kr_param_value_text);
        TextView textView3 = (TextView) inflate.findViewById(d.c.b.f.kr_param_count_text);
        e.p.d.i.c(textView2, "valueView");
        textView2.setTag(this.f1507e.getName());
        e.p.d.i.c(textView, "textView");
        e.p.d.i.c(textView3, "countView");
        f(textView, textView2, textView3);
        textView.setOnClickListener(new b(textView, textView2, textView3));
        e.p.d.i.c(inflate, "layout");
        return inflate;
    }
}
