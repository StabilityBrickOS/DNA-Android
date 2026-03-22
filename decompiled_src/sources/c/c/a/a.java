package c.c.a;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class a extends FrameLayout {
    private static final f i;

    /* renamed from: e, reason: collision with root package name */
    private boolean f672e;
    private boolean f;
    final Rect g;
    private final e h;

    static {
        int i2 = Build.VERSION.SDK_INT;
        i = i2 >= 21 ? new c() : i2 >= 17 ? new b() : new d();
        i.m();
    }

    public ColorStateList getCardBackgroundColor() {
        return i.f(this.h);
    }

    public float getCardElevation() {
        return i.k(this.h);
    }

    public int getContentPaddingBottom() {
        return this.g.bottom;
    }

    public int getContentPaddingLeft() {
        return this.g.left;
    }

    public int getContentPaddingRight() {
        return this.g.right;
    }

    public int getContentPaddingTop() {
        return this.g.top;
    }

    public float getMaxCardElevation() {
        return i.a(this.h);
    }

    public boolean getPreventCornerOverlap() {
        return this.f;
    }

    public float getRadius() {
        return i.b(this.h);
    }

    public boolean getUseCompatPadding() {
        return this.f672e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (!(i instanceof c)) {
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(i.d(this.h)), View.MeasureSpec.getSize(i2)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(i.c(this.h)), View.MeasureSpec.getSize(i3)), mode2);
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        i.j(this.h, ColorStateList.valueOf(i2));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        i.j(this.h, colorStateList);
    }

    public void setCardElevation(float f) {
        i.g(this.h, f);
    }

    public void setMaxCardElevation(float f) {
        i.l(this.h, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        super.setMinimumHeight(i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i2) {
        super.setMinimumWidth(i2);
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f) {
            this.f = z;
            i.i(this.h);
        }
    }

    public void setRadius(float f) {
        i.h(this.h, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f672e != z) {
            this.f672e = z;
            i.e(this.h);
        }
    }
}
