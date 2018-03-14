package com.example.felipeboza.simplefirebase;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by Felipe Boza on 06/01/2018.
 */

public class Globales {

    public static String rutaFirebase = "Plantas"; // Nombre de la base de datos web

    public static long numeroRegistros = -1; // Se almacena el numero de registros en la base de datos web
    public static ArrayList<Planta> plantas; // Almacena objetos de tipo planta
    public static ArrayList<String> plantasFamilias; // Almacena las familias de las plantas

    public static Planta planta_actual = new Planta(); // Almacena un objeto de tipo planta

    public static int SELECT_PICTURE = 2; // Indica que se seleccionara una fotografia de galeria

    public Globales() {
    }

    public static long getNumeroRegistros() {
        return numeroRegistros;
    }

    public static void setNumeroRegistros(long numRecords) {
        Globales.numeroRegistros = numRecords;
    }

    public static ArrayList<Planta> getPlantas() {
        return plantas;
    }

    public static void setPlantas(ArrayList<Planta> plantas) {
        Globales.plantas = plantas;
    }

    public static Planta getPlanta_actual() {
        return planta_actual;
    }

    public static void setPlanta_actual(Planta planta_actual) {
        Globales.planta_actual = planta_actual;
    }

    /*
        Este metodo permite convertir una imagen en formato bitmap a formato string

     */

    public static String BitmapToString(Bitmap bitmap) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            byte[] b = baos.toByteArray();
            String temp = Base64.encodeToString(b, Base64.DEFAULT);
            return temp;
        } catch (NullPointerException e) {
            return null;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    /*
        Este metodo permite convertir una imagen en formato string a formato bitmap

     */

    public static Bitmap StringToBitmap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (NullPointerException e) {
            e.getMessage();
            return null;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }


    public static int getSelectPicture() {
        return SELECT_PICTURE;
    }

    public static void setSelectPicture(int selectPicture) {
        SELECT_PICTURE = selectPicture;
    }


    /*
        Este metodo verifica si existen variables vacias

     */

    public static boolean comprobarVariablesVacias(){

        if(Globales.getPlanta_actual().getId().isEmpty() ||
                Globales.getPlanta_actual().getNombreCientifico().isEmpty() ||
                Globales.getPlanta_actual().getNombreComun().isEmpty() ||
                Globales.getPlanta_actual().getFamilia().isEmpty() ||
                Globales.getPlanta_actual().getGenero().isEmpty() ||
                Globales.getPlanta_actual().getEspecie().isEmpty() ||
                Globales.getPlanta_actual().getClasificador().isEmpty() ||
                Globales.getPlanta_actual().getTipo().isEmpty() ||
                Globales.getPlanta_actual().getDistrito().isEmpty() ||
                Globales.getPlanta_actual().getUsos().isEmpty() ||
                Globales.getPlanta_actual().getProductor().isEmpty() ||
                Globales.getPlanta_actual().getLatitud().isEmpty() ||
                Globales.getPlanta_actual().getLongitud().isEmpty()){

            return false;
        }

        return true;
    }

    public static String getRutaFirebase() {
        return rutaFirebase;
    }

    public static void setRutaFirebase(String rutaFirebase) {
        Globales.rutaFirebase = rutaFirebase;
    }

    /*
        Este metodo permite comprobar si una cadena de texto esta vacia

     */

    public static boolean comprobarCadenaVacia(String cadena) {

        if ( (cadena == null) || (cadena.isEmpty()) ) {
            return false;
        }

        return true;
    }

    public static ArrayList<String> getPlantasFamilias() {
        return plantasFamilias;
    }

    public static void setPlantasFamilias(ArrayList<String> plantasFamilias) {
        Globales.plantasFamilias = plantasFamilias;
    }

    // Este metodo comprueba sin un elemento ya se encuentra agregado en una lista

    public static boolean comprobarElementoEnLista(String elemento) {

        for (int i = 0; i < Globales.getPlantasFamilias().size(); i++) {

            if (elemento.equals(Globales.getPlantasFamilias().get(i))) { // Si el elemento ya esta en la lista

                // entonces se devuelve FALSE
                return false;

            }

        }

        // Si el elemento no esta en la lista

        return true; // entonces se devuelve TRUE
    }

}
