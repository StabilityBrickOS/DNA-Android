package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends Drawable.ConstantState {
    int a;

    /* renamed from: b, reason: collision with root package name */
    Drawable.ConstantState f341b;

    /* renamed from: c, reason: collision with root package name */
    ColorStateList f342c;

    /* renamed from: d, reason: collision with root package name */
    PorterDuff.Mode f343d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(f fVar) {
        this.f342c = null;
        this.f343d = d.k;
        if (fVar != null) {
            this.a = fVar.a;
            this.f341b = fVar.f341b;
            this.f342c = fVar.f342c;
            this.f343d = fVar.f343d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f341b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i = this.a;
        Drawable.ConstantState constantState = this.f341b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new e(this, resources) : new d(this, resources);
    }
}
