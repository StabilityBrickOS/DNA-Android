package d.c.b;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import e.u.u;
import e.u.v;
import java.util.List;

/* loaded from: classes.dex */
public final class j {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final String f1390b;

    public j(Context context, String str) {
        e.p.d.i.d(context, "context");
        e.p.d.i.d(str, "activity");
        this.a = context;
        this.f1390b = str;
    }

    private final Intent a() {
        boolean n;
        Intent intent;
        List H;
        boolean k;
        try {
            n = v.n(this.f1390b, "/", false, 2, null);
            if (n) {
                intent = new Intent("android.intent.action.VIEW");
                H = v.H(this.f1390b, new String[]{"/"}, false, 0, 6, null);
                String str = (String) e.k.g.n(H);
                String str2 = (String) e.k.g.t(H);
                k = u.k(str2, ".", false, 2, null);
                if (k) {
                    str2 = str + str2;
                }
                intent.setClassName(str, str2);
            } else {
                intent = new Intent(this.f1390b);
            }
            intent.addFlags(268435456);
            return intent;
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean b() {
        boolean k;
        boolean n;
        d.c.a.g.b bVar;
        StringBuilder sb;
        String str;
        boolean n2;
        boolean n3;
        k = u.k(this.f1390b, "am ", false, 2, null);
        if (k) {
            n3 = v.n(d.c.a.g.b.f1379c.b(this.f1390b), "Start", false, 2, null);
            return n3;
        }
        try {
            this.a.startActivity(a());
            return true;
        } catch (SecurityException unused) {
            n = v.n(this.f1390b, "/", false, 2, null);
            if (n) {
                bVar = d.c.a.g.b.f1379c;
                sb = new StringBuilder();
                str = "am start-activity -W -n ";
            } else {
                bVar = d.c.a.g.b.f1379c;
                sb = new StringBuilder();
                str = "am start-activity -W -a ";
            }
            sb.append(str);
            sb.append(this.f1390b);
            n2 = v.n(bVar.b(sb.toString()), "ok", false, 2, null);
            if (n2) {
                return true;
            }
            Context context = this.a;
            Toast.makeText(context, context.getString(h.kr_slice_activity_fail), 0).show();
            return false;
        } catch (Exception unused2) {
            Context context2 = this.a;
            Toast.makeText(context2, context2.getString(h.kr_slice_activity_fail), 0).show();
            return false;
        }
    }
}
