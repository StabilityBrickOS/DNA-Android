package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.f.l.s;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d.a.a.a.f;
import d.a.a.a.l.h;
import d.a.a.a.l.i;
import d.a.a.a.l.j;
import d.a.a.a.p.d;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c, reason: collision with root package name */
    private final Rect f1225c;

    /* renamed from: d, reason: collision with root package name */
    private final RectF f1226d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f1227e;
    private final int[] f;
    private float g;
    private float h;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1228b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f1229c;

        a(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
            this.a = z;
            this.f1228b = view;
            this.f1229c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            this.f1228b.setVisibility(4);
            this.f1229c.setAlpha(1.0f);
            this.f1229c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.a) {
                this.f1228b.setVisibility(0);
                this.f1229c.setAlpha(0.0f);
                this.f1229c.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View a;

        b(FabTransformationBehavior fabTransformationBehavior, View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        final /* synthetic */ d.a.a.a.p.d a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Drawable f1230b;

        c(FabTransformationBehavior fabTransformationBehavior, d.a.a.a.p.d dVar, Drawable drawable) {
            this.a = dVar;
            this.f1230b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.setCircularRevealOverlayDrawable(this.f1230b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {
        final /* synthetic */ d.a.a.a.p.d a;

        d(FabTransformationBehavior fabTransformationBehavior, d.a.a.a.p.d dVar) {
            this.a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.e revealInfo = this.a.getRevealInfo();
            revealInfo.f1293c = Float.MAX_VALUE;
            this.a.setRevealInfo(revealInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class e {
        public h a;

        /* renamed from: b, reason: collision with root package name */
        public j f1231b;
    }

    public FabTransformationBehavior() {
        this.f1225c = new Rect();
        this.f1226d = new RectF();
        this.f1227e = new RectF();
        this.f = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1225c = new Rect();
        this.f1226d = new RectF();
        this.f1227e = new RectF();
        this.f = new int[2];
    }

    private ViewGroup K(View view) {
        View findViewById = view.findViewById(f.mtrl_child_content_container);
        return findViewById != null ? f0(findViewById) : ((view instanceof com.google.android.material.transformation.b) || (view instanceof com.google.android.material.transformation.a)) ? f0(((ViewGroup) view).getChildAt(0)) : f0(view);
    }

    private void L(View view, e eVar, i iVar, i iVar2, float f, float f2, float f3, float f4, RectF rectF) {
        float S = S(eVar, iVar, f, f3);
        float S2 = S(eVar, iVar2, f2, f4);
        Rect rect = this.f1225c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f1226d;
        rectF2.set(rect);
        RectF rectF3 = this.f1227e;
        T(view, rectF3);
        rectF3.offset(S, S2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void M(View view, RectF rectF) {
        T(view, rectF);
        rectF.offset(this.g, this.h);
    }

    private Pair<i, i> N(float f, float f2, boolean z, e eVar) {
        i e2;
        h hVar;
        String str;
        if (f == 0.0f || f2 == 0.0f) {
            e2 = eVar.a.e("translationXLinear");
            hVar = eVar.a;
            str = "translationYLinear";
        } else if ((!z || f2 >= 0.0f) && (z || f2 <= 0.0f)) {
            e2 = eVar.a.e("translationXCurveDownwards");
            hVar = eVar.a;
            str = "translationYCurveDownwards";
        } else {
            e2 = eVar.a.e("translationXCurveUpwards");
            hVar = eVar.a;
            str = "translationYCurveUpwards";
        }
        return new Pair<>(e2, hVar.e(str));
    }

    private float O(View view, View view2, j jVar) {
        RectF rectF = this.f1226d;
        RectF rectF2 = this.f1227e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(-Q(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float P(View view, View view2, j jVar) {
        RectF rectF = this.f1226d;
        RectF rectF2 = this.f1227e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(0.0f, -R(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private float Q(View view, View view2, j jVar) {
        float centerX;
        float centerX2;
        float f;
        RectF rectF = this.f1226d;
        RectF rectF2 = this.f1227e;
        M(view, rectF);
        T(view2, rectF2);
        int i = jVar.a & 7;
        if (i == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i == 3) {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        } else {
            if (i != 5) {
                f = 0.0f;
                return f + jVar.f1288b;
            }
            centerX = rectF2.right;
            centerX2 = rectF.right;
        }
        f = centerX - centerX2;
        return f + jVar.f1288b;
    }

    private float R(View view, View view2, j jVar) {
        float centerY;
        float centerY2;
        float f;
        RectF rectF = this.f1226d;
        RectF rectF2 = this.f1227e;
        M(view, rectF);
        T(view2, rectF2);
        int i = jVar.a & 112;
        if (i == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i == 48) {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        } else {
            if (i != 80) {
                f = 0.0f;
                return f + jVar.f1289c;
            }
            centerY = rectF2.bottom;
            centerY2 = rectF.bottom;
        }
        f = centerY - centerY2;
        return f + jVar.f1289c;
    }

    private float S(e eVar, i iVar, float f, float f2) {
        long c2 = iVar.c();
        long d2 = iVar.d();
        i e2 = eVar.a.e("expansion");
        return d.a.a.a.l.a.a(f, f2, iVar.e().getInterpolation(((float) (((e2.c() + e2.d()) + 17) - c2)) / ((float) d2)));
    }

    private void T(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void U(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup K;
        ObjectAnimator ofFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof d.a.a.a.p.d) && d.a.a.a.p.c.a == 0) || (K = K(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    d.a.a.a.l.d.a.set(K, Float.valueOf(0.0f));
                }
                ofFloat = ObjectAnimator.ofFloat(K, d.a.a.a.l.d.a, 1.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(K, d.a.a.a.l.d.a, 0.0f);
            }
            eVar.a.e("contentFade").a(ofFloat);
            list.add(ofFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void V(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (view2 instanceof d.a.a.a.p.d) {
            d.a.a.a.p.d dVar = (d.a.a.a.p.d) view2;
            int d0 = d0(view);
            int i = 16777215 & d0;
            if (z) {
                if (!z2) {
                    dVar.setCircularRevealScrimColor(d0);
                }
                ofInt = ObjectAnimator.ofInt(dVar, d.C0088d.a, i);
            } else {
                ofInt = ObjectAnimator.ofInt(dVar, d.C0088d.a, d0);
            }
            ofInt.setEvaluator(d.a.a.a.l.c.b());
            eVar.a.e("color").a(ofInt);
            list.add(ofInt);
        }
    }

    private void W(View view, View view2, boolean z, e eVar, List<Animator> list) {
        float Q = Q(view, view2, eVar.f1231b);
        float R = R(view, view2, eVar.f1231b);
        Pair<i, i> N = N(Q, R, z, eVar);
        i iVar = (i) N.first;
        i iVar2 = (i) N.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            Q = this.g;
        }
        fArr[0] = Q;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            R = this.h;
        }
        fArr2[0] = R;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    @TargetApi(21)
    private void X(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float t = s.t(view2) - s.t(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-t);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -t);
        }
        eVar.a.e("elevation").a(ofFloat);
        list.add(ofFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Y(View view, View view2, boolean z, boolean z2, e eVar, float f, float f2, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (view2 instanceof d.a.a.a.p.d) {
            d.a.a.a.p.d dVar = (d.a.a.a.p.d) view2;
            float O = O(view, view2, eVar.f1231b);
            float P = P(view, view2, eVar.f1231b);
            ((FloatingActionButton) view).i(this.f1225c);
            float width = this.f1225c.width() / 2.0f;
            i e2 = eVar.a.e("expansion");
            if (z) {
                if (!z2) {
                    dVar.setRevealInfo(new d.e(O, P, width));
                }
                if (z2) {
                    width = dVar.getRevealInfo().f1293c;
                }
                animator = d.a.a.a.p.a.a(dVar, O, P, d.a.a.a.u.a.b(O, P, 0.0f, 0.0f, f, f2));
                animator.addListener(new d(this, dVar));
                b0(view2, e2.c(), (int) O, (int) P, width, list);
            } else {
                float f3 = dVar.getRevealInfo().f1293c;
                Animator a2 = d.a.a.a.p.a.a(dVar, O, P, width);
                int i = (int) O;
                int i2 = (int) P;
                b0(view2, e2.c(), i, i2, f3, list);
                a0(view2, e2.c(), e2.d(), eVar.a.f(), i, i2, width, list);
                animator = a2;
            }
            e2.a(animator);
            list.add(animator);
            list2.add(d.a.a.a.p.a.b(dVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Z(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof d.a.a.a.p.d) && (view instanceof ImageView)) {
            d.a.a.a.p.d dVar = (d.a.a.a.p.d) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, d.a.a.a.l.e.f1280b, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, d.a.a.a.l.e.f1280b, 255);
            }
            ofInt.addUpdateListener(new b(this, view2));
            eVar.a.e("iconFade").a(ofInt);
            list.add(ofInt);
            list2.add(new c(this, dVar, drawable));
        }
    }

    private void a0(View view, long j, long j2, long j3, int i, int i2, float f, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j4 = j + j2;
            if (j4 < j3) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
                createCircularReveal.setStartDelay(j4);
                createCircularReveal.setDuration(j3 - j4);
                list.add(createCircularReveal);
            }
        }
    }

    private void b0(View view, long j, int i, int i2, float f, List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j <= 0) {
            return;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
        createCircularReveal.setStartDelay(0L);
        createCircularReveal.setDuration(j);
        list.add(createCircularReveal);
    }

    private void c0(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float Q = Q(view, view2, eVar.f1231b);
        float R = R(view, view2, eVar.f1231b);
        Pair<i, i> N = N(Q, R, z, eVar);
        i iVar = (i) N.first;
        i iVar2 = (i) N.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-Q);
                view2.setTranslationY(-R);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            L(view2, eVar, iVar, iVar2, -Q, -R, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -Q);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -R);
        }
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private int d0(View view) {
        ColorStateList p = s.p(view);
        if (p != null) {
            return p.getColorForState(view.getDrawableState(), p.getDefaultColor());
        }
        return 0;
    }

    private ViewGroup f0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet J(View view, View view2, boolean z, boolean z2) {
        e e0 = e0(view2.getContext(), z);
        if (z) {
            this.g = view.getTranslationX();
            this.h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            X(view, view2, z, z2, e0, arrayList, arrayList2);
        }
        RectF rectF = this.f1226d;
        c0(view, view2, z, z2, e0, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        W(view, view2, z, e0, arrayList);
        Z(view, view2, z, z2, e0, arrayList, arrayList2);
        Y(view, view2, z, z2, e0, width, height, arrayList, arrayList2);
        V(view, view2, z, z2, e0, arrayList, arrayList2);
        U(view, view2, z, z2, e0, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        d.a.a.a.l.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(this, z, view2, view));
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener(arrayList2.get(i));
        }
        return animatorSet;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    protected abstract e e0(Context context, boolean z);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        if (fVar.h == 0) {
            fVar.h = 80;
        }
    }
}
