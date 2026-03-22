package d.c.b.p;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.omarea.common.ui.f;
import com.omarea.krscript.model.ActionParamInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class u {
    private final Integer a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1516b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<d.c.a.e.a> f1517c;

    /* renamed from: d, reason: collision with root package name */
    private int f1518d;

    /* renamed from: e, reason: collision with root package name */
    private ActionParamInfo f1519e;
    private androidx.fragment.app.d f;

    /* loaded from: classes.dex */
    public static final class a implements f.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f1520b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ TextView f1521c;

        a(TextView textView, TextView textView2) {
            this.f1520b = textView;
            this.f1521c = textView2;
        }

        @Override // com.omarea.common.ui.f.a
        public void a(List<d.c.a.e.a> list, boolean[] zArr) {
            int g;
            e.p.d.i.d(list, "selected");
            e.p.d.i.d(zArr, "status");
            u uVar = u.this;
            g = e.k.e.g(zArr, true);
            uVar.e(g);
            u.this.f(this.f1520b, this.f1521c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b implements View.OnClickListener {
        final /* synthetic */ TextView f;
        final /* synthetic */ TextView g;

        b(TextView textView, TextView textView2) {
            this.f = textView;
            this.g = textView2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            u uVar = u.this;
            TextView textView = this.f;
            e.p.d.i.c(textView, "valueView");
            TextView textView2 = this.g;
            e.p.d.i.c(textView2, "textView");
            uVar.c(textView, textView2);
        }
    }

    public u(ActionParamInfo actionParamInfo, androidx.fragment.app.d dVar) {
        View decorView;
        e.p.d.i.d(actionParamInfo, "actionParamInfo");
        e.p.d.i.d(dVar, "context");
        this.f1519e = actionParamInfo;
        this.f = dVar;
        Window window = dVar.getWindow();
        Integer valueOf = (window == null || (decorView = window.getDecorView()) == null) ? null : Integer.valueOf(decorView.getSystemUiVisibility());
        this.a = valueOf;
        this.f1516b = valueOf != null && (valueOf.intValue() & 8192) == 0;
        ArrayList<d.c.a.e.a> optionsFromShell = this.f1519e.getOptionsFromShell();
        e.p.d.i.b(optionsFromShell);
        this.f1517c = optionsFromShell;
        this.f1518d = d.c.b.p.b.f1451d.a(this.f1519e, optionsFromShell);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(TextView textView, TextView textView2) {
        int g;
        boolean z = this.f1516b;
        ArrayList<d.c.a.e.a> arrayList = this.f1517c;
        g = e.k.j.g(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(g);
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                e.k.g.f();
                throw null;
            }
            d.c.a.e.a aVar = new d.c.a.e.a();
            aVar.e(((d.c.a.e.a) obj).b());
            aVar.d(i == this.f1518d);
            arrayList2.add(aVar);
            i = i2;
        }
        new com.omarea.common.ui.f(z, new ArrayList(arrayList2), false, new a(textView, textView2)).y1(this.f.o(), "params-single-select");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(TextView textView, TextView textView2) {
        int i = this.f1518d;
        if (i <= -1 || i >= this.f1517c.size()) {
            textView.setText("");
            textView2.setText("");
        } else {
            textView.setText(this.f1517c.get(this.f1518d).c());
            textView2.setText(this.f1517c.get(this.f1518d).b());
        }
    }

    public final View d() {
        if (this.f1517c.size() > 5) {
            View inflate = LayoutInflater.from(this.f).inflate(d.c.b.g.kr_param_single_select, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.c.b.f.kr_param_single_select);
            TextView textView2 = (TextView) inflate.findViewById(d.c.b.f.kr_param_value);
            textView2.setTag(this.f1519e.getName());
            e.p.d.i.c(textView2, "this");
            e.p.d.i.c(textView, "textView");
            f(textView2, textView);
            textView.setOnClickListener(new b(textView2, textView));
            e.p.d.i.c(inflate, "layout");
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.f).inflate(d.c.b.g.kr_param_spinner, (ViewGroup) null);
        Spinner spinner = (Spinner) inflate2.findViewById(d.c.b.f.kr_param_spinner);
        spinner.setTag(this.f1519e.getName());
        ArrayAdapter arrayAdapter = new ArrayAdapter(spinner.getContext(), d.c.b.g.kr_spinner_default, d.c.b.f.text, this.f1517c);
        arrayAdapter.setDropDownViewResource(d.c.b.g.kr_spinner_dropdown);
        e.j jVar = e.j.a;
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setEnabled(!this.f1519e.getReadonly());
        int i = this.f1518d;
        if (i > -1 && i < this.f1517c.size()) {
            spinner.setSelection(this.f1518d);
        }
        e.p.d.i.c(inflate2, "layout");
        return inflate2;
    }

    public final void e(int i) {
        this.f1518d = i;
    }
}
