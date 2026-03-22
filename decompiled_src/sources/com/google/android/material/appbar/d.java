package com.google.android.material.appbar;

import android.view.View;
import c.f.l.s;

/* loaded from: classes.dex */
class d {
    private final View a;

    /* renamed from: b, reason: collision with root package name */
    private int f1047b;

    /* renamed from: c, reason: collision with root package name */
    private int f1048c;

    /* renamed from: d, reason: collision with root package name */
    private int f1049d;

    /* renamed from: e, reason: collision with root package name */
    private int f1050e;
    private boolean f = true;
    private boolean g = true;

    public d(View view) {
        this.a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view = this.a;
        s.U(view, this.f1049d - (view.getTop() - this.f1047b));
        View view2 = this.a;
        s.T(view2, this.f1050e - (view2.getLeft() - this.f1048c));
    }

    public int b() {
        return this.f1049d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f1047b = this.a.getTop();
        this.f1048c = this.a.getLeft();
    }

    public boolean d(int i) {
        if (!this.g || this.f1050e == i) {
            return false;
        }
        this.f1050e = i;
        a();
        return true;
    }

    public boolean e(int i) {
        if (!this.f || this.f1049d == i) {
            return false;
        }
        this.f1049d = i;
        a();
        return true;
    }
}
