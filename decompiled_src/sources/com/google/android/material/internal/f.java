package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f {
    private final ArrayList<b> a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private b f1150b = null;

    /* renamed from: c, reason: collision with root package name */
    ValueAnimator f1151c = null;

    /* renamed from: d, reason: collision with root package name */
    private final Animator.AnimatorListener f1152d = new a();

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f fVar = f.this;
            if (fVar.f1151c == animator) {
                fVar.f1151c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        final int[] a;

        /* renamed from: b, reason: collision with root package name */
        final ValueAnimator f1153b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.a = iArr;
            this.f1153b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.f1151c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f1151c = null;
        }
    }

    private void e(b bVar) {
        ValueAnimator valueAnimator = bVar.f1153b;
        this.f1151c = valueAnimator;
        valueAnimator.start();
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f1152d);
        this.a.add(bVar);
    }

    public void c() {
        ValueAnimator valueAnimator = this.f1151c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f1151c = null;
        }
    }

    public void d(int[] iArr) {
        b bVar;
        int size = this.a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                bVar = null;
                break;
            }
            bVar = this.a.get(i);
            if (StateSet.stateSetMatches(bVar.a, iArr)) {
                break;
            } else {
                i++;
            }
        }
        b bVar2 = this.f1150b;
        if (bVar == bVar2) {
            return;
        }
        if (bVar2 != null) {
            b();
        }
        this.f1150b = bVar;
        if (bVar != null) {
            e(bVar);
        }
    }
}
