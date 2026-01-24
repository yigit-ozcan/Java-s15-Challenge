package librarysystem.records;

import librarysystem.enums.MemberType;

import java.time.LocalDate;

public class member_Record {
    protected int member_id;
    protected MemberType type;
    protected LocalDate date_of_membership;
    protected int no_books_issued;
    protected int max_book_limit;
    protected String name;
    protected String address;
    protected String phone_no;
}
