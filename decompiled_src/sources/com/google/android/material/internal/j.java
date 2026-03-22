package com.google.android.material.internal;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import c.f.l.a0;
import c.f.l.p;
import c.f.l.s;

/* loaded from: classes.dex */
public class j {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements p {
        final /* synthetic */ c a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f1163b;

        a(c cVar, d dVar) {
            this.a = cVar;
            this.f1163b = dVar;
        }

        @Override // c.f.l.p
        public a0 a(View view, a0 a0Var) {
            this.a.a(view, a0Var, new d(this.f1163b));
            return a0Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            s.f0(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        a0 a(View view, a0 a0Var, d dVar);
    }

    /* loaded from: classes.dex */
    public static class d {
        public int a;

        /* renamed from: b, reason: collision with root package name */
        public int f1164b;

        /* renamed from: c, reason: collision with root package name */
        public int f1165c;

        /* renamed from: d, reason: collision with root package name */
        public int f1166d;

        public d(int i, int i2, int i3, int i4) {
            this.a = i;
            this.f1164b = i2;
            this.f1165c = i3;
            this.f1166d = i4;
        }

        public d(d dVar) {
            this.a = dVar.a;
            this.f1164b = dVar.f1164b;
            this.f1165c = dVar.f1165c;
            this.f1166d = dVar.f1166d;
        }
    }

    public static void a(View view, c cVar) {
        s.u0(view, new a(cVar, new d(s.D(view), view.getPaddingTop(), s.C(view), view.getPaddingBottom())));
        f(view);
    }

    public static float b(Context context, int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static float c(View view) {
        float f = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f += s.t((View) parent);
        }
        return f;
    }

    public static boolean d(View view) {
        return s.y(view) == 1;
    }

    public static PorterDuff.Mode e(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void f(View view) {
        if (s.N(view)) {
            s.f0(view);
        } else {
            view.addOnAttachStateChangeListener(new b());
        }
    }
}
