package c.d;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {
    private static final int[] i = new int[0];
    private static final Object[] j = new Object[0];
    private static Object[] k;
    private static int l;
    private static Object[] m;
    private static int n;

    /* renamed from: e, reason: collision with root package name */
    private int[] f682e;
    Object[] f;
    int g;
    private f<E, E> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends f<E, E> {
        a() {
        }

        @Override // c.d.f
        protected void a() {
            b.this.clear();
        }

        @Override // c.d.f
        protected Object b(int i, int i2) {
            return b.this.f[i];
        }

        @Override // c.d.f
        protected Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // c.d.f
        protected int d() {
            return b.this.g;
        }

        @Override // c.d.f
        protected int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // c.d.f
        protected int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // c.d.f
        protected void g(E e2, E e3) {
            b.this.add(e2);
        }

        @Override // c.d.f
        protected void h(int i) {
            b.this.g(i);
        }

        @Override // c.d.f
        protected E i(int i, E e2) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    public b(int i2) {
        if (i2 == 0) {
            this.f682e = i;
            this.f = j;
        } else {
            a(i2);
        }
        this.g = 0;
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                if (m != null) {
                    Object[] objArr = m;
                    this.f = objArr;
                    m = (Object[]) objArr[0];
                    this.f682e = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    n--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                if (k != null) {
                    Object[] objArr2 = k;
                    this.f = objArr2;
                    k = (Object[]) objArr2[0];
                    this.f682e = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    l--;
                    return;
                }
            }
        }
        this.f682e = new int[i2];
        this.f = new Object[i2];
    }

    private static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (n < 10) {
                    objArr[0] = m;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    m = objArr;
                    n++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                if (l < 10) {
                    objArr[0] = k;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    k = objArr;
                    l++;
                }
            }
        }
    }

    private f<E, E> d() {
        if (this.h == null) {
            this.h = new a();
        }
        return this.h;
    }

    private int e(Object obj, int i2) {
        int i3 = this.g;
        if (i3 == 0) {
            return -1;
        }
        int a2 = c.a(this.f682e, i3, i2);
        if (a2 < 0 || obj.equals(this.f[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f682e[i4] == i2) {
            if (obj.equals(this.f[i4])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = a2 - 1; i5 >= 0 && this.f682e[i5] == i2; i5--) {
            if (obj.equals(this.f[i5])) {
                return i5;
            }
        }
        return ~i4;
    }

    private int f() {
        int i2 = this.g;
        if (i2 == 0) {
            return -1;
        }
        int a2 = c.a(this.f682e, i2, 0);
        if (a2 < 0 || this.f[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f682e[i3] == 0) {
            if (this.f[i3] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = a2 - 1; i4 >= 0 && this.f682e[i4] == 0; i4--) {
            if (this.f[i4] == null) {
                return i4;
            }
        }
        return ~i3;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int i2;
        int e3;
        if (e2 == null) {
            e3 = f();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i2 = hashCode;
            e3 = e(e2, hashCode);
        }
        if (e3 >= 0) {
            return false;
        }
        int i3 = ~e3;
        int i4 = this.g;
        if (i4 >= this.f682e.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.f682e;
            Object[] objArr = this.f;
            a(i5);
            int[] iArr2 = this.f682e;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f, 0, objArr.length);
            }
            c(iArr, objArr, this.g);
        }
        int i6 = this.g;
        if (i3 < i6) {
            int[] iArr3 = this.f682e;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.f;
            System.arraycopy(objArr2, i3, objArr2, i7, this.g - i3);
        }
        this.f682e[i3] = i2;
        this.f[i3] = e2;
        this.g++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        b(this.g + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    public void b(int i2) {
        int[] iArr = this.f682e;
        if (iArr.length < i2) {
            Object[] objArr = this.f;
            a(i2);
            int i3 = this.g;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f682e, 0, i3);
                System.arraycopy(objArr, 0, this.f, 0, this.g);
            }
            c(iArr, objArr, this.g);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.g;
        if (i2 != 0) {
            c(this.f682e, this.f, i2);
            this.f682e = i;
            this.f = j;
            this.g = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.g; i2++) {
                try {
                    if (!set.contains(h(i2))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public E g(int i2) {
        Object[] objArr = this.f;
        E e2 = (E) objArr[i2];
        int i3 = this.g;
        if (i3 <= 1) {
            c(this.f682e, objArr, i3);
            this.f682e = i;
            this.f = j;
            this.g = 0;
        } else {
            int[] iArr = this.f682e;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i4 = this.g - 1;
                this.g = i4;
                if (i2 < i4) {
                    int[] iArr2 = this.f682e;
                    int i5 = i2 + 1;
                    System.arraycopy(iArr2, i5, iArr2, i2, i4 - i2);
                    Object[] objArr2 = this.f;
                    System.arraycopy(objArr2, i5, objArr2, i2, this.g - i2);
                }
                this.f[this.g] = null;
            } else {
                int i6 = i3 > 8 ? i3 + (i3 >> 1) : 8;
                int[] iArr3 = this.f682e;
                Object[] objArr3 = this.f;
                a(i6);
                this.g--;
                if (i2 > 0) {
                    System.arraycopy(iArr3, 0, this.f682e, 0, i2);
                    System.arraycopy(objArr3, 0, this.f, 0, i2);
                }
                int i7 = this.g;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr3, i8, this.f682e, i2, i7 - i2);
                    System.arraycopy(objArr3, i8, this.f, i2, this.g - i2);
                }
            }
        }
        return e2;
    }

    public E h(int i2) {
        return (E) this.f[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f682e;
        int i2 = this.g;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? f() : e(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.g <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return d().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        g(indexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.g - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f[i2])) {
                g(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.g;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.g;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f, 0, objArr, 0, i2);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.g) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.g));
        }
        System.arraycopy(this.f, 0, tArr, 0, this.g);
        int length = tArr.length;
        int i2 = this.g;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.g * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.g; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            E h = h(i2);
            if (h != this) {
                sb.append(h);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
