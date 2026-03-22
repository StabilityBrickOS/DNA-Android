package c.l;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class d extends j0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends n {
        final /* synthetic */ View a;

        a(d dVar, View view) {
            this.a = view;
        }

        @Override // c.l.m.f
        public void e(m mVar) {
            c0.g(this.a, 1.0f);
            c0.a(this.a);
            mVar.P(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter {
        private final View a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f860b = false;

        b(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c0.g(this.a, 1.0f);
            if (this.f860b) {
                this.a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (c.f.l.s.K(this.a) && this.a.getLayerType() == 0) {
                this.f860b = true;
                this.a.setLayerType(2, null);
            }
        }
    }

    public d(int i) {
        i0(i);
    }

    private Animator j0(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        c0.g(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, c0.f859b, f2);
        ofFloat.addListener(new b(view));
        a(new a(this, view));
        return ofFloat;
    }

    private static float k0(s sVar, float f) {
        Float f2;
        return (sVar == null || (f2 = (Float) sVar.a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    @Override // c.l.j0
    public Animator e0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float k0 = k0(sVar, 0.0f);
        return j0(view, k0 != 1.0f ? k0 : 0.0f, 1.0f);
    }

    @Override // c.l.j0
    public Animator g0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        c0.e(view);
        return j0(view, k0(sVar, 1.0f), 0.0f);
    }

    @Override // c.l.j0, c.l.m
    public void j(s sVar) {
        super.j(sVar);
        sVar.a.put("android:fade:transitionAlpha", Float.valueOf(c0.c(sVar.f898b)));
    }
}
