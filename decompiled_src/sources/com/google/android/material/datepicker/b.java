package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import c.f.l.s;

/* loaded from: classes.dex */
final class b {
    private final Rect a;

    /* renamed from: b, reason: collision with root package name */
    private final ColorStateList f1082b;

    /* renamed from: c, reason: collision with root package name */
    private final ColorStateList f1083c;

    /* renamed from: d, reason: collision with root package name */
    private final ColorStateList f1084d;

    /* renamed from: e, reason: collision with root package name */
    private final int f1085e;
    private final d.a.a.a.z.k f;

    private b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, d.a.a.a.z.k kVar, Rect rect) {
        c.f.k.h.b(rect.left);
        c.f.k.h.b(rect.top);
        c.f.k.h.b(rect.right);
        c.f.k.h.b(rect.bottom);
        this.a = rect;
        this.f1082b = colorStateList2;
        this.f1083c = colorStateList;
        this.f1084d = colorStateList3;
        this.f1085e = i;
        this.f = kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(Context context, int i) {
        c.f.k.h.a(i != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, d.a.a.a.k.MaterialCalendarItem);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(d.a.a.a.k.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(d.a.a.a.k.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(d.a.a.a.k.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(d.a.a.a.k.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList a = d.a.a.a.w.c.a(context, obtainStyledAttributes, d.a.a.a.k.MaterialCalendarItem_itemFillColor);
        ColorStateList a2 = d.a.a.a.w.c.a(context, obtainStyledAttributes, d.a.a.a.k.MaterialCalendarItem_itemTextColor);
        ColorStateList a3 = d.a.a.a.w.c.a(context, obtainStyledAttributes, d.a.a.a.k.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(d.a.a.a.k.MaterialCalendarItem_itemStrokeWidth, 0);
        d.a.a.a.z.k m = d.a.a.a.z.k.b(context, obtainStyledAttributes.getResourceId(d.a.a.a.k.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(d.a.a.a.k.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m();
        obtainStyledAttributes.recycle();
        return new b(a, a2, a3, dimensionPixelSize, m, rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.a.bottom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.a.top;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TextView textView) {
        d.a.a.a.z.g gVar = new d.a.a.a.z.g();
        d.a.a.a.z.g gVar2 = new d.a.a.a.z.g();
        gVar.setShapeAppearanceModel(this.f);
        gVar2.setShapeAppearanceModel(this.f);
        gVar.V(this.f1083c);
        gVar.c0(this.f1085e, this.f1084d);
        textView.setTextColor(this.f1082b);
        Drawable rippleDrawable = Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.f1082b.withAlpha(30), gVar, gVar2) : gVar;
        Rect rect = this.a;
        s.l0(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
