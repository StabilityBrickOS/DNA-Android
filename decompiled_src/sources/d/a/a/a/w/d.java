package d.a.a.a.w;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import c.f.d.c.f;
import d.a.a.a.k;

/* loaded from: classes.dex */
public class d {
    public final float a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f1301b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1302c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1303d;

    /* renamed from: e, reason: collision with root package name */
    public final String f1304e;
    public final ColorStateList f;
    public final float g;
    public final float h;
    public final float i;
    private final int j;
    private boolean k = false;
    private Typeface l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends f.a {
        final /* synthetic */ f a;

        a(f fVar) {
            this.a = fVar;
        }

        @Override // c.f.d.c.f.a
        public void c(int i) {
            d.this.k = true;
            this.a.a(i);
        }

        @Override // c.f.d.c.f.a
        public void d(Typeface typeface) {
            d dVar = d.this;
            dVar.l = Typeface.create(typeface, dVar.f1302c);
            d.this.k = true;
            this.a.b(d.this.l, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends f {
        final /* synthetic */ TextPaint a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f1306b;

        b(TextPaint textPaint, f fVar) {
            this.a = textPaint;
            this.f1306b = fVar;
        }

        @Override // d.a.a.a.w.f
        public void a(int i) {
            this.f1306b.a(i);
        }

        @Override // d.a.a.a.w.f
        public void b(Typeface typeface, boolean z) {
            d.this.k(this.a, typeface);
            this.f1306b.b(typeface, z);
        }
    }

    public d(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, k.TextAppearance);
        this.a = obtainStyledAttributes.getDimension(k.TextAppearance_android_textSize, 0.0f);
        this.f1301b = c.a(context, obtainStyledAttributes, k.TextAppearance_android_textColor);
        c.a(context, obtainStyledAttributes, k.TextAppearance_android_textColorHint);
        c.a(context, obtainStyledAttributes, k.TextAppearance_android_textColorLink);
        this.f1302c = obtainStyledAttributes.getInt(k.TextAppearance_android_textStyle, 0);
        this.f1303d = obtainStyledAttributes.getInt(k.TextAppearance_android_typeface, 1);
        int e2 = c.e(obtainStyledAttributes, k.TextAppearance_fontFamily, k.TextAppearance_android_fontFamily);
        this.j = obtainStyledAttributes.getResourceId(e2, 0);
        this.f1304e = obtainStyledAttributes.getString(e2);
        obtainStyledAttributes.getBoolean(k.TextAppearance_textAllCaps, false);
        this.f = c.a(context, obtainStyledAttributes, k.TextAppearance_android_shadowColor);
        this.g = obtainStyledAttributes.getFloat(k.TextAppearance_android_shadowDx, 0.0f);
        this.h = obtainStyledAttributes.getFloat(k.TextAppearance_android_shadowDy, 0.0f);
        this.i = obtainStyledAttributes.getFloat(k.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private void d() {
        String str;
        if (this.l == null && (str = this.f1304e) != null) {
            this.l = Typeface.create(str, this.f1302c);
        }
        if (this.l == null) {
            int i = this.f1303d;
            this.l = i != 1 ? i != 2 ? i != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            this.l = Typeface.create(this.l, this.f1302c);
        }
    }

    public Typeface e() {
        d();
        return this.l;
    }

    public Typeface f(Context context) {
        if (this.k) {
            return this.l;
        }
        if (!context.isRestricted()) {
            try {
                Typeface b2 = c.f.d.c.f.b(context, this.j);
                this.l = b2;
                if (b2 != null) {
                    this.l = Typeface.create(b2, this.f1302c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e2) {
                Log.d("TextAppearance", "Error loading font " + this.f1304e, e2);
            }
        }
        d();
        this.k = true;
        return this.l;
    }

    public void g(Context context, TextPaint textPaint, f fVar) {
        k(textPaint, e());
        h(context, new b(textPaint, fVar));
    }

    public void h(Context context, f fVar) {
        if (e.a()) {
            f(context);
        } else {
            d();
        }
        if (this.j == 0) {
            this.k = true;
        }
        if (this.k) {
            fVar.b(this.l, true);
            return;
        }
        try {
            c.f.d.c.f.d(context, this.j, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.k = true;
            fVar.a(1);
        } catch (Exception e2) {
            Log.d("TextAppearance", "Error loading font " + this.f1304e, e2);
            this.k = true;
            fVar.a(-3);
        }
    }

    public void i(Context context, TextPaint textPaint, f fVar) {
        j(context, textPaint, fVar);
        ColorStateList colorStateList = this.f1301b;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f = this.i;
        float f2 = this.g;
        float f3 = this.h;
        ColorStateList colorStateList2 = this.f;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void j(Context context, TextPaint textPaint, f fVar) {
        if (e.a()) {
            k(textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void k(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i = (~typeface.getStyle()) & this.f1302c;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.a);
    }
}
