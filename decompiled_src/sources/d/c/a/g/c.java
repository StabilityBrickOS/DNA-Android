package d.c.a.g;

import e.p.d.i;

/* loaded from: classes.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    public final String a(String str) {
        i.d(str, "propName");
        return b.f1379c.b("if [[ -e \"" + str + "\" ]]; then cat \"" + str + "\"; fi;");
    }

    public final String b(String str, String str2) {
        i.d(str, "propName");
        i.d(str2, "grep");
        return b.f1379c.b("if [[ -e \"" + str + "\" ]]; then cat \"" + str + "\" | grep \"" + str2 + "\"; fi;");
    }
}
