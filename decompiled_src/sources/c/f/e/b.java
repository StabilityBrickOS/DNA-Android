package c.f.e;

import android.graphics.Insets;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f714e = new b(0, 0, 0, 0);
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final int f715b;

    /* renamed from: c, reason: collision with root package name */
    public final int f716c;

    /* renamed from: d, reason: collision with root package name */
    public final int f717d;

    private b(int i, int i2, int i3, int i4) {
        this.a = i;
        this.f715b = i2;
        this.f716c = i3;
        this.f717d = i4;
    }

    public static b a(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? f714e : new b(i, i2, i3, i4);
    }

    public static b b(Insets insets) {
        return a(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets c() {
        return Insets.of(this.a, this.f715b, this.f716c, this.f717d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f717d == bVar.f717d && this.a == bVar.a && this.f716c == bVar.f716c && this.f715b == bVar.f715b;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.f715b) * 31) + this.f716c) * 31) + this.f717d;
    }

    public String toString() {
        return "Insets{left=" + this.a + ", top=" + this.f715b + ", right=" + this.f716c + ", bottom=" + this.f717d + '}';
    }
}
