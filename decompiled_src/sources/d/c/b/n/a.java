package d.c.b.n;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, String> f1421b = new HashMap<>();
    private Context a;

    public a(Context context) {
        this.a = context;
    }

    private String c(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (f1421b.containsKey(str)) {
            return f1421b.get(str);
        }
        if (str.startsWith("file:///android_asset/")) {
            str = str.substring(22);
        }
        String f = d.c.a.f.b.a.f(str, str, this.a);
        if (f != null) {
            f1421b.put(str, f);
        }
        return f;
    }

    public String a(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (f1421b.containsKey(str)) {
            return f1421b.get(str);
        }
        if (str.endsWith(".sh")) {
            return c(str);
        }
        if (str.startsWith("file:///android_asset/")) {
            str = str.substring(22);
        }
        String d2 = d.c.a.f.b.a.d(this.a.getAssets(), str, str, this.a);
        if (d2 != null) {
            f1421b.put(str, d2);
        }
        return d2;
    }

    public String b(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (f1421b.containsKey(str)) {
            return f1421b.get(str);
        }
        if (str.startsWith("file:///android_asset/")) {
            str = str.substring(22);
        } else if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        try {
            String[] list = this.a.getAssets().list(str);
            if (list == null || list.length <= 0) {
                return a(str);
            }
            for (String str2 : list) {
                b(str + "/" + str2);
            }
            String d2 = d(str);
            f1421b.put(str, d2);
            return d2;
        } catch (Exception unused) {
            return "";
        }
    }

    public String d(String str) {
        d.c.a.f.b bVar = d.c.a.f.b.a;
        Context context = this.a;
        if (str.startsWith("file:///android_asset/")) {
            str = str.substring(22);
        }
        return bVar.b(context, str);
    }
}
