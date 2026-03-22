package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import d.a.a.a.l.h;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public interface d {
    h a();

    AnimatorSet b();

    void c();

    void d();

    List<Animator.AnimatorListener> e();

    void f(ExtendedFloatingActionButton.d dVar);

    boolean g();

    void h(h hVar);

    void i();

    void onAnimationStart(Animator animator);
}
