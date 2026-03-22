package d.a.a.a.n;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import d.a.a.a.z.h;
import d.a.a.a.z.k;
import d.a.a.a.z.n;

/* loaded from: classes.dex */
public class a extends c.c.a.a implements Checkable, n {
    private static final int[] o = {R.attr.state_checkable};
    private static final int[] p = {R.attr.state_checked};
    private static final int[] q = {d.a.a.a.b.state_dragged};
    private final b j;
    private boolean k;
    private boolean l;
    private boolean m;
    private InterfaceC0086a n;

    /* renamed from: d.a.a.a.n.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0086a {
        void a(a aVar, boolean z);
    }

    private void d() {
        if (Build.VERSION.SDK_INT > 26) {
            this.j.a();
        }
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.j.b().getBounds());
        return rectF;
    }

    public boolean e() {
        b bVar = this.j;
        return bVar != null && bVar.p();
    }

    public boolean f() {
        return this.m;
    }

    @Override // c.c.a.a
    public ColorStateList getCardBackgroundColor() {
        return this.j.c();
    }

    public ColorStateList getCardForegroundColor() {
        return this.j.d();
    }

    float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.j.e();
    }

    public ColorStateList getCheckedIconTint() {
        return this.j.f();
    }

    @Override // c.c.a.a
    public int getContentPaddingBottom() {
        return this.j.n().bottom;
    }

    @Override // c.c.a.a
    public int getContentPaddingLeft() {
        return this.j.n().left;
    }

    @Override // c.c.a.a
    public int getContentPaddingRight() {
        return this.j.n().right;
    }

    @Override // c.c.a.a
    public int getContentPaddingTop() {
        return this.j.n().top;
    }

    public float getProgress() {
        return this.j.h();
    }

    @Override // c.c.a.a
    public float getRadius() {
        return this.j.g();
    }

    public ColorStateList getRippleColor() {
        return this.j.i();
    }

    public k getShapeAppearanceModel() {
        return this.j.j();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.j.k();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.j.l();
    }

    public int getStrokeWidth() {
        return this.j.m();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.l;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.f(this, this.j.b());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 3);
        if (e()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, o);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, p);
        }
        if (f()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, q);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(e());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // c.c.a.a, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.j.q(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.k) {
            if (!this.j.o()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.j.r(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // c.c.a.a
    public void setCardBackgroundColor(int i) {
        this.j.s(ColorStateList.valueOf(i));
    }

    @Override // c.c.a.a
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.j.s(colorStateList);
    }

    @Override // c.c.a.a
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        this.j.F();
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        this.j.t(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.j.u(z);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.l != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.j.v(drawable);
    }

    public void setCheckedIconResource(int i) {
        this.j.v(c.a.k.a.a.d(getContext(), i));
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.j.w(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        b bVar = this.j;
        if (bVar != null) {
            bVar.D();
        }
    }

    public void setDragged(boolean z) {
        if (this.m != z) {
            this.m = z;
            refreshDrawableState();
            d();
            invalidate();
        }
    }

    @Override // c.c.a.a
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.j.G();
    }

    public void setOnCheckedChangeListener(InterfaceC0086a interfaceC0086a) {
        this.n = interfaceC0086a;
    }

    @Override // c.c.a.a
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.j.G();
        this.j.E();
    }

    public void setProgress(float f) {
        this.j.y(f);
    }

    @Override // c.c.a.a
    public void setRadius(float f) {
        super.setRadius(f);
        this.j.x(f);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.j.z(colorStateList);
    }

    public void setRippleColorResource(int i) {
        this.j.z(c.a.k.a.a.c(getContext(), i));
    }

    @Override // d.a.a.a.z.n
    public void setShapeAppearanceModel(k kVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(kVar.u(getBoundsAsRectF()));
        }
        this.j.A(kVar);
    }

    public void setStrokeColor(int i) {
        this.j.B(ColorStateList.valueOf(i));
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.j.B(colorStateList);
    }

    public void setStrokeWidth(int i) {
        this.j.C(i);
    }

    @Override // c.c.a.a
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.j.G();
        this.j.E();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (e() && isEnabled()) {
            this.l = !this.l;
            refreshDrawableState();
            d();
            InterfaceC0086a interfaceC0086a = this.n;
            if (interfaceC0086a != null) {
                interfaceC0086a.a(this, this.l);
            }
        }
    }
}
