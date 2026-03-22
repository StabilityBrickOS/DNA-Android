package d.c.b.l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.omarea.krscript.model.ClickableNode;
import e.p.d.i;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class a {
    public final Drawable a(Bitmap bitmap) {
        i.d(bitmap, "bitmap");
        return new BitmapDrawable(bitmap);
    }

    public final Drawable b(Context context, ClickableNode clickableNode) {
        i.d(context, "context");
        i.d(clickableNode, "clickableNode");
        if (clickableNode.getIconPath().length() == 0) {
            return null;
        }
        String pageConfigDir = clickableNode.getPageConfigDir();
        i.c(pageConfigDir, "clickableNode.pageConfigDir");
        InputStream e2 = new d(context, pageConfigDir).e(clickableNode.getIconPath());
        if (e2 == null) {
            return null;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(e2);
        i.c(decodeStream, "BitmapFactory.decodeStream(this)");
        return a(decodeStream);
    }

    public final Drawable c(Context context, ClickableNode clickableNode) {
        i.d(context, "context");
        i.d(clickableNode, "clickableNode");
        Drawable d2 = d(context, clickableNode, true);
        i.b(d2);
        return d2;
    }

    public final Drawable d(Context context, ClickableNode clickableNode, boolean z) {
        Bitmap decodeStream;
        i.d(context, "context");
        i.d(clickableNode, "clickableNode");
        if (!(clickableNode.getLogoPath().length() == 0)) {
            String pageConfigDir = clickableNode.getPageConfigDir();
            i.c(pageConfigDir, "clickableNode.pageConfigDir");
            InputStream e2 = new d(context, pageConfigDir).e(clickableNode.getLogoPath());
            if (e2 != null) {
                decodeStream = BitmapFactory.decodeStream(e2);
                i.c(decodeStream, "BitmapFactory.decodeStream(this)");
                return a(decodeStream);
            }
        }
        if (!(clickableNode.getIconPath().length() == 0)) {
            String pageConfigDir2 = clickableNode.getPageConfigDir();
            i.c(pageConfigDir2, "clickableNode.pageConfigDir");
            InputStream e3 = new d(context, pageConfigDir2).e(clickableNode.getIconPath());
            if (e3 != null) {
                decodeStream = BitmapFactory.decodeStream(e3);
                i.c(decodeStream, "BitmapFactory.decodeStream(this)");
                return a(decodeStream);
            }
        }
        if (!z) {
            return null;
        }
        Drawable drawable = context.getDrawable(d.c.b.e.kr_shortcut_logo);
        i.b(drawable);
        return drawable;
    }
}
