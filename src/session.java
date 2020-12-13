/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Master
 */
public class session {

    private static int id_log;
    private static String nama;
    private static String lvl;

    public static int getId() {
        return id_log;
    }

    public static void setIdlog(int id_log) {
        session.id_log = id_log;
    }

    public static String getName() {
        return nama;
    }

    public static void setName(String nama) {
        session.nama = nama;
    }

    public static String getLvl() {
        return lvl;
    }

    public static void setLvl(String lvl) {
        session.lvl = lvl;
    }

}
