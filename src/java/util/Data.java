/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data {

    private static final SimpleDateFormat DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static final Date converte(String data) {
        try {
            return DATETIME.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
