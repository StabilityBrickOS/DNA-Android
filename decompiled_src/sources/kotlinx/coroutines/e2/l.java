package kotlinx.coroutines.e2;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.internal.u;

/* loaded from: classes.dex */
public final class l {
    public static final long a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f1567b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f1568c;

    /* renamed from: d, reason: collision with root package name */
    public static final long f1569d;

    /* renamed from: e, reason: collision with root package name */
    public static m f1570e;

    static {
        long e2;
        int a2;
        int d2;
        int e3;
        int d3;
        long e4;
        e2 = u.e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        a = e2;
        u.d("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        a2 = e.r.f.a(s.a(), 2);
        d2 = u.d("kotlinx.coroutines.scheduler.core.pool.size", a2, 1, 0, 8, null);
        f1567b = d2;
        e3 = e.r.f.e(s.a() * 128, f1567b, 2097150);
        d3 = u.d("kotlinx.coroutines.scheduler.max.pool.size", e3, 0, 2097150, 4, null);
        f1568c = d3;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e4 = u.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f1569d = timeUnit.toNanos(e4);
        f1570e = g.a;
    }
}
