package d.a.a.a.p;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import d.a.a.a.p.d;

/* loaded from: classes.dex */
public class c {
    public static final int a;

    static {
        int i = Build.VERSION.SDK_INT;
        a = i >= 21 ? 2 : i >= 18 ? 1 : 0;
    }

    public abstract void a();

    public abstract void b();

    public abstract void c(Canvas canvas);

    public abstract Drawable d();

    public abstract int e();

    public abstract d.e f();

    public abstract boolean g();

    public abstract void h(Drawable drawable);

    public abstract void i(int i);

    public abstract void j(d.e eVar);
}
