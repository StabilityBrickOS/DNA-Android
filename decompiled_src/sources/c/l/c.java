package c.l;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* loaded from: classes.dex */
public class c extends m {
    private static final String[] Q = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> R = new b(PointF.class, "boundsOrigin");
    private static final Property<k, PointF> S = new C0047c(PointF.class, "topLeft");
    private static final Property<k, PointF> T = new d(PointF.class, "bottomRight");
    private static final Property<View, PointF> U = new e(PointF.class, "bottomRight");
    private static final Property<View, PointF> V = new f(PointF.class, "topLeft");
    private static final Property<View, PointF> W = new g(PointF.class, "position");
    private static c.l.k X = new c.l.k();
    private int[] N = new int[2];
    private boolean O = false;
    private boolean P = false;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f847b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f848c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f849d;

        a(c cVar, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
            this.a = viewGroup;
            this.f847b = bitmapDrawable;
            this.f848c = view;
            this.f849d = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c0.b(this.a).d(this.f847b);
            c0.g(this.f848c, this.f849d);
        }
    }

    /* loaded from: classes.dex */
    static class b extends Property<Drawable, PointF> {
        private Rect a;

        b(Class cls, String str) {
            super(cls, str);
            this.a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.a);
            Rect rect = this.a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.a);
            this.a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.a);
        }
    }

    /* renamed from: c.l.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0047c extends Property<k, PointF> {
        C0047c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    /* loaded from: classes.dex */
    static class d extends Property<k, PointF> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    /* loaded from: classes.dex */
    static class e extends Property<View, PointF> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            c0.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* loaded from: classes.dex */
    static class f extends Property<View, PointF> {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            c0.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* loaded from: classes.dex */
    static class g extends Property<View, PointF> {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            c0.f(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* loaded from: classes.dex */
    class h extends AnimatorListenerAdapter {
        final /* synthetic */ k a;
        private k mViewBounds;

        h(c cVar, k kVar) {
            this.a = kVar;
            this.mViewBounds = this.a;
        }
    }

    /* loaded from: classes.dex */
    class i extends AnimatorListenerAdapter {
        private boolean a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f850b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f851c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f852d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f853e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;

        i(c cVar, View view, Rect rect, int i, int i2, int i3, int i4) {
            this.f850b = view;
            this.f851c = rect;
            this.f852d = i;
            this.f853e = i2;
            this.f = i3;
            this.g = i4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            c.f.l.s.o0(this.f850b, this.f851c);
            c0.f(this.f850b, this.f852d, this.f853e, this.f, this.g);
        }
    }

    /* loaded from: classes.dex */
    class j extends n {
        boolean a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f854b;

        j(c cVar, ViewGroup viewGroup) {
            this.f854b = viewGroup;
        }

        @Override // c.l.n, c.l.m.f
        public void a(m mVar) {
            x.c(this.f854b, false);
        }

        @Override // c.l.n, c.l.m.f
        public void b(m mVar) {
            x.c(this.f854b, true);
        }

        @Override // c.l.n, c.l.m.f
        public void d(m mVar) {
            x.c(this.f854b, false);
            this.a = true;
        }

        @Override // c.l.m.f
        public void e(m mVar) {
            if (!this.a) {
                x.c(this.f854b, false);
            }
            mVar.P(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class k {
        private int a;

        /* renamed from: b, reason: collision with root package name */
        private int f855b;

        /* renamed from: c, reason: collision with root package name */
        private int f856c;

        /* renamed from: d, reason: collision with root package name */
        private int f857d;

        /* renamed from: e, reason: collision with root package name */
        private View f858e;
        private int f;
        private int g;

        k(View view) {
            this.f858e = view;
        }

        private void b() {
            c0.f(this.f858e, this.a, this.f855b, this.f856c, this.f857d);
            this.f = 0;
            this.g = 0;
        }

        void a(PointF pointF) {
            this.f856c = Math.round(pointF.x);
            this.f857d = Math.round(pointF.y);
            int i = this.g + 1;
            this.g = i;
            if (this.f == i) {
                b();
            }
        }

        void c(PointF pointF) {
            this.a = Math.round(pointF.x);
            this.f855b = Math.round(pointF.y);
            int i = this.f + 1;
            this.f = i;
            if (i == this.g) {
                b();
            }
        }
    }

    private void c0(s sVar) {
        View view = sVar.f898b;
        if (!c.f.l.s.O(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        sVar.a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        sVar.a.put("android:changeBounds:parent", sVar.f898b.getParent());
        if (this.P) {
            sVar.f898b.getLocationInWindow(this.N);
            sVar.a.put("android:changeBounds:windowX", Integer.valueOf(this.N[0]));
            sVar.a.put("android:changeBounds:windowY", Integer.valueOf(this.N[1]));
        }
        if (this.O) {
            sVar.a.put("android:changeBounds:clip", c.f.l.s.r(view));
        }
    }

    private boolean d0(View view, View view2) {
        if (!this.P) {
            return true;
        }
        s t = t(view, true);
        if (t == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == t.f898b) {
            return true;
        }
        return false;
    }

    @Override // c.l.m
    public String[] D() {
        return Q;
    }

    @Override // c.l.m
    public void g(s sVar) {
        c0(sVar);
    }

    @Override // c.l.m
    public void j(s sVar) {
        c0(sVar);
    }

    @Override // c.l.m
    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        int i2;
        View view;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator c2;
        Path a2;
        Property<View, PointF> property;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map<String, Object> map = sVar.a;
        Map<String, Object> map2 = sVar2.a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar2.f898b;
        if (!d0(viewGroup2, viewGroup3)) {
            int intValue = ((Integer) sVar.a.get("android:changeBounds:windowX")).intValue();
            int intValue2 = ((Integer) sVar.a.get("android:changeBounds:windowY")).intValue();
            int intValue3 = ((Integer) sVar2.a.get("android:changeBounds:windowX")).intValue();
            int intValue4 = ((Integer) sVar2.a.get("android:changeBounds:windowY")).intValue();
            if (intValue == intValue3 && intValue2 == intValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.N);
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(createBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
            float c3 = c0.c(view2);
            c0.g(view2, 0.0f);
            c0.b(viewGroup).b(bitmapDrawable);
            c.l.g v = v();
            int[] iArr = this.N;
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, c.l.i.a(R, v.a(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
            ofPropertyValuesHolder.addListener(new a(this, viewGroup, bitmapDrawable, view2, c3));
            return ofPropertyValuesHolder;
        }
        Rect rect2 = (Rect) sVar.a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) sVar2.a.get("android:changeBounds:bounds");
        int i4 = rect2.left;
        int i5 = rect3.left;
        int i6 = rect2.top;
        int i7 = rect3.top;
        int i8 = rect2.right;
        int i9 = rect3.right;
        int i10 = rect2.bottom;
        int i11 = rect3.bottom;
        int i12 = i8 - i4;
        int i13 = i10 - i6;
        int i14 = i9 - i5;
        int i15 = i11 - i7;
        Rect rect4 = (Rect) sVar.a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) sVar2.a.get("android:changeBounds:clip");
        if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
            i2 = 0;
        } else {
            i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
            if (i8 != i9 || i10 != i11) {
                i2++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i2++;
        }
        if (i2 <= 0) {
            return null;
        }
        if (this.O) {
            view = view2;
            c0.f(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
            ObjectAnimator a3 = (i4 == i5 && i6 == i7) ? null : c.l.f.a(view, W, v().a(i4, i6, i5, i7));
            if (rect4 == null) {
                i3 = 0;
                rect = new Rect(0, 0, i12, i13);
            } else {
                i3 = 0;
                rect = rect4;
            }
            Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
            if (rect.equals(rect6)) {
                objectAnimator = null;
            } else {
                c.f.l.s.o0(view, rect);
                c.l.k kVar = X;
                Object[] objArr = new Object[2];
                objArr[i3] = rect;
                objArr[1] = rect6;
                ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", kVar, objArr);
                ofObject.addListener(new i(this, view, rect5, i5, i7, i9, i11));
                objectAnimator = ofObject;
            }
            c2 = r.c(a3, objectAnimator);
        } else {
            view = view2;
            c0.f(view, i4, i6, i8, i10);
            if (i2 == 2) {
                if (i12 == i14 && i13 == i15) {
                    a2 = v().a(i4, i6, i5, i7);
                    property = W;
                } else {
                    k kVar2 = new k(view);
                    ObjectAnimator a4 = c.l.f.a(kVar2, S, v().a(i4, i6, i5, i7));
                    ObjectAnimator a5 = c.l.f.a(kVar2, T, v().a(i8, i10, i9, i11));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(a4, a5);
                    animatorSet.addListener(new h(this, kVar2));
                    c2 = animatorSet;
                }
            } else if (i4 == i5 && i6 == i7) {
                a2 = v().a(i8, i10, i9, i11);
                property = U;
            } else {
                a2 = v().a(i4, i6, i5, i7);
                property = V;
            }
            c2 = c.l.f.a(view, property, a2);
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            x.c(viewGroup4, true);
            a(new j(this, viewGroup4));
        }
        return c2;
    }
}
