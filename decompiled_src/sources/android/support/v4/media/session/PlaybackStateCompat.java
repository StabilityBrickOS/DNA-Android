package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.g;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    final int f24e;
    final long f;
    final long g;
    final float h;
    final long i;
    final int j;
    final CharSequence k;
    final long l;
    List<CustomAction> m;
    final long n;
    final Bundle o;

    /* loaded from: classes.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        private final String f25e;
        private final CharSequence f;
        private final int g;
        private final Bundle h;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<CustomAction> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        }

        CustomAction(Parcel parcel) {
            this.f25e = parcel.readString();
            this.f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.g = parcel.readInt();
            this.h = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f25e = str;
            this.f = charSequence;
            this.g = i;
            this.h = bundle;
        }

        public static CustomAction f(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new CustomAction(g.a.a(obj), g.a.d(obj), g.a.c(obj), g.a.b(obj));
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f) + ", mIcon=" + this.g + ", mExtras=" + this.h;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f25e);
            TextUtils.writeToParcel(this.f, parcel, i);
            parcel.writeInt(this.g);
            parcel.writeBundle(this.h);
        }
    }

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<PlaybackStateCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    }

    PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f24e = i;
        this.f = j;
        this.g = j2;
        this.h = f;
        this.i = j3;
        this.j = i2;
        this.k = charSequence;
        this.l = j4;
        this.m = new ArrayList(list);
        this.n = j5;
        this.o = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f24e = parcel.readInt();
        this.f = parcel.readLong();
        this.h = parcel.readFloat();
        this.l = parcel.readLong();
        this.g = parcel.readLong();
        this.i = parcel.readLong();
        this.k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.n = parcel.readLong();
        this.o = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.j = parcel.readInt();
    }

    public static PlaybackStateCompat f(Object obj) {
        ArrayList arrayList;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> d2 = g.d(obj);
        if (d2 != null) {
            ArrayList arrayList2 = new ArrayList(d2.size());
            Iterator<Object> it = d2.iterator();
            while (it.hasNext()) {
                arrayList2.add(CustomAction.f(it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new PlaybackStateCompat(g.i(obj), g.h(obj), g.c(obj), g.g(obj), g.a(obj), 0, g.e(obj), g.f(obj), arrayList, g.b(obj), Build.VERSION.SDK_INT >= 22 ? h.a(obj) : null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f24e + ", position=" + this.f + ", buffered position=" + this.g + ", speed=" + this.h + ", updated=" + this.l + ", actions=" + this.i + ", error code=" + this.j + ", error message=" + this.k + ", custom actions=" + this.m + ", active item id=" + this.n + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f24e);
        parcel.writeLong(this.f);
        parcel.writeFloat(this.h);
        parcel.writeLong(this.l);
        parcel.writeLong(this.g);
        parcel.writeLong(this.i);
        TextUtils.writeToParcel(this.k, parcel, i);
        parcel.writeTypedList(this.m);
        parcel.writeLong(this.n);
        parcel.writeBundle(this.o);
        parcel.writeInt(this.j);
    }
}
