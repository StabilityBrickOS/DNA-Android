package e.r;

import e.k.v;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b extends v {

    /* renamed from: e, reason: collision with root package name */
    private final int f1545e;
    private boolean f;
    private int g;
    private final int h;

    public b(int i, int i2, int i3) {
        this.h = i3;
        this.f1545e = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f = z;
        this.g = z ? i : this.f1545e;
    }

    @Override // e.k.v
    public int b() {
        int i = this.g;
        if (i != this.f1545e) {
            this.g = this.h + i;
        } else {
            if (!this.f) {
                throw new NoSuchElementException();
            }
            this.f = false;
        }
        return i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f;
    }
}
