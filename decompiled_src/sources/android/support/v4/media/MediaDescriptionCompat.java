package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.d;
import android.support.v4.media.e;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    private final String f9e;
    private final CharSequence f;
    private final CharSequence g;
    private final CharSequence h;
    private final Bitmap i;
    private final Uri j;
    private final Bundle k;
    private final Uri l;
    private Object m;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<MediaDescriptionCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return Build.VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.f(d.a(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private String a;

        /* renamed from: b, reason: collision with root package name */
        private CharSequence f10b;

        /* renamed from: c, reason: collision with root package name */
        private CharSequence f11c;

        /* renamed from: d, reason: collision with root package name */
        private CharSequence f12d;

        /* renamed from: e, reason: collision with root package name */
        private Bitmap f13e;
        private Uri f;
        private Bundle g;
        private Uri h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.a, this.f10b, this.f11c, this.f12d, this.f13e, this.f, this.g, this.h);
        }

        public b b(CharSequence charSequence) {
            this.f12d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f13e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f = uri;
            return this;
        }

        public b f(String str) {
            this.a = str;
            return this;
        }

        public b g(Uri uri) {
            this.h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f11c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f10b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f9e = parcel.readString();
        this.f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.i = (Bitmap) parcel.readParcelable(classLoader);
        this.j = (Uri) parcel.readParcelable(classLoader);
        this.k = parcel.readBundle(classLoader);
        this.l = (Uri) parcel.readParcelable(classLoader);
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f9e = str;
        this.f = charSequence;
        this.g = charSequence2;
        this.h = charSequence3;
        this.i = bitmap;
        this.j = uri;
        this.k = bundle;
        this.l = uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.support.v4.media.MediaDescriptionCompat f(java.lang.Object r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L80
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L80
            android.support.v4.media.MediaDescriptionCompat$b r1 = new android.support.v4.media.MediaDescriptionCompat$b
            r1.<init>()
            java.lang.String r2 = android.support.v4.media.d.f(r8)
            r1.f(r2)
            java.lang.CharSequence r2 = android.support.v4.media.d.h(r8)
            r1.i(r2)
            java.lang.CharSequence r2 = android.support.v4.media.d.g(r8)
            r1.h(r2)
            java.lang.CharSequence r2 = android.support.v4.media.d.b(r8)
            r1.b(r2)
            android.graphics.Bitmap r2 = android.support.v4.media.d.d(r8)
            r1.d(r2)
            android.net.Uri r2 = android.support.v4.media.d.e(r8)
            r1.e(r2)
            android.os.Bundle r2 = android.support.v4.media.d.c(r8)
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            if (r2 == 0) goto L4a
            android.support.v4.media.session.MediaSessionCompat.a(r2)
            android.os.Parcelable r4 = r2.getParcelable(r3)
            android.net.Uri r4 = (android.net.Uri) r4
            goto L4b
        L4a:
            r4 = r0
        L4b:
            if (r4 == 0) goto L63
            java.lang.String r5 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r6 = r2.containsKey(r5)
            if (r6 == 0) goto L5d
            int r6 = r2.size()
            r7 = 2
            if (r6 != r7) goto L5d
            goto L64
        L5d:
            r2.remove(r3)
            r2.remove(r5)
        L63:
            r0 = r2
        L64:
            r1.c(r0)
            if (r4 == 0) goto L6d
            r1.g(r4)
            goto L7a
        L6d:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r0 < r2) goto L7a
            android.net.Uri r0 = android.support.v4.media.e.a(r8)
            r1.g(r0)
        L7a:
            android.support.v4.media.MediaDescriptionCompat r0 = r1.a()
            r0.m = r8
        L80:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.f(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object g() {
        if (this.m != null || Build.VERSION.SDK_INT < 21) {
            return this.m;
        }
        Object b2 = d.a.b();
        d.a.g(b2, this.f9e);
        d.a.i(b2, this.f);
        d.a.h(b2, this.g);
        d.a.c(b2, this.h);
        d.a.e(b2, this.i);
        d.a.f(b2, this.j);
        Bundle bundle = this.k;
        if (Build.VERSION.SDK_INT < 23 && this.l != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.l);
        }
        d.a.d(b2, bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            e.a.a(b2, this.l);
        }
        Object a2 = d.a.a(b2);
        this.m = a2;
        return a2;
    }

    public String toString() {
        return ((Object) this.f) + ", " + ((Object) this.g) + ", " + ((Object) this.h);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.i(g(), parcel, i);
            return;
        }
        parcel.writeString(this.f9e);
        TextUtils.writeToParcel(this.f, parcel, i);
        TextUtils.writeToParcel(this.g, parcel, i);
        TextUtils.writeToParcel(this.h, parcel, i);
        parcel.writeParcelable(this.i, i);
        parcel.writeParcelable(this.j, i);
        parcel.writeBundle(this.k);
        parcel.writeParcelable(this.l, i);
    }
}
