package d.c.b.p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.omarea.krscript.model.NodeInfoBase;

/* loaded from: classes.dex */
public class k {
    private View a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f1470b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f1471c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f1472d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f1473e;
    private final int f;
    private final NodeInfoBase g;

    public k(Context context, int i, NodeInfoBase nodeInfoBase) {
        e.p.d.i.d(context, "context");
        e.p.d.i.d(nodeInfoBase, "config");
        this.f1473e = context;
        this.f = i;
        this.g = nodeInfoBase;
        View inflate = LayoutInflater.from(context).inflate(this.f, (ViewGroup) null);
        this.a = inflate;
        this.f1470b = (TextView) inflate.findViewById(d.c.b.f.kr_desc);
        this.f1471c = (TextView) this.a.findViewById(d.c.b.f.kr_summary);
        this.f1472d = (TextView) this.a.findViewById(d.c.b.f.kr_title);
        g(this.g.getTitle());
        e(this.g.getDesc());
        f(this.g.getSummary());
    }

    public final String a() {
        return this.g.getIndex();
    }

    public final String b() {
        return this.g.getKey();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View c() {
        return this.a;
    }

    public final View d() {
        View view = this.a;
        e.p.d.i.c(view, "layout");
        return view;
    }

    public final void e(String str) {
        e.p.d.i.d(str, "value");
        if (str.length() == 0) {
            TextView textView = this.f1470b;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = this.f1470b;
        if (textView2 != null) {
            textView2.setText(str);
        }
        TextView textView3 = this.f1470b;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
    }

    public final void f(String str) {
        e.p.d.i.d(str, "value");
        if (str.length() == 0) {
            TextView textView = this.f1471c;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = this.f1471c;
        if (textView2 != null) {
            textView2.setText(str);
        }
        TextView textView3 = this.f1471c;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
    }

    public final void g(String str) {
        e.p.d.i.d(str, "value");
        if (str.length() == 0) {
            TextView textView = this.f1472d;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = this.f1472d;
        if (textView2 != null) {
            textView2.setText(str);
        }
        TextView textView3 = this.f1472d;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
    }

    public void h() {
        if (this.g.getDescSh().length() > 0) {
            NodeInfoBase nodeInfoBase = this.g;
            String b2 = d.c.b.n.b.b(this.f1473e, nodeInfoBase.getDescSh(), this.g);
            e.p.d.i.c(b2, "ScriptEnvironmen.execute…t, config.descSh, config)");
            nodeInfoBase.setDesc(b2);
            e(this.g.getDesc());
        }
        if (this.g.getSummarySh().length() > 0) {
            NodeInfoBase nodeInfoBase2 = this.g;
            String b3 = d.c.b.n.b.b(this.f1473e, nodeInfoBase2.getSummarySh(), this.g);
            e.p.d.i.c(b3, "ScriptEnvironmen.execute…config.summarySh, config)");
            nodeInfoBase2.setSummary(b3);
            f(this.g.getSummary());
        }
    }
}
