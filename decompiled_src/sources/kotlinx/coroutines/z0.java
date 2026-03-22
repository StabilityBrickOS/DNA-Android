package kotlinx.coroutines;

import e.m.g;
import java.io.Closeable;

/* loaded from: classes.dex */
public abstract class z0 extends y implements Closeable {

    /* loaded from: classes.dex */
    public static final class a extends e.m.b<y, z0> {

        /* renamed from: kotlinx.coroutines.z0$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0127a extends e.p.d.j implements e.p.c.l<g.b, z0> {
            public static final C0127a INSTANCE = new C0127a();

            C0127a() {
                super(1);
            }

            @Override // e.p.c.l
            public final z0 invoke(g.b bVar) {
                if (!(bVar instanceof z0)) {
                    bVar = null;
                }
                return (z0) bVar;
            }
        }

        private a() {
            super(y.f1617e, C0127a.INSTANCE);
        }

        public /* synthetic */ a(e.p.d.e eVar) {
            this();
        }
    }

    static {
        new a(null);
    }
}
