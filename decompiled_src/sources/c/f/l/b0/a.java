package c.f.l.b0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: e, reason: collision with root package name */
    private final int f794e;
    private final c f;
    private final int g;

    public a(int i, c cVar, int i2) {
        this.f794e = i;
        this.f = cVar;
        this.g = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f794e);
        this.f.Q(this.g, bundle);
    }
}
