package c.a.n;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;

/* loaded from: classes.dex */
public class d extends ContextWrapper {
    private int a;

    /* renamed from: b, reason: collision with root package name */
    private Resources.Theme f640b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f641c;

    /* renamed from: d, reason: collision with root package name */
    private Configuration f642d;

    /* renamed from: e, reason: collision with root package name */
    private Resources f643e;

    public d() {
        super(null);
    }

    public d(Context context, int i) {
        super(context);
        this.a = i;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f640b = theme;
    }

    private Resources b() {
        Resources resources;
        if (this.f643e == null) {
            Configuration configuration = this.f642d;
            if (configuration == null) {
                resources = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                resources = createConfigurationContext(configuration).getResources();
            } else {
                Resources resources2 = super.getResources();
                Configuration configuration2 = new Configuration(resources2.getConfiguration());
                configuration2.updateFrom(this.f642d);
                this.f643e = new Resources(resources2.getAssets(), resources2.getDisplayMetrics(), configuration2);
            }
            this.f643e = resources;
        }
        return this.f643e;
    }

    private void d() {
        boolean z = this.f640b == null;
        if (z) {
            this.f640b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f640b.setTo(theme);
            }
        }
        e(this.f640b, this.a, z);
    }

    public void a(Configuration configuration) {
        if (this.f643e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f642d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f642d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.a;
    }

    protected void e(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f641c == null) {
            this.f641c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f641c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f640b;
        if (theme != null) {
            return theme;
        }
        if (this.a == 0) {
            this.a = c.a.i.Theme_AppCompat_Light;
        }
        d();
        return this.f640b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.a != i) {
            this.a = i;
            d();
        }
    }
}
