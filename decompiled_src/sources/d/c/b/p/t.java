package d.c.b.p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.omarea.krscript.model.ActionParamInfo;

/* loaded from: classes.dex */
public final class t {
    private ActionParamInfo a;

    /* renamed from: b, reason: collision with root package name */
    private Context f1512b;

    /* loaded from: classes.dex */
    public static final class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f1513b;

        a(TextView textView) {
            this.f1513b = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            TextView textView = this.f1513b;
            e.p.d.i.c(textView, "textView");
            textView.setText(String.valueOf(i + t.this.a.getMin()));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* loaded from: classes.dex */
    static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SeekBar f1514e;

        b(SeekBar seekBar) {
            this.f1514e = seekBar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SeekBar seekBar = this.f1514e;
            e.p.d.i.c(seekBar, "seekbar");
            if (seekBar.getProgress() > 0) {
                SeekBar seekBar2 = this.f1514e;
                e.p.d.i.c(seekBar2, "seekbar");
                seekBar2.setProgress(seekBar2.getProgress() - 1);
            }
        }
    }

    /* loaded from: classes.dex */
    static final class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SeekBar f1515e;

        c(SeekBar seekBar) {
            this.f1515e = seekBar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SeekBar seekBar = this.f1515e;
            e.p.d.i.c(seekBar, "seekbar");
            int progress = seekBar.getProgress();
            SeekBar seekBar2 = this.f1515e;
            e.p.d.i.c(seekBar2, "seekbar");
            if (progress < seekBar2.getMax()) {
                SeekBar seekBar3 = this.f1515e;
                e.p.d.i.c(seekBar3, "seekbar");
                seekBar3.setProgress(seekBar3.getProgress() + 1);
            }
        }
    }

    public t(ActionParamInfo actionParamInfo, Context context) {
        e.p.d.i.d(actionParamInfo, "actionParamInfo");
        e.p.d.i.d(context, "context");
        this.a = actionParamInfo;
        this.f1512b = context;
    }

    public final View b() {
        String value;
        View inflate = LayoutInflater.from(this.f1512b).inflate(d.c.b.g.kr_param_seekbar, (ViewGroup) null);
        SeekBar seekBar = (SeekBar) inflate.findViewById(d.c.b.f.kr_param_seekbar);
        e.p.d.i.c(seekBar, "seekbar");
        seekBar.setMax(this.a.getMax());
        seekBar.setMax(this.a.getMax() - this.a.getMin());
        if (this.a.getValueFromShell() == null) {
            if (this.a.getValue() != null) {
                value = this.a.getValue();
                e.p.d.i.b(value);
            }
            seekBar.setTag(this.a.getName());
            ImageButton imageButton = (ImageButton) inflate.findViewById(d.c.b.f.kr_param_seekbar_minus);
            ImageButton imageButton2 = (ImageButton) inflate.findViewById(d.c.b.f.kr_param_seekbar_plus);
            TextView textView = (TextView) inflate.findViewById(d.c.b.f.kr_param_seekbar_value);
            e.p.d.i.c(textView, "textView");
            textView.setText(String.valueOf(seekBar.getProgress() + this.a.getMin()));
            seekBar.setOnSeekBarChangeListener(new a(textView));
            imageButton.setOnClickListener(new b(seekBar));
            imageButton2.setOnClickListener(new c(seekBar));
            e.p.d.i.c(inflate, "layout");
            return inflate;
        }
        value = this.a.getValueFromShell();
        e.p.d.i.b(value);
        seekBar.setProgress(Integer.parseInt(value) - this.a.getMin());
        seekBar.setTag(this.a.getName());
        ImageButton imageButton3 = (ImageButton) inflate.findViewById(d.c.b.f.kr_param_seekbar_minus);
        ImageButton imageButton22 = (ImageButton) inflate.findViewById(d.c.b.f.kr_param_seekbar_plus);
        TextView textView2 = (TextView) inflate.findViewById(d.c.b.f.kr_param_seekbar_value);
        e.p.d.i.c(textView2, "textView");
        textView2.setText(String.valueOf(seekBar.getProgress() + this.a.getMin()));
        seekBar.setOnSeekBarChangeListener(new a(textView2));
        imageButton3.setOnClickListener(new b(seekBar));
        imageButton22.setOnClickListener(new c(seekBar));
        e.p.d.i.c(inflate, "layout");
        return inflate;
    }
}
