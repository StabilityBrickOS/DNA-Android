package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* loaded from: classes.dex */
public class p extends MultiAutoCompleteTextView implements c.f.l.r {
    private static final int[] g = {R.attr.popupBackground};

    /* renamed from: e, reason: collision with root package name */
    private final e f244e;
    private final y f;

    public p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.autoCompleteTextViewStyle);
    }

    public p(Context context, AttributeSet attributeSet, int i) {
        super(t0.b(context), attributeSet, i);
        r0.a(this, getContext());
        w0 v = w0.v(getContext(), attributeSet, g, i, 0);
        if (v.s(0)) {
            setDropDownBackgroundDrawable(v.g(0));
        }
        v.w();
        e eVar = new e(this);
        this.f244e = eVar;
        eVar.e(attributeSet, i);
        y yVar = new y(this);
        this.f = yVar;
        yVar.m(attributeSet, i);
        this.f.b();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f244e;
        if (eVar != null) {
            eVar.b();
        }
        y yVar = this.f;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // c.f.l.r
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f244e;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // c.f.l.r
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f244e;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        l.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f244e;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f244e;
        if (eVar != null) {
            eVar.g(i);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(c.a.k.a.a.d(getContext(), i));
    }

    @Override // c.f.l.r
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f244e;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // c.f.l.r
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f244e;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        y yVar = this.f;
        if (yVar != null) {
            yVar.q(context, i);
        }
    }
}
