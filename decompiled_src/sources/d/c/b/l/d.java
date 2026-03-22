package d.c.b.l;

import android.content.Context;
import android.content.res.AssetManager;
import e.k.g;
import e.k.q;
import e.p.d.i;
import e.u.u;
import e.u.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class d {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private String f1417b;

    /* renamed from: c, reason: collision with root package name */
    private Context f1418c;

    /* renamed from: d, reason: collision with root package name */
    private String f1419d;

    public d(Context context, String str) {
        i.d(context, "context");
        i.d(str, "parentDir");
        this.f1418c = context;
        this.f1419d = str;
        this.a = "file:///android_asset/";
        this.f1417b = "";
    }

    private final InputStream a(String str) {
        String f = f(this.f1419d, str);
        try {
            try {
                int length = this.a.length();
                if (f == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String substring = f.substring(length);
                i.c(substring, "(this as java.lang.String).substring(startIndex)");
                InputStream open = this.f1418c.getAssets().open(substring);
                this.f1417b = f;
                return open;
            } catch (Exception unused) {
                InputStream open2 = this.f1418c.getAssets().open(str);
                this.f1417b = this.a + str;
                return open2;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    private final InputStream b(String str) {
        if (this.f1419d.length() > 0) {
            String f = f(this.f1419d, str);
            File file = new File(f);
            if (file.exists() && file.canRead()) {
                String absolutePath = file.getAbsolutePath();
                i.c(absolutePath, "absolutePath");
                this.f1417b = absolutePath;
                return new FileInputStream(file);
            }
            InputStream g = g(f);
            if (g != null) {
                return g;
            }
        }
        String absolutePath2 = new File(f(d.c.a.f.b.a.a(this.f1418c), str)).getAbsolutePath();
        File file2 = new File(absolutePath2);
        if (file2.exists() && file2.canRead()) {
            String absolutePath3 = file2.getAbsolutePath();
            i.c(absolutePath3, "absolutePath");
            this.f1417b = absolutePath3;
            return new FileInputStream(file2);
        }
        i.c(absolutePath2, "privatePath");
        InputStream g2 = g(absolutePath2);
        if (g2 != null) {
            return g2;
        }
        return null;
    }

    private final InputStream d(String str) {
        boolean k;
        boolean k2;
        try {
            k = u.k(str, "/", false, 2, null);
            if (k) {
                this.f1417b = str;
                File file = new File(str);
                return (file.exists() && file.canRead()) ? new FileInputStream(file) : g(str);
            }
            if (this.f1419d.length() > 0) {
                k2 = u.k(this.f1419d, this.a, false, 2, null);
                if (k2) {
                    return a(str);
                }
            }
            return b(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private final String f(String str, String str2) {
        boolean k;
        List H;
        boolean k2;
        boolean k3;
        String str3;
        boolean h;
        List H2;
        String s;
        String s2;
        String str4 = str;
        k = u.k(str4, this.a, false, 2, null);
        if (k) {
            int length = this.a.length();
            if (str4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            str4 = str4.substring(length);
            i.c(str4, "(this as java.lang.String).substring(startIndex)");
        }
        H = v.H(str4, new String[]{"/"}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(H);
        k2 = u.k(str2, "../", false, 2, null);
        if (k2 && arrayList.size() > 0) {
            H2 = v.H(str2, new String[]{"/"}, false, 0, 6, null);
            ArrayList arrayList2 = new ArrayList(H2);
            while (true) {
                String str5 = (String) g.o(arrayList2);
                if (str5 == null || !i.a(str5, "..") || arrayList.size() <= 0) {
                    break;
                }
                arrayList.remove(arrayList.size() - 1);
                arrayList2.remove(0);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(k ? this.a : "");
            s = q.s(arrayList, "/", null, null, 0, null, null, 62, null);
            sb.append(s);
            String sb2 = sb.toString();
            s2 = q.s(arrayList2, "/", null, null, 0, null, null, 62, null);
            return f(sb2, s2);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(k ? this.a : "");
        if (!(str4.length() == 0)) {
            h = u.h(str4, "/", false, 2, null);
            if (!h) {
                str4 = str4 + "/";
            }
        }
        sb3.append(str4);
        k3 = u.k(str2, "./", false, 2, null);
        if (!k3) {
            str3 = str2;
        } else {
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            str3 = str2.substring(2);
            i.c(str3, "(this as java.lang.String).substring(startIndex)");
        }
        sb3.append(str3);
        return sb3.toString();
    }

    private final InputStream g(String str) {
        if (!d.c.a.g.d.a.b(str)) {
            return null;
        }
        File file = new File(d.c.a.f.b.a.b(this.f1418c, "kr-script"));
        if (!file.exists()) {
            file.mkdirs();
        }
        String b2 = d.c.a.f.b.a.b(this.f1418c, "kr-script/outside_file.cache");
        String a = new d.c.b.b(this.f1418c).a();
        d.c.a.g.b.f1379c.b("cp -f \"" + str + "\" \"" + b2 + "\"\nchmod 777 \"" + b2 + "\"\nchown " + a + ':' + a + " \"" + b2 + "\"\n");
        File file2 = new File(b2);
        if (file2.exists() && file2.canRead()) {
            return new FileInputStream(file2);
        }
        return null;
    }

    public final String c() {
        return this.f1417b;
    }

    public final InputStream e(String str) {
        boolean k;
        i.d(str, "filePath");
        try {
            k = u.k(str, this.a, false, 2, null);
            if (!k) {
                return d(str);
            }
            this.f1417b = str;
            AssetManager assets = this.f1418c.getAssets();
            String substring = str.substring(this.a.length());
            i.c(substring, "(this as java.lang.String).substring(startIndex)");
            return assets.open(substring);
        } catch (Exception unused) {
            return null;
        }
    }
}
