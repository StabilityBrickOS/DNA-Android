package c.d;

/* loaded from: classes.dex */
public class d<E> implements Cloneable {
    private static final Object i = new Object();

    /* renamed from: e, reason: collision with root package name */
    private boolean f686e;
    private long[] f;
    private Object[] g;
    private int h;

    public d() {
        this(10);
    }

    public d(int i2) {
        this.f686e = false;
        if (i2 == 0) {
            this.f = c.f684b;
            this.g = c.f685c;
        } else {
            int f = c.f(i2);
            this.f = new long[f];
            this.g = new Object[f];
        }
    }

    private void d() {
        int i2 = this.h;
        long[] jArr = this.f;
        Object[] objArr = this.g;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != i) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f686e = false;
        this.h = i3;
    }

    public void a(long j, E e2) {
        int i2 = this.h;
        if (i2 != 0 && j <= this.f[i2 - 1]) {
            i(j, e2);
            return;
        }
        if (this.f686e && this.h >= this.f.length) {
            d();
        }
        int i3 = this.h;
        if (i3 >= this.f.length) {
            int f = c.f(i3 + 1);
            long[] jArr = new long[f];
            Object[] objArr = new Object[f];
            long[] jArr2 = this.f;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.g;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f = jArr;
            this.g = objArr;
        }
        this.f[i3] = j;
        this.g[i3] = e2;
        this.h = i3 + 1;
    }

    public void b() {
        int i2 = this.h;
        Object[] objArr = this.g;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.h = 0;
        this.f686e = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f = (long[]) this.f.clone();
            dVar.g = (Object[]) this.g.clone();
            return dVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E e(long j) {
        return f(j, null);
    }

    public E f(long j, E e2) {
        int b2 = c.b(this.f, this.h, j);
        if (b2 >= 0) {
            Object[] objArr = this.g;
            if (objArr[b2] != i) {
                return (E) objArr[b2];
            }
        }
        return e2;
    }

    public int g(long j) {
        if (this.f686e) {
            d();
        }
        return c.b(this.f, this.h, j);
    }

    public long h(int i2) {
        if (this.f686e) {
            d();
        }
        return this.f[i2];
    }

    public void i(long j, E e2) {
        int b2 = c.b(this.f, this.h, j);
        if (b2 >= 0) {
            this.g[b2] = e2;
            return;
        }
        int i2 = ~b2;
        if (i2 < this.h) {
            Object[] objArr = this.g;
            if (objArr[i2] == i) {
                this.f[i2] = j;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f686e && this.h >= this.f.length) {
            d();
            i2 = ~c.b(this.f, this.h, j);
        }
        int i3 = this.h;
        if (i3 >= this.f.length) {
            int f = c.f(i3 + 1);
            long[] jArr = new long[f];
            Object[] objArr2 = new Object[f];
            long[] jArr2 = this.f;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.g;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f = jArr;
            this.g = objArr2;
        }
        int i4 = this.h;
        if (i4 - i2 != 0) {
            long[] jArr3 = this.f;
            int i5 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i5, i4 - i2);
            Object[] objArr4 = this.g;
            System.arraycopy(objArr4, i2, objArr4, i5, this.h - i2);
        }
        this.f[i2] = j;
        this.g[i2] = e2;
        this.h++;
    }

    public void j(long j) {
        int b2 = c.b(this.f, this.h, j);
        if (b2 >= 0) {
            Object[] objArr = this.g;
            Object obj = objArr[b2];
            Object obj2 = i;
            if (obj != obj2) {
                objArr[b2] = obj2;
                this.f686e = true;
            }
        }
    }

    public void k(int i2) {
        Object[] objArr = this.g;
        Object obj = objArr[i2];
        Object obj2 = i;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.f686e = true;
        }
    }

    public int l() {
        if (this.f686e) {
            d();
        }
        return this.h;
    }

    public E m(int i2) {
        if (this.f686e) {
            d();
        }
        return (E) this.g[i2];
    }

    public String toString() {
        if (l() <= 0) {
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
            E m = m(i2);
            if (m != this) {
                sb.append(m);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
