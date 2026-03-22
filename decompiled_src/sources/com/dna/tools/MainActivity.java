package com.dna.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.n;
import com.dna.tools.k.a;
import com.omarea.common.ui.e;
import com.omarea.krscript.model.ActionNode;
import com.omarea.krscript.model.AutoRunTask;
import com.omarea.krscript.model.ClickableNode;
import com.omarea.krscript.model.KrScriptActionHandler;
import com.omarea.krscript.model.NodeInfoBase;
import com.omarea.krscript.model.PageNode;
import com.omarea.krscript.model.RunnableNode;
import d.c.b.p.a;
import d.c.b.p.r;
import d.c.d.a;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class MainActivity extends androidx.appcompat.app.c {

    /* renamed from: short, reason: not valid java name */
    private static final short[] f0short = {1007, 1010, 1022, 1007, 996, 1017, 995, 997, 996, 774, 801, 809, 812, 805, 804, 864, 820, 815, 864, 819, 820, 801, 818, 820, 864, 802, 821, 809, 812, 820, 877, 809, 814, 864, 806, 809, 812, 805, 864, 819, 805, 812, 805, 803, 820, 815, 818, 865, 2571, 2564, 2574, 2584, 2565, 2563, 2574, 2628, 2586, 2575, 2584, 2567, 2563, 2585, 2585, 2563, 2565, 2564, 2628, 2616, 2607, 2603, 2606, 2613, 2607, 2610, 2622, 2607, 2616, 2596, 2603, 2598, 2613, 2617, 2622, 2597, 2616, 2603, 2605, 2607, 1780, 1787, 1777, 1767, 1786, 1788, 1777, 1723, 1788, 1787, 1761, 1776, 1787, 1761, 1723, 1780, 1782, 1761, 1788, 1786, 1787, 1723, 1746, 1744, 1729, 1738, 1750, 1754, 1755, 1729, 1744, 1755, 1729, 1885, 1880, 1885, 1952, 1967, 1957, 1971, 1966, 1960, 1957, 2031, 1960, 1967, 1973, 1956, 1967, 1973, 2031, 1954, 1952, 1973, 1956, 1958, 1966, 1971, 1976, 2031, 1934, 1937, 1924, 1935, 1920, 1923, 1933, 1924, 975, 979, 978, 968, 917, 986, 971, 971, 983, 978, 984, 986, 975, 978, 980, 981, 1016, 980, 981, 975, 990, 963, 975, 594, 579, 581, 583, 620, 589, 582, 583, 1691, 1713, 1699, 1720, 1721, 1664, 1698, 1717, 1718, 1699, 984, 983, 972, 973, 970, 1010, 991, 971, 976, 989, 982, 774, 792, 794, 824, 818, 830, 798, 803, 777, 776, 770, 828, 778, 787, 786, 864, 818, 809, 786, 790, 818, 829, 820, 803, 817, 776, 798, 831, 1232, 1246, 1235, 1196, 1232, 1244, 1243, 1259, 1216, 1230, 1261, 1265, 1274, 1195, 1265, 1257, 1236, 1217, 1216, 1249, 2384, 2399, 2372, 2373, 2370, 2426, 2391, 2371, 2392, 2389, 2398, 2532, 2539, 2542, 2535, 760, 756, 764, 763, 714, 737, 756, 759, 765, 762, 742, 737, 495, 493, 508, 475, 508, 506, 481, 486, 495, 416, 474, 422, 507, 508, 506, 481, 486, 495, 422, 508, 489, 490, 471, 480, 487, 485, 493, 417, 2067, 2079, 2071, 2064, 2081, 2058, 2079, 2076, 2070, 2065, 2061, 2058, 2081, 2077, 2062, 2059, 1082, 1080, 1065, 1038, 1065, 1071, 1076, 1075, 1082, 1141, 1039, 1139, 1070, 1065, 1071, 1076, 1075, 1082, 1139, 1069, 1073, 1080, 1084, 1070, 1080, 1026, 1066, 1084, 1076, 1065, 1140, 1553, 1559, 1554, 1554, 1549, 1552, 1558, 1572, 1552, 1539, 1541, 1551, 1543, 1548, 1558, 1583, 1539, 1548, 1539, 1541, 1543, 1552, 774, 786, 769, 775, 781, 773, 782, 788, 813, 769, 782, 769, 775, 773, 786, 846, 770, 773, 775, 777, 782, 820, 786, 769, 782, 787, 769, 771, 788, 777, 783, 782, 840, 841, 2919, 2920, 2914, 2932, 2921, 2927, 2914, 2856, 2934, 2915, 2932, 2923, 2927, 2933, 2933, 2927, 2921, 2920, 2856, 2900, 2883, 2887, 2882, 2905, 2883, 2910, 2898, 2883, 2900, 2888, 2887, 2890, 2905, 2901, 2898, 2889, 2900, 2887, 2881, 2883, 680, 679, 685, 699, 678, 672, 685, 743, 697, 684, 699, 676, 672, 698, 698, 672, 678, 679, 743, 670, 667, 640, 669, 652, 662, 652, 657, 669, 652, 667, 647, 648, 645, 662, 666, 669, 646, 667, 648, 654, 652, 679, 700, 677, 677, 745, 682, 680, 679, 679, 678, 701, 745, 683, 684, 745, 682, 680, 698, 701, 745, 701, 678, 745, 679, 678, 679, 740, 679, 700, 677, 677, 745, 701, 688, 697, 684, 745, 680, 679, 685, 699, 678, 672, 685, 689, 743, 680, 697, 697, 682, 678, 676, 697, 680, 701, 743, 702, 672, 685, 686, 684, 701, 743, 669, 678, 678, 677, 683, 680, 699, 1677, 1669, 1678, 1685, 2415, 2407, 2412, 2423, 2348, 2404, 2411, 2412, 2406, 2379, 2422, 2407, 2415, 2346, 2384, 2348, 2411, 2406, 2348, 2403, 2401, 2422, 2411, 2413, 2412, 2397, 2405, 2416, 2403, 2418, 2410, 2347, 2959, 2947, 2955, 2956, 3005, 2966, 2947, 2944, 2954, 2957, 2961, 2966, 3005, 2945, 2962, 2967, 1853, 1824, 1841, 1849, 1218, 1220, 1239, 1240, 1221, 1222, 1239, 1220, 1235, 1240, 1218, 1251, 1247, 2657, 2668, 2676, 2658, 2680, 2681, 2733, 2722, 2728, 2750, 2723, 2725, 2728, 2786, 2751, 2729, 2744, 2744, 2725, 2722, 2731, 2751, 2786, 2701, 2716, 2716, 2688, 2693, 2703, 2701, 2712, 2693, 2691, 2690, 2707, 2696, 2697, 2712, 2701, 2693, 2688, 2719, 2707, 2719, 2697, 2712, 2712, 2693, 2690, 2699, 2719, 1034, 1051, 1049, 1041, 1051, 1053, 1055};
    private HashMap C;
    private r.b z;
    private final com.omarea.common.ui.h w = new com.omarea.common.ui.h(this, null, 2, null);
    private Handler x = new Handler();
    private com.dna.tools.e y = new com.dna.tools.e();
    private final int A = 65400;
    private final int B = 65300;

    /* loaded from: classes.dex */
    public static final class a implements KrScriptActionHandler {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f960b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ PageNode f961c;

        a(boolean z, PageNode pageNode) {
            this.f960b = z;
            this.f961c = pageNode;
        }

        @Override // com.omarea.krscript.model.KrScriptActionHandler
        public void addToFavorites(ClickableNode clickableNode, KrScriptActionHandler.AddToFavoritesHandler addToFavoritesHandler) {
            PageNode pageNode;
            e.p.d.i.d(clickableNode, "clickableNode");
            e.p.d.i.d(addToFavoritesHandler, "addToFavoritesHandler");
            if (clickableNode instanceof PageNode) {
                pageNode = (PageNode) clickableNode;
            } else if (!(clickableNode instanceof RunnableNode)) {
                return;
            } else {
                pageNode = this.f961c;
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(MainActivity.this.getApplicationContext(), (Class<?>) ActionPage.class));
            intent.addFlags(8388608);
            intent.addFlags(1073741824);
            if (clickableNode instanceof RunnableNode) {
                intent.putExtra("autoRunItemId", clickableNode.getKey());
            }
            intent.putExtra("page", pageNode);
            addToFavoritesHandler.onAddToFavorites(clickableNode, intent);
        }

        @Override // com.omarea.krscript.model.KrScriptActionHandler
        public void onActionCompleted(RunnableNode runnableNode) {
            e.p.d.i.d(runnableNode, "runnableNode");
            if (runnableNode.getAutoFinish()) {
                MainActivity.this.finishAndRemoveTask();
            } else if (runnableNode.getReloadPage()) {
                if (this.f960b) {
                    MainActivity.m38xa9667016(MainActivity.this);
                } else {
                    MainActivity.m57x924a9a5c(MainActivity.this);
                }
            }
        }

        @Override // com.omarea.krscript.model.KrScriptActionHandler
        public void onSubPageClick(PageNode pageNode) {
            e.p.d.i.d(pageNode, "pageNode");
            MainActivity.this.H(pageNode);
        }

        @Override // com.omarea.krscript.model.KrScriptActionHandler
        public boolean openFileChooser(r.b bVar) {
            e.p.d.i.d(bVar, "fileSelectedInterface");
            return MainActivity.m21x72e6861a(MainActivity.this, bVar);
        }

        @Override // com.omarea.krscript.model.KrScriptActionHandler
        public boolean openParamsPage(ActionNode actionNode, View view, Runnable runnable) {
            e.p.d.i.d(actionNode, "actionNode");
            e.p.d.i.d(view, "view");
            e.p.d.i.d(runnable, "onCompleted");
            return KrScriptActionHandler.DefaultImpls.openParamsPage(this, actionNode, view, runnable);
        }
    }

    /* loaded from: classes.dex */
    static final class b implements TabHost.OnTabChangeListener {
        final /* synthetic */ com.dna.tools.ui.c a;

        b(com.dna.tools.ui.c cVar) {
            this.a = cVar;
        }

        @Override // android.widget.TabHost.OnTabChangeListener
        public final void onTabChanged(String str) {
            this.a.b();
        }
    }

    /* loaded from: classes.dex */
    static final class c implements Runnable {
        final /* synthetic */ com.dna.tools.ui.c f;

        /* loaded from: classes.dex */
        static final class a implements Runnable {
            final /* synthetic */ ArrayList f;
            final /* synthetic */ PageNode g;
            final /* synthetic */ ArrayList h;
            final /* synthetic */ PageNode i;

            a(ArrayList arrayList, PageNode pageNode, ArrayList arrayList2, PageNode pageNode2) {
                this.f = arrayList;
                this.g = pageNode;
                this.h = arrayList2;
                this.i = pageNode2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.m10x4aee29eb(MainActivity.this).a();
                ArrayList arrayList = this.f;
                if (arrayList == null || arrayList.size() <= 0) {
                    FrameLayout frameLayout = (FrameLayout) MainActivity.this.G(g.main_tabhost_2);
                    e.p.d.i.c(frameLayout, "main_tabhost_2");
                    frameLayout.setVisibility(8);
                } else {
                    MainActivity mainActivity = MainActivity.this;
                    ArrayList arrayList2 = this.f;
                    PageNode pageNode = this.g;
                    e.p.d.i.c(pageNode, "favoritesConfig");
                    MainActivity.m49x6284ac82(mainActivity, arrayList2, pageNode);
                    c cVar = c.this;
                    com.dna.tools.ui.c cVar2 = cVar.f;
                    String string = MainActivity.this.getString(R.string.tab_favorites);
                    e.p.d.i.c(string, "getString(R.string.tab_favorites)");
                    Drawable c2 = c.f.d.a.c(MainActivity.this, R.drawable.tab_favorites);
                    e.p.d.i.b(c2);
                    e.p.d.i.c(c2, "ContextCompat.getDrawabl…drawable.tab_favorites)!!");
                    cVar2.a(string, c2, R.id.main_tabhost_2);
                }
                ArrayList arrayList3 = this.h;
                if (arrayList3 == null || arrayList3.size() <= 0) {
                    FrameLayout frameLayout2 = (FrameLayout) MainActivity.this.G(g.main_tabhost_3);
                    e.p.d.i.c(frameLayout2, "main_tabhost_3");
                    frameLayout2.setVisibility(8);
                    return;
                }
                MainActivity mainActivity2 = MainActivity.this;
                ArrayList arrayList4 = this.h;
                PageNode pageNode2 = this.i;
                e.p.d.i.c(pageNode2, "page2Config");
                MainActivity.m15xe3129ec9(mainActivity2, arrayList4, pageNode2);
                c cVar3 = c.this;
                com.dna.tools.ui.c cVar4 = cVar3.f;
                String string2 = MainActivity.this.getString(R.string.tab_pages);
                e.p.d.i.c(string2, "getString(R.string.tab_pages)");
                Drawable c3 = c.f.d.a.c(MainActivity.this, R.drawable.tab_pages);
                e.p.d.i.b(c3);
                e.p.d.i.c(c3, "ContextCompat.getDrawabl…, R.drawable.tab_pages)!!");
                cVar4.a(string2, c3, R.id.main_tabhost_3);
            }
        }

        c(com.dna.tools.ui.c cVar) {
            this.f = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PageNode e2 = MainActivity.m35xd96af4d0(MainActivity.this).e();
            PageNode d2 = MainActivity.m35xd96af4d0(MainActivity.this).d();
            MainActivity mainActivity = MainActivity.this;
            e.p.d.i.c(e2, "page2Config");
            ArrayList m1xcf053d4b = MainActivity.m1xcf053d4b(mainActivity, e2);
            MainActivity mainActivity2 = MainActivity.this;
            e.p.d.i.c(d2, "favoritesConfig");
            MainActivity.m32x66e48bbc(MainActivity.this).post(new a(MainActivity.m1xcf053d4b(mainActivity2, d2), d2, m1xcf053d4b, e2));
        }
    }

    /* loaded from: classes.dex */
    static final class d implements View.OnClickListener {
        final /* synthetic */ i f;

        d(i iVar) {
            this.f = iVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
            }
            CompoundButton compoundButton = (CompoundButton) view;
            boolean isChecked = compoundButton.isChecked();
            if (!isChecked || MainActivity.m62x16aa0d6e(MainActivity.this, "android.permission.READ_EXTERNAL_STORAGE")) {
                this.f.b(isChecked);
            } else {
                compoundButton.setChecked(false);
                Toast.makeText(MainActivity.this, R.string.kr_write_external_storage, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e implements Runnable {

        /* loaded from: classes.dex */
        static final class a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ArrayList f966e;
            final /* synthetic */ e f;
            final /* synthetic */ PageNode g;

            a(ArrayList arrayList, e eVar, PageNode pageNode) {
                this.f966e = arrayList;
                this.f = eVar;
                this.g = pageNode;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MainActivity mainActivity = MainActivity.this;
                ArrayList arrayList = this.f966e;
                PageNode pageNode = this.g;
                e.p.d.i.c(pageNode, "favoritesConfig");
                MainActivity.m49x6284ac82(mainActivity, arrayList, pageNode);
            }
        }

        e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            PageNode d2 = MainActivity.m35xd96af4d0(MainActivity.this).d();
            MainActivity mainActivity = MainActivity.this;
            e.p.d.i.c(d2, "favoritesConfig");
            ArrayList m1xcf053d4b = MainActivity.m1xcf053d4b(mainActivity, d2);
            if (m1xcf053d4b != null) {
                MainActivity.m32x66e48bbc(MainActivity.this).post(new a(m1xcf053d4b, this, d2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class f implements Runnable {

        /* loaded from: classes.dex */
        static final class a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ArrayList f968e;
            final /* synthetic */ f f;
            final /* synthetic */ PageNode g;

            a(ArrayList arrayList, f fVar, PageNode pageNode) {
                this.f968e = arrayList;
                this.f = fVar;
                this.g = pageNode;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MainActivity mainActivity = MainActivity.this;
                ArrayList arrayList = this.f968e;
                PageNode pageNode = this.g;
                e.p.d.i.c(pageNode, "page2Config");
                MainActivity.m15xe3129ec9(mainActivity, arrayList, pageNode);
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            PageNode e2 = MainActivity.m35xd96af4d0(MainActivity.this).e();
            MainActivity mainActivity = MainActivity.this;
            e.p.d.i.c(e2, "page2Config");
            ArrayList m1xcf053d4b = MainActivity.m1xcf053d4b(mainActivity, e2);
            if (m1xcf053d4b != null) {
                MainActivity.m32x66e48bbc(MainActivity.this).post(new a(m1xcf053d4b, this, e2));
            }
        }
    }

    /* renamed from: B̷̭̫̫͈̯̽͑̿̓́̋͜͝u̸̡̧͎͓̰̗͗̋̎̂͊̈͂̐̉͘̚͘͝ư̧̨̛̭̗̭̹͋̋̃̌͂̃̑̂͋̎̉̃̕͝ê̶̶̡̜̹͈̥̺̆͌̌͑͑͑͜͝͝Ḵ̸̟̹͉̖͚̮͎̮̫̭̲̻̋̑̏̑̂͌̋͑̔́͜͝l̫̹͂K̴̹͓̭͐̉͝u̒ã̧̫̹̙͚̘̺̅͗̅̆̋̕͜͠p͠P̸̴̴̢̛̯̙̺̟̫̭̹̗̎̌̏̅̂̄̾̀̂́̂̿̕̚͜͝͝͝l̶̵̷̢̢̛̛̥̖̹̙͈̱̫̬͎̫̱͉̔̐̓̉̏̌̿͐͒̏̏͌̃̃̍̂̋̂̇͘͜͜͜͝͝͝͠B̢̧̯͓̻̦̀́̃̌̆a̸̫̝͇̬͓̾̇ȁ̷̛̺̑͌̈ä͎̈́ḁ̶̢͚̱̙͈͎̫͎͈̫͚̎͌̃͌̋̈́̌̿̋̚͜͝͝͠n̶̸̶̵̫͎̮̟͓͖̥̎͑̆̍̉͗͌̊̃̚, reason: contains not printable characters */
    public static ArrayList m0x1216a0a6(Object obj) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() >= 0) {
            return ((d.c.b.l.c) obj).b();
        }
        return null;
    }

    /* renamed from: K̀͘ṍ̷̸̯͚̘̹̦̱͈̝͙̠̼̫̲̰̦̓̓̈́̾̋̑̒͊͐͌̓̚ŭ̂ṵ̶̡̖͈̱̫̮̥̠̝͑̅̄͐̓͋͋͒͌̌͜͝͠͝B̗̹͌́̋̂͐͗̑͠ù̴̢̯̰͓̽̈́̓̿́̆͗ō̧̢͉̫̯̥̯͈͈̺̲̲͗͆͌̎͗̉̍͌͐͌͊̑̔̌͘͜͝͠ò̴̧̡̘͚̋͜ö̸̺̪̼̹͎̔̇͘͝ę̲̩̻̈́̽̐ͅo̧̡͓̲͈͗͗̅͝ä̢̧̧̫̘̖̭̪̦̲͓̤̭̹͎̦͚̺͎̮̮͚̯̞̭̮́̆̈́̌̋͗͂̀̏͐̾̈́̋̈́̃̔͘͘͜͠͝͝͝u̸̠̫̦̺͈̱͐̌͒ỗ̸̝͕͎̻͌̄͑̎͘u̷̵̴̧̨̨̩̗͉̫̯̲̺̭͙̹̯̗̱̤̠̦̱̫͓̩̺̬͌̌̏͌̅́̋̀͑̾̈́̈̃̌̽͌͆̑̈́̂̅͑͗͐̏͆̌͋͗̂̂́̚̚̕͝, reason: contains not printable characters */
    public static ArrayList m1xcf053d4b(Object obj, Object obj2) {
        if (ccooopahacBnhcacooKa.m76xf651d881() >= 0) {
            return ((MainActivity) obj).V((PageNode) obj2);
        }
        return null;
    }

    /* renamed from: Ķ̭a̷̧̝̦͙͕̬̦̗̩̹͉̥̘͌̿̋̈̅â̶͚͌̔̋a̤͉ťB̼̃ü̮e̢̯̾̎B̛̩̪͓̬͂̇̆̄͜hc̸̨̛͖͈̞͙͑͗̿͗̑̋̂̃̌͘ą̶̘͈̮̱̘̹̱̙̌͂͌̌̈͑̌̚͜͜͝ȁa̫̹K̩̗̖̫͈̃̅͑͋̔͜͝ľ̫̌k̵̷̴̢͎̭̯̥͈̥̀̏̄̆̄̀͘͝ö͉̭̟̔̔̋͌̐͌̆̋a̸̵̧̡̭̖̤͉͎̭͚̍̈͋̑̾͋̒̂͜K̗̪̯̼͌̚͘l̴̹a̷̸̱̭̥̘͚̫̫̦̯̘͋͌͋̌͒̈̾͐̋̿̌̈̔̈́͜͠͝͝c̄B̛a̸̵͎͎̍͜͜o̧̠̍͆̏͜͠l̸̯̗̖̞̦̲̬͌̔̚B̰K̢̙̥̖̈̑K̵̵̢̡̛̛̮̟̫̯̫͕͎͕̬̰̫̹̦̈́̌́̄͌͒̌̒̌̃̂̑̌̑̈͑̊̍͗͐̚͜͝͝, reason: contains not printable characters */
    public static void m2xd4b3858f(Object obj) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() > 0) {
            e.p.d.i.b(obj);
        }
    }

    /* renamed from: Ķ̸̸̶̢̱̘̞͉̭̤̭̤͚̬̐̋̐̿͌̈̈́̈́̋̐͌͑̀͒͠B̢̨̻̥̗͚̺̾̀͠u̶̱̐k̵̩̙͈̗͚̋̅̌̈́̈̑̋͝ȃ̸̡k̸͘õ̸̶̧̫̻͉͚̌a̘̗͗͒͘ố̧͈̤͎̤̅̑͜͜͝͝͠P̷̢̢͕̹̦̞͈͙̝̭̗̃̌̈́͊͗̑͌̎͝͠͝͝ä̴́̑̚͘l̸̸̶̶̴̢̛͓̘̫̲̹͇̭͓̥̗͉̦̫͉̞͑͗͊̌̔́̈́̑̉͆͑͂̈́͊̋̎̏͘̚͜͜͝͠ơ̶̷̧̧̧̻̻͙̗̰̹͚͚͕͚̰͓̬̺̑̋̆̌̑͑̑͗͌̀̍̆͘͜͝͝a͜ơ̵̧͎̲͙̺͈̺̘͈̹̖͉̑̎̄̈̂̃̑͋̈́̎͜͝͝K̷̡͚̦̯̺̹̼͎͓̯̬̘͆͗̇̈́͗̋͑͋̋͗̋̅͜͝a̧͐͌á̷̡͚͙̥͕̼̑̍̔͝a̶̢͕̦̮̖̋̔̄̑͜, reason: contains not printable characters */
    public static boolean m3x958516f3(Object obj) {
        if (ccooopahacBnhcacooKa.m76xf651d881() >= 0) {
            return ((a.C0057a) obj).a();
        }
        return false;
    }

    /* renamed from: K͓K̶̨̦͚̭̈́͐͒͌̿̔̓͝a̰͈̤̗͒͗͘͜͠n̫͙͝c̷̝̫̩̀̀ú̸̠̥̔͘n̶̷̯͓̺̭̦͉͙͉̫͋̈́̎̑̑̑̋̄̿̌̊̔̅ͅK̐͌c̑a̗͈̹͎̅́̿̄ņ̲̭̻͓̄̿̋͊͌͊͆͆͜͝o̦̪̊͑͘Ka͗a̺̰͘͝K̴͈̭̺̃̅̋͐̃͑a̓o̮͘K͓̦̫̈͊l̖p̧̡͙̗̦͕̭͑̎́̐h̎͘͜ǎ̴̭̜̱͕̯̫͐̾̂̒͗͘͘͝p͐h͋ǒ̸̢̧̱͈̫̱̹̯̿͋̈́̃̑͋͜a̸̶̸̧̼͕̗̭͋̋͂̀͋̅͜͝ư̸̵̸̢͈̺̭̌͌̐̅͌ȩ̴̷̸̜̱̂͋̎̊͐̇͜͜ǒ̡̨̝̪͖͕̬͐͘e̸̖̱̫̫̞͂̌̏͗̃̎̃̍̄̂͌̒̾̚͝u̸̷̸̷̪̤̲̯̺͑̆̄̀̓͋̿̅͋͜͝a̧̋͠t̺̱, reason: contains not printable characters */
    public static androidx.fragment.app.i m4x7e64ae96(Object obj) {
        if (occatKolokBtoapaKaPhp.m184x48849b02() <= 0) {
            return ((androidx.fragment.app.d) obj).o();
        }
        return null;
    }

    /* renamed from: P̷̴̷̷̸̸̢̧̧̡͉̮̯͚͓͚̠̹̗̟̏͌̾͂̃̌̾͂̊̎̏̎͂͌̑̈̋͘͜͝͠͝ͅt̗ḁ̺̐̋̾̅̅̈́͘͜͜a̦o̗̗͘͝͝ḽ̢̫̙̮̫̫̠̲͓̍̋͊́̈̅̃͌͘p̸̷̷̷̧͚̲̭̠̦͎̹̫̅̍̈̂̃̅̌̋̂̌͘͜͝͠ȏ̦̹̎͜͠kl̴͌̀̌̊͊̚͝o̧̤̗̎̌ä̷͎̠̗̜̫́̋̏̂ė̫̲̘̚͝͝k̯̭̫̫̮̀̐̋̈́͝l̷̈́h̴̢̧̋̋̕͝K̴̸̸̷̵̸̶̸̢̢͓͉̼̪͈̫̬̤̗̬͉͕͖̪̼̗̻̱̦̪̜͈̹̫͌͌̎͒͗͌̂̄͑̿̈́͐̎͒́͗̎̇̐̅̈́̐̂̋̈́̿͗͆͗̅͋̋̑̕͘͘͜͠͠͝͠͝͝͝͝ͅa̡̗̬̥̺̠͌̈̎̈̄͘͘͝͝ą̸̸̧͚̪̜̱͚͉̫͓̀̾̀̑͌̂͌̃̽͝͠͝, reason: contains not printable characters */
    public static e.a m5xa9480f() {
        if (occatKolokBtoapaKaPhp.m184x48849b02() < 0) {
            return com.omarea.common.ui.e.f1255b;
        }
        return null;
    }

    /* renamed from: P͓͋̾̑ǫ̷̸̷̢̧̛̦͉̰̫̝͉͉͕̦̜̺̰̜̹͇̞̰̫̘̞͈͈͓̹̫̯̤̌̄̔̋̈́͗̆́͌̈́̈̄͂̿͋̉̅͂̌͐̑͗̈́̇̄͗͒̋͊̂̋͗̔̓̈́͌̂͜͠͠B̸̷̧̨̢̤͇̺̹̭̯̰͎̰̾͋̂̈́͑͐͒͌̾̂̔̋̑͜͝t̸̴̷̷̵̢̨̧̛͈̱̗͚̫̫̰̭͉͓̼̟̫̲̞̰̩̲̗͉̄̑̃̇͒͌͑̃̈́̃̂̐͒̂͌̃͌͊̈̑̊̕͘͠͝͝͠͝͝K̴̴̴̢̨̛̮̘̥͖̯͇̖̘͈̫̺̻͎͒̅͗͋̂̈́̔̂̅͗͆̀͐̈́͘̚͠͝͠͝͝a̧̭̼̯̹͉͇͕̎̾́̑̐̑͆͗̄͝͝ȁḽ̸̢͉̞͙̱͌̌̕n̛̮̈́͗͌͂͝͝ư̴̸̴̸̸̶̢͇̭̹̗̝̖̗̺͓̤̍̌̈́̑̈́̓͐̄̌͠͝͠͝u̷̴̢̺̦̝͌͂͂̄̈́͗̆͝P, reason: contains not printable characters */
    public static short[] m6xfaf58400() {
        if (ccooopahacBnhcacooKa.m76xf651d881() >= 0) {
            return f0short;
        }
        return null;
    }

    private final boolean S(String str) {
        return m54x196e6e9d(this, str) == 0;
    }

    private final void T(String str) {
        try {
            Intent intent = new Intent(this, (Class<?>) ActivityFileSelector.class);
            opPnkpaatkaatonataKpceo.m231x59f78359(intent, m56x889e8dee(m6xfaf58400(), 1748834 ^ m12xee631403(ccooopahacBnhcacooKa.m83x6d375beb()), 1750730 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m169xf4662ea1()), 1750292 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m170xf4fc5c45())), str);
            m13x57bf86ac(this, intent, m9x1273c6e5(this));
        } catch (Exception unused) {
            ccooopahacBnhcacooKa.m73xdb74fd44(opPnkpaatkaatonataKpceo.m260xd40377fe(this, m27x81b8dc41(m6xfaf58400(), 1755385 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m137x1273c6e5()), 1752576 ^ m12xee631403(ccooopahacBnhcacooKa.m117x5e62fd7()), 1750341 ^ m12xee631403(opPnkpaatkaatonataKpceo.m236x32e4b550())), 0));
        }
    }

    private final boolean U(r.b bVar) {
        if (khoeKettlaaaaaKnPPanaBkoa.m136xdf1b17fc() >= 23) {
            String m56x889e8dee = m56x889e8dee(m6xfaf58400(), 1755509 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m129x8add41ef()), 1752493 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m133x4a4665b3()), 1752271 ^ m12xee631403(ccooopahacBnhcacooKa.m82x53e9a1ae()));
            if (ccooopahacBnhcacooKa.m105xd083eab6(this, m56x889e8dee) != 0) {
                ccooopahacBnhcacooKa.m73xdb74fd44(opPnkpaatkaatonataKpceo.m260xd40377fe(this, occatKolokBtoapaKaPhp.m181xa54dcf47(this, (((2132118848 ^ 1485) ^ 9992) ^ 7337) ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m165x250d490b())), 1));
                ccooopahacBnhcacooKa.m99xbb68dd38(this, new String[]{m56x889e8dee}, 2);
                return false;
            }
        }
        try {
            String m55xe4fe62a4 = m55xe4fe62a4(bVar);
            if (m55xe4fe62a4 != null) {
                if (khoeKettlaaaaaKnPPanaBkoa.m157x35bd63a9(m55xe4fe62a4) > 0) {
                    m29xf5d0e302(this, m55xe4fe62a4);
                    this.z = bVar;
                    return true;
                }
            }
            Intent intent = new Intent(m47x474ecb7c(m6xfaf58400(), 1752496 ^ m12xee631403(occatKolokBtoapaKaPhp.m217xc4f218f1()), 1752584 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m166xeb550369()), 1748341 ^ m12xee631403(opPnkpaatkaatonataKpceo.m254x8d928166())));
            String m25x58fc39e6 = m25x58fc39e6(bVar);
            if (m25x58fc39e6 == null) {
                m25x58fc39e6 = m56x889e8dee(m6xfaf58400(), 1749755 ^ m12xee631403(occatKolokBtoapaKaPhp.m218xa20dd4ad()), 1748710 ^ m12xee631403(ccooopahacBnhcacooKa.m88x296264a9()), 1749428 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m169xf4662ea1()));
            }
            ccooopahacBnhcacooKa.m120x6618c209(intent, m25x58fc39e6);
            opPnkpaatkaatonataKpceo.m233x11794613(intent, m26x3d83010(m6xfaf58400(), 1754723 ^ m12xee631403(opPnkpaatkaatonataKpceo.m249xd525b820()), 1754407 ^ m12xee631403(occatKolokBtoapaKaPhp.m195xace00977()), 1744987 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m125x981823cb())));
            m13x57bf86ac(this, intent, m65x96994b02(this));
            this.z = bVar;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private final ArrayList<NodeInfoBase> V(PageNode pageNode) {
        ArrayList<NodeInfoBase> m0x1216a0a6 = khoeKettlaaaaaKnPPanaBkoa.m157x35bd63a9(m63x69e6ad92(pageNode)) > 0 ? m0x1216a0a6(new d.c.b.l.c(this, m63x69e6ad92(pageNode), null)) : null;
        if (m0x1216a0a6 != null) {
            return m0x1216a0a6;
        }
        if (!(khoeKettlaaaaaKnPPanaBkoa.m157x35bd63a9(m20xd17ffaf7(pageNode)) > 0)) {
            return m0x1216a0a6;
        }
        Context m154x6e784d3f = khoeKettlaaaaaKnPPanaBkoa.m154x6e784d3f(this);
        m58xaa9f4961(m154x6e784d3f, m26x3d83010(m6xfaf58400(), 1754454 ^ m12xee631403(occatKolokBtoapaKaPhp.m173x3a3e3fab()), 1750697 ^ m12xee631403(occatKolokBtoapaKaPhp.m188x5c7322aa()), 1749497 ^ m12xee631403(occatKolokBtoapaKaPhp.m179x82acaa9b())));
        return m59x6d45c122(new d.c.b.l.b(m154x6e784d3f, m20xd17ffaf7(pageNode), null));
    }

    private final KrScriptActionHandler W(PageNode pageNode, boolean z) {
        return new a(z, pageNode);
    }

    private final String X(Uri uri) {
        try {
            return m53x250d490b(new d.c.a.f.a(), this, uri);
        } catch (Exception unused) {
            return null;
        }
    }

    private final void Y() {
        opPnkpaatkaatonataKpceo.m226xc3750731(new Thread(new e()));
    }

    private final void Z() {
        opPnkpaatkaatonataKpceo.m226xc3750731(new Thread(new f()));
    }

    private final void a0(ArrayList<NodeInfoBase> arrayList, PageNode pageNode) {
        d.c.b.p.a m8x59e49f59 = m8x59e49f59(m42x66ea8a7(), arrayList, m51xdcc43825(this, pageNode, true), null, m34x64582924(m23xa0e0a96b()));
        n m40x4c1febbb = m40x4c1febbb(m4x7e64ae96(this));
        m22x2ca01c66(m40x4c1febbb, R.id.list_favorites, m8x59e49f59);
        m18xdd64949d(m40x4c1febbb);
    }

    /* renamed from: aaK̸̹͚͊̎͜u̧̲̺͌̀K̛̲͂͂͗̀͜P̯̼͓̩̫̘̯͎̆͆̌̈́̋̑̌̈́͗͋͜B̺͈̰̹̙̄̑̂͑̊̌̚ą̵̸̨͎̝͚̗̖͉̹̻͚̌̋̍̅͂̍̾͐̅͒̚͜͜͝a̸̵̡̘͙̯͉̩͎̺͂̾͒͝K̶̷̵̬̥̦͓̅́̐͗͑̋͋̈̌͠P̸̵̷̢̰̠̺̻̭̱̬̄̃͌́̅̏̂͘͝͝ŏ̡̹̪͙̫̹̂́̋͌̆͊̊̕̚͝B͎̺͓͎̱̱̈̈̎̀̌̀̋̾ͅP̷̱͌k̷̸̢̫̝̗͚̫̯͎̯̞̠̠͌̋͋̋̉̐̐̏͌͋͊͋̂͘͠ͅő͙̱ä̧̛ǫ̵̢̨̛̖̲̮͓͙̻̠̘̙̙̋͒͋̍̃͂̽̈́͑͑̽͋͋͑̑̄͝o̷̰̻̻̫͌̆̉a̢̧̼̺̹̫͇̅̽͑̌͋̐̇̌͘͠͠ȧ̷̢̗̺̦̞̱̫͚̪̃̂̈͐̌̔̈̌͜͝u, reason: contains not printable characters */
    public static Boolean m7x84b00e5d(Object obj) {
        if (aalloKKholeaacllnou.m68xcb69398c() < 0) {
            return ((a.C0116a) obj).a();
        }
        return null;
    }

    /* renamed from: ã̶̧̧̡̠̺̱͚̮̀̃̔͝a̶̷̸̖̫͙̲̠̾͗Ḃ̶̫͈̈͠h̴̷͂̃ô̭̯͉͌͋͌̇̿̋͜͜͠͝a̷K̸̨̨͖͉̭̺̼͈̱̏̈́̌̿̐̉͑̾̏͌̚K̵͚̻̘͓͙̏͐͂͘ç̢̛͈̥̻̖̫͉̜̄́̄̄̈ä̷̧͎̰͈̰̩̥̱̭̘̻͋̈Kő̵͚͉̈́̈́h̶̴̸̴̷̸̸̵̠̫̭̮̫͇̻̫̼̺͚̩̰̯̮͚̭̫̫̦͌̂͆͆̌̌͂͌̌̈́̂͋̔̔̌͌̊̂̈́̈́̌͐̕͜͜͝K͕͓̋ķ̯̺͊̆͌͑̎͘̚͝a̸͇̭̭͈͋͗̾͗̃̏͘p̵̘̭̻̯̈̏̿̐̊̅̕͝ä̢̭̜̫͈̠́̂͋͌͌̒͗͋̾a̶̷̛͎̼̜͉̔̈̈͝e͙̩͎̿̌́̓͑͜P̫̎͋͠p̧̗͓̰͖͋̐̒̐̃͑̅̈́̀͘͝͝á̒o̵̶̥͚͐͗͘͠͠, reason: contains not printable characters */
    public static d.c.b.p.a m8x59e49f59(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        if (occatKolokBtoapaKaPhp.m184x48849b02() < 0) {
            return ((a.C0106a) obj).a((ArrayList) obj2, (KrScriptActionHandler) obj3, (AutoRunTask) obj4, (com.omarea.common.ui.i) obj5);
        }
        return null;
    }

    /* renamed from: a̋Ķ̶̴̱̹̲̪͇̯̗̱̘̱̰̱̲̲̙̯̩͗̀̄̈́̋̏̆̎̋̃͘͘͜ǘ̠c̛͈͘ķ̸̴̴̧̡̛͚͚̟̩͙̯̹̯͚̪̬̝͕͕̦͈̫̋́̈̎̂̈̔͌̌̑̈́̃̌͝͝B̴̤͕͓̌̋͝ȃ̸̮̺̗̼͚͚̝̦̰͕̋̍́̈̄c̶̵̶̵̷̨̨̗̯̠̞̫̝̥̫̭̲̯͈̩͙̝̓͋̾̅̂̉͆̈̌̒͘̚̚͘͝n̷͕̘̫̫̖̩̼͈̅̅̋̍́̈́̍̈́́͂̚͝ck͕̫͙̦̑͑̍͝t̵̸̨͎̓l̷̫̹͈̯̝͌̋̋͒̊̅͋̎̊̌̇̈̌̚͜͜a̴̷̸͙̫p̶̷̻̻̯̻̜͙͉̫̹͇̭̺̙̺̥̱̅͋̏̔̐̄̈́̀̎̚͘̕͜͜͝K̵̴̸̸̸̸̡̡̢̰͕̺̮̪̬̥̹͙̱̏̋̑̅̎̃̅̀̽̈̔̾̂͗̋́̆̅͗̾̀̑͌̚͜͝͠͝h͚͋́, reason: contains not printable characters */
    public static int m9x1273c6e5(Object obj) {
        if (occatKolokBtoapaKaPhp.m184x48849b02() <= 0) {
            return ((MainActivity) obj).B;
        }
        return 0;
    }

    /* renamed from: a̴̶̙̗̮͉̯̔̒̅̃̄̈̒ȧ̸͈̻̘͖̦̰͑̋͋̈͌͘ͅư̶̸̧̧̙̥̖̫̯͇̞̟̗͙̺̞͚̘̫͈͌͌͒͐̀̑͌̎̑̿̏̍̚̚̚͝͠ân̷͖̬̙̫̫̿̑̈̿̌pt̷̸̸̲̖̺̖͎̯͖̲̫̑̐͋͑̊̋͌͂͘͝͝K̀k̷̮̪̙̍̈ţ̤̹̭͓a̵͚͂a̷̷͎̲̱̰͆͗̌̂͝u͖͉̺̻͙̦̲͉̦̍͑͌̆̈̈́͋͘͠͠͝a̸̧̫̐̑͌u̧͕͈̪̩̹͕͗̎͋̿͒͘K̷̤͚͙͎̹̗̺̯̫̘͈̠̮̤͌͗̈̈́̄͌̐̑̋̃̾͑̋͋̚K̫̘͙̄̑̀̎͠k͎̾̂͠l̢̅͘ẻ̡̘͇̫͗n̶̛̯̗̯̫̈̍̚͝B̞͖̹̘̊͠h̵̛͈͚̫͚͕̭͚̫̤̎͌̄̍͆̌̈́̀͗̈̎̊͘͝͠͝͝u̸̢͕̫P̌ͅB̹̗̋̿͌͝, reason: contains not printable characters */
    public static com.omarea.common.ui.h m10x4aee29eb(Object obj) {
        if (occatKolokBtoapaKaPhp.m184x48849b02() < 0) {
            return ((MainActivity) obj).w;
        }
        return null;
    }

    /* renamed from: a̸̶̛͎̖̺̝͚̅̒̏̂̔̚̚͝͠n̸̛̯͎͑̋̃̀͝ṱ̶̸̨̨̢̲͉̹̦̭̰̮̰͚͈̯͗̏͊̑͗̾̑̈́͘͜͜͝͠͠l̛̛̮̱̫̱̺̺̘͈̱̈́̾̂͗̍a͐u͋ḩ̯̰̌̿̿͘͠K̫k̸p̸̸̫̫̱̯̈́͑̂͊̄͂͘͜͠ķ͇̤̗͒̀͗͋͠a̷͚̽̎͌͜ą̶̵̸̴̶̷̧̢̩̫͚̜͚̥͙̺̮̀̈́͑͋̋͌̈́̔̔̃̚̕͘͝͠ǘ̸̸̸̷̷̡̢̨̨̢̠̩̫̼͚̘̙̥̤̯̯̙̘̘͚͈̫̯̗̗̪̼̑̋̍̃̇͐͌̃́̌̈̈́̎͌͌̎̈́̑̃͌̾͑̌̔̀̀͌̂̎̍̈́͐̍͗͋̐̎͘̚͜͜͜͠͠ͅo͓͗̾ͅo̵̶̢̙̫̙̮̮̠͌̌͌͜͝͠c̨n̶̷̸̸̷̸͓̰̮̗̪̼̞͕̖͚̽̔̾̋͗̀̌̚t̸͚͚͉̹̑̃̄̋͝, reason: contains not printable characters */
    public static void m11x880d0b51(Object obj, Object obj2) {
        if (ccooopahacBnhcacooKa.m76xf651d881() > 0) {
            ((com.dna.tools.f) obj).a((PageNode) obj2);
        }
    }

    /* renamed from: a̭͙̩̼̹͎͉͎͈̱͒̍a̶̷̸̷̢̛̺̹͎̓̈̊̿͌̈́̂͗ẫ̲Ḇ̶̛̥̗͎̹̩̥̖͓̗̏̔̄̈́̆͋̌͘͠ḩ̷̷̵̸͓̤̑͒̎͐̃̿̃͐̂͗͘͜o̷̼̠͇ǒ̶̸̧̧̧̫͎͈̬̺̭̌̒͗̌̍̿̍͑̚͜͜͝͠͝͝e̅l̴̛̫̼̩̱̦̂͋̍̔̑̄͜͝P̩̰͗͘͜ņ̶̛̛̺̹̠̘͚̠̘̘̲̗͈̭̬̫͌̋͒̂̎̋̑̋́̊̆̇̚͜͝͝͠ḩ̵̛̠̪̭̫͖̤̫̝̰̭̫͓͚̪͎̖͌͒̈́̑̾̈́̆̅̓̌̏̑̽͗̋̂͆̍́̂̋̈́͘̚͜͠n͙p̸̸̸̭̯̗̰̭̑͐̿̂̌͝t̸̮̮̹̾͑̿͋̂̈͘͘͜a̸̭̅͂̌͜t̫͐͌̈́ḁ̷̡͙̭̅͗͠n̶̸̷̸͉̫͈̪̲͓̝̪̭̦͎͙͒̌͘͜͜͠͠k̖̻̑͐̂́͘, reason: contains not printable characters */
    public static int m12xee631403(Object obj) {
        if (occatKolokBtoapaKaPhp.m184x48849b02() <= 0) {
            return occatKolokBtoapaKaPhp.m200xda7b03d7(obj);
        }
        return 0;
    }

    /* renamed from: a̴̾P̷̧͕̋oo̷̜̦̘̭̜̍c̵̴̴̴̶̨̨̛̺̮̺̙̰̘̯̼̤̱̭̺̺̹͈͗̈́̎̏́̀̀͊͑̊̿̂̋͌̐̚̚͘̚͘͝͝͝kuĶ̸͓̪̲̩̻͉̽̋̂͗̒̄̋̅̾̆k̢̫̭̹̿ņ̸̶̴̶̧̢̥͙͖̦̭͕̗̟̜͇̫̯̩̮̫̗̤̱̍̌̌͑̋̅̃̿̌͊̿̋̍̀͒̑̀̾́͊̄̆̔͗͐̌̓͋̾̚͝͝ě̡̢̺͓̦͈̤̫̫̋̾͗̂̍̿̄͋̚t̶̎̄o̧̪̦̝̱̪̞̅̌̌͌̋a̶̸͈̭̪̯̻̗̘͎̐̈̎̎͂̋͒̿̑̃̂p̪̆̿͌͝K̶̸̸̸̝̦̜̱̗̹͎̤̎͂̅̾̀̎͊̈͜ͅB̶̩͚̱̥͈̑̎̃̈̿͊̾͜͝K̢̆ũ̸͈͕͚̦̋o͗c̤̪̼͕͉̿̔͋̄͝ẫ̶͕̫̩͊͜aK̴̸̢̿̂̈͊̌͘ḰP, reason: contains not printable characters */
    public static void m13x57bf86ac(Object obj, Object obj2, int i) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() > 0) {
            ((androidx.fragment.app.d) obj).startActivityForResult((Intent) obj2, i);
        }
    }

    /* renamed from: ȃ̵̞͘͝ô̴̤̻͝K͎a͇̬͈̖͚̾h͉ṯ̶̱̫͋̈͘á̵̸̧̛̼͎͎̯̌̋͜͝B̸̟̹̆̋͌̑̐͑͘B̸̧̧̯̦͚̖͈͚̠̃̈́̓̂͌̌͌̌͗c͚̮̰̭͗̏ǎ̶̹͕K̴̷̸̶̨̯̭͉̺̫͙͈͕̟͉͕̗̝̦̫͕̩̪̙̊̽̈́͗̈́̐̃͋͋̽̋͂̎̌͌̔͌̄̂͘͝t̔͗͝ļ̡̩̉̚͜͜a̫̦͓͓̲̗͆̋̉͒o̷̺ç̷̛̮̘͇̃̔B̶̷̸̧̛̰̬̰̼͚͓̖̙̻͗̆̋̿̎̃͗̌̅̎̏̚ö̸̸̧̧̲͎̞̼̭̖͈̜̥̤̯͖̠̠̱̖̞̝̮́̂͋̾̂̔̂͋̈̌̊̋̋̎̕͘͠͠ͅK̸͉̺̹̯͙̭̯̎̿̅̈́̿̿͒̋͒͘͘͘͘ơ̵͎̙̓K̲̾̋̋͘̕͝e̶̫̭̯̲̒̌̋̔ĥ̨̀̾a̶̧̗͓͓̺̾͜P, reason: contains not printable characters */
    public static boolean m14xbdb9ba94(Object obj) {
        if (ccooopahacBnhcacooKa.m76xf651d881() > 0) {
            return ((i) obj).a();
        }
        return false;
    }

    /* renamed from: a͎c̷̸̫͖͚̮̺̘͓̫̭̪̄͊̌̈̄͝l̯͙͋̎͌Ķ͕l̸̢͕̯̩̊̌̂̅͌͂͂͘͜ç̸̶̲̱̩̝̲̗̹̺̾́̈́̎͂̆̚͝ư̷̸̶̴̸̷̧̢̮̙̺̭͙͙͈̱̖̹̭̭̺͚̗̺͕̱̖͎͎̩͎̽̎͗̑̋̿͗̈̐̂̊̆́̋̀͆͜͝͠͠ͅK̭̗̍̑͂̈́̈́̌͒͘͠͝k͈̃̈͝à̀k̷̝̀Ko̢̰͉̺͉̫͗͗͗̐̿̑͘͜a̸̙̪̎̍̈̑̌ą̸̫̯̗͈͈̦̲̎̀̎͌͋̌͗̉͜͜͝ǭ̧̧̛̹̗͎̙͉͌̔͗͌̌̋̑͌͊̔̾̑̋̃͗͑̂͐͘ä̴̟͖̠̩́̅͗̎̂̆̈̓̕͘͝ļ̸̶̢̡̛̫̘̘̙͎̯̺͈͓͕̲̑͋̋͆̅̈̏͐̌̋͗͘̕͜͜͝͝K̸͚͎̫̲̺̅̍̌̄̌̚t̫͌̋͝t͎͈̄̾̌P̧̧̻, reason: contains not printable characters */
    public static void m15xe3129ec9(Object obj, Object obj2, Object obj3) {
        if (ccooopahacBnhcacooKa.m76xf651d881() > 0) {
            ((MainActivity) obj).b0((ArrayList) obj2, (PageNode) obj3);
        }
    }

    /* renamed from: ä̸̡̩̥̫͚̠̠͚̗̖͇͊̐͝a̶̛͓͙̭̞͕̋̔͊̄̕ơ̡̮͎̺͈̎̔͗͌͗́͝͠͠ḁ̷̧̡̥̩̦͚̭͎̘̾̄͗̌͒̂̀̈́͌̚͝͝o̶̵̸͕͕̗͚̫̗̦̭͓̎͋̓̇̈̂̈͑̔́̌͂̈́͋͝c̸̟̪̝̫̺͐̈́̐͘ư̷̛̘̘̯͙̿̃̄͝͝o̡̻̐̃̈́at̶͖̂̃̅̌̉͠͝͝K̫̙̫̹̫̱̱̑̏̈͜͜nṅ̈B̴̷̴̹̫̫̫̦̊̌̒̑k̷̮̮̗̺̈̍̅̃̑̑̈͜ű̶̶̲͕̺̫̯̺̹͓̦̪͒͌̅̍̋̌̾̐͝͠͝ä̴̼͙̲̩̫͎̪͓̯͗̃̌͌̈̇̈́̅͋̃͘͝͝͝ͅờ͖̯̻͚͎̫̹̪̋̑̋̑́͝͝k̶̸̸̸̢̛̛̛̼͕̻̦̭̩͈̺̺̫̑̾́́̑̎͑̿͗̿͂̂̃̊̋̈̈́̽̈̚̚͘̕͜͝ͅ, reason: contains not printable characters */
    public static String m16xaa48b9f6(Object obj, Object obj2) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() >= 0) {
            return ((MainActivity) obj).X((Uri) obj2);
        }
        return null;
    }

    private final void b0(ArrayList<NodeInfoBase> arrayList, PageNode pageNode) {
        d.c.b.p.a m8x59e49f59 = m8x59e49f59(m42x66ea8a7(), arrayList, m51xdcc43825(this, pageNode, false), null, m34x64582924(m23xa0e0a96b()));
        n m40x4c1febbb = m40x4c1febbb(m4x7e64ae96(this));
        m22x2ca01c66(m40x4c1febbb, R.id.list_pages, m8x59e49f59);
        m18xdd64949d(m40x4c1febbb);
    }

    /* renamed from: c̖̭̱̻͉̃̎̈́̾̑̈́́͘͝͝Ķ̵̷̶̶̸̴̶̢̧͕̭̘̼̼̮̬͚̺̯̘͙̫͉̟͊̿̐̿͌͗̋́̅̈̌́͐͑̏̕͜͠͝B̶̸̨̛͚͓̫͉̰̱͉̫͓͎͓̫̫̮̞͉͓̭̫͓̺̋̂̐̎̋̈́̂̍̍̓͆̈́̽̽͐̎͌̀̆͘͘͜͝͠â̷̧̛̛̩͈̲̫̑̂̈͘͠͝ņ̷̻͎̥͐̈́̍ą̷̛̭͎̤̼̂̊̎̈̈́̌͋ȗ̶̠̯K͗ă̙nê̷̶̷̸̷̱̪̩̘̩̘̮̆͌͂͗́̌K̫̎͂̅͝a̹͝ȃ̴̫̈́͌a̧̠̾̏͠a̩l͈̿l̸̛̮͗̌̎̑͝p̴̨̧̛̱̫̭͉̤̫̠̫͑̆͗̌̿̀͊͗̋̿̏͗͗͘͘͜͜͝ä̸͓́́͝l̲̝͈̫̫̩̄̂͌ȃ̺̞̄̂̂̚͝ķ̶̶̶̨̧̠̯̗͙͉̱̫̫̪̃̾͜͜õ̸̸̧̹̘, reason: contains not printable characters */
    public static a.C0057a m17xf27d292c() {
        if (occatKolokBtoapaKaPhp.m184x48849b02() < 0) {
            return com.dna.tools.k.a.f;
        }
        return null;
    }

    /* renamed from: c̥̫̙͋̂̆̉̽̋́̆ư̶̸̸̹͈͚̮̫̯͈͉͕̐͊̑̿̆̌̄̾͌͠k̵̶̸̢̩̗̯͈̺͎̹̱͕͊̃̏͌̂̃̅̒͆͘̚̕͘͝͝ţ̶̷̶̶͚̟̹̺̹̼̦̥͉͚̱͕̫̫͌͋̐̋͑̃̂͑̾̄͆͑̍̓̌͜͝͝ͅͅä̲̺͎̠̈́̂̾̋͘͝͝cǒ̢̙͙̈́͘͘͠ǫ̢̫͌̌̀͜͝͝â̵̢̢̛̘̼̗̖͖̫̱̺̘͕̗̂̋̾͑͋̈͆̀̾͐͑ņ̸̵̛̜̫̰̭͕͇̖̪͚͈͉̬̥͎̦̙̩̼͎̫̙̮̤͊͌̈͐̈́̐̌̆͊̂͗̔̎͐̅̇̎̌̔̈́̄͒̽̈͘͝͝ͅŭ̷̸͖̭̦̯̘͚̗̻͙̿͊͋̇̚͜͜K̨̈́́̉́k̛̝̈̈́͂̎̀̃͝c̔͗̓K̫̫̂͋͐͜͠c̸̷̸̵̸͉̫̬̫̫̮̋͐̀̄͋̋̎̿̋͗̂͊̂̍͐̅͗͝, reason: contains not printable characters */
    public static int m18xdd64949d(Object obj) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() > 0) {
            return ((n) obj).e();
        }
        return 0;
    }

    /* renamed from: ç̸̴̧̢̦̺͇͈̘̦̰̫̮̺̗͎͉͉̀̌͌̐̑̋͋͜͝͝l̷̷̸̢̢̛̰͉̘̗̍̈̾̾̂̈́͌̉͗͌̆̅̂͋̃̀̾̌̈̈͌̆̾̂̚̕ě̶̢͚͚̙̫̒̄̉͋͜ĺ̶̵̢̘̫̃̂c͈͕͎̋͝n̗̏̏̏͂̆͘p̷̡̧̭̫̦̰̭̠̪̅̑͌͋̄̋̋̔͜k̴̡̹̫͈̰̻̩̬͉͈͓͚̋̅͋̿̊̉̄̄̅͘͘͜͠k̷̴͎͈̩͜á̸̴̷̢̧͈̲̭̯͕̺̯̈́͗̆̆̊͆̎̈́̎͊̾̕͝͠K͙â̖͂̂͊Kö̶̧̘̫͎̺͉̮̩̘̘̗̏̇͑̇͘ȃ͒ă͚̤͈̰̗̮̭͚̞̂͜͠͠͠a̷͕̟͎͚͎͕͌̂̑̈̂́ḩ̵̶̤̺̘͚͓̙̖̯̉̈̽̏̑h̢͎̫̜͙̱͈͈̋̄̀̀͆͌͝͠ͅa̭͕̋͝e͈̖̰̪͖̊̉͘k̛̞͌͘, reason: contains not printable characters */
    public static int m19x588cebaf() {
        if (ccooopahacBnhcacooKa.m76xf651d881() > 0) {
            return g.main_tabhost;
        }
        return 0;
    }

    /* renamed from: ĉ̷̸̶̢̲̥̤̤͎̰̩̞͙̹̭̮̖̝̱̭̺̠͕̜̘̲̫̆̃͌͗̈͗̈́͒́̎͌́͑̎͑̈͂̃͌͗̔͋͋̌͑̿͘͘͘͜͠͝͝͝͝͠͝͝͝ͅać̶̹͓̽͋͆͐ḁ̱̮̈́͌̃̿̋͂͜͝ă̵̸͉̪̭̜̺͖̒̓̌̎̌̿̎͝ļ̹̯̗̫̌̌͋̽̈̅̈́̎͝á̵͈̠̲̯̲͗͠o͚a̶̮̺̩̥͒̃̎̂͑͝͝͝n̗̥͘͝t̩̓͌ļ̸̸̸̸̸̸̛͚̰̻̤̰͈̹̹̫̰̫̥̠̻̯̫̹̻͚̗̖͇̝̤̗̮̟̯̫̙̰̥̭͕͒̈̌͋̊̈̍̌͂͒̃́͌̅͗̈́̊̑͌̚͜͠͠ả̛̙̫̼̺̗͎̙̪͇̮̺̗̲̹̮̈́̍̈̋̀̂̈́͗̈́̄̂̆̎̅̚͘͜͜͝ả̴̧̼̬̗͈̼̟̈́̇̇̀̽̑͗̑͘͜͠e̶͓̮̹̜͌̽̌̋̾̿́͗̌̋͝, reason: contains not printable characters */
    public static String m20xd17ffaf7(Object obj) {
        if (aalloKKholeaacllnou.m68xcb69398c() < 0) {
            return ((PageNode) obj).getPageConfigPath();
        }
        return null;
    }

    public static String dec(String str) {
        return new String(khoeKettlaaaaaKnPPanaBkoa.m134x82acaa9b(str, 0));
    }

    /* renamed from: e̫̮̅ư̶̶̧̢̡̛̱͈̘̦̼̮̺̩͕͕͕̥̯͈͎̬͙̑̑͗͐̈̀͗͊̅̈́̂͗̕͝͝K͙̀͠ā̶̸̸̲͕̬̼̮̾͘͠epą̛͚̼̗̮͎̎̉c̸̴̶̸̶̡̧̡̛̫̪̥̲͉͕͉̺̾͌̃̐͗̅́͑̐̑̔n̿̕̚n̸̷̷̢̛̘̭͚̙̩̩͓̫̔͐̑̂̔͜Ķ̷̸̛͈̩͇̀͒̈́̑͋̚͝͠o̩͉̗̦̭͈̭͗͗̃͐̇̂͌̿̚͠͝ǎ̸̭͈̱̻͖͙̩̋̋̏̍͌̔́͘͜͝͝ͅȩ̶̷̨̛͇͚̖̰͈̫̦̻̦͖͂̎̃̇̑͌͜n̻̗̲̫̫̑̌͝p̯̭̈̑͑n̷̴̻͉̖̟̜̗̹͈͎̞̤͈͋̈́́̋̍͌͋̌͑̌̑K̴̨̛͓͉̱͓̫͕̑͗̿̌̌̌̾̚̕l̶̡͕̻͉͗̎̒͘͜Kt͘K̴͎̻̈n̠̯͑ä̸̶̧̹͎̹̋̏̂, reason: contains not printable characters */
    public static boolean m21x72e6861a(Object obj, Object obj2) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() >= 0) {
            return ((MainActivity) obj).U((r.b) obj2);
        }
        return false;
    }

    /* renamed from: e̶̡̦̙̺̗͚̙̫͙̯̹̋͋͗͌̏͐̀͋̂͂̊̄̄̓̅̈͠aa̦͇a̶̴̧͈̖̹̘͊̈́̚͝n̵̶̸͉̙͓̜̲̫͓͊̅́͌̊̋̎̃̇̀c̀ñ̸̹̭̦ḩ̸̶̢̫̯̮̙̮̝͕̈͊͐̄̌̂͂̾͠ķ͈̯̺̥ḫ̷̯̟̭͐̃͜͝K̷é̱̺̅͌̀̿͝oo̮ả̸̢̛̛̛̙͚̫̺̖̹͚͉̺̠̱̥̯̥͙̫̼̻͙̺͌͆̄̄̾̀oư̴̥̂̈́B̢̢̧̠͚̺̫͈͓̠͓͙͓̫͚̈́̅̎̌̾̀̔̆̿̃̋̏͗͒̑͑̊̔̀͌̀̂̋͆͘̚͘͠͝͠pa̢̖̭B͈̎ḁ̸̶̢͉͉͉̈͋͗͌͋̿a̸̴̴̺̖͎̰̠̮̟̮̜͕̬̰̻̰̫̲͐͑͐̿͜͜͝ͅl̸̛̪͕̯̭̾͊́̏̚t͎͈̖͗͌͝a̷̧͕̰̩̗̭̗̿̈́͘a̘͗͗̄̌̚, reason: contains not printable characters */
    public static n m22x2ca01c66(Object obj, int i, Object obj2) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() >= 0) {
            return ((n) obj).h(i, (Fragment) obj2);
        }
        return null;
    }

    /* renamed from: e̸̸̗͙̫̫͉͈͓̼̫̦̬͉͌̉̒̍̌̌͘͘͝a̷̧͚̯̹̋̂̈͑̈́̈͋̾͑̾̔̿͌̑h̶̶̸̶̸̢̛̗̱̻̜͚͎͚̯̭͕̮͎͉̤̯̮̝̫̫͌̎͌͗̌́̀̂̑͌̾̑̀̎̃͒̎̋̾͌̄̄̉̌͌͂̕͘̕͜͜͠͝͝ͅą̷̸̷̢͙̹͎̠͓͎͎̺̖̂̋̀͌̿̂͐͜͝ő͈͊K̢̏ǎ̵̵̮̲̬̋ä̺k̋oḰ̘̀͘͝K̋ķ̲͕̗̜͈̍͒̑̌͐̅͝͝͝aņ̸̵̶̸̴̷̸̸̶̨̨̛̛̝͈̺͚͈̤͚̠̱͓͕̤̞͕̫͎͊̈́̑͒̊̅̾̅͗̅̏̂̋̌͋͐͌̋͘͘͘̕͝͝͝͠aǩ̥̠̮̬͓̋͝ͅŏ̯̫̖̺̉̌̃͜K̶̶̛̯̫̪͚̭̍̑͋͌́̑̃̕͜͜͜a̶̎͑̀͘o̺͎̠͕̿̋̿͑͝n̦uaḩ͉̻̦̱, reason: contains not printable characters */
    public static j m23xa0e0a96b() {
        if (aalloKKholeaacllnou.m68xcb69398c() <= 0) {
            return j.f999b;
        }
        return null;
    }

    /* renamed from: ȩ̸̧̧̮͎̦̭̦̦̪͌̆͐a̸̷̡̫̼̻̗̙̖̼̗̮̯͐̆̌̽́̀̌̈̿̃̈̎̂̋̎͌͝͝ō̗͗a̴̷̢̨̧͕̗̬̱̤̔̎̄̃̌̈͋̈̑͝B̨̼͈͇̼̭͚̼͌̋̿͌̏͋̐̓̌͘ä̸̵̵̸̸̧̢̢̧̨̛̮̮̘̫̥͈̹̹̜͎̫̤̮̫̘̟̱͕͂̌̀̌̑̀̌̃̈̿͒̆̈́͑̀͂̋̾̌͘̕͜͝͝͝k̛̬̰̭͈͗͂͐̈́̾͂̿̏̃̃͝ļ̶̫̺̮̺͕̩͚̮̫̦͋́͐̂̏̌̚͠͠ǒ̷̢̫͚̼͓̯̼̺̮̮͗̌̃͌͜͠n̸̫a̴̸̼͊͋̒̂͐̂̈́̍͜͜͝͝K͐͠t̶̛̲̲̯̱̼̯̃͗̃͗̍͜͝͝͝͝c̸̡̞̺̱͋́͂k̂̽̐n̸̶̰͗̆̚͜p̧͓̥̩̠̞̐͆̈̌͌͌̚͘Ǩ͚̄ōh̻̯̗̍̋͋͐͌̈́̚͘, reason: contains not printable characters */
    public static r.b m24xda7b03d7(Object obj) {
        if (ccooopahacBnhcacooKa.m76xf651d881() >= 0) {
            return ((MainActivity) obj).z;
        }
        return null;
    }

    /* renamed from: e̶̤͋̋̈̂̔̈́̾̇B̸̸̴̧̢̧̺̪͗̿̅̋̎̿o̴̶̭̥h̛̫̘̘͉͋͂h̶̛͕̰͈̘̺̱̗͚̱̺͖̤͇̲̹̮̥̋̄̂̈́̄̑̈̌̋͝e̷̪̔p̷̶̴̨̪̻̜̖̲̺͓͓̑̊̈́̄̋͜͜͜͠͝͝hǎ̷̶̢̨̛̪̞̩̘̩̘͕̦̭̖̮͚̗̫̱͈̫̂̎̈́̈́̃͋̄͠c̷̱̠̲̈́́̋͊̇̑̈́͜͜͝ǎ̝͜à̧̟̹̗K̸̴̢̛̖̹͎̰̦͑̈́̂̋̃̂͌̽̉͜K̷̞̥P͒ţ̸̶̛̗̖̙̖̰̫͓̥̹̖̺̦̩̦̥͎̫̠͙͈͈̘̖͆̂̆̑̂͑̏͊̌͒̌̿̈̋͌̿̅͗̿̌̄̉̚͘͜͜͝͠K̹̘̺̹̗̑͋͋͝ë̢̧̛̤͕̪͉́̈̚͜ņ̷̧̢̛̭̹̩̤̹͚͈͎̫̋̈̈̈̓͂͋͝͝a̛͝͝ù̵͚̺̫͇̫͓̥̈́͋, reason: contains not printable characters */
    public static String m25x58fc39e6(Object obj) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() > 0) {
            return ((r.b) obj).b();
        }
        return null;
    }

    /* renamed from: e̷̛͉̻̭̯̗̫̩̮̰̔̉͒̾͗̎̀̎͘͘̕͜͝P̻̞̱̼̺̮̋̌̈͘͜ͅK̸̢̛̹̾͋͑̿͝ả̴̛̰̭̗͙͇͈̩̻̆̎͌͒̋͒͗̚͝͝͝ú̗̮͈͉̘̍̈̃̂̋ǫ̷̴̶̸̷̛̛̯̖̺̮͓̰̦̺͕͕̗̥̯͓͚̭̫̗̭̗͙̫͗̎͂͒̽͌̔͊̂̆̋́̋̎̂̾̑̔͌̾͑̇̓̈̈͋͊̃̃̔̂̍̈̚̚͜͜͝͝ͅo̴̢͓̺̗̮̯̹͈̘̅͗̑̅̐͐͂͊͠͝h͓̱̿͌c̑͝ą̷̸̶̧̩̺̺͕̱͓̦̘͉̱̼̋͋̍̀̌B̨̮͚̮̺̹̃͐̾̌͗̃́̑̾̚̚h̹P̸̸̧̢̟̺͓͉̌̅̄̅̅͋̀̀̋͘̚͜͝ķ̶̗̯̪͐̎̈̔͌č̴̸̸̴̨̨̨̰̩̟̩̯͎̘̫̘̤̱̱̗̻̼͐̾̌͑̎͌͗̃̈͗̋̑̈̃́͌͜͝, reason: contains not printable characters */
    public static String m26x3d83010(Object obj, int i, int i2, int i3) {
        if (occatKolokBtoapaKaPhp.m184x48849b02() < 0) {
            return khoeKettlaaaaaKnPPanaBkoa.m128x92a9e5b2((short[]) obj, i, i2, i3);
        }
        return null;
    }

    /* renamed from: hư̧̯͚̠̦̠̫͎̦͖̩̘̽̂̂̈́͐͂̿̋̅̃͘͝p̹̦̯̈̑̑̀̋͘ne̶̛͚͉Ķ̶̸̶̧̢̢̘̲̗̺̠̤̫̺͈͈̆̆̂̔̑́̈͌̅̌̑͗͜͠͝P̴̸̶̧͎̩͈̫͎͈̰̱̘͕̃̎̌̇̐̃̔̋̈̑̎̾̌̃̄̚͜ͅč̸̶͈͌̾͜ơ̷̷̸̴̷̶̷̧̧̢̢̧̮͙̗̯͎̙͈̗̗̪͈̱̹̫͈̫̮̮͊̈͂̋̈̂̌̋̾͗̂̋̋̌̎͐̿̋̈̈́͑̄̎̈́͊̔̑̒̅̋͘̚͘͘͘͜͠͝͝͝͝͝͝ķ͙͎͙͚͖̲̙̠̱̑̑̋̑̔̾B̸̶̶̸̛̗̺͈̙̮̮̩̮͉̯̭͚̆͒̂̃̈͑̐̾̃̅̅̄̅̾͆̆͘͘̚̚͜͜͠o̴̱̗̪̝̗͈͎̊́o͎̾ah͖̜̼̃̌̈́͝ţ̷̴̢̛͈͎̪͎̼̘̼̑̑͌̈̐̈̂̋̚͘͠͝͠͝, reason: contains not printable characters */
    public static String m27x81b8dc41(Object obj, int i, int i2, int i3) {
        if (ccooopahacBnhcacooKa.m76xf651d881() > 0) {
            return occatKolokBtoapaKaPhp.m196xf70c41e8((short[]) obj, i, i2, i3);
        }
        return null;
    }

    /* renamed from: h͚̀͜͝c͚̀̾̾̕͜͜ãǒ̸̵̱̥̱̫͕̹͗̄̈́̿͌̃̈́̒̈͜͜ĥ͚͕ä̯͉͊̚oṉ̵̵̵̵̛̭̺̻̹̫̗͖͉͚̏̎͗̋̌̃͗ͅḙK̂ơ̸̷̷̷̧̧̤͎̰̘̫͉̘̱̖̗͎̹͕̩͈̭̹̘̯̹̪͊͋̈́͂͒̂̈͊̈̋̏̎̅̋̈́͋͘͝͝͝͝͝ͅo̸̷̧̧̧̮̠͚͌͗uç̧̧̭̪͓̮͊̑͒̑̑̈̅̂̒͑̋̌̚l̦ä̸̷̸̴̢̢̧͇͕͎̫̫̭̗̺̞̭̹̈̍̏́̒̈́̆̄̿̂́͌̌͜͜n̫͚͚̫̫̭̯̫̱̭̘̫̗̗̫͈̗̾̋̌͗̇̿̈̑͒̂͝͝͝͠Bą͉̙̜̍̋̈̃͝Ḵ̸̸̸̨̧̧͎̱̤̯̫̤͎̗̄̊̆͐̈̔̎̏̉̂̋̈́̌̇͝͝K̃ử̶̴̫͕̦̮̬̺̭͌̌̈́͌̄̈̓̋̃͌̚͘͝͝, reason: contains not printable characters */
    public static e.c m28xe854eb50(Object obj, Object obj2, Object obj3, boolean z, int i, Object obj4) {
        if (ccooopahacBnhcacooKa.m76xf651d881() > 0) {
            return e.a.i((e.a) obj, (Context) obj2, (View) obj3, z, i, obj4);
        }
        return null;
    }

    /* renamed from: h̢̯̼u͎̭͒̏̈͑a̛̤͗̌̈́͗ǎ͉̾ơ̠͎̐̎̅p̴̘͑̆͋̂̚n͌c̸̫̺̖̯̹͚̎̀̀̆͘͘͘͜P̸̧̨̛͓̠̺̱͖͈͈̖͐̑͋̐̋̋͑̓̅̐͘͘B̧̬͒͜ǭ̷͎͓̺̦̿́̐͒͒̏̚͜ȩ̫̑Ķ̤̥̑́l̴̗̥͗̏̃̄̎̍ͅP̯͚̺̎̈́̀̾͂oç̨͚̯̯̂̇̂̄͘͠h̷̴̛͖̙̫̯̫͎̠͎͈͉̟̙̞̄͂̾̌̆̐̑̏̈̆̾́͆͒̔̋̂̚͘̚͝͝p̷̙̎̊̈̈́͋͜͝u̷̷̻͂͗a̋̈͐̾n̷̢̖͉̱̭̖̾̾͌̋̈̎̾͑̕͝ķ̵͕̭́̌ù̢̢͚̯͓̮̯͚̼̻̲͂̅̎̈́̌̋̆̀̚̚̚͜͜͝l̴̴̶̛̻̘͇͎̈́̔̃͌͌̀͐͊̂̈pc̸̷̷̨̢̛͇̺͚̺͎͓̜͎̤̬̿̾̈͌͗͗͘, reason: contains not printable characters */
    public static void m29xf5d0e302(Object obj, Object obj2) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() > 0) {
            ((MainActivity) obj).T((String) obj2);
        }
    }

    /* renamed from: ĥ͙a͐͠B̸̷̸̶͎͓̼̦̱̩̬̹͚̭̩̗͈̥͚̱̦̈́̐̒͋͂̑̈̂̈̅̄̊̿̈́̄̈̕͜͜͜͜͜͝͝͠o̹͌͝k̀̈́͊͗̈͝͠o͕͑͘P̵̨͙̱͑̋̽ee̢̫͌h̷̶̗͓̺̲̗̭͉͋̑̿̆̀̇͒̌͒̀͌̌͗̋́̊͌͗̂̔̍͘͘͝ằ̷͈̗̃̌̃͑͒͊̃̈́͠k̷̸̵͕͓͙̫̺̺̯̠͚̭̾͑͋͗̅̕B̴̢̧̧̮̻͓̤̫̪͙͚̗͇̖̩͈̻̂͗͋͋̽̌͐͗̌͝ţẫ̸̧̗͖̭̯͎̮͖͉̺̭̭̭̆̂̒͂͋̑̀̄͗̅͘͜͠ͅK̸̺̭͒͌̌̋̏̈́͝ķ̸̷̸̫̫̫̩͚̞͖͈͕͙̺͈̹̼͙̫̱̖̫̜̍̾͗̑̌͑͑͋̆̎̌͌̑̂̔͆́̈̍̇̔͗̈͌̎͌̚̚͜͜͜͠͠͝͝͝a͠a̷̛̠̯̫̠͐͗̃̿̅͝, reason: contains not printable characters */
    public static void m30x463864b8(Object obj) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() > 0) {
            ((d.c.d.a) obj).p();
        }
    }

    /* renamed from: h̶̸̸͚̘͈͈̫͓͙̹̗̩̱͈̗̦̫̙͕̫͎̾̏̋͌̑͒̑͌͌̋͑͘͝͝͝͝͝͝ͅe̤̱t̤̪̱̫̯̤͈̫̅̌̎̚͜ū͎͋̑c̗̺̀ͅKn̸̸̶̸̶̢̢̤̜͎̯͈̯̯̰̰̗̮̱̦̹̂̈͒̎͑̃͐͌̐͋̓͌̿̈̑͝͝l̸̎̚͝a̫a̵̦͜n̤͎e̔P͈̾͘c̨̟ä̤̙̋̏̆͜͠B̶͓̼̥͚̫̲͌͋̿̌̿a͉̋u̧͙̺͌̂̃o̍K̴̸̴̸̢̢̧̫͚͈̬̩̯̹̫͋̀̋̌̎̂̾͒̌͑̃̍̌͋͘͜͝͝͝h̴͖͈͚̘̤͙̞̞̔̀̈́͐̋̋͌͌̋c͕̗̦̹̥͚͉̍͌̆̋͝a̷̧̧̛͇̤̺̦̫͚̯͖̦̭͕͗͌͗̍̂̿̈̈́̀̌̔͘̕̚a̫͕̦̭̗͉͌̈́͂̈́̄͘͜͠ǎ͓͎̫̱̞̰͓͚͗͌̋̐́͜l̴̸̟̤̏, reason: contains not printable characters */
    public static View m31x1f959fc2(Object obj, int i) {
        if (aalloKKholeaacllnou.m68xcb69398c() <= 0) {
            return ((androidx.appcompat.app.c) obj).findViewById(i);
        }
        return null;
    }

    /* renamed from: k͎̐ơ̵̧̜̔̑̆̈K̸̸̢̨͉̯̫͎̫̭̮̘̠̞̋̾͂̑̎̈̌͌K̷̠̗̗͎͉̫̔͌̆̆̂̾͌̋̈́̈́̚͜ö̸̵̲̯̺͙̗͈̝̼͕͎̼͈́̔̾̃̌͂̎̑̚͘͝͝a̲ù͒ȩ̢̧̫̼̑̌̍̾K̑ü̶̙͈̮̫̃̇͗̾̈́͘͜P̷̴̷̴̡̧̛̛̛̬̥͉͌͌̑̈́̆͒͗̎̀ņ̸̶̸̻͈̩̥̻̩̻̃̂̀͌̈̋͋̅̆̚̚͜͜͜͝P̸̸̸̸̨̛̯͎͈̱̫̟̘̩̯̟̋̂͒̎͐̈̌͋͂͆̌̏͒̿̂͋̋̂̈́̿̑̾̚ͅć̵͙͙̙̫͓̯̙̦͒͂̏̎͌͝͠͝͝Ķ̫̝̗̅̎̂̚͝c̷̖̤̈́ą̵͗͐eư̛͓̲̼̮̯̗͙̭̘̱̯͖̖̞̟̩̯̫̭̈́͌͒̌̌̾́͘͜h̼̿̂ō̴͕͎̼̤͈̗͓̹̑̇͐̒͘n̯̾̑͝, reason: contains not printable characters */
    public static Handler m32x66e48bbc(Object obj) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() > 0) {
            return ((MainActivity) obj).x;
        }
        return null;
    }

    /* renamed from: k̴̴̴͎̫̤̠̓͒̂͑̾͑̈́̅a̷̶̧̲͂̌͌̕Ḇ̴̷̵̸̴̶̟̠̲͈̹̻̽̌͑̀̈́̋̀̈͑̂̃͘͜͝K̶̵̪͕̭̠̗̃͌͋l̷̛̹̝̯̿̽͆̾͘͝͝K̵̵͈̐̈n̢̦̪͌̾̈ta̷̗̗͕͋̄̍̏͘͘Ǩ͗c̵̸̸̨̢̯̥͈͈̤̤̯̫̫̫̦͗̍̔͌̔͌̌̿͌͋̍̎͒̎͜͝͝͝͠͝ea̿̏͐̑̋̑͠o̾͌͗͝K̴̷̸̨̨̧̧̧̭̦͈̯̹͈͕̪͉̈́̃͌̾͑̃ą̸̴̴̺͕̭̮̹͎̺̙͙͎͚̗̜̪̱̭̮̘̺̺͊̋̌̅́͗͑̌͌̅̎̎̎͌̐͗̌̀̑͋͗̒̉͌̚͜͠͠ͅâ̷̭̹̙̂̑͂͜u̢̧̥̹̯̥̥͓̲̝͎͑̏̚͝͝Ķ̫͚͚̈́̑ȧ͚̭̹̃c̵̸̨̖̖̺̖̆̋̌̚͘͝n͂̐̋͊h̷̽͠K̗̈, reason: contains not printable characters */
    public static a.C0116a m33x18e336d() {
        if (ccooopahacBnhcacooKa.m76xf651d881() > 0) {
            return d.c.d.a.s;
        }
        return null;
    }

    /* renamed from: k̷̶̴̥̦̝̲̺̖̞̀̍̔̈͊͌̾̃͗̚͘̚͝c̶̵̢͕̻͎̖͓̺̑͂̂̈͗̕ͅa͎̲̚̕ǫ̶̸̸̴̷̴̡̢̢̲̬̤̖̫̮̼̭̤̰̤͓̗̥̫̻̖̖͉̺͎̺̩͎͌̉̏̏̍͌̾͑̍̆͌̈̌̌͋̈́̅͌̀̐̃̈́̈̾̈̆̆̕͘͜͠͠B̷̸̛̮̦̮̫̗̫̗̠̺̃̉̏̄̌̑͜͜ͅã̗a̸̶̶̧̢̛͎̭͉̦̤̫̩͓̍̔͑̃̿ņ̴̶̸̸̛̺̥͚͙͇̯̮̰̖̆̈́̅̿͗̂͊̌̋̔̋͝͠h̷̡ô̪K̸̷̢̛͎̩̜̥͎̟̹̤̭̙̗̹̘̎̿͋̑͋̌͗̆͘͜͜͝ͅa̶̧͓̤̺̗̯̿͌̋̔̑̈́́͝͝͝B̸̸̷̷̢̧̞̯̺͎͉̞̠̑̌́͋̑͜͠͝l͎̫̦̱̥͚̈̋̎͊o̍͘ũ̷̷͚̩͎͒́͠ǎ̧̺̯̥̓͌͜͝ͅk, reason: contains not printable characters */
    public static com.omarea.common.ui.i m34x64582924(Object obj) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() >= 0) {
            return ((j) obj).b();
        }
        return null;
    }

    /* renamed from: k̴̶̴̵̶̸̢̧̮̜̮̮͈͕͚̼͓̽̂̾̈́͋͗̋͒͌͋̂̌͘̕͝͠ͅǨ̶̸̥̯̘̦̠̫̻̈B̵̷̷̸̨̧̨̛̛̼̺̦͎̙̥̰͕̺̠̹̺͐̂̿̌͗̔̅̂͋̌͗̃̑̈́̆͌̈́͒̈̌̑͗̈́̈́̐͘͜͜͠͝͝͠͝ͅo̠̹̗̔̀͒̀͠p͎lķ̵̸̎͋͑̏̍̈́̽ų̸̧̫̯̫̫̯̦͎͂͌̋̊͋̂͆̕͘͜͝P̹̺̘̑͗͘͜ķ̸̸̪͎̮̘̎̂͘̚͘͝ą̶̸̶̛̟̞̦̗̪͕͚̞͓͑͑̾͌͆̀̑̎̈́̈́͐̋͘ȏ̧̺̘P̷̼̫̯̀́̽̌̕͜h̛̝͕͕͈̐͊̈́̂̈͘͠ë̵͎́̂͌͌͘l̵̯̹̲̦̱͆͌̄͑ņ̶̟̹̼̥̻͙̫̲̎̌̌͘̚͜a̶̴̸̡̛̯͚̺͓͎̭̪͚͙̫͈̪̫͕͕͗̂̈́̂͌̎͗̾̈̃͘̚͜͝͝͠, reason: contains not printable characters */
    public static com.dna.tools.e m35xd96af4d0(Object obj) {
        if (occatKolokBtoapaKaPhp.m184x48849b02() < 0) {
            return ((MainActivity) obj).y;
        }
        return null;
    }

    /* renamed from: ln̷̩͈͇̫͈̙̮͌͋͌̔͗̋̋̃̎͆k̸̴̛̫͈͎̹̗̪̭̭̮̮̼̇̿̈́̑̎̚͝͝ḧ̭̱Pk͙̥̦͉̪̯̗̀͋K͉̱̫̘̙̙̯̲̅̑̂͗̊̈́ͅà̶̰̯͙̈́͗̅c̢̙̾͐͑͌̌̑̀̍̑h̴̤̫̯͙͗̌K͈n͈͜ầ̵̸̸̴̸̸̷̛̘̹̫̦͙͚͕̦̰̫̫̮͌̿̂̎̅̋̃̋͌̌̈̑͋͘͝ḛ̷̛̫͚͎̱̈͂̋̌̑̿͌͌̿̄͘̚ö̸̷͚̘̪̭̙̘̮̫̮̰̗͙̰̜́̀̃̈̿̑̋́̈̽̍͋̋̅́͗̔́̆͘͜͝ͅḧ͓̥́̋͂̌͠ͅn̸̫͚̻̹̦͌̄͋̌p̧̟e̞͋͐̓̌͘͜͝ơ̶̸̷̧̢̧̢̰͈̘̦̹̪͉̻͎̪̥̬͌́͋͐̅͗̇̿͗̏͊͊̑͘͜͜͝ả̬̺͊͘p̢̢̺̭̭̫̫̺̈́̀͌̌p̹͓̯̈, reason: contains not printable characters */
    public static com.omarea.common.ui.h m36x3b5e92ff(Object obj, Object obj2) {
        if (ccooopahacBnhcacooKa.m76xf651d881() >= 0) {
            return ((com.omarea.common.ui.h) obj).b((String) obj2);
        }
        return null;
    }

    /* renamed from: l̸̶̷̢̢̢̧̨̛̫̰̭̖̗͉̘͕̺̗̫̫͓̻̥̀̌̋̋̂͗̈́̂̈̎͆̎͑̈̈́̚̕̚͜ả̸̧̢̹̹̹͎̋͑͂̋͗͘P̸̷̸̷̵̨̢̛̫̙̺͓̯̯̮͕̥̲̺̫̆̌̃̄̈̑̿̋̂́͜͝a̷̸̢̧̢̫̺̭͇͓̪̯̱̗̩͉̺̹̔̿̾̋̆̅̈́̌͐̈͗̚͝aa̧͕̅͑̃̌̈́a̷̧̼͈̮̟̍̊̈̚̚̕͜͠͝ul̢͉͚̯̲̟̫̮͋͌̂̆̈́͗̆̌̽͐́͋͗̏͂̓̀̏͘̚͜͠͝ͅͅc̴̷̡̧̭͉̹̮͚̪̈̂̾̀̅̃͘͘͘̚ṷ̷̧̧͓̖̾̈̈̌ã̷̸̸̷̧͈̺̲̗̺̗͉͚̺̎̌̈́̿͆́͋u̷̢̢͉̠̞̍͊͝B̯̯̫̫͎͉͉̃͌̆͋Ķ̡͉̱̺̋̎̅̋̆o̴̧͉͕̗͒̂̿̃͋͌ǎ̷̛̘̱̦͈̭̖̈́̌a̘̐̌, reason: contains not printable characters */
    public static boolean m37x83f1b7a9(Object obj) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() >= 0) {
            return ((com.dna.tools.e) obj).a();
        }
        return false;
    }

    /* renamed from: l̖̱̥̻͚̱̂͌̄́̑̐͗t̠̱̩͐̏̀K̫͈̆͗͝ê͂̕ȃ̶̪̺̘̓̌͌̈̅̏̈̎̿̾̂̾͝ẽ̹̪̽Ḱ̶̷̸̛͎͚͚͇̞̦͌̎͊̂͒̌͝a̻͙͊͑̑̂̋̇͑̋͜͜e̴̶̸̸͖̫̩̰̭͎͓̪̱̘̺̬̗͎̝̯̼̼̪̥͖͈̩̲̠͓̫͂͊̽̋̋̔͐̄̈́̈́̂͗͐͐͋͌̅̿͗͊͘͜͜͜͜͝͝͠oā̸̛̪̦̰̱̹̘̱̿̆͗͋͋͑̒̐̎̈͌̋͜͠P̥̥͗̂̑͝o̮k̡̫̬̯̤̋͋͗̚o̗͉̺̘̤͎͗͌̾̅ö̸̸̷̶̷̸̷̢̧̧͈̖̠̪̱̭͙͎̰̥̩͉̹̦̫̭̬̠͉̘͎̫̭͉̖͎̦̱͚̗̰͉̇̋͋̾̍̌̐́̆̾̈́͋́̋̈́̑̈̂̌̾̃͋̑̔́͌̆̾͊̋͌̔̓͗̂̕͝͝͝͠͝KK̦̲͎͕̍͋̊t̗͌, reason: contains not printable characters */
    public static void m38xa9667016(Object obj) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() > 0) {
            ((MainActivity) obj).Y();
        }
    }

    /* renamed from: l̴̷̟̭̩̹̥͉̄̌͘k̹̹̼̫̺̒̌̊̾͝n̷̴̶̢̧̧̧̛͕̩̘̗̗̺̮̖͚̺̯͕̘̥͚̘̜͋̒̔͑̋͗͊̿͗͑̅̈́̌̚͘̚͜͜͠͠ͅa̢̛͉̘͓̲̬͓̋͋͊͐ä̸̵̷͚͓̥̭̈́̾̎̌̈͂̌̇̀͑͘͜͜͝͝n̩̋̚͠h̵̹̻͘a͕͝l̛̘̂ḱ̸̟̻̯̖͕͈͌͌̅͝ḁ̷̷̵̴̥͉͇̙̈͗̈̕̕͠͠ẗ̶̴̨̛̘͕̱̫̘͈̼͈̫̹̞̙́̈̓̈́̃͌̿̋̈́͂̈͐̚̕͜͝B͚c̛̤̈̾́̂͝P̻̺͝a͊̾͜ẗ̸̶̘̠̠̦̦̜̰̥̹͓͎̩̭͓̘̹͈́̄̌̔̎́͌̅͋̕͜͜͠͠͝͠ǎ̴̧̡̧̛̮͓͕̲͚͉͌̄̌̈́̃̌̚͠ȏ̪̦̺͓̞͈͎͓̺̺͐͑̋͒̌͜l̅̍̌c̷̷̛̹̪̥͈͋̃̎̄̈͜͝ͅ, reason: contains not printable characters */
    public static boolean m39x1d2e9eb4(Object obj, Object obj2) {
        if (ccooopahacBnhcacooKa.m76xf651d881() > 0) {
            return e.p.d.i.a(obj, obj2);
        }
        return false;
    }

    /* renamed from: l̢̛̯̻̦̥̼͒̌͘͝ǫ̛̗͚͖͕̺̥̐̌̀̋̌̎͗͒̌̈́̂͂c̘̜̦͈͈͑͊̌̂̄̾̚͠ņ̈́ơ̴̶͙͉͙̖̺̺̮̤̗̘̯̺̭̫̦̄̋͌̋̄̑̋̑̈́̑̌l̴͉̮͗̐͋̏̒͋k̰̚̚͝a̸̧̧̮̥͚͌̅̐̀͑́͝͝h̹̋P̴̧̼͚̉̋̀͋ǒ̸̸͠a̋̂e̛͎͖̱̮͇̥͖̠͋̅͑̌̋̌͜p̭̯̘̋ǫ̷͉̖̫̊̀̈́͌̑̀ao̴̴̴̧̧͓̙̗̦͙̩̘͗͑͗̇͗̈́͘͘Ķ̵̮͎̠̘̭̯͓̯͓̻̆̑̾̂͐͝a͌K̸̷̴̨̫̫̲̫̹̘͈̻̗̻͉̖͓̹̪̪̘̯̘͚͌̏̐̂̅̿̉̔̍̌͗͋̈́͑̀̑̿̋͌͗͘͜͜͜ͅp̴̸̨͐̔̑̊͘͝P̷̔͑̾B̶̭̮̲̫̫̤̫̦̓̈̋͜͝͝ͅą̶̨̛͈͗̑͌͗͗, reason: contains not printable characters */
    public static n m40x4c1febbb(Object obj) {
        if (aalloKKholeaacllnou.m68xcb69398c() <= 0) {
            return ((androidx.fragment.app.i) obj).a();
        }
        return null;
    }

    /* renamed from: l̈́̃͘P͈͕̙̄͊ȗ̶̖͕̈͑̌͘̚͜laa̛̛̘̗̎͂͠h̛͖̘̉͌̆͌͊̚͝h̎ļ̰̖̗̦͓̗̈̄̂̔̐͐̀̍aB̸̴̸̸̧̢̢̛̩̻̼̫̥̥̺͈̖͈̱̯͎̫̼͈̦̲͐͒̈́̾̏͒̍͌͗̂̽̄͑̑̾͌̑͋͑̐́̋̈́̌͗̑͑͗̋̂̈́̒͘̕̚̚̚͜͜͜͠͝͠K̶̴̹̥̪̭̥͈̫͙̠̤̗̯̖̲̋͋͒̐̾̎͜͝ͅe̦͠ac̐̎̂̋t̢o̱Ǩ̸̷̨̫̦͊̈̿̈̾̚͜c̷̷̨̧̛͓̰͈̲̖̮̼͖͚̒̀͗͑̏̃̈̈͋͌̂̎͌̚͝o̪͙̱̤̺͊̌͌h̴̢̛̛̗̥̻̪̜̦́͐͆͘͝c͐ǘ̚Pk̶̷̸̷̶̷̶̨̛̫̠̗͎̩͚͚̖͈̯̮̗̪̺̬̤͚̺͕̞̍̋͐̋̾́͗̀̋͗́̈́͗͒̀͘̚͘͘͘͜͝͝͝͠, reason: contains not printable characters */
    public static com.omarea.common.ui.i m41x7c4716e3(Object obj, Object obj2) {
        if (occatKolokBtoapaKaPhp.m184x48849b02() <= 0) {
            return ((j) obj).c((Activity) obj2);
        }
        return null;
    }

    /* renamed from: ňē̶͚̪̻͖̄̄̌͆̈̃͜͝p̶̴̸̧̡̛̤̱̫̭̰͉͖͎̯̺̤̖͓̰͌̑̈͋̈́͌̅̈̈͌̒̐̀͋̕͜͝͠͝͝K̷̸̛̤̱͓̪̫̟̟̺͉̻̤̯̑͒̾̾̋̋̏͗́̋̈́̔̎̐͋͘a̴̷̫̘̥̿͐̈͘l̫̭̫͋̉́͌̃͜ͅǨ̸̴̥̫͓͚̯̱͚̘͕̖̗̹̇̎̌̆̎̈́̋̈́̑͑̋̕̕͜͠o̸͎̲͐̃̚a̸̵̧̛̝̮̻̻͉̜̮̤̭̙͋̅̋͐͗̂̆͌̔͋̎̒̃͝ǘ̯̌pă̷̠͈̽͝ǎ̸̛͓͎̖̯̩̉́͜h̶a̧̻̫̍͑̂̾̍̚͘͜͝p̩̥̑͂̕͝a̬kǩ̸̢͕͚̤̥̤̙͙̌̋́͋͘̕͜ö̸̝̲̟̩͙̤̦͎̪̑̽͗̒͝a̶̙͖̺͙̙͗̈͐͌̈͑ĉ̷̸͙̺̫̥̤̺͉̗̎͌̿̅̏͂͝͝͝t̞̯͙, reason: contains not printable characters */
    public static a.C0106a m42x66ea8a7() {
        if (ccooopahacBnhcacooKa.m76xf651d881() > 0) {
            return d.c.b.p.a.j0;
        }
        return null;
    }

    /* renamed from: ň̸̵̟̖͎́̂P̺̗̈͊̔̔͗͗̕͜ḁ̫̈̌̆̌̌͒͝p̢̧̧̰͓̗̄̂́̎̋̌̾͜a̶̛̛̛͉͓̥͚̥̠͈̦̪͎̅̽̋̈̈͐̿͜͜͜͝t̛̩͈̺̅̈́͝ͅa̶̹͎͎̺̜͉͌̈̌̿͜͝͝h̺͈͕͑͂͝͝K̸̜̭̙̆͝ļ̶̴̡̦͓͎͙̈́̅̅̾͠Bp̵̶̤̭̲̘̫͈̎̒̍͌̅̋̒̎̕̚͝ö̴̧̫͎̠̺̾͐̈͋͜͝ą̮̫̱͚̤͌͊̑̌̏͘͜o̴̸̴̵̶̧̫͉̫͎͈̖̜̖̿̑͗̎̓̈́̍̿͝͝͝͠P̾eo̷̫͚̺̠̮̮̗̰̫̾͆͆̄̏̆̔̍̎̃́̎͘͝B̸̸̶̢͎̹̫̗͚͕͈͓̲̿̋͌͌̌̀̑̃͌͜͝e̷̲̦̗t̼̯͎͓̓͋̌̋̎Bà̋K̗͘pä̡̫̩ȃ̵͈̯̞̫̙̤̃̋̄̅̈́͌̿͜͜͝, reason: contains not printable characters */
    public static HashMap m43x13e585ba(Object obj) {
        if (ccooopahacBnhcacooKa.m76xf651d881() >= 0) {
            return ((MainActivity) obj).C;
        }
        return null;
    }

    /* renamed from: ṉ̡̛̖̯͉͕̼͌̀̀̈͌̉́͘͜͝P͠eh̤̑e̵̶̘̦͊̍͊͒̄̎ų̶̸̸̶̸̷̷̧̢̗̟̯̼͈̙̥̖͚͇̮̺͓̭͙͈͇͈̘͇̘̙̾̋̆͌̐̍͂̊̍͑̐͋͒̇̈́́̽̓͌̾͌̎́̓̋̔͘͠͝͝͝ṱ̶͎͎̦͎̭̻͚͌̏͠͠ơ̶̢͕̞͓̥͈̘̦͇͈͋͋͐̿͠p̴̛̱̮̋̈́̈͒͝ơ̮̖̂a̶̵̭̩̱͗̎̈́̈́̿͘͝eK̸̛̛̘̮̮̗͉̲͋̋̐̋̎̎ͅt̼̲̻͇̠̺͓̿͝epp̷̸̨̢̗͋͗̈h̢̨̫̫̑͌͐̋́c̷̸̡̛̝̫͈̦̥̰̈̂̏̎̌̒͑̌̔͠͠͝͝ô̷̶͈̥̹̦e̶̸̢̧͕̮̠̥͉̰̯̺̭̥̥̺͗̿͗̂͆̈́̄̃̆̀̿̈̚͘͜͜͝͝͝oB̸̵̛̩̱̮̈̄͋͒̈́͜p̘͒P̸̷̫̏͝, reason: contains not printable characters */
    public static void m44xe93c77b3(Object obj, Object obj2) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() > 0) {
            ((r.b) obj).a((String) obj2);
        }
    }

    /* renamed from: o̸̦̫̲͕̜͚̹̦̲̍͋͊͋͝k̹̫̖̫̱̞͓̐̈̍́̈̋̾̔̕͘͜ͅB̴̶͕͙̥͈͐͂͗͗͗̀e̱t̷̷ȇ̴̵̮̱͙̋̄͐ļ̫̗̰̖̯͈̤̩͉̫̦͌̇̆̈́̀̎̍͋̈́̋̀͜͝oK͕̻̯e̜h͙͙͎̘̾̌̄͋͝͝ͅͅa̛̻̫̲̫͉̎͝ơ̸̵̶̶̸̸̸̧̧̧̛̟͖̯̗̭̪̗͓̦̗̪͎̪̈́̈̌̏̈̂̎́͑̅̏͊̒̈͒̚͝͝u͈̥͌͑͜p̵̨̫̭͓͙̈́̃͗͌̈̌͘͠ö̥a̶̬̥͎̘̲̰̯̮͈̋̐͗̏͌̈́͌̌̆̅͘͘B̸t̠̀̂o̷̷̢̮̗̯̫͙̾̌̋͆̋̎̌̄̎̋̀͌͜͝c̷̶̶̶̸̨̢̧̨̢̲̯̫̺̯̻͖͇̎̂̇̅̿̋̆̋͘̚͘͠à̶̸̢̯̺͚̱̮͊̓̂̚K̷̛͌̂͜ͅǒ̧̩̫̤̿͑͝, reason: contains not printable characters */
    public static void m45x14b21624(Object obj, Object obj2) {
        if (ccooopahacBnhcacooKa.m76xf651d881() >= 0) {
            ((androidx.appcompat.app.c) obj).D((Toolbar) obj2);
        }
    }

    /* renamed from: ơ̸̖̗͈̰̥̝̌͋͋̋͠Ḵ͝ļ̹́̏͑ḁ̵̸̴̶̶̧̛̱̤͚͈̤͉͓͎͓̹͈̯̼͗̋̆̂̅̈́̾̐̑͗̾͋̿͐̄̐͊̈͘͘̚͜͜͜͜͝͝ͅǫ̸̸͈͉͈̋̔̾̾͗̈́͗͘͝tB̧̢̨̛̹̼̦͚̥͈̤̖̭͌̉͂͑̂͑͗̌͌̕͝͝͝ḧ̴̗͓̺̹̯̹̫̭̱̗̱̾̉̾Ķ̷̴̮̖͉̒̈́͋͂̕â̸̦̫̱̫̱̕̚ä͓̦̦́͜͝t̀ç̸̸̨̢̛̹̩͓̩̮̬͙̖̝̫̱̘̺͈̤̯̦̯̫̯̐͗̉̿͂̓͌͂́̑̍̋͋͗̀̍̈́̋̆̌̿͜͝͠͝P̶̵̷̸̴̛̛̹̖̤̤͙̫̘͚̘͚̘̯̄̑̽̅̋̂̋͌̎̔̈́̈̌͌͌̈͗̾͘͜͝t̸̸̺̘̲̖̫̥̰̙̼̾̉̽̓̑̾̑͌͋́́̌͌̓̋͗̚͜͝͝a̵̯̮͎̙̜̲̾͜, reason: contains not printable characters */
    public static void m46xe122ec89(Object obj, int i) {
        if (aalloKKholeaacllnou.m68xcb69398c() < 0) {
            ((androidx.appcompat.app.c) obj).setContentView(i);
        }
    }

    /* renamed from: ö̸̧̗̖̋ḧ̸̴̨̛̫̹̦̯͓̰̹̲̱̯͓̱͓̫̱̗̝̯̺̈́̈́̀͑̂͠P̶P̠̱̜͕̥̺̺̬̫̖̺̙̈́̋̾̎̌͌́͝c̷̷̵̷̶̴̵̡̛̛̼̘͉̗͚͉̥͉̮̩̥̗͎̗̫͒̀͂̈̈̎̀̎̆͋͗̒̅̀̚̕͜͠Ķ̫̫̩̦̘͙̥̔͗̂̐̚͜͜͜͝P̢̢̥̗͎͕̮̗̫̰͈̦͓̞̭̎͊͌̃̋́̀̈̚͘͝ȟ͚̩̭̽̅̌Ķl̷̗û̢̮̤̲ö̗̟̿̒̀͜ņ̶̠̹̯̠͕̰͈͓̹̱̘̮͂̅͋̂͗̌̋̾̀͗̌͘͜͠͝͝͝tK̸̛̠̠̺͌̀̀͌͌̇̌̋K̢̛̫̱͈͎͈͎͕̮͙͈̐̌̈̋̀̂̌͌̅̑͜͝ã̫̘̗̉PK̶̯̀̌̏͋͝ő̵̷͇̼̝̼̚͜͝͝a̸͓aK̷͇͖͌̂̏̌a͚̿̈́c̶̥͕̰͎̄͠, reason: contains not printable characters */
    public static String m47x474ecb7c(Object obj, int i, int i2, int i3) {
        if (ccooopahacBnhcacooKa.m76xf651d881() > 0) {
            return ccooopahacBnhcacooKa.m93xeb8d073e((short[]) obj, i, i2, i3);
        }
        return null;
    }

    /* renamed from: o̸̶̢̧̡̞̖̘̫̗̩̹̺̫͇͎̺̗͕̼̘͗͌̌̎̈́͑̈̋́́͜͠͝ͅͅë̶̸̢̫̠̦̫́̎̎̎̾̉͂̃͜B̶̸̸͕͎͎͓͉͉̅̿̌̂͒̃ha̶̛̰͓̮̦͈͂́͊͊̑͘B̶̧̫̭͋͌̈͂̊ą̡̢͎͉̫͎͇̹̽̃̈́̌͒́́̂̄̎̈̉͘ǫ̶̷̵͇̲̱̲̭̫̦̈̂̐͐̽͒̏̅̀̆͘̚͜͠͝K̸̨̧̨̤͓̯̫̫̮̱̯̱̻͉͎̫̃̈́̋̂̂̍͊̇̌̄͌̂̄͑͋̚͜͜͜͝͝ȧ̶̵̢͉̗͕̹̈͑̐̈́̈́̌͝l͉̜̥K̶͎͕̹̥͉̥̂̾̈́̌͜͜͜͝ac̡͕͉̈́̑̍̀͝͝o̸̷̢͚̟̹͉͉̮̺̦̬̩̹̺͌̏̑̂̇̐͌̓̐͊̚͝c̸̵̢̧͖͈̞̭̲͉̈̋̈͐̌̅̌͊̕K̈Ķ̶̭̰̌̐͘n̻̭̥͊́̂̾͑, reason: contains not printable characters */
    public static void m48x42dc6ec5(Object obj, Object obj2, int i) {
        if (aalloKKholeaacllnou.m68xcb69398c() < 0) {
            androidx.core.app.a.h((Activity) obj, (String[]) obj2, i);
        }
    }

    /* renamed from: o̵̧a̴̭̭̖͖̿̉̂̍͗͝͝k̑̄ą̶̨̨̧̧̮̦͕͚͚̭̠̻̝̱̺͙̻̯̃̅͌̾̑͗́̋̍̈̋̎͆̂͌̈̾́̚͜â͈͓̯̭͎͖̮̹̺̼̺̺̑̈̀̅̅̔̎͌̈́͒͌̔̒̒͒͋̿̎͐̄̍͒͠͝͝K̸̷̡̨͚͉̖͚̈́̄̅̈́͌͋̾̑͂̑͗̌͌̃̑̃̚͘͜͠͝͝͝u̸̷̸̠̫͚͙̦̎̂͌͝c̶̶̴̺̭̫͚̝̗̼̗͈̈̈̋̆̃̀̈́̈́͊̕͝K̵͈͈̭̫͓͓͙̎̄͘͝l̴͉̠̩̮̫̦͆̋͒͗á̴̶̶̧̠̹̭̰̪̻͖̌͒͗̃͝͝ṋ̶̸͈͎̂͘B̴̵̷̢̥͎̠͌̂͌͐̈́͐̌͘B̷̶̶̛̬̗̞̱̬̭̿͑̈̈̌̌̑̾͊̏̋̈͘͜͠ö̢͙̤̮͉͖͌̂K̸̢̫̈́̌a̵̘̿̎̎͋̈́͠K̸͓̥̺̮͑̈́̅͒̀̂̚, reason: contains not printable characters */
    public static void m49x6284ac82(Object obj, Object obj2, Object obj3) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() > 0) {
            ((MainActivity) obj).a0((ArrayList) obj2, (PageNode) obj3);
        }
    }

    /* renamed from: o̴̫͓̩̠̒́̈́͐ä̸̵͚̭̲̹̭͕̺̰̘̫͖͊͂͜͝n̵̨̘̲̪̥̺̭͌͂̀͗͆͝n̵̸̷̸̢̡̛̛̘̪̱̼͈̺̻̯̭̤̙̝̩͎̋̑͌̐̌̃̆̄̈́̔̑̇̈͒͌̇̎͘͘̚͜͜͜͝l̵̶̸̡̰̥̜̻̦̠͎͙̯̋͐̐̐̐̇̂̃̅́͝͝͠k͓̬̼̪̮͜ha̶̪̗̭̟̥̭̅̔̈́̌̈̾̐̄͘ȏ̡͈͉̮̯̱̗̺̦͓̹̄̈́̋͑̋̋͝K̤̜̲͋B̶̦̞̱̲̘̿̑̌̈͋u͎ķ̧ę̧̪̥̑̈͐a̶̧̠͉͉̻͚̫͌̂̈́K̷̸̸̴̡̛̰̲̫̯͓̩̙͉̀́͋͑̋̏́͜ļ͚̗͓͖̮̯͈̠̗̀̏̌̇͘͝n̘̄͌̈́p̦̐͐͝ň̷̶̷̸̸̢̼̥̮̱͕͕̟͓̱̝̻̗́̈́̿͋͂̏̄̂̾̌̊͌̐̑̿͂͘̕̚͜͠͝͝͝, reason: contains not printable characters */
    public static int m50x87b75ccb() {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() > 0) {
            return g.main_tabhost_cpu;
        }
        return 0;
    }

    /* renamed from: pǫ̮͚͝ǹ̸̴̨͇̮̗̞̃̐̐̌̋̾́̌̚͠͝͝ͅu̷̸̎̿͂͘̚͝a̮̞̿͗ë̘̦́͋ṋ͕͎͌̇̔̋͐͜͝t͎̀̈a̸̶̶̧̧̧͚̰̬̥͉̻͑́̈̌͗̐̋̑̋̈́͑̑̚͠͠͠ư̶̸̷̸̸̸̧̧̢̪̘̪͉̯͓̥̗̟͓̗̻̪̗͎̺͈͉͕͇͉͈̦̱̗̹̠̻͋͑̈́̈̑̋̈̾̂̏̋͋̄̃̑̃̊̈͘͘͜͝a̱̼̪͐̿̾͌͜o͈Ķ̸̗̯̝̗̞̻͉̫͚̤̹̄̂̈́̋̈́̅̾̋͘̚͜͜͝c̒h̪̾l̯̼a̧̙o͚͗̍ç̶̸̶̵̧̧̧̨̧̹̪̗̟̼̮̙̫̫̜̰͖͈͈͕̬̺̝̫̈̇͆͌̄͐̑͌͗̍̿̈́́̀̌̊͊̐̈́̅̈́̈́̂̂̂̌̈́͑̎̀͜͜͜͜͠ķ̵̸̸̷̥͚̯̠̫̤̬̗̭͎̭͕̂̈́̋̇̎́̄͋̈̍͘͜, reason: contains not printable characters */
    public static KrScriptActionHandler m51xdcc43825(Object obj, Object obj2, boolean z) {
        if (ccooopahacBnhcacooKa.m76xf651d881() >= 0) {
            return ((MainActivity) obj).W((PageNode) obj2, z);
        }
        return null;
    }

    /* renamed from: p̸̶̸̗̱͙͚̱̼̪͉̌͗͌̌͐͂͒͋͜͜͝͠B̴̷̷̧̧̧̻̺̜͈̯̗͚̙̱̺̥̯̊̋̈͆͐͐̋̍̾̈́̅͌̾̑̈́͜͜͝ͅn̘K̸̴̶̸̶̛̪̲̪̭̭̯̖͓͈̩̤̩̘͎̜̠͕̯̭̱͎̋̄͒̀̈́͊͐͐͑͋̾͑̌̾͗̏̋̂͆̃̚̚͝͠͠p̺B̙͆a̢͎̯͕̋K̶̻͘͜e̴̸̸̢̛͕̦̺̋̒̈́͗̈́ú̊͝h̷͚̞̑ẖ̤̿̌̌ļ̻͌̋u̶̗͉͚̾̂̎̚̚Ka̋ȩ̶̛̹̫̬̫̮͎̼̞̌̽̔͂́a̷̡͚͚̽̍̂̅̂̌̈́̌̄̂h̭̎̄̒̐͘BKǒ͓͂cǎ̷̶̸̧̢̛̯̤̗͕̗̹̭̲̯̍͑͐̅̑̈̄̕̚͘͜͝͝a̶͙̱̫̫̙̠̯͓̹̺͂͗̃̍͊̾̍̎̅̿̈̒̇̚͘͘͜͝ͅu̸̧̧̮̙͋̌̄̂͑͋͘, reason: contains not printable characters */
    public static void m52x22f8dbac(Object obj) {
        if (aalloKKholeaacllnou.m68xcb69398c() < 0) {
            ((com.dna.tools.c) obj).b();
        }
    }

    /* renamed from: p̷̴̷̴̷̨̯̤͕̤̫̹̗͎̗̞͕̘̅̏̀̅̌̃̌͑̅̃͗̾̂͋͗̈̑͝o̢̱̭̙̫͚̤͈̫̅͋͂́̆̈́̋͗̏͘͝͠P̷̨̧̡͓͉̦̘͉͚̈͌͌̾͠oừ̸̸̴̴̷̢̧̧̯̺͓̬̗̺̫̤̺̗̦̫̓̔̈̎̋̌̋̄̈̋͘͝͠͠ͅͅā̷̫̯͗̿͝ő̸̯̥͎̋͑̌͆̀͜͝B͙͇͖͉̞̎̂̅̍͝ö̶̷̧̢͕̎͗̿͋̈́̎͋̏͜P̵̶̛̫̹̟͚͙͇͚͌̈́͋̂̅̐͌̾̎̚l̸̶̷͓̫̂̋̎̒B̸̶̢̛̹͎̮̤̹̤̭̘̌̂̋́͋͗͋̈̚B̷̧̩̺̝͓͐͑͊̈́̍̌̋̂̚̚͜͝͠k̢͓͉͓̈́̑́͊̒̏n̶̢̧̧͇͈̺̯̫̱͚̙̯̦̲̋̓̃͊̎̐͌̚͘͜͝͝ḩ͓̤̈͌̾͗e̙̰̻̻͚̩͚̺̾̌͌̈́̋͘ȟ, reason: contains not printable characters */
    public static String m53x250d490b(Object obj, Object obj2, Object obj3) {
        if (occatKolokBtoapaKaPhp.m184x48849b02() < 0) {
            return ((d.c.a.f.a) obj).b((Context) obj2, (Uri) obj3);
        }
        return null;
    }

    /* renamed from: p͌a̴̴̧̡̧̡͙̺͎͕̮̮͖̯͈̫͖̔̈́̌̃̾̋̄͑̀̾͋̀̃̕͜͠͝t̛̙̊̀̅͌͝p̴͑͗͜͠ḁ̸̺̎̆ͅṋt̪̹̄̑̃͘͘k̪̩̄̎͜͝K̨̂ņ̯͈̹̑̈́̚o̸̵̷̴̷̧͈̮͓̯̙͙̙̫̗̞̾̌̌͐͊̌͊̚ͅa̷̫̫̘͈̭͗͆́a̸̞͈͝P̶̸̱͚̺̱̲̫̲͚̉̾͌͗́̋ņ̵̧̡̛̹̫̰͎̉̄̈̌̈́̐̾̆͌͋͘͜͝͝n̤̄͑P̛̫̗͈̃̅̔̚ȩ̸̵̺͚̱͂͌̈̈́͗pḩ̷̵̷̨̛͙̯̩͚͚̺̠̬̦̭̤̯͈̩̥̦̃̔̑͒̎̄̈́͒͐̄̎̔͋͆̂̈́̏̇̑̅̏̿͌͒̿͜͝K̨̫͕͉̺̼̑͊̔͝t̷̤̘̫̘̙̼͇̭̭͉̻͎̗̭͎̺͑̂̾͐͋̾̄͘̚ę͕̫̹̦̪͈̥̂̂͗͗̑̎͜͜͠, reason: contains not printable characters */
    public static int m54x196e6e9d(Object obj, Object obj2) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() >= 0) {
            return c.f.d.b.b((Context) obj, (String) obj2);
        }
        return 0;
    }

    /* renamed from: p̸͖̘̼̮̻̎̀͐̍͒͂̈́͗̚͜ą̴̸̧̛̛̭͙͈̺̫͐̀̈̉̌͗̇̃̂͋̎͝͠nñ̸̻̹̯͖̑͘u̷̶̢̯̱̫̗̮͓͓̭̖̺̮͌͗͊͗͒͆̂̽̚͘͜o͌Ķ̡̘̻̺̜͖̪̗̻̖͚̖̦̦̘̬͕̖̃͒́͐̌̋͒͆͂̐̽͊̌͝͝ṱ̴̵̸̺̗͎̞̐͌͌̎̈̔t͎̺̯̅̓͋P̴̷̮͚̗̗̫͈̭̬̆͗̒̃̚͜͠͝e͈͑̕a̸͈̰̩̬̾͌̊͋̿̀̾͑̕͝͝a͘l̖̉̈́̑̈́̂̈a̧̘̩̘͚̮͉͆̈́̂̋P͌̈t͖ȩ̴̵̧̧̧̰̭̼̪̺̲̻̹̠̮̹͈̫̝͕͎͕̲̰̠̥̺̘̈͌͊̈͋̎̓̈͗͂̈͋̍̀͗̌̅̚̚̚K̤̯̗͗̃͊͘ō̶̻̪̥͋͌̃̂̈̏͜tp̭̲̌c̸̷̸̱̭̫̗̺̄̋͐̈́̋̋̌̂̚̚͜, reason: contains not printable characters */
    public static String m55xe4fe62a4(Object obj) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() >= 0) {
            return ((r.b) obj).c();
        }
        return null;
    }

    /* renamed from: t̸̢̙̭̹͉̹̦̱͚̂̉͋̆̂̏̄͌̋̾͗̒͘͝o̸̷̭̫̎͝p͇̿͝pç̵̸̶̷̴̴̸̧̤̘̦̤̬̭͓̯̘̖̠̗̞̮̬̋͐̃̇̂̄̅̎̊̀̂̔̎͒̈̄̓̌̏͌͗̈́͊̌͋̈̐͑̊̌̕͝͝͝͝͝͝ḩ̴̸̸̛̝̫͈̭̹̲̺͙̦͕̠̑́̄̏̓̎̋̈̐͜͝ļ̤̠̠̦͈̬̖͑̎̐́̀͒̉͘͝ľ̫̺̗̌̄͑Ḱ͓̲͉̤̬͎̼̝̫̘̺̆͋̂̎͆͗̈͘͜͝͝o̷̸̴̧̘̘͉͕̻̻͈͉͉̦̎̂͗̄̎͘̚à̰̬̮̉̌ą̸̶̸̟͖͚̪̪͎̙̭̭̿͆̇͋̽͌̅̕͜͜͝Ķ̸̖̫͉̫̫͓̍͋́̌́̑̈̀̋̆̔͘͜͝͠ö̦́̌K̺͌̍ṱ͇̲̯̰̫̭̙̼͑̏̂̎͒̑̿̐͋̅͘͝P̸͎͉͉̦̫̯̹̏̒͗͑͑͘, reason: contains not printable characters */
    public static String m56x889e8dee(Object obj, int i, int i2, int i3) {
        if (ccooopahacBnhcacooKa.m76xf651d881() > 0) {
            return opPnkpaatkaatonataKpceo.m239x2f4a2b12((short[]) obj, i, i2, i3);
        }
        return null;
    }

    /* renamed from: ţ̷̶̢̛͇̼̱̠͚̗̤̜̭̫͓̗̭̌̑̽̂̿̋͑͐̆̏́̉͂̏̈́͘̚͜͝͝͠o̷̼c̸̭̫̄̏͘nt̴̾ṉ̢̧̛̟̦̗͈͙͈̟̗̀̈́̈́̂̿͑͘̕ő̮͑̎͌͘͝K̸̖̋̌k̋ṯ̸͜p̋̈́͌͘͝k͉͖̀͊́P̦͎̤̦̻̻͎͉̥̜̥͌̂̈́̅̄̾̐́̑͗͠͝͝ͅä̯k̷̶̡̛͓̂́P̧̲̝̹̈͌ô̶̸̢̡͈͚̹̺̱̥͓̫̦͎̰̺̹̮̗̲̱̎̃̈͂͒̏͘̚͘͘̕͝͠a̛͈͎̫͒̇̋ȩB̪͐c̴̢̤̗̑ȩ̴̪̂́ȁ͠c͚̺P̷̵̧̤̻͚̙̱̭̈̋̃̋̌̈͗̐͜ͅḽ̙̦̚k̷̵̞̭̯̟̯͉̄̈̂͂͂ç̬̹͎̗͚̂̅͗̀͠t̺̪̫̋̐ô̵̱̹̜̘̞̙̤͚͌͐́̿̑͒̋̋͒̏͆͌͘͜, reason: contains not printable characters */
    public static void m57x924a9a5c(Object obj) {
        if (occatKolokBtoapaKaPhp.m184x48849b02() < 0) {
            ((MainActivity) obj).Z();
        }
    }

    /* renamed from: ť͖a̸̢̧̫̦̤͎̹͚̫̩̖̭̎̓̎̓͐̎̂̽̏͠͝h̸̵̸̛͙͈̲͚͙̫͚̥̉̋̂̐̌̀͑͂̚͘͜͜͜͝P̶̷̷̧̧̢͕͚͎̦̟̗̦̬̥͓̭͉̜̭̿͌͌̋̄̂͑͜͜͝͝ư̶̧̭͇͋͂̓̊h̩͎̰̫͓͈̺̾̑͌̍͗ḧ̞́͑͝ķ̺̥̰̫̻̩̹͗̇̊̋̈̋̀̈́̆͑͗͜n̮̝͉̈̃̃͊̑͗͑̈́̍̑͘͜a̸̗̪͕͕̹̩̝̅̋̂̍͜K̴̥̼̰̂̓͂̌́͜͝t̸̸̟͓̱͈͌̎̋̌̋͜å̴̶̶̧̯̱̩̫̰̲̹̫͓̘͙͇̖͓̏͌̈̈̚͜͜͝k̗̪͙̭̦̑̈́͂̍͋͋͗̕o̷̯̘͋̌͝ö̶̴̸̧̢̪̘̤͚͉͚̱̠̱̦̙́̈́͗̈́̾̌͒̑̾̃͗͌̋̔̊͌̿́̾͆̑͝͠ö̶̗͓̲̹̪͈́͑̈́̈́͋̍̾͂͜͝͠k, reason: contains not printable characters */
    public static void m58xaa9f4961(Object obj, Object obj2) {
        if (opPnkpaatkaatonataKpceo.m252xb8564fc0() >= 0) {
            e.p.d.i.c(obj, (String) obj2);
        }
    }

    /* renamed from: ţa̸̡̫̗̩͓͚̎̄̍͐̎̽̃̋͘͝ͅo̱̗͌̈́͆͗̂n̰͈̫͈̹̫̈̌̈́̑̊̈́̏͜͜ç̷͎̻͓̺̪̄̂̆͌̈́͆̚n̷̸̸̛͎͙͓͎̩̪̪̰̻̘̬̦̤̂̂̂̎̌͌̌̾̔̂͊̂́̃͘̚̕͘͜͜͝ḙ̶̴̶̵̸̶̸̸̡̢̢̛̫̺̫͚̫͈̘͓̥͓̟̺̱̹̭͎͈̻̯͓̱̦̺̫͈̺̜̩͂̑́͂̆͒͗͂̅̀̂̂͒̂̈́̋̾̂̈́̂̌͋̿̈́̃͗̎̑̈́̂̚͘͘̚̚͜͜͠͝͝͠k̵̶̸̢̢̢̼͙̠̞̹̥̻͎̙̖̼͎͚͓̲̭͚̱͑̓̅́̇͆͊̊̿̇͂̽̌̏̿̐̈͊̒̾̓̚͘͘͜͜͠͝͝͝ͅô̧̼̪̌̀͆͂ư̴̷̴̷̧̧̛͉̗̘̹͕̥̺̫̔̅̌̌͐͘̚͜nţ̷̨̯̮̦̌̈̅̚c̵̻c̤͉͕͈̖̦̈́̈́̆̈́̽͜, reason: contains not printable characters */
    public static ArrayList m59x6d45c122(Object obj) {
        if (ccooopahacBnhcacooKa.m76xf651d881() > 0) {
            return ((d.c.b.l.b) obj).i();
        }
        return null;
    }

    /* renamed from: ţ̴̶̹̖͉̭̔̂͌̈̑͒͐̚͘͝Ḃ̸̛̪̮̜̖̖͗̋̍̽̀̎̑͌͘ͅu͚͐̈̃ư̶͈̙̥͎̭͓͇̹̫̮͉͚̍̆̌͌͗̿̈́̈͗̀̾́̉͌͋͋͜e̸̷̸̢̢̘̙͎̩̦̭͕͕͕͑̑̀̂̔̀̃̎̚ě̶̮̗̝̗͈̓̃̈́̂̀̈͌̔͌̌͋͝ţ̸̵̸͈͎̱̫̝̦̹͎͇͎̱̲̫̼̱̹̘͓̲͈̋̐̿͋̃͌̈́͂̃̏̌̇̿̓̿͋̋͋̋̃͋̑͘̚͜ͅţ̴̢̗͎̯̩̰͌̽͒͐͑͌ö̸̯̘̗́͂̆͋͒̌a̛̖͓̋͂̏̈́̑̍̈́̌͜͜͝K̋̆ơ̴̪̝͉̿̉͗͂̂̂̈́͘͝B̥̹̺͕͈̿̏̔͋̆͘͝ö̵̞̹̺̺̼̖̫̖͕͈̙̽̂̌̃̃͑͘͜͝l̀ő̶͓̲̀ǒ̜̥͓͈̈́͌h̢̢̙̑͜t̪̲͓͖̑̃̕a͗u̹̗͝, reason: contains not printable characters */
    public static void m60x30310ea9(Object obj, Object obj2) {
        if (occatKolokBtoapaKaPhp.m184x48849b02() <= 0) {
            e.p.d.i.d(obj, (String) obj2);
        }
    }

    /* renamed from: ũ̶̸̚ǫ̶͈͚͇̺̼̫̲̗̥̩͚̫̟̌̀̄͌͊͗͝͝ä̢̗͇̫͕̰̌̇̌̀͘ń̴̤̰̭͕̈͜h̿p̸̸̴̨̛̗̯̙̱̰̫̱͙̘̲̮̻̝͑̂̏̃͋̋̉͑̔̈́̈́̋̔͌̈̔̎̕͝͝͝P̮̫͂͘͘k̗c̸̙̪̱͈̠̎͑͌͑̚͜Ķ͉̘̠̏́̀̌͝ą̛̭̙̭̯͗̅͋͒B̈k̸̯ṋ̛͕͌ǘ̢̢͕͕̫͚̭̱̠̫̰̄̐̄͑͂̇̚͘h̶̺̏́́͗̈́͒͋́͋h̴̶̴̸̷̢̛͎̲͖̤͎̭̤̪̔͌̊̄̚͝ư̧̯̰̹̽̈̌Ḱ̸̫̠̮̓̉̌̋͝à̷̴̘̲͇̗͕̘̼̈͝n̢̢̏̃K̻̭̀̈́̈́͠K̛͈̘͈̈́͝B̞̦̃̊B̛̖͚̺̫̼̫̯̑̑͜͝t̴ừ͙̦̬̰͎̃̇̚p̶̸̥̭̺̰͌̾̚͝͝o̸̲͎̚, reason: contains not printable characters */
    public static MenuInflater m61x2d102dd4(Object obj) {
        if (ccooopahacBnhcacooKa.m76xf651d881() > 0) {
            return ((androidx.appcompat.app.c) obj).getMenuInflater();
        }
        return null;
    }

    /* renamed from: u̴̢̧̨̝̺̪̪̻͓̠̱̯̔̎̃̒̌̔̾͗͌̎́͗̋̎̿̚̚͜͜ͅĶ̸̷̸̶̡̨̨̧̧̢̛̥̠̱͕̫̪͕͈̹̯͚̠̹̘̯̰͓͎̰̹͎̫̂̄̈́̔̈̈̎̿̀͐̑͋͌̂͌̅̌͑͌̌̌̂̚͘͠͝͠͝ơ̮̠̯̾̍̚u̴̠͈͈͓̮̾̂͒̆͑̈̊̃͜a̹͑ā̢̫͉h̯͝lp̖͙̯̄͘͝ȯ͙̼̅͌̅͒͆h̺̖͝p̵̶͈̪̹̌â̸̫̫p̺̫̗̖̝̋̃̎͑͘c̸̫͕̈́̒͑͘B̷̻̯͚̞́̎͌̔͒p̶̛̙̉̌̑̚a̮e̸̶̸͉̗͚̭̫̺̮̻̜͕͑́͘͜͝ͅk̸̸̸̢͙̱̼̬̩͗̿͌͋̎̑̓̋͠ǎ̸̵̧̧̛̛̘̭͎̤̲̟̱͚̯̹̦͂̐̌͋̋̈́̅͌͑͌͋̄̃̄̾͊̌̈́͗͂͘͠͝a̸̸̺̙͚̭̥͉͌͠͝o͊, reason: contains not printable characters */
    public static boolean m62x16aa0d6e(Object obj, Object obj2) {
        if (occatKolokBtoapaKaPhp.m184x48849b02() <= 0) {
            return ((MainActivity) obj).S((String) obj2);
        }
        return false;
    }

    /* renamed from: u̢̪̯͎p̼̮̥̫̪̆̾̈́̎̄͘ţ̱̭̖̻͚͇̠̦̭̲̖̫̦̫̂̋̂̈́͗̓̽̑͗̔̚͜͝ȩ̫̑K̵̴̼̦̲̭͂͂̾͝o̫͉͉̞͎̒̆̃̀̈́̍̽B̰̘̫̥͊o͋̅o̱̺͗B̴͉̮̤͒̑̈͝ä̴̷̴̶̧̧̡̛̹͈̲̱̦̠̼̠̮̲͕̘̤͇̭͚̫̼͉̞̝̭̬͚̘̥͚̐̎̆̈́̾͗̌̋͐̈́́͊͐̂̅̐̌̈́̆̚͜͜͝͠͝͠͝ǒ̙̮͋͜aaa̶͕̮̺͑̆̅͜͝͝ȃ̶͕̜͊̈̈́̌̎ȍ̧͈̦͗̿͝P̯͙K͋̿͝u̷̢̻̭̠͈̙̎P̵̍p̸͙̭̖̗̪͚͚̅̌̋͆ḩ̶̶̡̛͎̦̭͉̪̬̭̖̈̋̿͋̈́͂̂̈́̀̅͘͜͜a̧͉̽e̷̮͌̅P̛̄̋̆͜͝k̖̗̫̫̬̩̖̮̗͉͋̅́͗̂͊̈̎̌̆͘͜͠͠͝͝͝, reason: contains not printable characters */
    public static String m63x69e6ad92(Object obj) {
        if (ccooopahacBnhcacooKa.m76xf651d881() > 0) {
            return ((PageNode) obj).getPageConfigSh();
        }
        return null;
    }

    /* renamed from: u̶̸̴̵͎͇͕̟͈̫̤̗̇͌͋͊̋̾̃͜o̸̵͓̭̻͌̑̀̃͌a̱̜͕͎̎̏͋̂̈̀̃̄n̫͉̪̱̦͚͑͌͗͘͜͝c̘̋̎̋P̨̛͚̦͋͂͘a̫̩̐c̶̹͙͉̗̭̋̈́͜K̢̯͎̹̰̠̠̺̎͐́̓̽̎̈́̅͗̈tK̭K̷̘̐̚̚͘͜p̴̸̛͓͖͚̱̥̉̐̈̑͠e̅̋o̧̠͎͈̱͎͎͚̅̋̿̒̃̆̀̿̈́̋̍͘͘̚͜͜͝͝o̡̼̤̰̍͌̈́̅̓l̷͈̪̼̺͚̱̦̺̪̭̄͊͗͆̎͑́̎̌͊̏̈͜K͎̺̫̯̻̫̋̈́͝K̋ȃB̧̌̽p̸̢̪̜̏̽́͜aṱ̶̸̵̢̧̢̛̦̗͓͉̥̯̲̫͉̺͒́̀͋̀̂̂̈͗̈̈͂̋̏̊͂͘͜͠͝ö̵̙̠̜͉́̿͌̈́͝͠B̴̛̛̛̛̜͉̠̯͉̑̂̈́̈́͋̅̑͝ķ̝̍̐̿̈́̑, reason: contains not printable characters */
    public static void m64x482584fe(Object obj) {
        if (ccooopahacBnhcacooKa.m76xf651d881() >= 0) {
            ((d.c.d.a) obj).n();
        }
    }

    /* renamed from: u̷̝͑͐̎̈́͜h̶̘͈͌̌̋͆̂͌ô̴̖͈̦͓̫̫̎̈̈̈́̈́̚̚͝a̷l̢̠̏̈́̒̏͝P̸̶̡̞̠̼̌̑̑̽͗̅̚̚͜o̯͝͝͝e͜͜͝ç͈̟̯̫͓̟̭͚͒͊̂́͗͌͠P̧a̷̭͓̮̯̻̋̅̃̔͑̊̒̇K̛͓͖̖̟̫͊̂̔͌̌̅͋ę̸̸̷̺̖͉͕͈͎̭̩̜̥͚͈̌͐̍̌͗͊̋̄̌̿̃̓͌͜͜͝K̶̶̸͇̫̪̥̏̾̋́̏̍̾͘͘t̸̢̢̪̫̗͂̂̀̌̃͂̎́̿͝B̴̴̧̫̘̺͚̻͕̪̃̾̐̋̿̅̂͌̑̒̈̒͒̚̚͜͜͜͝͠͝͝ͅK͉͈̱̗̻̐͋̔̐͝͝nnl̸̛̛̛͕̼̏̉́̋̐̚͜P͈̫͈̘̖̠̮̌̾̌͗͗͝P̈́P̢̧̯̹̼͆͌͊͘a̶̮͖͎̤K̶̛͕͉̑̃͒̌͘ȁ̫͈͈̮͗̇̈͌̈́, reason: contains not printable characters */
    public static int m65x96994b02(Object obj) {
        if (occatKolokBtoapaKaPhp.m184x48849b02() < 0) {
            return ((MainActivity) obj).A;
        }
        return 0;
    }

    /* renamed from: ữ̸̸̡̯̭̠̼̜̦̫̗̯̩̱̺̩̗̗̭̩̗͎͇̪̹̼͈̭̔̌̎̂̑̈́͆̈̂̈̌̀͌̄̏͌̑͘͘̕͜͜͠͝ͅp̷̸̡̧͉̹̱͇̃̿̆̊͂̃̋̎̃̕͜͠͝͠a̧̧̞̫̤͋â̶̷̛͕̺̮̺̬̦̗͈̖͉̰̄͊̋͐̋̉̌͜͜͜ů͇̗͊͗̈̌͜a̷̵̡̲̦̥̯̫̭̟̺͈͓͕̥̋̀̌͑͌̆̋ņ̷̷̷̴̴̧̧̢̢̧̛̛̫̗̘̯̺̰̙̯̥̩̺͚̟͎͓̺̜̦̫͇̗͚͓̈͗̿͌̅͌͗̈̉̂̂͊̈́͑͗̆̾̋̈́̒̂̒̂͒̾͜͝͝͠k̴̶͉͈̹̺ȇ̶̸̛̪̫̗͚̞̭̯̾͑̄͒̏́̄̾̿̎̕͝͝͠K͚̤̋̆͒̃͘a̸̶̴̛̹͙̯͓̭̋́̋̐̽͗͗̓͌͌̑̈́̾͐͠B̷̷̵̢̮̝͚̭̫̖̪̟̙̱͈͌͗́̈̈́̂͘͝, reason: contains not printable characters */
    public static String m66x42ce2c(Object obj, Object obj2, Object obj3, int i) {
        if (occatKolokBtoapaKaPhp.m184x48849b02() <= 0) {
            return ((com.dna.tools.ui.c) obj).a((String) obj2, (Drawable) obj3, i);
        }
        return null;
    }

    public View G(int i) {
        if (m43x13e585ba(this) == null) {
            this.C = new HashMap();
        }
        View view = (View) khoeKettlaaaaaKnPPanaBkoa.m140x9427f7b7(m43x13e585ba(this), opPnkpaatkaatonataKpceo.m237xc7830856(i));
        if (view != null) {
            return view;
        }
        View m31x1f959fc2 = m31x1f959fc2(this, i);
        occatKolokBtoapaKaPhp.m185x24819536(m43x13e585ba(this), opPnkpaatkaatonataKpceo.m237xc7830856(i), m31x1f959fc2);
        return m31x1f959fc2;
    }

    public final void H(PageNode pageNode) {
        m60x30310ea9(pageNode, m27x81b8dc41(m6xfaf58400(), 1752342 ^ m12xee631403(ccooopahacBnhcacooKa.m98xa4c7865a()), 1754561 ^ m12xee631403(ccooopahacBnhcacooKa.m104x83f1b7a9()), 1752198 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m149x73a254f5())));
        m11x880d0b51(new com.dna.tools.f(this), pageNode);
    }

    public void createFragment() {
        SharedPreferences m85xeb30f7b = ccooopahacBnhcacooKa.m85xeb30f7b(this, m26x3d83010(m6xfaf58400(), 1750675 ^ m12xee631403(ccooopahacBnhcacooKa.m115x7fe0c0cb()), 1747732 ^ m12xee631403(ccooopahacBnhcacooKa.m112xdacc1d78()), 1752174 ^ m12xee631403(ccooopahacBnhcacooKa.m90x2b5d0a4e())), 0);
        if (khoeKettlaaaaaKnPPanaBkoa.m151xa977417c(m85xeb30f7b, m26x3d83010(m6xfaf58400(), 56442 ^ m12xee631403(occatKolokBtoapaKaPhp.m216xc8cdc823()), 1747785 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m130x9774fae7()), 1751645 ^ m12xee631403(ccooopahacBnhcacooKa.m116x5dba15a4())), true)) {
            ccooopahacBnhcacooKa.m73xdb74fd44(opPnkpaatkaatonataKpceo.m260xd40377fe(this, occatKolokBtoapaKaPhp.m207x4c5c81c3(ccooopahacBnhcacooKa.m77x6635157(m56x889e8dee(m6xfaf58400(), 1746801 ^ m12xee631403(ccooopahacBnhcacooKa.m95x2c4f82b2()), 1750548 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m156x5e3438dc()), 1746153 ^ m12xee631403(ccooopahacBnhcacooKa.m78x7b4ce09e()))), ccooopahacBnhcacooKa.m77x6635157(m27x81b8dc41(m6xfaf58400(), 56076 ^ m12xee631403(ccooopahacBnhcacooKa.m80x1ae6eb1f()), 1746793 ^ m12xee631403(occatKolokBtoapaKaPhp.m187x1c2e9a17()), 55363 ^ m12xee631403(occatKolokBtoapaKaPhp.m186x5d4cb423())))), 0));
            opPnkpaatkaatonataKpceo.m235xf8ddfac7(khoeKettlaaaaaKnPPanaBkoa.m160xc8f60310(khoeKettlaaaaaKnPPanaBkoa.m143xaa48b9f6(m85xeb30f7b), m47x474ecb7c(m6xfaf58400(), 1748936 ^ m12xee631403(ccooopahacBnhcacooKa.m72x7cbd9a7b()), 1754369 ^ m12xee631403(occatKolokBtoapaKaPhp.m223xa914de8f()), 1746518 ^ m12xee631403(occatKolokBtoapaKaPhp.m190x541de28c())), false));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
    
        if (r1 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        m44xe93c77b3(r1, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007f, code lost:
    
        if (r1 != null) goto L14;
     */
    @Override // androidx.fragment.app.d, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onActivityResult(int r55, int r56, android.content.Intent r57) {
        /*
            r54 = this;
            r6 = r57
            r5 = r56
            r4 = r55
            r3 = r54
            int r0 = m65x96994b02(r3)
            r1 = -1
            r2 = 0
            if (r4 != r0) goto L39
            if (r6 == 0) goto L1a
            if (r5 == r1) goto L15
            goto L1a
        L15:
            android.net.Uri r0 = com.dna.tools.opPnkpaatkaatonataKpceo.m246xe520f0bf(r6)
            goto L1b
        L1a:
            r0 = r2
        L1b:
            d.c.b.p.r$b r1 = m24xda7b03d7(r3)
            if (r1 == 0) goto L36
            if (r0 == 0) goto L31
            java.lang.String r0 = m16xaa48b9f6(r3, r0)
            d.c.b.p.r$b r1 = m24xda7b03d7(r3)
            if (r1 == 0) goto L36
        L2d:
            m44xe93c77b3(r1, r0)
            goto L36
        L31:
            if (r1 == 0) goto L36
            m44xe93c77b3(r1, r2)
        L36:
            r3.z = r2
            goto L82
        L39:
            int r0 = m9x1273c6e5(r3)
            if (r4 != r0) goto L82
            if (r6 == 0) goto L7a
            if (r5 == r1) goto L44
            goto L7a
        L44:
            short[] r12 = m6xfaf58400()
            r15 = 1745630(0x1aa2de, float:2.446149E-39)
            java.lang.String r11 = com.dna.tools.opPnkpaatkaatonataKpceo.m225x584d0c86()
            int r11 = m12xee631403(r11)
            r15 = r15 ^ r11
            r13 = 1747913(0x1aabc9, float:2.449348E-39)
            java.lang.String r11 = com.dna.tools.opPnkpaatkaatonataKpceo.m241x88e2f341()
            int r11 = m12xee631403(r11)
            r13 = r13 ^ r11
            r14 = 1754445(0x1ac54d, float:2.458501E-39)
            java.lang.String r11 = com.dna.tools.opPnkpaatkaatonataKpceo.m238xc70a431a()
            int r11 = m12xee631403(r11)
            r14 = r14 ^ r11
            java.lang.String r12 = m56x889e8dee(r12, r13, r14, r15)
            r0 = r12
            java.lang.String r0 = com.dna.tools.khoeKettlaaaaaKnPPanaBkoa.m141xeb8d073e(r6, r0)
            goto L7b
        L7a:
            r0 = r2
        L7b:
            d.c.b.p.r$b r1 = m24xda7b03d7(r3)
            if (r1 == 0) goto L36
            goto L2d
        L82:
            super.onActivityResult(r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dna.tools.MainActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m41x7c4716e3(m23xa0e0a96b(), this);
        m46xe122ec89(this, (((2131854159 ^ 6611) ^ 2715) ^ 9017) ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m153x427718ab()));
        View m31x1f959fc2 = m31x1f959fc2(this, (2131939353 ^ 6122) ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m171xede73c52()));
        if (m31x1f959fc2 == null) {
            throw new NullPointerException(m26x3d83010(m6xfaf58400(), 1753099 ^ m12xee631403(occatKolokBtoapaKaPhp.m180xaa19e1aa()), 1750564 ^ m12xee631403(opPnkpaatkaatonataKpceo.m240xed7e8b7f()), 1756110 ^ m12xee631403(opPnkpaatkaatonataKpceo.m264x10605721())));
        }
        m45x14b21624(this, (Toolbar) m31x1f959fc2);
        ccooopahacBnhcacooKa.m106xdb5fa172(this, R.string.app_name);
        this.y = new com.dna.tools.e();
        ccooopahacBnhcacooKa.m97x9dce99e8((TabHost) ccooopahacBnhcacooKa.m75xd30d12b(this, m19x588cebaf()));
        TabHost tabHost = (TabHost) ccooopahacBnhcacooKa.m75xd30d12b(this, m19x588cebaf());
        m58xaa9f4961(tabHost, m47x474ecb7c(m6xfaf58400(), 2030 ^ m12xee631403(ccooopahacBnhcacooKa.m119x912decf3()), 1748749 ^ m12xee631403(occatKolokBtoapaKaPhp.m177x47ca737e()), 1746196 ^ m12xee631403(occatKolokBtoapaKaPhp.m189x9403d0d8())));
        com.dna.tools.ui.c cVar = new com.dna.tools.ui.c(tabHost, this);
        if (m3x958516f3(m17xf27d292c()) && m37x83f1b7a9(m35xd96af4d0(this))) {
            String m181xa54dcf47 = occatKolokBtoapaKaPhp.m181xa54dcf47(this, (2132124222 ^ 4300) ^ m12xee631403(occatKolokBtoapaKaPhp.m205xf8f6e5ba()));
            m58xaa9f4961(m181xa54dcf47, m56x889e8dee(m6xfaf58400(), 1747967 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m162x8b041963()), 1750713 ^ m12xee631403(ccooopahacBnhcacooKa.m82x53e9a1ae()), 1746635 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m167xe4fe62a4())));
            Drawable m102xa33841d5 = ccooopahacBnhcacooKa.m102xa33841d5(this, (2132649198 ^ 3857) ^ m12xee631403(occatKolokBtoapaKaPhp.m213x5a6c592e()));
            m2xd4b3858f(m102xa33841d5);
            m66x42ce2c(cVar, m181xa54dcf47, m102xa33841d5, R.id.main_tabhost_cpu);
        } else {
            FrameLayout frameLayout = (FrameLayout) ccooopahacBnhcacooKa.m75xd30d12b(this, m50x87b75ccb());
            m58xaa9f4961(frameLayout, m47x474ecb7c(m6xfaf58400(), 1750803 ^ m12xee631403(occatKolokBtoapaKaPhp.m183x3ba53e79()), 1753649 ^ m12xee631403(ccooopahacBnhcacooKa.m84x39e1fa87()), 1751845 ^ m12xee631403(opPnkpaatkaatonataKpceo.m256xc40443f6())));
            occatKolokBtoapaKaPhp.m182x4bbe752f(frameLayout, 8);
        }
        opPnkpaatkaatonataKpceo.m234xa274c675((TabHost) ccooopahacBnhcacooKa.m75xd30d12b(this, m19x588cebaf()), new b(cVar));
        com.omarea.common.ui.h m10x4aee29eb = m10x4aee29eb(this);
        String m181xa54dcf472 = occatKolokBtoapaKaPhp.m181xa54dcf47(this, (2132127810 ^ 2630) ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m142x353f0a3d()));
        m58xaa9f4961(m181xa54dcf472, m26x3d83010(m6xfaf58400(), 1749603 ^ m12xee631403(opPnkpaatkaatonataKpceo.m255x9dff48cb()), 1747670 ^ m12xee631403(opPnkpaatkaatonataKpceo.m251xf78680f5()), 55517 ^ m12xee631403(ccooopahacBnhcacooKa.m96x586fa222())));
        m36x3b5e92ff(m10x4aee29eb, m181xa54dcf472);
        opPnkpaatkaatonataKpceo.m226xc3750731(new Thread(new c(cVar)));
        if (m3x958516f3(m17xf27d292c()) && m37x83f1b7a9(m35xd96af4d0(this))) {
            com.dna.tools.d dVar = new com.dna.tools.d();
            androidx.fragment.app.i m4x7e64ae96 = m4x7e64ae96(this);
            m58xaa9f4961(m4x7e64ae96, m47x474ecb7c(m6xfaf58400(), 1754122 ^ m12xee631403(ccooopahacBnhcacooKa.m107xf926ae7b()), 1750608 ^ m12xee631403(ccooopahacBnhcacooKa.m81x7b020769()), 1749151 ^ m12xee631403(occatKolokBtoapaKaPhp.m210x4f22c6cb())));
            n m40x4c1febbb = m40x4c1febbb(m4x7e64ae96);
            m58xaa9f4961(m40x4c1febbb, m27x81b8dc41(m6xfaf58400(), 1750631 ^ m12xee631403(occatKolokBtoapaKaPhp.m224x304e4bdb()), 1748644 ^ m12xee631403(ccooopahacBnhcacooKa.m89x2b1c9ee1()), 1749446 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m138xbc823728())));
            m22x2ca01c66(m40x4c1febbb, R.id.main_tabhost_cpu, dVar);
            m18xdd64949d(m40x4c1febbb);
        }
        String m26x3d83010 = m26x3d83010(m6xfaf58400(), 1751161 ^ m12xee631403(occatKolokBtoapaKaPhp.m212x398e30ce()), 1755617 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m139xd2f1c44d()), 53474 ^ m12xee631403(ccooopahacBnhcacooKa.m118x55c5aa88()));
        boolean m62x16aa0d6e = m62x16aa0d6e(this, m26x3d83010);
        String m26x3d830102 = m26x3d83010(m6xfaf58400(), 1747751 ^ m12xee631403(ccooopahacBnhcacooKa.m94x27540124()), 1747724 ^ m12xee631403(opPnkpaatkaatonataKpceo.m261x44578bc()), 1753227 ^ m12xee631403(opPnkpaatkaatonataKpceo.m263xeb550369()));
        if (!m62x16aa0d6e || !m62x16aa0d6e(this, m26x3d830102)) {
            m48x42dc6ec5(this, new String[]{m26x3d83010, m26x3d830102}, 111);
        }
        occatKolokBtoapaKaPhp.m219x726110bf(this);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        m60x30310ea9(menu, m56x889e8dee(m6xfaf58400(), 1747500 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m147x4865af7d()), 1751719 ^ m12xee631403(occatKolokBtoapaKaPhp.m175x24fb36c8()), 1746973 ^ m12xee631403(ccooopahacBnhcacooKa.m71x88d91bd0())));
        occatKolokBtoapaKaPhp.m209xe8dcf922(m61x2d102dd4(this), R.menu.main, menu);
        MenuItem m206xc7379684 = occatKolokBtoapaKaPhp.m206xc7379684(menu, R.id.action_graph);
        m58xaa9f4961(m206xc7379684, m27x81b8dc41(m6xfaf58400(), 1746338 ^ m12xee631403(ccooopahacBnhcacooKa.m79x8ffe749()), 1750631 ^ m12xee631403(ccooopahacBnhcacooKa.m100x21b2b634()), 1749771 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m161x6b5abdc5())));
        FrameLayout frameLayout = (FrameLayout) ccooopahacBnhcacooKa.m75xd30d12b(this, m50x87b75ccb());
        m58xaa9f4961(frameLayout, m27x81b8dc41(m6xfaf58400(), 1751066 ^ m12xee631403(opPnkpaatkaatonataKpceo.m248x14233c5()), 56433 ^ m12xee631403(ccooopahacBnhcacooKa.m114x2e9347c5()), 1756843 ^ m12xee631403(opPnkpaatkaatonataKpceo.m238xc70a431a())));
        opPnkpaatkaatonataKpceo.m257xc8f60310(m206xc7379684, khoeKettlaaaaaKnPPanaBkoa.m146x5e09731a(frameLayout) == 0);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        d.c.d.a aVar;
        m60x30310ea9(menuItem, m47x474ecb7c(m6xfaf58400(), 1746322 ^ m12xee631403(opPnkpaatkaatonataKpceo.m259xb9499283()), 1754446 ^ m12xee631403(opPnkpaatkaatonataKpceo.m242xf70c41e8()), 1748810 ^ m12xee631403(occatKolokBtoapaKaPhp.m197x20ce8e83())));
        switch (ccooopahacBnhcacooKa.m108xcf3c1ec7(menuItem)) {
            case R.id.action_graph /* 2131230786 */:
                if (!m39x1d2e9eb4(m7x84b00e5d(m33x18e336d()), khoeKettlaaaaaKnPPanaBkoa.m152xe2b5d6f2())) {
                    if (khoeKettlaaaaaKnPPanaBkoa.m136xdf1b17fc() < 23) {
                        aVar = new d.c.d.a(this);
                    } else if (!ccooopahacBnhcacooKa.m113x2757465c(this)) {
                        Intent intent = new Intent();
                        occatKolokBtoapaKaPhp.m215xc8f60310(intent, 268435456);
                        occatKolokBtoapaKaPhp.m204x58fc39e6(intent, m47x474ecb7c(m6xfaf58400(), 1751107 ^ m12xee631403(occatKolokBtoapaKaPhp.m191x742a7d28()), 1746770 ^ m12xee631403(occatKolokBtoapaKaPhp.m193xb348abe2()), 1756395 ^ m12xee631403(opPnkpaatkaatonataKpceo.m230xc075cdf1())));
                        ccooopahacBnhcacooKa.m110x791faa4a(intent, occatKolokBtoapaKaPhp.m199x72e6861a(m26x3d83010(m6xfaf58400(), 1747045 ^ m12xee631403(occatKolokBtoapaKaPhp.m208x18e336d()), 1748827 ^ m12xee631403(opPnkpaatkaatonataKpceo.m228x464a6bcc()), 1751539 ^ m12xee631403(occatKolokBtoapaKaPhp.m178xe2bf49c8())), opPnkpaatkaatonataKpceo.m253xac18318e(this), null));
                        ccooopahacBnhcacooKa.m73xdb74fd44(opPnkpaatkaatonataKpceo.m260xd40377fe(khoeKettlaaaaaKnPPanaBkoa.m154x6e784d3f(this), occatKolokBtoapaKaPhp.m181xa54dcf47(this, ((2131695199 ^ 8028) ^ m12xee631403(ccooopahacBnhcacooKa.m91xbab36677())) ^ m12xee631403(opPnkpaatkaatonataKpceo.m232xdfe07fff())), 1));
                        try {
                            opPnkpaatkaatonataKpceo.m227x516e065b(this, intent);
                            break;
                        } catch (Exception unused) {
                            break;
                        }
                    } else {
                        aVar = new d.c.d.a(this);
                    }
                    m30x463864b8(aVar);
                    ccooopahacBnhcacooKa.m73xdb74fd44(opPnkpaatkaatonataKpceo.m260xd40377fe(this, occatKolokBtoapaKaPhp.m181xa54dcf47(this, R.string.float_monitor_tips), 1));
                    break;
                } else {
                    m64x482584fe(new d.c.d.a(this));
                    return false;
                }
            case R.id.option_menu_info /* 2131231084 */:
                View m174x92516b2f = occatKolokBtoapaKaPhp.m174x92516b2f(khoeKettlaaaaaKnPPanaBkoa.m124x9871aee8(this), R.layout.dialog_about, null);
                CompoundButton compoundButton = (CompoundButton) ccooopahacBnhcacooKa.m109xbc58385a(m174x92516b2f, (2131927184 ^ 5101) ^ m12xee631403(occatKolokBtoapaKaPhp.m176x6635157()));
                i iVar = new i(this);
                khoeKettlaaaaaKnPPanaBkoa.m159xefc6eab8(compoundButton, new d(iVar));
                m58xaa9f4961(compoundButton, m26x3d83010(m6xfaf58400(), 1747407 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m155x554da7bd()), 1752750 ^ m12xee631403(khoeKettlaaaaaKnPPanaBkoa.m131x8935fd34()), 1749525 ^ m12xee631403(opPnkpaatkaatonataKpceo.m244xa0e0a96b())));
                occatKolokBtoapaKaPhp.m211xa5f1b6f0(compoundButton, m14xbdb9ba94(iVar));
                e.a m5xa9480f = m5xa9480f();
                m58xaa9f4961(m174x92516b2f, m26x3d83010(m6xfaf58400(), 1750236 ^ m12xee631403(occatKolokBtoapaKaPhp.m192xb85bffe2()), 1752739 ^ m12xee631403(ccooopahacBnhcacooKa.m87xfaeee14()), 1749230 ^ m12xee631403(ccooopahacBnhcacooKa.m70xed017057())));
                m28xe854eb50(m5xa9480f, this, m174x92516b2f, false, 4, null);
                break;
            case R.id.option_menu_reboot /* 2131231085 */:
                m52x22f8dbac(new com.dna.tools.c(this));
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
