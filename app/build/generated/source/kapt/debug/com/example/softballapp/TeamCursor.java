package com.example.softballapp;

import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;
import io.objectbox.relation.ToMany;
import java.util.List;

// THIS CODE IS GENERATED BY ObjectBox, DO NOT EDIT.

/**
 * ObjectBox generated Cursor implementation for "Team".
 * Note that this is a low-level class: usually you should stick to the Box class.
 */
public final class TeamCursor extends Cursor<Team> {
    @Internal
    static final class Factory implements CursorFactory<Team> {
        @Override
        public Cursor<Team> createCursor(io.objectbox.Transaction tx, long cursorHandle, BoxStore boxStoreForEntities) {
            return new TeamCursor(tx, cursorHandle, boxStoreForEntities);
        }
    }

    private static final Team_.TeamIdGetter ID_GETTER = Team_.__ID_GETTER;


    private final static int __ID_teamName = Team_.teamName.id;
    private final static int __ID_manager = Team_.manager.id;
    private final static int __ID_location = Team_.location.id;

    public TeamCursor(io.objectbox.Transaction tx, long cursor, BoxStore boxStore) {
        super(tx, cursor, Team_.__INSTANCE, boxStore);
    }

    @Override
    public final long getId(Team entity) {
        return ID_GETTER.getId(entity);
    }

    /**
     * Puts an object into its box.
     *
     * @return The ID of the object within its box.
     */
    @Override
    public final long put(Team entity) {
        String teamName = entity.getTeamName();
        int __id1 = teamName != null ? __ID_teamName : 0;
        String manager = entity.getManager();
        int __id2 = manager != null ? __ID_manager : 0;
        String location = entity.getLocation();
        int __id3 = location != null ? __ID_location : 0;

        long __assignedId = collect313311(cursor, entity.getId(), PUT_FLAG_FIRST | PUT_FLAG_COMPLETE,
                __id1, teamName, __id2, manager,
                __id3, location, 0, null,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0);

        entity.setId(__assignedId);

        attachEntity(entity);
        checkApplyToManyToDb(entity.players, Player.class);
        return __assignedId;
    }

    private void attachEntity(Team entity) {
        // Transformer will create __boxStore field in entity and init it here:
        // entity.__boxStore = boxStoreForEntities;
    }

}