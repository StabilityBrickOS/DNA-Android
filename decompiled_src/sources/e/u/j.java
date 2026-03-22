package e.u;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* loaded from: classes.dex */
public final class j {
    public static final /* synthetic */ f a(Matcher matcher, int i, CharSequence charSequence) {
        return e(matcher, i, charSequence);
    }

    public static final /* synthetic */ f b(Matcher matcher, CharSequence charSequence) {
        return f(matcher, charSequence);
    }

    public static final /* synthetic */ int d(Iterable iterable) {
        return h(iterable);
    }

    public static final f e(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new g(matcher, charSequence);
        }
        return null;
    }

    public static final f f(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new g(matcher, charSequence);
        }
        return null;
    }

    public static final e.r.c g(MatchResult matchResult) {
        e.r.c g;
        g = e.r.f.g(matchResult.start(), matchResult.end());
        return g;
    }

    public static final int h(Iterable<? extends e> iterable) {
        Iterator<? extends e> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i |= it.next().getValue();
        }
        return i;
    }
}
