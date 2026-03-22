package com.omarea.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/* loaded from: classes.dex */
public class OverScrollGridView extends GridView {

    /* renamed from: e, reason: collision with root package name */
    private int f1235e;

    public OverScrollGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1235e = 400;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, this.f1235e, z);
    }

    public void setMaxOverScrollY(int i) {
        this.f1235e = i;
    }
}
