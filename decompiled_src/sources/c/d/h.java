package c.d;

/* loaded from: classes.dex */
public class h<E> implements Cloneable {
    private static final Object i = new Object();

    /* renamed from: e, reason: collision with root package name */
    private boolean f699e;
    private int[] f;
    private Object[] g;
    private int h;

    public h() {
        this(10);
    }

    public h(int i2) {
        this.f699e = false;
        if (i2 == 0) {
            this.f = c.a;
            this.g = c.f685c;
        } else {
            int e2 = c.e(i2);
            this.f = new int[e2];
            this.g = new Object[e2];
        }
    }

    private void d() {
        int i2 = this.h;
        int[] iArr = this.f;
        Object[] objArr = this.g;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != i) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f699e = false;
        this.h = i3;
    }

    public void a(int i2, E e2) {
        int i3 = this.h;
        if (i3 != 0 && i2 <= this.f[i3 - 1]) {
            i(i2, e2);
            return;
        }
        if (this.f699e && this.h >= this.f.length) {
            d();
        }
        int i4 = this.h;
        if (i4 >= this.f.length) {
            int e3 = c.e(i4 + 1);
            int[] iArr = new int[e3];
            Object[] objArr = new Object[e3];
            int[] iArr2 = this.f;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.g;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f = iArr;
            this.g = objArr;
        }
        this.f[i4] = i2;
        this.g[i4] = e2;
        this.h = i4 + 1;
    }

    public void b() {
        int i2 = this.h;
        Object[] objArr = this.g;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.h = 0;
        this.f699e = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f = (int[]) this.f.clone();
            hVar.g = (Object[]) this.g.clone();
            return hVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E e(int i2) {
        return f(i2, null);
    }

    public E f(int i2, E e2) {
        int a = c.a(this.f, this.h, i2);
        if (a >= 0) {
            Object[] objArr = this.g;
            if (objArr[a] != i) {
                return (E) objArr[a];
            }
        }
        return e2;
    }

    public int g(E e2) {
        if (this.f699e) {
            d();
        }
        for (int i2 = 0; i2 < this.h; i2++) {
            if (this.g[i2] == e2) {
                return i2;
            }
        }
        return -1;
    }

    public int h(int i2) {
        if (this.f699e) {
            d();
        }
        return this.f[i2];
    }

    public void i(int i2, E e2) {
        int a = c.a(this.f, this.h, i2);
        if (a >= 0) {
            this.g[a] = e2;
            return;
        }
        int i3 = ~a;
        if (i3 < this.h) {
            Object[] objArr = this.g;
            if (objArr[i3] == i) {
                this.f[i3] = i2;
                objArr[i3] = e2;
                return;
            }
        }
        if (this.f699e && this.h >= this.f.length) {
            d();
            i3 = ~c.a(this.f, this.h, i2);
        }
        int i4 = this.h;
        if (i4 >= this.f.length) {
            int e3 = c.e(i4 + 1);
            int[] iArr = new int[e3];
            Object[] objArr2 = new Object[e3];
            int[] iArr2 = this.f;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.g;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f = iArr;
            this.g = objArr2;
        }
        int i5 = this.h;
        if (i5 - i3 != 0) {
            int[] iArr3 = this.f;
            int i6 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i6, i5 - i3);
            Object[] objArr4 = this.g;
            System.arraycopy(objArr4, i3, objArr4, i6, this.h - i3);
        }
        this.f[i3] = i2;
        this.g[i3] = e2;
        this.h++;
    }

    public void j(int i2) {
        int a = c.a(this.f, this.h, i2);
        if (a >= 0) {
            Object[] objArr = this.g;
            Object obj = objArr[a];
            Object obj2 = i;
            if (obj != obj2) {
                objArr[a] = obj2;
                this.f699e = true;
            }
        }
    }

    public int k() {
        if (this.f699e) {
            d();
        }
        return this.h;
    }

    public E l(int i2) {
        if (this.f699e) {
            d();
        }
        return (E) this.g[i2];
    }

    public String toString() {
        if (k() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.h * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.h; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(h(i2));
            sb.append('=');
            E l = l(i2);
            if (l != this) {
                sb.append(l);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
