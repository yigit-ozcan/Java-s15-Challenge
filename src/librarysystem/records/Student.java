package librarysystem.records;

import librarysystem.enums.MemberType;

public class Student extends member_Record{

    public Student() {
        this.type = MemberType.STUDENT;
        this.maxBookLimit = 3;
        this.noBookIssued = 0;
    }

}
