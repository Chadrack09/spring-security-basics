package za.ac.cput.app.model;

import com.google.common.collect.Sets;

import java.util.Set;

import static za.ac.cput.app.model.UserPermission.*;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 3/11/2022 | 11:02 AM
 *
 * <p>Project spring-security-basics</p>
 */
public enum UserRole {
    USER(Sets.newHashSet(USER_READ, USER_WRITE)),
    ADMIN(Sets.newHashSet(ADMIN_READ, ADMIN_WRITE));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
}
