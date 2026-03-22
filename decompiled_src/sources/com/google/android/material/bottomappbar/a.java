package com.google.android.material.bottomappbar;

import d.a.a.a.z.f;
import d.a.a.a.z.m;

/* loaded from: classes.dex */
public class a extends f implements Cloneable {

    /* renamed from: e, reason: collision with root package name */
    private float f1067e;
    private float f;
    private float g;
    private float h;
    private float i;

    @Override // d.a.a.a.z.f
    public void b(float f, float f2, float f3, m mVar) {
        float f4 = this.g;
        if (f4 == 0.0f) {
            mVar.m(f, 0.0f);
            return;
        }
        float f5 = ((this.f * 2.0f) + f4) / 2.0f;
        float f6 = f3 * this.f1067e;
        float f7 = f2 + this.i;
        float f8 = (this.h * f3) + ((1.0f - f3) * f5);
        if (f8 / f5 >= 1.0f) {
            mVar.m(f, 0.0f);
            return;
        }
        float f9 = f5 + f6;
        float f10 = f8 + f6;
        float sqrt = (float) Math.sqrt((f9 * f9) - (f10 * f10));
        float f11 = f7 - sqrt;
        float f12 = f7 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f10));
        float f13 = 90.0f - degrees;
        mVar.m(f11, 0.0f);
        float f14 = f6 * 2.0f;
        mVar.a(f11 - f6, 0.0f, f11 + f6, f14, 270.0f, degrees);
        mVar.a(f7 - f5, (-f5) - f8, f7 + f5, f5 - f8, 180.0f - f13, (f13 * 2.0f) - 180.0f);
        mVar.a(f12 - f6, 0.0f, f12 + f6, f14, 270.0f - degrees, degrees);
        mVar.m(f, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.f1067e;
    }

    public float f() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.h = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(float f) {
        this.f = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(float f) {
        this.f1067e = f;
    }

    public void j(float f) {
        this.g = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(float f) {
        this.i = f;
    }
}
