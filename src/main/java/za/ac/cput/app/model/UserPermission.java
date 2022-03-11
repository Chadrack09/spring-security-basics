package za.ac.cput.app.model;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 3/11/2022 | 11:51 AM
 *
 * <p>Project spring-security-basics</p>
 */
public enum UserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),

    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");

    private final String permissions;

    UserPermission(String permissions) {
        this.permissions = permissions;
    }

    public String getPermissions() {
        return permissions;
    }
}
