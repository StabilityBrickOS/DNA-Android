package c.f.i;

import android.util.Base64;
import c.f.k.h;
import java.util.List;

/* loaded from: classes.dex */
public final class a {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final String f729b;

    /* renamed from: c, reason: collision with root package name */
    private final String f730c;

    /* renamed from: d, reason: collision with root package name */
    private final List<List<byte[]>> f731d;

    /* renamed from: e, reason: collision with root package name */
    private final int f732e;
    private final String f;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        h.c(str);
        this.a = str;
        h.c(str2);
        this.f729b = str2;
        h.c(str3);
        this.f730c = str3;
        h.c(list);
        this.f731d = list;
        this.f732e = 0;
        this.f = this.a + "-" + this.f729b + "-" + this.f730c;
    }

    public List<List<byte[]>> a() {
        return this.f731d;
    }

    public int b() {
        return this.f732e;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.f729b;
    }

    public String f() {
        return this.f730c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.a + ", mProviderPackage: " + this.f729b + ", mQuery: " + this.f730c + ", mCertificates:");
        for (int i = 0; i < this.f731d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f731d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f732e);
        return sb.toString();
    }
}
