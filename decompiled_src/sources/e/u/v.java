package e.u;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends u {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends e.p.d.j implements e.p.c.p<CharSequence, Integer, e.e<? extends Integer, ? extends Integer>> {
        final /* synthetic */ List $delimitersList;
        final /* synthetic */ boolean $ignoreCase;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list, boolean z) {
            super(2);
            this.$delimitersList = list;
            this.$ignoreCase = z;
        }

        public final e.e<Integer, Integer> invoke(CharSequence charSequence, int i) {
            e.p.d.i.d(charSequence, "$receiver");
            e.e o = v.o(charSequence, this.$delimitersList, i, this.$ignoreCase, false);
            if (o != null) {
                return e.h.a(o.getFirst(), Integer.valueOf(((String) o.getSecond()).length()));
            }
            return null;
        }

        @Override // e.p.c.p
        public /* bridge */ /* synthetic */ e.e<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return invoke(charSequence, num.intValue());
        }
    }

    public static /* synthetic */ int A(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = p(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return y(charSequence, str, i, z);
    }

    public static final int B(CharSequence charSequence, char[] cArr, int i, boolean z) {
        e.p.d.i.d(charSequence, "$this$lastIndexOfAny");
        e.p.d.i.d(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(e.k.a.h(cArr), i);
        }
        for (int c2 = e.r.d.c(i, p(charSequence)); c2 >= 0; c2--) {
            char charAt = charSequence.charAt(c2);
            int length = cArr.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (b.d(cArr[i2], charAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return c2;
            }
        }
        return -1;
    }

    private static final e.t.c<e.r.c> C(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        if (i2 >= 0) {
            return new d(charSequence, i, i2, new a(e.k.a.a(strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    static /* synthetic */ e.t.c D(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return C(charSequence, strArr, i, z, i2);
    }

    public static final boolean E(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        e.p.d.i.d(charSequence, "$this$regionMatchesImpl");
        e.p.d.i.d(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!b.d(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final List<String> F(CharSequence charSequence, String[] strArr, boolean z, int i) {
        e.p.d.i.d(charSequence, "$this$split");
        e.p.d.i.d(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return G(charSequence, str, z, i);
            }
        }
        Iterable d2 = e.t.d.d(D(charSequence, strArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(e.k.g.g(d2, 10));
        Iterator it = d2.iterator();
        while (it.hasNext()) {
            arrayList.add(I(charSequence, (e.r.c) it.next()));
        }
        return arrayList;
    }

    private static final List<String> G(CharSequence charSequence, String str, boolean z, int i) {
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
        }
        int r = r(charSequence, str, 0, z);
        if (r == -1 || i == 1) {
            return e.k.g.a(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? e.r.d.c(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(i2, r).toString());
            i2 = str.length() + r;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            r = r(charSequence, str, i2, z);
        } while (r != -1);
        arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List H(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return F(charSequence, strArr, z, i);
    }

    public static final String I(CharSequence charSequence, e.r.c cVar) {
        e.p.d.i.d(charSequence, "$this$substring");
        e.p.d.i.d(cVar, "range");
        return charSequence.subSequence(cVar.g().intValue(), cVar.f().intValue() + 1).toString();
    }

    public static final String J(String str, String str2, String str3) {
        e.p.d.i.d(str, "$this$substringAfter");
        e.p.d.i.d(str2, "delimiter");
        e.p.d.i.d(str3, "missingDelimiterValue");
        int v = l.v(str, str2, 0, false, 6, null);
        if (v == -1) {
            return str3;
        }
        String substring = str.substring(v + str2.length(), str.length());
        e.p.d.i.c(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String K(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return J(str, str2, str3);
    }

    public static final String L(String str, char c2, String str2) {
        e.p.d.i.d(str, "$this$substringAfterLast");
        e.p.d.i.d(str2, "missingDelimiterValue");
        int z = z(str, c2, 0, false, 6, null);
        if (z == -1) {
            return str2;
        }
        String substring = str.substring(z + 1, str.length());
        e.p.d.i.c(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String M(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return L(str, c2, str2);
    }

    public static final String N(String str, char c2, String str2) {
        e.p.d.i.d(str, "$this$substringBefore");
        e.p.d.i.d(str2, "missingDelimiterValue");
        int u = l.u(str, c2, 0, false, 6, null);
        if (u == -1) {
            return str2;
        }
        String substring = str.substring(0, u);
        e.p.d.i.c(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String O(String str, String str2, String str3) {
        e.p.d.i.d(str, "$this$substringBefore");
        e.p.d.i.d(str2, "delimiter");
        e.p.d.i.d(str3, "missingDelimiterValue");
        int v = l.v(str, str2, 0, false, 6, null);
        if (v == -1) {
            return str3;
        }
        String substring = str.substring(0, v);
        e.p.d.i.c(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String P(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return N(str, c2, str2);
    }

    public static /* synthetic */ String Q(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return O(str, str2, str3);
    }

    public static CharSequence R(CharSequence charSequence) {
        e.p.d.i.d(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean c2 = e.u.a.c(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!c2) {
                    break;
                }
                length--;
            } else if (c2) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final boolean m(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        e.p.d.i.d(charSequence, "$this$contains");
        e.p.d.i.d(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (l.v(charSequence, (String) charSequence2, 0, z, 2, null) >= 0) {
                return true;
            }
        } else if (t(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean n(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m(charSequence, charSequence2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0090, code lost:
    
        return e.h.a(java.lang.Integer.valueOf(r12), r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final e.e<java.lang.Integer, java.lang.String> o(java.lang.CharSequence r10, java.util.Collection<java.lang.String> r11, int r12, boolean r13, boolean r14) {
        /*
            r0 = 0
            if (r13 != 0) goto L2d
            int r1 = r11.size()
            r2 = 1
            if (r1 != r2) goto L2d
            java.lang.Object r11 = e.k.g.v(r11)
            java.lang.String r11 = (java.lang.String) r11
            r4 = 0
            r5 = 4
            r6 = 0
            r1 = r10
            r2 = r11
            r3 = r12
            if (r14 != 0) goto L1d
            int r10 = e.u.l.v(r1, r2, r3, r4, r5, r6)
            goto L21
        L1d:
            int r10 = e.u.l.A(r1, r2, r3, r4, r5, r6)
        L21:
            if (r10 >= 0) goto L24
            goto L2c
        L24:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            e.e r0 = e.h.a(r10, r11)
        L2c:
            return r0
        L2d:
            r1 = 0
            if (r14 != 0) goto L3e
            int r12 = e.r.d.a(r12, r1)
            e.r.c r14 = new e.r.c
            int r1 = r10.length()
            r14.<init>(r12, r1)
            goto L4a
        L3e:
            int r14 = p(r10)
            int r12 = e.r.d.c(r12, r14)
            e.r.a r14 = e.r.d.f(r12, r1)
        L4a:
            boolean r12 = r10 instanceof java.lang.String
            if (r12 == 0) goto L95
            int r12 = r14.a()
            int r1 = r14.b()
            int r14 = r14.c()
            if (r14 < 0) goto L5f
            if (r12 > r1) goto Ld2
            goto L61
        L5f:
            if (r12 < r1) goto Ld2
        L61:
            java.util.Iterator r8 = r11.iterator()
        L65:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L83
            java.lang.Object r9 = r8.next()
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            r4 = r10
            java.lang.String r4 = (java.lang.String) r4
            int r6 = r2.length()
            r5 = r12
            r7 = r13
            boolean r2 = e.u.u.i(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto L65
            goto L84
        L83:
            r9 = r0
        L84:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L91
        L88:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r12)
            e.e r10 = e.h.a(r10, r9)
            return r10
        L91:
            if (r12 == r1) goto Ld2
            int r12 = r12 + r14
            goto L61
        L95:
            int r12 = r14.a()
            int r1 = r14.b()
            int r14 = r14.c()
            if (r14 < 0) goto La6
            if (r12 > r1) goto Ld2
            goto La8
        La6:
            if (r12 < r1) goto Ld2
        La8:
            java.util.Iterator r8 = r11.iterator()
        Lac:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lc8
            java.lang.Object r9 = r8.next()
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            int r6 = r2.length()
            r4 = r10
            r5 = r12
            r7 = r13
            boolean r2 = E(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto Lac
            goto Lc9
        Lc8:
            r9 = r0
        Lc9:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto Lce
            goto L88
        Lce:
            if (r12 == r1) goto Ld2
            int r12 = r12 + r14
            goto La8
        Ld2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.u.v.o(java.lang.CharSequence, java.util.Collection, int, boolean, boolean):e.e");
    }

    public static final int p(CharSequence charSequence) {
        e.p.d.i.d(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final int q(CharSequence charSequence, char c2, int i, boolean z) {
        e.p.d.i.d(charSequence, "$this$indexOf");
        return (z || !(charSequence instanceof String)) ? w(charSequence, new char[]{c2}, i, z) : ((String) charSequence).indexOf(c2, i);
    }

    public static final int r(CharSequence charSequence, String str, int i, boolean z) {
        e.p.d.i.d(charSequence, "$this$indexOf");
        e.p.d.i.d(str, "string");
        return (z || !(charSequence instanceof String)) ? t(charSequence, str, i, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(str, i);
    }

    private static final int s(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        e.r.a cVar = !z2 ? new e.r.c(e.r.d.a(i, 0), e.r.d.c(i2, charSequence.length())) : e.r.d.f(e.r.d.c(i, p(charSequence)), e.r.d.a(i2, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int a2 = cVar.a();
            int b2 = cVar.b();
            int c2 = cVar.c();
            if (c2 >= 0) {
                if (a2 > b2) {
                    return -1;
                }
            } else if (a2 < b2) {
                return -1;
            }
            while (!u.i((String) charSequence2, 0, (String) charSequence, a2, charSequence2.length(), z)) {
                if (a2 == b2) {
                    return -1;
                }
                a2 += c2;
            }
            return a2;
        }
        int a3 = cVar.a();
        int b3 = cVar.b();
        int c3 = cVar.c();
        if (c3 >= 0) {
            if (a3 > b3) {
                return -1;
            }
        } else if (a3 < b3) {
            return -1;
        }
        while (!E(charSequence2, 0, charSequence, a3, charSequence2.length(), z)) {
            if (a3 == b3) {
                return -1;
            }
            a3 += c3;
        }
        return a3;
    }

    static /* synthetic */ int t(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return s(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ int u(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return q(charSequence, c2, i, z);
    }

    public static /* synthetic */ int v(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return r(charSequence, str, i, z);
    }

    public static final int w(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        e.p.d.i.d(charSequence, "$this$indexOfAny");
        e.p.d.i.d(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(e.k.a.h(cArr), i);
        }
        int a2 = e.r.d.a(i, 0);
        int p = p(charSequence);
        if (a2 > p) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(a2);
            int length = cArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                }
                if (b.d(cArr[i2], charAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return a2;
            }
            if (a2 == p) {
                return -1;
            }
            a2++;
        }
    }

    public static final int x(CharSequence charSequence, char c2, int i, boolean z) {
        e.p.d.i.d(charSequence, "$this$lastIndexOf");
        return (z || !(charSequence instanceof String)) ? B(charSequence, new char[]{c2}, i, z) : ((String) charSequence).lastIndexOf(c2, i);
    }

    public static final int y(CharSequence charSequence, String str, int i, boolean z) {
        e.p.d.i.d(charSequence, "$this$lastIndexOf");
        e.p.d.i.d(str, "string");
        return (z || !(charSequence instanceof String)) ? s(charSequence, str, i, 0, z, true) : ((String) charSequence).lastIndexOf(str, i);
    }

    public static /* synthetic */ int z(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = p(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return x(charSequence, c2, i, z);
    }
}
