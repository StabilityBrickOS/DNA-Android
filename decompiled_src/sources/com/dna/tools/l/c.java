package com.dna.tools.l;

import d.c.a.g.d;

/* loaded from: classes.dex */
public class c {
    private static String a;

    /* renamed from: b, reason: collision with root package name */
    private static String f1014b;

    public static String a() {
        if (f1014b == null) {
            if (d.a.b("/sys/kernel/gpu/gpu_clock")) {
                f1014b = "/sys/kernel/gpu/gpu_clock";
            } else if (d.a.b("/sys/class/kgsl/kgsl-3d0/devfreq/cur_freq")) {
                f1014b = "/sys/class/kgsl/kgsl-3d0/devfreq/cur_freq";
            } else {
                f1014b = "";
            }
        }
        if (f1014b.isEmpty()) {
            return "";
        }
        String a2 = d.c.a.g.c.a.a(f1014b);
        return a2.length() > 6 ? a2.substring(0, a2.length() - 6) : a2;
    }

    public static int b() {
        if (a == null) {
            if (d.a.b("/sys/kernel/gpu/gpu_busy")) {
                a = "/sys/kernel/gpu/gpu_busy";
            } else if (d.a.b("/sys/class/kgsl/kgsl-3d0/devfreq/gpu_load")) {
                a = "/sys/class/kgsl/kgsl-3d0/devfreq/gpu_load";
            } else if (d.a.b("/sys/class/kgsl/kgsl-3d0/gpu_busy_percentage")) {
                a = "/sys/class/kgsl/kgsl-3d0/gpu_busy_percentage";
            } else {
                a = "";
            }
        }
        if (a.equals("")) {
            return -1;
        }
        try {
            return Integer.parseInt(d.c.a.g.c.a.a(a).replace("%", "").trim());
        } catch (Exception unused) {
            return -1;
        }
    }
}
