package d.a.a.a.z;

/* loaded from: classes.dex */
public class e extends d {
    float a = -1.0f;

    @Override // d.a.a.a.z.d
    public void a(m mVar, float f, float f2, float f3) {
        mVar.o(0.0f, f3 * f2, 180.0f, 180.0f - f);
        double d2 = f3;
        double d3 = f2;
        mVar.m((float) (Math.sin(Math.toRadians(f)) * d2 * d3), (float) (Math.sin(Math.toRadians(90.0f - f)) * d2 * d3));
    }
}
