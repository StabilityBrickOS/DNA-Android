package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class b extends a {

    /* renamed from: d, reason: collision with root package name */
    private final SparseIntArray f614d;

    /* renamed from: e, reason: collision with root package name */
    private final Parcel f615e;
    private final int f;
    private final int g;
    private final String h;
    private int i;
    private int j;
    private int k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new c.d.a(), new c.d.a(), new c.d.a());
    }

    private b(Parcel parcel, int i, int i2, String str, c.d.a<String, Method> aVar, c.d.a<String, Method> aVar2, c.d.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f614d = new SparseIntArray();
        this.i = -1;
        this.j = 0;
        this.k = -1;
        this.f615e = parcel;
        this.f = i;
        this.g = i2;
        this.j = i;
        this.h = str;
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f615e.writeInt(-1);
        } else {
            this.f615e.writeInt(bArr.length);
            this.f615e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f615e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i) {
        this.f615e.writeInt(i);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.f615e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.f615e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i = this.i;
        if (i >= 0) {
            int i2 = this.f614d.get(i);
            int dataPosition = this.f615e.dataPosition();
            this.f615e.setDataPosition(i2);
            this.f615e.writeInt(dataPosition - i2);
            this.f615e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.f615e;
        int dataPosition = parcel.dataPosition();
        int i = this.j;
        if (i == this.f) {
            i = this.g;
        }
        return new b(parcel, dataPosition, i, this.h + "  ", this.a, this.f612b, this.f613c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.f615e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int readInt = this.f615e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f615e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f615e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i) {
        while (this.j < this.g) {
            int i2 = this.k;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.f615e.setDataPosition(this.j);
            int readInt = this.f615e.readInt();
            this.k = this.f615e.readInt();
            this.j += readInt;
        }
        return this.k == i;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.f615e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public <T extends Parcelable> T q() {
        return (T) this.f615e.readParcelable(b.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.f615e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i) {
        a();
        this.i = i;
        this.f614d.put(i, this.f615e.dataPosition());
        E(0);
        E(i);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z) {
        this.f615e.writeInt(z ? 1 : 0);
    }
}
