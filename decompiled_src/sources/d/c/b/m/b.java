package d.c.b.m;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.widget.Toast;
import com.omarea.common.ui.e;
import d.c.b.h;

/* loaded from: classes.dex */
public class b extends BroadcastReceiver {
    private static b a;

    public static void a(Context context) {
        if (a == null) {
            a = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
            context.registerReceiver(a, intentFilter);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction())) {
            return;
        }
        try {
            long longExtra = intent.getLongExtra("extra_download_id", -1L);
            DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
            TextUtils.isEmpty(downloadManager.getMimeTypeForDownloadedFile(longExtra));
            String b2 = new d.c.a.f.a().b(context, downloadManager.getUriForDownloadedFile(longExtra));
            if (b2 != null && !b2.isEmpty()) {
                new a(context, null).c(longExtra, b2);
                try {
                    e.f1255b.n(context, context.getString(h.kr_download_completed), "" + b2, null);
                } catch (Exception unused) {
                    Toast.makeText(context, context.getString(h.kr_download_completed) + "\n" + b2, 1).show();
                }
            }
        } catch (Exception unused2) {
        }
    }
}
