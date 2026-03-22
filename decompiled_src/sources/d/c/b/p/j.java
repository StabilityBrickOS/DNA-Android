package d.c.b.p;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.common.ui.e;
import com.omarea.krscript.model.TextNode;

/* loaded from: classes.dex */
public final class j extends k {
    private final TextView h;
    private final Context i;

    /* loaded from: classes.dex */
    public static final class a extends ClickableSpan {
        final /* synthetic */ TextNode.TextRow f;

        a(TextNode.TextRow textRow) {
            this.f = textRow;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            e.p.d.i.d(view, "widget");
            if (this.f.getLink$krscript_release_mini().length() > 0) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f.getLink$krscript_release_mini()));
                    intent.addFlags(268435456);
                    j.this.i.startActivity(intent);
                } catch (Exception unused) {
                    Toast.makeText(j.this.i, j.this.i.getString(d.c.b.h.kr_slice_activity_fail), 0).show();
                }
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            e.p.d.i.d(textPaint, "ds");
            textPaint.setColor(this.f.getColor$krscript_release_mini() != 1 ? textPaint.linkColor : this.f.getColor$krscript_release_mini());
            textPaint.setUnderlineText(this.f.getUnderline$krscript_release_mini());
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends ClickableSpan {
        final /* synthetic */ TextNode.TextRow f;

        b(TextNode.TextRow textRow) {
            this.f = textRow;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            e.p.d.i.d(view, "widget");
            new d.c.b.j(j.this.i, this.f.getActivity$krscript_release_mini()).b();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            e.p.d.i.d(textPaint, "ds");
            textPaint.setColor(this.f.getColor$krscript_release_mini() != 1 ? textPaint.linkColor : this.f.getColor$krscript_release_mini());
            textPaint.setUnderlineText(this.f.getUnderline$krscript_release_mini());
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends ClickableSpan {
        final /* synthetic */ TextNode.TextRow f;
        final /* synthetic */ TextNode g;

        c(TextNode.TextRow textRow, TextNode textNode) {
            this.f = textRow;
            this.g = textNode;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            CharSequence R;
            e.p.d.i.d(view, "widget");
            String b2 = d.c.b.n.b.b(j.this.i, this.f.getOnClickScript$krscript_release_mini(), this.g);
            e.p.d.i.c(b2, "result");
            if (b2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            R = e.u.v.R(b2);
            if (R.toString().length() > 0) {
                e.a aVar = com.omarea.common.ui.e.f1255b;
                Context context = j.this.i;
                String string = j.this.i.getString(d.c.b.h.kr_slice_script_result);
                e.p.d.i.c(string, "context.getString(R.string.kr_slice_script_result)");
                e.a.o(aVar, context, string, b2, null, 8, null);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            e.p.d.i.d(textPaint, "ds");
            textPaint.setColor(this.f.getColor$krscript_release_mini() != 1 ? textPaint.linkColor : this.f.getColor$krscript_release_mini());
            textPaint.setUnderlineText(this.f.getUnderline$krscript_release_mini());
        }
    }

    /* loaded from: classes.dex */
    static final class d implements View.OnLongClickListener {

        /* renamed from: e, reason: collision with root package name */
        public static final d f1469e = new d();

        d() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public j(android.content.Context r9, int r10, com.omarea.krscript.model.TextNode r11) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.b.p.j.<init>(android.content.Context, int, com.omarea.krscript.model.TextNode):void");
    }
}
