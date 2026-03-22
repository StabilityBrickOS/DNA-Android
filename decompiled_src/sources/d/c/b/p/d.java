package d.c.b.p;

import android.content.Context;
import android.widget.ImageView;
import com.omarea.krscript.model.ActionNode;
import com.omarea.krscript.model.ActionParamInfo;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d extends e {
    private final ImageView m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, ActionNode actionNode) {
        super(context, d.c.b.g.kr_action_list_item, actionNode);
        ImageView imageView;
        int i;
        e.p.d.i.d(context, "context");
        e.p.d.i.d(actionNode, "config");
        ImageView imageView2 = (ImageView) c().findViewById(d.c.b.f.kr_widget);
        this.m = imageView2;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        if (actionNode.getParams() != null) {
            ArrayList<ActionParamInfo> params = actionNode.getParams();
            e.p.d.i.b(params);
            if (params.size() > 0) {
                imageView = this.m;
                if (imageView != null) {
                    i = d.c.b.e.kr_list;
                    imageView.setImageDrawable(context.getDrawable(i));
                }
                return;
            }
        }
        imageView = this.m;
        if (imageView != null) {
            i = d.c.b.e.kr_run;
            imageView.setImageDrawable(context.getDrawable(i));
        }
    }
}
