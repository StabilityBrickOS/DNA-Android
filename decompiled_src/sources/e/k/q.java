package e.k;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public class q extends p {
    public static <T> List<T> A(Iterable<? extends T> iterable) {
        List<T> e2;
        List<T> b2;
        List<T> a;
        e.p.d.i.d(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            e2 = i.e(B(iterable));
            return e2;
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            b2 = i.b();
            return b2;
        }
        if (size != 1) {
            return C(collection);
        }
        a = h.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        return a;
    }

    public static final <T> List<T> B(Iterable<? extends T> iterable) {
        e.p.d.i.d(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            return C((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        z(iterable, arrayList);
        return arrayList;
    }

    public static final <T> List<T> C(Collection<? extends T> collection) {
        e.p.d.i.d(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }

    public static <T> Set<T> D(Iterable<? extends T> iterable) {
        int a;
        e.p.d.i.d(iterable, "$this$toSet");
        if (!(iterable instanceof Collection)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            z(iterable, linkedHashSet);
            return c0.c(linkedHashSet);
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return c0.b();
        }
        if (size == 1) {
            return b0.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        a = y.a(collection.size());
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(a);
        z(iterable, linkedHashSet2);
        return linkedHashSet2;
    }

    public static <T> boolean l(Iterable<? extends T> iterable, T t) {
        e.p.d.i.d(iterable, "$this$contains");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t) : p(iterable, t) >= 0;
    }

    public static final <T> T m(Iterable<? extends T> iterable) {
        e.p.d.i.d(iterable, "$this$first");
        if (iterable instanceof List) {
            return (T) g.n((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T n(List<? extends T> list) {
        e.p.d.i.d(list, "$this$first");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static <T> T o(List<? extends T> list) {
        e.p.d.i.d(list, "$this$firstOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final <T> int p(Iterable<? extends T> iterable, T t) {
        e.p.d.i.d(iterable, "$this$indexOf");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int i = 0;
        for (T t2 : iterable) {
            if (i < 0) {
                g.f();
                throw null;
            }
            if (e.p.d.i.a(t, t2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A q(Iterable<? extends T> iterable, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, e.p.c.l<? super T, ? extends CharSequence> lVar) {
        e.p.d.i.d(iterable, "$this$joinTo");
        e.p.d.i.d(a, "buffer");
        e.p.d.i.d(charSequence, "separator");
        e.p.d.i.d(charSequence2, "prefix");
        e.p.d.i.d(charSequence3, "postfix");
        e.p.d.i.d(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (T t : iterable) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            e.u.m.a(a, t, lVar);
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    public static final <T> String r(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, e.p.c.l<? super T, ? extends CharSequence> lVar) {
        e.p.d.i.d(iterable, "$this$joinToString");
        e.p.d.i.d(charSequence, "separator");
        e.p.d.i.d(charSequence2, "prefix");
        e.p.d.i.d(charSequence3, "postfix");
        e.p.d.i.d(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        q(iterable, sb, charSequence, charSequence2, charSequence3, i, charSequence4, lVar);
        String sb2 = sb.toString();
        e.p.d.i.c(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static /* synthetic */ String s(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, e.p.c.l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            lVar = null;
        }
        return r(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, lVar);
    }

    public static <T> T t(List<? extends T> list) {
        e.p.d.i.d(list, "$this$last");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(i.c(list));
    }

    public static <T> T u(List<? extends T> list) {
        e.p.d.i.d(list, "$this$lastOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static <T> T v(Iterable<? extends T> iterable) {
        e.p.d.i.d(iterable, "$this$single");
        if (iterable instanceof List) {
            return (T) w((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final <T> T w(List<? extends T> list) {
        e.p.d.i.d(list, "$this$single");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static <T> List<T> x(Iterable<? extends T> iterable, int i) {
        List<T> e2;
        List<T> a;
        List<T> A;
        List<T> b2;
        e.p.d.i.d(iterable, "$this$take");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            b2 = i.b();
            return b2;
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                A = A(iterable);
                return A;
            }
            if (i == 1) {
                a = h.a(m(iterable));
                return a;
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        e2 = i.e(arrayList);
        return e2;
    }

    public static boolean[] y(Collection<Boolean> collection) {
        e.p.d.i.d(collection, "$this$toBooleanArray");
        boolean[] zArr = new boolean[collection.size()];
        Iterator<Boolean> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            zArr[i] = it.next().booleanValue();
            i++;
        }
        return zArr;
    }

    public static final <T, C extends Collection<? super T>> C z(Iterable<? extends T> iterable, C c2) {
        e.p.d.i.d(iterable, "$this$toCollection");
        e.p.d.i.d(c2, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c2.add(it.next());
        }
        return c2;
    }
}
