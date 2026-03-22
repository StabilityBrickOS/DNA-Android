package d.c.a.g;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class e {
    private static String a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f1380b = "";

    private static String a() {
        String str = a;
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (f1380b.isEmpty()) {
            try {
                Process exec = Runtime.getRuntime().exec("sh");
                OutputStream outputStream = exec.getOutputStream();
                outputStream.write("echo $PATH".getBytes());
                outputStream.flush();
                outputStream.close();
                InputStream inputStream = exec.getInputStream();
                byte[] bArr = new byte[16384];
                int read = inputStream.read(bArr);
                inputStream.close();
                exec.destroy();
                String trim = new String(bArr, 0, read).trim();
                if (trim.length() <= 0) {
                    throw new RuntimeException("Failed to get $PATH parameter");
                }
                f1380b = trim;
            } catch (Exception unused) {
                f1380b = "/sbin:/system/sbin:/system/bin:/system/xbin:/odm/bin:/vendor/bin:/vendor/xbin";
            }
        }
        return "PATH=" + f1380b + ":" + a;
    }

    private static Process b(String str) {
        String a2 = a();
        Process exec = Runtime.getRuntime().exec(str);
        if (a2 != null) {
            OutputStream outputStream = exec.getOutputStream();
            outputStream.write("export ".getBytes());
            outputStream.write(a2.getBytes());
            outputStream.write("\n".getBytes());
            outputStream.flush();
        }
        return exec;
    }

    public static Process c() {
        return b("sh");
    }

    public static Process d() {
        return b("su");
    }
}
