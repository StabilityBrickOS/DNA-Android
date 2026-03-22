package d.c.a.e;

import e.p.d.i;

/* loaded from: classes.dex */
public final class a {
    private String a;

    /* renamed from: b, reason: collision with root package name */
    private String f1365b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1366c;

    public final boolean a() {
        return this.f1366c;
    }

    public final String b() {
        return this.a;
    }

    public final String c() {
        return this.f1365b;
    }

    public final void d(boolean z) {
        this.f1366c = z;
    }

    public final void e(String str) {
        this.a = str;
    }

    public final void f(String str) {
        this.f1365b = str;
    }

    public String toString() {
        String str;
        String str2 = this.a;
        if (str2 == null || str2.length() == 0) {
            String str3 = this.f1365b;
            if (str3 == null || str3.length() == 0) {
                return "";
            }
            str = this.f1365b;
        } else {
            str = this.a;
        }
        i.b(str);
        return str;
    }
}
