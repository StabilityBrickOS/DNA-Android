package e.u;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements f {
    private final Matcher a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f1553b;

    public g(Matcher matcher, CharSequence charSequence) {
        e.p.d.i.d(matcher, "matcher");
        e.p.d.i.d(charSequence, "input");
        this.a = matcher;
        this.f1553b = charSequence;
    }

    private final MatchResult b() {
        return this.a;
    }

    @Override // e.u.f
    public e.r.c a() {
        e.r.c g;
        g = j.g(b());
        return g;
    }

    @Override // e.u.f
    public f next() {
        f e2;
        int end = b().end() + (b().end() == b().start() ? 1 : 0);
        if (end > this.f1553b.length()) {
            return null;
        }
        Matcher matcher = this.a.pattern().matcher(this.f1553b);
        e.p.d.i.c(matcher, "matcher.pattern().matcher(input)");
        e2 = j.e(matcher, end, this.f1553b);
        return e2;
    }
}
