package c.f.j;

import java.util.Locale;

/* loaded from: classes.dex */
public final class e {
    public static final c.f.j.d a = new C0034e(null, false);

    /* renamed from: b, reason: collision with root package name */
    public static final c.f.j.d f772b = new C0034e(null, true);

    /* renamed from: c, reason: collision with root package name */
    public static final c.f.j.d f773c = new C0034e(b.a, false);

    /* renamed from: d, reason: collision with root package name */
    public static final c.f.j.d f774d = new C0034e(b.a, true);

    /* loaded from: classes.dex */
    private static class a implements c {

        /* renamed from: b, reason: collision with root package name */
        static final a f775b = new a(true);
        private final boolean a;

        private a(boolean z) {
            this.a = z;
        }

        @Override // c.f.j.e.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                int a = e.a(Character.getDirectionality(charSequence.charAt(i)));
                if (a != 0) {
                    if (a != 1) {
                        continue;
                        i++;
                    } else if (!this.a) {
                        return 1;
                    }
                } else if (this.a) {
                    return 0;
                }
                z = true;
                i++;
            }
            if (z) {
                return this.a ? 1 : 0;
            }
            return 2;
        }
    }

    /* loaded from: classes.dex */
    private static class b implements c {
        static final b a = new b();

        private b() {
        }

        @Override // c.f.j.e.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = e.b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    /* loaded from: classes.dex */
    private static abstract class d implements c.f.j.d {
        private final c a;

        d(c cVar) {
            this.a = cVar;
        }

        private boolean c(CharSequence charSequence, int i, int i2) {
            int a = this.a.a(charSequence, i, i2);
            if (a == 0) {
                return true;
            }
            if (a != 1) {
                return b();
            }
            return false;
        }

        @Override // c.f.j.d
        public boolean a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            return this.a == null ? b() : c(charSequence, i, i2);
        }

        protected abstract boolean b();
    }

    /* renamed from: c.f.j.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0034e extends d {

        /* renamed from: b, reason: collision with root package name */
        private final boolean f776b;

        C0034e(c cVar, boolean z) {
            super(cVar);
            this.f776b = z;
        }

        @Override // c.f.j.e.d
        protected boolean b() {
            return this.f776b;
        }
    }

    /* loaded from: classes.dex */
    private static class f extends d {

        /* renamed from: b, reason: collision with root package name */
        static final f f777b = new f();

        f() {
            super(null);
        }

        @Override // c.f.j.e.d
        protected boolean b() {
            return c.f.j.f.b(Locale.getDefault()) == 1;
        }
    }

    static {
        a aVar = a.f775b;
        f fVar = f.f777b;
    }

    static int a(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
