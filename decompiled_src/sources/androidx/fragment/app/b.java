package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.n;
import androidx.lifecycle.d;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    final int[] f376e;
    final ArrayList<String> f;
    final int[] g;
    final int[] h;
    final int i;
    final int j;
    final String k;
    final int l;
    final int m;
    final CharSequence n;
    final int o;
    final CharSequence p;
    final ArrayList<String> q;
    final ArrayList<String> r;
    final boolean s;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    public b(Parcel parcel) {
        this.f376e = parcel.createIntArray();
        this.f = parcel.createStringArrayList();
        this.g = parcel.createIntArray();
        this.h = parcel.createIntArray();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readString();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.o = parcel.readInt();
        this.p = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.q = parcel.createStringArrayList();
        this.r = parcel.createStringArrayList();
        this.s = parcel.readInt() != 0;
    }

    public b(androidx.fragment.app.a aVar) {
        int size = aVar.a.size();
        this.f376e = new int[size * 5];
        if (!aVar.h) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f = new ArrayList<>(size);
        this.g = new int[size];
        this.h = new int[size];
        int i = 0;
        int i2 = 0;
        while (i < size) {
            n.a aVar2 = aVar.a.get(i);
            int i3 = i2 + 1;
            this.f376e[i2] = aVar2.a;
            ArrayList<String> arrayList = this.f;
            Fragment fragment = aVar2.f409b;
            arrayList.add(fragment != null ? fragment.i : null);
            int[] iArr = this.f376e;
            int i4 = i3 + 1;
            iArr[i3] = aVar2.f410c;
            int i5 = i4 + 1;
            iArr[i4] = aVar2.f411d;
            int i6 = i5 + 1;
            iArr[i5] = aVar2.f412e;
            iArr[i6] = aVar2.f;
            this.g[i] = aVar2.g.ordinal();
            this.h[i] = aVar2.h.ordinal();
            i++;
            i2 = i6 + 1;
        }
        this.i = aVar.f;
        this.j = aVar.g;
        this.k = aVar.i;
        this.l = aVar.t;
        this.m = aVar.j;
        this.n = aVar.k;
        this.o = aVar.l;
        this.p = aVar.m;
        this.q = aVar.n;
        this.r = aVar.o;
        this.s = aVar.p;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public androidx.fragment.app.a f(j jVar) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(jVar);
        int i = 0;
        int i2 = 0;
        while (i < this.f376e.length) {
            n.a aVar2 = new n.a();
            int i3 = i + 1;
            aVar2.a = this.f376e[i];
            if (j.L) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i2 + " base fragment #" + this.f376e[i3]);
            }
            String str = this.f.get(i2);
            aVar2.f409b = str != null ? jVar.k.get(str) : null;
            aVar2.g = d.b.values()[this.g[i2]];
            aVar2.h = d.b.values()[this.h[i2]];
            int[] iArr = this.f376e;
            int i4 = i3 + 1;
            int i5 = iArr[i3];
            aVar2.f410c = i5;
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            aVar2.f411d = i7;
            int i8 = i6 + 1;
            int i9 = iArr[i6];
            aVar2.f412e = i9;
            int i10 = iArr[i8];
            aVar2.f = i10;
            aVar.f405b = i5;
            aVar.f406c = i7;
            aVar.f407d = i9;
            aVar.f408e = i10;
            aVar.c(aVar2);
            i2++;
            i = i8 + 1;
        }
        aVar.f = this.i;
        aVar.g = this.j;
        aVar.i = this.k;
        aVar.t = this.l;
        aVar.h = true;
        aVar.j = this.m;
        aVar.k = this.n;
        aVar.l = this.o;
        aVar.m = this.p;
        aVar.n = this.q;
        aVar.o = this.r;
        aVar.p = this.s;
        aVar.j(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f376e);
        parcel.writeStringList(this.f);
        parcel.writeIntArray(this.g);
        parcel.writeIntArray(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        TextUtils.writeToParcel(this.n, parcel, 0);
        parcel.writeInt(this.o);
        TextUtils.writeToParcel(this.p, parcel, 0);
        parcel.writeStringList(this.q);
        parcel.writeStringList(this.r);
        parcel.writeInt(this.s ? 1 : 0);
    }
}
