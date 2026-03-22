package d.a.a.a.x;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import d.a.a.a.z.g;
import d.a.a.a.z.k;
import d.a.a.a.z.n;

/* loaded from: classes.dex */
public class a extends Drawable implements n, androidx.core.graphics.drawable.b {

    /* renamed from: e, reason: collision with root package name */
    private b f1308e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends Drawable.ConstantState {
        g a;

        /* renamed from: b, reason: collision with root package name */
        boolean f1309b;

        public b(b bVar) {
            this.a = (g) bVar.a.getConstantState().newDrawable();
            this.f1309b = bVar.f1309b;
        }

        public b(g gVar) {
            this.a = gVar;
            this.f1309b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }
    }

    private a(b bVar) {
        this.f1308e = bVar;
    }

    public a(k kVar) {
        this(new b(new g(kVar)));
    }

    public a a() {
        this.f1308e = new b(this.f1308e);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f1308e;
        if (bVar.f1309b) {
            bVar.a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f1308e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f1308e.a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable mutate() {
        a();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f1308e.a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f1308e.a.setState(iArr)) {
            onStateChange = true;
        }
        boolean b2 = d.a.a.a.x.b.b(iArr);
        b bVar = this.f1308e;
        if (bVar.f1309b == b2) {
            return onStateChange;
        }
        bVar.f1309b = b2;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f1308e.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1308e.a.setColorFilter(colorFilter);
    }

    @Override // d.a.a.a.z.n
    public void setShapeAppearanceModel(k kVar) {
        this.f1308e.a.setShapeAppearanceModel(kVar);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        this.f1308e.a.setTint(i);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f1308e.a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f1308e.a.setTintMode(mode);
    }
}
