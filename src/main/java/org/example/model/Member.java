package org.example.model;

public class Member {
    private static int library_id;
    private static String f_name;
    private static String l_name;
    private static long contact_num;

    public Member(String f_name, String l_name, long contact_num) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.contact_num= contact_num;
    }

    //getters
    public static int getLibrary_id() {
        return library_id;
    }

    public static String getL_name() {
        return l_name;
    }

    public static String getF_name() {
        return f_name;
    }

    public static long getContact_num() {
        return contact_num;
    }
}
