package d.c.b.p;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.omarea.krscript.model.ClickableNode;

/* loaded from: classes.dex */
public class e extends k {
    private c h;
    private d i;
    private View j;
    private ImageView k;
    private final ClickableNode l;

    /* loaded from: classes.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            c i = e.this.i();
            if (i != null) {
                i.a(e.this);
            }
        }
    }

    /* loaded from: classes.dex */
    static final class b implements View.OnLongClickListener {
        b() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            d j = e.this.j();
            if (j == null) {
                return true;
            }
            j.a(e.this);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(e eVar);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(e eVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, int i, ClickableNode clickableNode) {
        super(context, i, clickableNode);
        Drawable b2;
        e.p.d.i.d(context, "context");
        e.p.d.i.d(clickableNode, "config");
        this.l = clickableNode;
        this.j = c().findViewById(d.c.b.f.kr_shortcut_icon);
        this.k = (ImageView) c().findViewById(d.c.b.f.kr_icon);
        g(this.l.getTitle());
        e(this.l.getDesc());
        f(this.l.getSummary());
        c().setOnClickListener(new a());
        if ((b().length() > 0) && (!e.p.d.i.a(this.l.getAllowShortcut(), Boolean.FALSE))) {
            c().setOnLongClickListener(new b());
            View view = this.j;
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View view2 = this.j;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        ImageView imageView = this.k;
        if (imageView != null) {
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (!(this.l.getIconPath().length() > 0) || (b2 = new d.c.b.l.a().b(context, this.l)) == null) {
                return;
            }
            ImageView imageView2 = this.k;
            if (imageView2 != null) {
                imageView2.setImageDrawable(b2);
            }
            ImageView imageView3 = this.k;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
        }
    }

    protected final c i() {
        return this.h;
    }

    protected final d j() {
        return this.i;
    }

    public final e k(c cVar) {
        e.p.d.i.d(cVar, "onClickListener");
        this.h = cVar;
        return this;
    }

    public final e l(d dVar) {
        e.p.d.i.d(dVar, "onLongClickListener");
        this.i = dVar;
        return this;
    }

    public final void m() {
        c cVar = this.h;
        if (cVar != null) {
            cVar.a(this);
        }
    }
}
