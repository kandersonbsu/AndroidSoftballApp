
package com.example.softballapp;

import com.example.softballapp.TeamCursor.Factory;
import io.objectbox.EntityInfo;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import io.objectbox.internal.ToManyGetter;
import io.objectbox.internal.ToOneGetter;
import io.objectbox.relation.RelationInfo;
import io.objectbox.relation.ToOne;
import java.util.List;

// THIS CODE IS GENERATED BY ObjectBox, DO NOT EDIT.

/**
 * Properties for entity "Team". Can be used for QueryBuilder and for referencing DB names.
 */
public final class Team_ implements EntityInfo<Team> {

    // Leading underscores for static constants to avoid naming conflicts with property names

    public static final String __ENTITY_NAME = "Team";

    public static final int __ENTITY_ID = 3;

    public static final Class<Team> __ENTITY_CLASS = Team.class;

    public static final String __DB_NAME = "Team";

    public static final CursorFactory<Team> __CURSOR_FACTORY = new Factory();

    @Internal
    static final TeamIdGetter __ID_GETTER = new TeamIdGetter();

    public final static Team_ __INSTANCE = new Team_();

    public final static io.objectbox.Property<Team> id =
        new io.objectbox.Property<>(__INSTANCE, 0, 1, long.class, "id", true, "id");

    public final static io.objectbox.Property<Team> teamName =
        new io.objectbox.Property<>(__INSTANCE, 1, 2, String.class, "teamName");

    public final static io.objectbox.Property<Team> manager =
        new io.objectbox.Property<>(__INSTANCE, 2, 3, String.class, "manager");

    public final static io.objectbox.Property<Team> location =
        new io.objectbox.Property<>(__INSTANCE, 3, 4, String.class, "location");

    @SuppressWarnings("unchecked")
    public final static io.objectbox.Property<Team>[] __ALL_PROPERTIES = new io.objectbox.Property[]{
        id,
        teamName,
        manager,
        location
    };

    public final static io.objectbox.Property<Team> __ID_PROPERTY = id;

    @Override
    public String getEntityName() {
        return __ENTITY_NAME;
    }

    @Override
    public int getEntityId() {
        return __ENTITY_ID;
    }

    @Override
    public Class<Team> getEntityClass() {
        return __ENTITY_CLASS;
    }

    @Override
    public String getDbName() {
        return __DB_NAME;
    }

    @Override
    public io.objectbox.Property<Team>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    @Override
    public io.objectbox.Property<Team> getIdProperty() {
        return __ID_PROPERTY;
    }

    @Override
    public IdGetter<Team> getIdGetter() {
        return __ID_GETTER;
    }

    @Override
    public CursorFactory<Team> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    @Internal
    static final class TeamIdGetter implements IdGetter<Team> {
        @Override
        public long getId(Team object) {
            return object.getId();
        }
    }

    /** To-many relation "players" to target entity "Player". */
    public static final RelationInfo<Team, Player> players = new RelationInfo<>(Team_.__INSTANCE, Player_.__INSTANCE,
            new ToManyGetter<Team>() {
                @Override
                public List<Player> getToMany(Team entity) {
                    return entity.players;
                }
            },
             1);

}