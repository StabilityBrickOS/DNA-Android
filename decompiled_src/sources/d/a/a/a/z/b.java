package d.a.a.a.z;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class b implements c {
    private final c a;

    /* renamed from: b, reason: collision with root package name */
    private final float f1316b;

    public b(float f, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).a;
            f += ((b) cVar).f1316b;
        }
        this.a = cVar;
        this.f1316b = f;
    }

    @Override // d.a.a.a.z.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.a.a(rectF) + this.f1316b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a.equals(bVar.a) && this.f1316b == bVar.f1316b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.f1316b)});
    }
}
