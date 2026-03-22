package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements Comparable<i>, Parcelable {
    public static final Parcelable.Creator<i> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    private final Calendar f1100e;
    private final String f;
    final int g;
    final int h;
    final int i;
    final int j;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<i> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i createFromParcel(Parcel parcel) {
            return i.g(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public i[] newArray(int i) {
            return new i[i];
        }
    }

    private i(Calendar calendar) {
        calendar.set(5, 1);
        Calendar d2 = p.d(calendar);
        this.f1100e = d2;
        this.g = d2.get(2);
        this.h = this.f1100e.get(1);
        this.i = this.f1100e.getMaximum(7);
        this.j = this.f1100e.getActualMaximum(5);
        this.f = p.o().format(this.f1100e.getTime());
        this.f1100e.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i g(int i, int i2) {
        Calendar l = p.l();
        l.set(1, i);
        l.set(2, i2);
        return new i(l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i h() {
        return new i(p.j());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.g == iVar.g && this.h == iVar.h;
    }

    @Override // java.lang.Comparable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public int compareTo(i iVar) {
        return this.f1100e.compareTo(iVar.f1100e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.g), Integer.valueOf(this.h)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        int firstDayOfWeek = this.f1100e.get(7) - this.f1100e.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.i : firstDayOfWeek;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long j(int i) {
        Calendar d2 = p.d(this.f1100e);
        d2.set(5, i);
        return d2.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long l() {
        return this.f1100e.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i m(int i) {
        Calendar d2 = p.d(this.f1100e);
        d2.add(2, i);
        return new i(d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n(i iVar) {
        if (this.f1100e instanceof GregorianCalendar) {
            return ((iVar.h - this.h) * 12) + (iVar.g - this.g);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.h);
        parcel.writeInt(this.g);
    }
}
