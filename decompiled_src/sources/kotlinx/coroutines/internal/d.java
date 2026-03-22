package kotlinx.coroutines.internal;

import e.f;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class d {
    private static final int a = d(Throwable.class, -1);

    /* renamed from: b, reason: collision with root package name */
    private static final ReentrantReadWriteLock f1581b = new ReentrantReadWriteLock();

    /* renamed from: c, reason: collision with root package name */
    private static final WeakHashMap<Class<? extends Throwable>, e.p.c.l<Throwable, Throwable>> f1582c = new WeakHashMap<>();

    /* loaded from: classes.dex */
    public static final class a extends e.p.d.j implements e.p.c.l<Throwable, Throwable> {
        final /* synthetic */ Constructor $constructor$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Constructor constructor) {
            super(1);
            this.$constructor$inlined = constructor;
        }

        @Override // e.p.c.l
        public final Throwable invoke(Throwable th) {
            Object m266constructorimpl;
            Object newInstance;
            try {
                f.a aVar = e.f.Companion;
                newInstance = this.$constructor$inlined.newInstance(th.getMessage(), th);
            } catch (Throwable th2) {
                f.a aVar2 = e.f.Companion;
                m266constructorimpl = e.f.m266constructorimpl(e.g.a(th2));
            }
            if (newInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            }
            m266constructorimpl = e.f.m266constructorimpl((Throwable) newInstance);
            if (e.f.m272isFailureimpl(m266constructorimpl)) {
                m266constructorimpl = null;
            }
            return (Throwable) m266constructorimpl;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends e.p.d.j implements e.p.c.l<Throwable, Throwable> {
        final /* synthetic */ Constructor $constructor$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Constructor constructor) {
            super(1);
            this.$constructor$inlined = constructor;
        }

        @Override // e.p.c.l
        public final Throwable invoke(Throwable th) {
            Object m266constructorimpl;
            Object newInstance;
            try {
                f.a aVar = e.f.Companion;
                newInstance = this.$constructor$inlined.newInstance(th);
            } catch (Throwable th2) {
                f.a aVar2 = e.f.Companion;
                m266constructorimpl = e.f.m266constructorimpl(e.g.a(th2));
            }
            if (newInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            }
            m266constructorimpl = e.f.m266constructorimpl((Throwable) newInstance);
            if (e.f.m272isFailureimpl(m266constructorimpl)) {
                m266constructorimpl = null;
            }
            return (Throwable) m266constructorimpl;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends e.p.d.j implements e.p.c.l<Throwable, Throwable> {
        final /* synthetic */ Constructor $constructor$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Constructor constructor) {
            super(1);
            this.$constructor$inlined = constructor;
        }

        @Override // e.p.c.l
        public final Throwable invoke(Throwable th) {
            Object m266constructorimpl;
            Object newInstance;
            try {
                f.a aVar = e.f.Companion;
                newInstance = this.$constructor$inlined.newInstance(th.getMessage());
            } catch (Throwable th2) {
                f.a aVar2 = e.f.Companion;
                m266constructorimpl = e.f.m266constructorimpl(e.g.a(th2));
            }
            if (newInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            }
            Throwable th3 = (Throwable) newInstance;
            th3.initCause(th);
            m266constructorimpl = e.f.m266constructorimpl(th3);
            if (e.f.m272isFailureimpl(m266constructorimpl)) {
                m266constructorimpl = null;
            }
            return (Throwable) m266constructorimpl;
        }
    }

    /* renamed from: kotlinx.coroutines.internal.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0125d extends e.p.d.j implements e.p.c.l<Throwable, Throwable> {
        final /* synthetic */ Constructor $constructor$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0125d(Constructor constructor) {
            super(1);
            this.$constructor$inlined = constructor;
        }

        @Override // e.p.c.l
        public final Throwable invoke(Throwable th) {
            Object m266constructorimpl;
            Object newInstance;
            try {
                f.a aVar = e.f.Companion;
                newInstance = this.$constructor$inlined.newInstance(new Object[0]);
            } catch (Throwable th2) {
                f.a aVar2 = e.f.Companion;
                m266constructorimpl = e.f.m266constructorimpl(e.g.a(th2));
            }
            if (newInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            }
            Throwable th3 = (Throwable) newInstance;
            th3.initCause(th);
            m266constructorimpl = e.f.m266constructorimpl(th3);
            if (e.f.m272isFailureimpl(m266constructorimpl)) {
                m266constructorimpl = null;
            }
            return (Throwable) m266constructorimpl;
        }
    }

    /* loaded from: classes.dex */
    public static final class e<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            a = e.l.b.a(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
            return a;
        }
    }

    /* loaded from: classes.dex */
    static final class f extends e.p.d.j implements e.p.c.l {
        public static final f INSTANCE = new f();

        f() {
            super(1);
        }

        @Override // e.p.c.l
        public final Void invoke(Throwable th) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    static final class g extends e.p.d.j implements e.p.c.l {
        public static final g INSTANCE = new g();

        g() {
            super(1);
        }

        @Override // e.p.c.l
        public final Void invoke(Throwable th) {
            return null;
        }
    }

    private static final e.p.c.l<Throwable, Throwable> a(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new C0125d(constructor);
        }
        if (length != 1) {
            if (length == 2 && e.p.d.i.a(parameterTypes[0], String.class) && e.p.d.i.a(parameterTypes[1], Throwable.class)) {
                return new a(constructor);
            }
            return null;
        }
        Class<?> cls = parameterTypes[0];
        if (e.p.d.i.a(cls, Throwable.class)) {
            return new b(constructor);
        }
        if (e.p.d.i.a(cls, String.class)) {
            return new c(constructor);
        }
        return null;
    }

    private static final int b(Class<?> cls, int i) {
        do {
            int length = cls.getDeclaredFields().length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (!Modifier.isStatic(r0[i3].getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }

    static /* synthetic */ int c(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return b(cls, i);
    }

    private static final int d(Class<?> cls, int i) {
        Object m266constructorimpl;
        e.p.a.b(cls);
        try {
            f.a aVar = e.f.Companion;
            m266constructorimpl = e.f.m266constructorimpl(Integer.valueOf(c(cls, 0, 1, null)));
        } catch (Throwable th) {
            f.a aVar2 = e.f.Companion;
            m266constructorimpl = e.f.m266constructorimpl(e.g.a(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (e.f.m272isFailureimpl(m266constructorimpl)) {
            m266constructorimpl = valueOf;
        }
        return ((Number) m266constructorimpl).intValue();
    }

    public static final <E extends Throwable> E e(E e2) {
        Object m266constructorimpl;
        List k;
        ReentrantReadWriteLock.ReadLock readLock;
        int readHoldCount;
        ReentrantReadWriteLock.WriteLock writeLock;
        if (e2 instanceof kotlinx.coroutines.w) {
            try {
                f.a aVar = e.f.Companion;
                m266constructorimpl = e.f.m266constructorimpl(((kotlinx.coroutines.w) e2).createCopy());
            } catch (Throwable th) {
                f.a aVar2 = e.f.Companion;
                m266constructorimpl = e.f.m266constructorimpl(e.g.a(th));
            }
            return (E) (e.f.m272isFailureimpl(m266constructorimpl) ? null : m266constructorimpl);
        }
        ReentrantReadWriteLock.ReadLock readLock2 = f1581b.readLock();
        readLock2.lock();
        try {
            e.p.c.l<Throwable, Throwable> lVar = f1582c.get(e2.getClass());
            if (lVar != null) {
                return (E) lVar.invoke(e2);
            }
            int i = 0;
            if (a != d(e2.getClass(), 0)) {
                ReentrantReadWriteLock reentrantReadWriteLock = f1581b;
                readLock = reentrantReadWriteLock.readLock();
                readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i2 = 0; i2 < readHoldCount; i2++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    f1582c.put(e2.getClass(), f.INSTANCE);
                    e.j jVar = e.j.a;
                    return null;
                } finally {
                    while (i < readHoldCount) {
                        readLock.lock();
                        i++;
                    }
                    writeLock.unlock();
                }
            }
            k = e.k.e.k(e2.getClass().getConstructors(), new e());
            Iterator it = k.iterator();
            e.p.c.l<Throwable, Throwable> lVar2 = null;
            while (it.hasNext() && (lVar2 = a((Constructor) it.next())) == null) {
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = f1581b;
            readLock = reentrantReadWriteLock2.readLock();
            readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            for (int i3 = 0; i3 < readHoldCount; i3++) {
                readLock.unlock();
            }
            writeLock = reentrantReadWriteLock2.writeLock();
            writeLock.lock();
            try {
                f1582c.put(e2.getClass(), lVar2 != null ? lVar2 : g.INSTANCE);
                e.j jVar2 = e.j.a;
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
                if (lVar2 != null) {
                    return (E) lVar2.invoke(e2);
                }
                return null;
            } finally {
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
            }
        } finally {
            readLock2.unlock();
        }
    }
}
