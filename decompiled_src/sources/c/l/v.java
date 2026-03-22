package c.l;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* loaded from: classes.dex */
class v implements w {
    private final ViewGroupOverlay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ViewGroup viewGroup) {
        this.a = viewGroup.getOverlay();
    }

    @Override // c.l.w
    public void a(View view) {
        this.a.add(view);
    }

    @Override // c.l.b0
    public void b(Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // c.l.w
    public void c(View view) {
        this.a.remove(view);
    }

    @Override // c.l.b0
    public void d(Drawable drawable) {
        this.a.remove(drawable);
    }
}
