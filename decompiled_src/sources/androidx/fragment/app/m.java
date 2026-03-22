package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.lifecycle.d;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class m implements Parcelable {
    public static final Parcelable.Creator<m> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    final String f404e;
    final String f;
    final boolean g;
    final int h;
    final int i;
    final String j;
    final boolean k;
    final boolean l;
    final boolean m;
    final Bundle n;
    final boolean o;
    final int p;
    Bundle q;
    Fragment r;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<m> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public m[] newArray(int i) {
            return new m[i];
        }
    }

    m(Parcel parcel) {
        this.f404e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readString();
        this.k = parcel.readInt() != 0;
        this.l = parcel.readInt() != 0;
        this.m = parcel.readInt() != 0;
        this.n = parcel.readBundle();
        this.o = parcel.readInt() != 0;
        this.q = parcel.readBundle();
        this.p = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Fragment fragment) {
        this.f404e = fragment.getClass().getName();
        this.f = fragment.i;
        this.g = fragment.q;
        this.h = fragment.z;
        this.i = fragment.A;
        this.j = fragment.B;
        this.k = fragment.E;
        this.l = fragment.p;
        this.m = fragment.D;
        this.n = fragment.j;
        this.o = fragment.C;
        this.p = fragment.U.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Fragment f(ClassLoader classLoader, g gVar) {
        Fragment fragment;
        Bundle bundle;
        if (this.r == null) {
            Bundle bundle2 = this.n;
            if (bundle2 != null) {
                bundle2.setClassLoader(classLoader);
            }
            Fragment a2 = gVar.a(classLoader, this.f404e);
            this.r = a2;
            a2.l1(this.n);
            Bundle bundle3 = this.q;
            if (bundle3 != null) {
                bundle3.setClassLoader(classLoader);
                fragment = this.r;
                bundle = this.q;
            } else {
                fragment = this.r;
                bundle = new Bundle();
            }
            fragment.f = bundle;
            Fragment fragment2 = this.r;
            fragment2.i = this.f;
            fragment2.q = this.g;
            fragment2.s = true;
            fragment2.z = this.h;
            fragment2.A = this.i;
            fragment2.B = this.j;
            fragment2.E = this.k;
            fragment2.p = this.l;
            fragment2.D = this.m;
            fragment2.C = this.o;
            fragment2.U = d.b.values()[this.p];
            if (j.L) {
                Log.v("FragmentManager", "Instantiated fragment " + this.r);
            }
        }
        return this.r;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f404e);
        sb.append(" (");
        sb.append(this.f);
        sb.append(")}:");
        if (this.g) {
            sb.append(" fromLayout");
        }
        if (this.i != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.i));
        }
        String str = this.j;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.j);
        }
        if (this.k) {
            sb.append(" retainInstance");
        }
        if (this.l) {
            sb.append(" removing");
        }
        if (this.m) {
            sb.append(" detached");
        }
        if (this.o) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f404e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeString(this.j);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeBundle(this.n);
        parcel.writeInt(this.o ? 1 : 0);
        parcel.writeBundle(this.q);
        parcel.writeInt(this.p);
    }
}
