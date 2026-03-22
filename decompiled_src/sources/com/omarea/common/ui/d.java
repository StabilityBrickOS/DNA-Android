package com.omarea.common.ui;

import android.R;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* loaded from: classes.dex */
public class d extends androidx.fragment.app.c {
    private int m0;
    private View n0;
    private final int o0;
    private final boolean p0;

    public d(int i, boolean z) {
        this.o0 = i;
        this.p0 = z;
        this.m0 = z ? d.c.a.c.dialog_full_screen_dark : d.c.a.c.dialog_full_screen_light;
    }

    @Override // androidx.fragment.app.Fragment
    public void E0(View view, Bundle bundle) {
        Dialog u1;
        Window window;
        e.p.d.i.d(view, "view");
        super.E0(view, bundle);
        androidx.fragment.app.d n = n();
        if (n == null || (u1 = u1()) == null || (window = u1.getWindow()) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            window.setWindowAnimations(R.style.Animation.Translucent);
        }
        e.f1255b.s(window, n);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void Z(Bundle bundle) {
        super.Z(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View j0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        e.p.d.i.d(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(this.o0, viewGroup);
        e.p.d.i.c(inflate, "inflater.inflate(layout, container)");
        this.n0 = inflate;
        if (inflate != null) {
            return inflate;
        }
        e.p.d.i.l("currentView");
        throw null;
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public /* synthetic */ void m0() {
        super.m0();
        z1();
    }

    @Override // androidx.fragment.app.c
    public Dialog v1(Bundle bundle) {
        if (Build.VERSION.SDK_INT < 23) {
            androidx.fragment.app.d n = n();
            e.p.d.i.b(n);
            return new Dialog(n, -1);
        }
        androidx.fragment.app.d n2 = n();
        e.p.d.i.b(n2);
        int i = this.m0;
        if (i == 0) {
            i = d.c.a.c.dialog_full_screen_light;
        }
        return new Dialog(n2, i);
    }

    public abstract void z1();
}
