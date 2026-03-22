package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class k implements Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    ArrayList<m> f399e;
    ArrayList<String> f;
    b[] g;
    String h;
    int i;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<k> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public k[] newArray(int i) {
            return new k[i];
        }
    }

    public k() {
        this.h = null;
    }

    public k(Parcel parcel) {
        this.h = null;
        this.f399e = parcel.createTypedArrayList(m.CREATOR);
        this.f = parcel.createStringArrayList();
        this.g = (b[]) parcel.createTypedArray(b.CREATOR);
        this.h = parcel.readString();
        this.i = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f399e);
        parcel.writeStringList(this.f);
        parcel.writeTypedArray(this.g, i);
        parcel.writeString(this.h);
        parcel.writeInt(this.i);
    }
}
