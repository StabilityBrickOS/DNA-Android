package d.a.a.a.l;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public class i {
    private long a;

    /* renamed from: b, reason: collision with root package name */
    private long f1284b;

    /* renamed from: c, reason: collision with root package name */
    private TimeInterpolator f1285c;

    /* renamed from: d, reason: collision with root package name */
    private int f1286d;

    /* renamed from: e, reason: collision with root package name */
    private int f1287e;

    public i(long j, long j2) {
        this.a = 0L;
        this.f1284b = 300L;
        this.f1285c = null;
        this.f1286d = 0;
        this.f1287e = 1;
        this.a = j;
        this.f1284b = j2;
    }

    public i(long j, long j2, TimeInterpolator timeInterpolator) {
        this.a = 0L;
        this.f1284b = 300L;
        this.f1285c = null;
        this.f1286d = 0;
        this.f1287e = 1;
        this.a = j;
        this.f1284b = j2;
        this.f1285c = timeInterpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i b(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f1286d = valueAnimator.getRepeatCount();
        iVar.f1287e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? a.f1276b : interpolator instanceof AccelerateInterpolator ? a.f1277c : interpolator instanceof DecelerateInterpolator ? a.f1278d : interpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.a;
    }

    public long d() {
        return this.f1284b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f1285c;
        return timeInterpolator != null ? timeInterpolator : a.f1276b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (c() == iVar.c() && d() == iVar.d() && g() == iVar.g() && h() == iVar.h()) {
            return e().getClass().equals(iVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f1286d;
    }

    public int h() {
        return this.f1287e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return '\n' + i.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }
}
