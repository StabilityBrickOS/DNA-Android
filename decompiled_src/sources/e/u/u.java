package e.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends t {
    public static final boolean g(String str, String str2, boolean z) {
        e.p.d.i.d(str, "$this$endsWith");
        e.p.d.i.d(str2, "suffix");
        return !z ? str.endsWith(str2) : i(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean h(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return g(str, str2, z);
    }

    public static final boolean i(String str, int i, String str2, int i2, int i3, boolean z) {
        e.p.d.i.d(str, "$this$regionMatches");
        e.p.d.i.d(str2, "other");
        return !z ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z, i, str2, i2, i3);
    }

    public static final boolean j(String str, String str2, boolean z) {
        e.p.d.i.d(str, "$this$startsWith");
        e.p.d.i.d(str2, "prefix");
        return !z ? str.startsWith(str2) : i(str, 0, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean k(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return j(str, str2, z);
    }
}
