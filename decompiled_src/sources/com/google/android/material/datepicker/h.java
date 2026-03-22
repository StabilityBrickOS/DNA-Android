package com.google.android.material.datepicker;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;

/* loaded from: classes.dex */
public final class h<S> extends androidx.fragment.app.c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean z1(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(d.a.a.a.w.b.c(context, d.a.a.a.b.materialCalendarStyle, g.class.getCanonicalName()), new int[]{R.attr.windowFullscreen});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }
}
