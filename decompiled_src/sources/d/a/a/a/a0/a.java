package d.a.a.a.a0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c.d.g;

/* loaded from: classes.dex */
public class a extends c.h.a.a {
    public static final Parcelable.Creator<a> CREATOR = new C0085a();
    public final g<String, Bundle> g;

    /* renamed from: d.a.a.a.a0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0085a implements Parcelable.ClassLoaderCreator<a> {
        C0085a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null, 0 == true ? 1 : 0);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    private a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.g = new g<>(readInt);
        for (int i = 0; i < readInt; i++) {
            this.g.put(strArr[i], bundleArr[i]);
        }
    }

    /* synthetic */ a(Parcel parcel, ClassLoader classLoader, C0085a c0085a) {
        this(parcel, classLoader);
    }

    public a(Parcelable parcelable) {
        super(parcelable);
        this.g = new g<>();
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.g + "}";
    }

    @Override // c.h.a.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int size = this.g.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = this.g.i(i2);
            bundleArr[i2] = this.g.m(i2);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
