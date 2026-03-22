package androidx.media;

import java.util.Arrays;

/* loaded from: classes.dex */
class c implements a {
    int a = 0;

    /* renamed from: b, reason: collision with root package name */
    int f457b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f458c = 0;

    /* renamed from: d, reason: collision with root package name */
    int f459d = -1;

    public int a() {
        return this.f457b;
    }

    public int b() {
        int i = this.f458c;
        int c2 = c();
        if (c2 == 6) {
            i |= 4;
        } else if (c2 == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public int c() {
        int i = this.f459d;
        return i != -1 ? i : AudioAttributesCompat.a(false, this.f458c, this.a);
    }

    public int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f457b == cVar.a() && this.f458c == cVar.b() && this.a == cVar.d() && this.f459d == cVar.f459d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f457b), Integer.valueOf(this.f458c), Integer.valueOf(this.a), Integer.valueOf(this.f459d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f459d != -1) {
            sb.append(" stream=");
            sb.append(this.f459d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.a));
        sb.append(" content=");
        sb.append(this.f457b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f458c).toUpperCase());
        return sb.toString();
    }
}
