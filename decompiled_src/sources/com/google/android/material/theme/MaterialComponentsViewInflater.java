package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.h;
import androidx.appcompat.widget.d;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.s;
import androidx.appcompat.widget.z;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.g;
import com.google.android.material.textview.MaterialTextView;
import d.a.a.a.o.a;

/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends h {
    @Override // androidx.appcompat.app.h
    protected d b(Context context, AttributeSet attributeSet) {
        return new g(context, attributeSet);
    }

    @Override // androidx.appcompat.app.h
    protected f c(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // androidx.appcompat.app.h
    protected androidx.appcompat.widget.g d(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    @Override // androidx.appcompat.app.h
    protected s j(Context context, AttributeSet attributeSet) {
        return new d.a.a.a.v.a(context, attributeSet);
    }

    @Override // androidx.appcompat.app.h
    protected z n(Context context, AttributeSet attributeSet) {
        return new MaterialTextView(context, attributeSet);
    }
}
