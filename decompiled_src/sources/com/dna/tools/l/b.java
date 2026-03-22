package com.dna.tools.l;

/* loaded from: classes.dex */
public class b {
    private static String a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f1013b = "";

    public b() {
        String b2 = d.c.a.g.c.a.b("/proc/stat", "^cpu");
        a = b2;
        f1013b = b2;
    }

    private long a(String[] strArr) {
        return Long.parseLong(strArr[4]);
    }

    private long b(String[] strArr) {
        long j = 0;
        for (int i = 1; i < strArr.length; i++) {
            j += Long.parseLong(strArr[i]);
        }
        return j;
    }

    public Double c() {
        String b2 = d.c.a.g.c.a.b("/proc/stat", "^cpu ");
        if (!b2.equals("error") && b2.startsWith("cpu")) {
            try {
                if (f1013b.isEmpty()) {
                    f1013b = b2;
                    Thread.sleep(100L);
                    return c();
                }
                String[] split = b2.split("\n");
                String[] split2 = f1013b.split("\n");
                for (String str : split) {
                    String[] split3 = str.replaceAll(" {2}", " ").split(" ");
                    if (split3[0].trim().equals("cpu")) {
                        for (String str2 : split2) {
                            if (str2.startsWith("cpu ")) {
                                f1013b = b2;
                                String[] split4 = str2.replaceAll(" {2}", " ").split(" ");
                                long b3 = b(split3);
                                long a2 = a(split3);
                                long b4 = b(split4);
                                long a3 = a(split4);
                                long j = b3 - b4;
                                if (j == 0) {
                                    return Double.valueOf(0.0d);
                                }
                                long j2 = a2 - a3;
                                return j2 < 1 ? Double.valueOf(100.0d) : Double.valueOf(100.0d - ((j2 * 100.0d) / j));
                            }
                        }
                        return Double.valueOf(0.0d);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return Double.valueOf(-1.0d);
    }
}
