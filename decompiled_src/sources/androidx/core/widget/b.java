package androidx.core.widget;

import android.os.Build;

/* loaded from: classes.dex */
public interface b {
    public static final boolean a;

    static {
        a = Build.VERSION.SDK_INT >= 27;
    }
}
