package com.dna.tools;

import android.app.Activity;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class i {
    private final SharedPreferences a;

    /* renamed from: b, reason: collision with root package name */
    private final Activity f998b;

    public i(Activity activity) {
        e.p.d.i.d(activity, "activity");
        this.f998b = activity;
        this.a = activity.getSharedPreferences("theme", 0);
    }

    public final boolean a() {
        return this.a.getBoolean("TransparentUI", false);
    }

    public final void b(boolean z) {
        this.a.edit().putBoolean("TransparentUI", z).apply();
        this.f998b.recreate();
    }
}
