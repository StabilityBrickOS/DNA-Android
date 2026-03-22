package com.dna.tools.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.dna.tools.R;
import com.dna.tools.h;
import e.p.d.i;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public final class CpuChartBarView extends View {

    /* renamed from: e, reason: collision with root package name */
    private Paint f1015e;
    private float f;
    private LinkedBlockingQueue<Integer> g;
    private float h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpuChartBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.d(context, "context");
        i.d(attributeSet, "attrs");
        this.g = new LinkedBlockingQueue<>();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.RamInfo);
        for (int i = 0; i <= 4; i++) {
            this.g.put(0);
        }
        obtainStyledAttributes.recycle();
    }

    public final void a(float f, float f2) {
        if (f2 == f && f == 0.0f) {
            this.g.put(0);
        } else {
            this.g.put(Integer.valueOf(100 - ((int) ((f2 * 100.0d) / f))));
        }
        if (this.g.size() > 5) {
            this.g.poll();
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float intValue;
        float f;
        i.d(canvas, "canvas");
        super.onDraw(canvas);
        if (this.f1015e == null) {
            Paint paint = new Paint();
            this.f1015e = paint;
            i.b(paint);
            paint.setAntiAlias(true);
            Paint paint2 = this.f1015e;
            i.b(paint2);
            paint2.setStyle(Paint.Style.FILL);
            this.h = getWidth() / 5;
            Paint paint3 = this.f1015e;
            i.b(paint3);
            paint3.setStrokeWidth(0.0f);
            Paint paint4 = this.f1015e;
            i.b(paint4);
            paint4.setColor(getResources().getColor(R.color.colorAccent));
        }
        int i = 0;
        float f2 = this.h;
        Iterator<Integer> it = this.g.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            Paint paint5 = this.f1015e;
            i.b(paint5);
            paint5.setAlpha((next.intValue() * 255) / 100);
            if (next.intValue() <= 2) {
                intValue = this.f - 10.0f;
            } else if (next.intValue() >= 98) {
                f = 0.0f;
                float f3 = f2 * i;
                float f4 = this.f;
                Paint paint6 = this.f1015e;
                i.b(paint6);
                canvas.drawRoundRect(f3, f, f3 + (0.9f * f2), f4, 5.0f, 5.0f, paint6);
                i++;
            } else {
                i.c(next, "ratio");
                intValue = ((100 - next.intValue()) * this.f) / 100;
            }
            f = intValue;
            float f32 = f2 * i;
            float f42 = this.f;
            Paint paint62 = this.f1015e;
            i.b(paint62);
            canvas.drawRoundRect(f32, f, f32 + (0.9f * f2), f42, 5.0f, 5.0f, paint62);
            i++;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f = i2;
    }
}
