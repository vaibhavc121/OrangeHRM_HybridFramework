package models.admin.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AdminModel
{
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddUserModel
    {
        public String userRole;
        public String employeeName;
        public String status;
        public String username;
        public String password;
        public String confirmPassword;
    }

    public static class UpdateUserModel
    {
        public String status;
        public String username;
        public String password1;
        public String confirmPassword1;
    }
}