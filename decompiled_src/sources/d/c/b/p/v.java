package d.c.b.p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.omarea.krscript.model.ActionParamInfo;

/* loaded from: classes.dex */
public final class v {
    private ActionParamInfo a;

    /* renamed from: b, reason: collision with root package name */
    private Context f1523b;

    /* loaded from: classes.dex */
    static final class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        public static final a f1524e = new a();

        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    public v(ActionParamInfo actionParamInfo, Context context) {
        e.p.d.i.d(actionParamInfo, "actionParamInfo");
        e.p.d.i.d(context, "context");
        this.a = actionParamInfo;
        this.f1523b = context;
    }

    private final boolean a(ActionParamInfo actionParamInfo, boolean z) {
        if (actionParamInfo.getValueFromShell() != null) {
            if (!e.p.d.i.a(actionParamInfo.getValueFromShell(), "1")) {
                String valueFromShell = actionParamInfo.getValueFromShell();
                e.p.d.i.b(valueFromShell);
                if (valueFromShell == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = valueFromShell.toLowerCase();
                e.p.d.i.c(lowerCase, "(this as java.lang.String).toLowerCase()");
                if (!e.p.d.i.a(lowerCase, "true")) {
                    return false;
                }
            }
            return true;
        }
        if (actionParamInfo.getValue() == null) {
            return z;
        }
        if (!e.p.d.i.a(actionParamInfo.getValue(), "1")) {
            String value = actionParamInfo.getValue();
            e.p.d.i.b(value);
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase2 = value.toLowerCase();
            e.p.d.i.c(lowerCase2, "(this as java.lang.String).toLowerCase()");
            if (!e.p.d.i.a(lowerCase2, "true")) {
                return false;
            }
        }
        return true;
    }

    public final View b() {
        View inflate = LayoutInflater.from(this.f1523b).inflate(d.c.b.g.kr_param_switch, (ViewGroup) null);
        CompoundButton compoundButton = (CompoundButton) inflate.findViewById(d.c.b.f.kr_param_switch);
        compoundButton.setTag(this.a.getName());
        compoundButton.setChecked(a(this.a, false));
        String label = this.a.getLabel();
        if (!(label == null || label.length() == 0)) {
            compoundButton.setText(this.a.getLabel());
        }
        compoundButton.setOnClickListener(a.f1524e);
        e.p.d.i.c(inflate, "layout");
        return inflate;
    }
}
