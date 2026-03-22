package c.f.j;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    static final d f754d = e.f773c;

    /* renamed from: e, reason: collision with root package name */
    private static final String f755e = Character.toString(8206);
    private static final String f = Character.toString(8207);
    static final a g = new a(false, 2, f754d);
    static final a h = new a(true, 2, f754d);
    private final boolean a;

    /* renamed from: b, reason: collision with root package name */
    private final int f756b;

    /* renamed from: c, reason: collision with root package name */
    private final d f757c;

    /* renamed from: c.f.j.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0032a {
        private boolean a;

        /* renamed from: b, reason: collision with root package name */
        private int f758b;

        /* renamed from: c, reason: collision with root package name */
        private d f759c;

        public C0032a() {
            c(a.e(Locale.getDefault()));
        }

        private static a b(boolean z) {
            return z ? a.h : a.g;
        }

        private void c(boolean z) {
            this.a = z;
            this.f759c = a.f754d;
            this.f758b = 2;
        }

        public a a() {
            return (this.f758b == 2 && this.f759c == a.f754d) ? b(this.a) : new a(this.a, this.f758b, this.f759c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final byte[] f = new byte[1792];
        private final CharSequence a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f760b;

        /* renamed from: c, reason: collision with root package name */
        private final int f761c;

        /* renamed from: d, reason: collision with root package name */
        private int f762d;

        /* renamed from: e, reason: collision with root package name */
        private char f763e;

        static {
            for (int i = 0; i < 1792; i++) {
                f[i] = Character.getDirectionality(i);
            }
        }

        b(CharSequence charSequence, boolean z) {
            this.a = charSequence;
            this.f760b = z;
            this.f761c = charSequence.length();
        }

        private static byte c(char c2) {
            return c2 < 1792 ? f[c2] : Character.getDirectionality(c2);
        }

        private byte f() {
            char charAt;
            int i = this.f762d;
            do {
                int i2 = this.f762d;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.a;
                int i3 = i2 - 1;
                this.f762d = i3;
                charAt = charSequence.charAt(i3);
                this.f763e = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.f762d = i;
            this.f763e = ';';
            return (byte) 13;
        }

        private byte g() {
            char charAt;
            do {
                int i = this.f762d;
                if (i >= this.f761c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.a;
                this.f762d = i + 1;
                charAt = charSequence.charAt(i);
                this.f763e = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char charAt;
            int i = this.f762d;
            while (true) {
                int i2 = this.f762d;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.a;
                int i3 = i2 - 1;
                this.f762d = i3;
                char charAt2 = charSequence.charAt(i3);
                this.f763e = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    char c2 = this.f763e;
                    do {
                        int i4 = this.f762d;
                        if (i4 > 0) {
                            CharSequence charSequence2 = this.a;
                            int i5 = i4 - 1;
                            this.f762d = i5;
                            charAt = charSequence2.charAt(i5);
                            this.f763e = charAt;
                        }
                    } while (charAt != c2);
                }
            }
            this.f762d = i;
            this.f763e = '>';
            return (byte) 13;
        }

        private byte i() {
            char charAt;
            int i = this.f762d;
            while (true) {
                int i2 = this.f762d;
                if (i2 >= this.f761c) {
                    this.f762d = i;
                    this.f763e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.a;
                this.f762d = i2 + 1;
                char charAt2 = charSequence.charAt(i2);
                this.f763e = charAt2;
                if (charAt2 == '>') {
                    return (byte) 12;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    char c2 = this.f763e;
                    do {
                        int i3 = this.f762d;
                        if (i3 < this.f761c) {
                            CharSequence charSequence2 = this.a;
                            this.f762d = i3 + 1;
                            charAt = charSequence2.charAt(i3);
                            this.f763e = charAt;
                        }
                    } while (charAt != c2);
                }
            }
        }

        byte a() {
            char charAt = this.a.charAt(this.f762d - 1);
            this.f763e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.a, this.f762d);
                this.f762d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f762d--;
            byte c2 = c(this.f763e);
            if (!this.f760b) {
                return c2;
            }
            char c3 = this.f763e;
            return c3 == '>' ? h() : c3 == ';' ? f() : c2;
        }

        byte b() {
            char charAt = this.a.charAt(this.f762d);
            this.f763e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.a, this.f762d);
                this.f762d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f762d++;
            byte c2 = c(this.f763e);
            if (!this.f760b) {
                return c2;
            }
            char c3 = this.f763e;
            return c3 == '<' ? i() : c3 == '&' ? g() : c2;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:46:0x0045. Please report as an issue. */
        int d() {
            this.f762d = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.f762d < this.f761c && i == 0) {
                byte b2 = b();
                if (b2 != 0) {
                    if (b2 == 1 || b2 == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (b2 != 9) {
                        switch (b2) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case 18:
                                i3--;
                                i2 = 0;
                                continue;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.f762d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        i3--;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        i3--;
                    case 18:
                        i3++;
                }
            }
            return 0;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:33:0x001c. Please report as an issue. */
        int e() {
            this.f762d = this.f761c;
            int i = 0;
            int i2 = 0;
            while (this.f762d > 0) {
                byte a = a();
                if (a != 0) {
                    if (a == 1 || a == 2) {
                        if (i == 0) {
                            return 1;
                        }
                        if (i2 == 0) {
                            i2 = i;
                        }
                    } else if (a != 9) {
                        switch (a) {
                            case 14:
                            case 15:
                                if (i2 == i) {
                                    return -1;
                                }
                                i--;
                                break;
                            case 16:
                            case 17:
                                if (i2 == i) {
                                    return 1;
                                }
                                i--;
                                break;
                            case 18:
                                i++;
                                break;
                            default:
                                if (i2 != 0) {
                                    break;
                                } else {
                                    i2 = i;
                                    break;
                                }
                        }
                    } else {
                        continue;
                    }
                } else {
                    if (i == 0) {
                        return -1;
                    }
                    if (i2 == 0) {
                        i2 = i;
                    }
                }
            }
            return 0;
        }
    }

    a(boolean z, int i, d dVar) {
        this.a = z;
        this.f756b = i;
        this.f757c = dVar;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0032a().a();
    }

    static boolean e(Locale locale) {
        return f.b(locale) == 1;
    }

    private String f(CharSequence charSequence, d dVar) {
        boolean a = dVar.a(charSequence, 0, charSequence.length());
        return (this.a || !(a || b(charSequence) == 1)) ? this.a ? (!a || b(charSequence) == -1) ? f : "" : "" : f755e;
    }

    private String g(CharSequence charSequence, d dVar) {
        boolean a = dVar.a(charSequence, 0, charSequence.length());
        return (this.a || !(a || a(charSequence) == 1)) ? this.a ? (!a || a(charSequence) == -1) ? f : "" : "" : f755e;
    }

    public boolean d() {
        return (this.f756b & 2) != 0;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f757c, true);
    }

    public CharSequence i(CharSequence charSequence, d dVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean a = dVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z) {
            spannableStringBuilder.append((CharSequence) g(charSequence, a ? e.f772b : e.a));
        }
        if (a != this.a) {
            spannableStringBuilder.append(a ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) f(charSequence, a ? e.f772b : e.a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f757c, true);
    }

    public String k(String str, d dVar, boolean z) {
        if (str == null) {
            return null;
        }
        return i(str, dVar, z).toString();
    }
}
