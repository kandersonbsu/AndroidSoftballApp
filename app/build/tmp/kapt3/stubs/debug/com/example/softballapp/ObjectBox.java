package com.example.softballapp;

import java.lang.System;

/**
 * * Singleton to keep BoxStore reference.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/example/softballapp/ObjectBox;", "", "()V", "<set-?>", "Lio/objectbox/BoxStore;", "boxStore", "getBoxStore", "()Lio/objectbox/BoxStore;", "init", "", "context", "Landroid/content/Context;", "app_debug"})
public final class ObjectBox {
    @org.jetbrains.annotations.NotNull()
    private static io.objectbox.BoxStore boxStore;
    public static final com.example.softballapp.ObjectBox INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.objectbox.BoxStore getBoxStore() {
        return null;
    }
    
    public final void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    private ObjectBox() {
        super();
    }
}