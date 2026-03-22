package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.i0;
import androidx.appcompat.widget.y0;
import c.f.l.s;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends d implements n.a {
    private static final int[] J = {R.attr.state_checked};
    private boolean A;
    boolean B;
    private final CheckedTextView C;
    private FrameLayout D;
    private androidx.appcompat.view.menu.i E;
    private ColorStateList F;
    private boolean G;
    private Drawable H;
    private final c.f.l.a I;
    private int z;

    /* loaded from: classes.dex */
    class a extends c.f.l.a {
        a() {
        }

        @Override // c.f.l.a
        public void g(View view, c.f.l.b0.c cVar) {
            super.g(view, cVar);
            cVar.Y(NavigationMenuItemView.this.B);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.I = new a();
        setOrientation(0);
        LayoutInflater.from(context).inflate(d.a.a.a.h.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(d.a.a.a.d.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(d.a.a.a.f.design_menu_item_text);
        this.C = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        s.i0(this.C, this.I);
    }

    private void B() {
        i0.a aVar;
        int i;
        if (D()) {
            this.C.setVisibility(8);
            FrameLayout frameLayout = this.D;
            if (frameLayout == null) {
                return;
            }
            aVar = (i0.a) frameLayout.getLayoutParams();
            i = -1;
        } else {
            this.C.setVisibility(0);
            FrameLayout frameLayout2 = this.D;
            if (frameLayout2 == null) {
                return;
            }
            aVar = (i0.a) frameLayout2.getLayoutParams();
            i = -2;
        }
        ((ViewGroup.MarginLayoutParams) aVar).width = i;
        this.D.setLayoutParams(aVar);
    }

    private StateListDrawable C() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(c.a.a.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(J, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean D() {
        return this.E.getTitle() == null && this.E.getIcon() == null && this.E.getActionView() != null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.D == null) {
                this.D = (FrameLayout) ((ViewStub) findViewById(d.a.a.a.f.design_menu_item_action_area_stub)).inflate();
            }
            this.D.removeAllViews();
            this.D.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void e(androidx.appcompat.view.menu.i iVar, int i) {
        this.E = iVar;
        if (iVar.getItemId() > 0) {
            setId(iVar.getItemId());
        }
        setVisibility(iVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            s.l0(this, C());
        }
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setTitle(iVar.getTitle());
        setIcon(iVar.getIcon());
        setActionView(iVar.getActionView());
        setContentDescription(iVar.getContentDescription());
        y0.a(this, iVar.getTooltipText());
        B();
    }

    @Override // androidx.appcompat.view.menu.n.a
    public androidx.appcompat.view.menu.i getItemData() {
        return this.E;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        androidx.appcompat.view.menu.i iVar = this.E;
        if (iVar != null && iVar.isCheckable() && this.E.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, J);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.B != z) {
            this.B = z;
            this.I.l(this.C, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.C.setChecked(z);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.G) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
                androidx.core.graphics.drawable.a.o(drawable, this.F);
            }
            int i = this.z;
            drawable.setBounds(0, 0, i, i);
        } else if (this.A) {
            if (this.H == null) {
                Drawable a2 = c.f.d.c.f.a(getResources(), d.a.a.a.e.navigation_empty_icon, getContext().getTheme());
                this.H = a2;
                if (a2 != null) {
                    int i2 = this.z;
                    a2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.H;
        }
        androidx.core.widget.i.i(this.C, drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.C.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.z = i;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.F = colorStateList;
        this.G = colorStateList != null;
        androidx.appcompat.view.menu.i iVar = this.E;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.C.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.A = z;
    }

    public void setTextAppearance(int i) {
        androidx.core.widget.i.n(this.C, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.C.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.C.setText(charSequence);
    }
}
