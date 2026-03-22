package androidx.media;

import android.media.AudioAttributes;

/* loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static b read(androidx.versionedparcelable.a aVar) {
        b bVar = new b();
        bVar.a = (AudioAttributes) aVar.r(bVar.a, 1);
        bVar.f456b = aVar.p(bVar.f456b, 2);
        return bVar;
    }

    public static void write(b bVar, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.H(bVar.a, 1);
        aVar.F(bVar.f456b, 2);
    }
}
