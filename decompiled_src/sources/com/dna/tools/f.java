package com.dna.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.omarea.krscript.model.PageNode;

/* loaded from: classes.dex */
public final class f {
    private Activity a;

    public f(Activity activity) {
        e.p.d.i.d(activity, "activity");
        this.a = activity;
        new Handler(Looper.getMainLooper());
    }

    public final void a(PageNode pageNode) {
        e.p.d.i.d(pageNode, "pageNode");
        Intent intent = null;
        try {
            boolean z = true;
            if (!(pageNode.getOnlineHtmlPage().length() == 0)) {
                intent = new Intent(this.a, (Class<?>) ActionPageOnline.class);
                intent.addFlags(268435456);
                intent.putExtra("config", pageNode.getOnlineHtmlPage());
            }
            if (!(pageNode.getPageConfigSh().length() == 0)) {
                if (intent == null) {
                    intent = new Intent(this.a, (Class<?>) ActionPage.class);
                }
                intent.addFlags(268435456);
            }
            if (pageNode.getPageConfigPath().length() != 0) {
                z = false;
            }
            if (!z) {
                if (intent == null) {
                    intent = new Intent(this.a, (Class<?>) ActionPage.class);
                }
                intent.addFlags(268435456);
            }
            if (intent != null) {
                intent.putExtra("page", pageNode);
                this.a.startActivity(intent);
            }
        } catch (Exception e2) {
            Toast.makeText(this.a, "" + e2.getMessage(), 0).show();
        }
    }
}
