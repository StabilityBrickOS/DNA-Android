package d.c.a.f;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import e.p.d.i;
import e.u.h;
import e.u.u;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class b {
    public static final b a = new b();

    static {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        i.c(externalStorageDirectory, "Environment.getExternalStorageDirectory()");
        i.c(externalStorageDirectory.getAbsolutePath(), "Environment.getExternalS…eDirectory().absolutePath");
    }

    private b() {
    }

    private final byte[] c(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            int read = open.read(bArr);
            if (read < 0) {
                read = 0;
            }
            String replace = new h("\r\t").replace(new h("\r\n").replace(new String(bArr, 0, read, e.u.c.a), "\n"), "\t");
            Charset charset = e.u.c.a;
            if (replace == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = replace.getBytes(charset);
            i.c(bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes;
        } catch (Exception e2) {
            Log.e("script-parse", "" + e2.getMessage());
            byte[] bytes2 = "".getBytes(e.u.c.a);
            i.c(bytes2, "(this as java.lang.String).getBytes(charset)");
            return bytes2;
        }
    }

    public final String a(Context context) {
        i.d(context, "context");
        StringBuilder sb = new StringBuilder();
        File filesDir = context.getFilesDir();
        i.c(filesDir, "context.filesDir");
        sb.append(filesDir.getAbsolutePath());
        sb.append("/");
        return sb.toString();
    }

    public final String b(Context context, String str) {
        boolean k;
        i.d(context, "context");
        i.d(str, "outName");
        StringBuilder sb = new StringBuilder();
        sb.append(a(context));
        k = u.k(str, "/", false, 2, null);
        if (k) {
            str = str.substring(1, str.length());
            i.c(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        sb.append(str);
        return sb.toString();
    }

    public final String d(AssetManager assetManager, String str, String str2, Context context) {
        boolean k;
        i.d(assetManager, "assetManager");
        i.d(str, "file");
        i.d(str2, "outName");
        i.d(context, "context");
        try {
            k = u.k(str, "file:///android_asset/", false, 2, null);
            if (k) {
                str = str.substring(22);
                i.c(str, "(this as java.lang.String).substring(startIndex)");
            }
            InputStream open = assetManager.open(str);
            File file = new File(a(context));
            if (!file.exists()) {
                file.mkdirs();
            }
            String b2 = b(context, str2);
            File parentFile = new File(b2).getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(b2);
            byte[] bArr = new byte[20480];
            while (true) {
                int read = open.read(bArr);
                if (read <= 0) {
                    fileOutputStream.close();
                    open.close();
                    File file2 = new File(b2);
                    file2.setWritable(true);
                    file2.setExecutable(true);
                    file2.setReadable(true);
                    return b2;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e2) {
            Log.e("writePrivateFile", "" + e2.getMessage());
            e2.printStackTrace();
            return null;
        }
    }

    public final boolean e(byte[] bArr, String str, Context context) {
        i.d(bArr, "bytes");
        i.d(str, "outName");
        i.d(context, "context");
        try {
            File file = new File(a(context));
            if (!file.exists()) {
                file.mkdirs();
            }
            String b2 = b(context, str);
            File parentFile = new File(b2).getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(b2);
            fileOutputStream.write(bArr, 0, bArr.length);
            fileOutputStream.close();
            new File(b2).setExecutable(true, false);
            File file2 = new File(b2);
            file2.setWritable(true);
            file2.setExecutable(true);
            file2.setReadable(true);
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final String f(String str, String str2, Context context) {
        i.d(str, "file");
        i.d(str2, "outName");
        i.d(context, "context");
        byte[] c2 = c(context, str);
        if (c2.length <= 0 || !e(c2, str2, context)) {
            return null;
        }
        return b(context, str2);
    }
}
