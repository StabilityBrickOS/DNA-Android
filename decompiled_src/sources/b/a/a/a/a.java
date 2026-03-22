package b.a.a.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: b.a.a.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0019a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b.a.a.a.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0020a implements a {

            /* renamed from: b, reason: collision with root package name */
            public static a f618b;
            private IBinder a;

            C0020a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // b.a.a.a.a
            public void n(int i, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.os.IResultReceiver");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.a.transact(1, obtain, null, 1) || AbstractBinderC0019a.q() == null) {
                        return;
                    }
                    AbstractBinderC0019a.q().n(i, bundle);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0019a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static a p(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0020a(iBinder) : (a) queryLocalInterface;
        }

        public static a q() {
            return C0020a.f618b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                n(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("android.support.v4.os.IResultReceiver");
            return true;
        }
    }

    void n(int i, Bundle bundle);
}
