package d.c.a.g;

import e.p.d.i;

/* loaded from: classes.dex */
public final class d {
    public static final d a = new d();

    private d() {
    }

    public final boolean a(String str) {
        i.d(str, "path");
        return b.f1379c.b("if [[ -d \"" + str + "\" ]]; then echo 1; fi;").equals("1");
    }

    public final boolean b(String str) {
        i.d(str, "path");
        return b.f1379c.b("if [[ -f \"" + str + "\" ]]; then echo 1; fi;").equals("1");
    }
}
