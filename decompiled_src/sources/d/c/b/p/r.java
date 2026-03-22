package d.c.b.p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.omarea.krscript.model.ActionParamInfo;

/* loaded from: classes.dex */
public final class r {
    private ActionParamInfo a;

    /* renamed from: b, reason: collision with root package name */
    private Context f1500b;

    /* renamed from: c, reason: collision with root package name */
    private a f1501c;

    /* loaded from: classes.dex */
    public interface a {
        boolean openFileChooser(b bVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        public static final a a = a.a;

        /* loaded from: classes.dex */
        public static final class a {
            static final /* synthetic */ a a = new a();

            private a() {
            }

            public final int a() {
                return 0;
            }

            public final int b() {
                return 1;
            }
        }

        void a(String str);

        String b();

        String c();

        int d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c implements View.OnClickListener {
        final /* synthetic */ TextView f;
        final /* synthetic */ EditText g;

        /* loaded from: classes.dex */
        public static final class a implements b {
            a() {
            }

            @Override // d.c.b.p.r.b
            public void a(String str) {
                TextView textView;
                Context context;
                int i;
                if (!(str == null || str.length() == 0)) {
                    TextView textView2 = c.this.f;
                    e.p.d.i.c(textView2, "textView");
                    textView2.setText(str);
                    c.this.g.setText(str);
                    return;
                }
                if (d() == b.a.b()) {
                    textView = c.this.f;
                    e.p.d.i.c(textView, "textView");
                    context = r.this.f1500b;
                    i = d.c.b.h.kr_please_choose_folder;
                } else {
                    textView = c.this.f;
                    e.p.d.i.c(textView, "textView");
                    context = r.this.f1500b;
                    i = d.c.b.h.kr_please_choose_file;
                }
                textView.setText(context.getString(i));
                c.this.g.setText("");
            }

            @Override // d.c.b.p.r.b
            public String b() {
                if (r.this.a.getMime().length() > 0) {
                    return r.this.a.getMime();
                }
                return null;
            }

            @Override // d.c.b.p.r.b
            public String c() {
                if (r.this.a.getSuffix().length() > 0) {
                    return r.this.a.getSuffix();
                }
                return null;
            }

            @Override // d.c.b.p.r.b
            public int d() {
                String type = r.this.a.getType();
                return (type != null && type.hashCode() == -1268966290 && type.equals("folder")) ? b.a.b() : b.a.a();
            }
        }

        c(TextView textView, EditText editText) {
            this.f = textView;
            this.g = editText;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a aVar = r.this.f1501c;
            if (aVar != null) {
                aVar.openFileChooser(new a());
            }
        }
    }

    public r(ActionParamInfo actionParamInfo, Context context, a aVar) {
        e.p.d.i.d(actionParamInfo, "actionParamInfo");
        e.p.d.i.d(context, "context");
        this.a = actionParamInfo;
        this.f1500b = context;
        this.f1501c = aVar;
    }

    public final View d() {
        String value;
        Context context;
        int i;
        View inflate = LayoutInflater.from(this.f1500b).inflate(d.c.b.g.kr_param_file, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.c.b.f.kr_param_file_text);
        EditText editText = (EditText) inflate.findViewById(d.c.b.f.kr_param_file_path);
        View findViewById = inflate.findViewById(d.c.b.f.kr_param_file_btn);
        if (this.a.getEditable()) {
            e.p.d.i.c(textView, "textView");
            textView.setVisibility(8);
            e.p.d.i.c(editText, "pathView");
            editText.setVisibility(0);
            if (e.p.d.i.a(this.a.getType(), "folder")) {
                context = this.f1500b;
                i = d.c.b.h.kr_please_choose_folder;
            } else {
                context = this.f1500b;
                i = d.c.b.h.kr_please_choose_file;
            }
            editText.setHint(context.getString(i));
        } else {
            e.p.d.i.c(editText, "pathView");
            e(editText);
        }
        findViewById.setOnClickListener(new c(textView, editText));
        if (this.a.getValueFromShell() == null) {
            String value2 = this.a.getValue();
            if (!(value2 == null || value2.length() == 0)) {
                e.p.d.i.c(textView, "textView");
                textView.setText(this.a.getValue());
                value = this.a.getValue();
            }
            editText.setTag(this.a.getName());
            e.p.d.i.c(inflate, "layout");
            return inflate;
        }
        e.p.d.i.c(textView, "textView");
        textView.setText(this.a.getValueFromShell());
        value = this.a.getValueFromShell();
        editText.setText(value);
        editText.setTag(this.a.getName());
        e.p.d.i.c(inflate, "layout");
        return inflate;
    }

    public final void e(TextView textView) {
        e.p.d.i.d(textView, "view");
        if (textView instanceof EditText) {
            textView.setCursorVisible(false);
            textView.setFocusable(false);
            textView.setFocusableInTouchMode(false);
        }
    }
}
