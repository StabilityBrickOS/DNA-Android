package d.a.a.a.l;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public class a {
    public static final TimeInterpolator a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f1276b = new c.i.a.a.b();

    /* renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f1277c = new c.i.a.a.a();

    /* renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f1278d = new c.i.a.a.c();

    /* renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f1279e = new DecelerateInterpolator();

    public static float a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }
}
