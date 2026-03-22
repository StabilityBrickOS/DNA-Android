package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class a extends c.f.d.a {

    /* renamed from: c, reason: collision with root package name */
    private static c f317c;

    /* renamed from: androidx.core.app.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0008a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String[] f318e;
        final /* synthetic */ Activity f;
        final /* synthetic */ int g;

        RunnableC0008a(String[] strArr, Activity activity, int i) {
            this.f318e = strArr;
            this.f = activity;
            this.g = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f318e.length];
            PackageManager packageManager = this.f.getPackageManager();
            String packageName = this.f.getPackageName();
            int length = this.f318e.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.f318e[i], packageName);
            }
            ((b) this.f).onRequestPermissionsResult(this.g, this.f318e, iArr);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(Activity activity, String[] strArr, int i);

        boolean b(Activity activity, int i, int i2, Intent intent);
    }

    /* loaded from: classes.dex */
    public interface d {
        void b(int i);
    }

    public static void e(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static c f() {
        return f317c;
    }

    public static void g(Activity activity) {
        if (Build.VERSION.SDK_INT < 28 && androidx.core.app.b.i(activity)) {
            return;
        }
        activity.recreate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void h(Activity activity, String[] strArr, int i) {
        c cVar = f317c;
        if (cVar == null || !cVar.a(activity, strArr, i)) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof d) {
                    ((d) activity).b(i);
                }
                activity.requestPermissions(strArr, i);
            } else if (activity instanceof b) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0008a(strArr, activity, i));
            }
        }
    }
}
