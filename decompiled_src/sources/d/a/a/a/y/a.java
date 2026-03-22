package d.a.a.a.y;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* loaded from: classes.dex */
public class a {
    private static final int[] i = new int[3];
    private static final float[] j = {0.0f, 0.5f, 1.0f};
    private static final int[] k = new int[4];
    private static final float[] l = {0.0f, 0.0f, 0.5f, 1.0f};
    private final Paint a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f1312b;

    /* renamed from: c, reason: collision with root package name */
    private final Paint f1313c;

    /* renamed from: d, reason: collision with root package name */
    private int f1314d;

    /* renamed from: e, reason: collision with root package name */
    private int f1315e;
    private int f;
    private final Path g;
    private Paint h;

    public a() {
        this(-16777216);
    }

    public a(int i2) {
        this.g = new Path();
        this.h = new Paint();
        this.a = new Paint();
        d(i2);
        this.h.setColor(0);
        Paint paint = new Paint(4);
        this.f1312b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f1313c = new Paint(this.f1312b);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i2, float f, float f2) {
        boolean z = f2 < 0.0f;
        Path path = this.g;
        if (z) {
            int[] iArr = k;
            iArr[0] = 0;
            iArr[1] = this.f;
            iArr[2] = this.f1315e;
            iArr[3] = this.f1314d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f, f2);
            path.close();
            float f3 = -i2;
            rectF.inset(f3, f3);
            int[] iArr2 = k;
            iArr2[0] = 0;
            iArr2[1] = this.f1314d;
            iArr2[2] = this.f1315e;
            iArr2[3] = this.f;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f4 = 1.0f - (i2 / width);
        float[] fArr = l;
        fArr[1] = f4;
        fArr[2] = ((1.0f - f4) / 2.0f) + f4;
        this.f1312b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, k, l, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        if (!z) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.h);
        }
        canvas.drawArc(rectF, f, f2, true, this.f1312b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i2) {
        rectF.bottom += i2;
        rectF.offset(0.0f, -i2);
        int[] iArr = i;
        iArr[0] = this.f;
        iArr[1] = this.f1315e;
        iArr[2] = this.f1314d;
        Paint paint = this.f1313c;
        float f = rectF.left;
        paint.setShader(new LinearGradient(f, rectF.top, f, rectF.bottom, i, j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f1313c);
        canvas.restore();
    }

    public Paint c() {
        return this.a;
    }

    public void d(int i2) {
        this.f1314d = c.f.e.a.d(i2, 68);
        this.f1315e = c.f.e.a.d(i2, 20);
        this.f = c.f.e.a.d(i2, 0);
        this.a.setColor(this.f1314d);
    }
}
