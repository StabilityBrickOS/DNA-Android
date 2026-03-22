package c.f.l;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class w {
    private WeakReference<View> a;

    /* renamed from: b, reason: collision with root package name */
    Runnable f822b = null;

    /* renamed from: c, reason: collision with root package name */
    Runnable f823c = null;

    /* renamed from: d, reason: collision with root package name */
    int f824d = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        final /* synthetic */ x a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f825b;

        a(w wVar, x xVar, View view) {
            this.a = xVar;
            this.f825b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a.c(this.f825b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.a(this.f825b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.b(this.f825b);
        }
    }

    /* loaded from: classes.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ z a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f826b;

        b(w wVar, z zVar, View view) {
            this.a = zVar;
            this.f826b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.a(this.f826b);
        }
    }

    /* loaded from: classes.dex */
    static class c implements x {
        w a;

        /* renamed from: b, reason: collision with root package name */
        boolean f827b;

        c(w wVar) {
            this.a = wVar;
        }

        @Override // c.f.l.x
        @SuppressLint({"WrongConstant"})
        public void a(View view) {
            int i = this.a.f824d;
            if (i > -1) {
                view.setLayerType(i, null);
                this.a.f824d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f827b) {
                w wVar = this.a;
                Runnable runnable = wVar.f823c;
                if (runnable != null) {
                    wVar.f823c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                x xVar = tag instanceof x ? (x) tag : null;
                if (xVar != null) {
                    xVar.a(view);
                }
                this.f827b = true;
            }
        }

        @Override // c.f.l.x
        public void b(View view) {
            this.f827b = false;
            if (this.a.f824d > -1) {
                view.setLayerType(2, null);
            }
            w wVar = this.a;
            Runnable runnable = wVar.f822b;
            if (runnable != null) {
                wVar.f822b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            x xVar = tag instanceof x ? (x) tag : null;
            if (xVar != null) {
                xVar.b(view);
            }
        }

        @Override // c.f.l.x
        public void c(View view) {
            Object tag = view.getTag(2113929216);
            x xVar = tag instanceof x ? (x) tag : null;
            if (xVar != null) {
                xVar.c(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(View view) {
        this.a = new WeakReference<>(view);
    }

    private void g(View view, x xVar) {
        if (xVar != null) {
            view.animate().setListener(new a(this, xVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public w a(float f) {
        View view = this.a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public void b() {
        View view = this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long c() {
        View view = this.a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public w d(long j) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public w e(Interpolator interpolator) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public w f(x xVar) {
        View view = this.a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT < 16) {
                view.setTag(2113929216, xVar);
                xVar = new c(this);
            }
            g(view, xVar);
        }
        return this;
    }

    public w h(long j) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public w i(z zVar) {
        View view = this.a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(zVar != null ? new b(this, zVar, view) : null);
        }
        return this;
    }

    public void j() {
        View view = this.a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public w k(float f) {
        View view = this.a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }
}
