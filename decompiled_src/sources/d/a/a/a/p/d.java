package d.a.a.a.p;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* loaded from: classes.dex */
public interface d {

    /* loaded from: classes.dex */
    public static class b implements TypeEvaluator<e> {

        /* renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator<e> f1291b = new b();
        private final e a = new e();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f, e eVar, e eVar2) {
            this.a.a(d.a.a.a.u.a.c(eVar.a, eVar2.a, f), d.a.a.a.u.a.c(eVar.f1292b, eVar2.f1292b, f), d.a.a.a.u.a.c(eVar.f1293c, eVar2.f1293c, f));
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Property<d, e> {
        public static final Property<d, e> a = new c("circularReveal");

        private c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(d dVar) {
            return dVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, e eVar) {
            dVar.setRevealInfo(eVar);
        }
    }

    /* renamed from: d.a.a.a.p.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0088d extends Property<d, Integer> {
        public static final Property<d, Integer> a = new C0088d("circularRevealScrimColor");

        private C0088d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public float a;

        /* renamed from: b, reason: collision with root package name */
        public float f1292b;

        /* renamed from: c, reason: collision with root package name */
        public float f1293c;

        private e() {
        }

        public e(float f, float f2, float f3) {
            this.a = f;
            this.f1292b = f2;
            this.f1293c = f3;
        }

        public void a(float f, float f2, float f3) {
            this.a = f;
            this.f1292b = f2;
            this.f1293c = f3;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(e eVar);
}
