package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.w0;
import androidx.appcompat.widget.z;
import c.f.l.s;
import com.google.android.material.internal.CheckableImageButton;
import d.a.a.a.j;
import d.a.a.a.z.k;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    private static final int M0 = j.Widget_Design_TextInputLayout;
    private CharSequence A;
    private ColorStateList A0;
    private final TextView B;
    private int B0;
    private boolean C;
    private int C0;
    private CharSequence D;
    private int D0;
    private boolean E;
    private int E0;
    private d.a.a.a.z.g F;
    private int F0;
    private d.a.a.a.z.g G;
    private boolean G0;
    private k H;
    final com.google.android.material.internal.a H0;
    private final int I;
    private boolean I0;
    private int J;
    private ValueAnimator J0;
    private final int K;
    private boolean K0;
    private int L;
    private boolean L0;
    private int M;
    private int N;
    private int O;
    private int P;
    private final Rect Q;
    private final Rect R;
    private final RectF S;
    private Typeface T;
    private final CheckableImageButton U;
    private ColorStateList V;
    private boolean W;
    private PorterDuff.Mode a0;
    private boolean b0;
    private Drawable c0;
    private int d0;

    /* renamed from: e, reason: collision with root package name */
    private final FrameLayout f1189e;
    private View.OnLongClickListener e0;
    private final LinearLayout f;
    private final LinkedHashSet<f> f0;
    private final LinearLayout g;
    private int g0;
    private final FrameLayout h;
    private final SparseArray<com.google.android.material.textfield.e> h0;
    EditText i;
    private final CheckableImageButton i0;
    private CharSequence j;
    private final LinkedHashSet<g> j0;
    private final com.google.android.material.textfield.f k;
    private ColorStateList k0;
    boolean l;
    private boolean l0;
    private int m;
    private PorterDuff.Mode m0;
    private boolean n;
    private boolean n0;
    private TextView o;
    private Drawable o0;
    private int p;
    private int p0;
    private int q;
    private Drawable q0;
    private CharSequence r;
    private View.OnLongClickListener r0;
    private boolean s;
    private View.OnLongClickListener s0;
    private TextView t;
    private final CheckableImageButton t0;
    private ColorStateList u;
    private ColorStateList u0;
    private int v;
    private ColorStateList v0;
    private ColorStateList w;
    private ColorStateList w0;
    private ColorStateList x;
    private int x0;
    private CharSequence y;
    private int y0;
    private final TextView z;
    private int z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.o0(!r0.L0);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.l) {
                textInputLayout.g0(editable.length());
            }
            if (TextInputLayout.this.s) {
                TextInputLayout.this.s0(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.i0.performClick();
            TextInputLayout.this.i0.jumpDrawablesToCurrentState();
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.i.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.H0.V(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public static class e extends c.f.l.a {

        /* renamed from: d, reason: collision with root package name */
        private final TextInputLayout f1193d;

        public e(TextInputLayout textInputLayout) {
            this.f1193d = textInputLayout;
        }

        @Override // c.f.l.a
        public void g(View view, c.f.l.b0.c cVar) {
            super.g(view, cVar);
            EditText editText = this.f1193d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f1193d.getHint();
            CharSequence helperText = this.f1193d.getHelperText();
            CharSequence error = this.f1193d.getError();
            int counterMaxLength = this.f1193d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f1193d.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(helperText);
            boolean z4 = !TextUtils.isEmpty(error);
            boolean z5 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z2 ? hint.toString() : "";
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence);
            sb.append(((z4 || z3) && !TextUtils.isEmpty(charSequence)) ? ", " : "");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            if (z4) {
                helperText = error;
            } else if (!z3) {
                helperText = "";
            }
            sb3.append((Object) helperText);
            String sb4 = sb3.toString();
            if (z) {
                cVar.y0(text);
            } else if (!TextUtils.isEmpty(sb4)) {
                cVar.y0(sb4);
            }
            if (!TextUtils.isEmpty(sb4)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    cVar.l0(sb4);
                } else {
                    if (z) {
                        sb4 = ((Object) text) + ", " + sb4;
                    }
                    cVar.y0(sb4);
                }
                cVar.v0(!z);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            cVar.n0(counterMaxLength);
            if (z5) {
                if (!z4) {
                    error = counterOverflowDescription;
                }
                cVar.h0(error);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(TextInputLayout textInputLayout, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h extends c.h.a.a {
        public static final Parcelable.Creator<h> CREATOR = new a();
        CharSequence g;
        boolean h;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i) {
                return new h[i];
            }
        }

        h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.h = parcel.readInt() == 1;
        }

        h(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.g) + "}";
        }

        @Override // c.h.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.g, parcel, i);
            parcel.writeInt(this.h ? 1 : 0);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.a.a.b.textInputStyle);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i, M0), attributeSet, i);
        int colorForState;
        this.k = new com.google.android.material.textfield.f(this);
        this.Q = new Rect();
        this.R = new Rect();
        this.S = new RectF();
        this.f0 = new LinkedHashSet<>();
        this.g0 = 0;
        this.h0 = new SparseArray<>();
        this.j0 = new LinkedHashSet<>();
        this.H0 = new com.google.android.material.internal.a(this);
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f1189e = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(this.f1189e);
        LinearLayout linearLayout = new LinearLayout(context2);
        this.f = linearLayout;
        linearLayout.setOrientation(0);
        this.f.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        this.f1189e.addView(this.f);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        this.g = linearLayout2;
        linearLayout2.setOrientation(0);
        this.g.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        this.f1189e.addView(this.g);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.h = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        this.H0.a0(d.a.a.a.l.a.a);
        this.H0.X(d.a.a.a.l.a.a);
        this.H0.L(8388659);
        w0 i2 = com.google.android.material.internal.i.i(context2, attributeSet, d.a.a.a.k.TextInputLayout, i, M0, d.a.a.a.k.TextInputLayout_counterTextAppearance, d.a.a.a.k.TextInputLayout_counterOverflowTextAppearance, d.a.a.a.k.TextInputLayout_errorTextAppearance, d.a.a.a.k.TextInputLayout_helperTextTextAppearance, d.a.a.a.k.TextInputLayout_hintTextAppearance);
        this.C = i2.a(d.a.a.a.k.TextInputLayout_hintEnabled, true);
        setHint(i2.p(d.a.a.a.k.TextInputLayout_android_hint));
        this.I0 = i2.a(d.a.a.a.k.TextInputLayout_hintAnimationEnabled, true);
        this.H = k.e(context2, attributeSet, i, M0).m();
        this.I = context2.getResources().getDimensionPixelOffset(d.a.a.a.d.mtrl_textinput_box_label_cutout_padding);
        this.K = i2.e(d.a.a.a.k.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.M = i2.f(d.a.a.a.k.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(d.a.a.a.d.mtrl_textinput_box_stroke_width_default));
        this.N = i2.f(d.a.a.a.k.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(d.a.a.a.d.mtrl_textinput_box_stroke_width_focused));
        this.L = this.M;
        float d2 = i2.d(d.a.a.a.k.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float d3 = i2.d(d.a.a.a.k.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float d4 = i2.d(d.a.a.a.k.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float d5 = i2.d(d.a.a.a.k.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        k.b v = this.H.v();
        if (d2 >= 0.0f) {
            v.z(d2);
        }
        if (d3 >= 0.0f) {
            v.D(d3);
        }
        if (d4 >= 0.0f) {
            v.v(d4);
        }
        if (d5 >= 0.0f) {
            v.r(d5);
        }
        this.H = v.m();
        ColorStateList b2 = d.a.a.a.w.c.b(context2, i2, d.a.a.a.k.TextInputLayout_boxBackgroundColor);
        if (b2 != null) {
            int defaultColor = b2.getDefaultColor();
            this.B0 = defaultColor;
            this.P = defaultColor;
            if (b2.isStateful()) {
                this.C0 = b2.getColorForState(new int[]{-16842910}, -1);
                this.D0 = b2.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                colorForState = b2.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.D0 = this.B0;
                ColorStateList c2 = c.a.k.a.a.c(context2, d.a.a.a.c.mtrl_filled_background_color);
                this.C0 = c2.getColorForState(new int[]{-16842910}, -1);
                colorForState = c2.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
            this.E0 = colorForState;
        } else {
            this.P = 0;
            this.B0 = 0;
            this.C0 = 0;
            this.D0 = 0;
            this.E0 = 0;
        }
        if (i2.s(d.a.a.a.k.TextInputLayout_android_textColorHint)) {
            ColorStateList c3 = i2.c(d.a.a.a.k.TextInputLayout_android_textColorHint);
            this.w0 = c3;
            this.v0 = c3;
        }
        ColorStateList b3 = d.a.a.a.w.c.b(context2, i2, d.a.a.a.k.TextInputLayout_boxStrokeColor);
        this.z0 = i2.b(d.a.a.a.k.TextInputLayout_boxStrokeColor, 0);
        this.x0 = c.f.d.a.a(context2, d.a.a.a.c.mtrl_textinput_default_box_stroke_color);
        this.F0 = c.f.d.a.a(context2, d.a.a.a.c.mtrl_textinput_disabled_color);
        this.y0 = c.f.d.a.a(context2, d.a.a.a.c.mtrl_textinput_hovered_box_stroke_color);
        if (b3 != null) {
            setBoxStrokeColorStateList(b3);
        }
        if (i2.s(d.a.a.a.k.TextInputLayout_boxStrokeErrorColor)) {
            setBoxStrokeErrorColor(d.a.a.a.w.c.b(context2, i2, d.a.a.a.k.TextInputLayout_boxStrokeErrorColor));
        }
        if (i2.n(d.a.a.a.k.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(i2.n(d.a.a.a.k.TextInputLayout_hintTextAppearance, 0));
        }
        int n = i2.n(d.a.a.a.k.TextInputLayout_errorTextAppearance, 0);
        CharSequence p = i2.p(d.a.a.a.k.TextInputLayout_errorContentDescription);
        boolean a2 = i2.a(d.a.a.a.k.TextInputLayout_errorEnabled, false);
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(d.a.a.a.h.design_text_input_end_icon, (ViewGroup) this.g, false);
        this.t0 = checkableImageButton;
        checkableImageButton.setVisibility(8);
        if (i2.s(d.a.a.a.k.TextInputLayout_errorIconDrawable)) {
            setErrorIconDrawable(i2.g(d.a.a.a.k.TextInputLayout_errorIconDrawable));
        }
        if (i2.s(d.a.a.a.k.TextInputLayout_errorIconTint)) {
            setErrorIconTintList(d.a.a.a.w.c.b(context2, i2, d.a.a.a.k.TextInputLayout_errorIconTint));
        }
        if (i2.s(d.a.a.a.k.TextInputLayout_errorIconTintMode)) {
            setErrorIconTintMode(com.google.android.material.internal.j.e(i2.k(d.a.a.a.k.TextInputLayout_errorIconTintMode, -1), null));
        }
        this.t0.setContentDescription(getResources().getText(d.a.a.a.i.error_icon_content_description));
        s.s0(this.t0, 2);
        this.t0.setClickable(false);
        this.t0.setPressable(false);
        this.t0.setFocusable(false);
        int n2 = i2.n(d.a.a.a.k.TextInputLayout_helperTextTextAppearance, 0);
        boolean a3 = i2.a(d.a.a.a.k.TextInputLayout_helperTextEnabled, false);
        CharSequence p2 = i2.p(d.a.a.a.k.TextInputLayout_helperText);
        int n3 = i2.n(d.a.a.a.k.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence p3 = i2.p(d.a.a.a.k.TextInputLayout_placeholderText);
        int n4 = i2.n(d.a.a.a.k.TextInputLayout_prefixTextAppearance, 0);
        CharSequence p4 = i2.p(d.a.a.a.k.TextInputLayout_prefixText);
        int n5 = i2.n(d.a.a.a.k.TextInputLayout_suffixTextAppearance, 0);
        CharSequence p5 = i2.p(d.a.a.a.k.TextInputLayout_suffixText);
        boolean a4 = i2.a(d.a.a.a.k.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(i2.k(d.a.a.a.k.TextInputLayout_counterMaxLength, -1));
        this.q = i2.n(d.a.a.a.k.TextInputLayout_counterTextAppearance, 0);
        this.p = i2.n(d.a.a.a.k.TextInputLayout_counterOverflowTextAppearance, 0);
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(d.a.a.a.h.design_text_input_start_icon, (ViewGroup) this.f, false);
        this.U = checkableImageButton2;
        checkableImageButton2.setVisibility(8);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        if (i2.s(d.a.a.a.k.TextInputLayout_startIconDrawable)) {
            setStartIconDrawable(i2.g(d.a.a.a.k.TextInputLayout_startIconDrawable));
            if (i2.s(d.a.a.a.k.TextInputLayout_startIconContentDescription)) {
                setStartIconContentDescription(i2.p(d.a.a.a.k.TextInputLayout_startIconContentDescription));
            }
            setStartIconCheckable(i2.a(d.a.a.a.k.TextInputLayout_startIconCheckable, true));
        }
        if (i2.s(d.a.a.a.k.TextInputLayout_startIconTint)) {
            setStartIconTintList(d.a.a.a.w.c.b(context2, i2, d.a.a.a.k.TextInputLayout_startIconTint));
        }
        if (i2.s(d.a.a.a.k.TextInputLayout_startIconTintMode)) {
            setStartIconTintMode(com.google.android.material.internal.j.e(i2.k(d.a.a.a.k.TextInputLayout_startIconTintMode, -1), null));
        }
        setBoxBackgroundMode(i2.k(d.a.a.a.k.TextInputLayout_boxBackgroundMode, 0));
        CheckableImageButton checkableImageButton3 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(d.a.a.a.h.design_text_input_end_icon, (ViewGroup) this.h, false);
        this.i0 = checkableImageButton3;
        this.h.addView(checkableImageButton3);
        this.i0.setVisibility(8);
        this.h0.append(-1, new com.google.android.material.textfield.b(this));
        this.h0.append(0, new com.google.android.material.textfield.h(this));
        this.h0.append(1, new i(this));
        this.h0.append(2, new com.google.android.material.textfield.a(this));
        this.h0.append(3, new com.google.android.material.textfield.d(this));
        if (i2.s(d.a.a.a.k.TextInputLayout_endIconMode)) {
            setEndIconMode(i2.k(d.a.a.a.k.TextInputLayout_endIconMode, 0));
            if (i2.s(d.a.a.a.k.TextInputLayout_endIconDrawable)) {
                setEndIconDrawable(i2.g(d.a.a.a.k.TextInputLayout_endIconDrawable));
            }
            if (i2.s(d.a.a.a.k.TextInputLayout_endIconContentDescription)) {
                setEndIconContentDescription(i2.p(d.a.a.a.k.TextInputLayout_endIconContentDescription));
            }
            setEndIconCheckable(i2.a(d.a.a.a.k.TextInputLayout_endIconCheckable, true));
        } else if (i2.s(d.a.a.a.k.TextInputLayout_passwordToggleEnabled)) {
            setEndIconMode(i2.a(d.a.a.a.k.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
            setEndIconDrawable(i2.g(d.a.a.a.k.TextInputLayout_passwordToggleDrawable));
            setEndIconContentDescription(i2.p(d.a.a.a.k.TextInputLayout_passwordToggleContentDescription));
            if (i2.s(d.a.a.a.k.TextInputLayout_passwordToggleTint)) {
                setEndIconTintList(d.a.a.a.w.c.b(context2, i2, d.a.a.a.k.TextInputLayout_passwordToggleTint));
            }
            if (i2.s(d.a.a.a.k.TextInputLayout_passwordToggleTintMode)) {
                setEndIconTintMode(com.google.android.material.internal.j.e(i2.k(d.a.a.a.k.TextInputLayout_passwordToggleTintMode, -1), null));
            }
        }
        if (!i2.s(d.a.a.a.k.TextInputLayout_passwordToggleEnabled)) {
            if (i2.s(d.a.a.a.k.TextInputLayout_endIconTint)) {
                setEndIconTintList(d.a.a.a.w.c.b(context2, i2, d.a.a.a.k.TextInputLayout_endIconTint));
            }
            if (i2.s(d.a.a.a.k.TextInputLayout_endIconTintMode)) {
                setEndIconTintMode(com.google.android.material.internal.j.e(i2.k(d.a.a.a.k.TextInputLayout_endIconTintMode, -1), null));
            }
        }
        z zVar = new z(context2);
        this.z = zVar;
        zVar.setId(d.a.a.a.f.textinput_prefix_text);
        this.z.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        s.k0(this.z, 1);
        this.f.addView(this.U);
        this.f.addView(this.z);
        z zVar2 = new z(context2);
        this.B = zVar2;
        zVar2.setId(d.a.a.a.f.textinput_suffix_text);
        this.B.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        s.k0(this.B, 1);
        this.g.addView(this.B);
        this.g.addView(this.t0);
        this.g.addView(this.h);
        setHelperTextEnabled(a3);
        setHelperText(p2);
        setHelperTextTextAppearance(n2);
        setErrorEnabled(a2);
        setErrorTextAppearance(n);
        setErrorContentDescription(p);
        setCounterTextAppearance(this.q);
        setCounterOverflowTextAppearance(this.p);
        setPlaceholderText(p3);
        setPlaceholderTextAppearance(n3);
        setPrefixText(p4);
        setPrefixTextAppearance(n4);
        setSuffixText(p5);
        setSuffixTextAppearance(n5);
        if (i2.s(d.a.a.a.k.TextInputLayout_errorTextColor)) {
            setErrorTextColor(i2.c(d.a.a.a.k.TextInputLayout_errorTextColor));
        }
        if (i2.s(d.a.a.a.k.TextInputLayout_helperTextTextColor)) {
            setHelperTextColor(i2.c(d.a.a.a.k.TextInputLayout_helperTextTextColor));
        }
        if (i2.s(d.a.a.a.k.TextInputLayout_hintTextColor)) {
            setHintTextColor(i2.c(d.a.a.a.k.TextInputLayout_hintTextColor));
        }
        if (i2.s(d.a.a.a.k.TextInputLayout_counterTextColor)) {
            setCounterTextColor(i2.c(d.a.a.a.k.TextInputLayout_counterTextColor));
        }
        if (i2.s(d.a.a.a.k.TextInputLayout_counterOverflowTextColor)) {
            setCounterOverflowTextColor(i2.c(d.a.a.a.k.TextInputLayout_counterOverflowTextColor));
        }
        if (i2.s(d.a.a.a.k.TextInputLayout_placeholderTextColor)) {
            setPlaceholderTextColor(i2.c(d.a.a.a.k.TextInputLayout_placeholderTextColor));
        }
        if (i2.s(d.a.a.a.k.TextInputLayout_prefixTextColor)) {
            setPrefixTextColor(i2.c(d.a.a.a.k.TextInputLayout_prefixTextColor));
        }
        if (i2.s(d.a.a.a.k.TextInputLayout_suffixTextColor)) {
            setSuffixTextColor(i2.c(d.a.a.a.k.TextInputLayout_suffixTextColor));
        }
        setCounterEnabled(a4);
        setEnabled(i2.a(d.a.a.a.k.TextInputLayout_android_enabled, true));
        i2.w();
        s.s0(this, 2);
    }

    private void A() {
        Iterator<f> it = this.f0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void B(int i) {
        Iterator<g> it = this.j0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i);
        }
    }

    private void C(Canvas canvas) {
        d.a.a.a.z.g gVar = this.G;
        if (gVar != null) {
            Rect bounds = gVar.getBounds();
            bounds.top = bounds.bottom - this.L;
            this.G.draw(canvas);
        }
    }

    private void D(Canvas canvas) {
        if (this.C) {
            this.H0.j(canvas);
        }
    }

    private void E(boolean z) {
        ValueAnimator valueAnimator = this.J0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.J0.cancel();
        }
        if (z && this.I0) {
            h(0.0f);
        } else {
            this.H0.V(0.0f);
        }
        if (z() && ((com.google.android.material.textfield.c) this.F).i0()) {
            x();
        }
        this.G0 = true;
        I();
        u0();
        x0();
    }

    private int F(int i, boolean z) {
        int compoundPaddingLeft = i + this.i.getCompoundPaddingLeft();
        return (this.y == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - this.z.getMeasuredWidth()) + this.z.getPaddingLeft();
    }

    private int G(int i, boolean z) {
        int compoundPaddingRight = i - this.i.getCompoundPaddingRight();
        return (this.y == null || !z) ? compoundPaddingRight : compoundPaddingRight + (this.z.getMeasuredWidth() - this.z.getPaddingRight());
    }

    private boolean H() {
        return this.g0 != 0;
    }

    private void I() {
        TextView textView = this.t;
        if (textView == null || !this.s) {
            return;
        }
        textView.setText((CharSequence) null);
        this.t.setVisibility(4);
    }

    private boolean K() {
        return this.t0.getVisibility() == 0;
    }

    private boolean O() {
        return this.J == 1 && (Build.VERSION.SDK_INT < 16 || this.i.getMinLines() <= 1);
    }

    private void Q() {
        o();
        U();
        y0();
        if (this.J != 0) {
            n0();
        }
    }

    private void R() {
        if (z()) {
            RectF rectF = this.S;
            this.H0.m(rectF, this.i.getWidth(), this.i.getGravity());
            k(rectF);
            rectF.offset(-getPaddingLeft(), -getPaddingTop());
            ((com.google.android.material.textfield.c) this.F).o0(rectF);
        }
    }

    private static void S(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                S((ViewGroup) childAt, z);
            }
        }
    }

    private void T() {
        TextView textView = this.t;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void U() {
        if (b0()) {
            s.l0(this.i, this.F);
        }
    }

    private static void V(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean J = s.J(checkableImageButton);
        boolean z = onLongClickListener != null;
        boolean z2 = J || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(J);
        checkableImageButton.setPressable(J);
        checkableImageButton.setLongClickable(z);
        s.s0(checkableImageButton, z2 ? 1 : 2);
    }

    private static void W(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        V(checkableImageButton, onLongClickListener);
    }

    private static void X(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        V(checkableImageButton, onLongClickListener);
    }

    private boolean Z() {
        return (this.t0.getVisibility() == 0 || ((H() && J()) || this.A != null)) && this.g.getMeasuredWidth() > 0;
    }

    private boolean a0() {
        return !(getStartIconDrawable() == null && this.y == null) && this.f.getMeasuredWidth() > 0;
    }

    private boolean b0() {
        EditText editText = this.i;
        return (editText == null || this.F == null || editText.getBackground() != null || this.J == 0) ? false : true;
    }

    private void c0() {
        TextView textView = this.t;
        if (textView == null || !this.s) {
            return;
        }
        textView.setText(this.r);
        this.t.setVisibility(0);
        this.t.bringToFront();
    }

    private void d0(boolean z) {
        if (!z || getEndIconDrawable() == null) {
            l();
            return;
        }
        Drawable mutate = androidx.core.graphics.drawable.a.r(getEndIconDrawable()).mutate();
        androidx.core.graphics.drawable.a.n(mutate, this.k.o());
        this.i0.setImageDrawable(mutate);
    }

    private void e0(Rect rect) {
        d.a.a.a.z.g gVar = this.G;
        if (gVar != null) {
            int i = rect.bottom;
            gVar.setBounds(rect.left, i - this.N, rect.right, i);
        }
    }

    private void f0() {
        if (this.o != null) {
            EditText editText = this.i;
            g0(editText == null ? 0 : editText.getText().length());
        }
    }

    private void g() {
        TextView textView = this.t;
        if (textView != null) {
            this.f1189e.addView(textView);
            this.t.setVisibility(0);
        }
    }

    private com.google.android.material.textfield.e getEndIconDelegate() {
        com.google.android.material.textfield.e eVar = this.h0.get(this.g0);
        return eVar != null ? eVar : this.h0.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.t0.getVisibility() == 0) {
            return this.t0;
        }
        if (H() && J()) {
            return this.i0;
        }
        return null;
    }

    private static void h0(Context context, TextView textView, int i, int i2, boolean z) {
        textView.setContentDescription(context.getString(z ? d.a.a.a.i.character_counter_overflowed_content_description : d.a.a.a.i.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    private void i() {
        d.a.a.a.z.g gVar = this.F;
        if (gVar == null) {
            return;
        }
        gVar.setShapeAppearanceModel(this.H);
        if (v()) {
            this.F.b0(this.L, this.O);
        }
        int p = p();
        this.P = p;
        this.F.V(ColorStateList.valueOf(p));
        if (this.g0 == 3) {
            this.i.getBackground().invalidateSelf();
        }
        j();
        invalidate();
    }

    private void i0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.o;
        if (textView != null) {
            Y(textView, this.n ? this.p : this.q);
            if (!this.n && (colorStateList2 = this.w) != null) {
                this.o.setTextColor(colorStateList2);
            }
            if (!this.n || (colorStateList = this.x) == null) {
                return;
            }
            this.o.setTextColor(colorStateList);
        }
    }

    private void j() {
        if (this.G == null) {
            return;
        }
        if (w()) {
            this.G.V(ColorStateList.valueOf(this.O));
        }
        invalidate();
    }

    private boolean j0() {
        boolean z;
        if (this.i == null) {
            return false;
        }
        boolean z2 = true;
        if (a0()) {
            int measuredWidth = this.f.getMeasuredWidth() - this.i.getPaddingLeft();
            if (this.c0 == null || this.d0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.c0 = colorDrawable;
                this.d0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] a2 = androidx.core.widget.i.a(this.i);
            Drawable drawable = a2[0];
            Drawable drawable2 = this.c0;
            if (drawable != drawable2) {
                androidx.core.widget.i.i(this.i, drawable2, a2[1], a2[2], a2[3]);
                z = true;
            }
            z = false;
        } else {
            if (this.c0 != null) {
                Drawable[] a3 = androidx.core.widget.i.a(this.i);
                androidx.core.widget.i.i(this.i, null, a3[1], a3[2], a3[3]);
                this.c0 = null;
                z = true;
            }
            z = false;
        }
        if (Z()) {
            int measuredWidth2 = this.B.getMeasuredWidth() - this.i.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + c.f.l.g.b((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            Drawable[] a4 = androidx.core.widget.i.a(this.i);
            Drawable drawable3 = this.o0;
            if (drawable3 == null || this.p0 == measuredWidth2) {
                if (this.o0 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.o0 = colorDrawable2;
                    this.p0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = a4[2];
                Drawable drawable5 = this.o0;
                if (drawable4 != drawable5) {
                    this.q0 = a4[2];
                    androidx.core.widget.i.i(this.i, a4[0], a4[1], drawable5, a4[3]);
                } else {
                    z2 = z;
                }
            } else {
                this.p0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                androidx.core.widget.i.i(this.i, a4[0], a4[1], this.o0, a4[3]);
            }
        } else {
            if (this.o0 == null) {
                return z;
            }
            Drawable[] a5 = androidx.core.widget.i.a(this.i);
            if (a5[2] == this.o0) {
                androidx.core.widget.i.i(this.i, a5[0], a5[1], this.q0, a5[3]);
            } else {
                z2 = z;
            }
            this.o0 = null;
        }
        return z2;
    }

    private void k(RectF rectF) {
        float f2 = rectF.left;
        int i = this.I;
        rectF.left = f2 - i;
        rectF.top -= i;
        rectF.right += i;
        rectF.bottom += i;
    }

    private void l() {
        m(this.i0, this.l0, this.k0, this.n0, this.m0);
    }

    private boolean l0() {
        int max;
        if (this.i == null || this.i.getMeasuredHeight() >= (max = Math.max(this.g.getMeasuredHeight(), this.f.getMeasuredHeight()))) {
            return false;
        }
        this.i.setMinimumHeight(max);
        return true;
    }

    private void m(CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            if (z) {
                androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            }
            if (z2) {
                androidx.core.graphics.drawable.a.p(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private void m0(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
        Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
        androidx.core.graphics.drawable.a.o(mutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(mutate);
    }

    private void n() {
        m(this.U, this.W, this.V, this.b0, this.a0);
    }

    private void n0() {
        if (this.J != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1189e.getLayoutParams();
            int u = u();
            if (u != layoutParams.topMargin) {
                layoutParams.topMargin = u;
                this.f1189e.requestLayout();
            }
        }
    }

    private void o() {
        int i = this.J;
        if (i == 0) {
            this.F = null;
        } else if (i == 1) {
            this.F = new d.a.a.a.z.g(this.H);
            this.G = new d.a.a.a.z.g();
            return;
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(this.J + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            this.F = (!this.C || (this.F instanceof com.google.android.material.textfield.c)) ? new d.a.a.a.z.g(this.H) : new com.google.android.material.textfield.c(this.H);
        }
        this.G = null;
    }

    private int p() {
        return this.J == 1 ? d.a.a.a.q.a.e(d.a.a.a.q.a.d(this, d.a.a.a.b.colorSurface, 0), this.P) : this.P;
    }

    private void p0(boolean z, boolean z2) {
        ColorStateList colorStateList;
        com.google.android.material.internal.a aVar;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.i;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.i;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean k = this.k.k();
        ColorStateList colorStateList2 = this.v0;
        if (colorStateList2 != null) {
            this.H0.K(colorStateList2);
            this.H0.R(this.v0);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.v0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.F0) : this.F0;
            this.H0.K(ColorStateList.valueOf(colorForState));
            this.H0.R(ColorStateList.valueOf(colorForState));
        } else if (k) {
            this.H0.K(this.k.p());
        } else {
            if (this.n && (textView = this.o) != null) {
                aVar = this.H0;
                colorStateList = textView.getTextColors();
            } else if (z4 && (colorStateList = this.w0) != null) {
                aVar = this.H0;
            }
            aVar.K(colorStateList);
        }
        if (z3 || (isEnabled() && (z4 || k))) {
            if (z2 || this.G0) {
                y(z);
                return;
            }
            return;
        }
        if (z2 || !this.G0) {
            E(z);
        }
    }

    private Rect q(Rect rect) {
        int i;
        int i2;
        if (this.i == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.R;
        boolean z = s.y(this) == 1;
        rect2.bottom = rect.bottom;
        int i3 = this.J;
        if (i3 == 1) {
            rect2.left = F(rect.left, z);
            i = rect.top + this.K;
        } else {
            if (i3 == 2) {
                rect2.left = rect.left + this.i.getPaddingLeft();
                rect2.top = rect.top - u();
                i2 = rect.right - this.i.getPaddingRight();
                rect2.right = i2;
                return rect2;
            }
            rect2.left = F(rect.left, z);
            i = getPaddingTop();
        }
        rect2.top = i;
        i2 = G(rect.right, z);
        rect2.right = i2;
        return rect2;
    }

    private void q0() {
        EditText editText;
        if (this.t == null || (editText = this.i) == null) {
            return;
        }
        this.t.setGravity(editText.getGravity());
        this.t.setPadding(this.i.getCompoundPaddingLeft(), this.i.getCompoundPaddingTop(), this.i.getCompoundPaddingRight(), this.i.getCompoundPaddingBottom());
    }

    private int r(Rect rect, Rect rect2, float f2) {
        return O() ? (int) (rect2.top + f2) : rect.bottom - this.i.getCompoundPaddingBottom();
    }

    private void r0() {
        EditText editText = this.i;
        s0(editText == null ? 0 : editText.getText().length());
    }

    private int s(Rect rect, float f2) {
        return O() ? (int) (rect.centerY() - (f2 / 2.0f)) : rect.top + this.i.getCompoundPaddingTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(int i) {
        if (i != 0 || this.G0) {
            I();
        } else {
            c0();
        }
    }

    private void setEditText(EditText editText) {
        if (this.i != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.g0 != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.i = editText;
        Q();
        setTextInputAccessibilityDelegate(new e(this));
        this.H0.b0(this.i.getTypeface());
        this.H0.T(this.i.getTextSize());
        int gravity = this.i.getGravity();
        this.H0.L((gravity & (-113)) | 48);
        this.H0.S(gravity);
        this.i.addTextChangedListener(new a());
        if (this.v0 == null) {
            this.v0 = this.i.getHintTextColors();
        }
        if (this.C) {
            if (TextUtils.isEmpty(this.D)) {
                CharSequence hint = this.i.getHint();
                this.j = hint;
                setHint(hint);
                this.i.setHint((CharSequence) null);
            }
            this.E = true;
        }
        if (this.o != null) {
            g0(this.i.getText().length());
        }
        k0();
        this.k.e();
        this.f.bringToFront();
        this.g.bringToFront();
        this.h.bringToFront();
        this.t0.bringToFront();
        A();
        t0();
        w0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        p0(false, true);
    }

    private void setErrorIconVisible(boolean z) {
        this.t0.setVisibility(z ? 0 : 8);
        this.h.setVisibility(z ? 8 : 0);
        w0();
        if (H()) {
            return;
        }
        j0();
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.D)) {
            return;
        }
        this.D = charSequence;
        this.H0.Z(charSequence);
        if (this.G0) {
            return;
        }
        R();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.s == z) {
            return;
        }
        if (z) {
            z zVar = new z(getContext());
            this.t = zVar;
            zVar.setId(d.a.a.a.f.textinput_placeholder);
            s.k0(this.t, 1);
            setPlaceholderTextAppearance(this.v);
            setPlaceholderTextColor(this.u);
            g();
        } else {
            T();
            this.t = null;
        }
        this.s = z;
    }

    private Rect t(Rect rect) {
        if (this.i == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.R;
        float u = this.H0.u();
        rect2.left = rect.left + this.i.getCompoundPaddingLeft();
        rect2.top = s(rect, u);
        rect2.right = rect.right - this.i.getCompoundPaddingRight();
        rect2.bottom = r(rect, rect2, u);
        return rect2;
    }

    private void t0() {
        if (this.i == null) {
            return;
        }
        s.v0(this.z, P() ? 0 : s.D(this.i), this.i.getCompoundPaddingTop(), 0, this.i.getCompoundPaddingBottom());
    }

    private int u() {
        float o;
        if (!this.C) {
            return 0;
        }
        int i = this.J;
        if (i == 0 || i == 1) {
            o = this.H0.o();
        } else {
            if (i != 2) {
                return 0;
            }
            o = this.H0.o() / 2.0f;
        }
        return (int) o;
    }

    private void u0() {
        this.z.setVisibility((this.y == null || M()) ? 8 : 0);
        j0();
    }

    private boolean v() {
        return this.J == 2 && w();
    }

    private void v0(boolean z, boolean z2) {
        int defaultColor = this.A0.getDefaultColor();
        int colorForState = this.A0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.A0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z) {
            this.O = colorForState2;
        } else if (z2) {
            this.O = colorForState;
        } else {
            this.O = defaultColor;
        }
    }

    private boolean w() {
        return this.L > -1 && this.O != 0;
    }

    private void w0() {
        if (this.i == null) {
            return;
        }
        s.v0(this.B, 0, this.i.getPaddingTop(), (J() || K()) ? 0 : s.C(this.i), this.i.getPaddingBottom());
    }

    private void x() {
        if (z()) {
            ((com.google.android.material.textfield.c) this.F).l0();
        }
    }

    private void x0() {
        int visibility = this.B.getVisibility();
        boolean z = (this.A == null || M()) ? false : true;
        this.B.setVisibility(z ? 0 : 8);
        if (visibility != this.B.getVisibility()) {
            getEndIconDelegate().c(z);
        }
        j0();
    }

    private void y(boolean z) {
        ValueAnimator valueAnimator = this.J0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.J0.cancel();
        }
        if (z && this.I0) {
            h(1.0f);
        } else {
            this.H0.V(1.0f);
        }
        this.G0 = false;
        if (z()) {
            R();
        }
        r0();
        u0();
        x0();
    }

    private boolean z() {
        return this.C && !TextUtils.isEmpty(this.D) && (this.F instanceof com.google.android.material.textfield.c);
    }

    public boolean J() {
        return this.h.getVisibility() == 0 && this.i0.getVisibility() == 0;
    }

    public boolean L() {
        return this.k.x();
    }

    final boolean M() {
        return this.G0;
    }

    public boolean N() {
        return this.E;
    }

    public boolean P() {
        return this.U.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Y(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.i.n(r3, r4)     // Catch: java.lang.Exception -> L1b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1b
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1b
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1c
        L18:
            r4 = 0
            r0 = 0
            goto L1c
        L1b:
        L1c:
            if (r0 == 0) goto L30
            int r4 = d.a.a.a.j.TextAppearance_AppCompat_Caption
            androidx.core.widget.i.n(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = d.a.a.a.c.design_error
            int r4 = c.f.d.a.a(r4, r0)
            r3.setTextColor(r4)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.Y(android.widget.TextView, int):void");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f1189e.addView(view, layoutParams2);
        this.f1189e.setLayoutParams(layoutParams);
        n0();
        setEditText((EditText) view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText;
        if (this.j == null || (editText = this.i) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        boolean z = this.E;
        this.E = false;
        CharSequence hint = editText.getHint();
        this.i.setHint(this.j);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
        } finally {
            this.i.setHint(hint);
            this.E = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.L0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.L0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        D(canvas);
        C(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.K0) {
            return;
        }
        this.K0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.a aVar = this.H0;
        boolean Y = aVar != null ? aVar.Y(drawableState) | false : false;
        if (this.i != null) {
            o0(s.O(this) && isEnabled());
        }
        k0();
        y0();
        if (Y) {
            invalidate();
        }
        this.K0 = false;
    }

    public void e(f fVar) {
        this.f0.add(fVar);
        if (this.i != null) {
            fVar.a(this);
        }
    }

    public void f(g gVar) {
        this.j0.add(gVar);
    }

    void g0(int i) {
        boolean z = this.n;
        int i2 = this.m;
        if (i2 == -1) {
            this.o.setText(String.valueOf(i));
            this.o.setContentDescription(null);
            this.n = false;
        } else {
            this.n = i > i2;
            h0(getContext(), this.o, i, this.m, this.n);
            if (z != this.n) {
                i0();
            }
            this.o.setText(c.f.j.a.c().j(getContext().getString(d.a.a.a.i.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.m))));
        }
        if (this.i == null || z == this.n) {
            return;
        }
        o0(false);
        y0();
        k0();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.i;
        return editText != null ? editText.getBaseline() + getPaddingTop() + u() : super.getBaseline();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d.a.a.a.z.g getBoxBackground() {
        int i = this.J;
        if (i == 1 || i == 2) {
            return this.F;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.P;
    }

    public int getBoxBackgroundMode() {
        return this.J;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.F.s();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.F.t();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.F.G();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.F.F();
    }

    public int getBoxStrokeColor() {
        return this.z0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.A0;
    }

    public int getBoxStrokeWidth() {
        return this.M;
    }

    public int getBoxStrokeWidthFocused() {
        return this.N;
    }

    public int getCounterMaxLength() {
        return this.m;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.l && this.n && (textView = this.o) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.w;
    }

    public ColorStateList getCounterTextColor() {
        return this.w;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.v0;
    }

    public EditText getEditText() {
        return this.i;
    }

    public CharSequence getEndIconContentDescription() {
        return this.i0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.i0.getDrawable();
    }

    public int getEndIconMode() {
        return this.g0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckableImageButton getEndIconView() {
        return this.i0;
    }

    public CharSequence getError() {
        if (this.k.w()) {
            return this.k.n();
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.k.m();
    }

    public int getErrorCurrentTextColors() {
        return this.k.o();
    }

    public Drawable getErrorIconDrawable() {
        return this.t0.getDrawable();
    }

    final int getErrorTextCurrentColor() {
        return this.k.o();
    }

    public CharSequence getHelperText() {
        if (this.k.x()) {
            return this.k.q();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.k.r();
    }

    public CharSequence getHint() {
        if (this.C) {
            return this.D;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.H0.o();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.H0.r();
    }

    public ColorStateList getHintTextColor() {
        return this.w0;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.i0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.i0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.s) {
            return this.r;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.v;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.u;
    }

    public CharSequence getPrefixText() {
        return this.y;
    }

    public ColorStateList getPrefixTextColor() {
        return this.z.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.z;
    }

    public CharSequence getStartIconContentDescription() {
        return this.U.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.U.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.A;
    }

    public ColorStateList getSuffixTextColor() {
        return this.B.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.B;
    }

    public Typeface getTypeface() {
        return this.T;
    }

    void h(float f2) {
        if (this.H0.v() == f2) {
            return;
        }
        if (this.J0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.J0 = valueAnimator;
            valueAnimator.setInterpolator(d.a.a.a.l.a.f1276b);
            this.J0.setDuration(167L);
            this.J0.addUpdateListener(new d());
        }
        this.J0.setFloatValues(this.H0.v(), f2);
        this.J0.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k0() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText = this.i;
        if (editText == null || this.J != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (e0.a(background)) {
            background = background.mutate();
        }
        if (this.k.k()) {
            currentTextColor = this.k.o();
        } else {
            if (!this.n || (textView = this.o) == null) {
                androidx.core.graphics.drawable.a.c(background);
                this.i.refreshDrawableState();
                return;
            }
            currentTextColor = textView.getCurrentTextColor();
        }
        background.setColorFilter(androidx.appcompat.widget.j.e(currentTextColor, PorterDuff.Mode.SRC_IN));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o0(boolean z) {
        p0(z, false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.i;
        if (editText != null) {
            Rect rect = this.Q;
            com.google.android.material.internal.b.a(this, editText, rect);
            e0(rect);
            if (this.C) {
                this.H0.T(this.i.getTextSize());
                int gravity = this.i.getGravity();
                this.H0.L((gravity & (-113)) | 48);
                this.H0.S(gravity);
                this.H0.H(q(rect));
                this.H0.P(t(rect));
                this.H0.E();
                if (!z() || this.G0) {
                    return;
                }
                R();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        boolean l0 = l0();
        boolean j0 = j0();
        if (l0 || j0) {
            this.i.post(new c());
        }
        q0();
        t0();
        w0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.f());
        setError(hVar.g);
        if (hVar.h) {
            this.i0.post(new b());
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (this.k.k()) {
            hVar.g = getError();
        }
        hVar.h = H() && this.i0.isChecked();
        return hVar;
    }

    public void setBoxBackgroundColor(int i) {
        if (this.P != i) {
            this.P = i;
            this.B0 = i;
            this.D0 = i;
            this.E0 = i;
            i();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(c.f.d.a.a(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.B0 = defaultColor;
        this.P = defaultColor;
        this.C0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.D0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.E0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        i();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.J) {
            return;
        }
        this.J = i;
        if (this.i != null) {
            Q();
        }
    }

    public void setBoxStrokeColor(int i) {
        if (this.z0 != i) {
            this.z0 = i;
            y0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        int defaultColor;
        if (!colorStateList.isStateful()) {
            if (this.z0 != colorStateList.getDefaultColor()) {
                defaultColor = colorStateList.getDefaultColor();
            }
            y0();
        } else {
            this.x0 = colorStateList.getDefaultColor();
            this.F0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.y0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            defaultColor = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        }
        this.z0 = defaultColor;
        y0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.A0 != colorStateList) {
            this.A0 = colorStateList;
            y0();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.M = i;
        y0();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.N = i;
        y0();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.l != z) {
            if (z) {
                z zVar = new z(getContext());
                this.o = zVar;
                zVar.setId(d.a.a.a.f.textinput_counter);
                Typeface typeface = this.T;
                if (typeface != null) {
                    this.o.setTypeface(typeface);
                }
                this.o.setMaxLines(1);
                this.k.d(this.o, 2);
                c.f.l.g.c((ViewGroup.MarginLayoutParams) this.o.getLayoutParams(), getResources().getDimensionPixelOffset(d.a.a.a.d.mtrl_textinput_counter_margin_start));
                i0();
                f0();
            } else {
                this.k.y(this.o, 2);
                this.o = null;
            }
            this.l = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.m != i) {
            if (i <= 0) {
                i = -1;
            }
            this.m = i;
            if (this.l) {
                f0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.p != i) {
            this.p = i;
            i0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.x != colorStateList) {
            this.x = colorStateList;
            i0();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.q != i) {
            this.q = i;
            i0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.w != colorStateList) {
            this.w = colorStateList;
            i0();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.v0 = colorStateList;
        this.w0 = colorStateList;
        if (this.i != null) {
            o0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        S(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.i0.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.i0.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.i0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(int i) {
        setEndIconDrawable(i != 0 ? c.a.k.a.a.d(getContext(), i) : null);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.i0.setImageDrawable(drawable);
    }

    public void setEndIconMode(int i) {
        int i2 = this.g0;
        this.g0 = i;
        B(i2);
        setEndIconVisible(i != 0);
        if (getEndIconDelegate().b(this.J)) {
            getEndIconDelegate().a();
            l();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.J + " is not supported by the end icon mode " + i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        W(this.i0, onClickListener, this.r0);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.r0 = onLongClickListener;
        X(this.i0, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.k0 != colorStateList) {
            this.k0 = colorStateList;
            this.l0 = true;
            l();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.m0 != mode) {
            this.m0 = mode;
            this.n0 = true;
            l();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (J() != z) {
            this.i0.setVisibility(z ? 0 : 8);
            w0();
            j0();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.k.w()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.k.s();
        } else {
            this.k.L(charSequence);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.k.A(charSequence);
    }

    public void setErrorEnabled(boolean z) {
        this.k.B(z);
    }

    public void setErrorIconDrawable(int i) {
        setErrorIconDrawable(i != 0 ? c.a.k.a.a.d(getContext(), i) : null);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.t0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.k.w());
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        W(this.t0, onClickListener, this.s0);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.s0 = onLongClickListener;
        X(this.t0, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.u0 = colorStateList;
        Drawable drawable = this.t0.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        }
        if (this.t0.getDrawable() != drawable) {
            this.t0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.t0.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            androidx.core.graphics.drawable.a.p(drawable, mode);
        }
        if (this.t0.getDrawable() != drawable) {
            this.t0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i) {
        this.k.C(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.k.D(colorStateList);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (L()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!L()) {
                setHelperTextEnabled(true);
            }
            this.k.M(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.k.G(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.k.F(z);
    }

    public void setHelperTextTextAppearance(int i) {
        this.k.E(i);
    }

    public void setHint(CharSequence charSequence) {
        if (this.C) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.I0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.C) {
            this.C = z;
            if (z) {
                CharSequence hint = this.i.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.D)) {
                        setHint(hint);
                    }
                    this.i.setHint((CharSequence) null);
                }
                this.E = true;
            } else {
                this.E = false;
                if (!TextUtils.isEmpty(this.D) && TextUtils.isEmpty(this.i.getHint())) {
                    this.i.setHint(this.D);
                }
                setHintInternal(null);
            }
            if (this.i != null) {
                n0();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.H0.I(i);
        this.w0 = this.H0.n();
        if (this.i != null) {
            o0(false);
            n0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.w0 != colorStateList) {
            if (this.v0 == null) {
                this.H0.K(colorStateList);
            }
            this.w0 = colorStateList;
            if (this.i != null) {
                o0(false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.i0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? c.a.k.a.a.d(getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.i0.setImageDrawable(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.g0 != 1) {
            setEndIconMode(1);
        } else {
            if (z) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.k0 = colorStateList;
        this.l0 = true;
        l();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.m0 = mode;
        this.n0 = true;
        l();
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.s && TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.s) {
                setPlaceholderTextEnabled(true);
            }
            this.r = charSequence;
        }
        r0();
    }

    public void setPlaceholderTextAppearance(int i) {
        this.v = i;
        TextView textView = this.t;
        if (textView != null) {
            androidx.core.widget.i.n(textView, i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.u != colorStateList) {
            this.u = colorStateList;
            TextView textView = this.t;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.y = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.z.setText(charSequence);
        u0();
    }

    public void setPrefixTextAppearance(int i) {
        androidx.core.widget.i.n(this.z, i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.z.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.U.setCheckable(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.U.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? c.a.k.a.a.d(getContext(), i) : null);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.U.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            n();
        } else {
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription((CharSequence) null);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        W(this.U, onClickListener, this.e0);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.e0 = onLongClickListener;
        X(this.U, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            this.W = true;
            n();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.a0 != mode) {
            this.a0 = mode;
            this.b0 = true;
            n();
        }
    }

    public void setStartIconVisible(boolean z) {
        if (P() != z) {
            this.U.setVisibility(z ? 0 : 8);
            t0();
            j0();
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.A = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.B.setText(charSequence);
        x0();
    }

    public void setSuffixTextAppearance(int i) {
        androidx.core.widget.i.n(this.B, i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.B.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.i;
        if (editText != null) {
            s.i0(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.T) {
            this.T = typeface;
            this.H0.b0(typeface);
            this.k.I(typeface);
            TextView textView = this.o;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void y0() {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.y0():void");
    }
}
