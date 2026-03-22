package e.u;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'LITERAL' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class k implements e {
    private static final /* synthetic */ k[] $VALUES;
    public static final k CANON_EQ;
    public static final k COMMENTS;
    public static final k DOT_MATCHES_ALL;
    public static final k IGNORE_CASE;
    public static final k LITERAL;
    public static final k MULTILINE;
    public static final k UNIX_LINES;
    private final int mask;
    private final int value;

    static {
        k kVar = new k("IGNORE_CASE", 0, 2, 0, 2, null);
        IGNORE_CASE = kVar;
        k kVar2 = new k("MULTILINE", 1, 8, 0, 2, null);
        MULTILINE = kVar2;
        int i = 0;
        int i2 = 2;
        e.p.d.e eVar = null;
        k kVar3 = new k("LITERAL", 2, 16, i, i2, eVar);
        LITERAL = kVar3;
        k kVar4 = new k("UNIX_LINES", 3, 1, i, i2, eVar);
        UNIX_LINES = kVar4;
        k kVar5 = new k("COMMENTS", 4, 4, i, i2, eVar);
        COMMENTS = kVar5;
        k kVar6 = new k("DOT_MATCHES_ALL", 5, 32, i, i2, eVar);
        DOT_MATCHES_ALL = kVar6;
        k kVar7 = new k("CANON_EQ", 6, 128, i, i2, eVar);
        CANON_EQ = kVar7;
        $VALUES = new k[]{kVar, kVar2, kVar3, kVar4, kVar5, kVar6, kVar7};
    }

    private k(String str, int i, int i2, int i3) {
        this.value = i2;
        this.mask = i3;
    }

    /* synthetic */ k(String str, int i, int i2, int i3, int i4, e.p.d.e eVar) {
        this(str, i, i2, (i4 & 2) != 0 ? i2 : i3);
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) $VALUES.clone();
    }

    @Override // e.u.e
    public int getMask() {
        return this.mask;
    }

    @Override // e.u.e
    public int getValue() {
        return this.value;
    }
}
