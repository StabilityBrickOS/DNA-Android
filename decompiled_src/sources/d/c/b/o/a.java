package d.c.b.o;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.util.Log;
import com.omarea.krscript.model.NodeInfoBase;
import com.omarea.krscript.model.PageNode;
import d.c.a.f.d;
import e.p.d.i;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a {
    private Context a;

    /* renamed from: d.c.b.o.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0105a extends ArrayList<ShortcutInfo> {
        final /* synthetic */ ShortcutInfo $info;

        C0105a(ShortcutInfo shortcutInfo) {
            this.$info = shortcutInfo;
            add(shortcutInfo);
        }

        public /* bridge */ boolean contains(ShortcutInfo shortcutInfo) {
            return super.contains((Object) shortcutInfo);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof ShortcutInfo) {
                return contains((ShortcutInfo) obj);
            }
            return false;
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ int indexOf(ShortcutInfo shortcutInfo) {
            return super.indexOf((Object) shortcutInfo);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof ShortcutInfo) {
                return indexOf((ShortcutInfo) obj);
            }
            return -1;
        }

        public /* bridge */ int lastIndexOf(ShortcutInfo shortcutInfo) {
            return super.lastIndexOf((Object) shortcutInfo);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof ShortcutInfo) {
                return lastIndexOf((ShortcutInfo) obj);
            }
            return -1;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ ShortcutInfo remove(int i) {
            return removeAt(i);
        }

        public /* bridge */ boolean remove(ShortcutInfo shortcutInfo) {
            return super.remove((Object) shortcutInfo);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj instanceof ShortcutInfo) {
                return remove((ShortcutInfo) obj);
            }
            return false;
        }

        public /* bridge */ ShortcutInfo removeAt(int i) {
            return (ShortcutInfo) super.remove(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return getSize();
        }
    }

    public a(Context context) {
        i.d(context, "context");
        this.a = context;
    }

    private final boolean b(Intent intent, Drawable drawable, NodeInfoBase nodeInfoBase) {
        try {
            Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            String str = "addin_" + nodeInfoBase.getIndex();
            intent2.putExtra("android.intent.extra.shortcut.NAME", nodeInfoBase.getTitle());
            intent2.putExtra("duplicate", false);
            if (drawable == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
            }
            intent2.putExtra("android.intent.extra.shortcut.ICON", ((BitmapDrawable) drawable).getBitmap());
            Intent intent3 = new Intent("android.intent.action.MAIN");
            Context applicationContext = this.a.getApplicationContext();
            ComponentName component = intent.getComponent();
            i.b(component);
            intent3.setClassName(applicationContext, component.getClassName());
            intent3.putExtras(intent);
            intent2.putExtra("android.intent.extra.shortcut.INTENT", intent3);
            intent3.setFlags(1082130432);
            this.a.sendBroadcast(intent2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private final String e(PageNode pageNode) {
        String valueOf = String.valueOf(System.currentTimeMillis());
        new d(this.a).c(pageNode, valueOf);
        return valueOf;
    }

    @TargetApi(26)
    public final boolean a(Intent intent, Drawable drawable, NodeInfoBase nodeInfoBase) {
        i.d(intent, "intent");
        i.d(drawable, "drawable");
        i.d(nodeInfoBase, "config");
        if (intent.hasExtra("page")) {
            Serializable serializableExtra = intent.getSerializableExtra("page");
            if (serializableExtra == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.krscript.model.PageNode");
            }
            intent.putExtra("shortcutId", e((PageNode) serializableExtra));
            intent.removeExtra("page");
        }
        return Build.VERSION.SDK_INT >= 26 ? c(intent, drawable, nodeInfoBase) : b(intent, drawable, nodeInfoBase);
    }

    @TargetApi(26)
    public final boolean c(Intent intent, Drawable drawable, NodeInfoBase nodeInfoBase) {
        i.d(intent, "intent");
        i.d(drawable, "drawable");
        i.d(nodeInfoBase, "config");
        try {
            Object systemService = this.a.getSystemService("shortcut");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.content.pm.ShortcutManager");
            }
            ShortcutManager shortcutManager = (ShortcutManager) systemService;
            if (!shortcutManager.isRequestPinShortcutSupported()) {
                return true;
            }
            String str = "addin_" + nodeInfoBase.getIndex();
            Intent intent2 = new Intent("android.intent.action.MAIN");
            Context applicationContext = this.a.getApplicationContext();
            ComponentName component = intent.getComponent();
            i.b(component);
            intent2.setClassName(applicationContext, component.getClassName());
            intent2.putExtras(intent);
            intent2.setFlags(1082130432);
            ShortcutInfo.Builder intent3 = new ShortcutInfo.Builder(this.a, str).setIcon(Icon.createWithBitmap(((BitmapDrawable) drawable).getBitmap())).setShortLabel(nodeInfoBase.getTitle()).setIntent(intent2);
            ComponentName component2 = intent.getComponent();
            i.b(component2);
            ShortcutInfo build = intent3.setActivity(component2).build();
            PendingIntent broadcast = PendingIntent.getBroadcast(this.a, 0, new Intent(), 134217728);
            if (!shortcutManager.isRequestPinShortcutSupported()) {
                return false;
            }
            for (ShortcutInfo shortcutInfo : shortcutManager.getPinnedShortcuts()) {
                i.c(shortcutInfo, "item");
                if (i.a(shortcutInfo.getId(), str)) {
                    shortcutManager.updateShortcuts(new C0105a(build));
                    return true;
                }
            }
            i.c(broadcast, "shortcutCallbackIntent");
            shortcutManager.requestPinShortcut(build, broadcast.getIntentSender());
            return true;
        } catch (Exception e2) {
            Log.e("ActionShortcutManager", "" + e2.getMessage());
            return false;
        }
    }

    public final PageNode d(String str) {
        i.d(str, "shortcutId");
        return (PageNode) new d(this.a).b(str);
    }
}
