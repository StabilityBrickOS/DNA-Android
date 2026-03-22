package c.c.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import c.c.a.h;

/* loaded from: classes.dex */
class b extends d {

    /* loaded from: classes.dex */
    class a implements h.a {
        a(b bVar) {
        }

        @Override // c.c.a.h.a
        public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    @Override // c.c.a.d, c.c.a.f
    public void m() {
        h.r = new a(this);
    }
}
