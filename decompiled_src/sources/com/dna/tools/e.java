package com.dna.tools;

import android.content.Context;
import com.omarea.krscript.model.PageNode;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;

/* loaded from: classes.dex */
public class e {
    private static HashMap<String, String> a;

    private String c() {
        HashMap<String, String> hashMap = a;
        return (hashMap == null || !hashMap.containsKey("executor_core")) ? "file:///android_asset/kr-script/executor.sh" : a.get("executor_core");
    }

    private String f() {
        HashMap<String, String> hashMap = a;
        return (hashMap == null || !hashMap.containsKey("toolkit_dir")) ? "file:///android_asset/kr-script/toolkit" : a.get("toolkit_dir");
    }

    public boolean a() {
        HashMap<String, String> hashMap = a;
        if (hashMap == null || !hashMap.containsKey("allow_home_page")) {
            return true;
        }
        String str = a.get("allow_home_page");
        return str != null && str.equals("1");
    }

    public String b() {
        HashMap<String, String> hashMap = a;
        return (hashMap == null || !hashMap.containsKey("before_start_sh")) ? "" : a.get("before_start_sh");
    }

    public PageNode d() {
        if (a == null) {
            return null;
        }
        PageNode pageNode = new PageNode("");
        if (a.containsKey("favorite_config_sh")) {
            pageNode.setPageConfigSh(a.get("favorite_config_sh"));
        }
        if (a.containsKey("favorite_config")) {
            pageNode.setPageConfigPath(a.get("favorite_config"));
        }
        return pageNode;
    }

    public PageNode e() {
        if (a == null) {
            return null;
        }
        PageNode pageNode = new PageNode("");
        if (a.containsKey("page_list_config_sh")) {
            pageNode.setPageConfigSh(a.get("page_list_config_sh"));
        }
        if (a.containsKey("page_list_config")) {
            pageNode.setPageConfigPath(a.get("page_list_config"));
        }
        return pageNode;
    }

    public HashMap<String, String> g() {
        return a;
    }

    public e h(Context context) {
        if (a == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            a = hashMap;
            hashMap.put("executor_core", "file:///android_asset/kr-script/executor.sh");
            a.put("page_list_config", "file:///android_asset/kr-script/pages/more.xml");
            a.put("favorite_config", "file:///android_asset/kr-script/pages/favorites.xml");
            a.put("allow_home_page", "0");
            a.put("toolkit_dir", "file:///android_asset/kr-script/toolkit");
            a.put("before_start_sh", "");
            try {
                String string = context.getString(R.string.kr_script_config);
                if (string.startsWith("file:///android_asset/")) {
                    string = string.substring(22);
                }
                InputStream open = context.getAssets().open(string);
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                for (String str : new String(bArr, Charset.defaultCharset()).split("\n")) {
                    String trim = str.trim();
                    if (!trim.startsWith("#") && trim.contains("=")) {
                        int indexOf = trim.indexOf("=");
                        String trim2 = trim.substring(0, indexOf).trim();
                        String trim3 = trim.substring(indexOf + 2, trim.length() - 1).trim();
                        a.remove(trim2);
                        a.put(trim2, trim3);
                    }
                }
            } catch (Exception unused) {
            }
            d.c.b.n.b.k(context, c(), f());
        }
        return this;
    }
}
