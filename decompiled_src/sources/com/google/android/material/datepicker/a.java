package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0070a();

    /* renamed from: e, reason: collision with root package name */
    private final i f1081e;
    private final i f;
    private final i g;
    private final b h;
    private final int i;
    private final int j;

    /* renamed from: com.google.android.material.datepicker.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0070a implements Parcelable.Creator<a> {
        C0070a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a((i) parcel.readParcelable(i.class.getClassLoader()), (i) parcel.readParcelable(i.class.getClassLoader()), (i) parcel.readParcelable(i.class.getClassLoader()), (b) parcel.readParcelable(b.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    /* loaded from: classes.dex */
    public interface b extends Parcelable {
        boolean c(long j);
    }

    private a(i iVar, i iVar2, i iVar3, b bVar) {
        this.f1081e = iVar;
        this.f = iVar2;
        this.g = iVar3;
        this.h = bVar;
        if (iVar.compareTo(iVar3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (iVar3.compareTo(iVar2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.j = iVar.n(iVar2) + 1;
        this.i = (iVar2.h - iVar.h) + 1;
    }

    /* synthetic */ a(i iVar, i iVar2, i iVar3, b bVar, C0070a c0070a) {
        this(iVar, iVar2, iVar3, bVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f1081e.equals(aVar.f1081e) && this.f.equals(aVar.f) && this.g.equals(aVar.g) && this.h.equals(aVar.h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i f(i iVar) {
        return iVar.compareTo(this.f1081e) < 0 ? this.f1081e : iVar.compareTo(this.f) > 0 ? this.f : iVar;
    }

    public b g() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i h() {
        return this.f;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1081e, this.f, this.g, this.h});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i j() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i k() {
        return this.f1081e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1081e, 0);
        parcel.writeParcelable(this.f, 0);
        parcel.writeParcelable(this.g, 0);
        parcel.writeParcelable(this.h, 0);
    }
}
