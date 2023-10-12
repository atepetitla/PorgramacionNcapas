/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.Util;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author digis
 */
public class Util {
    
public static String converBase64(MultipartFile imgenfile){

    try {
String  imagenBase64=null;    
            if (!imgenfile.isEmpty()) {
                byte[] bytes = imgenfile.getBytes();
                imagenBase64 = Base64.encodeBase64String(bytes);

               return imagenBase64;
            } else {
                 imagenBase64=null;
                return imagenBase64;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    return null;
    
}
public static String converBase64aimg(MultipartFile imgenfile){

    try {
String  imagenBase64=null;    
            if (!imgenfile.isEmpty()) {
                byte[] bytes = imgenfile.getBytes();
                imagenBase64 = Base64.encodeBase64String(bytes);

               return imagenBase64;
            } else {
                 imagenBase64=null;
                return imagenBase64;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    return null;
    
}



}