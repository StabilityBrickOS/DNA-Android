package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;

/* loaded from: classes.dex */
public class k extends EditText implements c.f.l.r {

    /* renamed from: e, reason: collision with root package name */
    private final e f230e;
    private final y f;
    private final x g;

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.editTextStyle);
    }

    public k(Context context, AttributeSet attributeSet, int i) {
        super(t0.b(context), attributeSet, i);
        r0.a(this, getContext());
        e eVar = new e(this);
        this.f230e = eVar;
        eVar.e(attributeSet, i);
        y yVar = new y(this);
        this.f = yVar;
        yVar.m(attributeSet, i);
        this.f.b();
        this.g = new x(this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f230e;
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
        e eVar = this.f230e;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // c.f.l.r
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f230e;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        x xVar;
        return (Build.VERSION.SDK_INT >= 28 || (xVar = this.g) == null) ? super.getTextClassifier() : xVar.a();
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
        e eVar = this.f230e;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f230e;
        if (eVar != null) {
            eVar.g(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    @Override // c.f.l.r
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f230e;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // c.f.l.r
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f230e;
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

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        x xVar;
        if (Build.VERSION.SDK_INT >= 28 || (xVar = this.g) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            xVar.b(textClassifier);
        }
    }
}
