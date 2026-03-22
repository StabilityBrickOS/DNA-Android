package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.i0;

/* loaded from: classes.dex */
public class p0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: e, reason: collision with root package name */
    Runnable f245e;
    private c f;
    i0 g;
    private Spinner h;
    private boolean i;
    int j;
    int k;
    private int l;
    private int m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f246e;

        a(View view) {
            this.f246e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            p0.this.smoothScrollTo(this.f246e.getLeft() - ((p0.this.getWidth() - this.f246e.getWidth()) / 2), 0);
            p0.this.f245e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BaseAdapter {
        b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return p0.this.g.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((d) p0.this.g.getChildAt(i)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return p0.this.c((a.c) getItem(i), true);
            }
            ((d) view).a((a.c) getItem(i));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).b().e();
            int childCount = p0.this.g.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = p0.this.g.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends LinearLayout {

        /* renamed from: e, reason: collision with root package name */
        private final int[] f249e;
        private a.c f;
        private TextView g;
        private ImageView h;
        private View i;

        public d(Context context, a.c cVar, boolean z) {
            super(context, null, c.a.a.actionBarTabStyle);
            int[] iArr = {R.attr.background};
            this.f249e = iArr;
            this.f = cVar;
            w0 v = w0.v(context, null, iArr, c.a.a.actionBarTabStyle, 0);
            if (v.s(0)) {
                setBackgroundDrawable(v.g(0));
            }
            v.w();
            if (z) {
                setGravity(8388627);
            }
            c();
        }

        public void a(a.c cVar) {
            this.f = cVar;
            c();
        }

        public a.c b() {
            return this.f;
        }

        public void c() {
            a.c cVar = this.f;
            View b2 = cVar.b();
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.i = b2;
                TextView textView = this.g;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.h;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.h.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.i;
            if (view != null) {
                removeView(view);
                this.i = null;
            }
            Drawable c2 = cVar.c();
            CharSequence d2 = cVar.d();
            if (c2 != null) {
                if (this.h == null) {
                    o oVar = new o(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    oVar.setLayoutParams(layoutParams);
                    addView(oVar, 0);
                    this.h = oVar;
                }
                this.h.setImageDrawable(c2);
                this.h.setVisibility(0);
            } else {
                ImageView imageView2 = this.h;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.h.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(d2);
            if (z) {
                if (this.g == null) {
                    z zVar = new z(getContext(), null, c.a.a.actionBarTabTextStyle);
                    zVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    zVar.setLayoutParams(layoutParams2);
                    addView(zVar);
                    this.g = zVar;
                }
                this.g.setText(d2);
                this.g.setVisibility(0);
            } else {
                TextView textView2 = this.g;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.g.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.h;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            y0.a(this, z ? null : cVar.a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (p0.this.j > 0) {
                int measuredWidth = getMeasuredWidth();
                int i3 = p0.this.j;
                if (measuredWidth > i3) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    static {
        new DecelerateInterpolator();
    }

    private Spinner b() {
        w wVar = new w(getContext(), null, c.a.a.actionDropDownStyle);
        wVar.setLayoutParams(new i0.a(-2, -1));
        wVar.setOnItemSelectedListener(this);
        return wVar;
    }

    private boolean d() {
        Spinner spinner = this.h;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (d()) {
            return;
        }
        if (this.h == null) {
            this.h = b();
        }
        removeView(this.g);
        addView(this.h, new ViewGroup.LayoutParams(-2, -1));
        if (this.h.getAdapter() == null) {
            this.h.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.f245e;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f245e = null;
        }
        this.h.setSelection(this.m);
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.h);
        addView(this.g, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.h.getSelectedItemPosition());
        return false;
    }

    public void a(int i) {
        View childAt = this.g.getChildAt(i);
        Runnable runnable = this.f245e;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f245e = aVar;
        post(aVar);
    }

    d c(a.c cVar, boolean z) {
        d dVar = new d(getContext(), cVar, z);
        if (z) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.l));
        } else {
            dVar.setFocusable(true);
            if (this.f == null) {
                this.f = new c();
            }
            dVar.setOnClickListener(this.f);
        }
        return dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f245e;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c.a.n.a b2 = c.a.n.a.b(getContext());
        setContentHeight(b2.f());
        this.k = b2.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f245e;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((d) view).b().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.g.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            i3 = -1;
        } else {
            if (childCount > 2) {
                this.j = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.j = View.MeasureSpec.getSize(i) / 2;
            }
            i3 = Math.min(this.j, this.k);
        }
        this.j = i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.l, 1073741824);
        if (!z && this.i) {
            this.g.measure(0, makeMeasureSpec);
            if (this.g.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                e();
                int measuredWidth = getMeasuredWidth();
                super.onMeasure(i, makeMeasureSpec);
                int measuredWidth2 = getMeasuredWidth();
                if (z || measuredWidth == measuredWidth2) {
                }
                setTabSelected(this.m);
                return;
            }
        }
        f();
        int measuredWidth3 = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth22 = getMeasuredWidth();
        if (z) {
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.i = z;
    }

    public void setContentHeight(int i) {
        this.l = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.m = i;
        int childCount = this.g.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.g.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
            i2++;
        }
        Spinner spinner = this.h;
        if (spinner == null || i < 0) {
            return;
        }
        spinner.setSelection(i);
    }
}
