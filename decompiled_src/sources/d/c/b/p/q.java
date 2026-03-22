package d.c.b.p;

import android.content.Context;
import com.omarea.krscript.model.ActionParamInfo;

/* loaded from: classes.dex */
public final class q {
    private ActionParamInfo a;

    /* renamed from: b, reason: collision with root package name */
    private Context f1499b;

    public q(ActionParamInfo actionParamInfo, Context context) {
        e.p.d.i.d(actionParamInfo, "actionParamInfo");
        e.p.d.i.d(context, "context");
        this.a = actionParamInfo;
        this.f1499b = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View a() {
        /*
            r6 = this;
            android.content.Context r0 = r6.f1499b
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = d.c.b.g.kr_param_text
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r2)
            int r1 = d.c.b.f.kr_param_text
            android.view.View r1 = r0.findViewById(r1)
            android.widget.EditText r1 = (android.widget.EditText) r1
            com.omarea.krscript.model.ActionParamInfo r2 = r6.a
            java.lang.String r2 = r2.getName()
            r1.setTag(r2)
            com.omarea.krscript.model.ActionParamInfo r2 = r6.a
            java.lang.String r2 = r2.getValueFromShell()
            if (r2 == 0) goto L30
            com.omarea.krscript.model.ActionParamInfo r2 = r6.a
            java.lang.String r2 = r2.getValueFromShell()
        L2c:
            r1.setText(r2)
            goto L3f
        L30:
            com.omarea.krscript.model.ActionParamInfo r2 = r6.a
            java.lang.String r2 = r2.getValue()
            if (r2 == 0) goto L3f
            com.omarea.krscript.model.ActionParamInfo r2 = r6.a
            java.lang.String r2 = r2.getValue()
            goto L2c
        L3f:
            r2 = 1
            com.omarea.krscript.model.ParamInfoFilter[] r3 = new com.omarea.krscript.model.ParamInfoFilter[r2]
            com.omarea.krscript.model.ParamInfoFilter r4 = new com.omarea.krscript.model.ParamInfoFilter
            com.omarea.krscript.model.ActionParamInfo r5 = r6.a
            r4.<init>(r5)
            r5 = 0
            r3[r5] = r4
            r1.setFilters(r3)
            com.omarea.krscript.model.ActionParamInfo r3 = r6.a
            boolean r3 = r3.getReadonly()
            r3 = r3 ^ r2
            r1.setEnabled(r3)
            com.omarea.krscript.model.ActionParamInfo r3 = r6.a
            java.lang.String r3 = r3.getPlaceholder()
            int r3 = r3.length()
            if (r3 <= 0) goto L66
            goto L67
        L66:
            r2 = 0
        L67:
            if (r2 == 0) goto L73
            com.omarea.krscript.model.ActionParamInfo r2 = r6.a
            java.lang.String r2 = r2.getPlaceholder()
        L6f:
            r1.setHint(r2)
            goto Lc5
        L73:
            com.omarea.krscript.model.ActionParamInfo r2 = r6.a
            java.lang.String r2 = r2.getType()
            java.lang.String r3 = "int"
            boolean r2 = e.p.d.i.a(r2, r3)
            if (r2 != 0) goto L8f
            com.omarea.krscript.model.ActionParamInfo r2 = r6.a
            java.lang.String r2 = r2.getType()
            java.lang.String r3 = "number"
            boolean r2 = e.p.d.i.a(r2, r3)
            if (r2 == 0) goto Lc5
        L8f:
            com.omarea.krscript.model.ActionParamInfo r2 = r6.a
            int r2 = r2.getMin()
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 != r3) goto La4
            com.omarea.krscript.model.ActionParamInfo r2 = r6.a
            int r2 = r2.getMax()
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 == r3) goto Lc5
        La4:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.omarea.krscript.model.ActionParamInfo r3 = r6.a
            int r3 = r3.getMin()
            r2.append(r3)
            java.lang.String r3 = " ~ "
            r2.append(r3)
            com.omarea.krscript.model.ActionParamInfo r3 = r6.a
            int r3 = r3.getMax()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            goto L6f
        Lc5:
            java.lang.String r1 = "layout"
            e.p.d.i.c(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.b.p.q.a():android.view.View");
    }
}
