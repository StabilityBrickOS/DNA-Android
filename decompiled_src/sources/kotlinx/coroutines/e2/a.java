package kotlinx.coroutines.e2;

import kotlinx.coroutines.e2.b;

/* loaded from: classes.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[b.EnumC0124b.values().length];
        a = iArr;
        iArr[b.EnumC0124b.PARKING.ordinal()] = 1;
        a[b.EnumC0124b.BLOCKING.ordinal()] = 2;
        a[b.EnumC0124b.CPU_ACQUIRED.ordinal()] = 3;
        a[b.EnumC0124b.DORMANT.ordinal()] = 4;
        a[b.EnumC0124b.TERMINATED.ordinal()] = 5;
    }
}
