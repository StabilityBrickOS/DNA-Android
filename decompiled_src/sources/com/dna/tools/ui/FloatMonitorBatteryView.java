package com.dna.tools.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.dna.tools.R;
import com.dna.tools.h;
import e.p.d.i;

/* loaded from: classes.dex */
public final class FloatMonitorBatteryView extends View {

    /* renamed from: e, reason: collision with root package name */
    private int f1016e;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            FloatMonitorBatteryView floatMonitorBatteryView = FloatMonitorBatteryView.this;
            i.c(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            floatMonitorBatteryView.f = ((Integer) animatedValue).intValue();
            FloatMonitorBatteryView.this.invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatMonitorBatteryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.d(context, "context");
        i.d(attributeSet, "attrs");
        this.g = 300.0f;
        this.h = 40.0f;
        this.i = 20;
        this.m = -7829368;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.RamInfo);
        this.f1016e = 100 - ((int) ((obtainStyledAttributes.getInteger(0, 1) * 100.0d) / obtainStyledAttributes.getInteger(1, 1)));
        obtainStyledAttributes.recycle();
    }

    private final int c(Context context, float f) {
        Resources resources = context.getResources();
        i.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    private final void d(Canvas canvas) {
        Paint paint;
        Resources resources;
        int i;
        Paint paint2 = this.j;
        i.b(paint2);
        paint2.setColor(579373192);
        float f = this.g;
        canvas.drawArc(new RectF(0.0f, 0.0f, f, f), 0.0f, 360.0f, false, this.j);
        int i2 = this.f;
        if (i2 > 79) {
            paint = this.j;
            i.b(paint);
            resources = getResources();
            i = R.color.color_load_low;
        } else if (i2 > 40) {
            paint = this.j;
            i.b(paint);
            resources = getResources();
            i = R.color.color_load_mid;
        } else if (i2 > 25) {
            paint = this.j;
            i.b(paint);
            resources = getResources();
            i = R.color.color_load_hight;
        } else {
            paint = this.j;
            i.b(paint);
            resources = getResources();
            i = R.color.color_load_veryhight;
        }
        paint.setColor(resources.getColor(i));
        Paint paint3 = this.j;
        i.b(paint3);
        paint3.setStrokeCap(Paint.Cap.ROUND);
        if (this.f1016e >= 1 || this.f > 2) {
            if (this.f >= 98) {
                float f2 = this.g;
                RectF rectF = new RectF(0.0f, 0.0f, f2, f2);
                Paint paint4 = this.j;
                i.b(paint4);
                canvas.drawArc(rectF, -90.0f, 360.0f, false, paint4);
                return;
            }
            float f3 = this.g;
            Paint paint5 = this.j;
            i.b(paint5);
            canvas.drawArc(new RectF(0.0f, 0.0f, f3, f3), -90.0f, this.f * 3.6f, false, paint5);
        }
    }

    private final void e() {
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

    public final void b(int i) {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f, i);
        i.c(ofInt, "va");
        ofInt.setDuration(200L);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(new a());
        ofInt.start();
    }

    public final void f(float f, float f2) {
        this.f1016e = (f2 == f && f == 0.0f) ? 0 : 100 - ((int) ((f2 * 100.0d) / f));
        b(this.f1016e);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        i.d(canvas, "canvas");
        super.onDraw(canvas);
        float f = this.o / 2;
        float f2 = this.g;
        float f3 = 2;
        canvas.translate(f - (f2 / f3), (this.n / 2) - (f2 / f3));
        e();
        d(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.o = i;
        this.n = i2;
        Context context = getContext();
        i.c(context, "context");
        this.h = c(context, 4.0f);
        Context context2 = getContext();
        i.c(context2, "context");
        this.i = c(context2, 18.0f);
        this.g = (int) (((i > i2 ? i2 : i) * 0.9d) - r5);
    }
}
