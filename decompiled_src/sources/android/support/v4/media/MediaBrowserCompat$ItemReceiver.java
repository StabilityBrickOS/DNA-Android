package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;

/* loaded from: classes.dex */
class MediaBrowserCompat$ItemReceiver extends b.a.a.a.b {
    private final String g;
    private final b h;

    @Override // b.a.a.a.b
    protected void f(int i, Bundle bundle) {
        MediaSessionCompat.a(bundle);
        if (i != 0 || bundle == null || !bundle.containsKey("media_item")) {
            this.h.a(this.g);
            return;
        }
        Parcelable parcelable = bundle.getParcelable("media_item");
        if (parcelable == null || (parcelable instanceof MediaBrowserCompat$MediaItem)) {
            this.h.b((MediaBrowserCompat$MediaItem) parcelable);
        } else {
            this.h.a(this.g);
        }
    }
}
