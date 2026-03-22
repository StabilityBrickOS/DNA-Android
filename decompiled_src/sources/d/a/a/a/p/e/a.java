package d.a.a.a.p.e;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import d.a.a.a.p.c;
import d.a.a.a.p.d;

/* loaded from: classes.dex */
public class a extends d.a.a.a.n.a implements d {
    private final c r;

    @Override // d.a.a.a.p.d
    public void a() {
        this.r.a();
    }

    @Override // d.a.a.a.p.d
    public void b() {
        this.r.b();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        c cVar = this.r;
        if (cVar != null) {
            cVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.r.d();
    }

    @Override // d.a.a.a.p.d
    public int getCircularRevealScrimColor() {
        return this.r.e();
    }

    @Override // d.a.a.a.p.d
    public d.e getRevealInfo() {
        return this.r.f();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        c cVar = this.r;
        return cVar != null ? cVar.g() : super.isOpaque();
    }

    @Override // d.a.a.a.p.d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.r.h(drawable);
    }

    @Override // d.a.a.a.p.d
    public void setCircularRevealScrimColor(int i) {
        this.r.i(i);
    }

    @Override // d.a.a.a.p.d
    public void setRevealInfo(d.e eVar) {
        this.r.j(eVar);
    }
}
