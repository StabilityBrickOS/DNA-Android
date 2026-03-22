package c.f.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import c.f.d.c.c;
import c.f.i.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j {
    private ConcurrentHashMap<Long, c.b> a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements c<b.f> {
        a(j jVar) {
        }

        @Override // c.f.e.j.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(b.f fVar) {
            return fVar.d();
        }

        @Override // c.f.e.j.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(b.f fVar) {
            return fVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements c<c.C0027c> {
        b(j jVar) {
        }

        @Override // c.f.e.j.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(c.C0027c c0027c) {
            return c0027c.e();
        }

        @Override // c.f.e.j.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(c.C0027c c0027c) {
            return c0027c.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c<T> {
        int a(T t);

        boolean b(T t);
    }

    private void a(Typeface typeface, c.b bVar) {
        long j = j(typeface);
        if (j != 0) {
            this.a.put(Long.valueOf(j), bVar);
        }
    }

    private c.C0027c f(c.b bVar, int i) {
        return (c.C0027c) g(bVar.a(), i, new b(this));
    }

    private static <T> T g(T[] tArr, int i, c<T> cVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(cVar.a(t2) - i2) * 2) + (cVar.b(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    private static long j(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        } catch (NoSuchFieldException e3) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e3);
            return 0L;
        }
    }

    public Typeface b(Context context, c.b bVar, Resources resources, int i) {
        c.C0027c f = f(bVar, i);
        if (f == null) {
            return null;
        }
        Typeface d2 = d.d(context, resources, f.b(), f.a(), i);
        a(d2, bVar);
        return d2;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (fVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(h(fVarArr, i).c());
        } catch (IOException unused) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Typeface d2 = d(context, inputStream);
            k.a(inputStream);
            return d2;
        } catch (IOException unused2) {
            k.a(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            k.a(inputStream2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface d(Context context, InputStream inputStream) {
        File e2 = k.e(context);
        if (e2 == null) {
            return null;
        }
        try {
            if (k.d(e2, inputStream)) {
                return Typeface.createFromFile(e2.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e2.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i, String str, int i2) {
        File e2 = k.e(context);
        if (e2 == null) {
            return null;
        }
        try {
            if (k.c(e2, resources, i)) {
                return Typeface.createFromFile(e2.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e2.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b.f h(b.f[] fVarArr, int i) {
        return (b.f) g(fVarArr, i, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c.b i(Typeface typeface) {
        long j = j(typeface);
        if (j == 0) {
            return null;
        }
        return this.a.get(Long.valueOf(j));
    }
}
