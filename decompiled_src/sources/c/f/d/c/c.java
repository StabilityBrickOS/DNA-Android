package c.f.d.c;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    public interface a {
    }

    /* loaded from: classes.dex */
    public static final class b implements a {
        private final C0027c[] a;

        public b(C0027c[] c0027cArr) {
            this.a = c0027cArr;
        }

        public C0027c[] a() {
            return this.a;
        }
    }

    /* renamed from: c.f.d.c.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0027c {
        private final String a;

        /* renamed from: b, reason: collision with root package name */
        private int f703b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f704c;

        /* renamed from: d, reason: collision with root package name */
        private String f705d;

        /* renamed from: e, reason: collision with root package name */
        private int f706e;
        private int f;

        public C0027c(String str, int i, boolean z, String str2, int i2, int i3) {
            this.a = str;
            this.f703b = i;
            this.f704c = z;
            this.f705d = str2;
            this.f706e = i2;
            this.f = i3;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.f;
        }

        public int c() {
            return this.f706e;
        }

        public String d() {
            return this.f705d;
        }

        public int e() {
            return this.f703b;
        }

        public boolean f() {
            return this.f704c;
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements a {
        private final c.f.i.a a;

        /* renamed from: b, reason: collision with root package name */
        private final int f707b;

        /* renamed from: c, reason: collision with root package name */
        private final int f708c;

        public d(c.f.i.a aVar, int i, int i2) {
            this.a = aVar;
            this.f708c = i;
            this.f707b = i2;
        }

        public int a() {
            return this.f708c;
        }

        public c.f.i.a b() {
            return this.a;
        }

        public int c() {
            return this.f707b;
        }
    }

    private static int a(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    public static a b(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> c(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static a d(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static a e(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), c.f.c.FontFamily);
        String string = obtainAttributes.getString(c.f.c.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(c.f.c.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(c.f.c.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(c.f.c.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(c.f.c.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(c.f.c.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new d(new c.f.i.a(string, string2, string3, c(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((C0027c[]) arrayList.toArray(new C0027c[arrayList.size()]));
    }

    private static C0027c f(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), c.f.c.FontFamilyFont);
        int i = obtainAttributes.getInt(obtainAttributes.hasValue(c.f.c.FontFamilyFont_fontWeight) ? c.f.c.FontFamilyFont_fontWeight : c.f.c.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(c.f.c.FontFamilyFont_fontStyle) ? c.f.c.FontFamilyFont_fontStyle : c.f.c.FontFamilyFont_android_fontStyle, 0);
        int i2 = obtainAttributes.hasValue(c.f.c.FontFamilyFont_ttcIndex) ? c.f.c.FontFamilyFont_ttcIndex : c.f.c.FontFamilyFont_android_ttcIndex;
        String string = obtainAttributes.getString(obtainAttributes.hasValue(c.f.c.FontFamilyFont_fontVariationSettings) ? c.f.c.FontFamilyFont_fontVariationSettings : c.f.c.FontFamilyFont_android_fontVariationSettings);
        int i3 = obtainAttributes.getInt(i2, 0);
        int i4 = obtainAttributes.hasValue(c.f.c.FontFamilyFont_font) ? c.f.c.FontFamilyFont_font : c.f.c.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i4, 0);
        String string2 = obtainAttributes.getString(i4);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new C0027c(string2, i, z, string, i3, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
