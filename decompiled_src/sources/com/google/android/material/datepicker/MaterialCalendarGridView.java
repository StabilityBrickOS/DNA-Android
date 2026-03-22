package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import c.f.l.s;
import java.util.Calendar;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MaterialCalendarGridView extends GridView {

    /* renamed from: e, reason: collision with root package name */
    private final Calendar f1080e;

    /* loaded from: classes.dex */
    class a extends c.f.l.a {
        a(MaterialCalendarGridView materialCalendarGridView) {
        }

        @Override // c.f.l.a
        public void g(View view, c.f.l.b0.c cVar) {
            super.g(view, cVar);
            cVar.c0(null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1080e = p.l();
        if (h.z1(getContext())) {
            setNextFocusLeftId(d.a.a.a.f.cancel_button);
            setNextFocusRightId(d.a.a.a.f.confirm_button);
        }
        s.i0(this, new a(this));
    }

    private void a(int i, Rect rect) {
        int b2;
        if (i == 33) {
            b2 = getAdapter().h();
        } else {
            if (i != 130) {
                super.onFocusChanged(true, i, rect);
                return;
            }
            b2 = getAdapter().b();
        }
        setSelection(b2);
    }

    private static int c(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean d(Long l, Long l2, Long l3, Long l4) {
        return l == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l.longValue();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public j getAdapter2() {
        return (j) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        int a2;
        int c2;
        int a3;
        int c3;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        j adapter = getAdapter();
        d<?> dVar = adapter.f;
        c cVar = adapter.g;
        Long item = adapter.getItem(adapter.b());
        Long item2 = adapter.getItem(adapter.h());
        for (c.f.k.d<Long, Long> dVar2 : dVar.b()) {
            Long l = dVar2.a;
            if (l != null) {
                if (dVar2.f779b == null) {
                    continue;
                } else {
                    long longValue = l.longValue();
                    long longValue2 = dVar2.f779b.longValue();
                    if (d(item, item2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                        return;
                    }
                    if (longValue < item.longValue()) {
                        a2 = adapter.b();
                        c2 = adapter.f(a2) ? 0 : materialCalendarGridView.getChildAt(a2 - 1).getRight();
                    } else {
                        materialCalendarGridView.f1080e.setTimeInMillis(longValue);
                        a2 = adapter.a(materialCalendarGridView.f1080e.get(5));
                        c2 = c(materialCalendarGridView.getChildAt(a2));
                    }
                    if (longValue2 > item2.longValue()) {
                        a3 = Math.min(adapter.h(), getChildCount() - 1);
                        c3 = adapter.g(a3) ? getWidth() : materialCalendarGridView.getChildAt(a3).getRight();
                    } else {
                        materialCalendarGridView.f1080e.setTimeInMillis(longValue2);
                        a3 = adapter.a(materialCalendarGridView.f1080e.get(5));
                        c3 = c(materialCalendarGridView.getChildAt(a3));
                    }
                    int itemId = (int) adapter.getItemId(a2);
                    int itemId2 = (int) adapter.getItemId(a3);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (getNumColumns() + numColumns) - 1;
                        View childAt = materialCalendarGridView.getChildAt(numColumns);
                        canvas.drawRect(numColumns > a2 ? 0 : c2, childAt.getTop() + cVar.a.c(), a3 > numColumns2 ? getWidth() : c3, childAt.getBottom() - cVar.a.b(), cVar.h);
                        itemId++;
                        materialCalendarGridView = this;
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            a(i, rect);
        } else {
            super.onFocusChanged(false, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof j)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), j.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i) {
        if (i < getAdapter().b()) {
            i = getAdapter().b();
        }
        super.setSelection(i);
    }
}
