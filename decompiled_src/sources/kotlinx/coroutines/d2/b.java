package kotlinx.coroutines.d2;

import e.f;
import e.m.d;
import e.m.j.a.g;
import e.p.c.l;
import e.p.c.p;
import e.p.d.r;
import kotlinx.coroutines.internal.v;

/* loaded from: classes.dex */
public final class b {
    public static final <T> void a(l<? super d<? super T>, ? extends Object> lVar, d<? super T> dVar) {
        Object a;
        g.a(dVar);
        try {
            e.m.g context = dVar.getContext();
            Object c2 = v.c(context, null);
            try {
            } finally {
                v.a(context, c2);
            }
        } catch (Throwable th) {
            f.a aVar = f.Companion;
            a = e.g.a(th);
        }
        if (lVar == null) {
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        r.a(lVar, 1);
        a = lVar.invoke(dVar);
        if (a != e.m.i.b.d()) {
            f.a aVar2 = f.Companion;
            dVar.resumeWith(f.m266constructorimpl(a));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> void b(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r, d<? super T> dVar) {
        Object a;
        g.a(dVar);
        try {
            e.m.g context = dVar.getContext();
            Object c2 = v.c(context, null);
            try {
            } finally {
                v.a(context, c2);
            }
        } catch (Throwable th) {
            f.a aVar = f.Companion;
            a = e.g.a(th);
        }
        if (pVar == null) {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        r.a(pVar, 2);
        a = pVar.invoke(r, dVar);
        if (a != e.m.i.b.d()) {
            f.a aVar2 = f.Companion;
            dVar.resumeWith(f.m266constructorimpl(a));
        }
    }
}
