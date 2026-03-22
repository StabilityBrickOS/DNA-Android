package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Parcel;

/* loaded from: classes.dex */
class f {
    public static void a(Object obj, Parcel parcel, int i) {
        ((MediaMetadata) obj).writeToParcel(parcel, i);
    }
}
