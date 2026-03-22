package d.c.c.a;

import d.c.a.g.b;
import e.p.d.i;
import e.u.u;
import e.u.v;
import java.util.List;

/* loaded from: classes.dex */
public final class a {
    public final com.dna.tools.a a() {
        List<String> H;
        CharSequence R;
        int v;
        int v2;
        CharSequence R2;
        boolean k;
        boolean k2;
        boolean k3;
        H = v.H(b.f1379c.b("dumpsys battery"), new String[]{"\n"}, false, 0, 6, null);
        com.dna.tools.a aVar = new com.dna.tools.a();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (String str : H) {
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            R = v.R(str);
            String obj = R.toString();
            v = v.v(obj, ":", 0, false, 6, null);
            if (v > Integer.MIN_VALUE && v < obj.length() - 1) {
                v2 = v.v(obj, ":", 0, false, 6, null);
                int i = v2 + 1;
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String substring = obj.substring(i);
                i.c(substring, "(this as java.lang.String).substring(startIndex)");
                if (substring == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                R2 = v.R(substring);
                String obj2 = R2.toString();
                try {
                    k = u.k(obj, "status", false, 2, null);
                    if (!k) {
                        k2 = u.k(obj, "level", false, 2, null);
                        if (!k2) {
                            k3 = u.k(obj, "temperature", false, 2, null);
                            if (k3 && !z3) {
                                try {
                                    aVar.f980b = (float) (Float.parseFloat(obj2) / 10.0d);
                                } catch (Exception unused) {
                                }
                                z3 = true;
                            }
                        } else if (!z2) {
                            aVar.a = Integer.parseInt(obj2);
                            z2 = true;
                        }
                    } else if (!z) {
                        z = true;
                    }
                } catch (Exception unused2) {
                }
            }
        }
        return aVar;
    }
}
