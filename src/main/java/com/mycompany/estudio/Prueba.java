
package com.mycompany.estudio;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Prueba {

static int vidas=3,puntos=0,premios,paredes,trampas,filas,columnas,cont_nombres=0,cont_punteos=0;
static String nombre,tablero,tablerog[][],movimiento,tablerop[][];
static boolean ganar;
static    int[] punteos=new int[20];
static    String[] nombres=new String[20];

static void imprimirtableropequeño(){
        Scanner a=new Scanner(System.in);
        do {
        System.out.println("PREMIOS [1-12]:");
        premios=a.nextInt();    
        } while (premios<=0 || premios>12);
        
        do{
        System.out.println("PAREDES [1-6]:");
        paredes=a.nextInt();    
        }while(paredes<=0 || paredes>6);
        do {
        System.out.println("TRAMPAS [1-6]:");
        trampas=a.nextInt();
        } while (paredes<=0 || paredes>6);

        tablerop= new String [5][6];
        
        int cont_premios;
        
        cont_premios=0;    
        
        for (int i = 1; i <= premios; i++) {    

        Random ran = new Random();
        int fila,columna;
        do{
        fila = ran.nextInt(5);
        columna = ran.nextInt(6);    
        }while(tablerop[fila][columna]=="$" || tablerop[fila][columna]=="0");
        
        int aleatorio=ran.nextInt(2);
            if (aleatorio==1) {
            tablerop[fila][columna]="$";  
            }else{
             tablerop[fila][columna]="0";     
            }
 
        
        }
        
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (tablerop[i][j]=="$" || tablerop[i][j]=="0") {
                    cont_premios++;
                }
            }
        }    
        System.out.println(cont_premios);
        
        
       int cont_paredes=0;
       for (int i = 1; i <= paredes; i++) {   

        Random ran = new Random();
        int fila,columna;
        do{
        fila = ran.nextInt(5);
        columna = ran.nextInt(6);    
        }while(tablerop[fila][columna]=="$" || tablerop[fila][columna]=="0" || tablerop[fila][columna]=="X");
        
        tablerop[fila][columna]="X";
            
        }
       
       
               for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (tablerop[i][j]=="X") {
                    cont_paredes++;
                }
            }
        }    
        System.out.println(cont_paredes);
       
        for (int i = 1; i <= trampas; i++) {

        Random ran = new Random();
        int fila,columna;
        do{
        fila = ran.nextInt(5) ;
        columna = ran.nextInt(6);    
        }while(tablerop[fila][columna]=="$" || tablerop[fila][columna]=="0" || tablerop[fila][columna]=="X" ||tablerop[fila][columna]=="@");
        
        tablerop[fila][columna]="@";
        }
    
        int cont_fantas=0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (tablerop[i][j]=="@") {
                    cont_fantas++;
                }
            }
        }    
        System.out.println(cont_fantas);      
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (tablerop[i][j]==null) {
                    tablerop[i][j]=" ";
                }
            }
        }
    
vidas=3;
puntos=0;
    
    
        System.out.println("USUARIO: "+nombre);
        System.out.println("PUNTEO: "+puntos);
        System.out.println("VIDAS: "+vidas);
    System.out.println("-------------");
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 6; j++) {
            if (j==0) {
                System.out.print("|"+tablerop[i][j]+" ");
            }else if(j==5){
             System.out.print(tablerop[i][j]+"|");   
            }else{
             System.out.print(tablerop[i][j]+" ");
            }
            
        }
        System.out.println("");
    }    System.out.println("-------------");
    do{
        do {
        System.out.println("elija su fila inicial [1-5]:");
        filas=a.nextInt();
        } while (filas<1 || columnas>5);
        do {
        System.out.println("elija su columna inicial [1-6]");    
        columnas=a.nextInt();
        } while (columnas<1 || columnas>6);
        
        if (tablerop[filas-1][columnas-1]=="$" || tablerop[filas-1][columnas-1]=="0" || tablerop[filas-1][columnas-1]=="X" ||tablerop[filas-1][columnas-1]=="@") {
            System.out.println("Elija un espacio que este vacio por favor");    
        }
        
    }while(tablerop[filas-1][columnas-1]=="$" || tablerop[filas-1][columnas-1]=="0" || tablerop[filas-1][columnas-1]=="X" ||tablerop[filas-1][columnas-1]=="@");    
    
    filas-=1;
    columnas-=1;
    tablerop[filas][columnas]="<";   
    
   
    
        System.out.println("USUARIO: "+nombre);
        System.out.println("PUNTEO: "+puntos);
        System.out.println("VIDAS: "+vidas);
    System.out.println("-------------");
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 6; j++) {
            if (j==0) {
                System.out.print("|"+tablerop[i][j]+" ");
            }else if(j==5){
             System.out.print(tablerop[i][j]+"|");   
            }else{
             System.out.print(tablerop[i][j]+" ");
            }
            
        }
        System.out.println("");
    }    System.out.println("-------------");
    
     ganar=false;

}






















static void historial(){
    System.out.println("=======HISTORIAL DE PARTIDAS=======");
    System.out.println("No.\t\tUsuario\t\tPunteo");
    System.out.println("");
    for (int i = 0; i < cont_nombres; i++) {
        System.out.println((i+1)+".\t\t"+nombres[i]+"\t\t"+punteos[i]);
    }
    
    System.out.println("");
}

static void impg(){

        System.out.println("USUARIO: "+nombre);
        System.out.println("PUNTEO: "+puntos);
        System.out.println("VIDAS: "+vidas);
    System.out.println("---------------------");
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (j==0) {
                System.out.print("|"+tablerog[i][j]+" ");
            }else if(j==9){
             System.out.print(tablerog[i][j]+"|");   
            }else{
             System.out.print(tablerog[i][j]+" ");
            }
            
        }
        System.out.println("");
    }    System.out.println("---------------------");
}


static void validartg(){
    int contador=0;
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if(tablerog[i][j] == "$" || tablerog[i][j] == "0"){
                contador++;   
            }
        }
    }
    
    
    
    if (contador==0) {
        System.out.println("!!!GANASTE FELICIDADES!!!");
        ganar=true;
        nombres[cont_nombres]=nombre;
        cont_nombres++;
        punteos[cont_punteos]=puntos;
        cont_punteos++;
    }
    if (vidas==0) {
        System.out.println("!!!PERDISTE LA PARTIDA!!!");
        ganar=true;
        nombres[cont_nombres]=nombre;
        cont_nombres++;
        punteos[cont_punteos]=puntos;cont_punteos++;
        
    }
    
}
    static void imprimirtablerogrande(){
        Scanner a=new Scanner(System.in);
        do {
        System.out.println("PREMIOS [1-40]:");
        premios=a.nextInt();    
        } while (premios<=0 || premios>40);
        
        do{
        System.out.println("PAREDES [1-20]:");
        paredes=a.nextInt();    
        }while(paredes<=0 || paredes>20);
        do {
        System.out.println("TRAMPAS [1-20]:");
        trampas=a.nextInt();
        } while (paredes<=0 || paredes>20);

        tablerog= new String [10][10];
        
        int cont_premios;
        
        cont_premios=0;    
        
        for (int i = 1; i <= premios; i++) {    
        int min_val = 0;
        int max_val = 10;
        Random ran = new Random();
        int fila,columna;
        do{
        fila = ran.nextInt(max_val) + min_val;
        columna = ran.nextInt(max_val) + min_val;    
        }while(tablerog[fila][columna]=="$" || tablerog[fila][columna]=="0");
        
        int aleatorio=ran.nextInt(2);
            if (aleatorio==1) {
            tablerog[fila][columna]="$";  
            }else{
             tablerog[fila][columna]="0";     
            }
 
        
        }
        
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablerog[i][j]=="$" || tablerog[i][j]=="0") {
                    cont_premios++;
                }
            }
        }    
        System.out.println(cont_premios);
        
        
       int cont_paredes=0;
       for (int i = 1; i <= paredes; i++) {   
        int min_val = 0;
        int max_val = 10;
        Random ran = new Random();
        int fila,columna;
        do{
        fila = ran.nextInt(max_val) + min_val;
        columna = ran.nextInt(max_val) + min_val;    
        }while(tablerog[fila][columna]=="$" || tablerog[fila][columna]=="0" || tablerog[fila][columna]=="X");
        
        tablerog[fila][columna]="X";
            
        }
       
       
               for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablerog[i][j]=="X") {
                    cont_paredes++;
                }
            }
        }    
        System.out.println(cont_paredes);
       
        for (int i = 1; i <= trampas; i++) {
        int min_val = 0;
        int max_val = 10;
        Random ran = new Random();
        int fila,columna;
        do{
        fila = ran.nextInt(max_val) + min_val;
        columna = ran.nextInt(max_val) + min_val;    
        }while(tablerog[fila][columna]=="$" || tablerog[fila][columna]=="0" || tablerog[fila][columna]=="X" ||tablerog[fila][columna]=="@");
        
        tablerog[fila][columna]="@";
        }
    
        int cont_fantas=0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablerog[i][j]=="@") {
                    cont_fantas++;
                }
            }
        }    
        System.out.println(cont_fantas);      
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablerog[i][j]==null) {
                    tablerog[i][j]=" ";
                }
            }
        }
    
vidas=3;
puntos=0;
    
    
        System.out.println("USUARIO: "+nombre);
        System.out.println("PUNTEO: "+puntos);
        System.out.println("VIDAS: "+vidas);
    System.out.println("---------------------");
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (j==0) {
                System.out.print("|"+tablerog[i][j]+" ");
            }else if(j==9){
             System.out.print(tablerog[i][j]+"|");   
            }else{
             System.out.print(tablerog[i][j]+" ");
            }
            
        }
        System.out.println("");
    }    System.out.println("---------------------");
    do{
        do {
        System.out.println("elija su fila inicial [1-10]:");
        filas=a.nextInt();
        } while (filas<1 || columnas>10);
        do {
        System.out.println("elija su columna inicial [1-10]");    
        columnas=a.nextInt();
        } while (columnas<1 || columnas>10);
        
        if (tablerog[filas-1][columnas-1]=="$" || tablerog[filas-1][columnas-1]=="0" || tablerog[filas-1][columnas-1]=="X" ||tablerog[filas-1][columnas-1]=="@") {
            System.out.println("Elija un espacio que este vacio por favor");    
        }
        
    }while(tablerog[filas-1][columnas-1]=="$" || tablerog[filas-1][columnas-1]=="0" || tablerog[filas-1][columnas-1]=="X" ||tablerog[filas-1][columnas-1]=="@");    
    
    filas-=1;
    columnas-=1;
    tablerog[filas][columnas]="<";   
    
   
    
        System.out.println("USUARIO: "+nombre);
        System.out.println("PUNTEO: "+puntos);
        System.out.println("VIDAS: "+vidas);
    System.out.println("---------------------");
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (j==0) {
                System.out.print("|"+tablerog[i][j]+" ");
            }else if(j==9){
             System.out.print(tablerog[i][j]+"|");   
            }else{
             System.out.print(tablerog[i][j]+" ");
            }
            
        }
        System.out.println("");
    }    System.out.println("---------------------");
    
     ganar=false;
     
     while(ganar!=true){
      jugandotablerog();   
     }
     
     
    }
    
    static void jugandotablerog(){
    Scanner a=new Scanner(System.in);
    movimiento=a.nextLine();
    movimiento=movimiento.toLowerCase();
        if (movimiento.equals("w")) {
        
            if (tablerog[filas-1][columnas]==" ") {
            tablerog[filas][columnas]=" ";
            filas-=1;
            tablerog[filas][columnas]="^";
            impg();
            validartg();  
            }else if(tablerog[filas-1][columnas]=="$"){
            tablerog[filas][columnas]=" ";
            filas-=1;
            tablerog[filas][columnas]="^";
            puntos+=15;
            impg();
            validartg();   
            }else if(tablerog[filas-1][columnas]=="0"){
            tablerog[filas][columnas]=" ";
            filas-=1;
            tablerog[filas][columnas]="^";
            puntos+=10;
            impg();
            validartg();    
            }else if(tablerog[filas-1][columnas]=="@"){
            tablerog[filas][columnas]=" ";
            filas-=1;
            tablerog[filas][columnas]="^";
            vidas-=1;
            impg();
            validartg();    
        }else if(tablerog[filas-1][columnas]=="X"){
            tablerog[filas][columnas]="^";
            System.out.println("hay pared no se puede cruzar");
            impg();
            validartg();    
        }
            

        }else if(movimiento.equals("s")){
if (tablerog[filas+1][columnas]==" ") {
            tablerog[filas][columnas]=" ";
            filas+=1;
            tablerog[filas][columnas]="v";
            impg();
            validartg();  
            }else if(tablerog[filas+1][columnas]=="$"){
            tablerog[filas][columnas]=" ";
            filas+=1;
            tablerog[filas][columnas]="v";
            puntos+=15;
            impg();
            validartg();   
            }else if(tablerog[filas+1][columnas]=="0"){
            tablerog[filas][columnas]=" ";
            filas+=1;
            tablerog[filas][columnas]="v";
            puntos+=10;
            impg();
            validartg();    
            }else if(tablerog[filas+1][columnas]=="@"){
            tablerog[filas][columnas]=" ";
            filas+=1;
            tablerog[filas][columnas]="v";
            vidas-=1;
            impg();
            validartg();    
        }else if(tablerog[filas+1][columnas]=="X"){
            tablerog[filas][columnas]="v";
            System.out.println("hay pared no se puede cruzar");
            impg();
            validartg();    
        }
        }else if(movimiento.equals("a")){
   if (tablerog[filas][columnas-1]==" ") {
            tablerog[filas][columnas]=" ";
            columnas-=1;
            tablerog[filas][columnas]="<";
            impg();
            validartg();  
            }else if(tablerog[filas][columnas-1]=="$"){
            tablerog[filas][columnas]=" ";
            columnas-=1;
            tablerog[filas][columnas]="<";
            puntos+=15;
            impg();
            validartg();   
            }else if(tablerog[filas][columnas-1]=="0"){
            tablerog[filas][columnas]=" ";
            columnas-=1;
            tablerog[filas][columnas]="<";
            puntos+=10;
            impg();
            validartg();    
            }else if(tablerog[filas][columnas-1]=="@"){
            tablerog[filas][columnas]=" ";
            columnas-=1;
            tablerog[filas][columnas]="<";
            vidas-=1;
            impg();
            validartg();    
        }else if(tablerog[filas][columnas-1]=="X"){
            tablerog[filas][columnas]="<";
            System.out.println("hay pared no se puede cruzar");
            impg();
            validartg();    
        }       

        }else if(movimiento.equals("d")){

   if (tablerog[filas][columnas+1]==" ") {
            tablerog[filas][columnas]=" ";
            columnas+=1;
            tablerog[filas][columnas]=">";
            impg();
            validartg();  
            }else if(tablerog[filas][columnas+1]=="$"){
            tablerog[filas][columnas]=" ";
            columnas+=1;
            tablerog[filas][columnas]=">";
            puntos+=15;
            impg();
            validartg();   
            }else if(tablerog[filas][columnas+1]=="0"){
            tablerog[filas][columnas]=" ";
            columnas+=1;
            tablerog[filas][columnas]=">";
            puntos+=10;
            impg();
            validartg();    
            }else if(tablerog[filas][columnas+1]=="@"){
            tablerog[filas][columnas]=" ";
            columnas+=1;
            tablerog[filas][columnas]=">";
            vidas-=1;
            impg();
            validartg();    
        }else if(tablerog[filas][columnas+1]=="X"){
            tablerog[filas][columnas]=">";
            System.out.println("hay pared no se puede cruzar");
            impg();
            validartg();    
        }    
        }else{
            System.out.println("ingrese un movimiento valido");
        }
    
    
    }
    
    static void juego(){
        Scanner a=new Scanner(System.in);
        System.out.println("Nombre: ");
        nombre=a.nextLine();
        
        System.out.println("========Especificar Tablero========");
        System.out.println("POR FAVOR, INGRESE LOS SIGUIENTES VALORES");
        do{
        System.out.println("TABLERO: ");
        tablero=a.nextLine();
        tablero=tablero.toLowerCase();
   
        }while(!(tablero.equals("p") || tablero.equals("g")));
        
        if (tablero.equals("g")) {
            imprimirtablerogrande();
        }else{
            imprimirtableropequeño();
        }
       

        
    }
    
public static void main(String[] args){
int vidas=3,puntos=0;
String nombre;
int opcion; 
Scanner a=new Scanner(System.in);
    do {
    System.out.println("====MENU DE INICIO===");
    System.out.println("1. Iniciar Juego");
    System.out.println("2. Historial de partidas");
    System.out.println("3. Salir del juego");
    

 
    opcion=a.nextInt();
    
    
        switch(opcion){
        case 1:
            juego();
            break;
        case 2:
            historial();
            break;
        case 3:
            System.out.println("!!!JUEGO TERMINADO!!!");
            break;
        default:
           System.out.println("ingrese una opcion entre el rango de 1-3");
            break;
    }
    
    } while (opcion!=3);
    

    
    
    

    
}

    
}
