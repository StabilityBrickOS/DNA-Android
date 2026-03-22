package com.omarea.krscript.model;

import e.p.d.e;
import e.p.d.i;

/* loaded from: classes.dex */
public class RunnableNode extends ClickableNode {
    private boolean autoFinish;
    private boolean autoOff;
    private boolean confirm;
    private boolean interruptable;
    private boolean reloadPage;
    private String setState;
    private String shell;
    private String[] updateBlocks;
    private String warning;
    public static final Companion Companion = new Companion(null);
    private static final String shellModeDefault = "default";
    private static final String shellModeBgTask = "bg-task";
    private static final String shellModeHidden = "hidden";

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final String getShellModeBgTask() {
            return RunnableNode.shellModeBgTask;
        }

        public final String getShellModeDefault() {
            return RunnableNode.shellModeDefault;
        }

        public final String getShellModeHidden() {
            return RunnableNode.shellModeHidden;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunnableNode(String str) {
        super(str);
        i.d(str, "currentConfigXml");
        this.warning = "";
        this.interruptable = true;
        this.shell = shellModeDefault;
    }

    public final boolean getAutoFinish() {
        return this.autoFinish;
    }

    public final boolean getAutoOff() {
        return this.autoOff;
    }

    public final boolean getConfirm() {
        return this.confirm;
    }

    public final boolean getInterruptable() {
        return this.interruptable;
    }

    public final boolean getReloadPage() {
        return this.reloadPage;
    }

    public final String getSetState() {
        return this.setState;
    }

    public final String getShell() {
        return this.shell;
    }

    public final String[] getUpdateBlocks() {
        return this.updateBlocks;
    }

    public final String getWarning() {
        return this.warning;
    }

    public final void setAutoFinish(boolean z) {
        this.autoFinish = z;
    }

    public final void setAutoOff(boolean z) {
        this.autoOff = z;
    }

    public final void setConfirm(boolean z) {
        this.confirm = z;
    }

    public final void setInterruptable(boolean z) {
        this.interruptable = z;
    }

    public final void setReloadPage(boolean z) {
        this.reloadPage = z;
    }

    public final void setSetState(String str) {
        this.setState = str;
    }

    public final void setShell(String str) {
        i.d(str, "<set-?>");
        this.shell = str;
    }

    public final void setUpdateBlocks(String[] strArr) {
        this.updateBlocks = strArr;
    }

    public final void setWarning(String str) {
        i.d(str, "<set-?>");
        this.warning = str;
    }
}
