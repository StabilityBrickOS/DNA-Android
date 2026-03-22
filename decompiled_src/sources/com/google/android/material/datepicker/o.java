package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes.dex */
class o {

    /* renamed from: c, reason: collision with root package name */
    private static final o f1106c = new o(null, null);
    private final Long a;

    /* renamed from: b, reason: collision with root package name */
    private final TimeZone f1107b;

    private o(Long l, TimeZone timeZone) {
        this.a = l;
        this.f1107b = timeZone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o c() {
        return f1106c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Calendar a() {
        return b(this.f1107b);
    }

    Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = this.a;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        return calendar;
    }
}
