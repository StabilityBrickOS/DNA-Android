package d.a.a.a.o;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.g;
import androidx.core.widget.c;
import com.google.android.material.internal.i;
import d.a.a.a.b;
import d.a.a.a.j;
import d.a.a.a.k;

/* loaded from: classes.dex */
public class a extends g {
    private static final int j = j.Widget_MaterialComponents_CompoundButton_CheckBox;
    private static final int[][] k = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    private ColorStateList h;
    private boolean i;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.checkboxStyle);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i, j), attributeSet, i);
        Context context2 = getContext();
        TypedArray h = i.h(context2, attributeSet, k.MaterialCheckBox, i, j, new int[0]);
        if (h.hasValue(k.MaterialCheckBox_buttonTint)) {
            c.c(this, d.a.a.a.w.c.a(context2, h, k.MaterialCheckBox_buttonTint));
        }
        this.i = h.getBoolean(k.MaterialCheckBox_useMaterialThemeColors, false);
        h.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.h == null) {
            int[] iArr = new int[k.length];
            int c2 = d.a.a.a.q.a.c(this, b.colorControlActivated);
            int c3 = d.a.a.a.q.a.c(this, b.colorSurface);
            int c4 = d.a.a.a.q.a.c(this, b.colorOnSurface);
            iArr[0] = d.a.a.a.q.a.f(c3, c2, 1.0f);
            iArr[1] = d.a.a.a.q.a.f(c3, c4, 0.54f);
            iArr[2] = d.a.a.a.q.a.f(c3, c4, 0.38f);
            iArr[3] = d.a.a.a.q.a.f(c3, c4, 0.38f);
            this.h = new ColorStateList(k, iArr);
        }
        return this.h;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.i && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.i = z;
        c.c(this, z ? getMaterialThemeColorsTintList() : null);
    }
}
