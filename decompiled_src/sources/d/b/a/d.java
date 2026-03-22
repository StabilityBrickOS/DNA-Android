package d.b.a;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.AnimationUtils;

/* loaded from: classes.dex */
public class d {
    private long a;

    /* renamed from: b, reason: collision with root package name */
    private int f1360b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1361c;

    /* renamed from: d, reason: collision with root package name */
    private int f1362d;

    /* renamed from: e, reason: collision with root package name */
    private float f1363e;
    private a f;

    /* loaded from: classes.dex */
    public static class a {
        private float[] a;

        /* renamed from: b, reason: collision with root package name */
        private float[] f1364b;

        public a(Path path) {
            AnimationUtils.currentAnimationTimeMillis();
            PathMeasure pathMeasure = new PathMeasure(path, false);
            float length = pathMeasure.getLength();
            int i = ((int) (length / 0.002f)) + 1;
            this.a = new float[i];
            this.f1364b = new float[i];
            float[] fArr = new float[2];
            for (int i2 = 0; i2 < i; i2++) {
                pathMeasure.getPosTan((i2 * length) / (i - 1), fArr, null);
                this.a[i2] = fArr[0];
                this.f1364b[i2] = fArr[1];
            }
            AnimationUtils.currentAnimationTimeMillis();
        }

        float a(float f) {
            int i = 0;
            if (f <= 0.0f) {
                return this.f1364b[0];
            }
            if (f >= 1.0f) {
                float[] fArr = this.f1364b;
                return fArr[fArr.length - 1];
            }
            int length = this.a.length - 1;
            while (length - i > 1) {
                int i2 = (i + length) / 2;
                if (f < this.a[i2]) {
                    length = i2;
                } else {
                    i = i2;
                }
            }
            float[] fArr2 = this.a;
            float f2 = fArr2[length] - fArr2[i];
            if (f2 == 0.0f) {
                return this.f1364b[i];
            }
            float f3 = (f - fArr2[i]) / f2;
            float[] fArr3 = this.f1364b;
            float f4 = fArr3[i];
            return f4 + (f3 * (fArr3[length] - f4));
        }
    }

    public void a() {
        this.f1361c = true;
    }

    public boolean b() {
        if (this.f1361c) {
            return false;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.a;
        float f = 1.0f;
        int i = this.f1360b;
        float f2 = (((float) currentAnimationTimeMillis) * 1.0f) / i;
        if (currentAnimationTimeMillis >= i) {
            this.f1361c = true;
        } else {
            f = f2;
        }
        this.f1362d = Math.round(this.f1363e * this.f.a(f));
        return true;
    }

    public int c() {
        return this.f1362d;
    }

    public void d(float f, int i, a aVar) {
        this.f1363e = f;
        this.f1360b = i;
        this.f1361c = false;
        this.f = aVar;
        this.a = AnimationUtils.currentAnimationTimeMillis();
    }
}
