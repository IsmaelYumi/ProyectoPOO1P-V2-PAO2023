package com.example;
import com.example.Usuario;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;


public class Main {
    private static ArrayList<Usuario> Usuarios =new ArrayList<>();
    private static ArrayList<Articulo> Articulos=new ArrayList<>();
    public static Usuario usuario_act=null;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean verificar =true;
        ArrayList<Articulo> arti=new ArrayList<>();
        CargarUsuarios();
        int opc;
        while(verificar==true){
        System.out.println("Bienvenido al sistema");
        System.out.println("1...Iniciar sesion");
        System.out.println("2...Subir articulo");
        System.out.println("3...Salir");
        System.out.println("Escoge una opcion:");
        opc= sc.nextInt();
        sc.nextLine();
        switch (opc) {
            case 1:
            Boolean ingreso=false;
            
                    System.out.println("Ingrese su usuario");
                    String usu=sc.nextLine();
                    System.out.println("Ingrese su contrasenia");
                    String contra=sc.nextLine();
                    for(Usuario us: Usuarios){
                        if (us.getUser().equals(usu) && us.getContrasenia().equals(contra)){
                            usuario_act=us;
                            ingreso=true;
                            break;    
                        }
                    }
                    if(ingreso==true){
                        System.out.println("Bienvenido al sistema");
                        if(usuario_act instanceof Editor){
                             String[] info=null;
                            Editor editor= (Editor) usuario_act;
                                String rutaArchivo = "src/main/java/com/archivos/Revision.txt";
                            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                                String linea;
                                while ((linea = br.readLine()) != null) {
                                    info=linea.split(",");
                                    System.out.println("tienes revisiones");
                                    System.out.println(info[0]+"..."+info[1]);   
                                }
                            }catch(IOException a){
                            }
                           
                            System.out.println("Escriba el codigo del articulo que quiera tener detalle: ");
                            String codigo=sc.nextLine();
                             try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                                String linea;
                                while ((linea = br.readLine()) != null) {
                                    info=linea.split(",");
                                    if(codigo.equals(info[2])){
                                        System.out.println("Comentarios: "+info[3]);
                                        break;
                                    
                                    }else{
                                        System.out.println("codigo no valido");
                                    }
                                }
                                
                            }catch(IOException a){
                                a.printStackTrace();
                            }
                            
                             System.out.println("Desea publicar el articulo?, escribe :si o no ");
                             String decision =sc.nextLine();
                             if(decision.equals("si")){
                                 System.out.println("articulo publicado, motificnado a los demas...");
                             }else{
                                 System.out.println("saliendo..");
                             }
                             
                            
                            
                            

                        }
                        if(usuario_act instanceof Revisor){
                            Revisor revisor= (Revisor) usuario_act;
                            String rutaArchivo = "src/main/java/com/archivos/Seguimiento.txt";
                           
                            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                                String linea;
                                while ((linea = br.readLine()) != null) {
                                    String[] info=linea.split(",");
                                    if(info[2].trim().equals(usuario_act.getUser())){
                                        System.out.println("tienes revisiones");
                                        System.out.println(linea);
                                    }

                                }
                            }catch(IOException a){
                            }
                             Articulo art_seleccionado=null;
                          
                            System.out.println("Escriba el codigo del articulo que quiera tener detalle: ");
                            String codigo=sc.nextLine();
                            for(Articulo ac: Articulos){
                             
                                if(ac.getCodigo().equalsIgnoreCase(codigo.trim())){ 
                                    System.out.println(ac);
                                    art_seleccionado=ac;
                                    break;
                                }else{
                                    System.out.println("No hay codigo");
                                }
                            }
                           
                            System.out.println("Deseas emitir comentarios respeco al articulo?: ");
                            String opcion=sc.nextLine();
                            if(opcion.equalsIgnoreCase("si")){
                                System.out.println("Ingrese su comentario");
                                String comentarios= sc.nextLine();
                                System.out.println("Desea enviar a revision?, presione s para confirmar , n para no subir");
                                String opcionSubir=sc.nextLine();
                                if(opcionSubir.equals("s")){
                                    revisor.SubirRevision(art_seleccionado, comentarios);      
                                }else{
                                    System.out.println("Saliendo del sistema");
                                }  
                            }else{
                                System.out.println("Saliendo del sistema");
                            }
                        }

                    }else{
                        System.out.println("Error usuario no encontrado");
                    }
                break;
            case 2:
                System.out.println("Ingrese su nombre: ");
               String nombre=sc.nextLine();
               System.out.println("Ingrese su Apellido: ");
               String apellido= sc.nextLine();
               System.out.println("Ingrese su Institucion: ");
               String Institutcion= sc.nextLine();
               System.out.println("Ingrese su Campo de investigacion");
               String Campo=  sc.nextLine();
               Autor ar=new Autor(nombre,apellido,Institutcion,Campo);
               System.out.println("Ingreso exitoso");
               System.out.println("Ingrese el titulo de su libro");
               String titulo=  sc.nextLine();
               System.out.println("Ingrese el resumen");
               String resumen=  sc.nextLine();
               System.out.println("Ingrese el  contenido");
               String contenido=  sc.nextLine();
               System.out.println("Ingrese ciertas palabras claves");
               String pa= sc.nextLine();
               String [] palabras=pa.split(",");
               Articulo art=new Articulo(titulo, resumen, contenido, ar);
               art.setPalabras_c(palabras);
              System.out.println("subiendo a revision..");
              ar.SubirDoc(art);
              Articulos.add(art);
                break;
            default:
                System.out.println("saliendo");
                verificar=false;
                break;
        }
    }

       
    }

    public static void CargarUsuarios(){
        String rutaArchivo = "src/main/java/com/archivos/Usuarios.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos=linea.split(",");
                if(datos[2].charAt(0)=='R'){
                    Usuario usu= new Revisor(datos[0].trim(), datos[1].trim(),datos[2].charAt(0), datos[3], datos[4], datos[5],Integer.parseInt(datos[6]));
                    Usuarios.add(usu);
                }
                if(datos[2].charAt(0)=='E'){
                    Usuario usu= new Editor(datos[0].trim(), datos[1].trim(),datos[2].charAt(0), datos[3], datos[4], datos[5]);
                    Usuarios.add(usu);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void Cargar_Articulos(){
        
        
        
    }



    
}