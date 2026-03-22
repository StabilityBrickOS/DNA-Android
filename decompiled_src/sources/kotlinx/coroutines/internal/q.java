package kotlinx.coroutines.internal;

import e.f;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class q {
    private static final String a;

    static {
        Object m266constructorimpl;
        Object m266constructorimpl2;
        try {
            f.a aVar = e.f.Companion;
            m266constructorimpl = e.f.m266constructorimpl(Class.forName("e.m.j.a.a").getCanonicalName());
        } catch (Throwable th) {
            f.a aVar2 = e.f.Companion;
            m266constructorimpl = e.f.m266constructorimpl(e.g.a(th));
        }
        if (e.f.m269exceptionOrNullimpl(m266constructorimpl) != null) {
            m266constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        a = (String) m266constructorimpl;
        try {
            f.a aVar3 = e.f.Companion;
            m266constructorimpl2 = e.f.m266constructorimpl(Class.forName("kotlinx.coroutines.internal.q").getCanonicalName());
        } catch (Throwable th2) {
            f.a aVar4 = e.f.Companion;
            m266constructorimpl2 = e.f.m266constructorimpl(e.g.a(th2));
        }
        if (e.f.m269exceptionOrNullimpl(m266constructorimpl2) != null) {
            m266constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }

    public static final /* synthetic */ Throwable a(Throwable th, e.m.j.a.d dVar) {
        return j(th, dVar);
    }

    public static final StackTraceElement b(String str) {
        return new StackTraceElement("\b\b\b(" + str, "\b", "\b", -1);
    }

    private static final <E extends Throwable> e.e<E, StackTraceElement[]> c(E e2) {
        boolean z;
        Throwable cause = e2.getCause();
        if (cause == null || !e.p.d.i.a(cause.getClass(), e2.getClass())) {
            return e.h.a(e2, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (h(stackTrace[i])) {
                z = true;
                break;
            }
            i++;
        }
        return z ? e.h.a(cause, stackTrace) : e.h.a(e2, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> E d(E e2, E e3, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(b("Coroutine boundary"));
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int g = g(stackTrace, a);
        int i = 0;
        if (g == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            e3.setStackTrace((StackTraceElement[]) array);
            return e3;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + g];
        for (int i2 = 0; i2 < g; i2++) {
            stackTraceElementArr[i2] = stackTrace[i2];
        }
        Iterator<T> it = arrayDeque.iterator();
        while (it.hasNext()) {
            stackTraceElementArr[g + i] = (StackTraceElement) it.next();
            i++;
        }
        e3.setStackTrace(stackTraceElementArr);
        return e3;
    }

    private static final ArrayDeque<StackTraceElement> e(e.m.j.a.d dVar) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = dVar.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            if (!(dVar instanceof e.m.j.a.d)) {
                dVar = null;
            }
            if (dVar == null || (dVar = dVar.getCallerFrame()) == null) {
                break;
            }
            StackTraceElement stackTraceElement2 = dVar.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
        return arrayDeque;
    }

    private static final boolean f(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && e.p.d.i.a(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && e.p.d.i.a(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && e.p.d.i.a(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    private static final int g(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (e.p.d.i.a(str, stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }

    public static final boolean h(StackTraceElement stackTraceElement) {
        boolean k;
        k = e.u.u.k(stackTraceElement.getClassName(), "\b\b\b", false, 2, null);
        return k;
    }

    private static final void i(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (h(stackTraceElementArr[i])) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 < i2) {
            return;
        }
        while (true) {
            if (f(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i2) {
                return;
            } else {
                length2--;
            }
        }
    }

    public static final <E extends Throwable> E j(E e2, e.m.j.a.d dVar) {
        e.e c2 = c(e2);
        Throwable th = (Throwable) c2.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) c2.component2();
        E e3 = (E) d.e(th);
        if (e3 == null || (!e.p.d.i.a(e3.getMessage(), th.getMessage()))) {
            return e2;
        }
        ArrayDeque<StackTraceElement> e4 = e(dVar);
        if (e4.isEmpty()) {
            return e2;
        }
        if (th != e2) {
            i(stackTraceElementArr, e4);
        }
        d(th, e3, e4);
        return e3;
    }

    public static final <E extends Throwable> E k(E e2) {
        E e3 = (E) e2.getCause();
        if (e3 != null) {
            boolean z = true;
            if (!(!e.p.d.i.a(e3.getClass(), e2.getClass()))) {
                StackTraceElement[] stackTrace = e2.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    if (h(stackTrace[i])) {
                        break;
                    }
                    i++;
                }
                if (z) {
                    return e3;
                }
            }
        }
        return e2;
    }
}
