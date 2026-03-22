package c.m.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import c.f.e.c;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class h extends c.m.a.a.g {
    static final PorterDuff.Mode n = PorterDuff.Mode.SRC_IN;
    private C0050h f;
    private PorterDuffColorFilter g;
    private ColorFilter h;
    private boolean i;
    private boolean j;
    private final float[] k;
    private final Matrix l;
    private final Rect m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends f {
        b() {
        }

        b(b bVar) {
            super(bVar);
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f924b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.a = c.f.e.c.d(string2);
            }
            this.f925c = c.f.d.c.g.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // c.m.a.a.h.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (c.f.d.c.g.j(xmlPullParser, "pathData")) {
                TypedArray k = c.f.d.c.g.k(resources, theme, attributeSet, c.m.a.a.a.f910d);
                f(k, xmlPullParser);
                k.recycle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        private int[] f919e;
        c.f.d.c.b f;
        float g;
        c.f.d.c.b h;
        float i;
        float j;
        float k;
        float l;
        float m;
        Paint.Cap n;
        Paint.Join o;
        float p;

        c() {
            this.g = 0.0f;
            this.i = 1.0f;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        c(c cVar) {
            super(cVar);
            this.g = 0.0f;
            this.i = 1.0f;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.f919e = cVar.f919e;
            this.f = cVar.f;
            this.g = cVar.g;
            this.i = cVar.i;
            this.h = cVar.h;
            this.f925c = cVar.f925c;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }

        private Paint.Cap e(int i, Paint.Cap cap) {
            return i != 0 ? i != 1 ? i != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join f(int i, Paint.Join join) {
            return i != 0 ? i != 1 ? i != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f919e = null;
            if (c.f.d.c.g.j(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f924b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.a = c.f.e.c.d(string2);
                }
                this.h = c.f.d.c.g.e(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.j = c.f.d.c.g.f(typedArray, xmlPullParser, "fillAlpha", 12, this.j);
                this.n = e(c.f.d.c.g.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = f(c.f.d.c.g.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = c.f.d.c.g.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.f = c.f.d.c.g.e(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.i = c.f.d.c.g.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.i);
                this.g = c.f.d.c.g.f(typedArray, xmlPullParser, "strokeWidth", 4, this.g);
                this.l = c.f.d.c.g.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
                this.m = c.f.d.c.g.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.k = c.f.d.c.g.f(typedArray, xmlPullParser, "trimPathStart", 5, this.k);
                this.f925c = c.f.d.c.g.g(typedArray, xmlPullParser, "fillType", 13, this.f925c);
            }
        }

        @Override // c.m.a.a.h.e
        public boolean a() {
            return this.h.i() || this.f.i();
        }

        @Override // c.m.a.a.h.e
        public boolean b(int[] iArr) {
            return this.f.j(iArr) | this.h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k = c.f.d.c.g.k(resources, theme, attributeSet, c.m.a.a.a.f909c);
            h(k, xmlPullParser, theme);
            k.recycle();
        }

        float getFillAlpha() {
            return this.j;
        }

        int getFillColor() {
            return this.h.e();
        }

        float getStrokeAlpha() {
            return this.i;
        }

        int getStrokeColor() {
            return this.f.e();
        }

        float getStrokeWidth() {
            return this.g;
        }

        float getTrimPathEnd() {
            return this.l;
        }

        float getTrimPathOffset() {
            return this.m;
        }

        float getTrimPathStart() {
            return this.k;
        }

        void setFillAlpha(float f) {
            this.j = f;
        }

        void setFillColor(int i) {
            this.h.k(i);
        }

        void setStrokeAlpha(float f) {
            this.i = f;
        }

        void setStrokeColor(int i) {
            this.f.k(i);
        }

        void setStrokeWidth(float f) {
            this.g = f;
        }

        void setTrimPathEnd(float f) {
            this.l = f;
        }

        void setTrimPathOffset(float f) {
            this.m = f;
        }

        void setTrimPathStart(float f) {
            this.k = f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends e {
        final Matrix a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList<e> f920b;

        /* renamed from: c, reason: collision with root package name */
        float f921c;

        /* renamed from: d, reason: collision with root package name */
        private float f922d;

        /* renamed from: e, reason: collision with root package name */
        private float f923e;
        private float f;
        private float g;
        private float h;
        private float i;
        final Matrix j;
        int k;
        private int[] l;
        private String m;

        public d() {
            super();
            this.a = new Matrix();
            this.f920b = new ArrayList<>();
            this.f921c = 0.0f;
            this.f922d = 0.0f;
            this.f923e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }

        public d(d dVar, c.d.a<String, Object> aVar) {
            super();
            f bVar;
            this.a = new Matrix();
            this.f920b = new ArrayList<>();
            this.f921c = 0.0f;
            this.f922d = 0.0f;
            this.f923e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
            this.f921c = dVar.f921c;
            this.f922d = dVar.f922d;
            this.f923e = dVar.f923e;
            this.f = dVar.f;
            this.g = dVar.g;
            this.h = dVar.h;
            this.i = dVar.i;
            this.l = dVar.l;
            String str = dVar.m;
            this.m = str;
            this.k = dVar.k;
            if (str != null) {
                aVar.put(str, this);
            }
            this.j.set(dVar.j);
            ArrayList<e> arrayList = dVar.f920b;
            for (int i = 0; i < arrayList.size(); i++) {
                e eVar = arrayList.get(i);
                if (eVar instanceof d) {
                    this.f920b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else {
                        if (!(eVar instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) eVar);
                    }
                    this.f920b.add(bVar);
                    String str2 = bVar.f924b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        private void d() {
            this.j.reset();
            this.j.postTranslate(-this.f922d, -this.f923e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.f921c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.f922d, this.i + this.f923e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f921c = c.f.d.c.g.f(typedArray, xmlPullParser, "rotation", 5, this.f921c);
            this.f922d = typedArray.getFloat(1, this.f922d);
            this.f923e = typedArray.getFloat(2, this.f923e);
            this.f = c.f.d.c.g.f(typedArray, xmlPullParser, "scaleX", 3, this.f);
            this.g = c.f.d.c.g.f(typedArray, xmlPullParser, "scaleY", 4, this.g);
            this.h = c.f.d.c.g.f(typedArray, xmlPullParser, "translateX", 6, this.h);
            this.i = c.f.d.c.g.f(typedArray, xmlPullParser, "translateY", 7, this.i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            d();
        }

        @Override // c.m.a.a.h.e
        public boolean a() {
            for (int i = 0; i < this.f920b.size(); i++) {
                if (this.f920b.get(i).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // c.m.a.a.h.e
        public boolean b(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.f920b.size(); i++) {
                z |= this.f920b.get(i).b(iArr);
            }
            return z;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k = c.f.d.c.g.k(resources, theme, attributeSet, c.m.a.a.a.f908b);
            e(k, xmlPullParser);
            k.recycle();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.f922d;
        }

        public float getPivotY() {
            return this.f923e;
        }

        public float getRotation() {
            return this.f921c;
        }

        public float getScaleX() {
            return this.f;
        }

        public float getScaleY() {
            return this.g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f) {
            if (f != this.f922d) {
                this.f922d = f;
                d();
            }
        }

        public void setPivotY(float f) {
            if (f != this.f923e) {
                this.f923e = f;
                d();
            }
        }

        public void setRotation(float f) {
            if (f != this.f921c) {
                this.f921c = f;
                d();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f) {
                this.f = f;
                d();
            }
        }

        public void setScaleY(float f) {
            if (f != this.g) {
                this.g = f;
                d();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.h) {
                this.h = f;
                d();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.i) {
                this.i = f;
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class f extends e {
        protected c.b[] a;

        /* renamed from: b, reason: collision with root package name */
        String f924b;

        /* renamed from: c, reason: collision with root package name */
        int f925c;

        /* renamed from: d, reason: collision with root package name */
        int f926d;

        public f() {
            super();
            this.a = null;
            this.f925c = 0;
        }

        public f(f fVar) {
            super();
            this.a = null;
            this.f925c = 0;
            this.f924b = fVar.f924b;
            this.f926d = fVar.f926d;
            this.a = c.f.e.c.f(fVar.a);
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            c.b[] bVarArr = this.a;
            if (bVarArr != null) {
                c.b.e(bVarArr, path);
            }
        }

        public c.b[] getPathData() {
            return this.a;
        }

        public String getPathName() {
            return this.f924b;
        }

        public void setPathData(c.b[] bVarArr) {
            if (c.f.e.c.b(this.a, bVarArr)) {
                c.f.e.c.j(this.a, bVarArr);
            } else {
                this.a = c.f.e.c.f(bVarArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final Matrix q = new Matrix();
        private final Path a;

        /* renamed from: b, reason: collision with root package name */
        private final Path f927b;

        /* renamed from: c, reason: collision with root package name */
        private final Matrix f928c;

        /* renamed from: d, reason: collision with root package name */
        Paint f929d;

        /* renamed from: e, reason: collision with root package name */
        Paint f930e;
        private PathMeasure f;
        private int g;
        final d h;
        float i;
        float j;
        float k;
        float l;
        int m;
        String n;
        Boolean o;
        final c.d.a<String, Object> p;

        public g() {
            this.f928c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new c.d.a<>();
            this.h = new d();
            this.a = new Path();
            this.f927b = new Path();
        }

        public g(g gVar) {
            this.f928c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            c.d.a<String, Object> aVar = new c.d.a<>();
            this.p = aVar;
            this.h = new d(gVar.h, aVar);
            this.a = new Path(gVar.a);
            this.f927b = new Path(gVar.f927b);
            this.i = gVar.i;
            this.j = gVar.j;
            this.k = gVar.k;
            this.l = gVar.l;
            this.g = gVar.g;
            this.m = gVar.m;
            this.n = gVar.n;
            String str = gVar.n;
            if (str != null) {
                this.p.put(str, this);
            }
            this.o = gVar.o;
        }

        private static float a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            dVar.a.set(matrix);
            dVar.a.preConcat(dVar.j);
            canvas.save();
            for (int i3 = 0; i3 < dVar.f920b.size(); i3++) {
                e eVar = dVar.f920b.get(i3);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.a, canvas, i, i2, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.k;
            float f2 = i2 / this.l;
            float min = Math.min(f, f2);
            Matrix matrix = dVar.a;
            this.f928c.set(matrix);
            this.f928c.postScale(f, f2);
            float e2 = e(matrix);
            if (e2 == 0.0f) {
                return;
            }
            fVar.d(this.a);
            Path path = this.a;
            this.f927b.reset();
            if (fVar.c()) {
                this.f927b.setFillType(fVar.f925c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f927b.addPath(path, this.f928c);
                canvas.clipPath(this.f927b);
                return;
            }
            c cVar = (c) fVar;
            if (cVar.k != 0.0f || cVar.l != 1.0f) {
                float f3 = cVar.k;
                float f4 = cVar.m;
                float f5 = (f3 + f4) % 1.0f;
                float f6 = (cVar.l + f4) % 1.0f;
                if (this.f == null) {
                    this.f = new PathMeasure();
                }
                this.f.setPath(this.a, false);
                float length = this.f.getLength();
                float f7 = f5 * length;
                float f8 = f6 * length;
                path.reset();
                if (f7 > f8) {
                    this.f.getSegment(f7, length, path, true);
                    this.f.getSegment(0.0f, f8, path, true);
                } else {
                    this.f.getSegment(f7, f8, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f927b.addPath(path, this.f928c);
            if (cVar.h.l()) {
                c.f.d.c.b bVar = cVar.h;
                if (this.f930e == null) {
                    Paint paint = new Paint(1);
                    this.f930e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f930e;
                if (bVar.h()) {
                    Shader f9 = bVar.f();
                    f9.setLocalMatrix(this.f928c);
                    paint2.setShader(f9);
                    paint2.setAlpha(Math.round(cVar.j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(h.a(bVar.e(), cVar.j));
                }
                paint2.setColorFilter(colorFilter);
                this.f927b.setFillType(cVar.f925c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f927b, paint2);
            }
            if (cVar.f.l()) {
                c.f.d.c.b bVar2 = cVar.f;
                if (this.f929d == null) {
                    Paint paint3 = new Paint(1);
                    this.f929d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f929d;
                Paint.Join join = cVar.o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.p);
                if (bVar2.h()) {
                    Shader f10 = bVar2.f();
                    f10.setLocalMatrix(this.f928c);
                    paint4.setShader(f10);
                    paint4.setAlpha(Math.round(cVar.i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(h.a(bVar2.e(), cVar.i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.g * min * e2);
                canvas.drawPath(this.f927b, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot(fArr[0], fArr[1]);
            float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float a = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max > 0.0f) {
                return Math.abs(a) / max;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            c(this.h, q, canvas, i, i2, colorFilter);
        }

        public boolean f() {
            if (this.o == null) {
                this.o = Boolean.valueOf(this.h.a());
            }
            return this.o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.m;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.m = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c.m.a.a.h$h, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0050h extends Drawable.ConstantState {
        int a;

        /* renamed from: b, reason: collision with root package name */
        g f931b;

        /* renamed from: c, reason: collision with root package name */
        ColorStateList f932c;

        /* renamed from: d, reason: collision with root package name */
        PorterDuff.Mode f933d;

        /* renamed from: e, reason: collision with root package name */
        boolean f934e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public C0050h() {
            this.f932c = null;
            this.f933d = h.n;
            this.f931b = new g();
        }

        public C0050h(C0050h c0050h) {
            this.f932c = null;
            this.f933d = h.n;
            if (c0050h != null) {
                this.a = c0050h.a;
                g gVar = new g(c0050h.f931b);
                this.f931b = gVar;
                if (c0050h.f931b.f930e != null) {
                    gVar.f930e = new Paint(c0050h.f931b.f930e);
                }
                if (c0050h.f931b.f929d != null) {
                    this.f931b.f929d = new Paint(c0050h.f931b.f929d);
                }
                this.f932c = c0050h.f932c;
                this.f933d = c0050h.f933d;
                this.f934e = c0050h.f934e;
            }
        }

        public boolean a(int i, int i2) {
            return i == this.f.getWidth() && i2 == this.f.getHeight();
        }

        public boolean b() {
            return !this.k && this.g == this.f932c && this.h == this.f933d && this.j == this.f934e && this.i == this.f931b.getRootAlpha();
        }

        public void c(int i, int i2) {
            if (this.f == null || !a(i, i2)) {
                this.f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                Paint paint = new Paint();
                this.l = paint;
                paint.setFilterBitmap(true);
            }
            this.l.setAlpha(this.f931b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public boolean f() {
            return this.f931b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f931b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        public boolean h(int[] iArr) {
            boolean g = this.f931b.g(iArr);
            this.k |= g;
            return g;
        }

        public void i() {
            this.g = this.f932c;
            this.h = this.f933d;
            this.i = this.f931b.getRootAlpha();
            this.j = this.f934e;
            this.k = false;
        }

        public void j(int i, int i2) {
            this.f.eraseColor(0);
            this.f931b.b(new Canvas(this.f), i, i2, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new h(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new h(this);
        }
    }

    /* loaded from: classes.dex */
    private static class i extends Drawable.ConstantState {
        private final Drawable.ConstantState a;

        public i(Drawable.ConstantState constantState) {
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
            h hVar = new h();
            hVar.f918e = (VectorDrawable) this.a.newDrawable();
            return hVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            h hVar = new h();
            hVar.f918e = (VectorDrawable) this.a.newDrawable(resources);
            return hVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            h hVar = new h();
            hVar.f918e = (VectorDrawable) this.a.newDrawable(resources, theme);
            return hVar;
        }
    }

    h() {
        this.j = true;
        this.k = new float[9];
        this.l = new Matrix();
        this.m = new Rect();
        this.f = new C0050h();
    }

    h(C0050h c0050h) {
        this.j = true;
        this.k = new float[9];
        this.l = new Matrix();
        this.m = new Rect();
        this.f = c0050h;
        this.g = j(this.g, c0050h.f932c, c0050h.f933d);
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (Color.alpha(i2) * f2)) << 24);
    }

    public static h b(Resources resources, int i2, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            h hVar = new h();
            hVar.f918e = c.f.d.c.f.a(resources, i2, theme);
            new i(hVar.f918e.getConstantState());
            return hVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return c(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static h c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        h hVar = new h();
        hVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return hVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int i2;
        int i3;
        b bVar;
        C0050h c0050h = this.f;
        g gVar = c0050h.f931b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f920b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.p.put(cVar.getPathName(), cVar);
                    }
                    z = false;
                    bVar = cVar;
                } else if ("clip-path".equals(name)) {
                    b bVar2 = new b();
                    bVar2.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f920b.add(bVar2);
                    String pathName = bVar2.getPathName();
                    bVar = bVar2;
                    if (pathName != null) {
                        gVar.p.put(bVar2.getPathName(), bVar2);
                        bVar = bVar2;
                    }
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f920b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.p.put(dVar2.getGroupName(), dVar2);
                    }
                    i2 = c0050h.a;
                    i3 = dVar2.k;
                    c0050h.a = i3 | i2;
                }
                i2 = c0050h.a;
                i3 = bVar.f926d;
                c0050h.a = i3 | i2;
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && androidx.core.graphics.drawable.a.f(this) == 1;
    }

    private static PorterDuff.Mode g(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        C0050h c0050h = this.f;
        g gVar = c0050h.f931b;
        c0050h.f933d = g(c.f.d.c.g.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList c2 = c.f.d.c.g.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (c2 != null) {
            c0050h.f932c = c2;
        }
        c0050h.f934e = c.f.d.c.g.a(typedArray, xmlPullParser, "autoMirrored", 5, c0050h.f934e);
        gVar.k = c.f.d.c.g.f(typedArray, xmlPullParser, "viewportWidth", 7, gVar.k);
        float f2 = c.f.d.c.g.f(typedArray, xmlPullParser, "viewportHeight", 8, gVar.l);
        gVar.l = f2;
        if (gVar.k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f2 <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        gVar.i = typedArray.getDimension(3, gVar.i);
        float dimension = typedArray.getDimension(2, gVar.j);
        gVar.j = dimension;
        if (gVar.i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        gVar.setAlpha(c.f.d.c.g.f(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            gVar.n = string;
            gVar.p.put(string, gVar);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f918e;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object d(String str) {
        return this.f.f931b.p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.m);
        if (this.m.width() <= 0 || this.m.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.h;
        if (colorFilter == null) {
            colorFilter = this.g;
        }
        canvas.getMatrix(this.l);
        this.l.getValues(this.k);
        float abs = Math.abs(this.k[0]);
        float abs2 = Math.abs(this.k[4]);
        float abs3 = Math.abs(this.k[1]);
        float abs4 = Math.abs(this.k[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.m.width() * abs));
        int min2 = Math.min(2048, (int) (this.m.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.m;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.m.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.m.offsetTo(0, 0);
        this.f.c(min, min2);
        if (!this.j) {
            this.f.j(min, min2);
        } else if (!this.f.b()) {
            this.f.j(min, min2);
            this.f.i();
        }
        this.f.d(canvas, colorFilter, this.m);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f918e;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f.f931b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f918e;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f918e;
        return drawable != null ? androidx.core.graphics.drawable.a.e(drawable) : this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f918e != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.f918e.getConstantState());
        }
        this.f.a = getChangingConfigurations();
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f918e;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f.f931b.j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f918e;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f.f931b.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(boolean z) {
        this.j = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0050h c0050h = this.f;
        c0050h.f931b = new g();
        TypedArray k = c.f.d.c.g.k(resources, theme, attributeSet, c.m.a.a.a.a);
        i(k, xmlPullParser, theme);
        k.recycle();
        c0050h.a = getChangingConfigurations();
        c0050h.k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.g = j(this.g, c0050h.f932c, c0050h.f933d);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f918e;
        return drawable != null ? androidx.core.graphics.drawable.a.h(drawable) : this.f.f934e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        C0050h c0050h;
        ColorStateList colorStateList;
        Drawable drawable = this.f918e;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((c0050h = this.f) != null && (c0050h.g() || ((colorStateList = this.f.f932c) != null && colorStateList.isStateful())));
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.i && super.mutate() == this) {
            this.f = new C0050h(this.f);
            this.i = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f918e;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        C0050h c0050h = this.f;
        ColorStateList colorStateList = c0050h.f932c;
        if (colorStateList != null && (mode = c0050h.f933d) != null) {
            this.g = j(this.g, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!c0050h.g() || !c0050h.h(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.f.f931b.getRootAlpha() != i2) {
            this.f.f931b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z);
        } else {
            this.f.f934e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.h = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i2) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            return;
        }
        C0050h c0050h = this.f;
        if (c0050h.f932c != colorStateList) {
            c0050h.f932c = colorStateList;
            this.g = j(this.g, colorStateList, c0050h.f933d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
            return;
        }
        C0050h c0050h = this.f;
        if (c0050h.f933d != mode) {
            c0050h.f933d = mode;
            this.g = j(this.g, c0050h.f932c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f918e;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f918e;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
