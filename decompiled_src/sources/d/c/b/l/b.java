package d.c.b.l;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.util.Log;
import android.util.Xml;
import android.widget.Toast;
import com.omarea.krscript.model.ActionNode;
import com.omarea.krscript.model.ActionParamInfo;
import com.omarea.krscript.model.GroupNode;
import com.omarea.krscript.model.NodeInfoBase;
import com.omarea.krscript.model.PageNode;
import com.omarea.krscript.model.PickerNode;
import com.omarea.krscript.model.SwitchNode;
import com.omarea.krscript.model.TextNode;
import e.p.d.i;
import e.u.v;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public final class b {
    private Context a;

    /* renamed from: b, reason: collision with root package name */
    private String f1406b;

    /* renamed from: c, reason: collision with root package name */
    private String f1407c;

    /* renamed from: d, reason: collision with root package name */
    private InputStream f1408d;

    /* renamed from: e, reason: collision with root package name */
    private String f1409e;
    private ArrayList<ActionParamInfo> f;
    private ActionParamInfo g;
    private NodeInfoBase h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        final /* synthetic */ Exception f;

        a(Exception exc) {
            this.f = exc;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(b.this.a, "Failed to parse configuration files" + this.f.getMessage(), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d.c.b.l.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class RunnableC0104b implements Runnable {
        final /* synthetic */ Exception f;

        RunnableC0104b(Exception exc) {
            this.f = exc;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(b.this.a, "Failed to parse configuration files" + this.f.getMessage(), 1).show();
        }
    }

    public b(Context context, InputStream inputStream) {
        i.d(context, "context");
        i.d(inputStream, "pageConfigStream");
        this.f1406b = "";
        this.f1407c = "";
        this.f1409e = "";
        this.a = context;
        this.f1408d = inputStream;
    }

    public b(Context context, String str, String str2) {
        i.d(context, "context");
        i.d(str, "pageConfig");
        this.f1406b = "";
        this.f1407c = "";
        this.f1409e = "";
        this.a = context;
        this.f1406b = str;
        this.f1409e = str2 == null ? "" : str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x0163, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x002c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0061 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0113 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.omarea.krscript.model.ClickableNode b(com.omarea.krscript.model.ClickableNode r14, org.xmlpull.v1.XmlPullParser r15) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.b.l.b.b(com.omarea.krscript.model.ClickableNode, org.xmlpull.v1.XmlPullParser):com.omarea.krscript.model.ClickableNode");
    }

    private final void c(NodeInfoBase nodeInfoBase, XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if (i.a(attributeName, "su") || i.a(attributeName, "sh") || i.a(attributeName, "desc-sh")) {
                String attributeValue = xmlPullParser.getAttributeValue(i);
                i.c(attributeValue, "parser.getAttributeValue(i)");
                nodeInfoBase.setDescSh(attributeValue);
                nodeInfoBase.setDesc(d(this.a, nodeInfoBase.getDescSh()));
            }
        }
        if (nodeInfoBase.getDesc().length() == 0) {
            String nextText = xmlPullParser.nextText();
            i.c(nextText, "parser.nextText()");
            nodeInfoBase.setDesc(nextText);
        }
    }

    private final String d(Context context, String str) {
        if (this.h == null) {
            this.h = new NodeInfoBase(this.f1407c);
        }
        String b2 = d.c.b.n.b.b(context, str, this.h);
        i.c(b2, "ScriptEnvironmen.execute…scriptIn, vitualRootNode)");
        return b2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0089, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0020. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.omarea.krscript.model.GroupNode e(org.xmlpull.v1.XmlPullParser r8) {
        /*
            r7 = this;
            com.omarea.krscript.model.GroupNode r0 = new com.omarea.krscript.model.GroupNode
            java.lang.String r1 = r7.f1407c
            r0.<init>(r1)
            int r1 = r8.getAttributeCount()
            r2 = 0
        Lc:
            if (r2 >= r1) goto L8c
            java.lang.String r3 = r8.getAttributeName(r2)
            java.lang.String r4 = r8.getAttributeValue(r2)
            if (r3 != 0) goto L1a
            goto L89
        L1a:
            int r5 = r3.hashCode()
            java.lang.String r6 = "attrValue"
            switch(r5) {
                case -1854767153: goto L6f;
                case 3355: goto L4e;
                case 106079: goto L45;
                case 100346066: goto L3c;
                case 110371416: goto L2d;
                case 466743410: goto L24;
                default: goto L23;
            }
        L23:
            goto L89
        L24:
            java.lang.String r5 = "visible"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L89
            goto L77
        L2d:
            java.lang.String r5 = "title"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L89
            e.p.d.i.c(r4, r6)
            r0.setTitle(r4)
            goto L89
        L3c:
            java.lang.String r5 = "index"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L89
            goto L56
        L45:
            java.lang.String r5 = "key"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L89
            goto L56
        L4e:
            java.lang.String r5 = "id"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L89
        L56:
            e.p.d.i.c(r4, r6)
            if (r4 == 0) goto L67
            java.lang.CharSequence r3 = e.u.l.R(r4)
            java.lang.String r3 = r3.toString()
            r0.setKey(r3)
            goto L89
        L67:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.CharSequence"
            r8.<init>(r0)
            throw r8
        L6f:
            java.lang.String r5 = "support"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L89
        L77:
            android.content.Context r3 = r7.a
            e.p.d.i.c(r4, r6)
            java.lang.String r3 = r7.d(r3, r4)
            java.lang.String r4 = "1"
            boolean r3 = e.p.d.i.a(r3, r4)
            r0.setSupported(r3)
        L89:
            int r2 = r2 + 1
            goto Lc
        L8c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.b.l.b.e(org.xmlpull.v1.XmlPullParser):com.omarea.krscript.model.GroupNode");
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e6, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.omarea.krscript.model.NodeInfoBase f(com.omarea.krscript.model.NodeInfoBase r8, org.xmlpull.v1.XmlPullParser r9) {
        /*
            r7 = this;
            int r0 = r9.getAttributeCount()
            r1 = 0
        L5:
            if (r1 >= r0) goto Lea
            java.lang.String r2 = r9.getAttributeValue(r1)
            java.lang.String r3 = r9.getAttributeName(r1)
            if (r3 != 0) goto L13
            goto Le6
        L13:
            int r4 = r3.hashCode()
            java.lang.String r5 = "parser.getAttributeValue(i)"
            java.lang.String r6 = "attrValue"
            switch(r4) {
                case -1857640538: goto Ld4;
                case -1854767153: goto Lb7;
                case -315611684: goto L9a;
                case 3355: goto L79;
                case 106079: goto L70;
                case 3079825: goto L60;
                case 100346066: goto L57;
                case 110371416: goto L47;
                case 466743410: goto L3d;
                case 1556800273: goto L20;
                default: goto L1e;
            }
        L1e:
            goto Le6
        L20:
            java.lang.String r2 = "desc-sh"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto Le6
            java.lang.String r2 = r9.getAttributeValue(r1)
            e.p.d.i.c(r2, r5)
            r8.setDescSh(r2)
            android.content.Context r2 = r7.a
            java.lang.String r3 = r8.getDescSh()
            java.lang.String r2 = r7.d(r2, r3)
            goto L6b
        L3d:
            java.lang.String r4 = "visible"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto Le6
            goto Lbf
        L47:
            java.lang.String r4 = "title"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto Le6
            e.p.d.i.c(r2, r6)
            r8.setTitle(r2)
            goto Le6
        L57:
            java.lang.String r4 = "index"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto Le6
            goto L81
        L60:
            java.lang.String r4 = "desc"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto Le6
            e.p.d.i.c(r2, r6)
        L6b:
            r8.setDesc(r2)
            goto Le6
        L70:
            java.lang.String r4 = "key"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto Le6
            goto L81
        L79:
            java.lang.String r4 = "id"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto Le6
        L81:
            e.p.d.i.c(r2, r6)
            if (r2 == 0) goto L92
            java.lang.CharSequence r2 = e.u.l.R(r2)
            java.lang.String r2 = r2.toString()
            r8.setKey(r2)
            goto Le6
        L92:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.CharSequence"
            r8.<init>(r9)
            throw r8
        L9a:
            java.lang.String r2 = "summary-sh"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto Le6
            java.lang.String r2 = r9.getAttributeValue(r1)
            e.p.d.i.c(r2, r5)
            r8.setSummarySh(r2)
            android.content.Context r2 = r7.a
            java.lang.String r3 = r8.getSummarySh()
            java.lang.String r2 = r7.d(r2, r3)
            goto Le3
        Lb7:
            java.lang.String r4 = "support"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto Le6
        Lbf:
            android.content.Context r3 = r7.a
            e.p.d.i.c(r2, r6)
            java.lang.String r2 = r7.d(r3, r2)
            java.lang.String r3 = "1"
            boolean r2 = e.p.d.i.a(r2, r3)
            r2 = r2 ^ 1
            if (r2 == 0) goto Le6
            r8 = 0
            return r8
        Ld4:
            java.lang.String r2 = "summary"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto Le6
            java.lang.String r2 = r9.getAttributeValue(r1)
            e.p.d.i.c(r2, r5)
        Le3:
            r8.setSummary(r2)
        Le6:
            int r1 = r1 + 1
            goto L5
        Lea:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.b.l.b.f(com.omarea.krscript.model.NodeInfoBase, org.xmlpull.v1.XmlPullParser):com.omarea.krscript.model.NodeInfoBase");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0019. Please report as an issue. */
    private final PageNode g(PageNode pageNode, XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (attributeName != null) {
                switch (attributeName.hashCode()) {
                    case -1655966961:
                        if (!attributeName.equals("activity")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setActivity(attributeValue);
                        break;
                    case -1354792126:
                        if (attributeName.equals("config")) {
                            i.c(attributeValue, "attrValue");
                            pageNode.setPageConfigPath(attributeValue);
                            break;
                        } else {
                            break;
                        }
                    case -1317542303:
                        if (!attributeName.equals("load-error")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setLoadFail(attributeValue);
                        break;
                    case -1183762788:
                        if (!attributeName.equals("intent")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setActivity(attributeValue);
                        break;
                    case -1141277068:
                        if (!attributeName.equals("before-load")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setBeforeRead(attributeValue);
                        break;
                    case -1141107932:
                        if (!attributeName.equals("before-read")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setBeforeRead(attributeValue);
                        break;
                    case -907685685:
                        if (!attributeName.equals("script")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setPageHandlerSh(attributeValue);
                        break;
                    case -804498240:
                        if (attributeName.equals("config-sh")) {
                            i.c(attributeValue, "attrValue");
                            pageNode.setPageConfigSh(attributeValue);
                            break;
                        } else {
                            break;
                        }
                    case 97:
                        if (!attributeName.equals("a")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setActivity(attributeValue);
                        break;
                    case 113762:
                        if (!attributeName.equals("set")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setPageHandlerSh(attributeValue);
                        break;
                    case 3211051:
                        if (!attributeName.equals("href")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setLink(attributeValue);
                        break;
                    case 3213227:
                        if (attributeName.equals("html")) {
                            i.c(attributeValue, "attrValue");
                            pageNode.setOnlineHtmlPage(attributeValue);
                            break;
                        } else {
                            break;
                        }
                    case 3321850:
                        if (!attributeName.equals("link")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setLink(attributeValue);
                        break;
                    case 336592931:
                        if (!attributeName.equals("load-ok")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setLoadSuccess(attributeValue);
                        break;
                    case 469017116:
                        if (!attributeName.equals("load-success")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setLoadSuccess(attributeValue);
                        break;
                    case 692803402:
                        if (!attributeName.equals("handler")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setPageHandlerSh(attributeValue);
                        break;
                    case 1342985125:
                        if (!attributeName.equals("load-fail")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setLoadFail(attributeValue);
                        break;
                    case 1374438372:
                        if (!attributeName.equals("options-sh")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setPageMenuOptionsSh(attributeValue);
                        break;
                    case 1496001079:
                        if (!attributeName.equals("after-load")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setAfterRead(attributeValue);
                        break;
                    case 1496170215:
                        if (!attributeName.equals("after-read")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setAfterRead(attributeValue);
                        break;
                    case 1845386925:
                        if (!attributeName.equals("option-sh")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setPageMenuOptionsSh(attributeValue);
                        break;
                    case 1845386938:
                        if (!attributeName.equals("option-su")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setPageMenuOptionsSh(attributeValue);
                        break;
                    case 1988338616:
                        if (!attributeName.equals("handler-sh")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setPageHandlerSh(attributeValue);
                        break;
                    case 1995135739:
                        if (!attributeName.equals("getstate")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        pageNode.setPageHandlerSh(attributeValue);
                        break;
                }
            }
        }
        return pageNode;
    }

    private final void h(PickerNode pickerNode, XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (attributeName != null) {
                switch (attributeName.hashCode()) {
                    case 653829648:
                        if (!attributeName.equals("multiple")) {
                            break;
                        } else {
                            pickerNode.setMultiple(i.a(attributeValue, "multiple") || i.a(attributeValue, "true") || i.a(attributeValue, "1"));
                            continue;
                        }
                    case 1374438372:
                        if (!attributeName.equals("options-sh")) {
                            break;
                        }
                        break;
                    case 1374438385:
                        if (!attributeName.equals("options-su")) {
                            break;
                        }
                        break;
                    case 1732829925:
                        if (attributeName.equals("separator")) {
                            i.c(attributeValue, "attrValue");
                            pickerNode.setSeparator(attributeValue);
                            break;
                        } else {
                            continue;
                        }
                    case 1845386925:
                        if (!attributeName.equals("option-sh")) {
                            break;
                        }
                        break;
                }
                if (pickerNode.getOptions() == null) {
                    pickerNode.setOptions(new ArrayList<>());
                }
                i.c(attributeValue, "attrValue");
                pickerNode.setOptionsSh(attributeValue);
            }
        }
    }

    private final ArrayList<NodeInfoBase> j(InputStream inputStream) {
        TextNode textNode;
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(inputStream, "utf-8");
            i.c(newPullParser, "parser");
            int eventType = newPullParser.getEventType();
            ArrayList<NodeInfoBase> arrayList = new ArrayList<>();
            GroupNode groupNode = null;
            boolean z = true;
            PageNode pageNode = null;
            ActionNode actionNode = null;
            SwitchNode switchNode = null;
            PickerNode pickerNode = null;
            TextNode textNode2 = null;
            for (int i = 1; eventType != i; i = 1) {
                boolean z2 = z;
                TextNode textNode3 = textNode2;
                if (eventType == 2) {
                    if (i.a("group", newPullParser.getName())) {
                        if (groupNode != null && groupNode.getSupported()) {
                            arrayList.add(groupNode);
                        }
                        groupNode = e(newPullParser);
                    } else if (groupNode == null || groupNode.getSupported()) {
                        if (i.a("page", newPullParser.getName())) {
                            if (!z2) {
                                PageNode pageNode2 = (PageNode) b(new PageNode(this.f1407c), newPullParser);
                                if (pageNode2 != null) {
                                    g(pageNode2, newPullParser);
                                }
                                pageNode = pageNode2;
                            }
                        } else if (i.a("action", newPullParser.getName())) {
                            actionNode = (ActionNode) m(new ActionNode(this.f1407c), newPullParser);
                        } else if (i.a("switch", newPullParser.getName())) {
                            switchNode = (SwitchNode) m(new SwitchNode(this.f1407c), newPullParser);
                        } else if (i.a("picker", newPullParser.getName())) {
                            PickerNode pickerNode2 = (PickerNode) m(new PickerNode(this.f1407c), newPullParser);
                            if (pickerNode2 != null) {
                                h(pickerNode2, newPullParser);
                            }
                            pickerNode = pickerNode2;
                        } else if (i.a("text", newPullParser.getName())) {
                            textNode2 = (TextNode) f(new TextNode(this.f1407c), newPullParser);
                            z = false;
                        } else if (pageNode != null) {
                            u(pageNode, newPullParser);
                        } else if (actionNode != null) {
                            t(actionNode, newPullParser);
                        } else if (switchNode != null) {
                            w(switchNode, newPullParser);
                        } else if (pickerNode != null) {
                            v(pickerNode, newPullParser);
                        } else if (textNode3 != null) {
                            x(textNode3, newPullParser);
                        } else if (i.a("resource", newPullParser.getName())) {
                            k(newPullParser);
                        }
                    }
                    textNode2 = textNode3;
                    z = false;
                } else if (eventType != 3) {
                    z = z2;
                    textNode2 = textNode3;
                } else if (i.a("group", newPullParser.getName())) {
                    if (groupNode != null && groupNode.getSupported()) {
                        arrayList.add(groupNode);
                    }
                    z = z2;
                    textNode2 = textNode3;
                    groupNode = null;
                } else {
                    if (groupNode == null) {
                        textNode = textNode3;
                        if (i.a("page", newPullParser.getName())) {
                            p(pageNode, newPullParser);
                            if (pageNode != null) {
                                arrayList.add(pageNode);
                            }
                            textNode2 = textNode;
                            pageNode = null;
                        } else if (i.a("action", newPullParser.getName())) {
                            o(actionNode, newPullParser);
                            if (actionNode != null) {
                                arrayList.add(actionNode);
                            }
                            textNode2 = textNode;
                            actionNode = null;
                        } else if (i.a("switch", newPullParser.getName())) {
                            r(switchNode, newPullParser);
                            if (switchNode != null) {
                                arrayList.add(switchNode);
                            }
                            textNode2 = textNode;
                            switchNode = null;
                        } else if (i.a("picker", newPullParser.getName())) {
                            q(pickerNode, newPullParser);
                            if (pickerNode != null) {
                                arrayList.add(pickerNode);
                            }
                            textNode2 = textNode;
                            pickerNode = null;
                        } else {
                            if (i.a("text", newPullParser.getName())) {
                                s(textNode, newPullParser);
                                if (textNode != null) {
                                    arrayList.add(textNode);
                                }
                                textNode2 = null;
                            }
                            textNode2 = textNode;
                        }
                    } else if (i.a("page", newPullParser.getName())) {
                        p(pageNode, newPullParser);
                        if (pageNode != null) {
                            groupNode.getChildren().add(pageNode);
                        }
                        z = z2;
                        textNode2 = textNode3;
                        pageNode = null;
                    } else if (i.a("action", newPullParser.getName())) {
                        o(actionNode, newPullParser);
                        if (actionNode != null) {
                            groupNode.getChildren().add(actionNode);
                        }
                        z = z2;
                        textNode2 = textNode3;
                        actionNode = null;
                    } else if (i.a("switch", newPullParser.getName())) {
                        r(switchNode, newPullParser);
                        if (switchNode != null) {
                            groupNode.getChildren().add(switchNode);
                        }
                        z = z2;
                        textNode2 = textNode3;
                        switchNode = null;
                    } else if (i.a("picker", newPullParser.getName())) {
                        q(pickerNode, newPullParser);
                        if (pickerNode != null) {
                            groupNode.getChildren().add(pickerNode);
                        }
                        z = z2;
                        textNode2 = textNode3;
                        pickerNode = null;
                    } else if (i.a("text", newPullParser.getName())) {
                        s(textNode3, newPullParser);
                        if (textNode3 != null) {
                            groupNode.getChildren().add(textNode3);
                        }
                        textNode2 = null;
                    } else {
                        textNode = textNode3;
                        textNode2 = textNode;
                    }
                    z = z2;
                }
                eventType = newPullParser.next();
            }
            return arrayList;
        } catch (Exception e2) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0104b(e2));
            Log.e("KrConfig Fail！", "" + e2.getMessage());
            return null;
        }
    }

    private final void k(XmlPullParser xmlPullParser) {
        CharSequence R;
        CharSequence R2;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (i.a(xmlPullParser.getAttributeName(i), "file")) {
                String attributeValue = xmlPullParser.getAttributeValue(i);
                i.c(attributeValue, "parser.getAttributeValue(i)");
                if (attributeValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                R2 = v.R(attributeValue);
                new d.c.b.n.a(this.a).a(R2.toString());
            } else if (i.a(xmlPullParser.getAttributeName(i), "dir")) {
                String attributeValue2 = xmlPullParser.getAttributeValue(i);
                i.c(attributeValue2, "parser.getAttributeValue(i)");
                if (attributeValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                R = v.R(attributeValue2);
                new d.c.b.n.a(this.a).b(R.toString());
            } else {
                continue;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x003a. Please report as an issue. */
    private final void l(TextNode textNode, XmlPullParser xmlPullParser) {
        Layout.Alignment alignment;
        TextNode.TextRow textRow = new TextNode.TextRow();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            i.c(attributeName, "parser.getAttributeName(i)");
            if (attributeName == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = attributeName.toLowerCase();
            i.c(lowerCase, "(this as java.lang.String).toLowerCase()");
            String attributeValue = xmlPullParser.getAttributeValue(i);
            try {
                boolean z = true;
                switch (lowerCase.hashCode()) {
                    case -1655966961:
                        if (!lowerCase.equals("activity")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        textRow.setActivity$krscript_release_mini(attributeValue);
                        break;
                    case -1332194002:
                        if (!lowerCase.equals("background")) {
                            break;
                        }
                        textRow.setBgColor$krscript_release_mini(Color.parseColor(attributeValue));
                        break;
                    case -1183762788:
                        if (lowerCase.equals("intent")) {
                            i.c(attributeValue, "attrValue");
                            textRow.setActivity$krscript_release_mini(attributeValue);
                            break;
                        } else {
                            break;
                        }
                    case -1178781136:
                        if (!lowerCase.equals("italic")) {
                            break;
                        }
                        if (!i.a(attributeValue, "1") && !i.a(attributeValue, "true") && !i.a(attributeValue, "italic")) {
                            z = false;
                        }
                        textRow.setItalic$krscript_release_mini(z);
                        break;
                    case -1026963764:
                        if (!lowerCase.equals("underline")) {
                            break;
                        }
                        if (!i.a(attributeValue, "1") && !i.a(attributeValue, "true") && !i.a(attributeValue, "underline")) {
                            z = false;
                        }
                        textRow.setUnderline$krscript_release_mini(z);
                        break;
                    case -907685685:
                        if (!lowerCase.equals("script")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        textRow.setOnClickScript$krscript_release_mini(attributeValue);
                        break;
                    case -175307202:
                        if (lowerCase.equals("bgcolor")) {
                            textRow.setBgColor$krscript_release_mini(Color.parseColor(attributeValue));
                            break;
                        } else {
                            break;
                        }
                    case 97:
                        if (lowerCase.equals("a")) {
                            i.c(attributeValue, "attrValue");
                            textRow.setActivity$krscript_release_mini(attributeValue);
                            break;
                        } else {
                            break;
                        }
                    case 98:
                        if (!lowerCase.equals("b")) {
                            break;
                        }
                        if (!i.a(attributeValue, "1") && !i.a(attributeValue, "true") && !i.a(attributeValue, "bold")) {
                            z = false;
                        }
                        textRow.setBold$krscript_release_mini(z);
                        break;
                    case 105:
                        if (lowerCase.equals("i")) {
                            if (!i.a(attributeValue, "1")) {
                                z = false;
                                break;
                            }
                            textRow.setItalic$krscript_release_mini(z);
                            break;
                        } else {
                            break;
                        }
                    case 117:
                        if (lowerCase.equals("u")) {
                            if (!i.a(attributeValue, "1")) {
                                z = false;
                                break;
                            }
                            textRow.setUnderline$krscript_release_mini(z);
                            break;
                        } else {
                            break;
                        }
                    case 3141:
                        if (lowerCase.equals("bg")) {
                            textRow.setBgColor$krscript_release_mini(Color.parseColor(attributeValue));
                            break;
                        } else {
                            break;
                        }
                    case 3669:
                        if (lowerCase.equals("sh")) {
                            i.c(attributeValue, "attrValue");
                            textRow.setDynamicTextSh$krscript_release_mini(attributeValue);
                            break;
                        } else {
                            break;
                        }
                    case 113291:
                        if (lowerCase.equals("run")) {
                            i.c(attributeValue, "attrValue");
                            textRow.setOnClickScript$krscript_release_mini(attributeValue);
                            break;
                        } else {
                            break;
                        }
                    case 3029637:
                        if (lowerCase.equals("bold")) {
                            if (!i.a(attributeValue, "1")) {
                                z = false;
                                break;
                            }
                            textRow.setBold$krscript_release_mini(z);
                            break;
                        } else {
                            break;
                        }
                    case 3211051:
                        if (!lowerCase.equals("href")) {
                            break;
                        }
                        i.c(attributeValue, "attrValue");
                        textRow.setLink$krscript_release_mini(attributeValue);
                        break;
                    case 3321850:
                        if (lowerCase.equals("link")) {
                            i.c(attributeValue, "attrValue");
                            textRow.setLink$krscript_release_mini(attributeValue);
                            break;
                        } else {
                            break;
                        }
                    case 3530753:
                        if (lowerCase.equals("size")) {
                            i.c(attributeValue, "attrValue");
                            textRow.setSize$krscript_release_mini(Integer.parseInt(attributeValue));
                            break;
                        } else {
                            break;
                        }
                    case 92903173:
                        if (lowerCase.equals("align") && attributeValue != null) {
                            switch (attributeValue.hashCode()) {
                                case -1364013995:
                                    if (attributeValue.equals("center")) {
                                        alignment = Layout.Alignment.ALIGN_CENTER;
                                        break;
                                    } else {
                                        break;
                                    }
                                case -1039745817:
                                    if (attributeValue.equals("normal")) {
                                        alignment = Layout.Alignment.ALIGN_NORMAL;
                                        break;
                                    } else {
                                        break;
                                    }
                                case 3317767:
                                    if (attributeValue.equals("left") && Build.VERSION.SDK_INT >= 28) {
                                        alignment = Layout.Alignment.ALIGN_LEFT;
                                        break;
                                    }
                                    break;
                                case 108511772:
                                    if (attributeValue.equals("right") && Build.VERSION.SDK_INT >= 28) {
                                        alignment = Layout.Alignment.ALIGN_RIGHT;
                                        break;
                                    }
                                    break;
                                default:
                                    continue;
                            }
                            textRow.setAlign$krscript_release_mini(alignment);
                            break;
                        }
                        break;
                    case 94001407:
                        if (lowerCase.equals("break")) {
                            if (!i.a(attributeValue, "1") && !i.a(attributeValue, "true") && !i.a(attributeValue, "break")) {
                                z = false;
                            }
                            textRow.setBreakRow$krscript_release_mini(z);
                            break;
                        } else {
                            break;
                        }
                        break;
                    case 94842723:
                        if (!lowerCase.equals("color")) {
                            break;
                        }
                        textRow.setColor$krscript_release_mini(Color.parseColor(attributeValue));
                        break;
                    case 1984457027:
                        if (lowerCase.equals("foreground")) {
                            textRow.setColor$krscript_release_mini(Color.parseColor(attributeValue));
                            break;
                        } else {
                            break;
                        }
                }
            } catch (Exception unused) {
            }
        }
        textRow.setText$krscript_release_mini("" + xmlPullParser.nextText());
        textNode.getRows().add(textRow);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x012f, code lost:
    
        if (r6.equals("bg-task") != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
    
        if (r6.equals("background-task") != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0082, code lost:
    
        if (r6.equals("warning") != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00fa, code lost:
    
        e.p.d.i.c(r5, "attrValue");
        r1.setWarning(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ac, code lost:
    
        if (r6.equals("interruptible") != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00b5, code lost:
    
        e.p.d.i.c(r5, "attrValue");
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00bc, code lost:
    
        if (r5.length() != 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00be, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c1, code lost:
    
        if (r0 != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c7, code lost:
    
        if (e.p.d.i.a(r5, "interruptable") != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00cd, code lost:
    
        if (e.p.d.i.a(r5, "interruptable") != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00d3, code lost:
    
        if (e.p.d.i.a(r5, "true") != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00d9, code lost:
    
        if (e.p.d.i.a(r5, "1") == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00dc, code lost:
    
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00dd, code lost:
    
        r1.setInterruptable(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00c0, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00b3, code lost:
    
        if (r6.equals("interruptable") != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00f8, code lost:
    
        if (r6.equals("warn") != false) goto L69;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0043. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01ea A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.omarea.krscript.model.RunnableNode m(com.omarea.krscript.model.RunnableNode r20, org.xmlpull.v1.XmlPullParser r21) {
        /*
            Method dump skipped, instructions count: 672
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.b.l.b.m(com.omarea.krscript.model.RunnableNode, org.xmlpull.v1.XmlPullParser):com.omarea.krscript.model.RunnableNode");
    }

    private final void n(NodeInfoBase nodeInfoBase, XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if (i.a(attributeName, "su") || i.a(attributeName, "sh") || i.a(attributeName, "summary-sh")) {
                String attributeValue = xmlPullParser.getAttributeValue(i);
                i.c(attributeValue, "parser.getAttributeValue(i)");
                nodeInfoBase.setSummarySh(attributeValue);
                nodeInfoBase.setSummary(d(this.a, nodeInfoBase.getSummarySh()));
            }
        }
        if (nodeInfoBase.getSummary().length() == 0) {
            String nextText = xmlPullParser.nextText();
            i.c(nextText, "parser.nextText()");
            nodeInfoBase.setSummary(nextText);
        }
    }

    private final void o(ActionNode actionNode, XmlPullParser xmlPullParser) {
        if (actionNode != null) {
            if (actionNode.getSetState() == null) {
                actionNode.setSetState("");
            }
            actionNode.setParams(this.f);
            this.f = null;
        }
    }

    private final void p(PageNode pageNode, XmlPullParser xmlPullParser) {
    }

    private final void q(PickerNode pickerNode, XmlPullParser xmlPullParser) {
        if (pickerNode != null) {
            if (pickerNode.getGetState() == null) {
                pickerNode.setGetState("");
            } else {
                pickerNode.setValue(d(this.a, "" + pickerNode.getGetState()));
            }
            if (pickerNode.getSetState() == null) {
                pickerNode.setSetState("");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002f, code lost:
    
        if (e.p.d.i.a(r4, "true") != false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void r(com.omarea.krscript.model.SwitchNode r3, org.xmlpull.v1.XmlPullParser r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L49
            android.content.Context r4 = r2.a
            java.lang.String r0 = r3.getGetState()
            java.lang.String r4 = r2.d(r4, r0)
            java.lang.String r0 = "error"
            boolean r0 = e.p.d.i.a(r4, r0)
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L3a
            java.lang.String r0 = "1"
            boolean r0 = e.p.d.i.a(r4, r0)
            if (r0 != 0) goto L3b
            if (r4 == 0) goto L32
            java.lang.String r4 = r4.toLowerCase()
            java.lang.String r0 = "(this as java.lang.String).toLowerCase()"
            e.p.d.i.c(r4, r0)
            java.lang.String r0 = "true"
            boolean r4 = e.p.d.i.a(r4, r0)
            if (r4 == 0) goto L3a
            goto L3b
        L32:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.String"
            r3.<init>(r4)
            throw r3
        L3a:
            r1 = 0
        L3b:
            r3.setChecked(r1)
            java.lang.String r4 = r3.getSetState()
            if (r4 != 0) goto L49
            java.lang.String r4 = ""
            r3.setSetState(r4)
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.b.l.b.r(com.omarea.krscript.model.SwitchNode, org.xmlpull.v1.XmlPullParser):void");
    }

    private final void s(TextNode textNode, XmlPullParser xmlPullParser) {
    }

    private final void t(ActionNode actionNode, XmlPullParser xmlPullParser) {
        CharSequence R;
        String str;
        String str2;
        String str3 = "title";
        if (i.a("title", xmlPullParser.getName())) {
            String nextText = xmlPullParser.nextText();
            i.c(nextText, "parser.nextText()");
            actionNode.setTitle(nextText);
            return;
        }
        String str4 = "desc";
        if (i.a("desc", xmlPullParser.getName())) {
            c(actionNode, xmlPullParser);
            return;
        }
        if (i.a("summary", xmlPullParser.getName())) {
            n(actionNode, xmlPullParser);
            return;
        }
        if (i.a("script", xmlPullParser.getName()) || i.a("set", xmlPullParser.getName()) || i.a("setstate", xmlPullParser.getName())) {
            String nextText2 = xmlPullParser.nextText();
            i.c(nextText2, "parser.nextText()");
            if (nextText2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            R = v.R(nextText2);
            actionNode.setSetState(R.toString());
            return;
        }
        if (i.a("lock", xmlPullParser.getName()) || i.a("lock-state", xmlPullParser.getName())) {
            String nextText3 = xmlPullParser.nextText();
            i.c(nextText3, "parser.nextText()");
            actionNode.setLockShell(nextText3);
            return;
        }
        if (!i.a("param", xmlPullParser.getName())) {
            if (this.g == null || !i.a("option", xmlPullParser.getName())) {
                if (i.a("resource", xmlPullParser.getName())) {
                    k(xmlPullParser);
                    return;
                }
                return;
            }
            ActionParamInfo actionParamInfo = this.g;
            i.b(actionParamInfo);
            if (actionParamInfo.getOptions() == null) {
                actionParamInfo.setOptions(new ArrayList<>());
            }
            d.c.a.e.a aVar = new d.c.a.e.a();
            int attributeCount = xmlPullParser.getAttributeCount();
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = xmlPullParser.getAttributeName(i);
                if (i.a(attributeName, "val") || i.a(attributeName, "value")) {
                    aVar.f(xmlPullParser.getAttributeValue(i));
                }
            }
            aVar.e(xmlPullParser.nextText());
            if (aVar.c() == null) {
                aVar.f(aVar.b());
            }
            ArrayList<d.c.a.e.a> options = actionParamInfo.getOptions();
            i.b(options);
            options.add(aVar);
            return;
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        ActionParamInfo actionParamInfo2 = new ActionParamInfo();
        this.g = actionParamInfo2;
        i.b(actionParamInfo2);
        int attributeCount2 = xmlPullParser.getAttributeCount();
        int i2 = 0;
        while (true) {
            if (i2 >= attributeCount2) {
                if (!actionParamInfo2.getSupported() || actionParamInfo2.getName() == null) {
                    return;
                }
                String name = actionParamInfo2.getName();
                i.b(name);
                if (name.length() > 0) {
                    ArrayList<ActionParamInfo> arrayList = this.f;
                    i.b(arrayList);
                    arrayList.add(actionParamInfo2);
                    return;
                }
                return;
            }
            String attributeName2 = xmlPullParser.getAttributeName(i2);
            String attributeValue = xmlPullParser.getAttributeValue(i2);
            if (i.a(attributeName2, "name")) {
                actionParamInfo2.setName(attributeValue);
            } else if (i.a(attributeName2, "label")) {
                actionParamInfo2.setLabel(attributeValue);
            } else if (i.a(attributeName2, "placeholder")) {
                i.c(attributeValue, "attrValue");
                actionParamInfo2.setPlaceholder(attributeValue);
            } else if (i.a(attributeName2, str3)) {
                actionParamInfo2.setTitle(attributeValue);
            } else if (i.a(attributeName2, str4)) {
                actionParamInfo2.setDesc(attributeValue);
            } else if (i.a(attributeName2, "value")) {
                actionParamInfo2.setValue(attributeValue);
            } else if (i.a(attributeName2, "type")) {
                i.c(attributeValue, "attrValue");
                if (attributeValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = attributeValue.toLowerCase();
                i.c(lowerCase, "(this as java.lang.String).toLowerCase()");
                int length = lowerCase.length() - 1;
                int i3 = 0;
                boolean z = false;
                while (i3 <= length) {
                    boolean z2 = i.e(lowerCase.charAt(!z ? i3 : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z2) {
                        i3++;
                    } else {
                        z = true;
                    }
                }
                actionParamInfo2.setType(lowerCase.subSequence(i3, length + 1).toString());
            } else if (i.a(attributeName2, "suffix")) {
                i.c(attributeValue, "attrValue");
                if (attributeValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase2 = attributeValue.toLowerCase();
                i.c(lowerCase2, "(this as java.lang.String).toLowerCase()");
                int length2 = lowerCase2.length() - 1;
                int i4 = 0;
                boolean z3 = false;
                while (i4 <= length2) {
                    boolean z4 = i.e(lowerCase2.charAt(!z3 ? i4 : length2), 32) <= 0;
                    if (z3) {
                        if (!z4) {
                            break;
                        } else {
                            length2--;
                        }
                    } else if (z4) {
                        i4++;
                    } else {
                        z3 = true;
                    }
                }
                String obj = lowerCase2.subSequence(i4, length2 + 1).toString();
                if (actionParamInfo2.getMime().length() == 0) {
                    actionParamInfo2.setMime(new e().a(obj));
                }
                actionParamInfo2.setSuffix(obj);
            } else if (i.a(attributeName2, "mime")) {
                i.c(attributeValue, "attrValue");
                if (attributeValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase3 = attributeValue.toLowerCase();
                i.c(lowerCase3, "(this as java.lang.String).toLowerCase()");
                actionParamInfo2.setMime(lowerCase3);
            } else {
                str = str3;
                if (i.a(attributeName2, "readonly")) {
                    i.c(attributeValue, "attrValue");
                    if (attributeValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase4 = attributeValue.toLowerCase();
                    i.c(lowerCase4, "(this as java.lang.String).toLowerCase()");
                    int length3 = lowerCase4.length() - 1;
                    boolean z5 = false;
                    int i5 = 0;
                    while (true) {
                        if (i5 > length3) {
                            str2 = str4;
                            break;
                        }
                        str2 = str4;
                        boolean z6 = i.e(lowerCase4.charAt(!z5 ? i5 : length3), 32) <= 0;
                        if (z5) {
                            if (!z6) {
                                break;
                            } else {
                                length3--;
                            }
                        } else if (z6) {
                            i5++;
                        } else {
                            z5 = true;
                        }
                        str4 = str2;
                    }
                    String obj2 = lowerCase4.subSequence(i5, length3 + 1).toString();
                    actionParamInfo2.setReadonly(i.a(obj2, "readonly") || i.a(obj2, "true") || i.a(obj2, "1"));
                } else {
                    str2 = str4;
                    if (i.a(attributeName2, "maxlength")) {
                        actionParamInfo2.setMaxLength(Integer.parseInt(attributeValue));
                    } else if (i.a(attributeName2, "min")) {
                        actionParamInfo2.setMin(Integer.parseInt(attributeValue));
                    } else if (i.a(attributeName2, "max")) {
                        actionParamInfo2.setMax(Integer.parseInt(attributeValue));
                    } else if (i.a(attributeName2, "required")) {
                        actionParamInfo2.setRequired(i.a(attributeValue, "true") || i.a(attributeValue, "1") || i.a(attributeValue, "required"));
                    } else {
                        if (i.a(attributeName2, "value-sh") || i.a(attributeName2, "value-su")) {
                            actionParamInfo2.setValueShell(attributeValue);
                        } else if (i.a(attributeName2, "options-sh") || i.a(attributeName2, "option-sh") || i.a(attributeName2, "options-su")) {
                            if (actionParamInfo2.getOptions() == null) {
                                actionParamInfo2.setOptions(new ArrayList<>());
                            }
                            i.c(attributeValue, "script");
                            actionParamInfo2.setOptionsSh(attributeValue);
                        } else if (i.a(attributeName2, "support") || i.a(attributeName2, "visible")) {
                            Context context = this.a;
                            i.c(attributeValue, "attrValue");
                            if (!i.a(d(context, attributeValue), "1")) {
                                actionParamInfo2.setSupported(false);
                            }
                        } else if (i.a(attributeName2, "multiple")) {
                            actionParamInfo2.setMultiple(i.a(attributeValue, "multiple") || i.a(attributeValue, "true") || i.a(attributeValue, "1"));
                        } else if (i.a(attributeName2, "editable")) {
                            actionParamInfo2.setEditable(i.a(attributeValue, "editable") || i.a(attributeValue, "true") || i.a(attributeValue, "1"));
                        } else if (i.a(attributeName2, "separator")) {
                            i.c(attributeValue, "attrValue");
                            actionParamInfo2.setSeparator(attributeValue);
                        }
                        i2++;
                        str4 = str2;
                        str3 = str;
                    }
                }
                i2++;
                str4 = str2;
                str3 = str;
            }
            str = str3;
            str2 = str4;
            i2++;
            str4 = str2;
            str3 = str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x01d5, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void u(com.omarea.krscript.model.PageNode r13, org.xmlpull.v1.XmlPullParser r14) {
        /*
            Method dump skipped, instructions count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.b.l.b.u(com.omarea.krscript.model.PageNode, org.xmlpull.v1.XmlPullParser):void");
    }

    private final void v(PickerNode pickerNode, XmlPullParser xmlPullParser) {
        if (i.a("title", xmlPullParser.getName())) {
            String nextText = xmlPullParser.nextText();
            i.c(nextText, "parser.nextText()");
            pickerNode.setTitle(nextText);
            return;
        }
        if (i.a("desc", xmlPullParser.getName())) {
            c(pickerNode, xmlPullParser);
            return;
        }
        if (i.a("summary", xmlPullParser.getName())) {
            n(pickerNode, xmlPullParser);
            return;
        }
        if (i.a("option", xmlPullParser.getName())) {
            if (pickerNode.getOptions() == null) {
                pickerNode.setOptions(new ArrayList<>());
            }
            d.c.a.e.a aVar = new d.c.a.e.a();
            int attributeCount = xmlPullParser.getAttributeCount();
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = xmlPullParser.getAttributeName(i);
                if (i.a(attributeName, "val") || i.a(attributeName, "value")) {
                    aVar.f(xmlPullParser.getAttributeValue(i));
                }
            }
            aVar.e(xmlPullParser.nextText());
            if (aVar.c() == null) {
                aVar.f(aVar.b());
            }
            ArrayList<d.c.a.e.a> options = pickerNode.getOptions();
            i.b(options);
            options.add(aVar);
            return;
        }
        if (i.a("getstate", xmlPullParser.getName()) || i.a("get", xmlPullParser.getName())) {
            pickerNode.setGetState(xmlPullParser.nextText());
            return;
        }
        if (i.a("setstate", xmlPullParser.getName()) || i.a("set", xmlPullParser.getName())) {
            pickerNode.setSetState(xmlPullParser.nextText());
            return;
        }
        if (i.a("resource", xmlPullParser.getName())) {
            k(xmlPullParser);
        } else if (i.a("lock", xmlPullParser.getName()) || i.a("lock-state", xmlPullParser.getName())) {
            String nextText2 = xmlPullParser.nextText();
            i.c(nextText2, "parser.nextText()");
            pickerNode.setLockShell(nextText2);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000e. Please report as an issue. */
    private final void w(SwitchNode switchNode, XmlPullParser xmlPullParser) {
        String name = xmlPullParser.getName();
        if (name == null) {
            return;
        }
        switch (name.hashCode()) {
            case -1857640538:
                if (name.equals("summary")) {
                    n(switchNode, xmlPullParser);
                    return;
                }
                return;
            case -341064690:
                if (name.equals("resource")) {
                    k(xmlPullParser);
                    return;
                }
                return;
            case -196357777:
                if (!name.equals("lock-state")) {
                    return;
                }
                String nextText = xmlPullParser.nextText();
                i.c(nextText, "parser.nextText()");
                switchNode.setLockShell(nextText);
                return;
            case 102230:
                if (!name.equals("get")) {
                    return;
                }
                String nextText2 = xmlPullParser.nextText();
                i.c(nextText2, "parser.nextText()");
                switchNode.setGetState(nextText2);
                return;
            case 113762:
                if (!name.equals("set")) {
                    return;
                }
                switchNode.setSetState(xmlPullParser.nextText());
                return;
            case 3079825:
                if (name.equals("desc")) {
                    c(switchNode, xmlPullParser);
                    return;
                }
                return;
            case 3327275:
                if (!name.equals("lock")) {
                    return;
                }
                String nextText3 = xmlPullParser.nextText();
                i.c(nextText3, "parser.nextText()");
                switchNode.setLockShell(nextText3);
                return;
            case 110371416:
                if (name.equals("title")) {
                    String nextText4 = xmlPullParser.nextText();
                    i.c(nextText4, "parser.nextText()");
                    switchNode.setTitle(nextText4);
                    return;
                }
                return;
            case 1434023279:
                if (!name.equals("setstate")) {
                    return;
                }
                switchNode.setSetState(xmlPullParser.nextText());
                return;
            case 1995135739:
                if (!name.equals("getstate")) {
                    return;
                }
                String nextText22 = xmlPullParser.nextText();
                i.c(nextText22, "parser.nextText()");
                switchNode.setGetState(nextText22);
                return;
            default:
                return;
        }
    }

    private final void x(TextNode textNode, XmlPullParser xmlPullParser) {
        if (i.a("title", xmlPullParser.getName())) {
            String nextText = xmlPullParser.nextText();
            i.c(nextText, "parser.nextText()");
            textNode.setTitle(nextText);
        } else {
            if (i.a("desc", xmlPullParser.getName())) {
                c(textNode, xmlPullParser);
                return;
            }
            if (i.a("summary", xmlPullParser.getName())) {
                n(textNode, xmlPullParser);
            } else if (i.a("slice", xmlPullParser.getName())) {
                l(textNode, xmlPullParser);
            } else if (i.a("resource", xmlPullParser.getName())) {
                k(xmlPullParser);
            }
        }
    }

    public final ArrayList<NodeInfoBase> i() {
        InputStream inputStream = this.f1408d;
        if (inputStream != null) {
            i.b(inputStream);
            return j(inputStream);
        }
        try {
            d dVar = new d(this.a, this.f1409e);
            InputStream e2 = dVar.e(this.f1406b);
            if (e2 == null) {
                return new ArrayList<>();
            }
            this.f1407c = dVar.c();
            return j(e2);
        } catch (Exception e3) {
            new Handler(Looper.getMainLooper()).post(new a(e3));
            Log.e("KrConfig Fail！", "" + e3.getMessage());
            return null;
        }
    }
}
