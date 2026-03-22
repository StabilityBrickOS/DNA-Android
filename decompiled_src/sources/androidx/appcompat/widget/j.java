package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.m0;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    private static final PorterDuff.Mode f219b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    private static j f220c;
    private m0 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements m0.e {
        private final int[] a = {c.a.e.abc_textfield_search_default_mtrl_alpha, c.a.e.abc_textfield_default_mtrl_alpha, c.a.e.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b, reason: collision with root package name */
        private final int[] f221b = {c.a.e.abc_ic_commit_search_api_mtrl_alpha, c.a.e.abc_seekbar_tick_mark_material, c.a.e.abc_ic_menu_share_mtrl_alpha, c.a.e.abc_ic_menu_copy_mtrl_am_alpha, c.a.e.abc_ic_menu_cut_mtrl_alpha, c.a.e.abc_ic_menu_selectall_mtrl_alpha, c.a.e.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c, reason: collision with root package name */
        private final int[] f222c = {c.a.e.abc_textfield_activated_mtrl_alpha, c.a.e.abc_textfield_search_activated_mtrl_alpha, c.a.e.abc_cab_background_top_mtrl_alpha, c.a.e.abc_text_cursor_material, c.a.e.abc_text_select_handle_left_mtrl_dark, c.a.e.abc_text_select_handle_middle_mtrl_dark, c.a.e.abc_text_select_handle_right_mtrl_dark, c.a.e.abc_text_select_handle_left_mtrl_light, c.a.e.abc_text_select_handle_middle_mtrl_light, c.a.e.abc_text_select_handle_right_mtrl_light};

        /* renamed from: d, reason: collision with root package name */
        private final int[] f223d = {c.a.e.abc_popup_background_mtrl_mult, c.a.e.abc_cab_background_internal_bg, c.a.e.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e, reason: collision with root package name */
        private final int[] f224e = {c.a.e.abc_tab_indicator_material, c.a.e.abc_textfield_search_material};
        private final int[] f = {c.a.e.abc_btn_check_material, c.a.e.abc_btn_radio_material, c.a.e.abc_btn_check_material_anim, c.a.e.abc_btn_radio_material_anim};

        a() {
        }

        private boolean f(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i) {
            int c2 = r0.c(context, c.a.a.colorControlHighlight);
            return new ColorStateList(new int[][]{r0.f257b, r0.f259d, r0.f258c, r0.f}, new int[]{r0.b(context, c.a.a.colorButtonNormal), c.f.e.a.b(c2, i), c.f.e.a.b(c2, i), i});
        }

        private ColorStateList i(Context context) {
            return h(context, r0.c(context, c.a.a.colorAccent));
        }

        private ColorStateList j(Context context) {
            return h(context, r0.c(context, c.a.a.colorButtonNormal));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3];
            int[] iArr2 = new int[3];
            ColorStateList e2 = r0.e(context, c.a.a.colorSwitchThumbNormal);
            if (e2 == null || !e2.isStateful()) {
                iArr[0] = r0.f257b;
                iArr2[0] = r0.b(context, c.a.a.colorSwitchThumbNormal);
                iArr[1] = r0.f260e;
                iArr2[1] = r0.c(context, c.a.a.colorControlActivated);
                iArr[2] = r0.f;
                iArr2[2] = r0.c(context, c.a.a.colorSwitchThumbNormal);
            } else {
                iArr[0] = r0.f257b;
                iArr2[0] = e2.getColorForState(iArr[0], 0);
                iArr[1] = r0.f260e;
                iArr2[1] = r0.c(context, c.a.a.colorControlActivated);
                iArr[2] = r0.f;
                iArr2[2] = e2.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private void l(Drawable drawable, int i, PorterDuff.Mode mode) {
            if (e0.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = j.f219b;
            }
            drawable.setColorFilter(j.e(i, mode));
        }

        @Override // androidx.appcompat.widget.m0.e
        public Drawable a(m0 m0Var, Context context, int i) {
            if (i == c.a.e.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{m0Var.j(context, c.a.e.abc_cab_background_internal_bg), m0Var.j(context, c.a.e.abc_cab_background_top_mtrl_alpha)});
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0061 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
        @Override // androidx.appcompat.widget.m0.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean b(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.j.a()
                int[] r1 = r6.a
                boolean r1 = r6.f(r1, r8)
                r2 = 16842801(0x1010031, float:2.3693695E-38)
                r3 = -1
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L17
                int r2 = c.a.a.colorControlNormal
            L14:
                r8 = -1
            L15:
                r1 = 1
                goto L44
            L17:
                int[] r1 = r6.f222c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L22
                int r2 = c.a.a.colorControlActivated
                goto L14
            L22:
                int[] r1 = r6.f223d
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L2d
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                goto L14
            L2d:
                int r1 = c.a.e.abc_list_divider_mtrl_alpha
                if (r8 != r1) goto L3c
                r2 = 16842800(0x1010030, float:2.3693693E-38)
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                goto L15
            L3c:
                int r1 = c.a.e.abc_dialog_material_background
                if (r8 != r1) goto L41
                goto L14
            L41:
                r8 = -1
                r1 = 0
                r2 = 0
            L44:
                if (r1 == 0) goto L61
                boolean r1 = androidx.appcompat.widget.e0.a(r9)
                if (r1 == 0) goto L50
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L50:
                int r7 = androidx.appcompat.widget.r0.c(r7, r2)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.j.e(r7, r0)
                r9.setColorFilter(r7)
                if (r8 == r3) goto L60
                r9.setAlpha(r8)
            L60:
                return r5
            L61:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j.a.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // androidx.appcompat.widget.m0.e
        public ColorStateList c(Context context, int i) {
            if (i == c.a.e.abc_edit_text_material) {
                return c.a.k.a.a.c(context, c.a.c.abc_tint_edittext);
            }
            if (i == c.a.e.abc_switch_track_mtrl_alpha) {
                return c.a.k.a.a.c(context, c.a.c.abc_tint_switch_track);
            }
            if (i == c.a.e.abc_switch_thumb_material) {
                return k(context);
            }
            if (i == c.a.e.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i == c.a.e.abc_btn_borderless_material) {
                return g(context);
            }
            if (i == c.a.e.abc_btn_colored_material) {
                return i(context);
            }
            if (i == c.a.e.abc_spinner_mtrl_am_alpha || i == c.a.e.abc_spinner_textfield_background_material) {
                return c.a.k.a.a.c(context, c.a.c.abc_tint_spinner);
            }
            if (f(this.f221b, i)) {
                return r0.e(context, c.a.a.colorControlNormal);
            }
            if (f(this.f224e, i)) {
                return c.a.k.a.a.c(context, c.a.c.abc_tint_default);
            }
            if (f(this.f, i)) {
                return c.a.k.a.a.c(context, c.a.c.abc_tint_btn_checkable);
            }
            if (i == c.a.e.abc_seekbar_thumb_material) {
                return c.a.k.a.a.c(context, c.a.c.abc_tint_seek_thumb);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.m0.e
        public boolean d(Context context, int i, Drawable drawable) {
            LayerDrawable layerDrawable;
            Drawable findDrawableByLayerId;
            int i2;
            if (i == c.a.e.abc_seekbar_track_material) {
                layerDrawable = (LayerDrawable) drawable;
                l(layerDrawable.findDrawableByLayerId(R.id.background), r0.c(context, c.a.a.colorControlNormal), j.f219b);
                findDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.secondaryProgress);
                i2 = c.a.a.colorControlNormal;
            } else {
                if (i != c.a.e.abc_ratingbar_material && i != c.a.e.abc_ratingbar_indicator_material && i != c.a.e.abc_ratingbar_small_material) {
                    return false;
                }
                layerDrawable = (LayerDrawable) drawable;
                l(layerDrawable.findDrawableByLayerId(R.id.background), r0.b(context, c.a.a.colorControlNormal), j.f219b);
                findDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.secondaryProgress);
                i2 = c.a.a.colorControlActivated;
            }
            l(findDrawableByLayerId, r0.c(context, i2), j.f219b);
            l(layerDrawable.findDrawableByLayerId(R.id.progress), r0.c(context, c.a.a.colorControlActivated), j.f219b);
            return true;
        }

        @Override // androidx.appcompat.widget.m0.e
        public PorterDuff.Mode e(int i) {
            if (i == c.a.e.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }
    }

    public static synchronized j b() {
        j jVar;
        synchronized (j.class) {
            if (f220c == null) {
                h();
            }
            jVar = f220c;
        }
        return jVar;
    }

    public static synchronized PorterDuffColorFilter e(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter l;
        synchronized (j.class) {
            l = m0.l(i, mode);
        }
        return l;
    }

    public static synchronized void h() {
        synchronized (j.class) {
            if (f220c == null) {
                j jVar = new j();
                f220c = jVar;
                jVar.a = m0.h();
                f220c.a.u(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Drawable drawable, u0 u0Var, int[] iArr) {
        m0.w(drawable, u0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i) {
        return this.a.j(context, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable d(Context context, int i, boolean z) {
        return this.a.k(context, i, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList f(Context context, int i) {
        return this.a.m(context, i);
    }

    public synchronized void g(Context context) {
        this.a.s(context);
    }
}
