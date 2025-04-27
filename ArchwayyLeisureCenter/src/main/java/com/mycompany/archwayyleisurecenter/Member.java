package com.mycompany.archwayyleisurecenter;

import java.util.Date;

/**
 *
 * @author mitas
 */

public class Member {
    private String membershipNumber;
    private String fullName;
    private boolean teamOrganizer;
    private String teamName;
    private Date dateOfBirth;
    private String address;
    private String homeTel;
    private String workTel;
    private String email;
    private Date dateOfJoining;

    // Constructor for initializing member details
    public Member(String membershipNumber, String fullName, boolean teamOrganizer, String teamName, 
                  Date dateOfBirth, String address, String homeTel, String workTel, 
                  String email, Date dateOfJoining) {
        this.membershipNumber = membershipNumber;
        this.fullName = fullName;
        this.teamOrganizer = teamOrganizer;
        this.teamName = teamName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.homeTel = homeTel;
        this.workTel = workTel;
        this.email = email;
        this.dateOfJoining = dateOfJoining;
    }

    // Method to display member info
    public String displayMemberInfo() {
        return "Membership Number: " + membershipNumber + "\n" +
               "Name: " + fullName + "\n" +
               "Team Organizer: " + (teamOrganizer ? "Yes" : "No") + "\n" +
               "Team: " + teamName + "\n" +
               "Date of Birth: " + dateOfBirth + "\n" +
               "Address: " + address + "\n" +
               "Home Tel: " + homeTel + "\n" +
               "Work Tel: " + workTel + "\n" +
               "Email: " + email + "\n" +
               "Date of Joining: " + dateOfJoining + "\n";
    }
    
}
