package d.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import c.f.l.i;
import c.f.l.s;
import d.b.a.d;

/* loaded from: classes.dex */
public class a {
    private static final b l = new C0091a();
    private static final d.a m = a();
    private static final d.a n = b();

    /* renamed from: b, reason: collision with root package name */
    private final int f1354b;

    /* renamed from: c, reason: collision with root package name */
    private float f1355c;

    /* renamed from: d, reason: collision with root package name */
    private float f1356d;
    private final d f;
    private final View g;
    private c h;
    private b k;
    private int a = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f1357e = -1;
    private boolean i = true;
    private boolean j = true;

    /* renamed from: d.b.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0091a extends b {
        C0091a() {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        static {
            float f = Resources.getSystem().getDisplayMetrics().density;
        }

        public void a(float f, Canvas canvas, View view) {
        }

        public void b(float f, Canvas canvas, View view) {
        }

        public void c(float f, Canvas canvas, View view) {
            canvas.translate(0.0f, Math.round(f * 0.36f));
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        int a();

        void b(MotionEvent motionEvent);

        boolean c(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z);

        boolean d();

        int e();

        int f();

        void g(Canvas canvas);

        View getOverScrollableView();
    }

    public a(c cVar) {
        View overScrollableView = cVar.getOverScrollableView();
        this.g = overScrollableView;
        if (overScrollableView instanceof RecyclerView) {
            overScrollableView.setOverScrollMode(0);
        } else {
            overScrollableView.setOverScrollMode(2);
        }
        this.h = cVar;
        Context context = this.g.getContext();
        this.f = new d();
        this.f1354b = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
        this.k = l;
    }

    private static d.a a() {
        Path path = new Path();
        path.moveTo(0.0f, 1.0f);
        path.cubicTo(0.11f, 0.11f, 0.36f, 0.05f, 1.0f, 0.0f);
        return new d.a(path);
    }

    private static d.a b() {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(0.05f, 0.8f, 0.09f, 1.2f, 0.21f, 0.88f);
        path.cubicTo(0.48f, 0.1f, 0.72f, 0.02f, 1.0f, 0.0f);
        return new d.a(path);
    }

    private boolean d() {
        return this.a == 2;
    }

    private boolean e() {
        int i = this.a;
        return i == 1 || i == 2;
    }

    private boolean f() {
        return this.a == 1;
    }

    private void g(String str) {
        Log.d("OverScrollDelegate", str);
    }

    private void h(int i) {
        this.f1356d = i > 0 ? -1 : 1;
        float f = i * 0.07f;
        g("velocityY->" + i + " overY->" + f);
        this.f.d(f, 550, n);
        o(4);
        this.g.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean j(android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.a.a.j(android.view.MotionEvent):boolean");
    }

    private void k(MotionEvent motionEvent) {
        int b2 = i.b(motionEvent);
        if (i.d(motionEvent, b2) == this.f1357e) {
            this.f1357e = i.d(motionEvent, b2 == 0 ? 1 : 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m(android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.a.a.m(android.view.MotionEvent):boolean");
    }

    private void o(int i) {
        if (this.a != i) {
            this.a = i;
            g("setState->" + (i == 0 ? "OS_NONE" : i == 1 ? "OS_TOP" : i == 2 ? "OS_BOTTOM" : i == 3 ? "OS_SPRING_BACK" : i == 4 ? "OS_FLING" : ""));
        }
    }

    public void c(Canvas canvas) {
        int i = this.a;
        if (i == 0) {
            this.h.g(canvas);
            return;
        }
        if (i == 3 || i == 4) {
            if (this.f.b()) {
                this.f1356d = this.f.c();
            } else {
                this.f1356d = 0.0f;
                o(0);
            }
            s.Z(this.g);
        }
        int save = canvas.save();
        this.k.c(this.f1356d, canvas, this.g);
        this.h.g(canvas);
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        float f = this.f1356d;
        if (f > 0.0f) {
            this.k.b(f, canvas, this.g);
        } else if (f < 0.0f) {
            this.k.a(f, canvas, this.g);
        }
        canvas.restoreToCount(save2);
    }

    public boolean i(MotionEvent motionEvent) {
        if (this.i) {
            return j(motionEvent);
        }
        return false;
    }

    public boolean l(MotionEvent motionEvent) {
        if (this.i) {
            return m(motionEvent);
        }
        return false;
    }

    public boolean n(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean c2 = this.h.c(i, i2, i3, i4, i5, i6, 0, 0, z);
        if (!this.j) {
            return c2;
        }
        if (c2) {
            if (!z && this.a != 4) {
                g("deltaY->" + i2);
                h(-((int) (((float) i2) / 0.0166666f)));
            }
        } else if (this.a == 4) {
            g("warning, overScroll=flase BUT mState=OS_FLING");
        }
        return c2;
    }
}
