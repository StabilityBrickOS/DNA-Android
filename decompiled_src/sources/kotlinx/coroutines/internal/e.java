package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/* loaded from: classes.dex */
public final class e {
    public static final e a = new e();

    private e() {
    }

    private final <S> S a(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        List<S> A;
        try {
            return d(cls, classLoader);
        } catch (Throwable unused) {
            A = e.k.q.A(ServiceLoader.load(cls, classLoader));
            return A;
        }
    }

    private final List<String> e(URL url) {
        boolean k;
        BufferedReader bufferedReader;
        String K;
        String P;
        String K2;
        String url2 = url.toString();
        k = e.u.u.k(url2, "jar", false, 2, null);
        if (!k) {
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> f = a.f(bufferedReader);
                e.o.a.a(bufferedReader, null);
                return f;
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                }
            }
        }
        K = e.u.v.K(url2, "jar:file:", null, 2, null);
        P = e.u.v.P(K, '!', null, 2, null);
        K2 = e.u.v.K(url2, "!/", null, 2, null);
        JarFile jarFile = new JarFile(P, false);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(K2)), "UTF-8"));
            try {
                List<String> f2 = a.f(bufferedReader);
                e.o.a.a(bufferedReader, null);
                jarFile.close();
                return f2;
            } finally {
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                try {
                    jarFile.close();
                    throw th3;
                } catch (Throwable th4) {
                    e.b.a(th2, th4);
                    throw th2;
                }
            }
        }
    }

    private final List<String> f(BufferedReader bufferedReader) {
        List<String> A;
        String Q;
        CharSequence R;
        boolean z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                A = e.k.q.A(linkedHashSet);
                return A;
            }
            Q = e.u.v.Q(readLine, "#", null, 2, null);
            if (Q == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            R = e.u.v.R(Q);
            String obj = R.toString();
            int i = 0;
            while (true) {
                if (i >= obj.length()) {
                    z = true;
                    break;
                }
                char charAt = obj.charAt(i);
                if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                    z = false;
                    break;
                }
                i++;
            }
            if (!z) {
                throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
            }
            if (obj.length() > 0) {
                linkedHashSet.add(obj);
            }
        }
    }

    public final List<MainDispatcherFactory> c() {
        MainDispatcherFactory mainDispatcherFactory;
        if (!f.a()) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            MainDispatcherFactory mainDispatcherFactory2 = null;
            try {
                mainDispatcherFactory = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (mainDispatcherFactory2 == null) {
                return arrayList;
            }
            arrayList.add(mainDispatcherFactory2);
            return arrayList;
        } catch (Throwable unused3) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
    }

    public final <S> List<S> d(Class<S> cls, ClassLoader classLoader) {
        Set D;
        int g;
        ArrayList list = Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
        e.p.d.i.c(list, "java.util.Collections.list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e.k.n.i(arrayList, a.e((URL) it.next()));
        }
        D = e.k.q.D(arrayList);
        if (!(!D.isEmpty())) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        g = e.k.j.g(D, 10);
        ArrayList arrayList2 = new ArrayList(g);
        Iterator it2 = D.iterator();
        while (it2.hasNext()) {
            arrayList2.add(a.a((String) it2.next(), classLoader, cls));
        }
        return arrayList2;
    }
}
