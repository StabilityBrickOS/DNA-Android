package c.l;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* loaded from: classes.dex */
class h<T> extends Property<T, Float> {
    private final Property<T, PointF> a;

    /* renamed from: b, reason: collision with root package name */
    private final PathMeasure f867b;

    /* renamed from: c, reason: collision with root package name */
    private final float f868c;

    /* renamed from: d, reason: collision with root package name */
    private final float[] f869d;

    /* renamed from: e, reason: collision with root package name */
    private final PointF f870e;
    private float f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f869d = new float[2];
        this.f870e = new PointF();
        this.a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f867b = pathMeasure;
        this.f868c = pathMeasure.getLength();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(T t) {
        return Float.valueOf(this.f);
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(T t, Float f) {
        this.f = f.floatValue();
        this.f867b.getPosTan(this.f868c * f.floatValue(), this.f869d, null);
        PointF pointF = this.f870e;
        float[] fArr = this.f869d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.a.set(t, pointF);
    }
}
