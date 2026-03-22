package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* loaded from: classes.dex */
public class b0 extends ToggleButton {

    /* renamed from: e, reason: collision with root package name */
    private final y f195e;

    public b0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    public b0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        r0.a(this, getContext());
        y yVar = new y(this);
        this.f195e = yVar;
        yVar.m(attributeSet, i);
    }
}
