package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: e, reason: collision with root package name */
    protected final C0006a f184e;
    protected final Context f;
    protected ActionMenuView g;
    protected c h;
    protected int i;
    protected c.f.l.w j;
    private boolean k;
    private boolean l;

    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    protected class C0006a implements c.f.l.x {
        private boolean a = false;

        /* renamed from: b, reason: collision with root package name */
        int f185b;

        protected C0006a() {
        }

        @Override // c.f.l.x
        public void a(View view) {
            if (this.a) {
                return;
            }
            a aVar = a.this;
            aVar.j = null;
            a.super.setVisibility(this.f185b);
        }

        @Override // c.f.l.x
        public void b(View view) {
            a.super.setVisibility(0);
            this.a = false;
        }

        @Override // c.f.l.x
        public void c(View view) {
            this.a = true;
        }

        public C0006a d(c.f.l.w wVar, int i) {
            a.this.j = wVar;
            this.f185b = i;
            return this;
        }
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f184e = new C0006a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(c.a.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f = context;
        } else {
            this.f = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int d(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public c.f.l.w f(int i, long j) {
        c.f.l.w wVar = this.j;
        if (wVar != null) {
            wVar.b();
        }
        if (i != 0) {
            c.f.l.w c2 = c.f.l.s.c(this);
            c2.a(0.0f);
            c2.d(j);
            C0006a c0006a = this.f184e;
            c0006a.d(c2, i);
            c2.f(c0006a);
            return c2;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        c.f.l.w c3 = c.f.l.s.c(this);
        c3.a(1.0f);
        c3.d(j);
        C0006a c0006a2 = this.f184e;
        c0006a2.d(c3, i);
        c3.f(c0006a2);
        return c3;
    }

    public int getAnimatedVisibility() {
        return this.j != null ? this.f184e.f185b : getVisibility();
    }

    public int getContentHeight() {
        return this.i;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, c.a.j.ActionBar, c.a.a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(c.a.j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        c cVar = this.h;
        if (cVar != null) {
            cVar.F(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.l = false;
        }
        if (!this.l) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.l = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.l = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.k = false;
        }
        if (!this.k) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.k = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.k = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            c.f.l.w wVar = this.j;
            if (wVar != null) {
                wVar.b();
            }
            super.setVisibility(i);
        }
    }
}
