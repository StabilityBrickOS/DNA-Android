package c.f.e;

import android.graphics.Color;

/* loaded from: classes.dex */
public final class a {
    static {
        new ThreadLocal();
    }

    private static int a(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    public static int b(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int a = a(alpha2, alpha);
        return Color.argb(a, c(Color.red(i), alpha2, Color.red(i2), alpha, a), c(Color.green(i), alpha2, Color.green(i2), alpha, a), c(Color.blue(i), alpha2, Color.blue(i2), alpha, a));
    }

    private static int c(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    public static int d(int i, int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & 16777215) | (i2 << 24);
    }
}
