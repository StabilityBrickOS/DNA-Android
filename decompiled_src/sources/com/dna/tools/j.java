package com.dna.tools;

import android.app.Activity;
import android.app.UiModeManager;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    public static final j f999b = new j();
    private static com.omarea.common.ui.i a = new com.omarea.common.ui.i();

    private j() {
    }

    private final boolean a(Context context, String str) {
        return c.f.d.b.b(context, str) == 0;
    }

    public final com.omarea.common.ui.i b() {
        return a;
    }

    public final com.omarea.common.ui.i c(Activity activity) {
        int i;
        if (activity != null) {
            Object systemService = activity.getApplicationContext().getSystemService("uimode");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.UiModeManager");
            }
            boolean z = ((UiModeManager) systemService).getNightMode() == 2;
            if (new i(activity).a() && a(activity, "android.permission.READ_EXTERNAL_STORAGE") && a(activity, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(activity);
                e.p.d.i.c(wallpaperManager, "wallpaper");
                WallpaperInfo wallpaperInfo = wallpaperManager.getWallpaperInfo();
                if (z) {
                    a.b(true);
                    i = R.style.AppThemeWallpaper;
                } else {
                    a.b(false);
                    i = R.style.AppThemeWallpaperLight;
                }
                activity.setTheme(i);
                if (wallpaperInfo == null || wallpaperInfo.getPackageName() == null) {
                    activity.getWindow().setBackgroundDrawable(wallpaperManager.getDrawable());
                } else {
                    activity.getWindow().addFlags(1048576);
                }
            } else if (z) {
                a.b(true);
                a.c(false);
                activity.setTheme(R.style.AppThemeDark);
            } else {
                a.b(false);
            }
            if (!a.a()) {
                a.c(Build.VERSION.SDK_INT >= 23);
                Window window = activity.getWindow();
                window.clearFlags(67108864);
                View decorView = window.getDecorView();
                e.p.d.i.c(decorView, "decorView");
                decorView.setSystemUiVisibility(1280);
                window.addFlags(Integer.MIN_VALUE);
                int i2 = Build.VERSION.SDK_INT;
                View decorView2 = window.getDecorView();
                e.p.d.i.c(decorView2, "decorView");
                decorView2.setSystemUiVisibility(i2 >= 26 ? 9232 : 9216);
            }
        }
        return a;
    }
}
