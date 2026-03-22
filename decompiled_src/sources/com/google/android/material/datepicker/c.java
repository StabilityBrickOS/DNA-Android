package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c {
    final b a;

    /* renamed from: b, reason: collision with root package name */
    final b f1086b;

    /* renamed from: c, reason: collision with root package name */
    final b f1087c;

    /* renamed from: d, reason: collision with root package name */
    final b f1088d;

    /* renamed from: e, reason: collision with root package name */
    final b f1089e;
    final b f;
    final b g;
    final Paint h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(d.a.a.a.w.b.c(context, d.a.a.a.b.materialCalendarStyle, g.class.getCanonicalName()), d.a.a.a.k.MaterialCalendar);
        this.a = b.a(context, obtainStyledAttributes.getResourceId(d.a.a.a.k.MaterialCalendar_dayStyle, 0));
        this.g = b.a(context, obtainStyledAttributes.getResourceId(d.a.a.a.k.MaterialCalendar_dayInvalidStyle, 0));
        this.f1086b = b.a(context, obtainStyledAttributes.getResourceId(d.a.a.a.k.MaterialCalendar_daySelectedStyle, 0));
        this.f1087c = b.a(context, obtainStyledAttributes.getResourceId(d.a.a.a.k.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList a = d.a.a.a.w.c.a(context, obtainStyledAttributes, d.a.a.a.k.MaterialCalendar_rangeFillColor);
        this.f1088d = b.a(context, obtainStyledAttributes.getResourceId(d.a.a.a.k.MaterialCalendar_yearStyle, 0));
        this.f1089e = b.a(context, obtainStyledAttributes.getResourceId(d.a.a.a.k.MaterialCalendar_yearSelectedStyle, 0));
        this.f = b.a(context, obtainStyledAttributes.getResourceId(d.a.a.a.k.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(a.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
