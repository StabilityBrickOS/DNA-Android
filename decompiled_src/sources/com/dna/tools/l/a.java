package com.dna.tools.l;

import java.io.File;
import java.util.HashMap;

/* loaded from: classes.dex */
public class a {
    private static String a = "";

    private static long a(String[] strArr) {
        return Long.parseLong(strArr[4]);
    }

    private static long b(String[] strArr) {
        long j = 0;
        for (int i = 1; i < strArr.length; i++) {
            j += Long.parseLong(strArr[i]);
        }
        return j;
    }

    public static int c() {
        int i = 0;
        while (true) {
            if (!new File("/sys/devices/system/cpu/cpu0/".replace("cpu0", "cpu" + i)).exists()) {
                return i;
            }
            i++;
        }
    }

    private static int d(String[] strArr) {
        if (strArr[0].equals("cpu")) {
            return -1;
        }
        return Integer.parseInt(strArr[0].substring(3));
    }

    public static HashMap<Integer, Double> e() {
        Integer valueOf;
        Double d2;
        HashMap<Integer, Double> hashMap = new HashMap<>();
        String b2 = d.c.a.g.c.a.b("/proc/stat", "^cpu");
        if (!b2.equals("error") && b2.startsWith("cpu")) {
            try {
                if (a.isEmpty()) {
                    a = b2;
                    Thread.sleep(100L);
                    return e();
                }
                String[] split = b2.split("\n");
                String[] split2 = a.split("\n");
                for (String str : split) {
                    String[] split3 = str.replaceAll(" {2}", " ").split(" ");
                    String[] strArr = null;
                    int length = split2.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        String str2 = split2[i];
                        if (str2.startsWith(split3[0] + " ")) {
                            strArr = str2.replaceAll(" {2}", " ").split(" ");
                            break;
                        }
                        i++;
                    }
                    if (strArr == null || strArr.length == 0) {
                        valueOf = Integer.valueOf(d(split3));
                    } else {
                        long b3 = b(split3);
                        long a2 = a(split3);
                        long b4 = b(strArr);
                        long a3 = a(strArr);
                        long j = b3 - b4;
                        if (j == 0) {
                            valueOf = Integer.valueOf(d(split3));
                        } else {
                            long j2 = a2 - a3;
                            double d3 = 100.0d;
                            if (j2 < 1) {
                                valueOf = Integer.valueOf(d(split3));
                            } else {
                                d3 = 100.0d - ((j2 * 100.0d) / j);
                                valueOf = Integer.valueOf(d(split3));
                            }
                            d2 = Double.valueOf(d3);
                            hashMap.put(valueOf, d2);
                        }
                    }
                    d2 = Double.valueOf(0.0d);
                    hashMap.put(valueOf, d2);
                }
                a = b2;
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }

    public static int f() {
        String b2 = d.c.a.g.b.f1379c.b("cat /sys/devices/system/cpu/cpu*/cpufreq/cpuinfo_cur_freq");
        if (b2.equals("error")) {
            return 0;
        }
        int i = 0;
        for (String str : b2.split("\n")) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt > i) {
                    i = parseInt;
                }
            } catch (Exception unused) {
            }
        }
        return i;
    }

    public static String g(String str) {
        return d.c.a.g.c.a.a("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_cur_freq".replace("cpu0", str));
    }

    public static String h(String str) {
        return d.c.a.g.c.a.a("/sys/devices/system/cpu/cpu0/cpufreq/scaling_max_freq".replace("cpu0", str));
    }

    public static String i(String str) {
        return d.c.a.g.c.a.a("/sys/devices/system/cpu/cpu0/cpufreq/scaling_min_freq".replace("cpu0", str));
    }
}
