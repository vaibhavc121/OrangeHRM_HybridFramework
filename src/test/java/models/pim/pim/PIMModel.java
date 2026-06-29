package models.pim.pim;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PIMModel
{
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EmployeeModel
    {
        public String firstName;
        public String middleName;
        public String lastName;

    }
}