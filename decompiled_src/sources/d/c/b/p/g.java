package d.c.b.p;

import android.content.Context;
import android.widget.ImageView;
import com.omarea.krscript.model.PageNode;

/* loaded from: classes.dex */
public final class g extends e {
    private final ImageView m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, PageNode pageNode) {
        super(context, d.c.b.g.kr_action_list_item, pageNode);
        e.p.d.i.d(context, "context");
        e.p.d.i.d(pageNode, "config");
        ImageView imageView = (ImageView) c().findViewById(d.c.b.f.kr_widget);
        this.m = imageView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this.m;
        if (imageView2 != null) {
            imageView2.setImageDrawable(context.getDrawable(d.c.b.e.kr_arrow));
        }
    }
}
