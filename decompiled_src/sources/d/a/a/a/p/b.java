package d.a.a.a.p;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import d.a.a.a.p.d;

/* loaded from: classes.dex */
public class b extends FrameLayout implements d {

    /* renamed from: e, reason: collision with root package name */
    private final c f1290e;

    @Override // d.a.a.a.p.d
    public void a() {
        this.f1290e.a();
    }

    @Override // d.a.a.a.p.d
    public void b() {
        this.f1290e.b();
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        c cVar = this.f1290e;
        if (cVar != null) {
            cVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f1290e.d();
    }

    @Override // d.a.a.a.p.d
    public int getCircularRevealScrimColor() {
        return this.f1290e.e();
    }

    @Override // d.a.a.a.p.d
    public d.e getRevealInfo() {
        return this.f1290e.f();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        c cVar = this.f1290e;
        return cVar != null ? cVar.g() : super.isOpaque();
    }

    @Override // d.a.a.a.p.d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f1290e.h(drawable);
    }

    @Override // d.a.a.a.p.d
    public void setCircularRevealScrimColor(int i) {
        this.f1290e.i(i);
    }

    @Override // d.a.a.a.p.d
    public void setRevealInfo(d.e eVar) {
        this.f1290e.j(eVar);
    }
}
