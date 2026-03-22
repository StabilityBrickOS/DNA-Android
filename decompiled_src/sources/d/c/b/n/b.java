package d.c.b.n;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import com.omarea.krscript.model.NodeInfoBase;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class b {
    private static boolean a = false;

    /* renamed from: b, reason: collision with root package name */
    private static String f1422b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f1423c = "";

    /* renamed from: d, reason: collision with root package name */
    private static boolean f1424d;

    /* renamed from: e, reason: collision with root package name */
    private static d.c.a.g.a f1425e;

    private static String a(Context context, String str) {
        String str2 = "kr-script/cache/" + m(str) + ".sh";
        if (new File(str2).exists()) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("#!/system/bin/sh\n\n");
        sb.append(str);
        return d.c.a.f.b.a.e(sb.toString().replaceAll("\r\n", "\n").replaceAll("\r\t", "\t").replaceAll("\r", "\n").getBytes(), str2, context) ? d.c.a.f.b.a.b(context, str2) : "";
    }

    public static String b(Context context, String str, NodeInfoBase nodeInfoBase) {
        if (!a) {
            j(context);
        }
        if (str == null || str.isEmpty()) {
            return "";
        }
        String trim = str.trim();
        String d2 = trim.startsWith("file:///android_asset/") ? d(context, trim) : a(context, str);
        if (!a) {
            j(context);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        if (nodeInfoBase == null || nodeInfoBase.getCurrentPageConfigPath().isEmpty()) {
            sb.append("export PAGE_CONFIG_DIR=''\n");
            sb.append("export PAGE_CONFIG_FILE=''\n");
            sb.append("export PAGE_WORK_DIR=''\n");
            sb.append("export PAGE_WORK_DIR=''\n");
        } else {
            String pageConfigDir = nodeInfoBase.getPageConfigDir();
            String currentPageConfigPath = nodeInfoBase.getCurrentPageConfigPath();
            sb.append("export PAGE_CONFIG_DIR='");
            sb.append(pageConfigDir);
            sb.append("'\n");
            sb.append("export PAGE_CONFIG_FILE='");
            sb.append(currentPageConfigPath);
            sb.append("'\n");
            boolean startsWith = currentPageConfigPath.startsWith("file:///android_asset/");
            sb.append("export PAGE_WORK_DIR='");
            if (startsWith) {
                sb.append(new a(context).d(pageConfigDir));
                sb.append("'\n");
                sb.append("export PAGE_WORK_FILE='");
                sb.append(new a(context).d(currentPageConfigPath));
            } else {
                sb.append(pageConfigDir);
                sb.append("'\n");
                sb.append("export PAGE_WORK_FILE='");
                sb.append(currentPageConfigPath);
            }
            sb.append("'\n");
        }
        sb.append("\n\n");
        sb.append(f1422b + " \"" + d2 + "\"");
        return f1425e.m(sb.toString());
    }

    public static void c(Context context, DataOutputStream dataOutputStream, String str, HashMap<String, String> hashMap, NodeInfoBase nodeInfoBase, String str2) {
        String str3;
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        if (nodeInfoBase != null) {
            String pageConfigDir = nodeInfoBase.getPageConfigDir();
            str3 = nodeInfoBase.getCurrentPageConfigPath();
            hashMap.put("PAGE_CONFIG_DIR", pageConfigDir);
            hashMap.put("PAGE_CONFIG_FILE", str3);
            if (str3.startsWith("file:///android_asset/")) {
                hashMap.put("PAGE_WORK_DIR", new a(context).d(pageConfigDir));
                str3 = new a(context).d(str3);
            } else {
                hashMap.put("PAGE_WORK_DIR", pageConfigDir);
            }
        } else {
            str3 = "";
            hashMap.put("PAGE_CONFIG_DIR", "");
            hashMap.put("PAGE_CONFIG_FILE", "");
            hashMap.put("PAGE_WORK_DIR", "");
        }
        hashMap.put("PAGE_WORK_FILE", str3);
        ArrayList<String> i = i(hashMap);
        StringBuilder sb = new StringBuilder();
        if (i.size() > 0) {
            Iterator<String> it = i.iterator();
            while (it.hasNext()) {
                String next = it.next();
                sb.append("export ");
                sb.append(next);
                sb.append("\n");
            }
        }
        try {
            dataOutputStream.write(sb.toString().getBytes("UTF-8"));
            dataOutputStream.write(f(context, str, str2).getBytes("UTF-8"));
            dataOutputStream.writeBytes("\n\n");
            dataOutputStream.writeBytes("sleep 0.2;\n");
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
        } catch (Exception unused) {
        }
    }

    private static String d(Context context, String str) {
        if (str.startsWith("file:///android_asset/")) {
            str = str.substring(22);
        }
        return d.c.a.f.b.a.f(str, str, context);
    }

    private static HashMap<String, String> e(Context context) {
        StringBuilder sb;
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("TOOLKIT", f1423c);
        if (d.c.a.f.c.b()) {
            if (d.c.a.f.c.a.endsWith("/")) {
                str = d.c.a.f.c.a.substring(0, r1.length() - 1);
            } else {
                str = d.c.a.f.c.a;
            }
            hashMap.put("MAGISK_PATH", str);
        } else {
            hashMap.put("MAGISK_PATH", "");
        }
        hashMap.put("START_DIR", h(context));
        hashMap.put("TEMP_DIR", context.getCacheDir().getAbsolutePath());
        d.c.b.b bVar = new d.c.b.b(context);
        hashMap.put("ANDROID_UID", "" + bVar.b());
        try {
            hashMap.put("APP_USER_ID", bVar.a());
        } catch (Exception unused) {
        }
        hashMap.put("ANDROID_SDK", "" + Build.VERSION.SDK_INT);
        hashMap.put("ROOT_PERMISSION", f1424d ? "true" : "false");
        hashMap.put("SDCARD_PATH", Environment.getExternalStorageDirectory().getAbsolutePath());
        String b2 = d.c.a.f.b.a.b(context, "busybox");
        if (new File(d.c.a.f.b.a.b(context, "busybox")).exists()) {
            hashMap.put("BUSYBOX", b2);
        } else {
            hashMap.put("BUSYBOX", "busybox");
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            hashMap.put("PACKAGE_NAME", context.getPackageName());
            hashMap.put("PACKAGE_VERSION_NAME", packageInfo.versionName);
            if (Build.VERSION.SDK_INT >= 28) {
                sb = new StringBuilder();
                sb.append("");
                sb.append(packageInfo.getLongVersionCode());
            } else {
                sb = new StringBuilder();
                sb.append("");
                sb.append(packageInfo.versionCode);
            }
            hashMap.put("PACKAGE_VERSION_CODE", sb.toString());
        } catch (Exception unused2) {
        }
        return hashMap;
    }

    private static String f(Context context, String str, String str2) {
        if (!a) {
            j(context);
        }
        if (str == null || str.isEmpty()) {
            return "";
        }
        String trim = str.trim();
        if (trim.startsWith("file:///android_asset/")) {
            String d2 = d(context, trim);
            if (d2 != null) {
                str = d2;
            }
        } else {
            str = a(context, str);
        }
        return f1422b + " \"" + str + "\" \"" + str2 + "\"";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Process g() {
        try {
            return f1424d ? Runtime.getRuntime().exec("su") : Runtime.getRuntime().exec("sh");
        } catch (Exception unused) {
            return null;
        }
    }

    private static String h(Context context) {
        String a2 = d.c.a.f.b.a.a(context);
        return a2.endsWith("/") ? a2.substring(0, a2.length() - 1) : a2;
    }

    private static ArrayList<String> i(HashMap<String, String> hashMap) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                String str2 = hashMap.get(str);
                if (str2 == null) {
                    str2 = "";
                }
                arrayList.add(str + "='" + str2.replaceAll("'", "'\\\\''") + "'");
            }
        }
        return arrayList;
    }

    private static boolean j(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("kr-script-config", 0);
        return k(context, sharedPreferences.getString("executor", "kr-script/executor.sh"), sharedPreferences.getString("toolkitDir", "kr-script/toolkit"));
    }

    public static boolean k(Context context, String str, String str2) {
        if (a) {
            return true;
        }
        f1424d = d.c.a.g.b.f1379c.a();
        if (str2 != null) {
            try {
                if (!str2.isEmpty()) {
                    f1423c = new a(context).b(str2);
                }
            } catch (Exception unused) {
                return false;
            }
        }
        String substring = str.startsWith("file:///android_asset/") ? str.substring(22) : str;
        InputStream open = context.getAssets().open(substring);
        int available = open.available();
        byte[] bArr = new byte[available];
        open.read(bArr, 0, available);
        String replaceAll = new String(bArr, Charset.defaultCharset()).replaceAll("\r", "");
        HashMap<String, String> e2 = e(context);
        for (String str3 : e2.keySet()) {
            String str4 = e2.get(str3);
            if (str4 == null) {
                str4 = "";
            }
            replaceAll = replaceAll.replace("$({" + str3 + "})", str4);
        }
        String b2 = d.c.a.f.b.a.b(context, substring);
        boolean e3 = d.c.a.f.b.a.e(replaceAll.replace("$({EXECUTOR_PATH})", b2).getBytes(Charset.defaultCharset()), substring, context);
        a = e3;
        if (e3) {
            f1422b = b2;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("kr-script-config", 0).edit();
        edit.putString("executor", str);
        edit.putString("toolkitDir", str2);
        edit.apply();
        f1425e = f1424d ? d.c.a.g.b.f1379c.c() : new d.c.a.g.a(f1424d);
        return a;
    }

    public static boolean l() {
        return a;
    }

    private static String m(String str) {
        if (str.isEmpty()) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
