package e.u;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class h implements Serializable {
    public static final a Companion = new a(null);
    private Set<? extends k> _options;
    private final Pattern nativePattern;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e.p.d.e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(int i) {
            return (i & 2) != 0 ? i | 64 : i;
        }
    }

    /* loaded from: classes.dex */
    private static final class b implements Serializable {
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(e.p.d.e eVar) {
                this();
            }
        }

        public b(String str, int i) {
            e.p.d.i.d(str, "pattern");
            this.pattern = str;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            e.p.d.i.c(compile, "Pattern.compile(pattern, flags)");
            return new h(compile);
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends e.p.d.j implements e.p.c.a<f> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $startIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence, int i) {
            super(0);
            this.$input = charSequence;
            this.$startIndex = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // e.p.c.a
        public final f invoke() {
            return h.this.find(this.$input, this.$startIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final /* synthetic */ class d extends e.p.d.h implements e.p.c.l<f, f> {
        public static final d INSTANCE = new d();

        d() {
            super(1, f.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // e.p.c.l
        public final f invoke(f fVar) {
            e.p.d.i.d(fVar, "p1");
            return fVar.next();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            e.p.d.i.d(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "Pattern.compile(pattern)"
            e.p.d.i.c(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.u.h.<init>(java.lang.String):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(java.lang.String r2, e.u.k r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            e.p.d.i.d(r2, r0)
            java.lang.String r0 = "option"
            e.p.d.i.d(r3, r0)
            e.u.h$a r0 = e.u.h.Companion
            int r3 = r3.getValue()
            int r3 = e.u.h.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…nicodeCase(option.value))"
            e.p.d.i.c(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.u.h.<init>(java.lang.String, e.u.k):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(java.lang.String r2, java.util.Set<? extends e.u.k> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            e.p.d.i.d(r2, r0)
            java.lang.String r0 = "options"
            e.p.d.i.d(r3, r0)
            e.u.h$a r0 = e.u.h.Companion
            int r3 = e.u.j.d(r3)
            int r3 = e.u.h.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…odeCase(options.toInt()))"
            e.p.d.i.c(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.u.h.<init>(java.lang.String, java.util.Set):void");
    }

    public h(Pattern pattern) {
        e.p.d.i.d(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public static /* synthetic */ f find$default(h hVar, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return hVar.find(charSequence, i);
    }

    public static /* synthetic */ e.t.c findAll$default(h hVar, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return hVar.findAll(charSequence, i);
    }

    public static /* synthetic */ List split$default(h hVar, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return hVar.split(charSequence, i);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        e.p.d.i.c(pattern, "nativePattern.pattern()");
        return new b(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence charSequence) {
        e.p.d.i.d(charSequence, "input");
        return this.nativePattern.matcher(charSequence).find();
    }

    public final f find(CharSequence charSequence, int i) {
        e.p.d.i.d(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        e.p.d.i.c(matcher, "nativePattern.matcher(input)");
        return j.a(matcher, i, charSequence);
    }

    public final e.t.c<f> findAll(CharSequence charSequence, int i) {
        e.p.d.i.d(charSequence, "input");
        if (i >= 0 && i <= charSequence.length()) {
            return e.t.d.c(new c(charSequence, i), d.INSTANCE);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i + ", input length: " + charSequence.length());
    }

    public final Set<k> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        int flags = this.nativePattern.flags();
        EnumSet allOf = EnumSet.allOf(k.class);
        e.k.g.k(allOf, new i(flags));
        Set<k> unmodifiableSet = Collections.unmodifiableSet(allOf);
        e.p.d.i.c(unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        e.p.d.i.c(pattern, "nativePattern.pattern()");
        return pattern;
    }

    public final f matchEntire(CharSequence charSequence) {
        e.p.d.i.d(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        e.p.d.i.c(matcher, "nativePattern.matcher(input)");
        return j.b(matcher, charSequence);
    }

    public final boolean matches(CharSequence charSequence) {
        e.p.d.i.d(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    public final String replace(CharSequence charSequence, e.p.c.l<? super f, ? extends CharSequence> lVar) {
        e.p.d.i.d(charSequence, "input");
        e.p.d.i.d(lVar, "transform");
        int i = 0;
        f find$default = find$default(this, charSequence, 0, 2, null);
        if (find$default == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            e.p.d.i.b(find$default);
            sb.append(charSequence, i, find$default.a().g().intValue());
            sb.append(lVar.invoke(find$default));
            i = find$default.a().f().intValue() + 1;
            find$default = find$default.next();
            if (i >= length) {
                break;
            }
        } while (find$default != null);
        if (i < length) {
            sb.append(charSequence, i, length);
        }
        String sb2 = sb.toString();
        e.p.d.i.c(sb2, "sb.toString()");
        return sb2;
    }

    public final String replace(CharSequence charSequence, String str) {
        e.p.d.i.d(charSequence, "input");
        e.p.d.i.d(str, "replacement");
        String replaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        e.p.d.i.c(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final String replaceFirst(CharSequence charSequence, String str) {
        e.p.d.i.d(charSequence, "input");
        e.p.d.i.d(str, "replacement");
        String replaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        e.p.d.i.c(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    public final List<String> split(CharSequence charSequence, int i) {
        e.p.d.i.d(charSequence, "input");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
        }
        Matcher matcher = this.nativePattern.matcher(charSequence);
        if (!matcher.find() || i == 1) {
            return e.k.g.a(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(i > 0 ? e.r.d.c(i, 10) : 10);
        int i3 = i - 1;
        do {
            arrayList.add(charSequence.subSequence(i2, matcher.start()).toString());
            i2 = matcher.end();
            if (i3 >= 0 && arrayList.size() == i3) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
        return arrayList;
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        e.p.d.i.c(pattern, "nativePattern.toString()");
        return pattern;
    }
}
