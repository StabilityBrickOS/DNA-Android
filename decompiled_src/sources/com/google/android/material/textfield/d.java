package com.google.android.material.textfield;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import c.f.l.s;
import com.google.android.material.textfield.TextInputLayout;
import d.a.a.a.z.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.google.android.material.textfield.e {
    private static final boolean q;

    /* renamed from: d, reason: collision with root package name */
    private final TextWatcher f1199d;

    /* renamed from: e, reason: collision with root package name */
    private final View.OnFocusChangeListener f1200e;
    private final TextInputLayout.e f;
    private final TextInputLayout.f g;

    @SuppressLint({"ClickableViewAccessibility"})
    private final TextInputLayout.g h;
    private boolean i;
    private boolean j;
    private long k;
    private StateListDrawable l;
    private d.a.a.a.z.g m;
    private AccessibilityManager n;
    private ValueAnimator o;
    private ValueAnimator p;

    /* loaded from: classes.dex */
    class a implements TextWatcher {

        /* renamed from: com.google.android.material.textfield.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0077a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f1202e;

            RunnableC0077a(AutoCompleteTextView autoCompleteTextView) {
                this.f1202e = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.f1202e.isPopupShowing();
                d.this.C(isPopupShowing);
                d.this.i = isPopupShowing;
            }
        }

        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d dVar = d.this;
            AutoCompleteTextView x = dVar.x(dVar.a.getEditText());
            x.post(new RunnableC0077a(x));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.f1208c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnFocusChangeListener {
        c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            d.this.a.setEndIconActivated(z);
            if (z) {
                return;
            }
            d.this.C(false);
            d.this.i = false;
        }
    }

    /* renamed from: com.google.android.material.textfield.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0078d extends TextInputLayout.e {
        C0078d(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, c.f.l.a
        public void g(View view, c.f.l.b0.c cVar) {
            super.g(view, cVar);
            if (d.this.a.getEditText().getKeyListener() == null) {
                cVar.a0(Spinner.class.getName());
            }
            if (cVar.L()) {
                cVar.l0(null);
            }
        }

        @Override // c.f.l.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            d dVar = d.this;
            AutoCompleteTextView x = dVar.x(dVar.a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && d.this.n.isTouchExplorationEnabled()) {
                d.this.F(x);
            }
        }
    }

    /* loaded from: classes.dex */
    class e implements TextInputLayout.f {
        e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView x = d.this.x(textInputLayout.getEditText());
            d.this.D(x);
            d.this.u(x);
            d.this.E(x);
            x.setThreshold(0);
            x.removeTextChangedListener(d.this.f1199d);
            x.addTextChangedListener(d.this.f1199d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            textInputLayout.setTextInputAccessibilityDelegate(d.this.f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* loaded from: classes.dex */
    class f implements TextInputLayout.g {
        f() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView == null || i != 3) {
                return;
            }
            autoCompleteTextView.removeTextChangedListener(d.this.f1199d);
            if (autoCompleteTextView.getOnFocusChangeListener() == d.this.f1200e) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            if (d.q) {
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    }

    /* loaded from: classes.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.F((AutoCompleteTextView) d.this.a.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements View.OnTouchListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AutoCompleteTextView f1206e;

        h(AutoCompleteTextView autoCompleteTextView) {
            this.f1206e = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (d.this.B()) {
                    d.this.i = false;
                }
                d.this.F(this.f1206e);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements AutoCompleteTextView.OnDismissListener {
        i() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            d.this.i = true;
            d.this.k = System.currentTimeMillis();
            d.this.C(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends AnimatorListenerAdapter {
        j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            dVar.f1208c.setChecked(dVar.j);
            d.this.p.start();
        }
    }

    static {
        q = Build.VERSION.SDK_INT >= 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f1199d = new a();
        this.f1200e = new c();
        this.f = new C0078d(this.a);
        this.g = new e();
        this.h = new f();
        this.i = false;
        this.j = false;
        this.k = Long.MAX_VALUE;
    }

    private void A() {
        this.p = y(67, 0.0f, 1.0f);
        ValueAnimator y = y(50, 1.0f, 0.0f);
        this.o = y;
        y.addListener(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B() {
        long currentTimeMillis = System.currentTimeMillis() - this.k;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z) {
        if (this.j != z) {
            this.j = z;
            this.p.cancel();
            this.o.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(AutoCompleteTextView autoCompleteTextView) {
        Drawable drawable;
        if (q) {
            int boxBackgroundMode = this.a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                drawable = this.m;
            } else if (boxBackgroundMode != 1) {
                return;
            } else {
                drawable = this.l;
            }
            autoCompleteTextView.setDropDownBackgroundDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void E(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new h(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f1200e);
        if (q) {
            autoCompleteTextView.setOnDismissListener(new i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (B()) {
            this.i = false;
        }
        if (this.i) {
            this.i = false;
            return;
        }
        if (q) {
            C(!this.j);
        } else {
            this.j = !this.j;
            this.f1208c.toggle();
        }
        if (!this.j) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView.getKeyListener() != null) {
            return;
        }
        int boxBackgroundMode = this.a.getBoxBackgroundMode();
        d.a.a.a.z.g boxBackground = this.a.getBoxBackground();
        int c2 = d.a.a.a.q.a.c(autoCompleteTextView, d.a.a.a.b.colorControlHighlight);
        int[][] iArr = {new int[]{R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            w(autoCompleteTextView, c2, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            v(autoCompleteTextView, c2, iArr, boxBackground);
        }
    }

    private void v(AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, d.a.a.a.z.g gVar) {
        int boxBackgroundColor = this.a.getBoxBackgroundColor();
        int[] iArr2 = {d.a.a.a.q.a.f(i2, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (q) {
            s.l0(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), gVar, gVar));
            return;
        }
        d.a.a.a.z.g gVar2 = new d.a.a.a.z.g(gVar.C());
        gVar2.V(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar, gVar2});
        int D = s.D(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int C = s.C(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        s.l0(autoCompleteTextView, layerDrawable);
        s.v0(autoCompleteTextView, D, paddingTop, C, paddingBottom);
    }

    private void w(AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, d.a.a.a.z.g gVar) {
        LayerDrawable layerDrawable;
        int c2 = d.a.a.a.q.a.c(autoCompleteTextView, d.a.a.a.b.colorSurface);
        d.a.a.a.z.g gVar2 = new d.a.a.a.z.g(gVar.C());
        int f2 = d.a.a.a.q.a.f(i2, c2, 0.1f);
        gVar2.V(new ColorStateList(iArr, new int[]{f2, 0}));
        if (q) {
            gVar2.setTint(c2);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{f2, c2});
            d.a.a.a.z.g gVar3 = new d.a.a.a.z.g(gVar.C());
            gVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar2, gVar3), gVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar});
        }
        s.l0(autoCompleteTextView, layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AutoCompleteTextView x(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator y(int i2, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(d.a.a.a.l.a.a);
        ofFloat.setDuration(i2);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    private d.a.a.a.z.g z(float f2, float f3, float f4, int i2) {
        k.b a2 = k.a();
        a2.z(f2);
        a2.D(f2);
        a2.r(f3);
        a2.v(f3);
        k m = a2.m();
        d.a.a.a.z.g m2 = d.a.a.a.z.g.m(this.f1207b, f4);
        m2.setShapeAppearanceModel(m);
        m2.X(0, i2, 0, i2);
        return m2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        float dimensionPixelOffset = this.f1207b.getResources().getDimensionPixelOffset(d.a.a.a.d.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f1207b.getResources().getDimensionPixelOffset(d.a.a.a.d.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f1207b.getResources().getDimensionPixelOffset(d.a.a.a.d.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        d.a.a.a.z.g z = z(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        d.a.a.a.z.g z2 = z(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.m = z;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.l = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, z);
        this.l.addState(new int[0], z2);
        this.a.setEndIconDrawable(c.a.k.a.a.d(this.f1207b, q ? d.a.a.a.e.mtrl_dropdown_arrow : d.a.a.a.e.mtrl_ic_arrow_drop_down));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(d.a.a.a.i.exposed_dropdown_menu_content_description));
        this.a.setEndIconOnClickListener(new g());
        this.a.e(this.g);
        this.a.f(this.h);
        A();
        s.s0(this.f1208c, 2);
        this.n = (AccessibilityManager) this.f1207b.getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public boolean b(int i2) {
        return i2 != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public boolean d() {
        return true;
    }
}
