package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
class f extends BaseAdapter {
    private static final int h;

    /* renamed from: e, reason: collision with root package name */
    private final Calendar f1090e;
    private final int f;
    private final int g;

    static {
        h = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public f() {
        Calendar l = p.l();
        this.f1090e = l;
        this.f = l.getMaximum(7);
        this.g = this.f1090e.getFirstDayOfWeek();
    }

    private int b(int i) {
        int i2 = i + this.g;
        int i3 = this.f;
        return i2 > i3 ? i2 - i3 : i2;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i) {
        if (i >= this.f) {
            return null;
        }
        return Integer.valueOf(b(i));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(d.a.a.a.h.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f1090e.set(7, b(i));
        textView.setText(this.f1090e.getDisplayName(7, h, Locale.getDefault()));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(d.a.a.a.i.mtrl_picker_day_of_week_column_header), this.f1090e.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
