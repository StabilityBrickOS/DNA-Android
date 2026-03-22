package androidx.media;

/* loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static c read(androidx.versionedparcelable.a aVar) {
        c cVar = new c();
        cVar.a = aVar.p(cVar.a, 1);
        cVar.f457b = aVar.p(cVar.f457b, 2);
        cVar.f458c = aVar.p(cVar.f458c, 3);
        cVar.f459d = aVar.p(cVar.f459d, 4);
        return cVar;
    }

    public static void write(c cVar, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.F(cVar.a, 1);
        aVar.F(cVar.f457b, 2);
        aVar.F(cVar.f458c, 3);
        aVar.F(cVar.f459d, 4);
    }
}
