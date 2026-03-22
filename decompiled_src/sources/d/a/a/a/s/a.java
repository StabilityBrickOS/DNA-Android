package d.a.a.a.s;

import android.content.Context;
import android.graphics.Color;
import d.a.a.a.w.b;

/* loaded from: classes.dex */
public class a {
    private final boolean a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1294b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1295c;

    /* renamed from: d, reason: collision with root package name */
    private final float f1296d;

    public a(Context context) {
        this.a = b.b(context, d.a.a.a.b.elevationOverlayEnabled, false);
        this.f1294b = d.a.a.a.q.a.a(context, d.a.a.a.b.elevationOverlayColor, 0);
        this.f1295c = d.a.a.a.q.a.a(context, d.a.a.a.b.colorSurface, 0);
        this.f1296d = context.getResources().getDisplayMetrics().density;
    }

    private boolean e(int i) {
        return c.f.e.a.d(i, 255) == this.f1295c;
    }

    public float a(float f) {
        if (this.f1296d <= 0.0f || f <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i, float f) {
        float a = a(f);
        return c.f.e.a.d(d.a.a.a.q.a.f(c.f.e.a.d(i, 255), this.f1294b, a), Color.alpha(i));
    }

    public int c(int i, float f) {
        return (this.a && e(i)) ? b(i, f) : i;
    }

    public boolean d() {
        return this.a;
    }
}
