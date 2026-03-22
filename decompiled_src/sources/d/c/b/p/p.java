package d.c.b.p;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.omarea.common.ui.e;
import com.omarea.krscript.model.ActionParamInfo;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class p {
    private final ActionParamInfo a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f1490b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements DialogInterface.OnClickListener {
        final /* synthetic */ SeekBar f;
        final /* synthetic */ SeekBar g;
        final /* synthetic */ SeekBar h;
        final /* synthetic */ SeekBar i;
        final /* synthetic */ Button j;
        final /* synthetic */ TextView k;
        final /* synthetic */ ImageView l;
        final /* synthetic */ View m;

        a(SeekBar seekBar, SeekBar seekBar2, SeekBar seekBar3, SeekBar seekBar4, Button button, TextView textView, ImageView imageView, View view) {
            this.f = seekBar;
            this.g = seekBar2;
            this.h = seekBar3;
            this.i = seekBar4;
            this.j = button;
            this.k = textView;
            this.l = imageView;
            this.m = view;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            SeekBar seekBar = this.f;
            e.p.d.i.c(seekBar, "alphaBar");
            int progress = seekBar.getProgress();
            SeekBar seekBar2 = this.g;
            e.p.d.i.c(seekBar2, "redBar");
            int progress2 = seekBar2.getProgress();
            SeekBar seekBar3 = this.h;
            e.p.d.i.c(seekBar3, "greenBar");
            int progress3 = seekBar3.getProgress();
            SeekBar seekBar4 = this.i;
            e.p.d.i.c(seekBar4, "blueBar");
            int argb = Color.argb(progress, progress2, progress3, seekBar4.getProgress());
            this.j.setBackgroundColor(argb);
            try {
                TextView textView = this.k;
                p pVar = p.this;
                SeekBar seekBar5 = this.f;
                e.p.d.i.c(seekBar5, "alphaBar");
                int progress4 = seekBar5.getProgress();
                SeekBar seekBar6 = this.g;
                e.p.d.i.c(seekBar6, "redBar");
                int progress5 = seekBar6.getProgress();
                SeekBar seekBar7 = this.h;
                e.p.d.i.c(seekBar7, "greenBar");
                int progress6 = seekBar7.getProgress();
                SeekBar seekBar8 = this.i;
                e.p.d.i.c(seekBar8, "blueBar");
                textView.setText(pVar.f(progress4, progress5, progress6, seekBar8.getProgress()));
                this.l.setVisibility(8);
                this.m.setBackground(new ColorDrawable(argb));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b implements DialogInterface.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        public static final b f1492e = new b();

        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements SeekBar.OnSeekBarChangeListener {
        final /* synthetic */ SeekBar a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SeekBar f1493b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ SeekBar f1494c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SeekBar f1495d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Button f1496e;

        c(SeekBar seekBar, SeekBar seekBar2, SeekBar seekBar3, SeekBar seekBar4, Button button) {
            this.a = seekBar;
            this.f1493b = seekBar2;
            this.f1494c = seekBar3;
            this.f1495d = seekBar4;
            this.f1496e = button;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            e.p.d.i.d(seekBar, "seekBar");
            SeekBar seekBar2 = this.a;
            e.p.d.i.c(seekBar2, "alphaBar");
            int progress = seekBar2.getProgress();
            SeekBar seekBar3 = this.f1493b;
            e.p.d.i.c(seekBar3, "redBar");
            int progress2 = seekBar3.getProgress();
            SeekBar seekBar4 = this.f1494c;
            e.p.d.i.c(seekBar4, "greenBar");
            int progress3 = seekBar4.getProgress();
            SeekBar seekBar5 = this.f1495d;
            e.p.d.i.c(seekBar5, "blueBar");
            this.f1496e.setBackgroundColor(Color.argb(progress, progress2, progress3, seekBar5.getProgress()));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            e.p.d.i.d(seekBar, "seekBar");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            e.p.d.i.d(seekBar, "seekBar");
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements TextWatcher {
        final /* synthetic */ EditText f;
        final /* synthetic */ ImageView g;
        final /* synthetic */ View h;

        d(EditText editText, ImageView imageView, View view) {
            this.f = editText;
            this.g = imageView;
            this.h = view;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            p pVar = p.this;
            EditText editText = this.f;
            e.p.d.i.c(editText, "textView");
            ImageView imageView = this.g;
            e.p.d.i.c(imageView, "invalidView");
            View view = this.h;
            e.p.d.i.c(view, "preview");
            e.p.d.i.b(editable);
            pVar.h(editText, imageView, view, editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes.dex */
    static final class e implements View.OnClickListener {
        final /* synthetic */ EditText f;
        final /* synthetic */ ImageView g;
        final /* synthetic */ View h;

        e(EditText editText, ImageView imageView, View view) {
            this.f = editText;
            this.g = imageView;
            this.h = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            p pVar = p.this;
            EditText editText = this.f;
            e.p.d.i.c(editText, "textView");
            ImageView imageView = this.g;
            e.p.d.i.c(imageView, "invalidView");
            View view2 = this.h;
            e.p.d.i.c(view2, "preview");
            pVar.e(editText, imageView, view2);
        }
    }

    public p(ActionParamInfo actionParamInfo, Context context) {
        e.p.d.i.d(actionParamInfo, "actionParamInfo");
        e.p.d.i.d(context, "context");
        this.a = actionParamInfo;
        this.f1490b = context;
    }

    private final int d(CharSequence charSequence) {
        if (charSequence != null) {
            if (charSequence.length() > 0) {
                try {
                    return Color.parseColor(charSequence.toString());
                } catch (Exception unused) {
                }
            }
        }
        return (int) 4278190080L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(TextView textView, ImageView imageView, View view) {
        View inflate = LayoutInflater.from(this.f1490b).inflate(d.c.b.g.kr_color_picker, (ViewGroup) null);
        int d2 = d(textView.getText());
        SeekBar seekBar = (SeekBar) inflate.findViewById(d.c.b.f.color_alpha);
        SeekBar seekBar2 = (SeekBar) inflate.findViewById(d.c.b.f.color_red);
        SeekBar seekBar3 = (SeekBar) inflate.findViewById(d.c.b.f.color_green);
        SeekBar seekBar4 = (SeekBar) inflate.findViewById(d.c.b.f.color_blue);
        Button button = (Button) inflate.findViewById(d.c.b.f.color_preview);
        TextView textView2 = (TextView) inflate.findViewById(d.c.b.f.color_preview_text);
        e.p.d.i.c(seekBar, "alphaBar");
        seekBar.setProgress(Color.alpha(d2));
        e.p.d.i.c(seekBar2, "redBar");
        seekBar2.setProgress(Color.red(d2));
        e.p.d.i.c(seekBar3, "greenBar");
        seekBar3.setProgress(Color.green(d2));
        e.p.d.i.c(seekBar4, "blueBar");
        seekBar4.setProgress(Color.blue(d2));
        button.setBackgroundColor(d2);
        e.p.d.i.c(textView2, "colorPreviewText");
        textView2.setText(f(seekBar.getProgress(), seekBar2.getProgress(), seekBar3.getProgress(), seekBar4.getProgress()));
        c cVar = new c(seekBar, seekBar2, seekBar3, seekBar4, button);
        seekBar.setOnSeekBarChangeListener(cVar);
        seekBar2.setOnSeekBarChangeListener(cVar);
        seekBar3.setOnSeekBarChangeListener(cVar);
        seekBar4.setOnSeekBarChangeListener(cVar);
        e.a aVar = com.omarea.common.ui.e.f1255b;
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(this.f1490b).setTitle(this.f1490b.getString(d.c.b.h.kr_color_picker)).setView(inflate).setPositiveButton(this.f1490b.getString(d.c.b.h.btn_confirm), new a(seekBar, seekBar2, seekBar3, seekBar4, button, textView, imageView, view)).setNegativeButton(this.f1490b.getString(d.c.b.h.btn_cancel), b.f1492e);
        e.p.d.i.c(negativeButton, "AlertDialog.Builder(cont….btn_cancel)) { _, _ -> }");
        aVar.c(negativeButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f(int i, int i2, int i3, int i4) {
        e.p.d.q qVar = e.p.d.q.a;
        String format = String.format("#%02x%02x%02x%02x", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}, 4));
        e.p.d.i.c(format, "java.lang.String.format(format, *args)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h(TextView textView, ImageView imageView, View view, String str) {
        try {
            int parseColor = Color.parseColor(str);
            imageView.setVisibility(8);
            view.setVisibility(0);
            view.setBackground(new ColorDrawable(parseColor));
            return true;
        } catch (Exception unused) {
            imageView.setVisibility(0);
            view.setVisibility(8);
            return false;
        }
    }

    public final View g() {
        String value;
        View inflate = LayoutInflater.from(this.f1490b).inflate(d.c.b.g.kr_param_color, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(d.c.b.f.kr_param_color_text);
        ImageView imageView = (ImageView) inflate.findViewById(d.c.b.f.kr_param_color_invalid);
        View findViewById = inflate.findViewById(d.c.b.f.kr_param_color_preview);
        e.p.d.i.c(editText, "textView");
        editText.setTag(this.a.getName());
        editText.addTextChangedListener(new d(editText, imageView, findViewById));
        if (this.a.getValueFromShell() == null) {
            if (this.a.getValue() != null) {
                value = this.a.getValue();
            }
            e.p.d.i.c(imageView, "invalidView");
            e.p.d.i.c(findViewById, "preview");
            h(editText, imageView, findViewById, editText.getText().toString());
            inflate.findViewById(d.c.b.f.kr_param_color_picker).setOnClickListener(new e(editText, imageView, findViewById));
            e.p.d.i.c(inflate, "layout");
            return inflate;
        }
        value = this.a.getValueFromShell();
        e.p.d.i.b(value);
        editText.setText(value);
        e.p.d.i.c(imageView, "invalidView");
        e.p.d.i.c(findViewById, "preview");
        h(editText, imageView, findViewById, editText.getText().toString());
        inflate.findViewById(d.c.b.f.kr_param_color_picker).setOnClickListener(new e(editText, imageView, findViewById));
        e.p.d.i.c(inflate, "layout");
        return inflate;
    }
}
