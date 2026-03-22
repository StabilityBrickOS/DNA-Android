package com.omarea.common.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.omarea.common.ui.e;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class h {

    /* renamed from: e, reason: collision with root package name */
    private static final LinkedHashMap<String, e.c> f1272e = new LinkedHashMap<>();
    private e.c a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f1273b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f1274c;

    /* renamed from: d, reason: collision with root package name */
    private String f1275d;

    public h(Activity activity, String str) {
        e.p.d.i.d(activity, "context");
        this.f1274c = activity;
        this.f1275d = str;
        a();
    }

    public /* synthetic */ h(Activity activity, String str, int i, e.p.d.e eVar) {
        this(activity, (i & 2) != 0 ? null : str);
    }

    public final void a() {
        try {
            if (this.a != null) {
                e.c cVar = this.a;
                e.p.d.i.b(cVar);
                cVar.a();
                e.c cVar2 = this.a;
                e.p.d.i.b(cVar2);
                cVar2.c();
                this.a = null;
            }
        } catch (Exception unused) {
        }
        String str = this.f1275d;
        if (str == null || !f1272e.containsKey(str)) {
            return;
        }
        f1272e.remove(str);
    }

    @SuppressLint({"InflateParams"})
    public final h b(String str) {
        e.p.d.i.d(str, "text");
        TextView textView = this.f1273b;
        if (textView == null || this.a == null) {
            a();
            View inflate = LayoutInflater.from(this.f1274c).inflate(d.c.a.b.dialog_loading, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.c.a.a.dialog_text);
            if (findViewById == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            TextView textView2 = (TextView) findViewById;
            this.f1273b = textView2;
            e.p.d.i.b(textView2);
            textView2.setText(str);
            e.a aVar = e.f1255b;
            Activity activity = this.f1274c;
            e.p.d.i.c(inflate, "dialog");
            this.a = aVar.h(activity, inflate, false);
        } else {
            e.p.d.i.b(textView);
            textView.setText(str);
        }
        String str2 = this.f1275d;
        if (str2 != null) {
            if (f1272e.containsKey(str2)) {
                f1272e.remove(str2);
            }
            e.c cVar = this.a;
            if (cVar != null) {
                LinkedHashMap<String, e.c> linkedHashMap = f1272e;
                e.p.d.i.b(cVar);
                linkedHashMap.put(str2, cVar);
            }
        }
        return this;
    }
}
