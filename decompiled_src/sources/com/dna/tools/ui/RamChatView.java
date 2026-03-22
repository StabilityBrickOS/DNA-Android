package com.dna.tools.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.dna.tools.R;
import com.dna.tools.h;
import e.p.d.i;

/* loaded from: classes.dex */
public final class RamChatView extends View {

    /* renamed from: e, reason: collision with root package name */
    private int f1018e;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RamChatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.d(context, "context");
        i.d(attributeSet, "attrs");
        this.g = 300.0f;
        this.h = 40.0f;
        this.i = 20;
        this.m = -7829368;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.RamInfo);
        this.f1018e = 100 - ((int) ((obtainStyledAttributes.getInteger(0, 1) * 100.0d) / obtainStyledAttributes.getInteger(1, 1)));
        obtainStyledAttributes.recycle();
    }

    private final int a(Context context, float f) {
        Resources resources = context.getResources();
        i.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    private final void b(Canvas canvas) {
        int i;
        Paint paint = this.j;
        i.b(paint);
        paint.setColor(1149798536);
        Paint paint2 = this.j;
        i.b(paint2);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        float f = this.g;
        canvas.drawArc(new RectF(0.0f, 0.0f, f, f), 0.0f, 360.0f, false, this.j);
        if (this.f1018e == 0) {
            return;
        }
        Paint paint3 = this.j;
        i.b(paint3);
        paint3.setColor(getResources().getColor(R.color.colorAccent));
        Paint paint4 = this.j;
        i.b(paint4);
        paint4.setAlpha((this.f1018e * 255) / 100);
        float f2 = this.g;
        Paint paint5 = this.j;
        i.b(paint5);
        canvas.drawArc(new RectF(0.0f, 0.0f, f2, f2), -90.0f, (this.f * 3.6f) + 1.0f, false, paint5);
        int i2 = this.f;
        int i3 = this.f1018e;
        if (i2 < i3) {
            i = i2 + 1;
        } else if (i2 <= i3) {
            return;
        } else {
            i = i2 - 1;
        }
        this.f = i;
        invalidate();
    }

    private final void c() {
        Paint paint = new Paint();
        this.j = paint;
        i.b(paint);
        paint.setAntiAlias(true);
        Paint paint2 = this.j;
        i.b(paint2);
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint3 = this.j;
        i.b(paint3);
        paint3.setStrokeWidth(this.h);
        Paint paint4 = new Paint();
        this.k = paint4;
        i.b(paint4);
        paint4.setAntiAlias(true);
        Paint paint5 = this.k;
        i.b(paint5);
        paint5.setColor(this.m);
        Paint paint6 = this.k;
        i.b(paint6);
        paint6.setStyle(Paint.Style.STROKE);
        Paint paint7 = this.k;
        i.b(paint7);
        paint7.setStrokeWidth(1.0f);
        Paint paint8 = this.k;
        i.b(paint8);
        paint8.setTextSize(this.i);
        Paint paint9 = new Paint();
        this.l = paint9;
        i.b(paint9);
        paint9.setAntiAlias(true);
        Paint paint10 = this.l;
        i.b(paint10);
        paint10.setStyle(Paint.Style.FILL);
        Paint paint11 = this.l;
        i.b(paint11);
        paint11.setStrokeWidth(2.0f);
    }

    public final void d(float f, float f2) {
        this.f1018e = (f2 == f && f == 0.0f) ? 0 : 100 - ((int) ((f2 * 100.0d) / f));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        i.d(canvas, "canvas");
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
        i.c(context, "context");
        this.h = a(context, 8.0f);
        Context context2 = getContext();
        i.c(context2, "context");
        this.i = a(context2, 18.0f);
        this.g = (int) (((i > i2 ? i2 : i) * 0.9d) - r5);
    }
}
