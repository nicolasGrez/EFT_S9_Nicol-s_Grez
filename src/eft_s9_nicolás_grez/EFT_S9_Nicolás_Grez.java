/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eft_s9_nicolás_grez;
import java.util.*;
/**
 *
 * @author admin
 */
public class EFT_S9_Nicolás_Grez {
     static String[][] vip = new String[2][6];
    static boolean[][] ocupadosVip = new boolean[2][6];
     static String[][] palco = new String[2][6];
    static boolean[][] ocupadosPalco = new boolean[2][6];
     static String[][] plateaBaja = new String[2][6];
    static boolean[][] ocupadosPlateaBaja = new boolean[2][6];
     static String[][] plateaAlta = new String[2][6];
    static boolean[][] ocupadosPlateaAlta = new boolean[2][6];
     static String[][] galeria = new String[2][6];
    static boolean[][] ocupadosGaleria = new boolean[2][6];
    
    static ArrayList<String> boletas = new ArrayList<>();
    
    static double total = 0;
    static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        // TODO code application logic here
        inicializarVip();
        inicializarPalco();
        inicializarPlateaBaja();
        inicializarPlateaAlta();
        inicializarGaleria();
        int opcion;
        
        do{
            
            
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");
            
            switch(opcion){
                case 1 -> menuZonas();
                case 2 -> comprarEntrada();
                case 3 -> eliminarEntrada();
                case 4 -> imprimirBoleta();
                case 5 -> System.out.println("Gracias por su compra!\n Hasta luego!");
                default -> System.out.println("Opcion no valida, intente nuevamente");
                  
            }
        }while (opcion!=5);
    }
    
    
    static void inicializarVip(){
        for(int i = 0; i<2; i++){
            for(int j=0; j<6;j++){
                vip[i][j]=(char)('A'+i)+Integer.toString(j+1);
                ocupadosVip[i][j] = false;
            }
        }
    }
        static void inicializarPalco(){
        for(int i = 0; i<2; i++){
            for(int j=0; j<6;j++){
                palco[i][j]=(char)('C'+i)+Integer.toString(j+1);
                ocupadosPalco[i][j] = false;
            }
        }
        
    }
        static void inicializarPlateaBaja(){
        for(int i = 0; i<2; i++){
            for(int j=0; j<6;j++){
                plateaBaja[i][j]=(char)('E'+i)+Integer.toString(j+1);
                ocupadosPlateaBaja[i][j] = false; 
            }
        }
        }
        static void inicializarPlateaAlta(){
        for(int i = 0; i<2; i++){
            for(int j=0; j<6;j++){
                plateaAlta[i][j]=(char)('G'+i)+Integer.toString(j+1);
                ocupadosPlateaAlta[i][j] = false;
            }
        }
        }
        static void inicializarGaleria(){
        for(int i = 0; i<2; i++){
            for(int j=0; j<6;j++){
                galeria[i][j]=(char)('I'+i)+Integer.toString(j+1);
                ocupadosGaleria[i][j] = false; 
            }
        }
        }
    static void mostrarMenu(){
        System.out.println("\n--- TEATRO MORO ---");
                System.out.println("1. Mostrar Zonas disponibles");
                System.out.println("2. Comprar entradas");
                System.out.println("3. Eliminar reserva existentes");
                System.out.println("4. Imprimir boleta");
                System.out.println("5. Salir");
    }
    static void menuZonas(){
     System.out.println("    ---------------ESCENARIO---------------");
                            System.out.println("0.   VIP:      A1-A2-A3-A4-A5-A6 ");
                            System.out.println("               B1-B2-B3-B4-B5-B6 ");
                            System.out.println("               ================= ");
                            System.out.println("1. PALCO:      C1-C2-C3-C4-C5-C6 ");
                            System.out.println("               D1-D2-D3-D4-D5-D6 ");
                            System.out.println("               ================= ");
                            System.out.println("2.PLATEA BAJA: E1-E2-E3-E4-E5-E6 ");
                            System.out.println("               F1-F2-F3-F4-F5-F6 ");
                            System.out.println("               ================= ");
                            System.out.println("3.PLATEA ALTA: G1-G2-G3-G4-G5-G6 ");
                            System.out.println("               H1-H2-H3-H4-H5-H6 ");
                            System.out.println("               ================= ");
                            System.out.println("4.   GALERIA:  I1-I2-I3-I4-I5-I6 ");
                            System.out.println("               J1-J2-J3-J4-J5-J6 ");
    }
    static void comprarEntrada() {
    String nombre = leerTexto("Ingrese su nombre: ");
    int edad = leerEntero("Ingrese su edad: ");
    String sexo = leerTexto("Ingrese su sexo (M/F): ").toUpperCase();
    boolean esEstudiante = leerSiNo("Es estudiante? (si/no):");

    double descuento = 0;
    String tipo = "General";

    if (edad >= 60) {
        descuento += 25.0;
        tipo = "Adulto Mayor";
    } else if (edad <= 12) {
        descuento += 10.0;
        tipo = "Nino";
    }

    if (sexo.equals("F")) {
        descuento += 20.0;
        tipo += " / Mujer";
    }

    if (esEstudiante) {
        descuento += 15.0;
        tipo += " / Estudiante";
    }

    menuZonas();
    int zona = leerEntero("Ingrese el numero de la zona: ");
    int[] pos;
    int costo;
    String asientoSeleccionado;
    double montoConDescuento;
    String ficha;

    while (true) {
        switch (zona) {
            case 0 -> {
                mostrarVip();
                costo = 30000;
                asientoSeleccionado = leerTexto("Seleccione asiento (ej: A1): ").toUpperCase();
                pos = buscarAsientoVip(asientoSeleccionado);
                if (pos[0] == -1 || ocupadosVip[pos[0]][pos[1]]) {
                    System.out.println("Asiento no disponible.");
                    continue;
                }
                ocupadosVip[pos[0]][pos[1]] = true;
            }
            case 1 -> {
                mostrarPalco();
                costo = 18000;
                asientoSeleccionado = leerTexto("Seleccione asiento (ej: C1): ").toUpperCase();
                pos = buscarAsientoPalco(asientoSeleccionado);
                if (pos[0] == -1 || ocupadosPalco[pos[0]][pos[1]]) {
                    System.out.println("Asiento no disponible.");
                    continue;
                }
                ocupadosPalco[pos[0]][pos[1]] = true;
            }
            case 2 -> {
                mostrarPlateaBaja();
                costo = 13000;
                asientoSeleccionado = leerTexto("Seleccione asiento (ej: E1): ").toUpperCase();
                pos = buscarAsientoPlateaBaja(asientoSeleccionado);
                if (pos[0] == -1 || ocupadosPlateaBaja[pos[0]][pos[1]]) {
                    System.out.println("Asiento no disponible.");
                    continue;
                }
                ocupadosPlateaBaja[pos[0]][pos[1]] = true;
            }
            case 3 -> {
                mostrarPlateaAlta();
                costo = 10000;
                asientoSeleccionado = leerTexto("Seleccione asiento (ej: G1): ").toUpperCase();
                pos = buscarAsientoPlateaAlta(asientoSeleccionado);
                if (pos[0] == -1 || ocupadosPlateaAlta[pos[0]][pos[1]]) {
                    System.out.println("Asiento no disponible.");
                    continue;
                }
                ocupadosPlateaAlta[pos[0]][pos[1]] = true;
            }
            case 4 -> {
                mostrarGaleria();
                costo = 5000;
                asientoSeleccionado = leerTexto("Seleccione asiento (ej: I1): ").toUpperCase();
                pos = buscarAsientoGaleria(asientoSeleccionado);
                if (pos[0] == -1 || ocupadosGaleria[pos[0]][pos[1]]) {
                    System.out.println("Asiento no disponible.");
                    continue;
                }
                ocupadosGaleria[pos[0]][pos[1]] = true;
            }
            default -> {
                System.out.println("Zona inválida.");
                return;
            }
        }

        montoConDescuento = costo * (1 - descuento / 100);
        ficha = nombre + ", " + edad + ", Zona " + zona + ", " + asientoSeleccionado + ", " + tipo + ", $" + montoConDescuento;
        boletas.add(ficha);
        total += montoConDescuento;
        System.out.println("Entrada comprada exitosamente.");
        break;
    }
}


            static int leerEntero(String mensaje){
        while (true){
            try{
                System.out.println(mensaje);
                return Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Numero invalido, ingrese un numero entero");

            }
        }
    }
    static String leerTexto(String mensaje){
        System.out.println(mensaje);
        return sc.nextLine();
    }
    
    static void eliminarEntrada(){
        String nombre = leerTexto("Ingrese nombre de cliente a eliminar: ");
        Iterator<String> it = boletas.iterator();
        while(it.hasNext()){
            String ficha = it.next();
            if(ficha.toLowerCase().contains(nombre.toLowerCase())){
                String[] datos = ficha.split(", "); 
                total -= Double.parseDouble(datos[5]);
                it.remove();
                System.out.println("Entrada eliminada");
                return;
            }
        }
        System.out.println("No se encontró esa entrada");
    }
    
    static void mostrarVip(){
        System.out.println("===ZONA VIP===");
        for(int i = 0; i<2; i++){
            for(int j=0; j<6; j++){
                
                if(ocupadosVip[i][j]) System.out.print("[X]");
                else System.out.print("[" + vip[i][j] + "]" );
            
            }
            System.out.println("");
        }
    }
    static void mostrarPalco(){
        System.out.println("===ZONA PALCO===");
        for(int i = 0; i<2; i++){
            for(int j=0; j<6; j++){
                
                if(ocupadosPalco[i][j]) System.out.print("[X]");
                else System.out.print("[" + palco[i][j] + "]" );
            
            }
            System.out.println("");
        }
    }
     static void mostrarPlateaBaja(){
        System.out.println("===ZONA PLATEA BAJA===");
        for(int i = 0; i<2; i++){
            for(int j=0; j<6; j++){
                
                if(ocupadosPlateaBaja[i][j]) System.out.print("[X]");
                else System.out.print("[" + plateaBaja[i][j] + "]" );
            
            }
            System.out.println("");
        }
    }
      static void mostrarPlateaAlta(){
        System.out.println("===ZONA PLATEA ALTA===");
        for(int i = 0; i<2; i++){
            for(int j=0; j<6; j++){
                
                if(ocupadosPlateaAlta[i][j]) System.out.print("[X]");
                else System.out.print("[" + plateaAlta[i][j] + "]" );
            
            }
            System.out.println("");
        }
    }
     static void mostrarGaleria(){
        System.out.println("===ZONA GALERIA==");
        for(int i = 0; i<2; i++){
            for(int j=0; j<6; j++){
                
                if(ocupadosGaleria[i][j]) System.out.print("[X]");
                else System.out.print("[" + galeria[i][j] + "]" );
            
            }
            System.out.println("");
        }
    }
    static void imprimirBoleta(){
        System.out.println("========BOLETA========");
        for(String boleta: boletas) System.out.println(boleta);
        System.out.println("Total clientes: "+ boletas.size());
        System.out.println("Total a pagar: $" + total);
        System.out.println("======================");
    }
    
    static int[] buscarAsientoVip(String codigo){
        
        for(int i = 0; i<2; i++){
            for(int j=0; j<6; j++){
                if (vip[i][j].equalsIgnoreCase(codigo))
                    return new int[] {i, j}; 
            }
        }
        return new int[]{-1, -1};
    }
    static int[] buscarAsientoPalco(String codigo){
        
        for(int i = 0; i<2; i++){
            for(int j=0; j<6; j++){
                if (palco[i][j].equalsIgnoreCase(codigo))
                    return new int[] {i, j}; 
            }
        }
        return new int[]{-1, -1};
    }
    static int[] buscarAsientoPlateaBaja(String codigo){
        
        for(int i = 0; i<2; i++){
            for(int j=0; j<6; j++){
                if (plateaBaja[i][j].equalsIgnoreCase(codigo))
                    return new int[] {i, j}; 
            }
        }
        return new int[]{-1, -1};
    }
    static int[] buscarAsientoPlateaAlta(String codigo){
        
        for(int i = 0; i<2; i++){
            for(int j=0; j<6; j++){
                if (plateaAlta[i][j].equalsIgnoreCase(codigo))
                    return new int[] {i, j}; 
            }
        }
        return new int[]{-1, -1};
    }
    static int[] buscarAsientoGaleria(String codigo){
        
        for(int i = 0; i<2; i++){
            for(int j=0; j<6; j++){
                if (galeria[i][j].equalsIgnoreCase(codigo))
                    return new int[] {i, j}; 
            }
        }
        return new int[]{-1, -1};
    }
    static boolean leerSiNo(String mensaje){
        while(true){
            System.out.println(mensaje);
            String entrada = sc.nextLine().toLowerCase();
            if(entrada.equals("si")) return true;
            if(entrada.equals("no")) return false;
            System.out.println("Respuesta invalida, ingrese si o no");
            
        }
    }
}