package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* loaded from: classes.dex */
class l {

    /* renamed from: d, reason: collision with root package name */
    private static l f93d;
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final LocationManager f94b;

    /* renamed from: c, reason: collision with root package name */
    private final a f95c = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        boolean a;

        /* renamed from: b, reason: collision with root package name */
        long f96b;

        /* renamed from: c, reason: collision with root package name */
        long f97c;

        /* renamed from: d, reason: collision with root package name */
        long f98d;

        /* renamed from: e, reason: collision with root package name */
        long f99e;
        long f;

        a() {
        }
    }

    l(Context context, LocationManager locationManager) {
        this.a = context;
        this.f94b = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l a(Context context) {
        if (f93d == null) {
            Context applicationContext = context.getApplicationContext();
            f93d = new l(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f93d;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location c2 = c.f.d.b.b(this.a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location c3 = c.f.d.b.b(this.a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (c3 == null || c2 == null) ? c3 != null ? c3 : c2 : c3.getTime() > c2.getTime() ? c3 : c2;
    }

    private Location c(String str) {
        try {
            if (this.f94b.isProviderEnabled(str)) {
                return this.f94b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
            return null;
        }
    }

    private boolean e() {
        return this.f95c.f > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j;
        a aVar = this.f95c;
        long currentTimeMillis = System.currentTimeMillis();
        k b2 = k.b();
        b2.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = b2.a;
        b2.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = b2.f92c == 1;
        long j3 = b2.f91b;
        long j4 = b2.a;
        boolean z2 = z;
        b2.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = b2.f91b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        aVar.a = z2;
        aVar.f96b = j2;
        aVar.f97c = j3;
        aVar.f98d = j4;
        aVar.f99e = j5;
        aVar.f = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        a aVar = this.f95c;
        if (e()) {
            return aVar.a;
        }
        Location b2 = b();
        if (b2 != null) {
            f(b2);
            return aVar.a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
