package c.f.i;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import c.f.d.c.f;
import c.f.e.k;
import c.f.i.c;
import c.f.k.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class b {
    static final c.d.e<String, Typeface> a = new c.d.e<>(16);

    /* renamed from: b, reason: collision with root package name */
    private static final c.f.i.c f733b = new c.f.i.c("fonts", 10, 10000);

    /* renamed from: c, reason: collision with root package name */
    static final Object f734c = new Object();

    /* renamed from: d, reason: collision with root package name */
    static final c.d.g<String, ArrayList<c.d<g>>> f735d = new c.d.g<>();

    /* renamed from: e, reason: collision with root package name */
    private static final Comparator<byte[]> f736e = new d();

    /* loaded from: classes.dex */
    class a implements Callable<g> {
        final /* synthetic */ Context a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c.f.i.a f737b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f738c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f739d;

        a(Context context, c.f.i.a aVar, int i, String str) {
            this.a = context;
            this.f737b = aVar;
            this.f738c = i;
            this.f739d = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g call() {
            g f = b.f(this.a, this.f737b, this.f738c);
            Typeface typeface = f.a;
            if (typeface != null) {
                b.a.d(this.f739d, typeface);
            }
            return f;
        }
    }

    /* renamed from: c.f.i.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0030b implements c.d<g> {
        final /* synthetic */ f.a a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Handler f740b;

        C0030b(f.a aVar, Handler handler) {
            this.a = aVar;
            this.f740b = handler;
        }

        @Override // c.f.i.c.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g gVar) {
            int i;
            f.a aVar;
            if (gVar == null) {
                aVar = this.a;
                i = 1;
            } else {
                i = gVar.f746b;
                if (i == 0) {
                    this.a.b(gVar.a, this.f740b);
                    return;
                }
                aVar = this.a;
            }
            aVar.a(i, this.f740b);
        }
    }

    /* loaded from: classes.dex */
    class c implements c.d<g> {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // c.f.i.c.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g gVar) {
            synchronized (b.f734c) {
                ArrayList<c.d<g>> arrayList = b.f735d.get(this.a);
                if (arrayList == null) {
                    return;
                }
                b.f735d.remove(this.a);
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i).a(gVar);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements Comparator<byte[]> {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            int i;
            int i2;
            if (bArr.length == bArr2.length) {
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    if (bArr[i3] != bArr2[i3]) {
                        i = bArr[i3];
                        i2 = bArr2[i3];
                    }
                }
                return 0;
            }
            i = bArr.length;
            i2 = bArr2.length;
            return i - i2;
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        private final int a;

        /* renamed from: b, reason: collision with root package name */
        private final f[] f741b;

        public e(int i, f[] fVarArr) {
            this.a = i;
            this.f741b = fVarArr;
        }

        public f[] a() {
            return this.f741b;
        }

        public int b() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        private final Uri a;

        /* renamed from: b, reason: collision with root package name */
        private final int f742b;

        /* renamed from: c, reason: collision with root package name */
        private final int f743c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f744d;

        /* renamed from: e, reason: collision with root package name */
        private final int f745e;

        public f(Uri uri, int i, int i2, boolean z, int i3) {
            h.c(uri);
            this.a = uri;
            this.f742b = i;
            this.f743c = i2;
            this.f744d = z;
            this.f745e = i3;
        }

        public int a() {
            return this.f745e;
        }

        public int b() {
            return this.f742b;
        }

        public Uri c() {
            return this.a;
        }

        public int d() {
            return this.f743c;
        }

        public boolean e() {
            return this.f744d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class g {
        final Typeface a;

        /* renamed from: b, reason: collision with root package name */
        final int f746b;

        g(Typeface typeface, int i) {
            this.a = typeface;
            this.f746b = i;
        }
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean b(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static e c(Context context, CancellationSignal cancellationSignal, c.f.i.a aVar) {
        ProviderInfo h = h(context.getPackageManager(), aVar, context.getResources());
        return h == null ? new e(1, null) : new e(0, e(context, aVar, h.authority, cancellationSignal));
    }

    private static List<List<byte[]>> d(c.f.i.a aVar, Resources resources) {
        return aVar.a() != null ? aVar.a() : c.f.d.c.c.c(resources, aVar.b());
    }

    static f[] e(Context context, c.f.i.a aVar, String str, CancellationSignal cancellationSignal) {
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            cursor = Build.VERSION.SDK_INT > 16 ? context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, null, cancellationSignal) : context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, null);
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    arrayList2.add(new f(columnIndex3 == -1 ? ContentUris.withAppendedId(build, cursor.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3)), columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i));
                }
                arrayList = arrayList2;
            }
            return (f[]) arrayList.toArray(new f[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    static g f(Context context, c.f.i.a aVar, int i) {
        try {
            e c2 = c(context, null, aVar);
            if (c2.b() != 0) {
                return new g(null, c2.b() == 1 ? -2 : -3);
            }
            Typeface b2 = c.f.e.d.b(context, null, c2.a(), i);
            return new g(b2, b2 != null ? 0 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new g(null, -1);
        }
    }

    public static Typeface g(Context context, c.f.i.a aVar, f.a aVar2, Handler handler, boolean z, int i, int i2) {
        String str = aVar.c() + "-" + i2;
        Typeface c2 = a.c(str);
        if (c2 != null) {
            if (aVar2 != null) {
                aVar2.d(c2);
            }
            return c2;
        }
        if (z && i == -1) {
            g f2 = f(context, aVar, i2);
            if (aVar2 != null) {
                int i3 = f2.f746b;
                if (i3 == 0) {
                    aVar2.b(f2.a, handler);
                } else {
                    aVar2.a(i3, handler);
                }
            }
            return f2.a;
        }
        a aVar3 = new a(context, aVar, i2, str);
        if (z) {
            try {
                return ((g) f733b.e(aVar3, i)).a;
            } catch (InterruptedException unused) {
                return null;
            }
        }
        C0030b c0030b = aVar2 == null ? null : new C0030b(aVar2, handler);
        synchronized (f734c) {
            ArrayList<c.d<g>> arrayList = f735d.get(str);
            if (arrayList != null) {
                if (c0030b != null) {
                    arrayList.add(c0030b);
                }
                return null;
            }
            if (c0030b != null) {
                ArrayList<c.d<g>> arrayList2 = new ArrayList<>();
                arrayList2.add(c0030b);
                f735d.put(str, arrayList2);
            }
            f733b.d(aVar3, new c(str));
            return null;
        }
    }

    public static ProviderInfo h(PackageManager packageManager, c.f.i.a aVar, Resources resources) {
        String d2 = aVar.d();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(d2, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + d2);
        }
        if (!resolveContentProvider.packageName.equals(aVar.e())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + d2 + ", but package was not " + aVar.e());
        }
        List<byte[]> a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
        Collections.sort(a2, f736e);
        List<List<byte[]>> d3 = d(aVar, resources);
        for (int i = 0; i < d3.size(); i++) {
            ArrayList arrayList = new ArrayList(d3.get(i));
            Collections.sort(arrayList, f736e);
            if (b(a2, arrayList)) {
                return resolveContentProvider;
            }
        }
        return null;
    }

    public static Map<Uri, ByteBuffer> i(Context context, f[] fVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (f fVar : fVarArr) {
            if (fVar.a() == 0) {
                Uri c2 = fVar.c();
                if (!hashMap.containsKey(c2)) {
                    hashMap.put(c2, k.f(context, cancellationSignal, c2));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
