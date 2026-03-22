package d.a.a.a.x;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

/* loaded from: classes.dex */
public class b {
    public static final boolean a;

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f1310b;

    /* renamed from: c, reason: collision with root package name */
    static final String f1311c;

    static {
        a = Build.VERSION.SDK_INT >= 21;
        f1310b = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        f1311c = b.class.getSimpleName();
    }

    private b() {
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 22 && i <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f1310b, 0)) != 0) {
            Log.w(f1311c, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean b(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z = true;
            } else if (i == 16842908 || i == 16842919 || i == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
