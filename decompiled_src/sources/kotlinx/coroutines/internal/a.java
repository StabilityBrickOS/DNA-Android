package kotlinx.coroutines.internal;

/* loaded from: classes.dex */
public class a<T> {
    private Object[] a = new Object[16];

    /* renamed from: b, reason: collision with root package name */
    private int f1579b;

    /* renamed from: c, reason: collision with root package name */
    private int f1580c;

    private final void b() {
        Object[] objArr = this.a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        e.k.a.c(objArr, objArr2, 0, this.f1579b, 0, 10, null);
        Object[] objArr3 = this.a;
        int length2 = objArr3.length;
        int i = this.f1579b;
        e.k.a.c(objArr3, objArr2, length2 - i, 0, i, 4, null);
        this.a = objArr2;
        this.f1579b = 0;
        this.f1580c = length;
    }

    public final void a(T t) {
        Object[] objArr = this.a;
        int i = this.f1580c;
        objArr[i] = t;
        int length = (objArr.length - 1) & (i + 1);
        this.f1580c = length;
        if (length == this.f1579b) {
            b();
        }
    }

    public final boolean c() {
        return this.f1579b == this.f1580c;
    }

    public final T d() {
        int i = this.f1579b;
        if (i == this.f1580c) {
            return null;
        }
        Object[] objArr = this.a;
        T t = (T) objArr[i];
        objArr[i] = null;
        this.f1579b = (i + 1) & (objArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null cannot be cast to non-null type T");
    }
}
