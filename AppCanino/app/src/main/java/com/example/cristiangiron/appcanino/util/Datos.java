package com.example.cristiangiron.appcanino.util;

import com.example.cristiangiron.appcanino.models.Peluqueria01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CristianGiron on 22/05/2017.
 */

public class Datos {

    private static List<Peluqueria01> datos;

    public static List<Peluqueria01> getDatos(){

        if (datos == null){
            datos = new ArrayList<>();

            Peluqueria01 p1 = new Peluqueria01();
            p1.setName("Huellas Peluqueria Canina");
            p1.setFecha("Cupón Valido Hasta 12 de Abril 2017");
            p1.setHora("6:00pm");

            p1.setDescripcion("Huellas jsjjshkjshksjhs sjhskjhs kskjhskjhskjskj shkshksjhkshksjhskjhskshkshkshk");
            p1.setImage("http://nessware.net/wp-content/uploads/2014/03/Descuento-50-Nessware.Net_.png");
            p1.setDireccion("Calle 5 # 7-80");


            Peluqueria01 p2 = new Peluqueria01();
            p2.setName("Caniches Peluqueria Canina");
            p2.setFecha("Cupon Valido Hasta 27 de Junio 2017");
            p2.setHora("4:00pm");
            p2.setDescripcion("Huellas jsjjshkjshksjhs sjhskjhs kskjhskjhskjskj shkshksjhkshksjhskjhskshkshkshk");
            p2.setImage("http://blog.ofertitas.es/wp-content/uploads/2015/03/10-descuento-rakuten-09-03-2015.jpg");
            p2.setDireccion("Carrera 4 # 7-89");


            Peluqueria01 p3 = new Peluqueria01();
            p3.setName("Pelos & Patas");
            p3.setFecha("Cupón Valido Hasta 31 de Junio 2017");
            p3.setHora("12:30 pm");
            p3.setDescripcion("Huellas jsjjshkjshksjhs sjhskjhs kskjhskjhskjskj shkshksjhkshksjhskjhskshkshkshk");
            p3.setImage("http://lamanadacanina.es/wp-content/uploads/2016/07/burbujas.promo_.jpg");
            p3.setDireccion("Calle 6 # 27-7");

            Peluqueria01 p4 = new Peluqueria01();
            p4.setName("Peluditos Peluqueria Canina");
            p4.setFecha("Cupón Valido Hasta 22 de Mayo 2017");
            p4.setHora("06:30pm");
            p4.setDescripcion("Huellas jsjjshkjshksjhs sjhskjhs kskjhskjhskjskj shkshksjhkshksjhskjhskshkshkshk");
            p4.setImage("https://www.vulcano.com.ar/images/40-off-semana.png");
            p4.setDireccion("Carrera 27c-6-52");


            datos.add(p1);
            datos.add(p2);
            datos.add(p3);
            datos.add(p4);

        }

        return datos;
    }



}
