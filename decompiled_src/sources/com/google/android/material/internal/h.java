package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private float f1159c;
    private d.a.a.a.w.d f;
    private final TextPaint a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    private final d.a.a.a.w.f f1158b = new a();

    /* renamed from: d, reason: collision with root package name */
    private boolean f1160d = true;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<b> f1161e = new WeakReference<>(null);

    /* loaded from: classes.dex */
    class a extends d.a.a.a.w.f {
        a() {
        }

        @Override // d.a.a.a.w.f
        public void a(int i) {
            h.this.f1160d = true;
            b bVar = (b) h.this.f1161e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // d.a.a.a.w.f
        public void b(Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            h.this.f1160d = true;
            b bVar = (b) h.this.f1161e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public h(b bVar) {
        g(bVar);
    }

    private float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.a.measureText(charSequence, 0, charSequence.length());
    }

    public d.a.a.a.w.d d() {
        return this.f;
    }

    public TextPaint e() {
        return this.a;
    }

    public float f(String str) {
        if (!this.f1160d) {
            return this.f1159c;
        }
        float c2 = c(str);
        this.f1159c = c2;
        this.f1160d = false;
        return c2;
    }

    public void g(b bVar) {
        this.f1161e = new WeakReference<>(bVar);
    }

    public void h(d.a.a.a.w.d dVar, Context context) {
        if (this.f != dVar) {
            this.f = dVar;
            if (dVar != null) {
                dVar.j(context, this.a, this.f1158b);
                b bVar = this.f1161e.get();
                if (bVar != null) {
                    this.a.drawableState = bVar.getState();
                }
                dVar.i(context, this.a, this.f1158b);
                this.f1160d = true;
            }
            b bVar2 = this.f1161e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void i(boolean z) {
        this.f1160d = z;
    }

    public void j(Context context) {
        this.f.i(context, this.a, this.f1158b);
    }
}
