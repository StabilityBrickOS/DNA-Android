package d.c.a.f;

/* loaded from: classes.dex */
public class c {
    public static String a = "/sbin/.core/img/scene_systemless/";

    /* renamed from: b, reason: collision with root package name */
    private static String f1367b = "/data/adb/modules";

    /* renamed from: c, reason: collision with root package name */
    private static String f1368c = "/sbin/.core/img";

    /* renamed from: d, reason: collision with root package name */
    private static String f1369d = "/sbin/.magisk/img";

    /* renamed from: e, reason: collision with root package name */
    private static String f1370e = "scene_systemless";
    private static int f = -1;
    private static int g;

    public static boolean a() {
        String str;
        if (f == -1 || g < 1) {
            String b2 = d.c.a.g.b.f1379c.b("magisk -V");
            if (b2.equals("error")) {
                f = 0;
            } else {
                try {
                    int parseInt = Integer.parseInt(b2) / 1000;
                    g = parseInt;
                    int i = parseInt >= 17 ? 1 : 0;
                    f = i;
                    if (i == 1) {
                        if (g >= 19) {
                            str = f1367b + "/" + f1370e + "/";
                        } else if (d.c.a.g.d.a.a(f1368c)) {
                            str = f1368c + "/" + f1370e + "/";
                        } else if (d.c.a.g.d.a.a(f1369d)) {
                            str = f1369d + "/" + f1370e + "/";
                        }
                        a = str;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return f == 1;
    }

    public static boolean b() {
        if (a()) {
            if (d.c.a.g.d.a.b(a + "module.prop")) {
                return true;
            }
        }
        return false;
    }
}
