package e.q;

import e.p.d.i;
import java.util.Random;

/* loaded from: classes.dex */
public final class b extends e.q.a {

    /* renamed from: c, reason: collision with root package name */
    private final a f1542c = new a();

    /* loaded from: classes.dex */
    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // e.q.a
    public Random c() {
        Random random = this.f1542c.get();
        i.c(random, "implStorage.get()");
        return random;
    }
}
