package androidx.appcompat.app;

/* loaded from: classes.dex */
class k {

    /* renamed from: d, reason: collision with root package name */
    private static k f90d;
    public long a;

    /* renamed from: b, reason: collision with root package name */
    public long f91b;

    /* renamed from: c, reason: collision with root package name */
    public int f92c;

    k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k b() {
        if (f90d == null) {
            f90d = new k();
        }
        return f90d;
    }

    public void a(long j, double d2, double d3) {
        double d4 = (0.01720197f * (((float) (j - 946728000000L)) / 8.64E7f)) + 6.24006f;
        double sin = (Math.sin(d4) * 0.03341960161924362d) + d4 + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double round = ((float) Math.round((r3 - 9.0E-4f) - r9)) + 9.0E-4f + ((-d3) / 360.0d) + (Math.sin(d4) * 0.0053d) + (Math.sin(2.0d * sin) * (-0.0069d));
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d5 = 0.01745329238474369d * d2;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d5) * Math.sin(asin))) / (Math.cos(d5) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.f92c = 1;
        } else {
            if (sin2 > -1.0d) {
                double acos = (float) (Math.acos(sin2) / 6.283185307179586d);
                this.a = Math.round((round + acos) * 8.64E7d) + 946728000000L;
                long round2 = Math.round((round - acos) * 8.64E7d) + 946728000000L;
                this.f91b = round2;
                if (round2 >= j || this.a <= j) {
                    this.f92c = 1;
                    return;
                } else {
                    this.f92c = 0;
                    return;
                }
            }
            this.f92c = 0;
        }
        this.a = -1L;
        this.f91b = -1L;
    }
}
