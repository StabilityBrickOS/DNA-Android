package b.a.a.a;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import b.a.a.a.a;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    final Handler f619e = null;
    b.a.a.a.a f;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<b> {
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

    /* renamed from: b.a.a.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class BinderC0021b extends a.AbstractBinderC0019a {
        BinderC0021b() {
        }

        @Override // b.a.a.a.a
        public void n(int i, Bundle bundle) {
            b bVar = b.this;
            Handler handler = bVar.f619e;
            if (handler != null) {
                handler.post(new c(i, bundle));
            } else {
                bVar.f(i, bundle);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final int f620e;
        final Bundle f;

        c(int i, Bundle bundle) {
            this.f620e = i;
            this.f = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f(this.f620e, this.f);
        }
    }

    b(Parcel parcel) {
        this.f = a.AbstractBinderC0019a.p(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected void f(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f == null) {
                this.f = new BinderC0021b();
            }
            parcel.writeStrongBinder(this.f.asBinder());
        }
    }
}
