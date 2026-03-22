package e.u;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
public final class i<T> extends e.p.d.j implements e.p.c.l<T, Boolean> {
    final /* synthetic */ int $value$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(int i) {
        super(1);
        this.$value$inlined = i;
    }

    @Override // e.p.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke((Enum) obj));
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)Z */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean invoke(Enum r3) {
        e eVar = (e) r3;
        return (this.$value$inlined & eVar.getMask()) == eVar.getValue();
    }
}
