package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.f.l.s;
import d.a.a.a.f;
import d.a.a.a.k;

/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements a {

    /* renamed from: e, reason: collision with root package name */
    private TextView f1182e;
    private Button f;
    private int g;
    private int h;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.SnackbarLayout);
        this.g = obtainStyledAttributes.getDimensionPixelSize(k.SnackbarLayout_android_maxWidth, -1);
        this.h = obtainStyledAttributes.getDimensionPixelSize(k.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    private static void d(View view, int i, int i2) {
        if (s.Q(view)) {
            s.v0(view, s.D(view), i, s.C(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    private boolean e(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.f1182e.getPaddingTop() == i2 && this.f1182e.getPaddingBottom() == i3) {
            return z;
        }
        d(this.f1182e, i2, i3);
        return true;
    }

    @Override // com.google.android.material.snackbar.a
    public void a(int i, int i2) {
        this.f1182e.setAlpha(1.0f);
        long j = i2;
        long j2 = i;
        this.f1182e.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        if (this.f.getVisibility() == 0) {
            this.f.setAlpha(1.0f);
            this.f.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    @Override // com.google.android.material.snackbar.a
    public void b(int i, int i2) {
        this.f1182e.setAlpha(0.0f);
        long j = i2;
        long j2 = i;
        this.f1182e.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        if (this.f.getVisibility() == 0) {
            this.f.setAlpha(0.0f);
            this.f.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        if (f != 1.0f) {
            this.f.setTextColor(d.a.a.a.q.a.f(d.a.a.a.q.a.c(this, d.a.a.a.b.colorSurface), this.f.getCurrentTextColor(), f));
        }
    }

    public Button getActionView() {
        return this.f;
    }

    public TextView getMessageView() {
        return this.f1182e;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f1182e = (TextView) findViewById(f.snackbar_text);
        this.f = (Button) findViewById(f.snackbar_action);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (e(1, r0, r0 - r1) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        if (e(0, r0, r0) != false) goto L24;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.g
            if (r0 <= 0) goto L18
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.g
            if (r0 <= r1) goto L18
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L18:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = d.a.a.a.d.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = d.a.a.a.d.design_snackbar_padding_vertical
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.f1182e
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L3c
            r2 = 1
            goto L3d
        L3c:
            r2 = 0
        L3d:
            if (r2 == 0) goto L56
            int r5 = r7.h
            if (r5 <= 0) goto L56
            android.widget.Button r5 = r7.f
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.h
            if (r5 <= r6) goto L56
            int r1 = r0 - r1
            boolean r0 = r7.e(r4, r0, r1)
            if (r0 == 0) goto L61
            goto L60
        L56:
            if (r2 == 0) goto L59
            goto L5a
        L59:
            r0 = r1
        L5a:
            boolean r0 = r7.e(r3, r0, r0)
            if (r0 == 0) goto L61
        L60:
            r3 = 1
        L61:
            if (r3 == 0) goto L66
            super.onMeasure(r8, r9)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int i) {
        this.h = i;
    }
}
