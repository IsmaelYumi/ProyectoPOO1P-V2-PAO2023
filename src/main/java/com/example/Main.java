package com.example;
import com.example.Usuario;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    private static ArrayList<Usuario> Usuarios =new ArrayList<>();
    private static ArrayList<Articulo> Articulos=new AarrayList<>();
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
        System.out.println("Escoge una opcion:");
        opc= sc.nextInt();
        switch (opc) {
            case 1:
            Boolean ingreso=false;
            Usuario usuario_act=null;
                    System.out.println("Ingrese su usuario");
                    String usu=sc.next();
                    System.out.println("Ingrese su contrasenia");
                    String contra=sc.next();
                    for(Usuario us: Usuarios){
                        if (us.getUser()==usu && us.getContrasenia()==contra){
                            usuario_act=us;
                            ingreso=true;
                            break;    
                        }
                    }
                    if(ingreso==true){
                        System.out.println("Bienvenido al sistema");
                        if(usuario_act instanceof Editor){



                        }
                        if(usuario_act instanceof Revisor){
                            String rutaArchivo = "src/main/java/com/archivos/Usuarios.txt";
                            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                                String linea;
                                while ((linea = br.readLine()) != null) {
                                    String[] info=linea.split(",");
                                    if(info[2]==usuario_act.getUser()){
                                        System.out.println("tienes revisiones");
                                        System.out.println(linea);
                                    }

                                }
                            }catch(IOException a){
                            }
                            System.out.println("Escriba el codigo del articulo que quiera tener detalle: ");
                            String codigo=sc.next();
                            for(Articulo ac: Articulos){
                                if(ac.getCodigo()==codigo){
                                    System.out.println(ac);
                                }
                                
                            }
                            System.out.println("Deseas emitir comentarios respeco al articulo?: ");
                            String opcion=sc.next();
                            if(opcion.equalsIgnoreCase("si"));
                            



                        }

                    }else{
                        System.out.println("Error usuario no encontrado");
                    }
                

                break;
            case 2:
                System.out.println("Ingrese su nombre: ");
               String nombre=sc.next();
               System.out.println("Ingrese su Apellido: ");
               String apellido= sc.next();
               System.out.println("Ingrese su Institucion: ");
               String Institutcion= sc.next();
               System.out.println("Ingrese su Campo de investigacion");
               String Campo= sc.next();
               Autor ar=new Autor(nombre,apellido,Institutcion,Campo);
               System.out.println("Ingreso exitoso");
               System.out.println("Ingrese el titulo de su libro");
               String titulo= sc.next();
               System.out.println("Ingrese el resumen");
               String resumen= sc.next();
               System.out.println("Ingrese el  contenido");
               String contenido= sc.next();
               System.out.println("Ingrese ciertas palabras claves");
               String pa=sc.next();
               String [] palabras=pa.split(",");
               Articulo art=new Articulo(titulo, resumen, contenido, ar);
               art.setPalabras_c(palabras);
              System.out.println("subiendo a revision..");
              ar.SubirDoc(art);
              Articulos.add(ar);
                break;
            default:
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
                    Usuario usu= new Revisor(datos[0], datos[1],datos[2].charAt(0), datos[3], datos[4], datos[5],Integer.parseInt(datos[6]));
                    Usuarios.add(usu);
                }
                if(datos[2].charAt(0)=='E'){
                    Usuario usu= new Editor(datos[0], datos[1],datos[2].charAt(0), datos[3], datos[4], datos[5]);
                    Usuarios.add(usu);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    
}