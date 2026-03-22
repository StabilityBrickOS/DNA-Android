package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import c.f.d.c.f;

/* loaded from: classes.dex */
public class w0 {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final TypedArray f281b;

    /* renamed from: c, reason: collision with root package name */
    private TypedValue f282c;

    private w0(Context context, TypedArray typedArray) {
        this.a = context;
        this.f281b = typedArray;
    }

    public static w0 t(Context context, int i, int[] iArr) {
        return new w0(context, context.obtainStyledAttributes(i, iArr));
    }

    public static w0 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new w0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static w0 v(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new w0(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public boolean a(int i, boolean z) {
        return this.f281b.getBoolean(i, z);
    }

    public int b(int i, int i2) {
        return this.f281b.getColor(i, i2);
    }

    public ColorStateList c(int i) {
        int resourceId;
        ColorStateList c2;
        return (!this.f281b.hasValue(i) || (resourceId = this.f281b.getResourceId(i, 0)) == 0 || (c2 = c.a.k.a.a.c(this.a, resourceId)) == null) ? this.f281b.getColorStateList(i) : c2;
    }

    public float d(int i, float f) {
        return this.f281b.getDimension(i, f);
    }

    public int e(int i, int i2) {
        return this.f281b.getDimensionPixelOffset(i, i2);
    }

    public int f(int i, int i2) {
        return this.f281b.getDimensionPixelSize(i, i2);
    }

    public Drawable g(int i) {
        int resourceId;
        return (!this.f281b.hasValue(i) || (resourceId = this.f281b.getResourceId(i, 0)) == 0) ? this.f281b.getDrawable(i) : c.a.k.a.a.d(this.a, resourceId);
    }

    public Drawable h(int i) {
        int resourceId;
        if (!this.f281b.hasValue(i) || (resourceId = this.f281b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return j.b().d(this.a, resourceId, true);
    }

    public float i(int i, float f) {
        return this.f281b.getFloat(i, f);
    }

    public Typeface j(int i, int i2, f.a aVar) {
        int resourceId = this.f281b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f282c == null) {
            this.f282c = new TypedValue();
        }
        return c.f.d.c.f.c(this.a, resourceId, this.f282c, i2, aVar);
    }

    public int k(int i, int i2) {
        return this.f281b.getInt(i, i2);
    }

    public int l(int i, int i2) {
        return this.f281b.getInteger(i, i2);
    }

    public int m(int i, int i2) {
        return this.f281b.getLayoutDimension(i, i2);
    }

    public int n(int i, int i2) {
        return this.f281b.getResourceId(i, i2);
    }

    public String o(int i) {
        return this.f281b.getString(i);
    }

    public CharSequence p(int i) {
        return this.f281b.getText(i);
    }

    public CharSequence[] q(int i) {
        return this.f281b.getTextArray(i);
    }

    public TypedArray r() {
        return this.f281b;
    }

    public boolean s(int i) {
        return this.f281b.hasValue(i);
    }

    public void w() {
        this.f281b.recycle();
    }
}
