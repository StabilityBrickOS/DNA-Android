package c.m.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class b extends g implements Animatable {
    private C0049b f;
    private Context g;
    private ArgbEvaluator h;
    final Drawable.Callback i;

    /* loaded from: classes.dex */
    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            b.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c.m.a.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0049b extends Drawable.ConstantState {
        int a;

        /* renamed from: b, reason: collision with root package name */
        h f913b;

        /* renamed from: c, reason: collision with root package name */
        AnimatorSet f914c;

        /* renamed from: d, reason: collision with root package name */
        ArrayList<Animator> f915d;

        /* renamed from: e, reason: collision with root package name */
        c.d.a<Animator, String> f916e;

        public C0049b(Context context, C0049b c0049b, Drawable.Callback callback, Resources resources) {
            if (c0049b != null) {
                this.a = c0049b.a;
                h hVar = c0049b.f913b;
                if (hVar != null) {
                    Drawable.ConstantState constantState = hVar.getConstantState();
                    this.f913b = (h) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    h hVar2 = this.f913b;
                    hVar2.mutate();
                    h hVar3 = hVar2;
                    this.f913b = hVar3;
                    hVar3.setCallback(callback);
                    this.f913b.setBounds(c0049b.f913b.getBounds());
                    this.f913b.h(false);
                }
                ArrayList<Animator> arrayList = c0049b.f915d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f915d = new ArrayList<>(size);
                    this.f916e = new c.d.a<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = c0049b.f915d.get(i);
                        Animator clone = animator.clone();
                        String str = c0049b.f916e.get(animator);
                        clone.setTarget(this.f913b.d(str));
                        this.f915d.add(clone);
                        this.f916e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f914c == null) {
                this.f914c = new AnimatorSet();
            }
            this.f914c.playTogether(this.f915d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    /* loaded from: classes.dex */
    private static class c extends Drawable.ConstantState {
        private final Drawable.ConstantState a;

        public c(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            b bVar = new b();
            Drawable newDrawable = this.a.newDrawable();
            bVar.f918e = newDrawable;
            newDrawable.setCallback(bVar.i);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            b bVar = new b();
            Drawable newDrawable = this.a.newDrawable(resources);
            bVar.f918e = newDrawable;
            newDrawable.setCallback(bVar.i);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b();
            Drawable newDrawable = this.a.newDrawable(resources, theme);
            bVar.f918e = newDrawable;
            newDrawable.setCallback(bVar.i);
            return bVar;
        }
    }

    b() {
        this(null, null, null);
    }

    private b(Context context) {
        this(context, null, null);
    }

    private b(Context context, C0049b c0049b, Resources resources) {
        this.h = null;
        this.i = new a();
        this.g = context;
        if (c0049b != null) {
            this.f = c0049b;
        } else {
            this.f = new C0049b(context, c0049b, this.i, resources);
        }
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    private void b(String str, Animator animator) {
        animator.setTarget(this.f.f913b.d(str));
        if (Build.VERSION.SDK_INT < 21) {
            c(animator);
        }
        C0049b c0049b = this.f;
        if (c0049b.f915d == null) {
            c0049b.f915d = new ArrayList<>();
            this.f.f916e = new c.d.a<>();
        }
        this.f.f915d.add(animator);
        this.f.f916e.put(animator, str);
    }

    private void c(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                c(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.h == null) {
                    this.h = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.h);
            }
        }
    }

    @Override // c.m.a.a.g, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.b(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f.f913b.draw(canvas);
        if (this.f.f914c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f918e;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f.f913b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f918e;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f.a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f918e;
        return drawable != null ? androidx.core.graphics.drawable.a.e(drawable) : this.f.f913b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f918e == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new c(this.f918e.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f918e;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f.f913b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f918e;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f.f913b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f918e;
        return drawable != null ? drawable.getOpacity() : this.f.f913b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainAttributes;
        Drawable drawable = this.f918e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    obtainAttributes = c.f.d.c.g.k(resources, theme, attributeSet, c.m.a.a.a.f911e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        h b2 = h.b(resources, resourceId, theme);
                        b2.h(false);
                        b2.setCallback(this.i);
                        h hVar = this.f.f913b;
                        if (hVar != null) {
                            hVar.setCallback(null);
                        }
                        this.f.f913b = b2;
                    }
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, c.m.a.a.a.f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.g;
                        if (context == null) {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        b(string, d.i(context, resourceId2));
                    }
                } else {
                    continue;
                }
                obtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        this.f.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f918e;
        return drawable != null ? androidx.core.graphics.drawable.a.h(drawable) : this.f.f913b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f918e;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f.f914c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f918e;
        return drawable != null ? drawable.isStateful() : this.f.f913b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f.f913b.setBounds(rect);
        }
    }

    @Override // c.m.a.a.g, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        Drawable drawable = this.f918e;
        return drawable != null ? drawable.setLevel(i) : this.f.f913b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f918e;
        return drawable != null ? drawable.setState(iArr) : this.f.f913b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f.f913b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z);
        } else {
            this.f.f913b.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f.f913b.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i);
        } else {
            this.f.f913b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        } else {
            this.f.f913b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
        } else {
            this.f.f913b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f.f913b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f.f914c.isStarted()) {
                return;
            }
            this.f.f914c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f.f914c.end();
        }
    }
}
