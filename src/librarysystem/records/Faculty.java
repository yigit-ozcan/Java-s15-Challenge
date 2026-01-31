package librarysystem.records;

import librarysystem.enums.MemberType;

public class Faculty extends member_Record{

    public Faculty() {
        this.type = MemberType.FACULTY;
        this.maxBookLimit = 5;
        this.noBookIssued = 0;
    }

}
