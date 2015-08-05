package restservice

class Customer {

    String firstname
    String lastname
    String status
    String gender
    Date dob
    String emailid
    String address
    String phoneno
    String password

    static mapping = {
        id column: "custid", generator: "assigned"
        version false
    }

    static constraints = {
        firstname nullable: true, maxSize: 20
        lastname nullable: true, maxSize: 20
        status nullable: true, maxSize: 10
        gender nullable: true, maxSize: 1
        dob nullable: true
        emailid nullable: true, maxSize: 30
        address nullable: true, maxSize: 100
        phoneno nullable: true, maxSize: 10
        password nullable: true, maxSize: 32
    }
}
