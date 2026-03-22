package e.k;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends y {
    public static final <K, V> Map<K, V> d() {
        t tVar = t.INSTANCE;
        if (tVar != null) {
            return tVar;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> e(Map<K, ? extends V> map) {
        e.p.d.i.d(map, "$this$optimizeReadOnlyMap");
        int size = map.size();
        return size != 0 ? size != 1 ? map : y.c(map) : d();
    }

    public static final <K, V> void f(Map<? super K, ? super V> map, Iterable<? extends e.e<? extends K, ? extends V>> iterable) {
        e.p.d.i.d(map, "$this$putAll");
        e.p.d.i.d(iterable, "pairs");
        for (e.e<? extends K, ? extends V> eVar : iterable) {
            map.put(eVar.component1(), eVar.component2());
        }
    }

    public static <K, V> Map<K, V> g(Iterable<? extends e.e<? extends K, ? extends V>> iterable) {
        e.p.d.i.d(iterable, "$this$toMap");
        if (!(iterable instanceof Collection)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            h(iterable, linkedHashMap);
            return e(linkedHashMap);
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return d();
        }
        if (size == 1) {
            return y.b(iterable instanceof List ? (e.e<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(w.a(collection.size()));
        h(iterable, linkedHashMap2);
        return linkedHashMap2;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M h(Iterable<? extends e.e<? extends K, ? extends V>> iterable, M m) {
        e.p.d.i.d(iterable, "$this$toMap");
        e.p.d.i.d(m, "destination");
        f(m, iterable);
        return m;
    }
}
