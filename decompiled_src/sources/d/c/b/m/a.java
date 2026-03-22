package d.c.b.m;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.omarea.common.ui.e;
import d.c.b.h;
import e.p.d.e;
import e.p.d.i;
import java.io.File;
import java.nio.charset.Charset;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f1420b = "kr_downloader";
    private Context a;

    public a(Context context, Activity activity) {
        i.d(context, "context");
        this.a = context;
    }

    public /* synthetic */ a(Context context, Activity activity, int i, e eVar) {
        this(context, (i & 2) != 0 ? null : activity);
    }

    private final void a(long j, String str, String str2) {
        SharedPreferences sharedPreferences = this.a.getSharedPreferences(f1420b, 0);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", str2);
        jSONObject.put("taskAliasId", str);
        sharedPreferences.edit().putString(String.valueOf(j), jSONObject.toString(2)).apply();
    }

    public final Long b(String str, String str2, String str3, String str4) {
        i.d(str, "url");
        i.d(str4, "taskAliasId");
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            request.setAllowedOverMetered(true);
            request.setVisibleInDownloadsUi(true);
            request.setAllowedOverRoaming(true);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(str, str2, str3));
            Object systemService = this.a.getSystemService("download");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.DownloadManager");
            }
            long enqueue = ((DownloadManager) systemService).enqueue(request);
            a(enqueue, str4, str);
            Toast.makeText(this.a, this.a.getString(h.kr_download_create_success), 0).show();
            b.a(this.a.getApplicationContext());
            return Long.valueOf(enqueue);
        } catch (Exception e2) {
            e.a aVar = com.omarea.common.ui.e.f1255b;
            Context context = this.a;
            String string = context.getString(h.kr_download_create_fail);
            i.c(string, "context.getString(R.stri….kr_download_create_fail)");
            e.a.o(aVar, context, string, "" + e2.getMessage(), null, 8, null);
            return null;
        }
    }

    public final void c(long j, String str) {
        String str2;
        i.d(str, "absPath");
        SharedPreferences sharedPreferences = this.a.getSharedPreferences(f1420b, 0);
        String string = sharedPreferences.getString(String.valueOf(j), null);
        if (string != null) {
            JSONObject jSONObject = new JSONObject(string);
            jSONObject.put("absPath", str);
            sharedPreferences.edit().putString(String.valueOf(j), jSONObject.toString(2)).apply();
            str2 = jSONObject.getString("taskAliasId");
        } else {
            str2 = "";
        }
        try {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                String b2 = new c().b(file);
                i.c(b2, "FileMD5().getFileMD5(file)");
                if (b2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = b2.toLowerCase();
                i.c(lowerCase, "(this as java.lang.String).toLowerCase()");
                d.c.a.f.b bVar = d.c.a.f.b.a;
                Charset defaultCharset = Charset.defaultCharset();
                i.c(defaultCharset, "Charset.defaultCharset()");
                byte[] bytes = str.getBytes(defaultCharset);
                i.c(bytes, "(this as java.lang.String).getBytes(charset)");
                bVar.e(bytes, "downloader/path/" + lowerCase, this.a);
                if (str2 != null) {
                    d.c.a.f.b bVar2 = d.c.a.f.b.a;
                    Charset defaultCharset2 = Charset.defaultCharset();
                    i.c(defaultCharset2, "Charset.defaultCharset()");
                    byte[] bytes2 = str.getBytes(defaultCharset2);
                    i.c(bytes2, "(this as java.lang.String).getBytes(charset)");
                    bVar2.e(bytes2, "downloader/result/" + str2, this.a);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void d(String str, int i) {
        i.d(str, "taskAliasId");
        d.c.a.f.b bVar = d.c.a.f.b.a;
        String valueOf = String.valueOf(i);
        Charset defaultCharset = Charset.defaultCharset();
        i.c(defaultCharset, "Charset.defaultCharset()");
        if (valueOf == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = valueOf.getBytes(defaultCharset);
        i.c(bytes, "(this as java.lang.String).getBytes(charset)");
        bVar.e(bytes, "downloader/status/" + str, this.a);
    }
}
