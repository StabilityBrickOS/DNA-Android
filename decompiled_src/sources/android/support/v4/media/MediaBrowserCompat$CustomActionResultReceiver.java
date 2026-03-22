package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;

/* loaded from: classes.dex */
class MediaBrowserCompat$CustomActionResultReceiver extends b.a.a.a.b {
    private final String g;
    private final Bundle h;
    private final a i;

    @Override // b.a.a.a.b
    protected void f(int i, Bundle bundle) {
        if (this.i == null) {
            return;
        }
        MediaSessionCompat.a(bundle);
        if (i == -1) {
            this.i.a(this.g, this.h, bundle);
            return;
        }
        if (i == 0) {
            this.i.c(this.g, this.h, bundle);
            return;
        }
        if (i == 1) {
            this.i.b(this.g, this.h, bundle);
            return;
        }
        Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.h + ", resultData=" + bundle + ")");
    }
}
