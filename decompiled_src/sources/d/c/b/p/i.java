package d.c.b.p;

import android.content.Context;
import android.widget.Switch;
import com.omarea.krscript.model.SwitchNode;

/* loaded from: classes.dex */
public final class i extends e {
    private Switch m;
    private final Context n;
    private final SwitchNode o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, SwitchNode switchNode) {
        super(context, d.c.b.g.kr_switch_list_item, switchNode);
        e.p.d.i.d(context, "context");
        e.p.d.i.d(switchNode, "config");
        this.n = context;
        this.o = switchNode;
        this.m = (Switch) c().findViewById(d.c.b.f.kr_switch);
        n(this.o.getChecked());
    }

    @Override // d.c.b.p.k
    public void h() {
        super.h();
        boolean z = true;
        if (this.o.getGetState().length() > 0) {
            String b2 = d.c.b.n.b.b(this.n, this.o.getGetState(), this.o);
            SwitchNode switchNode = this.o;
            if (!e.p.d.i.a(b2, "1")) {
                e.p.d.i.c(b2, "shellResult");
                if (b2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = b2.toLowerCase();
                e.p.d.i.c(lowerCase, "(this as java.lang.String).toLowerCase()");
                if (!e.p.d.i.a(lowerCase, "true")) {
                    z = false;
                }
            }
            switchNode.setChecked(z);
        }
        n(this.o.getChecked());
    }

    public final void n(boolean z) {
        Switch r0 = this.m;
        if (r0 != null) {
            r0.setChecked(z);
        }
    }
}
