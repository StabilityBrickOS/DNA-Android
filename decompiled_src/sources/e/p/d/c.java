package e.p.d;

import e.k.y;
import e.k.z;
import e.p.c.s;
import e.p.c.t;
import e.p.c.u;
import e.p.c.v;
import e.p.c.w;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class c implements e.s.c<Object>, b {
    private static final Map<Class<? extends e.c<?>>, Integer> f;
    private static final HashMap<String, String> g;
    private static final HashMap<String, String> h;
    private static final HashMap<String, String> i;

    /* renamed from: e, reason: collision with root package name */
    private final Class<?> f1540e;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List d2;
        int g2;
        Map<Class<? extends e.c<?>>, Integer> g3;
        int a;
        String M;
        String M2;
        int i2 = 0;
        d2 = e.k.i.d(e.p.c.a.class, e.p.c.l.class, e.p.c.p.class, e.p.c.q.class, e.p.c.r.class, s.class, t.class, u.class, v.class, w.class, e.p.c.b.class, e.p.c.c.class, e.p.c.d.class, e.p.c.e.class, e.p.c.f.class, e.p.c.g.class, e.p.c.h.class, e.p.c.i.class, e.p.c.j.class, e.p.c.k.class, e.p.c.m.class, e.p.c.n.class, e.p.c.o.class);
        g2 = e.k.j.g(d2, 10);
        ArrayList arrayList = new ArrayList(g2);
        for (Object obj : d2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                e.k.g.f();
                throw null;
            }
            arrayList.add(e.h.a((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        g3 = z.g(arrayList);
        f = g3;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        g = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        h = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(g);
        hashMap3.putAll(h);
        Collection<String> values = g.values();
        i.c(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            i.c(str, "kotlinName");
            M2 = e.u.v.M(str, '.', null, 2, null);
            sb.append(M2);
            sb.append("CompanionObject");
            e.e a2 = e.h.a(sb.toString(), str + ".Companion");
            hashMap3.put(a2.getFirst(), a2.getSecond());
        }
        for (Map.Entry<Class<? extends e.c<?>>, Integer> entry : f.entrySet()) {
            Class<? extends e.c<?>> key = entry.getKey();
            int intValue = entry.getValue().intValue();
            hashMap3.put(key.getName(), "kotlin.Function" + intValue);
        }
        i = hashMap3;
        a = y.a(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(a);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key2 = entry2.getKey();
            M = e.u.v.M((String) entry2.getValue(), '.', null, 2, null);
            linkedHashMap.put(key2, M);
        }
    }

    public c(Class<?> cls) {
        i.d(cls, "jClass");
        this.f1540e = cls;
    }

    private final Void b() {
        throw new e.p.b();
    }

    @Override // e.p.d.b
    public Class<?> a() {
        return this.f1540e;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && i.a(e.p.a.a(this), e.p.a.a((e.s.c) obj));
    }

    @Override // e.s.a
    public List<Annotation> getAnnotations() {
        b();
        throw null;
    }

    public int hashCode() {
        return e.p.a.a(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
