package e.u;

/* loaded from: classes.dex */
class a {
    public static final int a(int i) {
        if (2 <= i && 36 >= i) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new e.r.c(2, 36));
    }

    public static final int b(char c2, int i) {
        return Character.digit((int) c2, i);
    }

    public static final boolean c(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }
}
