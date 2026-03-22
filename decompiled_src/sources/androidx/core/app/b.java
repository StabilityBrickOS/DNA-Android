package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes.dex */
final class b {
    private static final Handler g = new Handler(Looper.getMainLooper());
    protected static final Class<?> a = a();

    /* renamed from: b, reason: collision with root package name */
    protected static final Field f319b = b();

    /* renamed from: c, reason: collision with root package name */
    protected static final Field f320c = f();

    /* renamed from: d, reason: collision with root package name */
    protected static final Method f321d = d(a);

    /* renamed from: e, reason: collision with root package name */
    protected static final Method f322e = c(a);
    protected static final Method f = e(a);

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f323e;
        final /* synthetic */ Object f;

        a(d dVar, Object obj) {
            this.f323e = dVar;
            this.f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f323e.a = this.f;
        }
    }

    /* renamed from: androidx.core.app.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0009b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Application f324e;
        final /* synthetic */ d f;

        RunnableC0009b(Application application, d dVar) {
            this.f324e = application;
            this.f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f324e.unregisterActivityLifecycleCallbacks(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f325e;
        final /* synthetic */ Object f;

        c(Object obj, Object obj2) {
            this.f325e = obj;
            this.f = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (b.f321d != null) {
                    b.f321d.invoke(this.f325e, this.f, Boolean.FALSE, "AppCompat recreation");
                } else {
                    b.f322e.invoke(this.f325e, this.f, Boolean.FALSE);
                }
            } catch (RuntimeException e2) {
                if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                    throw e2;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class d implements Application.ActivityLifecycleCallbacks {
        Object a;

        /* renamed from: b, reason: collision with root package name */
        private Activity f326b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f327c = false;

        /* renamed from: d, reason: collision with root package name */
        private boolean f328d = false;

        /* renamed from: e, reason: collision with root package name */
        private boolean f329e = false;

        d(Activity activity) {
            this.f326b = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f326b == activity) {
                this.f326b = null;
                this.f328d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f328d || this.f329e || this.f327c || !b.h(this.a, activity)) {
                return;
            }
            this.f329e = true;
            this.a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f326b == activity) {
                this.f327c = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i = Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    protected static boolean h(Object obj, Activity activity) {
        try {
            Object obj2 = f320c.get(activity);
            if (obj2 != obj) {
                return false;
            }
            g.postAtFrontOfQueue(new c(f319b.get(activity), obj2));
            return true;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f == null) {
            return false;
        }
        if (f322e == null && f321d == null) {
            return false;
        }
        try {
            Object obj2 = f320c.get(activity);
            if (obj2 == null || (obj = f319b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            d dVar = new d(activity);
            application.registerActivityLifecycleCallbacks(dVar);
            g.post(new a(dVar, obj2));
            try {
                if (g()) {
                    f.invoke(obj, obj2, null, null, 0, Boolean.FALSE, null, null, Boolean.FALSE, Boolean.FALSE);
                } else {
                    activity.recreate();
                }
                return true;
            } finally {
                g.post(new RunnableC0009b(application, dVar));
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
