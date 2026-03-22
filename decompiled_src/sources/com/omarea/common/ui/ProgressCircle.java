package com.omarea.common.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public final class ProgressCircle extends View {

    /* renamed from: e, reason: collision with root package name */
    private int f1236e;
    private int f;
    private float g;
    private float h;
    private int i;
    private Paint j;
    private Paint k;
    private Paint l;
    private final int m;
    private int n;
    private int o;
    private float p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e.p.d.i.d(context, "context");
        e.p.d.i.d(attributeSet, "attrs");
        this.g = 300.0f;
        this.h = 10.0f;
        this.i = 20;
        this.m = -7829368;
        this.p = 35.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.c.a.d.ProgressState);
        this.f1236e = (int) ((obtainStyledAttributes.getInteger(d.c.a.d.ProgressState_current, 1) * 100.0d) / obtainStyledAttributes.getInteger(d.c.a.d.ProgressState_total, 1));
        obtainStyledAttributes.recycle();
    }

    private final int a(Context context, float f) {
        Resources resources = context.getResources();
        e.p.d.i.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void b(android.graphics.Canvas r17) {
        /*
            r16 = this;
            r0 = r16
            android.graphics.Paint r1 = r0.j
            e.p.d.i.b(r1)
            r2 = 579373192(0x22888888, float:3.700743E-18)
            r1.setColor(r2)
            android.graphics.RectF r4 = new android.graphics.RectF
            float r1 = r0.g
            r2 = 0
            r4.<init>(r2, r2, r1, r1)
            android.graphics.Paint r8 = r0.j
            e.p.d.i.b(r8)
            r5 = 0
            r6 = 1135869952(0x43b40000, float:360.0)
            r7 = 0
            r3 = r17
            r3.drawArc(r4, r5, r6, r7, r8)
            float r1 = r0.p
            r3 = 48
            float r3 = (float) r3
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 >= 0) goto L48
            int r3 = r0.f
            r4 = 11
            if (r3 >= r4) goto L33
            goto L48
        L33:
            r3 = 44
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L40
            int r1 = r0.f1236e
            r3 = 16
            if (r1 >= r3) goto L59
        L40:
            android.graphics.Paint r1 = r0.j
            e.p.d.i.b(r1)
            r3 = -65536(0xffffffffffff0000, float:NaN)
            goto L56
        L48:
            android.graphics.Paint r1 = r0.j
            e.p.d.i.b(r1)
            r3 = 255(0xff, float:3.57E-43)
            r4 = 15
            r5 = 0
            int r3 = android.graphics.Color.rgb(r3, r4, r5)
        L56:
            r1.setColor(r3)
        L59:
            android.graphics.Paint r1 = r0.j
            e.p.d.i.b(r1)
            android.graphics.Paint$Cap r3 = android.graphics.Paint.Cap.ROUND
            r1.setStrokeCap(r3)
            int r1 = r0.f1236e
            r3 = 1
            if (r1 >= r3) goto L6e
            int r1 = r0.f
            r3 = 2
            if (r1 > r3) goto L6e
            return
        L6e:
            int r1 = r0.f
            r3 = 98
            if (r1 < r3) goto L8b
            android.graphics.RectF r5 = new android.graphics.RectF
            float r1 = r0.g
            r5.<init>(r2, r2, r1, r1)
            r6 = -1028390912(0xffffffffc2b40000, float:-90.0)
            r7 = 1135869952(0x43b40000, float:360.0)
            r8 = 0
            android.graphics.Paint r9 = r0.j
            e.p.d.i.b(r9)
            r4 = r17
            r4.drawArc(r5, r6, r7, r8, r9)
            goto La7
        L8b:
            android.graphics.RectF r11 = new android.graphics.RectF
            float r1 = r0.g
            r11.<init>(r2, r2, r1, r1)
            r12 = -1028390912(0xffffffffc2b40000, float:-90.0)
            int r1 = r0.f
            float r1 = (float) r1
            r2 = 1080452710(0x40666666, float:3.6)
            float r13 = r1 * r2
            r14 = 0
            android.graphics.Paint r15 = r0.j
            e.p.d.i.b(r15)
            r10 = r17
            r10.drawArc(r11, r12, r13, r14, r15)
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.common.ui.ProgressCircle.b(android.graphics.Canvas):void");
    }

    private final void c() {
        Paint paint = new Paint();
        this.j = paint;
        e.p.d.i.b(paint);
        paint.setAntiAlias(true);
        Paint paint2 = this.j;
        e.p.d.i.b(paint2);
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint3 = this.j;
        e.p.d.i.b(paint3);
        paint3.setStrokeWidth(this.h);
        Paint paint4 = new Paint();
        this.k = paint4;
        e.p.d.i.b(paint4);
        paint4.setAntiAlias(true);
        Paint paint5 = this.k;
        e.p.d.i.b(paint5);
        paint5.setColor(this.m);
        Paint paint6 = this.k;
        e.p.d.i.b(paint6);
        paint6.setStyle(Paint.Style.STROKE);
        Paint paint7 = this.k;
        e.p.d.i.b(paint7);
        paint7.setStrokeWidth(1.0f);
        Paint paint8 = this.k;
        e.p.d.i.b(paint8);
        paint8.setTextSize(this.i);
        Paint paint9 = new Paint();
        this.l = paint9;
        e.p.d.i.b(paint9);
        paint9.setAntiAlias(true);
        Paint paint10 = this.l;
        e.p.d.i.b(paint10);
        paint10.setStyle(Paint.Style.FILL);
        Paint paint11 = this.l;
        e.p.d.i.b(paint11);
        paint11.setStrokeWidth(20.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        e.p.d.i.d(canvas, "canvas");
        super.onDraw(canvas);
        float f = this.o / 2;
        float f2 = this.g;
        float f3 = 2;
        canvas.translate(f - (f2 / f3), (this.n / 2) - (f2 / f3));
        c();
        b(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.o = i;
        this.n = i2;
        Context context = getContext();
        e.p.d.i.c(context, "context");
        this.h = a(context, 10.0f);
        Context context2 = getContext();
        e.p.d.i.c(context2, "context");
        this.i = a(context2, 18.0f);
        this.g = (int) (((i > i2 ? i2 : i) * 0.9d) - r5);
    }
}
