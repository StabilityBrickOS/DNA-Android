package d.b.a;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import d.b.a.a;

/* loaded from: classes.dex */
public class b extends ListView implements a.c {

    /* renamed from: e, reason: collision with root package name */
    private a f1358e;

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h(context);
    }

    private void h(Context context) {
        this.f1358e = new a(this);
    }

    @Override // d.b.a.a.c
    public int a() {
        return super.computeVerticalScrollRange();
    }

    @Override // d.b.a.a.c
    public void b(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
    }

    @Override // d.b.a.a.c
    public boolean c(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // d.b.a.a.c
    public boolean d() {
        return super.awakenScrollBars();
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        this.f1358e.c(canvas);
    }

    @Override // d.b.a.a.c
    public int e() {
        return super.computeVerticalScrollExtent();
    }

    @Override // d.b.a.a.c
    public int f() {
        return super.computeVerticalScrollOffset();
    }

    @Override // d.b.a.a.c
    public void g(Canvas canvas) {
        super.draw(canvas);
    }

    public a getOverScrollDelegate() {
        return this.f1358e;
    }

    @Override // d.b.a.a.c
    public View getOverScrollableView() {
        return this;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f1358e.i(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1358e.l(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return this.f1358e.n(i, i2, i3, i4, i5, i6, i7, i8, z);
    }
}
